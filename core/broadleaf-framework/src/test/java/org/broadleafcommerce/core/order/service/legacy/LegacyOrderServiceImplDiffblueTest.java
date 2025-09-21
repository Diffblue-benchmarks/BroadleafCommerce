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
package org.broadleafcommerce.core.order.service.legacy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundle;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupDao;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.call.BundleOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.DiscreteOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.ItemNotFoundException;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDao;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.pricing.service.PricingService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LegacyOrderServiceImplDiffblueTest {
  @Mock private CategoryDao categoryDao;

  @Mock private FulfillmentGroupDao fulfillmentGroupDao;

  @Mock private FulfillmentGroupItemDao fulfillmentGroupItemDao;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks private LegacyOrderServiceImpl legacyOrderServiceImpl;

  @Mock private OrderDao orderDao;

  @Mock private OrderItemDao orderItemDao;

  @Mock private OrderItemService orderItemService;

  @Mock private OrderPaymentDao orderPaymentDao;

  @Mock private PricingService pricingService;

  @Mock private ProductDao productDao;

  @Mock private SkuDao skuDao;

  /**
   * Test {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.findDefaultFulfillmentGroupForOrder(Order)"
  })
  public void testFindDefaultFulfillmentGroupForOrder_thenReturnFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);

    // Act
    FulfillmentGroup actualFindDefaultFulfillmentGroupForOrderResult =
        legacyOrderServiceImpl.findDefaultFulfillmentGroupForOrder(new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    assertSame(fulfillmentGroupImpl, actualFindDefaultFulfillmentGroupForOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.findDefaultFulfillmentGroupForOrder(Order)"
  })
  public void testFindDefaultFulfillmentGroupForOrder_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.findDefaultFulfillmentGroupForOrder(new NullOrderImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"
  })
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem() {
    // Arrange and Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult =
        legacyOrderServiceImpl.createDiscreteOrderItemRequest(new DiscreteOrderItemImpl());

    // Assert
    assertNull(actualCreateDiscreteOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getCategory());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getProduct());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSku());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getBundleOrderItem());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getOrder());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getPersonalMessage());
    assertEquals(0, actualCreateDiscreteOrderItemRequestResult.getQuantity());
    assertTrue(
        actualCreateDiscreteOrderItemRequestResult.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"
  })
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem2() {
    // Arrange
    when(orderItemService.createPersonalMessage()).thenReturn(new PersonalMessageImpl());

    DiscreteOrderItemImpl discreteOrderItem = new DiscreteOrderItemImpl();
    discreteOrderItem.setPersonalMessage(new PersonalMessageImpl());

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult =
        legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem);

    // Assert
    verify(orderItemService).createPersonalMessage();
    PersonalMessage personalMessage =
        actualCreateDiscreteOrderItemRequestResult.getPersonalMessage();
    assertTrue(personalMessage instanceof PersonalMessageImpl);
    assertNull(personalMessage.getMessage());
    assertNull(personalMessage.getMessageFrom());
    assertNull(personalMessage.getMessageTo());
    assertNull(personalMessage.getOccasion());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"
  })
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem3() {
    // Arrange
    when(orderItemService.createPersonalMessage()).thenThrow(new IllegalArgumentException());

    DiscreteOrderItemImpl discreteOrderItem = new DiscreteOrderItemImpl();
    discreteOrderItem.setPersonalMessage(new PersonalMessageImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem));
    verify(orderItemService).createPersonalMessage();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"
  })
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem4() {
    // Arrange
    when(orderItemService.createPersonalMessage()).thenReturn(new PersonalMessageImpl());

    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    personalMessage.setId(1L);

    DiscreteOrderItemImpl discreteOrderItem = new DiscreteOrderItemImpl();
    discreteOrderItem.setPersonalMessage(personalMessage);

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult =
        legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem);

    // Assert
    verify(orderItemService).createPersonalMessage();
    PersonalMessage personalMessage2 =
        actualCreateDiscreteOrderItemRequestResult.getPersonalMessage();
    assertTrue(personalMessage2 instanceof PersonalMessageImpl);
    assertNull(personalMessage2.getMessage());
    assertNull(personalMessage2.getMessageFrom());
    assertNull(personalMessage2.getMessageTo());
    assertNull(personalMessage2.getOccasion());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"
  })
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem5() {
    // Arrange
    when(orderItemService.createPersonalMessage()).thenReturn(new PersonalMessageImpl());

    PersonalMessage personalMessage = mock(PersonalMessage.class);
    when(personalMessage.getId()).thenReturn(1L);
    when(personalMessage.getMessage()).thenReturn("Not all who wander are lost");
    when(personalMessage.getMessageFrom()).thenReturn("jane.doe@example.org");
    when(personalMessage.getMessageTo()).thenReturn("alice.liddell@example.org");
    when(personalMessage.getOccasion()).thenReturn("Occasion");

    DiscreteOrderItemImpl discreteOrderItem = new DiscreteOrderItemImpl();
    discreteOrderItem.setPersonalMessage(personalMessage);

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult =
        legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem);

    // Assert
    verify(personalMessage).getId();
    verify(personalMessage).getMessage();
    verify(personalMessage).getMessageFrom();
    verify(personalMessage).getMessageTo();
    verify(personalMessage).getOccasion();
    verify(orderItemService).createPersonalMessage();
    PersonalMessage personalMessage2 =
        actualCreateDiscreteOrderItemRequestResult.getPersonalMessage();
    assertTrue(personalMessage2 instanceof PersonalMessageImpl);
    assertEquals("Not all who wander are lost", personalMessage2.getMessage());
    assertEquals("Occasion", personalMessage2.getOccasion());
    assertEquals("alice.liddell@example.org", personalMessage2.getMessageTo());
    assertEquals("jane.doe@example.org", personalMessage2.getMessageFrom());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"
  })
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem6() {
    // Arrange
    when(orderItemService.createPersonalMessage()).thenReturn(new PersonalMessageImpl());

    PersonalMessage personalMessage = mock(PersonalMessage.class);
    when(personalMessage.getOccasion()).thenThrow(new IllegalArgumentException());

    DiscreteOrderItemImpl discreteOrderItem = new DiscreteOrderItemImpl();
    discreteOrderItem.setPersonalMessage(personalMessage);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem));
    verify(personalMessage).getOccasion();
    verify(orderItemService).createPersonalMessage();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"
  })
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem7() {
    // Arrange
    PersonalMessage personalMessage = mock(PersonalMessage.class);
    doThrow(new IllegalArgumentException())
        .when(personalMessage)
        .setOccasion(Mockito.<String>any());
    when(orderItemService.createPersonalMessage()).thenReturn(personalMessage);

    PersonalMessage personalMessage2 = mock(PersonalMessage.class);
    when(personalMessage2.getOccasion()).thenReturn("Occasion");

    DiscreteOrderItemImpl discreteOrderItem = new DiscreteOrderItemImpl();
    discreteOrderItem.setPersonalMessage(personalMessage2);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem));
    verify(personalMessage2).getOccasion();
    verify(personalMessage).setOccasion("Occasion");
    verify(orderItemService).createPersonalMessage();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku,
   * Product, Category, Integer, Map)} with {@code order}, {@code bundleOrderItem}, {@code sku},
   * {@code product}, {@code category}, {@code quantity}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order,
   * BundleOrderItem, Sku, Product, org.broadleafcommerce.core.catalog.domain.Category, Integer,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, org.broadleafcommerce.core.catalog.domain.Category, Integer, Map)"
  })
  public void
      testCreateDiscreteOrderItemRequestWithOrderBundleOrderItemSkuProductCategoryQuantityItemAttributes() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    SkuImpl sku = new SkuImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult =
        legacyOrderServiceImpl.createDiscreteOrderItemRequest(
            order, bundleOrderItem, sku, product, category, 1, new HashMap<>());

    // Assert
    org.broadleafcommerce.core.catalog.domain.Category category2 =
        actualCreateDiscreteOrderItemRequestResult.getCategory();
    assertTrue(category2 instanceof CategoryImpl);
    Product product2 = actualCreateDiscreteOrderItemRequestResult.getProduct();
    assertTrue(product2 instanceof ProductBundleImpl);
    Sku sku2 = actualCreateDiscreteOrderItemRequestResult.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    BundleOrderItem bundleOrderItem2 =
        actualCreateDiscreteOrderItemRequestResult.getBundleOrderItem();
    assertTrue(bundleOrderItem2 instanceof BundleOrderItemImpl);
    Order order2 = actualCreateDiscreteOrderItemRequestResult.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertNull(actualCreateDiscreteOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getPersonalMessage());
    assertEquals(1, actualCreateDiscreteOrderItemRequestResult.getQuantity());
    assertTrue(
        actualCreateDiscreteOrderItemRequestResult.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getItemAttributes().isEmpty());
    assertSame(category, category2);
    assertSame(product, product2);
    assertSame(sku, sku2);
    assertSame(bundleOrderItem, bundleOrderItem2);
    assertSame(order, order2);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long,
   * Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long,
   * Long, Long, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"
  })
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult =
        legacyOrderServiceImpl.createDiscreteOrderItemRequest(1L, 1L, 1L, 1L, 1);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    assertTrue(
        actualCreateDiscreteOrderItemRequestResult.getProduct() instanceof ProductBundleImpl);
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getSku() instanceof SkuImpl);
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getOrder() instanceof NullOrderImpl);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long,
   * Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long,
   * Long, Long, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"
  })
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity2() {
    // Arrange
    when(skuDao.readSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(1L, 1L, 1L, 1L, 1));
    verify(skuDao).readSkuById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long,
   * Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long,
   * Long, Long, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"
  })
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity3() {
    // Arrange
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(1L, 1L, 1L, 1L, 1));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long,
   * Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long,
   * Long, Long, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"
  })
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity4() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult =
        legacyOrderServiceImpl.createDiscreteOrderItemRequest(1L, 1L, null, 1L, 1);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    Sku sku = actualCreateDiscreteOrderItemRequestResult.getSku();
    assertTrue(sku instanceof SkuImpl);
    Order order = actualCreateDiscreteOrderItemRequestResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertNull(actualCreateDiscreteOrderItemRequestResult.getProduct());
    Money orderAdjustmentsValue = order.getOrderAdjustmentsValue();
    assertEquals(new BigDecimal("0.00"), orderAdjustmentsValue.getAmount());
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, order.getSubTotal());
    assertSame(orderAdjustmentsValue, sku.getMargin());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long,
   * Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long,
   * Long, Long, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"
  })
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity5() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult =
        legacyOrderServiceImpl.createDiscreteOrderItemRequest(1L, 1L, 1L, null, 1);

    // Assert
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    assertTrue(
        actualCreateDiscreteOrderItemRequestResult.getProduct() instanceof ProductBundleImpl);
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getSku() instanceof SkuImpl);
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getOrder() instanceof NullOrderImpl);
    assertNull(actualCreateDiscreteOrderItemRequestResult.getCategory());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long,
   * Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long,
   * Long, Long, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"
  })
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity6() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(1L, 1L, null, null, 1));
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long,
   * Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long,
   * Long, Long, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"
  })
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity7() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(1L, 1L, null, 1L, 1));
    verify(categoryDao).readCategoryById(1L);
    verify(skuDao).readSkuById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest,
   * boolean)} with {@code order}, {@code itemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order,
   * BundleOrderItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addBundleItemToOrder(Order, BundleOrderItemRequest, boolean)"
  })
  public void testAddBundleItemToOrderWithOrderItemRequestPriceOrder() throws PricingException {
    // Arrange
    when(orderItemService.createBundleOrderItem(Mockito.<BundleOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException());
    NullOrderImpl order = new NullOrderImpl();

    BundleOrderItemRequest itemRequest = new BundleOrderItemRequest();
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addBundleItemToOrder(order, itemRequest, true));
    verify(orderItemService).createBundleOrderItem(isA(BundleOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest)} with
   * {@code order}, {@code itemRequest}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order,
   * BundleOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addBundleItemToOrder(Order, BundleOrderItemRequest)"
  })
  public void testAddBundleItemToOrderWithOrderItemRequest_thenThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(orderItemService.createBundleOrderItem(Mockito.<BundleOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException());
    NullOrderImpl order = new NullOrderImpl();

    BundleOrderItemRequest itemRequest = new BundleOrderItemRequest();
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addBundleItemToOrder(order, itemRequest));
    verify(orderItemService).createBundleOrderItem(isA(BundleOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)} with {@code orderId},
   * {@code itemId}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long)"})
  public void testRemoveItemFromOrderWithOrderIdItemId() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)} with {@code orderId},
   * {@code itemId}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long)"})
  public void testRemoveItemFromOrderWithOrderIdItemId2() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L));
    verify(orderDao).readOrderById(1L);
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)} with {@code orderId},
   * {@code itemId}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long)"})
  public void testRemoveItemFromOrderWithOrderIdItemId3() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    doThrow(new IllegalArgumentException()).when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L));
    verify(orderDao).readOrderById(1L);
    verify(order, atLeast(1)).getOrderItems();
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)} with {@code orderId},
   * {@code itemId}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long)"})
  public void testRemoveItemFromOrderWithOrderIdItemId4() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L));
    verify(orderDao).readOrderById(1L);
    verify(order, atLeast(1)).getOrderItems();
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)} with {@code
   * orderId}, {@code itemId}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long, boolean)"})
  public void testRemoveItemFromOrderWithOrderIdItemIdPriceOrder() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L, true));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)} with {@code
   * orderId}, {@code itemId}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long, boolean)"})
  public void testRemoveItemFromOrderWithOrderIdItemIdPriceOrder2() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L, true));
    verify(orderDao).readOrderById(1L);
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)} with {@code
   * orderId}, {@code itemId}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long, boolean)"})
  public void testRemoveItemFromOrderWithOrderIdItemIdPriceOrder3() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    doThrow(new IllegalArgumentException()).when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L, true));
    verify(orderDao).readOrderById(1L);
    verify(order, atLeast(1)).getOrderItems();
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)} with {@code
   * orderId}, {@code itemId}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long, boolean)"})
  public void testRemoveItemFromOrderWithOrderIdItemIdPriceOrder4() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L, true));
    verify(orderDao).readOrderById(1L);
    verify(order, atLeast(1)).getOrderItems();
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)} with {@code
   * orderId}, {@code itemId}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#setOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long, boolean)"})
  public void testRemoveItemFromOrderWithOrderIdItemIdPriceOrder_thenCallsSetOrder()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new IllegalArgumentException())
        .when(bundleOrderItemImpl)
        .setOrder(Mockito.<Order>any());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L, true));
    verify(orderDao).readOrderById(1L);
    verify(order, atLeast(1)).getOrderItems();
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)} with {@code
   * orderId}, {@code itemId}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long, boolean)"})
  public void testRemoveItemFromOrderWithOrderIdItemIdPriceOrder_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    // Act
    Order actualRemoveItemFromOrderResult =
        legacyOrderServiceImpl.removeItemFromOrder(1L, 1L, true);

    // Assert
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(order, atLeast(1)).getOrderItems();
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(nullOrderImpl, actualRemoveItemFromOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)} with {@code orderId},
   * {@code itemId}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#setOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long)"})
  public void testRemoveItemFromOrderWithOrderIdItemId_thenCallsSetOrder() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new IllegalArgumentException())
        .when(bundleOrderItemImpl)
        .setOrder(Mockito.<Order>any());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L));
    verify(orderDao).readOrderById(1L);
    verify(order, atLeast(1)).getOrderItems();
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)} with {@code orderId},
   * {@code itemId}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long)"})
  public void testRemoveItemFromOrderWithOrderIdItemId_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    // Act
    Order actualRemoveItemFromOrderResult = legacyOrderServiceImpl.removeItemFromOrder(1L, 1L);

    // Assert
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(order, atLeast(1)).getOrderItems();
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(nullOrderImpl, actualRemoveItemFromOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem)"})
  public void testRemoveItemFromOrderWithOrderItem() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doThrow(new IllegalArgumentException()).when(orderItemService).delete(Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl()));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem)"})
  public void testRemoveItemFromOrderWithOrderItem2() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl()));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"})
  public void testRemoveItemFromOrderWithOrderItemPriceOrder() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"})
  public void testRemoveItemFromOrderWithOrderItemPriceOrder2() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doThrow(new IllegalArgumentException()).when(orderItemService).delete(Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"})
  public void testRemoveItemFromOrderWithOrderItemPriceOrder3() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#setOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"})
  public void testRemoveItemFromOrderWithOrderItemPriceOrder_thenCallsSetOrder()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new IllegalArgumentException())
        .when(bundleOrderItemImpl)
        .setOrder(Mockito.<Order>any());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true));
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"})
  public void testRemoveItemFromOrderWithOrderItemPriceOrder_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act
    Order actualRemoveItemFromOrderResult =
        legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(nullOrderImpl, actualRemoveItemFromOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#setOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem)"})
  public void testRemoveItemFromOrderWithOrderItem_thenCallsSetOrder() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new IllegalArgumentException())
        .when(bundleOrderItemImpl)
        .setOrder(Mockito.<Order>any());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl()));
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem)"})
  public void testRemoveItemFromOrderWithOrderItem_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act
    Order actualRemoveItemFromOrderResult =
        legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl());

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(nullOrderImpl, actualRemoveItemFromOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)} with {@code
   * originalOrder}, {@code destinationOrder}, {@code item}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.moveItemToOrder(Order, Order, OrderItem)"})
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItem() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl originalOrder = new NullOrderImpl();
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.moveItemToOrder(
                originalOrder, destinationOrder, new BundleOrderItemImpl()));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem, boolean)} with
   * {@code originalOrder}, {@code destinationOrder}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.moveItemToOrder(Order, Order, OrderItem, boolean)"
  })
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItemPriceOrder()
      throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl originalOrder = new NullOrderImpl();
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.moveItemToOrder(
                originalOrder, destinationOrder, new BundleOrderItemImpl(), true));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem, boolean)} with
   * {@code originalOrder}, {@code destinationOrder}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.moveItemToOrder(Order, Order, OrderItem, boolean)"
  })
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItemPriceOrder2()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl originalOrder = new OrderImpl();
    originalOrder.setAdditionalOfferInformation(new HashMap<>());
    originalOrder.setAuditable(auditable);
    originalOrder.setCandidateOrderOffers(new ArrayList<>());
    originalOrder.setCurrency(new BroadleafCurrencyImpl());
    originalOrder.setCustomer(new CustomerImpl());
    originalOrder.setEmailAddress("42 Main St");
    originalOrder.setFulfillmentGroups(new ArrayList<>());
    originalOrder.setId(1L);
    originalOrder.setLocale(new LocaleImpl());
    originalOrder.setName("Name");
    originalOrder.setOrderAttributes(new HashMap<>());
    originalOrder.setOrderItems(orderItems);
    originalOrder.setOrderMessages(new ArrayList<>());
    originalOrder.setOrderNumber("42");
    originalOrder.setPayments(new ArrayList<>());
    originalOrder.setStatus(OrderStatus.ARCHIVED);
    originalOrder.setSubTotal(new Money());
    originalOrder.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    originalOrder.setTaxOverride(true);
    originalOrder.setTotal(new Money());
    originalOrder.setTotalFulfillmentCharges(new Money());
    originalOrder.setTotalTax(new Money());
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.moveItemToOrder(
                originalOrder, destinationOrder, new BundleOrderItemImpl(), true));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem, boolean)} with
   * {@code originalOrder}, {@code destinationOrder}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.moveItemToOrder(Order, Order, OrderItem, boolean)"
  })
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItemPriceOrder3()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new IllegalArgumentException())
        .when(bundleOrderItemImpl)
        .setOrder(Mockito.<Order>any());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl originalOrder = new OrderImpl();
    originalOrder.setAdditionalOfferInformation(new HashMap<>());
    originalOrder.setAuditable(auditable);
    originalOrder.setCandidateOrderOffers(new ArrayList<>());
    originalOrder.setCurrency(new BroadleafCurrencyImpl());
    originalOrder.setCustomer(new CustomerImpl());
    originalOrder.setEmailAddress("42 Main St");
    originalOrder.setFulfillmentGroups(new ArrayList<>());
    originalOrder.setId(1L);
    originalOrder.setLocale(new LocaleImpl());
    originalOrder.setName("Name");
    originalOrder.setOrderAttributes(new HashMap<>());
    originalOrder.setOrderItems(orderItems);
    originalOrder.setOrderMessages(new ArrayList<>());
    originalOrder.setOrderNumber("42");
    originalOrder.setPayments(new ArrayList<>());
    originalOrder.setStatus(OrderStatus.ARCHIVED);
    originalOrder.setSubTotal(new Money());
    originalOrder.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    originalOrder.setTaxOverride(true);
    originalOrder.setTotal(new Money());
    originalOrder.setTotalFulfillmentCharges(new Money());
    originalOrder.setTotalTax(new Money());
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.moveItemToOrder(
                originalOrder, destinationOrder, new BundleOrderItemImpl(), true));
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)} with {@code
   * originalOrder}, {@code destinationOrder}, {@code item}.
   *
   * <ul>
   *   <li>Then calls {@link PricingService#executePricing(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.moveItemToOrder(Order, Order, OrderItem)"})
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItem_thenCallsExecutePricing()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl originalOrder = new OrderImpl();
    originalOrder.setAdditionalOfferInformation(new HashMap<>());
    originalOrder.setAuditable(auditable);
    originalOrder.setCandidateOrderOffers(new ArrayList<>());
    originalOrder.setCurrency(new BroadleafCurrencyImpl());
    originalOrder.setCustomer(new CustomerImpl());
    originalOrder.setEmailAddress("42 Main St");
    originalOrder.setFulfillmentGroups(new ArrayList<>());
    originalOrder.setId(1L);
    originalOrder.setLocale(new LocaleImpl());
    originalOrder.setName("Name");
    originalOrder.setOrderAttributes(new HashMap<>());
    originalOrder.setOrderItems(orderItems);
    originalOrder.setOrderMessages(new ArrayList<>());
    originalOrder.setOrderNumber("42");
    originalOrder.setPayments(new ArrayList<>());
    originalOrder.setStatus(OrderStatus.ARCHIVED);
    originalOrder.setSubTotal(new Money());
    originalOrder.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    originalOrder.setTaxOverride(true);
    originalOrder.setTotal(new Money());
    originalOrder.setTotalFulfillmentCharges(new Money());
    originalOrder.setTotalTax(new Money());
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.moveItemToOrder(
                originalOrder, destinationOrder, new BundleOrderItemImpl()));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)} with {@code
   * originalOrder}, {@code destinationOrder}, {@code item}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#setOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.moveItemToOrder(Order, Order, OrderItem)"})
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItem_thenCallsSetOrder()
      throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new IllegalArgumentException())
        .when(bundleOrderItemImpl)
        .setOrder(Mockito.<Order>any());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl originalOrder = new OrderImpl();
    originalOrder.setAdditionalOfferInformation(new HashMap<>());
    originalOrder.setAuditable(auditable);
    originalOrder.setCandidateOrderOffers(new ArrayList<>());
    originalOrder.setCurrency(new BroadleafCurrencyImpl());
    originalOrder.setCustomer(new CustomerImpl());
    originalOrder.setEmailAddress("42 Main St");
    originalOrder.setFulfillmentGroups(new ArrayList<>());
    originalOrder.setId(1L);
    originalOrder.setLocale(new LocaleImpl());
    originalOrder.setName("Name");
    originalOrder.setOrderAttributes(new HashMap<>());
    originalOrder.setOrderItems(orderItems);
    originalOrder.setOrderMessages(new ArrayList<>());
    originalOrder.setOrderNumber("42");
    originalOrder.setPayments(new ArrayList<>());
    originalOrder.setStatus(OrderStatus.ARCHIVED);
    originalOrder.setSubTotal(new Money());
    originalOrder.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    originalOrder.setTaxOverride(true);
    originalOrder.setTotal(new Money());
    originalOrder.setTotalFulfillmentCharges(new Money());
    originalOrder.setTotalTax(new Money());
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.moveItemToOrder(
                originalOrder, destinationOrder, new BundleOrderItemImpl()));
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)} with
   * {@code fulfillmentGroupRequest}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest)"
  })
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequest() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult =
        legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest);

    // Assert
    verify(fulfillmentGroupDao).create();
    assertSame(fulfillmentGroupImpl, actualAddFulfillmentGroupToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)} with
   * {@code fulfillmentGroupRequest}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest)"
  })
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequest2() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException());

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)} with {@code fulfillmentGroupRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequestPriceOrder()
      throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult =
        legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, true);

    // Assert
    verify(fulfillmentGroupDao).create();
    assertSame(fulfillmentGroupImpl, actualAddFulfillmentGroupToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)} with {@code fulfillmentGroupRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequestPriceOrder2()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException());

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, true));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup)} with
   * {@code order}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup)"
  })
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroup() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup)} with
   * {@code order}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup)"
  })
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroup2() throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup,
   * boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)"
  })
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroupPriceOrder()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addFulfillmentGroupToOrder(
                order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup,
   * boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)"
  })
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroupPriceOrder2()
      throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addFulfillmentGroupToOrder(
                order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup,
   * boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then calls {@link OrderDao#save(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)"
  })
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroupPriceOrder_thenCallsSave()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addFulfillmentGroupToOrder(
                order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup)} with
   * {@code order}, {@code fulfillmentGroup}.
   *
   * <ul>
   *   <li>Then calls {@link OrderDao#save(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup)"
  })
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroup_thenCallsSave()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with
   * {@code item}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with
   * {@code item}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup2() throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with
   * {@code item}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup3() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with
   * {@code item}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup4() throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with
   * {@code item}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup5() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with
   * {@code item}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup6() throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroup)
        .addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addItemToFulfillmentGroup(
                item, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder2()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder3()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder4()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder5()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder6()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroup)
        .addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder7()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException()).when(fulfillmentGroup).setOrder(Mockito.<Order>any());
    when(fulfillmentGroup.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder8()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException()).when(fulfillmentGroup).setPrimary(anyBoolean());
    when(fulfillmentGroup.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setPrimary(true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), 2));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity2()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity3()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity4()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity5()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity6()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroup)
        .addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity7()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException()).when(fulfillmentGroup).setPrimary(anyBoolean());
    when(fulfillmentGroup.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setPrimary(true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addItemToFulfillmentGroup(
                item, new FulfillmentGroupImpl(), 2, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder2()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder3()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder4()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder5()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder6()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroup)
        .addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    when(fulfillmentGroup.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder7()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException()).when(fulfillmentGroup).setOrder(Mockito.<Order>any());
    when(fulfillmentGroup.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int,
   * boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder8()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException()).when(fulfillmentGroup).setPrimary(anyBoolean());
    when(fulfillmentGroup.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setPrimary(true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#setOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity_thenCallsSetOrder()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException()).when(fulfillmentGroup).setOrder(Mockito.<Order>any());
    when(fulfillmentGroup.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup, 2));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with
   * {@code item}, {@code fulfillmentGroup}.
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#setOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup_thenCallsSetOrder()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException()).when(fulfillmentGroup).setOrder(Mockito.<Order>any());
    when(fulfillmentGroup.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with
   * {@code item}, {@code fulfillmentGroup}.
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#setPrimary(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup_thenCallsSetPrimary()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    doThrow(new IllegalArgumentException()).when(fulfillmentGroup).setPrimary(anyBoolean());
    when(fulfillmentGroup.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, fulfillmentGroup));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setPrimary(true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup},
   * {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder()
      throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupItemDao)
        .delete(Mockito.<FulfillmentGroupItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems2 = new ArrayList<>();
    fulfillmentGroupItems2.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setId(null);
    fulfillmentGroup.setFulfillmentGroupItems(fulfillmentGroupItems2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addItemToFulfillmentGroup(
                order, item, fulfillmentGroup, 2, true));
    verify(fulfillmentGroupItemDao).delete(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemImpl).getOrderItem();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup},
   * {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder2()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    doNothing().when(fulfillmentGroupItemDao).delete(Mockito.<FulfillmentGroupItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems2 = new ArrayList<>();
    fulfillmentGroupItems2.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setId(null);
    fulfillmentGroup.setFulfillmentGroupItems(fulfillmentGroupItems2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addItemToFulfillmentGroup(
                order, item, fulfillmentGroup, 2, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupItemDao).delete(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemImpl).getOrderItem();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup},
   * {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder3()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());
    doNothing().when(fulfillmentGroupItemDao).delete(Mockito.<FulfillmentGroupItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems2 = new ArrayList<>();
    fulfillmentGroupItems2.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setFulfillmentGroupItems(fulfillmentGroupItems2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addItemToFulfillmentGroup(
                order, item, fulfillmentGroup, 2, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).delete(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemImpl).getOrderItem();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup},
   * {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder4()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    doNothing().when(fulfillmentGroupItemDao).delete(Mockito.<FulfillmentGroupItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems2 = new ArrayList<>();
    fulfillmentGroupItems2.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setFulfillmentGroupItems(fulfillmentGroupItems2);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(order, item, fulfillmentGroup, 2, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).delete(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup},
   * {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder5()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    doNothing().when(fulfillmentGroupItemDao).delete(Mockito.<FulfillmentGroupItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems2 = new ArrayList<>();
    fulfillmentGroupItems2.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setFulfillmentGroupItems(fulfillmentGroupItems2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addItemToFulfillmentGroup(
                order, item, fulfillmentGroup, 2, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).delete(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemImpl).getOrderItem();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup},
   * {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder6()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new DiscreteOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems2 = new ArrayList<>();
    fulfillmentGroupItems2.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setFulfillmentGroupItems(fulfillmentGroupItems2);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        legacyOrderServiceImpl.addItemToFulfillmentGroup(order, item, fulfillmentGroup, 2, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup},
   * {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder7()
      throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addItemToFulfillmentGroup(
                order, item, new FulfillmentGroupImpl(), 2, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem() throws ItemNotFoundException, PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem2()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doThrow(new IllegalArgumentException()).when(orderItemService).delete(Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem3()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem4()
      throws ItemNotFoundException, PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem5()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, new BundleOrderItemImpl()));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item, true));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder2()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doThrow(new IllegalArgumentException()).when(orderItemService).delete(Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item, true));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder3()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item, true));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder4()
      throws ItemNotFoundException, PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item, true));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder5()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, new BundleOrderItemImpl(), true));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder_givenMinusOne()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(-1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#setOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder_thenCallsSetOrder()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new IllegalArgumentException())
        .when(bundleOrderItemImpl)
        .setOrder(Mockito.<Order>any());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, new BundleOrderItemImpl(), true));
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) OrderItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder_thenOrderImplOrderItemsEmpty()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act
    legacyOrderServiceImpl.updateItemQuantity(order, item, true);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertTrue(order.getOrderItems().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) OrderItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder_thenOrderImplOrderItemsSizeIsOne()
      throws ItemNotFoundException, PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(1);

    // Act
    legacyOrderServiceImpl.updateItemQuantity(order, item, true);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertEquals(1, getResult.getQuantity());
    assertSame(orderItems, orderItems2);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code
   * order}, {@code item}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem_givenMinusOne()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(-1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, item));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then throw {@link ItemNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem_givenZero_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class, () -> legacyOrderServiceImpl.updateItemQuantity(order, item));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#setOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem_thenCallsSetOrder()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new IllegalArgumentException())
        .when(bundleOrderItemImpl)
        .setOrder(Mockito.<Order>any());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, new BundleOrderItemImpl()));
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) OrderItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem_thenOrderImplOrderItemsEmpty()
      throws ItemNotFoundException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act
    legacyOrderServiceImpl.updateItemQuantity(order, item);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertTrue(order.getOrderItems().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order},
   * {@code item}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) OrderItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem_thenOrderImplOrderItemsSizeIsOne()
      throws ItemNotFoundException, PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setId(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(1);

    // Act
    legacyOrderServiceImpl.updateItemQuantity(order, item);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertEquals(1, getResult.getQuantity());
    assertSame(orderItems, orderItems2);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItemRequestDTO)} with {@code
   * order}, {@code orderItemRequestDTO}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItemRequestDTO)"})
  public void testUpdateItemQuantityWithOrderOrderItemRequestDTO()
      throws ItemNotFoundException, PricingException {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(discreteOrderItemImpl.getId()).thenReturn(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(discreteOrderItemImpl);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(null);

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(order.getId()).thenReturn(1L);
    when(order.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Pricing Model Type");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setQuantity(0);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, orderItemRequestDTO));
    verify(order).getDiscreteOrderItems();
    verify(order).getId();
    verify(order).getOrderItems();
    verify(discreteOrderItemImpl, atLeast(1)).getId();
    verify(discreteOrderItemImpl).setQuantity(0);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItemRequestDTO)} with {@code
   * order}, {@code orderItemRequestDTO}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItemRequestDTO)"})
  public void testUpdateItemQuantityWithOrderOrderItemRequestDTO2()
      throws ItemNotFoundException, PricingException {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(discreteOrderItemImpl.getId()).thenReturn(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(discreteOrderItemImpl);

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException());
    when(order.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Pricing Model Type");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setQuantity(0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateItemQuantity(order, orderItemRequestDTO));
    verify(order).getDiscreteOrderItems();
    verify(order).getOrderItems();
    verify(discreteOrderItemImpl).getId();
    verify(discreteOrderItemImpl).setQuantity(0);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)} with {@code
   * order}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrder() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order);

    // Assert that nothing has changed
    verify(orderDao).save(isA(Order.class));
    assertTrue(order.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)} with {@code
   * order}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrder2() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order));
    verify(orderDao).save(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)} with {@code
   * order}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrder3() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    assertTrue(order.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)} with {@code
   * order}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrder4() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupDao)
        .delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with
   * {@code order}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true);

    // Assert that nothing has changed
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertTrue(order.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with
   * {@code order}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder2()
      throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with
   * {@code order}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder3()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertTrue(order.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with
   * {@code order}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder4()
      throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupDao)
        .delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with
   * {@code order}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder5()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with
   * {@code order}, {@code priceOrder}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder_whenFalse()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, false);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    assertTrue(order.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)}
   * with {@code order}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)"
  })
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroup()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl());

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)}
   * with {@code order}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)"
  })
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroup2()
      throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupDao)
        .delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(
                order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)}
   * with {@code order}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)"
  })
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroup3()
      throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(
                order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)}
   * with {@code order}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order,
   * FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)"
  })
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroup4()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(
                order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup,
   * boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)"
  })
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroupPriceOrder()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl(), true);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup,
   * boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)"
  })
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroupPriceOrder2()
      throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupDao)
        .delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(
                order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup,
   * boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)"
  })
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroupPriceOrder3()
      throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(
                order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup,
   * boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)"
  })
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroupPriceOrder4()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(
                order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup,
   * boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order,
   * FulfillmentGroup, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)"
  })
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroupPriceOrder_whenFalse()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(
        order, new FulfillmentGroupImpl(), false);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeNamedOrderForCustomer(String, Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderDao#delete(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeNamedOrderForCustomer(String,
   * Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeNamedOrderForCustomer(String, Customer)"})
  public void testRemoveNamedOrderForCustomer_thenCallsDelete() {
    // Arrange
    when(orderDao.readNamedOrderForCustomer(Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new NullOrderImpl());
    doNothing().when(orderDao).delete(Mockito.<Order>any());

    // Act
    legacyOrderServiceImpl.removeNamedOrderForCustomer("Name", new CustomerImpl());

    // Assert
    verify(orderDao).delete(isA(Order.class));
    verify(orderDao).readNamedOrderForCustomer(isA(Customer.class), eq("Name"));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeNamedOrderForCustomer(String, Customer)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeNamedOrderForCustomer(String,
   * Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeNamedOrderForCustomer(String, Customer)"})
  public void testRemoveNamedOrderForCustomer_thenThrowIllegalArgumentException() {
    // Arrange
    when(orderDao.readNamedOrderForCustomer(Mockito.<Customer>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeNamedOrderForCustomer("Name", new CustomerImpl()));
    verify(orderDao).readNamedOrderForCustomer(isA(Customer.class), eq("Name"));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List LegacyOrderServiceImpl.readPaymentInfosForOrder(Order)"})
  public void testReadPaymentInfosForOrder_thenReturnEmpty() {
    // Arrange
    when(orderPaymentDao.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    List<OrderPayment> actualReadPaymentInfosForOrderResult =
        legacyOrderServiceImpl.readPaymentInfosForOrder(new NullOrderImpl());

    // Assert
    verify(orderPaymentDao).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualReadPaymentInfosForOrderResult.isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List LegacyOrderServiceImpl.readPaymentInfosForOrder(Order)"})
  public void testReadPaymentInfosForOrder_thenThrowIllegalArgumentException() {
    // Arrange
    when(orderPaymentDao.readPaymentsForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.readPaymentInfosForOrder(new NullOrderImpl()));
    verify(orderPaymentDao).readPaymentsForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with
   * {@code item1}, {@code item2}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"
  })
  public void testItemMatchesWithItem1Item2() {
    // Arrange
    DiscreteOrderItemImpl item1 = new DiscreteOrderItemImpl();
    item1.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.itemMatches(item1, new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with
   * {@code item1}, {@code item2}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"
  })
  public void testItemMatchesWithItem1Item2_givenSkuImplGetIdReturnOne_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    DiscreteOrderItem item1 = mock(DiscreteOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);

    DiscreteOrderItem item2 = mock(DiscreteOrderItem.class);
    when(item2.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualItemMatchesResult = legacyOrderServiceImpl.itemMatches(item1, item2);

    // Assert
    verify(skuImpl).getId();
    verify(item1, atLeast(1)).getSku();
    verify(item2, atLeast(1)).getSku();
    assertFalse(actualItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with
   * {@code item1}, {@code item2}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"
  })
  public void testItemMatchesWithItem1Item2_givenSkuImplGetIdReturnOne_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    DiscreteOrderItem item1 = mock(DiscreteOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);

    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getId()).thenReturn(1L);

    DiscreteOrderItem item2 = mock(DiscreteOrderItem.class);
    when(item2.getSku()).thenReturn(skuImpl2);

    // Act
    boolean actualItemMatchesResult = legacyOrderServiceImpl.itemMatches(item1, item2);

    // Assert
    verify(skuImpl).getId();
    verify(skuImpl2).getId();
    verify(item1, atLeast(1)).getSku();
    verify(item2, atLeast(1)).getSku();
    assertTrue(actualItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with
   * {@code item1}, {@code item2}.
   *
   * <ul>
   *   <li>Then calls {@link DiscreteOrderItem#getProduct()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"
  })
  public void testItemMatchesWithItem1Item2_thenCallsGetProduct() {
    // Arrange
    DiscreteOrderItem item1 = mock(DiscreteOrderItem.class);
    when(item1.getProduct()).thenReturn(new ProductBundleImpl());
    when(item1.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualItemMatchesResult =
        legacyOrderServiceImpl.itemMatches(item1, new DiscreteOrderItemImpl());

    // Assert
    verify(item1).getProduct();
    verify(item1).getSku();
    assertFalse(actualItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with
   * {@code item1}, {@code item2}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"
  })
  public void testItemMatchesWithItem1Item2_thenThrowIllegalArgumentException() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenThrow(new IllegalArgumentException());

    DiscreteOrderItem item1 = mock(DiscreteOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);

    DiscreteOrderItem item2 = mock(DiscreteOrderItem.class);
    when(item2.getSku()).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> legacyOrderServiceImpl.itemMatches(item1, item2));
    verify(skuImpl).getId();
    verify(item2).getSku();
    verify(item1, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with
   * {@code item1}, {@code item2}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"
  })
  public void testItemMatchesWithItem1Item2_thenThrowIllegalArgumentException2() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    DiscreteOrderItem item1 = mock(DiscreteOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);

    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getId()).thenThrow(new IllegalArgumentException());

    DiscreteOrderItem item2 = mock(DiscreteOrderItem.class);
    when(item2.getSku()).thenReturn(skuImpl2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> legacyOrderServiceImpl.itemMatches(item1, item2));
    verify(skuImpl).getId();
    verify(skuImpl2).getId();
    verify(item1, atLeast(1)).getSku();
    verify(item2, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with
   * {@code item1}, {@code item2}.
   *
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"
  })
  public void testItemMatchesWithItem1Item2_whenDiscreteOrderItemImpl_thenReturnFalse() {
    // Arrange
    DiscreteOrderItemImpl item1 = new DiscreteOrderItemImpl();

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.itemMatches(item1, new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingDiscreteItem(Order, DiscreteOrderItem)"
  })
  public void testFindMatchingDiscreteItem_givenArrayListAddBundleOrderItemImpl_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingDiscreteItem(order, new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingDiscreteItem(Order, DiscreteOrderItem)"
  })
  public void testFindMatchingDiscreteItem_givenArrayListAddDiscreteOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingDiscreteItem(order, new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingDiscreteItem(Order, DiscreteOrderItem)"
  })
  public void testFindMatchingDiscreteItem_givenAuditableCreatedByIsOne_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(new ArrayList<>());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingDiscreteItem(order, new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order,
   * DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingDiscreteItem(Order, DiscreteOrderItem)"
  })
  public void testFindMatchingDiscreteItem_givenOrderItemImplAuditableIsAuditable() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingDiscreteItem(order, new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"
  })
  public void testBundleItemMatches() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenThrow(new IllegalArgumentException());
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl item1 = new BundleOrderItemImpl();
    item1.setAuditable(auditable);
    item1.setBaseRetailPrice(new Money());
    item1.setBaseSalePrice(new Money());
    item1.setBundleOrderItemFeePrices(new ArrayList<>());
    item1.setCandidateItemOffers(new ArrayList<>());
    item1.setCartMessages(new ArrayList<>());
    item1.setChildOrderItems(new ArrayList<>());
    item1.setDiscountingAllowed(true);
    item1.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item1.setHasValidationError(true);
    item1.setId(1L);
    item1.setName("Name");
    item1.setOrder(new NullOrderImpl());
    item1.setOrderItemAdjustments(new ArrayList<>());
    item1.setOrderItemAttributes(new HashMap<>());
    item1.setOrderItemPriceDetails(new ArrayList<>());
    item1.setOrderItemQualifiers(new ArrayList<>());
    item1.setOrderItemType(OrderItemType.BASIC);
    item1.setParentOrderItem(new BundleOrderItemImpl());
    item1.setPersonalMessage(new PersonalMessageImpl());
    item1.setPrice(new Money());
    item1.setProratedOrderItemAdjustments(new ArrayList<>());
    item1.setQuantity(1);
    item1.setRetailPrice(new Money());
    item1.setRetailPriceOverride(true);
    item1.setSalePrice(new Money());
    item1.setSalePriceOverride(true);
    item1.setTaxable(true);
    item1.updateSaleAndRetailPrices();
    item1.setDiscreteOrderItems(discreteOrderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems2 = new ArrayList<>();
    discreteOrderItems2.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl item2 = new BundleOrderItemImpl();
    item2.setAuditable(auditable2);
    item2.setBaseRetailPrice(new Money());
    item2.setBaseSalePrice(new Money());
    item2.setBundleOrderItemFeePrices(new ArrayList<>());
    item2.setCandidateItemOffers(new ArrayList<>());
    item2.setCartMessages(new ArrayList<>());
    item2.setChildOrderItems(new ArrayList<>());
    item2.setDiscountingAllowed(true);
    item2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item2.setHasValidationError(true);
    item2.setId(1L);
    item2.setName("Name");
    item2.setOrder(new NullOrderImpl());
    item2.setOrderItemAdjustments(new ArrayList<>());
    item2.setOrderItemAttributes(new HashMap<>());
    item2.setOrderItemPriceDetails(new ArrayList<>());
    item2.setOrderItemQualifiers(new ArrayList<>());
    item2.setOrderItemType(OrderItemType.BASIC);
    item2.setParentOrderItem(new BundleOrderItemImpl());
    item2.setPersonalMessage(new PersonalMessageImpl());
    item2.setPrice(new Money());
    item2.setProratedOrderItemAdjustments(new ArrayList<>());
    item2.setQuantity(1);
    item2.setRetailPrice(new Money());
    item2.setRetailPriceOverride(true);
    item2.setSalePrice(new Money());
    item2.setSalePriceOverride(true);
    item2.setTaxable(true);
    item2.updateSaleAndRetailPrices();
    item2.setDiscreteOrderItems(discreteOrderItems2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.bundleItemMatches(item1, item2));
    verify(discreteOrderItemImpl, atLeast(1)).getSku();
    verify(discreteOrderItemImpl).getQuantity();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl}.
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"
  })
  public void testBundleItemMatches_givenSkuImpl_thenCallsGetId() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenThrow(new IllegalArgumentException());

    BundleOrderItem item1 = mock(BundleOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);

    BundleOrderItem item2 = mock(BundleOrderItem.class);
    when(item2.getSku()).thenReturn(mock(SkuImpl.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.bundleItemMatches(item1, item2));
    verify(skuImpl).getId();
    verify(item2).getSku();
    verify(item1, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItem#getDiscreteOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"
  })
  public void testBundleItemMatches_thenCallsGetDiscreteOrderItems() {
    // Arrange
    BundleOrderItem item1 = mock(BundleOrderItem.class);
    when(item1.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(item1.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualBundleItemMatchesResult =
        legacyOrderServiceImpl.bundleItemMatches(item1, new BundleOrderItemImpl());

    // Assert
    verify(item1).getDiscreteOrderItems();
    verify(item1).getSku();
    assertTrue(actualBundleItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   *
   * <ul>
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"
  })
  public void testBundleItemMatches_thenCallsGetId() {
    // Arrange
    BundleOrderItem item1 = mock(BundleOrderItem.class);
    when(item1.getSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenThrow(new IllegalArgumentException());

    BundleOrderItem item2 = mock(BundleOrderItem.class);
    when(item2.getSku()).thenReturn(skuImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.bundleItemMatches(item1, item2));
    verify(skuImpl).getId();
    verify(item1, atLeast(1)).getSku();
    verify(item2, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   *
   * <ul>
   *   <li>Then calls {@link DiscreteOrderItemImpl#getSku()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"
  })
  public void testBundleItemMatches_thenCallsGetSku() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl item1 = new BundleOrderItemImpl();
    item1.setAuditable(auditable);
    item1.setBaseRetailPrice(new Money());
    item1.setBaseSalePrice(new Money());
    item1.setBundleOrderItemFeePrices(new ArrayList<>());
    item1.setCandidateItemOffers(new ArrayList<>());
    item1.setCartMessages(new ArrayList<>());
    item1.setChildOrderItems(new ArrayList<>());
    item1.setDiscountingAllowed(true);
    item1.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item1.setHasValidationError(true);
    item1.setId(1L);
    item1.setName("Name");
    item1.setOrder(new NullOrderImpl());
    item1.setOrderItemAdjustments(new ArrayList<>());
    item1.setOrderItemAttributes(new HashMap<>());
    item1.setOrderItemPriceDetails(new ArrayList<>());
    item1.setOrderItemQualifiers(new ArrayList<>());
    item1.setOrderItemType(OrderItemType.BASIC);
    item1.setParentOrderItem(new BundleOrderItemImpl());
    item1.setPersonalMessage(new PersonalMessageImpl());
    item1.setPrice(new Money());
    item1.setProratedOrderItemAdjustments(new ArrayList<>());
    item1.setQuantity(1);
    item1.setRetailPrice(new Money());
    item1.setRetailPriceOverride(true);
    item1.setSalePrice(new Money());
    item1.setSalePriceOverride(true);
    item1.setTaxable(true);
    item1.updateSaleAndRetailPrices();
    item1.setDiscreteOrderItems(discreteOrderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl2 = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl2.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl2.getSku()).thenReturn(new SkuImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems2 = new ArrayList<>();
    discreteOrderItems2.add(discreteOrderItemImpl2);

    BundleOrderItemImpl item2 = new BundleOrderItemImpl();
    item2.setAuditable(auditable2);
    item2.setBaseRetailPrice(new Money());
    item2.setBaseSalePrice(new Money());
    item2.setBundleOrderItemFeePrices(new ArrayList<>());
    item2.setCandidateItemOffers(new ArrayList<>());
    item2.setCartMessages(new ArrayList<>());
    item2.setChildOrderItems(new ArrayList<>());
    item2.setDiscountingAllowed(true);
    item2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item2.setHasValidationError(true);
    item2.setId(1L);
    item2.setName("Name");
    item2.setOrder(new NullOrderImpl());
    item2.setOrderItemAdjustments(new ArrayList<>());
    item2.setOrderItemAttributes(new HashMap<>());
    item2.setOrderItemPriceDetails(new ArrayList<>());
    item2.setOrderItemQualifiers(new ArrayList<>());
    item2.setOrderItemType(OrderItemType.BASIC);
    item2.setParentOrderItem(new BundleOrderItemImpl());
    item2.setPersonalMessage(new PersonalMessageImpl());
    item2.setPrice(new Money());
    item2.setProratedOrderItemAdjustments(new ArrayList<>());
    item2.setQuantity(1);
    item2.setRetailPrice(new Money());
    item2.setRetailPriceOverride(true);
    item2.setSalePrice(new Money());
    item2.setSalePriceOverride(true);
    item2.setTaxable(true);
    item2.updateSaleAndRetailPrices();
    item2.setDiscreteOrderItems(discreteOrderItems2);

    // Act
    boolean actualBundleItemMatchesResult = legacyOrderServiceImpl.bundleItemMatches(item1, item2);

    // Assert
    verify(discreteOrderItemImpl, atLeast(1)).getSku();
    verify(discreteOrderItemImpl2, atLeast(1)).getSku();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl2).getQuantity();
    assertTrue(actualBundleItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   *
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"
  })
  public void testBundleItemMatches_whenBundleOrderItemImpl_thenReturnTrue() {
    // Arrange
    BundleOrderItemImpl item1 = new BundleOrderItemImpl();

    // Act and Assert
    assertTrue(legacyOrderServiceImpl.bundleItemMatches(item1, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"
  })
  public void testFindMatchingBundleItem() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenThrow(new IllegalArgumentException());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.findMatchingBundleItem(order, new BundleOrderItemImpl()));
    verify(bundleOrderItemImpl).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"
  })
  public void testFindMatchingBundleItem_givenArrayListAddDiscreteOrderItemImpl_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingBundleItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"
  })
  public void testFindMatchingBundleItem_givenSkuImplGetIdReturnOne_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    BundleOrderItemImpl itemToFind = mock(BundleOrderItemImpl.class);
    when(itemToFind.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItem actualFindMatchingBundleItemResult =
        legacyOrderServiceImpl.findMatchingBundleItem(order, itemToFind);

    // Assert
    verify(skuImpl).getId();
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
    verify(itemToFind, atLeast(1)).getSku();
    assertNull(actualFindMatchingBundleItemResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"
  })
  public void testFindMatchingBundleItem_givenSkuImplGetIdThrowIllegalArgumentException() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenThrow(new IllegalArgumentException());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    BundleOrderItemImpl itemToFind = mock(BundleOrderItemImpl.class);
    when(itemToFind.getSku()).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.findMatchingBundleItem(order, itemToFind));
    verify(skuImpl).getId();
    verify(itemToFind).getSku();
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"
  })
  public void testFindMatchingBundleItem_thenCallsGetDiscreteOrderItems() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    legacyOrderServiceImpl.findMatchingBundleItem(order, new BundleOrderItemImpl());

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   *
   * <ul>
   *   <li>Then return {@link BundleOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"
  })
  public void testFindMatchingBundleItem_thenReturnBundleOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertSame(
        bundleOrderItemImpl,
        legacyOrderServiceImpl.findMatchingBundleItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   *
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link
   *       SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"
  })
  public void testFindMatchingBundleItem_whenBundleOrderItemImplGetSkuReturnSkuImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getId()).thenThrow(new IllegalArgumentException());

    BundleOrderItemImpl itemToFind = mock(BundleOrderItemImpl.class);
    when(itemToFind.getSku()).thenReturn(skuImpl2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.findMatchingBundleItem(order, itemToFind));
    verify(skuImpl).getId();
    verify(skuImpl2).getId();
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
    verify(itemToFind, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   *
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order,
   * BundleOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"
  })
  public void testFindMatchingBundleItem_whenBundleOrderItemImpl_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingBundleItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenThrow(new IllegalArgumentException());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl()));
    verify(orderItem).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem2() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenThrow(new IllegalArgumentException());

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(skuImpl);

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);

    BundleOrderItemImpl itemToFind = mock(BundleOrderItemImpl.class);
    when(itemToFind.getSku()).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.findMatchingItem(order, itemToFind));
    verify(skuImpl).getId();
    verify(itemToFind).getSku();
    verify(orderItem, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem3() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(skuImpl);

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);

    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getId()).thenThrow(new IllegalArgumentException());

    BundleOrderItemImpl itemToFind = mock(BundleOrderItemImpl.class);
    when(itemToFind.getSku()).thenReturn(skuImpl2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.findMatchingItem(order, itemToFind));
    verify(skuImpl).getId();
    verify(skuImpl2).getId();
    verify(orderItem, atLeast(1)).getSku();
    verify(itemToFind, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_givenBundleOrderItemImpl() {
    // Arrange
    OrderImpl order = new OrderImpl();
    order.addOrderItem(mock(BundleOrderItemImpl.class));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl itemToFind = new OrderItemImpl();
    itemToFind.setAuditable(auditable);
    itemToFind.setCandidateItemOffers(new ArrayList<>());
    itemToFind.setCartMessages(new ArrayList<>());
    itemToFind.setChildOrderItems(new ArrayList<>());
    itemToFind.setDiscountingAllowed(true);
    itemToFind.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    itemToFind.setHasValidationError(true);
    itemToFind.setId(1L);
    itemToFind.setName("Name");
    itemToFind.setOrder(new NullOrderImpl());
    itemToFind.setOrderItemAdjustments(new ArrayList<>());
    itemToFind.setOrderItemAttributes(new HashMap<>());
    itemToFind.setOrderItemPriceDetails(new ArrayList<>());
    itemToFind.setOrderItemQualifiers(new ArrayList<>());
    itemToFind.setOrderItemType(OrderItemType.BASIC);
    itemToFind.setParentOrderItem(new BundleOrderItemImpl());
    itemToFind.setPersonalMessage(new PersonalMessageImpl());
    itemToFind.setPrice(new Money());
    itemToFind.setProratedOrderItemAdjustments(new ArrayList<>());
    itemToFind.setQuantity(1);
    itemToFind.setRetailPrice(new Money());
    itemToFind.setRetailPriceOverride(true);
    itemToFind.setSalePrice(new Money());
    itemToFind.setSalePriceOverride(true);
    itemToFind.setTaxable(true);
    itemToFind.updateSaleAndRetailPrices();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingItem(order, itemToFind));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_givenDiscreteOrderItemImpl() {
    // Arrange
    OrderImpl order = new OrderImpl();
    order.addOrderItem(new DiscreteOrderItemImpl());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_givenSkuImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(skuImpl);

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);

    BundleOrderItemImpl itemToFind = mock(BundleOrderItemImpl.class);
    when(itemToFind.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItem actualFindMatchingItemResult =
        legacyOrderServiceImpl.findMatchingItem(order, itemToFind);

    // Assert
    verify(skuImpl).getId();
    verify(orderItem, atLeast(1)).getSku();
    verify(itemToFind, atLeast(1)).getSku();
    assertNull(actualFindMatchingItemResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_thenCallsGetDiscreteOrderItems() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(orderItem.getSku()).thenReturn(new SkuImpl());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);

    // Act
    legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl());

    // Assert
    verify(orderItem).getDiscreteOrderItems();
    verify(orderItem).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <ul>
   *   <li>Then return {@link BundleOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_thenReturnBundleOrderItemImpl() {
    // Arrange
    OrderImpl order = new OrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    order.addOrderItem(orderItem);

    // Act and Assert
    assertSame(
        orderItem, legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_whenDiscreteOrderItemImpl() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getDiscreteOrderItems()).thenReturn(new ArrayList<>());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);

    // Act
    OrderItem actualFindMatchingItemResult =
        legacyOrderServiceImpl.findMatchingItem(order, new DiscreteOrderItemImpl());

    // Assert
    verify(orderItem).getDiscreteOrderItems();
    assertNull(actualFindMatchingItemResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order},
   * {@code OrderItem}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_whenOrderImpl_thenReturnNull() {
    // Arrange
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem,
   * DiscreteOrderItem, boolean)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order,
   * BundleOrderItem, DiscreteOrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)"
  })
  public void testAddOrderItemToBundle() throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundle = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addOrderItemToBundle(
                order, bundle, new DiscreteOrderItemImpl(), true));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem,
   * DiscreteOrderItem, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderDao#save(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order,
   * BundleOrderItem, DiscreteOrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)"
  })
  public void testAddOrderItemToBundle_thenCallsSave() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundle = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addOrderItemToBundle(
                order, bundle, new DiscreteOrderItemImpl(), true));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order, OrderItem, Map,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order,
   * OrderItem, Map, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)"
  })
  public void testAddOrUpdateOrderItemAttributes_thenReturnOrderImpl()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act
    Order actualAddOrUpdateOrderItemAttributesResult =
        legacyOrderServiceImpl.addOrUpdateOrderItemAttributes(order, item, new HashMap<>(), true);

    // Assert
    assertSame(order, actualAddOrUpdateOrderItemAttributesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order, OrderItem, Map,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order,
   * OrderItem, Map, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)"
  })
  public void testAddOrUpdateOrderItemAttributes_thenThrowIllegalArgumentException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getOrderItemAttributes()).thenThrow(new IllegalArgumentException());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addOrUpdateOrderItemAttributes(
                order, item, new HashMap<>(), true));
    verify(bundleOrderItemImpl).getOrderItemAttributes();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order, OrderItem, Map,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order,
   * OrderItem, Map, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)"
  })
  public void testAddOrUpdateOrderItemAttributes_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () ->
            legacyOrderServiceImpl.addOrUpdateOrderItemAttributes(
                order, item, new HashMap<>(), true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.removeOrderItemAttribute(Order, OrderItem, String, boolean)"
  })
  public void testRemoveOrderItemAttribute_thenReturnOrderImpl()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act
    Order actualRemoveOrderItemAttributeResult =
        legacyOrderServiceImpl.removeOrderItemAttribute(
            order, new BundleOrderItemImpl(), "Attribute Name", true);

    // Assert
    assertSame(order, actualRemoveOrderItemAttributeResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.removeOrderItemAttribute(Order, OrderItem, String, boolean)"
  })
  public void testRemoveOrderItemAttribute_thenThrowIllegalArgumentException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getOrderItemAttributes()).thenThrow(new IllegalArgumentException());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.removeOrderItemAttribute(
                order, new BundleOrderItemImpl(), "Attribute Name", true));
    verify(bundleOrderItemImpl).getOrderItemAttributes();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.removeOrderItemAttribute(Order, OrderItem, String, boolean)"
  })
  public void testRemoveOrderItemAttribute_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());

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
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        ItemNotFoundException.class,
        () ->
            legacyOrderServiceImpl.removeOrderItemAttribute(
                order, new BundleOrderItemImpl(), "Attribute Name", true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.createDefaultFulfillmentGroup(Order, Address)"
  })
  public void testCreateDefaultFulfillmentGroup() {
    // Arrange
    when(fulfillmentGroupService.createEmptyFulfillmentGroup())
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setPrimary(false);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDefaultFulfillmentGroup(order, new AddressImpl()));
    verify(fulfillmentGroupService).createEmptyFulfillmentGroup();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.createDefaultFulfillmentGroup(Order, Address)"
  })
  public void testCreateDefaultFulfillmentGroup2() {
    // Arrange
    when(fulfillmentGroupService.createEmptyFulfillmentGroup())
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setPrimary(false);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDefaultFulfillmentGroup(order, new AddressImpl()));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupService).createEmptyFulfillmentGroup();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.createDefaultFulfillmentGroup(Order, Address)"
  })
  public void testCreateDefaultFulfillmentGroup3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    FulfillmentOptionImpl fulfillmentOption = new FulfillmentOptionImpl();
    fulfillmentGroupImpl.setFulfillmentOption(fulfillmentOption);
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    NullOrderImpl order = new NullOrderImpl();
    fulfillmentGroupImpl.setOrder(order);
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    fulfillmentGroupImpl.setPersonalMessage(personalMessage);
    PhoneImpl phone = new PhoneImpl();
    fulfillmentGroupImpl.setPhone(phone);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setPrimary(true);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order2 = new OrderImpl();
    order2.setAdditionalOfferInformation(new HashMap<>());
    order2.setAuditable(auditable);
    order2.setCandidateOrderOffers(new ArrayList<>());
    order2.setCurrency(new BroadleafCurrencyImpl());
    order2.setCustomer(new CustomerImpl());
    order2.setEmailAddress("42 Main St");
    order2.setId(1L);
    order2.setLocale(new LocaleImpl());
    order2.setName("Name");
    order2.setOrderAttributes(new HashMap<>());
    order2.setOrderMessages(new ArrayList<>());
    order2.setOrderNumber("42");
    order2.setPayments(new ArrayList<>());
    order2.setStatus(OrderStatus.ARCHIVED);
    Money subTotal = new Money();
    order2.setSubTotal(subTotal);
    order2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order2.setTaxOverride(true);
    order2.setTotal(new Money());
    order2.setTotalFulfillmentCharges(new Money());
    order2.setTotalTax(new Money());
    order2.setFulfillmentGroups(fulfillmentGroups);
    order2.setOrderItems(orderItems);

    // Act
    FulfillmentGroup actualCreateDefaultFulfillmentGroupResult =
        legacyOrderServiceImpl.createDefaultFulfillmentGroup(order2, new AddressImpl());

    // Assert
    assertTrue(actualCreateDefaultFulfillmentGroupResult instanceof FulfillmentGroupImpl);
    FulfillmentOption fulfillmentOption2 =
        actualCreateDefaultFulfillmentGroupResult.getFulfillmentOption();
    assertTrue(fulfillmentOption2 instanceof FulfillmentOptionImpl);
    Order order3 = actualCreateDefaultFulfillmentGroupResult.getOrder();
    assertTrue(order3 instanceof NullOrderImpl);
    PersonalMessage personalMessage2 =
        actualCreateDefaultFulfillmentGroupResult.getPersonalMessage();
    assertTrue(personalMessage2 instanceof PersonalMessageImpl);
    Phone phone2 = actualCreateDefaultFulfillmentGroupResult.getPhone();
    assertTrue(phone2 instanceof PhoneImpl);
    assertEquals("42", actualCreateDefaultFulfillmentGroupResult.getReferenceNumber());
    assertEquals(
        "Delivery Instruction", actualCreateDefaultFulfillmentGroupResult.getDeliveryInstruction());
    assertEquals("Fulfillment Method", actualCreateDefaultFulfillmentGroupResult.getMethod());
    assertEquals("Service", actualCreateDefaultFulfillmentGroupResult.getService());
    assertEquals(1, actualCreateDefaultFulfillmentGroupResult.getSequence().intValue());
    assertEquals(1L, actualCreateDefaultFulfillmentGroupResult.getId().longValue());
    assertTrue(actualCreateDefaultFulfillmentGroupResult.getFulfillmentGroupItems().isEmpty());
    assertTrue(actualCreateDefaultFulfillmentGroupResult.getShippingOverride());
    assertTrue(actualCreateDefaultFulfillmentGroupResult.isShippingPriceTaxable());
    assertEquals(
        subTotal, actualCreateDefaultFulfillmentGroupResult.getFulfillmentGroupAdjustmentsValue());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getFulfillmentPrice());
    assertEquals(
        subTotal,
        actualCreateDefaultFulfillmentGroupResult
            .getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getMerchandiseTotal());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getRetailFulfillmentPrice());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getRetailShippingPrice());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getSaleFulfillmentPrice());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getSaleShippingPrice());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getShippingPrice());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getTotal());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getTotalFeeTax());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getTotalFulfillmentGroupTax());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getTotalItemTax());
    assertEquals(subTotal, actualCreateDefaultFulfillmentGroupResult.getTotalTax());
    assertSame(fulfillmentOption, fulfillmentOption2);
    assertSame(order, order3);
    assertSame(personalMessage, personalMessage2);
    assertSame(phone, phone2);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}.
   *
   * <ul>
   *   <li>Then Order return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup LegacyOrderServiceImpl.createDefaultFulfillmentGroup(Order, Address)"
  })
  public void testCreateDefaultFulfillmentGroup_thenOrderReturnOrderImpl() {
    // Arrange
    when(fulfillmentGroupService.createEmptyFulfillmentGroup())
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    AddressImpl address = new AddressImpl();
    fulfillmentGroupImpl.setAddress(address);
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setPrimary(false);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setOrderItems(orderItems);

    // Act
    FulfillmentGroup actualCreateDefaultFulfillmentGroupResult =
        legacyOrderServiceImpl.createDefaultFulfillmentGroup(order, new AddressImpl());

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupService).createEmptyFulfillmentGroup();
    assertTrue(actualCreateDefaultFulfillmentGroupResult instanceof FulfillmentGroupImpl);
    Order order2 = actualCreateDefaultFulfillmentGroupResult.getOrder();
    assertTrue(order2 instanceof OrderImpl);
    Address address2 = actualCreateDefaultFulfillmentGroupResult.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertNull(actualCreateDefaultFulfillmentGroupResult.getSequence());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getId());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getDeliveryInstruction());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getMethod());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getReferenceNumber());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getService());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getFulfillmentPrice());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getMerchandiseTotal());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getRetailFulfillmentPrice());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getRetailShippingPrice());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getSaleFulfillmentPrice());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getSaleShippingPrice());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getShippingPrice());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getTotal());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getTotalFeeTax());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getTotalFulfillmentGroupTax());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getTotalItemTax());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getTotalTax());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getFulfillmentOption());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getPersonalMessage());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getStatus());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getType());
    assertNull(actualCreateDefaultFulfillmentGroupResult.getPhone());
    assertEquals(1, actualCreateDefaultFulfillmentGroupResult.getFulfillmentGroupItems().size());
    assertFalse(actualCreateDefaultFulfillmentGroupResult.getShippingOverride());
    assertFalse(actualCreateDefaultFulfillmentGroupResult.isShippingPriceTaxable());
    assertEquals(address, address2);
    assertSame(order, order2);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.findOrderByOrderNumber(String)"})
  public void testFindOrderByOrderNumber_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderByOrderNumber(Mockito.<String>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindOrderByOrderNumberResult = legacyOrderServiceImpl.findOrderByOrderNumber("42");

    // Assert
    verify(orderDao).readOrderByOrderNumber("42");
    assertSame(nullOrderImpl, actualFindOrderByOrderNumberResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.findOrderByOrderNumber(String)"})
  public void testFindOrderByOrderNumber_thenThrowIllegalArgumentException() {
    // Arrange
    when(orderDao.readOrderByOrderNumber(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> legacyOrderServiceImpl.findOrderByOrderNumber("42"));
    verify(orderDao).readOrderByOrderNumber("42");
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} return {@link NullOrderImpl} (default
   *       constructor).
   *   <li>Then return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.updateOrder(Order, Boolean)"})
  public void testUpdateOrder_givenOrderDaoSaveReturnNullOrderImpl_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    // Act
    Order actualUpdateOrderResult = legacyOrderServiceImpl.updateOrder(new NullOrderImpl(), true);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertTrue(actualUpdateOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualUpdateOrderResult.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, actualUpdateOrderResult.getSubTotal());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.updateOrder(Order, Boolean)"})
  public void testUpdateOrder_givenOrderDaoSaveThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateOrder(new NullOrderImpl(), true));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}.
   *
   * <ul>
   *   <li>Given {@link PricingService} {@link PricingService#executePricing(Order)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.updateOrder(Order, Boolean)"})
  public void testUpdateOrder_givenPricingServiceExecutePricingThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.updateOrder(new NullOrderImpl(), true));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.updateOrder(Order, Boolean)"})
  public void testUpdateOrder_whenFalse_thenReturnNullOrderImpl() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    // Act
    Order actualUpdateOrderResult = legacyOrderServiceImpl.updateOrder(new NullOrderImpl(), false);

    // Assert
    verify(orderDao).save(isA(Order.class));
    assertTrue(actualUpdateOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualUpdateOrderResult.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, actualUpdateOrderResult.getSubTotal());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#persistOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} return {@link NullOrderImpl} (default
   *       constructor).
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#persistOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.persistOrder(Order)"})
  public void testPersistOrder_givenOrderDaoSaveReturnNullOrderImpl_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualPersistOrderResult = legacyOrderServiceImpl.persistOrder(new NullOrderImpl());

    // Assert
    verify(orderDao).save(isA(Order.class));
    assertSame(nullOrderImpl, actualPersistOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#persistOrder(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#persistOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.persistOrder(Order)"})
  public void testPersistOrder_thenThrowIllegalArgumentException() {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.persistOrder(new NullOrderImpl()));
    verify(orderDao).save(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem,
   * FulfillmentGroup, int)}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroupItem LegacyOrderServiceImpl.createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)"
  })
  public void testCreateFulfillmentGroupItemFromOrderItem_thenReturnFulfillmentGroupItemImpl() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    when(fulfillmentGroupItemDao.create()).thenReturn(fulfillmentGroupItemImpl);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    FulfillmentGroupItem actualCreateFulfillmentGroupItemFromOrderItemResult =
        legacyOrderServiceImpl.createFulfillmentGroupItemFromOrderItem(
            orderItem, new FulfillmentGroupImpl(), 1);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    assertSame(fulfillmentGroupItemImpl, actualCreateFulfillmentGroupItemFromOrderItemResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem,
   * FulfillmentGroup, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroupItem LegacyOrderServiceImpl.createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)"
  })
  public void testCreateFulfillmentGroupItemFromOrderItem_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.createFulfillmentGroupItemFromOrderItem(
                orderItem, new FulfillmentGroupImpl(), 1));
    verify(fulfillmentGroupItemDao).create();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeOrderItemFromFullfillmentGroup(Order, OrderItem)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeOrderItemFromFullfillmentGroup(Order,
   * OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeOrderItemFromFullfillmentGroup(Order, OrderItem)"
  })
  public void testRemoveOrderItemFromFullfillmentGroup() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable2);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    // Act
    legacyOrderServiceImpl.removeOrderItemFromFullfillmentGroup(order, orderItem);

    // Assert that nothing has changed
    verify(fulfillmentGroupItemImpl, atLeast(1)).getOrderItem();
    List<FulfillmentGroup> fulfillmentGroups2 = order.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    List<FulfillmentGroupItem> fulfillmentGroupItems2 = getResult.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems2.size());
    assertTrue(getResult.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItems, fulfillmentGroupItems2);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeOrderItemFromFullfillmentGroup(Order, OrderItem)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeOrderItemFromFullfillmentGroup(Order,
   * OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeOrderItemFromFullfillmentGroup(Order, OrderItem)"
  })
  public void testRemoveOrderItemFromFullfillmentGroup2() {
    // Arrange
    doNothing().when(fulfillmentGroupItemDao).delete(Mockito.<FulfillmentGroupItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new DiscreteOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable2);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    // Act
    legacyOrderServiceImpl.removeOrderItemFromFullfillmentGroup(order, orderItem);

    // Assert
    verify(fulfillmentGroupItemDao).delete(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemImpl, atLeast(1)).getOrderItem();
    List<FulfillmentGroup> fulfillmentGroups2 = order.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(getResult.getDiscreteOrderItems().isEmpty());
    assertTrue(getResult.getFulfillmentGroupItems().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeOrderItemFromFullfillmentGroup(Order, OrderItem)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#removeOrderItemFromFullfillmentGroup(Order,
   * OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOrderServiceImpl.removeOrderItemFromFullfillmentGroup(Order, OrderItem)"
  })
  public void testRemoveOrderItemFromFullfillmentGroup_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupItemDao)
        .delete(Mockito.<FulfillmentGroupItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new DiscreteOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable2);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeOrderItemFromFullfillmentGroup(order, orderItem));
    verify(fulfillmentGroupItemDao).delete(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemImpl, atLeast(1)).getOrderItem();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}.
   *
   * <ul>
   *   <li>Then return DiscreteOrderItems is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItemRequest LegacyOrderServiceImpl.createBundleOrderItemRequest(BundleOrderItem, List)"
  })
  public void testCreateBundleOrderItemRequest_thenReturnDiscreteOrderItemsIsArrayList() {
    // Arrange
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    ArrayList<DiscreteOrderItemRequest> discreteOrderItemRequests = new ArrayList<>();
    discreteOrderItemRequests.add(new DiscreteOrderItemRequest());

    // Act and Assert
    assertSame(
        discreteOrderItemRequests,
        legacyOrderServiceImpl
            .createBundleOrderItemRequest(bundleOrderItem, discreteOrderItemRequests)
            .getDiscreteOrderItems());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}.
   *
   * <ul>
   *   <li>Then return DiscreteOrderItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItemRequest LegacyOrderServiceImpl.createBundleOrderItemRequest(BundleOrderItem, List)"
  })
  public void testCreateBundleOrderItemRequest_thenReturnDiscreteOrderItemsSizeIsTwo() {
    // Arrange
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    ArrayList<DiscreteOrderItemRequest> discreteOrderItemRequests = new ArrayList<>();
    discreteOrderItemRequests.add(new DiscreteOrderItemRequest());
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequests.add(discreteOrderItemRequest);

    // Act and Assert
    List<DiscreteOrderItemRequest> discreteOrderItems =
        legacyOrderServiceImpl
            .createBundleOrderItemRequest(bundleOrderItem, discreteOrderItemRequests)
            .getDiscreteOrderItems();
    assertEquals(2, discreteOrderItems.size());
    assertSame(discreteOrderItemRequest, discreteOrderItems.get(1));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItemRequest LegacyOrderServiceImpl.createBundleOrderItemRequest(BundleOrderItem, List)"
  })
  public void testCreateBundleOrderItemRequest_whenArrayList_thenReturnNameIsNull() {
    // Arrange
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    // Act
    BundleOrderItemRequest actualCreateBundleOrderItemRequestResult =
        legacyOrderServiceImpl.createBundleOrderItemRequest(bundleOrderItem, new ArrayList<>());

    // Assert
    assertNull(actualCreateBundleOrderItemRequestResult.getName());
    assertNull(actualCreateBundleOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateBundleOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateBundleOrderItemRequestResult.getCategory());
    assertNull(actualCreateBundleOrderItemRequestResult.getOrder());
    assertEquals(0, actualCreateBundleOrderItemRequestResult.getQuantity());
    assertTrue(actualCreateBundleOrderItemRequestResult.getBundleOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateBundleOrderItemRequestResult.getDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.validateOrder(Long)"})
  public void testValidateOrder_givenOrderDaoReadOrderByIdReturnNull() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.validateOrder(1L));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.validateOrder(Long)"})
  public void testValidateOrder_givenOrderDaoReadOrderByIdThrowIllegalArgumentException() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.validateOrder(1L));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.validateOrder(Long)"})
  public void testValidateOrder_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualValidateOrderResult = legacyOrderServiceImpl.validateOrder(1L);

    // Assert
    verify(orderDao).readOrderById(1L);
    assertSame(nullOrderImpl, actualValidateOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.validateOrder(Long)"})
  public void testValidateOrder_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.validateOrder(null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   *
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product LegacyOrderServiceImpl.validateProduct(Long)"})
  public void testValidateProduct_givenProductDaoReadProductByIdReturnNull() {
    // Arrange
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.validateProduct(1L));
    verify(productDao).readProductById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   *
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product LegacyOrderServiceImpl.validateProduct(Long)"})
  public void testValidateProduct_givenProductDaoReadProductByIdThrowIllegalArgumentException() {
    // Arrange
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.validateProduct(1L));
    verify(productDao).readProductById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   *
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product LegacyOrderServiceImpl.validateProduct(Long)"})
  public void testValidateProduct_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act
    Product actualValidateProductResult = legacyOrderServiceImpl.validateProduct(1L);

    // Assert
    verify(productDao).readProductById(1L);
    assertSame(productBundleImpl, actualValidateProductResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product LegacyOrderServiceImpl.validateProduct(Long)"})
  public void testValidateProduct_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.validateProduct(null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   *
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category LegacyOrderServiceImpl.determineCategory(Product, Long)"
  })
  public void testDetermineCategory_thenReturnCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualDetermineCategoryResult =
        legacyOrderServiceImpl.determineCategory(new ProductBundleImpl(), 1L);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    assertSame(categoryImpl, actualDetermineCategoryResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category LegacyOrderServiceImpl.determineCategory(Product, Long)"
  })
  public void testDetermineCategory_thenThrowIllegalArgumentException() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.determineCategory(new ProductBundleImpl(), 1L));
    verify(categoryDao).readCategoryById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category LegacyOrderServiceImpl.determineCategory(Product, Long)"
  })
  public void testDetermineCategory_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.determineCategory(null, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category LegacyOrderServiceImpl.determineCategory(Product, Long)"
  })
  public void testDetermineCategory_whenNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.determineCategory(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuDao} {@link SkuDao#readSkuById(Long)} return {@code null}.
   *   <li>Then calls {@link Product#getAdditionalSkus()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.determineSku(Product, Long, Map)"})
  public void testDetermineSku_givenSkuDaoReadSkuByIdReturnNull_thenCallsGetAdditionalSkus() {
    // Arrange
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    Product product = mock(Product.class);
    when(product.getAdditionalSkus()).thenReturn(null);
    when(product.getProductOptions()).thenReturn(null);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    Sku actualDetermineSkuResult =
        legacyOrderServiceImpl.determineSku(product, 1L, new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(1L);
    verify(product).getAdditionalSkus();
    verify(product).getDefaultSku();
    verify(product).getProductOptions();
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    Money actualAbsResult = margin.abs();
    assertEquals(margin, actualAbsResult);
    Money actualZeroResult = margin.zero();
    assertEquals(margin, actualZeroResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuDao} {@link SkuDao#readSkuById(Long)} return {@link SkuImpl} (default
   *       constructor).
   *   <li>Then calls {@link Product#getProductOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.determineSku(Product, Long, Map)"})
  public void testDetermineSku_givenSkuDaoReadSkuByIdReturnSkuImpl_thenCallsGetProductOptions() {
    // Arrange
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    Product product = mock(Product.class);
    when(product.getProductOptions()).thenReturn(null);

    // Act
    Sku actualDetermineSkuResult =
        legacyOrderServiceImpl.determineSku(product, 1L, new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(1L);
    verify(product).getProductOptions();
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    Money actualAbsResult = margin.abs();
    assertEquals(margin, actualAbsResult);
    Money actualZeroResult = margin.zero();
    assertEquals(margin, actualZeroResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuDao} {@link SkuDao#readSkuById(Long)} return {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.determineSku(Product, Long, Map)"})
  public void testDetermineSku_givenSkuDaoReadSkuByIdReturnSkuImpl_thenReturnSkuImpl() {
    // Arrange
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    Sku actualDetermineSkuResult =
        legacyOrderServiceImpl.determineSku(product, 1L, new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(1L);
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    Money actualAbsResult = margin.abs();
    assertEquals(margin, actualAbsResult);
    Money actualZeroResult = margin.zero();
    assertEquals(margin, actualZeroResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.determineSku(Product, Long, Map)"})
  public void testDetermineSku_thenThrowIllegalArgumentException() {
    // Arrange
    when(skuDao.readSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.determineSku(product, 1L, new HashMap<>()));
    verify(skuDao).readSkuById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.determineSku(Product, Long, Map)"})
  public void testDetermineSku_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.determineSku(null, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.determineSku(Product, Long, Map)"})
  public void testDetermineSku_whenNull_thenReturnNull2() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.determineSku(product, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SkuImpl} (default constructor).
   *   <li>Then calls {@link ProductOptionImpl#getAttributeName()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_givenArrayListAddSkuImpl_thenCallsGetAttributeName() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");
    when(productOptionImpl.getRequired()).thenReturn(true);

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(skuList);
    when(product.getProductOptions()).thenReturn(productOptionList);

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult =
        legacyOrderServiceImpl.findMatchingSku(product, attributeValues);

    // Assert
    verify(product, atLeast(1)).getProductOptions();
    verify(product, atLeast(1)).getSkus();
    verify(productOptionImpl, atLeast(1)).getAttributeName();
    verify(productOptionImpl).getRequired();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SkuImpl} (default constructor).
   *   <li>Then calls {@link Product#getSkus()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_givenArrayListAddSkuImpl_thenCallsGetSkus() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(false);

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(skuList);
    when(product.getProductOptions()).thenReturn(productOptionList);

    // Act
    Sku actualFindMatchingSkuResult =
        legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>());

    // Assert
    verify(product, atLeast(1)).getProductOptions();
    verify(product, atLeast(1)).getSkus();
    verify(productOptionImpl).getRequired();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Product#getSkus()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_givenArrayList_thenCallsGetSkus() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(false);

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(new ArrayList<>());
    when(product.getProductOptions()).thenReturn(productOptionList);

    // Act
    Sku actualFindMatchingSkuResult =
        legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>());

    // Assert
    verify(product, atLeast(1)).getProductOptions();
    verify(product, atLeast(1)).getSkus();
    verify(productOptionImpl).getRequired();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Product} {@link Product#getProductOptions()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_givenNull_whenProductGetProductOptionsReturnNull() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getProductOptions()).thenReturn(null);

    // Act
    Sku actualFindMatchingSkuResult =
        legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>());

    // Assert
    verify(product).getProductOptions();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Product} {@link Product#getSkus()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_givenNull_whenProductGetSkusReturnNull() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");
    when(productOptionImpl.getRequired()).thenReturn(true);

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(null);
    when(product.getProductOptions()).thenReturn(productOptionList);

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult =
        legacyOrderServiceImpl.findMatchingSku(product, attributeValues);

    // Assert
    verify(product, atLeast(1)).getProductOptions();
    verify(product).getSkus();
    verify(productOptionImpl, atLeast(1)).getAttributeName();
    verify(productOptionImpl).getRequired();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductOptionValueImpl#getAttributeValue()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_thenCallsGetAttributeValue() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");
    when(productOptionImpl.getRequired()).thenReturn(true);

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    ProductOptionImpl productOptionImpl2 = mock(ProductOptionImpl.class);
    when(productOptionImpl2.getAttributeName()).thenReturn("foo");

    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getProductOption()).thenReturn(productOptionImpl2);

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(productOptionValueImpl);

    Sku sku = mock(Sku.class);
    when(sku.getProductOptionValues()).thenReturn(productOptionValueList);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(sku);

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(skuList);
    when(product.getProductOptions()).thenReturn(productOptionList);

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult =
        legacyOrderServiceImpl.findMatchingSku(product, attributeValues);

    // Assert
    verify(product, atLeast(1)).getProductOptions();
    verify(product, atLeast(1)).getSkus();
    verify(productOptionImpl2).getAttributeName();
    verify(productOptionImpl, atLeast(1)).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getProductOption();
    verify(sku).getProductOptionValues();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductOptionValueImpl#getProductOption()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_thenCallsGetProductOption() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");
    when(productOptionImpl.getRequired()).thenReturn(true);

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    ProductOptionImpl productOptionImpl2 = mock(ProductOptionImpl.class);
    when(productOptionImpl2.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getProductOption()).thenReturn(productOptionImpl2);

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(productOptionValueImpl);

    Sku sku = mock(Sku.class);
    when(sku.getProductOptionValues()).thenReturn(productOptionValueList);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(sku);

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(skuList);
    when(product.getProductOptions()).thenReturn(productOptionList);

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult =
        legacyOrderServiceImpl.findMatchingSku(product, attributeValues);

    // Assert
    verify(product, atLeast(1)).getProductOptions();
    verify(product, atLeast(1)).getSkus();
    verify(productOptionImpl2).getAttributeName();
    verify(productOptionImpl, atLeast(1)).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionValueImpl).getProductOption();
    verify(sku).getProductOptionValues();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_thenThrowIllegalArgumentException() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenThrow(new IllegalArgumentException());
    when(productOptionImpl.getRequired()).thenReturn(true);

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    Product product = mock(Product.class);
    when(product.getProductOptions()).thenReturn(productOptionList);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>()));
    verify(product, atLeast(1)).getProductOptions();
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_thenThrowRequiredAttributeNotProvidedException() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");
    when(productOptionImpl.getRequired()).thenReturn(true);

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    Product product = mock(Product.class);
    when(product.getProductOptions()).thenReturn(productOptionList);

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>()));
    verify(product, atLeast(1)).getProductOptions();
    verify(productOptionImpl, atLeast(1)).getAttributeName();
    verify(productOptionImpl).getRequired();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingSku(null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_whenProductBundleImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   *
   * <ul>
   *   <li>When {@link Product} {@link Product#getSkus()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_whenProductGetSkusReturnNull() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(false);

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(null);
    when(product.getProductOptions()).thenReturn(productOptionList);

    // Act
    Sku actualFindMatchingSkuResult =
        legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>());

    // Assert
    verify(product, atLeast(1)).getProductOptions();
    verify(product).getSkus();
    verify(productOptionImpl).getRequired();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.checkSkuForMatch(Sku, Map)"})
  public void testCheckSkuForMatch_givenFoo_whenSkuImpl_thenReturnFalse() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.checkSkuForMatch(sku, attributeValues));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionImpl} {@link ProductOptionImpl#getAttributeName()} return
   *       {@code Attribute Name}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.checkSkuForMatch(Sku, Map)"})
  public void testCheckSkuForMatch_givenProductOptionImplGetAttributeNameReturnAttributeName() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(productOptionValueImpl);

    Sku sku = mock(Sku.class);
    when(sku.getProductOptionValues()).thenReturn(productOptionValueList);

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act
    boolean actualCheckSkuForMatchResult =
        legacyOrderServiceImpl.checkSkuForMatch(sku, attributeValues);

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionValueImpl).getProductOption();
    verify(sku).getProductOptionValues();
    assertFalse(actualCheckSkuForMatchResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValueImpl} {@link ProductOptionValueImpl#getAttributeValue()}
   *       return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.checkSkuForMatch(Sku, Map)"})
  public void testCheckSkuForMatch_givenProductOptionValueImplGetAttributeValueReturn42() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");

    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(productOptionValueImpl);

    Sku sku = mock(Sku.class);
    when(sku.getProductOptionValues()).thenReturn(productOptionValueList);

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act
    boolean actualCheckSkuForMatchResult =
        legacyOrderServiceImpl.checkSkuForMatch(sku, attributeValues);

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getProductOption();
    verify(sku).getProductOptionValues();
    assertFalse(actualCheckSkuForMatchResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.checkSkuForMatch(Sku, Map)"})
  public void testCheckSkuForMatch_thenReturnTrue() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");

    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("foo");
    when(productOptionValueImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(productOptionValueImpl);

    Sku sku = mock(Sku.class);
    when(sku.getProductOptionValues()).thenReturn(productOptionValueList);

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act
    boolean actualCheckSkuForMatchResult =
        legacyOrderServiceImpl.checkSkuForMatch(sku, attributeValues);

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getProductOption();
    verify(sku).getProductOptionValues();
    assertTrue(actualCheckSkuForMatchResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.checkSkuForMatch(Sku, Map)"})
  public void testCheckSkuForMatch_thenThrowIllegalArgumentException() {
    // Arrange
    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");

    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getAttributeValue()).thenThrow(new IllegalArgumentException());
    when(productOptionValueImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(productOptionValueImpl);

    Sku sku = mock(Sku.class);
    when(sku.getProductOptionValues()).thenReturn(productOptionValueList);

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.checkSkuForMatch(sku, attributeValues));
    verify(productOptionImpl).getAttributeName();
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getProductOption();
    verify(sku).getProductOptionValues();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.checkSkuForMatch(Sku, Map)"})
  public void testCheckSkuForMatch_whenHashMap_thenReturnFalse() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.checkSkuForMatch(sku, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.checkSkuForMatch(Sku, Map)"})
  public void testCheckSkuForMatch_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(legacyOrderServiceImpl.checkSkuForMatch(new SkuImpl(), null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getProductOptions()).thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(1L);
    verify(productBundleImpl).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder2() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given {@link CategoryDao} {@link CategoryDao#readCategoryById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenCategoryDaoReadCategoryByIdThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenMinusOne() throws PricingException {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setQuantity(-1);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(null, orderItemRequestDTO, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenOrderDaoReadOrderByIdReturnNull() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenOrderDaoReadOrderByIdThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductBundleImpl#getDefaultSku()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenProductBundleImplGetDefaultSkuReturnNull()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act
    Order actualAddItemToOrderResult =
        legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true);

    // Assert
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddItemToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenProductDaoReadProductByIdReturnNull()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenProductDaoReadProductByIdThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given {@link SkuDao} {@link SkuDao#readSkuById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenSkuDaoReadSkuByIdThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenTwo() throws PricingException {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setQuantity(2);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(null, orderItemRequestDTO, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_givenZero() throws PricingException {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setQuantity(0);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addItemToOrder(null, orderItemRequestDTO, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderItemDao#create(OrderItemType)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_thenCallsCreate() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductBundleImpl#getDefaultCategory()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_thenCallsGetDefaultCategory() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_thenThrowRequiredAttributeNotProvidedException()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>When {@link ConfigurableOrderItemRequest} (default constructor) ProductId is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_whenConfigurableOrderItemRequestProductIdIsNull()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act
    Order actualAddItemToOrderResult =
        legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true);

    // Assert
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddItemToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemToOrder_whenOrderItemRequestDTO_thenReturnNull() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addItemToOrder(1L, new OrderItemRequestDTO(), true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest,
   * boolean)} with {@code order}, {@code itemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order,
   * DiscreteOrderItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addDiscreteItemToOrder(Order, DiscreteOrderItemRequest, boolean)"
  })
  public void testAddDiscreteItemToOrderWithOrderItemRequestPriceOrder() throws PricingException {
    // Arrange
    when(orderItemService.createDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addDiscreteItemToOrder(
                order, new DiscreteOrderItemRequest(), true));
    verify(orderItemService).createDiscreteOrderItem(isA(DiscreteOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)}
   * with {@code order}, {@code itemRequest}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)"
  })
  public void testAddDiscreteItemToOrderWithOrderItemRequest_thenThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(orderItemService.createDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addDiscreteItemToOrder(order, new DiscreteOrderItemRequest()));
    verify(orderItemService).createDiscreteOrderItem(isA(DiscreteOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity2()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity3()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity4()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity5()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity6()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity7()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getProductOptions()).thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(productDao).readProductById(1L);
    verify(productBundleImpl).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity8()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity9()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity10()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2);

    // Assert
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity11()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity12()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity13()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity14()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity15()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes2()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes3()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes4()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes5()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes6()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes7()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes8()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes9()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes10()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes11()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getProductOptions()).thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(productBundleImpl).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes12()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes13()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes14()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult =
        legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>());

    // Assert
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes15()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes16()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes17()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult =
        legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, 2, new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes18()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 0, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes19()
      throws PricingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, -1, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes20()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult =
        legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>());

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes21()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with
   * {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code
   * itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes22()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder2()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder3()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder4()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder5()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder6()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder7()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getProductOptions()).thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(productDao).readProductById(1L);
    verify(productBundleImpl).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder8()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder9()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder10()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult =
        legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true);

    // Assert
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder11()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder12()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder13()
      throws PricingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, -1, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder14()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult =
        legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder15()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder16()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(
        legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes2()
          throws PricingException {
    // Arrange, Act and Assert
    assertNull(
        legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes3()
          throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes4()
          throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes5()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes6()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes7()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes8()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes9()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any()))
        .thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes10()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes11()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getProductOptions()).thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(productBundleImpl).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes12()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes13()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes14()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult =
        legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>());

    // Assert
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes15()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes16()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes17()
          throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult =
        legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, 2, true, new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes18()
          throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 0, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes19()
          throws PricingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, -1, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes20()
          throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult =
        legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>());

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes21()
          throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean,
   * Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code
   * quantity}, {@code priceOrder}, {@code itemAttributes}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"
  })
  public void
      testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes22()
          throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(mock(SkuImpl.class));
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(skuDao).readSkuById(1L);
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setProductBundle(isA(ProductBundle.class));
    verify(bundleOrderItemImpl).setSku(isA(Sku.class));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getOrderItems();
    verify(bundleOrderItemImpl)
        .setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(bundleOrderItemImpl).setName("Name");
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setQuantity(2);
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder_whenNull()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder_whenNull2()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder_whenNull3()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder_whenNull4()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder_whenNull5()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult =
        legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, 2, true);

    // Assert
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity},
   * {@code priceOrder}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder_whenZero()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 0, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_whenMinusOne()
      throws PricingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, -1));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_whenNull()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_whenNull2()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_whenNull3()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_whenNull4()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_whenNull5()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, 2);

    // Assert
    verify(skuDao).readSkuById(1L);
    verify(orderDao).readOrderById(1L);
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code
   * orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"
  })
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_whenZero()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 0));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order,
   * DiscreteOrderItemRequest, HashMap)} with {@code order}, {@code itemRequest}, {@code
   * skuPricingConsiderations}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order,
   * DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap)"
  })
  public void testAddDynamicPriceDiscreteItemToOrderWithOrderItemRequestSkuPricingConsiderations()
      throws PricingException {
    // Arrange
    when(orderItemService.createDynamicPriceDiscreteOrderItem(
            Mockito.<DiscreteOrderItemRequest>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(
                order, itemRequest, new HashMap()));
    verify(orderItemService)
        .createDynamicPriceDiscreteOrderItem(
            isA(DiscreteOrderItemRequest.class), isA(HashMap.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order,
   * DiscreteOrderItemRequest, HashMap, boolean)} with {@code order}, {@code itemRequest}, {@code
   * skuPricingConsiderations}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order,
   * DiscreteOrderItemRequest, HashMap, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap, boolean)"
  })
  public void
      testAddDynamicPriceDiscreteItemToOrderWithOrderItemRequestSkuPricingConsiderationsPriceOrder()
          throws PricingException {
    // Arrange
    when(orderItemService.createDynamicPriceDiscreteOrderItem(
            Mockito.<DiscreteOrderItemRequest>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            legacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(
                order, itemRequest, new HashMap(), true));
    verify(orderItemService)
        .createDynamicPriceDiscreteOrderItem(
            isA(DiscreteOrderItemRequest.class), isA(HashMap.class));
  }
}
