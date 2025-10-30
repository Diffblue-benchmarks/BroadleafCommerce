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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
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

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FulfillmentGroupItemImplDiffblueTest {
  @Autowired
  private FulfillmentGroupItemImpl fulfillmentGroupItemImpl;

  /**
   * Test {@link FulfillmentGroupItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenOrderItemImplOrderIsNull_order_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    Money retailPrice = new Money();
    orderItem.setRetailPrice(retailPrice);
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(retailPrice, fulfillmentGroupItemImpl2.getRetailPrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link BundleOrderItemImpl} (default constructor) {@link OrderItemImpl#salePrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenReturnAbsAbsAbsAmountIsBundleOrderItemImplSalePrice() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);

    // Act
    Money actualRetailPrice = fulfillmentGroupItemImpl2.getRetailPrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualRetailPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualRetailPrice.zero();
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
   * Test {@link FulfillmentGroupItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);

    // Act
    Money actualRetailPrice = fulfillmentGroupItemImpl2.getRetailPrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualRetailPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    assertEquals(actualRetailPrice, actualRetailPrice.abs());
    assertEquals(actualRetailPrice, actualRetailPrice.zero());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenAuditableCreatedByIsSerialVersionUID_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    Money retailPrice = new Money();
    orderItem.setRetailPrice(retailPrice);
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(retailPrice, fulfillmentGroupItemImpl2.getSalePrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnNull() {
    // Arrange
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
    assertNull(fulfillmentGroupItemImpl2.getSalePrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getPrice()"})
  public void testGetPrice_givenAuditableCreatedByIsSerialVersionUID_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    Money retailPrice = new Money();
    orderItem.setRetailPrice(retailPrice);
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(retailPrice, fulfillmentGroupItemImpl2.getPrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getPrice()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getPrice()"})
  public void testGetPrice_thenReturnNull() {
    // Arrange
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
    assertNull(fulfillmentGroupItemImpl2.getPrice());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return abs abs zero is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_givenOrderImplCurrencyIsNull_thenReturnAbsAbsZeroIsMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    Money proratedOrderAdjustment = new Money();
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);

    // Act
    Money actualConvertToMoneyResult = fulfillmentGroupItemImpl2.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Money absResult = actualConvertToMoneyResult.abs();
    assertEquals(proratedOrderAdjustment, absResult.abs().zero());
    assertEquals(proratedOrderAdjustment, absResult.zero());
    assertEquals(proratedOrderAdjustment, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_givenOrderImplCurrencyIsNull_whenNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertNull(fulfillmentGroupItemImpl2.convertToMoney(null));
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs zero is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnAbsAbsZeroIsZero() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);

    // Act
    Money actualConvertToMoneyResult = fulfillmentGroupItemImpl2.convertToMoney(new BigDecimal("2.3"));

    // Assert
    verify(orderItem).getOrder();
    Money money = actualConvertToMoneyResult.ZERO;
    Money absResult = actualConvertToMoneyResult.abs();
    assertEquals(money, absResult.abs().zero());
    assertEquals(money, absResult.zero());
    assertEquals(money, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemAmount()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getTotalItemAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemAmount()"})
  public void testGetTotalItemAmount_givenFulfillmentGroupItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupItemImpl()).getTotalItemAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemAmount()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getTotalItemAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemAmount()"})
  public void testGetTotalItemAmount_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    Money proratedOrderAdjustment = new Money();
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(proratedOrderAdjustment, fulfillmentGroupItemImpl2.getTotalItemAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#setTotalItemAmount(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#setTotalItemAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalItemAmount(Money)"})
  public void testSetTotalItemAmount() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    Money amount = new Money();

    // Act
    fulfillmentGroupItemImpl2.setTotalItemAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupItemImpl2.totalItemAmount);
    BigDecimal bigDecimal = fulfillmentGroupItemImpl2.totalItemAmount;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupItemImpl} (default constructor) {@link FulfillmentGroupItemImpl#totalItemAmount} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#setTotalItemAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalItemAmount(Money)"})
  public void testSetTotalItemAmount_thenFulfillmentGroupItemImplTotalItemAmountIsNull() {
    // Arrange
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

    // Act
    fulfillmentGroupItemImpl2.setTotalItemAmount(null);

    // Assert
    assertNull(fulfillmentGroupItemImpl2.totalItemAmount);
    assertNull(fulfillmentGroupItemImpl2.getTotalItemAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount()"})
  public void testGetProratedOrderAdjustmentAmount_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    Money amount = new Money();
    fulfillmentGroupItemImpl2.setTotalItemAmount(amount);
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(amount, fulfillmentGroupItemImpl2.getProratedOrderAdjustmentAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getProratedOrderAdjustmentAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount()"})
  public void testGetProratedOrderAdjustmentAmount_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupItemImpl()).getProratedOrderAdjustmentAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#setProratedOrderAdjustmentAmount(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#setProratedOrderAdjustmentAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(Money)"})
  public void testSetProratedOrderAdjustmentAmount() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    Money proratedOrderAdjustment = new Money();

    // Act
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupItemImpl2.proratedOrderAdjustment);
    BigDecimal bigDecimal = fulfillmentGroupItemImpl2.proratedOrderAdjustment;
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
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#setProratedOrderAdjustmentAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(Money)"})
  public void testSetProratedOrderAdjustmentAmount2() {
    // Arrange
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

    // Act
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(null);

    // Assert
    assertNull(fulfillmentGroupItemImpl2.proratedOrderAdjustment);
    assertNull(fulfillmentGroupItemImpl2.getProratedOrderAdjustmentAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemTaxableAmount()"})
  public void testGetTotalItemTaxableAmount_givenFulfillmentGroupItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupItemImpl()).getTotalItemTaxableAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getTotalItemTaxableAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalItemTaxableAmount()"})
  public void testGetTotalItemTaxableAmount_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    Money proratedOrderAdjustment = new Money();
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(proratedOrderAdjustment, fulfillmentGroupItemImpl2.getTotalItemTaxableAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#setTotalItemTaxableAmount(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#setTotalItemTaxableAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalItemTaxableAmount(Money)"})
  public void testSetTotalItemTaxableAmount() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    Money taxableAmount = new Money();

    // Act
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(taxableAmount);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupItemImpl2.totalItemTaxableAmount);
    BigDecimal bigDecimal = fulfillmentGroupItemImpl2.totalItemTaxableAmount;
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
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#setTotalItemTaxableAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalItemTaxableAmount(Money)"})
  public void testSetTotalItemTaxableAmount2() {
    // Arrange
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

    // Act
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(null);

    // Assert
    assertNull(fulfillmentGroupItemImpl2.totalItemTaxableAmount);
    assertNull(fulfillmentGroupItemImpl2.getTotalItemTaxableAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getStatus()}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroupStatusType FulfillmentGroupItemImpl.getStatus()"})
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupItemImpl()).getStatus());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#setStatus(FulfillmentGroupStatusType)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupItemImpl} (default constructor) Status is {@link FulfillmentGroupStatusType#CANCELLED} {@link FulfillmentGroupStatusType#CANCELLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#setStatus(FulfillmentGroupStatusType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType)"})
  public void testSetStatus_thenFulfillmentGroupItemImplStatusIsCancelledCancelled() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    FulfillmentGroupStatusType status = FulfillmentGroupStatusType.CANCELLED;

    // Act
    fulfillmentGroupItemImpl2.setStatus(status);

    // Assert
    FulfillmentGroupStatusType expectedStatus = status.CANCELLED;
    assertSame(expectedStatus, fulfillmentGroupItemImpl2.getStatus());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());

    // Act
    fulfillmentGroupItemImpl2.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl2.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl2.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations2() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl2.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl2.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl2.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations3() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(mock(FulfillmentGroupItem.class));

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl2.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl2.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl2.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations4() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl2.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl2.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl2.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations5() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();
    fulfillmentGroupItem.setOrderItem(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(fulfillmentGroupItem);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl2.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl2.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl2.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor) addFulfillmentGroupItem {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations_givenFulfillmentGroupImplAddFulfillmentGroupItemNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(null);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl2.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl2.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl2.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations_givenFulfillmentGroupItemImpl() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupItemImpl2.removeAssociations();

    // Assert that nothing has changed
    assertNull(fulfillmentGroupItemImpl2.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl2.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor) Id is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations_givenFulfillmentGroupItemImplIdIsSerialVersionUID() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act
    fulfillmentGroupItemImpl2.removeAssociations();

    // Assert
    assertNull(fulfillmentGroupItemImpl2.getFulfillmentGroup());
    assertNull(fulfillmentGroupItemImpl2.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#removeAssociations()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#removeAssociations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.removeAssociations()"})
  public void testRemoveAssociations_thenThrowRuntimeException() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenThrow(new RuntimeException("foo"));

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> fulfillmentGroupItemImpl2.removeAssociations());
    verify(fulfillmentGroup).getFulfillmentGroupItems();
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalTax()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getTotalTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalTax()"})
  public void testGetTotalTax_givenFulfillmentGroupItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupItemImpl()).getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getTotalTax()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getTotalTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupItemImpl.getTotalTax()"})
  public void testGetTotalTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setOrder(order);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    Money proratedOrderAdjustment = new Money();
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertEquals(proratedOrderAdjustment, fulfillmentGroupItemImpl2.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#setTotalTax(Money)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupItemImpl} (default constructor) {@link FulfillmentGroupItemImpl#totalTax} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#setTotalTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalTax(Money)"})
  public void testSetTotalTax_thenFulfillmentGroupItemImplTotalTaxIsBigDecimalWith000() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    Money totalTax = new Money();

    // Act
    fulfillmentGroupItemImpl2.setTotalTax(totalTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupItemImpl2.totalTax);
    BigDecimal bigDecimal = fulfillmentGroupItemImpl2.totalTax;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupItemImpl} (default constructor) {@link FulfillmentGroupItemImpl#totalTax} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#setTotalTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.setTotalTax(Money)"})
  public void testSetTotalTax_thenFulfillmentGroupItemImplTotalTaxIsNull() {
    // Arrange
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

    // Act
    fulfillmentGroupItemImpl2.setTotalTax(null);

    // Assert
    assertNull(fulfillmentGroupItemImpl2.totalTax);
    assertNull(fulfillmentGroupItemImpl2.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Then return {@code GBP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FulfillmentGroupItemImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_thenReturnGbp() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getCurrencyCode()).thenReturn("GBP");

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act
    String actualCurrencyCode = fulfillmentGroupItemImpl2.getCurrencyCode();

    // Assert
    verify(fulfillmentGroup).getCurrencyCode();
    assertEquals("GBP", actualCurrencyCode);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return Price Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_givenOrderImplCurrencyIsNull_thenReturnPriceAmountIsBigDecimalWith000() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setTotalItemAmount(null);
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(null);

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl2.clone();

    // Assert
    OrderItem orderItem2 = actualCloneResult.getOrderItem();
    assertTrue(orderItem2 instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = actualCloneResult.getPrice().getAmount();
    assertEquals(expectedAmount, amount);
    assertSame(amount, actualCloneResult.getRetailPrice().getAmount());
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).baseRetailPrice);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).baseSalePrice);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).retailPrice);
    assertSame(amount, ((BundleOrderItemImpl) orderItem2).salePrice);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   * <ul>
   *   <li>Then return Price is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_thenReturnPriceIsNull() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl2.clone();

    // Assert
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
    assertNull(actualCloneResult.getPrice());
    assertNull(actualCloneResult.getFulfillmentGroup());
    assertNull(actualCloneResult.getStatus());
    assertEquals(0, actualCloneResult.getQuantity());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupItemImpl#totalItemTaxableAmount} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_thenReturnTotalItemTaxableAmountIsBigDecimalWith000() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    Money proratedOrderAdjustment = new Money();
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setTotalItemAmount(null);
    fulfillmentGroupItemImpl2.setOrderItem(orderItem);
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl2.clone();

    // Assert
    OrderItem orderItem2 = actualCloneResult.getOrderItem();
    assertTrue(orderItem2 instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
    assertEquals(new BigDecimal("0.00"), ((FulfillmentGroupItemImpl) actualCloneResult).totalItemTaxableAmount);
    assertEquals(proratedOrderAdjustment, actualCloneResult.getTotalItemTaxableAmount());
    BigDecimal bigDecimal = ((FulfillmentGroupItemImpl) actualCloneResult).totalItemTaxableAmount;
    assertSame(bigDecimal, actualCloneResult.getPrice().getAmount());
    assertSame(bigDecimal, actualCloneResult.getRetailPrice().getAmount());
    assertSame(bigDecimal, ((BundleOrderItemImpl) orderItem2).baseRetailPrice);
    assertSame(bigDecimal, ((BundleOrderItemImpl) orderItem2).baseSalePrice);
    assertSame(bigDecimal, ((BundleOrderItemImpl) orderItem2).retailPrice);
    assertSame(bigDecimal, ((BundleOrderItemImpl) orderItem2).salePrice);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse FulfillmentGroupItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FulfillmentGroupItem> actualCreateOrRetrieveCopyInstanceResult = fulfillmentGroupItemImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroupItem)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupItemImpl} (default constructor) Taxes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroupItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroupItem)"})
  public void testCloneTaxDetails_thenFulfillmentGroupItemImplTaxesSizeIsOne() throws CloneNotSupportedException {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    TaxDetailImpl taxDetailImpl2 = new TaxDetailImpl();
    when(taxDetailImpl.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(taxDetailImpl2, true));

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setTaxes(taxes);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    FulfillmentGroupItemImpl cloned = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupItemImpl2.cloneTaxDetails(context, cloned);

    // Assert
    verify(taxDetailImpl).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    List<TaxDetail> taxes2 = cloned.getTaxes();
    assertEquals(1, taxes2.size());
    assertSame(taxDetailImpl2, taxes2.get(0));
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}.
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.getHasProratedOrderAdjustments()"})
  public void testGetHasProratedOrderAdjustments() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());

    // Act and Assert
    assertFalse(fulfillmentGroupItemImpl2.getHasProratedOrderAdjustments());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.getHasProratedOrderAdjustments()"})
  public void testGetHasProratedOrderAdjustments_givenFulfillmentGroupItemImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupItemImpl()).getHasProratedOrderAdjustments());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#getHasProratedOrderAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.getHasProratedOrderAdjustments()"})
  public void testGetHasProratedOrderAdjustments_thenReturnTrue() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money(10.0d));

    // Act and Assert
    assertTrue(fulfillmentGroupItemImpl2.getHasProratedOrderAdjustments());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link FulfillmentGroupItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.equals(Object)", "int FulfillmentGroupItemImpl.hashCode()"})
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
    int expectedHashCodeResult = fulfillmentGroupItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link FulfillmentGroupItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.equals(Object)", "int FulfillmentGroupItemImpl.hashCode()"})
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
    int expectedHashCodeResult = fulfillmentGroupItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link FulfillmentGroupItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.equals(Object)", "int FulfillmentGroupItemImpl.hashCode()"})
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
    int expectedHashCodeResult = fulfillmentGroupItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link FulfillmentGroupItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.equals(Object)", "int FulfillmentGroupItemImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.equals(Object)", "int FulfillmentGroupItemImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.equals(Object)", "int FulfillmentGroupItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    fulfillmentGroupItemImpl.setId(null);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.equals(Object)", "int FulfillmentGroupItemImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.equals(Object)", "int FulfillmentGroupItemImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupItemImpl.equals(Object)", "int FulfillmentGroupItemImpl.hashCode()"})
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
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupItemImpl.<init>()",
      "FulfillmentGroup FulfillmentGroupItemImpl.getFulfillmentGroup()", "Long FulfillmentGroupItemImpl.getId()",
      "OrderItem FulfillmentGroupItemImpl.getOrderItem()", "int FulfillmentGroupItemImpl.getQuantity()",
      "List FulfillmentGroupItemImpl.getTaxes()", "void FulfillmentGroupItemImpl.setFulfillmentGroup(FulfillmentGroup)",
      "void FulfillmentGroupItemImpl.setId(Long)", "void FulfillmentGroupItemImpl.setOrderItem(OrderItem)",
      "void FulfillmentGroupItemImpl.setQuantity(int)", "void FulfillmentGroupItemImpl.setTaxes(List)"})
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
