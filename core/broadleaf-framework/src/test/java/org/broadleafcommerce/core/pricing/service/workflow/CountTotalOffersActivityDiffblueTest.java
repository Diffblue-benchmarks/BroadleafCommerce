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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class CountTotalOffersActivityDiffblueTest {
  /**
   * Test {@link CountTotalOffersActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountTotalOffersActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenAuditableCreatedByIsOne() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountTotalOffersActivity countTotalOffersActivity = new CountTotalOffersActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = countTotalOffersActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link CountTotalOffersActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   *   <li>When {@link ProcessContext} {@link ProcessContext#getSeedData()} return
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CountTotalOffersActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenNullOrderImpl_whenProcessContextGetSeedDataReturnNullOrderImpl() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountTotalOffersActivity countTotalOffersActivity = new CountTotalOffersActivity();
    ProcessContext<Order> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new NullOrderImpl());

    // Act
    ProcessContext<Order> actualExecuteResult = countTotalOffersActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link CountTotalOffersActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).</li>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CountTotalOffersActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_whenDefaultProcessContextImpl_thenReturnDefaultProcessContextImpl() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountTotalOffersActivity countTotalOffersActivity = new CountTotalOffersActivity();
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, countTotalOffersActivity.execute((ProcessContext<Order>) context));
  }
}
