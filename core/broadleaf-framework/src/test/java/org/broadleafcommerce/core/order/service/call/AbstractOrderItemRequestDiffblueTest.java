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
   * Test {@link AbstractOrderItemRequest#getSku()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getSku()}
   */
  @Test
  public void testGetSku_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getSku());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getSku()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getSku()}
   */
  @Test
  public void testGetSku_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getSku());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setSku(Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl}.</li>
   *   <li>Then {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()} Sku is
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setSku(Sku)}
   */
  @Test
  public void testSetSku_whenSkuImpl_thenDiscreteOrderItemRequestSkuIsSkuImpl() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    SkuImpl sku = mock(SkuImpl.class);

    // Act
    discreteOrderItemRequest.setSku(sku);

    // Assert
    assertSame(sku, discreteOrderItemRequest.getSku());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getCategory()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getCategory()}
   */
  @Test
  public void testGetCategory_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getCategory());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getCategory()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getCategory()}
   */
  @Test
  public void testGetCategory_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getCategory());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setCategory(Category)}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setCategory(Category)}
   */
  @Test
  public void testSetCategory_givenDateGetTimeReturnTen_thenCallsGetTime() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
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
   * Test {@link AbstractOrderItemRequest#setCategory(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setCategory(Category)}
   */
  @Test
  public void testSetCategory_whenCategoryImpl() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    CategoryImpl category = new CategoryImpl();

    // Act
    discreteOrderItemRequest.setCategory(category);

    // Assert
    assertSame(category, discreteOrderItemRequest.getCategory());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getProduct()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getProduct()}
   */
  @Test
  public void testGetProduct_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getProduct());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getProduct()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getProduct()}
   */
  @Test
  public void testGetProduct_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getProduct());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setProduct(Product)}.
   * <ul>
   *   <li>Then {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()} Product
   * is {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setProduct(Product)}
   */
  @Test
  public void testSetProduct_thenDiscreteOrderItemRequestProductIsProductBundleImpl() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    // Act
    discreteOrderItemRequest.setProduct(product);

    // Assert
    assertSame(product, discreteOrderItemRequest.getProduct());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setOrder(Order)}.
   * <ul>
   *   <li>Then {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()} Order is
   * {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setOrder(Order)}
   */
  @Test
  public void testSetOrder_thenDiscreteOrderItemRequestOrderIsOrderImpl() {
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
   * Test {@link AbstractOrderItemRequest#getOrder()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getOrder()}
   */
  @Test
  public void testGetOrder_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getOrder());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getOrder()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getOrder()}
   */
  @Test
  public void testGetOrder_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getOrder());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getQuantity()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getQuantity()}
   */
  @Test
  public void testGetQuantity_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertEquals(0, (new DiscreteOrderItemRequest()).getQuantity());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getQuantity()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getQuantity()}
   */
  @Test
  public void testGetQuantity_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertEquals(0, discreteOrderItemRequest.getQuantity());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setQuantity(int)}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setQuantity(int)}
   */
  @Test
  public void testSetQuantity_givenDiscreteOrderItemRequest() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    // Act
    discreteOrderItemRequest.setQuantity(1);

    // Assert
    assertEquals(1, discreteOrderItemRequest.getQuantity());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setQuantity(int)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setQuantity(int)}
   */
  @Test
  public void testSetQuantity_givenHashMapComputeIfPresentFooAndBiFunction() {
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
   * Test {@link AbstractOrderItemRequest#getItemAttributes()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getItemAttributes()}
   */
  @Test
  public void testGetItemAttributes_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertTrue((new DiscreteOrderItemRequest()).getItemAttributes().isEmpty());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getItemAttributes()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getItemAttributes()}
   */
  @Test
  public void testGetItemAttributes_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertTrue(discreteOrderItemRequest.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setItemAttributes(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setItemAttributes(Map)}
   */
  @Test
  public void testSetItemAttributes_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
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
   * Test {@link AbstractOrderItemRequest#setItemAttributes(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setItemAttributes(Map)}
   */
  @Test
  public void testSetItemAttributes_whenHashMap() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    HashMap<String, String> itemAttributes = new HashMap<>();

    // Act
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Assert
    assertSame(itemAttributes, discreteOrderItemRequest.getItemAttributes());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getAdditionalAttributes()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getAdditionalAttributes()}
   */
  @Test
  public void testGetAdditionalAttributes_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertTrue((new DiscreteOrderItemRequest()).getAdditionalAttributes().isEmpty());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getAdditionalAttributes()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getAdditionalAttributes()}
   */
  @Test
  public void testGetAdditionalAttributes_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertTrue(discreteOrderItemRequest.getAdditionalAttributes().isEmpty());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}
   */
  @Test
  public void testSetAdditionalAttributes_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
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
   * Test {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}
   */
  @Test
  public void testSetAdditionalAttributes_whenHashMap() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    HashMap<String, String> additionalAttributes = new HashMap<>();

    // Act
    discreteOrderItemRequest.setAdditionalAttributes(additionalAttributes);

    // Assert
    assertSame(additionalAttributes, discreteOrderItemRequest.getAdditionalAttributes());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getSalePriceOverride()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getSalePriceOverride()}
   */
  @Test
  public void testGetSalePriceOverride_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getSalePriceOverride());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getSalePriceOverride()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getSalePriceOverride()}
   */
  @Test
  public void testGetSalePriceOverride_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getSalePriceOverride());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setSalePriceOverride(Money)}.
   * <ul>
   *   <li>Then {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}
   * SalePriceOverride is {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderItemRequest#setSalePriceOverride(Money)}
   */
  @Test
  public void testSetSalePriceOverride_thenDiscreteOrderItemRequestSalePriceOverrideIsMoney() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    Money salePriceOverride = mock(Money.class);

    // Act
    discreteOrderItemRequest.setSalePriceOverride(salePriceOverride);

    // Assert
    assertSame(salePriceOverride, discreteOrderItemRequest.getSalePriceOverride());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getRetailPriceOverride()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getRetailPriceOverride()}
   */
  @Test
  public void testGetRetailPriceOverride_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getRetailPriceOverride());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getRetailPriceOverride()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getRetailPriceOverride()}
   */
  @Test
  public void testGetRetailPriceOverride_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getRetailPriceOverride());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setRetailPriceOverride(Money)}.
   * <p>
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
   * Test
   * {@link AbstractOrderItemRequest#copyProperties(AbstractOrderItemRequest)}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderItemRequest#copyProperties(AbstractOrderItemRequest)}
   */
  @Test
  public void testCopyProperties_thenCallsSetAdditionalAttributes() {
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and
   * {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and
   * {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and
   * {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and
   * {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and
   * {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and
   * {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and
   * {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DiscreteOrderItemRequest(), null);
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DiscreteOrderItemRequest(), "Different type to AbstractOrderItemRequest");
  }

  /**
   * Test {@link AbstractOrderItemRequest#getPersonalMessage()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getPersonalMessage()}
   */
  @Test
  public void testGetPersonalMessage_givenDiscreteOrderItemRequest() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getPersonalMessage());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getPersonalMessage()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getPersonalMessage()}
   */
  @Test
  public void testGetPersonalMessage_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.computeIfPresent("foo", mock(BiFunction.class));

    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Act and Assert
    assertNull(discreteOrderItemRequest.getPersonalMessage());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setPersonalMessage(PersonalMessage)}.
   * <p>
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
}
