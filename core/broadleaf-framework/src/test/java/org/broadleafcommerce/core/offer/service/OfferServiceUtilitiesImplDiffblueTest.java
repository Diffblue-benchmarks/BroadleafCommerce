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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OfferServiceUtilitiesImplDiffblueTest {
  @InjectMocks
  private OfferServiceUtilitiesImpl offerServiceUtilitiesImpl;

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
  @MethodsUnderTest({"java.util.List OfferServiceUtilitiesImpl.buildOrderItemList(Order)"})
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
    order.setTotalShipping(new Money());
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
}
