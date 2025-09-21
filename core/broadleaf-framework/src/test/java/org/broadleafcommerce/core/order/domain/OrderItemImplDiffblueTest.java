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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductBundle;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemAdjustment;
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

@ContextConfiguration(classes = {OrderItemImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemImplDiffblueTest {
  @Autowired private OrderItemImpl orderItemImpl;

  /**
   * Test {@link OrderItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) RetailPrice is {@link Money#Money()}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenOrderItemImplRetailPriceIsMoney_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(null);

    // Act and Assert
    assertEquals(finalPrice, orderItemImpl.getRetailPrice());
  }

  /**
   * Test {@link OrderItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) RetailPrice is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenOrderItemImplRetailPriceIsNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setRetailPrice(null);
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(orderItemImpl.getRetailPrice());
  }

  /**
   * Test {@link OrderItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenOrderItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new OrderItemImpl().getRetailPrice());
  }

  /**
   * Test {@link OrderItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenOrderItemImplSalePriceIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setSalePrice(null);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act and Assert
    assertEquals(finalPrice, orderItemImpl.getSalePrice());
  }

  /**
   * Test {@link OrderItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenOrderItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new OrderItemImpl().getSalePrice());
  }

  /**
   * Test {@link OrderItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(null);
    orderItemImpl.setOrder(order);

    // Act
    Money actualSalePrice = orderItemImpl.getSalePrice();

    // Assert
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    Money absResult = actualSalePrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualSalePrice.zero();
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
   * Test {@link OrderItemImpl#getPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPrice()"})
  public void testGetPrice_givenOrderItemImplOrderIsNull_order_thenReturnMoney() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);

    // Act and Assert
    assertEquals(finalPrice, orderItemImpl.getPrice());
  }

  /**
   * Test {@link OrderItemImpl#getPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Quantity is six.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPrice()"})
  public void testGetPrice_givenOrderItemImplQuantityIsSix() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setOrder(order);
    orderItemImpl.setPrice(new Money());

    // Act
    Money actualPrice = orderItemImpl.getPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Currency currency = actualPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualPrice.abs();
    assertEquals(actualPrice, actualAbsResult);
    Money actualZeroResult = actualPrice.zero();
    assertEquals(actualPrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPrice()"})
  public void testGetPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setPrice(new Money());

    // Act
    Money actualPrice = orderItemImpl.getPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualPrice.abs();
    assertEquals(actualPrice, actualAbsResult);
    Money actualZeroResult = actualPrice.zero();
    assertEquals(actualPrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link NullOrderImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_givenOrderItemImplOrderIsNullOrderImpl_thenReturnNull() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNull(orderItemImpl.getTaxablePrice());
  }

  /**
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_givenOrderItemImplOrderIsNull_order_thenReturnNull() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertNull(orderItemImpl.getTaxablePrice());
  }

  /**
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@link
   *       Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_givenOrderItemImplSalePriceIsMoneyWithAmountIsTen() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setQuantity(6);
    orderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = orderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    Money absResult = actualTaxablePrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTaxablePrice.zero();
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
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Taxable is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_givenOrderItemImplTaxableIsTrue_thenReturnNull() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setTaxable(true);
    orderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = orderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    assertNull(actualTaxablePrice);
  }

  /**
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#price}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenReturnAbsAbsAbsAmountIsOrderItemImplPrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = orderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.price;
    Money absResult = actualTaxablePrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTaxablePrice.zero();
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
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#price}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenReturnAbsAbsAbsAmountIsOrderItemImplPrice2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = orderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.price;
    Money absResult = actualTaxablePrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTaxablePrice.zero();
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
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#retailPrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenReturnAbsAbsAbsAmountIsOrderItemImplRetailPrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setQuantity(6);
    orderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = orderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    Money absResult = actualTaxablePrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTaxablePrice.zero();
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
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setQuantity(6);
    orderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = orderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    Money absResult = actualTaxablePrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTaxablePrice.zero();
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
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setQuantity(6);
    orderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = orderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    Money absResult = actualTaxablePrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTaxablePrice.zero();
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
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setTaxable(false);
    orderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = orderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualTaxablePrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertEquals(new BigDecimal("0.00"), actualTaxablePrice.getAmount());
    Money actualAbsResult = actualTaxablePrice.abs();
    assertEquals(actualTaxablePrice, actualAbsResult);
    Money actualZeroResult = actualTaxablePrice.zero();
    assertEquals(actualTaxablePrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenReturnNull() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = orderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    assertNull(actualTaxablePrice);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#setAuditable(Auditable)}
   *   <li>{@link OrderItemImpl#setCandidateItemOffers(List)}
   *   <li>{@link OrderItemImpl#setCartMessages(List)}
   *   <li>{@link OrderItemImpl#setChildOrderItems(List)}
   *   <li>{@link OrderItemImpl#setGiftWrapOrderItem(GiftWrapOrderItem)}
   *   <li>{@link OrderItemImpl#setHasValidationError(Boolean)}
   *   <li>{@link OrderItemImpl#setId(Long)}
   *   <li>{@link OrderItemImpl#setName(String)}
   *   <li>{@link OrderItemImpl#setOrder(Order)}
   *   <li>{@link OrderItemImpl#setOrderItemAdjustments(List)}
   *   <li>{@link OrderItemImpl#setOrderItemAttributes(Map)}
   *   <li>{@link OrderItemImpl#setOrderItemPriceDetails(List)}
   *   <li>{@link OrderItemImpl#setOrderItemQualifiers(List)}
   *   <li>{@link OrderItemImpl#setParentOrderItem(OrderItem)}
   *   <li>{@link OrderItemImpl#setPersonalMessage(PersonalMessage)}
   *   <li>{@link OrderItemImpl#setProratedOrderItemAdjustments(List)}
   *   <li>{@link OrderItemImpl#setQuantity(int)}
   *   <li>{@link OrderItemImpl#setTaxable(Boolean)}
   *   <li>{@link OrderItemImpl#getAuditable()}
   *   <li>{@link OrderItemImpl#getCandidateItemOffers()}
   *   <li>{@link OrderItemImpl#getCartMessages()}
   *   <li>{@link OrderItemImpl#getChildOrderItems()}
   *   <li>{@link OrderItemImpl#getId()}
   *   <li>{@link OrderItemImpl#getName()}
   *   <li>{@link OrderItemImpl#getOrder()}
   *   <li>{@link OrderItemImpl#getOrderItemAdjustments()}
   *   <li>{@link OrderItemImpl#getOrderItemAttributes()}
   *   <li>{@link OrderItemImpl#getOrderItemPriceDetails()}
   *   <li>{@link OrderItemImpl#getOrderItemQualifiers()}
   *   <li>{@link OrderItemImpl#getParentOrderItem()}
   *   <li>{@link OrderItemImpl#getPersonalMessage()}
   *   <li>{@link OrderItemImpl#getQuantity()}
   *   <li>{@link OrderItemImpl#isSkuActive()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Auditable OrderItemImpl.getAuditable()",
    "List OrderItemImpl.getCandidateItemOffers()",
    "List OrderItemImpl.getCartMessages()",
    "List OrderItemImpl.getChildOrderItems()",
    "Long OrderItemImpl.getId()",
    "String OrderItemImpl.getName()",
    "Order OrderItemImpl.getOrder()",
    "List OrderItemImpl.getOrderItemAdjustments()",
    "Map OrderItemImpl.getOrderItemAttributes()",
    "List OrderItemImpl.getOrderItemPriceDetails()",
    "List OrderItemImpl.getOrderItemQualifiers()",
    "OrderItem OrderItemImpl.getParentOrderItem()",
    "PersonalMessage OrderItemImpl.getPersonalMessage()",
    "int OrderItemImpl.getQuantity()",
    "boolean OrderItemImpl.isSkuActive()",
    "void OrderItemImpl.setAuditable(Auditable)",
    "void OrderItemImpl.setCandidateItemOffers(List)",
    "void OrderItemImpl.setCartMessages(List)",
    "void OrderItemImpl.setChildOrderItems(List)",
    "void OrderItemImpl.setGiftWrapOrderItem(GiftWrapOrderItem)",
    "void OrderItemImpl.setHasValidationError(Boolean)",
    "void OrderItemImpl.setId(Long)",
    "void OrderItemImpl.setName(String)",
    "void OrderItemImpl.setOrder(Order)",
    "void OrderItemImpl.setOrderItemAdjustments(List)",
    "void OrderItemImpl.setOrderItemAttributes(Map)",
    "void OrderItemImpl.setOrderItemPriceDetails(List)",
    "void OrderItemImpl.setOrderItemQualifiers(List)",
    "void OrderItemImpl.setParentOrderItem(OrderItem)",
    "void OrderItemImpl.setPersonalMessage(PersonalMessage)",
    "void OrderItemImpl.setProratedOrderItemAdjustments(List)",
    "void OrderItemImpl.setQuantity(int)",
    "void OrderItemImpl.setTaxable(Boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    // Act
    orderItemImpl.setAuditable(auditable);
    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    orderItemImpl.setCandidateItemOffers(candidateItemOffers);
    ArrayList<String> cartMessage = new ArrayList<>();
    orderItemImpl.setCartMessages(cartMessage);
    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    orderItemImpl.setChildOrderItems(childOrderItems);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    Order order = NullOrderFactoryImpl.NULL_ORDER;
    orderItemImpl.setOrder(order);
    ArrayList<OrderItemAdjustment> orderItemAdjustments = new ArrayList<>();
    orderItemImpl.setOrderItemAdjustments(orderItemAdjustments);
    HashMap<String, OrderItemAttribute> orderItemAttributes = new HashMap<>();
    orderItemImpl.setOrderItemAttributes(orderItemAttributes);
    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);
    ArrayList<OrderItemQualifier> orderItemQualifiers = new ArrayList<>();
    orderItemImpl.setOrderItemQualifiers(orderItemQualifiers);
    BundleOrderItemImpl parentOrderItem = new BundleOrderItemImpl();
    orderItemImpl.setParentOrderItem(parentOrderItem);
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    orderItemImpl.setPersonalMessage(personalMessage);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setTaxable(true);
    Auditable actualAuditable = orderItemImpl.getAuditable();
    List<CandidateItemOffer> actualCandidateItemOffers = orderItemImpl.getCandidateItemOffers();
    List<String> actualCartMessages = orderItemImpl.getCartMessages();
    List<OrderItem> actualChildOrderItems = orderItemImpl.getChildOrderItems();
    Long actualId = orderItemImpl.getId();
    String actualName = orderItemImpl.getName();
    Order actualOrder = orderItemImpl.getOrder();
    List<OrderItemAdjustment> actualOrderItemAdjustments = orderItemImpl.getOrderItemAdjustments();
    Map<String, OrderItemAttribute> actualOrderItemAttributes =
        orderItemImpl.getOrderItemAttributes();
    List<OrderItemPriceDetail> actualOrderItemPriceDetails =
        orderItemImpl.getOrderItemPriceDetails();
    List<OrderItemQualifier> actualOrderItemQualifiers = orderItemImpl.getOrderItemQualifiers();
    OrderItem actualParentOrderItem = orderItemImpl.getParentOrderItem();
    PersonalMessage actualPersonalMessage = orderItemImpl.getPersonalMessage();
    int actualQuantity = orderItemImpl.getQuantity();
    boolean actualIsSkuActiveResult = orderItemImpl.isSkuActive();

    // Assert
    assertTrue(actualPersonalMessage instanceof PersonalMessageImpl);
    assertEquals("Name", actualName);
    assertEquals(1, actualQuantity);
    assertTrue(actualCandidateItemOffers.isEmpty());
    assertTrue(actualCartMessages.isEmpty());
    assertTrue(actualChildOrderItems.isEmpty());
    assertTrue(actualIsSkuActiveResult);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(candidateItemOffers, actualCandidateItemOffers);
    assertSame(cartMessage, actualCartMessages);
    assertSame(childOrderItems, actualChildOrderItems);
    assertSame(orderItemAdjustments, actualOrderItemAdjustments);
    assertSame(orderItemPriceDetails, actualOrderItemPriceDetails);
    assertSame(orderItemQualifiers, actualOrderItemQualifiers);
    assertSame(orderItemAttributes, actualOrderItemAttributes);
    assertSame(auditable, actualAuditable);
    assertSame(parentOrderItem, actualParentOrderItem);
    assertSame(personalMessage, actualPersonalMessage);
    assertSame(order, actualOrder);
  }

  /**
   * Test {@link OrderItemImpl#getAdjustmentValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getAdjustmentValue()"})
  public void testGetAdjustmentValue_givenOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setQuantity(1);

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getAdjustmentValue());
  }

  /**
   * Test {@link OrderItemImpl#getAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getAdjustmentValue()"})
  public void testGetAdjustmentValue_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setQuantity(1);

    // Act
    Money actualAdjustmentValue = orderItemImpl.getAdjustmentValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualAdjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualAdjustmentValue.abs();
    assertEquals(actualAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualAdjustmentValue.zero();
    assertEquals(actualAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getIsOnSale()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@link Money#Money()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getIsOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.getIsOnSale()"})
  public void testGetIsOnSale_givenOrderItemImplSalePriceIsMoney_thenReturnTrue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(null);
    orderItemImpl.setOrder(order);

    // Act and Assert
    assertTrue(orderItemImpl.getIsOnSale());
  }

  /**
   * Test {@link OrderItemImpl#getIsOnSale()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getIsOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.getIsOnSale()"})
  public void testGetIsOnSale_givenOrderItemImplSalePriceIsNull_thenReturnFalse() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setSalePrice(null);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act and Assert
    assertFalse(orderItemImpl.getIsOnSale());
  }

  /**
   * Test {@link OrderItemImpl#getIsOnSale()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getIsOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.getIsOnSale()"})
  public void testGetIsOnSale_givenOrderItemImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new OrderItemImpl().getIsOnSale());
  }

  /**
   * Test {@link OrderItemImpl#getIsDiscounted()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getIsDiscounted()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.getIsDiscounted()"})
  public void testGetIsDiscounted_givenOrderItemImplOrderIsNull_order() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(orderItemImpl.getIsDiscounted());
  }

  /**
   * Test {@link OrderItemImpl#getIsDiscounted()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Price is {@link Money#Money(double)}
   *       with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getIsDiscounted()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.getIsDiscounted()"})
  public void testGetIsDiscounted_givenOrderItemImplPriceIsMoneyWithAmountIsTen() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setPrice(new Money(10.0d));

    // Act and Assert
    assertFalse(orderItemImpl.getIsDiscounted());
  }

  /**
   * Test {@link OrderItemImpl#getIsDiscounted()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Quantity is six.
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getIsDiscounted()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.getIsDiscounted()"})
  public void testGetIsDiscounted_givenOrderItemImplQuantityIsSix_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setOrder(order);
    orderItemImpl.setPrice(new Money());

    // Act
    boolean actualIsDiscounted = orderItemImpl.getIsDiscounted();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertFalse(actualIsDiscounted);
  }

  /**
   * Test {@link OrderItemImpl#getIsDiscounted()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getIsDiscounted()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.getIsDiscounted()"})
  public void testGetIsDiscounted_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setPrice(new Money());

    // Act
    boolean actualIsDiscounted = orderItemImpl.getIsDiscounted();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertFalse(actualIsDiscounted);
  }

  /**
   * Test {@link OrderItemImpl#updateSaleAndRetailPrices()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       OrderItemQualifierImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.updateSaleAndRetailPrices()"})
  public void testUpdateSaleAndRetailPrices_givenAuditableCreatedByIsSerialVersionUID() {
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
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setSalePrice(new Money());

    // Act and Assert
    assertFalse(orderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test {@link OrderItemImpl#updateSaleAndRetailPrices()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.updateSaleAndRetailPrices()"})
  public void testUpdateSaleAndRetailPrices_givenOrderItemImpl() {
    // Arrange, Act and Assert
    assertFalse(new OrderItemImpl().updateSaleAndRetailPrices());
  }

  /**
   * Test {@link OrderItemImpl#finalizePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Quantity is six.
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#finalizePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.finalizePrice()"})
  public void testFinalizePrice_givenOrderItemImplQuantityIsSix_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setOrder(order);
    orderItemImpl.setPrice(new Money());

    // Act
    orderItemImpl.finalizePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
  }

  /**
   * Test {@link OrderItemImpl#finalizePrice()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#finalizePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.finalizePrice()"})
  public void testFinalizePrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setPrice(new Money());

    // Act
    orderItemImpl.finalizePrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.price);
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    assertSame(bigDecimal, orderItemImpl.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAveragePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getRetailPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getSalePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTaxablePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalPrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert that nothing has changed
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderItemImpl.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAveragePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getRetailPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getSalePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTaxablePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalPrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert that nothing has changed
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.price);
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice_givenOrderItemImplSalePriceIsNull() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(null);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.price);
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    assertSame(bigDecimal, orderItemImpl.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAveragePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getRetailPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getSalePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTaxablePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalPrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <ul>
   *   <li>Then {@link OrderItemImpl} (default constructor) AdjustmentValue Amount is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice_thenOrderItemImplAdjustmentValueAmountIsBigDecimalWith000() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(null);
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.getAdjustmentValue().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.getAveragePrice().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.getPrice().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.getTaxablePrice().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.price);
    assertEquals(new BigDecimal("60.00"), orderItemImpl.getTotalPrice().getAmount());
    BigDecimal expectedAmount = orderItemImpl.salePrice;
    assertSame(expectedAmount, orderItemImpl.getSalePrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)} with {@code allowSalesPrice}.
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPrice() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setSalePrice(null);
    Money retailPrice = new Money();
    orderItemImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, orderItemImpl.getPriceBeforeAdjustments(true));
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)} with {@code allowSalesPrice}.
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPrice2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(new Money());

    // Act
    Money actualPriceBeforeAdjustments = orderItemImpl.getPriceBeforeAdjustments(true);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Money actualAbsResult = actualPriceBeforeAdjustments.abs();
    assertEquals(actualPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualPriceBeforeAdjustments.zero();
    assertEquals(actualPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)} with {@code
   * allowSalesPrice}, {@code includeChildren}.
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean, boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPriceIncludeChildren() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setSalePrice(null);
    Money retailPrice = new Money();
    orderItemImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, orderItemImpl.getPriceBeforeAdjustments(true, true));
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)} with {@code
   * allowSalesPrice}, {@code includeChildren}.
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean, boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPriceIncludeChildren2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(null);

    // Act
    Money actualPriceBeforeAdjustments = orderItemImpl.getPriceBeforeAdjustments(true, true);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualPriceBeforeAdjustments.abs();
    assertEquals(actualPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualPriceBeforeAdjustments.zero();
    assertEquals(actualPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)} with {@code
   * allowSalesPrice}, {@code includeChildren}.
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean, boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPriceIncludeChildren3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());

    // Act
    Money actualPriceBeforeAdjustments = orderItemImpl.getPriceBeforeAdjustments(false, true);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualPriceBeforeAdjustments.abs();
    assertEquals(actualPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualPriceBeforeAdjustments.zero();
    assertEquals(actualPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)} with {@code
   * allowSalesPrice}, {@code includeChildren}.
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean, boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPriceIncludeChildren4() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(null);

    // Act
    Money actualPriceBeforeAdjustments = orderItemImpl.getPriceBeforeAdjustments(true, false);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualPriceBeforeAdjustments.abs();
    assertEquals(actualPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualPriceBeforeAdjustments.zero();
    assertEquals(actualPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)} with {@code
   * allowSalesPrice}, {@code includeChildren}.
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean, boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPriceIncludeChildren5() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(new Money());

    // Act
    Money actualPriceBeforeAdjustments = orderItemImpl.getPriceBeforeAdjustments(true, true);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Money actualAbsResult = actualPriceBeforeAdjustments.abs();
    assertEquals(actualPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualPriceBeforeAdjustments.zero();
    assertEquals(actualPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)} with {@code
   * allowSalesPrice}, {@code includeChildren}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean, boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPriceIncludeChildren_thenReturnMoney() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    Money salePrice = new Money();
    orderItemImpl.setSalePrice(salePrice);
    orderItemImpl.setRetailPrice(null);

    // Act and Assert
    assertEquals(salePrice, orderItemImpl.getPriceBeforeAdjustments(true, true));
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)} with {@code
   * allowSalesPrice}, {@code includeChildren}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean, boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPriceIncludeChildren_thenReturnMoney2() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    Money salePrice = new Money();
    orderItemImpl.setSalePrice(salePrice);
    orderItemImpl.setRetailPrice(new Money());

    // Act and Assert
    assertEquals(salePrice, orderItemImpl.getPriceBeforeAdjustments(true, true));
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)} with {@code allowSalesPrice}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(null);

    // Act
    Money actualPriceBeforeAdjustments = orderItemImpl.getPriceBeforeAdjustments(true);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualPriceBeforeAdjustments.abs();
    assertEquals(actualPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualPriceBeforeAdjustments.zero();
    assertEquals(actualPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)} with {@code allowSalesPrice}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPrice_thenCallsGetCurrencyCode2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());

    // Act
    Money actualPriceBeforeAdjustments = orderItemImpl.getPriceBeforeAdjustments(false);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualPriceBeforeAdjustments.abs();
    assertEquals(actualPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualPriceBeforeAdjustments.zero();
    assertEquals(actualPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)} with {@code allowSalesPrice}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPrice_thenReturnMoney() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    Money salePrice = new Money();
    orderItemImpl.setSalePrice(salePrice);
    orderItemImpl.setRetailPrice(null);

    // Act and Assert
    assertEquals(salePrice, orderItemImpl.getPriceBeforeAdjustments(true));
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)} with {@code allowSalesPrice}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPrice_thenReturnMoney2() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    Money salePrice = new Money();
    orderItemImpl.setSalePrice(salePrice);
    orderItemImpl.setRetailPrice(new Money());

    // Act and Assert
    assertEquals(salePrice, orderItemImpl.getPriceBeforeAdjustments(true));
  }

  /**
   * Test {@link OrderItemImpl#removeAllAdjustments()}.
   *
   * <p>Method under test: {@link OrderItemImpl#removeAllAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderItemImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.removeAllAdjustments();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.price);
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    assertSame(bigDecimal, orderItemImpl.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAveragePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getRetailPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getSalePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTaxablePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalPrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#removeAllAdjustments()}.
   *
   * <p>Method under test: {@link OrderItemImpl#removeAllAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderItemImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.removeAllAdjustments();

    // Assert that nothing has changed
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderItemImpl.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAveragePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getRetailPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getSalePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTaxablePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalPrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#removeAllAdjustments()}.
   *
   * <p>Method under test: {@link OrderItemImpl#removeAllAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderItemImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(null);
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.removeAllAdjustments();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.getAdjustmentValue().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.getAveragePrice().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.getPrice().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.getTaxablePrice().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.price);
    assertEquals(new BigDecimal("60.00"), orderItemImpl.getTotalPrice().getAmount());
    BigDecimal expectedAmount = orderItemImpl.salePrice;
    assertSame(expectedAmount, orderItemImpl.getSalePrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#removeAllAdjustments()}.
   *
   * <p>Method under test: {@link OrderItemImpl#removeAllAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderItemImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments4() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.removeAllAdjustments();

    // Assert that nothing has changed
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.price);
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#removeAllAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#removeAllAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderItemImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments_givenOrderItemImplSalePriceIsNull() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(null);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.removeAllAdjustments();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.price);
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    assertSame(bigDecimal, orderItemImpl.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAveragePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getRetailPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getSalePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTaxablePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalPrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#isTaxable()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Taxable is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#isTaxable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderItemImpl.isTaxable()"})
  public void testIsTaxable_givenOrderItemImplTaxableIsFalse_thenReturnFalse() {
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
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setTaxable(false);

    // Act and Assert
    assertFalse(orderItemImpl.isTaxable());
  }

  /**
   * Test {@link OrderItemImpl#isTaxable()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Taxable is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#isTaxable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderItemImpl.isTaxable()"})
  public void testIsTaxable_givenOrderItemImplTaxableIsTrue_thenReturnTrue() {
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
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setTaxable(true);

    // Act and Assert
    assertTrue(orderItemImpl.isTaxable());
  }

  /**
   * Test {@link OrderItemImpl#isTaxable()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#isTaxable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderItemImpl.isTaxable()"})
  public void testIsTaxable_givenOrderItemImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new OrderItemImpl().isTaxable());
  }

  /**
   * Test {@link OrderItemImpl#isDiscountingAllowed()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       OrderItemQualifierImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.isDiscountingAllowed()"})
  public void testIsDiscountingAllowed_givenAuditableCreatedByIsSerialVersionUID() {
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

    // Act and Assert
    assertFalse(orderItemImpl.isDiscountingAllowed());
  }

  /**
   * Test {@link OrderItemImpl#isDiscountingAllowed()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.isDiscountingAllowed()"})
  public void testIsDiscountingAllowed_givenOrderItemImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new OrderItemImpl().isDiscountingAllowed());
  }

  /**
   * Test {@link OrderItemImpl#getAveragePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getAveragePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getAveragePrice()"})
  public void testGetAveragePrice_givenOrderItemImplOrderIsNull_order_thenReturnMoney() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);

    // Act and Assert
    assertEquals(finalPrice, orderItemImpl.getAveragePrice());
  }

  /**
   * Test {@link OrderItemImpl#getAveragePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Quantity is six.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getAveragePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getAveragePrice()"})
  public void testGetAveragePrice_givenOrderItemImplQuantityIsSix() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setOrder(order);
    orderItemImpl.setPrice(new Money());

    // Act
    Money actualAveragePrice = orderItemImpl.getAveragePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Currency currency = actualAveragePrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualAveragePrice.abs();
    assertEquals(actualAveragePrice, actualAbsResult);
    Money actualZeroResult = actualAveragePrice.zero();
    assertEquals(actualAveragePrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getAveragePrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getAveragePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getAveragePrice()"})
  public void testGetAveragePrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setPrice(new Money());

    // Act
    Money actualAveragePrice = orderItemImpl.getAveragePrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualAveragePrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualAveragePrice.abs();
    assertEquals(actualAveragePrice, actualAbsResult);
    Money actualZeroResult = actualAveragePrice.zero();
    assertEquals(actualAveragePrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getAverageAdjustmentValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getAverageAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getAverageAdjustmentValue()"})
  public void testGetAverageAdjustmentValue_givenOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setQuantity(1);

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getAverageAdjustmentValue());
  }

  /**
   * Test {@link OrderItemImpl#getAverageAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getAverageAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getAverageAdjustmentValue()"})
  public void testGetAverageAdjustmentValue_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setQuantity(1);

    // Act
    Money actualAverageAdjustmentValue = orderItemImpl.getAverageAdjustmentValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualAverageAdjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualAverageAdjustmentValue.abs();
    assertEquals(actualAverageAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualAverageAdjustmentValue.zero();
    assertEquals(actualAverageAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getTotalAdjustmentValue(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link NullOrderImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalAdjustmentValue(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalAdjustmentValue(boolean)"})
  public void testGetTotalAdjustmentValueWithBoolean_givenOrderItemImplOrderIsNullOrderImpl() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getTotalAdjustmentValue(true));
  }

  /**
   * Test {@link OrderItemImpl#getTotalAdjustmentValue(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalAdjustmentValue(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalAdjustmentValue(boolean)"})
  public void testGetTotalAdjustmentValueWithBoolean_givenOrderItemImplOrderIsNull_order() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getTotalAdjustmentValue(true));
  }

  /**
   * Test {@link OrderItemImpl#getTotalAdjustmentValue(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalAdjustmentValue(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalAdjustmentValue(boolean)"})
  public void testGetTotalAdjustmentValueWithBoolean_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalAdjustmentValue = orderItemImpl.getTotalAdjustmentValue(true);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualTotalAdjustmentValue.abs();
    assertEquals(actualTotalAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualTotalAdjustmentValue.zero();
    assertEquals(actualTotalAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getTotalAdjustmentValue(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalAdjustmentValue(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalAdjustmentValue(boolean)"})
  public void testGetTotalAdjustmentValueWithBoolean_whenFalse_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalAdjustmentValue = orderItemImpl.getTotalAdjustmentValue(false);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualTotalAdjustmentValue.abs();
    assertEquals(actualTotalAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualTotalAdjustmentValue.zero();
    assertEquals(actualTotalAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getTotalAdjustmentValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link NullOrderImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalAdjustmentValue()"})
  public void testGetTotalAdjustmentValue_givenOrderItemImplOrderIsNullOrderImpl() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getTotalAdjustmentValue());
  }

  /**
   * Test {@link OrderItemImpl#getTotalAdjustmentValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalAdjustmentValue()"})
  public void testGetTotalAdjustmentValue_givenOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getTotalAdjustmentValue());
  }

  /**
   * Test {@link OrderItemImpl#getTotalAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalAdjustmentValue()"})
  public void testGetTotalAdjustmentValue_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalAdjustmentValue = orderItemImpl.getTotalAdjustmentValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualTotalAdjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualTotalAdjustmentValue.abs();
    assertEquals(actualTotalAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualTotalAdjustmentValue.zero();
    assertEquals(actualTotalAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue()}.
   *
   * <p>Method under test: {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getFutureCreditTotalAdjustmentValue()"})
  public void testGetFutureCreditTotalAdjustmentValue() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);

    // Act
    Money actualFutureCreditTotalAdjustmentValue =
        orderItemImpl.getFutureCreditTotalAdjustmentValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualFutureCreditTotalAdjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualFutureCreditTotalAdjustmentValue.abs();
    assertEquals(actualFutureCreditTotalAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditTotalAdjustmentValue.zero();
    assertEquals(actualFutureCreditTotalAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getFutureCreditTotalAdjustmentValue(boolean)"})
  public void testGetFutureCreditTotalAdjustmentValueWithBoolean() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getFutureCreditTotalAdjustmentValue(true));
  }

  /**
   * Test {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getFutureCreditTotalAdjustmentValue(boolean)"})
  public void testGetFutureCreditTotalAdjustmentValueWithBoolean2() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getFutureCreditTotalAdjustmentValue(true));
  }

  /**
   * Test {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getFutureCreditTotalAdjustmentValue(boolean)"})
  public void testGetFutureCreditTotalAdjustmentValueWithBoolean_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);

    // Act
    Money actualFutureCreditTotalAdjustmentValue =
        orderItemImpl.getFutureCreditTotalAdjustmentValue(true);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualFutureCreditTotalAdjustmentValue.abs();
    assertEquals(actualFutureCreditTotalAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditTotalAdjustmentValue.zero();
    assertEquals(actualFutureCreditTotalAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getFutureCreditTotalAdjustmentValue(boolean)"})
  public void testGetFutureCreditTotalAdjustmentValueWithBoolean_whenFalse() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);

    // Act
    Money actualFutureCreditTotalAdjustmentValue =
        orderItemImpl.getFutureCreditTotalAdjustmentValue(false);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualFutureCreditTotalAdjustmentValue.abs();
    assertEquals(actualFutureCreditTotalAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditTotalAdjustmentValue.zero();
    assertEquals(actualFutureCreditTotalAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link NullOrderImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getFutureCreditTotalAdjustmentValue()"})
  public void testGetFutureCreditTotalAdjustmentValue_givenOrderItemImplOrderIsNullOrderImpl() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getFutureCreditTotalAdjustmentValue());
  }

  /**
   * Test {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getFutureCreditTotalAdjustmentValue()"})
  public void testGetFutureCreditTotalAdjustmentValue_givenOrderItemImplOrderIsNull_order() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertEquals(Money.ZERO, orderItemImpl.getFutureCreditTotalAdjustmentValue());
  }

  /**
   * Test {@link OrderItemImpl#getTotalPrice(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) RetailPrice is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice(boolean)"})
  public void testGetTotalPriceWithBoolean_givenOrderItemImplRetailPriceIsMoney() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice(true);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertEquals(actualTotalPrice, absResult2.abs());
    Money zeroResult = actualTotalPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertEquals(actualTotalPrice, absResult3.abs());
    Money zeroResult2 = absResult.zero();
    assertEquals(actualTotalPrice, zeroResult2.abs());
    Money zeroResult3 = zeroResult.zero();
    assertEquals(actualTotalPrice, zeroResult3.abs());
    assertEquals(actualTotalPrice, absResult2.zero());
    assertEquals(actualTotalPrice, absResult3.zero());
    assertEquals(actualTotalPrice, zeroResult2.zero());
    assertEquals(actualTotalPrice, zeroResult3.zero());
  }

  /**
   * Test {@link OrderItemImpl#getTotalPrice(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) RetailPrice is {@link Money#Money()}.
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice(boolean)"})
  public void testGetTotalPriceWithBoolean_givenOrderItemImplRetailPriceIsMoney_whenFalse() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice(false);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertEquals(actualTotalPrice, absResult2.abs());
    Money zeroResult = actualTotalPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertEquals(actualTotalPrice, absResult3.abs());
    Money zeroResult2 = absResult.zero();
    assertEquals(actualTotalPrice, zeroResult2.abs());
    Money zeroResult3 = zeroResult.zero();
    assertEquals(actualTotalPrice, zeroResult3.abs());
    assertEquals(actualTotalPrice, absResult2.zero());
    assertEquals(actualTotalPrice, absResult3.zero());
    assertEquals(actualTotalPrice, zeroResult2.zero());
    assertEquals(actualTotalPrice, zeroResult3.zero());
  }

  /**
   * Test {@link OrderItemImpl#getTotalPrice(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice(boolean)"})
  public void testGetTotalPriceWithBoolean_givenOrderItemImplSalePriceIsMoney() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice(true);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Money actualAbsResult = actualTotalPrice.abs();
    assertEquals(actualTotalPrice, actualAbsResult);
    Money actualZeroResult = actualTotalPrice.zero();
    assertEquals(actualTotalPrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getTotalPrice(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@link
   *       Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice(boolean)"})
  public void testGetTotalPriceWithBoolean_givenOrderItemImplSalePriceIsMoneyWithAmountIsTen() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice(false);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertEquals(actualTotalPrice, absResult2.abs());
    Money zeroResult = actualTotalPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertEquals(actualTotalPrice, absResult3.abs());
    Money zeroResult2 = absResult.zero();
    assertEquals(actualTotalPrice, zeroResult2.abs());
    Money zeroResult3 = zeroResult.zero();
    assertEquals(actualTotalPrice, zeroResult3.abs());
    assertEquals(actualTotalPrice, absResult2.zero());
    assertEquals(actualTotalPrice, absResult3.zero());
    assertEquals(actualTotalPrice, zeroResult2.zero());
    assertEquals(actualTotalPrice, zeroResult3.zero());
  }

  /**
   * Test {@link OrderItemImpl#getTotalPrice(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@link Money#Money()}.
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice(boolean)"})
  public void testGetTotalPriceWithBoolean_givenOrderItemImplSalePriceIsMoney_whenFalse() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice(false);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Money actualAbsResult = actualTotalPrice.abs();
    assertEquals(actualTotalPrice, actualAbsResult);
    Money actualZeroResult = actualTotalPrice.zero();
    assertEquals(actualTotalPrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getTotalPrice(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#price}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice(boolean)"})
  public void testGetTotalPriceWithBoolean_thenReturnAbsAbsAbsAmountIsOrderItemImplPrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice(true);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.price;
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalPrice.zero();
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
   * Test {@link OrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@link
   *       Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_givenOrderItemImplSalePriceIsMoneyWithAmountIsTen() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalPrice.zero();
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
   * Test {@link OrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#price}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_thenReturnAbsAbsAbsAmountIsOrderItemImplPrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.price;
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalPrice.zero();
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
   * Test {@link OrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#retailPrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_thenReturnAbsAbsAbsAmountIsOrderItemImplRetailPrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalPrice.zero();
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
   * Test {@link OrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalPrice.zero();
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
   * Test {@link OrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = orderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalPrice.zero();
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
   * Test {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}.
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPriceBeforeAdjustments(boolean)"})
  public void testGetTotalPriceBeforeAdjustments() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(new Money());

    // Act
    Money actualTotalPriceBeforeAdjustments = orderItemImpl.getTotalPriceBeforeAdjustments(true);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Money actualAbsResult = actualTotalPriceBeforeAdjustments.abs();
    assertEquals(actualTotalPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualTotalPriceBeforeAdjustments.zero();
    assertEquals(actualTotalPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPriceBeforeAdjustments(boolean)"})
  public void testGetTotalPriceBeforeAdjustments_givenOrderItemImplSalePriceIsNull() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setSalePrice(null);
    Money retailPrice = new Money();
    orderItemImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, orderItemImpl.getTotalPriceBeforeAdjustments(true));
  }

  /**
   * Test {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPriceBeforeAdjustments(boolean)"})
  public void testGetTotalPriceBeforeAdjustments_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(null);

    // Act
    Money actualTotalPriceBeforeAdjustments = orderItemImpl.getTotalPriceBeforeAdjustments(true);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualTotalPriceBeforeAdjustments.abs();
    assertEquals(actualTotalPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualTotalPriceBeforeAdjustments.zero();
    assertEquals(actualTotalPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPriceBeforeAdjustments(boolean)"})
  public void testGetTotalPriceBeforeAdjustments_thenReturnMoney() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    Money salePrice = new Money();
    orderItemImpl.setSalePrice(salePrice);
    orderItemImpl.setRetailPrice(null);

    // Act and Assert
    assertEquals(salePrice, orderItemImpl.getTotalPriceBeforeAdjustments(true));
  }

  /**
   * Test {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPriceBeforeAdjustments(boolean)"})
  public void testGetTotalPriceBeforeAdjustments_thenReturnMoney2() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    Money salePrice = new Money();
    orderItemImpl.setSalePrice(salePrice);
    orderItemImpl.setRetailPrice(new Money());

    // Act and Assert
    assertEquals(salePrice, orderItemImpl.getTotalPriceBeforeAdjustments(true));
  }

  /**
   * Test {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPriceBeforeAdjustments(boolean)"})
  public void testGetTotalPriceBeforeAdjustments_whenFalse_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setOrder(order);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());

    // Act
    Money actualTotalPriceBeforeAdjustments = orderItemImpl.getTotalPriceBeforeAdjustments(false);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualTotalPriceBeforeAdjustments.abs();
    assertEquals(actualTotalPriceBeforeAdjustments, actualAbsResult);
    Money actualZeroResult = actualTotalPriceBeforeAdjustments.zero();
    assertEquals(actualTotalPriceBeforeAdjustments, actualZeroResult);
  }

  /**
   * Test {@link OrderItemImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link OrderItemImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderItemImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(orderItemImpl.getMainEntityName());
  }

  /**
   * Test {@link OrderItemImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl}
   *       (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderItemImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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

    // Act and Assert
    assertNull(orderItemImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderItemImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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

    // Act and Assert
    assertNull(orderItemImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_givenOrderItemImplAuditableIsAuditable_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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

    // Act and Assert
    assertNull(orderItemImpl.convertToMoney(null));
  }

  /**
   * Test {@link OrderItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency Symbol is {@code $}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnCurrencySymbolIsDollarSign() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setOrder(order);

    // Act
    Money actualConvertToMoneyResult = orderItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    assertEquals(finalPrice, actualConvertToMoneyResult.abs().zero());
    assertEquals(finalPrice, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) OrderItemAttributes is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_givenOrderItemImplOrderItemAttributesIsHashMap() {
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
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setCandidateItemOffers(null);
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setChildOrderItems(null);

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    Money zeroResult = actualCloneResult.getAverageAdjustmentValue().zero();
    assertEquals(finalPrice, zeroResult.zero().abs().abs().abs());
    Money zeroResult2 = zeroResult.abs().zero().zero();
    assertEquals(finalPrice, zeroResult2.abs());
    assertEquals(finalPrice, zeroResult2.zero());
    assertSame(((OrderItemImpl) actualCloneResult).salePrice, zeroResult2.getAmount());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then ChildOrderItems first return {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenChildOrderItemsFirstReturnBundleOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    when(bundleOrderItemImpl.clone()).thenReturn(bundleOrderItemImpl2);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
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
    orderItemImpl.setCandidateItemOffers(null);
    orderItemImpl.setOrderItemAttributes(null);
    orderItemImpl.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    verify(bundleOrderItemImpl).clone();
    List<OrderItem> childOrderItems2 = actualCloneResult.getChildOrderItems();
    assertEquals(1, childOrderItems2.size());
    OrderItem getResult = childOrderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    assertSame(bundleOrderItemImpl2, getResult);
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then ChildOrderItems first return {@link OrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenChildOrderItemsFirstReturnOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("clone");
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

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(orderItemImpl);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable);
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();
    orderItemImpl2.setCandidateItemOffers(null);
    orderItemImpl2.setOrderItemAttributes(null);
    orderItemImpl2.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = orderItemImpl2.clone();

    // Assert
    List<OrderItem> childOrderItems2 = actualCloneResult.getChildOrderItems();
    assertEquals(1, childOrderItems2.size());
    assertTrue(childOrderItems2.get(0) instanceof OrderItemImpl);
    assertTrue(actualCloneResult instanceof OrderItemImpl);
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return AverageAdjustmentValue zero zero abs abs abs is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenReturnAverageAdjustmentValueZeroZeroAbsAbsAbsIsMoney() {
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
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setCandidateItemOffers(null);
    orderItemImpl.setOrderItemAttributes(null);
    orderItemImpl.setChildOrderItems(null);

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    Money zeroResult = actualCloneResult.getAverageAdjustmentValue().zero();
    assertEquals(finalPrice, zeroResult.zero().abs().abs().abs());
    Money zeroResult2 = zeroResult.abs().zero().zero();
    assertEquals(finalPrice, zeroResult2.abs());
    assertEquals(finalPrice, zeroResult2.zero());
    assertSame(((OrderItemImpl) actualCloneResult).salePrice, zeroResult2.getAmount());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return AverageAdjustmentValue zero zero abs abs abs is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenReturnAverageAdjustmentValueZeroZeroAbsAbsAbsIsMoney2() {
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
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setCandidateItemOffers(null);
    orderItemImpl.setOrderItemAttributes(null);
    orderItemImpl.setChildOrderItems(new ArrayList<>());

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    Money zeroResult = actualCloneResult.getAverageAdjustmentValue().zero();
    assertEquals(finalPrice, zeroResult.zero().abs().abs().abs());
    Money zeroResult2 = zeroResult.abs().zero().zero();
    assertEquals(finalPrice, zeroResult2.abs());
    assertEquals(finalPrice, zeroResult2.zero());
    assertSame(((OrderItemImpl) actualCloneResult).salePrice, zeroResult2.getAmount());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return AverageAdjustmentValue zero zero abs abs abs is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenReturnAverageAdjustmentValueZeroZeroAbsAbsAbsIsMoney3() {
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
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(null);
    orderItemImpl.setChildOrderItems(null);

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    Money zeroResult = actualCloneResult.getAverageAdjustmentValue().zero();
    assertEquals(finalPrice, zeroResult.zero().abs().abs().abs());
    Money zeroResult2 = zeroResult.abs().zero().zero();
    assertEquals(finalPrice, zeroResult2.abs());
    assertEquals(finalPrice, zeroResult2.zero());
    assertSame(((OrderItemImpl) actualCloneResult).salePrice, zeroResult2.getAmount());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return CandidateItemOffers size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenReturnCandidateItemOffersSizeIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    candidateItemOffers.add(new CandidateItemOfferImpl());

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
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
    orderItemImpl.setCandidateItemOffers(candidateItemOffers);
    orderItemImpl.setOrderItemAttributes(null);
    orderItemImpl.setChildOrderItems(null);

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    List<CandidateItemOffer> candidateItemOffers2 = actualCloneResult.getCandidateItemOffers();
    assertEquals(1, candidateItemOffers2.size());
    CandidateItemOffer getResult = candidateItemOffers2.get(0);
    assertTrue(getResult instanceof CandidateItemOfferImpl);
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getDiscountedPrice());
    assertNull(getResult.getOffer());
    assertSame(actualCloneResult, getResult.getOrderItem());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return OrderItemAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenReturnOrderItemAttributesSizeIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    HashMap<String, OrderItemAttribute> orderItemAttributes = new HashMap<>();
    orderItemAttributes.put("clone", new OrderItemAttributeImpl());

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
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
    orderItemImpl.setCandidateItemOffers(null);
    orderItemImpl.setOrderItemAttributes(orderItemAttributes);
    orderItemImpl.setChildOrderItems(null);

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    Map<String, OrderItemAttribute> orderItemAttributes2 =
        actualCloneResult.getOrderItemAttributes();
    assertEquals(1, orderItemAttributes2.size());
    OrderItemAttribute getResult = orderItemAttributes2.get(null);
    assertTrue(getResult instanceof OrderItemAttributeImpl);
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    assertNull(getResult.getId());
    assertNull(getResult.toString());
    assertNull(getResult.getName());
    assertNull(getResult.getValue());
    assertSame(actualCloneResult, getResult.getOrderItem());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl2);
    assertEquals(orderItemImpl.hashCode(), orderItemImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
    orderItemImpl.setId(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl2);
    assertEquals(orderItemImpl.hashCode(), orderItemImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(null);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl2);
    assertEquals(orderItemImpl.hashCode(), orderItemImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl);
    int expectedHashCodeResult = orderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemImpl.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    orderItemImpl.setId(2L);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
    orderItemImpl.setGiftWrapOrderItem(null);
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
    orderItemImpl.setGiftWrapOrderItem(mock(GiftWrapOrderItemImpl.class));
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
    orderItemImpl.setId(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BUNDLE);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(new OrderItemType());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new DiscreteOrderItemImpl());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(null);
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(mock(PersonalMessageImpl.class));
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
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
    orderItemImpl.setId(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
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
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money(10.0d));
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
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
    orderItemImpl.setId(null);
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
    orderItemImpl.setQuantity(0);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
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
    orderItemImpl.setId(null);
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
    orderItemImpl.setRetailPrice(null);
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
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
    orderItemImpl.setId(null);
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
    orderItemImpl.setRetailPrice(new Money(10.0d));
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
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
    orderItemImpl.setId(null);
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
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(orderItemImpl, null);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(orderItemImpl, "Different type to OrderItemImpl");
  }

  /**
   * Test {@link OrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenOrderItemImpl()
      throws CloneNotSupportedException {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).finalizePrice();
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(bundleOrderItemImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItem> actualCreateOrRetrieveCopyInstanceResult =
        orderItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(bundleOrderItemImpl).finalizePrice();
    verify(bundleOrderItemImpl).setCategory(isNull());
    verify(bundleOrderItemImpl).setGiftWrapOrderItem(isNull());
    verify(bundleOrderItemImpl).setName(null);
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(bundleOrderItemImpl).setOrderItemType(isNull());
    verify(bundleOrderItemImpl).setParentOrderItem(isNull());
    verify(bundleOrderItemImpl).setPersonalMessage(isNull());
    verify(bundleOrderItemImpl).setQuantity(0);
    verify(bundleOrderItemImpl).setTaxable(true);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Taxable is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenOrderItemImplTaxableIsTrue()
      throws CloneNotSupportedException {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setTaxable(true);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).finalizePrice();
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(bundleOrderItemImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItem> actualCreateOrRetrieveCopyInstanceResult =
        orderItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(bundleOrderItemImpl).finalizePrice();
    verify(bundleOrderItemImpl).setCategory(isNull());
    verify(bundleOrderItemImpl).setGiftWrapOrderItem(isNull());
    verify(bundleOrderItemImpl).setName(null);
    verify(bundleOrderItemImpl).setOrder(isNull());
    verify(bundleOrderItemImpl).setOrderItemType(isNull());
    verify(bundleOrderItemImpl).setParentOrderItem(isNull());
    verify(bundleOrderItemImpl).setPersonalMessage(isNull());
    verify(bundleOrderItemImpl).setQuantity(0);
    verify(bundleOrderItemImpl).setTaxable(true);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#setBaseSalePrice(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCallsSetBaseSalePrice()
      throws CloneNotSupportedException {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setProductBundle(Mockito.<ProductBundle>any());
    doNothing().when(bundleOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(bundleOrderItemImpl).finalizePrice();
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(bundleOrderItemImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItem> actualCreateOrRetrieveCopyInstanceResult =
        orderItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context, atLeast(1)).createOrRetrieveCopyInstance(Mockito.<Object>any());
    verify(bundleOrderItemImpl).setBaseRetailPrice(isNull());
    verify(bundleOrderItemImpl).setBaseSalePrice(isNull());
    verify(bundleOrderItemImpl).setProductBundle(isNull());
    verify(bundleOrderItemImpl).setSku(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).finalizePrice();
    verify(bundleOrderItemImpl, atLeast(1)).setCategory(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setGiftWrapOrderItem(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setName(null);
    verify(bundleOrderItemImpl, atLeast(1)).setOrder(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setOrderItemType(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setParentOrderItem(Mockito.<OrderItem>any());
    verify(bundleOrderItemImpl, atLeast(1)).setPersonalMessage(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setQuantity(0);
    verify(bundleOrderItemImpl, atLeast(1)).setTaxable(true);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowRuntimeException()
      throws CloneNotSupportedException {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new RuntimeException())
        .when(bundleOrderItemImpl)
        .setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).finalizePrice();
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(bundleOrderItemImpl, false));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderItemImpl.createOrRetrieveCopyInstance(context));
    verify(context, atLeast(1)).createOrRetrieveCopyInstance(Mockito.<Object>any());
    verify(bundleOrderItemImpl).setBaseRetailPrice(isNull());
    verify(bundleOrderItemImpl).finalizePrice();
    verify(bundleOrderItemImpl, atLeast(1)).setCategory(isNull());
    verify(bundleOrderItemImpl).setGiftWrapOrderItem(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setName(null);
    verify(bundleOrderItemImpl, atLeast(1)).setOrder(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setOrderItemType(isNull());
    verify(bundleOrderItemImpl).setParentOrderItem(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setPersonalMessage(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setQuantity(0);
    verify(bundleOrderItemImpl, atLeast(1)).setTaxable(true);
  }
}
