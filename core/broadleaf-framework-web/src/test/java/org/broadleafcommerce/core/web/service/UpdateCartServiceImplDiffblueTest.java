/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.UpdateCartResponse;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.web.order.security.exception.OrderLockAcquisitionFailureException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateCartServiceImplDiffblueTest {
  @InjectMocks
  private UpdateCartServiceImpl updateCartServiceImpl;

  @Mock
  private UpdateCartServiceExtensionManager updateCartServiceExtensionManager;

  /**
   * Test {@link UpdateCartServiceImpl#currencyHasChanged()}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#currencyHasChanged()}
   */
  @Test
  @DisplayName("Test currencyHasChanged()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateCartServiceImpl.currencyHasChanged()"})
  void testCurrencyHasChanged() {
    // Arrange, Act and Assert
    assertTrue(updateCartServiceImpl.currencyHasChanged());
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order); given Auditable (default constructor) CreatedBy is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateCartResponse UpdateCartServiceImpl.copyCartToCurrentContext(Order)"})
  void testCopyCartToCurrentContext_givenAuditableCreatedByIsOne() {
    // Arrange
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
   * Method under test: {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order); then calls getOrderItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateCartResponse UpdateCartServiceImpl.copyCartToCurrentContext(Order)"})
  void testCopyCartToCurrentContext_thenCallsGetOrderItems() {
    // Arrange
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
   * Method under test: {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order); when NullOrderImpl (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateCartResponse UpdateCartServiceImpl.copyCartToCurrentContext(Order)"})
  void testCopyCartToCurrentContext_whenNullOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(updateCartServiceImpl.copyCartToCurrentContext(new NullOrderImpl()));
  }

  /**
   * Test {@link UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}
   */
  @Test
  @DisplayName("Test validateAddToCartRequest(OrderItemRequestDTO, Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UpdateCartServiceImpl.validateAddToCartRequest(OrderItemRequestDTO, Order)"})
  void testValidateAddToCartRequest() {
    // Arrange
    when(updateCartServiceExtensionManager.getProxy()).thenReturn(new i18nUpdateCartServiceExtensionHandler());
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act
    updateCartServiceImpl.validateAddToCartRequest(itemRequest, new NullOrderImpl());

    // Assert
    verify(updateCartServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}.
   * <ul>
   *   <li>Then throw {@link OrderLockAcquisitionFailureException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}
   */
  @Test
  @DisplayName("Test validateAddToCartRequest(OrderItemRequestDTO, Order); then throw OrderLockAcquisitionFailureException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UpdateCartServiceImpl.validateAddToCartRequest(OrderItemRequestDTO, Order)"})
  void testValidateAddToCartRequest_thenThrowOrderLockAcquisitionFailureException() {
    // Arrange
    when(updateCartServiceExtensionManager.getProxy())
        .thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act and Assert
    assertThrows(OrderLockAcquisitionFailureException.class,
        () -> updateCartServiceImpl.validateAddToCartRequest(itemRequest, new NullOrderImpl()));
    verify(updateCartServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}
   */
  @Test
  @DisplayName("Test updateAndValidateCart(Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UpdateCartServiceImpl.updateAndValidateCart(Order)"})
  void testUpdateAndValidateCart() {
    // Arrange
    when(updateCartServiceExtensionManager.getProxy()).thenReturn(new i18nUpdateCartServiceExtensionHandler());

    // Act
    updateCartServiceImpl.updateAndValidateCart(new NullOrderImpl());

    // Assert
    verify(updateCartServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}.
   * <ul>
   *   <li>Then calls {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}
   */
  @Test
  @DisplayName("Test updateAndValidateCart(Order); then calls updateAndValidateCart(Order, ExtensionResultHolder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UpdateCartServiceImpl.updateAndValidateCart(Order)"})
  void testUpdateAndValidateCart_thenCallsUpdateAndValidateCart() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = mock(
        i18nUpdateCartServiceExtensionHandler.class);
    when(i18nUpdateCartServiceExtensionHandler.updateAndValidateCart(Mockito.<Order>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(updateCartServiceExtensionManager.getProxy()).thenReturn(i18nUpdateCartServiceExtensionHandler);

    // Act
    updateCartServiceImpl.updateAndValidateCart(new NullOrderImpl());

    // Assert
    verify(updateCartServiceExtensionManager).getProxy();
    verify(i18nUpdateCartServiceExtensionHandler).updateAndValidateCart(isA(Order.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link UpdateCartServiceImpl#lockOrder(Order, Object)}.
   * <ul>
   *   <li>When {@code Lock Object}.</li>
   *   <li>Then return {@code Lock Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#lockOrder(Order, Object)}
   */
  @Test
  @DisplayName("Test lockOrder(Order, Object); when 'Lock Object'; then return 'Lock Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object UpdateCartServiceImpl.lockOrder(Order, Object)"})
  void testLockOrder_whenLockObject_thenReturnLockObject() {
    // Arrange, Act and Assert
    assertEquals("Lock Object", updateCartServiceImpl.lockOrder(new NullOrderImpl(), "Lock Object"));
  }

  /**
   * Test {@link UpdateCartServiceImpl#findActiveCurrency()}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#findActiveCurrency()}
   */
  @Test
  @DisplayName("Test findActiveCurrency()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BroadleafCurrency UpdateCartServiceImpl.findActiveCurrency()"})
  void testFindActiveCurrency() {
    // Arrange, Act and Assert
    assertNull(updateCartServiceImpl.findActiveCurrency());
  }

  /**
   * Test {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}
   */
  @Test
  @DisplayName("Test checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency); given SkuImpl (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateCartServiceImpl.checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)"})
  void testCheckAvailabilityInLocale_givenSkuImpl_thenReturnTrue() {
    // Arrange
    DiscreteOrderItem doi = mock(DiscreteOrderItem.class);
    when(doi.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualCheckAvailabilityInLocaleResult = updateCartServiceImpl.checkAvailabilityInLocale(doi,
        new BroadleafCurrencyImpl());

    // Assert
    verify(doi, atLeast(1)).getSku();
    assertTrue(actualCheckAvailabilityInLocaleResult);
  }

  /**
   * Test {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}.
   * <ul>
   *   <li>Then throw {@link OrderLockAcquisitionFailureException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}
   */
  @Test
  @DisplayName("Test checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency); then throw OrderLockAcquisitionFailureException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateCartServiceImpl.checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)"})
  void testCheckAvailabilityInLocale_thenThrowOrderLockAcquisitionFailureException() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isAvailable()).thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));
    DiscreteOrderItem doi = mock(DiscreteOrderItem.class);
    when(doi.getSku()).thenReturn(skuImpl);

    // Act and Assert
    assertThrows(OrderLockAcquisitionFailureException.class,
        () -> updateCartServiceImpl.checkAvailabilityInLocale(doi, new BroadleafCurrencyImpl()));
    verify(skuImpl).isAvailable();
    verify(doi, atLeast(1)).getSku();
  }

  /**
   * Test {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}
   */
  @Test
  @DisplayName("Test checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency); when DiscreteOrderItemImpl (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateCartServiceImpl.checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)"})
  void testCheckAvailabilityInLocale_whenDiscreteOrderItemImpl_thenReturnFalse() {
    // Arrange
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BroadleafCurrency UpdateCartServiceImpl.getSavedCurrency()",
      "void UpdateCartServiceImpl.setSavedCurrency(BroadleafCurrency)"})
  void testGettersAndSetters() {
    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    BroadleafCurrencyImpl savedCurrency = new BroadleafCurrencyImpl();

    // Act
    updateCartServiceImpl.setSavedCurrency(savedCurrency);

    // Assert
    assertSame(savedCurrency, updateCartServiceImpl.getSavedCurrency());
  }
}
