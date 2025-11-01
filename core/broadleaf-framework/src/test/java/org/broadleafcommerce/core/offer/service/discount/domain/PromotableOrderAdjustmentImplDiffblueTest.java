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
package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class PromotableOrderAdjustmentImplDiffblueTest {
  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);

    // Act
    (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .computeAdjustmentValue();

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl, atLeast(1)).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue2() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .computeAdjustmentValue();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl, atLeast(1)).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue3() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("-2.3"));
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .computeAdjustmentValue();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl, atLeast(1)).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue4() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .computeAdjustmentValue();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue5() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .computeAdjustmentValue();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl, atLeast(1)).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue6() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getDiscountType()).thenReturn(new OfferDiscountType());
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .computeAdjustmentValue();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue7() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .computeAdjustmentValue();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Method under test: {@link PromotableOrderAdjustmentImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isCombinableWithOtherOffers()).thenReturn(true);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);

    // Act
    boolean actualIsCombinableResult = (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .isCombinable();

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isCombinableWithOtherOffers();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualIsCombinableResult);
  }

  /**
   * Method under test: {@link PromotableOrderAdjustmentImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable2() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isCombinableWithOtherOffers()).thenReturn(false);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);

    // Act
    boolean actualIsCombinableResult = (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .isCombinable();

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isCombinableWithOtherOffers();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertFalse(actualIsCombinableResult);
  }

  /**
   * Method under test: {@link PromotableOrderAdjustmentImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isTotalitarianOffer()).thenReturn(true);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);

    // Act
    boolean actualIsTotalitarianResult = (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .isTotalitarian();

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(offerImpl).isTotalitarianOffer();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualIsTotalitarianResult);
  }

  /**
   * Method under test: {@link PromotableOrderAdjustmentImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian2() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isTotalitarianOffer()).thenReturn(false);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);

    // Act
    boolean actualIsTotalitarianResult = (new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)))
        .isTotalitarian();

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(offerImpl).isTotalitarianOffer();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertFalse(actualIsTotalitarianResult);
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    Money money = new Money();
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertEquals(money, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl2() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    Money money = new Money();
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertEquals(money, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl3() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    Money money = new Money();
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(840, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00000");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(money, adjustmentValue.abs());
    assertEquals(money, adjustmentValue.zero());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl4() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    Money money = new Money();
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertEquals(money, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl5() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    Money money = mock(Money.class);
    Money money2 = new Money();
    when(money.subtract(Mockito.<Money>any())).thenReturn(money2);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(money);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(money).subtract(isA(Money.class));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(840, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00000");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(money2, adjustmentValue.abs());
    assertEquals(money2, adjustmentValue.zero());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl6() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money2 = mock(Money.class);
    when(money2.subtract(Mockito.<Money>any())).thenReturn(money);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(money2);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(money).getAmount();
    verify(money).lessThan(isA(Money.class));
    verify(money2).subtract(isA(Money.class));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl7() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl8() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl9() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl10() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl11() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(false);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    Money money = new Money();
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, new Money());

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(840, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00000");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(money, adjustmentValue.abs());
    assertEquals(money, adjustmentValue.zero());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl12() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(money);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(money).subtract(isA(Money.class));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl13() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money2 = mock(Money.class);
    when(money2.subtract(Mockito.<Money>any())).thenReturn(money);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(money2);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(money).getAmount();
    verify(money).lessThan(isA(Money.class));
    verify(money2).subtract(isA(Money.class));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl14() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    InternalNumber internalNumber2 = mock(InternalNumber.class);
    when(internalNumber2.setScale(anyInt(), Mockito.<RoundingMode>any())).thenReturn(new BigDecimal("2.3"));
    InternalNumber internalNumber3 = mock(InternalNumber.class);
    when(internalNumber3.multiply(Mockito.<BigDecimal>any())).thenReturn(internalNumber2);
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(internalNumber3);
    Money money2 = mock(Money.class);
    when(money2.subtract(Mockito.<Money>any())).thenReturn(money);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(money2);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, null);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(internalNumber3).multiply(isA(BigDecimal.class));
    verify(internalNumber2).setScale(eq(2), eq(RoundingMode.HALF_EVEN));
    verify(money).getAmount();
    verify(money).lessThan(isA(Money.class));
    verify(money2).subtract(isA(Money.class));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertNull(actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertEquals(2, actualPromotableOrderAdjustmentImpl.getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderAdjustmentImpl.isFutureCredit());
    assertTrue(actualPromotableOrderAdjustmentImpl.isRoundOfferValues());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }
}
