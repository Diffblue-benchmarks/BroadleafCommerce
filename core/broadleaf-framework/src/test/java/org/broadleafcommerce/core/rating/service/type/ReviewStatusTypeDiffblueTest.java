package org.broadleafcommerce.core.rating.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReviewStatusTypeDiffblueTest {
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
   * <ul>
   *   <li>Then return FriendlyType is {@code null}.
   * </ul>
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
    "void ReviewStatusType.<init>(String)",
    "void ReviewStatusType.<init>(String, String)",
    "String ReviewStatusType.getFriendlyType()",
    "String ReviewStatusType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType();
    String actualFriendlyType = actualReviewStatusType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualReviewStatusType.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Friendly Type}.
   *   <li>Then return {@code Friendly Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReviewStatusType#ReviewStatusType(String, String)}
   *   <li>{@link ReviewStatusType#getFriendlyType()}
   *   <li>{@link ReviewStatusType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReviewStatusType.<init>()",
    "void ReviewStatusType.<init>(String)",
    "void ReviewStatusType.<init>(String, String)",
    "String ReviewStatusType.getFriendlyType()",
    "String ReviewStatusType.getType()"
  })
  public void testGettersAndSetters_whenFriendlyType_thenReturnFriendlyType() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType("Type", "Friendly Type");
    String actualFriendlyType = actualReviewStatusType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualReviewStatusType.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return FriendlyType is {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReviewStatusType#ReviewStatusType(String)}
   *   <li>{@link ReviewStatusType#getFriendlyType()}
   *   <li>{@link ReviewStatusType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReviewStatusType.<init>()",
    "void ReviewStatusType.<init>(String)",
    "void ReviewStatusType.<init>(String, String)",
    "String ReviewStatusType.getFriendlyType()",
    "String ReviewStatusType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyTypeIsType() {
    // Arrange and Act
    ReviewStatusType actualReviewStatusType = new ReviewStatusType("Type");
    String actualFriendlyType = actualReviewStatusType.getFriendlyType();

    // Assert
    assertEquals("Type", actualFriendlyType);
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
