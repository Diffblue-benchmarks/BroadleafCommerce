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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemQualifierImplDiffblueTest {
  @Autowired
  private OrderItemQualifierImpl orderItemQualifierImpl;

  /**
   * Test {@link OrderItemQualifierImpl#setOffer(Offer)}.
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemQualifierImpl.setOffer(Offer)"})
  public void testSetOffer() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemQualifierImpl2.setOffer(offer);

    // Assert
    assertTrue(orderItemQualifierImpl2.offer instanceof OfferImpl);
    assertSame(offer, orderItemQualifierImpl2.getOffer());
    assertSame(offer, orderItemQualifierImpl2.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemQualifierImpl#getOffer()}.
   * <p>
   * Method under test: {@link OrderItemQualifierImpl#getOffer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OrderItemQualifierImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull((new OrderItemQualifierImpl()).getOffer());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link OrderItemQualifierImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link OrderItemQualifierImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link OrderItemQualifierImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link OrderItemQualifierImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link OrderItemQualifierImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
    orderItem.setPrice(new Money());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemQualifierImpl.equals(Object)", "int OrderItemQualifierImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemQualifierImpl.<init>()", "Long OrderItemQualifierImpl.getId()",
      "OrderItem OrderItemQualifierImpl.getOrderItem()", "Long OrderItemQualifierImpl.getQuantity()",
      "void OrderItemQualifierImpl.setId(Long)", "void OrderItemQualifierImpl.setOrderItem(OrderItem)",
      "void OrderItemQualifierImpl.setQuantity(Long)"})
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

    // Assert
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualQuantity.longValue());
    assertSame(orderItem, actualOrderItem);
  }
}
