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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderImplDiffblueTest {
  @Autowired
  private OrderImpl orderImpl;

  /**
   * Test {@link OrderImpl#getSubTotal()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getSubTotal()"})
  public void testGetSubTotal_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    Money orderTotal = new Money();
    orderImpl2.setTotal(orderTotal);
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setCurrency(null);

    // Act and Assert
    assertEquals(orderTotal, orderImpl2.getSubTotal());
  }

  /**
   * Test {@link OrderImpl#getSubTotal()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getSubTotal()"})
  public void testGetSubTotal_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderImpl()).getSubTotal());
  }

  /**
   * Test {@link OrderImpl#setSubTotal(Money)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#subTotal} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setSubTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setSubTotal(Money)"})
  public void testSetSubTotal_givenOrderImpl_thenOrderImplSubTotalIsBigDecimalWith000() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money subTotal = new Money();

    // Act
    orderImpl2.setSubTotal(subTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl2.subTotal);
    BigDecimal bigDecimal = orderImpl2.subTotal;
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
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#subTotal} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setSubTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setSubTotal(Money)"})
  public void testSetSubTotal_thenOrderImplSubTotalIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act
    orderImpl2.setSubTotal(null);

    // Assert
    assertNull(orderImpl2.subTotal);
    assertNull(orderImpl2.getSubTotal());
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualCalculateSubTotalResult = orderImpl2.calculateSubTotal();

    // Assert
    assertEquals(actualCalculateSubTotalResult.ZERO, actualCalculateSubTotalResult);
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_givenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualCalculateSubTotalResult = (new OrderImpl()).calculateSubTotal();

    // Assert
    assertEquals(actualCalculateSubTotalResult.ZERO, actualCalculateSubTotalResult);
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link OrderItemImpl#salePrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
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
    orderItem.setName("ThreadLocalManager.notify.orphans");
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualCalculateSubTotalResult = orderImpl2.calculateSubTotal();

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
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getTotalPrice()).thenReturn(money);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualCalculateSubTotalResult = orderImpl2.calculateSubTotal();

    // Assert
    verify(orderItem).getTotalPrice();
    assertEquals(money, actualCalculateSubTotalResult);
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#assignFinalPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_thenCallsAssignFinalPrice() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).assignFinalPrice();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderItems(orderItems);

    // Act
    orderImpl2.assignOrderItemsFinalPrice();

    // Assert
    verify(bundleOrderItemImpl).assignFinalPrice();
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) NonDiscreteOrderItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_thenOrderImplNonDiscreteOrderItemsSizeIsOne() {
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

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderItems(orderItems);

    // Act
    orderImpl2.assignOrderItemsFinalPrice();

    // Assert
    List<OrderItem> nonDiscreteOrderItems = orderImpl2.getNonDiscreteOrderItems();
    assertEquals(1, nonDiscreteOrderItems.size());
    OrderItem getResult = nonDiscreteOrderItems.get(0);
    assertTrue(getResult instanceof OrderItemImpl);
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, getResult.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, getResult.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, getResult.getAveragePrice().getAmount());
    assertSame(bigDecimal, getResult.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, getResult.getPrice().getAmount());
    assertSame(bigDecimal, getResult.getRetailPrice().getAmount());
    assertSame(bigDecimal, getResult.getSalePrice().getAmount());
    assertSame(bigDecimal, getResult.getTaxablePrice().getAmount());
    assertSame(bigDecimal, getResult.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, getResult.getTotalPrice().getAmount());
    assertSame(bigDecimal, ((OrderItemImpl) getResult).price);
    assertSame(bigDecimal, ((OrderItemImpl) getResult).retailPrice);
    assertSame(bigDecimal, ((OrderItemImpl) getResult).salePrice);
  }

  /**
   * Test {@link OrderImpl#getTotal()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotal()"})
  public void testGetTotal_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
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
    Money subTotal = new Money();
    orderImpl2.setSubTotal(subTotal);
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setTotal(new Money());
    orderImpl2.setCurrency(null);

    // Act and Assert
    assertEquals(subTotal, orderImpl2.getTotal());
  }

  /**
   * Test {@link OrderImpl#getTotal()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotal()"})
  public void testGetTotal_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderImpl()).getTotal());
  }

  /**
   * Test {@link OrderImpl#getTotalAfterAppliedPayments()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Total is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalAfterAppliedPayments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalAfterAppliedPayments()"})
  public void testGetTotalAfterAppliedPayments_givenOrderImplTotalIsMoney_thenReturnMoney() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money orderTotal = new Money();
    orderImpl2.setTotal(orderTotal);

    // Act and Assert
    assertEquals(orderTotal, orderImpl2.getTotalAfterAppliedPayments());
  }

  /**
   * Test {@link OrderImpl#getTotalAfterAppliedPayments()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalAfterAppliedPayments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalAfterAppliedPayments()"})
  public void testGetTotalAfterAppliedPayments_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderImpl()).getTotalAfterAppliedPayments());
  }

  /**
   * Test {@link OrderImpl#getTotalAfterAppliedPayments()}.
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalAfterAppliedPayments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalAfterAppliedPayments()"})
  public void testGetTotalAfterAppliedPayments_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrencyImpl currency = mock(BroadleafCurrencyImpl.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setCurrency(currency);
    orderImpl2.setTotal(new Money());

    // Act
    Money actualTotalAfterAppliedPayments = orderImpl2.getTotalAfterAppliedPayments();

    // Assert
    verify(currency, atLeast(1)).getCurrencyCode();
    Currency currency2 = actualTotalAfterAppliedPayments.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    assertEquals(actualTotalAfterAppliedPayments, actualTotalAfterAppliedPayments.abs());
    assertEquals(actualTotalAfterAppliedPayments, actualTotalAfterAppliedPayments.zero());
  }

  /**
   * Test {@link OrderImpl#setTotal(Money)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#total} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setTotal(Money)"})
  public void testSetTotal_givenAuditableCreatedByIsSerialVersionUID_thenOrderImplTotalIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act
    orderImpl2.setTotal(null);

    // Assert
    assertNull(orderImpl2.total);
    assertNull(orderImpl2.getTotal());
    assertNull(orderImpl2.getTotalAfterAppliedPayments());
  }

  /**
   * Test {@link OrderImpl#setTotal(Money)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#total} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setTotal(Money)"})
  public void testSetTotal_givenOrderImpl_whenMoney_thenOrderImplTotalIsBigDecimalWith000() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money orderTotal = new Money();

    // Act
    orderImpl2.setTotal(orderTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl2.total);
    BigDecimal bigDecimal = orderImpl2.total;
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
   * Test {@link OrderImpl#getPreview()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getPreview()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderImpl.getPreview()"})
  public void testGetPreview_givenAuditableCreatedByIsSerialVersionUID_thenReturnTrue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setPreview(true);

    // Act and Assert
    assertTrue(orderImpl2.getPreview());
  }

  /**
   * Test {@link OrderImpl#getPreview()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getPreview()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderImpl.getPreview()"})
  public void testGetPreview_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderImpl()).getPreview());
  }

  /**
   * Test {@link OrderImpl#setPreview(Boolean)}.
   * <p>
   * Method under test: {@link OrderImpl#setPreview(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setPreview(Boolean)"})
  public void testSetPreview() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();

    // Act
    orderImpl2.setPreview(true);

    // Assert
    assertTrue(orderImpl2.previewable.getPreview());
    assertTrue(orderImpl2.getPreview());
  }

  /**
   * Test {@link OrderImpl#getStatus()}.
   * <p>
   * Method under test: {@link OrderImpl#getStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderStatus OrderImpl.getStatus()"})
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertNull((new OrderImpl()).getStatus());
  }

  /**
   * Test {@link OrderImpl#setStatus(OrderStatus)}.
   * <ul>
   *   <li>When {@link OrderStatus#ARCHIVED}.</li>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#status} is {@code ARCHIVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setStatus(OrderStatus)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setStatus(OrderStatus)"})
  public void testSetStatus_whenArchived_thenOrderImplStatusIsArchived() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    OrderStatus status = OrderStatus.ARCHIVED;

    // Act
    orderImpl2.setStatus(status);

    // Assert
    assertEquals("ARCHIVED", orderImpl2.status);
    OrderStatus expectedStatus = status.ARCHIVED;
    assertSame(expectedStatus, orderImpl2.getStatus());
  }

  /**
   * Test {@link OrderImpl#addOrderItem(OrderItem)}.
   * <p>
   * Method under test: {@link OrderImpl#addOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.addOrderItem(OrderItem)"})
  public void testAddOrderItem() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    orderImpl2.addOrderItem(orderItem);

    // Assert
    List<OrderItem> orderItems = orderImpl2.getOrderItems();
    assertEquals(1, orderItems.size());
    assertSame(orderItem, orderItems.get(0));
  }

  /**
   * Test {@link OrderImpl#getTotalTax()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalTax()"})
  public void testGetTotalTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
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
    Money subTotal = new Money();
    orderImpl2.setSubTotal(subTotal);
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setCurrency(null);

    // Act and Assert
    assertEquals(subTotal, orderImpl2.getTotalTax());
  }

  /**
   * Test {@link OrderImpl#getTotalTax()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalTax()"})
  public void testGetTotalTax_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderImpl()).getTotalTax());
  }

  /**
   * Test {@link OrderImpl#setTotalTax(Money)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#totalTax} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setTotalTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setTotalTax(Money)"})
  public void testSetTotalTax_givenOrderImpl_thenOrderImplTotalTaxIsBigDecimalWith000() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money totalTax = new Money();

    // Act
    orderImpl2.setTotalTax(totalTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl2.totalTax);
    BigDecimal bigDecimal = orderImpl2.totalTax;
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
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#totalTax} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setTotalTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setTotalTax(Money)"})
  public void testSetTotalTax_thenOrderImplTotalTaxIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act
    orderImpl2.setTotalTax(null);

    // Assert
    assertNull(orderImpl2.totalTax);
    assertNull(orderImpl2.getTotalTax());
  }

  /**
   * Test {@link OrderImpl#getTotalShipping()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalShipping()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalShipping()"})
  public void testGetTotalShipping_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
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
    Money subTotal = new Money();
    orderImpl2.setSubTotal(subTotal);
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setCurrency(null);

    // Act and Assert
    assertEquals(subTotal, orderImpl2.getTotalShipping());
  }

  /**
   * Test {@link OrderImpl#getTotalShipping()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalShipping()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalShipping()"})
  public void testGetTotalShipping_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderImpl()).getTotalShipping());
  }

  /**
   * Test {@link OrderImpl#setTotalShipping(Money)}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#totalFulfillmentCharges} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setTotalShipping(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setTotalShipping(Money)"})
  public void testSetTotalShipping_thenOrderImplTotalFulfillmentChargesIsBigDecimalWith000() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money totalShipping = new Money();

    // Act
    orderImpl2.setTotalShipping(totalShipping);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl2.totalFulfillmentCharges);
    BigDecimal bigDecimal = orderImpl2.totalFulfillmentCharges;
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
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#totalFulfillmentCharges} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setTotalShipping(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setTotalShipping(Money)"})
  public void testSetTotalShipping_thenOrderImplTotalFulfillmentChargesIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act
    orderImpl2.setTotalShipping(null);

    // Assert
    assertNull(orderImpl2.totalFulfillmentCharges);
    assertNull(orderImpl2.getTotalFulfillmentCharges());
    assertNull(orderImpl2.getTotalShipping());
  }

  /**
   * Test {@link OrderImpl#getTotalFulfillmentCharges()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalFulfillmentCharges()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalFulfillmentCharges()"})
  public void testGetTotalFulfillmentCharges_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
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
    Money subTotal = new Money();
    orderImpl2.setSubTotal(subTotal);
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setCurrency(null);

    // Act and Assert
    assertEquals(subTotal, orderImpl2.getTotalFulfillmentCharges());
  }

  /**
   * Test {@link OrderImpl#getTotalFulfillmentCharges()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalFulfillmentCharges()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalFulfillmentCharges()"})
  public void testGetTotalFulfillmentCharges_givenOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderImpl()).getTotalFulfillmentCharges());
  }

  /**
   * Test {@link OrderImpl#setTotalFulfillmentCharges(Money)}.
   * <p>
   * Method under test: {@link OrderImpl#setTotalFulfillmentCharges(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setTotalFulfillmentCharges(Money)"})
  public void testSetTotalFulfillmentCharges() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money totalFulfillmentCharges = new Money();

    // Act
    orderImpl2.setTotalFulfillmentCharges(totalFulfillmentCharges);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderImpl2.totalFulfillmentCharges);
    BigDecimal bigDecimal = orderImpl2.totalFulfillmentCharges;
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
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) {@link OrderImpl#totalFulfillmentCharges} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#setTotalFulfillmentCharges(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.setTotalFulfillmentCharges(Money)"})
  public void testSetTotalFulfillmentCharges_thenOrderImplTotalFulfillmentChargesIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act
    orderImpl2.setTotalFulfillmentCharges(null);

    // Assert
    assertNull(orderImpl2.totalFulfillmentCharges);
    assertNull(orderImpl2.getTotalFulfillmentCharges());
    assertNull(orderImpl2.getTotalShipping());
  }

  /**
   * Test {@link OrderImpl#hasCategoryItem(String)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#hasCategoryItem(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.hasCategoryItem(String)"})
  public void testHasCategoryItem_givenAuditableCreatedByIsSerialVersionUID() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl2.hasCategoryItem("Category Name"));
  }

  /**
   * Test {@link OrderImpl#hasCategoryItem(String)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#hasCategoryItem(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.hasCategoryItem(String)"})
  public void testHasCategoryItem_givenOrderImpl() {
    // Arrange, Act and Assert
    assertFalse((new OrderImpl()).hasCategoryItem("Category Name"));
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustments()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditOrderAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getFutureCreditOrderAdjustments()"})
  public void testGetFutureCreditOrderAdjustments_givenAuditableCreatedByIsSerialVersionUID() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderAdjustments.add(new OrderAdjustmentImpl());

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderAdjustments(orderAdjustments);

    // Act and Assert
    assertTrue(orderImpl2.getFutureCreditOrderAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustments()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditOrderAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getFutureCreditOrderAdjustments()"})
  public void testGetFutureCreditOrderAdjustments_givenOrderImpl() {
    // Arrange, Act and Assert
    assertTrue((new OrderImpl()).getFutureCreditOrderAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getAllFutureCreditAdjustments()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getAllFutureCreditAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getAllFutureCreditAdjustments()"})
  public void testGetAllFutureCreditAdjustments_givenAuditableCreatedByIsSerialVersionUID() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(new OrderItemPriceDetailImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setFulfillmentGroups(fulfillmentGroups);
    orderImpl2.setOrderItems(orderItems);
    orderImpl2.setOrderAdjustments(orderAdjustments);

    // Act and Assert
    assertTrue(orderImpl2.getAllFutureCreditAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getAllFutureCreditAdjustments()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getAllFutureCreditAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getAllFutureCreditAdjustments()"})
  public void testGetAllFutureCreditAdjustments_givenOrderImpl() {
    // Arrange, Act and Assert
    assertTrue((new OrderImpl()).getAllFutureCreditAdjustments().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getDiscreteOrderItems()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_givenOrderImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new OrderImpl()).getDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getDiscreteOrderItems()}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_thenReturnArrayList() {
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

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(discreteOrderItems, orderImpl2.getDiscreteOrderItems());
  }

  /**
   * Test {@link OrderImpl#getNonDiscreteOrderItems()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getNonDiscreteOrderItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getNonDiscreteOrderItems()"})
  public void testGetNonDiscreteOrderItems_givenAuditableCreatedByIsSerialVersionUID() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderItems(orderItems);

    // Act and Assert
    assertTrue(orderImpl2.getNonDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getNonDiscreteOrderItems()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getNonDiscreteOrderItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getNonDiscreteOrderItems()"})
  public void testGetNonDiscreteOrderItems_givenOrderImpl() {
    // Arrange, Act and Assert
    assertTrue((new OrderImpl()).getNonDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenAuditableCreatedByIsSerialVersionUID_thenReturnFalse() {
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act and Assert
    assertFalse(orderImpl2.containsSku(new SkuImpl()));
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link SkuImpl}.</li>
   *   <li>Then calls {@link BundleOrderItemImpl#getSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenBundleOrderItemImplGetSkuReturnSkuImpl_thenCallsGetSku() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(mock(SkuImpl.class));

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    boolean actualContainsSkuResult = orderImpl2.containsSku(new SkuImpl());

    // Assert
    verify(orderItem, atLeast(1)).getSku();
    assertFalse(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenBundleOrderItemImplGetSkuReturnSkuImpl_thenReturnTrue() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(new SkuImpl());

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    boolean actualContainsSkuResult = orderImpl2.containsSku(new SkuImpl());

    // Assert
    verify(orderItem, atLeast(1)).getSku();
    assertTrue(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) addOrderItem {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenOrderImplAddOrderItemBundleOrderItemImpl_thenReturnFalse() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(orderImpl2.containsSku(new SkuImpl()));
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenOrderImpl_thenReturnFalse() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();

    // Act and Assert
    assertFalse(orderImpl2.containsSku(new SkuImpl()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getAddedOfferCodes()", "Map OrderImpl.getAdditionalOfferInformation()",
      "Auditable OrderImpl.getAuditable()", "Long OrderImpl.getBroadleafAccountId()",
      "List OrderImpl.getCandidateOrderOffers()", "BroadleafCurrency OrderImpl.getCurrency()",
      "Customer OrderImpl.getCustomer()", "String OrderImpl.getEmailAddress()", "List OrderImpl.getFulfillmentGroups()",
      "String OrderImpl.getFulfillmentStatus()", "Long OrderImpl.getId()", "Locale OrderImpl.getLocale()",
      "String OrderImpl.getName()", "List OrderImpl.getOrderAdjustments()", "Map OrderImpl.getOrderAttributes()",
      "List OrderImpl.getOrderItems()", "String OrderImpl.getOrderNumber()", "List OrderImpl.getPayments()",
      "Date OrderImpl.getSubmitDate()", "void OrderImpl.setAdditionalOfferInformation(Map)",
      "void OrderImpl.setAuditable(Auditable)", "void OrderImpl.setCandidateOrderOffers(List)",
      "void OrderImpl.setCurrency(BroadleafCurrency)", "void OrderImpl.setCustomer(Customer)",
      "void OrderImpl.setEmailAddress(String)", "void OrderImpl.setFulfillmentGroups(List)",
      "void OrderImpl.setId(Long)", "void OrderImpl.setLocale(Locale)", "void OrderImpl.setName(String)",
      "void OrderImpl.setOrderAdjustments(List)", "void OrderImpl.setOrderAttributes(Map)",
      "void OrderImpl.setOrderItems(List)", "void OrderImpl.setOrderMessages(List)",
      "void OrderImpl.setOrderNumber(String)", "void OrderImpl.setPayments(List)", "void OrderImpl.setSubmitDate(Date)",
      "void OrderImpl.setTaxOverride(Boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    HashMap<Offer, OfferInfo> additionalOfferInformation = new HashMap<>();

    // Act
    orderImpl.setAdditionalOfferInformation(additionalOfferInformation);
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Date submitDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    orderImpl.setSubmitDate(submitDate);
    orderImpl.setTaxOverride(true);
    List<OfferCode> actualAddedOfferCodes = orderImpl.getAddedOfferCodes();
    Map<Offer, OfferInfo> actualAdditionalOfferInformation = orderImpl.getAdditionalOfferInformation();
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
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getItemAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getItemAdjustmentsValue()"})
  public void testGetItemAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualItemAdjustmentsValue = (new OrderImpl()).getItemAdjustmentsValue();

    // Assert
    assertEquals(actualItemAdjustmentsValue.ZERO, actualItemAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getItemAdjustmentsValue()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link OrderItemImpl#salePrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getItemAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getItemAdjustmentsValue()"})
  public void testGetItemAdjustmentsValue_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
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
    orderItem.setName("ThreadLocalManager.notify.orphans");
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualItemAdjustmentsValue = orderImpl2.getItemAdjustmentsValue();

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
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getItemAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getItemAdjustmentsValue()"})
  public void testGetItemAdjustmentsValue_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getTotalAdjustmentValue()).thenReturn(money);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualItemAdjustmentsValue = orderImpl2.getItemAdjustmentsValue();

    // Assert
    verify(orderItem).getTotalAdjustmentValue();
    assertEquals(money, actualItemAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}.
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditItemAdjustmentsValue()"})
  public void testGetFutureCreditItemAdjustmentsValue() {
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
    orderItem.setName("ThreadLocalManager.notify.orphans");
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualFutureCreditItemAdjustmentsValue = orderImpl2.getFutureCreditItemAdjustmentsValue();

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
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditItemAdjustmentsValue()"})
  public void testGetFutureCreditItemAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualFutureCreditItemAdjustmentsValue = (new OrderImpl()).getFutureCreditItemAdjustmentsValue();

    // Assert
    assertEquals(actualFutureCreditItemAdjustmentsValue.ZERO, actualFutureCreditItemAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditItemAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditItemAdjustmentsValue()"})
  public void testGetFutureCreditItemAdjustmentsValue_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getFutureCreditTotalAdjustmentValue()).thenReturn(money);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualFutureCreditItemAdjustmentsValue = orderImpl2.getFutureCreditItemAdjustmentsValue();

    // Assert
    verify(orderItem).getFutureCreditTotalAdjustmentValue();
    assertEquals(money, actualFutureCreditItemAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}.
   * <p>
   * Method under test: {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue() {
    // Arrange
    BroadleafCurrencyImpl currency = mock(BroadleafCurrencyImpl.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setCurrency(currency);

    // Act
    Money actualFulfillmentGroupAdjustmentsValue = orderImpl2.getFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualFulfillmentGroupAdjustmentsValue.abs());
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualFulfillmentGroupAdjustmentsValue.zero());
  }

  /**
   * Test {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualFulfillmentGroupAdjustmentsValue = (new OrderImpl()).getFulfillmentGroupAdjustmentsValue();

    // Assert
    assertEquals(actualFulfillmentGroupAdjustmentsValue.ZERO, actualFulfillmentGroupAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue_thenReturnMoney() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money subTotal = new Money();
    orderImpl2.setSubTotal(subTotal);

    // Act and Assert
    assertEquals(subTotal, orderImpl2.getFulfillmentGroupAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"})
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue() {
    // Arrange
    BroadleafCurrencyImpl currency = mock(BroadleafCurrencyImpl.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setCurrency(currency);

    // Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue = orderImpl2
        .getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualFutureCreditFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue,
        actualFutureCreditFulfillmentGroupAdjustmentsValue.abs());
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue,
        actualFutureCreditFulfillmentGroupAdjustmentsValue.zero());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"})
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue_thenReturnMoney() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money subTotal = new Money();
    orderImpl2.setSubTotal(subTotal);

    // Act and Assert
    assertEquals(subTotal, orderImpl2.getFutureCreditFulfillmentGroupAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"})
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue_thenReturnZero() {
    // Arrange and Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue = (new OrderImpl())
        .getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue.ZERO,
        actualFutureCreditFulfillmentGroupAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getOrderAdjustmentsValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) SubTotal is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getOrderAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getOrderAdjustmentsValue()"})
  public void testGetOrderAdjustmentsValue_givenOrderImplSubTotalIsMoney_thenReturnMoney() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money subTotal = new Money();
    orderImpl2.setSubTotal(subTotal);

    // Act and Assert
    assertEquals(subTotal, orderImpl2.getOrderAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getOrderAdjustmentsValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getOrderAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getOrderAdjustmentsValue()"})
  public void testGetOrderAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualOrderAdjustmentsValue = (new OrderImpl()).getOrderAdjustmentsValue();

    // Assert
    assertEquals(actualOrderAdjustmentsValue.ZERO, actualOrderAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getOrderAdjustmentsValue()}.
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getOrderAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getOrderAdjustmentsValue()"})
  public void testGetOrderAdjustmentsValue_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrencyImpl currency = mock(BroadleafCurrencyImpl.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setCurrency(currency);

    // Act
    Money actualOrderAdjustmentsValue = orderImpl2.getOrderAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualOrderAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    assertEquals(actualOrderAdjustmentsValue, actualOrderAdjustmentsValue.abs());
    assertEquals(actualOrderAdjustmentsValue, actualOrderAdjustmentsValue.zero());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}.
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditOrderAdjustmentsValue()"})
  public void testGetFutureCreditOrderAdjustmentsValue() {
    // Arrange
    BroadleafCurrencyImpl currency = mock(BroadleafCurrencyImpl.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setCurrency(currency);

    // Act
    Money actualFutureCreditOrderAdjustmentsValue = orderImpl2.getFutureCreditOrderAdjustmentsValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualFutureCreditOrderAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    assertEquals(actualFutureCreditOrderAdjustmentsValue, actualFutureCreditOrderAdjustmentsValue.abs());
    assertEquals(actualFutureCreditOrderAdjustmentsValue, actualFutureCreditOrderAdjustmentsValue.zero());
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditOrderAdjustmentsValue()"})
  public void testGetFutureCreditOrderAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualFutureCreditOrderAdjustmentsValue = (new OrderImpl()).getFutureCreditOrderAdjustmentsValue();

    // Assert
    assertEquals(actualFutureCreditOrderAdjustmentsValue.ZERO, actualFutureCreditOrderAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getFutureCreditOrderAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getFutureCreditOrderAdjustmentsValue()"})
  public void testGetFutureCreditOrderAdjustmentsValue_thenReturnMoney() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    Money subTotal = new Money();
    orderImpl2.setSubTotal(subTotal);

    // Act and Assert
    assertEquals(subTotal, orderImpl2.getFutureCreditOrderAdjustmentsValue());
  }

  /**
   * Test {@link OrderImpl#getTotalAdjustmentsValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalAdjustmentsValue()"})
  public void testGetTotalAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualTotalAdjustmentsValue = (new OrderImpl()).getTotalAdjustmentsValue();

    // Assert
    assertEquals(actualTotalAdjustmentsValue.ZERO, actualTotalAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getTotalAdjustmentsValue()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link OrderItemImpl#salePrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalAdjustmentsValue()"})
  public void testGetTotalAdjustmentsValue_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
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
    orderItem.setName("ThreadLocalManager.notify.orphans");
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentsValue = orderImpl2.getTotalAdjustmentsValue();

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
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalAdjustmentsValue()"})
  public void testGetTotalAdjustmentsValue_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getTotalAdjustmentValue()).thenReturn(money);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentsValue = orderImpl2.getTotalAdjustmentsValue();

    // Assert
    verify(orderItem).getTotalAdjustmentValue();
    assertEquals(money, actualTotalAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}.
   * <p>
   * Method under test: {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalFutureCreditAdjustmentsValue()"})
  public void testGetTotalFutureCreditAdjustmentsValue() {
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
    orderItem.setName("ThreadLocalManager.notify.orphans");
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualTotalFutureCreditAdjustmentsValue = orderImpl2.getTotalFutureCreditAdjustmentsValue();

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
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalFutureCreditAdjustmentsValue()"})
  public void testGetTotalFutureCreditAdjustmentsValue_givenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualTotalFutureCreditAdjustmentsValue = (new OrderImpl()).getTotalFutureCreditAdjustmentsValue();

    // Assert
    assertEquals(actualTotalFutureCreditAdjustmentsValue.ZERO, actualTotalFutureCreditAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTotalFutureCreditAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderImpl.getTotalFutureCreditAdjustmentsValue()"})
  public void testGetTotalFutureCreditAdjustmentsValue_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getFutureCreditTotalAdjustmentValue()).thenReturn(money);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act
    Money actualTotalFutureCreditAdjustmentsValue = orderImpl2.getTotalFutureCreditAdjustmentsValue();

    // Assert
    verify(orderItem).getFutureCreditTotalAdjustmentValue();
    assertEquals(money, actualTotalFutureCreditAdjustmentsValue);
  }

  /**
   * Test {@link OrderImpl#updatePrices()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#updatePrices()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.updatePrices()"})
  public void testUpdatePrices_givenAuditableCreatedByIsSerialVersionUID() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl2.updatePrices());
  }

  /**
   * Test {@link OrderImpl#updatePrices()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#updatePrices()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.updatePrices()"})
  public void testUpdatePrices_givenOrderImpl() {
    // Arrange, Act and Assert
    assertFalse((new OrderImpl()).updatePrices());
  }

  /**
   * Test {@link OrderImpl#finalizeItemPrices()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#finalizeItemPrices()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.finalizeItemPrices()"})
  public void testFinalizeItemPrices_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderImpl()).finalizeItemPrices());
  }

  /**
   * Test {@link OrderImpl#finalizeItemPrices()}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#finalizePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#finalizeItemPrices()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.finalizeItemPrices()"})
  public void testFinalizeItemPrices_thenCallsFinalizePrice() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).finalizePrice();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderItems(orderItems);

    // Act
    boolean actualFinalizeItemPricesResult = orderImpl2.finalizeItemPrices();

    // Assert
    verify(bundleOrderItemImpl).finalizePrice();
    assertFalse(actualFinalizeItemPricesResult);
  }

  /**
   * Test {@link OrderImpl#finalizeItemPrices()}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) NonDiscreteOrderItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#finalizeItemPrices()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.finalizeItemPrices()"})
  public void testFinalizeItemPrices_thenOrderImplNonDiscreteOrderItemsSizeIsOne() {
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

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderItems(orderItems);

    // Act
    orderImpl2.finalizeItemPrices();

    // Assert
    List<OrderItem> nonDiscreteOrderItems = orderImpl2.getNonDiscreteOrderItems();
    assertEquals(1, nonDiscreteOrderItems.size());
    OrderItem getResult = nonDiscreteOrderItems.get(0);
    assertTrue(getResult instanceof OrderItemImpl);
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, getResult.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, getResult.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, getResult.getAveragePrice().getAmount());
    assertSame(bigDecimal, getResult.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, getResult.getPrice().getAmount());
    assertSame(bigDecimal, getResult.getRetailPrice().getAmount());
    assertSame(bigDecimal, getResult.getSalePrice().getAmount());
    assertSame(bigDecimal, getResult.getTaxablePrice().getAmount());
    assertSame(bigDecimal, getResult.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, getResult.getTotalPrice().getAmount());
    assertSame(bigDecimal, ((OrderItemImpl) getResult).price);
    assertSame(bigDecimal, ((OrderItemImpl) getResult).retailPrice);
    assertSame(bigDecimal, ((OrderItemImpl) getResult).salePrice);
  }

  /**
   * Test {@link OrderImpl#addAddedOfferCode(OfferCode)}.
   * <p>
   * Method under test: {@link OrderImpl#addAddedOfferCode(OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.addAddedOfferCode(OfferCode)"})
  public void testAddAddedOfferCode() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    orderImpl2.addAddedOfferCode(offerCode);

    // Assert
    List<OfferCode> addedOfferCodes = orderImpl2.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link OrderImpl#addOfferCode(OfferCode)}.
   * <p>
   * Method under test: {@link OrderImpl#addOfferCode(OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderImpl.addOfferCode(OfferCode)"})
  public void testAddOfferCode() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    orderImpl2.addOfferCode(offerCode);

    // Assert
    List<OfferCode> addedOfferCodes = orderImpl2.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link OrderImpl#getTaxOverride()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTaxOverride()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderImpl.getTaxOverride()"})
  public void testGetTaxOverride_givenAuditableCreatedByIsSerialVersionUID_thenReturnTrue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setTaxOverride(true);

    // Act and Assert
    assertTrue(orderImpl2.getTaxOverride());
  }

  /**
   * Test {@link OrderImpl#getTaxOverride()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getTaxOverride()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderImpl.getTaxOverride()"})
  public void testGetTaxOverride_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderImpl()).getTaxOverride());
  }

  /**
   * Test {@link OrderImpl#getItemCount()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getItemCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OrderImpl.getItemCount()"})
  public void testGetItemCount_givenAuditableCreatedByIsSerialVersionUID() {
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

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(0, orderImpl2.getItemCount());
  }

  /**
   * Test {@link OrderImpl#getItemCount()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getItemCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OrderImpl.getItemCount()"})
  public void testGetItemCount_givenOrderImpl() {
    // Arrange, Act and Assert
    assertEquals(0, (new OrderImpl()).getItemCount());
  }

  /**
   * Test {@link OrderImpl#getHasOrderAdjustments()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) SubTotal is {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getHasOrderAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.getHasOrderAdjustments()"})
  public void testGetHasOrderAdjustments_givenOrderImplSubTotalIsMoney_thenReturnFalse() {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setSubTotal(new Money());

    // Act and Assert
    assertFalse(orderImpl2.getHasOrderAdjustments());
  }

  /**
   * Test {@link OrderImpl#getHasOrderAdjustments()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getHasOrderAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.getHasOrderAdjustments()"})
  public void testGetHasOrderAdjustments_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderImpl()).getHasOrderAdjustments());
  }

  /**
   * Test {@link OrderImpl#getHasOrderAdjustments()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getHasOrderAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.getHasOrderAdjustments()"})
  public void testGetHasOrderAdjustments_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrencyImpl currency = mock(BroadleafCurrencyImpl.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setCurrency(currency);

    // Act
    boolean actualHasOrderAdjustments = orderImpl2.getHasOrderAdjustments();

    // Assert
    verify(currency).getCurrencyCode();
    assertFalse(actualHasOrderAdjustments);
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) FirstName is {@code foo}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplFirstNameIsFoo_thenReturnEmptyString() {
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

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
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
    customer.setLastName(null);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setCustomer(customer);
    orderImpl2.setOrderNumber(null);

    // Act and Assert
    assertEquals("", orderImpl2.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) FirstName is {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplFirstNameIsNull_thenReturnEmptyString() {
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

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
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
    customer.setFirstName(null);
    customer.setLastName(null);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setCustomer(customer);
    orderImpl2.setOrderNumber(null);

    // Act and Assert
    assertEquals("", orderImpl2.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) FirstName is {@code null}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplFirstNameIsNull_thenReturnFoo() {
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

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
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
    customer.setFirstName(null);
    customer.setLastName(null);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setCustomer(customer);
    orderImpl2.setOrderNumber("foo");

    // Act and Assert
    assertEquals("foo", orderImpl2.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) LastName is {@code foo}.</li>
   *   <li>Then return {@code foo foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplLastNameIsFoo_thenReturnFooFoo() {
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

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setCustomer(customer);
    orderImpl2.setOrderNumber(null);

    // Act and Assert
    assertEquals("foo foo", orderImpl2.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) LastName is {@code foo}.</li>
   *   <li>Then return {@code foo - foo foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplLastNameIsFoo_thenReturnFooFooFoo() {
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

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setCustomer(customer);
    orderImpl2.setOrderNumber("foo");

    // Act and Assert
    assertEquals("foo - foo foo", orderImpl2.getMainEntityName());
  }

  /**
   * Test {@link OrderImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenAuditableCreatedByIsSerialVersionUID() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());

    // Act and Assert
    assertNull(orderImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImpl() {
    // Arrange, Act and Assert
    assertNull((new OrderImpl()).getCurrencyCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    int notExpectedHashCodeResult = orderImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    int notExpectedHashCodeResult = orderImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    int notExpectedHashCodeResult = orderImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl);
    int expectedHashCodeResult = orderImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderImpl.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, null);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, "Different type to OrderImpl");
  }

  /**
   * Test {@link OrderImpl#getOrderMessages()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getOrderMessages()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getOrderMessages()"})
  public void testGetOrderMessages_givenAuditableCreatedByIsSerialVersionUID() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable);
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
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    orderImpl2.setOrderMessages(new ArrayList<>());

    // Act and Assert
    assertTrue(orderImpl2.getOrderMessages().isEmpty());
  }

  /**
   * Test {@link OrderImpl#getOrderMessages()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#getOrderMessages()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderImpl.getOrderMessages()"})
  public void testGetOrderMessages_givenOrderImpl() {
    // Arrange, Act and Assert
    assertTrue((new OrderImpl()).getOrderMessages().isEmpty());
  }

  /**
   * Test {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link OrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse OrderImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OrderImpl orderImpl2 = new OrderImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Order> actualCreateOrRetrieveCopyInstanceResult = orderImpl2.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderImpl#hasValidationErrors()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#hasValidationErrors()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderImpl.hasValidationErrors()"})
  public void testHasValidationErrors_givenAuditableCreatedByIsSerialVersionUID_thenReturnTrue() {
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

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.addOrderItem(orderItem);

    // Act and Assert
    assertTrue(orderImpl2.hasValidationErrors());
  }

  /**
   * Test {@link OrderImpl#hasValidationErrors()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderImpl#hasValidationErrors()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderImpl.hasValidationErrors()"})
  public void testHasValidationErrors_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderImpl()).hasValidationErrors());
  }

  /**
   * Test new {@link OrderImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OrderImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
