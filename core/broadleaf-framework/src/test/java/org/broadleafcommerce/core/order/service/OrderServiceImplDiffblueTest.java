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
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.exception.UpdateCartException;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class OrderServiceImplDiffblueTest {
  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  public void testFindLastMatchingItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(new NullOrderImpl(), 1L, 1L));
  }

  /**
   * Test
   * {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)}
   * with {@code namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)}
   */
  @Test
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), 2, true));
  }

  /**
   * Test {@link OrderServiceImpl#getTotalChildOrderItems(OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#getTotalChildOrderItems(OrderItemRequestDTO)}
   */
  @Test
  public void testGetTotalChildOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    // Act and Assert
    assertEquals(1, orderServiceImpl.getTotalChildOrderItems(new OrderItemRequestDTO()));
  }

  /**
   * Test
   * {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)}
   */
  @Test
  public void testAddDependentOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    OrderItemRequestDTO parentOrderItemRequest = new OrderItemRequestDTO();
    OrderItemRequestDTO dependentOrderItem = new OrderItemRequestDTO();

    // Act
    orderServiceImpl.addDependentOrderItem(parentOrderItemRequest, dependentOrderItem);

    // Assert
    List<OrderItemRequestDTO> childOrderItems = parentOrderItemRequest.getChildOrderItems();
    assertEquals(1, childOrderItems.size());
    assertSame(dependentOrderItem, childOrderItems.get(0));
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  public void testFindAllChildrenToRemove_givenAuditableCreatedByIsOne_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
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
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
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
    orderItem.setChildOrderItems(childOrderItems);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(1, childrenToRemove.size());
    assertEquals(1L, childrenToRemove.get(0).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  public void testFindAllChildrenToRemove_thenArrayListSizeIsFour() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    Auditable auditable5 = new Auditable();
    auditable5.setCreatedBy(1L);
    auditable5.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable5);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
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
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable4);
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
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl bundleOrderItemImpl3 = new BundleOrderItemImpl();
    bundleOrderItemImpl3.setAuditable(auditable3);
    bundleOrderItemImpl3.setBaseRetailPrice(new Money());
    bundleOrderItemImpl3.setBaseSalePrice(new Money());
    bundleOrderItemImpl3.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl3.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl3.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl3.setDiscountingAllowed(true);
    bundleOrderItemImpl3.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl3.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl3.setHasValidationError(true);
    bundleOrderItemImpl3.setId(1L);
    bundleOrderItemImpl3.setName("Name");
    bundleOrderItemImpl3.setOrder(new NullOrderImpl());
    bundleOrderItemImpl3.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl3.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl3.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl3.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl3.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setQuantity(1);
    bundleOrderItemImpl3.setRetailPrice(new Money());
    bundleOrderItemImpl3.setRetailPriceOverride(true);
    bundleOrderItemImpl3.setSalePrice(new Money());
    bundleOrderItemImpl3.setSalePriceOverride(true);
    bundleOrderItemImpl3.setTaxable(true);
    bundleOrderItemImpl3.updateSaleAndRetailPrices();
    bundleOrderItemImpl3.setChildOrderItems(childOrderItems2);

    ArrayList<OrderItem> childOrderItems3 = new ArrayList<>();
    childOrderItems3.add(bundleOrderItemImpl3);

    BundleOrderItemImpl bundleOrderItemImpl4 = new BundleOrderItemImpl();
    bundleOrderItemImpl4.setAuditable(auditable2);
    bundleOrderItemImpl4.setBaseRetailPrice(new Money());
    bundleOrderItemImpl4.setBaseSalePrice(new Money());
    bundleOrderItemImpl4.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl4.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl4.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl4.setDiscountingAllowed(true);
    bundleOrderItemImpl4.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl4.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl4.setHasValidationError(true);
    bundleOrderItemImpl4.setId(1L);
    bundleOrderItemImpl4.setName("Name");
    bundleOrderItemImpl4.setOrder(new NullOrderImpl());
    bundleOrderItemImpl4.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl4.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl4.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl4.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl4.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setQuantity(1);
    bundleOrderItemImpl4.setRetailPrice(new Money());
    bundleOrderItemImpl4.setRetailPriceOverride(true);
    bundleOrderItemImpl4.setSalePrice(new Money());
    bundleOrderItemImpl4.setSalePriceOverride(true);
    bundleOrderItemImpl4.setTaxable(true);
    bundleOrderItemImpl4.updateSaleAndRetailPrices();
    bundleOrderItemImpl4.setChildOrderItems(childOrderItems3);

    ArrayList<OrderItem> childOrderItems4 = new ArrayList<>();
    childOrderItems4.add(bundleOrderItemImpl4);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
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
    orderItem.setChildOrderItems(childOrderItems4);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(4, childrenToRemove.size());
    assertEquals(1L, childrenToRemove.get(1).longValue());
    assertEquals(1L, childrenToRemove.get(2).longValue());
    assertEquals(1L, childrenToRemove.get(3).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  public void testFindAllChildrenToRemove_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable3);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
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
    bundleOrderItemImpl.setChildOrderItems(null);

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
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
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
    orderItem.setChildOrderItems(childOrderItems2);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(2, childrenToRemove.size());
    assertEquals(1L, childrenToRemove.get(0).longValue());
    assertEquals(1L, childrenToRemove.get(1).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  public void testFindAllChildrenToRemove_whenBundleOrderItemImpl_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, new BundleOrderItemImpl());

    // Assert that nothing has changed
    assertTrue(childrenToRemove.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}
   */
  @Test
  public void testGetAutomaticallyMergeLikeItems_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    orderServiceImpl.setAutomaticallyMergeLikeItems(true);

    // Act and Assert
    assertTrue(orderServiceImpl.getAutomaticallyMergeLikeItems());
  }

  /**
   * Test {@link OrderServiceImpl#setAutomaticallyMergeLikeItems(boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#setAutomaticallyMergeLikeItems(boolean)}
   */
  @Test
  public void testSetAutomaticallyMergeLikeItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    // Act
    orderServiceImpl.setAutomaticallyMergeLikeItems(true);

    // Assert
    assertTrue(orderServiceImpl.getAutomaticallyMergeLikeItems());
    assertTrue(orderServiceImpl.automaticallyMergeLikeItems);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderServiceImpl#setDeleteEmptyNamedOrders(boolean)}
   *   <li>{@link OrderServiceImpl#setMoveNamedOrderItems(boolean)}
   *   <li>{@link OrderServiceImpl#isDeleteEmptyNamedOrders()}
   *   <li>{@link OrderServiceImpl#isMoveNamedOrderItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    // Act
    orderServiceImpl.setDeleteEmptyNamedOrders(true);
    orderServiceImpl.setMoveNamedOrderItems(true);
    boolean actualIsDeleteEmptyNamedOrdersResult = orderServiceImpl.isDeleteEmptyNamedOrders();

    // Assert that nothing has changed
    assertTrue(actualIsDeleteEmptyNamedOrdersResult);
    assertTrue(orderServiceImpl.isMoveNamedOrderItems());
  }

  /**
   * Test
   * {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}
   */
  @Test
  public void testGetCartOperationExceptionRootCause() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    WorkflowException e = new WorkflowException("An error occurred");

    // Act and Assert
    assertSame(e, orderServiceImpl.getCartOperationExceptionRootCause(e));
  }

  /**
   * Test
   * {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>Then return {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}
   */
  @Test
  public void testGetCartOperationExceptionRootCause_givenThrowable_thenReturnThrowable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    WorkflowException e = new WorkflowException("An error occurred");
    Throwable throwable = new Throwable();
    e.initCause(throwable);

    // Act and Assert
    assertSame(throwable, orderServiceImpl.getCartOperationExceptionRootCause(e));
  }

  /**
   * Test
   * {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}.
   * <ul>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}
   */
  @Test
  public void testGetCartOperationExceptionRootCause_thenReturnCauseIsThrowable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Throwable throwable = new Throwable();
    Throwable throwable2 = new Throwable();
    throwable.initCause(throwable2);

    WorkflowException e = new WorkflowException("An error occurred");
    e.initCause(throwable);

    // Act and Assert
    assertSame(throwable2, orderServiceImpl.getCartOperationExceptionRootCause(e).getCause());
  }

  /**
   * Test {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}
   */
  @Test
  public void testCompareAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    // Act and Assert
    assertTrue(orderServiceImpl.compareAttributes(item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test
   * {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}
   */
  @Test
  public void testItemMatches() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    SkuImpl item1Sku = new SkuImpl();
    ProductBundleImpl item1Product = new ProductBundleImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    // Act and Assert
    assertFalse(orderServiceImpl.itemMatches(item1Sku, item1Product, item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#reloadOrder(Order)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link OrderImpl} (default constructor) Id is {@code null}.</li>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#reloadOrder(Order)}
   */
  @Test
  public void testReloadOrder_givenNull_whenOrderImplIdIsNull_thenReturnOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

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
    order.setId(null);

    // Act and Assert
    assertSame(order, orderServiceImpl.reloadOrder(order));
  }

  /**
   * Test {@link OrderServiceImpl#reloadOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#reloadOrder(Order)}
   */
  @Test
  public void testReloadOrder_whenNullOrderImpl_thenReturnNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, orderServiceImpl.reloadOrder(order));
  }

  /**
   * Test {@link OrderServiceImpl#reloadOrder(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#reloadOrder(Order)}
   */
  @Test
  public void testReloadOrder_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderServiceImpl()).reloadOrder(null));
  }
}
