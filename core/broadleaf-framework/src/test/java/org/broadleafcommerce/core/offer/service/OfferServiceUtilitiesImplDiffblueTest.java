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
package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtility;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetail;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.OrderItemQualifier;
import org.broadleafcommerce.core.order.domain.OrderItemQualifierImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OfferServiceUtilitiesImplDiffblueTest {
  @Mock
  private GenericEntityService genericEntityService;

  @Mock
  private OfferDao offerDao;

  @InjectMocks
  private OfferServiceUtilitiesImpl offerServiceUtilitiesImpl;

  @Mock
  private PromotableItemFactory promotableItemFactory;

  @Mock
  private PromotableOfferUtility promotableOfferUtility;

  /**
   * Test {@link OfferServiceUtilitiesImpl#sortTargetItemDetails(List, boolean)}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#getOrderItemPriceDetails()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#sortTargetItemDetails(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceUtilitiesImpl.sortTargetItemDetails(List, boolean)"})
  public void testSortTargetItemDetails_thenCallsGetOrderItemPriceDetails() {
    // Arrange
    OrderItemImpl orderItem = mock(OrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(new Money());
    doNothing().when(orderItem).setOrder(Mockito.<Order>any());
    orderItem.setOrder(mock(Order.class));
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(orderItem, null, promotableItemFactory, true), 1));

    BundleOrderItemImpl orderItem2 = new BundleOrderItemImpl();
    orderItem2.setOrder(new NullOrderImpl());
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper2 = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(orderItem2, null, promotableItemFactory, true), 1));

    ArrayList<PromotableOrderItemPriceDetail> itemPriceDetails = new ArrayList<>();
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper2);
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper);

    // Act
    offerServiceUtilitiesImpl.sortTargetItemDetails(itemPriceDetails, true);

    // Assert
    verify(orderItem).getOrderItemPriceDetails();
    verify(orderItem, atLeast(1)).getSalePrice();
    verify(orderItem).setOrder(isA(Order.class));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#sortQualifierItemDetails(List, boolean)}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#getOrderItemPriceDetails()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#sortQualifierItemDetails(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceUtilitiesImpl.sortQualifierItemDetails(List, boolean)"})
  public void testSortQualifierItemDetails_thenCallsGetOrderItemPriceDetails() {
    // Arrange
    OrderItemImpl orderItem = mock(OrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(new Money());
    doNothing().when(orderItem).setOrder(Mockito.<Order>any());
    orderItem.setOrder(mock(Order.class));
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(orderItem, null, promotableItemFactory, true), 1));

    BundleOrderItemImpl orderItem2 = new BundleOrderItemImpl();
    orderItem2.setOrder(new NullOrderImpl());
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper2 = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(orderItem2, null, promotableItemFactory, true), 1));

    ArrayList<PromotableOrderItemPriceDetail> itemPriceDetails = new ArrayList<>();
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper2);
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper);

    // Act
    offerServiceUtilitiesImpl.sortQualifierItemDetails(itemPriceDetails, true);

    // Assert
    verify(orderItem).getOrderItemPriceDetails();
    verify(orderItem, atLeast(1)).getSalePrice();
    verify(orderItem).setOrder(isA(Order.class));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OfferServiceUtilitiesImpl.findRelatedQualifierRoot(OrderItem)"})
  public void testFindRelatedQualifierRoot_givenAuditableCreatedByIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl relatedQualifier = new BundleOrderItemImpl();
    relatedQualifier.setAuditable(auditable);
    relatedQualifier.setBaseRetailPrice(new Money());
    relatedQualifier.setBaseSalePrice(new Money());
    relatedQualifier.setBundleOrderItemFeePrices(new ArrayList<>());
    relatedQualifier.setCandidateItemOffers(new ArrayList<>());
    relatedQualifier.setCartMessages(new ArrayList<>());
    relatedQualifier.setChildOrderItems(new ArrayList<>());
    relatedQualifier.setDiscountingAllowed(true);
    relatedQualifier.setDiscreteOrderItems(new ArrayList<>());
    relatedQualifier.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    relatedQualifier.setHasValidationError(true);
    relatedQualifier.setId(1L);
    relatedQualifier.setName("Name");
    relatedQualifier.setOrder(new NullOrderImpl());
    relatedQualifier.setOrderItemAdjustments(new ArrayList<>());
    relatedQualifier.setOrderItemAttributes(new HashMap<>());
    relatedQualifier.setOrderItemPriceDetails(new ArrayList<>());
    relatedQualifier.setOrderItemQualifiers(new ArrayList<>());
    relatedQualifier.setOrderItemType(OrderItemType.BASIC);
    relatedQualifier.setPersonalMessage(new PersonalMessageImpl());
    relatedQualifier.setPrice(new Money());
    relatedQualifier.setProratedOrderItemAdjustments(new ArrayList<>());
    relatedQualifier.setQuantity(1);
    relatedQualifier.setRetailPrice(new Money());
    relatedQualifier.setRetailPriceOverride(true);
    relatedQualifier.setSalePrice(new Money());
    relatedQualifier.setSalePriceOverride(true);
    relatedQualifier.setTaxable(true);
    relatedQualifier.updateSaleAndRetailPrices();
    BundleOrderItemImpl parentOrderItem = new BundleOrderItemImpl();
    relatedQualifier.setParentOrderItem(parentOrderItem);

    // Act and Assert
    assertSame(parentOrderItem, offerServiceUtilitiesImpl.findRelatedQualifierRoot(relatedQualifier));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OfferServiceUtilitiesImpl.findRelatedQualifierRoot(OrderItem)"})
  public void testFindRelatedQualifierRoot_whenBundleOrderItemImpl() {
    // Arrange
    BundleOrderItemImpl relatedQualifier = new BundleOrderItemImpl();

    // Act and Assert
    assertSame(relatedQualifier, offerServiceUtilitiesImpl.findRelatedQualifierRoot(relatedQualifier));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OfferServiceUtilitiesImpl.findRelatedQualifierRoot(OrderItem)"})
  public void testFindRelatedQualifierRoot_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(offerServiceUtilitiesImpl.findRelatedQualifierRoot(null));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferServiceUtilitiesImpl.isAddOnOrderItem(OrderItem)"})
  public void testIsAddOnOrderItem_givenFalse() {
    // Arrange
    DiscreteOrderItemImpl orderItem = mock(DiscreteOrderItemImpl.class);
    when(orderItem.isChildOrderItem()).thenReturn(false);
    when(orderItem.getAdditionalAttributes()).thenReturn(new HashMap<>());

    // Act
    boolean actualIsAddOnOrderItemResult = offerServiceUtilitiesImpl.isAddOnOrderItem(orderItem);

    // Assert
    verify(orderItem).getAdditionalAttributes();
    verify(orderItem).isChildOrderItem();
    assertFalse(actualIsAddOnOrderItemResult);
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code addOnXrefId} is {@code addOnXrefId}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferServiceUtilitiesImpl.isAddOnOrderItem(OrderItem)"})
  public void testIsAddOnOrderItem_givenHashMapAddOnXrefIdIsAddOnXrefId_thenReturnTrue() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("addOnXrefId", "addOnXrefId");
    DiscreteOrderItemImpl orderItem = mock(DiscreteOrderItemImpl.class);
    when(orderItem.isChildOrderItem()).thenReturn(true);
    when(orderItem.getAdditionalAttributes()).thenReturn(stringStringMap);

    // Act
    boolean actualIsAddOnOrderItemResult = offerServiceUtilitiesImpl.isAddOnOrderItem(orderItem);

    // Assert
    verify(orderItem).getAdditionalAttributes();
    verify(orderItem).isChildOrderItem();
    assertTrue(actualIsAddOnOrderItemResult);
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferServiceUtilitiesImpl.isAddOnOrderItem(OrderItem)"})
  public void testIsAddOnOrderItem_givenTrue() {
    // Arrange
    DiscreteOrderItemImpl orderItem = mock(DiscreteOrderItemImpl.class);
    when(orderItem.isChildOrderItem()).thenReturn(true);
    when(orderItem.getAdditionalAttributes()).thenReturn(new HashMap<>());

    // Act
    boolean actualIsAddOnOrderItemResult = offerServiceUtilitiesImpl.isAddOnOrderItem(orderItem);

    // Assert
    verify(orderItem).getAdditionalAttributes();
    verify(orderItem).isChildOrderItem();
    assertFalse(actualIsAddOnOrderItemResult);
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferServiceUtilitiesImpl.isAddOnOrderItem(OrderItem)"})
  public void testIsAddOnOrderItem_whenBundleOrderItemImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerServiceUtilitiesImpl.isAddOnOrderItem(new BundleOrderItemImpl()));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceUtilitiesImpl.buildOrderItemList(Order)"})
  public void testBuildOrderItemList_givenAuditableCreatedByIsOne_thenReturnArrayList() {
    // Arrange
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

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(discreteOrderItems, offerServiceUtilitiesImpl.buildOrderItemList(order));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceUtilitiesImpl.buildOrderItemList(Order)"})
  public void testBuildOrderItemList_givenAuditableCreatedByIsOne_thenReturnArrayList2() {
    // Arrange
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

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(discreteOrderItems, offerServiceUtilitiesImpl.buildOrderItemList(order));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceUtilitiesImpl.buildPromotableItemMap(PromotableOrder)"})
  public void testBuildPromotableItemMap_givenAuditableCreatedByIsOne_thenReturnEmpty() {
    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

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
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(offerServiceUtilitiesImpl
        .buildPromotableItemMap(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .isEmpty());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceUtilitiesImpl.buildPromotableItemMap(PromotableOrder)"})
  public void testBuildPromotableItemMap_givenAuditableCreatedByIsOne_thenReturnEmpty2() {
    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

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
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(offerServiceUtilitiesImpl
        .buildPromotableItemMap(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .isEmpty());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceUtilitiesImpl.buildPromotableItemMap(PromotableOrder)"})
  public void testBuildPromotableItemMap_thenReturnSizeIsOne() {
    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals(1,
        offerServiceUtilitiesImpl
            .buildPromotableItemMap(
                new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
            .size());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceUtilitiesImpl.buildPromotableItemMap(PromotableOrder)"})
  public void testBuildPromotableItemMap_thenReturnSizeIsOne2() {
    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals(1,
        offerServiceUtilitiesImpl
            .buildPromotableItemMap(
                new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
            .size());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceUtilitiesImpl.buildItemDetailAdjustmentMap(OrderItemPriceDetail)"})
  public void testBuildItemDetailAdjustmentMap_thenReturnSizeIsOne() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = mock(
        OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.getOffer()).thenReturn(new OfferImpl());

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();
    itemDetail.setId(1L);
    itemDetail.setOrderItem(new BundleOrderItemImpl());
    itemDetail.setQuantity(1);
    itemDetail.setUseSalePrice(true);
    itemDetail.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act
    Map<Long, OrderItemPriceDetailAdjustment> actualBuildItemDetailAdjustmentMapResult = offerServiceUtilitiesImpl
        .buildItemDetailAdjustmentMap(itemDetail);

    // Assert
    verify(orderItemPriceDetailAdjustmentImpl, atLeast(1)).getOffer();
    assertEquals(1, actualBuildItemDetailAdjustmentMapResult.size());
    assertTrue(actualBuildItemDetailAdjustmentMapResult.containsKey(null));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceUtilitiesImpl.buildItemDetailAdjustmentMap(OrderItemPriceDetail)"})
  public void testBuildItemDetailAdjustmentMap_thenReturnSizeIsOne2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = mock(
        OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.getOffer()).thenReturn(new OfferImpl());

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();
    itemDetail.setId(1L);
    itemDetail.setOrderItem(new BundleOrderItemImpl());
    itemDetail.setQuantity(1);
    itemDetail.setUseSalePrice(true);
    itemDetail.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act
    Map<Long, OrderItemPriceDetailAdjustment> actualBuildItemDetailAdjustmentMapResult = offerServiceUtilitiesImpl
        .buildItemDetailAdjustmentMap(itemDetail);

    // Assert
    verify(orderItemPriceDetailAdjustmentImpl, atLeast(1)).getOffer();
    assertEquals(1, actualBuildItemDetailAdjustmentMapResult.size());
    assertTrue(actualBuildItemDetailAdjustmentMapResult.containsKey(null));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <ul>
   *   <li>When {@link OrderItemPriceDetailImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceUtilitiesImpl.buildItemDetailAdjustmentMap(OrderItemPriceDetail)"})
  public void testBuildItemDetailAdjustmentMap_whenOrderItemPriceDetailImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(offerServiceUtilitiesImpl.buildItemDetailAdjustmentMap(new OrderItemPriceDetailImpl()).isEmpty());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <ul>
   *   <li>When {@link OrderItemPriceDetailImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceUtilitiesImpl.buildItemDetailAdjustmentMap(OrderItemPriceDetail)"})
  public void testBuildItemDetailAdjustmentMap_whenOrderItemPriceDetailImpl_thenReturnEmpty2() {
    // Arrange, Act and Assert
    assertTrue(offerServiceUtilitiesImpl.buildItemDetailAdjustmentMap(new OrderItemPriceDetailImpl()).isEmpty());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link OrderItemPriceDetailImpl#getOrderItemPriceDetailAdjustments()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OfferServiceUtilitiesImpl.updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)"})
  public void testUpdatePriceDetail_givenArrayList_thenCallsGetOrderItemPriceDetailAdjustments() {
    // Arrange
    OrderItemPriceDetailImpl itemDetail = mock(OrderItemPriceDetailImpl.class);
    when(itemDetail.getQuantity()).thenReturn(1);
    when(itemDetail.getOrderItemPriceDetailAdjustments()).thenReturn(new ArrayList<>());

    // Act
    offerServiceUtilitiesImpl.updatePriceDetail(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, promotableItemFactory, true), 1)));

    // Assert
    verify(itemDetail).getOrderItemPriceDetailAdjustments();
    verify(itemDetail).getQuantity();
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link PromotableOrderItemPriceDetail#getCandidateItemAdjustments()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OfferServiceUtilitiesImpl.updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)"})
  public void testUpdatePriceDetail_givenTrue_thenCallsGetCandidateItemAdjustments() {
    // Arrange
    OrderItemPriceDetailImpl itemDetail = mock(OrderItemPriceDetailImpl.class);
    doNothing().when(itemDetail).setUseSalePrice(anyBoolean());
    when(itemDetail.getQuantity()).thenReturn(1);
    when(itemDetail.getOrderItemPriceDetailAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderItemPriceDetail wrappedDetail = mock(PromotableOrderItemPriceDetail.class);
    when(wrappedDetail.useSaleAdjustments()).thenReturn(true);
    when(wrappedDetail.isAdjustmentsFinalized()).thenReturn(true);
    when(wrappedDetail.getQuantity()).thenReturn(1);
    when(wrappedDetail.getCandidateItemAdjustments()).thenReturn(new ArrayList<>());

    // Act
    offerServiceUtilitiesImpl.updatePriceDetail(itemDetail, new PromotableOrderItemPriceDetailWrapper(wrappedDetail));

    // Assert
    verify(wrappedDetail).getCandidateItemAdjustments();
    verify(wrappedDetail).getQuantity();
    verify(wrappedDetail).isAdjustmentsFinalized();
    verify(wrappedDetail).useSaleAdjustments();
    verify(itemDetail).getOrderItemPriceDetailAdjustments();
    verify(itemDetail).getQuantity();
    verify(itemDetail).setUseSalePrice(eq(true));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailImpl} (default constructor) Quantity is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OfferServiceUtilitiesImpl.updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)"})
  public void testUpdatePriceDetail_thenOrderItemPriceDetailImplQuantityIsOne() {
    // Arrange
    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();

    // Act
    offerServiceUtilitiesImpl.updatePriceDetail(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, promotableItemFactory, true), 1)));

    // Assert
    assertEquals(1, itemDetail.getQuantity());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)}.
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OfferServiceUtilitiesImpl.updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)"})
  public void testUpdateItemAdjustment() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetailAdjustmentImpl itemAdjustment2 = mock(OrderItemPriceDetailAdjustmentImpl.class);
    Money money = new Money();
    when(itemAdjustment2.getRetailPriceValue()).thenReturn(money);
    when(itemAdjustment2.isAppliedToSalePrice()).thenReturn(true);
    Money money2 = new Money();
    when(itemAdjustment2.getValue()).thenReturn(money2);
    when(itemAdjustment2.getOffer()).thenReturn(new OfferImpl());

    // Act
    offerServiceUtilitiesImpl.updateItemAdjustment(itemAdjustment, new PromotableOrderItemPriceDetailAdjustmentImpl(
        itemAdjustment2, new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1))));

    // Assert
    verify(itemAdjustment2).getOffer();
    verify(itemAdjustment2).getRetailPriceValue();
    verify(itemAdjustment2, atLeast(1)).getValue();
    verify(itemAdjustment2, atLeast(1)).isAppliedToSalePrice();
    assertTrue(itemAdjustment.isAppliedToSalePrice());
    assertSame(money, itemAdjustment.getRetailPriceValue());
    assertSame(money2, itemAdjustment.getSalesPriceValue());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)}.
   * <ul>
   *   <li>Then calls {@link OrderItemPriceDetailAdjustmentImpl#setAppliedToSalePrice(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OfferServiceUtilitiesImpl.updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)"})
  public void testUpdateItemAdjustment_thenCallsSetAppliedToSalePrice() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    doNothing().when(itemAdjustment).setAppliedToSalePrice(anyBoolean());
    doNothing().when(itemAdjustment).setRetailPriceValue(Mockito.<Money>any());
    doNothing().when(itemAdjustment).setSalesPriceValue(Mockito.<Money>any());
    doNothing().when(itemAdjustment).setValue(Mockito.<Money>any());
    OrderItemPriceDetailAdjustmentImpl itemAdjustment2 = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment2.getRetailPriceValue()).thenReturn(new Money());
    when(itemAdjustment2.isAppliedToSalePrice()).thenReturn(true);
    when(itemAdjustment2.getValue()).thenReturn(new Money());
    when(itemAdjustment2.getOffer()).thenReturn(new OfferImpl());

    // Act
    offerServiceUtilitiesImpl.updateItemAdjustment(itemAdjustment, new PromotableOrderItemPriceDetailAdjustmentImpl(
        itemAdjustment2, new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1))));

    // Assert
    verify(itemAdjustment2).getOffer();
    verify(itemAdjustment2).getRetailPriceValue();
    verify(itemAdjustment2, atLeast(1)).getValue();
    verify(itemAdjustment2, atLeast(1)).isAppliedToSalePrice();
    verify(itemAdjustment).setAppliedToSalePrice(eq(true));
    verify(itemAdjustment).setRetailPriceValue(isA(Money.class));
    verify(itemAdjustment).setSalesPriceValue(isA(Money.class));
    verify(itemAdjustment).setValue(isA(Money.class));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceUtilitiesImpl.removeUnmatchedPriceDetails(Map, Iterator)"})
  public void testRemoveUnmatchedPriceDetails_givenOrderItemPriceDetailImpl() {
    // Arrange
    HashMap<Long, OrderItemPriceDetail> unmatchedDetailsMap = new HashMap<>();

    ArrayList<OrderItemPriceDetail> orderItemPriceDetailList = new ArrayList<>();
    orderItemPriceDetailList.add(new OrderItemPriceDetailImpl());
    Iterator<OrderItemPriceDetail> pdIterator = orderItemPriceDetailList.iterator();

    // Act
    offerServiceUtilitiesImpl.removeUnmatchedPriceDetails(unmatchedDetailsMap, pdIterator);

    // Assert
    assertFalse(pdIterator.hasNext());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}.
   * <ul>
   *   <li>Then not {@link ArrayList#ArrayList()} iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceUtilitiesImpl.removeUnmatchedPriceDetails(Map, Iterator)"})
  public void testRemoveUnmatchedPriceDetails_thenNotArrayListIteratorHasNext() {
    // Arrange
    HashMap<Long, OrderItemPriceDetail> unmatchedDetailsMap = new HashMap<>();

    ArrayList<OrderItemPriceDetail> orderItemPriceDetailList = new ArrayList<>();
    Iterator<OrderItemPriceDetail> pdIterator = orderItemPriceDetailList.iterator();

    // Act
    offerServiceUtilitiesImpl.removeUnmatchedPriceDetails(unmatchedDetailsMap, pdIterator);

    // Assert that nothing has changed
    assertFalse(pdIterator.hasNext());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OrderItemQualifierImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceUtilitiesImpl.removeUnmatchedQualifiers(Map, Iterator)"})
  public void testRemoveUnmatchedQualifiers_whenArrayListAddOrderItemQualifierImpl() {
    // Arrange
    HashMap<Long, OrderItemQualifier> unmatchedQualifiersMap = new HashMap<>();

    ArrayList<OrderItemQualifier> orderItemQualifierList = new ArrayList<>();
    orderItemQualifierList.add(new OrderItemQualifierImpl());
    Iterator<OrderItemQualifier> qIterator = orderItemQualifierList.iterator();

    // Act
    offerServiceUtilitiesImpl.removeUnmatchedQualifiers(unmatchedQualifiersMap, qIterator);

    // Assert
    assertFalse(qIterator.hasNext());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then not {@link ArrayList#ArrayList()} iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceUtilitiesImpl.removeUnmatchedQualifiers(Map, Iterator)"})
  public void testRemoveUnmatchedQualifiers_whenHashMap_thenNotArrayListIteratorHasNext() {
    // Arrange
    HashMap<Long, OrderItemQualifier> unmatchedQualifiersMap = new HashMap<>();

    ArrayList<OrderItemQualifier> orderItemQualifierList = new ArrayList<>();
    Iterator<OrderItemQualifier> qIterator = orderItemQualifierList.iterator();

    // Act
    offerServiceUtilitiesImpl.removeUnmatchedQualifiers(unmatchedQualifiersMap, qIterator);

    // Assert that nothing has changed
    assertFalse(qIterator.hasNext());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferServiceUtilitiesImpl#setGenericEntityService(GenericEntityService)}
   *   <li>{@link OfferServiceUtilitiesImpl#setOfferDao(OfferDao)}
   *   <li>{@link OfferServiceUtilitiesImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OfferServiceUtilitiesImpl#getGenericEntityService()}
   *   <li>{@link OfferServiceUtilitiesImpl#getOfferDao()}
   *   <li>{@link OfferServiceUtilitiesImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericEntityService OfferServiceUtilitiesImpl.getGenericEntityService()",
      "OfferDao OfferServiceUtilitiesImpl.getOfferDao()",
      "PromotableItemFactory OfferServiceUtilitiesImpl.getPromotableItemFactory()",
      "void OfferServiceUtilitiesImpl.setGenericEntityService(GenericEntityService)",
      "void OfferServiceUtilitiesImpl.setOfferDao(OfferDao)",
      "void OfferServiceUtilitiesImpl.setPromotableItemFactory(PromotableItemFactory)"})
  public void testGettersAndSetters() {
    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    GenericEntityServiceImpl entityService = new GenericEntityServiceImpl();

    // Act
    offerServiceUtilitiesImpl.setGenericEntityService(entityService);
    OfferDaoImpl offerDao = new OfferDaoImpl();
    offerServiceUtilitiesImpl.setOfferDao(offerDao);
    PromotableItemFactoryImpl promotableItemFactory = new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    offerServiceUtilitiesImpl.setPromotableItemFactory(promotableItemFactory);
    GenericEntityService actualGenericEntityService = offerServiceUtilitiesImpl.getGenericEntityService();
    OfferDao actualOfferDao = offerServiceUtilitiesImpl.getOfferDao();
    PromotableItemFactory actualPromotableItemFactory = offerServiceUtilitiesImpl.getPromotableItemFactory();

    // Assert
    assertTrue(actualGenericEntityService instanceof GenericEntityServiceImpl);
    assertTrue(actualOfferDao instanceof OfferDaoImpl);
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(entityService, actualGenericEntityService);
    assertSame(offerDao, actualOfferDao);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferServiceUtilitiesImpl#setGenericEntityService(GenericEntityService)}
   *   <li>{@link OfferServiceUtilitiesImpl#setOfferDao(OfferDao)}
   *   <li>{@link OfferServiceUtilitiesImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OfferServiceUtilitiesImpl#getGenericEntityService()}
   *   <li>{@link OfferServiceUtilitiesImpl#getOfferDao()}
   *   <li>{@link OfferServiceUtilitiesImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericEntityService OfferServiceUtilitiesImpl.getGenericEntityService()",
      "OfferDao OfferServiceUtilitiesImpl.getOfferDao()",
      "PromotableItemFactory OfferServiceUtilitiesImpl.getPromotableItemFactory()",
      "void OfferServiceUtilitiesImpl.setGenericEntityService(GenericEntityService)",
      "void OfferServiceUtilitiesImpl.setOfferDao(OfferDao)",
      "void OfferServiceUtilitiesImpl.setPromotableItemFactory(PromotableItemFactory)"})
  public void testGettersAndSetters2() {
    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    GenericEntityServiceImpl entityService = new GenericEntityServiceImpl();

    // Act
    offerServiceUtilitiesImpl.setGenericEntityService(entityService);
    OfferDaoImpl offerDao = new OfferDaoImpl();
    offerServiceUtilitiesImpl.setOfferDao(offerDao);
    PromotableItemFactoryImpl promotableItemFactory = new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    offerServiceUtilitiesImpl.setPromotableItemFactory(promotableItemFactory);
    GenericEntityService actualGenericEntityService = offerServiceUtilitiesImpl.getGenericEntityService();
    OfferDao actualOfferDao = offerServiceUtilitiesImpl.getOfferDao();
    PromotableItemFactory actualPromotableItemFactory = offerServiceUtilitiesImpl.getPromotableItemFactory();

    // Assert
    assertTrue(actualGenericEntityService instanceof GenericEntityServiceImpl);
    assertTrue(actualOfferDao instanceof OfferDaoImpl);
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(entityService, actualGenericEntityService);
    assertSame(offerDao, actualOfferDao);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
  }
}
