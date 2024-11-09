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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class PromotableOfferUtilityImplDiffblueTest {
  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetail() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, new OfferImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());

    // Act
    Money actualComputeRetailAdjustmentValueResult = promotableOfferUtilityImpl
        .computeRetailAdjustmentValue(promotableCandidateItemOffer, new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(order, atLeast(1)).getOrderAdjustments();
    assertEquals(actualComputeRetailAdjustmentValueResult.ZERO, actualComputeRetailAdjustmentValueResult);
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetail2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, new OfferImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
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

    // Act
    promotableOfferUtilityImpl.computeRetailAdjustmentValue(promotableCandidateItemOffer,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(order, atLeast(1)).getOrderAdjustments();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetail3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, new OfferImpl());

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getRetailPrice()).thenReturn(new Money());
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl.computeRetailAdjustmentValue(promotableCandidateItemOffer,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(orderItem).getRetailPrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetail4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Offer offer = mock(Offer.class);
    when(offer.getUseListForDiscounts()).thenReturn(true);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    Money money = new Money();
    when(orderItem.getRetailPrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    Money actualComputeRetailAdjustmentValueResult = promotableOfferUtilityImpl
        .computeRetailAdjustmentValue(promotableCandidateItemOffer, new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(offer).getDiscountType();
    verify(offer).getUseListForDiscounts();
    verify(offer).getValue();
    verify(orderItem).getRetailPrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
    assertSame(money, actualComputeRetailAdjustmentValueResult);
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetail5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.setScale(anyInt(), anyInt())).thenReturn(new BigDecimal("2.3"));
    Offer offer = mock(Offer.class);
    when(offer.getUseListForDiscounts()).thenReturn(true);
    when(offer.getValue()).thenReturn(internalNumber);
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);
    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getRetailPrice()).thenReturn(new Money());
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    Money actualComputeRetailAdjustmentValueResult = promotableOfferUtilityImpl
        .computeRetailAdjustmentValue(promotableCandidateItemOffer, new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(internalNumber).setScale(eq(2), eq(6));
    verify(offer).getDiscountType();
    verify(offer).getUseListForDiscounts();
    verify(offer).getValue();
    verify(orderItem).getRetailPrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
    BigDecimal expectedAmount = new BigDecimal("-2.30");
    assertEquals(expectedAmount, actualComputeRetailAdjustmentValueResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.00");
    Money zeroResult = actualComputeRetailAdjustmentValueResult.zero();
    BigDecimal amount = zeroResult.getAmount();
    assertEquals(expectedAmount2, amount);
    BigDecimal expectedAmount3 = new BigDecimal("2.30");
    Money absResult = actualComputeRetailAdjustmentValueResult.abs();
    assertEquals(expectedAmount3, absResult.getAmount());
    assertEquals(absResult.abs(), absResult.abs());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = zeroResult2.zero();
    Money zeroResult4 = zeroResult3.zero();
    Money zeroResult5 = zeroResult4.zero();
    BigDecimal amount2 = zeroResult5.zero().getAmount();
    Money absResult2 = zeroResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(amount2, absResult6.abs().getAmount());
    Money zeroResult6 = absResult.zero();
    Money absResult7 = zeroResult6.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    assertSame(amount2, absResult10.abs().getAmount());
    assertSame(amount2, absResult6.getAmount());
    Money zeroResult7 = absResult2.zero();
    Money absResult11 = zeroResult7.abs();
    Money absResult12 = absResult11.abs();
    Money absResult13 = absResult12.abs();
    assertSame(amount2, absResult13.abs().getAmount());
    assertSame(amount2, absResult10.getAmount());
    Money zeroResult8 = zeroResult6.zero();
    Money absResult14 = zeroResult8.abs();
    Money absResult15 = absResult14.abs();
    Money absResult16 = absResult15.abs();
    assertSame(amount2, absResult16.abs().getAmount());
    assertSame(amount2, absResult5.getAmount());
    Money zeroResult9 = absResult3.zero();
    Money absResult17 = zeroResult9.abs();
    Money absResult18 = absResult17.abs();
    assertSame(amount2, absResult18.abs().getAmount());
    Money zeroResult10 = absResult7.zero();
    Money absResult19 = zeroResult10.abs();
    Money absResult20 = absResult19.abs();
    assertSame(amount2, absResult20.abs().getAmount());
    assertSame(amount2, absResult13.getAmount());
    assertSame(amount2, absResult9.getAmount());
    Money zeroResult11 = zeroResult7.zero();
    Money absResult21 = zeroResult11.abs();
    Money absResult22 = absResult21.abs();
    assertSame(amount2, absResult22.abs().getAmount());
    assertSame(amount2, absResult16.getAmount());
    Money zeroResult12 = zeroResult8.zero();
    Money absResult23 = zeroResult12.abs();
    Money absResult24 = absResult23.abs();
    assertSame(amount2, absResult24.abs().getAmount());
    assertSame(amount2, absResult4.getAmount());
    Money zeroResult13 = absResult4.zero();
    Money absResult25 = zeroResult13.abs();
    assertSame(amount2, absResult25.abs().getAmount());
    Money zeroResult14 = absResult8.zero();
    Money absResult26 = zeroResult14.abs();
    assertSame(amount2, absResult26.abs().getAmount());
    assertSame(amount2, absResult18.getAmount());
    Money zeroResult15 = absResult11.zero();
    Money absResult27 = zeroResult15.abs();
    assertSame(amount2, absResult27.abs().getAmount());
    assertSame(amount2, absResult20.getAmount());
    Money zeroResult16 = absResult14.zero();
    Money absResult28 = zeroResult16.abs();
    assertSame(amount2, absResult28.abs().getAmount());
    assertSame(amount2, absResult12.getAmount());
    assertSame(amount2, absResult8.getAmount());
    Money zeroResult17 = zeroResult9.zero();
    Money absResult29 = zeroResult17.abs();
    assertSame(amount2, absResult29.abs().getAmount());
    Money zeroResult18 = zeroResult10.zero();
    Money absResult30 = zeroResult18.abs();
    assertSame(amount2, absResult30.abs().getAmount());
    assertSame(amount2, absResult22.getAmount());
    assertSame(amount2, absResult15.getAmount());
    Money zeroResult19 = zeroResult11.zero();
    Money absResult31 = zeroResult19.abs();
    assertSame(amount2, absResult31.abs().getAmount());
    assertSame(amount2, absResult24.getAmount());
    Money zeroResult20 = zeroResult12.zero();
    Money absResult32 = zeroResult20.abs();
    assertSame(amount2, absResult32.abs().getAmount());
    assertSame(amount2, absResult3.getAmount());
    Money zeroResult21 = absResult5.zero();
    assertSame(amount2, zeroResult21.abs().getAmount());
    Money zeroResult22 = absResult9.zero();
    assertSame(amount2, zeroResult22.abs().getAmount());
    assertSame(amount2, absResult25.getAmount());
    Money zeroResult23 = absResult12.zero();
    assertSame(amount2, zeroResult23.abs().getAmount());
    assertSame(amount2, absResult26.getAmount());
    Money zeroResult24 = absResult15.zero();
    assertSame(amount2, zeroResult24.abs().getAmount());
    assertSame(amount2, absResult17.getAmount());
    Money zeroResult25 = absResult17.zero();
    assertSame(amount2, zeroResult25.abs().getAmount());
    Money zeroResult26 = absResult19.zero();
    assertSame(amount2, zeroResult26.abs().getAmount());
    assertSame(amount2, absResult27.getAmount());
    assertSame(amount2, absResult19.getAmount());
    Money zeroResult27 = absResult21.zero();
    assertSame(amount2, zeroResult27.abs().getAmount());
    assertSame(amount2, absResult28.getAmount());
    Money zeroResult28 = absResult23.zero();
    assertSame(amount2, zeroResult28.abs().getAmount());
    assertSame(amount2, absResult11.getAmount());
    assertSame(amount2, absResult7.getAmount());
    Money zeroResult29 = zeroResult13.zero();
    assertSame(amount2, zeroResult29.abs().getAmount());
    Money zeroResult30 = zeroResult14.zero();
    assertSame(amount2, zeroResult30.abs().getAmount());
    assertSame(amount2, absResult29.getAmount());
    Money zeroResult31 = zeroResult15.zero();
    assertSame(amount2, zeroResult31.abs().getAmount());
    assertSame(amount2, absResult30.getAmount());
    Money zeroResult32 = zeroResult16.zero();
    assertSame(amount2, zeroResult32.abs().getAmount());
    assertSame(amount2, absResult21.getAmount());
    assertSame(amount2, absResult14.getAmount());
    Money zeroResult33 = zeroResult17.zero();
    assertSame(amount2, zeroResult33.abs().getAmount());
    Money zeroResult34 = zeroResult18.zero();
    assertSame(amount2, zeroResult34.abs().getAmount());
    assertSame(amount2, absResult31.getAmount());
    assertSame(amount2, absResult23.getAmount());
    Money zeroResult35 = zeroResult19.zero();
    assertSame(amount2, zeroResult35.abs().getAmount());
    assertSame(amount2, absResult32.getAmount());
    Money zeroResult36 = zeroResult20.zero();
    assertSame(amount2, zeroResult36.abs().getAmount());
    assertSame(amount2, absResult2.getAmount());
    assertSame(amount2, absResult6.zero().getAmount());
    assertSame(amount2, absResult10.zero().getAmount());
    assertSame(amount2, zeroResult21.getAmount());
    assertSame(amount2, absResult13.zero().getAmount());
    assertSame(amount2, zeroResult22.getAmount());
    assertSame(amount2, absResult16.zero().getAmount());
    assertSame(amount2, zeroResult13.getAmount());
    assertSame(amount2, absResult18.zero().getAmount());
    assertSame(amount2, absResult20.zero().getAmount());
    assertSame(amount2, zeroResult23.getAmount());
    assertSame(amount2, zeroResult14.getAmount());
    assertSame(amount2, absResult22.zero().getAmount());
    assertSame(amount2, zeroResult24.getAmount());
    assertSame(amount2, absResult24.zero().getAmount());
    assertSame(amount2, zeroResult9.getAmount());
    assertSame(amount2, absResult25.zero().getAmount());
    assertSame(amount2, absResult26.zero().getAmount());
    assertSame(amount2, zeroResult25.getAmount());
    assertSame(amount2, absResult27.zero().getAmount());
    assertSame(amount2, zeroResult26.getAmount());
    assertSame(amount2, absResult28.zero().getAmount());
    assertSame(amount2, zeroResult15.getAmount());
    assertSame(amount2, zeroResult10.getAmount());
    assertSame(amount2, absResult29.zero().getAmount());
    assertSame(amount2, absResult30.zero().getAmount());
    assertSame(amount2, zeroResult27.getAmount());
    assertSame(amount2, zeroResult16.getAmount());
    assertSame(amount2, absResult31.zero().getAmount());
    assertSame(amount2, zeroResult28.getAmount());
    assertSame(amount2, absResult32.zero().getAmount());
    assertSame(amount2, zeroResult7.getAmount());
    assertSame(amount2, zeroResult6.getAmount());
    assertSame(amount2, zeroResult21.zero().getAmount());
    assertSame(amount2, zeroResult22.zero().getAmount());
    assertSame(amount2, zeroResult29.getAmount());
    assertSame(amount2, zeroResult23.zero().getAmount());
    assertSame(amount2, zeroResult30.getAmount());
    assertSame(amount2, zeroResult24.zero().getAmount());
    assertSame(amount2, zeroResult17.getAmount());
    assertSame(amount2, zeroResult25.zero().getAmount());
    assertSame(amount2, zeroResult26.zero().getAmount());
    assertSame(amount2, zeroResult31.getAmount());
    assertSame(amount2, zeroResult18.getAmount());
    assertSame(amount2, zeroResult27.zero().getAmount());
    assertSame(amount2, zeroResult32.getAmount());
    assertSame(amount2, zeroResult28.zero().getAmount());
    assertSame(amount2, zeroResult11.getAmount());
    assertSame(amount2, zeroResult8.getAmount());
    assertSame(amount2, zeroResult29.zero().getAmount());
    assertSame(amount2, zeroResult30.zero().getAmount());
    assertSame(amount2, zeroResult33.getAmount());
    assertSame(amount2, zeroResult31.zero().getAmount());
    assertSame(amount2, zeroResult34.getAmount());
    assertSame(amount2, zeroResult32.zero().getAmount());
    assertSame(amount2, zeroResult19.getAmount());
    assertSame(amount2, zeroResult12.getAmount());
    assertSame(amount2, zeroResult33.zero().getAmount());
    assertSame(amount2, zeroResult34.zero().getAmount());
    assertSame(amount2, zeroResult35.getAmount());
    assertSame(amount2, zeroResult20.getAmount());
    assertSame(amount2, zeroResult35.zero().getAmount());
    assertSame(amount2, zeroResult36.getAmount());
    assertSame(amount2, zeroResult36.zero().getAmount());
    assertSame(amount2, amount2);
    assertSame(zeroResult5.getAmount(), zeroResult5.getAmount());
    BigDecimal amount3 = zeroResult4.getAmount();
    assertSame(amount3, zeroResult5.abs().getAmount());
    assertSame(amount3, amount3);
    BigDecimal amount4 = zeroResult3.getAmount();
    Money absResult33 = zeroResult4.abs();
    Money absResult34 = absResult33.abs();
    assertSame(amount4, absResult34.abs().getAmount());
    assertSame(amount4, absResult34.getAmount());
    assertSame(amount4, absResult33.getAmount());
    assertSame(amount4, absResult34.zero().getAmount());
    assertSame(amount4, absResult33.zero().getAmount());
    assertSame(amount4, amount4);
    BigDecimal amount5 = zeroResult2.getAmount();
    Money absResult35 = zeroResult3.abs();
    Money absResult36 = absResult35.abs();
    Money absResult37 = absResult36.abs();
    assertSame(amount5, absResult37.abs().getAmount());
    assertSame(amount5, absResult37.getAmount());
    Money zeroResult37 = absResult35.zero();
    Money absResult38 = zeroResult37.abs();
    assertSame(amount5, absResult38.abs().getAmount());
    assertSame(amount5, absResult36.getAmount());
    Money zeroResult38 = absResult36.zero();
    assertSame(amount5, zeroResult38.abs().getAmount());
    assertSame(amount5, absResult38.getAmount());
    Money zeroResult39 = zeroResult37.zero();
    assertSame(amount5, zeroResult39.abs().getAmount());
    assertSame(amount5, absResult35.getAmount());
    assertSame(amount5, absResult37.zero().getAmount());
    assertSame(amount5, zeroResult38.getAmount());
    assertSame(amount5, absResult38.zero().getAmount());
    assertSame(amount5, zeroResult37.getAmount());
    assertSame(amount5, zeroResult38.zero().getAmount());
    assertSame(amount5, zeroResult39.getAmount());
    assertSame(amount5, zeroResult39.zero().getAmount());
    assertSame(amount5, amount5);
    Money absResult39 = zeroResult2.abs();
    Money absResult40 = absResult39.abs();
    Money absResult41 = absResult40.abs();
    Money absResult42 = absResult41.abs();
    assertSame(amount, absResult42.abs().getAmount());
    assertSame(amount, absResult42.getAmount());
    Money zeroResult40 = absResult39.zero();
    Money absResult43 = zeroResult40.abs();
    Money absResult44 = absResult43.abs();
    assertSame(amount, absResult44.abs().getAmount());
    assertSame(amount, absResult41.getAmount());
    Money zeroResult41 = absResult40.zero();
    Money absResult45 = zeroResult41.abs();
    assertSame(amount, absResult45.abs().getAmount());
    assertSame(amount, absResult44.getAmount());
    Money zeroResult42 = zeroResult40.zero();
    Money absResult46 = zeroResult42.abs();
    assertSame(amount, absResult46.abs().getAmount());
    assertSame(amount, absResult40.getAmount());
    Money zeroResult43 = absResult41.zero();
    assertSame(amount, zeroResult43.abs().getAmount());
    assertSame(amount, absResult45.getAmount());
    Money zeroResult44 = absResult43.zero();
    assertSame(amount, zeroResult44.abs().getAmount());
    assertSame(amount, absResult43.getAmount());
    Money zeroResult45 = zeroResult41.zero();
    assertSame(amount, zeroResult45.abs().getAmount());
    assertSame(amount, absResult46.getAmount());
    Money zeroResult46 = zeroResult42.zero();
    assertSame(amount, zeroResult46.abs().getAmount());
    assertSame(amount, absResult39.getAmount());
    assertSame(amount, absResult42.zero().getAmount());
    assertSame(amount, zeroResult43.getAmount());
    assertSame(amount, absResult44.zero().getAmount());
    assertSame(amount, zeroResult41.getAmount());
    assertSame(amount, absResult45.zero().getAmount());
    assertSame(amount, zeroResult44.getAmount());
    assertSame(amount, absResult46.zero().getAmount());
    assertSame(amount, zeroResult40.getAmount());
    assertSame(amount, zeroResult43.zero().getAmount());
    assertSame(amount, zeroResult45.getAmount());
    assertSame(amount, zeroResult44.zero().getAmount());
    assertSame(amount, zeroResult42.getAmount());
    assertSame(amount, zeroResult45.zero().getAmount());
    assertSame(amount, zeroResult46.getAmount());
    assertSame(amount, zeroResult46.zero().getAmount());
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetail6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    Offer offer = mock(Offer.class);
    when(offer.getUseListForDiscounts()).thenReturn(true);
    when(offer.getValue()).thenReturn(internalNumber);
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getRetailPrice()).thenReturn(new Money());
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl.computeRetailAdjustmentValue(promotableCandidateItemOffer,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(offer).getDiscountType();
    verify(offer).getUseListForDiscounts();
    verify(offer).getValue();
    verify(orderItem).getRetailPrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetail7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Offer offer = mock(Offer.class);
    when(offer.getUseListForDiscounts()).thenReturn(true);
    when(offer.getValue()).thenReturn(mock(InternalNumber.class));
    when(offer.getDiscountType()).thenReturn(null);
    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getRetailPrice()).thenReturn(new Money());
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl.computeRetailAdjustmentValue(promotableCandidateItemOffer,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(offer).getDiscountType();
    verify(offer).getUseListForDiscounts();
    verify(offer).getValue();
    verify(orderItem).getRetailPrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetail8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    PromotableCandidateItemOffer promotableCandidateItemOffer = mock(PromotableCandidateItemOffer.class);
    when(promotableCandidateItemOffer.calculateTargetQuantityForTieredOffer()).thenReturn(1);
    when(promotableCandidateItemOffer.getOffer()).thenReturn(new OfferImpl());
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getRetailPrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl.computeRetailAdjustmentValue(promotableCandidateItemOffer,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(money).lessThan(isA(Money.class));
    verify(promotableCandidateItemOffer, atLeast(1)).calculateTargetQuantityForTieredOffer();
    verify(promotableCandidateItemOffer).getOffer();
    verify(orderItem).getRetailPrice();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetail9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    PromotableCandidateItemOffer promotableCandidateItemOffer = mock(PromotableCandidateItemOffer.class);
    when(promotableCandidateItemOffer.calculateTargetQuantityForTieredOffer()).thenReturn(1);
    when(promotableCandidateItemOffer.getOffer()).thenReturn(new OfferImpl());
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(currency);
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getRetailPrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    // Act
    promotableOfferUtilityImpl.computeRetailAdjustmentValue(promotableCandidateItemOffer,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(currency).getCurrencyCode();
    verify(money).lessThan(isA(Money.class));
    verify(promotableCandidateItemOffer, atLeast(1)).calculateTargetQuantityForTieredOffer();
    verify(promotableCandidateItemOffer).getOffer();
    verify(orderItem).getRetailPrice();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail},
   * {@code allowSalePrice}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetailAllowSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, new OfferImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());

    // Act
    Money actualComputeAdjustmentValueResult = promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(order, atLeast(1)).getOrderAdjustments();
    assertEquals(actualComputeAdjustmentValueResult.ZERO, actualComputeAdjustmentValueResult);
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail},
   * {@code allowSalePrice}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetailAllowSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, new OfferImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
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

    // Act
    promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(order, atLeast(1)).getOrderAdjustments();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail},
   * {@code allowSalePrice}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetailAllowSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, new OfferImpl());

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(new Money());
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(orderItem).getSalePrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail},
   * {@code allowSalePrice}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetailAllowSalePrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Offer offer = mock(Offer.class);
    when(offer.getUseListForDiscounts()).thenReturn(true);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    Money money = new Money();
    when(orderItem.getSalePrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    Money actualComputeAdjustmentValueResult = promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(offer).getDiscountType();
    verify(offer).getUseListForDiscounts();
    verify(offer).getValue();
    verify(orderItem).getSalePrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
    assertSame(money, actualComputeAdjustmentValueResult);
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail},
   * {@code allowSalePrice}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetailAllowSalePrice5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.setScale(anyInt(), anyInt())).thenReturn(new BigDecimal("2.3"));
    Offer offer = mock(Offer.class);
    when(offer.getUseListForDiscounts()).thenReturn(true);
    when(offer.getValue()).thenReturn(internalNumber);
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);
    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(new Money());
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    Money actualComputeAdjustmentValueResult = promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(internalNumber).setScale(eq(2), eq(6));
    verify(offer).getDiscountType();
    verify(offer).getUseListForDiscounts();
    verify(offer).getValue();
    verify(orderItem).getSalePrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
    BigDecimal expectedAmount = new BigDecimal("-2.30");
    assertEquals(expectedAmount, actualComputeAdjustmentValueResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.00");
    Money zeroResult = actualComputeAdjustmentValueResult.zero();
    BigDecimal amount = zeroResult.getAmount();
    assertEquals(expectedAmount2, amount);
    BigDecimal expectedAmount3 = new BigDecimal("2.30");
    Money absResult = actualComputeAdjustmentValueResult.abs();
    assertEquals(expectedAmount3, absResult.getAmount());
    assertEquals(absResult.abs(), absResult.abs());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = zeroResult2.zero();
    Money zeroResult4 = zeroResult3.zero();
    Money zeroResult5 = zeroResult4.zero();
    BigDecimal amount2 = zeroResult5.zero().getAmount();
    Money absResult2 = zeroResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(amount2, absResult6.abs().getAmount());
    Money zeroResult6 = absResult.zero();
    Money absResult7 = zeroResult6.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    assertSame(amount2, absResult10.abs().getAmount());
    assertSame(amount2, absResult6.getAmount());
    Money zeroResult7 = absResult2.zero();
    Money absResult11 = zeroResult7.abs();
    Money absResult12 = absResult11.abs();
    Money absResult13 = absResult12.abs();
    assertSame(amount2, absResult13.abs().getAmount());
    assertSame(amount2, absResult10.getAmount());
    Money zeroResult8 = zeroResult6.zero();
    Money absResult14 = zeroResult8.abs();
    Money absResult15 = absResult14.abs();
    Money absResult16 = absResult15.abs();
    assertSame(amount2, absResult16.abs().getAmount());
    assertSame(amount2, absResult5.getAmount());
    Money zeroResult9 = absResult3.zero();
    Money absResult17 = zeroResult9.abs();
    Money absResult18 = absResult17.abs();
    assertSame(amount2, absResult18.abs().getAmount());
    Money zeroResult10 = absResult7.zero();
    Money absResult19 = zeroResult10.abs();
    Money absResult20 = absResult19.abs();
    assertSame(amount2, absResult20.abs().getAmount());
    assertSame(amount2, absResult13.getAmount());
    assertSame(amount2, absResult9.getAmount());
    Money zeroResult11 = zeroResult7.zero();
    Money absResult21 = zeroResult11.abs();
    Money absResult22 = absResult21.abs();
    assertSame(amount2, absResult22.abs().getAmount());
    assertSame(amount2, absResult16.getAmount());
    Money zeroResult12 = zeroResult8.zero();
    Money absResult23 = zeroResult12.abs();
    Money absResult24 = absResult23.abs();
    assertSame(amount2, absResult24.abs().getAmount());
    assertSame(amount2, absResult4.getAmount());
    Money zeroResult13 = absResult4.zero();
    Money absResult25 = zeroResult13.abs();
    assertSame(amount2, absResult25.abs().getAmount());
    Money zeroResult14 = absResult8.zero();
    Money absResult26 = zeroResult14.abs();
    assertSame(amount2, absResult26.abs().getAmount());
    assertSame(amount2, absResult18.getAmount());
    Money zeroResult15 = absResult11.zero();
    Money absResult27 = zeroResult15.abs();
    assertSame(amount2, absResult27.abs().getAmount());
    assertSame(amount2, absResult20.getAmount());
    Money zeroResult16 = absResult14.zero();
    Money absResult28 = zeroResult16.abs();
    assertSame(amount2, absResult28.abs().getAmount());
    assertSame(amount2, absResult12.getAmount());
    assertSame(amount2, absResult8.getAmount());
    Money zeroResult17 = zeroResult9.zero();
    Money absResult29 = zeroResult17.abs();
    assertSame(amount2, absResult29.abs().getAmount());
    Money zeroResult18 = zeroResult10.zero();
    Money absResult30 = zeroResult18.abs();
    assertSame(amount2, absResult30.abs().getAmount());
    assertSame(amount2, absResult22.getAmount());
    assertSame(amount2, absResult15.getAmount());
    Money zeroResult19 = zeroResult11.zero();
    Money absResult31 = zeroResult19.abs();
    assertSame(amount2, absResult31.abs().getAmount());
    assertSame(amount2, absResult24.getAmount());
    Money zeroResult20 = zeroResult12.zero();
    Money absResult32 = zeroResult20.abs();
    assertSame(amount2, absResult32.abs().getAmount());
    assertSame(amount2, absResult3.getAmount());
    Money zeroResult21 = absResult5.zero();
    assertSame(amount2, zeroResult21.abs().getAmount());
    Money zeroResult22 = absResult9.zero();
    assertSame(amount2, zeroResult22.abs().getAmount());
    assertSame(amount2, absResult25.getAmount());
    Money zeroResult23 = absResult12.zero();
    assertSame(amount2, zeroResult23.abs().getAmount());
    assertSame(amount2, absResult26.getAmount());
    Money zeroResult24 = absResult15.zero();
    assertSame(amount2, zeroResult24.abs().getAmount());
    assertSame(amount2, absResult17.getAmount());
    Money zeroResult25 = absResult17.zero();
    assertSame(amount2, zeroResult25.abs().getAmount());
    Money zeroResult26 = absResult19.zero();
    assertSame(amount2, zeroResult26.abs().getAmount());
    assertSame(amount2, absResult27.getAmount());
    assertSame(amount2, absResult19.getAmount());
    Money zeroResult27 = absResult21.zero();
    assertSame(amount2, zeroResult27.abs().getAmount());
    assertSame(amount2, absResult28.getAmount());
    Money zeroResult28 = absResult23.zero();
    assertSame(amount2, zeroResult28.abs().getAmount());
    assertSame(amount2, absResult11.getAmount());
    assertSame(amount2, absResult7.getAmount());
    Money zeroResult29 = zeroResult13.zero();
    assertSame(amount2, zeroResult29.abs().getAmount());
    Money zeroResult30 = zeroResult14.zero();
    assertSame(amount2, zeroResult30.abs().getAmount());
    assertSame(amount2, absResult29.getAmount());
    Money zeroResult31 = zeroResult15.zero();
    assertSame(amount2, zeroResult31.abs().getAmount());
    assertSame(amount2, absResult30.getAmount());
    Money zeroResult32 = zeroResult16.zero();
    assertSame(amount2, zeroResult32.abs().getAmount());
    assertSame(amount2, absResult21.getAmount());
    assertSame(amount2, absResult14.getAmount());
    Money zeroResult33 = zeroResult17.zero();
    assertSame(amount2, zeroResult33.abs().getAmount());
    Money zeroResult34 = zeroResult18.zero();
    assertSame(amount2, zeroResult34.abs().getAmount());
    assertSame(amount2, absResult31.getAmount());
    assertSame(amount2, absResult23.getAmount());
    Money zeroResult35 = zeroResult19.zero();
    assertSame(amount2, zeroResult35.abs().getAmount());
    assertSame(amount2, absResult32.getAmount());
    Money zeroResult36 = zeroResult20.zero();
    assertSame(amount2, zeroResult36.abs().getAmount());
    assertSame(amount2, absResult2.getAmount());
    assertSame(amount2, absResult6.zero().getAmount());
    assertSame(amount2, absResult10.zero().getAmount());
    assertSame(amount2, zeroResult21.getAmount());
    assertSame(amount2, absResult13.zero().getAmount());
    assertSame(amount2, zeroResult22.getAmount());
    assertSame(amount2, absResult16.zero().getAmount());
    assertSame(amount2, zeroResult13.getAmount());
    assertSame(amount2, absResult18.zero().getAmount());
    assertSame(amount2, absResult20.zero().getAmount());
    assertSame(amount2, zeroResult23.getAmount());
    assertSame(amount2, zeroResult14.getAmount());
    assertSame(amount2, absResult22.zero().getAmount());
    assertSame(amount2, zeroResult24.getAmount());
    assertSame(amount2, absResult24.zero().getAmount());
    assertSame(amount2, zeroResult9.getAmount());
    assertSame(amount2, absResult25.zero().getAmount());
    assertSame(amount2, absResult26.zero().getAmount());
    assertSame(amount2, zeroResult25.getAmount());
    assertSame(amount2, absResult27.zero().getAmount());
    assertSame(amount2, zeroResult26.getAmount());
    assertSame(amount2, absResult28.zero().getAmount());
    assertSame(amount2, zeroResult15.getAmount());
    assertSame(amount2, zeroResult10.getAmount());
    assertSame(amount2, absResult29.zero().getAmount());
    assertSame(amount2, absResult30.zero().getAmount());
    assertSame(amount2, zeroResult27.getAmount());
    assertSame(amount2, zeroResult16.getAmount());
    assertSame(amount2, absResult31.zero().getAmount());
    assertSame(amount2, zeroResult28.getAmount());
    assertSame(amount2, absResult32.zero().getAmount());
    assertSame(amount2, zeroResult7.getAmount());
    assertSame(amount2, zeroResult6.getAmount());
    assertSame(amount2, zeroResult21.zero().getAmount());
    assertSame(amount2, zeroResult22.zero().getAmount());
    assertSame(amount2, zeroResult29.getAmount());
    assertSame(amount2, zeroResult23.zero().getAmount());
    assertSame(amount2, zeroResult30.getAmount());
    assertSame(amount2, zeroResult24.zero().getAmount());
    assertSame(amount2, zeroResult17.getAmount());
    assertSame(amount2, zeroResult25.zero().getAmount());
    assertSame(amount2, zeroResult26.zero().getAmount());
    assertSame(amount2, zeroResult31.getAmount());
    assertSame(amount2, zeroResult18.getAmount());
    assertSame(amount2, zeroResult27.zero().getAmount());
    assertSame(amount2, zeroResult32.getAmount());
    assertSame(amount2, zeroResult28.zero().getAmount());
    assertSame(amount2, zeroResult11.getAmount());
    assertSame(amount2, zeroResult8.getAmount());
    assertSame(amount2, zeroResult29.zero().getAmount());
    assertSame(amount2, zeroResult30.zero().getAmount());
    assertSame(amount2, zeroResult33.getAmount());
    assertSame(amount2, zeroResult31.zero().getAmount());
    assertSame(amount2, zeroResult34.getAmount());
    assertSame(amount2, zeroResult32.zero().getAmount());
    assertSame(amount2, zeroResult19.getAmount());
    assertSame(amount2, zeroResult12.getAmount());
    assertSame(amount2, zeroResult33.zero().getAmount());
    assertSame(amount2, zeroResult34.zero().getAmount());
    assertSame(amount2, zeroResult35.getAmount());
    assertSame(amount2, zeroResult20.getAmount());
    assertSame(amount2, zeroResult35.zero().getAmount());
    assertSame(amount2, zeroResult36.getAmount());
    assertSame(amount2, zeroResult36.zero().getAmount());
    assertSame(amount2, amount2);
    assertSame(zeroResult5.getAmount(), zeroResult5.getAmount());
    BigDecimal amount3 = zeroResult4.getAmount();
    assertSame(amount3, zeroResult5.abs().getAmount());
    assertSame(amount3, amount3);
    BigDecimal amount4 = zeroResult3.getAmount();
    Money absResult33 = zeroResult4.abs();
    Money absResult34 = absResult33.abs();
    assertSame(amount4, absResult34.abs().getAmount());
    assertSame(amount4, absResult34.getAmount());
    assertSame(amount4, absResult33.getAmount());
    assertSame(amount4, absResult34.zero().getAmount());
    assertSame(amount4, absResult33.zero().getAmount());
    assertSame(amount4, amount4);
    BigDecimal amount5 = zeroResult2.getAmount();
    Money absResult35 = zeroResult3.abs();
    Money absResult36 = absResult35.abs();
    Money absResult37 = absResult36.abs();
    assertSame(amount5, absResult37.abs().getAmount());
    assertSame(amount5, absResult37.getAmount());
    Money zeroResult37 = absResult35.zero();
    Money absResult38 = zeroResult37.abs();
    assertSame(amount5, absResult38.abs().getAmount());
    assertSame(amount5, absResult36.getAmount());
    Money zeroResult38 = absResult36.zero();
    assertSame(amount5, zeroResult38.abs().getAmount());
    assertSame(amount5, absResult38.getAmount());
    Money zeroResult39 = zeroResult37.zero();
    assertSame(amount5, zeroResult39.abs().getAmount());
    assertSame(amount5, absResult35.getAmount());
    assertSame(amount5, absResult37.zero().getAmount());
    assertSame(amount5, zeroResult38.getAmount());
    assertSame(amount5, absResult38.zero().getAmount());
    assertSame(amount5, zeroResult37.getAmount());
    assertSame(amount5, zeroResult38.zero().getAmount());
    assertSame(amount5, zeroResult39.getAmount());
    assertSame(amount5, zeroResult39.zero().getAmount());
    assertSame(amount5, amount5);
    Money absResult39 = zeroResult2.abs();
    Money absResult40 = absResult39.abs();
    Money absResult41 = absResult40.abs();
    Money absResult42 = absResult41.abs();
    assertSame(amount, absResult42.abs().getAmount());
    assertSame(amount, absResult42.getAmount());
    Money zeroResult40 = absResult39.zero();
    Money absResult43 = zeroResult40.abs();
    Money absResult44 = absResult43.abs();
    assertSame(amount, absResult44.abs().getAmount());
    assertSame(amount, absResult41.getAmount());
    Money zeroResult41 = absResult40.zero();
    Money absResult45 = zeroResult41.abs();
    assertSame(amount, absResult45.abs().getAmount());
    assertSame(amount, absResult44.getAmount());
    Money zeroResult42 = zeroResult40.zero();
    Money absResult46 = zeroResult42.abs();
    assertSame(amount, absResult46.abs().getAmount());
    assertSame(amount, absResult40.getAmount());
    Money zeroResult43 = absResult41.zero();
    assertSame(amount, zeroResult43.abs().getAmount());
    assertSame(amount, absResult45.getAmount());
    Money zeroResult44 = absResult43.zero();
    assertSame(amount, zeroResult44.abs().getAmount());
    assertSame(amount, absResult43.getAmount());
    Money zeroResult45 = zeroResult41.zero();
    assertSame(amount, zeroResult45.abs().getAmount());
    assertSame(amount, absResult46.getAmount());
    Money zeroResult46 = zeroResult42.zero();
    assertSame(amount, zeroResult46.abs().getAmount());
    assertSame(amount, absResult39.getAmount());
    assertSame(amount, absResult42.zero().getAmount());
    assertSame(amount, zeroResult43.getAmount());
    assertSame(amount, absResult44.zero().getAmount());
    assertSame(amount, zeroResult41.getAmount());
    assertSame(amount, absResult45.zero().getAmount());
    assertSame(amount, zeroResult44.getAmount());
    assertSame(amount, absResult46.zero().getAmount());
    assertSame(amount, zeroResult40.getAmount());
    assertSame(amount, zeroResult43.zero().getAmount());
    assertSame(amount, zeroResult45.getAmount());
    assertSame(amount, zeroResult44.zero().getAmount());
    assertSame(amount, zeroResult42.getAmount());
    assertSame(amount, zeroResult45.zero().getAmount());
    assertSame(amount, zeroResult46.getAmount());
    assertSame(amount, zeroResult46.zero().getAmount());
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail},
   * {@code allowSalePrice}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetailAllowSalePrice6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    Offer offer = mock(Offer.class);
    when(offer.getUseListForDiscounts()).thenReturn(true);
    when(offer.getValue()).thenReturn(internalNumber);
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(new Money());
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(offer).getDiscountType();
    verify(offer).getUseListForDiscounts();
    verify(offer).getValue();
    verify(orderItem).getSalePrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail},
   * {@code allowSalePrice}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetailAllowSalePrice7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Offer offer = mock(Offer.class);
    when(offer.getUseListForDiscounts()).thenReturn(true);
    when(offer.getValue()).thenReturn(mock(InternalNumber.class));
    when(offer.getDiscountType()).thenReturn(null);
    PromotableCandidateItemOfferImpl promotableCandidateItemOffer = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(new Money());
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(offer).getDiscountType();
    verify(offer).getUseListForDiscounts();
    verify(offer).getValue();
    verify(orderItem).getSalePrice();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail},
   * {@code allowSalePrice}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetailAllowSalePrice8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    PromotableCandidateItemOffer promotableCandidateItemOffer = mock(PromotableCandidateItemOffer.class);
    when(promotableCandidateItemOffer.calculateTargetQuantityForTieredOffer()).thenReturn(1);
    when(promotableCandidateItemOffer.getOffer()).thenReturn(new OfferImpl());
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(money).lessThan(isA(Money.class));
    verify(promotableCandidateItemOffer, atLeast(1)).calculateTargetQuantityForTieredOffer();
    verify(promotableCandidateItemOffer).getOffer();
    verify(orderItem).getSalePrice();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   * with {@code promotableCandidateItemOffer}, {@code orderItemPriceDetail},
   * {@code allowSalePrice}.
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValueWithPromotableCandidateItemOfferOrderItemPriceDetailAllowSalePrice9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    PromotableCandidateItemOffer promotableCandidateItemOffer = mock(PromotableCandidateItemOffer.class);
    when(promotableCandidateItemOffer.calculateTargetQuantityForTieredOffer()).thenReturn(1);
    when(promotableCandidateItemOffer.getOffer()).thenReturn(new OfferImpl());
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(currency);
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("currency.default");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    // Act
    promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(currency).getCurrencyCode();
    verify(money).lessThan(isA(Money.class));
    verify(promotableCandidateItemOffer, atLeast(1)).calculateTargetQuantityForTieredOffer();
    verify(promotableCandidateItemOffer).getOffer();
    verify(orderItem).getSalePrice();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#determineOfferUnitValue(Offer, Integer)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#determineOfferUnitValue(Offer, Integer)}
   */
  @Test
  public void testDetermineOfferUnitValue_givenBigDecimalWith23_thenReturnBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    Offer offer = mock(Offer.class);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    BigDecimal actualDetermineOfferUnitValueResult = promotableOfferUtilityImpl.determineOfferUnitValue(offer, 1);

    // Assert
    verify(offer).getValue();
    assertEquals(new BigDecimal("2.3"), actualDetermineOfferUnitValueResult);
  }

  /**
   * Test
   * {@link PromotableOfferUtilityImpl#determineOfferUnitValue(Offer, Integer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOfferUtilityImpl#determineOfferUnitValue(Offer, Integer)}
   */
  @Test
  public void testDetermineOfferUnitValue_whenOfferImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();

    // Act and Assert
    assertNull(promotableOfferUtilityImpl.determineOfferUnitValue(new OfferImpl(), 1));
  }
}
