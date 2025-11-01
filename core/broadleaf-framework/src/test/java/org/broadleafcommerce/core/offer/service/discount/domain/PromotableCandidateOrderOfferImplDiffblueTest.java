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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.junit.Test;

public class PromotableCandidateOrderOfferImplDiffblueTest {
  /**
   * Method under test:
   * {@link PromotableCandidateOrderOfferImpl#calculatePotentialSavings()}
   */
  @Test
  public void testCalculatePotentialSavings() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).calculatePotentialSavings();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer, atLeast(1)).getDiscountType();
    verify(offer, atLeast(1)).getValue();
    verify(promotableOrder, atLeast(1)).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
  }

  /**
   * Method under test:
   * {@link PromotableCandidateOrderOfferImpl#calculatePotentialSavings()}
   */
  @Test
  public void testCalculatePotentialSavings2() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money(10.0d));
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).calculatePotentialSavings();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer, atLeast(1)).getDiscountType();
    verify(offer, atLeast(1)).getValue();
    verify(promotableOrder, atLeast(1)).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
  }

  /**
   * Method under test:
   * {@link PromotableCandidateOrderOfferImpl#calculatePotentialSavings()}
   */
  @Test
  public void testCalculatePotentialSavings3() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);

    // Act
    (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).calculatePotentialSavings();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer, atLeast(1)).getDiscountType();
    verify(offer, atLeast(1)).getValue();
    verify(promotableOrder, atLeast(1)).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
  }

  /**
   * Method under test:
   * {@link PromotableCandidateOrderOfferImpl#calculatePotentialSavings()}
   */
  @Test
  public void testCalculatePotentialSavings4() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getDiscountType()).thenReturn(new OfferDiscountType("Type", "Friendly Type"));

    // Act
    (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).calculatePotentialSavings();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer, atLeast(1)).getDiscountType();
    verify(promotableOrder, atLeast(1)).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
  }

  /**
   * Method under test:
   * {@link PromotableCandidateOrderOfferImpl#calculatePotentialSavings()}
   */
  @Test
  public void testCalculatePotentialSavings5() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getDiscountType()).thenReturn(new OfferDiscountType());

    // Act
    (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).calculatePotentialSavings();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer, atLeast(1)).getDiscountType();
    verify(promotableOrder, atLeast(1)).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
  }

  /**
   * Method under test:
   * {@link PromotableCandidateOrderOfferImpl#calculatePotentialSavings()}
   */
  @Test
  public void testCalculatePotentialSavings6() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getDiscountType()).thenReturn(mock(OfferDiscountType.class));

    // Act
    (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).calculatePotentialSavings();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer, atLeast(1)).getDiscountType();
    verify(promotableOrder, atLeast(1)).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
  }

  /**
   * Method under test: {@link PromotableCandidateOrderOfferImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).getCurrency();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer).getDiscountType();
    verify(offer).getValue();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
  }

  /**
   * Method under test: {@link PromotableCandidateOrderOfferImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.isCombinableWithOtherOffers()).thenReturn(true);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    boolean actualIsCombinableResult = (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).isCombinable();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer).getDiscountType();
    verify(offer).getValue();
    verify(offer).isCombinableWithOtherOffers();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    assertTrue(actualIsCombinableResult);
  }

  /**
   * Method under test: {@link PromotableCandidateOrderOfferImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable2() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.isCombinableWithOtherOffers()).thenReturn(false);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    boolean actualIsCombinableResult = (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).isCombinable();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer).getDiscountType();
    verify(offer).getValue();
    verify(offer).isCombinableWithOtherOffers();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    assertFalse(actualIsCombinableResult);
  }

  /**
   * Method under test: {@link PromotableCandidateOrderOfferImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.isTotalitarianOffer()).thenReturn(true);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    boolean actualIsTotalitarianResult = (new PromotableCandidateOrderOfferImpl(promotableOrder, offer))
        .isTotalitarian();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer).getDiscountType();
    verify(offer).getValue();
    verify(offer).isTotalitarianOffer();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    assertTrue(actualIsTotalitarianResult);
  }

  /**
   * Method under test: {@link PromotableCandidateOrderOfferImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian2() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.isTotalitarianOffer()).thenReturn(false);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    boolean actualIsTotalitarianResult = (new PromotableCandidateOrderOfferImpl(promotableOrder, offer))
        .isTotalitarian();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer).getDiscountType();
    verify(offer).getValue();
    verify(offer).isTotalitarianOffer();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    assertFalse(actualIsTotalitarianResult);
  }

  /**
   * Method under test: {@link PromotableCandidateOrderOfferImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian3() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.isTotalitarianOffer()).thenReturn(null);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    boolean actualIsTotalitarianResult = (new PromotableCandidateOrderOfferImpl(promotableOrder, offer))
        .isTotalitarian();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer).getDiscountType();
    verify(offer).getValue();
    verify(offer).isTotalitarianOffer();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    assertFalse(actualIsTotalitarianResult);
  }

  /**
   * Method under test: {@link PromotableCandidateOrderOfferImpl#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrencyImpl);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getPriority()).thenReturn(1);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    int actualPriority = (new PromotableCandidateOrderOfferImpl(promotableOrder, offer)).getPriority();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offer).getDiscountType();
    verify(offer).getPriority();
    verify(offer).getValue();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    assertEquals(1, actualPriority);
  }
}
