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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.pricing.SkuPriceWrapper;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPrices;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPricingService;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationStrategyType;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemFeePrice;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemFeePriceImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.AbstractOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.BundleOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.DiscreteOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.GiftWrapOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.ProductBundleOrderItemRequest;
import org.broadleafcommerce.core.order.service.extension.OrderItemServiceExtensionHandler;
import org.broadleafcommerce.core.order.service.extension.OrderItemServiceExtensionManager;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemServiceImplDiffblueTest {
  @Mock private CatalogService catalogService;

  @Mock private DynamicSkuPricingService dynamicSkuPricingService;

  @Mock private OrderItemDao orderItemDao;

  @Mock private OrderItemServiceExtensionManager orderItemServiceExtensionManager;

  @InjectMocks private OrderItemServiceImpl orderItemServiceImpl;

  /**
   * Test {@link OrderItemServiceImpl#readOrderItemById(Long)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#readOrderItemById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.readOrderItemById(Long)"})
  public void testReadOrderItemById() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);

    // Act
    OrderItem actualReadOrderItemByIdResult = orderItemServiceImpl.readOrderItemById(1L);

    // Assert
    verify(orderItemDao).readOrderItemById(1L);
    assertSame(bundleOrderItemImpl, actualReadOrderItemByIdResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#saveOrderItem(OrderItem)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#saveOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.saveOrderItem(OrderItem)"})
  public void testSaveOrderItem() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);

    // Act
    OrderItem actualSaveOrderItemResult =
        orderItemServiceImpl.saveOrderItem(new BundleOrderItemImpl());

    // Assert
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualSaveOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#delete(OrderItem)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#delete(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemServiceImpl.delete(OrderItem)"})
  public void testDelete() {
    // Arrange
    doNothing().when(orderItemDao).delete(Mockito.<OrderItem>any());

    // Act
    orderItemServiceImpl.delete(new BundleOrderItemImpl());

    // Assert
    verify(orderItemDao).delete(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createPersonalMessage()}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#createPersonalMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersonalMessage OrderItemServiceImpl.createPersonalMessage()"})
  public void testCreatePersonalMessage() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    when(orderItemDao.createPersonalMessage()).thenReturn(personalMessageImpl);

    // Act
    PersonalMessage actualCreatePersonalMessageResult =
        orderItemServiceImpl.createPersonalMessage();

    // Assert
    verify(orderItemDao).createPersonalMessage();
    assertSame(personalMessageImpl, actualCreatePersonalMessageResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemServiceImpl.populateDiscreteOrderItem(DiscreteOrderItem, AbstractOrderItemRequest)"
  })
  public void testPopulateDiscreteOrderItem() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl item = new DiscreteOrderItemImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("name", "name");

    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());

    // Act
    orderItemServiceImpl.populateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest).getSku();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Map<String, OrderItemAttribute> orderItemAttributes = item.getOrderItemAttributes();
    assertEquals(1, orderItemAttributes.size());
    OrderItemAttribute getResult = orderItemAttributes.get("name");
    assertTrue(getResult instanceof OrderItemAttributeImpl);
    assertEquals("name", getResult.toString());
    assertEquals("name", getResult.getName());
    assertEquals("name", getResult.getValue());
    assertNull(getResult.getId());
    assertSame(item, getResult.getOrderItem());
  }

  /**
   * Test {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemServiceImpl.populateDiscreteOrderItem(DiscreteOrderItem, AbstractOrderItemRequest)"
  })
  public void testPopulateDiscreteOrderItem_givenHashMap() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl item = new DiscreteOrderItemImpl();

    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemAttributes()).thenReturn(new HashMap<>());
    CategoryImpl categoryImpl = new CategoryImpl();
    when(itemRequest.getCategory()).thenReturn(categoryImpl);
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(itemRequest.getProduct()).thenReturn(productBundleImpl);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(itemRequest.getOrder()).thenReturn(nullOrderImpl);
    SkuImpl skuImpl = new SkuImpl();
    when(itemRequest.getSku()).thenReturn(skuImpl);

    // Act
    orderItemServiceImpl.populateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest).getSku();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    org.broadleafcommerce.core.catalog.domain.Category category = item.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Product product = item.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    Sku sku = item.getSku();
    assertTrue(sku instanceof SkuImpl);
    Order order = item.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertNull(item.getName());
    assertNull(item.getCurrencyCode());
    assertNull(item.getMainEntityName());
    assertNull(item.getRetailPrice());
    assertNull(item.getSalePrice());
    assertEquals(1, item.getQuantity());
    assertFalse(item.isSkuActive());
    assertFalse(item.getIsOnSale());
    assertSame(categoryImpl, category);
    assertSame(productBundleImpl, product);
    assertSame(skuImpl, sku);
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code name} is {@code name}.
   *   <li>Then calls {@link DiscreteOrderItem#setProduct(Product)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemServiceImpl.populateDiscreteOrderItem(DiscreteOrderItem, AbstractOrderItemRequest)"
  })
  public void testPopulateDiscreteOrderItem_givenHashMapNameIsName_thenCallsSetProduct() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItem item = mock(DiscreteOrderItem.class);
    doNothing().when(item).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    when(item.getOrderItemAttributes()).thenReturn(null);
    doNothing().when(item).setProduct(Mockito.<Product>any());
    doNothing().when(item).setSku(Mockito.<Sku>any());
    doNothing()
        .when(item)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(item).setOrder(Mockito.<Order>any());
    doNothing().when(item).setQuantity(anyInt());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("name", "name");

    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());

    // Act
    orderItemServiceImpl.populateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(item).setProduct(isA(Product.class));
    verify(item).setSku(isA(Sku.class));
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(item).setOrder(isA(Order.class));
    verify(item).setOrderItemAttributes(isA(Map.class));
    verify(item).setQuantity(1);
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest).getSku();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code name} is {@code null}.
   *   <li>Then calls {@link DiscreteOrderItem#setProduct(Product)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemServiceImpl.populateDiscreteOrderItem(DiscreteOrderItem, AbstractOrderItemRequest)"
  })
  public void testPopulateDiscreteOrderItem_givenHashMapNameIsNull_thenCallsSetProduct() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItem item = mock(DiscreteOrderItem.class);
    doNothing().when(item).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    when(item.getOrderItemAttributes()).thenReturn(null);
    doNothing().when(item).setProduct(Mockito.<Product>any());
    doNothing().when(item).setSku(Mockito.<Sku>any());
    doNothing()
        .when(item)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(item).setOrder(Mockito.<Order>any());
    doNothing().when(item).setQuantity(anyInt());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("name", null);

    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());

    // Act
    orderItemServiceImpl.populateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(item).setProduct(isA(Product.class));
    verify(item).setSku(isA(Sku.class));
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(item).setOrder(isA(Order.class));
    verify(item).setOrderItemAttributes(isA(Map.class));
    verify(item).setQuantity(1);
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest).getSku();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}.
   *
   * <ul>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor) Category {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem,
   * AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemServiceImpl.populateDiscreteOrderItem(DiscreteOrderItem, AbstractOrderItemRequest)"
  })
  public void testPopulateDiscreteOrderItem_thenDiscreteOrderItemImplCategoryCategoryImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl item = new DiscreteOrderItemImpl();

    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getItemAttributes()).thenReturn(null);
    when(itemRequest.getQuantity()).thenReturn(1);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(itemRequest.getCategory()).thenReturn(categoryImpl);
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(itemRequest.getProduct()).thenReturn(productBundleImpl);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(itemRequest.getOrder()).thenReturn(nullOrderImpl);
    SkuImpl skuImpl = new SkuImpl();
    when(itemRequest.getSku()).thenReturn(skuImpl);

    // Act
    orderItemServiceImpl.populateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest).getSku();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    org.broadleafcommerce.core.catalog.domain.Category category = item.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Product product = item.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    Sku sku = item.getSku();
    assertTrue(sku instanceof SkuImpl);
    Order order = item.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertNull(item.getName());
    assertNull(item.getCurrencyCode());
    assertNull(item.getMainEntityName());
    assertNull(item.getRetailPrice());
    assertNull(item.getSalePrice());
    assertEquals(1, item.getQuantity());
    assertFalse(item.isSkuActive());
    assertFalse(item.getIsOnSale());
    assertSame(categoryImpl, category);
    assertSame(productBundleImpl, product);
    assertSame(skuImpl, sku);
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemServiceImpl.populateProductOptionAttributes(OrderItem, Map)"})
  public void testPopulateProductOptionAttributes() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    item.setPrice(new Money());
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
   * Test {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemServiceImpl.populateProductOptionAttributes(OrderItem, Map)"})
  public void testPopulateProductOptionAttributes2() {
    // Arrange
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
   * Test {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link OrderItemAttributeImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemServiceImpl.populateProductOptionAttributes(OrderItem, Map)"})
  public void testPopulateProductOptionAttributes_givenHashMapFooIsOrderItemAttributeImpl() {
    // Arrange
    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("foo", new OrderItemAttributeImpl());

    OrderItem item = mock(OrderItem.class);
    when(item.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);

    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", "foo");

    // Act
    orderItemServiceImpl.populateProductOptionAttributes(item, attributes);

    // Assert
    verify(item, atLeast(1)).getOrderItemAttributes();
  }

  /**
   * Test {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderItem#setOrderItemAttributes(Map)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemServiceImpl.populateProductOptionAttributes(OrderItem, Map)"})
  public void testPopulateProductOptionAttributes_thenCallsSetOrderItemAttributes() {
    // Arrange
    OrderItem item = mock(OrderItem.class);
    doNothing().when(item).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    when(item.getOrderItemAttributes()).thenReturn(null);

    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", "foo");

    // Act
    orderItemServiceImpl.populateProductOptionAttributes(item, attributes);

    // Assert
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).setOrderItemAttributes(isA(Map.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemServiceImpl.populateProductOptionAttributes(OrderItem, Map)"})
  public void testPopulateProductOptionAttributes_whenHashMap() {
    // Arrange
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act
    orderItemServiceImpl.populateProductOptionAttributes(item, new HashMap<>());

    // Assert that nothing has changed
    assertTrue(item.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemServiceImpl.populateProductOptionAttributes(OrderItem, Map)"})
  public void testPopulateProductOptionAttributes_whenHashMapFooIsNull() {
    // Arrange
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", null);

    // Act
    orderItemServiceImpl.populateProductOptionAttributes(item, attributes);

    // Assert that nothing has changed
    assertTrue(item.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.createOrderItem(OrderItemRequest)"})
  public void testCreateOrderItem() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    OrderItemRequest itemRequest = new OrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setSalePriceOverride(null);
    itemRequest.setRetailPriceOverride(null);
    itemRequest.setItemAttributes(null);

    // Act
    OrderItem actualCreateOrderItemResult = orderItemServiceImpl.createOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.createOrderItem(OrderItemRequest)"})
  public void testCreateOrderItem2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    OrderItemRequest itemRequest = new OrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setSalePriceOverride(null);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setItemAttributes(null);

    // Act
    OrderItem actualCreateOrderItemResult = orderItemServiceImpl.createOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.createOrderItem(OrderItemRequest)"})
  public void testCreateOrderItem3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    OrderItemRequest itemRequest = new OrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setRetailPriceOverride(null);
    itemRequest.setItemAttributes(null);

    // Act
    OrderItem actualCreateOrderItemResult = orderItemServiceImpl.createOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   *   <li>Then return {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.createOrderItem(OrderItemRequest)"})
  public void testCreateOrderItem_givenHashMapFooIsFoo_thenReturnBundleOrderItemImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    OrderItemRequest itemRequest = new OrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setSalePriceOverride(null);
    itemRequest.setRetailPriceOverride(null);
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    OrderItem actualCreateOrderItemResult = orderItemServiceImpl.createOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateOrderItemResult instanceof BundleOrderItemImpl);
    Map<String, OrderItemAttribute> orderItemAttributes =
        actualCreateOrderItemResult.getOrderItemAttributes();
    assertEquals(1, orderItemAttributes.size());
    OrderItemAttribute getResult = orderItemAttributes.get("foo");
    assertTrue(getResult instanceof OrderItemAttributeImpl);
    assertEquals("foo", getResult.toString());
    assertEquals("foo", getResult.getName());
    assertEquals("foo", getResult.getValue());
    assertNull(getResult.getId());
    assertSame(bundleOrderItemImpl, getResult.getOrderItem());
  }

  /**
   * Test {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}.
   *
   * <ul>
   *   <li>When {@link OrderItemRequest#OrderItemRequest()}.
   *   <li>Then return {@link BundleOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.createOrderItem(OrderItemRequest)"})
  public void testCreateOrderItem_whenOrderItemRequest_thenReturnBundleOrderItemImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    // Act
    OrderItem actualCreateOrderItemResult =
        orderItemServiceImpl.createOrderItem(new OrderItemRequest());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(null);

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(null, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isNull());
    assertNull(itemRequest.getItemAttributes());
    assertNull(actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getProduct()).thenReturn(new ProductBundleImpl());

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(null);

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(item).getProduct();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertNull(itemRequest.getItemAttributes());
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(item).getProduct();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Map<String, String> itemAttributes2 = itemRequest.getItemAttributes();
    assertEquals(1, itemAttributes2.size());
    assertTrue(itemAttributes2.containsKey("foo"));
    assertSame(itemAttributes, itemAttributes2);
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem4() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    Product product = mock(Product.class);
    when(product.getProductOptions()).thenReturn(productOptionList);

    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getProduct()).thenReturn(product);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(product).getProductOptions();
    verify(productOptionImpl).getAttributeName();
    verify(item).getProduct();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Map<String, String> itemAttributes2 = itemRequest.getItemAttributes();
    assertEquals(1, itemAttributes2.size());
    assertTrue(itemAttributes2.containsKey("foo"));
    assertSame(itemAttributes, itemAttributes2);
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem5() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getProductOptionValidationStrategyType())
        .thenReturn(ProductOptionValidationStrategyType.ADD_ITEM);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    Product product = mock(Product.class);
    when(product.getProductOptions()).thenReturn(productOptionList);

    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getProduct()).thenReturn(product);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(product).getProductOptions();
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getProductOptionValidationStrategyType();
    verify(item).getProduct();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Map<String, String> itemAttributes2 = itemRequest.getItemAttributes();
    assertEquals(1, itemAttributes2.size());
    assertTrue(itemAttributes2.containsKey("foo"));
    assertSame(itemAttributes, itemAttributes2);
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem6() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getProductOptionValidationStrategyType()).thenReturn(null);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    Product product = mock(Product.class);
    when(product.getProductOptions()).thenReturn(productOptionList);

    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getProduct()).thenReturn(product);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(product).getProductOptions();
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getProductOptionValidationStrategyType();
    verify(item).getProduct();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(itemRequest.getItemAttributes().isEmpty());
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem_givenHashMapFooIsNull() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getProductOptionValidationStrategyType())
        .thenReturn(ProductOptionValidationStrategyType.ADD_ITEM);
    when(productOptionImpl.getAttributeName()).thenReturn("foo");

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(productOptionImpl);

    Product product = mock(Product.class);
    when(product.getProductOptions()).thenReturn(productOptionList);

    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getProduct()).thenReturn(product);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", null);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(product).getProductOptions();
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getProductOptionValidationStrategyType();
    verify(item).getProduct();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Map<String, String> itemAttributes2 = itemRequest.getItemAttributes();
    assertEquals(1, itemAttributes2.size());
    assertTrue(itemAttributes2.containsKey("foo"));
    assertSame(itemAttributes, itemAttributes2);
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link OrderItemAttributeImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem_givenHashMapFooIsOrderItemAttributeImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("foo", new OrderItemAttributeImpl());

    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);
    when(item.getProduct()).thenReturn(new ProductBundleImpl());

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(item).getProduct();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Map<String, String> itemAttributes2 = itemRequest.getItemAttributes();
    assertEquals(1, itemAttributes2.size());
    assertTrue(itemAttributes2.containsKey("foo"));
    assertSame(itemAttributes, itemAttributes2);
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <ul>
   *   <li>Then {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()} ItemAttributes Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem_thenDiscreteOrderItemRequestItemAttributesEmpty() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(item, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(item).getProduct();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(itemRequest.getItemAttributes().isEmpty());
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem,
   * DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"
  })
  public void testUpdateDiscreteOrderItem_whenNull_thenReturnNull() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult =
        orderItemServiceImpl.updateDiscreteOrderItem(null, itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isNull());
    assertNull(actualUpdateDiscreteOrderItemResult);
    assertTrue(itemRequest.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)} with {@code
   * AbstractOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(AbstractOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).assignFinalPrice();
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();
    itemRequest.setSku(new SkuImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem((AbstractOrderItemRequest) itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isNull());
    verify(discreteOrderItemImpl).setBaseSalePrice(isNull());
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).updateSaleAndRetailPrices();
    verify(discreteOrderItemImpl).assignFinalPrice();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)} with {@code
   * AbstractOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(AbstractOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("foo", new OrderItemAttributeImpl());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);
    when(discreteOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).assignFinalPrice();
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);
    itemRequest.setSku(new SkuImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem((AbstractOrderItemRequest) itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isNull());
    verify(discreteOrderItemImpl).setBaseSalePrice(isNull());
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).updateSaleAndRetailPrices();
    verify(discreteOrderItemImpl).assignFinalPrice();
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)} with {@code
   * AbstractOrderItemRequest}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(AbstractOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest_givenHashMapFooIsFoo() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).assignFinalPrice();
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);
    itemRequest.setSku(new SkuImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem((AbstractOrderItemRequest) itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isNull());
    verify(discreteOrderItemImpl).setBaseSalePrice(isNull());
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).updateSaleAndRetailPrices();
    verify(discreteOrderItemImpl).assignFinalPrice();
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)} with {@code
   * AbstractOrderItemRequest}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(AbstractOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest_givenHashMapFooIsNull() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).assignFinalPrice();
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", null);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);
    itemRequest.setSku(new SkuImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem((AbstractOrderItemRequest) itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isNull());
    verify(discreteOrderItemImpl).setBaseSalePrice(isNull());
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).updateSaleAndRetailPrices();
    verify(discreteOrderItemImpl).assignFinalPrice();
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)} with {@code
   * AbstractOrderItemRequest}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(AbstractOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest_givenNull() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).assignFinalPrice();
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(null);
    itemRequest.setSku(new SkuImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem((AbstractOrderItemRequest) itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isNull());
    verify(discreteOrderItemImpl).setBaseSalePrice(isNull());
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).updateSaleAndRetailPrices();
    verify(discreteOrderItemImpl).assignFinalPrice();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(new DiscreteOrderItemRequest());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePriceList = new ArrayList<>();
    discreteOrderItemFeePriceList.add(new DiscreteOrderItemFeePriceImpl());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices())
        .thenReturn(discreteOrderItemFeePriceList);
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(new DiscreteOrderItemRequest());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setSalePriceOverride(null);
    itemRequest.setRetailPriceOverride(null);
    itemRequest.setAdditionalAttributes(null);
    itemRequest.setItemAttributes(null);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest4() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setSalePriceOverride(null);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setAdditionalAttributes(null);
    itemRequest.setItemAttributes(null);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(true);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest5() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setAdditionalAttributes(null);
    itemRequest.setItemAttributes(null);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(true);
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(true);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest6() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest7() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("foo", new OrderItemAttributeImpl());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest8() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing()
        .when(discreteOrderItemImpl)
        .setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> additionalAttributes = new HashMap<>();
    additionalAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setSalePriceOverride(null);
    itemRequest.setRetailPriceOverride(null);
    itemRequest.setAdditionalAttributes(additionalAttributes);
    itemRequest.setItemAttributes(null);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setAdditionalAttributes(isA(Map.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest_givenHashMapFooIsNull() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", null);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code
   * DiscreteOrderItemRequest}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"
  })
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest_givenNull() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(null);

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest,
   * HashMap)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)"
  })
  public void testCreateDynamicPriceDiscreteOrderItem_givenHashMapFooIsFoo() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    when(dynamicSkuPricingService.getSkuPrices(
            Mockito.<SkuPriceWrapper>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenReturn(dynamicSkuPrices);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    orderItemServiceImpl.createDynamicPriceDiscreteOrderItem(itemRequest, new HashMap());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(dynamicSkuPricingService).getSkuPrices(isA(SkuPriceWrapper.class), isA(HashMap.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest,
   * HashMap)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)"
  })
  public void testCreateDynamicPriceDiscreteOrderItem_givenHashMapFooIsNull() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    when(dynamicSkuPricingService.getSkuPrices(
            Mockito.<SkuPriceWrapper>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenReturn(dynamicSkuPrices);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", null);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    orderItemServiceImpl.createDynamicPriceDiscreteOrderItem(itemRequest, new HashMap());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(dynamicSkuPricingService).getSkuPrices(isA(SkuPriceWrapper.class), isA(HashMap.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest,
   * HashMap)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link OrderItemAttributeImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)"
  })
  public void testCreateDynamicPriceDiscreteOrderItem_givenHashMapFooIsOrderItemAttributeImpl() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    when(dynamicSkuPricingService.getSkuPrices(
            Mockito.<SkuPriceWrapper>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenReturn(dynamicSkuPrices);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("foo", new OrderItemAttributeImpl());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> itemAttributes = new HashMap<>();
    itemAttributes.put("foo", "foo");

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(itemAttributes);

    // Act
    orderItemServiceImpl.createDynamicPriceDiscreteOrderItem(itemRequest, new HashMap());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(dynamicSkuPricingService).getSkuPrices(isA(SkuPriceWrapper.class), isA(HashMap.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest,
   * HashMap)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link OrderItemServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)"
  })
  public void testCreateDynamicPriceDiscreteOrderItem_givenNull_thenCallsGetProxy() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    when(dynamicSkuPricingService.getSkuPrices(
            Mockito.<SkuPriceWrapper>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenReturn(dynamicSkuPrices);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setItemAttributes(null);

    // Act
    orderItemServiceImpl.createDynamicPriceDiscreteOrderItem(itemRequest, new HashMap());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(dynamicSkuPricingService).getSkuPrices(isA(SkuPriceWrapper.class), isA(HashMap.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest,
   * HashMap)}.
   *
   * <ul>
   *   <li>Then calls {@link DiscreteOrderItemImpl#getRetailPrice()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)"
  })
  public void testCreateDynamicPriceDiscreteOrderItem_thenCallsGetRetailPrice() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    when(dynamicSkuPricingService.getSkuPrices(
            Mockito.<SkuPriceWrapper>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenReturn(dynamicSkuPrices);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getRetailPrice()).thenReturn(new Money());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(new Money());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money(10.0d));

    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePrices = new ArrayList<>();
    discreteOrderItemFeePrices.add(discreteOrderItemFeePriceImpl);

    DiscreteOrderItemRequest itemRequest =
        new DiscreteOrderItemRequest(new DiscreteOrderItemRequest());
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setDiscreteOrderItemFeePrices(discreteOrderItemFeePrices);
    itemRequest.setItemAttributes(null);

    // Act
    orderItemServiceImpl.createDynamicPriceDiscreteOrderItem(itemRequest, new HashMap());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(dynamicSkuPricingService).getSkuPrices(isA(SkuPriceWrapper.class), isA(HashMap.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).getRetailPrice();
    verify(discreteOrderItemImpl).getSalePrice();
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(discreteOrderItemImpl, atLeast(1)).setRetailPrice(Mockito.<Money>any());
    verify(discreteOrderItemImpl).setRetailPriceOverride(true);
    verify(discreteOrderItemImpl, atLeast(1)).setSalePrice(Mockito.<Money>any());
    verify(discreteOrderItemImpl).setSalePriceOverride(true);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest,
   * HashMap)}.
   *
   * <ul>
   *   <li>When {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscreteOrderItem OrderItemServiceImpl.createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)"
  })
  public void testCreateDynamicPriceDiscreteOrderItem_whenDiscreteOrderItemRequest() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    when(dynamicSkuPricingService.getSkuPrices(
            Mockito.<SkuPriceWrapper>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenReturn(dynamicSkuPrices);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act
    orderItemServiceImpl.createDynamicPriceDiscreteOrderItem(itemRequest, new HashMap());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(dynamicSkuPricingService).getSkuPrices(isA(SkuPriceWrapper.class), isA(HashMap.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder((Order) isNull());
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(0);
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.order.domain.GiftWrapOrderItem OrderItemServiceImpl.createGiftWrapOrderItem(GiftWrapOrderItemRequest)"
  })
  public void testCreateGiftWrapOrderItem_givenArrayListAddBundleOrderItemImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = mock(GiftWrapOrderItemImpl.class);
    when(giftWrapOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(giftWrapOrderItemImpl.getWrappedItems()).thenReturn(orderItemList);
    doNothing().when(giftWrapOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(giftWrapOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(giftWrapOrderItemImpl).assignFinalPrice();
    doNothing().when(giftWrapOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(giftWrapOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(giftWrapOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(giftWrapOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(giftWrapOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(giftWrapOrderItemImpl);

    SkuImpl sku = new SkuImpl();
    sku.setId(1L);

    GiftWrapOrderItemRequest itemRequest = new GiftWrapOrderItemRequest();
    itemRequest.setSku(sku);

    // Act
    orderItemServiceImpl.createGiftWrapOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(giftWrapOrderItemImpl).setBaseRetailPrice(isNull());
    verify(giftWrapOrderItemImpl).setBaseSalePrice(isNull());
    verify(giftWrapOrderItemImpl).setBundleOrderItem(isNull());
    verify(giftWrapOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(giftWrapOrderItemImpl).setOrder((Order) isNull());
    verify(giftWrapOrderItemImpl).setProduct(isNull());
    verify(giftWrapOrderItemImpl).setSku(isA(Sku.class));
    verify(giftWrapOrderItemImpl).updateSaleAndRetailPrices();
    verify(giftWrapOrderItemImpl, atLeast(1)).getWrappedItems();
    verify(giftWrapOrderItemImpl).assignFinalPrice();
    verify(giftWrapOrderItemImpl).setCategory(isNull());
    verify(giftWrapOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderItemServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.order.domain.GiftWrapOrderItem OrderItemServiceImpl.createGiftWrapOrderItem(GiftWrapOrderItemRequest)"
  })
  public void testCreateGiftWrapOrderItem_thenCallsGetProxy() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = mock(GiftWrapOrderItemImpl.class);
    when(giftWrapOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(giftWrapOrderItemImpl.getWrappedItems()).thenReturn(new ArrayList<>());
    doNothing().when(giftWrapOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(giftWrapOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(giftWrapOrderItemImpl).assignFinalPrice();
    doNothing().when(giftWrapOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(giftWrapOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(giftWrapOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(giftWrapOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(giftWrapOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(giftWrapOrderItemImpl);

    SkuImpl sku = new SkuImpl();
    sku.setId(1L);

    GiftWrapOrderItemRequest itemRequest = new GiftWrapOrderItemRequest();
    itemRequest.setSku(sku);

    // Act
    orderItemServiceImpl.createGiftWrapOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(giftWrapOrderItemImpl).setBaseRetailPrice(isNull());
    verify(giftWrapOrderItemImpl).setBaseSalePrice(isNull());
    verify(giftWrapOrderItemImpl).setBundleOrderItem(isNull());
    verify(giftWrapOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(giftWrapOrderItemImpl).setOrder((Order) isNull());
    verify(giftWrapOrderItemImpl).setProduct(isNull());
    verify(giftWrapOrderItemImpl).setSku(isA(Sku.class));
    verify(giftWrapOrderItemImpl).updateSaleAndRetailPrices();
    verify(giftWrapOrderItemImpl, atLeast(1)).getWrappedItems();
    verify(giftWrapOrderItemImpl).assignFinalPrice();
    verify(giftWrapOrderItemImpl).setCategory(isNull());
    verify(giftWrapOrderItemImpl).setQuantity(0);
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link GiftWrapOrderItemImpl#setRetailPrice(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.order.domain.GiftWrapOrderItem OrderItemServiceImpl.createGiftWrapOrderItem(GiftWrapOrderItemRequest)"
  })
  public void testCreateGiftWrapOrderItem_thenCallsSetRetailPrice() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = mock(GiftWrapOrderItemImpl.class);
    doNothing().when(giftWrapOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(giftWrapOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(giftWrapOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(giftWrapOrderItemImpl.getWrappedItems()).thenReturn(new ArrayList<>());
    doNothing().when(giftWrapOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(giftWrapOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(giftWrapOrderItemImpl).assignFinalPrice();
    doNothing().when(giftWrapOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(giftWrapOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(giftWrapOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(giftWrapOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(giftWrapOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(giftWrapOrderItemImpl);

    SkuImpl sku = new SkuImpl();
    sku.setId(1L);

    GiftWrapOrderItemRequest itemRequest = new GiftWrapOrderItemRequest();
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(sku);

    // Act
    orderItemServiceImpl.createGiftWrapOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(giftWrapOrderItemImpl, atLeast(1)).setBaseRetailPrice(Mockito.<Money>any());
    verify(giftWrapOrderItemImpl, atLeast(1)).setBaseSalePrice(Mockito.<Money>any());
    verify(giftWrapOrderItemImpl).setBundleOrderItem(isNull());
    verify(giftWrapOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(giftWrapOrderItemImpl).setOrder((Order) isNull());
    verify(giftWrapOrderItemImpl).setProduct(isNull());
    verify(giftWrapOrderItemImpl).setSku(isA(Sku.class));
    verify(giftWrapOrderItemImpl).updateSaleAndRetailPrices();
    verify(giftWrapOrderItemImpl, atLeast(1)).getWrappedItems();
    verify(giftWrapOrderItemImpl).assignFinalPrice();
    verify(giftWrapOrderItemImpl).setCategory(isNull());
    verify(giftWrapOrderItemImpl).setQuantity(0);
    verify(giftWrapOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setRetailPriceOverride(true);
    verify(giftWrapOrderItemImpl).setSalePrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setSalePriceOverride(true);
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link GiftWrapOrderItemImpl#setSalePrice(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.order.domain.GiftWrapOrderItem OrderItemServiceImpl.createGiftWrapOrderItem(GiftWrapOrderItemRequest)"
  })
  public void testCreateGiftWrapOrderItem_thenCallsSetSalePrice() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = mock(GiftWrapOrderItemImpl.class);
    doNothing().when(giftWrapOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(giftWrapOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(giftWrapOrderItemImpl.getWrappedItems()).thenReturn(new ArrayList<>());
    doNothing().when(giftWrapOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing()
        .when(giftWrapOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(giftWrapOrderItemImpl).assignFinalPrice();
    doNothing().when(giftWrapOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(giftWrapOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(giftWrapOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing()
        .when(giftWrapOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(giftWrapOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(giftWrapOrderItemImpl);

    SkuImpl sku = new SkuImpl();
    sku.setId(1L);

    GiftWrapOrderItemRequest itemRequest = new GiftWrapOrderItemRequest();
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(sku);

    // Act
    orderItemServiceImpl.createGiftWrapOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(giftWrapOrderItemImpl).setBaseRetailPrice(isNull());
    verify(giftWrapOrderItemImpl, atLeast(1)).setBaseSalePrice(Mockito.<Money>any());
    verify(giftWrapOrderItemImpl).setBundleOrderItem(isNull());
    verify(giftWrapOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(giftWrapOrderItemImpl).setOrder((Order) isNull());
    verify(giftWrapOrderItemImpl).setProduct(isNull());
    verify(giftWrapOrderItemImpl).setSku(isA(Sku.class));
    verify(giftWrapOrderItemImpl).updateSaleAndRetailPrices();
    verify(giftWrapOrderItemImpl, atLeast(1)).getWrappedItems();
    verify(giftWrapOrderItemImpl).assignFinalPrice();
    verify(giftWrapOrderItemImpl).setCategory(isNull());
    verify(giftWrapOrderItemImpl).setQuantity(0);
    verify(giftWrapOrderItemImpl).setSalePrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setSalePriceOverride(true);
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)} with {@code
   * BundleOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(BundleOrderItemRequest)"
  })
  public void testCreateBundleOrderItemWithBundleOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    BundleOrderItemRequest itemRequest = new BundleOrderItemRequest();
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    Money retailPriceOverride = new Money();
    itemRequest.setRetailPriceOverride(retailPriceOverride);
    itemRequest.setSalePriceOverride(new Money());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult =
        orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateBundleOrderItemResult instanceof BundleOrderItemImpl);
    assertEquals(retailPriceOverride, actualCreateBundleOrderItemResult.getBaseRetailPrice());
    assertEquals(retailPriceOverride, actualCreateBundleOrderItemResult.getBaseSalePrice());
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)} with {@code
   * BundleOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(BundleOrderItemRequest)"
  })
  public void testCreateBundleOrderItemWithBundleOrderItemRequest2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    BundleOrderItemRequest itemRequest = new BundleOrderItemRequest();
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(null);
    Money salePriceOverride = new Money();
    itemRequest.setSalePriceOverride(salePriceOverride);

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult =
        orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateBundleOrderItemResult instanceof BundleOrderItemImpl);
    assertNull(actualCreateBundleOrderItemResult.getBaseRetailPrice());
    Money baseSalePrice = actualCreateBundleOrderItemResult.getBaseSalePrice();
    Money absResult = baseSalePrice.abs();
    assertEquals(salePriceOverride, absResult.abs());
    Money zeroResult = baseSalePrice.zero();
    assertEquals(salePriceOverride, zeroResult.abs());
    assertEquals(salePriceOverride, absResult.zero());
    assertEquals(salePriceOverride, zeroResult.zero());
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)} with {@code
   * BundleOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(BundleOrderItemRequest)"
  })
  public void testCreateBundleOrderItemWithBundleOrderItemRequest3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    BundleOrderItemRequest itemRequest = new BundleOrderItemRequest();
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    Money retailPriceOverride = new Money();
    itemRequest.setRetailPriceOverride(retailPriceOverride);
    itemRequest.setSalePriceOverride(null);

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult =
        orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateBundleOrderItemResult instanceof BundleOrderItemImpl);
    assertNull(actualCreateBundleOrderItemResult.getBaseSalePrice());
    Money baseRetailPrice = actualCreateBundleOrderItemResult.getBaseRetailPrice();
    Money absResult = baseRetailPrice.abs();
    assertEquals(retailPriceOverride, absResult.abs());
    Money zeroResult = baseRetailPrice.zero();
    assertEquals(retailPriceOverride, zeroResult.abs());
    assertEquals(retailPriceOverride, absResult.zero());
    assertEquals(retailPriceOverride, zeroResult.zero());
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)} with
   * {@code ProductBundleOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest)"
  })
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest itemRequest = new ProductBundleOrderItemRequest();
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setProductBundle(new ProductBundleImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(new SkuImpl());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult =
        orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)} with
   * {@code ProductBundleOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest)"
  })
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequest2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest itemRequest = new ProductBundleOrderItemRequest();
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setProductBundle(new ProductBundleImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(null);
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(new SkuImpl());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult =
        orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)} with
   * {@code ProductBundleOrderItemRequest}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest)"
  })
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequest3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest itemRequest = new ProductBundleOrderItemRequest();
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setProductBundle(new ProductBundleImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(null);
    itemRequest.setSku(new SkuImpl());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult =
        orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   * with {@code ProductBundleOrderItemRequest}, {@code boolean}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest, boolean)"
  })
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequestBoolean() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest itemRequest = new ProductBundleOrderItemRequest();
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setProductBundle(new ProductBundleImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(new SkuImpl());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult =
        orderItemServiceImpl.createBundleOrderItem(itemRequest, true);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   * with {@code ProductBundleOrderItemRequest}, {@code boolean}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest, boolean)"
  })
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequestBoolean2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest itemRequest = new ProductBundleOrderItemRequest();
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setProductBundle(new ProductBundleImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(null);
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(new SkuImpl());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult =
        orderItemServiceImpl.createBundleOrderItem(itemRequest, true);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   * with {@code ProductBundleOrderItemRequest}, {@code boolean}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest, boolean)"
  })
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequestBoolean3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest itemRequest = new ProductBundleOrderItemRequest();
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setProductBundle(new ProductBundleImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(null);
    itemRequest.setSku(new SkuImpl());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult =
        orderItemServiceImpl.createBundleOrderItem(itemRequest, true);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"
  })
  public void testBuildOrderItemRequestDTOFromOrderItem() {
    // Arrange
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
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult =
        orderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    Map<String, String> additionalAttributes =
        actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes();
    assertEquals(1, additionalAttributes.size());
    assertEquals("foo", additionalAttributes.get("foo"));
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   *
   * <ul>
   *   <li>Then return ChildOrderItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"
  })
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnChildOrderItemsEmpty() {
    // Arrange
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult =
        orderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getChildOrderItems().isEmpty());
    assertTrue(
        actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   *
   * <ul>
   *   <li>Then return ChildOrderItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"
  })
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnChildOrderItemsSizeIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(new NullOrderImpl());

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable2);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setOrderItemAttributes(null);
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    item.setBaseRetailPrice(baseRetailPrice);
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
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
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setOrderItemAttributes(null);
    item.setChildOrderItems(childOrderItems2);

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult =
        orderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    List<OrderItemRequestDTO> childOrderItems3 =
        actualBuildOrderItemRequestDTOFromOrderItemResult.getChildOrderItems();
    assertEquals(1, childOrderItems3.size());
    assertTrue(childOrderItems3.get(0) instanceof NonDiscreteOrderItemRequestDTO);
    assertTrue(
        actualBuildOrderItemRequestDTOFromOrderItemResult
            instanceof NonDiscreteOrderItemRequestDTO);
    assertEquals(
        "Name",
        ((NonDiscreteOrderItemRequestDTO) actualBuildOrderItemRequestDTOFromOrderItemResult)
            .getItemName());
    assertEquals(
        baseRetailPrice,
        actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   *
   * <ul>
   *   <li>Then return ItemAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"
  })
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnItemAttributesSizeIsOne() {
    // Arrange
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
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult =
        orderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    Map<String, String> itemAttributes =
        actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes();
    assertEquals(1, itemAttributes.size());
    assertNull(itemAttributes.get("foo"));
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   *
   * <ul>
   *   <li>Then return ItemName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"
  })
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnItemNameIsNull() {
    // Arrange
    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setOrder(new NullOrderImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult =
        orderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    assertTrue(
        actualBuildOrderItemRequestDTOFromOrderItemResult
            instanceof NonDiscreteOrderItemRequestDTO);
    assertNull(
        ((NonDiscreteOrderItemRequestDTO) actualBuildOrderItemRequestDTOFromOrderItemResult)
            .getItemName());
    Money overrideRetailPrice =
        actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice();
    Money actualAbsResult = overrideRetailPrice.abs();
    assertEquals(overrideRetailPrice, actualAbsResult);
    Money actualZeroResult = overrideRetailPrice.zero();
    assertEquals(overrideRetailPrice, actualZeroResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   *
   * <ul>
   *   <li>Then return Quantity intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"
  })
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnQuantityIntValueIsZero() {
    // Arrange and Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult =
        orderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(new DiscreteOrderItemImpl());

    // Assert
    assertEquals(0, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getChildOrderItems().isEmpty());
    assertTrue(
        actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then ParentOrderItem return {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"
  })
  public void testBuildOrderItemFromDTO_thenParentOrderItemReturnBundleOrderItemImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setParentOrderItemId(1L);

    // Act
    OrderItem actualBuildOrderItemFromDTOResult =
        orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(catalogService).findCategoryById(1L);
    verify(catalogService).findProductById(1L);
    verify(catalogService).findSkuById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).readOrderItemById(1L);
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    OrderItem parentOrderItem = actualBuildOrderItemFromDTOResult.getParentOrderItem();
    assertTrue(parentOrderItem instanceof BundleOrderItemImpl);
    assertTrue(actualBuildOrderItemFromDTOResult instanceof BundleOrderItemImpl);
    assertTrue(actualBuildOrderItemFromDTOResult.isChildOrderItem());
    assertSame(bundleOrderItemImpl, parentOrderItem);
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then Product return {@link ProductImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"
  })
  public void testBuildOrderItemFromDTO_thenProductReturnProductImpl() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    ProductImpl productImpl = new ProductImpl();
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productImpl);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new DiscreteOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setParentOrderItemId(null);

    // Act
    OrderItem actualBuildOrderItemFromDTOResult =
        orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findCategoryById(1L);
    verify(catalogService).findProductById(1L);
    verify(catalogService).findSkuById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Product product = ((DiscreteOrderItemImpl) actualBuildOrderItemFromDTOResult).getProduct();
    assertTrue(product instanceof ProductImpl);
    assertTrue(actualBuildOrderItemFromDTOResult instanceof DiscreteOrderItemImpl);
    assertSame(productImpl, product);
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then return Category is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"
  })
  public void testBuildOrderItemFromDTO_thenReturnCategoryIsNull() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    ProductImpl productImpl = new ProductImpl();
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productImpl);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new DiscreteOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setParentOrderItemId(null);

    // Act
    OrderItem actualBuildOrderItemFromDTOResult =
        orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findProductById(1L);
    verify(catalogService).findSkuById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Product product = ((DiscreteOrderItemImpl) actualBuildOrderItemFromDTOResult).getProduct();
    assertTrue(product instanceof ProductImpl);
    assertTrue(actualBuildOrderItemFromDTOResult instanceof DiscreteOrderItemImpl);
    assertNull(actualBuildOrderItemFromDTOResult.getCategory());
    assertSame(productImpl, product);
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then return {@link DiscreteOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"
  })
  public void testBuildOrderItemFromDTO_thenReturnDiscreteOrderItemImpl() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setParentOrderItemId(null);

    // Act
    OrderItem actualBuildOrderItemFromDTOResult =
        orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findCategoryById(1L);
    verify(catalogService).findSkuById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(discreteOrderItemImpl, actualBuildOrderItemFromDTOResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then return RetailPrice is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"
  })
  public void testBuildOrderItemFromDTO_thenReturnRetailPriceIsNull() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setParentOrderItemId(null);

    // Act
    OrderItem actualBuildOrderItemFromDTOResult =
        orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getName();
    verify(catalogService).findProductById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualBuildOrderItemFromDTOResult instanceof BundleOrderItemImpl);
    assertNull(actualBuildOrderItemFromDTOResult.getRetailPrice());
    assertNull(actualBuildOrderItemFromDTOResult.getSalePrice());
    assertNull(((BundleOrderItemImpl) actualBuildOrderItemFromDTOResult).getSku());
    assertTrue(actualBuildOrderItemFromDTOResult.isSkuActive());
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then Sku return {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"
  })
  public void testBuildOrderItemFromDTO_thenSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setParentOrderItemId(null);

    // Act
    OrderItem actualBuildOrderItemFromDTOResult =
        orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getName();
    verify(catalogService).findProductById(1L);
    verify(catalogService).findSkuById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Sku sku = ((BundleOrderItemImpl) actualBuildOrderItemFromDTOResult).getSku();
    assertTrue(sku instanceof SkuImpl);
    assertTrue(actualBuildOrderItemFromDTOResult instanceof BundleOrderItemImpl);
    assertFalse(actualBuildOrderItemFromDTOResult.isSkuActive());
    assertSame(skuImpl, sku);
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then Sku return {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"
  })
  public void testBuildOrderItemFromDTO_thenSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setParentOrderItemId(null);

    // Act
    OrderItem actualBuildOrderItemFromDTOResult =
        orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(catalogService).findCategoryById(1L);
    verify(catalogService).findProductById(1L);
    verify(catalogService).findSkuById(1L);
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler, atLeast(1))
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
    Sku sku = ((BundleOrderItemImpl) actualBuildOrderItemFromDTOResult).getSku();
    assertTrue(sku instanceof SkuImpl);
    assertTrue(actualBuildOrderItemFromDTOResult instanceof BundleOrderItemImpl);
    assertFalse(actualBuildOrderItemFromDTOResult.isSkuActive());
    assertSame(skuImpl, sku);
  }

  /**
   * Test {@link OrderItemServiceImpl#priceOrderItem(OrderItem)}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#priceOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemServiceImpl.priceOrderItem(OrderItem)"})
  public void testPriceOrderItem() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.modifyOrderItemPrices(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    // Act
    orderItemServiceImpl.priceOrderItem(new BundleOrderItemImpl());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemServiceExtensionHandler).modifyOrderItemPrices(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set OrderItemServiceImpl.findAllProductsInRequest(ConfigurableOrderItemRequest)"
  })
  public void testFindAllProductsInRequest() {
    // Arrange
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
    itemRequest.setProduct(new ProductBundleImpl());
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSku(new SkuImpl());
    itemRequest.setSkuId(1L);

    // Act and Assert
    assertEquals(1, orderItemServiceImpl.findAllProductsInRequest(itemRequest).size());
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set OrderItemServiceImpl.findAllProductsInRequest(ConfigurableOrderItemRequest)"
  })
  public void testFindAllProductsInRequest2() {
    // Arrange
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
    configurableOrderItemRequest.setSku(new SkuImpl());
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
    itemRequest.setProduct(new ProductBundleImpl());
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSku(new SkuImpl());
    itemRequest.setSkuId(1L);
    itemRequest.setChildOrderItems(childOrderItems);

    // Act and Assert
    assertEquals(1, orderItemServiceImpl.findAllProductsInRequest(itemRequest).size());
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set OrderItemServiceImpl.findAllChildProductsInRequest(List)"})
  public void testFindAllChildProductsInRequest_thenReturnSizeIsOne() {
    // Arrange
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
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());

    ArrayList<OrderItemRequestDTO> childItems = new ArrayList<>();
    childItems.add(configurableOrderItemRequest);

    // Act and Assert
    assertEquals(1, orderItemServiceImpl.findAllChildProductsInRequest(childItems).size());
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set OrderItemServiceImpl.findAllChildProductsInRequest(List)"})
  public void testFindAllChildProductsInRequest_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(orderItemServiceImpl.findAllChildProductsInRequest(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#applyAdditionalOrderItemProperties(OrderItem)}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#applyAdditionalOrderItemProperties(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemServiceImpl.applyAdditionalOrderItemProperties(OrderItem)"})
  public void testApplyAdditionalOrderItemProperties() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(
            Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    // Act
    orderItemServiceImpl.applyAdditionalOrderItemProperties(new BundleOrderItemImpl());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemServiceExtensionHandler)
        .applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}.
   *
   * <ul>
   *   <li>Then return MaxQuantity is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConfigurableOrderItemRequest OrderItemServiceImpl.createConfigurableOrderItemRequestFromProduct(Product)"
  })
  public void testCreateConfigurableOrderItemRequestFromProduct_thenReturnMaxQuantityIsNull() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    ConfigurableOrderItemRequest actualCreateConfigurableOrderItemRequestFromProductResult =
        orderItemServiceImpl.createConfigurableOrderItemRequestFromProduct(product);

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
    assertEquals(
        0, actualCreateConfigurableOrderItemRequestFromProductResult.getMinQuantity().intValue());
    assertEquals(
        1, actualCreateConfigurableOrderItemRequestFromProductResult.getQuantity().intValue());
    assertEquals(
        1L, actualCreateConfigurableOrderItemRequestFromProductResult.getProductId().longValue());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getDiscountsAllowed());
    assertFalse(
        actualCreateConfigurableOrderItemRequestFromProductResult.getHasConfigurationError());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getHasOverridenPrice());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getIsMultiSelect());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.isExpandable());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.isFirstExpandable());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.isLastExpandable());
    assertTrue(
        actualCreateConfigurableOrderItemRequestFromProductResult.getChildOrderItems().isEmpty());
    assertTrue(
        actualCreateConfigurableOrderItemRequestFromProductResult
            .getAdditionalAttributes()
            .isEmpty());
    assertTrue(
        actualCreateConfigurableOrderItemRequestFromProductResult.getItemAttributes().isEmpty());
    assertSame(product, actualCreateConfigurableOrderItemRequestFromProductResult.getProduct());
  }

  /**
   * Test {@link OrderItemServiceImpl#modifyOrderItemRequest(ConfigurableOrderItemRequest)}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#modifyOrderItemRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemServiceImpl.modifyOrderItemRequest(ConfigurableOrderItemRequest)"
  })
  public void testModifyOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.modifyOrderItemRequest(
            Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

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
    itemRequest.setProduct(new ProductBundleImpl());
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSku(new SkuImpl());
    itemRequest.setSkuId(1L);

    // Act
    orderItemServiceImpl.modifyOrderItemRequest(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemServiceExtensionHandler)
        .modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#mergeOrderItemRequest(ConfigurableOrderItemRequest,
   * OrderItem)}.
   *
   * <p>Method under test: {@link
   * OrderItemServiceImpl#mergeOrderItemRequest(ConfigurableOrderItemRequest, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemServiceImpl.mergeOrderItemRequest(ConfigurableOrderItemRequest, OrderItem)"
  })
  public void testMergeOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler =
        mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.mergeOrderItemRequest(
            Mockito.<ConfigurableOrderItemRequest>any(), Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

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
    itemRequest.setProduct(new ProductBundleImpl());
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSku(new SkuImpl());
    itemRequest.setSkuId(1L);

    // Act
    orderItemServiceImpl.mergeOrderItemRequest(itemRequest, new BundleOrderItemImpl());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemServiceExtensionHandler)
        .mergeOrderItemRequest(isA(ConfigurableOrderItemRequest.class), isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List,
   * Date, Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderItemServiceImpl.findOrderItemsForCustomersInDateRange(List, Date, Date)"
  })
  public void testFindOrderItemsForCustomersInDateRange_givenOne_whenArrayListAddOne() {
    // Arrange
    when(orderItemDao.readOrderItemsForCustomersInDateRange(
            Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> customerIds = new ArrayList<>();
    customerIds.add(1L);
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<OrderItem> actualFindOrderItemsForCustomersInDateRangeResult =
        orderItemServiceImpl.findOrderItemsForCustomersInDateRange(
            customerIds,
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderItemDao)
        .readOrderItemsForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrderItemsForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List,
   * Date, Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderItemServiceImpl.findOrderItemsForCustomersInDateRange(List, Date, Date)"
  })
  public void testFindOrderItemsForCustomersInDateRange_givenZero_whenArrayListAddZero() {
    // Arrange
    when(orderItemDao.readOrderItemsForCustomersInDateRange(
            Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> customerIds = new ArrayList<>();
    customerIds.add(0L);
    customerIds.add(1L);
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<OrderItem> actualFindOrderItemsForCustomersInDateRangeResult =
        orderItemServiceImpl.findOrderItemsForCustomersInDateRange(
            customerIds,
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderItemDao)
        .readOrderItemsForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrderItemsForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List,
   * Date, Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderItemServiceImpl.findOrderItemsForCustomersInDateRange(List, Date, Date)"
  })
  public void testFindOrderItemsForCustomersInDateRange_whenArrayList() {
    // Arrange
    when(orderItemDao.readOrderItemsForCustomersInDateRange(
            Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> customerIds = new ArrayList<>();
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<OrderItem> actualFindOrderItemsForCustomersInDateRangeResult =
        orderItemServiceImpl.findOrderItemsForCustomersInDateRange(
            customerIds,
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderItemDao)
        .readOrderItemsForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrderItemsForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}.
   *
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link OrderStatus#ARCHIVED}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderItemServiceImpl.readBatchOrderItems(int, int, List)"})
  public void testReadBatchOrderItems_givenArchived_whenArrayListAddArchived() {
    // Arrange
    when(orderItemDao.readBatchOrderItems(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<OrderStatus> orderStatusList = new ArrayList<>();
    orderStatusList.add(OrderStatus.ARCHIVED);

    // Act
    List<OrderItem> actualReadBatchOrderItemsResult =
        orderItemServiceImpl.readBatchOrderItems(1, 3, orderStatusList);

    // Assert
    verify(orderItemDao).readBatchOrderItems(eq(1), eq(3), isA(List.class));
    assertTrue(actualReadBatchOrderItemsResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}.
   *
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link OrderStatus#ARCHIVED}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderItemServiceImpl.readBatchOrderItems(int, int, List)"})
  public void testReadBatchOrderItems_givenArchived_whenArrayListAddArchived2() {
    // Arrange
    when(orderItemDao.readBatchOrderItems(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<OrderStatus> orderStatusList = new ArrayList<>();
    orderStatusList.add(OrderStatus.ARCHIVED);
    orderStatusList.add(OrderStatus.ARCHIVED);

    // Act
    List<OrderItem> actualReadBatchOrderItemsResult =
        orderItemServiceImpl.readBatchOrderItems(1, 3, orderStatusList);

    // Assert
    verify(orderItemDao).readBatchOrderItems(eq(1), eq(3), isA(List.class));
    assertTrue(actualReadBatchOrderItemsResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderItemServiceImpl.readBatchOrderItems(int, int, List)"})
  public void testReadBatchOrderItems_whenArrayList() {
    // Arrange
    when(orderItemDao.readBatchOrderItems(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OrderItem> actualReadBatchOrderItemsResult =
        orderItemServiceImpl.readBatchOrderItems(1, 3, new ArrayList<>());

    // Assert
    verify(orderItemDao).readBatchOrderItems(eq(1), eq(3), isA(List.class));
    assertTrue(actualReadBatchOrderItemsResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#readNumberOfOrderItems()}.
   *
   * <p>Method under test: {@link OrderItemServiceImpl#readNumberOfOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OrderItemServiceImpl.readNumberOfOrderItems()"})
  public void testReadNumberOfOrderItems() {
    // Arrange
    when(orderItemDao.readNumberOfOrderItems()).thenReturn(1L);

    // Act
    Long actualReadNumberOfOrderItemsResult = orderItemServiceImpl.readNumberOfOrderItems();

    // Assert
    verify(orderItemDao).readNumberOfOrderItems();
    assertEquals(1L, actualReadNumberOfOrderItemsResult.longValue());
  }
}
