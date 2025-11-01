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
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AddToCartItemsDiffblueTest {
  /**
   * Method under test: {@link AddToCartItems#setProductId(long)}
   */
  @Test
  public void testSetProductId() {
    // Arrange
    AddToCartItems addToCartItems = new AddToCartItems();

    // Act
    addToCartItems.setProductId(1L);

    // Assert
    assertEquals(1L, addToCartItems.getProductId());
    assertTrue(addToCartItems.getAddToCartItems().isEmpty());
  }

  /**
   * Method under test: {@link AddToCartItems#setProductId(long)}
   */
  @Test
  public void testSetProductId2() {
    // Arrange
    ArrayList<OrderItemRequestDTO> addToCartItems = new ArrayList<>();
    addToCartItems.add(new OrderItemRequestDTO());

    AddToCartItems addToCartItems2 = new AddToCartItems();
    addToCartItems2.setCategoryId(1L);
    addToCartItems2.setProductId(1L);
    addToCartItems2.setAddToCartItem(addToCartItems);

    // Act
    addToCartItems2.setProductId(1L);

    // Assert
    assertEquals(1L, addToCartItems2.getProductId());
    assertSame(addToCartItems, addToCartItems2.getAddToCartItems());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AddToCartItems#setAddToCartItem(List)}
   *   <li>{@link AddToCartItems#getAddToCartItems()}
   *   <li>{@link AddToCartItems#getCategoryId()}
   *   <li>{@link AddToCartItems#getProductId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AddToCartItems addToCartItems = new AddToCartItems();
    ArrayList<OrderItemRequestDTO> addToCartItems2 = new ArrayList<>();

    // Act
    addToCartItems.setAddToCartItem(addToCartItems2);
    List<OrderItemRequestDTO> actualAddToCartItems = addToCartItems.getAddToCartItems();
    long actualCategoryId = addToCartItems.getCategoryId();

    // Assert that nothing has changed
    assertEquals(0L, actualCategoryId);
    assertEquals(0L, addToCartItems.getProductId());
    assertTrue(actualAddToCartItems.isEmpty());
    assertSame(addToCartItems2, actualAddToCartItems);
  }

  /**
   * Method under test: {@link AddToCartItems#setCategoryId(long)}
   */
  @Test
  public void testSetCategoryId() {
    // Arrange
    AddToCartItems addToCartItems = new AddToCartItems();

    // Act
    addToCartItems.setCategoryId(1L);

    // Assert
    assertEquals(1L, addToCartItems.getCategoryId());
    assertTrue(addToCartItems.getAddToCartItems().isEmpty());
  }

  /**
   * Method under test: {@link AddToCartItems#setCategoryId(long)}
   */
  @Test
  public void testSetCategoryId2() {
    // Arrange
    ArrayList<OrderItemRequestDTO> addToCartItems = new ArrayList<>();
    addToCartItems.add(new OrderItemRequestDTO());

    AddToCartItems addToCartItems2 = new AddToCartItems();
    addToCartItems2.setAddToCartItem(addToCartItems);

    // Act
    addToCartItems2.setCategoryId(1L);

    // Assert
    assertEquals(1L, addToCartItems2.getCategoryId());
    assertSame(addToCartItems, addToCartItems2.getAddToCartItems());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AddToCartItems}
   */
  @Test
  public void testNewAddToCartItems() {
    // Arrange and Act
    AddToCartItems actualAddToCartItems = new AddToCartItems();

    // Assert
    assertEquals(0L, actualAddToCartItems.getCategoryId());
    assertEquals(0L, actualAddToCartItems.getProductId());
    assertTrue(actualAddToCartItems.getAddToCartItems().isEmpty());
  }
}
