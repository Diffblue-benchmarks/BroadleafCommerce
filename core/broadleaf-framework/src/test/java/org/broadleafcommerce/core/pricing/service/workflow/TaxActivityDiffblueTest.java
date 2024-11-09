/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.TaxService;
import org.broadleafcommerce.core.pricing.service.module.TaxModule;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.mockito.Mockito;

public class TaxActivityDiffblueTest {
  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link TaxModule#calculateTaxForOrder(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenCallsCalculateTaxForOrder() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxModule taxModule = mock(TaxModule.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(taxModule.calculateTaxForOrder(Mockito.<Order>any())).thenReturn(nullOrderImpl);

    TaxActivity taxActivity = new TaxActivity();
    taxActivity.setTaxService(null);
    taxActivity.setTaxModule(taxModule);

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(new NullOrderImpl());

    // Act
    ProcessContext<Order> actualExecuteResult = taxActivity.execute((ProcessContext<Order>) context);

    // Assert
    verify(taxModule).calculateTaxForOrder(isA(Order.class));
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(nullOrderImpl, actualExecuteResult.getSeedData());
  }

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link TaxService#calculateTaxForOrder(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenCallsCalculateTaxForOrder2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxService taxService = mock(TaxService.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(taxService.calculateTaxForOrder(Mockito.<Order>any())).thenReturn(nullOrderImpl);

    TaxActivity taxActivity = new TaxActivity();
    taxActivity.setTaxService(taxService);
    taxActivity.setTaxModule(mock(TaxModule.class));

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(new NullOrderImpl());

    // Act
    ProcessContext<Order> actualExecuteResult = taxActivity.execute((ProcessContext<Order>) context);

    // Assert
    verify(taxService).calculateTaxForOrder(isA(Order.class));
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(nullOrderImpl, actualExecuteResult.getSeedData());
  }

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).</li>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_whenDefaultProcessContextImpl_thenReturnDefaultProcessContextImpl() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxActivity taxActivity = new TaxActivity();
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, taxActivity.execute((ProcessContext<Order>) context));
  }
}
