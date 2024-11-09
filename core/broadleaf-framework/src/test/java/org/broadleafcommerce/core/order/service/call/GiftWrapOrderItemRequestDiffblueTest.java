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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class GiftWrapOrderItemRequestDiffblueTest {
  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}, and
   * {@link GiftWrapOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GiftWrapOrderItemRequest#equals(Object)}
   *   <li>{@link GiftWrapOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GiftWrapOrderItemRequest giftWrapOrderItemRequest = new GiftWrapOrderItemRequest();
    GiftWrapOrderItemRequest giftWrapOrderItemRequest2 = new GiftWrapOrderItemRequest();

    // Act and Assert
    assertEquals(giftWrapOrderItemRequest, giftWrapOrderItemRequest2);
    int expectedHashCodeResult = giftWrapOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, giftWrapOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}, and
   * {@link GiftWrapOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GiftWrapOrderItemRequest#equals(Object)}
   *   <li>{@link GiftWrapOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GiftWrapOrderItemRequest giftWrapOrderItemRequest = new GiftWrapOrderItemRequest();

    // Act and Assert
    assertEquals(giftWrapOrderItemRequest, giftWrapOrderItemRequest);
    int expectedHashCodeResult = giftWrapOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, giftWrapOrderItemRequest.hashCode());
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftWrapOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GiftWrapOrderItemRequest(), 1);
    assertNotEquals(new GiftWrapOrderItemRequest(), mock(DiscreteOrderItemRequest.class));
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftWrapOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<OrderItem> wrappedItems = new ArrayList<>();
    wrappedItems.add(new BundleOrderItemImpl());

    GiftWrapOrderItemRequest giftWrapOrderItemRequest = new GiftWrapOrderItemRequest();
    giftWrapOrderItemRequest.setWrappedItems(wrappedItems);

    // Act and Assert
    assertNotEquals(giftWrapOrderItemRequest, new GiftWrapOrderItemRequest());
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftWrapOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GiftWrapOrderItemRequest(), null);
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftWrapOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GiftWrapOrderItemRequest(), "Different type to GiftWrapOrderItemRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GiftWrapOrderItemRequest}
   *   <li>{@link GiftWrapOrderItemRequest#setWrappedItems(List)}
   *   <li>{@link GiftWrapOrderItemRequest#getWrappedItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    GiftWrapOrderItemRequest actualGiftWrapOrderItemRequest = new GiftWrapOrderItemRequest();
    ArrayList<OrderItem> wrappedItems = new ArrayList<>();
    actualGiftWrapOrderItemRequest.setWrappedItems(wrappedItems);
    List<OrderItem> actualWrappedItems = actualGiftWrapOrderItemRequest.getWrappedItems();

    // Assert that nothing has changed
    assertEquals(0, actualGiftWrapOrderItemRequest.getQuantity());
    assertTrue(actualGiftWrapOrderItemRequest.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualWrappedItems.isEmpty());
    assertTrue(actualGiftWrapOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualGiftWrapOrderItemRequest.getItemAttributes().isEmpty());
    assertSame(wrappedItems, actualWrappedItems);
  }
}
