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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Test;
import org.mockito.Mockito;

public class OrderItemServiceImplDiffblueTest {
  /**
   * Test
   * {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}
   */
  @Test
  public void testPopulateProductOptionAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act
    orderItemServiceImpl.populateProductOptionAttributes(item, new HashMap<>());

    // Assert that nothing has changed
    assertTrue(item.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}
   */
  @Test
  public void testPopulateProductOptionAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setOrderItemAttributes(null);

    // Act
    orderItemServiceImpl.populateProductOptionAttributes(item, null);

    // Assert that nothing has changed
    assertNull(item.getOrderItemAttributes());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}
   */
  @Test
  public void testPopulateProductOptionAttributes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", "foo");

    // Act
    orderItemServiceImpl.populateProductOptionAttributes(item, attributes);

    // Assert
    Map<String, OrderItemAttribute> orderItemAttributes = item.getOrderItemAttributes();
    assertEquals(1, orderItemAttributes.size());
    OrderItemAttribute getResult = orderItemAttributes.get("foo");
    assertTrue(getResult instanceof OrderItemAttributeImpl);
    assertEquals("foo", getResult.toString());
    assertEquals("foo", getResult.getName());
    assertEquals("foo", getResult.getValue());
    assertNull(getResult.getId());
    assertSame(item, getResult.getOrderItem());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}
   */
  @Test
  public void testPopulateProductOptionAttributes_whenHashMapFooIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", null);

    // Act
    orderItemServiceImpl.populateProductOptionAttributes(item, attributes);

    // Assert that nothing has changed
    assertTrue(item.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setOrder(new NullOrderImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult instanceof NonDiscreteOrderItemRequestDTO);
    Money overrideRetailPrice = actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice();
    Currency currency = overrideRetailPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(((NonDiscreteOrderItemRequestDTO) actualBuildOrderItemRequestDTOFromOrderItemResult).getItemName());
    assertEquals(0, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, overrideRetailPrice.getAmount());
    assertEquals(overrideRetailPrice, overrideRetailPrice.abs());
    assertEquals(overrideRetailPrice, overrideRetailPrice.zero());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(stringStringMap);
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    Map<String, String> additionalAttributes = actualBuildOrderItemRequestDTOFromOrderItemResult
        .getAdditionalAttributes();
    assertEquals(1, additionalAttributes.size());
    assertEquals("foo", additionalAttributes.get("foo"));
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(null);
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(null);
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(null);

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <ul>
   *   <li>Then return AdditionalAttributes Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnAdditionalAttributesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <ul>
   *   <li>Then return ItemAttributes size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnItemAttributesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("foo", new OrderItemAttributeImpl());
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    Map<String, String> itemAttributes = actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes();
    assertEquals(1, itemAttributes.size());
    assertNull(itemAttributes.get("foo"));
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then calls {@link ConfigurableOrderItemRequest#getProduct()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  public void testFindAllProductsInRequest_givenProductBundleImpl_thenCallsGetProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    ConfigurableOrderItemRequest itemRequest = mock(ConfigurableOrderItemRequest.class);
    when(itemRequest.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.setCategoryId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setItemAttributes(Mockito.<Map<String, String>>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setOrderItemId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setProductId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setQuantity(Mockito.<Integer>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setSkuId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    doNothing().when(itemRequest).setDiscountsAllowed(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setDisplayPrice(Mockito.<Money>any());
    doNothing().when(itemRequest).setExpandable(anyBoolean());
    doNothing().when(itemRequest).setFirstExpandable(anyBoolean());
    doNothing().when(itemRequest).setHasConfigurationError(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setHasOverridenPrice(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setIsMultiSelect(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setLastExpandable(anyBoolean());
    doNothing().when(itemRequest).setMaxQuantity(Mockito.<Integer>any());
    doNothing().when(itemRequest).setMinQuantity(Mockito.<Integer>any());
    doNothing().when(itemRequest).setOrderItemIndex(Mockito.<Integer>any());
    doNothing().when(itemRequest).setPricingModelType(Mockito.<String>any());
    doNothing().when(itemRequest).setProductChoices(Mockito.<List<ConfigurableOrderItemRequest>>any());
    doNothing().when(itemRequest).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(itemRequest).setChildOrderItems(Mockito.<List<OrderItemRequestDTO>>any());
    doNothing().when(itemRequest).setOverrideRetailPrice(Mockito.<Money>any());
    doNothing().when(itemRequest).setOverrideSalePrice(Mockito.<Money>any());
    doNothing().when(itemRequest).setParentOrderItemId(Mockito.<Long>any());
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setChildOrderItems(new ArrayList<>());
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);

    // Act
    Set<Product> actualFindAllProductsInRequestResult = orderItemServiceImpl.findAllProductsInRequest(itemRequest);

    // Assert
    verify(itemRequest).getProduct();
    verify(itemRequest).setDiscountsAllowed(eq(true));
    verify(itemRequest).setDisplayPrice(isA(Money.class));
    verify(itemRequest).setExpandable(eq(true));
    verify(itemRequest).setFirstExpandable(eq(true));
    verify(itemRequest).setHasConfigurationError(eq(true));
    verify(itemRequest).setHasOverridenPrice(eq(true));
    verify(itemRequest).setIsMultiSelect(eq(true));
    verify(itemRequest).setLastExpandable(eq(true));
    verify(itemRequest).setMaxQuantity(eq(3));
    verify(itemRequest).setMinQuantity(eq(1));
    verify(itemRequest).setOrderItemIndex(eq(1));
    verify(itemRequest).setPricingModelType(eq("Pricing Model Type"));
    verify(itemRequest).setProductChoices(isA(List.class));
    verify(itemRequest).getChildOrderItems();
    verify(itemRequest).setAdditionalAttributes(isA(Map.class));
    verify(itemRequest).setCategoryId(eq(1L));
    verify(itemRequest).setChildOrderItems(isA(List.class));
    verify(itemRequest).setItemAttributes(isA(Map.class));
    verify(itemRequest).setOrderItemId(eq(1L));
    verify(itemRequest).setOverrideRetailPrice(isA(Money.class));
    verify(itemRequest).setOverrideSalePrice(isA(Money.class));
    verify(itemRequest).setParentOrderItemId(eq(1L));
    verify(itemRequest).setProductId(eq(1L));
    verify(itemRequest).setQuantity(eq(1));
    verify(itemRequest).setSkuId(eq(1L));
    assertEquals(1, actualFindAllProductsInRequestResult.size());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  public void testFindAllProductsInRequest_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    ConfigurableOrderItemRequest itemRequest = new ConfigurableOrderItemRequest();
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setChildOrderItems(new ArrayList<>());
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);

    // Act and Assert
    assertEquals(1, orderItemServiceImpl.findAllProductsInRequest(itemRequest).size());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  public void testFindAllProductsInRequest_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(configurableOrderItemRequest);

    ConfigurableOrderItemRequest itemRequest = new ConfigurableOrderItemRequest();
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);
    itemRequest.setChildOrderItems(childOrderItems);

    // Act and Assert
    assertEquals(2, orderItemServiceImpl.findAllProductsInRequest(itemRequest).size());
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  public void testFindAllChildProductsInRequest_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());

    ArrayList<OrderItemRequestDTO> childItems = new ArrayList<>();
    childItems.add(configurableOrderItemRequest);

    // Act and Assert
    assertEquals(1, orderItemServiceImpl.findAllChildProductsInRequest(childItems).size());
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  public void testFindAllChildProductsInRequest_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    // Act and Assert
    assertTrue(orderItemServiceImpl.findAllChildProductsInRequest(new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}.
   * <ul>
   *   <li>Then return MaxQuantity is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}
   */
  @Test
  public void testCreateConfigurableOrderItemRequestFromProduct_thenReturnMaxQuantityIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    ConfigurableOrderItemRequest actualCreateConfigurableOrderItemRequestFromProductResult = orderItemServiceImpl
        .createConfigurableOrderItemRequestFromProduct(product);

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(product).getId();
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getMaxQuantity());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getOrderItemIndex());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getCategoryId());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getOrderItemId());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getParentOrderItemId());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getSkuId());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getPricingModelType());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getProductChoices());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getDisplayPrice());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getOverrideRetailPrice());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getOverrideSalePrice());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getSku());
    assertEquals(0, actualCreateConfigurableOrderItemRequestFromProductResult.getMinQuantity().intValue());
    assertEquals(1, actualCreateConfigurableOrderItemRequestFromProductResult.getQuantity().intValue());
    assertEquals(1L, actualCreateConfigurableOrderItemRequestFromProductResult.getProductId().longValue());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getDiscountsAllowed());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getHasConfigurationError());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getHasOverridenPrice());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getIsMultiSelect());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.isExpandable());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.isFirstExpandable());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.isLastExpandable());
    assertTrue(actualCreateConfigurableOrderItemRequestFromProductResult.getChildOrderItems().isEmpty());
    assertTrue(actualCreateConfigurableOrderItemRequestFromProductResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualCreateConfigurableOrderItemRequestFromProductResult.getItemAttributes().isEmpty());
    assertSame(product, actualCreateConfigurableOrderItemRequestFromProductResult.getProduct());
  }
}
