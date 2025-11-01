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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.RoundingMode;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.junit.Test;

public class PromotableOrderItemPriceDetailAdjustmentImplDiffblueTest {
  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment.getRetailPriceValue()).thenReturn(new Money());
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    when(itemAdjustment.getValue()).thenReturn(new Money());
    when(itemAdjustment.getOffer()).thenReturn(new OfferImpl());
    PromotableOrderItemImpl promotableOrderItem = mock(PromotableOrderItemImpl.class);
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    when(promotableOrderItem.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    BroadleafCurrency actualCurrency = (new PromotableOrderItemPriceDetailAdjustmentImpl(itemAdjustment,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(promotableOrderItem, 1))))
        .getCurrency();

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    verify(promotableOrderItem).getCurrency();
    assertSame(broadleafCurrencyImpl, actualCurrency);
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment.getRetailPriceValue()).thenReturn(new Money());
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    when(itemAdjustment.getValue()).thenReturn(new Money());
    when(itemAdjustment.getOffer()).thenReturn(new OfferImpl());

    // Act
    boolean actualIsCombinableResult = (new PromotableOrderItemPriceDetailAdjustmentImpl(itemAdjustment,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1)))).isCombinable();

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertTrue(actualIsCombinableResult);
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable2() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isCombinableWithOtherOffers()).thenReturn(false);
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment.getRetailPriceValue()).thenReturn(new Money());
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    when(itemAdjustment.getValue()).thenReturn(new Money());
    when(itemAdjustment.getOffer()).thenReturn(offerImpl);

    // Act
    boolean actualIsCombinableResult = (new PromotableOrderItemPriceDetailAdjustmentImpl(itemAdjustment,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1)))).isCombinable();

    // Assert
    verify(offerImpl).isCombinableWithOtherOffers();
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertFalse(actualIsCombinableResult);
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment.getRetailPriceValue()).thenReturn(new Money());
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    when(itemAdjustment.getValue()).thenReturn(new Money());
    when(itemAdjustment.getOffer()).thenReturn(new OfferImpl());

    // Act
    boolean actualIsTotalitarianResult = (new PromotableOrderItemPriceDetailAdjustmentImpl(itemAdjustment,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1)))).isTotalitarian();

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertFalse(actualIsTotalitarianResult);
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian2() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isTotalitarianOffer()).thenReturn(true);
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment.getRetailPriceValue()).thenReturn(new Money());
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    when(itemAdjustment.getValue()).thenReturn(new Money());
    when(itemAdjustment.getOffer()).thenReturn(offerImpl);

    // Act
    boolean actualIsTotalitarianResult = (new PromotableOrderItemPriceDetailAdjustmentImpl(itemAdjustment,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1)))).isTotalitarian();

    // Assert
    verify(offerImpl).isTotalitarianOffer();
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertTrue(actualIsTotalitarianResult);
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian3() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isTotalitarianOffer()).thenReturn(null);
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment.getRetailPriceValue()).thenReturn(new Money());
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    when(itemAdjustment.getValue()).thenReturn(new Money());
    when(itemAdjustment.getOffer()).thenReturn(offerImpl);

    // Act
    boolean actualIsTotalitarianResult = (new PromotableOrderItemPriceDetailAdjustmentImpl(itemAdjustment,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1)))).isTotalitarian();

    // Assert
    verify(offerImpl).isTotalitarianOffer();
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertFalse(actualIsTotalitarianResult);
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#getOfferId()}
   */
  @Test
  public void testGetOfferId() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment.getRetailPriceValue()).thenReturn(new Money());
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    when(itemAdjustment.getValue()).thenReturn(new Money());
    when(itemAdjustment.getOffer()).thenReturn(new OfferImpl());

    // Act
    Long actualOfferId = (new PromotableOrderItemPriceDetailAdjustmentImpl(itemAdjustment,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1)))).getOfferId();

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertNull(actualOfferId);
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#finalizeAdjustment(boolean)}
   */
  @Test
  public void testFinalizeAdjustment() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    Money money = new Money();
    when(itemAdjustment.getRetailPriceValue()).thenReturn(money);
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    Money money2 = new Money();
    when(itemAdjustment.getValue()).thenReturn(money2);
    when(itemAdjustment.getOffer()).thenReturn(new OfferImpl());
    PromotableOrderItemPriceDetailAdjustmentImpl promotableOrderItemPriceDetailAdjustmentImpl = new PromotableOrderItemPriceDetailAdjustmentImpl(
        itemAdjustment, new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1)));

    // Act
    promotableOrderItemPriceDetailAdjustmentImpl.finalizeAdjustment(true);

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertTrue(promotableOrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertSame(money2, promotableOrderItemPriceDetailAdjustmentImpl.getAdjustmentValue());
    assertSame(money, promotableOrderItemPriceDetailAdjustmentImpl.getRetailAdjustmentValue());
    assertSame(money2, promotableOrderItemPriceDetailAdjustmentImpl.getSaleAdjustmentValue());
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#finalizeAdjustment(boolean)}
   */
  @Test
  public void testFinalizeAdjustment2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    Money money = new Money();
    when(itemAdjustment.getRetailPriceValue()).thenReturn(money);
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    Money money2 = new Money();
    when(itemAdjustment.getValue()).thenReturn(money2);
    when(itemAdjustment.getOffer()).thenReturn(new OfferImpl());
    PromotableOrderItemPriceDetailAdjustmentImpl promotableOrderItemPriceDetailAdjustmentImpl = new PromotableOrderItemPriceDetailAdjustmentImpl(
        itemAdjustment, new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1)));

    // Act
    promotableOrderItemPriceDetailAdjustmentImpl.finalizeAdjustment(false);

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertFalse(promotableOrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertSame(money, promotableOrderItemPriceDetailAdjustmentImpl.getAdjustmentValue());
    assertSame(money, promotableOrderItemPriceDetailAdjustmentImpl.getRetailAdjustmentValue());
    assertSame(money2, promotableOrderItemPriceDetailAdjustmentImpl.getSaleAdjustmentValue());
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#PromotableOrderItemPriceDetailAdjustmentImpl(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testNewPromotableOrderItemPriceDetailAdjustmentImpl() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    Money money = new Money();
    when(itemAdjustment.getRetailPriceValue()).thenReturn(money);
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    Money money2 = new Money();
    when(itemAdjustment.getValue()).thenReturn(money2);
    OfferImpl offerImpl = new OfferImpl();
    when(itemAdjustment.getOffer()).thenReturn(offerImpl);
    PromotableOrderItemPriceDetailWrapper orderItemPriceDetail = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true),
            1));

    // Act
    PromotableOrderItemPriceDetailAdjustmentImpl actualPromotableOrderItemPriceDetailAdjustmentImpl = new PromotableOrderItemPriceDetailAdjustmentImpl(
        itemAdjustment, orderItemPriceDetail);

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertNull(actualPromotableOrderItemPriceDetailAdjustmentImpl.getRoundingScale());
    assertNull(actualPromotableOrderItemPriceDetailAdjustmentImpl.getOfferId());
    assertNull(actualPromotableOrderItemPriceDetailAdjustmentImpl.roundingMode);
    assertNull(actualPromotableOrderItemPriceDetailAdjustmentImpl.promotableCandidateItemOffer);
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderItemPriceDetailAdjustmentImpl.getRoundingMode());
    assertTrue(actualPromotableOrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertSame(money2, actualPromotableOrderItemPriceDetailAdjustmentImpl.getAdjustmentValue());
    assertSame(money, actualPromotableOrderItemPriceDetailAdjustmentImpl.getRetailAdjustmentValue());
    assertSame(money2, actualPromotableOrderItemPriceDetailAdjustmentImpl.getSaleAdjustmentValue());
    assertSame(offerImpl, actualPromotableOrderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(orderItemPriceDetail,
        actualPromotableOrderItemPriceDetailAdjustmentImpl.getPromotableOrderItemPriceDetail());
  }

  /**
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#PromotableOrderItemPriceDetailAdjustmentImpl(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testNewPromotableOrderItemPriceDetailAdjustmentImpl2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(false);
    Money money = new Money();
    when(itemAdjustment.getSalesPriceValue()).thenReturn(money);
    Money money2 = new Money();
    when(itemAdjustment.getValue()).thenReturn(money2);
    OfferImpl offerImpl = new OfferImpl();
    when(itemAdjustment.getOffer()).thenReturn(offerImpl);
    PromotableOrderItemPriceDetailWrapper orderItemPriceDetail = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true),
            1));

    // Act
    PromotableOrderItemPriceDetailAdjustmentImpl actualPromotableOrderItemPriceDetailAdjustmentImpl = new PromotableOrderItemPriceDetailAdjustmentImpl(
        itemAdjustment, orderItemPriceDetail);

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getSalesPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertNull(actualPromotableOrderItemPriceDetailAdjustmentImpl.getRoundingScale());
    assertNull(actualPromotableOrderItemPriceDetailAdjustmentImpl.getOfferId());
    assertNull(actualPromotableOrderItemPriceDetailAdjustmentImpl.roundingMode);
    assertNull(actualPromotableOrderItemPriceDetailAdjustmentImpl.promotableCandidateItemOffer);
    assertEquals(RoundingMode.HALF_EVEN, actualPromotableOrderItemPriceDetailAdjustmentImpl.getRoundingMode());
    assertFalse(actualPromotableOrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertSame(money2, actualPromotableOrderItemPriceDetailAdjustmentImpl.getAdjustmentValue());
    assertSame(money2, actualPromotableOrderItemPriceDetailAdjustmentImpl.getRetailAdjustmentValue());
    assertSame(money, actualPromotableOrderItemPriceDetailAdjustmentImpl.getSaleAdjustmentValue());
    assertSame(offerImpl, actualPromotableOrderItemPriceDetailAdjustmentImpl.getOffer());
    assertSame(orderItemPriceDetail,
        actualPromotableOrderItemPriceDetailAdjustmentImpl.getPromotableOrderItemPriceDetail());
  }
}
