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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;

public class ProratedOrderItemAdjustmentImplDiffblueTest {
  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#init(OrderItem, Offer, String)}.
   * <ul>
   *   <li>Then {@link ProratedOrderItemAdjustmentImpl} (default constructor)
   * CurrencyCode is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProratedOrderItemAdjustmentImpl#init(OrderItem, Offer, String)}
   */
  @Test
  public void testInit_thenProratedOrderItemAdjustmentImplCurrencyCodeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    OfferImpl offer = new OfferImpl();

    // Act
    proratedOrderItemAdjustmentImpl.init(orderItem, offer, "Just cause");

    // Assert
    assertEquals("Just cause", proratedOrderItemAdjustmentImpl.getReason());
    assertNull(proratedOrderItemAdjustmentImpl.getCurrencyCode());
    assertSame(offer, proratedOrderItemAdjustmentImpl.getOffer());
    assertSame(orderItem, proratedOrderItemAdjustmentImpl.getOrderItem());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#init(OrderItem, Offer, String)}.
   * <ul>
   *   <li>Then {@link ProratedOrderItemAdjustmentImpl} (default constructor)
   * OrderItem is {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProratedOrderItemAdjustmentImpl#init(OrderItem, Offer, String)}
   */
  @Test
  public void testInit_thenProratedOrderItemAdjustmentImplOrderItemIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    proratedOrderItemAdjustmentImpl.init(orderItem, offer, "Just cause");

    // Assert
    assertEquals("Just cause", proratedOrderItemAdjustmentImpl.getReason());
    assertSame(offer, proratedOrderItemAdjustmentImpl.getOffer());
    assertSame(orderItem, proratedOrderItemAdjustmentImpl.getOrderItem());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setId(Long)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setOffer(Offer)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setOrderItem(OrderItem)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setQuantity(int)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setReason(String)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getId()}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getOffer()}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getOrderItem()}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getQuantity()}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getReason()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();

    // Act
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    OfferImpl offer = new OfferImpl();
    proratedOrderItemAdjustmentImpl.setOffer(offer);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    Long actualId = proratedOrderItemAdjustmentImpl.getId();
    Offer actualOffer = proratedOrderItemAdjustmentImpl.getOffer();
    OrderItem actualOrderItem = proratedOrderItemAdjustmentImpl.getOrderItem();
    int actualQuantity = proratedOrderItemAdjustmentImpl.getQuantity();

    // Assert that nothing has changed
    assertEquals("Just cause", proratedOrderItemAdjustmentImpl.getReason());
    assertEquals(1, actualQuantity);
    assertEquals(ProratedOrderItemAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(orderItem, actualOrderItem);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link OrderItemImpl#getOrder()} return
   * {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenBundleOrderItemImplGetOrderReturnNullOrderImpl_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualValue = proratedOrderItemAdjustmentImpl.getValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualValue.ZERO, actualValue);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenMoneyGetAmountReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(value);
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualValue = proratedOrderItemAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    Money value = new Money();
    proratedOrderItemAdjustmentImpl.setValue(value);
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(value, proratedOrderItemAdjustmentImpl.getValue());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link ProratedOrderItemAdjustmentImpl} (default constructor)
   * {@link ProratedOrderItemAdjustmentImpl#value} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue_thenProratedOrderItemAdjustmentImplValueIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();

    // Act
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), proratedOrderItemAdjustmentImpl.value);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link ProratedOrderItemAdjustmentImpl} (default constructor)
   * {@link ProratedOrderItemAdjustmentImpl#value} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue_thenProratedOrderItemAdjustmentImplValueIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    proratedOrderItemAdjustmentImpl.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), proratedOrderItemAdjustmentImpl.value);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is
   * {@link ProratedOrderItemAdjustmentImpl#serialVersionUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertNull(proratedOrderItemAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link Auditable} {@link Auditable#setCreatedBy(Long)} does
   * nothing.</li>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenAuditableSetCreatedByDoesNothing_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    String actualCurrencyCode = proratedOrderItemAdjustmentImpl.getCurrencyCode();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertNull(actualCurrencyCode);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and
   * {@link ProratedOrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    int expectedHashCodeResult = proratedOrderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and
   * {@link ProratedOrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    int expectedHashCodeResult = proratedOrderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and
   * {@link ProratedOrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(mock(Offer.class));
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    int notExpectedHashCodeResult = proratedOrderItemAdjustmentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and
   * {@link ProratedOrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(null);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    int expectedHashCodeResult = proratedOrderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and
   * {@link ProratedOrderItemAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl);
    int expectedHashCodeResult = proratedOrderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, proratedOrderItemAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(2L);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(offer);
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(null);
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(null);
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Reason");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason(null);
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money(10.0d));

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(value);

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, null);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, "Different type to ProratedOrderItemAdjustmentImpl");
  }

  /**
   * Test new {@link ProratedOrderItemAdjustmentImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProratedOrderItemAdjustmentImpl}
   */
  @Test
  public void testNewProratedOrderItemAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProratedOrderItemAdjustmentImpl actualProratedOrderItemAdjustmentImpl = new ProratedOrderItemAdjustmentImpl();

    // Assert
    assertNull(actualProratedOrderItemAdjustmentImpl.getId());
    assertNull(actualProratedOrderItemAdjustmentImpl.getReason());
    assertNull(actualProratedOrderItemAdjustmentImpl.getOffer());
    assertNull(actualProratedOrderItemAdjustmentImpl.getOrderItem());
    assertEquals(0, actualProratedOrderItemAdjustmentImpl.getQuantity());
    assertEquals(new BigDecimal("0.00"), actualProratedOrderItemAdjustmentImpl.value);
  }
}
