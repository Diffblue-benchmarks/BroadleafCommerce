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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
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
public class OrderItemPriceDetailImplDiffblueTest {
  @Autowired private OrderItemPriceDetailImpl orderItemPriceDetailImpl;

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   *
   * <p>Method under test: {@link
   * OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments()"
  })
  public void testGetFutureCreditOrderItemPriceDetailAdjustments() {
    // Arrange
    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act and Assert
    assertTrue(orderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments()"
  })
  public void testGetFutureCreditOrderItemPriceDetailAdjustments_givenOrderItemPriceDetailImpl() {
    // Arrange, Act and Assert
    assertTrue(orderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments()"
  })
  public void testGetFutureCreditOrderItemPriceDetailAdjustments_thenReturnSizeIsOne() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act
    List<OrderItemPriceDetailAdjustment> actualFutureCreditOrderItemPriceDetailAdjustments =
        orderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments();

    // Assert
    verify(orderItemPriceDetailAdjustmentImpl).isFutureCredit();
    assertEquals(1, actualFutureCreditOrderItemPriceDetailAdjustments.size());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrency()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       OrderItemQualifierImpl#serialVersionUID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getCurrency()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafCurrency OrderItemPriceDetailImpl.getCurrency()"})
  public void testGetCurrency_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl.setOrderItem(orderItem);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);

    // Act and Assert
    assertNull(orderItemPriceDetailImpl.getCurrency());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getAdjustmentValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getAdjustmentValue()"})
  public void testGetAdjustmentValue_givenOrderItemImplOrderIsNull_order_thenReturnMoney() {
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
    Money finalPrice = new Money();
    orderItem.setPrice(finalPrice);
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(finalPrice, orderItemPriceDetailImpl.getAdjustmentValue());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then calls {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getAdjustmentValue()"})
  public void testGetAdjustmentValue_thenCallsIsFutureCredit() {
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
    orderItem.setOrder(order);
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

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.isFutureCredit()).thenReturn(true);
    doNothing()
        .when(orderItemPriceDetailAdjustmentImpl)
        .setOrderItemPriceDetail(Mockito.<OrderItemPriceDetail>any());
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualAdjustmentValue = orderItemPriceDetailImpl.getAdjustmentValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(orderItemPriceDetailAdjustmentImpl).isFutureCredit();
    verify(orderItemPriceDetailAdjustmentImpl).setOrderItemPriceDetail(isNull());
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
   * Test {@link OrderItemPriceDetailImpl#getAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getAdjustmentValue()"})
  public void testGetAdjustmentValue_thenReturnCurrencyDisplayNameIsBritishPound() {
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
    orderItem.setOrder(order);
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualAdjustmentValue = orderItemPriceDetailImpl.getAdjustmentValue();

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
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}.
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditAdjustmentValue()"})
  public void testGetFutureCreditAdjustmentValue() {
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
    orderItem.setOrder(order);
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

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditAdjustmentValue =
        orderItemPriceDetailImpl.getFutureCreditAdjustmentValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualFutureCreditAdjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualFutureCreditAdjustmentValue.abs();
    assertEquals(actualFutureCreditAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditAdjustmentValue.zero();
    assertEquals(actualFutureCreditAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditAdjustmentValue()"})
  public void testGetFutureCreditAdjustmentValue_thenReturnCurrencyDisplayNameIsBritishPound() {
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
    orderItem.setOrder(order);
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditAdjustmentValue =
        orderItemPriceDetailImpl.getFutureCreditAdjustmentValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualFutureCreditAdjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualFutureCreditAdjustmentValue.abs();
    assertEquals(actualFutureCreditAdjustmentValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditAdjustmentValue.zero();
    assertEquals(actualFutureCreditAdjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditAdjustmentValue()"})
  public void testGetFutureCreditAdjustmentValue_thenReturnMoney() {
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
    Money finalPrice = new Money();
    orderItem.setPrice(finalPrice);
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(finalPrice, orderItemPriceDetailImpl.getFutureCreditAdjustmentValue());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getRoundingModeForAdj()}.
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getRoundingModeForAdj()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RoundingMode OrderItemPriceDetailImpl.getRoundingModeForAdj()"})
  public void testGetRoundingModeForAdj() {
    // Arrange, Act and Assert
    assertEquals(RoundingMode.HALF_EVEN, orderItemPriceDetailImpl.getRoundingModeForAdj());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustmentValue()"})
  public void testGetTotalAdjustmentValue_givenOrderItemImplOrderIsNull_order_thenReturnMoney() {
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
    Money finalPrice = new Money();
    orderItem.setPrice(finalPrice);
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(finalPrice, orderItemPriceDetailImpl.getTotalAdjustmentValue());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then calls {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustmentValue()"})
  public void testGetTotalAdjustmentValue_thenCallsIsFutureCredit() {
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
    orderItem.setOrder(order);
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

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.isFutureCredit()).thenReturn(true);
    doNothing()
        .when(orderItemPriceDetailAdjustmentImpl)
        .setOrderItemPriceDetail(Mockito.<OrderItemPriceDetail>any());
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentValue = orderItemPriceDetailImpl.getTotalAdjustmentValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(orderItemPriceDetailAdjustmentImpl).isFutureCredit();
    verify(orderItemPriceDetailAdjustmentImpl).setOrderItemPriceDetail(isNull());
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
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustmentValue()"})
  public void testGetTotalAdjustmentValue_thenReturnCurrencyDisplayNameIsBritishPound() {
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
    orderItem.setOrder(order);
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentValue = orderItemPriceDetailImpl.getTotalAdjustmentValue();

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
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}.
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue()"})
  public void testGetFutureCreditTotalAdjustmentValue() {
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
    orderItem.setOrder(order);
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditTotalAdjustmentValue =
        orderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue();

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
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}.
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue()"})
  public void testGetFutureCreditTotalAdjustmentValue2() {
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
    orderItem.setOrder(order);
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

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditTotalAdjustmentValue =
        orderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue();

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
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue()"})
  public void testGetFutureCreditTotalAdjustmentValue_thenReturnMoney() {
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
    Money finalPrice = new Money();
    orderItem.setPrice(finalPrice);
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(finalPrice, orderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderItemPriceDetailImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_givenArrayListAddOrderItemPriceDetailImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(new OrderItemPriceDetailImpl());

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
    orderItem.setOrderItemPriceDetails(orderItemPriceDetails);
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItem.setPrice(finalPrice);
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(finalPrice, orderItemPriceDetailImpl.getTotalAdjustedPrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderItemPriceDetailImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_givenArrayListAddOrderItemPriceDetailImpl2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(new OrderItemPriceDetailImpl());
    orderItemPriceDetails.add(new OrderItemPriceDetailImpl());

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
    orderItem.setOrderItemPriceDetails(orderItemPriceDetails);
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItem.setPrice(finalPrice);
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(finalPrice, orderItemPriceDetailImpl.getTotalAdjustedPrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_givenOrderItemImplOrderIsNull_order_thenReturnMoney() {
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
    Money finalPrice = new Money();
    orderItem.setPrice(finalPrice);
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(finalPrice, orderItemPriceDetailImpl.getTotalAdjustedPrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@link
   *       Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_givenOrderItemImplSalePriceIsMoneyWithAmountIsTen() {
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
    Money finalPrice = new Money();
    orderItem.setPrice(finalPrice);
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money(10.0d));
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(finalPrice, orderItemPriceDetailImpl.getTotalAdjustedPrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   *
   * <ul>
   *   <li>Then calls {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_thenCallsIsFutureCredit() {
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
    orderItem.setOrder(order);
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

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.isFutureCredit()).thenReturn(true);
    doNothing()
        .when(orderItemPriceDetailAdjustmentImpl)
        .setOrderItemPriceDetail(Mockito.<OrderItemPriceDetail>any());
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl.getTotalAdjustedPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(orderItemPriceDetailAdjustmentImpl).isFutureCredit();
    verify(orderItemPriceDetailAdjustmentImpl).setOrderItemPriceDetail(isNull());
    verify(order, atLeast(1)).getCurrency();
    Currency currency = actualTotalAdjustedPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualTotalAdjustedPrice.abs();
    assertEquals(actualTotalAdjustedPrice, actualAbsResult);
    Money actualZeroResult = actualTotalAdjustedPrice.zero();
    assertEquals(actualTotalAdjustedPrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
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
    orderItem.setOrder(order);
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl.getTotalAdjustedPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Currency currency = actualTotalAdjustedPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualTotalAdjustedPrice.abs();
    assertEquals(actualTotalAdjustedPrice, actualAbsResult);
    Money actualZeroResult = actualTotalAdjustedPrice.zero();
    assertEquals(actualTotalAdjustedPrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getUseSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getUseSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemPriceDetailImpl.getUseSalePrice()"})
  public void testGetUseSalePrice_givenOrderItemPriceDetailImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(orderItemPriceDetailImpl.getUseSalePrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getUseSalePrice()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getUseSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemPriceDetailImpl.getUseSalePrice()"})
  public void testGetUseSalePrice_thenReturnFalse() {
    // Arrange
    orderItemPriceDetailImpl.setUseSalePrice(false);

    // Act and Assert
    assertFalse(orderItemPriceDetailImpl.getUseSalePrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl}
   *       (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String OrderItemPriceDetailImpl.getCurrencyCode()"})
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
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
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
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertNull(orderItemPriceDetailImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String OrderItemPriceDetailImpl.getCurrencyCode()"})
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
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
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
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertNull(orderItemPriceDetailImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderItemPriceDetailImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new OrderItemPriceDetailImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItemPriceDetail> actualCreateOrRetrieveCopyInstanceResult =
        orderItemPriceDetailImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderItemPriceDetailImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(orderItemPriceDetailImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItemPriceDetail> actualCreateOrRetrieveCopyInstanceResult =
        orderItemPriceDetailImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemPriceDetailImpl}
   *   <li>{@link OrderItemPriceDetailImpl#setId(Long)}
   *   <li>{@link OrderItemPriceDetailImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemPriceDetailImpl#setOrderItemAdjustments(List)}
   *   <li>{@link OrderItemPriceDetailImpl#setQuantity(int)}
   *   <li>{@link OrderItemPriceDetailImpl#getId()}
   *   <li>{@link OrderItemPriceDetailImpl#getOrderItem()}
   *   <li>{@link OrderItemPriceDetailImpl#getOrderItemPriceDetailAdjustments()}
   *   <li>{@link OrderItemPriceDetailImpl#getQuantity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailImpl.<init>()",
    "Long OrderItemPriceDetailImpl.getId()",
    "OrderItem OrderItemPriceDetailImpl.getOrderItem()",
    "List OrderItemPriceDetailImpl.getOrderItemPriceDetailAdjustments()",
    "int OrderItemPriceDetailImpl.getQuantity()",
    "void OrderItemPriceDetailImpl.setId(Long)",
    "void OrderItemPriceDetailImpl.setOrderItem(OrderItem)",
    "void OrderItemPriceDetailImpl.setOrderItemAdjustments(List)",
    "void OrderItemPriceDetailImpl.setQuantity(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemPriceDetailImpl actualOrderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    actualOrderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemPriceDetailImpl.setOrderItem(orderItem);
    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    actualOrderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);
    actualOrderItemPriceDetailImpl.setQuantity(1);
    Long actualId = actualOrderItemPriceDetailImpl.getId();
    OrderItem actualOrderItem = actualOrderItemPriceDetailImpl.getOrderItem();
    List<OrderItemPriceDetailAdjustment> actualOrderItemPriceDetailAdjustments =
        actualOrderItemPriceDetailImpl.getOrderItemPriceDetailAdjustments();

    // Assert
    assertEquals(1, actualOrderItemPriceDetailImpl.getQuantity());
    assertTrue(actualOrderItemPriceDetailAdjustments.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItemPriceDetailAdjustments, actualOrderItemPriceDetailAdjustments);
    assertSame(orderItem, actualOrderItem);
  }
}
