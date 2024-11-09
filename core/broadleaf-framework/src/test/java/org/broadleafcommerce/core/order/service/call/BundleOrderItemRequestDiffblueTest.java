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
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemFeePrice;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;

public class BundleOrderItemRequestDiffblueTest {
  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}, and
   * {@link BundleOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemRequest#equals(Object)}
   *   <li>{@link BundleOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(new CategoryImpl());
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName("Name");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    BundleOrderItemRequest bundleOrderItemRequest2 = new BundleOrderItemRequest();
    bundleOrderItemRequest2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest2.setCategory(new CategoryImpl());
    bundleOrderItemRequest2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest2.setName("Name");
    bundleOrderItemRequest2.setOrder(new NullOrderImpl());
    bundleOrderItemRequest2.setQuantity(1);
    bundleOrderItemRequest2.setRetailPriceOverride(new Money());
    bundleOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertEquals(bundleOrderItemRequest, bundleOrderItemRequest2);
    int expectedHashCodeResult = bundleOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}, and
   * {@link BundleOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemRequest#equals(Object)}
   *   <li>{@link BundleOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(null);
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName("Name");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    BundleOrderItemRequest bundleOrderItemRequest2 = new BundleOrderItemRequest();
    bundleOrderItemRequest2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest2.setCategory(null);
    bundleOrderItemRequest2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest2.setName("Name");
    bundleOrderItemRequest2.setOrder(new NullOrderImpl());
    bundleOrderItemRequest2.setQuantity(1);
    bundleOrderItemRequest2.setRetailPriceOverride(new Money());
    bundleOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertEquals(bundleOrderItemRequest, bundleOrderItemRequest2);
    int expectedHashCodeResult = bundleOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}, and
   * {@link BundleOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemRequest#equals(Object)}
   *   <li>{@link BundleOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(new CategoryImpl());
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName(null);
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    BundleOrderItemRequest bundleOrderItemRequest2 = new BundleOrderItemRequest();
    bundleOrderItemRequest2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest2.setCategory(new CategoryImpl());
    bundleOrderItemRequest2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest2.setName(null);
    bundleOrderItemRequest2.setOrder(new NullOrderImpl());
    bundleOrderItemRequest2.setQuantity(1);
    bundleOrderItemRequest2.setRetailPriceOverride(new Money());
    bundleOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertEquals(bundleOrderItemRequest, bundleOrderItemRequest2);
    int expectedHashCodeResult = bundleOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}, and
   * {@link BundleOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemRequest#equals(Object)}
   *   <li>{@link BundleOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(new CategoryImpl());
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName("Name");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    // Act and Assert
    assertEquals(bundleOrderItemRequest, bundleOrderItemRequest);
    int expectedHashCodeResult = bundleOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemRequest.hashCode());
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(null);
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName("Name");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    BundleOrderItemRequest bundleOrderItemRequest2 = new BundleOrderItemRequest();
    bundleOrderItemRequest2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest2.setCategory(new CategoryImpl());
    bundleOrderItemRequest2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest2.setName("Name");
    bundleOrderItemRequest2.setOrder(new NullOrderImpl());
    bundleOrderItemRequest2.setQuantity(1);
    bundleOrderItemRequest2.setRetailPriceOverride(new Money());
    bundleOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(bundleOrderItemRequest, bundleOrderItemRequest2);
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(mock(CategoryImpl.class));
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName("Name");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    BundleOrderItemRequest bundleOrderItemRequest2 = new BundleOrderItemRequest();
    bundleOrderItemRequest2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest2.setCategory(new CategoryImpl());
    bundleOrderItemRequest2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest2.setName("Name");
    bundleOrderItemRequest2.setOrder(new NullOrderImpl());
    bundleOrderItemRequest2.setQuantity(1);
    bundleOrderItemRequest2.setRetailPriceOverride(new Money());
    bundleOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(bundleOrderItemRequest, bundleOrderItemRequest2);
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<DiscreteOrderItemRequest> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemRequest());

    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(new CategoryImpl());
    bundleOrderItemRequest.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemRequest.setName("Name");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    BundleOrderItemRequest bundleOrderItemRequest2 = new BundleOrderItemRequest();
    bundleOrderItemRequest2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest2.setCategory(new CategoryImpl());
    bundleOrderItemRequest2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest2.setName("Name");
    bundleOrderItemRequest2.setOrder(new NullOrderImpl());
    bundleOrderItemRequest2.setQuantity(1);
    bundleOrderItemRequest2.setRetailPriceOverride(new Money());
    bundleOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(bundleOrderItemRequest, bundleOrderItemRequest2);
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(new CategoryImpl());
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName(null);
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    BundleOrderItemRequest bundleOrderItemRequest2 = new BundleOrderItemRequest();
    bundleOrderItemRequest2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest2.setCategory(new CategoryImpl());
    bundleOrderItemRequest2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest2.setName("Name");
    bundleOrderItemRequest2.setOrder(new NullOrderImpl());
    bundleOrderItemRequest2.setQuantity(1);
    bundleOrderItemRequest2.setRetailPriceOverride(new Money());
    bundleOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(bundleOrderItemRequest, bundleOrderItemRequest2);
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(new CategoryImpl());
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName("42");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    BundleOrderItemRequest bundleOrderItemRequest2 = new BundleOrderItemRequest();
    bundleOrderItemRequest2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest2.setCategory(new CategoryImpl());
    bundleOrderItemRequest2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest2.setName("Name");
    bundleOrderItemRequest2.setOrder(new NullOrderImpl());
    bundleOrderItemRequest2.setQuantity(1);
    bundleOrderItemRequest2.setRetailPriceOverride(new Money());
    bundleOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(bundleOrderItemRequest, bundleOrderItemRequest2);
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(new CategoryImpl());
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName("Name");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(0);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    BundleOrderItemRequest bundleOrderItemRequest2 = new BundleOrderItemRequest();
    bundleOrderItemRequest2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest2.setCategory(new CategoryImpl());
    bundleOrderItemRequest2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest2.setName("Name");
    bundleOrderItemRequest2.setOrder(new NullOrderImpl());
    bundleOrderItemRequest2.setQuantity(1);
    bundleOrderItemRequest2.setRetailPriceOverride(new Money());
    bundleOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(bundleOrderItemRequest, bundleOrderItemRequest2);
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(new CategoryImpl());
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName("Name");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(bundleOrderItemRequest, null);
  }

  /**
   * Test {@link BundleOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemRequest#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BundleOrderItemRequest bundleOrderItemRequest = new BundleOrderItemRequest();
    bundleOrderItemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemRequest.setCategory(new CategoryImpl());
    bundleOrderItemRequest.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemRequest.setName("Name");
    bundleOrderItemRequest.setOrder(new NullOrderImpl());
    bundleOrderItemRequest.setQuantity(1);
    bundleOrderItemRequest.setRetailPriceOverride(new Money());
    bundleOrderItemRequest.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(bundleOrderItemRequest, "Different type to BundleOrderItemRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BundleOrderItemRequest}
   *   <li>{@link BundleOrderItemRequest#setBundleOrderItemFeePrices(List)}
   *   <li>{@link BundleOrderItemRequest#setCategory(Category)}
   *   <li>{@link BundleOrderItemRequest#setDiscreteOrderItems(List)}
   *   <li>{@link BundleOrderItemRequest#setName(String)}
   *   <li>{@link BundleOrderItemRequest#setOrder(Order)}
   *   <li>{@link BundleOrderItemRequest#setQuantity(int)}
   *   <li>{@link BundleOrderItemRequest#setRetailPriceOverride(Money)}
   *   <li>{@link BundleOrderItemRequest#setSalePriceOverride(Money)}
   *   <li>{@link BundleOrderItemRequest#getBundleOrderItemFeePrices()}
   *   <li>{@link BundleOrderItemRequest#getCategory()}
   *   <li>{@link BundleOrderItemRequest#getDiscreteOrderItems()}
   *   <li>{@link BundleOrderItemRequest#getName()}
   *   <li>{@link BundleOrderItemRequest#getOrder()}
   *   <li>{@link BundleOrderItemRequest#getQuantity()}
   *   <li>{@link BundleOrderItemRequest#getRetailPriceOverride()}
   *   <li>{@link BundleOrderItemRequest#getSalePriceOverride()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BundleOrderItemRequest actualBundleOrderItemRequest = new BundleOrderItemRequest();
    ArrayList<BundleOrderItemFeePrice> bundleOrderItemFeePrices = new ArrayList<>();
    actualBundleOrderItemRequest.setBundleOrderItemFeePrices(bundleOrderItemFeePrices);
    CategoryImpl category = new CategoryImpl();
    actualBundleOrderItemRequest.setCategory(category);
    ArrayList<DiscreteOrderItemRequest> discreteOrderItems = new ArrayList<>();
    actualBundleOrderItemRequest.setDiscreteOrderItems(discreteOrderItems);
    actualBundleOrderItemRequest.setName("Name");
    NullOrderImpl order = new NullOrderImpl();
    actualBundleOrderItemRequest.setOrder(order);
    actualBundleOrderItemRequest.setQuantity(1);
    Money retailPriceOverride = new Money();
    actualBundleOrderItemRequest.setRetailPriceOverride(retailPriceOverride);
    Money salePriceOverride = new Money();
    actualBundleOrderItemRequest.setSalePriceOverride(salePriceOverride);
    List<BundleOrderItemFeePrice> actualBundleOrderItemFeePrices = actualBundleOrderItemRequest
        .getBundleOrderItemFeePrices();
    Category actualCategory = actualBundleOrderItemRequest.getCategory();
    List<DiscreteOrderItemRequest> actualDiscreteOrderItems = actualBundleOrderItemRequest.getDiscreteOrderItems();
    String actualName = actualBundleOrderItemRequest.getName();
    Order actualOrder = actualBundleOrderItemRequest.getOrder();
    int actualQuantity = actualBundleOrderItemRequest.getQuantity();
    Money actualRetailPriceOverride = actualBundleOrderItemRequest.getRetailPriceOverride();
    Money actualSalePriceOverride = actualBundleOrderItemRequest.getSalePriceOverride();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(1, actualQuantity);
    assertTrue(actualBundleOrderItemFeePrices.isEmpty());
    assertTrue(actualDiscreteOrderItems.isEmpty());
    assertSame(bundleOrderItemFeePrices, actualBundleOrderItemFeePrices);
    assertSame(discreteOrderItems, actualDiscreteOrderItems);
    assertSame(retailPriceOverride, actualRetailPriceOverride);
    assertSame(salePriceOverride, actualSalePriceOverride);
    assertSame(category, actualCategory);
    assertSame(order, actualOrder);
  }
}
