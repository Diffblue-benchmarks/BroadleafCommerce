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
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <p>
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
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <p>
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
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <p>
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
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(absResult6.abs().getAmount(), absResult6.abs().getAmount());
    BigDecimal amount2 = absResult6.getAmount();
    assertSame(amount2, amount2);
    assertSame(amount2, absResult6.zero().getAmount());
    BigDecimal amount3 = absResult5.getAmount();
    assertSame(amount3, amount3);
    Money zeroResult = absResult5.zero();
    assertSame(amount3, zeroResult.abs().getAmount());
    assertSame(amount3, zeroResult.getAmount());
    assertSame(amount3, zeroResult.zero().getAmount());
    BigDecimal amount4 = absResult4.getAmount();
    assertSame(amount4, amount4);
    Money zeroResult2 = absResult4.zero();
    Money absResult7 = zeroResult2.abs();
    assertSame(amount4, absResult7.abs().getAmount());
    assertSame(amount4, absResult7.getAmount());
    Money zeroResult3 = zeroResult2.zero();
    assertSame(amount4, zeroResult3.abs().getAmount());
    assertSame(amount4, zeroResult2.getAmount());
    assertSame(amount4, absResult7.zero().getAmount());
    assertSame(amount4, zeroResult3.getAmount());
    assertSame(amount4, zeroResult3.zero().getAmount());
    BigDecimal amount5 = absResult3.getAmount();
    Money zeroResult4 = absResult3.zero();
    Money absResult8 = zeroResult4.abs();
    Money absResult9 = absResult8.abs();
    assertSame(amount5, absResult9.abs().getAmount());
    assertSame(amount5, amount5);
    assertSame(amount5, absResult9.getAmount());
    Money zeroResult5 = zeroResult4.zero();
    Money absResult10 = zeroResult5.abs();
    assertSame(amount5, absResult10.abs().getAmount());
    assertSame(amount5, absResult8.getAmount());
    Money zeroResult6 = absResult8.zero();
    assertSame(amount5, zeroResult6.abs().getAmount());
    assertSame(amount5, absResult10.getAmount());
    Money zeroResult7 = zeroResult5.zero();
    assertSame(amount5, zeroResult7.abs().getAmount());
    assertSame(amount5, zeroResult4.getAmount());
    assertSame(amount5, absResult9.zero().getAmount());
    assertSame(amount5, zeroResult6.getAmount());
    assertSame(amount5, absResult10.zero().getAmount());
    assertSame(amount5, zeroResult5.getAmount());
    assertSame(amount5, zeroResult6.zero().getAmount());
    assertSame(amount5, zeroResult7.getAmount());
    assertSame(amount5, zeroResult7.zero().getAmount());
    BigDecimal amount6 = absResult2.getAmount();
    Money zeroResult8 = absResult2.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    Money absResult13 = absResult12.abs();
    assertSame(amount6, absResult13.abs().getAmount());
    assertSame(amount6, absResult13.getAmount());
    Money zeroResult9 = zeroResult8.zero();
    Money absResult14 = zeroResult9.abs();
    Money absResult15 = absResult14.abs();
    assertSame(amount6, absResult15.abs().getAmount());
    assertSame(amount6, absResult12.getAmount());
    Money zeroResult10 = absResult11.zero();
    Money absResult16 = zeroResult10.abs();
    assertSame(amount6, absResult16.abs().getAmount());
    assertSame(amount6, absResult15.getAmount());
    Money zeroResult11 = zeroResult9.zero();
    Money absResult17 = zeroResult11.abs();
    assertSame(amount6, absResult17.abs().getAmount());
    assertSame(amount6, amount6);
    Money zeroResult12 = absResult12.zero();
    assertSame(amount6, zeroResult12.abs().getAmount());
    assertSame(amount6, absResult11.getAmount());
    assertSame(amount6, absResult16.getAmount());
    Money zeroResult13 = absResult14.zero();
    assertSame(amount6, zeroResult13.abs().getAmount());
    assertSame(amount6, absResult14.getAmount());
    Money zeroResult14 = zeroResult10.zero();
    assertSame(amount6, zeroResult14.abs().getAmount());
    assertSame(amount6, absResult17.getAmount());
    Money zeroResult15 = zeroResult11.zero();
    assertSame(amount6, zeroResult15.abs().getAmount());
    assertSame(amount6, absResult13.zero().getAmount());
    assertSame(amount6, zeroResult12.getAmount());
    assertSame(amount6, absResult15.zero().getAmount());
    assertSame(amount6, zeroResult8.getAmount());
    assertSame(amount6, zeroResult10.getAmount());
    assertSame(amount6, absResult16.zero().getAmount());
    assertSame(amount6, zeroResult13.getAmount());
    assertSame(amount6, absResult17.zero().getAmount());
    assertSame(amount6, zeroResult12.zero().getAmount());
    assertSame(amount6, zeroResult9.getAmount());
    assertSame(amount6, zeroResult14.getAmount());
    assertSame(amount6, zeroResult13.zero().getAmount());
    assertSame(amount6, zeroResult11.getAmount());
    assertSame(amount6, zeroResult14.zero().getAmount());
    assertSame(amount6, zeroResult15.getAmount());
    assertSame(amount6, zeroResult15.zero().getAmount());
    Money zeroResult16 = adjustmentValue.zero();
    Money absResult18 = zeroResult16.abs();
    Money absResult19 = absResult18.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(amount, absResult22.abs().getAmount());
    Money zeroResult17 = absResult.zero();
    Money absResult23 = zeroResult17.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount, absResult26.abs().getAmount());
    Money zeroResult18 = zeroResult16.zero();
    Money absResult27 = zeroResult18.abs();
    Money absResult28 = absResult27.abs();
    Money absResult29 = absResult28.abs();
    Money absResult30 = absResult29.abs();
    assertSame(amount, absResult30.abs().getAmount());
    assertSame(amount, absResult22.getAmount());
    Money zeroResult19 = absResult18.zero();
    Money absResult31 = zeroResult19.abs();
    Money absResult32 = absResult31.abs();
    Money absResult33 = absResult32.abs();
    assertSame(amount, absResult33.abs().getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult20 = zeroResult17.zero();
    Money absResult34 = zeroResult20.abs();
    Money absResult35 = absResult34.abs();
    Money absResult36 = absResult35.abs();
    assertSame(amount, absResult36.abs().getAmount());
    Money zeroResult21 = zeroResult18.zero();
    Money absResult37 = zeroResult21.abs();
    Money absResult38 = absResult37.abs();
    Money absResult39 = absResult38.abs();
    assertSame(amount, absResult39.abs().getAmount());
    assertSame(amount, absResult30.getAmount());
    assertSame(amount, absResult21.getAmount());
    Money zeroResult22 = absResult19.zero();
    Money absResult40 = zeroResult22.abs();
    Money absResult41 = absResult40.abs();
    assertSame(amount, absResult41.abs().getAmount());
    Money zeroResult23 = absResult23.zero();
    Money absResult42 = zeroResult23.abs();
    Money absResult43 = absResult42.abs();
    assertSame(amount, absResult43.abs().getAmount());
    Money zeroResult24 = absResult27.zero();
    Money absResult44 = zeroResult24.abs();
    Money absResult45 = absResult44.abs();
    assertSame(amount, absResult45.abs().getAmount());
    assertSame(amount, absResult33.getAmount());
    assertSame(amount, absResult25.getAmount());
    Money zeroResult25 = zeroResult19.zero();
    Money absResult46 = zeroResult25.abs();
    Money absResult47 = absResult46.abs();
    assertSame(amount, absResult47.abs().getAmount());
    assertSame(amount, absResult36.getAmount());
    Money zeroResult26 = zeroResult20.zero();
    Money absResult48 = zeroResult26.abs();
    Money absResult49 = absResult48.abs();
    assertSame(amount, absResult49.abs().getAmount());
    assertSame(amount, absResult39.getAmount());
    assertSame(amount, absResult29.getAmount());
    assertSame(amount, absResult20.getAmount());
    Money zeroResult27 = absResult20.zero();
    Money absResult50 = zeroResult27.abs();
    assertSame(amount, absResult50.abs().getAmount());
    Money zeroResult28 = absResult24.zero();
    Money absResult51 = zeroResult28.abs();
    assertSame(amount, absResult51.abs().getAmount());
    Money zeroResult29 = absResult28.zero();
    Money absResult52 = zeroResult29.abs();
    assertSame(amount, absResult52.abs().getAmount());
    assertSame(amount, absResult41.getAmount());
    Money zeroResult30 = absResult31.zero();
    Money absResult53 = zeroResult30.abs();
    assertSame(amount, absResult53.abs().getAmount());
    assertSame(amount, absResult43.getAmount());
    Money zeroResult31 = absResult34.zero();
    Money absResult54 = zeroResult31.abs();
    assertSame(amount, absResult54.abs().getAmount());
    Money zeroResult32 = absResult37.zero();
    Money absResult55 = zeroResult32.abs();
    assertSame(amount, absResult55.abs().getAmount());
    assertSame(amount, absResult45.getAmount());
    assertSame(amount, absResult32.getAmount());
    assertSame(amount, absResult24.getAmount());
    Money zeroResult33 = zeroResult22.zero();
    Money absResult56 = zeroResult33.abs();
    assertSame(amount, absResult56.abs().getAmount());
    Money zeroResult34 = zeroResult23.zero();
    Money absResult57 = zeroResult34.abs();
    assertSame(amount, absResult57.abs().getAmount());
    Money zeroResult35 = zeroResult24.zero();
    Money absResult58 = zeroResult35.abs();
    assertSame(amount, absResult58.abs().getAmount());
    assertSame(amount, absResult47.getAmount());
    assertSame(amount, absResult35.getAmount());
    Money zeroResult36 = zeroResult25.zero();
    Money absResult59 = zeroResult36.abs();
    assertSame(amount, absResult59.abs().getAmount());
    assertSame(amount, absResult49.getAmount());
    Money zeroResult37 = zeroResult26.zero();
    Money absResult60 = zeroResult37.abs();
    assertSame(amount, absResult60.abs().getAmount());
    Money zeroResult38 = zeroResult21.zero();
    Money absResult61 = zeroResult38.abs();
    assertSame(amount, absResult61.abs().getAmount());
    assertSame(amount, absResult38.getAmount());
    assertSame(amount, absResult28.getAmount());
    assertSame(amount, absResult19.getAmount());
    Money zeroResult39 = absResult21.zero();
    assertSame(amount, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult25.zero();
    assertSame(amount, zeroResult40.abs().getAmount());
    Money zeroResult41 = absResult29.zero();
    assertSame(amount, zeroResult41.abs().getAmount());
    assertSame(amount, absResult50.getAmount());
    Money zeroResult42 = absResult32.zero();
    assertSame(amount, zeroResult42.abs().getAmount());
    assertSame(amount, absResult51.getAmount());
    Money zeroResult43 = absResult35.zero();
    assertSame(amount, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult38.zero();
    assertSame(amount, zeroResult44.abs().getAmount());
    assertSame(amount, absResult52.getAmount());
    assertSame(amount, absResult40.getAmount());
    Money zeroResult45 = absResult40.zero();
    assertSame(amount, zeroResult45.abs().getAmount());
    Money zeroResult46 = absResult42.zero();
    assertSame(amount, zeroResult46.abs().getAmount());
    Money zeroResult47 = absResult44.zero();
    assertSame(amount, zeroResult47.abs().getAmount());
    assertSame(amount, absResult53.getAmount());
    assertSame(amount, absResult42.getAmount());
    Money zeroResult48 = absResult46.zero();
    assertSame(amount, zeroResult48.abs().getAmount());
    assertSame(amount, absResult54.getAmount());
    Money zeroResult49 = absResult48.zero();
    assertSame(amount, zeroResult49.abs().getAmount());
    assertSame(amount, absResult55.getAmount());
    assertSame(amount, absResult44.getAmount());
    assertSame(amount, absResult31.getAmount());
    assertSame(amount, absResult23.getAmount());
    Money zeroResult50 = zeroResult27.zero();
    assertSame(amount, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult28.zero();
    assertSame(amount, zeroResult51.abs().getAmount());
    Money zeroResult52 = zeroResult29.zero();
    assertSame(amount, zeroResult52.abs().getAmount());
    assertSame(amount, absResult56.getAmount());
    Money zeroResult53 = zeroResult30.zero();
    assertSame(amount, zeroResult53.abs().getAmount());
    assertSame(amount, absResult57.getAmount());
    Money zeroResult54 = zeroResult31.zero();
    assertSame(amount, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult32.zero();
    assertSame(amount, zeroResult55.abs().getAmount());
    assertSame(amount, absResult58.getAmount());
    assertSame(amount, absResult46.getAmount());
    assertSame(amount, absResult34.getAmount());
    Money zeroResult56 = zeroResult33.zero();
    assertSame(amount, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult34.zero();
    assertSame(amount, zeroResult57.abs().getAmount());
    Money zeroResult58 = zeroResult35.zero();
    assertSame(amount, zeroResult58.abs().getAmount());
    assertSame(amount, absResult59.getAmount());
    assertSame(amount, absResult48.getAmount());
    Money zeroResult59 = zeroResult36.zero();
    assertSame(amount, zeroResult59.abs().getAmount());
    assertSame(amount, absResult60.getAmount());
    Money zeroResult60 = zeroResult37.zero();
    assertSame(amount, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult38.zero();
    assertSame(amount, zeroResult61.abs().getAmount());
    assertSame(amount, absResult61.getAmount());
    assertSame(amount, absResult37.getAmount());
    assertSame(amount, absResult27.getAmount());
    assertSame(amount, absResult18.getAmount());
    assertSame(amount, absResult22.zero().getAmount());
    assertSame(amount, absResult26.zero().getAmount());
    assertSame(amount, absResult30.zero().getAmount());
    assertSame(amount, zeroResult39.getAmount());
    assertSame(amount, absResult33.zero().getAmount());
    assertSame(amount, zeroResult40.getAmount());
    assertSame(amount, absResult36.zero().getAmount());
    assertSame(amount, absResult39.zero().getAmount());
    assertSame(amount, zeroResult41.getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, absResult41.zero().getAmount());
    assertSame(amount, absResult43.zero().getAmount());
    assertSame(amount, absResult45.zero().getAmount());
    assertSame(amount, zeroResult42.getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, absResult47.zero().getAmount());
    assertSame(amount, zeroResult43.getAmount());
    assertSame(amount, absResult49.zero().getAmount());
    assertSame(amount, zeroResult44.getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult22.getAmount());
    assertSame(amount, absResult50.zero().getAmount());
    assertSame(amount, absResult51.zero().getAmount());
    assertSame(amount, absResult52.zero().getAmount());
    assertSame(amount, zeroResult45.getAmount());
    assertSame(amount, absResult53.zero().getAmount());
    assertSame(amount, zeroResult46.getAmount());
    assertSame(amount, absResult54.zero().getAmount());
    assertSame(amount, absResult55.zero().getAmount());
    assertSame(amount, zeroResult47.getAmount());
    assertSame(amount, zeroResult30.getAmount());
    assertSame(amount, zeroResult23.getAmount());
    assertSame(amount, absResult56.zero().getAmount());
    assertSame(amount, absResult57.zero().getAmount());
    assertSame(amount, absResult58.zero().getAmount());
    assertSame(amount, zeroResult48.getAmount());
    assertSame(amount, zeroResult31.getAmount());
    assertSame(amount, absResult59.zero().getAmount());
    assertSame(amount, zeroResult49.getAmount());
    assertSame(amount, absResult60.zero().getAmount());
    assertSame(amount, absResult61.zero().getAmount());
    assertSame(amount, zeroResult32.getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult19.getAmount());
    assertSame(amount, zeroResult17.getAmount());
    assertSame(amount, zeroResult39.zero().getAmount());
    assertSame(amount, zeroResult40.zero().getAmount());
    assertSame(amount, zeroResult41.zero().getAmount());
    assertSame(amount, zeroResult50.getAmount());
    assertSame(amount, zeroResult42.zero().getAmount());
    assertSame(amount, zeroResult51.getAmount());
    assertSame(amount, zeroResult43.zero().getAmount());
    assertSame(amount, zeroResult44.zero().getAmount());
    assertSame(amount, zeroResult52.getAmount());
    assertSame(amount, zeroResult33.getAmount());
    assertSame(amount, zeroResult45.zero().getAmount());
    assertSame(amount, zeroResult46.zero().getAmount());
    assertSame(amount, zeroResult47.zero().getAmount());
    assertSame(amount, zeroResult53.getAmount());
    assertSame(amount, zeroResult34.getAmount());
    assertSame(amount, zeroResult48.zero().getAmount());
    assertSame(amount, zeroResult54.getAmount());
    assertSame(amount, zeroResult49.zero().getAmount());
    assertSame(amount, zeroResult55.getAmount());
    assertSame(amount, zeroResult35.getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, zeroResult20.getAmount());
    assertSame(amount, zeroResult50.zero().getAmount());
    assertSame(amount, zeroResult51.zero().getAmount());
    assertSame(amount, zeroResult52.zero().getAmount());
    assertSame(amount, zeroResult56.getAmount());
    assertSame(amount, zeroResult53.zero().getAmount());
    assertSame(amount, zeroResult57.getAmount());
    assertSame(amount, zeroResult54.zero().getAmount());
    assertSame(amount, zeroResult55.zero().getAmount());
    assertSame(amount, zeroResult58.getAmount());
    assertSame(amount, zeroResult36.getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult56.zero().getAmount());
    assertSame(amount, zeroResult57.zero().getAmount());
    assertSame(amount, zeroResult58.zero().getAmount());
    assertSame(amount, zeroResult59.getAmount());
    assertSame(amount, zeroResult37.getAmount());
    assertSame(amount, zeroResult59.zero().getAmount());
    assertSame(amount, zeroResult60.getAmount());
    assertSame(amount, zeroResult60.zero().getAmount());
    assertSame(amount, zeroResult61.zero().getAmount());
    assertSame(amount, zeroResult61.getAmount());
    assertSame(amount, zeroResult38.getAmount());
    assertSame(amount, zeroResult21.getAmount());
    assertSame(amount, zeroResult18.getAmount());
    assertSame(amount, zeroResult16.getAmount());
  }

  /**
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <p>
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
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
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
    Money money = new Money();
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, new Money());

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertEquals(money, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
  }

  /**
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
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
    Money money = new Money();
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, new Money());

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertEquals(money, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
  }

  /**
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
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
    Money money = new Money();
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, new Money());

    // Assert
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertEquals(money, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
  }

  /**
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
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
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(absResult6.abs().getAmount(), absResult6.abs().getAmount());
    BigDecimal amount2 = absResult6.getAmount();
    assertSame(amount2, amount2);
    assertSame(amount2, absResult6.zero().getAmount());
    BigDecimal amount3 = absResult5.getAmount();
    assertSame(amount3, amount3);
    Money zeroResult = absResult5.zero();
    assertSame(amount3, zeroResult.abs().getAmount());
    assertSame(amount3, zeroResult.getAmount());
    assertSame(amount3, zeroResult.zero().getAmount());
    BigDecimal amount4 = absResult4.getAmount();
    assertSame(amount4, amount4);
    Money zeroResult2 = absResult4.zero();
    Money absResult7 = zeroResult2.abs();
    assertSame(amount4, absResult7.abs().getAmount());
    assertSame(amount4, absResult7.getAmount());
    Money zeroResult3 = zeroResult2.zero();
    assertSame(amount4, zeroResult3.abs().getAmount());
    assertSame(amount4, zeroResult2.getAmount());
    assertSame(amount4, absResult7.zero().getAmount());
    assertSame(amount4, zeroResult3.getAmount());
    assertSame(amount4, zeroResult3.zero().getAmount());
    BigDecimal amount5 = absResult3.getAmount();
    Money zeroResult4 = absResult3.zero();
    Money absResult8 = zeroResult4.abs();
    Money absResult9 = absResult8.abs();
    assertSame(amount5, absResult9.abs().getAmount());
    assertSame(amount5, amount5);
    assertSame(amount5, absResult9.getAmount());
    Money zeroResult5 = zeroResult4.zero();
    Money absResult10 = zeroResult5.abs();
    assertSame(amount5, absResult10.abs().getAmount());
    assertSame(amount5, absResult8.getAmount());
    Money zeroResult6 = absResult8.zero();
    assertSame(amount5, zeroResult6.abs().getAmount());
    assertSame(amount5, absResult10.getAmount());
    Money zeroResult7 = zeroResult5.zero();
    assertSame(amount5, zeroResult7.abs().getAmount());
    assertSame(amount5, zeroResult4.getAmount());
    assertSame(amount5, absResult9.zero().getAmount());
    assertSame(amount5, zeroResult6.getAmount());
    assertSame(amount5, absResult10.zero().getAmount());
    assertSame(amount5, zeroResult5.getAmount());
    assertSame(amount5, zeroResult6.zero().getAmount());
    assertSame(amount5, zeroResult7.getAmount());
    assertSame(amount5, zeroResult7.zero().getAmount());
    BigDecimal amount6 = absResult2.getAmount();
    Money zeroResult8 = absResult2.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    Money absResult13 = absResult12.abs();
    assertSame(amount6, absResult13.abs().getAmount());
    assertSame(amount6, absResult13.getAmount());
    Money zeroResult9 = zeroResult8.zero();
    Money absResult14 = zeroResult9.abs();
    Money absResult15 = absResult14.abs();
    assertSame(amount6, absResult15.abs().getAmount());
    assertSame(amount6, absResult12.getAmount());
    Money zeroResult10 = absResult11.zero();
    Money absResult16 = zeroResult10.abs();
    assertSame(amount6, absResult16.abs().getAmount());
    assertSame(amount6, absResult15.getAmount());
    Money zeroResult11 = zeroResult9.zero();
    Money absResult17 = zeroResult11.abs();
    assertSame(amount6, absResult17.abs().getAmount());
    assertSame(amount6, amount6);
    Money zeroResult12 = absResult12.zero();
    assertSame(amount6, zeroResult12.abs().getAmount());
    assertSame(amount6, absResult11.getAmount());
    assertSame(amount6, absResult16.getAmount());
    Money zeroResult13 = absResult14.zero();
    assertSame(amount6, zeroResult13.abs().getAmount());
    assertSame(amount6, absResult14.getAmount());
    Money zeroResult14 = zeroResult10.zero();
    assertSame(amount6, zeroResult14.abs().getAmount());
    assertSame(amount6, absResult17.getAmount());
    Money zeroResult15 = zeroResult11.zero();
    assertSame(amount6, zeroResult15.abs().getAmount());
    assertSame(amount6, absResult13.zero().getAmount());
    assertSame(amount6, zeroResult12.getAmount());
    assertSame(amount6, absResult15.zero().getAmount());
    assertSame(amount6, zeroResult8.getAmount());
    assertSame(amount6, zeroResult10.getAmount());
    assertSame(amount6, absResult16.zero().getAmount());
    assertSame(amount6, zeroResult13.getAmount());
    assertSame(amount6, absResult17.zero().getAmount());
    assertSame(amount6, zeroResult12.zero().getAmount());
    assertSame(amount6, zeroResult9.getAmount());
    assertSame(amount6, zeroResult14.getAmount());
    assertSame(amount6, zeroResult13.zero().getAmount());
    assertSame(amount6, zeroResult11.getAmount());
    assertSame(amount6, zeroResult14.zero().getAmount());
    assertSame(amount6, zeroResult15.getAmount());
    assertSame(amount6, zeroResult15.zero().getAmount());
    Money zeroResult16 = adjustmentValue.zero();
    Money absResult18 = zeroResult16.abs();
    Money absResult19 = absResult18.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(amount, absResult22.abs().getAmount());
    Money zeroResult17 = absResult.zero();
    Money absResult23 = zeroResult17.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount, absResult26.abs().getAmount());
    Money zeroResult18 = zeroResult16.zero();
    Money absResult27 = zeroResult18.abs();
    Money absResult28 = absResult27.abs();
    Money absResult29 = absResult28.abs();
    Money absResult30 = absResult29.abs();
    assertSame(amount, absResult30.abs().getAmount());
    assertSame(amount, absResult22.getAmount());
    Money zeroResult19 = absResult18.zero();
    Money absResult31 = zeroResult19.abs();
    Money absResult32 = absResult31.abs();
    Money absResult33 = absResult32.abs();
    assertSame(amount, absResult33.abs().getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult20 = zeroResult17.zero();
    Money absResult34 = zeroResult20.abs();
    Money absResult35 = absResult34.abs();
    Money absResult36 = absResult35.abs();
    assertSame(amount, absResult36.abs().getAmount());
    Money zeroResult21 = zeroResult18.zero();
    Money absResult37 = zeroResult21.abs();
    Money absResult38 = absResult37.abs();
    Money absResult39 = absResult38.abs();
    assertSame(amount, absResult39.abs().getAmount());
    assertSame(amount, absResult30.getAmount());
    assertSame(amount, absResult21.getAmount());
    Money zeroResult22 = absResult19.zero();
    Money absResult40 = zeroResult22.abs();
    Money absResult41 = absResult40.abs();
    assertSame(amount, absResult41.abs().getAmount());
    Money zeroResult23 = absResult23.zero();
    Money absResult42 = zeroResult23.abs();
    Money absResult43 = absResult42.abs();
    assertSame(amount, absResult43.abs().getAmount());
    Money zeroResult24 = absResult27.zero();
    Money absResult44 = zeroResult24.abs();
    Money absResult45 = absResult44.abs();
    assertSame(amount, absResult45.abs().getAmount());
    assertSame(amount, absResult33.getAmount());
    assertSame(amount, absResult25.getAmount());
    Money zeroResult25 = zeroResult19.zero();
    Money absResult46 = zeroResult25.abs();
    Money absResult47 = absResult46.abs();
    assertSame(amount, absResult47.abs().getAmount());
    assertSame(amount, absResult36.getAmount());
    Money zeroResult26 = zeroResult20.zero();
    Money absResult48 = zeroResult26.abs();
    Money absResult49 = absResult48.abs();
    assertSame(amount, absResult49.abs().getAmount());
    assertSame(amount, absResult39.getAmount());
    assertSame(amount, absResult29.getAmount());
    assertSame(amount, absResult20.getAmount());
    Money zeroResult27 = absResult20.zero();
    Money absResult50 = zeroResult27.abs();
    assertSame(amount, absResult50.abs().getAmount());
    Money zeroResult28 = absResult24.zero();
    Money absResult51 = zeroResult28.abs();
    assertSame(amount, absResult51.abs().getAmount());
    Money zeroResult29 = absResult28.zero();
    Money absResult52 = zeroResult29.abs();
    assertSame(amount, absResult52.abs().getAmount());
    assertSame(amount, absResult41.getAmount());
    Money zeroResult30 = absResult31.zero();
    Money absResult53 = zeroResult30.abs();
    assertSame(amount, absResult53.abs().getAmount());
    assertSame(amount, absResult43.getAmount());
    Money zeroResult31 = absResult34.zero();
    Money absResult54 = zeroResult31.abs();
    assertSame(amount, absResult54.abs().getAmount());
    Money zeroResult32 = absResult37.zero();
    Money absResult55 = zeroResult32.abs();
    assertSame(amount, absResult55.abs().getAmount());
    assertSame(amount, absResult45.getAmount());
    assertSame(amount, absResult32.getAmount());
    assertSame(amount, absResult24.getAmount());
    Money zeroResult33 = zeroResult22.zero();
    Money absResult56 = zeroResult33.abs();
    assertSame(amount, absResult56.abs().getAmount());
    Money zeroResult34 = zeroResult23.zero();
    Money absResult57 = zeroResult34.abs();
    assertSame(amount, absResult57.abs().getAmount());
    Money zeroResult35 = zeroResult24.zero();
    Money absResult58 = zeroResult35.abs();
    assertSame(amount, absResult58.abs().getAmount());
    assertSame(amount, absResult47.getAmount());
    assertSame(amount, absResult35.getAmount());
    Money zeroResult36 = zeroResult25.zero();
    Money absResult59 = zeroResult36.abs();
    assertSame(amount, absResult59.abs().getAmount());
    assertSame(amount, absResult49.getAmount());
    Money zeroResult37 = zeroResult26.zero();
    Money absResult60 = zeroResult37.abs();
    assertSame(amount, absResult60.abs().getAmount());
    Money zeroResult38 = zeroResult21.zero();
    Money absResult61 = zeroResult38.abs();
    assertSame(amount, absResult61.abs().getAmount());
    assertSame(amount, absResult38.getAmount());
    assertSame(amount, absResult28.getAmount());
    assertSame(amount, absResult19.getAmount());
    Money zeroResult39 = absResult21.zero();
    assertSame(amount, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult25.zero();
    assertSame(amount, zeroResult40.abs().getAmount());
    Money zeroResult41 = absResult29.zero();
    assertSame(amount, zeroResult41.abs().getAmount());
    assertSame(amount, absResult50.getAmount());
    Money zeroResult42 = absResult32.zero();
    assertSame(amount, zeroResult42.abs().getAmount());
    assertSame(amount, absResult51.getAmount());
    Money zeroResult43 = absResult35.zero();
    assertSame(amount, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult38.zero();
    assertSame(amount, zeroResult44.abs().getAmount());
    assertSame(amount, absResult52.getAmount());
    assertSame(amount, absResult40.getAmount());
    Money zeroResult45 = absResult40.zero();
    assertSame(amount, zeroResult45.abs().getAmount());
    Money zeroResult46 = absResult42.zero();
    assertSame(amount, zeroResult46.abs().getAmount());
    Money zeroResult47 = absResult44.zero();
    assertSame(amount, zeroResult47.abs().getAmount());
    assertSame(amount, absResult53.getAmount());
    assertSame(amount, absResult42.getAmount());
    Money zeroResult48 = absResult46.zero();
    assertSame(amount, zeroResult48.abs().getAmount());
    assertSame(amount, absResult54.getAmount());
    Money zeroResult49 = absResult48.zero();
    assertSame(amount, zeroResult49.abs().getAmount());
    assertSame(amount, absResult55.getAmount());
    assertSame(amount, absResult44.getAmount());
    assertSame(amount, absResult31.getAmount());
    assertSame(amount, absResult23.getAmount());
    Money zeroResult50 = zeroResult27.zero();
    assertSame(amount, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult28.zero();
    assertSame(amount, zeroResult51.abs().getAmount());
    Money zeroResult52 = zeroResult29.zero();
    assertSame(amount, zeroResult52.abs().getAmount());
    assertSame(amount, absResult56.getAmount());
    Money zeroResult53 = zeroResult30.zero();
    assertSame(amount, zeroResult53.abs().getAmount());
    assertSame(amount, absResult57.getAmount());
    Money zeroResult54 = zeroResult31.zero();
    assertSame(amount, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult32.zero();
    assertSame(amount, zeroResult55.abs().getAmount());
    assertSame(amount, absResult58.getAmount());
    assertSame(amount, absResult46.getAmount());
    assertSame(amount, absResult34.getAmount());
    Money zeroResult56 = zeroResult33.zero();
    assertSame(amount, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult34.zero();
    assertSame(amount, zeroResult57.abs().getAmount());
    Money zeroResult58 = zeroResult35.zero();
    assertSame(amount, zeroResult58.abs().getAmount());
    assertSame(amount, absResult59.getAmount());
    assertSame(amount, absResult48.getAmount());
    Money zeroResult59 = zeroResult36.zero();
    assertSame(amount, zeroResult59.abs().getAmount());
    assertSame(amount, absResult60.getAmount());
    Money zeroResult60 = zeroResult37.zero();
    assertSame(amount, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult38.zero();
    assertSame(amount, zeroResult61.abs().getAmount());
    assertSame(amount, absResult61.getAmount());
    assertSame(amount, absResult37.getAmount());
    assertSame(amount, absResult27.getAmount());
    assertSame(amount, absResult18.getAmount());
    assertSame(amount, absResult22.zero().getAmount());
    assertSame(amount, absResult26.zero().getAmount());
    assertSame(amount, absResult30.zero().getAmount());
    assertSame(amount, zeroResult39.getAmount());
    assertSame(amount, absResult33.zero().getAmount());
    assertSame(amount, zeroResult40.getAmount());
    assertSame(amount, absResult36.zero().getAmount());
    assertSame(amount, absResult39.zero().getAmount());
    assertSame(amount, zeroResult41.getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, absResult41.zero().getAmount());
    assertSame(amount, absResult43.zero().getAmount());
    assertSame(amount, absResult45.zero().getAmount());
    assertSame(amount, zeroResult42.getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, absResult47.zero().getAmount());
    assertSame(amount, zeroResult43.getAmount());
    assertSame(amount, absResult49.zero().getAmount());
    assertSame(amount, zeroResult44.getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult22.getAmount());
    assertSame(amount, absResult50.zero().getAmount());
    assertSame(amount, absResult51.zero().getAmount());
    assertSame(amount, absResult52.zero().getAmount());
    assertSame(amount, zeroResult45.getAmount());
    assertSame(amount, absResult53.zero().getAmount());
    assertSame(amount, zeroResult46.getAmount());
    assertSame(amount, absResult54.zero().getAmount());
    assertSame(amount, absResult55.zero().getAmount());
    assertSame(amount, zeroResult47.getAmount());
    assertSame(amount, zeroResult30.getAmount());
    assertSame(amount, zeroResult23.getAmount());
    assertSame(amount, absResult56.zero().getAmount());
    assertSame(amount, absResult57.zero().getAmount());
    assertSame(amount, absResult58.zero().getAmount());
    assertSame(amount, zeroResult48.getAmount());
    assertSame(amount, zeroResult31.getAmount());
    assertSame(amount, absResult59.zero().getAmount());
    assertSame(amount, zeroResult49.getAmount());
    assertSame(amount, absResult60.zero().getAmount());
    assertSame(amount, absResult61.zero().getAmount());
    assertSame(amount, zeroResult32.getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult19.getAmount());
    assertSame(amount, zeroResult17.getAmount());
    assertSame(amount, zeroResult39.zero().getAmount());
    assertSame(amount, zeroResult40.zero().getAmount());
    assertSame(amount, zeroResult41.zero().getAmount());
    assertSame(amount, zeroResult50.getAmount());
    assertSame(amount, zeroResult42.zero().getAmount());
    assertSame(amount, zeroResult51.getAmount());
    assertSame(amount, zeroResult43.zero().getAmount());
    assertSame(amount, zeroResult44.zero().getAmount());
    assertSame(amount, zeroResult52.getAmount());
    assertSame(amount, zeroResult33.getAmount());
    assertSame(amount, zeroResult45.zero().getAmount());
    assertSame(amount, zeroResult46.zero().getAmount());
    assertSame(amount, zeroResult47.zero().getAmount());
    assertSame(amount, zeroResult53.getAmount());
    assertSame(amount, zeroResult34.getAmount());
    assertSame(amount, zeroResult48.zero().getAmount());
    assertSame(amount, zeroResult54.getAmount());
    assertSame(amount, zeroResult49.zero().getAmount());
    assertSame(amount, zeroResult55.getAmount());
    assertSame(amount, zeroResult35.getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, zeroResult20.getAmount());
    assertSame(amount, zeroResult50.zero().getAmount());
    assertSame(amount, zeroResult51.zero().getAmount());
    assertSame(amount, zeroResult52.zero().getAmount());
    assertSame(amount, zeroResult56.getAmount());
    assertSame(amount, zeroResult53.zero().getAmount());
    assertSame(amount, zeroResult57.getAmount());
    assertSame(amount, zeroResult54.zero().getAmount());
    assertSame(amount, zeroResult55.zero().getAmount());
    assertSame(amount, zeroResult58.getAmount());
    assertSame(amount, zeroResult36.getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult56.zero().getAmount());
    assertSame(amount, zeroResult57.zero().getAmount());
    assertSame(amount, zeroResult58.zero().getAmount());
    assertSame(amount, zeroResult59.getAmount());
    assertSame(amount, zeroResult37.getAmount());
    assertSame(amount, zeroResult59.zero().getAmount());
    assertSame(amount, zeroResult60.getAmount());
    assertSame(amount, zeroResult60.zero().getAmount());
    assertSame(amount, zeroResult61.zero().getAmount());
    assertSame(amount, zeroResult61.getAmount());
    assertSame(amount, zeroResult38.getAmount());
    assertSame(amount, zeroResult21.getAmount());
    assertSame(amount, zeroResult18.getAmount());
    assertSame(amount, zeroResult16.getAmount());
  }

  /**
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl_givenMoneyGetAmountReturnBigDecimalWith23() {
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
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
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
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(absResult6.abs().getAmount(), absResult6.abs().getAmount());
    BigDecimal amount2 = absResult6.getAmount();
    assertSame(amount2, amount2);
    assertSame(amount2, absResult6.zero().getAmount());
    BigDecimal amount3 = absResult5.getAmount();
    assertSame(amount3, amount3);
    Money zeroResult = absResult5.zero();
    assertSame(amount3, zeroResult.abs().getAmount());
    assertSame(amount3, zeroResult.getAmount());
    assertSame(amount3, zeroResult.zero().getAmount());
    BigDecimal amount4 = absResult4.getAmount();
    assertSame(amount4, amount4);
    Money zeroResult2 = absResult4.zero();
    Money absResult7 = zeroResult2.abs();
    assertSame(amount4, absResult7.abs().getAmount());
    assertSame(amount4, absResult7.getAmount());
    Money zeroResult3 = zeroResult2.zero();
    assertSame(amount4, zeroResult3.abs().getAmount());
    assertSame(amount4, zeroResult2.getAmount());
    assertSame(amount4, absResult7.zero().getAmount());
    assertSame(amount4, zeroResult3.getAmount());
    assertSame(amount4, zeroResult3.zero().getAmount());
    BigDecimal amount5 = absResult3.getAmount();
    Money zeroResult4 = absResult3.zero();
    Money absResult8 = zeroResult4.abs();
    Money absResult9 = absResult8.abs();
    assertSame(amount5, absResult9.abs().getAmount());
    assertSame(amount5, amount5);
    assertSame(amount5, absResult9.getAmount());
    Money zeroResult5 = zeroResult4.zero();
    Money absResult10 = zeroResult5.abs();
    assertSame(amount5, absResult10.abs().getAmount());
    assertSame(amount5, absResult8.getAmount());
    Money zeroResult6 = absResult8.zero();
    assertSame(amount5, zeroResult6.abs().getAmount());
    assertSame(amount5, absResult10.getAmount());
    Money zeroResult7 = zeroResult5.zero();
    assertSame(amount5, zeroResult7.abs().getAmount());
    assertSame(amount5, zeroResult4.getAmount());
    assertSame(amount5, absResult9.zero().getAmount());
    assertSame(amount5, zeroResult6.getAmount());
    assertSame(amount5, absResult10.zero().getAmount());
    assertSame(amount5, zeroResult5.getAmount());
    assertSame(amount5, zeroResult6.zero().getAmount());
    assertSame(amount5, zeroResult7.getAmount());
    assertSame(amount5, zeroResult7.zero().getAmount());
    BigDecimal amount6 = absResult2.getAmount();
    Money zeroResult8 = absResult2.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    Money absResult13 = absResult12.abs();
    assertSame(amount6, absResult13.abs().getAmount());
    assertSame(amount6, absResult13.getAmount());
    Money zeroResult9 = zeroResult8.zero();
    Money absResult14 = zeroResult9.abs();
    Money absResult15 = absResult14.abs();
    assertSame(amount6, absResult15.abs().getAmount());
    assertSame(amount6, absResult12.getAmount());
    Money zeroResult10 = absResult11.zero();
    Money absResult16 = zeroResult10.abs();
    assertSame(amount6, absResult16.abs().getAmount());
    assertSame(amount6, absResult15.getAmount());
    Money zeroResult11 = zeroResult9.zero();
    Money absResult17 = zeroResult11.abs();
    assertSame(amount6, absResult17.abs().getAmount());
    assertSame(amount6, amount6);
    Money zeroResult12 = absResult12.zero();
    assertSame(amount6, zeroResult12.abs().getAmount());
    assertSame(amount6, absResult11.getAmount());
    assertSame(amount6, absResult16.getAmount());
    Money zeroResult13 = absResult14.zero();
    assertSame(amount6, zeroResult13.abs().getAmount());
    assertSame(amount6, absResult14.getAmount());
    Money zeroResult14 = zeroResult10.zero();
    assertSame(amount6, zeroResult14.abs().getAmount());
    assertSame(amount6, absResult17.getAmount());
    Money zeroResult15 = zeroResult11.zero();
    assertSame(amount6, zeroResult15.abs().getAmount());
    assertSame(amount6, absResult13.zero().getAmount());
    assertSame(amount6, zeroResult12.getAmount());
    assertSame(amount6, absResult15.zero().getAmount());
    assertSame(amount6, zeroResult8.getAmount());
    assertSame(amount6, zeroResult10.getAmount());
    assertSame(amount6, absResult16.zero().getAmount());
    assertSame(amount6, zeroResult13.getAmount());
    assertSame(amount6, absResult17.zero().getAmount());
    assertSame(amount6, zeroResult12.zero().getAmount());
    assertSame(amount6, zeroResult9.getAmount());
    assertSame(amount6, zeroResult14.getAmount());
    assertSame(amount6, zeroResult13.zero().getAmount());
    assertSame(amount6, zeroResult11.getAmount());
    assertSame(amount6, zeroResult14.zero().getAmount());
    assertSame(amount6, zeroResult15.getAmount());
    assertSame(amount6, zeroResult15.zero().getAmount());
    Money zeroResult16 = adjustmentValue.zero();
    Money absResult18 = zeroResult16.abs();
    Money absResult19 = absResult18.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(amount, absResult22.abs().getAmount());
    Money zeroResult17 = absResult.zero();
    Money absResult23 = zeroResult17.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount, absResult26.abs().getAmount());
    Money zeroResult18 = zeroResult16.zero();
    Money absResult27 = zeroResult18.abs();
    Money absResult28 = absResult27.abs();
    Money absResult29 = absResult28.abs();
    Money absResult30 = absResult29.abs();
    assertSame(amount, absResult30.abs().getAmount());
    assertSame(amount, absResult22.getAmount());
    Money zeroResult19 = absResult18.zero();
    Money absResult31 = zeroResult19.abs();
    Money absResult32 = absResult31.abs();
    Money absResult33 = absResult32.abs();
    assertSame(amount, absResult33.abs().getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult20 = zeroResult17.zero();
    Money absResult34 = zeroResult20.abs();
    Money absResult35 = absResult34.abs();
    Money absResult36 = absResult35.abs();
    assertSame(amount, absResult36.abs().getAmount());
    Money zeroResult21 = zeroResult18.zero();
    Money absResult37 = zeroResult21.abs();
    Money absResult38 = absResult37.abs();
    Money absResult39 = absResult38.abs();
    assertSame(amount, absResult39.abs().getAmount());
    assertSame(amount, absResult30.getAmount());
    assertSame(amount, absResult21.getAmount());
    Money zeroResult22 = absResult19.zero();
    Money absResult40 = zeroResult22.abs();
    Money absResult41 = absResult40.abs();
    assertSame(amount, absResult41.abs().getAmount());
    Money zeroResult23 = absResult23.zero();
    Money absResult42 = zeroResult23.abs();
    Money absResult43 = absResult42.abs();
    assertSame(amount, absResult43.abs().getAmount());
    Money zeroResult24 = absResult27.zero();
    Money absResult44 = zeroResult24.abs();
    Money absResult45 = absResult44.abs();
    assertSame(amount, absResult45.abs().getAmount());
    assertSame(amount, absResult33.getAmount());
    assertSame(amount, absResult25.getAmount());
    Money zeroResult25 = zeroResult19.zero();
    Money absResult46 = zeroResult25.abs();
    Money absResult47 = absResult46.abs();
    assertSame(amount, absResult47.abs().getAmount());
    assertSame(amount, absResult36.getAmount());
    Money zeroResult26 = zeroResult20.zero();
    Money absResult48 = zeroResult26.abs();
    Money absResult49 = absResult48.abs();
    assertSame(amount, absResult49.abs().getAmount());
    assertSame(amount, absResult39.getAmount());
    assertSame(amount, absResult29.getAmount());
    assertSame(amount, absResult20.getAmount());
    Money zeroResult27 = absResult20.zero();
    Money absResult50 = zeroResult27.abs();
    assertSame(amount, absResult50.abs().getAmount());
    Money zeroResult28 = absResult24.zero();
    Money absResult51 = zeroResult28.abs();
    assertSame(amount, absResult51.abs().getAmount());
    Money zeroResult29 = absResult28.zero();
    Money absResult52 = zeroResult29.abs();
    assertSame(amount, absResult52.abs().getAmount());
    assertSame(amount, absResult41.getAmount());
    Money zeroResult30 = absResult31.zero();
    Money absResult53 = zeroResult30.abs();
    assertSame(amount, absResult53.abs().getAmount());
    assertSame(amount, absResult43.getAmount());
    Money zeroResult31 = absResult34.zero();
    Money absResult54 = zeroResult31.abs();
    assertSame(amount, absResult54.abs().getAmount());
    Money zeroResult32 = absResult37.zero();
    Money absResult55 = zeroResult32.abs();
    assertSame(amount, absResult55.abs().getAmount());
    assertSame(amount, absResult45.getAmount());
    assertSame(amount, absResult32.getAmount());
    assertSame(amount, absResult24.getAmount());
    Money zeroResult33 = zeroResult22.zero();
    Money absResult56 = zeroResult33.abs();
    assertSame(amount, absResult56.abs().getAmount());
    Money zeroResult34 = zeroResult23.zero();
    Money absResult57 = zeroResult34.abs();
    assertSame(amount, absResult57.abs().getAmount());
    Money zeroResult35 = zeroResult24.zero();
    Money absResult58 = zeroResult35.abs();
    assertSame(amount, absResult58.abs().getAmount());
    assertSame(amount, absResult47.getAmount());
    assertSame(amount, absResult35.getAmount());
    Money zeroResult36 = zeroResult25.zero();
    Money absResult59 = zeroResult36.abs();
    assertSame(amount, absResult59.abs().getAmount());
    assertSame(amount, absResult49.getAmount());
    Money zeroResult37 = zeroResult26.zero();
    Money absResult60 = zeroResult37.abs();
    assertSame(amount, absResult60.abs().getAmount());
    Money zeroResult38 = zeroResult21.zero();
    Money absResult61 = zeroResult38.abs();
    assertSame(amount, absResult61.abs().getAmount());
    assertSame(amount, absResult38.getAmount());
    assertSame(amount, absResult28.getAmount());
    assertSame(amount, absResult19.getAmount());
    Money zeroResult39 = absResult21.zero();
    assertSame(amount, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult25.zero();
    assertSame(amount, zeroResult40.abs().getAmount());
    Money zeroResult41 = absResult29.zero();
    assertSame(amount, zeroResult41.abs().getAmount());
    assertSame(amount, absResult50.getAmount());
    Money zeroResult42 = absResult32.zero();
    assertSame(amount, zeroResult42.abs().getAmount());
    assertSame(amount, absResult51.getAmount());
    Money zeroResult43 = absResult35.zero();
    assertSame(amount, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult38.zero();
    assertSame(amount, zeroResult44.abs().getAmount());
    assertSame(amount, absResult52.getAmount());
    assertSame(amount, absResult40.getAmount());
    Money zeroResult45 = absResult40.zero();
    assertSame(amount, zeroResult45.abs().getAmount());
    Money zeroResult46 = absResult42.zero();
    assertSame(amount, zeroResult46.abs().getAmount());
    Money zeroResult47 = absResult44.zero();
    assertSame(amount, zeroResult47.abs().getAmount());
    assertSame(amount, absResult53.getAmount());
    assertSame(amount, absResult42.getAmount());
    Money zeroResult48 = absResult46.zero();
    assertSame(amount, zeroResult48.abs().getAmount());
    assertSame(amount, absResult54.getAmount());
    Money zeroResult49 = absResult48.zero();
    assertSame(amount, zeroResult49.abs().getAmount());
    assertSame(amount, absResult55.getAmount());
    assertSame(amount, absResult44.getAmount());
    assertSame(amount, absResult31.getAmount());
    assertSame(amount, absResult23.getAmount());
    Money zeroResult50 = zeroResult27.zero();
    assertSame(amount, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult28.zero();
    assertSame(amount, zeroResult51.abs().getAmount());
    Money zeroResult52 = zeroResult29.zero();
    assertSame(amount, zeroResult52.abs().getAmount());
    assertSame(amount, absResult56.getAmount());
    Money zeroResult53 = zeroResult30.zero();
    assertSame(amount, zeroResult53.abs().getAmount());
    assertSame(amount, absResult57.getAmount());
    Money zeroResult54 = zeroResult31.zero();
    assertSame(amount, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult32.zero();
    assertSame(amount, zeroResult55.abs().getAmount());
    assertSame(amount, absResult58.getAmount());
    assertSame(amount, absResult46.getAmount());
    assertSame(amount, absResult34.getAmount());
    Money zeroResult56 = zeroResult33.zero();
    assertSame(amount, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult34.zero();
    assertSame(amount, zeroResult57.abs().getAmount());
    Money zeroResult58 = zeroResult35.zero();
    assertSame(amount, zeroResult58.abs().getAmount());
    assertSame(amount, absResult59.getAmount());
    assertSame(amount, absResult48.getAmount());
    Money zeroResult59 = zeroResult36.zero();
    assertSame(amount, zeroResult59.abs().getAmount());
    assertSame(amount, absResult60.getAmount());
    Money zeroResult60 = zeroResult37.zero();
    assertSame(amount, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult38.zero();
    assertSame(amount, zeroResult61.abs().getAmount());
    assertSame(amount, absResult61.getAmount());
    assertSame(amount, absResult37.getAmount());
    assertSame(amount, absResult27.getAmount());
    assertSame(amount, absResult18.getAmount());
    assertSame(amount, absResult22.zero().getAmount());
    assertSame(amount, absResult26.zero().getAmount());
    assertSame(amount, absResult30.zero().getAmount());
    assertSame(amount, zeroResult39.getAmount());
    assertSame(amount, absResult33.zero().getAmount());
    assertSame(amount, zeroResult40.getAmount());
    assertSame(amount, absResult36.zero().getAmount());
    assertSame(amount, absResult39.zero().getAmount());
    assertSame(amount, zeroResult41.getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, absResult41.zero().getAmount());
    assertSame(amount, absResult43.zero().getAmount());
    assertSame(amount, absResult45.zero().getAmount());
    assertSame(amount, zeroResult42.getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, absResult47.zero().getAmount());
    assertSame(amount, zeroResult43.getAmount());
    assertSame(amount, absResult49.zero().getAmount());
    assertSame(amount, zeroResult44.getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult22.getAmount());
    assertSame(amount, absResult50.zero().getAmount());
    assertSame(amount, absResult51.zero().getAmount());
    assertSame(amount, absResult52.zero().getAmount());
    assertSame(amount, zeroResult45.getAmount());
    assertSame(amount, absResult53.zero().getAmount());
    assertSame(amount, zeroResult46.getAmount());
    assertSame(amount, absResult54.zero().getAmount());
    assertSame(amount, absResult55.zero().getAmount());
    assertSame(amount, zeroResult47.getAmount());
    assertSame(amount, zeroResult30.getAmount());
    assertSame(amount, zeroResult23.getAmount());
    assertSame(amount, absResult56.zero().getAmount());
    assertSame(amount, absResult57.zero().getAmount());
    assertSame(amount, absResult58.zero().getAmount());
    assertSame(amount, zeroResult48.getAmount());
    assertSame(amount, zeroResult31.getAmount());
    assertSame(amount, absResult59.zero().getAmount());
    assertSame(amount, zeroResult49.getAmount());
    assertSame(amount, absResult60.zero().getAmount());
    assertSame(amount, absResult61.zero().getAmount());
    assertSame(amount, zeroResult32.getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult19.getAmount());
    assertSame(amount, zeroResult17.getAmount());
    assertSame(amount, zeroResult39.zero().getAmount());
    assertSame(amount, zeroResult40.zero().getAmount());
    assertSame(amount, zeroResult41.zero().getAmount());
    assertSame(amount, zeroResult50.getAmount());
    assertSame(amount, zeroResult42.zero().getAmount());
    assertSame(amount, zeroResult51.getAmount());
    assertSame(amount, zeroResult43.zero().getAmount());
    assertSame(amount, zeroResult44.zero().getAmount());
    assertSame(amount, zeroResult52.getAmount());
    assertSame(amount, zeroResult33.getAmount());
    assertSame(amount, zeroResult45.zero().getAmount());
    assertSame(amount, zeroResult46.zero().getAmount());
    assertSame(amount, zeroResult47.zero().getAmount());
    assertSame(amount, zeroResult53.getAmount());
    assertSame(amount, zeroResult34.getAmount());
    assertSame(amount, zeroResult48.zero().getAmount());
    assertSame(amount, zeroResult54.getAmount());
    assertSame(amount, zeroResult49.zero().getAmount());
    assertSame(amount, zeroResult55.getAmount());
    assertSame(amount, zeroResult35.getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, zeroResult20.getAmount());
    assertSame(amount, zeroResult50.zero().getAmount());
    assertSame(amount, zeroResult51.zero().getAmount());
    assertSame(amount, zeroResult52.zero().getAmount());
    assertSame(amount, zeroResult56.getAmount());
    assertSame(amount, zeroResult53.zero().getAmount());
    assertSame(amount, zeroResult57.getAmount());
    assertSame(amount, zeroResult54.zero().getAmount());
    assertSame(amount, zeroResult55.zero().getAmount());
    assertSame(amount, zeroResult58.getAmount());
    assertSame(amount, zeroResult36.getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult56.zero().getAmount());
    assertSame(amount, zeroResult57.zero().getAmount());
    assertSame(amount, zeroResult58.zero().getAmount());
    assertSame(amount, zeroResult59.getAmount());
    assertSame(amount, zeroResult37.getAmount());
    assertSame(amount, zeroResult59.zero().getAmount());
    assertSame(amount, zeroResult60.getAmount());
    assertSame(amount, zeroResult60.zero().getAmount());
    assertSame(amount, zeroResult61.zero().getAmount());
    assertSame(amount, zeroResult61.getAmount());
    assertSame(amount, zeroResult38.getAmount());
    assertSame(amount, zeroResult21.getAmount());
    assertSame(amount, zeroResult18.getAmount());
    assertSame(amount, zeroResult16.getAmount());
  }

  /**
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
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
    Money money2 = new Money();
    when(money.subtract(Mockito.<Money>any())).thenReturn(money2);
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(money);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl = new PromotableOrderAdjustmentImpl(
        promotableCandidateOrderOffer, promotableOrder, new Money());

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
    assertEquals(money2, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
  }

  /**
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <ul>
   *   <li>Then return AdjustmentValue is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testNewPromotableOrderAdjustmentImpl_thenReturnAdjustmentValueIsMoney() {
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
    assertEquals(money, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
  }

  /**
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}.
   * <ul>
   *   <li>Then return AdjustmentValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
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
   * Test
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}.
   * <ul>
   *   <li>Then return RoundingScale is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
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

  /**
   * Test {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getCurrency()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue_givenNullOrderImplGetCurrencyReturnNull() {
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
   * Test {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#getDiscountType()} return
   * {@link OfferDiscountType#FIX_PRICE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue_givenOfferImplGetDiscountTypeReturnFix_price() {
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
   * Test {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#getDiscountType()} return
   * {@link OfferDiscountType#OfferDiscountType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue_givenOfferImplGetDiscountTypeReturnOfferDiscountType() {
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
   * Test {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#getDiscountType()} return
   * {@link OfferDiscountType}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue_givenOfferImplGetDiscountTypeReturnOfferDiscountType2() {
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
   * Test {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#getDiscountType()} return
   * {@link OfferDiscountType#PERCENT_OFF}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue_givenOfferImplGetDiscountTypeReturnPercent_off() {
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
   * Test {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#getValue()} return
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue_givenOfferImplGetValueReturnBigDecimalWith23() {
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
   * Test {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#getValue()} return
   * {@link BigDecimal#BigDecimal(String)} with {@code -2.3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderAdjustmentImpl#computeAdjustmentValue()}
   */
  @Test
  public void testComputeAdjustmentValue_givenOfferImplGetValueReturnBigDecimalWith232() {
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
   * Test {@link PromotableOrderAdjustmentImpl#isCombinable()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable_thenReturnFalse() {
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
   * Test {@link PromotableOrderAdjustmentImpl#isCombinable()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable_thenReturnTrue() {
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
   * Test {@link PromotableOrderAdjustmentImpl#isTotalitarian()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#isTotalitarianOffer()} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian_givenOfferImplIsTotalitarianOfferReturnFalse_thenReturnFalse() {
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
   * Test {@link PromotableOrderAdjustmentImpl#isTotalitarian()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#isTotalitarianOffer()} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderAdjustmentImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian_givenOfferImplIsTotalitarianOfferReturnTrue_thenReturnTrue() {
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
}
