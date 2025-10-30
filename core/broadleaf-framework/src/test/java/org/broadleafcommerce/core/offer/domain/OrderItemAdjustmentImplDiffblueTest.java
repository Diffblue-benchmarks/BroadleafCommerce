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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderItemAdjustmentImplDiffblueTest {
  @Autowired
  private OrderItemAdjustmentImpl orderItemAdjustmentImpl;

  /**
   * Test {@link OrderItemAdjustmentImpl#init(OrderItem, Offer, String)}.
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#init(OrderItem, Offer, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemAdjustmentImpl.init(OrderItem, Offer, String)"})
  public void testInit() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemAdjustmentImpl2.init(orderItem, offer, "Just cause");

    // Assert
    assertTrue(orderItemAdjustmentImpl2.offer instanceof OfferImpl);
    assertEquals("Just cause", orderItemAdjustmentImpl2.getReason());
    assertSame(offer, orderItemAdjustmentImpl2.getOffer());
    assertSame(offer, orderItemAdjustmentImpl2.deproxiedOffer);
    assertSame(orderItem, orderItemAdjustmentImpl2.getOrderItem());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#setAppliedToSalePrice(boolean)}
   *   <li>{@link OrderItemAdjustmentImpl#setId(Long)}
   *   <li>{@link OrderItemAdjustmentImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemAdjustmentImpl#setReason(String)}
   *   <li>{@link OrderItemAdjustmentImpl#setRetailPriceValue(Money)}
   *   <li>{@link OrderItemAdjustmentImpl#setSalesPriceValue(Money)}
   *   <li>{@link OrderItemAdjustmentImpl#getId()}
   *   <li>{@link OrderItemAdjustmentImpl#getOrderItem()}
   *   <li>{@link OrderItemAdjustmentImpl#getReason()}
   *   <li>{@link OrderItemAdjustmentImpl#isAppliedToSalePrice()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OrderItemAdjustmentImpl.getId()", "OrderItem OrderItemAdjustmentImpl.getOrderItem()",
      "String OrderItemAdjustmentImpl.getReason()", "boolean OrderItemAdjustmentImpl.isAppliedToSalePrice()",
      "void OrderItemAdjustmentImpl.setAppliedToSalePrice(boolean)", "void OrderItemAdjustmentImpl.setId(Long)",
      "void OrderItemAdjustmentImpl.setOrderItem(OrderItem)", "void OrderItemAdjustmentImpl.setReason(String)",
      "void OrderItemAdjustmentImpl.setRetailPriceValue(Money)",
      "void OrderItemAdjustmentImpl.setSalesPriceValue(Money)"})
  public void testGettersAndSetters() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();

    // Act
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItemAdjustmentImpl.setOrderItem(orderItem);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    Long actualId = orderItemAdjustmentImpl.getId();
    OrderItem actualOrderItem = orderItemAdjustmentImpl.getOrderItem();
    String actualReason = orderItemAdjustmentImpl.getReason();

    // Assert
    assertEquals("Just cause", actualReason);
    assertTrue(orderItemAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(OrderItemAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getOffer()}.
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getOffer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OrderItemAdjustmentImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull((new OrderItemAdjustmentImpl()).getOffer());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#setOffer(Offer)}.
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemAdjustmentImpl.setOffer(Offer)"})
  public void testSetOffer() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemAdjustmentImpl2.setOffer(offer);

    // Assert
    assertTrue(orderItemAdjustmentImpl2.offer instanceof OfferImpl);
    assertSame(offer, orderItemAdjustmentImpl2.getOffer());
    assertSame(offer, orderItemAdjustmentImpl2.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getValue()"})
  public void testGetValue_givenMoneyGetAmountReturnNull_thenReturnNull() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
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
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(value);
    orderItemAdjustmentImpl2.setOrderItem(orderItem);

    // Act
    Money actualValue = orderItemAdjustmentImpl2.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getValue()"})
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
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
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setReason("Just cause");
    Money retailPriceValue = new Money();
    orderItemAdjustmentImpl2.setRetailPriceValue(retailPriceValue);
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());
    orderItemAdjustmentImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(retailPriceValue, orderItemAdjustmentImpl2.getValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link OrderItemAdjustmentImpl} (default constructor) {@link OrderItemAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenOrderItemAdjustmentImplValueIsBigDecimalWith23() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    orderItemAdjustmentImpl2.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), orderItemAdjustmentImpl2.value);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link OrderItemAdjustmentImpl} (default constructor) {@link OrderItemAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemAdjustmentImpl.setValue(Money)"})
  public void testSetValue_whenMoney_thenOrderItemAdjustmentImplValueIsBigDecimalWith000() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();

    // Act
    orderItemAdjustmentImpl2.setValue(new Money());

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), orderItemAdjustmentImpl2.value);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getRetailPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
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
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setReason("Just cause");
    Money salesPriceValue = new Money();
    orderItemAdjustmentImpl2.setSalesPriceValue(salesPriceValue);
    orderItemAdjustmentImpl2.setValue(new Money());
    orderItemAdjustmentImpl2.setRetailPriceValue(null);
    orderItemAdjustmentImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(salesPriceValue, orderItemAdjustmentImpl2.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getRetailPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderItemAdjustmentImpl} (default constructor) RetailPriceValue is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue_givenOrderItemAdjustmentImplRetailPriceValueIsMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
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
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());
    Money retailPriceValue = new Money();
    orderItemAdjustmentImpl2.setRetailPriceValue(retailPriceValue);
    orderItemAdjustmentImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertSame(retailPriceValue, orderItemAdjustmentImpl2.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getSalesPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
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
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setReason("Just cause");
    Money retailPriceValue = new Money();
    orderItemAdjustmentImpl2.setRetailPriceValue(retailPriceValue);
    orderItemAdjustmentImpl2.setValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(null);
    orderItemAdjustmentImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(retailPriceValue, orderItemAdjustmentImpl2.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getSalesPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderItemAdjustmentImpl} (default constructor) SalesPriceValue is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue_givenOrderItemAdjustmentImplSalesPriceValueIsMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
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
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());
    Money salesPriceValue = new Money();
    orderItemAdjustmentImpl2.setSalesPriceValue(salesPriceValue);
    orderItemAdjustmentImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertSame(salesPriceValue, orderItemAdjustmentImpl2.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemAdjustmentImpl#serialVersionUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderItemAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertNull(orderItemAdjustmentImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link OrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    int expectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link OrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    int expectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link OrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(null);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    int expectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link OrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl);
    int expectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(2L);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Just cause");
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(orderItem);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(null);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Reason");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason(null);
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money(10.0d));

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(value);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, null);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAdjustmentImpl.equals(Object)", "int OrderItemAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, "Different type to OrderItemAdjustmentImpl");
  }

  /**
   * Test new {@link OrderItemAdjustmentImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OrderItemAdjustmentImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemAdjustmentImpl.<init>()"})
  public void testNewOrderItemAdjustmentImpl() {
    // Arrange and Act
    OrderItemAdjustmentImpl actualOrderItemAdjustmentImpl = new OrderItemAdjustmentImpl();

    // Assert
    assertNull(actualOrderItemAdjustmentImpl.getId());
    assertNull(actualOrderItemAdjustmentImpl.getReason());
    assertNull(actualOrderItemAdjustmentImpl.retailValue);
    assertNull(actualOrderItemAdjustmentImpl.salesValue);
    assertNull(actualOrderItemAdjustmentImpl.getOffer());
    assertNull(actualOrderItemAdjustmentImpl.deproxiedOffer);
    assertNull(actualOrderItemAdjustmentImpl.offer);
    assertNull(actualOrderItemAdjustmentImpl.getOrderItem());
    assertFalse(actualOrderItemAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(new BigDecimal("0.00"), actualOrderItemAdjustmentImpl.value);
  }
}
