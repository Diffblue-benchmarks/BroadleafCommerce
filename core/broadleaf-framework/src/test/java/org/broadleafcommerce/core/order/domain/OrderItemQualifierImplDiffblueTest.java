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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Test;

public class OrderItemQualifierImplDiffblueTest {
  /**
   * Test {@link OrderItemQualifierImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl}.</li>
   *   <li>Then {@link OrderItemQualifierImpl} (default constructor) Offer is
   * {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenOrderItemQualifierImplOfferIsOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    OfferImpl offer = mock(OfferImpl.class);

    // Act
    orderItemQualifierImpl.setOffer(offer);

    // Assert
    assertSame(offer, orderItemQualifierImpl.getOffer());
    assertSame(offer, orderItemQualifierImpl.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemQualifierImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then {@link OrderItemQualifierImpl} (default constructor)
   * {@link OrderItemQualifierImpl#offer} {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenOrderItemQualifierImplOfferOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemQualifierImpl.setOffer(offer);

    // Assert
    Offer offer2 = orderItemQualifierImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(offer2.getValue());
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, offer2.getPriority());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertSame(offer, orderItemQualifierImpl.getOffer());
    assertSame(offer, orderItemQualifierImpl.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemQualifierImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link OrderItemQualifierImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenOrderItemQualifierImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderItemQualifierImpl()).getOffer());
  }

  /**
   * Test {@link OrderItemQualifierImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link OrderItemQualifierImpl} (default constructor) OrderItem is
   * {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenOrderItemQualifierImplOrderItemIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setOrderItem(mock(BundleOrderItemImpl.class));

    // Act and Assert
    assertNull(orderItemQualifierImpl.getOffer());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and
   * {@link OrderItemQualifierImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
    int expectedHashCodeResult = orderItemQualifierImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemQualifierImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and
   * {@link OrderItemQualifierImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(null);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(null);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
    int expectedHashCodeResult = orderItemQualifierImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemQualifierImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and
   * {@link OrderItemQualifierImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(null);
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(null);
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
    int expectedHashCodeResult = orderItemQualifierImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemQualifierImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and
   * {@link OrderItemQualifierImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(null);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(null);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
    int expectedHashCodeResult = orderItemQualifierImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemQualifierImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and
   * {@link OrderItemQualifierImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl);
    int expectedHashCodeResult = orderItemQualifierImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemQualifierImpl.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(2L);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(null);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(orderItem);
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(null);
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(mock(BundleOrderItemImpl.class));
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(0L);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(null);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, null);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, "Different type to OrderItemQualifierImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemQualifierImpl}
   *   <li>{@link OrderItemQualifierImpl#setId(Long)}
   *   <li>{@link OrderItemQualifierImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemQualifierImpl#setQuantity(Long)}
   *   <li>{@link OrderItemQualifierImpl#getId()}
   *   <li>{@link OrderItemQualifierImpl#getOrderItem()}
   *   <li>{@link OrderItemQualifierImpl#getQuantity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemQualifierImpl actualOrderItemQualifierImpl = new OrderItemQualifierImpl();
    actualOrderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemQualifierImpl.setOrderItem(orderItem);
    actualOrderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);
    Long actualId = actualOrderItemQualifierImpl.getId();
    OrderItem actualOrderItem = actualOrderItemQualifierImpl.getOrderItem();
    Long actualQuantity = actualOrderItemQualifierImpl.getQuantity();

    // Assert that nothing has changed
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualQuantity.longValue());
    assertSame(orderItem, actualOrderItem);
  }
}
