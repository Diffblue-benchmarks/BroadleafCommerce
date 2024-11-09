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

@ContextConfiguration(classes = {FulfillmentType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentTypeDiffblueTest {
  @Autowired
  private FulfillmentType fulfillmentType;

  /**
   * Test {@link FulfillmentType#getInstance(String)}.
   * <p>
   * Method under test: {@link FulfillmentType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    FulfillmentType actualInstance = FulfillmentType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentType#FulfillmentType()}
   *   <li>{@link FulfillmentType#getFriendlyType()}
   *   <li>{@link FulfillmentType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentType actualFulfillmentType = new FulfillmentType();
    String actualFriendlyType = actualFulfillmentType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFulfillmentType.getType());
  }

  /**
   * Test {@link FulfillmentType#FulfillmentType(String, String)}.
   * <p>
   * Method under test: {@link FulfillmentType#FulfillmentType(String, String)}
   */
  @Test
  public void testNewFulfillmentType() {
    // Arrange and Act
    FulfillmentType actualFulfillmentType = new FulfillmentType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFulfillmentType.getFriendlyType());
    assertEquals("Type", actualFulfillmentType.getType());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}, and
   * {@link FulfillmentType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentType#equals(Object)}
   *   <li>{@link FulfillmentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentType fulfillmentType = FulfillmentType.DIGITAL;
    FulfillmentType fulfillmentType2 = FulfillmentType.DIGITAL;

    // Act and Assert
    assertEquals(fulfillmentType, fulfillmentType2);
    int expectedHashCodeResult = fulfillmentType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentType2.hashCode());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}, and
   * {@link FulfillmentType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentType#equals(Object)}
   *   <li>{@link FulfillmentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentType fulfillmentType = new FulfillmentType();
    FulfillmentType fulfillmentType2 = new FulfillmentType();

    // Act and Assert
    assertEquals(fulfillmentType, fulfillmentType2);
    int expectedHashCodeResult = fulfillmentType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentType2.hashCode());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}, and
   * {@link FulfillmentType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentType#equals(Object)}
   *   <li>{@link FulfillmentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentType fulfillmentType = new FulfillmentType("DIGITAL", "Friendly Type");
    FulfillmentType fulfillmentType2 = FulfillmentType.DIGITAL;

    // Act and Assert
    assertEquals(fulfillmentType, fulfillmentType2);
    int expectedHashCodeResult = fulfillmentType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentType2.hashCode());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}, and
   * {@link FulfillmentType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentType#equals(Object)}
   *   <li>{@link FulfillmentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentType fulfillmentType = FulfillmentType.DIGITAL;

    // Act and Assert
    assertEquals(fulfillmentType, fulfillmentType);
    int expectedHashCodeResult = fulfillmentType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentType.hashCode());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentType.GIFT_CARD, FulfillmentType.DIGITAL);
    assertNotEquals(new FulfillmentType(), FulfillmentType.DIGITAL);
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentType.DIGITAL, null);
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentType.DIGITAL, "Different type to FulfillmentType");
  }
}
