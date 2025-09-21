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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemPriceDetailAdjustmentImplDiffblueTest {
  @Autowired private OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl;

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();

    OfferImpl offer = new OfferImpl();
    offer.setMarketingMessage("marketingMessage");

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    Offer offer2 = orderItemPriceDetailAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals("marketingMessage", offer2.getMarketingMessage());
    assertEquals("marketingMessage", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertEquals("marketingMessage", ((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertFalse(offer2.isFutureCredit());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <ul>
   *   <li>Given {@link OfferAdjustmentType#FUTURE_CREDIT} Type is {@code Adjustment Type}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit_givenFuture_creditTypeIsAdjustmentType() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();

    OfferAdjustmentType offerAdjustmentType = OfferAdjustmentType.FUTURE_CREDIT;
    offerAdjustmentType.setType("Adjustment Type");

    Offer offer = mock(Offer.class);
    when(offer.getAdjustmentType()).thenReturn(offerAdjustmentType);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");
    when(offer.getName()).thenReturn("Name");

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
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <ul>
   *   <li>Given {@link OfferAdjustmentType#FUTURE_CREDIT}.
   *   <li>When {@link Offer} {@link Offer#getAdjustmentType()} return {@link
   *       OfferAdjustmentType#FUTURE_CREDIT}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit_givenFuture_credit_whenOfferGetAdjustmentTypeReturnFuture_credit() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();

    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn(null);
    when(offer.getAdjustmentType()).thenReturn(OfferAdjustmentType.FUTURE_CREDIT);
    when(offer.getName()).thenReturn("Name");

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer).getMarketingMessage();
    verify(offer).getName();
    assertEquals("Name", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertTrue(orderItemPriceDetailAdjustmentImpl.isFutureCredit);
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <ul>
   *   <li>Given {@link OfferAdjustmentType#ORDER_DISCOUNT} Type is {@code Adjustment Type}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit_givenOrder_discountTypeIsAdjustmentType() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();

    OfferAdjustmentType offerAdjustmentType = OfferAdjustmentType.ORDER_DISCOUNT;
    offerAdjustmentType.setType("Adjustment Type");

    Offer offer = mock(Offer.class);
    when(offer.getAdjustmentType()).thenReturn(offerAdjustmentType);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");
    when(offer.getName()).thenReturn("Name");

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
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <ul>
   *   <li>Given {@link OfferAdjustmentType#ORDER_DISCOUNT} Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit_givenOrder_discountTypeIsNull() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();

    OfferAdjustmentType offerAdjustmentType = OfferAdjustmentType.ORDER_DISCOUNT;
    offerAdjustmentType.setType(null);

    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn(null);
    when(offer.getAdjustmentType()).thenReturn(offerAdjustmentType);
    when(offer.getName()).thenReturn("Name");

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer).getMarketingMessage();
    verify(offer).getName();
    assertEquals("Name", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} {@link
   *       OrderItemPriceDetailAdjustmentImpl#offer} FutureCredit.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit_thenOrderItemPriceDetailAdjustmentImplOfferFutureCredit() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    Offer offer2 = orderItemPriceDetailAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertNull(offer2.getMarketingMessage());
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertTrue(offer2.isFutureCredit());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} Reason is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit_thenOrderItemPriceDetailAdjustmentImplReasonIsFoo() {
    // Arrange
    orderItemPriceDetailAdjustmentImpl.setOfferName("foo");

    // Act
    orderItemPriceDetailAdjustmentImpl.init(new OrderItemPriceDetailImpl(), null, null);

    // Assert
    assertEquals("foo", orderItemPriceDetailAdjustmentImpl.getReason());
    assertNull(orderItemPriceDetailAdjustmentImpl.getOffer());
    assertNull(orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertNull(orderItemPriceDetailAdjustmentImpl.offer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} Reason is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit_thenOrderItemPriceDetailAdjustmentImplReasonIsNull() {
    // Arrange
    orderItemPriceDetailAdjustmentImpl.setOfferName(null);

    // Act
    orderItemPriceDetailAdjustmentImpl.init(new OrderItemPriceDetailImpl(), null, null);

    // Assert that nothing has changed
    assertNull(orderItemPriceDetailAdjustmentImpl.getReason());
    assertNull(orderItemPriceDetailAdjustmentImpl.getOffer());
    assertNull(orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertNull(orderItemPriceDetailAdjustmentImpl.offer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <ul>
   *   <li>When {@link Offer} {@link Offer#getAdjustmentType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit_whenOfferGetAdjustmentTypeReturnNull() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();

    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn(null);
    when(offer.getAdjustmentType()).thenReturn(null);
    when(offer.getName()).thenReturn("Name");

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer).getMarketingMessage();
    verify(offer).getName();
    assertEquals("Name", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail,
   * Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"
  })
  public void testInit_whenOfferImpl() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.init(orderItemPriceDetail, new OfferImpl(), "Just cause");

    // Assert
    Offer offer = orderItemPriceDetailAdjustmentImpl.offer;
    assertTrue(offer instanceof OfferImpl);
    assertNull(offer.getMarketingMessage());
    assertNull(((OfferImpl) offer).adjustmentType);
    assertNull(((OfferImpl) offer).marketingMessage);
    assertFalse(offer.isFutureCredit());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setAppliedToSalePrice(boolean)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setId(Long)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setOfferName(String)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setOrderItemPriceDetail(OrderItemPriceDetail)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long OrderItemPriceDetailAdjustmentImpl.getId()",
    "String OrderItemPriceDetailAdjustmentImpl.getOfferName()",
    "OrderItemPriceDetail OrderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail()",
    "String OrderItemPriceDetailAdjustmentImpl.getReason()",
    "boolean OrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice()",
    "void OrderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(boolean)",
    "void OrderItemPriceDetailAdjustmentImpl.setId(Long)",
    "void OrderItemPriceDetailAdjustmentImpl.setOfferName(String)",
    "void OrderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(OrderItemPriceDetail)",
    "void OrderItemPriceDetailAdjustmentImpl.setRetailPriceValue(Money)",
    "void OrderItemPriceDetailAdjustmentImpl.setSalesPriceValue(Money)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();

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
    OrderItemPriceDetail actualOrderItemPriceDetail =
        orderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail();
    String actualReason = orderItemPriceDetailAdjustmentImpl.getReason();

    // Assert
    assertEquals("Offer Name", actualOfferName);
    assertNull(actualReason);
    assertTrue(orderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(OrderItemPriceDetailAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItemPriceDetail, actualOrderItemPriceDetail);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}.
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OrderItemPriceDetailAdjustmentImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull(orderItemPriceDetailAdjustmentImpl.getOffer());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} Reason is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setReason(String)"})
  public void testSetReason_thenOrderItemPriceDetailAdjustmentImplReasonIsFoo() {
    // Arrange
    orderItemPriceDetailAdjustmentImpl.setOfferName("foo");

    // Act
    orderItemPriceDetailAdjustmentImpl.setReason(null);

    // Assert
    assertEquals("foo", orderItemPriceDetailAdjustmentImpl.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} Reason is {@code Just cause}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setReason(String)"})
  public void testSetReason_thenOrderItemPriceDetailAdjustmentImplReasonIsJustCause() {
    // Arrange and Act
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");

    // Assert
    assertEquals("Just cause", orderItemPriceDetailAdjustmentImpl.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} Reason is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setReason(String)"})
  public void testSetReason_thenOrderItemPriceDetailAdjustmentImplReasonIsNull() {
    // Arrange
    orderItemPriceDetailAdjustmentImpl.setOfferName(null);

    // Act
    orderItemPriceDetailAdjustmentImpl.setReason(null);

    // Assert that nothing has changed
    assertNull(orderItemPriceDetailAdjustmentImpl.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} OfferName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setOffer(Offer)"})
  public void testSetOffer_givenNull_thenOrderItemPriceDetailAdjustmentImplOfferNameIsName() {
    // Arrange
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn(null);
    when(offer.getName()).thenReturn("Name");

    // Act
    orderItemPriceDetailAdjustmentImpl.setOffer(offer);

    // Assert
    verify(offer).getMarketingMessage();
    verify(offer).getName();
    assertEquals("Name", orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} OfferName is {@code Marketing Message}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setOffer(Offer)"})
  public void testSetOffer_thenOrderItemPriceDetailAdjustmentImplOfferNameIsMarketingMessage() {
    // Arrange
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");
    when(offer.getName()).thenReturn("Name");

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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} Offer is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setOffer(Offer)"})
  public void testSetOffer_whenNull_thenOrderItemPriceDetailAdjustmentImplOfferIsNull() {
    // Arrange and Act
    orderItemPriceDetailAdjustmentImpl.setOffer(null);

    // Assert that nothing has changed
    assertNull(orderItemPriceDetailAdjustmentImpl.getOfferName());
    assertNull(orderItemPriceDetailAdjustmentImpl.getOffer());
    assertNull(orderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertNull(orderItemPriceDetailAdjustmentImpl.offer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getCurrency()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       OrderItemPriceDetailAdjustmentImpl#serialVersionUID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getCurrency()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafCurrency OrderItemPriceDetailAdjustmentImpl.getCurrency()"})
  public void testGetCurrency_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItemImpl.setPrice(new Money());
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

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
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
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getValue()"})
  public void testGetValue_givenMoneyGetAmountReturnNull_thenReturnNull() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(mock(BroadleafCurrency.class));

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
    orderItem.setPrice(new Money());
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
    orderItemPriceDetailAdjustmentImpl.setValue(value);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualValue = orderItemPriceDetailAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getValue()"})
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
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
    orderItem.setPrice(new Money());
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
    Money value = new Money();
    orderItemPriceDetailAdjustmentImpl.setValue(value);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertEquals(value, orderItemPriceDetailAdjustmentImpl.getValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getValue()"})
  public void testGetValue_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);

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
    orderItem.setPrice(new Money());
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
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualValue = orderItemPriceDetailAdjustmentImpl.getValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualValue.abs();
    assertEquals(actualValue, actualAbsResult);
    Money actualZeroResult = actualValue.zero();
    assertEquals(actualValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} {@link
   *       OrderItemPriceDetailAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with
   *       {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenOrderItemPriceDetailAdjustmentImplValueIsBigDecimalWith000() {
    // Arrange and Act
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), orderItemPriceDetailAdjustmentImpl.value);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} {@link
   *       OrderItemPriceDetailAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with
   *       {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenOrderItemPriceDetailAdjustmentImplValueIsBigDecimalWith23() {
    // Arrange
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
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
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
    orderItem.setPrice(new Money());
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
    Money retailPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(retailPriceValue);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertSame(retailPriceValue, orderItemPriceDetailAdjustmentImpl.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    orderItem.setBaseRetailPrice(baseRetailPrice);
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
    orderItem.setPrice(new Money());
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
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(null);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertEquals(baseRetailPrice, orderItemPriceDetailAdjustmentImpl.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);

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
    orderItem.setPrice(new Money());
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
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(null);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualRetailPriceValue = orderItemPriceDetailAdjustmentImpl.getRetailPriceValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualRetailPriceValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}.
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
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
    orderItem.setPrice(new Money());
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
    Money salesPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(salesPriceValue);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertSame(salesPriceValue, orderItemPriceDetailAdjustmentImpl.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    orderItem.setBaseRetailPrice(baseRetailPrice);
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
    orderItem.setPrice(new Money());
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
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(null);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertEquals(baseRetailPrice, orderItemPriceDetailAdjustmentImpl.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);

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
    orderItem.setPrice(new Money());
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
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(null);
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualSalesPriceValue = orderItemPriceDetailAdjustmentImpl.getSalesPriceValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualSalesPriceValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl}
   *       (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderItemPriceDetailAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
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
    orderItem.setPrice(new Money());
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
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertNull(orderItemPriceDetailAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderItemPriceDetailAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
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
    orderItem.setPrice(new Money());
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
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertNull(orderItemPriceDetailAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailAdjustmentImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOrderItemPriceDetailAdjustmentImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderItemPriceDetailAdjustmentImpl.isFutureCredit());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.isFutureCredit()"})
  public void testIsFutureCredit_thenReturnTrue() {
    // Arrange
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);

    // Act and Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl.isFutureCredit());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setFutureCredit(boolean)}.
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setFutureCredit(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setFutureCredit(boolean)"})
  public void testSetFutureCredit() {
    // Arrange and Act
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);

    // Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl.isFutureCredit);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
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
    assertNotEquals(
        orderItemPriceDetailAdjustmentImpl.hashCode(),
        orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
    assertEquals(
        orderItemPriceDetailAdjustmentImpl.hashCode(),
        orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(value);

    Money value2 = mock(Money.class);
    when(value2.getAmount()).thenReturn(null);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(value2);

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
    assertEquals(
        orderItemPriceDetailAdjustmentImpl.hashCode(),
        orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(2L);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(false);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Reason");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money(10.0d));

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(value);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
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
    assertNotEquals(
        orderItemPriceDetailAdjustmentImpl, "Different type to OrderItemPriceDetailAdjustmentImpl");
  }

  /**
   * Test {@link
   * OrderItemPriceDetailAdjustmentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OrderItemPriceDetailAdjustmentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderItemPriceDetailAdjustmentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new OrderItemPriceDetailAdjustmentImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItemPriceDetailAdjustment> actualCreateOrRetrieveCopyInstanceResult =
        orderItemPriceDetailAdjustmentImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link OrderItemPriceDetailAdjustmentImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * OrderItemPriceDetailAdjustmentImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.<init>()"})
  public void testNewOrderItemPriceDetailAdjustmentImpl() {
    // Arrange and Act
    OrderItemPriceDetailAdjustmentImpl actualOrderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();

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
