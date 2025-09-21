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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.domain.Adjustment;
import org.broadleafcommerce.core.offer.domain.CandidateOrderOffer;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferInfo;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderAdjustmentImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
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
public class OrderImplDiffblueTest {
  @Autowired private OrderImpl orderImpl;

  /**
   * Test {@link OrderImpl#getSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getSubTotal()"})
  public void testGetSubTotal_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Money subTotal = new Money();
    orderImpl.setSubTotal(subTotal);
    orderImpl.setCurrency(null);

    // Act and Assert
    assertEquals(subTotal, orderImpl.getSubTotal());
  }

  /**
   * Test {@link OrderImpl#getSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getSubTotal()"})
  public void testGetSubTotal_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderImpl.getSubTotal());
  }

  /**
   * Test {@link OrderImpl#getSubTotal()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getSubTotal()"})
  public void testGetSubTotal_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");
    orderImpl.setSubTotal(new Money());
    orderImpl.setCurrency(currency);

    // Act
    Money actualSubTotal = orderImpl.getSubTotal();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualSubTotal.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualSubTotal.abs();
    assertEquals(actualSubTotal, actualAbsResult);
    Money actualZeroResult = actualSubTotal.zero();
    assertEquals(actualSubTotal, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#setSubTotal(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link OrderImpl} {@link OrderImpl#subTotal} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setSubTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setSubTotal(Money)"})
  public void testSetSubTotal_whenMoney_thenOrderImplSubTotalIsBigDecimalWith000() {
    // Arrange
    Money subTotal = new Money();

    // Act
    orderImpl.setSubTotal(subTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl.subTotal);
    BigDecimal bigDecimal = orderImpl.subTotal;
    Money absResult = subTotal.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = subTotal.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link OrderImpl#setSubTotal(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OrderImpl} {@link OrderImpl#subTotal} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setSubTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setSubTotal(Money)"})
  public void testSetSubTotal_whenNull_thenOrderImplSubTotalIsNull() {
    // Arrange and Act
    orderImpl.setSubTotal(null);

    // Assert that nothing has changed
    assertNull(orderImpl.subTotal);
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act and Assert
    assertEquals(Money.ZERO, orderImpl.calculateSubTotal());
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.calculateSubTotal());
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("currency.default");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualCalculateSubTotalResult = orderImpl.calculateSubTotal();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualCalculateSubTotalResult.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualCalculateSubTotalResult.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getTotalPrice()).thenReturn(money);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualCalculateSubTotalResult = orderImpl.calculateSubTotal();

    // Assert
    verify(orderItem).getTotalPrice();
    assertEquals(money, actualCalculateSubTotalResult);
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(null);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditItemAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getItemAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getTotalAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getTotalFutureCreditAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_givenOrderItemImplOrderIsNull_order() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert that nothing has changed
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link OrderImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_givenOrderItemImplOrderIsOrderImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new OrderImpl());
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert that nothing has changed
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#assignFinalPrice()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_thenCallsAssignFinalPrice() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).assignFinalPrice();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert
    verify(bundleOrderItemImpl).assignFinalPrice();
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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
    orderItemImpl.setOrder(order);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert that nothing has changed
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#getTotal()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotal()"})
  public void testGetTotal_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Money orderTotal = new Money();
    orderImpl.setTotal(orderTotal);
    orderImpl.setCurrency(null);

    // Act and Assert
    assertEquals(orderTotal, orderImpl.getTotal());
  }

  /**
   * Test {@link OrderImpl#getTotal()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotal()"})
  public void testGetTotal_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderImpl.getTotal());
  }

  /**
   * Test {@link OrderImpl#getTotal()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotal()"})
  public void testGetTotal_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");
    orderImpl.setTotal(new Money());
    orderImpl.setCurrency(currency);

    // Act
    Money actualTotal = orderImpl.getTotal();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotal.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotal.abs();
    assertEquals(actualTotal, actualAbsResult);
    Money actualZeroResult = actualTotal.zero();
    assertEquals(actualTotal, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#getTotalAfterAppliedPayments()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalAfterAppliedPayments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalAfterAppliedPayments()"})
  public void testGetTotalAfterAppliedPayments_givenArrayListAddOrderPaymentImpl() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(new OrderPaymentImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setPayments(payments);
    orderImpl.setCurrency(currency);
    orderImpl.setTotal(new Money());

    // Act
    Money actualTotalAfterAppliedPayments = orderImpl.getTotalAfterAppliedPayments();

    // Assert
    verify(currency, atLeast(1)).getCurrencyCode();
    Currency currency2 = actualTotalAfterAppliedPayments.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalAfterAppliedPayments.abs();
    assertEquals(actualTotalAfterAppliedPayments, actualAbsResult);
    Money actualZeroResult = actualTotalAfterAppliedPayments.zero();
    assertEquals(actualTotalAfterAppliedPayments, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#getTotalAfterAppliedPayments()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Total is {@link Money#Money()}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalAfterAppliedPayments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalAfterAppliedPayments()"})
  public void testGetTotalAfterAppliedPayments_givenOrderImplTotalIsMoney_thenReturnMoney() {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    Money orderTotal = new Money();
    orderImpl.setTotal(orderTotal);

    // Act and Assert
    assertEquals(orderTotal, orderImpl.getTotalAfterAppliedPayments());
  }

  /**
   * Test {@link OrderImpl#getTotalAfterAppliedPayments()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalAfterAppliedPayments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalAfterAppliedPayments()"})
  public void testGetTotalAfterAppliedPayments_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderImpl.getTotalAfterAppliedPayments());
  }

  /**
   * Test {@link OrderImpl#getTotalAfterAppliedPayments()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalAfterAppliedPayments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalAfterAppliedPayments()"})
  public void testGetTotalAfterAppliedPayments_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setCurrency(currency);
    orderImpl.setTotal(new Money());

    // Act
    Money actualTotalAfterAppliedPayments = orderImpl.getTotalAfterAppliedPayments();

    // Assert
    verify(currency, atLeast(1)).getCurrencyCode();
    Currency currency2 = actualTotalAfterAppliedPayments.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalAfterAppliedPayments.abs();
    assertEquals(actualTotalAfterAppliedPayments, actualAbsResult);
    Money actualZeroResult = actualTotalAfterAppliedPayments.zero();
    assertEquals(actualTotalAfterAppliedPayments, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#getTotalAfterAppliedPayments()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalAfterAppliedPayments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalAfterAppliedPayments()"})
  public void testGetTotalAfterAppliedPayments_thenThrowUnsupportedOperationException() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(false);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(orderPaymentImpl);
    payments.add(mock(OrderPaymentImpl.class));

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setPayments(payments);
    orderImpl.setCurrency(currency);
    orderImpl.setTotal(new Money());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> orderImpl.getTotalAfterAppliedPayments());
    verify(currency, atLeast(1)).getCurrencyCode();
    verify(orderPaymentImpl, atLeast(1)).getAmount();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentImpl).isFinalPayment();
  }

  /**
   * Test {@link OrderImpl#setTotal(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link OrderImpl} {@link OrderImpl#total} is {@link BigDecimal#BigDecimal(String)}
   *       with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setTotal(Money)"})
  public void testSetTotal_whenMoney_thenOrderImplTotalIsBigDecimalWith000() {
    // Arrange
    Money orderTotal = new Money();

    // Act
    orderImpl.setTotal(orderTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl.total);
    BigDecimal bigDecimal = orderImpl.total;
    Money absResult = orderTotal.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = orderTotal.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link OrderImpl#setTotal(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OrderImpl} {@link OrderImpl#total} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setTotal(Money)"})
  public void testSetTotal_whenNull_thenOrderImplTotalIsNull() {
    // Arrange and Act
    orderImpl.setTotal(null);

    // Assert that nothing has changed
    assertNull(orderImpl.total);
  }

  /**
   * Test {@link OrderImpl#getPreview()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} Preview is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getPreview()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderImpl.getPreview()"})
  public void testGetPreview_givenOrderImplPreviewIsFalse_thenReturnFalse() {
    // Arrange
    orderImpl.setPreview(false);

    // Act and Assert
    assertFalse(orderImpl.getPreview());
  }

  /**
   * Test {@link OrderImpl#getPreview()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} Preview is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getPreview()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderImpl.getPreview()"})
  public void testGetPreview_givenOrderImplPreviewIsTrue_thenReturnTrue() {
    // Arrange
    orderImpl.setPreview(true);

    // Act and Assert
    assertTrue(orderImpl.getPreview());
  }

  /**
   * Test {@link OrderImpl#getPreview()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getPreview()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderImpl.getPreview()"})
  public void testGetPreview_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderImpl.getPreview());
  }

  /**
   * Test {@link OrderImpl#setPreview(Boolean)}.
   *
   * <p>Method under test: {@link OrderImpl#setPreview(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setPreview(Boolean)"})
  public void testSetPreview() {
    // Arrange and Act
    orderImpl.setPreview(true);

    // Assert
    assertTrue(orderImpl.previewable.getPreview());
    assertTrue(orderImpl.getPreview());
  }

  /**
   * Test {@link OrderImpl#getStatus()}.
   *
   * <p>Method under test: {@link OrderImpl#getStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderStatus OrderImpl.getStatus()"})
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertNull(orderImpl.getStatus());
  }

  /**
   * Test {@link OrderImpl#setStatus(OrderStatus)}.
   *
   * <ul>
   *   <li>When {@link OrderStatus#ARCHIVED}.
   *   <li>Then {@link OrderImpl} {@link OrderImpl#status} is {@code ARCHIVED}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setStatus(OrderStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setStatus(OrderStatus)"})
  public void testSetStatus_whenArchived_thenOrderImplStatusIsArchived() {
    // Arrange and Act
    orderImpl.setStatus(OrderStatus.ARCHIVED);

    // Assert
    assertEquals("ARCHIVED", orderImpl.status);
    assertSame(OrderStatus.ARCHIVED, orderImpl.getStatus());
  }

  /**
   * Test {@link OrderImpl#addOrderItem(OrderItem)}.
   *
   * <p>Method under test: {@link OrderImpl#addOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.addOrderItem(OrderItem)"})
  public void testAddOrderItem() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    orderImpl.addOrderItem(orderItem);

    // Assert
    List<OrderItem> orderItems = orderImpl.getOrderItems();
    assertEquals(1, orderItems.size());
    assertSame(orderItem, orderItems.get(0));
  }

  /**
   * Test {@link OrderImpl#getTotalTax()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalTax()"})
  public void testGetTotalTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Money totalTax = new Money();
    orderImpl.setTotalTax(totalTax);
    orderImpl.setCurrency(null);

    // Act and Assert
    assertEquals(totalTax, orderImpl.getTotalTax());
  }

  /**
   * Test {@link OrderImpl#getTotalTax()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalTax()"})
  public void testGetTotalTax_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderImpl.getTotalTax());
  }

  /**
   * Test {@link OrderImpl#getTotalTax()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalTax()"})
  public void testGetTotalTax_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(currency);

    // Act
    Money actualTotalTax = orderImpl.getTotalTax();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotalTax.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalTax.abs();
    assertEquals(actualTotalTax, actualAbsResult);
    Money actualZeroResult = actualTotalTax.zero();
    assertEquals(actualTotalTax, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#setTotalTax(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link OrderImpl} {@link OrderImpl#totalTax} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setTotalTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setTotalTax(Money)"})
  public void testSetTotalTax_whenMoney_thenOrderImplTotalTaxIsBigDecimalWith000() {
    // Arrange
    Money totalTax = new Money();

    // Act
    orderImpl.setTotalTax(totalTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl.totalTax);
    BigDecimal bigDecimal = orderImpl.totalTax;
    Money absResult = totalTax.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = totalTax.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link OrderImpl#setTotalTax(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OrderImpl} {@link OrderImpl#totalTax} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setTotalTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setTotalTax(Money)"})
  public void testSetTotalTax_whenNull_thenOrderImplTotalTaxIsNull() {
    // Arrange and Act
    orderImpl.setTotalTax(null);

    // Assert that nothing has changed
    assertNull(orderImpl.totalTax);
  }

  /**
   * Test {@link OrderImpl#getTotalShipping()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalShipping()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalShipping()"})
  public void testGetTotalShipping_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Money totalFulfillmentCharges = new Money();
    orderImpl.setTotalFulfillmentCharges(totalFulfillmentCharges);
    orderImpl.setCurrency(null);

    // Act and Assert
    assertEquals(totalFulfillmentCharges, orderImpl.getTotalShipping());
  }

  /**
   * Test {@link OrderImpl#getTotalShipping()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalShipping()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalShipping()"})
  public void testGetTotalShipping_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderImpl.getTotalShipping());
  }

  /**
   * Test {@link OrderImpl#getTotalShipping()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalShipping()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalShipping()"})
  public void testGetTotalShipping_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setCurrency(currency);

    // Act
    Money actualTotalShipping = orderImpl.getTotalShipping();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotalShipping.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalShipping.abs();
    assertEquals(actualTotalShipping, actualAbsResult);
    Money actualZeroResult = actualTotalShipping.zero();
    assertEquals(actualTotalShipping, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#setTotalShipping(Money)}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} {@link OrderImpl#totalFulfillmentCharges} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setTotalShipping(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setTotalShipping(Money)"})
  public void testSetTotalShipping_thenOrderImplTotalFulfillmentChargesIsBigDecimalWith000() {
    // Arrange
    Money totalShipping = new Money();

    // Act
    orderImpl.setTotalShipping(totalShipping);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl.totalFulfillmentCharges);
    BigDecimal bigDecimal = orderImpl.totalFulfillmentCharges;
    Money absResult = totalShipping.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = totalShipping.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link OrderImpl#setTotalShipping(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OrderImpl} {@link OrderImpl#totalFulfillmentCharges} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setTotalShipping(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setTotalShipping(Money)"})
  public void testSetTotalShipping_whenNull_thenOrderImplTotalFulfillmentChargesIsNull() {
    // Arrange and Act
    orderImpl.setTotalShipping(null);

    // Assert that nothing has changed
    assertNull(orderImpl.totalFulfillmentCharges);
  }

  /**
   * Test {@link OrderImpl#getTotalFulfillmentCharges()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalFulfillmentCharges()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalFulfillmentCharges()"})
  public void testGetTotalFulfillmentCharges_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Money totalFulfillmentCharges = new Money();
    orderImpl.setTotalFulfillmentCharges(totalFulfillmentCharges);
    orderImpl.setCurrency(null);

    // Act and Assert
    assertEquals(totalFulfillmentCharges, orderImpl.getTotalFulfillmentCharges());
  }

  /**
   * Test {@link OrderImpl#getTotalFulfillmentCharges()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalFulfillmentCharges()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalFulfillmentCharges()"})
  public void testGetTotalFulfillmentCharges_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderImpl.getTotalFulfillmentCharges());
  }

  /**
   * Test {@link OrderImpl#getTotalFulfillmentCharges()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalFulfillmentCharges()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalFulfillmentCharges()"})
  public void testGetTotalFulfillmentCharges_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setCurrency(currency);

    // Act
    Money actualTotalFulfillmentCharges = orderImpl.getTotalFulfillmentCharges();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotalFulfillmentCharges.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalFulfillmentCharges.abs();
    assertEquals(actualTotalFulfillmentCharges, actualAbsResult);
    Money actualZeroResult = actualTotalFulfillmentCharges.zero();
    assertEquals(actualTotalFulfillmentCharges, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#setTotalFulfillmentCharges(Money)}.
   *
   * <p>Method under test: {@link OrderImpl#setTotalFulfillmentCharges(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setTotalFulfillmentCharges(Money)"})
  public void testSetTotalFulfillmentCharges() {
    // Arrange
    Money totalFulfillmentCharges = new Money();

    // Act
    orderImpl.setTotalFulfillmentCharges(totalFulfillmentCharges);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl.totalFulfillmentCharges);
    BigDecimal bigDecimal = orderImpl.totalFulfillmentCharges;
    Money absResult = totalFulfillmentCharges.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = totalFulfillmentCharges.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link OrderImpl#setTotalFulfillmentCharges(Money)}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} {@link OrderImpl#totalFulfillmentCharges} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#setTotalFulfillmentCharges(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.setTotalFulfillmentCharges(Money)"})
  public void testSetTotalFulfillmentCharges_thenOrderImplTotalFulfillmentChargesIsNull() {
    // Arrange and Act
    orderImpl.setTotalFulfillmentCharges(null);

    // Assert that nothing has changed
    assertNull(orderImpl.totalFulfillmentCharges);
  }

  /**
   * Test {@link OrderImpl#hasCategoryItem(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#hasCategoryItem(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.hasCategoryItem(String)"})
  public void testHasCategoryItem_givenArrayListAddBundleOrderItemImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl.hasCategoryItem("Category Name"));
  }

  /**
   * Test {@link OrderImpl#hasCategoryItem(String)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#hasCategoryItem(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.hasCategoryItem(String)"})
  public void testHasCategoryItem_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderImpl.hasCategoryItem("Category Name"));
  }

  /**
   * Test {@link OrderImpl#hasCategoryItem(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#hasCategoryItem(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.hasCategoryItem(String)"})
  public void testHasCategoryItem_thenReturnTrue() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isInCategory(Mockito.<String>any())).thenReturn(true);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualHasCategoryItemResult = orderImpl.hasCategoryItem("Category Name");

    // Assert
    verify(bundleOrderItemImpl).isInCategory("Category Name");
    assertTrue(actualHasCategoryItemResult);
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderAdjustmentImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditOrderAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getFutureCreditOrderAdjustments()"})
  public void testGetFutureCreditOrderAdjustments_givenArrayListAddOrderAdjustmentImpl() {
    // Arrange
    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(new OrderAdjustmentImpl());
    orderImpl.setOrderAdjustments(orderAdjustments);

    // Act and Assert
    assertTrue(orderImpl.getFutureCreditOrderAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditOrderAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getFutureCreditOrderAdjustments()"})
  public void testGetFutureCreditOrderAdjustments_givenOrderImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(orderImpl.getFutureCreditOrderAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustments()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditOrderAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getFutureCreditOrderAdjustments()"})
  public void testGetFutureCreditOrderAdjustments_thenReturnSizeIsOne() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = mock(OrderAdjustmentImpl.class);
    when(orderAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(orderAdjustmentImpl);
    orderImpl.setOrderAdjustments(orderAdjustments);

    // Act
    List<OrderAdjustment> actualFutureCreditOrderAdjustments =
        orderImpl.getFutureCreditOrderAdjustments();

    // Assert
    verify(orderAdjustmentImpl).isFutureCredit();
    assertEquals(1, actualFutureCreditOrderAdjustments.size());
  }

  /**
   * Test {@link OrderImpl#getAllFutureCreditAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getAllFutureCreditAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getAllFutureCreditAdjustments()"})
  public void testGetAllFutureCreditAdjustments_givenOrderImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(orderImpl.getAllFutureCreditAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getAllFutureCreditAdjustments()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getAllFutureCreditAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getAllFutureCreditAdjustments()"})
  public void testGetAllFutureCreditAdjustments_thenReturnEmpty() {
    // Arrange
    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(new OrderItemPriceDetailImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(new OrderAdjustmentImpl());
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);
    orderImpl.setOrderAdjustments(orderAdjustments);

    // Act and Assert
    assertTrue(orderImpl.getAllFutureCreditAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getAllFutureCreditAdjustments()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getAllFutureCreditAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getAllFutureCreditAdjustments()"})
  public void testGetAllFutureCreditAdjustments_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(new OrderItemPriceDetailImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderAdjustmentImpl orderAdjustmentImpl = mock(OrderAdjustmentImpl.class);
    when(orderAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(orderAdjustmentImpl);
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);
    orderImpl.setOrderAdjustments(orderAdjustments);

    // Act
    List<Adjustment> actualAllFutureCreditAdjustments = orderImpl.getAllFutureCreditAdjustments();

    // Assert
    verify(orderAdjustmentImpl).isFutureCredit();
    assertEquals(1, actualAllFutureCreditAdjustments.size());
  }

  /**
   * Test {@link OrderImpl#getDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_givenOrderImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(orderImpl.getDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_givenOrderItemImplAuditableIsAuditable_thenReturnEmpty() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act and Assert
    assertTrue(orderImpl.getDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_thenReturnArrayList() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(discreteOrderItems, orderImpl.getDiscreteOrderItems());
  }

  /**
   * Test {@link OrderImpl#getDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_thenReturnSizeIsOne() {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    DiscreteOrderItemImpl orderItem = new DiscreteOrderItemImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    List<DiscreteOrderItem> actualDiscreteOrderItems = orderImpl.getDiscreteOrderItems();

    // Assert
    assertEquals(1, actualDiscreteOrderItems.size());
    DiscreteOrderItem getResult = actualDiscreteOrderItems.get(0);
    assertTrue(getResult instanceof DiscreteOrderItemImpl);
    assertSame(orderItem, getResult);
  }

  /**
   * Test {@link OrderImpl#getNonDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getNonDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getNonDiscreteOrderItems()"})
  public void testGetNonDiscreteOrderItems_givenArrayListAddBundleOrderItemImpl() {
    // Arrange
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertTrue(orderImpl.getNonDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getNonDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getNonDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getNonDiscreteOrderItems()"})
  public void testGetNonDiscreteOrderItems_givenOrderImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(orderImpl.getNonDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getNonDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getNonDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getNonDiscreteOrderItems()"})
  public void testGetNonDiscreteOrderItems_thenReturnArrayList() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(orderItems, orderImpl.getNonDiscreteOrderItems());
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenArrayListAddBundleOrderItemImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl.containsSku(new SkuImpl()));
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenArrayListAddDiscreteOrderItemImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl.containsSku(new SkuImpl()));
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       OrderItemQualifierImpl#serialVersionUID}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenAuditableCreatedByIsSerialVersionUID_thenReturnFalse() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl.containsSku(new SkuImpl()));
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link
   *       SkuImpl}.
   *   <li>Then calls {@link BundleOrderItemImpl#getSku()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenBundleOrderItemImplGetSkuReturnSkuImpl_thenCallsGetSku() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(mock(SkuImpl.class));

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualContainsSkuResult = orderImpl.containsSku(new SkuImpl());

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
    assertFalse(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link
   *       SkuImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenBundleOrderItemImplGetSkuReturnSkuImpl_thenReturnTrue() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualContainsSkuResult = orderImpl.containsSku(new SkuImpl());

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
    assertTrue(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getSku()} return {@link
   *       SkuImpl}.
   *   <li>Then calls {@link DiscreteOrderItemImpl#getSku()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenDiscreteOrderItemImplGetSkuReturnSkuImpl_thenCallsGetSku() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSku()).thenReturn(mock(SkuImpl.class));

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(discreteOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualContainsSkuResult = orderImpl.containsSku(new SkuImpl());

    // Assert
    verify(discreteOrderItemImpl, atLeast(1)).getSku();
    assertFalse(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getSku()} return {@link
   *       SkuImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenDiscreteOrderItemImplGetSkuReturnSkuImpl_thenReturnTrue() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(discreteOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualContainsSkuResult = orderImpl.containsSku(new SkuImpl());

    // Assert
    verify(discreteOrderItemImpl, atLeast(1)).getSku();
    assertTrue(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderImpl.containsSku(new SkuImpl()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#setAdditionalOfferInformation(Map)}
   *   <li>{@link OrderImpl#setAuditable(Auditable)}
   *   <li>{@link OrderImpl#setCandidateOrderOffers(List)}
   *   <li>{@link OrderImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link OrderImpl#setCustomer(Customer)}
   *   <li>{@link OrderImpl#setEmailAddress(String)}
   *   <li>{@link OrderImpl#setFulfillmentGroups(List)}
   *   <li>{@link OrderImpl#setId(Long)}
   *   <li>{@link OrderImpl#setLocale(Locale)}
   *   <li>{@link OrderImpl#setName(String)}
   *   <li>{@link OrderImpl#setOrderAdjustments(List)}
   *   <li>{@link OrderImpl#setOrderAttributes(Map)}
   *   <li>{@link OrderImpl#setOrderItems(List)}
   *   <li>{@link OrderImpl#setOrderMessages(List)}
   *   <li>{@link OrderImpl#setOrderNumber(String)}
   *   <li>{@link OrderImpl#setPayments(List)}
   *   <li>{@link OrderImpl#setSubmitDate(Date)}
   *   <li>{@link OrderImpl#setTaxOverride(Boolean)}
   *   <li>{@link OrderImpl#getAddedOfferCodes()}
   *   <li>{@link OrderImpl#getAdditionalOfferInformation()}
   *   <li>{@link OrderImpl#getAuditable()}
   *   <li>{@link OrderImpl#getBroadleafAccountId()}
   *   <li>{@link OrderImpl#getCandidateOrderOffers()}
   *   <li>{@link OrderImpl#getCurrency()}
   *   <li>{@link OrderImpl#getCustomer()}
   *   <li>{@link OrderImpl#getEmailAddress()}
   *   <li>{@link OrderImpl#getFulfillmentGroups()}
   *   <li>{@link OrderImpl#getFulfillmentStatus()}
   *   <li>{@link OrderImpl#getId()}
   *   <li>{@link OrderImpl#getLocale()}
   *   <li>{@link OrderImpl#getName()}
   *   <li>{@link OrderImpl#getOrderAdjustments()}
   *   <li>{@link OrderImpl#getOrderAttributes()}
   *   <li>{@link OrderImpl#getOrderItems()}
   *   <li>{@link OrderImpl#getOrderNumber()}
   *   <li>{@link OrderImpl#getPayments()}
   *   <li>{@link OrderImpl#getSubmitDate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderImpl.getAddedOfferCodes()",
    "Map OrderImpl.getAdditionalOfferInformation()",
    "Auditable OrderImpl.getAuditable()",
    "Long OrderImpl.getBroadleafAccountId()",
    "List OrderImpl.getCandidateOrderOffers()",
    "BroadleafCurrency OrderImpl.getCurrency()",
    "Customer OrderImpl.getCustomer()",
    "String OrderImpl.getEmailAddress()",
    "List OrderImpl.getFulfillmentGroups()",
    "String OrderImpl.getFulfillmentStatus()",
    "Long OrderImpl.getId()",
    "Locale OrderImpl.getLocale()",
    "String OrderImpl.getName()",
    "List OrderImpl.getOrderAdjustments()",
    "Map OrderImpl.getOrderAttributes()",
    "List OrderImpl.getOrderItems()",
    "String OrderImpl.getOrderNumber()",
    "List OrderImpl.getPayments()",
    "Date OrderImpl.getSubmitDate()",
    "void OrderImpl.setAdditionalOfferInformation(Map)",
    "void OrderImpl.setAuditable(Auditable)",
    "void OrderImpl.setCandidateOrderOffers(List)",
    "void OrderImpl.setCurrency(BroadleafCurrency)",
    "void OrderImpl.setCustomer(Customer)",
    "void OrderImpl.setEmailAddress(String)",
    "void OrderImpl.setFulfillmentGroups(List)",
    "void OrderImpl.setId(Long)",
    "void OrderImpl.setLocale(Locale)",
    "void OrderImpl.setName(String)",
    "void OrderImpl.setOrderAdjustments(List)",
    "void OrderImpl.setOrderAttributes(Map)",
    "void OrderImpl.setOrderItems(List)",
    "void OrderImpl.setOrderMessages(List)",
    "void OrderImpl.setOrderNumber(String)",
    "void OrderImpl.setPayments(List)",
    "void OrderImpl.setSubmitDate(Date)",
    "void OrderImpl.setTaxOverride(Boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    HashMap<Offer, OfferInfo> additionalOfferInformation = new HashMap<>();

    // Act
    orderImpl.setAdditionalOfferInformation(additionalOfferInformation);
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setAuditable(auditable);
    ArrayList<CandidateOrderOffer> candidateOrderOffers = new ArrayList<>();
    orderImpl.setCandidateOrderOffers(candidateOrderOffers);
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    orderImpl.setCurrency(currency);
    CustomerImpl customer = new CustomerImpl();
    orderImpl.setCustomer(customer);
    orderImpl.setEmailAddress("42 Main St");
    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    LocaleImpl locale = new LocaleImpl();
    orderImpl.setLocale(locale);
    orderImpl.setName("Name");
    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderImpl.setOrderAdjustments(orderAdjustments);
    HashMap<String, OrderAttribute> orderAttributes = new HashMap<>();
    orderImpl.setOrderAttributes(orderAttributes);
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderImpl.setOrderItems(orderItems);
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    ArrayList<OrderPayment> payments = new ArrayList<>();
    orderImpl.setPayments(payments);
    Date submitDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    orderImpl.setSubmitDate(submitDate);
    orderImpl.setTaxOverride(true);
    List<OfferCode> actualAddedOfferCodes = orderImpl.getAddedOfferCodes();
    Map<Offer, OfferInfo> actualAdditionalOfferInformation =
        orderImpl.getAdditionalOfferInformation();
    Auditable actualAuditable = orderImpl.getAuditable();
    Long actualBroadleafAccountId = orderImpl.getBroadleafAccountId();
    List<CandidateOrderOffer> actualCandidateOrderOffers = orderImpl.getCandidateOrderOffers();
    BroadleafCurrency actualCurrency = orderImpl.getCurrency();
    Customer actualCustomer = orderImpl.getCustomer();
    String actualEmailAddress = orderImpl.getEmailAddress();
    List<FulfillmentGroup> actualFulfillmentGroups = orderImpl.getFulfillmentGroups();
    String actualFulfillmentStatus = orderImpl.getFulfillmentStatus();
    Long actualId = orderImpl.getId();
    Locale actualLocale = orderImpl.getLocale();
    String actualName = orderImpl.getName();
    List<OrderAdjustment> actualOrderAdjustments = orderImpl.getOrderAdjustments();
    Map<String, OrderAttribute> actualOrderAttributes = orderImpl.getOrderAttributes();
    List<OrderItem> actualOrderItems = orderImpl.getOrderItems();
    String actualOrderNumber = orderImpl.getOrderNumber();
    List<OrderPayment> actualPayments = orderImpl.getPayments();
    Date actualSubmitDate = orderImpl.getSubmitDate();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("42", actualOrderNumber);
    assertEquals("Name", actualName);
    assertNull(actualBroadleafAccountId);
    assertNull(actualFulfillmentStatus);
    assertTrue(actualAddedOfferCodes.isEmpty());
    assertTrue(actualCandidateOrderOffers.isEmpty());
    assertTrue(actualFulfillmentGroups.isEmpty());
    assertTrue(actualOrderAdjustments.isEmpty());
    assertTrue(actualOrderItems.isEmpty());
    assertTrue(actualPayments.isEmpty());
    assertTrue(actualAdditionalOfferInformation.isEmpty());
    assertTrue(actualOrderAttributes.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(candidateOrderOffers, actualCandidateOrderOffers);
    assertSame(fulfillmentGroups, actualFulfillmentGroups);
    assertSame(orderAdjustments, actualOrderAdjustments);
    assertSame(orderItems, actualOrderItems);
    assertSame(payments, actualPayments);
    assertSame(additionalOfferInformation, actualAdditionalOfferInformation);
    assertSame(orderAttributes, actualOrderAttributes);
    assertSame(auditable, actualAuditable);
    assertSame(currency, actualCurrency);
    assertSame(locale, actualLocale);
    assertSame(customer, actualCustomer);
    assertSame(submitDate, actualSubmitDate);
  }

  /**
   * Test {@link OrderImpl#getItemAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getItemAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getItemAdjustmentsValue()"})
  public void testGetItemAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.getItemAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getItemAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getItemAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getItemAdjustmentsValue()"})
  public void testGetItemAdjustmentsValue_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("currency.default");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualItemAdjustmentsValue = orderImpl.getItemAdjustmentsValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualItemAdjustmentsValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualItemAdjustmentsValue.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderImpl#getItemAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getItemAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getItemAdjustmentsValue()"})
  public void testGetItemAdjustmentsValue_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getTotalAdjustmentValue()).thenReturn(money);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualItemAdjustmentsValue = orderImpl.getItemAdjustmentsValue();

    // Assert
    verify(orderItem).getTotalAdjustmentValue();
    assertEquals(money, actualItemAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}.
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditItemAdjustmentsValue()"})
  public void testGetFutureCreditItemAdjustmentsValue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("currency.default");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualFutureCreditItemAdjustmentsValue = orderImpl.getFutureCreditItemAdjustmentsValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualFutureCreditItemAdjustmentsValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualFutureCreditItemAdjustmentsValue.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditItemAdjustmentsValue()"})
  public void testGetFutureCreditItemAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.getFutureCreditItemAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditItemAdjustmentsValue()"})
  public void testGetFutureCreditItemAdjustmentsValue_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getFutureCreditTotalAdjustmentValue()).thenReturn(money);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualFutureCreditItemAdjustmentsValue = orderImpl.getFutureCreditItemAdjustmentsValue();

    // Assert
    verify(orderItem).getFutureCreditTotalAdjustmentValue();
    assertEquals(money, actualFutureCreditItemAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}.
   *
   * <p>Method under test: {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setCurrency(currency);

    // Act
    Money actualFulfillmentGroupAdjustmentsValue = orderImpl.getFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualFulfillmentGroupAdjustmentsValue.abs();
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualFulfillmentGroupAdjustmentsValue.zero();
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.getFulfillmentGroupAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"})
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setCurrency(currency);

    // Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue =
        orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualFutureCreditFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualFutureCreditFulfillmentGroupAdjustmentsValue.abs();
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditFulfillmentGroupAdjustmentsValue.zero();
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"})
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getOrderAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getOrderAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getOrderAdjustmentsValue()"})
  public void testGetOrderAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.getOrderAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getOrderAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then calls {@link OrderAdjustmentImpl#isFutureCredit()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getOrderAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getOrderAdjustmentsValue()"})
  public void testGetOrderAdjustmentsValue_thenCallsIsFutureCredit() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderAdjustmentImpl orderAdjustmentImpl = mock(OrderAdjustmentImpl.class);
    when(orderAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(orderAdjustmentImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setOrderAdjustments(orderAdjustments);
    orderImpl.setCurrency(currency);

    // Act
    Money actualOrderAdjustmentsValue = orderImpl.getOrderAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderAdjustmentImpl).isFutureCredit();
    Currency currency2 = actualOrderAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualOrderAdjustmentsValue.abs();
    assertEquals(actualOrderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualOrderAdjustmentsValue.zero();
    assertEquals(actualOrderAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#getOrderAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getOrderAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getOrderAdjustmentsValue()"})
  public void testGetOrderAdjustmentsValue_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setCurrency(currency);

    // Act
    Money actualOrderAdjustmentsValue = orderImpl.getOrderAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualOrderAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualOrderAdjustmentsValue.abs();
    assertEquals(actualOrderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualOrderAdjustmentsValue.zero();
    assertEquals(actualOrderAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}.
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditOrderAdjustmentsValue()"})
  public void testGetFutureCreditOrderAdjustmentsValue() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setCurrency(currency);

    // Act
    Money actualFutureCreditOrderAdjustmentsValue =
        orderImpl.getFutureCreditOrderAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualFutureCreditOrderAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualFutureCreditOrderAdjustmentsValue.abs();
    assertEquals(actualFutureCreditOrderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditOrderAdjustmentsValue.zero();
    assertEquals(actualFutureCreditOrderAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}.
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditOrderAdjustmentsValue()"})
  public void testGetFutureCreditOrderAdjustmentsValue2() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(new OrderAdjustmentImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setOrderAdjustments(orderAdjustments);
    orderImpl.setCurrency(currency);

    // Act
    Money actualFutureCreditOrderAdjustmentsValue =
        orderImpl.getFutureCreditOrderAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualFutureCreditOrderAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualFutureCreditOrderAdjustmentsValue.abs();
    assertEquals(actualFutureCreditOrderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditOrderAdjustmentsValue.zero();
    assertEquals(actualFutureCreditOrderAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}.
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditOrderAdjustmentsValue()"})
  public void testGetFutureCreditOrderAdjustmentsValue3() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAdjustmentImpl.setFutureCredit(true);

    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(orderAdjustmentImpl);
    orderAdjustments.add(mock(OrderAdjustmentImpl.class));

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setOrderAdjustments(orderAdjustments);
    orderImpl.setCurrency(currency);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> orderImpl.getFutureCreditOrderAdjustmentsValue());
    verify(currency).getCurrencyCode();
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}.
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditOrderAdjustmentsValue()"})
  public void testGetFutureCreditOrderAdjustmentsValue4() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setOrder(new OrderImpl());
    orderAdjustmentImpl.setFutureCredit(true);

    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(orderAdjustmentImpl);
    orderAdjustments.add(mock(OrderAdjustmentImpl.class));

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setOrderAdjustments(orderAdjustments);
    orderImpl.setCurrency(currency);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> orderImpl.getFutureCreditOrderAdjustmentsValue());
    verify(currency).getCurrencyCode();
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditOrderAdjustmentsValue()"})
  public void testGetFutureCreditOrderAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.getFutureCreditOrderAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getTotalAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalAdjustmentsValue()"})
  public void testGetTotalAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.getTotalAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getTotalAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalAdjustmentsValue()"})
  public void testGetTotalAdjustmentsValue_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("currency.default");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentsValue = orderImpl.getTotalAdjustmentsValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalAdjustmentsValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalAdjustmentsValue.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderImpl#getTotalAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalAdjustmentsValue()"})
  public void testGetTotalAdjustmentsValue_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getTotalAdjustmentValue()).thenReturn(money);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentsValue = orderImpl.getTotalAdjustmentsValue();

    // Assert
    verify(orderItem).getTotalAdjustmentValue();
    assertEquals(money, actualTotalAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}.
   *
   * <p>Method under test: {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalFutureCreditAdjustmentsValue()"})
  public void testGetTotalFutureCreditAdjustmentsValue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("currency.default");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualTotalFutureCreditAdjustmentsValue =
        orderImpl.getTotalFutureCreditAdjustmentsValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalFutureCreditAdjustmentsValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalFutureCreditAdjustmentsValue.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalFutureCreditAdjustmentsValue()"})
  public void testGetTotalFutureCreditAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.getTotalFutureCreditAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.getTotalFutureCreditAdjustmentsValue()"})
  public void testGetTotalFutureCreditAdjustmentsValue_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getFutureCreditTotalAdjustmentValue()).thenReturn(money);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualTotalFutureCreditAdjustmentsValue =
        orderImpl.getTotalFutureCreditAdjustmentsValue();

    // Assert
    verify(orderItem).getFutureCreditTotalAdjustmentValue();
    assertEquals(money, actualTotalFutureCreditAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#updatePrices()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#updatePrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.updatePrices()"})
  public void testUpdatePrices_givenArrayListAddBundleOrderItemImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl.updatePrices());
  }

  /**
   * Test {@link OrderImpl#updatePrices()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#updatePrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.updatePrices()"})
  public void testUpdatePrices_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderImpl.updatePrices());
  }

  /**
   * Test {@link OrderImpl#updatePrices()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#updatePrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.updatePrices()"})
  public void testUpdatePrices_thenReturnTrue() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualUpdatePricesResult = orderImpl.updatePrices();

    // Assert
    verify(bundleOrderItemImpl).updateSaleAndRetailPrices();
    assertTrue(actualUpdatePricesResult);
  }

  /**
   * Test {@link OrderImpl#finalizeItemPrices()}.
   *
   * <p>Method under test: {@link OrderImpl#finalizeItemPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.finalizeItemPrices()"})
  public void testFinalizeItemPrices() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(null);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.finalizeItemPrices();

    // Assert
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditItemAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getItemAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getTotalAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getTotalFutureCreditAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#finalizeItemPrices()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#finalizeItemPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.finalizeItemPrices()"})
  public void testFinalizeItemPrices_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderImpl.finalizeItemPrices());
  }

  /**
   * Test {@link OrderImpl#finalizeItemPrices()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#finalizeItemPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.finalizeItemPrices()"})
  public void testFinalizeItemPrices_givenOrderItemImplOrderIsNull_order() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.finalizeItemPrices();

    // Assert that nothing has changed
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#finalizeItemPrices()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link OrderImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#finalizeItemPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.finalizeItemPrices()"})
  public void testFinalizeItemPrices_givenOrderItemImplOrderIsOrderImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new OrderImpl());
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.finalizeItemPrices();

    // Assert that nothing has changed
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#finalizeItemPrices()}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#finalizePrice()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#finalizeItemPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.finalizeItemPrices()"})
  public void testFinalizeItemPrices_thenCallsFinalizePrice() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).finalizePrice();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualFinalizeItemPricesResult = orderImpl.finalizeItemPrices();

    // Assert
    verify(bundleOrderItemImpl).finalizePrice();
    assertFalse(actualFinalizeItemPricesResult);
  }

  /**
   * Test {@link OrderImpl#finalizeItemPrices()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#finalizeItemPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.finalizeItemPrices()"})
  public void testFinalizeItemPrices_thenCallsGetCurrencyCode() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(order);
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.finalizeItemPrices();

    // Assert that nothing has changed
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#addAddedOfferCode(OfferCode)}.
   *
   * <p>Method under test: {@link OrderImpl#addAddedOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.addAddedOfferCode(OfferCode)"})
  public void testAddAddedOfferCode() {
    // Arrange
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    orderImpl.addAddedOfferCode(offerCode);

    // Assert
    List<OfferCode> addedOfferCodes = orderImpl.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link OrderImpl#addOfferCode(OfferCode)}.
   *
   * <p>Method under test: {@link OrderImpl#addOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.addOfferCode(OfferCode)"})
  public void testAddOfferCode() {
    // Arrange
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    orderImpl.addOfferCode(offerCode);

    // Assert
    List<OfferCode> addedOfferCodes = orderImpl.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link OrderImpl#getTaxOverride()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} TaxOverride is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTaxOverride()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderImpl.getTaxOverride()"})
  public void testGetTaxOverride_givenOrderImplTaxOverrideIsTrue_thenReturnTrue() {
    // Arrange
    orderImpl.setTaxOverride(true);

    // Act and Assert
    assertTrue(orderImpl.getTaxOverride());
  }

  /**
   * Test {@link OrderImpl#getTaxOverride()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getTaxOverride()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderImpl.getTaxOverride()"})
  public void testGetTaxOverride_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderImpl.getTaxOverride());
  }

  /**
   * Test {@link OrderImpl#getItemCount()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getItemCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderImpl.getItemCount()"})
  public void testGetItemCount_givenArrayListAddDiscreteOrderItemImpl_thenReturnZero() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(0, orderImpl.getItemCount());
  }

  /**
   * Test {@link OrderImpl#getItemCount()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) addOrderItem {@link DiscreteOrderItemImpl}
   *       (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getItemCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderImpl.getItemCount()"})
  public void testGetItemCount_givenOrderImplAddOrderItemDiscreteOrderItemImpl_thenReturnZero() {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(new DiscreteOrderItemImpl());

    // Act and Assert
    assertEquals(0, orderImpl.getItemCount());
  }

  /**
   * Test {@link OrderImpl#getItemCount()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getItemCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderImpl.getItemCount()"})
  public void testGetItemCount_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, orderImpl.getItemCount());
  }

  /**
   * Test {@link OrderImpl#getItemCount()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getItemCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderImpl.getItemCount()"})
  public void testGetItemCount_givenOrderItemImplAuditableIsAuditable_thenReturnOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act and Assert
    assertEquals(1, orderImpl.getItemCount());
  }

  /**
   * Test {@link OrderImpl#getItemCount()}.
   *
   * <ul>
   *   <li>Then calls {@link DiscreteOrderItemImpl#getParentOrderItem()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getItemCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderImpl.getItemCount()"})
  public void testGetItemCount_thenCallsGetParentOrderItem() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getParentOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    int actualItemCount = orderImpl.getItemCount();

    // Assert
    verify(discreteOrderItemImpl).getParentOrderItem();
    assertEquals(0, actualItemCount);
  }

  /**
   * Test {@link OrderImpl#getHasOrderAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getHasOrderAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.getHasOrderAdjustments()"})
  public void testGetHasOrderAdjustments_givenOrderImpl() {
    // Arrange, Act and Assert
    assertFalse(orderImpl.getHasOrderAdjustments());
  }

  /**
   * Test {@link OrderImpl#getHasOrderAdjustments()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getHasOrderAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.getHasOrderAdjustments()"})
  public void testGetHasOrderAdjustments_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setCurrency(currency);

    // Act
    boolean actualHasOrderAdjustments = orderImpl.getHasOrderAdjustments();

    // Assert
    verify(currency).getCurrencyCode();
    assertFalse(actualHasOrderAdjustments);
  }

  /**
   * Test {@link OrderImpl#getHasOrderAdjustments()}.
   *
   * <ul>
   *   <li>Then calls {@link OrderAdjustmentImpl#isFutureCredit()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getHasOrderAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.getHasOrderAdjustments()"})
  public void testGetHasOrderAdjustments_thenCallsIsFutureCredit() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderAdjustmentImpl orderAdjustmentImpl = mock(OrderAdjustmentImpl.class);
    when(orderAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(orderAdjustmentImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setOrderAdjustments(orderAdjustments);
    orderImpl.setCurrency(currency);

    // Act
    boolean actualHasOrderAdjustments = orderImpl.getHasOrderAdjustments();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderAdjustmentImpl).isFutureCredit();
    assertFalse(actualHasOrderAdjustments);
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) FirstName is empty string.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplFirstNameIsEmptyString_thenReturnFoo() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setId(OrderItemQualifierImpl.serialVersionUID);
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setFirstName("");
    customer.setLastName("");
    orderImpl.setCustomer(customer);
    orderImpl.setOrderNumber("foo");

    // Act and Assert
    assertEquals("foo", orderImpl.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) FirstName is {@code foo}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplFirstNameIsFoo_thenReturnEmptyString() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setId(OrderItemQualifierImpl.serialVersionUID);
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setFirstName("foo");
    customer.setLastName("");
    orderImpl.setCustomer(customer);
    orderImpl.setOrderNumber("");

    // Act and Assert
    assertEquals("", orderImpl.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) LastName is {@code foo}.
   *   <li>Then return {@code foo foo}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplLastNameIsFoo_thenReturnFooFoo() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setId(OrderItemQualifierImpl.serialVersionUID);
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setFirstName("foo");
    customer.setLastName("foo");
    orderImpl.setCustomer(customer);
    orderImpl.setOrderNumber("");

    // Act and Assert
    assertEquals("foo foo", orderImpl.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) LastName is {@code foo}.
   *   <li>Then return {@code foo - foo foo}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplLastNameIsFoo_thenReturnFooFooFoo() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setId(OrderItemQualifierImpl.serialVersionUID);
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setFirstName("foo");
    customer.setLastName("foo");
    orderImpl.setCustomer(customer);
    orderImpl.setOrderNumber("foo");

    // Act and Assert
    assertEquals("foo - foo foo", orderImpl.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_thenReturnEmptyString() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setId(OrderItemQualifierImpl.serialVersionUID);
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setFirstName("");
    customer.setLastName("");
    orderImpl.setCustomer(customer);
    orderImpl.setOrderNumber("");

    // Act and Assert
    assertEquals("", orderImpl.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImpl() {
    // Arrange, Act and Assert
    assertNull(orderImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} Currency is {@link BroadleafCurrencyImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl() {
    // Arrange
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    // Act and Assert
    assertNull(orderImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(null);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(null);
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(null);
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(null);
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(null);
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl);
    int expectedHashCodeResult = orderImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderImpl.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(2L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(new Date());
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(null);
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(null);
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(mock(CustomerImpl.class));
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, null);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, "Different type to OrderImpl");
  }

  /**
   * Test {@link OrderImpl#getOrderMessages()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getOrderMessages()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getOrderMessages()"})
  public void testGetOrderMessages_givenOrderImpl() {
    // Arrange, Act and Assert
    assertTrue(orderImpl.getOrderMessages().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getOrderMessages()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} OrderMessages is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#getOrderMessages()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderImpl.getOrderMessages()"})
  public void testGetOrderMessages_givenOrderImplOrderMessagesIsArrayList() {
    // Arrange
    orderImpl.setOrderMessages(new ArrayList<>());

    // Act and Assert
    assertTrue(orderImpl.getOrderMessages().isEmpty());
  }

  /**
   * Test {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(NullOrderFactoryImpl.NULL_ORDER, true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Order> actualCreateOrRetrieveCopyInstanceResult =
        orderImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) SubTotal is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenOrderImplSubTotalIsMoney()
      throws CloneNotSupportedException {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setSubTotal(new Money());
    orderImpl.addAddedOfferCode(new OfferCodeImpl());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(nullOrderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(nullOrderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(nullOrderImpl).setName(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(nullOrderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(nullOrderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(nullOrderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalTax(Mockito.<Money>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(nullOrderImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Order> actualCreateOrRetrieveCopyInstanceResult =
        orderImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(nullOrderImpl).getAddedOfferCodes();
    verify(nullOrderImpl).setCurrency(isNull());
    verify(nullOrderImpl).setCustomer(isNull());
    verify(nullOrderImpl).setEmailAddress(null);
    verify(nullOrderImpl).setLocale(isNull());
    verify(nullOrderImpl).setName(null);
    verify(nullOrderImpl).setOrderNumber(null);
    verify(nullOrderImpl).setStatus(isNull());
    verify(nullOrderImpl).setSubTotal(isA(Money.class));
    verify(nullOrderImpl).setSubmitDate(isNull());
    verify(nullOrderImpl).setTaxOverride(isNull());
    verify(nullOrderImpl).setTotal(isNull());
    verify(nullOrderImpl).setTotalFulfillmentCharges(isNull());
    verify(nullOrderImpl).setTotalTax(isNull());
    assertEquals(1, orderImpl.getAddedOfferCodes().size());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) TaxOverride is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenOrderImplTaxOverrideIsTrue()
      throws CloneNotSupportedException {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setTaxOverride(true);
    orderImpl.addAddedOfferCode(new OfferCodeImpl());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(nullOrderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(nullOrderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(nullOrderImpl).setName(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(nullOrderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(nullOrderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(nullOrderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalTax(Mockito.<Money>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(nullOrderImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Order> actualCreateOrRetrieveCopyInstanceResult =
        orderImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(nullOrderImpl).getAddedOfferCodes();
    verify(nullOrderImpl).setCurrency(isNull());
    verify(nullOrderImpl).setCustomer(isNull());
    verify(nullOrderImpl).setEmailAddress(null);
    verify(nullOrderImpl).setLocale(isNull());
    verify(nullOrderImpl).setName(null);
    verify(nullOrderImpl).setOrderNumber(null);
    verify(nullOrderImpl).setStatus(isNull());
    verify(nullOrderImpl).setSubTotal(isNull());
    verify(nullOrderImpl).setSubmitDate(isNull());
    verify(nullOrderImpl).setTaxOverride(true);
    verify(nullOrderImpl).setTotal(isNull());
    verify(nullOrderImpl).setTotalFulfillmentCharges(isNull());
    verify(nullOrderImpl).setTotalTax(isNull());
    assertEquals(1, orderImpl.getAddedOfferCodes().size());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) TotalFulfillmentCharges is {@link
   *       Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenOrderImplTotalFulfillmentChargesIsMoney()
      throws CloneNotSupportedException {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.addAddedOfferCode(new OfferCodeImpl());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(nullOrderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(nullOrderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(nullOrderImpl).setName(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(nullOrderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(nullOrderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(nullOrderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalTax(Mockito.<Money>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(nullOrderImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Order> actualCreateOrRetrieveCopyInstanceResult =
        orderImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(nullOrderImpl).getAddedOfferCodes();
    verify(nullOrderImpl).setCurrency(isNull());
    verify(nullOrderImpl).setCustomer(isNull());
    verify(nullOrderImpl).setEmailAddress(null);
    verify(nullOrderImpl).setLocale(isNull());
    verify(nullOrderImpl).setName(null);
    verify(nullOrderImpl).setOrderNumber(null);
    verify(nullOrderImpl).setStatus(isNull());
    verify(nullOrderImpl).setSubTotal(isNull());
    verify(nullOrderImpl).setSubmitDate(isNull());
    verify(nullOrderImpl).setTaxOverride(isNull());
    verify(nullOrderImpl).setTotal(isNull());
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(nullOrderImpl).setTotalTax(isNull());
    assertEquals(1, orderImpl.getAddedOfferCodes().size());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Total is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenOrderImplTotalIsMoney()
      throws CloneNotSupportedException {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setTotal(new Money());
    orderImpl.addAddedOfferCode(new OfferCodeImpl());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(nullOrderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(nullOrderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(nullOrderImpl).setName(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(nullOrderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(nullOrderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(nullOrderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalTax(Mockito.<Money>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(nullOrderImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Order> actualCreateOrRetrieveCopyInstanceResult =
        orderImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(nullOrderImpl).getAddedOfferCodes();
    verify(nullOrderImpl).setCurrency(isNull());
    verify(nullOrderImpl).setCustomer(isNull());
    verify(nullOrderImpl).setEmailAddress(null);
    verify(nullOrderImpl).setLocale(isNull());
    verify(nullOrderImpl).setName(null);
    verify(nullOrderImpl).setOrderNumber(null);
    verify(nullOrderImpl).setStatus(isNull());
    verify(nullOrderImpl).setSubTotal(isNull());
    verify(nullOrderImpl).setSubmitDate(isNull());
    verify(nullOrderImpl).setTaxOverride(isNull());
    verify(nullOrderImpl).setTotal(isA(Money.class));
    verify(nullOrderImpl).setTotalFulfillmentCharges(isNull());
    verify(nullOrderImpl).setTotalTax(isNull());
    assertEquals(1, orderImpl.getAddedOfferCodes().size());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) TotalTax is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenOrderImplTotalTaxIsMoney()
      throws CloneNotSupportedException {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setTotalTax(new Money());
    orderImpl.addAddedOfferCode(new OfferCodeImpl());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(nullOrderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(nullOrderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(nullOrderImpl).setName(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(nullOrderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(nullOrderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(nullOrderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalTax(Mockito.<Money>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(nullOrderImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Order> actualCreateOrRetrieveCopyInstanceResult =
        orderImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(nullOrderImpl).getAddedOfferCodes();
    verify(nullOrderImpl).setCurrency(isNull());
    verify(nullOrderImpl).setCustomer(isNull());
    verify(nullOrderImpl).setEmailAddress(null);
    verify(nullOrderImpl).setLocale(isNull());
    verify(nullOrderImpl).setName(null);
    verify(nullOrderImpl).setOrderNumber(null);
    verify(nullOrderImpl).setStatus(isNull());
    verify(nullOrderImpl).setSubTotal(isNull());
    verify(nullOrderImpl).setSubmitDate(isNull());
    verify(nullOrderImpl).setTaxOverride(isNull());
    verify(nullOrderImpl).setTotal(isNull());
    verify(nullOrderImpl).setTotalFulfillmentCharges(isNull());
    verify(nullOrderImpl).setTotalTax(isA(Money.class));
    assertEquals(1, orderImpl.getAddedOfferCodes().size());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return not AlreadyPopulated.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenOrderImpl_thenReturnNotAlreadyPopulated()
      throws CloneNotSupportedException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    doNothing().when(nullOrderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(nullOrderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(nullOrderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(nullOrderImpl).setName(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(nullOrderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(nullOrderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(nullOrderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalTax(Mockito.<Money>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(nullOrderImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Order> actualCreateOrRetrieveCopyInstanceResult =
        orderImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(nullOrderImpl).setCurrency(isNull());
    verify(nullOrderImpl).setCustomer(isNull());
    verify(nullOrderImpl).setEmailAddress(null);
    verify(nullOrderImpl).setLocale(isNull());
    verify(nullOrderImpl).setName(null);
    verify(nullOrderImpl).setOrderNumber(null);
    verify(nullOrderImpl).setStatus(isNull());
    verify(nullOrderImpl).setSubTotal(isNull());
    verify(nullOrderImpl).setSubmitDate(isNull());
    verify(nullOrderImpl).setTaxOverride(isNull());
    verify(nullOrderImpl).setTotal(isNull());
    verify(nullOrderImpl).setTotalFulfillmentCharges(isNull());
    verify(nullOrderImpl).setTotalTax(isNull());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) AddedOfferCodes size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenOrderImplAddedOfferCodesSizeIsOne()
      throws CloneNotSupportedException {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addAddedOfferCode(new OfferCodeImpl());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    doNothing().when(nullOrderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(nullOrderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(nullOrderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(nullOrderImpl).setName(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(nullOrderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(nullOrderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(nullOrderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(nullOrderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(nullOrderImpl).setTotalTax(Mockito.<Money>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(nullOrderImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Order> actualCreateOrRetrieveCopyInstanceResult =
        orderImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(nullOrderImpl).getAddedOfferCodes();
    verify(nullOrderImpl).setCurrency(isNull());
    verify(nullOrderImpl).setCustomer(isNull());
    verify(nullOrderImpl).setEmailAddress(null);
    verify(nullOrderImpl).setLocale(isNull());
    verify(nullOrderImpl).setName(null);
    verify(nullOrderImpl).setOrderNumber(null);
    verify(nullOrderImpl).setStatus(isNull());
    verify(nullOrderImpl).setSubTotal(isNull());
    verify(nullOrderImpl).setSubmitDate(isNull());
    verify(nullOrderImpl).setTaxOverride(isNull());
    verify(nullOrderImpl).setTotal(isNull());
    verify(nullOrderImpl).setTotalFulfillmentCharges(isNull());
    verify(nullOrderImpl).setTotalTax(isNull());
    assertEquals(1, orderImpl.getAddedOfferCodes().size());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderImpl#hasValidationErrors()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       OrderItemQualifierImpl#serialVersionUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#hasValidationErrors()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderImpl.hasValidationErrors()"})
  public void testHasValidationErrors_givenAuditableCreatedByIsSerialVersionUID_thenReturnTrue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act and Assert
    assertTrue(orderImpl.hasValidationErrors());
  }

  /**
   * Test {@link OrderImpl#hasValidationErrors()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#hasValidationErrors()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderImpl.hasValidationErrors()"})
  public void testHasValidationErrors_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderImpl.hasValidationErrors());
  }

  /**
   * Test new {@link OrderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OrderImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.<init>()"})
  public void testNewOrderImpl() {
    // Arrange and Act
    OrderImpl actualOrderImpl = new OrderImpl();

    // Assert
    assertNull(actualOrderImpl.getPreview());
    assertNull(actualOrderImpl.taxOverride);
    assertNull(actualOrderImpl.getBroadleafAccountId());
    assertNull(actualOrderImpl.getId());
    assertNull(actualOrderImpl.getCurrencyCode());
    assertNull(actualOrderImpl.getEmailAddress());
    assertNull(actualOrderImpl.getFulfillmentStatus());
    assertNull(actualOrderImpl.getName());
    assertNull(actualOrderImpl.getOrderNumber());
    assertNull(actualOrderImpl.status);
    assertNull(actualOrderImpl.subTotal);
    assertNull(actualOrderImpl.total);
    assertNull(actualOrderImpl.totalFulfillmentCharges);
    assertNull(actualOrderImpl.totalTax);
    assertNull(actualOrderImpl.getSubmitDate());
    assertNull(actualOrderImpl.getCurrency());
    assertNull(actualOrderImpl.getLocale());
    assertNull(actualOrderImpl.getSubTotal());
    assertNull(actualOrderImpl.getTotal());
    assertNull(actualOrderImpl.getTotalAfterAppliedPayments());
    assertNull(actualOrderImpl.getTotalFulfillmentCharges());
    assertNull(actualOrderImpl.getTotalShipping());
    assertNull(actualOrderImpl.getTotalTax());
    assertNull(actualOrderImpl.getStatus());
    assertNull(actualOrderImpl.getCustomer());
    assertEquals(0, actualOrderImpl.getItemCount());
    assertFalse(actualOrderImpl.getHasOrderAdjustments());
    assertFalse(actualOrderImpl.getTaxOverride());
    assertTrue(actualOrderImpl.getAddedOfferCodes().isEmpty());
    assertTrue(actualOrderImpl.getAllFutureCreditAdjustments().isEmpty());
    assertTrue(actualOrderImpl.getCandidateOrderOffers().isEmpty());
    assertTrue(actualOrderImpl.getDiscreteOrderItems().isEmpty());
    assertTrue(actualOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(actualOrderImpl.getFutureCreditOrderAdjustments().isEmpty());
    assertTrue(actualOrderImpl.getNonDiscreteOrderItems().isEmpty());
    assertTrue(actualOrderImpl.getOrderAdjustments().isEmpty());
    assertTrue(actualOrderImpl.getOrderItems().isEmpty());
    assertTrue(actualOrderImpl.getOrderMessages().isEmpty());
    assertTrue(actualOrderImpl.getPayments().isEmpty());
    assertTrue(actualOrderImpl.getAdditionalOfferInformation().isEmpty());
    assertTrue(actualOrderImpl.getOrderAttributes().isEmpty());
  }
}
