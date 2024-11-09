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
package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import org.broadleafcommerce.core.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.domain.ProratedOrderItemAdjustment;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetail;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper;
import org.broadleafcommerce.core.order.domain.BundleOrderItemFeePrice;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItem;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.OrderItemQualifier;
import org.broadleafcommerce.core.order.domain.OrderItemQualifierImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OfferServiceUtilitiesImplDiffblueTest {
  /**
   * Test {@link OfferServiceUtilitiesImpl#sortTargetItemDetails(List, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#sortTargetItemDetails(List, boolean)}
   */
  @Test
  public void testSortTargetItemDetails_givenAuditableCreatedByIsOne_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(order);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1));
    BroadleafCurrencyImpl broadleafCurrencyImpl2 = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl2.getCurrencyCode()).thenReturn("GBP");
    Order order2 = mock(Order.class);
    when(order2.getCurrency()).thenReturn(broadleafCurrencyImpl2);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem2 = new OrderItemImpl();
    orderItem2.setAuditable(auditable);
    orderItem2.setCandidateItemOffers(new ArrayList<>());
    orderItem2.setCartMessages(new ArrayList<>());
    orderItem2.setChildOrderItems(new ArrayList<>());
    orderItem2.setDiscountingAllowed(true);
    orderItem2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem2.setHasValidationError(true);
    orderItem2.setId(1L);
    orderItem2.setName("Name");
    orderItem2.setOrder(new NullOrderImpl());
    orderItem2.setOrderItemAdjustments(new ArrayList<>());
    orderItem2.setOrderItemAttributes(new HashMap<>());
    orderItem2.setOrderItemPriceDetails(new ArrayList<>());
    orderItem2.setOrderItemQualifiers(new ArrayList<>());
    orderItem2.setOrderItemType(OrderItemType.BASIC);
    orderItem2.setParentOrderItem(new BundleOrderItemImpl());
    orderItem2.setPersonalMessage(new PersonalMessageImpl());
    orderItem2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem2.setQuantity(1);
    orderItem2.setRetailPrice(new Money());
    orderItem2.setRetailPriceOverride(true);
    orderItem2.setSalePrice(new Money());
    orderItem2.setSalePriceOverride(true);
    orderItem2.setTaxable(true);
    orderItem2.updateSaleAndRetailPrices();
    orderItem2.addCandidateItemOffer(new CandidateItemOfferImpl());
    orderItem2.setOrder(order2);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper2 = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem2, null, null, true), 1));

    ArrayList<PromotableOrderItemPriceDetail> itemPriceDetails = new ArrayList<>();
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper2);
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper);

    // Act
    offerServiceUtilitiesImpl.sortTargetItemDetails(itemPriceDetails, true);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(broadleafCurrencyImpl2, atLeast(1)).getCurrencyCode();
    verify(order).getCurrency();
    verify(order2, atLeast(1)).getCurrency();
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#sortTargetItemDetails(List, boolean)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#sortTargetItemDetails(List, boolean)}
   */
  @Test
  public void testSortTargetItemDetails_givenBundleOrderItemImplOrderIsNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(order);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1));

    BundleOrderItemImpl orderItem2 = new BundleOrderItemImpl();
    orderItem2.setOrder(new NullOrderImpl());
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper2 = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem2, null, null, true), 1));

    ArrayList<PromotableOrderItemPriceDetail> itemPriceDetails = new ArrayList<>();
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper2);
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper);

    // Act
    offerServiceUtilitiesImpl.sortTargetItemDetails(itemPriceDetails, true);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#sortTargetItemDetails(List, boolean)}.
   * <ul>
   *   <li>Given {@link Order} {@link Order#getCurrency()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#sortTargetItemDetails(List, boolean)}
   */
  @Test
  public void testSortTargetItemDetails_givenOrderGetCurrencyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(order);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1));
    Order order2 = mock(Order.class);
    when(order2.getCurrency()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem2 = new OrderItemImpl();
    orderItem2.setAuditable(auditable);
    orderItem2.setCandidateItemOffers(new ArrayList<>());
    orderItem2.setCartMessages(new ArrayList<>());
    orderItem2.setChildOrderItems(new ArrayList<>());
    orderItem2.setDiscountingAllowed(true);
    orderItem2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem2.setHasValidationError(true);
    orderItem2.setId(1L);
    orderItem2.setName("Name");
    orderItem2.setOrder(new NullOrderImpl());
    orderItem2.setOrderItemAdjustments(new ArrayList<>());
    orderItem2.setOrderItemAttributes(new HashMap<>());
    orderItem2.setOrderItemPriceDetails(new ArrayList<>());
    orderItem2.setOrderItemQualifiers(new ArrayList<>());
    orderItem2.setOrderItemType(OrderItemType.BASIC);
    orderItem2.setParentOrderItem(new BundleOrderItemImpl());
    orderItem2.setPersonalMessage(new PersonalMessageImpl());
    orderItem2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem2.setQuantity(1);
    orderItem2.setRetailPrice(new Money());
    orderItem2.setRetailPriceOverride(true);
    orderItem2.setSalePrice(new Money());
    orderItem2.setSalePriceOverride(true);
    orderItem2.setTaxable(true);
    orderItem2.updateSaleAndRetailPrices();
    orderItem2.addCandidateItemOffer(new CandidateItemOfferImpl());
    orderItem2.setOrder(order2);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper2 = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem2, null, null, true), 1));

    ArrayList<PromotableOrderItemPriceDetail> itemPriceDetails = new ArrayList<>();
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper2);
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper);

    // Act
    offerServiceUtilitiesImpl.sortTargetItemDetails(itemPriceDetails, true);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order2, atLeast(1)).getCurrency();
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#sortQualifierItemDetails(List, boolean)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#sortQualifierItemDetails(List, boolean)}
   */
  @Test
  public void testSortQualifierItemDetails_givenBundleOrderItemImplOrderIsNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(order);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1));

    BundleOrderItemImpl orderItem2 = new BundleOrderItemImpl();
    orderItem2.setOrder(new NullOrderImpl());
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper2 = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem2, null, null, true), 1));

    ArrayList<PromotableOrderItemPriceDetail> itemPriceDetails = new ArrayList<>();
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper2);
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper);

    // Act
    offerServiceUtilitiesImpl.sortQualifierItemDetails(itemPriceDetails, true);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#sortQualifierItemDetails(List, boolean)}.
   * <ul>
   *   <li>Given {@link Order} {@link Order#getCurrency()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#sortQualifierItemDetails(List, boolean)}
   */
  @Test
  public void testSortQualifierItemDetails_givenOrderGetCurrencyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(order);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1));
    Order order2 = mock(Order.class);
    when(order2.getCurrency()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem2 = new OrderItemImpl();
    orderItem2.setAuditable(auditable);
    orderItem2.setCandidateItemOffers(new ArrayList<>());
    orderItem2.setCartMessages(new ArrayList<>());
    orderItem2.setChildOrderItems(new ArrayList<>());
    orderItem2.setDiscountingAllowed(true);
    orderItem2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem2.setHasValidationError(true);
    orderItem2.setId(1L);
    orderItem2.setName("Name");
    orderItem2.setOrder(new NullOrderImpl());
    orderItem2.setOrderItemAdjustments(new ArrayList<>());
    orderItem2.setOrderItemAttributes(new HashMap<>());
    orderItem2.setOrderItemPriceDetails(new ArrayList<>());
    orderItem2.setOrderItemQualifiers(new ArrayList<>());
    orderItem2.setOrderItemType(OrderItemType.BASIC);
    orderItem2.setParentOrderItem(new BundleOrderItemImpl());
    orderItem2.setPersonalMessage(new PersonalMessageImpl());
    orderItem2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem2.setQuantity(1);
    orderItem2.setRetailPrice(new Money());
    orderItem2.setRetailPriceOverride(true);
    orderItem2.setSalePrice(new Money());
    orderItem2.setSalePriceOverride(true);
    orderItem2.setTaxable(true);
    orderItem2.updateSaleAndRetailPrices();
    orderItem2.addCandidateItemOffer(new CandidateItemOfferImpl());
    orderItem2.setOrder(order2);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper2 = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem2, null, null, true), 1));

    ArrayList<PromotableOrderItemPriceDetail> itemPriceDetails = new ArrayList<>();
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper2);
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper);

    // Act
    offerServiceUtilitiesImpl.sortQualifierItemDetails(itemPriceDetails, true);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order2, atLeast(1)).getCurrency();
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#sortQualifierItemDetails(List, boolean)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#sortQualifierItemDetails(List, boolean)}
   */
  @Test
  public void testSortQualifierItemDetails_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(order);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1));
    BroadleafCurrencyImpl broadleafCurrencyImpl2 = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl2.getCurrencyCode()).thenReturn("GBP");
    Order order2 = mock(Order.class);
    when(order2.getCurrency()).thenReturn(broadleafCurrencyImpl2);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem2 = new OrderItemImpl();
    orderItem2.setAuditable(auditable);
    orderItem2.setCandidateItemOffers(new ArrayList<>());
    orderItem2.setCartMessages(new ArrayList<>());
    orderItem2.setChildOrderItems(new ArrayList<>());
    orderItem2.setDiscountingAllowed(true);
    orderItem2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem2.setHasValidationError(true);
    orderItem2.setId(1L);
    orderItem2.setName("Name");
    orderItem2.setOrder(new NullOrderImpl());
    orderItem2.setOrderItemAdjustments(new ArrayList<>());
    orderItem2.setOrderItemAttributes(new HashMap<>());
    orderItem2.setOrderItemPriceDetails(new ArrayList<>());
    orderItem2.setOrderItemQualifiers(new ArrayList<>());
    orderItem2.setOrderItemType(OrderItemType.BASIC);
    orderItem2.setParentOrderItem(new BundleOrderItemImpl());
    orderItem2.setPersonalMessage(new PersonalMessageImpl());
    orderItem2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem2.setQuantity(1);
    orderItem2.setRetailPrice(new Money());
    orderItem2.setRetailPriceOverride(true);
    orderItem2.setSalePrice(new Money());
    orderItem2.setSalePriceOverride(true);
    orderItem2.setTaxable(true);
    orderItem2.updateSaleAndRetailPrices();
    orderItem2.addCandidateItemOffer(new CandidateItemOfferImpl());
    orderItem2.setOrder(order2);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper2 = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem2, null, null, true), 1));

    ArrayList<PromotableOrderItemPriceDetail> itemPriceDetails = new ArrayList<>();
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper2);
    itemPriceDetails.add(promotableOrderItemPriceDetailWrapper);

    // Act
    offerServiceUtilitiesImpl.sortQualifierItemDetails(itemPriceDetails, true);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(broadleafCurrencyImpl2, atLeast(1)).getCurrencyCode();
    verify(order).getCurrency();
    verify(order2, atLeast(1)).getCurrency();
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}
   */
  @Test
  public void testFindRelatedQualifierRoot() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        mock(PromotableOfferUtilityImpl.class));
    BundleOrderItemImpl relatedQualifier = new BundleOrderItemImpl();

    // Act and Assert
    assertSame(relatedQualifier, offerServiceUtilitiesImpl.findRelatedQualifierRoot(relatedQualifier));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}
   */
  @Test
  public void testFindRelatedQualifierRoot_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

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
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}
   */
  @Test
  public void testFindRelatedQualifierRoot_whenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
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
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#findRelatedQualifierRoot(OrderItem)}
   */
  @Test
  public void testFindRelatedQualifierRoot_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl())).findRelatedQualifierRoot(null));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}
   */
  @Test
  public void testIsAddOnOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        mock(PromotableOfferUtilityImpl.class));

    // Act and Assert
    assertFalse(offerServiceUtilitiesImpl.isAddOnOrderItem(new BundleOrderItemImpl()));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}
   */
  @Test
  public void testIsAddOnOrderItem_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
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
   *   <li>Given {@link HashMap#HashMap()} {@code addOnXrefId} is
   * {@code addOnXrefId}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}
   */
  @Test
  public void testIsAddOnOrderItem_givenHashMapAddOnXrefIdIsAddOnXrefId_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

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
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}
   */
  @Test
  public void testIsAddOnOrderItem_givenTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
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
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#isAddOnOrderItem(OrderItem)}
   */
  @Test
  public void testIsAddOnOrderItem_whenBundleOrderItemImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertFalse(offerServiceUtilitiesImpl.isAddOnOrderItem(new BundleOrderItemImpl()));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}
   */
  @Test
  public void testBuildOrderItemList_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

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
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(discreteOrderItems, offerServiceUtilitiesImpl.buildOrderItemList(order));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}
   */
  @Test
  public void testBuildOrderItemList_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

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
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isPricingAtContainerLevel()).thenReturn(true);
    when(bundleOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    doNothing().when(bundleOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBundleOrderItemFeePrices(Mockito.<List<BundleOrderItemFeePrice>>any());
    doNothing().when(bundleOrderItemImpl).setDiscreteOrderItems(Mockito.<List<DiscreteOrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(bundleOrderItemImpl).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(bundleOrderItemImpl).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(bundleOrderItemImpl).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setDiscountingAllowed(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(bundleOrderItemImpl).setId(Mockito.<Long>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl)
        .setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
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
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act
    List<OrderItem> actualBuildOrderItemListResult = offerServiceUtilitiesImpl.buildOrderItemList(order);

    // Assert
    verify(bundleOrderItemImpl).isPricingAtContainerLevel();
    verify(bundleOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBundleOrderItemFeePrices(isA(List.class));
    verify(bundleOrderItemImpl).setDiscreteOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).updateSaleAndRetailPrices();
    verify(bundleOrderItemImpl).setAuditable(isA(Auditable.class));
    verify(bundleOrderItemImpl).setCandidateItemOffers(isA(List.class));
    verify(bundleOrderItemImpl).setCartMessages(isA(List.class));
    verify(bundleOrderItemImpl).setChildOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).setDiscountingAllowed(eq(true));
    verify(bundleOrderItemImpl).setGiftWrapOrderItem(isA(GiftWrapOrderItem.class));
    verify(bundleOrderItemImpl).setHasValidationError(eq(true));
    verify(bundleOrderItemImpl).setId(eq(1L));
    verify(bundleOrderItemImpl).setName(eq("Name"));
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemAttributes(isA(Map.class));
    verify(bundleOrderItemImpl).setOrderItemPriceDetails(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemQualifiers(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemType(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setParentOrderItem(isA(OrderItem.class));
    verify(bundleOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(bundleOrderItemImpl).setProratedOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setQuantity(eq(1));
    verify(bundleOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(bundleOrderItemImpl).setSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setSalePriceOverride(eq(true));
    verify(bundleOrderItemImpl).setTaxable(eq(true));
    assertEquals(1, actualBuildOrderItemListResult.size());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}
   */
  @Test
  public void testBuildPromotableItemMap_givenAuditableCreatedByIsOne_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(offerServiceUtilitiesImpl
        .buildPromotableItemMap(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .isEmpty());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}
   */
  @Test
  public void testBuildPromotableItemMap_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(1,
        offerServiceUtilitiesImpl
            .buildPromotableItemMap(
                new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
            .size());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  public void testBuildItemDetailAdjustmentMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        mock(PromotableOfferUtilityImpl.class));

    // Act and Assert
    assertTrue(offerServiceUtilitiesImpl.buildItemDetailAdjustmentMap(new OrderItemPriceDetailImpl()).isEmpty());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  public void testBuildItemDetailAdjustmentMap_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
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
   * Test
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <ul>
   *   <li>When {@link OrderItemPriceDetailImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  public void testBuildItemDetailAdjustmentMap_whenOrderItemPriceDetailImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(offerServiceUtilitiesImpl.buildItemDetailAdjustmentMap(new OrderItemPriceDetailImpl()).isEmpty());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testUpdatePriceDetail() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        mock(PromotableOfferUtilityImpl.class));
    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();

    // Act
    offerServiceUtilitiesImpl.updatePriceDetail(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));

    // Assert
    assertEquals(1, itemDetail.getQuantity());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls
   * {@link OrderItemPriceDetailImpl#getOrderItemPriceDetailAdjustments()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testUpdatePriceDetail_givenArrayList_thenCallsGetOrderItemPriceDetailAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    OrderItemPriceDetailImpl itemDetail = mock(OrderItemPriceDetailImpl.class);
    when(itemDetail.getQuantity()).thenReturn(1);
    when(itemDetail.getOrderItemPriceDetailAdjustments()).thenReturn(new ArrayList<>());

    // Act
    offerServiceUtilitiesImpl.updatePriceDetail(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));

    // Assert
    verify(itemDetail).getOrderItemPriceDetailAdjustments();
    verify(itemDetail).getQuantity();
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls
   * {@link PromotableOrderItemPriceDetail#getCandidateItemAdjustments()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testUpdatePriceDetail_givenTrue_thenCallsGetCandidateItemAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
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
   * Test
   * {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailImpl} (default constructor) Quantity is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#updatePriceDetail(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testUpdatePriceDetail_thenOrderItemPriceDetailImplQuantityIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();

    // Act
    offerServiceUtilitiesImpl.updatePriceDetail(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));

    // Assert
    assertEquals(1, itemDetail.getQuantity());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)}
   */
  @Test
  public void testUpdateItemAdjustment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        mock(PromotableOfferUtilityImpl.class));
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
   * Test
   * {@link OfferServiceUtilitiesImpl#updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)}.
   * <ul>
   *   <li>Then calls
   * {@link OrderItemPriceDetailAdjustmentImpl#setAppliedToSalePrice(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#updateItemAdjustment(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetailAdjustment)}
   */
  @Test
  public void testUpdateItemAdjustment_thenCallsSetAppliedToSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        mock(PromotableOfferUtilityImpl.class));
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
   * Test
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}
   */
  @Test
  public void testRemoveUnmatchedPriceDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        mock(PromotableOfferUtilityImpl.class));
    HashMap<Long, OrderItemPriceDetail> unmatchedDetailsMap = new HashMap<>();

    ArrayList<OrderItemPriceDetail> orderItemPriceDetailList = new ArrayList<>();
    Iterator<OrderItemPriceDetail> pdIterator = orderItemPriceDetailList.iterator();

    // Act
    offerServiceUtilitiesImpl.removeUnmatchedPriceDetails(unmatchedDetailsMap, pdIterator);

    // Assert that nothing has changed
    assertFalse(pdIterator.hasNext());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}
   */
  @Test
  public void testRemoveUnmatchedPriceDetails_givenOrderItemPriceDetailImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    HashMap<Long, OrderItemPriceDetail> unmatchedDetailsMap = new HashMap<>();

    ArrayList<OrderItemPriceDetail> orderItemPriceDetailList = new ArrayList<>();
    orderItemPriceDetailList.add(new OrderItemPriceDetailImpl());
    Iterator<OrderItemPriceDetail> pdIterator = orderItemPriceDetailList.iterator();

    // Act
    offerServiceUtilitiesImpl.removeUnmatchedPriceDetails(unmatchedDetailsMap, pdIterator);

    // Assert that nothing has changed
    assertFalse(pdIterator.hasNext());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}.
   * <ul>
   *   <li>Then not {@link ArrayList#ArrayList()} iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedPriceDetails(Map, Iterator)}
   */
  @Test
  public void testRemoveUnmatchedPriceDetails_thenNotArrayListIteratorHasNext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    HashMap<Long, OrderItemPriceDetail> unmatchedDetailsMap = new HashMap<>();

    ArrayList<OrderItemPriceDetail> orderItemPriceDetailList = new ArrayList<>();
    Iterator<OrderItemPriceDetail> pdIterator = orderItemPriceDetailList.iterator();

    // Act
    offerServiceUtilitiesImpl.removeUnmatchedPriceDetails(unmatchedDetailsMap, pdIterator);

    // Assert that nothing has changed
    assertFalse(pdIterator.hasNext());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}
   */
  @Test
  public void testRemoveUnmatchedQualifiers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        mock(PromotableOfferUtilityImpl.class));
    HashMap<Long, OrderItemQualifier> unmatchedQualifiersMap = new HashMap<>();

    ArrayList<OrderItemQualifier> orderItemQualifierList = new ArrayList<>();
    Iterator<OrderItemQualifier> qIterator = orderItemQualifierList.iterator();

    // Act
    offerServiceUtilitiesImpl.removeUnmatchedQualifiers(unmatchedQualifiersMap, qIterator);

    // Assert that nothing has changed
    assertFalse(qIterator.hasNext());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}.
   * <ul>
   *   <li>Given {@link OrderItemQualifierImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}
   */
  @Test
  public void testRemoveUnmatchedQualifiers_givenOrderItemQualifierImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    HashMap<Long, OrderItemQualifier> unmatchedQualifiersMap = new HashMap<>();

    ArrayList<OrderItemQualifier> orderItemQualifierList = new ArrayList<>();
    orderItemQualifierList.add(new OrderItemQualifierImpl());
    Iterator<OrderItemQualifier> qIterator = orderItemQualifierList.iterator();

    // Act
    offerServiceUtilitiesImpl.removeUnmatchedQualifiers(unmatchedQualifiersMap, qIterator);

    // Assert that nothing has changed
    assertFalse(qIterator.hasNext());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}.
   * <ul>
   *   <li>Then not {@link ArrayList#ArrayList()} iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#removeUnmatchedQualifiers(Map, Iterator)}
   */
  @Test
  public void testRemoveUnmatchedQualifiers_thenNotArrayListIteratorHasNext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
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
   *   <li>
   * {@link OfferServiceUtilitiesImpl#setGenericEntityService(GenericEntityService)}
   *   <li>{@link OfferServiceUtilitiesImpl#setOfferDao(OfferDao)}
   *   <li>
   * {@link OfferServiceUtilitiesImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OfferServiceUtilitiesImpl#getGenericEntityService()}
   *   <li>{@link OfferServiceUtilitiesImpl#getOfferDao()}
   *   <li>{@link OfferServiceUtilitiesImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
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

    // Assert that nothing has changed
    assertTrue(actualGenericEntityService instanceof GenericEntityServiceImpl);
    assertTrue(actualOfferDao instanceof OfferDaoImpl);
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(entityService, actualGenericEntityService);
    assertSame(offerDao, actualOfferDao);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
  }
}
