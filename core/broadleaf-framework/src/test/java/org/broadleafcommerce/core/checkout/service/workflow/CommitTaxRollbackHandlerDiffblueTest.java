/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.TaxService;
import org.broadleafcommerce.core.pricing.service.exception.TaxException;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommitTaxRollbackHandlerDiffblueTest {
  @InjectMocks
  private CommitTaxRollbackHandler commitTaxRollbackHandler;

  @Mock
  private TaxService taxService;

  /**
   * Test {@link CommitTaxRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   * <ul>
   *   <li>Given {@link TaxService} {@link TaxService#cancelTax(Order)} does nothing.</li>
   *   <li>Then calls {@link TaxService#cancelTax(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommitTaxRollbackHandler#rollbackState(Activity, ProcessContext, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CommitTaxRollbackHandler.rollbackState(Activity, ProcessContext, Map)"})
  public void testRollbackState_givenTaxServiceCancelTaxDoesNothing_thenCallsCancelTax()
      throws TaxException, RollbackFailureException {
    // Arrange
    doNothing().when(taxService).cancelTax(Mockito.<Order>any());
    CommitTaxActivity activity = new CommitTaxActivity(commitTaxRollbackHandler);

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    processContext.setSeedData(new CheckoutSeed(order, new HashMap<>()));

    // Act
    commitTaxRollbackHandler.rollbackState(activity, processContext, new HashMap<>());

    // Assert
    verify(taxService).cancelTax(isA(Order.class));
  }

  /**
   * Test {@link CommitTaxRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   * <ul>
   *   <li>Then throw {@link RollbackFailureException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommitTaxRollbackHandler#rollbackState(Activity, ProcessContext, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CommitTaxRollbackHandler.rollbackState(Activity, ProcessContext, Map)"})
  public void testRollbackState_thenThrowRollbackFailureException() throws TaxException, RollbackFailureException {
    // Arrange
    doThrow(new TaxException("An error occurred")).when(taxService).cancelTax(Mockito.<Order>any());
    CommitTaxActivity activity = new CommitTaxActivity(commitTaxRollbackHandler);

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    processContext.setSeedData(new CheckoutSeed(order, new HashMap<>()));

    // Act and Assert
    assertThrows(RollbackFailureException.class,
        () -> commitTaxRollbackHandler.rollbackState(activity, processContext, new HashMap<>()));
    verify(taxService).cancelTax(isA(Order.class));
  }
}
