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
package org.broadleafcommerce.core.order.service.legacy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.broadleafcommerce.core.order.dao.FulfillmentGroupDao;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDaoImpl;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.dao.OrderDaoImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderItemServiceImpl;
import org.broadleafcommerce.core.order.service.call.BundleOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.DiscreteOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.ItemNotFoundException;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDao;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDaoImpl;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class LegacyOrderServiceImplDiffblueTest {
  /**
   * Test
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   * with {@code discreteOrderItem}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(new DiscreteOrderItemImpl());

    // Assert
    assertNull(actualCreateDiscreteOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getCategory());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getProduct());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSku());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getBundleOrderItem());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getOrder());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getPersonalMessage());
    assertEquals(0, actualCreateDiscreteOrderItemRequestResult.getQuantity());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, Category, Integer, Map)}
   * with {@code order}, {@code bundleOrderItem}, {@code sku}, {@code product},
   * {@code category}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, Category, Integer, Map)}
   */
  @Test
  public void testCreateDiscreteOrderItemRequestWithOrderBundleOrderItemSkuProductCategoryQuantityItemAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    SkuImpl sku = new SkuImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(order, bundleOrderItem, sku, product, category, 1, new HashMap<>());

    // Assert
    assertNull(actualCreateDiscreteOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getPersonalMessage());
    assertEquals(1, actualCreateDiscreteOrderItemRequestResult.getQuantity());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getItemAttributes().isEmpty());
    assertSame(category, actualCreateDiscreteOrderItemRequestResult.getCategory());
    assertSame(product, actualCreateDiscreteOrderItemRequestResult.getProduct());
    assertSame(sku, actualCreateDiscreteOrderItemRequestResult.getSku());
    assertSame(bundleOrderItem, actualCreateDiscreteOrderItemRequestResult.getBundleOrderItem());
    assertSame(order, actualCreateDiscreteOrderItemRequestResult.getOrder());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)}
   * with {@code order}, {@code item}, {@code priceOrder}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)}
   */
  @Test
  public void testUpdateItemQuantityWithOrderItemPriceOrder_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
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
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> legacyOrderServiceImpl.updateItemQuantity(order, item, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with
   * {@code order}, {@code item}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  public void testUpdateItemQuantityWithOrderItem_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
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
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> legacyOrderServiceImpl.updateItemQuantity(order, item));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   * with {@code item1}, {@code item2}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   */
  @Test
  public void testItemMatchesWithItem1Item2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    DiscreteOrderItemImpl item1 = new DiscreteOrderItemImpl();

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.itemMatches(item1, new DiscreteOrderItemImpl()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}
   */
  @Test
  public void testFindMatchingDiscreteItem_givenAuditableCreatedByIsOne_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setOrderItems(new ArrayList<>());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingDiscreteItem(order, new DiscreteOrderItemImpl()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}
   */
  @Test
  public void testBundleItemMatches() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    BundleOrderItemImpl item1 = new BundleOrderItemImpl();

    // Act and Assert
    assertTrue(legacyOrderServiceImpl.bundleItemMatches(item1, new BundleOrderItemImpl()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}
   */
  @Test
  public void testRemoveOrderItemAttribute_givenAuditableCreatedByIsOne_thenReturnOrderImpl()
      throws ItemNotFoundException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertSame(order,
        legacyOrderServiceImpl.removeOrderItemAttribute(order, new BundleOrderItemImpl(), "Attribute Name", true));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}
   */
  @Test
  public void testCreateBundleOrderItemRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    // Act
    BundleOrderItemRequest actualCreateBundleOrderItemRequestResult = legacyOrderServiceImpl
        .createBundleOrderItemRequest(bundleOrderItem, new ArrayList<>());

    // Assert
    assertNull(actualCreateBundleOrderItemRequestResult.getName());
    assertNull(actualCreateBundleOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateBundleOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateBundleOrderItemRequestResult.getCategory());
    assertNull(actualCreateBundleOrderItemRequestResult.getOrder());
    assertEquals(0, actualCreateBundleOrderItemRequestResult.getQuantity());
    assertTrue(actualCreateBundleOrderItemRequestResult.getBundleOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateBundleOrderItemRequestResult.getDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  public void testValidateOrder_whenNull_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new LegacyOrderServiceImpl()).validateOrder(null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  public void testValidateProduct_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LegacyOrderServiceImpl()).validateProduct(null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  public void testDetermineCategory_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LegacyOrderServiceImpl()).determineCategory(null, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  public void testDetermineCategory_whenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.determineCategory(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  public void testCheckSkuForMatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.checkSkuForMatch(sku, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItemToOrder_givenMinusOne_whenOrderItemRequestDTOQuantityIsMinusOne() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(-1);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(null, orderItemRequestDTO, true));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItemToOrder_givenTwo_whenOrderItemRequestDTOQuantityIsTwo() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(2);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(null, orderItemRequestDTO, true));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItemToOrder_givenZero_whenOrderItemRequestDTOQuantityIsZero() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(0);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addItemToOrder(null, orderItemRequestDTO, true));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItemToOrder_whenOne_thenReturnNull() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addItemToOrder(1L, new OrderItemRequestDTO(), true));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes3() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes4() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(null, null, null, 1L, null, true));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, null, null, 1L, null, true));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, null, 1L, 1L, null, true));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, 1L, null, 1L, null, true));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes2()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes3()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes4()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_thenReturnNull() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(null, null, null, 1L, null));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, null, null, 1L, null));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, null, 1L, 1L, null));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, 1L, null, 1L, null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LegacyOrderServiceImpl}
   *   <li>
   * {@link LegacyOrderServiceImpl#setFulfillmentGroupDao(FulfillmentGroupDao)}
   *   <li>
   * {@link LegacyOrderServiceImpl#setFulfillmentGroupItemDao(FulfillmentGroupItemDao)}
   *   <li>{@link LegacyOrderServiceImpl#setOrderDao(OrderDao)}
   *   <li>{@link LegacyOrderServiceImpl#setOrderItemService(OrderItemService)}
   *   <li>{@link LegacyOrderServiceImpl#setPaymentInfoDao(OrderPaymentDao)}
   *   <li>{@link LegacyOrderServiceImpl#getFulfillmentGroupDao()}
   *   <li>{@link LegacyOrderServiceImpl#getFulfillmentGroupItemDao()}
   *   <li>{@link LegacyOrderServiceImpl#getOrderDao()}
   *   <li>{@link LegacyOrderServiceImpl#getOrderItemService()}
   *   <li>{@link LegacyOrderServiceImpl#getPaymentInfoDao()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LegacyOrderServiceImpl actualLegacyOrderServiceImpl = new LegacyOrderServiceImpl();
    FulfillmentGroupDaoImpl fulfillmentGroupDao = new FulfillmentGroupDaoImpl();
    actualLegacyOrderServiceImpl.setFulfillmentGroupDao(fulfillmentGroupDao);
    FulfillmentGroupItemDaoImpl fulfillmentGroupItemDao = new FulfillmentGroupItemDaoImpl();
    actualLegacyOrderServiceImpl.setFulfillmentGroupItemDao(fulfillmentGroupItemDao);
    OrderDaoImpl orderDao = new OrderDaoImpl();
    actualLegacyOrderServiceImpl.setOrderDao(orderDao);
    OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
    actualLegacyOrderServiceImpl.setOrderItemService(orderItemService);
    OrderPaymentDaoImpl paymentInfoDao = new OrderPaymentDaoImpl();
    actualLegacyOrderServiceImpl.setPaymentInfoDao(paymentInfoDao);
    FulfillmentGroupDao actualFulfillmentGroupDao = actualLegacyOrderServiceImpl.getFulfillmentGroupDao();
    FulfillmentGroupItemDao actualFulfillmentGroupItemDao = actualLegacyOrderServiceImpl.getFulfillmentGroupItemDao();
    OrderDao actualOrderDao = actualLegacyOrderServiceImpl.getOrderDao();
    OrderItemService actualOrderItemService = actualLegacyOrderServiceImpl.getOrderItemService();
    OrderPaymentDao actualPaymentInfoDao = actualLegacyOrderServiceImpl.getPaymentInfoDao();

    // Assert that nothing has changed
    assertTrue(actualFulfillmentGroupDao instanceof FulfillmentGroupDaoImpl);
    assertTrue(actualFulfillmentGroupItemDao instanceof FulfillmentGroupItemDaoImpl);
    assertTrue(actualOrderDao instanceof OrderDaoImpl);
    assertTrue(actualOrderItemService instanceof OrderItemServiceImpl);
    assertTrue(actualPaymentInfoDao instanceof OrderPaymentDaoImpl);
    assertTrue(actualLegacyOrderServiceImpl.isDeleteEmptyNamedOrders());
    assertTrue(actualLegacyOrderServiceImpl.isMoveNamedOrderItems());
    assertSame(fulfillmentGroupDao, actualFulfillmentGroupDao);
    assertSame(fulfillmentGroupItemDao, actualFulfillmentGroupItemDao);
    assertSame(orderDao, actualOrderDao);
    assertSame(orderItemService, actualOrderItemService);
    assertSame(paymentInfoDao, actualPaymentInfoDao);
  }
}
