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
package org.broadleafcommerce.core.checkout.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class CheckoutServiceImplDiffblueTest {
  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(new OrderStatus("SUBMITTED", "SUBMITTED"));

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.</li>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getStatus()} return
   * {@link OrderStatus#ARCHIVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_givenArchived_whenNullOrderImplGetStatusReturnArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(OrderStatus.ARCHIVED);

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order, atLeast(1)).getStatus();
    assertFalse(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();

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
    assertFalse(checkoutServiceImpl.hasOrderBeenCompleted(order));
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#CANCELLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_givenCancelled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(OrderStatus.CANCELLED);

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order, atLeast(1)).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#SUBMITTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_givenSubmitted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(OrderStatus.SUBMITTED);

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_whenNullOrderImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();

    // Act and Assert
    assertFalse(checkoutServiceImpl.hasOrderBeenCompleted(new NullOrderImpl()));
  }
}
