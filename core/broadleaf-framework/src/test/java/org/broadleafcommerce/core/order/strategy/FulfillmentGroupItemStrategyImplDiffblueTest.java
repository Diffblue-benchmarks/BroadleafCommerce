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
package org.broadleafcommerce.core.order.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentGroupItemStrategyImplDiffblueTest {
  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@link CartOperationRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  public void testOnItemAdded_givenBundleOrderItemImpl_thenReturnCartOperationRequest() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  public void testOnItemAdded_thenThrowIllegalStateException() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   * with {@code discreteOrderItem}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  public void testResolveFulfillmentTypeWithDiscreteOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   * with {@code discreteOrderItem}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  public void testResolveFulfillmentTypeWithDiscreteOrderItem2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   * with {@code discreteOrderItem}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  public void testResolveFulfillmentTypeWithDiscreteOrderItem_givenSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   * with {@code discreteOrderItem}.
   * <ul>
   *   <li>Then return {@link FulfillmentType#DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  public void testResolveFulfillmentTypeWithDiscreteOrderItem_thenReturnDigital() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   * with {@code discreteOrderItem}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  public void testResolveFulfillmentTypeWithDiscreteOrderItem_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  public void testOnItemUpdated() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItemQuantityDelta(0);

    // Act and Assert
    assertSame(request, fulfillmentGroupItemStrategyImpl.onItemUpdated(request));
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  public void testOnItemUpdated_givenIllegalStateExceptionWithFoo() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  public void testOnItemUpdated_thenCallsGetDiscreteOrderItems() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <ul>
   *   <li>Then return {@link CartOperationRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  public void testOnItemUpdated_thenReturnCartOperationRequest() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
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
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getQuantity()).thenThrow(new IllegalStateException("foo"));
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 2));
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem).getQuantity();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getQuantity()).thenThrow(new IllegalStateException("foo"));
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 0));
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem).getQuantity();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity_givenArrayList_whenZero_thenThrowIllegalStateException() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 0));
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity_givenHashMap() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

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
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 2));
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity_givenOrderItemImplAuditableIsAuditable() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
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
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(2);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(orderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 2));
    verify(fulfillmentGroupItem).getOrderItem();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity_thenReturnEmpty() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getQuantity()).thenReturn(1);
    doNothing().when(fulfillmentGroupItem).setQuantity(anyInt());
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroupItem> actualUpdateItemQuantityResult = fulfillmentGroupItemStrategyImpl
        .updateItemQuantity(order, new BundleOrderItemImpl(), 2);

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem).getQuantity();
    verify(fulfillmentGroupItem).setQuantity(eq(3));
    verify(order).getFulfillmentGroups();
    assertTrue(actualUpdateItemQuantityResult.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity_thenReturnEmpty2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getQuantity()).thenReturn(1);
    doNothing().when(fulfillmentGroupItem).setQuantity(anyInt());
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroupItem> actualUpdateItemQuantityResult = fulfillmentGroupItemStrategyImpl
        .updateItemQuantity(order, new BundleOrderItemImpl(), 0);

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem, atLeast(1)).getQuantity();
    verify(fulfillmentGroupItem).setQuantity(eq(1));
    verify(order).getFulfillmentGroups();
    assertTrue(actualUpdateItemQuantityResult.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity_thenThrowIllegalStateException() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 2));
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity_whenMinusOne_thenReturnSizeIsOne() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroupItem> actualUpdateItemQuantityResult = fulfillmentGroupItemStrategyImpl
        .updateItemQuantity(order, new BundleOrderItemImpl(), -1);

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem).getQuantity();
    verify(order).getFulfillmentGroups();
    assertEquals(1, actualUpdateItemQuantityResult.size());
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}
   */
  @Test
  public void testUpdateItemQuantity_whenZero_thenThrowIllegalStateException() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 0));
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  public void testOnItemRemoved() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertSame(request, fulfillmentGroupItemStrategyImpl.onItemRemoved(request));
  }

  /**
   * Test
   * {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  public void testOnItemRemoved_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  public void testVerify() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

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
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, fulfillmentGroupItemStrategyImpl.verify(request));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  public void testVerify2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    CartOperationRequest actualVerifyResult = fulfillmentGroupItemStrategyImpl.verify(request);

    // Assert
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderItems();
    assertSame(request, actualVerifyResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  public void testVerify_givenArrayListAddBundleOrderItemImpl() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(orderItemList);
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    CartOperationRequest actualVerifyResult = fulfillmentGroupItemStrategyImpl.verify(request);

    // Assert
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderItems();
    assertSame(request, actualVerifyResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link DiscreteOrderItemImpl}.</li>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  public void testVerify_givenArrayListAddDiscreteOrderItemImpl_thenCallsGetDiscreteOrderItems()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalStateException("foo"));

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(mock(DiscreteOrderItemImpl.class));
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl
        .verify(new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderItems();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  public void testVerify_givenOrderItemImplAuditableIsAuditable_thenThrowIllegalStateException()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(3L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(3L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
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
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(3);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(orderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl
        .verify(new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderItems();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  public void testVerify_thenCallsGetDiscreteOrderItems() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalStateException("foo"));

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl
        .verify(new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderItems();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FulfillmentGroupItemStrategyImpl#setRemoveEmptyFulfillmentGroups(boolean)}
   *   <li>{@link FulfillmentGroupItemStrategyImpl#isRemoveEmptyFulfillmentGroups()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl = new FulfillmentGroupItemStrategyImpl();

    // Act
    fulfillmentGroupItemStrategyImpl.setRemoveEmptyFulfillmentGroups(true);

    // Assert that nothing has changed
    assertTrue(fulfillmentGroupItemStrategyImpl.isRemoveEmptyFulfillmentGroups());
  }
}
