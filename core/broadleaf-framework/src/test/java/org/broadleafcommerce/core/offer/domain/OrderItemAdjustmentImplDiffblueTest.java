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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OrderItemAdjustmentImplDiffblueTest {
  /**
   * Test {@link OrderItemAdjustmentImpl#init(OrderItem, Offer, String)}.
   * <ul>
   *   <li>Then {@link OrderItemAdjustmentImpl} (default constructor) OrderItem is
   * {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemAdjustmentImpl#init(OrderItem, Offer, String)}
   */
  @Test
  public void testInit_thenOrderItemAdjustmentImplOrderItemIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemAdjustmentImpl.init(orderItem, offer, "Just cause");

    // Assert
    Offer offer2 = orderItemAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals("Just cause", orderItemAdjustmentImpl.getReason());
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(((OfferImpl) offer2).maxUsesPerOrder);
    assertNull(((OfferImpl) offer2).priority);
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(((OfferImpl) offer2).maxUsesPerCustomer);
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertNull(((OfferImpl) offer2).discountType);
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).maxUsesStrategy);
    assertNull(((OfferImpl) offer2).offerItemQualifierRuleType);
    assertNull(((OfferImpl) offer2).offerItemTargetRuleType);
    assertNull(((OfferImpl) offer2).type);
    assertNull(offer2.getValue());
    assertNull(((OfferImpl) offer2).orderMinSubTotal);
    assertNull(((OfferImpl) offer2).qualifyingItemSubTotal);
    assertNull(((OfferImpl) offer2).targetMinSubTotal);
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(((OfferImpl) offer2).startDate);
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, offer2.getPriority());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertFalse(((OfferImpl) offer2).applyToChildItems);
    assertFalse(((OfferImpl) offer2).automaticallyAdded);
    assertFalse(((OfferImpl) offer2).requiresRelatedTargetAndQualifiers);
    assertFalse(((OfferImpl) offer2).totalitarianOffer);
    assertFalse(((OfferImpl) offer2).useListForDiscounts);
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertTrue(((OfferImpl) offer2).applyToSalePrice);
    assertTrue(((OfferImpl) offer2).combinableWithOtherOffers);
    assertSame(offer, orderItemAdjustmentImpl.getOffer());
    assertSame(offer, orderItemAdjustmentImpl.deproxiedOffer);
    assertSame(orderItem, orderItemAdjustmentImpl.getOrderItem());
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#init(OrderItem, Offer, String)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl}.</li>
   *   <li>Then {@link OrderItemAdjustmentImpl} (default constructor) CurrencyCode
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemAdjustmentImpl#init(OrderItem, Offer, String)}
   */
  @Test
  public void testInit_whenBundleOrderItemImpl_thenOrderItemAdjustmentImplCurrencyCodeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemAdjustmentImpl.init(orderItem, offer, "Just cause");

    // Assert
    Offer offer2 = orderItemAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals("Just cause", orderItemAdjustmentImpl.getReason());
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(((OfferImpl) offer2).maxUsesPerOrder);
    assertNull(((OfferImpl) offer2).priority);
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(((OfferImpl) offer2).maxUsesPerCustomer);
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(orderItemAdjustmentImpl.getCurrencyCode());
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertNull(((OfferImpl) offer2).discountType);
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).maxUsesStrategy);
    assertNull(((OfferImpl) offer2).offerItemQualifierRuleType);
    assertNull(((OfferImpl) offer2).offerItemTargetRuleType);
    assertNull(((OfferImpl) offer2).type);
    assertNull(offer2.getValue());
    assertNull(((OfferImpl) offer2).orderMinSubTotal);
    assertNull(((OfferImpl) offer2).qualifyingItemSubTotal);
    assertNull(((OfferImpl) offer2).targetMinSubTotal);
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(((OfferImpl) offer2).startDate);
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, offer2.getPriority());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertFalse(((OfferImpl) offer2).applyToChildItems);
    assertFalse(((OfferImpl) offer2).automaticallyAdded);
    assertFalse(((OfferImpl) offer2).requiresRelatedTargetAndQualifiers);
    assertFalse(((OfferImpl) offer2).totalitarianOffer);
    assertFalse(((OfferImpl) offer2).useListForDiscounts);
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertTrue(((OfferImpl) offer2).applyToSalePrice);
    assertTrue(((OfferImpl) offer2).combinableWithOtherOffers);
    assertSame(offer, orderItemAdjustmentImpl.getOffer());
    assertSame(offer, orderItemAdjustmentImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
    assertSame(orderItem, orderItemAdjustmentImpl.getOrderItem());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#setAppliedToSalePrice(boolean)}
   *   <li>{@link OrderItemAdjustmentImpl#setId(Long)}
   *   <li>{@link OrderItemAdjustmentImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemAdjustmentImpl#setReason(String)}
   *   <li>{@link OrderItemAdjustmentImpl#setRetailPriceValue(Money)}
   *   <li>{@link OrderItemAdjustmentImpl#setSalesPriceValue(Money)}
   *   <li>{@link OrderItemAdjustmentImpl#getId()}
   *   <li>{@link OrderItemAdjustmentImpl#getOrderItem()}
   *   <li>{@link OrderItemAdjustmentImpl#getReason()}
   *   <li>{@link OrderItemAdjustmentImpl#isAppliedToSalePrice()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();

    // Act
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItemAdjustmentImpl.setOrderItem(orderItem);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    Long actualId = orderItemAdjustmentImpl.getId();
    OrderItem actualOrderItem = orderItemAdjustmentImpl.getOrderItem();
    String actualReason = orderItemAdjustmentImpl.getReason();

    // Assert that nothing has changed
    assertEquals("Just cause", actualReason);
    assertTrue(orderItemAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(OrderItemAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link OrderItemAdjustmentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenOrderItemAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderItemAdjustmentImpl()).getOffer());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link OrderItemAdjustmentImpl} (default constructor) OrderItem is
   * {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenOrderItemAdjustmentImplOrderItemIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setOrderItem(mock(BundleOrderItemImpl.class));

    // Act and Assert
    assertNull(orderItemAdjustmentImpl.getOffer());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl}.</li>
   *   <li>Then {@link OrderItemAdjustmentImpl} (default constructor) Offer is
   * {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenOrderItemAdjustmentImplOfferIsOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    OfferImpl offer = mock(OfferImpl.class);

    // Act
    orderItemAdjustmentImpl.setOffer(offer);

    // Assert
    assertSame(offer, orderItemAdjustmentImpl.getOffer());
    assertSame(offer, orderItemAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then {@link OrderItemAdjustmentImpl} (default constructor)
   * {@link OrderItemAdjustmentImpl#offer} {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenOrderItemAdjustmentImplOfferOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemAdjustmentImpl.setOffer(offer);

    // Assert
    Offer offer2 = orderItemAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(((OfferImpl) offer2).maxUsesPerOrder);
    assertNull(((OfferImpl) offer2).priority);
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(((OfferImpl) offer2).maxUsesPerCustomer);
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertNull(((OfferImpl) offer2).discountType);
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).maxUsesStrategy);
    assertNull(((OfferImpl) offer2).offerItemQualifierRuleType);
    assertNull(((OfferImpl) offer2).offerItemTargetRuleType);
    assertNull(((OfferImpl) offer2).type);
    assertNull(offer2.getValue());
    assertNull(((OfferImpl) offer2).orderMinSubTotal);
    assertNull(((OfferImpl) offer2).qualifyingItemSubTotal);
    assertNull(((OfferImpl) offer2).targetMinSubTotal);
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(((OfferImpl) offer2).startDate);
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, offer2.getPriority());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertFalse(((OfferImpl) offer2).applyToChildItems);
    assertFalse(((OfferImpl) offer2).automaticallyAdded);
    assertFalse(((OfferImpl) offer2).requiresRelatedTargetAndQualifiers);
    assertFalse(((OfferImpl) offer2).totalitarianOffer);
    assertFalse(((OfferImpl) offer2).useListForDiscounts);
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertTrue(((OfferImpl) offer2).applyToSalePrice);
    assertTrue(((OfferImpl) offer2).combinableWithOtherOffers);
    assertSame(offer, orderItemAdjustmentImpl.getOffer());
    assertSame(offer, orderItemAdjustmentImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link OrderItemImpl#getOrder()} return
   * {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenBundleOrderItemImplGetOrderReturnNullOrderImpl_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualValue = orderItemAdjustmentImpl.getValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualValue.ZERO, actualValue);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenMoneyGetAmountReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(value);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualValue = orderItemAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setReason("Just cause");
    Money retailPriceValue = new Money();
    orderItemAdjustmentImpl.setRetailPriceValue(retailPriceValue);
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(retailPriceValue, orderItemAdjustmentImpl.getValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link OrderItemAdjustmentImpl} (default constructor)
   * {@link OrderItemAdjustmentImpl#value} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue_thenOrderItemAdjustmentImplValueIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    orderItemAdjustmentImpl.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), orderItemAdjustmentImpl.value);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link OrderItemAdjustmentImpl} (default constructor)
   * {@link OrderItemAdjustmentImpl#value} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue_whenMoney_thenOrderItemAdjustmentImplValueIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();

    // Act
    orderItemAdjustmentImpl.setValue(new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), orderItemAdjustmentImpl.value);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getRetailPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  public void testGetRetailPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setReason("Just cause");
    Money salesPriceValue = new Money();
    orderItemAdjustmentImpl.setSalesPriceValue(salesPriceValue);
    orderItemAdjustmentImpl.setValue(new Money());
    orderItemAdjustmentImpl.setRetailPriceValue(null);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(salesPriceValue, orderItemAdjustmentImpl.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getRetailPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderItemAdjustmentImpl} (default constructor)
   * RetailPriceValue is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  public void testGetRetailPriceValue_givenOrderItemAdjustmentImplRetailPriceValueIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());
    Money retailPriceValue = new Money();
    orderItemAdjustmentImpl.setRetailPriceValue(retailPriceValue);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertSame(retailPriceValue, orderItemAdjustmentImpl.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getRetailPriceValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  public void testGetRetailPriceValue_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualRetailPriceValue = orderItemAdjustmentImpl.getRetailPriceValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualRetailPriceValue.ZERO, actualRetailPriceValue);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getSalesPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  public void testGetSalesPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setReason("Just cause");
    Money retailPriceValue = new Money();
    orderItemAdjustmentImpl.setRetailPriceValue(retailPriceValue);
    orderItemAdjustmentImpl.setValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(null);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(retailPriceValue, orderItemAdjustmentImpl.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getSalesPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderItemAdjustmentImpl} (default constructor)
   * SalesPriceValue is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  public void testGetSalesPriceValue_givenOrderItemAdjustmentImplSalesPriceValueIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());
    Money salesPriceValue = new Money();
    orderItemAdjustmentImpl.setSalesPriceValue(salesPriceValue);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertSame(salesPriceValue, orderItemAdjustmentImpl.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getSalesPriceValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  public void testGetSalesPriceValue_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualSalesPriceValue = orderItemAdjustmentImpl.getSalesPriceValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualSalesPriceValue.ZERO, actualSalesPriceValue);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is
   * {@link OrderItemAdjustmentImpl#serialVersionUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertNull(orderItemAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link Auditable} {@link Auditable#setCreatedBy(Long)} does
   * nothing.</li>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenAuditableSetCreatedByDoesNothing_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    String actualCurrencyCode = orderItemAdjustmentImpl.getCurrencyCode();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertNull(actualCurrencyCode);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and
   * {@link OrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    int expectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and
   * {@link OrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    int expectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and
   * {@link OrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(mock(OrderItem.class));
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    int notExpectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and
   * {@link OrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(null);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    int expectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and
   * {@link OrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl);
    int expectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(2L);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Just cause");
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(orderItem);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(null);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Reason");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason(null);
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money(10.0d));

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(value);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, null);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, "Different type to OrderItemAdjustmentImpl");
  }

  /**
   * Test new {@link OrderItemAdjustmentImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OrderItemAdjustmentImpl}
   */
  @Test
  public void testNewOrderItemAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OrderItemAdjustmentImpl actualOrderItemAdjustmentImpl = new OrderItemAdjustmentImpl();

    // Assert
    assertNull(actualOrderItemAdjustmentImpl.getId());
    assertNull(actualOrderItemAdjustmentImpl.getReason());
    assertNull(actualOrderItemAdjustmentImpl.retailValue);
    assertNull(actualOrderItemAdjustmentImpl.salesValue);
    assertNull(actualOrderItemAdjustmentImpl.getOffer());
    assertNull(actualOrderItemAdjustmentImpl.deproxiedOffer);
    assertNull(actualOrderItemAdjustmentImpl.offer);
    assertNull(actualOrderItemAdjustmentImpl.getOrderItem());
    assertFalse(actualOrderItemAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(new BigDecimal("0.00"), actualOrderItemAdjustmentImpl.value);
  }
}
