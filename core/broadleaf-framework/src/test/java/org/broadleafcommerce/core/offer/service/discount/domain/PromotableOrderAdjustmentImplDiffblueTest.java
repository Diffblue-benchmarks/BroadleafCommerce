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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class PromotableOrderAdjustmentImplDiffblueTest {
  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"})
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
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testNewPromotableOrderAdjustmentImpl2() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"})
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
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());
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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    Money absResult = adjustmentValue.abs();
    BigDecimal amount = absResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("0.00000");
    assertEquals(expectedAmount2, adjustmentValue.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(absResult2.abs().getAmount(), absResult2.abs().getAmount());
    BigDecimal amount2 = absResult2.getAmount();
    assertSame(amount2, amount2);
    assertSame(amount2, absResult2.zero().getAmount());
    Money zeroResult = adjustmentValue.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(amount, absResult3.abs().getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(amount, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(amount, zeroResult3.abs().getAmount());
    assertSame(amount, absResult3.getAmount());
    assertSame(amount, absResult3.zero().getAmount());
    assertSame(amount, zeroResult2.getAmount());
    assertSame(amount, zeroResult2.zero().getAmount());
    assertSame(amount, zeroResult3.zero().getAmount());
    assertSame(amount, zeroResult3.getAmount());
    assertSame(amount, zeroResult.getAmount());
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testNewPromotableOrderAdjustmentImpl4() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"})
  public void testNewPromotableOrderAdjustmentImpl5() {
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

    // Act
    new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder, new Money());

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"})
  public void testNewPromotableOrderAdjustmentImpl6() {
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

    // Act
    new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder, new Money());

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"})
  public void testNewPromotableOrderAdjustmentImpl7() {
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

    // Act
    new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder, new Money());

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"})
  public void testNewPromotableOrderAdjustmentImpl8() {
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
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());
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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    Money absResult = adjustmentValue.abs();
    BigDecimal amount = absResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("0.00000");
    assertEquals(expectedAmount2, adjustmentValue.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(absResult2.abs().getAmount(), absResult2.abs().getAmount());
    BigDecimal amount2 = absResult2.getAmount();
    assertSame(amount2, amount2);
    assertSame(amount2, absResult2.zero().getAmount());
    Money zeroResult = adjustmentValue.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(amount, absResult3.abs().getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(amount, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(amount, zeroResult3.abs().getAmount());
    assertSame(amount, absResult3.getAmount());
    assertSame(amount, absResult3.zero().getAmount());
    assertSame(amount, zeroResult2.getAmount());
    assertSame(amount, zeroResult2.zero().getAmount());
    assertSame(amount, zeroResult3.zero().getAmount());
    assertSame(amount, zeroResult3.getAmount());
    assertSame(amount, zeroResult.getAmount());
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"})
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

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, new Money());

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
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testNewPromotableOrderAdjustmentImpl_givenMoneySubtractReturnMoney() {
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
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    Money absResult = adjustmentValue.abs();
    BigDecimal amount = absResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("0.00000");
    assertEquals(expectedAmount2, adjustmentValue.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(absResult2.abs().getAmount(), absResult2.abs().getAmount());
    BigDecimal amount2 = absResult2.getAmount();
    assertSame(amount2, amount2);
    assertSame(amount2, absResult2.zero().getAmount());
    Money zeroResult = adjustmentValue.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(amount, absResult3.abs().getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(amount, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(amount, zeroResult3.abs().getAmount());
    assertSame(amount, absResult3.getAmount());
    assertSame(amount, absResult3.zero().getAmount());
    assertSame(amount, zeroResult2.getAmount());
    assertSame(amount, zeroResult2.zero().getAmount());
    assertSame(amount, zeroResult3.zero().getAmount());
    assertSame(amount, zeroResult3.getAmount());
    assertSame(amount, zeroResult.getAmount());
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"})
  public void testNewPromotableOrderAdjustmentImpl_givenMoneySubtractReturnMoney2() {
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

    // Act
    new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder, new Money());

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
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <ul>
   *   <li>Then calls {@link BigDecimal#divide(BigDecimal, int, RoundingMode)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"})
  public void testNewPromotableOrderAdjustmentImpl_thenCallsDivide() {
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

    // Act
    new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder, new Money());

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
  }

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <ul>
   *   <li>Then return AdjustmentValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"})
  public void testNewPromotableOrderAdjustmentImpl_thenReturnAdjustmentValueIsNull() {
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

  /**
   * Test {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <ul>
   *   <li>Then return RoundingScale is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testNewPromotableOrderAdjustmentImpl_thenReturnRoundingScaleIsTwo() {
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
}
