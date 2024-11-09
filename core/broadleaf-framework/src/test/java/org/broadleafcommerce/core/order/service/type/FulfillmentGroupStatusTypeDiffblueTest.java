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
package org.broadleafcommerce.core.order.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FulfillmentGroupStatusType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentGroupStatusTypeDiffblueTest {
  @Autowired
  private FulfillmentGroupStatusType fulfillmentGroupStatusType;

  /**
   * Test {@link FulfillmentGroupStatusType#getInstance(String)}.
   * <p>
   * Method under test: {@link FulfillmentGroupStatusType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    FulfillmentGroupStatusType actualInstance = FulfillmentGroupStatusType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupStatusType#FulfillmentGroupStatusType()}
   *   <li>{@link FulfillmentGroupStatusType#getFriendlyType()}
   *   <li>{@link FulfillmentGroupStatusType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentGroupStatusType actualFulfillmentGroupStatusType = new FulfillmentGroupStatusType();
    String actualFriendlyType = actualFulfillmentGroupStatusType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFulfillmentGroupStatusType.getType());
  }

  /**
   * Test
   * {@link FulfillmentGroupStatusType#FulfillmentGroupStatusType(String, String)}.
   * <ul>
   *   <li>When {@code Delivered}.</li>
   *   <li>Then return Type is {@code Delivered}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupStatusType#FulfillmentGroupStatusType(String, String)}
   */
  @Test
  public void testNewFulfillmentGroupStatusType_whenDelivered_thenReturnTypeIsDelivered() {
    // Arrange and Act
    FulfillmentGroupStatusType actualFulfillmentGroupStatusType = new FulfillmentGroupStatusType("Delivered",
        "Friendly Type");

    // Assert
    assertEquals("Delivered", actualFulfillmentGroupStatusType.getType());
    assertEquals("Friendly Type", actualFulfillmentGroupStatusType.getFriendlyType());
  }

  /**
   * Test
   * {@link FulfillmentGroupStatusType#FulfillmentGroupStatusType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupStatusType#FulfillmentGroupStatusType(String, String)}
   */
  @Test
  public void testNewFulfillmentGroupStatusType_whenType_thenReturnType() {
    // Arrange and Act
    FulfillmentGroupStatusType actualFulfillmentGroupStatusType = new FulfillmentGroupStatusType("Type",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFulfillmentGroupStatusType.getFriendlyType());
    assertEquals("Type", actualFulfillmentGroupStatusType.getType());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}, and
   * {@link FulfillmentGroupStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupStatusType#equals(Object)}
   *   <li>{@link FulfillmentGroupStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupStatusType fulfillmentGroupStatusType = FulfillmentGroupStatusType.CANCELLED;
    FulfillmentGroupStatusType fulfillmentGroupStatusType2 = FulfillmentGroupStatusType.CANCELLED;

    // Act and Assert
    assertEquals(fulfillmentGroupStatusType, fulfillmentGroupStatusType2);
    int expectedHashCodeResult = fulfillmentGroupStatusType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupStatusType2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}, and
   * {@link FulfillmentGroupStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupStatusType#equals(Object)}
   *   <li>{@link FulfillmentGroupStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupStatusType fulfillmentGroupStatusType = new FulfillmentGroupStatusType();
    FulfillmentGroupStatusType fulfillmentGroupStatusType2 = new FulfillmentGroupStatusType();

    // Act and Assert
    assertEquals(fulfillmentGroupStatusType, fulfillmentGroupStatusType2);
    int expectedHashCodeResult = fulfillmentGroupStatusType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupStatusType2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}, and
   * {@link FulfillmentGroupStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupStatusType#equals(Object)}
   *   <li>{@link FulfillmentGroupStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupStatusType fulfillmentGroupStatusType = new FulfillmentGroupStatusType("CANCELLED",
        "Friendly Type");
    FulfillmentGroupStatusType fulfillmentGroupStatusType2 = FulfillmentGroupStatusType.CANCELLED;

    // Act and Assert
    assertEquals(fulfillmentGroupStatusType, fulfillmentGroupStatusType2);
    int expectedHashCodeResult = fulfillmentGroupStatusType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupStatusType2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}, and
   * {@link FulfillmentGroupStatusType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupStatusType#equals(Object)}
   *   <li>{@link FulfillmentGroupStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupStatusType fulfillmentGroupStatusType = FulfillmentGroupStatusType.CANCELLED;

    // Act and Assert
    assertEquals(fulfillmentGroupStatusType, fulfillmentGroupStatusType);
    int expectedHashCodeResult = fulfillmentGroupStatusType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupStatusType.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentGroupStatusType.DELIVERED, FulfillmentGroupStatusType.CANCELLED);
    assertNotEquals(new FulfillmentGroupStatusType(), FulfillmentGroupStatusType.CANCELLED);
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentGroupStatusType.CANCELLED, null);
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentGroupStatusType.CANCELLED, "Different type to FulfillmentGroupStatusType");
  }
}
