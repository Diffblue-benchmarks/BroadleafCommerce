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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ReviewStatusType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReviewStatusTypeDiffblueTest {
  @Autowired private ReviewStatusType reviewStatusType;

  /**
   * Test {@link ReviewStatusType#getInstance(String)}.
   *
   * <p>Method under test: {@link ReviewStatusType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReviewStatusType ReviewStatusType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    ReviewStatusType actualInstance = ReviewStatusType.getInstance("Type");

    // Assert
    assertEquals("Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReviewStatusType#ReviewStatusType()}
   *   <li>{@link ReviewStatusType#getFriendlyType()}
   *   <li>{@link ReviewStatusType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReviewStatusType.<init>()",
    "String ReviewStatusType.getFriendlyType()",
    "String ReviewStatusType.getType()"
  })
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
   *
   * <p>Method under test: {@link ReviewStatusType#ReviewStatusType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReviewStatusType.<init>(String, String)"})
  public void testNewReviewStatusType() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualReviewStatusType.getFriendlyType());
    assertEquals("Type", actualReviewStatusType.getType());
  }

  /**
   * Test {@link ReviewStatusType#ReviewStatusType(String)}.
   *
   * <ul>
   *   <li>When {@code 42Type}.
   *   <li>Then return FriendlyType is {@code 42Type}.
   * </ul>
   *
   * <p>Method under test: {@link ReviewStatusType#ReviewStatusType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReviewStatusType.<init>(String)"})
  public void testNewReviewStatusType_when42Type_thenReturnFriendlyTypeIs42Type() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType("42Type");

    // Assert
    assertEquals("42Type", actualReviewStatusType.getFriendlyType());
    assertEquals("42Type", actualReviewStatusType.getType());
  }

  /**
   * Test {@link ReviewStatusType#ReviewStatusType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return FriendlyType is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ReviewStatusType#ReviewStatusType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReviewStatusType.<init>(String)"})
  public void testNewReviewStatusType_whenType_thenReturnFriendlyTypeIsType() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType("Type");

    // Assert
    assertEquals("Type", actualReviewStatusType.getFriendlyType());
    assertEquals("Type", actualReviewStatusType.getType());
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}, and {@link ReviewStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReviewStatusType#equals(Object)}
   *   <li>{@link ReviewStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReviewStatusType.equals(Object)", "int ReviewStatusType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReviewStatusType reviewStatusType = ReviewStatusType.APPROVED;
    ReviewStatusType reviewStatusType2 = ReviewStatusType.APPROVED;

    // Act and Assert
    assertEquals(reviewStatusType, reviewStatusType2);
    assertEquals(reviewStatusType.hashCode(), reviewStatusType2.hashCode());
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}, and {@link ReviewStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReviewStatusType#equals(Object)}
   *   <li>{@link ReviewStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReviewStatusType.equals(Object)", "int ReviewStatusType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ReviewStatusType reviewStatusType = ReviewStatusType.PENDING;
    ReviewStatusType reviewStatusType2 = new ReviewStatusType("PENDING");

    // Act and Assert
    assertEquals(reviewStatusType, reviewStatusType2);
    assertEquals(reviewStatusType.hashCode(), reviewStatusType2.hashCode());
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}, and {@link ReviewStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReviewStatusType#equals(Object)}
   *   <li>{@link ReviewStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReviewStatusType.equals(Object)", "int ReviewStatusType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ReviewStatusType reviewStatusType = new ReviewStatusType();
    ReviewStatusType reviewStatusType2 = new ReviewStatusType();

    // Act and Assert
    assertEquals(reviewStatusType, reviewStatusType2);
    assertEquals(reviewStatusType.hashCode(), reviewStatusType2.hashCode());
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}, and {@link ReviewStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReviewStatusType#equals(Object)}
   *   <li>{@link ReviewStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReviewStatusType.equals(Object)", "int ReviewStatusType.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReviewStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReviewStatusType.equals(Object)", "int ReviewStatusType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ReviewStatusType.PENDING, ReviewStatusType.APPROVED);
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReviewStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReviewStatusType.equals(Object)", "int ReviewStatusType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ReviewStatusType(), ReviewStatusType.APPROVED);
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReviewStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReviewStatusType.equals(Object)", "int ReviewStatusType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ReviewStatusType.APPROVED, null);
  }

  /**
   * Test {@link ReviewStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReviewStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReviewStatusType.equals(Object)", "int ReviewStatusType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ReviewStatusType.APPROVED, "Different type to ReviewStatusType");
  }
}
