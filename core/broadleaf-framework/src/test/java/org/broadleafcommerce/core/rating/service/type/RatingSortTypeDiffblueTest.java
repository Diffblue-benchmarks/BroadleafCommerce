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
package org.broadleafcommerce.core.rating.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RatingSortType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RatingSortTypeDiffblueTest {
  @Autowired
  private RatingSortType ratingSortType;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RatingSortType ratingSortType = RatingSortType.DEFAULT;
    RatingSortType ratingSortType2 = RatingSortType.DEFAULT;

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType2);
    int expectedHashCodeResult = ratingSortType.hashCode();
    assertEquals(expectedHashCodeResult, ratingSortType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RatingSortType ratingSortType = RatingSortType.MOST_HELPFUL;
    RatingSortType ratingSortType2 = new RatingSortType("MOST_HELPFUL", "MOST_HELPFUL");

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType2);
    int expectedHashCodeResult = ratingSortType.hashCode();
    assertEquals(expectedHashCodeResult, ratingSortType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RatingSortType ratingSortType = new RatingSortType();
    RatingSortType ratingSortType2 = new RatingSortType();

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType2);
    int expectedHashCodeResult = ratingSortType.hashCode();
    assertEquals(expectedHashCodeResult, ratingSortType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RatingSortType ratingSortType = RatingSortType.DEFAULT;

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType);
    int expectedHashCodeResult = ratingSortType.hashCode();
    assertEquals(expectedHashCodeResult, ratingSortType.hashCode());
  }

  /**
   * Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.MOST_HELPFUL, RatingSortType.DEFAULT);
    assertNotEquals(new RatingSortType(), RatingSortType.DEFAULT);
  }

  /**
   * Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.DEFAULT, null);
  }

  /**
   * Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.DEFAULT, "Different type to RatingSortType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RatingSortType#RatingSortType()}
   *   <li>{@link RatingSortType#getFriendlyType()}
   *   <li>{@link RatingSortType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType();
    String actualFriendlyType = actualRatingSortType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualRatingSortType.getType());
  }

  /**
   * Method under test: {@link RatingSortType#RatingSortType(String)}
   */
  @Test
  public void testNewRatingSortType() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("Type");

    // Assert
    assertEquals("Type", actualRatingSortType.getFriendlyType());
    assertEquals("Type", actualRatingSortType.getType());
  }

  /**
   * Method under test: {@link RatingSortType#RatingSortType(String)}
   */
  @Test
  public void testNewRatingSortType2() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("TypeType");

    // Assert
    assertEquals("TypeType", actualRatingSortType.getFriendlyType());
    assertEquals("TypeType", actualRatingSortType.getType());
  }

  /**
   * Method under test: {@link RatingSortType#RatingSortType(String, String)}
   */
  @Test
  public void testNewRatingSortType3() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualRatingSortType.getFriendlyType());
    assertEquals("Type", actualRatingSortType.getType());
  }
}
