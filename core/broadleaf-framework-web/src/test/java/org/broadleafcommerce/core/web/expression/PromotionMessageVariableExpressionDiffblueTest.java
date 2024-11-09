/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PromotionMessageVariableExpressionDiffblueTest {
  /**
   * Test {@link PromotionMessageVariableExpression#getName()}.
   * <p>
   * Method under test: {@link PromotionMessageVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("promotion_messages", (new PromotionMessageVariableExpression()).getName());
  }

  /**
   * Test
   * {@link PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}
   */
  @Test
  @DisplayName("Test getItemPromotionMessages(OrderItem); given Auditable (default constructor) CreatedBy is one; then return size is two")
  void testGetItemPromotionMessages_givenAuditableCreatedByIsOne_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression = new PromotionMessageVariableExpression();

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

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

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
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(new OrderItemType("Type", "Friendly Type"));
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

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments2 = new ArrayList<>();
    orderItemPriceDetailAdjustments2.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setId(1L);
    orderItemPriceDetailImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl2.setQuantity(1);
    orderItemPriceDetailImpl2.setUseSalePrice(true);
    orderItemPriceDetailImpl2.setOrderItemAdjustments(orderItemPriceDetailAdjustments2);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails2 = new ArrayList<>();
    orderItemPriceDetails2.add(orderItemPriceDetailImpl2);

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
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(new OrderItemType("Type", "Friendly Type"));
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
    orderItem.setOrderItemPriceDetails(orderItemPriceDetails2);

    // Act
    List<String> actualItemPromotionMessages = promotionMessageVariableExpression.getItemPromotionMessages(orderItem);

    // Assert
    assertEquals(2, actualItemPromotionMessages.size());
    assertNull(actualItemPromotionMessages.get(0));
    assertNull(actualItemPromotionMessages.get(1));
  }

  /**
   * Test
   * {@link PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#getChildOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}
   */
  @Test
  @DisplayName("Test getItemPromotionMessages(OrderItem); then calls getChildOrderItems()")
  void testGetItemPromotionMessages_thenCallsGetChildOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression = new PromotionMessageVariableExpression();
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());

    // Act
    List<String> actualItemPromotionMessages = promotionMessageVariableExpression.getItemPromotionMessages(orderItem);

    // Assert
    verify(orderItem).getChildOrderItems();
    verify(orderItem).getOrderItemPriceDetails();
    assertTrue(actualItemPromotionMessages.isEmpty());
  }

  /**
   * Test
   * {@link PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}
   */
  @Test
  @DisplayName("Test getItemPromotionMessages(OrderItem); when BundleOrderItemImpl (default constructor); then return Empty")
  void testGetItemPromotionMessages_whenBundleOrderItemImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression = new PromotionMessageVariableExpression();

    // Act and Assert
    assertTrue(promotionMessageVariableExpression.getItemPromotionMessages(new BundleOrderItemImpl()).isEmpty());
  }

  /**
   * Test
   * {@link PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#getOrderItemPriceDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}
   */
  @Test
  @DisplayName("Test getAppliedOfferNamesForOrderItem(OrderItem); then calls getOrderItemPriceDetails()")
  void testGetAppliedOfferNamesForOrderItem_thenCallsGetOrderItemPriceDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression = new PromotionMessageVariableExpression();
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());

    // Act
    List<String> actualAppliedOfferNamesForOrderItem = promotionMessageVariableExpression
        .getAppliedOfferNamesForOrderItem(orderItem);

    // Assert
    verify(orderItem).getOrderItemPriceDetails();
    assertTrue(actualAppliedOfferNamesForOrderItem.isEmpty());
  }

  /**
   * Test
   * {@link PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}
   */
  @Test
  @DisplayName("Test getAppliedOfferNamesForOrderItem(OrderItem); then return size is one")
  void testGetAppliedOfferNamesForOrderItem_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression = new PromotionMessageVariableExpression();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

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
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(new OrderItemType("Type", "Friendly Type"));
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
    orderItem.setOrderItemPriceDetails(orderItemPriceDetails);

    // Act
    List<String> actualAppliedOfferNamesForOrderItem = promotionMessageVariableExpression
        .getAppliedOfferNamesForOrderItem(orderItem);

    // Assert
    assertEquals(1, actualAppliedOfferNamesForOrderItem.size());
    assertNull(actualAppliedOfferNamesForOrderItem.get(0));
  }

  /**
   * Test
   * {@link PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}
   */
  @Test
  @DisplayName("Test getAppliedOfferNamesForOrderItem(OrderItem); when BundleOrderItemImpl (default constructor); then return Empty")
  void testGetAppliedOfferNamesForOrderItem_whenBundleOrderItemImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression = new PromotionMessageVariableExpression();

    // Act and Assert
    assertTrue(
        promotionMessageVariableExpression.getAppliedOfferNamesForOrderItem(new BundleOrderItemImpl()).isEmpty());
  }

  /**
   * Test
   * {@link PromotionMessageVariableExpression#filterInvalidPlacements(String[])}.
   * <p>
   * Method under test:
   * {@link PromotionMessageVariableExpression#filterInvalidPlacements(String[])}
   */
  @Test
  @DisplayName("Test filterInvalidPlacements(String[])")
  void testFilterInvalidPlacements() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PromotionMessageVariableExpression())
        .filterInvalidPlacements(new String[]{"Stripping out invalid promotion message placement "})
        .isEmpty());
  }

  /**
   * Test
   * {@link PromotionMessageVariableExpression#filterInvalidPlacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code Placements}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageVariableExpression#filterInvalidPlacements(String[])}
   */
  @Test
  @DisplayName("Test filterInvalidPlacements(String[]); when array of String with 'Placements'; then return Empty")
  void testFilterInvalidPlacements_whenArrayOfStringWithPlacements_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue(
        (new PromotionMessageVariableExpression()).filterInvalidPlacements(new String[]{"Placements"}).isEmpty());
  }

  /**
   * Test {@link PromotionMessageVariableExpression#isValidPlacementType(String)}.
   * <p>
   * Method under test:
   * {@link PromotionMessageVariableExpression#isValidPlacementType(String)}
   */
  @Test
  @DisplayName("Test isValidPlacementType(String)")
  void testIsValidPlacementType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PromotionMessageVariableExpression()).isValidPlacementType("Placement"));
  }
}
