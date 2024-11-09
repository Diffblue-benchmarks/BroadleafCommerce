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
   * Test getters and setters.
   * <p>
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
   * Test {@link RatingSortType#RatingSortType(String, String)}.
   * <p>
   * Method under test: {@link RatingSortType#RatingSortType(String, String)}
   */
  @Test
  public void testNewRatingSortType() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualRatingSortType.getFriendlyType());
    assertEquals("Type", actualRatingSortType.getType());
  }

  /**
   * Test {@link RatingSortType#RatingSortType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then return FriendlyType is {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSortType#RatingSortType(String)}
   */
  @Test
  public void testNewRatingSortType_whenTypeType_thenReturnFriendlyTypeIsTypeType() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("TypeType");

    // Assert
    assertEquals("TypeType", actualRatingSortType.getFriendlyType());
    assertEquals("TypeType", actualRatingSortType.getType());
  }

  /**
   * Test {@link RatingSortType#RatingSortType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return FriendlyType is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSortType#RatingSortType(String)}
   */
  @Test
  public void testNewRatingSortType_whenType_thenReturnFriendlyTypeIsType() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("Type");

    // Assert
    assertEquals("Type", actualRatingSortType.getFriendlyType());
    assertEquals("Type", actualRatingSortType.getType());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}, and
   * {@link RatingSortType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link RatingSortType#equals(Object)}, and
   * {@link RatingSortType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link RatingSortType#equals(Object)}, and
   * {@link RatingSortType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link RatingSortType#equals(Object)}, and
   * {@link RatingSortType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link RatingSortType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.MOST_HELPFUL, RatingSortType.DEFAULT);
    assertNotEquals(new RatingSortType(), RatingSortType.DEFAULT);
  }

  /**
   * Test {@link RatingSortType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.DEFAULT, null);
  }

  /**
   * Test {@link RatingSortType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.DEFAULT, "Different type to RatingSortType");
  }
}
