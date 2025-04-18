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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.core.offer.domain.OrderItemAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.domain.ProratedOrderItemAdjustment;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderItemPriceDetailImplDiffblueTest {
  @Autowired
  private OrderItemPriceDetailImpl orderItemPriceDetailImpl;

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments()"})
  public void testGetFutureCreditOrderItemPriceDetailAdjustments() {
    // Arrange
    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl2.setQuantity(1);
    orderItemPriceDetailImpl2.setUseSalePrice(true);
    orderItemPriceDetailImpl2.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act and Assert
    assertTrue(orderItemPriceDetailImpl2.getFutureCreditOrderItemPriceDetailAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments()"})
  public void testGetFutureCreditOrderItemPriceDetailAdjustments_givenOrderItemPriceDetailImpl() {
    // Arrange, Act and Assert
    assertTrue((new OrderItemPriceDetailImpl()).getFutureCreditOrderItemPriceDetailAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments()"})
  public void testGetFutureCreditOrderItemPriceDetailAdjustments_thenReturnSizeIsOne() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = mock(
        OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl2.setQuantity(1);
    orderItemPriceDetailImpl2.setUseSalePrice(true);
    orderItemPriceDetailImpl2.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act
    List<OrderItemPriceDetailAdjustment> actualFutureCreditOrderItemPriceDetailAdjustments = orderItemPriceDetailImpl2
        .getFutureCreditOrderItemPriceDetailAdjustments();

    // Assert
    verify(orderItemPriceDetailAdjustmentImpl).isFutureCredit();
    assertEquals(1, actualFutureCreditOrderItemPriceDetailAdjustments.size());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getCurrency()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency OrderItemPriceDetailImpl.getCurrency()"})
  public void testGetCurrency_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
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
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl2.setOrderItem(orderItem);
    orderItemPriceDetailImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl2.setQuantity(1);
    orderItemPriceDetailImpl2.setUseSalePrice(true);

    // Act and Assert
    assertNull(orderItemPriceDetailImpl2.getCurrency());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getAdjustmentValue()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderImpl} (default constructor) {@link OrderImpl#totalTax}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getAdjustmentValue()"})
  public void testGetAdjustmentValue_thenReturnAbsAbsAbsAmountIsOrderImplTotalTax() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
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
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualAdjustmentValue = orderItemPriceDetailImpl2.getAdjustmentValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderItem).getOrder();
    BigDecimal bigDecimal = orderImpl.totalTax;
    Money absResult = actualAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualAdjustmentValue.zero();
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
   * Test {@link OrderItemPriceDetailImpl#getAdjustmentValue()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link OrderItemImpl#salePrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getAdjustmentValue()"})
  public void testGetAdjustmentValue_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
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
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualAdjustmentValue = orderItemPriceDetailImpl2.getAdjustmentValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualAdjustmentValue.zero();
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
   * Test {@link OrderItemPriceDetailImpl#getAdjustmentValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getAdjustmentValue()"})
  public void testGetAdjustmentValue_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualAdjustmentValue = orderItemPriceDetailImpl2.getAdjustmentValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualAdjustmentValue.ZERO, actualAdjustmentValue);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditAdjustmentValue()"})
  public void testGetFutureCreditAdjustmentValue() {
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
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditAdjustmentValue = orderItemPriceDetailImpl2.getFutureCreditAdjustmentValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualFutureCreditAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualFutureCreditAdjustmentValue.zero();
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
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderImpl} (default constructor) {@link OrderImpl#totalTax}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditAdjustmentValue()"})
  public void testGetFutureCreditAdjustmentValue_thenReturnAbsAbsAbsAmountIsOrderImplTotalTax() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
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
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditAdjustmentValue = orderItemPriceDetailImpl2.getFutureCreditAdjustmentValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderItem).getOrder();
    BigDecimal bigDecimal = orderImpl.totalTax;
    Money absResult = actualFutureCreditAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualFutureCreditAdjustmentValue.zero();
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
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditAdjustmentValue()"})
  public void testGetFutureCreditAdjustmentValue_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditAdjustmentValue = orderItemPriceDetailImpl2.getFutureCreditAdjustmentValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualFutureCreditAdjustmentValue.ZERO, actualFutureCreditAdjustmentValue);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getRoundingModeForAdj()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getRoundingModeForAdj()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RoundingMode OrderItemPriceDetailImpl.getRoundingModeForAdj()"})
  public void testGetRoundingModeForAdj() {
    // Arrange, Act and Assert
    assertEquals(RoundingMode.HALF_EVEN, (new OrderItemPriceDetailImpl()).getRoundingModeForAdj());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderImpl} (default constructor) {@link OrderImpl#totalTax}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustmentValue()"})
  public void testGetTotalAdjustmentValue_thenReturnAbsAbsAbsAmountIsOrderImplTotalTax() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
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
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentValue = orderItemPriceDetailImpl2.getTotalAdjustmentValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderItem).getOrder();
    BigDecimal bigDecimal = orderImpl.totalTax;
    Money absResult = actualTotalAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalAdjustmentValue.zero();
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
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link OrderItemImpl#salePrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustmentValue()"})
  public void testGetTotalAdjustmentValue_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
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
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentValue = orderItemPriceDetailImpl2.getTotalAdjustmentValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalAdjustmentValue.zero();
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
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustmentValue()"})
  public void testGetTotalAdjustmentValue_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentValue = orderItemPriceDetailImpl2.getTotalAdjustmentValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualTotalAdjustmentValue.ZERO, actualTotalAdjustmentValue);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue()"})
  public void testGetFutureCreditTotalAdjustmentValue() {
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
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditTotalAdjustmentValue = orderItemPriceDetailImpl2.getFutureCreditTotalAdjustmentValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualFutureCreditTotalAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualFutureCreditTotalAdjustmentValue.zero();
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
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue()"})
  public void testGetFutureCreditTotalAdjustmentValue2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
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
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditTotalAdjustmentValue = orderItemPriceDetailImpl2.getFutureCreditTotalAdjustmentValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderItem).getOrder();
    BigDecimal bigDecimal = orderImpl.totalTax;
    Money absResult = actualFutureCreditTotalAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualFutureCreditTotalAdjustmentValue.zero();
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
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue()"})
  public void testGetFutureCreditTotalAdjustmentValue_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditTotalAdjustmentValue = orderItemPriceDetailImpl2.getFutureCreditTotalAdjustmentValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualFutureCreditTotalAdjustmentValue.ZERO, actualFutureCreditTotalAdjustmentValue);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#multiply(int)} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#multiply(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_givenMoneyMultiplyReturnMoney_thenCallsMultiply() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    Money money = mock(Money.class);
    Money money2 = new Money();
    when(money.multiply(anyInt())).thenReturn(money2);
    OrderItemImpl orderItem = mock(OrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);
    when(orderItem.updateSaleAndRetailPrices()).thenReturn(true);
    when(orderItem.getPriceBeforeAdjustments(anyBoolean())).thenReturn(money);
    doNothing().when(orderItem).setAuditable(Mockito.<Auditable>any());
    doNothing().when(orderItem).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(orderItem).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(orderItem).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(orderItem).setDiscountingAllowed(anyBoolean());
    doNothing().when(orderItem).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(orderItem).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(orderItem).setId(Mockito.<Long>any());
    doNothing().when(orderItem).setName(Mockito.<String>any());
    doNothing().when(orderItem).setOrder(Mockito.<Order>any());
    doNothing().when(orderItem).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(orderItem).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(orderItem).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(orderItem).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(orderItem).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(orderItem).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(orderItem).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(orderItem).setPrice(Mockito.<Money>any());
    doNothing().when(orderItem).setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(orderItem).setQuantity(anyInt());
    doNothing().when(orderItem).setRetailPrice(Mockito.<Money>any());
    doNothing().when(orderItem).setRetailPriceOverride(anyBoolean());
    doNothing().when(orderItem).setSalePrice(Mockito.<Money>any());
    doNothing().when(orderItem).setSalePriceOverride(anyBoolean());
    doNothing().when(orderItem).setTaxable(Mockito.<Boolean>any());
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(mock(Order.class));
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl2.getTotalAdjustedPrice();

    // Assert
    verify(money).multiply(eq(0));
    verify(orderItem).getOrder();
    verify(orderItem).getPriceBeforeAdjustments(eq(true));
    verify(orderItem).setAuditable(isA(Auditable.class));
    verify(orderItem).setCandidateItemOffers(isA(List.class));
    verify(orderItem).setCartMessages(isA(List.class));
    verify(orderItem).setChildOrderItems(isA(List.class));
    verify(orderItem).setDiscountingAllowed(eq(true));
    verify(orderItem).setGiftWrapOrderItem(isA(GiftWrapOrderItem.class));
    verify(orderItem).setHasValidationError(eq(true));
    verify(orderItem).setId(eq(1L));
    verify(orderItem).setName(eq("Name"));
    verify(orderItem).setOrder(isA(Order.class));
    verify(orderItem).setOrderItemAdjustments(isA(List.class));
    verify(orderItem).setOrderItemAttributes(isA(Map.class));
    verify(orderItem).setOrderItemPriceDetails(isA(List.class));
    verify(orderItem).setOrderItemQualifiers(isA(List.class));
    verify(orderItem).setOrderItemType(isA(OrderItemType.class));
    verify(orderItem).setParentOrderItem(isA(OrderItem.class));
    verify(orderItem).setPersonalMessage(isA(PersonalMessage.class));
    verify(orderItem).setPrice(isA(Money.class));
    verify(orderItem).setProratedOrderItemAdjustments(isA(List.class));
    verify(orderItem).setQuantity(eq(1));
    verify(orderItem).setRetailPrice(isA(Money.class));
    verify(orderItem).setRetailPriceOverride(eq(true));
    verify(orderItem).setSalePrice(isA(Money.class));
    verify(orderItem).setSalePriceOverride(eq(true));
    verify(orderItem).setTaxable(eq(true));
    verify(orderItem).updateSaleAndRetailPrices();
    assertEquals(money2, actualTotalAdjustedPrice);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#subtract(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_givenMoneySubtractReturnMoney_thenCallsSubtract() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    Money money = mock(Money.class);
    Money money2 = new Money();
    when(money.subtract(Mockito.<Money>any())).thenReturn(money2);
    Money money3 = mock(Money.class);
    when(money3.multiply(anyInt())).thenReturn(money);
    OrderItemImpl orderItem = mock(OrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);
    when(orderItem.updateSaleAndRetailPrices()).thenReturn(true);
    when(orderItem.getPriceBeforeAdjustments(anyBoolean())).thenReturn(money3);
    doNothing().when(orderItem).setAuditable(Mockito.<Auditable>any());
    doNothing().when(orderItem).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(orderItem).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(orderItem).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(orderItem).setDiscountingAllowed(anyBoolean());
    doNothing().when(orderItem).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(orderItem).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(orderItem).setId(Mockito.<Long>any());
    doNothing().when(orderItem).setName(Mockito.<String>any());
    doNothing().when(orderItem).setOrder(Mockito.<Order>any());
    doNothing().when(orderItem).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(orderItem).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(orderItem).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(orderItem).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(orderItem).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(orderItem).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(orderItem).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(orderItem).setPrice(Mockito.<Money>any());
    doNothing().when(orderItem).setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(orderItem).setQuantity(anyInt());
    doNothing().when(orderItem).setRetailPrice(Mockito.<Money>any());
    doNothing().when(orderItem).setRetailPriceOverride(anyBoolean());
    doNothing().when(orderItem).setSalePrice(Mockito.<Money>any());
    doNothing().when(orderItem).setSalePriceOverride(anyBoolean());
    doNothing().when(orderItem).setTaxable(Mockito.<Boolean>any());
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(mock(Order.class));
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl2.getTotalAdjustedPrice();

    // Assert
    verify(money3).multiply(eq(0));
    verify(money).subtract(isA(Money.class));
    verify(orderItem).getOrder();
    verify(orderItem).getPriceBeforeAdjustments(eq(true));
    verify(orderItem).setAuditable(isA(Auditable.class));
    verify(orderItem).setCandidateItemOffers(isA(List.class));
    verify(orderItem).setCartMessages(isA(List.class));
    verify(orderItem).setChildOrderItems(isA(List.class));
    verify(orderItem).setDiscountingAllowed(eq(true));
    verify(orderItem).setGiftWrapOrderItem(isA(GiftWrapOrderItem.class));
    verify(orderItem).setHasValidationError(eq(true));
    verify(orderItem).setId(eq(1L));
    verify(orderItem).setName(eq("Name"));
    verify(orderItem).setOrder(isA(Order.class));
    verify(orderItem).setOrderItemAdjustments(isA(List.class));
    verify(orderItem).setOrderItemAttributes(isA(Map.class));
    verify(orderItem).setOrderItemPriceDetails(isA(List.class));
    verify(orderItem).setOrderItemQualifiers(isA(List.class));
    verify(orderItem).setOrderItemType(isA(OrderItemType.class));
    verify(orderItem).setParentOrderItem(isA(OrderItem.class));
    verify(orderItem).setPersonalMessage(isA(PersonalMessage.class));
    verify(orderItem).setPrice(isA(Money.class));
    verify(orderItem).setProratedOrderItemAdjustments(isA(List.class));
    verify(orderItem).setQuantity(eq(1));
    verify(orderItem).setRetailPrice(isA(Money.class));
    verify(orderItem).setRetailPriceOverride(eq(true));
    verify(orderItem).setSalePrice(isA(Money.class));
    verify(orderItem).setSalePriceOverride(eq(true));
    verify(orderItem).setTaxable(eq(true));
    verify(orderItem).updateSaleAndRetailPrices();
    assertSame(money2, actualTotalAdjustedPrice);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link OrderItemImpl#salePrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
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
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl2.getTotalAdjustedPrice();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalAdjustedPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalAdjustedPrice.zero();
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
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailImpl.getTotalAdjustedPrice()"})
  public void testGetTotalAdjustedPrice_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    OrderItemImpl orderItem = mock(OrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);
    when(orderItem.updateSaleAndRetailPrices()).thenReturn(true);
    Money money = new Money();
    when(orderItem.getPriceBeforeAdjustments(anyBoolean())).thenReturn(money);
    doNothing().when(orderItem).setAuditable(Mockito.<Auditable>any());
    doNothing().when(orderItem).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(orderItem).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(orderItem).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(orderItem).setDiscountingAllowed(anyBoolean());
    doNothing().when(orderItem).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(orderItem).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(orderItem).setId(Mockito.<Long>any());
    doNothing().when(orderItem).setName(Mockito.<String>any());
    doNothing().when(orderItem).setOrder(Mockito.<Order>any());
    doNothing().when(orderItem).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(orderItem).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(orderItem).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(orderItem).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(orderItem).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(orderItem).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(orderItem).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(orderItem).setPrice(Mockito.<Money>any());
    doNothing().when(orderItem).setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(orderItem).setQuantity(anyInt());
    doNothing().when(orderItem).setRetailPrice(Mockito.<Money>any());
    doNothing().when(orderItem).setRetailPriceOverride(anyBoolean());
    doNothing().when(orderItem).setSalePrice(Mockito.<Money>any());
    doNothing().when(orderItem).setSalePriceOverride(anyBoolean());
    doNothing().when(orderItem).setTaxable(Mockito.<Boolean>any());
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(mock(Order.class));
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl2.getTotalAdjustedPrice();

    // Assert
    verify(orderItem).getOrder();
    verify(orderItem).getPriceBeforeAdjustments(eq(true));
    verify(orderItem).setAuditable(isA(Auditable.class));
    verify(orderItem).setCandidateItemOffers(isA(List.class));
    verify(orderItem).setCartMessages(isA(List.class));
    verify(orderItem).setChildOrderItems(isA(List.class));
    verify(orderItem).setDiscountingAllowed(eq(true));
    verify(orderItem).setGiftWrapOrderItem(isA(GiftWrapOrderItem.class));
    verify(orderItem).setHasValidationError(eq(true));
    verify(orderItem).setId(eq(1L));
    verify(orderItem).setName(eq("Name"));
    verify(orderItem).setOrder(isA(Order.class));
    verify(orderItem).setOrderItemAdjustments(isA(List.class));
    verify(orderItem).setOrderItemAttributes(isA(Map.class));
    verify(orderItem).setOrderItemPriceDetails(isA(List.class));
    verify(orderItem).setOrderItemQualifiers(isA(List.class));
    verify(orderItem).setOrderItemType(isA(OrderItemType.class));
    verify(orderItem).setParentOrderItem(isA(OrderItem.class));
    verify(orderItem).setPersonalMessage(isA(PersonalMessage.class));
    verify(orderItem).setPrice(isA(Money.class));
    verify(orderItem).setProratedOrderItemAdjustments(isA(List.class));
    verify(orderItem).setQuantity(eq(1));
    verify(orderItem).setRetailPrice(isA(Money.class));
    verify(orderItem).setRetailPriceOverride(eq(true));
    verify(orderItem).setSalePrice(isA(Money.class));
    verify(orderItem).setSalePriceOverride(eq(true));
    verify(orderItem).setTaxable(eq(true));
    verify(orderItem).updateSaleAndRetailPrices();
    assertEquals(money, actualTotalAdjustedPrice);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getUseSalePrice()}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getUseSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailImpl.getUseSalePrice()"})
  public void testGetUseSalePrice_givenOrderItemPriceDetailImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OrderItemPriceDetailImpl()).getUseSalePrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getUseSalePrice()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getUseSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailImpl.getUseSalePrice()"})
  public void testGetUseSalePrice_thenReturnFalse() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setUseSalePrice(false);

    // Act and Assert
    assertFalse(orderItemPriceDetailImpl2.getUseSalePrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderItemPriceDetailImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl2.setQuantity(1);
    orderItemPriceDetailImpl2.setUseSalePrice(true);
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertNull(orderItemPriceDetailImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderItemPriceDetailImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
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

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl2.setQuantity(1);
    orderItemPriceDetailImpl2.setUseSalePrice(true);
    orderItemPriceDetailImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertNull(orderItemPriceDetailImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse OrderItemPriceDetailImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItemPriceDetail> actualCreateOrRetrieveCopyInstanceResult = orderItemPriceDetailImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link OrderItemPriceDetailImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse OrderItemPriceDetailImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnOrderItemPriceDetailImpl()
      throws CloneNotSupportedException {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<OrderItemPriceDetail> actualCreateOrRetrieveCopyInstanceResult = orderItemPriceDetailImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    OrderItemPriceDetail clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof OrderItemPriceDetailImpl);
    assertNull(clone.getId());
    assertNull(clone.getOrderItem());
    assertEquals(0, clone.getQuantity());
    assertEquals(RoundingMode.HALF_EVEN, ((OrderItemPriceDetailImpl) clone).getRoundingModeForAdj());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertTrue(clone.getFutureCreditOrderItemPriceDetailAdjustments().isEmpty());
    assertTrue(clone.getOrderItemPriceDetailAdjustments().isEmpty());
    assertTrue(clone.getUseSalePrice());
    assertTrue(((OrderItemPriceDetailImpl) clone).useSalePrice);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailImpl.<init>()", "Long OrderItemPriceDetailImpl.getId()",
      "OrderItem OrderItemPriceDetailImpl.getOrderItem()",
      "List OrderItemPriceDetailImpl.getOrderItemPriceDetailAdjustments()",
      "int OrderItemPriceDetailImpl.getQuantity()", "void OrderItemPriceDetailImpl.setId(Long)",
      "void OrderItemPriceDetailImpl.setOrderItem(OrderItem)",
      "void OrderItemPriceDetailImpl.setOrderItemAdjustments(List)", "void OrderItemPriceDetailImpl.setQuantity(int)"})
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
    List<OrderItemPriceDetailAdjustment> actualOrderItemPriceDetailAdjustments = actualOrderItemPriceDetailImpl
        .getOrderItemPriceDetailAdjustments();

    // Assert
    assertEquals(1, actualOrderItemPriceDetailImpl.getQuantity());
    assertTrue(actualOrderItemPriceDetailAdjustments.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItemPriceDetailAdjustments, actualOrderItemPriceDetailAdjustments);
    assertSame(orderItem, actualOrderItem);
  }
}
