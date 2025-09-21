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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.DeferredOperation;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FulfillmentGroupItemImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentGroupItemImplDiffblueTest {
  @Autowired private FulfillmentGroupItemImpl fulfillmentGroupItemImpl;

  /**
   * Test {@link FulfillmentGroupItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    Money proratedOrderAdjustment = new Money();
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(proratedOrderAdjustment, fulfillmentGroupItemImpl.getRetailPrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenOrderItemImplOrderIsNull_order_thenReturnMoney() {
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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(finalPrice, fulfillmentGroupItemImpl.getRetailPrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    Money actualRetailPrice = fulfillmentGroupItemImpl.getRetailPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualRetailPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualRetailPrice.abs();
    assertEquals(actualRetailPrice, actualAbsResult);
    Money actualZeroResult = actualRetailPrice.zero();
    assertEquals(actualRetailPrice, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenReturnCurrencyDisplayNameIsBritishPound2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(order);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act
    Money actualRetailPrice = fulfillmentGroupItemImpl.getRetailPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualRetailPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualRetailPrice.abs();
    assertEquals(actualRetailPrice, actualAbsResult);
    Money actualZeroResult = actualRetailPrice.zero();
    assertEquals(actualRetailPrice, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenReturnNull() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setOrderItem(new DynamicPriceDiscreteOrderItemImpl());

    // Act and Assert
    assertNull(fulfillmentGroupItemImpl.getRetailPrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenOrderItemImplOrderIsNull_order_thenReturnMoney() {
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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(finalPrice, fulfillmentGroupItemImpl.getSalePrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@link
   *       Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenOrderItemImplSalePriceIsMoneyWithAmountIsTen() {
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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(finalPrice, fulfillmentGroupItemImpl.getSalePrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnCurrencyDisplayNameIsBritishPound() {
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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act
    Money actualSalePrice = fulfillmentGroupItemImpl.getSalePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    Currency currency = actualSalePrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualSalePrice.abs();
    assertEquals(actualSalePrice, actualAbsResult);
    Money actualZeroResult = actualSalePrice.zero();
    assertEquals(actualSalePrice, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnNull() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertNull(fulfillmentGroupItemImpl.getSalePrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getPrice()"})
  public void testGetPrice_givenOrderItemImplOrderIsNull_order_thenReturnMoney() {
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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(finalPrice, fulfillmentGroupItemImpl.getPrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Price is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getPrice()"})
  public void testGetPrice_givenOrderItemImplPriceIsNull_thenReturnMoney() {
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
    orderItem.setPrice(null);
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    Money retailPrice = new Money();
    orderItem.setRetailPrice(retailPrice);
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(retailPrice, fulfillmentGroupItemImpl.getPrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getPrice()"})
  public void testGetPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act
    Money actualPrice = fulfillmentGroupItemImpl.getPrice();

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
   * Test {@link FulfillmentGroupItemImpl#getPrice()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getPrice()"})
  public void testGetPrice_thenReturnNull() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertNull(fulfillmentGroupItemImpl.getPrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_givenOrderImplCurrencyIsNull_whenNull_thenReturnNull() {
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
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act and Assert
    assertNull(fulfillmentGroupItemImpl.convertToMoney(null));
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnCurrencyDisplayNameIsBritishPound() {
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

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setCurrency(currency);

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
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    Money actualConvertToMoneyResult =
        fulfillmentGroupItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualConvertToMoneyResult.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money zeroResult = actualConvertToMoneyResult.zero();
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = actualConvertToMoneyResult.abs().zero();
    assertEquals(zeroResult2, zeroResult3.abs());
    assertEquals(zeroResult2, zeroResult3.zero());
    assertEquals(zeroResult2, zeroResult2);
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency Symbol is {@code $}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.convertToMoney(BigDecimal)"})
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    orderItem.setBaseRetailPrice(baseRetailPrice);
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
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    Money actualConvertToMoneyResult =
        fulfillmentGroupItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    assertEquals(baseRetailPrice, actualConvertToMoneyResult.abs().zero());
    assertEquals(baseRetailPrice, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemAmount()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getTotalItemAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemAmount()"})
  public void testGetTotalItemAmount_givenFulfillmentGroupItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupItemImpl.getTotalItemAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemAmount()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getTotalItemAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemAmount()"})
  public void testGetTotalItemAmount_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    Money amount = new Money();
    fulfillmentGroupItemImpl.setTotalItemAmount(amount);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(amount, fulfillmentGroupItemImpl.getTotalItemAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemAmount()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getTotalItemAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemAmount()"})
  public void testGetTotalItemAmount_thenReturnCurrencyDisplayNameIsBritishPound() {
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

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setCurrency(currency);

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
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalItemAmount = fulfillmentGroupItemImpl.getTotalItemAmount();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotalItemAmount.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalItemAmount.abs();
    assertEquals(actualTotalItemAmount, actualAbsResult);
    Money actualZeroResult = actualTotalItemAmount.zero();
    assertEquals(actualTotalItemAmount, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#setTotalItemAmount(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#setTotalItemAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalItemAmount(Money)"})
  public void testSetTotalItemAmount() {
    // Arrange
    Money amount = new Money();

    // Act
    fulfillmentGroupItemImpl.setTotalItemAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupItemImpl.totalItemAmount);
    BigDecimal bigDecimal = fulfillmentGroupItemImpl.totalItemAmount;
    Money absResult = amount.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = amount.zero();
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
   * Test {@link FulfillmentGroupItemImpl#setTotalItemAmount(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupItemImpl} {@link FulfillmentGroupItemImpl#totalItemAmount} is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#setTotalItemAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalItemAmount(Money)"})
  public void testSetTotalItemAmount_thenFulfillmentGroupItemImplTotalItemAmountIsNull() {
    // Arrange and Act
    fulfillmentGroupItemImpl.setTotalItemAmount(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupItemImpl.totalItemAmount);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount()"})
  public void testGetProratedOrderAdjustmentAmount_thenReturnCurrencyDisplayNameIsBritishPound() {
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

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setCurrency(currency);

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
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    Money actualProratedOrderAdjustmentAmount =
        fulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualProratedOrderAdjustmentAmount.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualProratedOrderAdjustmentAmount.abs();
    assertEquals(actualProratedOrderAdjustmentAmount, actualAbsResult);
    Money actualZeroResult = actualProratedOrderAdjustmentAmount.zero();
    assertEquals(actualProratedOrderAdjustmentAmount, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount()"})
  public void testGetProratedOrderAdjustmentAmount_thenReturnMoney() {
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
    Money proratedOrderAdjustment = new Money();
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(
        proratedOrderAdjustment, fulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount()"})
  public void testGetProratedOrderAdjustmentAmount_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#setProratedOrderAdjustmentAmount(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#setProratedOrderAdjustmentAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(Money)"})
  public void testSetProratedOrderAdjustmentAmount() {
    // Arrange
    Money proratedOrderAdjustment = new Money();

    // Act
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupItemImpl.proratedOrderAdjustment);
    BigDecimal bigDecimal = fulfillmentGroupItemImpl.proratedOrderAdjustment;
    Money absResult = proratedOrderAdjustment.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = proratedOrderAdjustment.zero();
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
   * Test {@link FulfillmentGroupItemImpl#setProratedOrderAdjustmentAmount(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#setProratedOrderAdjustmentAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(Money)"})
  public void testSetProratedOrderAdjustmentAmount2() {
    // Arrange and Act
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupItemImpl.proratedOrderAdjustment);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemTaxableAmount()"})
  public void testGetTotalItemTaxableAmount_givenFulfillmentGroupItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupItemImpl.getTotalItemTaxableAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemTaxableAmount()"})
  public void testGetTotalItemTaxableAmount_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    Money taxableAmount = new Money();
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(taxableAmount);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(taxableAmount, fulfillmentGroupItemImpl.getTotalItemTaxableAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemTaxableAmount()"})
  public void testGetTotalItemTaxableAmount_thenReturnCurrencyDisplayNameIsBritishPound() {
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

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setCurrency(currency);

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
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalItemTaxableAmount = fulfillmentGroupItemImpl.getTotalItemTaxableAmount();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotalItemTaxableAmount.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalItemTaxableAmount.abs();
    assertEquals(actualTotalItemTaxableAmount, actualAbsResult);
    Money actualZeroResult = actualTotalItemTaxableAmount.zero();
    assertEquals(actualTotalItemTaxableAmount, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#setTotalItemTaxableAmount(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#setTotalItemTaxableAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalItemTaxableAmount(Money)"})
  public void testSetTotalItemTaxableAmount() {
    // Arrange
    Money taxableAmount = new Money();

    // Act
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(taxableAmount);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupItemImpl.totalItemTaxableAmount);
    BigDecimal bigDecimal = fulfillmentGroupItemImpl.totalItemTaxableAmount;
    Money absResult = taxableAmount.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = taxableAmount.zero();
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
   * Test {@link FulfillmentGroupItemImpl#setTotalItemTaxableAmount(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#setTotalItemTaxableAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalItemTaxableAmount(Money)"})
  public void testSetTotalItemTaxableAmount2() {
    // Arrange and Act
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupItemImpl.totalItemTaxableAmount);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getStatus()}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupStatusType FulfillmentGroupItemImpl.getStatus()"})
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupItemImpl.getStatus());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#setStatus(FulfillmentGroupStatusType)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentGroupStatusType#CANCELLED}.
   *   <li>Then {@link FulfillmentGroupItemImpl} Status is {@link
   *       FulfillmentGroupStatusType#CANCELLED}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#setStatus(FulfillmentGroupStatusType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType)"})
  public void testSetStatus_whenCancelled_thenFulfillmentGroupItemImplStatusIsCancelled() {
    // Arrange and Act
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);

    // Assert
    assertSame(FulfillmentGroupStatusType.CANCELLED, fulfillmentGroupItemImpl.getStatus());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations() {
    // Arrange
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations2() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations3() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();
    fulfillmentGroupItem.setOrderItem(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(fulfillmentGroupItem);
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations4() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(mock(FulfillmentGroupItem.class));
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations5() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations6() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations7() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();
    fulfillmentGroupItem.setOrderItem(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(fulfillmentGroupItem);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor) addFulfillmentGroupItem {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations_givenFulfillmentGroupImplAddFulfillmentGroupItemNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(null);
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations_givenFulfillmentGroupItemImpl() {
    // Arrange and Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert that nothing has changed
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor) Id is {@link
   *       OrderItemQualifierImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations_givenFulfillmentGroupItemImplIdIsSerialVersionUID() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor) Id is {@link
   *       OrderItemQualifierImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations_givenFulfillmentGroupItemImplIdIsSerialVersionUID2() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();
    fulfillmentGroupItem.setId(OrderItemQualifierImpl.serialVersionUID);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(fulfillmentGroupItem);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations_thenThrowRuntimeException() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenThrow(new RuntimeException());
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> fulfillmentGroupItemImpl.removeAssociations());
    verify(fulfillmentGroup).getFulfillmentGroupItems();
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalTax()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getTotalTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalTax()"})
  public void testGetTotalTax_givenFulfillmentGroupItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupItemImpl.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalTax()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getTotalTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalTax()"})
  public void testGetTotalTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setOrder(order);
    Money totalTax = new Money();
    fulfillmentGroupItemImpl.setTotalTax(totalTax);
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertEquals(totalTax, fulfillmentGroupItemImpl.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalTax()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getTotalTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalTax()"})
  public void testGetTotalTax_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    order.setCurrency(currency);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setOrder(order);
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    Money actualTotalTax = fulfillmentGroupItemImpl.getTotalTax();

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
   * Test {@link FulfillmentGroupItemImpl#setTotalTax(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupItemImpl} {@link FulfillmentGroupItemImpl#totalTax} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#setTotalTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalTax(Money)"})
  public void testSetTotalTax_thenFulfillmentGroupItemImplTotalTaxIsBigDecimalWith000() {
    // Arrange
    Money totalTax = new Money();

    // Act
    fulfillmentGroupItemImpl.setTotalTax(totalTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupItemImpl.totalTax);
    BigDecimal bigDecimal = fulfillmentGroupItemImpl.totalTax;
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
   * Test {@link FulfillmentGroupItemImpl#setTotalTax(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupItemImpl} {@link FulfillmentGroupItemImpl#totalTax} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#setTotalTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalTax(Money)"})
  public void testSetTotalTax_whenNull_thenFulfillmentGroupItemImplTotalTaxIsNull() {
    // Arrange and Act
    fulfillmentGroupItemImpl.setTotalTax(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupItemImpl.totalTax);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Then return {@code GBP}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FulfillmentGroupItemImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_thenReturnGbp() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getCurrencyCode()).thenReturn("GBP");

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    String actualCurrencyCode = fulfillmentGroupItemImpl.getCurrencyCode();

    // Assert
    verify(fulfillmentGroup).getCurrencyCode();
    assertEquals("GBP", actualCurrencyCode);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrency} {@link BroadleafCurrency#getCurrencyCode()} return {@code
   *       GBP}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_givenBroadleafCurrencyGetCurrencyCodeReturnGbp() {
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

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setCurrency(currency);

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
    fulfillmentGroupItemImpl.setTotalItemAmount(null);
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl.clone();

    // Assert
    verify(currency).getCurrencyCode();
    assertTrue(actualCloneResult.getOrderItem() instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor) FulfillmentGroup is {@link
   *       FulfillmentGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_givenFulfillmentGroupItemImplFulfillmentGroupIsFulfillmentGroupImpl() {
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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTotalItemAmount(null);
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(null);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl.clone();

    // Assert
    OrderItem orderItem2 = actualCloneResult.getOrderItem();
    assertTrue(orderItem2 instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
    assertTrue(orderItem2.getOrder() instanceof OrderImpl);
    BigDecimal amount = actualCloneResult.getPrice().getAmount();
    assertEquals(new BigDecimal("0.00"), amount);
    assertSame(amount, actualCloneResult.getRetailPrice().getAmount());
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).baseRetailPrice);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).baseSalePrice);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).price);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).retailPrice);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).salePrice);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return TotalItemTaxableAmount is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_givenOrderImplCurrencyIsNull_thenReturnTotalItemTaxableAmountIsMoney() {
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
    fulfillmentGroupItemImpl.setTotalItemAmount(null);
    Money taxableAmount = new Money();
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(taxableAmount);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
    assertEquals(taxableAmount, actualCloneResult.getTotalItemTaxableAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupItemImpl#totalItemTaxableAmount} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_thenReturnTotalItemTaxableAmountIsNull() {
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
    fulfillmentGroupItemImpl.setTotalItemAmount(null);
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(null);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl.clone();

    // Assert
    OrderItem orderItem2 = actualCloneResult.getOrderItem();
    assertTrue(orderItem2 instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
    assertTrue(orderItem2.getOrder() instanceof OrderImpl);
    assertNull(((FulfillmentGroupItemImpl) actualCloneResult).totalItemTaxableAmount);
    assertNull(actualCloneResult.getTotalItemTaxableAmount());
    BigDecimal amount = actualCloneResult.getPrice().getAmount();
    assertEquals(new BigDecimal("0.00"), amount);
    assertSame(amount, actualCloneResult.getRetailPrice().getAmount());
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).baseRetailPrice);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).baseSalePrice);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).price);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).retailPrice);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).salePrice);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_thenThrowRuntimeException() {
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

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenThrow(new RuntimeException());

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
    order.setCurrency(currency);

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
    fulfillmentGroupItemImpl.setTotalItemAmount(null);
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> fulfillmentGroupItemImpl.clone());
    verify(currency).getCurrencyCode();
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse FulfillmentGroupItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new FulfillmentGroupItemImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FulfillmentGroupItem> actualCreateOrRetrieveCopyInstanceResult =
        fulfillmentGroupItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#cloneTaxDetails(MultiTenantCopyContext,
   * FulfillmentGroupItem)}.
   *
   * <ul>
   *   <li>Given {@link DeferredOperation}.
   *   <li>Then calls {@link MultiTenantCopyContext#addDeferredOperation(DeferredOperation)}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#cloneTaxDetails(MultiTenantCopyContext,
   * FulfillmentGroupItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupItemImpl.cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroupItem)"
  })
  public void testCloneTaxDetails_givenDeferredOperation_thenCallsAddDeferredOperation()
      throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    doNothing().when(context).addDeferredOperation(Mockito.<DeferredOperation>any());
    context.addDeferredOperation(mock(DeferredOperation.class));

    // Act
    fulfillmentGroupItemImpl.cloneTaxDetails(context, new FulfillmentGroupItemImpl());

    // Assert
    verify(context).addDeferredOperation(isA(DeferredOperation.class));
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#cloneTaxDetails(MultiTenantCopyContext,
   * FulfillmentGroupItem)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupItemImpl} (default constructor) Taxes size is one.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#cloneTaxDetails(MultiTenantCopyContext,
   * FulfillmentGroupItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupItemImpl.cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroupItem)"
  })
  public void testCloneTaxDetails_thenFulfillmentGroupItemImplTaxesSizeIsOne()
      throws CloneNotSupportedException {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    TaxDetailImpl taxDetailImpl2 = new TaxDetailImpl();
    when(taxDetailImpl.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(taxDetailImpl2, true));

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());
    FulfillmentGroupItemImpl cloned = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupItemImpl.cloneTaxDetails(context, cloned);

    // Assert
    verify(taxDetailImpl).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    List<TaxDetail> taxes2 = cloned.getTaxes();
    assertEquals(1, taxes2.size());
    assertSame(taxDetailImpl2, taxes2.get(0));
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.getHasProratedOrderAdjustments()"})
  public void testGetHasProratedOrderAdjustments() {
    // Arrange
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());

    // Act and Assert
    assertFalse(fulfillmentGroupItemImpl.getHasProratedOrderAdjustments());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.getHasProratedOrderAdjustments()"})
  public void testGetHasProratedOrderAdjustments_givenFulfillmentGroupItemImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentGroupItemImpl.getHasProratedOrderAdjustments());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.getHasProratedOrderAdjustments()"})
  public void testGetHasProratedOrderAdjustments_thenReturnTrue() {
    // Arrange
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money(10.0d));

    // Act and Assert
    assertTrue(fulfillmentGroupItemImpl.getHasProratedOrderAdjustments());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
    assertEquals(fulfillmentGroupItemImpl.hashCode(), fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(null);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
    assertEquals(fulfillmentGroupItemImpl.hashCode(), fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(null);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
    assertEquals(fulfillmentGroupItemImpl.hashCode(), fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(null);
    fulfillmentGroupItemImpl.setOrderItem(null);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(null);
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
    assertEquals(fulfillmentGroupItemImpl.hashCode(), fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl);
    int expectedHashCodeResult = fulfillmentGroupItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupItemImpl.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(2L);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(null);
    fulfillmentGroupItemImpl.setOrderItem(new DiscreteOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(null);
    fulfillmentGroupItemImpl.setOrderItem(null);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, null);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, "Different type to FulfillmentGroupItemImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FulfillmentGroupItemImpl}
   *   <li>{@link FulfillmentGroupItemImpl#setFulfillmentGroup(FulfillmentGroup)}
   *   <li>{@link FulfillmentGroupItemImpl#setId(Long)}
   *   <li>{@link FulfillmentGroupItemImpl#setOrderItem(OrderItem)}
   *   <li>{@link FulfillmentGroupItemImpl#setQuantity(int)}
   *   <li>{@link FulfillmentGroupItemImpl#setTaxes(List)}
   *   <li>{@link FulfillmentGroupItemImpl#getFulfillmentGroup()}
   *   <li>{@link FulfillmentGroupItemImpl#getId()}
   *   <li>{@link FulfillmentGroupItemImpl#getOrderItem()}
   *   <li>{@link FulfillmentGroupItemImpl#getQuantity()}
   *   <li>{@link FulfillmentGroupItemImpl#getTaxes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupItemImpl.<init>()",
    "FulfillmentGroup FulfillmentGroupItemImpl.getFulfillmentGroup()",
    "Long FulfillmentGroupItemImpl.getId()",
    "OrderItem FulfillmentGroupItemImpl.getOrderItem()",
    "int FulfillmentGroupItemImpl.getQuantity()",
    "List FulfillmentGroupItemImpl.getTaxes()",
    "void FulfillmentGroupItemImpl.setFulfillmentGroup(FulfillmentGroup)",
    "void FulfillmentGroupItemImpl.setId(Long)",
    "void FulfillmentGroupItemImpl.setOrderItem(OrderItem)",
    "void FulfillmentGroupItemImpl.setQuantity(int)",
    "void FulfillmentGroupItemImpl.setTaxes(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentGroupItemImpl actualFulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    actualFulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);
    actualFulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualFulfillmentGroupItemImpl.setOrderItem(orderItem);
    actualFulfillmentGroupItemImpl.setQuantity(1);
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    actualFulfillmentGroupItemImpl.setTaxes(taxes);
    FulfillmentGroup actualFulfillmentGroup = actualFulfillmentGroupItemImpl.getFulfillmentGroup();
    Long actualId = actualFulfillmentGroupItemImpl.getId();
    OrderItem actualOrderItem = actualFulfillmentGroupItemImpl.getOrderItem();
    int actualQuantity = actualFulfillmentGroupItemImpl.getQuantity();
    List<TaxDetail> actualTaxes = actualFulfillmentGroupItemImpl.getTaxes();

    // Assert
    assertEquals(1, actualQuantity);
    assertTrue(actualTaxes.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(taxes, actualTaxes);
    assertSame(orderItem, actualOrderItem);
    assertSame(fulfillmentGroup, actualFulfillmentGroup);
  }
}
