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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OrderItemPriceDetailAdjustmentImplDiffblueTest {
  /**
   * Test
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetail orderItemPriceDetail = mock(OrderItemPriceDetail.class);
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    Offer offer2 = orderItemPriceDetailAdjustmentImpl.offer;
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
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
    assertSame(orderItemPriceDetail, orderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail());
  }

  /**
   * Test
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>Given {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>When {@link Offer} {@link Offer#getAdjustmentType()} return
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  public void testInit_givenFuture_credit_whenOfferGetAdjustmentTypeReturnFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");
    when(offer.getAdjustmentType()).thenReturn(OfferAdjustmentType.FUTURE_CREDIT);

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer, atLeast(1)).getMarketingMessage();
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertTrue(orderItemPriceDetailAdjustmentImpl.isFutureCredit);
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then not {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  public void testInit_givenNull_thenNotOrderItemPriceDetailAdjustmentImplIsFutureCredit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");
    when(offer.getAdjustmentType()).thenReturn(null);

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer, atLeast(1)).getMarketingMessage();
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertFalse(orderItemPriceDetailAdjustmentImpl.isFutureCredit);
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * Reason is {@code Marketing Message}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  public void testInit_thenOrderItemPriceDetailAdjustmentImplReasonIsMarketingMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");
    when(offer.getAdjustmentType()).thenReturn(OfferAdjustmentType.FUTURE_CREDIT);

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, null);

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer, atLeast(1)).getMarketingMessage();
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl.getReason());
    assertTrue(orderItemPriceDetailAdjustmentImpl.isFutureCredit);
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * OfferName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  public void testInit_whenNull_thenOrderItemPriceDetailAdjustmentImplOfferNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.init(new OrderItemPriceDetailImpl(), null, "Just cause");

    // Assert
    assertNull(orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertNull(orderItemPriceDetailAdjustmentImpl.getOffer());
    assertNull(orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertNull(orderItemPriceDetailAdjustmentImpl.offer);
  }

  /**
   * Test
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * {@link OrderItemPriceDetailAdjustmentImpl#offer} {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  public void testInit_whenOfferImpl_thenOrderItemPriceDetailAdjustmentImplOfferOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    Offer offer2 = orderItemPriceDetailAdjustmentImpl.offer;
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
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setAppliedToSalePrice(boolean)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setId(Long)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setOfferName(String)}
   *   <li>
   * {@link OrderItemPriceDetailAdjustmentImpl#setOrderItemPriceDetail(OrderItemPriceDetail)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setRetailPriceValue(Money)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setSalesPriceValue(Money)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getId()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getOfferName()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getOrderItemPriceDetail()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getReason()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#isAppliedToSalePrice()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    Long actualId = orderItemPriceDetailAdjustmentImpl.getId();
    String actualOfferName = orderItemPriceDetailAdjustmentImpl.getOfferName();
    OrderItemPriceDetail actualOrderItemPriceDetail = orderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail();
    orderItemPriceDetailAdjustmentImpl.getReason();

    // Assert that nothing has changed
    assertEquals("Offer Name", actualOfferName);
    assertTrue(orderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(OrderItemPriceDetailAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItemPriceDetail, actualOrderItemPriceDetail);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(mock(OrderItemPriceDetailImpl.class));

    // Act and Assert
    assertNull(orderItemPriceDetailAdjustmentImpl.getOffer());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailAdjustmentImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenOrderItemPriceDetailAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderItemPriceDetailAdjustmentImpl()).getOffer());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  public void testSetReason() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setOfferName(null);

    // Act
    orderItemPriceDetailAdjustmentImpl.setReason(null);

    // Assert that nothing has changed
    assertEquals("Just cause", orderItemPriceDetailAdjustmentImpl.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  public void testSetReason2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(mock(OrderItemPriceDetailImpl.class));
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setOfferName(null);

    // Act
    orderItemPriceDetailAdjustmentImpl.setReason(null);

    // Assert that nothing has changed
    assertEquals("Just cause", orderItemPriceDetailAdjustmentImpl.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailAdjustmentImpl} (default
   * constructor).</li>
   *   <li>When {@code Just cause}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  public void testSetReason_givenOrderItemPriceDetailAdjustmentImpl_whenJustCause() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");

    // Assert
    assertEquals("Just cause", orderItemPriceDetailAdjustmentImpl.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * Reason is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  public void testSetReason_thenOrderItemPriceDetailAdjustmentImplReasonIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setOfferName("foo");

    // Act
    orderItemPriceDetailAdjustmentImpl.setReason(null);

    // Assert
    assertEquals("foo", orderItemPriceDetailAdjustmentImpl.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * {@link OrderItemPriceDetailAdjustmentImpl#offer} Archived charValue is
   * {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_thenOrderItemPriceDetailAdjustmentImplOfferArchivedCharValueIsN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.setOffer(offer);

    // Assert
    Offer offer2 = orderItemPriceDetailAdjustmentImpl.offer;
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
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    Set<OfferTargetCriteriaXref> expectedTargetItemCriteriaXref = offer.targetItemCriteria;
    assertSame(expectedTargetItemCriteriaXref, offer2.getTargetItemCriteriaXref());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * OfferName is {@code Marketing Message}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_thenOrderItemPriceDetailAdjustmentImplOfferNameIsMarketingMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");

    // Act
    orderItemPriceDetailAdjustmentImpl.setOffer(offer);

    // Assert
    verify(offer, atLeast(1)).getMarketingMessage();
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * OfferName is {@code Offer Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenNull_thenOrderItemPriceDetailAdjustmentImplOfferNameIsOfferName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act
    orderItemPriceDetailAdjustmentImpl.setOffer(null);

    // Assert
    assertEquals("Offer Name", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertNull(orderItemPriceDetailAdjustmentImpl.getOffer());
    assertNull(orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertNull(orderItemPriceDetailAdjustmentImpl.offer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * OfferName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenOrderItemPriceDetailAdjustmentImplOfferNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.setOffer(offer);

    // Assert
    Offer offer2 = orderItemPriceDetailAdjustmentImpl.offer;
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
    assertNull(orderItemPriceDetailAdjustmentImpl.getOfferName());
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
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    Set<OfferTargetCriteriaXref> expectedTargetItemCriteriaXref = offer.targetItemCriteria;
    assertSame(expectedTargetItemCriteriaXref, offer2.getTargetItemCriteriaXref());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is
   * {@link OrderItemPriceDetailAdjustmentImpl#serialVersionUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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
    OrderItemPriceDetailImpl orderItemPriceDetail = mock(OrderItemPriceDetailImpl.class);
    when(orderItemPriceDetail.getOrderItem()).thenReturn(orderItemImpl);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act
    BroadleafCurrency actualCurrency = orderItemPriceDetailAdjustmentImpl.getCurrency();

    // Assert
    verify(orderItemPriceDetail).getOrderItem();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link OrderItemImpl#getOrder()} return
   * {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenBundleOrderItemImplGetOrderReturnNullOrderImpl_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getOrder()).thenReturn(new NullOrderImpl());
    OrderItemPriceDetailImpl orderItemPriceDetail = mock(OrderItemPriceDetailImpl.class);
    when(orderItemPriceDetail.getOrderItem()).thenReturn(bundleOrderItemImpl);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualValue = orderItemPriceDetailAdjustmentImpl.getValue();

    // Assert
    verify(bundleOrderItemImpl).getOrder();
    verify(orderItemPriceDetail).getOrderItem();
    assertEquals(actualValue.ZERO, actualValue);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    Money retailPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(retailPriceValue);
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertEquals(retailPriceValue, orderItemPriceDetailAdjustmentImpl.getValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * {@link OrderItemPriceDetailAdjustmentImpl#value} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue_thenOrderItemPriceDetailAdjustmentImplValueIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), orderItemPriceDetailAdjustmentImpl.value);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor)
   * {@link OrderItemPriceDetailAdjustmentImpl#value} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue_thenOrderItemPriceDetailAdjustmentImplValueIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    orderItemPriceDetailAdjustmentImpl.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), orderItemPriceDetailAdjustmentImpl.value);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  public void testGetRetailPriceValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    Money retailPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(retailPriceValue);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertSame(retailPriceValue, orderItemPriceDetailAdjustmentImpl.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  public void testGetRetailPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    Money salesPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(salesPriceValue);
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(null);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertEquals(salesPriceValue, orderItemPriceDetailAdjustmentImpl.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  public void testGetRetailPriceValue_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getOrder()).thenReturn(new NullOrderImpl());
    OrderItemPriceDetailImpl orderItemPriceDetail = mock(OrderItemPriceDetailImpl.class);
    when(orderItemPriceDetail.getOrderItem()).thenReturn(bundleOrderItemImpl);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualRetailPriceValue = orderItemPriceDetailAdjustmentImpl.getRetailPriceValue();

    // Assert
    verify(bundleOrderItemImpl).getOrder();
    verify(orderItemPriceDetail).getOrderItem();
    assertEquals(actualRetailPriceValue.ZERO, actualRetailPriceValue);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  public void testGetSalesPriceValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    Money salesPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(salesPriceValue);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertSame(salesPriceValue, orderItemPriceDetailAdjustmentImpl.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  public void testGetSalesPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    Money retailPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(retailPriceValue);
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(null);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertEquals(retailPriceValue, orderItemPriceDetailAdjustmentImpl.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  public void testGetSalesPriceValue_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getOrder()).thenReturn(new NullOrderImpl());
    OrderItemPriceDetailImpl orderItemPriceDetail = mock(OrderItemPriceDetailImpl.class);
    when(orderItemPriceDetail.getOrderItem()).thenReturn(bundleOrderItemImpl);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualSalesPriceValue = orderItemPriceDetailAdjustmentImpl.getSalesPriceValue();

    // Assert
    verify(bundleOrderItemImpl).getOrder();
    verify(orderItemPriceDetail).getOrderItem();
    assertEquals(actualSalesPriceValue.ZERO, actualSalesPriceValue);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(new BroadleafCurrencyImpl());

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
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertNull(orderItemPriceDetailAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertNull(orderItemPriceDetailAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);

    // Act and Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl.isFutureCredit());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(mock(OrderItemPriceDetailImpl.class));
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);

    // Act and Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl.isFutureCredit());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailAdjustmentImpl} (default
   * constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit_givenOrderItemPriceDetailAdjustmentImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderItemPriceDetailAdjustmentImpl()).isFutureCredit());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setFutureCredit(boolean)}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#setFutureCredit(boolean)}
   */
  @Test
  public void testSetFutureCredit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(mock(OrderItemPriceDetailImpl.class));

    // Act
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);

    // Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl.isFutureCredit);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setFutureCredit(boolean)}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailAdjustmentImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#setFutureCredit(boolean)}
   */
  @Test
  public void testSetFutureCredit_givenOrderItemPriceDetailAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);

    // Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl.isFutureCredit);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and
   * {@link OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
    int notExpectedHashCodeResult = orderItemPriceDetailAdjustmentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and
   * {@link OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(mock(OrderItemPriceDetail.class));
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
    int notExpectedHashCodeResult = orderItemPriceDetailAdjustmentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and
   * {@link OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl);
    int expectedHashCodeResult = orderItemPriceDetailAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemPriceDetailAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(2L);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(null);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, null);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, "Different type to OrderItemPriceDetailAdjustmentImpl");
  }

  /**
   * Test
   * {@link OrderItemPriceDetailAdjustmentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailAdjustmentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItemPriceDetailAdjustment> actualCreateOrRetrieveCopyInstanceResult = orderItemPriceDetailAdjustmentImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link OrderItemPriceDetailAdjustmentImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OrderItemPriceDetailAdjustmentImpl}
   */
  @Test
  public void testNewOrderItemPriceDetailAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OrderItemPriceDetailAdjustmentImpl actualOrderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();

    // Assert
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getId());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getOfferName());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getReason());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.retailValue);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.salesValue);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getOffer());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.offer);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail());
    assertFalse(actualOrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertFalse(actualOrderItemPriceDetailAdjustmentImpl.isFutureCredit);
    assertEquals(new BigDecimal("0.00"), actualOrderItemPriceDetailAdjustmentImpl.value);
  }
}
