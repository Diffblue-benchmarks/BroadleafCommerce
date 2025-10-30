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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.core.offer.domain.OrderItemAdjustment;
import org.broadleafcommerce.core.offer.domain.ProratedOrderItemAdjustment;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderItemImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemImpl#setAuditable(Auditable)}
   *   <li>{@link OrderItemImpl#setCandidateItemOffers(List)}
   *   <li>{@link OrderItemImpl#setCartMessages(List)}
   *   <li>{@link OrderItemImpl#setChildOrderItems(List)}
   *   <li>{@link OrderItemImpl#setGiftWrapOrderItem(GiftWrapOrderItem)}
   *   <li>{@link OrderItemImpl#setHasValidationError(Boolean)}
   *   <li>{@link OrderItemImpl#setId(Long)}
   *   <li>{@link OrderItemImpl#setName(String)}
   *   <li>{@link OrderItemImpl#setOrder(Order)}
   *   <li>{@link OrderItemImpl#setOrderItemAdjustments(List)}
   *   <li>{@link OrderItemImpl#setOrderItemAttributes(Map)}
   *   <li>{@link OrderItemImpl#setOrderItemPriceDetails(List)}
   *   <li>{@link OrderItemImpl#setOrderItemQualifiers(List)}
   *   <li>{@link OrderItemImpl#setParentOrderItem(OrderItem)}
   *   <li>{@link OrderItemImpl#setPersonalMessage(PersonalMessage)}
   *   <li>{@link OrderItemImpl#setProratedOrderItemAdjustments(List)}
   *   <li>{@link OrderItemImpl#setQuantity(int)}
   *   <li>{@link OrderItemImpl#setTaxable(Boolean)}
   *   <li>{@link OrderItemImpl#getAuditable()}
   *   <li>{@link OrderItemImpl#getCandidateItemOffers()}
   *   <li>{@link OrderItemImpl#getCartMessages()}
   *   <li>{@link OrderItemImpl#getChildOrderItems()}
   *   <li>{@link OrderItemImpl#getId()}
   *   <li>{@link OrderItemImpl#getName()}
   *   <li>{@link OrderItemImpl#getOrder()}
   *   <li>{@link OrderItemImpl#getOrderItemAdjustments()}
   *   <li>{@link OrderItemImpl#getOrderItemAttributes()}
   *   <li>{@link OrderItemImpl#getOrderItemPriceDetails()}
   *   <li>{@link OrderItemImpl#getOrderItemQualifiers()}
   *   <li>{@link OrderItemImpl#getParentOrderItem()}
   *   <li>{@link OrderItemImpl#getPersonalMessage()}
   *   <li>{@link OrderItemImpl#getQuantity()}
   *   <li>{@link OrderItemImpl#isSkuActive()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Auditable OrderItemImpl.getAuditable()", "List OrderItemImpl.getCandidateItemOffers()",
      "List OrderItemImpl.getCartMessages()", "List OrderItemImpl.getChildOrderItems()", "Long OrderItemImpl.getId()",
      "String OrderItemImpl.getName()", "Order OrderItemImpl.getOrder()",
      "List OrderItemImpl.getOrderItemAdjustments()", "Map OrderItemImpl.getOrderItemAttributes()",
      "List OrderItemImpl.getOrderItemPriceDetails()", "List OrderItemImpl.getOrderItemQualifiers()",
      "OrderItem OrderItemImpl.getParentOrderItem()", "PersonalMessage OrderItemImpl.getPersonalMessage()",
      "int OrderItemImpl.getQuantity()", "boolean OrderItemImpl.isSkuActive()",
      "void OrderItemImpl.setAuditable(Auditable)", "void OrderItemImpl.setCandidateItemOffers(List)",
      "void OrderItemImpl.setCartMessages(List)", "void OrderItemImpl.setChildOrderItems(List)",
      "void OrderItemImpl.setGiftWrapOrderItem(GiftWrapOrderItem)", "void OrderItemImpl.setHasValidationError(Boolean)",
      "void OrderItemImpl.setId(Long)", "void OrderItemImpl.setName(String)", "void OrderItemImpl.setOrder(Order)",
      "void OrderItemImpl.setOrderItemAdjustments(List)", "void OrderItemImpl.setOrderItemAttributes(Map)",
      "void OrderItemImpl.setOrderItemPriceDetails(List)", "void OrderItemImpl.setOrderItemQualifiers(List)",
      "void OrderItemImpl.setParentOrderItem(OrderItem)", "void OrderItemImpl.setPersonalMessage(PersonalMessage)",
      "void OrderItemImpl.setProratedOrderItemAdjustments(List)", "void OrderItemImpl.setQuantity(int)",
      "void OrderItemImpl.setTaxable(Boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    // Act
    orderItemImpl.setAuditable(auditable);
    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    orderItemImpl.setCandidateItemOffers(candidateItemOffers);
    ArrayList<String> cartMessage = new ArrayList<>();
    orderItemImpl.setCartMessages(cartMessage);
    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    orderItemImpl.setChildOrderItems(childOrderItems);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    Order order = NullOrderFactoryImpl.NULL_ORDER;
    orderItemImpl.setOrder(order);
    ArrayList<OrderItemAdjustment> orderItemAdjustments = new ArrayList<>();
    orderItemImpl.setOrderItemAdjustments(orderItemAdjustments);
    HashMap<String, OrderItemAttribute> orderItemAttributes = new HashMap<>();
    orderItemImpl.setOrderItemAttributes(orderItemAttributes);
    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);
    ArrayList<OrderItemQualifier> orderItemQualifiers = new ArrayList<>();
    orderItemImpl.setOrderItemQualifiers(orderItemQualifiers);
    BundleOrderItemImpl parentOrderItem = new BundleOrderItemImpl();
    orderItemImpl.setParentOrderItem(parentOrderItem);
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    orderItemImpl.setPersonalMessage(personalMessage);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setTaxable(true);
    Auditable actualAuditable = orderItemImpl.getAuditable();
    List<CandidateItemOffer> actualCandidateItemOffers = orderItemImpl.getCandidateItemOffers();
    List<String> actualCartMessages = orderItemImpl.getCartMessages();
    List<OrderItem> actualChildOrderItems = orderItemImpl.getChildOrderItems();
    Long actualId = orderItemImpl.getId();
    String actualName = orderItemImpl.getName();
    Order actualOrder = orderItemImpl.getOrder();
    List<OrderItemAdjustment> actualOrderItemAdjustments = orderItemImpl.getOrderItemAdjustments();
    Map<String, OrderItemAttribute> actualOrderItemAttributes = orderItemImpl.getOrderItemAttributes();
    List<OrderItemPriceDetail> actualOrderItemPriceDetails = orderItemImpl.getOrderItemPriceDetails();
    List<OrderItemQualifier> actualOrderItemQualifiers = orderItemImpl.getOrderItemQualifiers();
    OrderItem actualParentOrderItem = orderItemImpl.getParentOrderItem();
    PersonalMessage actualPersonalMessage = orderItemImpl.getPersonalMessage();
    int actualQuantity = orderItemImpl.getQuantity();
    boolean actualIsSkuActiveResult = orderItemImpl.isSkuActive();

    // Assert
    assertTrue(actualPersonalMessage instanceof PersonalMessageImpl);
    assertEquals("Name", actualName);
    assertEquals(1, actualQuantity);
    assertTrue(actualCandidateItemOffers.isEmpty());
    assertTrue(actualCartMessages.isEmpty());
    assertTrue(actualChildOrderItems.isEmpty());
    assertTrue(actualIsSkuActiveResult);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(candidateItemOffers, actualCandidateItemOffers);
    assertSame(cartMessage, actualCartMessages);
    assertSame(childOrderItems, actualChildOrderItems);
    assertSame(orderItemAdjustments, actualOrderItemAdjustments);
    assertSame(orderItemPriceDetails, actualOrderItemPriceDetails);
    assertSame(orderItemQualifiers, actualOrderItemQualifiers);
    assertSame(orderItemAttributes, actualOrderItemAttributes);
    assertSame(auditable, actualAuditable);
    assertSame(parentOrderItem, actualParentOrderItem);
    assertSame(personalMessage, actualPersonalMessage);
    assertSame(order, actualOrder);
  }

  /**
   * Test {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)} with {@code allowSalesPrice}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemImpl#getPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemImpl.getPriceBeforeAdjustments(boolean)"})
  public void testGetPriceBeforeAdjustmentsWithAllowSalesPrice_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(new Money());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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
    bundleOrderItemImpl.setRetailPrice(null);

    // Act
    Money actualPriceBeforeAdjustments = bundleOrderItemImpl.getPriceBeforeAdjustments(true);

    // Assert
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl, atLeast(1)).getSalePrice();
    assertEquals(baseRetailPrice, actualPriceBeforeAdjustments);
  }

  /**
   * Test {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemImpl#getTotalPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemImpl.getTotalPriceBeforeAdjustments(boolean)"})
  public void testGetTotalPriceBeforeAdjustments_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(new Money());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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
    bundleOrderItemImpl.setRetailPrice(null);

    // Act
    Money actualTotalPriceBeforeAdjustments = bundleOrderItemImpl.getTotalPriceBeforeAdjustments(true);

    // Assert
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl, atLeast(1)).getSalePrice();
    assertEquals(baseRetailPrice, actualTotalPriceBeforeAdjustments);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl2);
    int expectedHashCodeResult = orderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl2);
    int expectedHashCodeResult = orderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl);
    int expectedHashCodeResult = orderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemImpl.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

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
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable3);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(bundleOrderItemImpl, orderItemImpl);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    doNothing().when(bundleOrderItemImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(bundleOrderItemImpl).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(bundleOrderItemImpl).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(bundleOrderItemImpl).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setDiscountingAllowed(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(bundleOrderItemImpl).setId(Mockito.<Long>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl)
        .setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    // Act and Assert
    assertNotEquals(orderItemImpl, bundleOrderItemImpl);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(null);
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    doNothing().when(bundleOrderItemImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(bundleOrderItemImpl).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(bundleOrderItemImpl).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(bundleOrderItemImpl).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setDiscountingAllowed(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(bundleOrderItemImpl).setId(Mockito.<Long>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl)
        .setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    // Act and Assert
    assertNotEquals(orderItemImpl, bundleOrderItemImpl);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, null);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, "Different type to OrderItemImpl");
  }
}
