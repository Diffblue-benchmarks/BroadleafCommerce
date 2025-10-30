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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupDao;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDaoImpl;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.dao.OrderDaoImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderItemServiceImpl;
import org.broadleafcommerce.core.order.service.call.BundleOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.DiscreteOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupRequest;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDao;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDaoImpl;
import org.broadleafcommerce.core.pricing.service.PricingService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
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
  @InjectMocks
  private LegacyOrderServiceImpl legacyOrderServiceImpl;

  @Mock
  private OrderItemService orderItemService;

  @Mock
  private FulfillmentGroupDao fulfillmentGroupDao;

  @Mock
  private PricingService pricingService;

  @Mock
  private FulfillmentGroupItemDao fulfillmentGroupItemDao;

  @Mock
  private OrderDao orderDao;

  /**
   * Test {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest, boolean)} with {@code order}, {@code itemRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addBundleItemToOrder(Order, BundleOrderItemRequest, boolean)"})
  public void testAddBundleItemToOrderWithOrderItemRequestPriceOrder() throws PricingException {
    // Arrange
    when(orderItemService.createBundleOrderItem(Mockito.<BundleOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException("foo"));
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
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addBundleItemToOrder(order, itemRequest, true));
    verify(orderItemService).createBundleOrderItem(isA(BundleOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest)} with {@code order}, {@code itemRequest}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addBundleItemToOrder(Order, BundleOrderItemRequest)"})
  public void testAddBundleItemToOrderWithOrderItemRequest_thenThrowIllegalArgumentException() throws PricingException {
    // Arrange
    when(orderItemService.createBundleOrderItem(Mockito.<BundleOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException("foo"));
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
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addBundleItemToOrder(order, itemRequest));
    verify(orderItemService).createBundleOrderItem(isA(BundleOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)} with {@code fulfillmentGroupRequest}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest)"})
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
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult = legacyOrderServiceImpl
        .addFulfillmentGroupToOrder(fulfillmentGroupRequest);

    // Assert
    verify(fulfillmentGroupDao).create();
    assertSame(fulfillmentGroupImpl, actualAddFulfillmentGroupToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)} with {@code fulfillmentGroupRequest}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest)"})
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequest2() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException("foo"));

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
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)} with {@code fulfillmentGroupRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"})
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequestPriceOrder() throws PricingException {
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
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult = legacyOrderServiceImpl
        .addFulfillmentGroupToOrder(fulfillmentGroupRequest, true);

    // Assert
    verify(fulfillmentGroupDao).create();
    assertSame(fulfillmentGroupImpl, actualAddFulfillmentGroupToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)} with {@code fulfillmentGroupRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"})
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequestPriceOrder2() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException("foo"));

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
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, true));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup)} with {@code order}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup)"})
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroup() throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(new FulfillmentGroupImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)"})
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroupPriceOrder() throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(new FulfillmentGroupImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with {@code item}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"})
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"})
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"})
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), 2));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"})
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), 2, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"})
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

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
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(order, item, new FulfillmentGroupImpl(), 2, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"})
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder2() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

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
    BundleOrderItemImpl item = new BundleOrderItemImpl();
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = legacyOrderServiceImpl.addItemToFulfillmentGroup(order,
        item, fulfillmentGroup, 2, true);

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
   * Test {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest, boolean)} with {@code order}, {@code itemRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "OrderItem LegacyOrderServiceImpl.addDiscreteItemToOrder(Order, DiscreteOrderItemRequest, boolean)"})
  public void testAddDiscreteItemToOrderWithOrderItemRequestPriceOrder() throws PricingException {
    // Arrange
    when(orderItemService.createDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addDiscreteItemToOrder(order, new DiscreteOrderItemRequest(), true));
    verify(orderItemService).createDiscreteOrderItem(isA(DiscreteOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)} with {@code order}, {@code itemRequest}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)"})
  public void testAddDiscreteItemToOrderWithOrderItemRequest_thenThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(orderItemService.createDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addDiscreteItemToOrder(order, new DiscreteOrderItemRequest()));
    verify(orderItemService).createDiscreteOrderItem(isA(DiscreteOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap)} with {@code order}, {@code itemRequest}, {@code skuPricingConsiderations}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "OrderItem LegacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap)"})
  public void testAddDynamicPriceDiscreteItemToOrderWithOrderItemRequestSkuPricingConsiderations()
      throws PricingException {
    // Arrange
    when(orderItemService.createDynamicPriceDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any(),
        Mockito.<HashMap<Object, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(order, itemRequest, new HashMap()));
    verify(orderItemService).createDynamicPriceDiscreteOrderItem(isA(DiscreteOrderItemRequest.class),
        isA(HashMap.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap, boolean)} with {@code order}, {@code itemRequest}, {@code skuPricingConsiderations}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "OrderItem LegacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap, boolean)"})
  public void testAddDynamicPriceDiscreteItemToOrderWithOrderItemRequestSkuPricingConsiderationsPriceOrder()
      throws PricingException {
    // Arrange
    when(orderItemService.createDynamicPriceDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any(),
        Mockito.<HashMap<Object, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(order, itemRequest, new HashMap(), true));
    verify(orderItemService).createDynamicPriceDiscreteOrderItem(isA(DiscreteOrderItemRequest.class),
        isA(HashMap.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LegacyOrderServiceImpl}
   *   <li>{@link LegacyOrderServiceImpl#setFulfillmentGroupDao(FulfillmentGroupDao)}
   *   <li>{@link LegacyOrderServiceImpl#setFulfillmentGroupItemDao(FulfillmentGroupItemDao)}
   *   <li>{@link LegacyOrderServiceImpl#setOrderDao(OrderDao)}
   *   <li>{@link LegacyOrderServiceImpl#setOrderItemService(OrderItemService)}
   *   <li>{@link LegacyOrderServiceImpl#setPaymentInfoDao(OrderPaymentDao)}
   *   <li>{@link LegacyOrderServiceImpl#getFulfillmentGroupDao()}
   *   <li>{@link LegacyOrderServiceImpl#getFulfillmentGroupItemDao()}
   *   <li>{@link LegacyOrderServiceImpl#getOrderDao()}
   *   <li>{@link LegacyOrderServiceImpl#getOrderItemService()}
   *   <li>{@link LegacyOrderServiceImpl#getPaymentInfoDao()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.<init>()",
      "FulfillmentGroupDao LegacyOrderServiceImpl.getFulfillmentGroupDao()",
      "FulfillmentGroupItemDao LegacyOrderServiceImpl.getFulfillmentGroupItemDao()",
      "OrderDao LegacyOrderServiceImpl.getOrderDao()", "OrderItemService LegacyOrderServiceImpl.getOrderItemService()",
      "OrderPaymentDao LegacyOrderServiceImpl.getPaymentInfoDao()",
      "void LegacyOrderServiceImpl.setFulfillmentGroupDao(FulfillmentGroupDao)",
      "void LegacyOrderServiceImpl.setFulfillmentGroupItemDao(FulfillmentGroupItemDao)",
      "void LegacyOrderServiceImpl.setOrderDao(OrderDao)",
      "void LegacyOrderServiceImpl.setOrderItemService(OrderItemService)",
      "void LegacyOrderServiceImpl.setPaymentInfoDao(OrderPaymentDao)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    LegacyOrderServiceImpl actualLegacyOrderServiceImpl = new LegacyOrderServiceImpl();
    FulfillmentGroupDaoImpl fulfillmentGroupDao = new FulfillmentGroupDaoImpl();
    actualLegacyOrderServiceImpl.setFulfillmentGroupDao(fulfillmentGroupDao);
    FulfillmentGroupItemDaoImpl fulfillmentGroupItemDao = new FulfillmentGroupItemDaoImpl();
    actualLegacyOrderServiceImpl.setFulfillmentGroupItemDao(fulfillmentGroupItemDao);
    OrderDaoImpl orderDao = new OrderDaoImpl();
    actualLegacyOrderServiceImpl.setOrderDao(orderDao);
    OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
    actualLegacyOrderServiceImpl.setOrderItemService(orderItemService);
    OrderPaymentDaoImpl paymentInfoDao = new OrderPaymentDaoImpl();
    actualLegacyOrderServiceImpl.setPaymentInfoDao(paymentInfoDao);
    FulfillmentGroupDao actualFulfillmentGroupDao = actualLegacyOrderServiceImpl.getFulfillmentGroupDao();
    FulfillmentGroupItemDao actualFulfillmentGroupItemDao = actualLegacyOrderServiceImpl.getFulfillmentGroupItemDao();
    OrderDao actualOrderDao = actualLegacyOrderServiceImpl.getOrderDao();
    OrderItemService actualOrderItemService = actualLegacyOrderServiceImpl.getOrderItemService();
    OrderPaymentDao actualPaymentInfoDao = actualLegacyOrderServiceImpl.getPaymentInfoDao();

    // Assert
    assertTrue(actualFulfillmentGroupDao instanceof FulfillmentGroupDaoImpl);
    assertTrue(actualFulfillmentGroupItemDao instanceof FulfillmentGroupItemDaoImpl);
    assertTrue(actualOrderDao instanceof OrderDaoImpl);
    assertTrue(actualOrderItemService instanceof OrderItemServiceImpl);
    assertTrue(actualPaymentInfoDao instanceof OrderPaymentDaoImpl);
    assertTrue(actualLegacyOrderServiceImpl.isDeleteEmptyNamedOrders());
    assertTrue(actualLegacyOrderServiceImpl.isMoveNamedOrderItems());
    assertSame(fulfillmentGroupDao, actualFulfillmentGroupDao);
    assertSame(fulfillmentGroupItemDao, actualFulfillmentGroupItemDao);
    assertSame(orderDao, actualOrderDao);
    assertSame(orderItemService, actualOrderItemService);
    assertSame(paymentInfoDao, actualPaymentInfoDao);
  }
}
