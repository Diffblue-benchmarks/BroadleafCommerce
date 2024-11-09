/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.call.UpdateCartResponse;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UpdateCartServiceImplDiffblueTest {
  /**
   * Test {@link UpdateCartServiceImpl#currencyHasChanged()}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#currencyHasChanged()}
   */
  @Test
  @DisplayName("Test currencyHasChanged()")
  void testCurrencyHasChanged() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new UpdateCartServiceImpl()).currencyHasChanged());
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order); given Auditable (default constructor) CreatedBy is one")
  void testCopyCartToCurrentContext_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl currentCart = new OrderImpl();
    currentCart.setAdditionalOfferInformation(new HashMap<>());
    currentCart.setAuditable(auditable);
    currentCart.setCandidateOrderOffers(new ArrayList<>());
    currentCart.setCurrency(new BroadleafCurrencyImpl());
    currentCart.setCustomer(new CustomerImpl());
    currentCart.setEmailAddress("42 Main St");
    currentCart.setFulfillmentGroups(new ArrayList<>());
    currentCart.setId(1L);
    currentCart.setLocale(new LocaleImpl());
    currentCart.setName("Name");
    currentCart.setOrderAttributes(new HashMap<>());
    currentCart.setOrderItems(new ArrayList<>());
    currentCart.setOrderMessages(new ArrayList<>());
    currentCart.setOrderNumber("42");
    currentCart.setPayments(new ArrayList<>());
    currentCart.setStatus(new OrderStatus("Type", "Friendly Type"));
    currentCart.setSubTotal(new Money());
    currentCart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    currentCart.setTaxOverride(true);
    currentCart.setTotal(new Money());
    currentCart.setTotalFulfillmentCharges(new Money());
    currentCart.setTotalShipping(new Money());
    currentCart.setTotalTax(new Money());

    // Act and Assert
    assertNull(updateCartServiceImpl.copyCartToCurrentContext(currentCart));
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order); then calls getOrderItems()")
  void testCopyCartToCurrentContext_thenCallsGetOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    NullOrderImpl currentCart = mock(NullOrderImpl.class);
    when(currentCart.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    UpdateCartResponse actualCopyCartToCurrentContextResult = updateCartServiceImpl
        .copyCartToCurrentContext(currentCart);

    // Assert
    verify(currentCart).getOrderItems();
    assertNull(actualCopyCartToCurrentContextResult);
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order); when NullOrderImpl (default constructor); then return 'null'")
  void testCopyCartToCurrentContext_whenNullOrderImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    // Act and Assert
    assertNull(updateCartServiceImpl.copyCartToCurrentContext(new NullOrderImpl()));
  }

  /**
   * Test {@link UpdateCartServiceImpl#lockOrder(Order, Object)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code Lock Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#lockOrder(Order, Object)}
   */
  @Test
  @DisplayName("Test lockOrder(Order, Object); when NullOrderImpl (default constructor); then return 'Lock Object'")
  void testLockOrder_whenNullOrderImpl_thenReturnLockObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    // Act and Assert
    assertEquals("Lock Object", updateCartServiceImpl.lockOrder(new NullOrderImpl(), "Lock Object"));
  }

  /**
   * Test {@link UpdateCartServiceImpl#lockOrder(Order, Object)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@code Lock Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#lockOrder(Order, Object)}
   */
  @Test
  @DisplayName("Test lockOrder(Order, Object); when NullOrderImpl; then return 'Lock Object'")
  void testLockOrder_whenNullOrderImpl_thenReturnLockObject2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Lock Object", (new UpdateCartServiceImpl()).lockOrder(mock(NullOrderImpl.class), "Lock Object"));
  }

  /**
   * Test {@link UpdateCartServiceImpl#findActiveCurrency()}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#findActiveCurrency()}
   */
  @Test
  @DisplayName("Test findActiveCurrency()")
  void testFindActiveCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new UpdateCartServiceImpl()).findActiveCurrency());
  }

  /**
   * Test
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link DiscreteOrderItem#getSku()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}
   */
  @Test
  @DisplayName("Test checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency); given SkuImpl (default constructor); then calls getSku()")
  void testCheckAvailabilityInLocale_givenSkuImpl_thenCallsGetSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    DiscreteOrderItem doi = mock(DiscreteOrderItem.class);
    when(doi.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualCheckAvailabilityInLocaleResult = updateCartServiceImpl.checkAvailabilityInLocale(doi,
        new BroadleafCurrencyImpl());

    // Assert
    verify(doi).getSku();
    assertFalse(actualCheckAvailabilityInLocaleResult);
  }

  /**
   * Test
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}
   */
  @Test
  @DisplayName("Test checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency); when DiscreteOrderItemImpl (default constructor); then return 'false'")
  void testCheckAvailabilityInLocale_whenDiscreteOrderItemImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    DiscreteOrderItemImpl doi = new DiscreteOrderItemImpl();

    // Act and Assert
    assertFalse(updateCartServiceImpl.checkAvailabilityInLocale(doi, new BroadleafCurrencyImpl()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateCartServiceImpl#setSavedCurrency(BroadleafCurrency)}
   *   <li>{@link UpdateCartServiceImpl#getSavedCurrency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    BroadleafCurrencyImpl savedCurrency = new BroadleafCurrencyImpl();

    // Act
    updateCartServiceImpl.setSavedCurrency(savedCurrency);

    // Assert that nothing has changed
    assertSame(savedCurrency, updateCartServiceImpl.getSavedCurrency());
  }
}
