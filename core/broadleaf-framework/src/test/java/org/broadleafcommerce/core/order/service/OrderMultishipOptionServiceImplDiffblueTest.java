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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderMultishipOption;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class OrderMultishipOptionServiceImplDiffblueTest {
  /**
   * Test
   * {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}
   */
  @Test
  public void testGetOrderMultishipOptionsFromDTOs_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderMultishipOptionServiceImpl orderMultishipOptionServiceImpl = new OrderMultishipOptionServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertTrue(orderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(order, new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}
   */
  @Test
  public void testGetOrderMultishipOptionsFromDTOs_whenNullOrderImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderMultishipOptionServiceImpl orderMultishipOptionServiceImpl = new OrderMultishipOptionServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertTrue(orderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(order, new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link NullOrderImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}
   */
  @Test
  public void testGenerateOrderMultishipOptions_givenArrayList_thenCallsGetDiscreteOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderMultishipOptionServiceImpl orderMultishipOptionServiceImpl = new OrderMultishipOptionServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getDiscreteOrderItems()).thenReturn(new ArrayList<>());

    // Act
    List<OrderMultishipOption> actualGenerateOrderMultishipOptionsResult = orderMultishipOptionServiceImpl
        .generateOrderMultishipOptions(order);

    // Assert
    verify(order).getDiscreteOrderItems();
    assertTrue(actualGenerateOrderMultishipOptionsResult.isEmpty());
  }

  /**
   * Test
   * {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}
   */
  @Test
  public void testGenerateOrderMultishipOptions_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderMultishipOptionServiceImpl orderMultishipOptionServiceImpl = new OrderMultishipOptionServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(orderMultishipOptionServiceImpl.generateOrderMultishipOptions(order).isEmpty());
  }
}
