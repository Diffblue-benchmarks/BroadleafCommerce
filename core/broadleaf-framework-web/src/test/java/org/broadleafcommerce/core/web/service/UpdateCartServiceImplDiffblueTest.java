package org.broadleafcommerce.core.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.web.order.security.exception.OrderLockAcquisitionFailureException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCartServiceImplDiffblueTest {
  @Mock private UpdateCartServiceExtensionManager updateCartServiceExtensionManager;

  @InjectMocks private UpdateCartServiceImpl updateCartServiceImpl;

  /**
   * Test {@link UpdateCartServiceImpl#currencyHasChanged()}.
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#currencyHasChanged()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateCartServiceImpl.currencyHasChanged()"})
  public void testCurrencyHasChanged() {
    // Arrange, Act and Assert
    assertTrue(new UpdateCartServiceImpl().currencyHasChanged());
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   * </ul>
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.order.service.call.UpdateCartResponse UpdateCartServiceImpl.copyCartToCurrentContext(Order)"
  })
  public void testCopyCartToCurrentContext_givenAuditableCreatedByIsOne() {
    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    currentCart.setStatus(new OrderStatus());
    currentCart.setSubTotal(new Money());
    currentCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    currentCart.setTaxOverride(true);
    currentCart.setTotal(new Money());
    currentCart.setTotalFulfillmentCharges(new Money());
    currentCart.setTotalTax(new Money());

    // Act and Assert
    assertNull(updateCartServiceImpl.copyCartToCurrentContext(currentCart));
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.order.service.call.UpdateCartResponse UpdateCartServiceImpl.copyCartToCurrentContext(Order)"
  })
  public void testCopyCartToCurrentContext_whenNullOrderImpl_thenReturnNull() {
    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    // Act and Assert
    assertNull(updateCartServiceImpl.copyCartToCurrentContext(new NullOrderImpl()));
  }

  /**
   * Test {@link UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}.
   *
   * <p>Method under test: {@link
   * UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpdateCartServiceImpl.validateAddToCartRequest(OrderItemRequestDTO, Order)"
  })
  public void testValidateAddToCartRequest() {
    // Arrange
    when(updateCartServiceExtensionManager.getProxy())
        .thenReturn(new i18nUpdateCartServiceExtensionHandler());
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act
    updateCartServiceImpl.validateAddToCartRequest(itemRequest, new NullOrderImpl());

    // Assert
    verify(updateCartServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}.
   *
   * <ul>
   *   <li>Then throw {@link OrderLockAcquisitionFailureException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpdateCartServiceImpl.validateAddToCartRequest(OrderItemRequestDTO, Order)"
  })
  public void testValidateAddToCartRequest_thenThrowOrderLockAcquisitionFailureException() {
    // Arrange
    when(updateCartServiceExtensionManager.getProxy())
        .thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () -> updateCartServiceImpl.validateAddToCartRequest(itemRequest, new NullOrderImpl()));
    verify(updateCartServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}.
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpdateCartServiceImpl.updateAndValidateCart(Order)"})
  public void testUpdateAndValidateCart() {
    // Arrange
    when(updateCartServiceExtensionManager.getProxy())
        .thenReturn(new i18nUpdateCartServiceExtensionHandler());

    // Act
    updateCartServiceImpl.updateAndValidateCart(new NullOrderImpl());

    // Assert
    verify(updateCartServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}.
   *
   * <ul>
   *   <li>Then calls {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order,
   *       ExtensionResultHolder)}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpdateCartServiceImpl.updateAndValidateCart(Order)"})
  public void testUpdateAndValidateCart_thenCallsUpdateAndValidateCart() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler =
        mock(i18nUpdateCartServiceExtensionHandler.class);
    when(i18nUpdateCartServiceExtensionHandler.updateAndValidateCart(
            Mockito.<Order>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(updateCartServiceExtensionManager.getProxy())
        .thenReturn(i18nUpdateCartServiceExtensionHandler);

    // Act
    updateCartServiceImpl.updateAndValidateCart(new NullOrderImpl());

    // Assert
    verify(updateCartServiceExtensionManager).getProxy();
    verify(i18nUpdateCartServiceExtensionHandler)
        .updateAndValidateCart(isA(Order.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link OrderLockAcquisitionFailureException}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpdateCartServiceImpl.updateAndValidateCart(Order)"})
  public void testUpdateAndValidateCart_thenThrowOrderLockAcquisitionFailureException() {
    // Arrange
    when(updateCartServiceExtensionManager.getProxy())
        .thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () -> updateCartServiceImpl.updateAndValidateCart(new NullOrderImpl()));
    verify(updateCartServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link UpdateCartServiceImpl#lockOrder(Order, Object)}.
   *
   * <ul>
   *   <li>Given {@link UpdateCartServiceImpl} (default constructor).
   *   <li>When {@code Lock Object}.
   *   <li>Then return {@code Lock Object}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#lockOrder(Order, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UpdateCartServiceImpl.lockOrder(Order, Object)"})
  public void testLockOrder_givenUpdateCartServiceImpl_whenLockObject_thenReturnLockObject() {
    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    // Act and Assert
    assertEquals(
        "Lock Object", updateCartServiceImpl.lockOrder(new NullOrderImpl(), "Lock Object"));
  }

  /**
   * Test {@link UpdateCartServiceImpl#findActiveCurrency()}.
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#findActiveCurrency()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafCurrency UpdateCartServiceImpl.findActiveCurrency()"})
  public void testFindActiveCurrency() {
    // Arrange, Act and Assert
    assertNull(new UpdateCartServiceImpl().findActiveCurrency());
  }

  /**
   * Test {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem,
   * BroadleafCurrency)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem,
   * BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UpdateCartServiceImpl.checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)"
  })
  public void testCheckAvailabilityInLocale_givenSkuImpl_thenReturnTrue() {
    // Arrange
    DiscreteOrderItem doi = mock(DiscreteOrderItem.class);
    when(doi.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualCheckAvailabilityInLocaleResult =
        updateCartServiceImpl.checkAvailabilityInLocale(doi, new BroadleafCurrencyImpl());

    // Assert
    verify(doi, atLeast(1)).getSku();
    assertTrue(actualCheckAvailabilityInLocaleResult);
  }

  /**
   * Test {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem,
   * BroadleafCurrency)}.
   *
   * <ul>
   *   <li>Given {@link UpdateCartServiceImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem,
   * BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UpdateCartServiceImpl.checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)"
  })
  public void testCheckAvailabilityInLocale_givenUpdateCartServiceImpl_thenReturnFalse() {
    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    DiscreteOrderItem doi = mock(DiscreteOrderItem.class);
    when(doi.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualCheckAvailabilityInLocaleResult =
        updateCartServiceImpl.checkAvailabilityInLocale(doi, new BroadleafCurrencyImpl());

    // Assert
    verify(doi).getSku();
    assertFalse(actualCheckAvailabilityInLocaleResult);
  }

  /**
   * Test {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem,
   * BroadleafCurrency)}.
   *
   * <ul>
   *   <li>Then throw {@link OrderLockAcquisitionFailureException}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem,
   * BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UpdateCartServiceImpl.checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)"
  })
  public void testCheckAvailabilityInLocale_thenThrowOrderLockAcquisitionFailureException() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isAvailable())
        .thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));

    DiscreteOrderItem doi = mock(DiscreteOrderItem.class);
    when(doi.getSku()).thenReturn(skuImpl);

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () -> updateCartServiceImpl.checkAvailabilityInLocale(doi, new BroadleafCurrencyImpl()));
    verify(skuImpl).isAvailable();
    verify(doi, atLeast(1)).getSku();
  }

  /**
   * Test {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem,
   * BroadleafCurrency)}.
   *
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem,
   * BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UpdateCartServiceImpl.checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)"
  })
  public void testCheckAvailabilityInLocale_whenDiscreteOrderItemImpl_thenReturnFalse() {
    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    DiscreteOrderItemImpl doi = new DiscreteOrderItemImpl();

    // Act and Assert
    assertFalse(updateCartServiceImpl.checkAvailabilityInLocale(doi, new BroadleafCurrencyImpl()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UpdateCartServiceImpl#setSavedCurrency(BroadleafCurrency)}
   *   <li>{@link UpdateCartServiceImpl#getSavedCurrency()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafCurrency UpdateCartServiceImpl.getSavedCurrency()",
    "void UpdateCartServiceImpl.setSavedCurrency(BroadleafCurrency)"
  })
  public void testGettersAndSetters() {
    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    BroadleafCurrencyImpl savedCurrency = new BroadleafCurrencyImpl();

    // Act
    updateCartServiceImpl.setSavedCurrency(savedCurrency);

    // Assert
    assertSame(savedCurrency, updateCartServiceImpl.getSavedCurrency());
  }
}
