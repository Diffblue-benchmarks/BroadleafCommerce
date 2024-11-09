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

@ContextConfiguration(classes = {ReviewStatusType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReviewStatusTypeDiffblueTest {
  @Autowired
  private ReviewStatusType reviewStatusType;

  /**
   * Test {@link ReviewStatusType#getInstance(String)}.
   * <p>
   * Method under test: {@link ReviewStatusType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    ReviewStatusType actualInstance = ReviewStatusType.getInstance("Type");

    // Assert
    assertEquals("Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReviewStatusType#ReviewStatusType()}
   *   <li>{@link ReviewStatusType#getFriendlyType()}
   *   <li>{@link ReviewStatusType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType();
    String actualFriendlyType = actualReviewStatusType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualReviewStatusType.getType());
  }

  /**
   * Test {@link ReviewStatusType#ReviewStatusType(String, String)}.
   * <p>
   * Method under test: {@link ReviewStatusType#ReviewStatusType(String, String)}
   */
  @Test
  public void testNewReviewStatusType() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualReviewStatusType.getFriendlyType());
    assertEquals("Type", actualReviewStatusType.getType());
  }

  /**
   * Test {@link ReviewStatusType#ReviewStatusType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then return FriendlyType is {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewStatusType#ReviewStatusType(String)}
   */
  @Test
  public void testNewReviewStatusType_whenTypeType_thenReturnFriendlyTypeIsTypeType() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType("TypeType");

    // Assert
    assertEquals("TypeType", actualReviewStatusType.getFriendlyType());
    assertEquals("TypeType", actualReviewStatusType.getType());
  }

  /**
   * Test {@link ReviewStatusType#ReviewStatusType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return FriendlyType is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewStatusType#ReviewStatusType(String)}
   */
  @Test
  public void testNewReviewStatusType_whenType_thenReturnFriendlyTypeIsType() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType("Type");

    // Assert
    assertEquals("Type", actualReviewStatusType.getFriendlyType());
    assertEquals("Type", actualReviewStatusType.getType());
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}, and
   * {@link ReviewStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReviewStatusType#equals(Object)}
   *   <li>{@link ReviewStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReviewStatusType reviewStatusType = ReviewStatusType.APPROVED;
    ReviewStatusType reviewStatusType2 = ReviewStatusType.APPROVED;

    // Act and Assert
    assertEquals(reviewStatusType, reviewStatusType2);
    int expectedHashCodeResult = reviewStatusType.hashCode();
    assertEquals(expectedHashCodeResult, reviewStatusType2.hashCode());
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}, and
   * {@link ReviewStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReviewStatusType#equals(Object)}
   *   <li>{@link ReviewStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ReviewStatusType reviewStatusType = ReviewStatusType.PENDING;
    ReviewStatusType reviewStatusType2 = new ReviewStatusType("PENDING", "PENDING");

    // Act and Assert
    assertEquals(reviewStatusType, reviewStatusType2);
    int expectedHashCodeResult = reviewStatusType.hashCode();
    assertEquals(expectedHashCodeResult, reviewStatusType2.hashCode());
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}, and
   * {@link ReviewStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReviewStatusType#equals(Object)}
   *   <li>{@link ReviewStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ReviewStatusType reviewStatusType = new ReviewStatusType();
    ReviewStatusType reviewStatusType2 = new ReviewStatusType();

    // Act and Assert
    assertEquals(reviewStatusType, reviewStatusType2);
    int expectedHashCodeResult = reviewStatusType.hashCode();
    assertEquals(expectedHashCodeResult, reviewStatusType2.hashCode());
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}, and
   * {@link ReviewStatusType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReviewStatusType#equals(Object)}
   *   <li>{@link ReviewStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReviewStatusType reviewStatusType = ReviewStatusType.APPROVED;

    // Act and Assert
    assertEquals(reviewStatusType, reviewStatusType);
    int expectedHashCodeResult = reviewStatusType.hashCode();
    assertEquals(expectedHashCodeResult, reviewStatusType.hashCode());
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ReviewStatusType.PENDING, ReviewStatusType.APPROVED);
    assertNotEquals(new ReviewStatusType(), ReviewStatusType.APPROVED);
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ReviewStatusType.APPROVED, null);
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ReviewStatusType.APPROVED, "Different type to ReviewStatusType");
  }
}
