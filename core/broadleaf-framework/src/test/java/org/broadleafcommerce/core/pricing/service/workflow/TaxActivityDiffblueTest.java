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
package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.TaxService;
import org.broadleafcommerce.core.pricing.service.module.TaxModule;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TaxActivityDiffblueTest {
  @InjectMocks
  private TaxActivity taxActivity;

  @Mock
  private TaxService taxService;

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link TaxActivity} TaxModule is {@code null}.</li>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext TaxActivity.execute(ProcessContext)"})
  public void testExecute_givenTaxActivityTaxModuleIsNull_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    taxActivity.setTaxService(null);
    taxActivity.setTaxModule(null);

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(new NullOrderImpl());

    // Act and Assert
    assertSame(context, taxActivity.execute(context));
  }

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link TaxModule#calculateTaxForOrder(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext TaxActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsCalculateTaxForOrder() throws Exception {
    // Arrange
    TaxModule taxModule = mock(TaxModule.class);
    when(taxModule.calculateTaxForOrder(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    taxActivity.setTaxService(null);
    taxActivity.setTaxModule(taxModule);

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(new NullOrderImpl());

    // Act
    ProcessContext<Order> actualExecuteResult = taxActivity.execute(context);

    // Assert
    verify(taxModule).calculateTaxForOrder(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).</li>
   *   <li>Then calls {@link TaxService#calculateTaxForOrder(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext TaxActivity.execute(ProcessContext)"})
  public void testExecute_whenDefaultProcessContextImpl_thenCallsCalculateTaxForOrder() throws Exception {
    // Arrange
    when(taxService.calculateTaxForOrder(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<Order> actualExecuteResult = taxActivity.execute(context);

    // Assert
    verify(taxService).calculateTaxForOrder(isNull());
    assertSame(context, actualExecuteResult);
  }
}
