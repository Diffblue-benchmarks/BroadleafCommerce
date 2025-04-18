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
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundle;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.pricing.SkuPriceWrapper;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPrices;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPricingService;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemFeePrice;
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
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
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
  @Mock
  private CatalogService catalogService;

  @Mock
  private DynamicSkuPricingService dynamicSkuPricingService;

  @Mock
  private OrderItemDao orderItemDao;

  @Mock
  private OrderItemServiceExtensionManager orderItemServiceExtensionManager;

  @InjectMocks
  private OrderItemServiceImpl orderItemServiceImpl;

  /**
   * Test {@link OrderItemServiceImpl#readOrderItemById(Long)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#readOrderItemById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.readOrderItemById(Long)"})
  public void testReadOrderItemById() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);

    // Act
    OrderItem actualReadOrderItemByIdResult = orderItemServiceImpl.readOrderItemById(1L);

    // Assert
    verify(orderItemDao).readOrderItemById(eq(1L));
    assertSame(bundleOrderItemImpl, actualReadOrderItemByIdResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#saveOrderItem(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#saveOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.saveOrderItem(OrderItem)"})
  public void testSaveOrderItem() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);

    // Act
    OrderItem actualSaveOrderItemResult = orderItemServiceImpl.saveOrderItem(new BundleOrderItemImpl());

    // Assert
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualSaveOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#delete(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#delete(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createPersonalMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersonalMessage OrderItemServiceImpl.createPersonalMessage()"})
  public void testCreatePersonalMessage() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    when(orderItemDao.createPersonalMessage()).thenReturn(personalMessageImpl);

    // Act
    PersonalMessage actualCreatePersonalMessageResult = orderItemServiceImpl.createPersonalMessage();

    // Assert
    verify(orderItemDao).createPersonalMessage();
    assertSame(personalMessageImpl, actualCreatePersonalMessageResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem, AbstractOrderItemRequest)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#populateDiscreteOrderItem(DiscreteOrderItem, AbstractOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderItemServiceImpl.populateDiscreteOrderItem(DiscreteOrderItem, AbstractOrderItemRequest)"})
  public void testPopulateDiscreteOrderItem_thenCallsGetProxy() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    doNothing().when(item).setOrder(Mockito.<Order>any());
    doNothing().when(item).setProduct(Mockito.<Product>any());
    doNothing().when(item).setSku(Mockito.<Sku>any());
    doNothing().when(item).setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(item).setQuantity(anyInt());

    // Act
    orderItemServiceImpl.populateDiscreteOrderItem(item, new DiscreteOrderItemRequest());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(item).setOrder((Order) isNull());
    verify(item).setProduct(isNull());
    verify(item).setSku(isNull());
    verify(item).setCategory(isNull());
    verify(item).setQuantity(eq(0));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemServiceImpl.populateProductOptionAttributes(OrderItem, Map)"})
  public void testPopulateProductOptionAttributes() {
    // Arrange
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
   * <p>
   * Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#populateProductOptionAttributes(OrderItem, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return OrderItemAttributes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.createOrderItem(OrderItemRequest)"})
  public void testCreateOrderItem_givenHashMapFooIsFoo_thenReturnOrderItemAttributesSizeIsOne() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(bundleOrderItemImpl);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    OrderItemRequest itemRequest = mock(OrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemName()).thenReturn("Item Name");
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    OrderItem actualCreateOrderItemResult = orderItemServiceImpl.createOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(itemRequest, atLeast(1)).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).getItemName();
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateOrderItemResult instanceof BundleOrderItemImpl);
    Map<String, OrderItemAttribute> orderItemAttributes = actualCreateOrderItemResult.getOrderItemAttributes();
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
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return Price zero abs zero abs abs is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.createOrderItem(OrderItemRequest)"})
  public void testCreateOrderItem_givenHashMap_thenReturnPriceZeroAbsZeroAbsAbsIsMoney() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    OrderItemRequest itemRequest = mock(OrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemName()).thenReturn("Item Name");
    when(itemRequest.getItemAttributes()).thenReturn(new HashMap<>());
    Money money = new Money();
    when(itemRequest.getRetailPriceOverride()).thenReturn(money);
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    OrderItem actualCreateOrderItemResult = orderItemServiceImpl.createOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).getItemName();
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateOrderItemResult instanceof BundleOrderItemImpl);
    Money absResult = actualCreateOrderItemResult.getPrice().zero().abs();
    assertEquals(money, absResult.zero().abs().abs());
    assertEquals(money, absResult.abs().zero().zero());
  }

  /**
   * Test {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}.
   * <ul>
   *   <li>When {@link OrderItemRequest#OrderItemRequest()}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.createOrderItem(OrderItemRequest)"})
  public void testCreateOrderItem_whenOrderItemRequest_thenReturnNameIsNull() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    // Act
    OrderItem actualCreateOrderItemResult = orderItemServiceImpl.createOrderItem(new OrderItemRequest());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateOrderItemResult instanceof BundleOrderItemImpl);
    assertNull(actualCreateOrderItemResult.getName());
    assertNull(((BundleOrderItemImpl) actualCreateOrderItemResult).getMainEntityName());
    assertNull(actualCreateOrderItemResult.getAdjustmentValue());
    assertNull(actualCreateOrderItemResult.getAverageAdjustmentValue());
    assertNull(actualCreateOrderItemResult.getAveragePrice());
    assertNull(actualCreateOrderItemResult.getPrice());
    assertNull(actualCreateOrderItemResult.getOrder());
    assertEquals(0, actualCreateOrderItemResult.getQuantity());
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   * <ul>
   *   <li>Then return {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"})
  public void testUpdateDiscreteOrderItem_thenReturnBundleOrderItemImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl item = mock(BundleOrderItemImpl.class);
    when(item.getProduct()).thenReturn(new ProductBundleImpl());

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult = orderItemServiceImpl.updateDiscreteOrderItem(item,
        new DiscreteOrderItemRequest());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(item).getProduct();
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   * <ul>
   *   <li>Then return {@link DiscreteOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"})
  public void testUpdateDiscreteOrderItem_thenReturnDiscreteOrderItemImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getProduct()).thenReturn(new ProductBundleImpl());

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult = orderItemServiceImpl.updateDiscreteOrderItem(item,
        new DiscreteOrderItemRequest());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(item).getProduct();
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(item, actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)"})
  public void testUpdateDiscreteOrderItem_whenNull_thenReturnNull() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    // Act
    OrderItem actualUpdateDiscreteOrderItemResult = orderItemServiceImpl.updateDiscreteOrderItem(null,
        new DiscreteOrderItemRequest());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isNull());
    assertNull(actualUpdateDiscreteOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)} with {@code AbstractOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(AbstractOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
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
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans");
    AbstractOrderItemRequest itemRequest = mock(AbstractOrderItemRequest.class);
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isNull());
    verify(discreteOrderItemImpl).setBaseSalePrice(isNull());
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).updateSaleAndRetailPrices();
    verify(discreteOrderItemImpl).assignFinalPrice();
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getSku();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)} with {@code AbstractOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(AbstractOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("ThreadLocalManager.notify.orphans", new OrderItemAttributeImpl());
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
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans");
    AbstractOrderItemRequest itemRequest = mock(AbstractOrderItemRequest.class);
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isNull());
    verify(discreteOrderItemImpl).setBaseSalePrice(isNull());
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).updateSaleAndRetailPrices();
    verify(discreteOrderItemImpl).assignFinalPrice();
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getSku();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)} with {@code AbstractOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(AbstractOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
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
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("ThreadLocalManager.notify.orphans", null);
    AbstractOrderItemRequest itemRequest = mock(AbstractOrderItemRequest.class);
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isNull());
    verify(discreteOrderItemImpl).setBaseSalePrice(isNull());
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).updateSaleAndRetailPrices();
    verify(discreteOrderItemImpl).assignFinalPrice();
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getSku();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)} with {@code AbstractOrderItemRequest}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(AbstractOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest_givenHashMap() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
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
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    AbstractOrderItemRequest itemRequest = mock(AbstractOrderItemRequest.class);
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getItemAttributes()).thenReturn(new HashMap<>());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isNull());
    verify(discreteOrderItemImpl).setBaseSalePrice(isNull());
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).updateSaleAndRetailPrices();
    verify(discreteOrderItemImpl).assignFinalPrice();
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getSku();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code DiscreteOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
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
    verify(discreteOrderItemImpl).setQuantity(eq(0));
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code DiscreteOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePriceList = new ArrayList<>();
    discreteOrderItemFeePriceList.add(new DiscreteOrderItemFeePriceImpl());
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(discreteOrderItemFeePriceList);
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
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
    verify(discreteOrderItemImpl).setQuantity(eq(0));
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code DiscreteOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    doNothing().when(discreteOrderItemImpl).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    HashMap<String, String> stringStringMap2 = new HashMap<>();
    stringStringMap2.put("foo", "foo");
    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(itemRequest.getAdditionalAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap2);
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getBundleOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setAdditionalAttributes(isA(Map.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isA(BundleOrderItem.class));
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(itemRequest, atLeast(1)).getAdditionalAttributes();
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).getSku();
    verify(itemRequest).getBundleOrderItem();
    verify(itemRequest).getDiscreteOrderItemFeePrices();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code DiscreteOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest4() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("foo", new OrderItemAttributeImpl());
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);
    doNothing().when(discreteOrderItemImpl).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    HashMap<String, String> stringStringMap2 = new HashMap<>();
    stringStringMap2.put("foo", "foo");
    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(itemRequest.getAdditionalAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap2);
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getBundleOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setAdditionalAttributes(isA(Map.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isA(BundleOrderItem.class));
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(itemRequest, atLeast(1)).getAdditionalAttributes();
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).getSku();
    verify(itemRequest).getBundleOrderItem();
    verify(itemRequest).getDiscreteOrderItemFeePrices();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code DiscreteOrderItemRequest}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest_givenHashMap() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(itemRequest.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(itemRequest.getItemAttributes()).thenReturn(new HashMap<>());
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getBundleOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isA(BundleOrderItem.class));
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(itemRequest).getAdditionalAttributes();
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).getSku();
    verify(itemRequest).getBundleOrderItem();
    verify(itemRequest).getDiscreteOrderItemFeePrices();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code DiscreteOrderItemRequest}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest_givenHashMap2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(itemRequest.getAdditionalAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getItemAttributes()).thenReturn(new HashMap<>());
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getBundleOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setAdditionalAttributes(isA(Map.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isA(BundleOrderItem.class));
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(itemRequest, atLeast(1)).getAdditionalAttributes();
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).getSku();
    verify(itemRequest).getBundleOrderItem();
    verify(itemRequest).getDiscreteOrderItemFeePrices();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)} with {@code DiscreteOrderItemRequest}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItem OrderItemServiceImpl.createDiscreteOrderItem(DiscreteOrderItemRequest)"})
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest_givenHashMapFooIsNull() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    doNothing().when(discreteOrderItemImpl).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    HashMap<String, String> stringStringMap2 = new HashMap<>();
    stringStringMap2.put("foo", null);
    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(itemRequest.getAdditionalAttributes()).thenReturn(stringStringMap);
    when(itemRequest.getItemAttributes()).thenReturn(stringStringMap2);
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getBundleOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act
    orderItemServiceImpl.createDiscreteOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setAdditionalAttributes(isA(Map.class));
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isA(BundleOrderItem.class));
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(itemRequest, atLeast(1)).getAdditionalAttributes();
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).getSku();
    verify(itemRequest).getBundleOrderItem();
    verify(itemRequest).getDiscreteOrderItemFeePrices();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItem OrderItemServiceImpl.createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)"})
  public void testCreateDynamicPriceDiscreteOrderItem_givenArrayList() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    when(dynamicSkuPricingService.getSkuPrices(Mockito.<SkuPriceWrapper>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenReturn(dynamicSkuPrices);
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(itemRequest.getItemAttributes()).thenReturn(new HashMap<>());
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getBundleOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act
    orderItemServiceImpl.createDynamicPriceDiscreteOrderItem(itemRequest, new HashMap());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(dynamicSkuPricingService).getSkuPrices(isA(SkuPriceWrapper.class), isA(HashMap.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isA(BundleOrderItem.class));
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl, atLeast(1)).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl, atLeast(1)).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest, atLeast(1)).getSku();
    verify(itemRequest).getBundleOrderItem();
    verify(itemRequest, atLeast(1)).getDiscreteOrderItemFeePrices();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}.
   * <ul>
   *   <li>Then calls {@link Money#add(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItem OrderItemServiceImpl.createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)"})
  public void testCreateDynamicPriceDiscreteOrderItem_thenCallsAdd() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    when(dynamicSkuPricingService.getSkuPrices(Mockito.<SkuPriceWrapper>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenReturn(dynamicSkuPrices);
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    Money money2 = mock(Money.class);
    when(money2.add(Mockito.<Money>any())).thenReturn(new Money());
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getRetailPrice()).thenReturn(money2);
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(money);
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);

    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePriceList = new ArrayList<>();
    discreteOrderItemFeePriceList.add(new DiscreteOrderItemFeePriceImpl());
    DiscreteOrderItemRequest itemRequest = mock(DiscreteOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getDiscreteOrderItemFeePrices()).thenReturn(discreteOrderItemFeePriceList);
    when(itemRequest.getItemAttributes()).thenReturn(new HashMap<>());
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getBundleOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act
    orderItemServiceImpl.createDynamicPriceDiscreteOrderItem(itemRequest, new HashMap());

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(money2).add(isNull());
    verify(money).add(isNull());
    verify(dynamicSkuPricingService).getSkuPrices(isA(SkuPriceWrapper.class), isA(HashMap.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isA(BundleOrderItem.class));
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).getRetailPrice();
    verify(discreteOrderItemImpl).getSalePrice();
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl, atLeast(1)).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl, atLeast(1)).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(itemRequest).getCategory();
    verify(itemRequest).getItemAttributes();
    verify(itemRequest).getOrder();
    verify(itemRequest).getPersonalMessage();
    verify(itemRequest).getProduct();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest, atLeast(1)).getSku();
    verify(itemRequest).getBundleOrderItem();
    verify(itemRequest, atLeast(1)).getDiscreteOrderItemFeePrices();
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItem OrderItemServiceImpl.createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)"})
  public void testCreateDynamicPriceDiscreteOrderItem_whenDiscreteOrderItemRequest() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    when(dynamicSkuPricingService.getSkuPrices(Mockito.<SkuPriceWrapper>any(), Mockito.<HashMap<Object, Object>>any()))
        .thenReturn(dynamicSkuPrices);
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
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
    verify(discreteOrderItemImpl).setQuantity(eq(0));
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.order.domain.GiftWrapOrderItem OrderItemServiceImpl.createGiftWrapOrderItem(GiftWrapOrderItemRequest)"})
  public void testCreateGiftWrapOrderItem_givenArrayListAddBundleOrderItemImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());
    GiftWrapOrderItemImpl giftWrapOrderItemImpl = mock(GiftWrapOrderItemImpl.class);
    when(giftWrapOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(giftWrapOrderItemImpl.getWrappedItems()).thenReturn(orderItemList);
    doNothing().when(giftWrapOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(giftWrapOrderItemImpl).assignFinalPrice();
    doNothing().when(giftWrapOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(giftWrapOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(giftWrapOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(giftWrapOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(giftWrapOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(giftWrapOrderItemImpl);
    Sku sku = mock(Sku.class);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());

    GiftWrapOrderItemRequest itemRequest = new GiftWrapOrderItemRequest();
    itemRequest.setSku(sku);

    // Act
    orderItemServiceImpl.createGiftWrapOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(sku).getRetailPrice();
    verify(sku).getSalePrice();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(giftWrapOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setBundleOrderItem(isNull());
    verify(giftWrapOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(giftWrapOrderItemImpl).setOrder((Order) isNull());
    verify(giftWrapOrderItemImpl).setProduct(isNull());
    verify(giftWrapOrderItemImpl).setSku(isA(Sku.class));
    verify(giftWrapOrderItemImpl).updateSaleAndRetailPrices();
    verify(giftWrapOrderItemImpl, atLeast(1)).getWrappedItems();
    verify(giftWrapOrderItemImpl).assignFinalPrice();
    verify(giftWrapOrderItemImpl).setCategory(isNull());
    verify(giftWrapOrderItemImpl).setQuantity(eq(0));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.order.domain.GiftWrapOrderItem OrderItemServiceImpl.createGiftWrapOrderItem(GiftWrapOrderItemRequest)"})
  public void testCreateGiftWrapOrderItem_thenCallsGetProxy() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    GiftWrapOrderItemImpl giftWrapOrderItemImpl = mock(GiftWrapOrderItemImpl.class);
    when(giftWrapOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(giftWrapOrderItemImpl.getWrappedItems()).thenReturn(new ArrayList<>());
    doNothing().when(giftWrapOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(giftWrapOrderItemImpl).assignFinalPrice();
    doNothing().when(giftWrapOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(giftWrapOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(giftWrapOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(giftWrapOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(giftWrapOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(giftWrapOrderItemImpl);
    Sku sku = mock(Sku.class);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());

    GiftWrapOrderItemRequest itemRequest = new GiftWrapOrderItemRequest();
    itemRequest.setSku(sku);

    // Act
    orderItemServiceImpl.createGiftWrapOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(sku).getRetailPrice();
    verify(sku).getSalePrice();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(giftWrapOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setBundleOrderItem(isNull());
    verify(giftWrapOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(giftWrapOrderItemImpl).setOrder((Order) isNull());
    verify(giftWrapOrderItemImpl).setProduct(isNull());
    verify(giftWrapOrderItemImpl).setSku(isA(Sku.class));
    verify(giftWrapOrderItemImpl).updateSaleAndRetailPrices();
    verify(giftWrapOrderItemImpl, atLeast(1)).getWrappedItems();
    verify(giftWrapOrderItemImpl).assignFinalPrice();
    verify(giftWrapOrderItemImpl).setCategory(isNull());
    verify(giftWrapOrderItemImpl).setQuantity(eq(0));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#setRetailPrice(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.order.domain.GiftWrapOrderItem OrderItemServiceImpl.createGiftWrapOrderItem(GiftWrapOrderItemRequest)"})
  public void testCreateGiftWrapOrderItem_thenCallsSetRetailPrice() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
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
    doNothing().when(giftWrapOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(giftWrapOrderItemImpl).assignFinalPrice();
    doNothing().when(giftWrapOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(giftWrapOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(giftWrapOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(giftWrapOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(giftWrapOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(giftWrapOrderItemImpl);
    Sku sku = mock(Sku.class);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());

    GiftWrapOrderItemRequest itemRequest = new GiftWrapOrderItemRequest();
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(sku);

    // Act
    orderItemServiceImpl.createGiftWrapOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(sku).getRetailPrice();
    verify(sku).getSalePrice();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(giftWrapOrderItemImpl, atLeast(1)).setBaseRetailPrice(isA(Money.class));
    verify(giftWrapOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setBundleOrderItem(isNull());
    verify(giftWrapOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(giftWrapOrderItemImpl).setOrder((Order) isNull());
    verify(giftWrapOrderItemImpl).setProduct(isNull());
    verify(giftWrapOrderItemImpl).setSku(isA(Sku.class));
    verify(giftWrapOrderItemImpl).updateSaleAndRetailPrices();
    verify(giftWrapOrderItemImpl, atLeast(1)).getWrappedItems();
    verify(giftWrapOrderItemImpl).assignFinalPrice();
    verify(giftWrapOrderItemImpl).setCategory(isNull());
    verify(giftWrapOrderItemImpl).setQuantity(eq(0));
    verify(giftWrapOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(giftWrapOrderItemImpl).setSalePrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setSalePriceOverride(eq(true));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#setSalePrice(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.order.domain.GiftWrapOrderItem OrderItemServiceImpl.createGiftWrapOrderItem(GiftWrapOrderItemRequest)"})
  public void testCreateGiftWrapOrderItem_thenCallsSetSalePrice() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    GiftWrapOrderItemImpl giftWrapOrderItemImpl = mock(GiftWrapOrderItemImpl.class);
    doNothing().when(giftWrapOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(giftWrapOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(giftWrapOrderItemImpl.getWrappedItems()).thenReturn(new ArrayList<>());
    doNothing().when(giftWrapOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(giftWrapOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(giftWrapOrderItemImpl).assignFinalPrice();
    doNothing().when(giftWrapOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(giftWrapOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(giftWrapOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(giftWrapOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(giftWrapOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(giftWrapOrderItemImpl);
    Sku sku = mock(Sku.class);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());

    GiftWrapOrderItemRequest itemRequest = new GiftWrapOrderItemRequest();
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(sku);

    // Act
    orderItemServiceImpl.createGiftWrapOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(sku).getRetailPrice();
    verify(sku).getSalePrice();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(giftWrapOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(giftWrapOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setBundleOrderItem(isNull());
    verify(giftWrapOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(giftWrapOrderItemImpl).setOrder((Order) isNull());
    verify(giftWrapOrderItemImpl).setProduct(isNull());
    verify(giftWrapOrderItemImpl).setSku(isA(Sku.class));
    verify(giftWrapOrderItemImpl).updateSaleAndRetailPrices();
    verify(giftWrapOrderItemImpl, atLeast(1)).getWrappedItems();
    verify(giftWrapOrderItemImpl).assignFinalPrice();
    verify(giftWrapOrderItemImpl).setCategory(isNull());
    verify(giftWrapOrderItemImpl).setQuantity(eq(0));
    verify(giftWrapOrderItemImpl).setSalePrice(isA(Money.class));
    verify(giftWrapOrderItemImpl).setSalePriceOverride(eq(true));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)} with {@code BundleOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(BundleOrderItemRequest)"})
  public void testCreateBundleOrderItemWithBundleOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    BundleOrderItemRequest itemRequest = mock(BundleOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getName()).thenReturn("Name");
    when(itemRequest.getBundleOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(itemRequest.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(itemRequest.getRetailPriceOverride()).thenReturn(null);
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    doNothing().when(itemRequest).setBundleOrderItemFeePrices(Mockito.<List<BundleOrderItemFeePrice>>any());
    doNothing().when(itemRequest).setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(itemRequest).setDiscreteOrderItems(Mockito.<List<DiscreteOrderItemRequest>>any());
    doNothing().when(itemRequest).setName(Mockito.<String>any());
    doNothing().when(itemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(itemRequest).setQuantity(anyInt());
    doNothing().when(itemRequest).setRetailPriceOverride(Mockito.<Money>any());
    doNothing().when(itemRequest).setSalePriceOverride(Mockito.<Money>any());
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult = orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(itemRequest).getBundleOrderItemFeePrices();
    verify(itemRequest).getCategory();
    verify(itemRequest).getDiscreteOrderItems();
    verify(itemRequest).getName();
    verify(itemRequest).getOrder();
    verify(itemRequest).getQuantity();
    verify(itemRequest).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).setBundleOrderItemFeePrices(isA(List.class));
    verify(itemRequest).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(itemRequest).setDiscreteOrderItems(isA(List.class));
    verify(itemRequest).setName(eq("Name"));
    verify(itemRequest).setOrder(isA(Order.class));
    verify(itemRequest).setQuantity(eq(1));
    verify(itemRequest).setRetailPriceOverride(isA(Money.class));
    verify(itemRequest).setSalePriceOverride(isA(Money.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateBundleOrderItemResult instanceof BundleOrderItemImpl);
    assertNull(actualCreateBundleOrderItemResult.getBaseRetailPrice());
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)} with {@code BundleOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(BundleOrderItemRequest)"})
  public void testCreateBundleOrderItemWithBundleOrderItemRequest2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    BundleOrderItemRequest itemRequest = mock(BundleOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getName()).thenReturn("Name");
    when(itemRequest.getBundleOrderItemFeePrices()).thenReturn(new ArrayList<>());
    when(itemRequest.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(null);
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    doNothing().when(itemRequest).setBundleOrderItemFeePrices(Mockito.<List<BundleOrderItemFeePrice>>any());
    doNothing().when(itemRequest).setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(itemRequest).setDiscreteOrderItems(Mockito.<List<DiscreteOrderItemRequest>>any());
    doNothing().when(itemRequest).setName(Mockito.<String>any());
    doNothing().when(itemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(itemRequest).setQuantity(anyInt());
    doNothing().when(itemRequest).setRetailPriceOverride(Mockito.<Money>any());
    doNothing().when(itemRequest).setSalePriceOverride(Mockito.<Money>any());
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult = orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(itemRequest).getBundleOrderItemFeePrices();
    verify(itemRequest).getCategory();
    verify(itemRequest).getDiscreteOrderItems();
    verify(itemRequest).getName();
    verify(itemRequest).getOrder();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest).getSalePriceOverride();
    verify(itemRequest).setBundleOrderItemFeePrices(isA(List.class));
    verify(itemRequest).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(itemRequest).setDiscreteOrderItems(isA(List.class));
    verify(itemRequest).setName(eq("Name"));
    verify(itemRequest).setOrder(isA(Order.class));
    verify(itemRequest).setQuantity(eq(1));
    verify(itemRequest).setRetailPriceOverride(isA(Money.class));
    verify(itemRequest).setSalePriceOverride(isA(Money.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateBundleOrderItemResult instanceof BundleOrderItemImpl);
    assertNull(actualCreateBundleOrderItemResult.getBaseSalePrice());
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)} with {@code BundleOrderItemRequest}.
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(BundleOrderItemRequest)"})
  public void testCreateBundleOrderItemWithBundleOrderItemRequest_thenOrderReturnNullOrderImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
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
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());

    // Act
    BundleOrderItem actualCreateBundleOrderItemResult = orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertTrue(actualCreateBundleOrderItemResult instanceof BundleOrderItemImpl);
    assertTrue(actualCreateBundleOrderItemResult.getOrder() instanceof NullOrderImpl);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)} with {@code ProductBundleOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest)"})
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
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
    BundleOrderItem actualCreateBundleOrderItemResult = orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)} with {@code ProductBundleOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest)"})
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequest2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest.setCategory(new CategoryImpl());
    productBundleOrderItemRequest.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest.setName("Name");
    productBundleOrderItemRequest.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest.setQuantity(1);
    productBundleOrderItemRequest.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest.setSalePriceOverride(new Money());
    productBundleOrderItemRequest.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest2 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest2.setCategory(new CategoryImpl());
    productBundleOrderItemRequest2.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest2.setName("Name");
    productBundleOrderItemRequest2.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest2.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest2.setQuantity(1);
    productBundleOrderItemRequest2.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest2.setSalePriceOverride(new Money());
    productBundleOrderItemRequest2.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest3 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest3.setCategory(new CategoryImpl());
    productBundleOrderItemRequest3.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest3.setName("Name");
    productBundleOrderItemRequest3.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest3.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest3.setQuantity(1);
    productBundleOrderItemRequest3.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest3.setSalePriceOverride(new Money());
    productBundleOrderItemRequest3.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest4 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest4.setCategory(new CategoryImpl());
    productBundleOrderItemRequest4.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest4.setName("Name");
    productBundleOrderItemRequest4.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest4.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest4.setQuantity(1);
    productBundleOrderItemRequest4.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest4.setSalePriceOverride(new Money());
    productBundleOrderItemRequest4.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest5 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest5.setCategory(new CategoryImpl());
    productBundleOrderItemRequest5.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest5.setName("Name");
    productBundleOrderItemRequest5.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest5.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest5.setQuantity(1);
    productBundleOrderItemRequest5.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest5.setSalePriceOverride(new Money());
    productBundleOrderItemRequest5.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest6 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest6.setCategory(new CategoryImpl());
    productBundleOrderItemRequest6.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest6.setName("Name");
    productBundleOrderItemRequest6.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest6.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest6.setQuantity(1);
    productBundleOrderItemRequest6.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest6.setSalePriceOverride(new Money());
    productBundleOrderItemRequest6.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest7 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest7.setCategory(new CategoryImpl());
    productBundleOrderItemRequest7.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest7.setName("Name");
    productBundleOrderItemRequest7.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest7.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest7.setQuantity(1);
    productBundleOrderItemRequest7.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest7.setSalePriceOverride(new Money());
    productBundleOrderItemRequest7.setSku(new SkuImpl());
    ProductBundleOrderItemRequest itemRequest = mock(ProductBundleOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getName()).thenReturn("Name");
    when(itemRequest.getRetailPriceOverride()).thenReturn(null);
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProductBundle()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn(productBundleOrderItemRequest);
    when(itemRequest.setItemAttributes(Mockito.<Map<String, String>>any())).thenReturn(productBundleOrderItemRequest2);
    when(itemRequest.setName(Mockito.<String>any())).thenReturn(productBundleOrderItemRequest3);
    when(itemRequest.setOrder(Mockito.<Order>any())).thenReturn(productBundleOrderItemRequest4);
    when(itemRequest.setProductBundle(Mockito.<ProductBundle>any())).thenReturn(productBundleOrderItemRequest5);
    when(itemRequest.setQuantity(anyInt())).thenReturn(productBundleOrderItemRequest6);
    when(itemRequest.setSku(Mockito.<Sku>any())).thenReturn(productBundleOrderItemRequest7);
    doNothing().when(itemRequest).setRetailPriceOverride(Mockito.<Money>any());
    doNothing().when(itemRequest).setSalePriceOverride(Mockito.<Money>any());
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
    BundleOrderItem actualCreateBundleOrderItemResult = orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(itemRequest).getCategory();
    verify(itemRequest).getName();
    verify(itemRequest).getOrder();
    verify(itemRequest).getProductBundle();
    verify(itemRequest).getQuantity();
    verify(itemRequest).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).getSku();
    verify(itemRequest).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(itemRequest).setItemAttributes(isA(Map.class));
    verify(itemRequest).setName(eq("Name"));
    verify(itemRequest).setOrder(isA(Order.class));
    verify(itemRequest).setProductBundle(isA(ProductBundle.class));
    verify(itemRequest).setQuantity(eq(1));
    verify(itemRequest).setRetailPriceOverride(isA(Money.class));
    verify(itemRequest).setSalePriceOverride(isA(Money.class));
    verify(itemRequest).setSku(isA(Sku.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)} with {@code ProductBundleOrderItemRequest}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest)"})
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequest3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest.setCategory(new CategoryImpl());
    productBundleOrderItemRequest.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest.setName("Name");
    productBundleOrderItemRequest.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest.setQuantity(1);
    productBundleOrderItemRequest.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest.setSalePriceOverride(new Money());
    productBundleOrderItemRequest.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest2 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest2.setCategory(new CategoryImpl());
    productBundleOrderItemRequest2.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest2.setName("Name");
    productBundleOrderItemRequest2.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest2.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest2.setQuantity(1);
    productBundleOrderItemRequest2.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest2.setSalePriceOverride(new Money());
    productBundleOrderItemRequest2.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest3 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest3.setCategory(new CategoryImpl());
    productBundleOrderItemRequest3.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest3.setName("Name");
    productBundleOrderItemRequest3.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest3.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest3.setQuantity(1);
    productBundleOrderItemRequest3.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest3.setSalePriceOverride(new Money());
    productBundleOrderItemRequest3.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest4 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest4.setCategory(new CategoryImpl());
    productBundleOrderItemRequest4.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest4.setName("Name");
    productBundleOrderItemRequest4.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest4.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest4.setQuantity(1);
    productBundleOrderItemRequest4.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest4.setSalePriceOverride(new Money());
    productBundleOrderItemRequest4.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest5 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest5.setCategory(new CategoryImpl());
    productBundleOrderItemRequest5.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest5.setName("Name");
    productBundleOrderItemRequest5.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest5.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest5.setQuantity(1);
    productBundleOrderItemRequest5.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest5.setSalePriceOverride(new Money());
    productBundleOrderItemRequest5.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest6 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest6.setCategory(new CategoryImpl());
    productBundleOrderItemRequest6.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest6.setName("Name");
    productBundleOrderItemRequest6.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest6.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest6.setQuantity(1);
    productBundleOrderItemRequest6.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest6.setSalePriceOverride(new Money());
    productBundleOrderItemRequest6.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest7 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest7.setCategory(new CategoryImpl());
    productBundleOrderItemRequest7.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest7.setName("Name");
    productBundleOrderItemRequest7.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest7.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest7.setQuantity(1);
    productBundleOrderItemRequest7.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest7.setSalePriceOverride(new Money());
    productBundleOrderItemRequest7.setSku(new SkuImpl());
    ProductBundleOrderItemRequest itemRequest = mock(ProductBundleOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getName()).thenReturn("Name");
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(null);
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProductBundle()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn(productBundleOrderItemRequest);
    when(itemRequest.setItemAttributes(Mockito.<Map<String, String>>any())).thenReturn(productBundleOrderItemRequest2);
    when(itemRequest.setName(Mockito.<String>any())).thenReturn(productBundleOrderItemRequest3);
    when(itemRequest.setOrder(Mockito.<Order>any())).thenReturn(productBundleOrderItemRequest4);
    when(itemRequest.setProductBundle(Mockito.<ProductBundle>any())).thenReturn(productBundleOrderItemRequest5);
    when(itemRequest.setQuantity(anyInt())).thenReturn(productBundleOrderItemRequest6);
    when(itemRequest.setSku(Mockito.<Sku>any())).thenReturn(productBundleOrderItemRequest7);
    doNothing().when(itemRequest).setRetailPriceOverride(Mockito.<Money>any());
    doNothing().when(itemRequest).setSalePriceOverride(Mockito.<Money>any());
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
    BundleOrderItem actualCreateBundleOrderItemResult = orderItemServiceImpl.createBundleOrderItem(itemRequest);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(itemRequest).getCategory();
    verify(itemRequest).getName();
    verify(itemRequest).getOrder();
    verify(itemRequest).getProductBundle();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest).getSalePriceOverride();
    verify(itemRequest).getSku();
    verify(itemRequest).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(itemRequest).setItemAttributes(isA(Map.class));
    verify(itemRequest).setName(eq("Name"));
    verify(itemRequest).setOrder(isA(Order.class));
    verify(itemRequest).setProductBundle(isA(ProductBundle.class));
    verify(itemRequest).setQuantity(eq(1));
    verify(itemRequest).setRetailPriceOverride(isA(Money.class));
    verify(itemRequest).setSalePriceOverride(isA(Money.class));
    verify(itemRequest).setSku(isA(Sku.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)} with {@code ProductBundleOrderItemRequest}, {@code boolean}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest, boolean)"})
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequestBoolean() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
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
    BundleOrderItem actualCreateBundleOrderItemResult = orderItemServiceImpl.createBundleOrderItem(itemRequest, true);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)} with {@code ProductBundleOrderItemRequest}, {@code boolean}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest, boolean)"})
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequestBoolean2() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest.setCategory(new CategoryImpl());
    productBundleOrderItemRequest.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest.setName("Name");
    productBundleOrderItemRequest.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest.setQuantity(1);
    productBundleOrderItemRequest.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest.setSalePriceOverride(new Money());
    productBundleOrderItemRequest.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest2 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest2.setCategory(new CategoryImpl());
    productBundleOrderItemRequest2.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest2.setName("Name");
    productBundleOrderItemRequest2.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest2.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest2.setQuantity(1);
    productBundleOrderItemRequest2.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest2.setSalePriceOverride(new Money());
    productBundleOrderItemRequest2.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest3 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest3.setCategory(new CategoryImpl());
    productBundleOrderItemRequest3.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest3.setName("Name");
    productBundleOrderItemRequest3.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest3.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest3.setQuantity(1);
    productBundleOrderItemRequest3.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest3.setSalePriceOverride(new Money());
    productBundleOrderItemRequest3.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest4 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest4.setCategory(new CategoryImpl());
    productBundleOrderItemRequest4.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest4.setName("Name");
    productBundleOrderItemRequest4.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest4.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest4.setQuantity(1);
    productBundleOrderItemRequest4.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest4.setSalePriceOverride(new Money());
    productBundleOrderItemRequest4.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest5 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest5.setCategory(new CategoryImpl());
    productBundleOrderItemRequest5.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest5.setName("Name");
    productBundleOrderItemRequest5.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest5.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest5.setQuantity(1);
    productBundleOrderItemRequest5.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest5.setSalePriceOverride(new Money());
    productBundleOrderItemRequest5.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest6 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest6.setCategory(new CategoryImpl());
    productBundleOrderItemRequest6.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest6.setName("Name");
    productBundleOrderItemRequest6.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest6.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest6.setQuantity(1);
    productBundleOrderItemRequest6.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest6.setSalePriceOverride(new Money());
    productBundleOrderItemRequest6.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest7 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest7.setCategory(new CategoryImpl());
    productBundleOrderItemRequest7.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest7.setName("Name");
    productBundleOrderItemRequest7.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest7.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest7.setQuantity(1);
    productBundleOrderItemRequest7.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest7.setSalePriceOverride(new Money());
    productBundleOrderItemRequest7.setSku(new SkuImpl());
    ProductBundleOrderItemRequest itemRequest = mock(ProductBundleOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getName()).thenReturn("Name");
    when(itemRequest.getRetailPriceOverride()).thenReturn(null);
    when(itemRequest.getSalePriceOverride()).thenReturn(new Money());
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProductBundle()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn(productBundleOrderItemRequest);
    when(itemRequest.setItemAttributes(Mockito.<Map<String, String>>any())).thenReturn(productBundleOrderItemRequest2);
    when(itemRequest.setName(Mockito.<String>any())).thenReturn(productBundleOrderItemRequest3);
    when(itemRequest.setOrder(Mockito.<Order>any())).thenReturn(productBundleOrderItemRequest4);
    when(itemRequest.setProductBundle(Mockito.<ProductBundle>any())).thenReturn(productBundleOrderItemRequest5);
    when(itemRequest.setQuantity(anyInt())).thenReturn(productBundleOrderItemRequest6);
    when(itemRequest.setSku(Mockito.<Sku>any())).thenReturn(productBundleOrderItemRequest7);
    doNothing().when(itemRequest).setRetailPriceOverride(Mockito.<Money>any());
    doNothing().when(itemRequest).setSalePriceOverride(Mockito.<Money>any());
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
    BundleOrderItem actualCreateBundleOrderItemResult = orderItemServiceImpl.createBundleOrderItem(itemRequest, true);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(itemRequest).getCategory();
    verify(itemRequest).getName();
    verify(itemRequest).getOrder();
    verify(itemRequest).getProductBundle();
    verify(itemRequest).getQuantity();
    verify(itemRequest).getRetailPriceOverride();
    verify(itemRequest, atLeast(1)).getSalePriceOverride();
    verify(itemRequest).getSku();
    verify(itemRequest).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(itemRequest).setItemAttributes(isA(Map.class));
    verify(itemRequest).setName(eq("Name"));
    verify(itemRequest).setOrder(isA(Order.class));
    verify(itemRequest).setProductBundle(isA(ProductBundle.class));
    verify(itemRequest).setQuantity(eq(1));
    verify(itemRequest).setRetailPriceOverride(isA(Money.class));
    verify(itemRequest).setSalePriceOverride(isA(Money.class));
    verify(itemRequest).setSku(isA(Sku.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)} with {@code ProductBundleOrderItemRequest}, {@code boolean}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BundleOrderItem OrderItemServiceImpl.createBundleOrderItem(ProductBundleOrderItemRequest, boolean)"})
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequestBoolean3() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemDao.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest.setCategory(new CategoryImpl());
    productBundleOrderItemRequest.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest.setName("Name");
    productBundleOrderItemRequest.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest.setQuantity(1);
    productBundleOrderItemRequest.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest.setSalePriceOverride(new Money());
    productBundleOrderItemRequest.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest2 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest2.setCategory(new CategoryImpl());
    productBundleOrderItemRequest2.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest2.setName("Name");
    productBundleOrderItemRequest2.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest2.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest2.setQuantity(1);
    productBundleOrderItemRequest2.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest2.setSalePriceOverride(new Money());
    productBundleOrderItemRequest2.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest3 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest3.setCategory(new CategoryImpl());
    productBundleOrderItemRequest3.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest3.setName("Name");
    productBundleOrderItemRequest3.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest3.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest3.setQuantity(1);
    productBundleOrderItemRequest3.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest3.setSalePriceOverride(new Money());
    productBundleOrderItemRequest3.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest4 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest4.setCategory(new CategoryImpl());
    productBundleOrderItemRequest4.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest4.setName("Name");
    productBundleOrderItemRequest4.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest4.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest4.setQuantity(1);
    productBundleOrderItemRequest4.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest4.setSalePriceOverride(new Money());
    productBundleOrderItemRequest4.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest5 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest5.setCategory(new CategoryImpl());
    productBundleOrderItemRequest5.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest5.setName("Name");
    productBundleOrderItemRequest5.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest5.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest5.setQuantity(1);
    productBundleOrderItemRequest5.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest5.setSalePriceOverride(new Money());
    productBundleOrderItemRequest5.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest6 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest6.setCategory(new CategoryImpl());
    productBundleOrderItemRequest6.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest6.setName("Name");
    productBundleOrderItemRequest6.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest6.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest6.setQuantity(1);
    productBundleOrderItemRequest6.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest6.setSalePriceOverride(new Money());
    productBundleOrderItemRequest6.setSku(new SkuImpl());

    ProductBundleOrderItemRequest productBundleOrderItemRequest7 = new ProductBundleOrderItemRequest();
    productBundleOrderItemRequest7.setCategory(new CategoryImpl());
    productBundleOrderItemRequest7.setItemAttributes(new HashMap<>());
    productBundleOrderItemRequest7.setName("Name");
    productBundleOrderItemRequest7.setOrder(new NullOrderImpl());
    productBundleOrderItemRequest7.setProductBundle(new ProductBundleImpl());
    productBundleOrderItemRequest7.setQuantity(1);
    productBundleOrderItemRequest7.setRetailPriceOverride(new Money());
    productBundleOrderItemRequest7.setSalePriceOverride(new Money());
    productBundleOrderItemRequest7.setSku(new SkuImpl());
    ProductBundleOrderItemRequest itemRequest = mock(ProductBundleOrderItemRequest.class);
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getName()).thenReturn("Name");
    when(itemRequest.getRetailPriceOverride()).thenReturn(new Money());
    when(itemRequest.getSalePriceOverride()).thenReturn(null);
    when(itemRequest.getCategory()).thenReturn(new CategoryImpl());
    when(itemRequest.getProductBundle()).thenReturn(new ProductBundleImpl());
    when(itemRequest.getSku()).thenReturn(new SkuImpl());
    when(itemRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(itemRequest.setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn(productBundleOrderItemRequest);
    when(itemRequest.setItemAttributes(Mockito.<Map<String, String>>any())).thenReturn(productBundleOrderItemRequest2);
    when(itemRequest.setName(Mockito.<String>any())).thenReturn(productBundleOrderItemRequest3);
    when(itemRequest.setOrder(Mockito.<Order>any())).thenReturn(productBundleOrderItemRequest4);
    when(itemRequest.setProductBundle(Mockito.<ProductBundle>any())).thenReturn(productBundleOrderItemRequest5);
    when(itemRequest.setQuantity(anyInt())).thenReturn(productBundleOrderItemRequest6);
    when(itemRequest.setSku(Mockito.<Sku>any())).thenReturn(productBundleOrderItemRequest7);
    doNothing().when(itemRequest).setRetailPriceOverride(Mockito.<Money>any());
    doNothing().when(itemRequest).setSalePriceOverride(Mockito.<Money>any());
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
    BundleOrderItem actualCreateBundleOrderItemResult = orderItemServiceImpl.createBundleOrderItem(itemRequest, true);

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).saveOrderItem(isA(OrderItem.class));
    verify(itemRequest).getCategory();
    verify(itemRequest).getName();
    verify(itemRequest).getOrder();
    verify(itemRequest).getProductBundle();
    verify(itemRequest).getQuantity();
    verify(itemRequest, atLeast(1)).getRetailPriceOverride();
    verify(itemRequest).getSalePriceOverride();
    verify(itemRequest).getSku();
    verify(itemRequest).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(itemRequest).setItemAttributes(isA(Map.class));
    verify(itemRequest).setName(eq("Name"));
    verify(itemRequest).setOrder(isA(Order.class));
    verify(itemRequest).setProductBundle(isA(ProductBundle.class));
    verify(itemRequest).setQuantity(eq(1));
    verify(itemRequest).setRetailPriceOverride(isA(Money.class));
    verify(itemRequest).setSalePriceOverride(isA(Money.class));
    verify(itemRequest).setSku(isA(Sku.class));
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
    assertSame(bundleOrderItemImpl, actualCreateBundleOrderItemResult);
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"})
  public void testBuildOrderItemRequestDTOFromOrderItem() {
    // Arrange
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
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"})
  public void testBuildOrderItemRequestDTOFromOrderItem2() {
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
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"})
  public void testBuildOrderItemRequestDTOFromOrderItem3() {
    // Arrange
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
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"})
  public void testBuildOrderItemRequestDTOFromOrderItem4() {
    // Arrange
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
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"})
  public void testBuildOrderItemRequestDTOFromOrderItem5() {
    // Arrange
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
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <ul>
   *   <li>Then return ItemAttributes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"})
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
   * Test {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <ul>
   *   <li>Then return OverrideRetailPrice is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemRequestDTO OrderItemServiceImpl.buildOrderItemRequestDTOFromOrderItem(OrderItem)"})
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnOverrideRetailPriceIsNull() {
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
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemFeePriceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"})
  public void testBuildOrderItemFromDTO_givenArrayListAddDiscreteOrderItemFeePriceImpl() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePriceList = new ArrayList<>();
    discreteOrderItemFeePriceList.add(new DiscreteOrderItemFeePriceImpl());
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(discreteOrderItemFeePriceList);
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(1);

    // Act
    orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"})
  public void testBuildOrderItemFromDTO_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(discreteOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    NullOrderImpl order = new NullOrderImpl();

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Pricing Model Type");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setQuantity(1);

    // Act
    orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findCategoryById(eq(1L));
    verify(catalogService).findProductById(eq(1L));
    verify(catalogService).findSkuById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).readOrderItemById(eq(1L));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl, atLeast(1)).setHasValidationError(eq(true));
    verify(discreteOrderItemImpl).setParentOrderItem(isA(OrderItem.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@link ProductImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"})
  public void testBuildOrderItemFromDTO_givenCatalogServiceFindProductByIdReturnProductImpl() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductImpl());
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(discreteOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    NullOrderImpl order = new NullOrderImpl();

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Pricing Model Type");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setQuantity(1);

    // Act
    orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findCategoryById(eq(1L));
    verify(catalogService).findProductById(eq(1L));
    verify(catalogService).findSkuById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(orderItemDao).readOrderItemById(eq(1L));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isA(Product.class));
    verify(discreteOrderItemImpl).setSku(isA(Sku.class));
    verify(discreteOrderItemImpl).setCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(discreteOrderItemImpl, atLeast(1)).setHasValidationError(eq(true));
    verify(discreteOrderItemImpl).setParentOrderItem(isA(OrderItem.class));
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} OverrideRetailPrice is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"})
  public void testBuildOrderItemFromDTO_whenOrderItemRequestDTOOverrideRetailPriceIsMoney() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setQuantity(1);

    // Act
    orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(discreteOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} OverrideSalePrice is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"})
  public void testBuildOrderItemFromDTO_whenOrderItemRequestDTOOverrideSalePriceIsMoney() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(discreteOrderItemImpl).setSalePriceOverride(anyBoolean());
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setQuantity(1);

    // Act
    orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl, atLeast(1)).setBaseSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(discreteOrderItemImpl).setSalePrice(isA(Money.class));
    verify(discreteOrderItemImpl).setSalePriceOverride(eq(true));
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is one.</li>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemServiceImpl.buildOrderItemFromDTO(Order, OrderItemRequestDTO)"})
  public void testBuildOrderItemFromDTO_whenOrderItemRequestDTOQuantityIsOne_thenCallsGetProxy() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getDiscreteOrderItemFeePrices()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());
    doNothing().when(discreteOrderItemImpl)
        .setDiscreteOrderItemFeePrices(Mockito.<List<DiscreteOrderItemFeePrice>>any());
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(discreteOrderItemImpl).setProduct(Mockito.<Product>any());
    doNothing().when(discreteOrderItemImpl).setSku(Mockito.<Sku>any());
    doNothing().when(discreteOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(discreteOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(discreteOrderItemImpl).setQuantity(anyInt());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(discreteOrderItemImpl);
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(1);

    // Act
    orderItemServiceImpl.buildOrderItemFromDTO(order, orderItemRequestDTO);

    // Assert
    verify(orderItemServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(discreteOrderItemImpl).getDiscreteOrderItemFeePrices();
    verify(discreteOrderItemImpl).setBundleOrderItem(isNull());
    verify(discreteOrderItemImpl).setDiscreteOrderItemFeePrices(isA(List.class));
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(discreteOrderItemImpl).setProduct(isNull());
    verify(discreteOrderItemImpl).setSku(isNull());
    verify(discreteOrderItemImpl).setCategory(isNull());
    verify(discreteOrderItemImpl).setPersonalMessage(isNull());
    verify(discreteOrderItemImpl).setQuantity(eq(1));
    verify(orderItemServiceExtensionHandler, atLeast(1)).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#priceOrderItem(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#priceOrderItem(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemServiceImpl.priceOrderItem(OrderItem)"})
  public void testPriceOrderItem() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
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
   * <p>
   * Method under test: {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set OrderItemServiceImpl.findAllProductsInRequest(ConfigurableOrderItemRequest)"})
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
   * <p>
   * Method under test: {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set OrderItemServiceImpl.findAllProductsInRequest(ConfigurableOrderItemRequest)"})
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
   * <ul>
   *   <li>Given {@link OrderItemServiceImpl} (default constructor).</li>
   *   <li>Then calls {@link ConfigurableOrderItemRequest#getProduct()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set OrderItemServiceImpl.findAllChildProductsInRequest(List)"})
  public void testFindAllChildProductsInRequest_givenOrderItemServiceImpl_thenCallsGetProduct() {
    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    ConfigurableOrderItemRequest configurableOrderItemRequest = mock(ConfigurableOrderItemRequest.class);
    when(configurableOrderItemRequest.getProductChoices()).thenReturn(new ArrayList<>());
    when(configurableOrderItemRequest.getProduct()).thenReturn(null);
    when(configurableOrderItemRequest.setCategoryId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(configurableOrderItemRequest.setItemAttributes(Mockito.<Map<String, String>>any()))
        .thenReturn(new OrderItemRequestDTO());
    when(configurableOrderItemRequest.setOrderItemId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(configurableOrderItemRequest.setProductId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(configurableOrderItemRequest.setQuantity(Mockito.<Integer>any())).thenReturn(new OrderItemRequestDTO());
    when(configurableOrderItemRequest.setSkuId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    doNothing().when(configurableOrderItemRequest).setDiscountsAllowed(Mockito.<Boolean>any());
    doNothing().when(configurableOrderItemRequest).setDisplayPrice(Mockito.<Money>any());
    doNothing().when(configurableOrderItemRequest).setExpandable(anyBoolean());
    doNothing().when(configurableOrderItemRequest).setFirstExpandable(anyBoolean());
    doNothing().when(configurableOrderItemRequest).setHasConfigurationError(Mockito.<Boolean>any());
    doNothing().when(configurableOrderItemRequest).setHasOverridenPrice(Mockito.<Boolean>any());
    doNothing().when(configurableOrderItemRequest).setIsMultiSelect(Mockito.<Boolean>any());
    doNothing().when(configurableOrderItemRequest).setLastExpandable(anyBoolean());
    doNothing().when(configurableOrderItemRequest).setMaxQuantity(Mockito.<Integer>any());
    doNothing().when(configurableOrderItemRequest).setMinQuantity(Mockito.<Integer>any());
    doNothing().when(configurableOrderItemRequest).setOrderItemIndex(Mockito.<Integer>any());
    doNothing().when(configurableOrderItemRequest).setPricingModelType(Mockito.<String>any());
    doNothing().when(configurableOrderItemRequest).setProduct(Mockito.<Product>any());
    doNothing().when(configurableOrderItemRequest).setProductChoices(Mockito.<List<ConfigurableOrderItemRequest>>any());
    doNothing().when(configurableOrderItemRequest).setSku(Mockito.<Sku>any());
    doNothing().when(configurableOrderItemRequest).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(configurableOrderItemRequest).setChildOrderItems(Mockito.<List<OrderItemRequestDTO>>any());
    doNothing().when(configurableOrderItemRequest).setOverrideRetailPrice(Mockito.<Money>any());
    doNothing().when(configurableOrderItemRequest).setOverrideSalePrice(Mockito.<Money>any());
    doNothing().when(configurableOrderItemRequest).setParentOrderItemId(Mockito.<Long>any());
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

    // Act
    Set<Product> actualFindAllChildProductsInRequestResult = orderItemServiceImpl
        .findAllChildProductsInRequest(childItems);

    // Assert
    verify(configurableOrderItemRequest).getProduct();
    verify(configurableOrderItemRequest).getProductChoices();
    verify(configurableOrderItemRequest).setDiscountsAllowed(eq(true));
    verify(configurableOrderItemRequest).setDisplayPrice(isA(Money.class));
    verify(configurableOrderItemRequest).setExpandable(eq(true));
    verify(configurableOrderItemRequest).setFirstExpandable(eq(true));
    verify(configurableOrderItemRequest).setHasConfigurationError(eq(true));
    verify(configurableOrderItemRequest).setHasOverridenPrice(eq(true));
    verify(configurableOrderItemRequest).setIsMultiSelect(eq(true));
    verify(configurableOrderItemRequest).setLastExpandable(eq(true));
    verify(configurableOrderItemRequest).setMaxQuantity(eq(3));
    verify(configurableOrderItemRequest).setMinQuantity(eq(1));
    verify(configurableOrderItemRequest).setOrderItemIndex(eq(1));
    verify(configurableOrderItemRequest).setPricingModelType(eq("Pricing Model Type"));
    verify(configurableOrderItemRequest).setProduct(isA(Product.class));
    verify(configurableOrderItemRequest).setProductChoices(isA(List.class));
    verify(configurableOrderItemRequest).setSku(isA(Sku.class));
    verify(configurableOrderItemRequest).setAdditionalAttributes(isA(Map.class));
    verify(configurableOrderItemRequest).setCategoryId(eq(1L));
    verify(configurableOrderItemRequest).setChildOrderItems(isA(List.class));
    verify(configurableOrderItemRequest).setItemAttributes(isA(Map.class));
    verify(configurableOrderItemRequest).setOrderItemId(eq(1L));
    verify(configurableOrderItemRequest).setOverrideRetailPrice(isA(Money.class));
    verify(configurableOrderItemRequest).setOverrideSalePrice(isA(Money.class));
    verify(configurableOrderItemRequest).setParentOrderItemId(eq(1L));
    verify(configurableOrderItemRequest).setProductId(eq(1L));
    verify(configurableOrderItemRequest).setQuantity(eq(1));
    verify(configurableOrderItemRequest).setSkuId(eq(1L));
    assertTrue(actualFindAllChildProductsInRequestResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set OrderItemServiceImpl.findAllChildProductsInRequest(List)"})
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set OrderItemServiceImpl.findAllChildProductsInRequest(List)"})
  public void testFindAllChildProductsInRequest_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(orderItemServiceImpl.findAllChildProductsInRequest(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#applyAdditionalOrderItemProperties(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#applyAdditionalOrderItemProperties(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemServiceImpl.applyAdditionalOrderItemProperties(OrderItem)"})
  public void testApplyAdditionalOrderItemProperties() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.applyAdditionalOrderItemProperties(Mockito.<OrderItem>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(orderItemServiceExtensionManager.getProxy()).thenReturn(orderItemServiceExtensionHandler);

    // Act
    orderItemServiceImpl.applyAdditionalOrderItemProperties(new BundleOrderItemImpl());

    // Assert
    verify(orderItemServiceExtensionManager).getProxy();
    verify(orderItemServiceExtensionHandler).applyAdditionalOrderItemProperties(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}.
   * <ul>
   *   <li>Then return MaxQuantity is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ConfigurableOrderItemRequest OrderItemServiceImpl.createConfigurableOrderItemRequestFromProduct(Product)"})
  public void testCreateConfigurableOrderItemRequestFromProduct_thenReturnMaxQuantityIsNull() {
    // Arrange
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

  /**
   * Test {@link OrderItemServiceImpl#modifyOrderItemRequest(ConfigurableOrderItemRequest)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#modifyOrderItemRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemServiceImpl.modifyOrderItemRequest(ConfigurableOrderItemRequest)"})
  public void testModifyOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any()))
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
    verify(orderItemServiceExtensionHandler).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#mergeOrderItemRequest(ConfigurableOrderItemRequest, OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#mergeOrderItemRequest(ConfigurableOrderItemRequest, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemServiceImpl.mergeOrderItemRequest(ConfigurableOrderItemRequest, OrderItem)"})
  public void testMergeOrderItemRequest() {
    // Arrange
    OrderItemServiceExtensionHandler orderItemServiceExtensionHandler = mock(OrderItemServiceExtensionHandler.class);
    when(orderItemServiceExtensionHandler.mergeOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any(),
        Mockito.<OrderItem>any())).thenReturn(ExtensionResultStatusType.HANDLED);
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
    verify(orderItemServiceExtensionHandler).mergeOrderItemRequest(isA(ConfigurableOrderItemRequest.class),
        isA(OrderItem.class));
  }

  /**
   * Test {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderItemServiceImpl.findOrderItemsForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrderItemsForCustomersInDateRange_givenOne_whenArrayListAddOne() {
    // Arrange
    when(orderItemDao.readOrderItemsForCustomersInDateRange(Mockito.<List<Long>>any(), Mockito.<Date>any(),
        Mockito.<Date>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> customerIds = new ArrayList<>();
    customerIds.add(1L);
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<OrderItem> actualFindOrderItemsForCustomersInDateRangeResult = orderItemServiceImpl
        .findOrderItemsForCustomersInDateRange(customerIds, startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderItemDao).readOrderItemsForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrderItemsForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderItemServiceImpl.findOrderItemsForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrderItemsForCustomersInDateRange_givenZero_whenArrayListAddZero() {
    // Arrange
    when(orderItemDao.readOrderItemsForCustomersInDateRange(Mockito.<List<Long>>any(), Mockito.<Date>any(),
        Mockito.<Date>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> customerIds = new ArrayList<>();
    customerIds.add(0L);
    customerIds.add(1L);
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<OrderItem> actualFindOrderItemsForCustomersInDateRangeResult = orderItemServiceImpl
        .findOrderItemsForCustomersInDateRange(customerIds, startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderItemDao).readOrderItemsForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrderItemsForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderItemServiceImpl.findOrderItemsForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrderItemsForCustomersInDateRange_whenArrayList() {
    // Arrange
    when(orderItemDao.readOrderItemsForCustomersInDateRange(Mockito.<List<Long>>any(), Mockito.<Date>any(),
        Mockito.<Date>any())).thenReturn(new ArrayList<>());
    ArrayList<Long> customerIds = new ArrayList<>();
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<OrderItem> actualFindOrderItemsForCustomersInDateRangeResult = orderItemServiceImpl
        .findOrderItemsForCustomersInDateRange(customerIds, startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderItemDao).readOrderItemsForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrderItemsForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}.
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OrderStatus#ARCHIVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderItemServiceImpl.readBatchOrderItems(int, int, List)"})
  public void testReadBatchOrderItems_givenArchived_whenArrayListAddArchived() {
    // Arrange
    when(orderItemDao.readBatchOrderItems(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<OrderStatus> orderStatusList = new ArrayList<>();
    orderStatusList.add(OrderStatus.ARCHIVED);

    // Act
    List<OrderItem> actualReadBatchOrderItemsResult = orderItemServiceImpl.readBatchOrderItems(1, 3, orderStatusList);

    // Assert
    verify(orderItemDao).readBatchOrderItems(eq(1), eq(3), isA(List.class));
    assertTrue(actualReadBatchOrderItemsResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}.
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OrderStatus#ARCHIVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderItemServiceImpl.readBatchOrderItems(int, int, List)"})
  public void testReadBatchOrderItems_givenArchived_whenArrayListAddArchived2() {
    // Arrange
    when(orderItemDao.readBatchOrderItems(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<OrderStatus> orderStatusList = new ArrayList<>();
    orderStatusList.add(OrderStatus.ARCHIVED);
    orderStatusList.add(OrderStatus.ARCHIVED);

    // Act
    List<OrderItem> actualReadBatchOrderItemsResult = orderItemServiceImpl.readBatchOrderItems(1, 3, orderStatusList);

    // Assert
    verify(orderItemDao).readBatchOrderItems(eq(1), eq(3), isA(List.class));
    assertTrue(actualReadBatchOrderItemsResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemServiceImpl#readBatchOrderItems(int, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderItemServiceImpl.readBatchOrderItems(int, int, List)"})
  public void testReadBatchOrderItems_whenArrayList() {
    // Arrange
    when(orderItemDao.readBatchOrderItems(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OrderItem> actualReadBatchOrderItemsResult = orderItemServiceImpl.readBatchOrderItems(1, 3, new ArrayList<>());

    // Assert
    verify(orderItemDao).readBatchOrderItems(eq(1), eq(3), isA(List.class));
    assertTrue(actualReadBatchOrderItemsResult.isEmpty());
  }

  /**
   * Test {@link OrderItemServiceImpl#readNumberOfOrderItems()}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#readNumberOfOrderItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
