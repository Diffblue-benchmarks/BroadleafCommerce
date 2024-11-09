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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupItemRequest;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentGroupServiceImplDiffblueTest {
  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)}
   * with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)}
   */
  @Test
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true, false));
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  public void testGetFulfillmentGroupItemsForOrderItem_givenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroupItem> actualFulfillmentGroupItemsForOrderItem = fulfillmentGroupServiceImpl
        .getFulfillmentGroupItemsForOrderItem(order, new BundleOrderItemImpl());

    // Assert
    verify(order).getFulfillmentGroups();
    assertTrue(actualFulfillmentGroupItemsForOrderItem.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}.
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  public void testGetFulfillmentGroupItemsForOrderItem_givenBroadleafCurrencyImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

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
    assertTrue(
        fulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(order, new BundleOrderItemImpl()).isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}.
   * <ul>
   *   <li>Given {@link GiftWrapOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  public void testGetFulfillmentGroupItemsForOrderItem_givenGiftWrapOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    // Act
    List<FulfillmentGroupItem> actualFulfillmentGroupItemsForOrderItem = fulfillmentGroupServiceImpl
        .getFulfillmentGroupItemsForOrderItem(order, orderItem);

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(order).getFulfillmentGroups();
    assertTrue(actualFulfillmentGroupItemsForOrderItem.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  public void testGetFulfillmentGroupItemsForOrderItem_givenOrderItemImplAuditableIsAuditable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

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
    orderItemImpl.setQuantity(1);
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

    // Act
    List<FulfillmentGroupItem> actualFulfillmentGroupItemsForOrderItem = fulfillmentGroupServiceImpl
        .getFulfillmentGroupItemsForOrderItem(order, new BundleOrderItemImpl());

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(order).getFulfillmentGroups();
    assertTrue(actualFulfillmentGroupItemsForOrderItem.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  public void testGetFulfillmentGroupItemsForOrderItem_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroupItem> actualFulfillmentGroupItemsForOrderItem = fulfillmentGroupServiceImpl
        .getFulfillmentGroupItemsForOrderItem(order, new BundleOrderItemImpl());

    // Assert
    verify(order).getFulfillmentGroups();
    assertTrue(actualFulfillmentGroupItemsForOrderItem.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  public void testGetFulfillmentGroupItemsForOrderItem_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroupItem> actualFulfillmentGroupItemsForOrderItem = fulfillmentGroupServiceImpl
        .getFulfillmentGroupItemsForOrderItem(order, new BundleOrderItemImpl());

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(order).getFulfillmentGroups();
    assertEquals(1, actualFulfillmentGroupItemsForOrderItem.size());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}
   */
  @Test
  public void testRemoveOrderItemFromFullfillmentGroups_givenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    fulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(order, new BundleOrderItemImpl());

    // Assert
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}.
   * <ul>
   *   <li>Given {@link GiftWrapOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}
   */
  @Test
  public void testRemoveOrderItemFromFullfillmentGroups_givenGiftWrapOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    // Act
    fulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(order, orderItem);

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}
   */
  @Test
  public void testRemoveOrderItemFromFullfillmentGroups_givenOrderItemImplAuditableIsAuditable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

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
    orderItemImpl.setQuantity(1);
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

    // Act
    fulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(order, new BundleOrderItemImpl());

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}
   */
  @Test
  public void testRemoveOrderItemFromFullfillmentGroups_thenCallsGetFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    fulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(order, new BundleOrderItemImpl());

    // Assert
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  public void testCollapseToOneShippableFulfillmentGroup() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.DIGITAL);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order, atLeast(1)).getFulfillmentGroups();
    assertSame(order, actualCollapseToOneShippableFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  public void testCollapseToOneShippableFulfillmentGroup2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.GIFT_CARD);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order, atLeast(1)).getFulfillmentGroups();
    assertSame(order, actualCollapseToOneShippableFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  public void testCollapseToOneShippableFulfillmentGroup3() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.PHYSICAL_PICKUP);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order, atLeast(1)).getFulfillmentGroups();
    assertSame(order, actualCollapseToOneShippableFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  public void testCollapseToOneShippableFulfillmentGroup4() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(new FulfillmentType("GIFT_CARD", "GIFT_CARD"));

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order, atLeast(1)).getFulfillmentGroups();
    assertSame(order, actualCollapseToOneShippableFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  public void testCollapseToOneShippableFulfillmentGroup_givenArrayList() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(order, atLeast(1)).getFulfillmentGroups();
    assertSame(order, actualCollapseToOneShippableFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  public void testCollapseToOneShippableFulfillmentGroup_thenReturnNullOrderImpl() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true));
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}.
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  public void testCollapseToOneShippableFulfillmentGroup_thenReturnOrderImpl() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

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
    assertSame(order, fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true));
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link FulfillmentOption} {@link FulfillmentOption#getId()} return
   * one.</li>
   *   <li>Then return {@code 1:1:DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}
   */
  @Test
  public void testGetKey_givenOne_whenFulfillmentOptionGetIdReturnOne_thenReturn11Digital() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getId()).thenReturn(1L);
    FulfillmentOption option = mock(FulfillmentOption.class);
    when(option.getId()).thenReturn(1L);

    // Act
    String actualKey = fulfillmentGroupServiceImpl.getKey(address, option, FulfillmentType.DIGITAL);

    // Assert
    verify(option).getId();
    verify(address).getId();
    assertEquals("1:1:DIGITAL", actualKey);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>When {@link FulfillmentType} {@link FulfillmentType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code 1:1:Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}
   */
  @Test
  public void testGetKey_givenType_whenFulfillmentTypeGetTypeReturnType_thenReturn11Type() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getId()).thenReturn(1L);
    FulfillmentOption option = mock(FulfillmentOption.class);
    when(option.getId()).thenReturn(1L);
    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("Type");

    // Act
    String actualKey = fulfillmentGroupServiceImpl.getKey(address, option, fulfillmentType);

    // Assert
    verify(option).getId();
    verify(fulfillmentType).getType();
    verify(address).getId();
    assertEquals("1:1:Type", actualKey);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code -1:-1:DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}
   */
  @Test
  public void testGetKey_whenNull_thenReturn11Digital() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-1:-1:DIGITAL", (new FulfillmentGroupServiceImpl()).getKey(null, null, FulfillmentType.DIGITAL));
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code -1:-1:-1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}
   */
  @Test
  public void testGetKey_whenNull_thenReturn111() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-1:-1:-1", (new FulfillmentGroupServiceImpl()).getKey(null, null, null));
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  public void testRemoveAllFulfillmentGroupsFromOrder_thenReturnNullOrderImpl() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, fulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  public void testIsShippable_whenDigital_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupServiceImpl()).isShippable(FulfillmentType.DIGITAL));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#FulfillmentType(String, String)} with type is
   * {@code GIFT_CARD} and friendlyType is {@code GIFT_CARD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  public void testIsShippable_whenFulfillmentTypeWithTypeIsGiftCardAndFriendlyTypeIsGiftCard() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    // Act and Assert
    assertFalse(fulfillmentGroupServiceImpl.isShippable(new FulfillmentType("GIFT_CARD", "GIFT_CARD")));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  public void testIsShippable_whenFulfillmentType_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentGroupServiceImpl()).isShippable(mock(FulfillmentType.class)));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#GIFT_CARD}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  public void testIsShippable_whenGift_card_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupServiceImpl()).isShippable(FulfillmentType.GIFT_CARD));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  public void testIsShippable_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentGroupServiceImpl()).isShippable(null));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#PHYSICAL_PICKUP_OR_SHIP}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  public void testIsShippable_whenPhysical_pickup_or_ship_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentGroupServiceImpl()).isShippable(FulfillmentType.PHYSICAL_PICKUP_OR_SHIP));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#PHYSICAL_PICKUP}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  public void testIsShippable_whenPhysical_pickup_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupServiceImpl()).isShippable(FulfillmentType.PHYSICAL_PICKUP));
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  public void testGetFirstShippableFulfillmentGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.DIGITAL);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup = fulfillmentGroupServiceImpl
        .getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertNull(actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  public void testGetFirstShippableFulfillmentGroup2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.GIFT_CARD);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup = fulfillmentGroupServiceImpl
        .getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertNull(actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  public void testGetFirstShippableFulfillmentGroup3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.PHYSICAL_PICKUP);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup = fulfillmentGroupServiceImpl
        .getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertNull(actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  public void testGetFirstShippableFulfillmentGroup4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(new FulfillmentType("GIFT_CARD", "GIFT_CARD"));

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup = fulfillmentGroupServiceImpl
        .getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertNull(actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  public void testGetFirstShippableFulfillmentGroup_givenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup = fulfillmentGroupServiceImpl
        .getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(order).getFulfillmentGroups();
    assertNull(actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  public void testGetFirstShippableFulfillmentGroup_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

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
    assertNull(fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order));
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#getType()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  public void testGetFirstShippableFulfillmentGroup_givenFulfillmentGroupImplGetTypeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(null);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  public void testGetFirstShippableFulfillmentGroup_thenReturnFulfillmentGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup = fulfillmentGroupServiceImpl
        .getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(order).getFulfillmentGroups();
    assertSame(fulfillmentGroupImpl, actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  public void testGetFirstShippableFulfillmentGroup_whenNullOrderImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    // Act and Assert
    assertNull(fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(new NullOrderImpl()));
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testGetAllShippableFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.DIGITAL);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups = fulfillmentGroupServiceImpl
        .getAllShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertTrue(actualAllShippableFulfillmentGroups.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testGetAllShippableFulfillmentGroups2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.GIFT_CARD);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups = fulfillmentGroupServiceImpl
        .getAllShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertTrue(actualAllShippableFulfillmentGroups.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testGetAllShippableFulfillmentGroups3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.PHYSICAL_PICKUP);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups = fulfillmentGroupServiceImpl
        .getAllShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertTrue(actualAllShippableFulfillmentGroups.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testGetAllShippableFulfillmentGroups4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(new FulfillmentType("GIFT_CARD", "GIFT_CARD"));

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups = fulfillmentGroupServiceImpl
        .getAllShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertTrue(actualAllShippableFulfillmentGroups.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testGetAllShippableFulfillmentGroups_givenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups = fulfillmentGroupServiceImpl
        .getAllShippableFulfillmentGroups(order);

    // Assert
    verify(order).getFulfillmentGroups();
    assertTrue(actualAllShippableFulfillmentGroups.isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testGetAllShippableFulfillmentGroups_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

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
    assertTrue(fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(order).isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#getType()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testGetAllShippableFulfillmentGroups_givenFulfillmentGroupImplGetTypeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(null);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups = fulfillmentGroupServiceImpl
        .getAllShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertEquals(1, actualAllShippableFulfillmentGroups.size());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Then return first is {@link FulfillmentGroupImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testGetAllShippableFulfillmentGroups_thenReturnFirstIsFulfillmentGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups = fulfillmentGroupServiceImpl
        .getAllShippableFulfillmentGroups(order);

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals(1, actualAllShippableFulfillmentGroups.size());
    assertSame(fulfillmentGroupImpl, actualAllShippableFulfillmentGroups.get(0));
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testGetAllShippableFulfillmentGroups_whenNullOrderImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(new NullOrderImpl()).isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testCalculateNumShippableFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.DIGITAL);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult = fulfillmentGroupServiceImpl
        .calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertEquals(0, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testCalculateNumShippableFulfillmentGroups2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.GIFT_CARD);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult = fulfillmentGroupServiceImpl
        .calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertEquals(0, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testCalculateNumShippableFulfillmentGroups3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.PHYSICAL_PICKUP);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult = fulfillmentGroupServiceImpl
        .calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertEquals(0, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testCalculateNumShippableFulfillmentGroups4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(new FulfillmentType("GIFT_CARD", "GIFT_CARD"));

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult = fulfillmentGroupServiceImpl
        .calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    verify(order).getFulfillmentGroups();
    assertEquals(0, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testCalculateNumShippableFulfillmentGroups_givenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult = fulfillmentGroupServiceImpl
        .calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals(0, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testCalculateNumShippableFulfillmentGroups_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

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
    assertEquals(0, fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(order).intValue());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testCalculateNumShippableFulfillmentGroups_thenReturnIntValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult = fulfillmentGroupServiceImpl
        .calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals(1, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  public void testCalculateNumShippableFulfillmentGroups_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl = new FulfillmentGroupServiceImpl();

    // Act and Assert
    assertEquals(0, fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(new NullOrderImpl()).intValue());
  }
}
