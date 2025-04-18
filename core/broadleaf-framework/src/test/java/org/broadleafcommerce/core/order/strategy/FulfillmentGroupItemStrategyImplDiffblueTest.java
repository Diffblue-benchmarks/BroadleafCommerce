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
package org.broadleafcommerce.core.order.strategy;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FulfillmentGroupItemStrategyImplDiffblueTest {
  @Mock
  private FulfillmentGroupItemDao fulfillmentGroupItemDao;

  @InjectMocks
  private FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @Mock
  private OrderItemService orderItemService;

  @Mock
  private OrderService orderService;

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@link CartOperationRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"})
  public void testOnItemAdded_givenBundleOrderItemImpl_thenReturnCartOperationRequest() throws PricingException {
    // Arrange
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(new NullOrderImpl());
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    // Act
    CartOperationRequest actualOnItemAddedResult = fulfillmentGroupItemStrategyImpl.onItemAdded(request);

    // Assert
    verify(request).getOrder();
    verify(request).getOrderItem();
    assertSame(request, actualOnItemAddedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"})
  public void testOnItemAdded_thenThrowIllegalStateException() throws PricingException {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalStateException("foo"));
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(new NullOrderImpl());
    when(request.getOrderItem()).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemAdded(request));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(request).getOrder();
    verify(request).getOrderItem();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"})
  public void testResolveFulfillmentTypeWithDiscreteOrderItem() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductBundleImpl());
    when(skuImpl.getFulfillmentType()).thenReturn(null);
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult = fulfillmentGroupItemStrategyImpl
        .resolveFulfillmentType(discreteOrderItem);

    // Assert
    verify(skuImpl, atLeast(1)).getDefaultProduct();
    verify(skuImpl).getFulfillmentType();
    verify(discreteOrderItem).getSku();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"})
  public void testResolveFulfillmentTypeWithDiscreteOrderItem2() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(productBundleImpl);
    when(skuImpl.getFulfillmentType()).thenReturn(null);
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult = fulfillmentGroupItemStrategyImpl
        .resolveFulfillmentType(discreteOrderItem);

    // Assert
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(skuImpl, atLeast(1)).getDefaultProduct();
    verify(skuImpl).getFulfillmentType();
    verify(discreteOrderItem).getSku();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"})
  public void testResolveFulfillmentTypeWithDiscreteOrderItem_givenSkuImpl() {
    // Arrange
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(new SkuImpl());

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult = fulfillmentGroupItemStrategyImpl
        .resolveFulfillmentType(discreteOrderItem);

    // Assert
    verify(discreteOrderItem).getSku();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <ul>
   *   <li>Then return {@link FulfillmentType#DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"})
  public void testResolveFulfillmentTypeWithDiscreteOrderItem_thenReturnDigital() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getFulfillmentType()).thenReturn(FulfillmentType.DIGITAL);
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult = fulfillmentGroupItemStrategyImpl
        .resolveFulfillmentType(discreteOrderItem);

    // Assert
    verify(skuImpl, atLeast(1)).getFulfillmentType();
    verify(discreteOrderItem).getSku();
    assertSame(actualResolveFulfillmentTypeResult.DIGITAL, actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"})
  public void testResolveFulfillmentTypeWithDiscreteOrderItem_thenThrowIllegalStateException() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFulfillmentType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(categoryImpl);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(productBundleImpl);
    when(skuImpl.getFulfillmentType()).thenReturn(null);
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(discreteOrderItem));
    verify(categoryImpl).getFulfillmentType();
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(skuImpl, atLeast(1)).getDefaultProduct();
    verify(skuImpl).getFulfillmentType();
    verify(discreteOrderItem).getSku();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"})
  public void testResolveFulfillmentTypeWithSku() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getDefaultProduct()).thenReturn(productBundleImpl);
    when(sku.getFulfillmentType()).thenReturn(null);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult = fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku);

    // Assert
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(sku, atLeast(1)).getDefaultProduct();
    verify(sku).getFulfillmentType();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   * <ul>
   *   <li>Given {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then return {@link FulfillmentType#DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"})
  public void testResolveFulfillmentTypeWithSku_givenDigital_thenReturnDigital() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getFulfillmentType()).thenReturn(FulfillmentType.DIGITAL);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult = fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku);

    // Assert
    verify(sku, atLeast(1)).getFulfillmentType();
    assertSame(actualResolveFulfillmentTypeResult.DIGITAL, actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"})
  public void testResolveFulfillmentTypeWithSku_givenProductBundleImpl() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getDefaultProduct()).thenReturn(new ProductBundleImpl());
    when(sku.getFulfillmentType()).thenReturn(null);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult = fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku);

    // Assert
    verify(sku, atLeast(1)).getDefaultProduct();
    verify(sku).getFulfillmentType();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"})
  public void testResolveFulfillmentTypeWithSku_thenThrowIllegalStateException() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFulfillmentType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(categoryImpl);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getDefaultProduct()).thenReturn(productBundleImpl);
    when(sku.getFulfillmentType()).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku));
    verify(categoryImpl).getFulfillmentType();
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(sku, atLeast(1)).getDefaultProduct();
    verify(sku).getFulfillmentType();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"})
  public void testResolveFulfillmentTypeWithSku_whenSkuImpl_thenReturnNull() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

    // Act and Assert
    assertNull(fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(new SkuImpl()));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup)} with {@code order}, {@code orderItem}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup)"})
  public void testAddItemToFulfillmentGroupWithOrderOrderItemFulfillmentGroup() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupService.addItemToFulfillmentGroup(Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(),
        anyBoolean())).thenReturn(fulfillmentGroupImpl);
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupItemStrategyImpl
        .addItemToFulfillmentGroup(order, orderItem, new FulfillmentGroupImpl());

    // Assert
    verify(fulfillmentGroupService).addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false),
        eq(false));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup)} with {@code order}, {@code orderItem}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup)"})
  public void testAddItemToFulfillmentGroupWithOrderOrderItemFulfillmentGroup2() throws PricingException {
    // Arrange
    when(fulfillmentGroupService.addItemToFulfillmentGroup(Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(),
        anyBoolean())).thenThrow(new IllegalStateException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(order, orderItem, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupService).addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false),
        eq(false));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, int, FulfillmentGroup)} with {@code order}, {@code orderItem}, {@code quantity}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, int, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(Order, OrderItem, int, FulfillmentGroup)"})
  public void testAddItemToFulfillmentGroupWithOrderOrderItemQuantityFulfillmentGroup() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupService.addItemToFulfillmentGroup(Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(),
        anyBoolean())).thenReturn(fulfillmentGroupImpl);
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupItemStrategyImpl
        .addItemToFulfillmentGroup(order, orderItem, 2, new FulfillmentGroupImpl());

    // Assert
    verify(fulfillmentGroupService).addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false),
        eq(false));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, int, FulfillmentGroup)} with {@code order}, {@code orderItem}, {@code quantity}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, int, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(Order, OrderItem, int, FulfillmentGroup)"})
  public void testAddItemToFulfillmentGroupWithOrderOrderItemQuantityFulfillmentGroup2() throws PricingException {
    // Arrange
    when(fulfillmentGroupService.addItemToFulfillmentGroup(Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(),
        anyBoolean())).thenThrow(new IllegalStateException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(order,
        orderItem, 2, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupService).addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false),
        eq(false));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"})
  public void testOnItemUpdated() throws PricingException {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItemQuantityDelta(0);

    // Act and Assert
    assertSame(request, fulfillmentGroupItemStrategyImpl.onItemUpdated(request));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"})
  public void testOnItemUpdated_givenIllegalStateExceptionWithFoo() throws PricingException {
    // Arrange
    CartOperationRequest request = mock(CartOperationRequest.class);
    doThrow(new IllegalStateException("foo")).when(request).setFgisToDelete(Mockito.<List<FulfillmentGroupItem>>any());
    when(request.getOrderItemQuantityDelta()).thenReturn(2);
    when(request.getOrder()).thenReturn(new NullOrderImpl());
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(request).setOrderItemQuantityDelta(Mockito.<Integer>any());
    request.setOrderItemQuantityDelta(0);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemUpdated(request));
    verify(request).getOrder();
    verify(request).getOrderItem();
    verify(request).getOrderItemQuantityDelta();
    verify(request).setFgisToDelete(isA(List.class));
    verify(request).setOrderItemQuantityDelta(eq(0));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"})
  public void testOnItemUpdated_thenCallsGetDiscreteOrderItems() throws PricingException {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalStateException("foo"));
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrderItemQuantityDelta()).thenReturn(2);
    when(request.getOrder()).thenReturn(new NullOrderImpl());
    when(request.getOrderItem()).thenReturn(bundleOrderItemImpl);
    doNothing().when(request).setOrderItemQuantityDelta(Mockito.<Integer>any());
    request.setOrderItemQuantityDelta(0);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemUpdated(request));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(request).getOrder();
    verify(request).getOrderItem();
    verify(request).getOrderItemQuantityDelta();
    verify(request).setOrderItemQuantityDelta(eq(0));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <ul>
   *   <li>Then return {@link CartOperationRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"})
  public void testOnItemUpdated_thenReturnCartOperationRequest() throws PricingException {
    // Arrange
    CartOperationRequest request = mock(CartOperationRequest.class);
    doNothing().when(request).setFgisToDelete(Mockito.<List<FulfillmentGroupItem>>any());
    when(request.getOrderItemQuantityDelta()).thenReturn(2);
    when(request.getOrder()).thenReturn(new NullOrderImpl());
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(request).setOrderItemQuantityDelta(Mockito.<Integer>any());
    request.setOrderItemQuantityDelta(0);

    // Act
    CartOperationRequest actualOnItemUpdatedResult = fulfillmentGroupItemStrategyImpl.onItemUpdated(request);

    // Assert
    verify(request).getOrder();
    verify(request).getOrderItem();
    verify(request).getOrderItemQuantityDelta();
    verify(request).setFgisToDelete(isA(List.class));
    verify(request).setOrderItemQuantityDelta(eq(0));
    assertSame(request, actualOnItemUpdatedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"})
  public void testUpdateItemQuantity_givenArrayListAddFulfillmentGroupImpl() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 2));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"})
  public void testUpdateItemQuantity_thenThrowIllegalStateException() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

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
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 2));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"})
  public void testUpdateItemQuantity_whenZero_thenThrowIllegalStateException() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

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
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 0));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"})
  public void testOnItemRemoved() {
    // Arrange
    when(fulfillmentGroupService.getFulfillmentGroupItemsForOrderItem(Mockito.<Order>any(), Mockito.<OrderItem>any()))
        .thenThrow(new IllegalStateException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl
        .onItemRemoved(new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
    verify(fulfillmentGroupService).getFulfillmentGroupItemsForOrderItem(isA(Order.class), isNull());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <ul>
   *   <li>Then AddedOrderItem return {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"})
  public void testOnItemRemoved_thenAddedOrderItemReturnBundleOrderItemImpl() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    request.setOrderItem(orderItem);

    // Act
    CartOperationRequest actualOnItemRemovedResult = fulfillmentGroupItemStrategyImpl.onItemRemoved(request);

    // Assert
    OrderItem addedOrderItem = actualOnItemRemovedResult.getAddedOrderItem();
    assertTrue(addedOrderItem instanceof BundleOrderItemImpl);
    assertSame(orderItem, addedOrderItem);
    assertSame(orderItem, actualOnItemRemovedResult.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"})
  public void testOnItemRemoved_thenCallsGetDiscreteOrderItems() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getDiscreteOrderItems()).thenThrow(new IllegalStateException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItem(orderItem);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemRemoved(request));
    verify(orderItem).getDiscreteOrderItems();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"})
  public void testOnItemRemoved_thenOrderReturnNullOrderImpl() {
    // Arrange
    when(fulfillmentGroupService.getFulfillmentGroupItemsForOrderItem(Mockito.<Order>any(), Mockito.<OrderItem>any()))
        .thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    CartOperationRequest actualOnItemRemovedResult = fulfillmentGroupItemStrategyImpl
        .onItemRemoved(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Assert
    verify(fulfillmentGroupService).getFulfillmentGroupItemsForOrderItem(isA(Order.class), isNull());
    assertTrue(actualOnItemRemovedResult.getOrder() instanceof NullOrderImpl);
    assertNull(actualOnItemRemovedResult.getAddedOrderItem());
    assertNull(actualOnItemRemovedResult.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"})
  public void testVerify() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(3L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(3L);

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
    order.setTotalTax(new Money());
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, fulfillmentGroupItemStrategyImpl.verify(request));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then calls {@link FulfillmentGroupService#delete(FulfillmentGroup)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"})
  public void testVerify_givenArrayListAddFulfillmentGroupImpl_thenCallsDelete() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(3L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(3L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    CartOperationRequest actualVerifyResult = fulfillmentGroupItemStrategyImpl.verify(request);

    // Assert
    verify(fulfillmentGroupService).delete(isA(FulfillmentGroup.class));
    assertSame(request, actualVerifyResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemStrategyImpl} (default constructor).</li>
   *   <li>Then Order return {@link OrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"})
  public void testVerify_givenFulfillmentGroupItemStrategyImpl_thenOrderReturnOrderImpl() throws PricingException {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(3L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(3L);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    Order order2 = fulfillmentGroupItemStrategyImpl
        .verify(new CartOperationRequest(order, new OrderItemRequestDTO(), true))
        .getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertSame(orderItems, order2.getOrderItems());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupItemStrategyImpl#setRemoveEmptyFulfillmentGroups(boolean)}
   *   <li>{@link FulfillmentGroupItemStrategyImpl#isRemoveEmptyFulfillmentGroups()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemStrategyImpl.isRemoveEmptyFulfillmentGroups()",
      "void FulfillmentGroupItemStrategyImpl.setRemoveEmptyFulfillmentGroups(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

    // Act
    fulfillmentGroupItemStrategyImpl.setRemoveEmptyFulfillmentGroups(true);

    // Assert
    assertTrue(fulfillmentGroupItemStrategyImpl.isRemoveEmptyFulfillmentGroups());
  }
}
