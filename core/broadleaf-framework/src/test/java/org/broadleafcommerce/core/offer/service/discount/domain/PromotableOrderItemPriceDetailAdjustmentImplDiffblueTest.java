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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Test
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#PromotableOrderItemPriceDetailAdjustmentImpl(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#PromotableOrderItemPriceDetailAdjustmentImpl(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testNewPromotableOrderItemPriceDetailAdjustmentImpl() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(false);
    when(itemAdjustment.getSalesPriceValue()).thenReturn(new Money());
    when(itemAdjustment.getValue()).thenReturn(new Money());
    when(itemAdjustment.getOffer()).thenReturn(new OfferImpl());
    Money expectedSaleAdjustmentValue = new Money();

    // Act
    PromotableOrderItemPriceDetailAdjustmentImpl actualPromotableOrderItemPriceDetailAdjustmentImpl = new PromotableOrderItemPriceDetailAdjustmentImpl(
        itemAdjustment, new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getSalesPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertFalse(actualPromotableOrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(expectedSaleAdjustmentValue,
        actualPromotableOrderItemPriceDetailAdjustmentImpl.getSaleAdjustmentValue());
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#PromotableOrderItemPriceDetailAdjustmentImpl(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Then return AppliedToSalePrice.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#PromotableOrderItemPriceDetailAdjustmentImpl(OrderItemPriceDetailAdjustment, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testNewPromotableOrderItemPriceDetailAdjustmentImpl_thenReturnAppliedToSalePrice() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = mock(OrderItemPriceDetailAdjustmentImpl.class);
    Money money = new Money();
    when(itemAdjustment.getRetailPriceValue()).thenReturn(money);
    when(itemAdjustment.isAppliedToSalePrice()).thenReturn(true);
    when(itemAdjustment.getValue()).thenReturn(new Money());
    when(itemAdjustment.getOffer()).thenReturn(new OfferImpl());

    // Act
    PromotableOrderItemPriceDetailAdjustmentImpl actualPromotableOrderItemPriceDetailAdjustmentImpl = new PromotableOrderItemPriceDetailAdjustmentImpl(
        itemAdjustment, new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));

    // Assert
    verify(itemAdjustment).getOffer();
    verify(itemAdjustment).getRetailPriceValue();
    verify(itemAdjustment, atLeast(1)).getValue();
    verify(itemAdjustment, atLeast(1)).isAppliedToSalePrice();
    assertTrue(actualPromotableOrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    Money retailAdjustmentValue = actualPromotableOrderItemPriceDetailAdjustmentImpl.getRetailAdjustmentValue();
    assertEquals(money, retailAdjustmentValue.abs());
    assertEquals(money, retailAdjustmentValue.zero());
    Money adjustmentValue = actualPromotableOrderItemPriceDetailAdjustmentImpl.getAdjustmentValue();
    assertEquals(retailAdjustmentValue, adjustmentValue.abs());
    assertEquals(retailAdjustmentValue, adjustmentValue.zero());
    assertSame(adjustmentValue, actualPromotableOrderItemPriceDetailAdjustmentImpl.getSaleAdjustmentValue());
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailAdjustmentImpl#getCurrency()}.
   * <ul>
   *   <li>Then return {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_thenReturnBroadleafCurrencyImpl() {
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
   * Test {@link PromotableOrderItemPriceDetailAdjustmentImpl#isCombinable()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable_thenReturnFalse() {
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
   * Test {@link PromotableOrderItemPriceDetailAdjustmentImpl#isCombinable()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#isCombinable()}
   */
  @Test
  public void testIsCombinable_thenReturnTrue() {
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
   * Test {@link PromotableOrderItemPriceDetailAdjustmentImpl#isTotalitarian()}.
   * <p>
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
   * Test {@link PromotableOrderItemPriceDetailAdjustmentImpl#isTotalitarian()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#isTotalitarianOffer()} return
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian_givenOfferImplIsTotalitarianOfferReturnNull_thenReturnFalse() {
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
   * Test {@link PromotableOrderItemPriceDetailAdjustmentImpl#isTotalitarian()}.
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#isTotalitarianOffer()} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#isTotalitarian()}
   */
  @Test
  public void testIsTotalitarian_givenOfferImplIsTotalitarianOfferReturnTrue_thenReturnTrue() {
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
   * Test {@link PromotableOrderItemPriceDetailAdjustmentImpl#getOfferId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#getOfferId()}
   */
  @Test
  public void testGetOfferId_thenReturnNull() {
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
   * Test
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#finalizeAdjustment(boolean)}.
   * <p>
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
    Money adjustmentValue = promotableOrderItemPriceDetailAdjustmentImpl.getAdjustmentValue();
    assertEquals(money, adjustmentValue.abs());
    assertEquals(money, adjustmentValue.zero());
    assertSame(money, promotableOrderItemPriceDetailAdjustmentImpl.getRetailAdjustmentValue());
    assertSame(money2, promotableOrderItemPriceDetailAdjustmentImpl.getSaleAdjustmentValue());
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailAdjustmentImpl#finalizeAdjustment(boolean)}.
   * <p>
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
    Money adjustmentValue = promotableOrderItemPriceDetailAdjustmentImpl.getAdjustmentValue();
    assertEquals(money, adjustmentValue.abs());
    assertEquals(money, adjustmentValue.zero());
    assertSame(money, promotableOrderItemPriceDetailAdjustmentImpl.getRetailAdjustmentValue());
    assertSame(money2, promotableOrderItemPriceDetailAdjustmentImpl.getSaleAdjustmentValue());
  }
}
