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
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class AbstractOrderItemRequestDiffblueTest {
  /**
   * Method under test: {@link AbstractOrderItemRequest#getSku()}
   */
  @Test
  public void testGetSku() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getSku());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getSku()}
   */
  @Test
  public void testGetSku2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getSku());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#setSku(Sku)}
   */
  @Test
  public void testSetSku() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    SkuImpl sku = mock(SkuImpl.class);

    // Act
    discreteOrderItemRequest.setSku(sku);

    // Assert
    assertSame(sku, discreteOrderItemRequest.getSku());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getCategory()}
   */
  @Test
  public void testGetCategory() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getCategory());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getCategory()}
   */
  @Test
  public void testGetCategory2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getCategory());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#setCategory(Category)}
   */
  @Test
  public void testSetCategory() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    CategoryImpl category = new CategoryImpl();

    // Act
    discreteOrderItemRequest.setCategory(category);

    // Assert
    assertSame(category, discreteOrderItemRequest.getCategory());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#setCategory(Category)}
   */
  @Test
  public void testSetCategory2() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    Date activeStartDate = mock(Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl category = new CategoryImpl();
    category.setActiveStartDate(activeStartDate);

    // Act
    discreteOrderItemRequest.setCategory(category);

    // Assert
    verify(activeStartDate).getTime();
    assertSame(category, discreteOrderItemRequest.getCategory());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getProduct()}
   */
  @Test
  public void testGetProduct() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getProduct());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getProduct()}
   */
  @Test
  public void testGetProduct2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getProduct());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#setProduct(Product)}
   */
  @Test
  public void testSetProduct() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    // Act
    discreteOrderItemRequest.setProduct(product);

    // Assert
    assertSame(product, discreteOrderItemRequest.getProduct());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#setOrder(Order)}
   */
  @Test
  public void testSetOrder() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    discreteOrderItemRequest.setOrder(order);

    // Assert
    assertSame(order, discreteOrderItemRequest.getOrder());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getOrder());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getOrder()}
   */
  @Test
  public void testGetOrder2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getOrder());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getQuantity()}
   */
  @Test
  public void testGetQuantity() {
    // Arrange, Act and Assert
    assertEquals(0, (new DiscreteOrderItemRequest()).getQuantity());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getQuantity()}
   */
  @Test
  public void testGetQuantity2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertEquals(0, discreteOrderItemRequest.getQuantity());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#setQuantity(int)}
   */
  @Test
  public void testSetQuantity() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    // Act
    discreteOrderItemRequest.setQuantity(1);

    // Assert
    assertEquals(1, discreteOrderItemRequest.getQuantity());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#setQuantity(int)}
   */
  @Test
  public void testSetQuantity2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act
    discreteOrderItemRequest.setQuantity(1);

    // Assert
    assertEquals(1, discreteOrderItemRequest.getQuantity());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getItemAttributes()}
   */
  @Test
  public void testGetItemAttributes() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    // Act
    Map<String, String> actualItemAttributes = discreteOrderItemRequest.getItemAttributes();

    // Assert
    assertTrue(actualItemAttributes.isEmpty());
    assertSame(discreteOrderItemRequest.itemAttributes, actualItemAttributes);
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getItemAttributes()}
   */
  @Test
  public void testGetItemAttributes2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act
    Map<String, String> actualItemAttributes = discreteOrderItemRequest.getItemAttributes();

    // Assert
    assertTrue(actualItemAttributes.isEmpty());
    assertSame(itemAttributes, actualItemAttributes);
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#setItemAttributes(Map)}
   */
  @Test
  public void testSetItemAttributes() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    HashMap<String, String> itemAttributes = new HashMap<>();

    // Act
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Assert
    assertSame(itemAttributes, discreteOrderItemRequest.getItemAttributes());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#setItemAttributes(Map)}
   */
  @Test
  public void testSetItemAttributes2() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Assert
    assertSame(itemAttributes, discreteOrderItemRequest.getItemAttributes());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getAdditionalAttributes()}
   */
  @Test
  public void testGetAdditionalAttributes() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    // Act
    Map<String, String> actualAdditionalAttributes = discreteOrderItemRequest.getAdditionalAttributes();

    // Assert
    assertTrue(actualAdditionalAttributes.isEmpty());
    assertSame(discreteOrderItemRequest.additionalAttributes, actualAdditionalAttributes);
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getAdditionalAttributes()}
   */
  @Test
  public void testGetAdditionalAttributes2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act
    Map<String, String> actualAdditionalAttributes = discreteOrderItemRequest.getAdditionalAttributes();

    // Assert
    assertTrue(actualAdditionalAttributes.isEmpty());
    assertSame(discreteOrderItemRequest.additionalAttributes, actualAdditionalAttributes);
  }

  /**
   * Method under test:
   * {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}
   */
  @Test
  public void testSetAdditionalAttributes() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    HashMap<String, String> additionalAttributes = new HashMap<>();

    // Act
    discreteOrderItemRequest.setAdditionalAttributes(additionalAttributes);

    // Assert
    assertSame(additionalAttributes, discreteOrderItemRequest.getAdditionalAttributes());
  }

  /**
   * Method under test:
   * {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}
   */
  @Test
  public void testSetAdditionalAttributes2() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    HashMap<String, String> additionalAttributes = new HashMap<>();
    additionalAttributes.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    discreteOrderItemRequest.setAdditionalAttributes(additionalAttributes);

    // Assert
    assertSame(additionalAttributes, discreteOrderItemRequest.getAdditionalAttributes());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getSalePriceOverride()}
   */
  @Test
  public void testGetSalePriceOverride() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getSalePriceOverride());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getSalePriceOverride()}
   */
  @Test
  public void testGetSalePriceOverride2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getSalePriceOverride());
  }

  /**
   * Method under test:
   * {@link AbstractOrderItemRequest#setSalePriceOverride(Money)}
   */
  @Test
  public void testSetSalePriceOverride() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    Money salePriceOverride = mock(Money.class);

    // Act
    discreteOrderItemRequest.setSalePriceOverride(salePriceOverride);

    // Assert
    assertSame(salePriceOverride, discreteOrderItemRequest.getSalePriceOverride());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getRetailPriceOverride()}
   */
  @Test
  public void testGetRetailPriceOverride() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getRetailPriceOverride());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getRetailPriceOverride()}
   */
  @Test
  public void testGetRetailPriceOverride2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getRetailPriceOverride());
  }

  /**
   * Method under test:
   * {@link AbstractOrderItemRequest#setRetailPriceOverride(Money)}
   */
  @Test
  public void testSetRetailPriceOverride() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    Money retailPriceOverride = mock(Money.class);

    // Act
    discreteOrderItemRequest.setRetailPriceOverride(retailPriceOverride);

    // Assert
    assertSame(retailPriceOverride, discreteOrderItemRequest.getRetailPriceOverride());
  }

  /**
   * Method under test:
   * {@link AbstractOrderItemRequest#copyProperties(AbstractOrderItemRequest)}
   */
  @Test
  public void testCopyProperties() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    GiftWrapOrderItemRequest newRequest = mock(GiftWrapOrderItemRequest.class);
    doNothing().when(newRequest).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(newRequest).setCategory(Mockito.<Category>any());
    doNothing().when(newRequest).setItemAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(newRequest).setOrder(Mockito.<Order>any());
    doNothing().when(newRequest).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(newRequest).setProduct(Mockito.<Product>any());
    doNothing().when(newRequest).setQuantity(anyInt());
    doNothing().when(newRequest).setRetailPriceOverride(Mockito.<Money>any());
    doNothing().when(newRequest).setSalePriceOverride(Mockito.<Money>any());
    doNothing().when(newRequest).setSku(Mockito.<Sku>any());

    // Act
    discreteOrderItemRequest.copyProperties(newRequest);

    // Assert
    verify(newRequest).setAdditionalAttributes(isA(Map.class));
    verify(newRequest).setCategory(isNull());
    verify(newRequest).setItemAttributes(isA(Map.class));
    verify(newRequest).setOrder(isNull());
    verify(newRequest).setPersonalMessage(isNull());
    verify(newRequest).setProduct(isNull());
    verify(newRequest).setQuantity(eq(0));
    verify(newRequest).setRetailPriceOverride(isNull());
    verify(newRequest).setSalePriceOverride(isNull());
    verify(newRequest).setSku(isNull());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    GiftWrapOrderItemRequest giftWrapOrderItemRequest = mock(GiftWrapOrderItemRequest.class);

    // Act and Assert
    assertEquals(discreteOrderItemRequest, giftWrapOrderItemRequest);
    int notExpectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertNotEquals(notExpectedHashCodeResult, giftWrapOrderItemRequest.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setSku(new SkuImpl());

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setCategory(new CategoryImpl());

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setCategory(new CategoryImpl());

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setProduct(new ProductBundleImpl());

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setSalePriceOverride(new Money());

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest.hashCode());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getPersonalMessage()}
   */
  @Test
  public void testGetPersonalMessage() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getPersonalMessage());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#getPersonalMessage()}
   */
  @Test
  public void testGetPersonalMessage2() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getPersonalMessage());
  }

  /**
   * Method under test:
   * {@link AbstractOrderItemRequest#setPersonalMessage(PersonalMessage)}
   */
  @Test
  public void testSetPersonalMessage() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();

    // Act
    discreteOrderItemRequest.setPersonalMessage(personalMessage);

    // Assert
    assertSame(personalMessage, discreteOrderItemRequest.getPersonalMessage());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GiftWrapOrderItemRequest giftWrapOrderItemRequest = new GiftWrapOrderItemRequest();

    // Act and Assert
    assertNotEquals(giftWrapOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setQuantity(1);

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DiscreteOrderItemRequest(), null);
  }

  /**
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DiscreteOrderItemRequest(), "Different type to AbstractOrderItemRequest");
  }
}
