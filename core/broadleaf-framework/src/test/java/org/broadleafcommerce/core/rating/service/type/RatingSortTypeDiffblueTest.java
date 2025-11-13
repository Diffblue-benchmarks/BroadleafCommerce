package org.broadleafcommerce.core.rating.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RatingSortTypeDiffblueTest {
  /**
   * Test {@link RatingSortType#getInstance(String)}.
   *
   * <p>Method under test: {@link RatingSortType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSortType RatingSortType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    RatingSortType actualInstance = RatingSortType.getInstance("Type");

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
   *   <li>{@link RatingSortType#RatingSortType()}
   *   <li>{@link RatingSortType#getFriendlyType()}
   *   <li>{@link RatingSortType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RatingSortType.<init>()",
    "void RatingSortType.<init>(String)",
    "void RatingSortType.<init>(String, String)",
    "String RatingSortType.getFriendlyType()",
    "String RatingSortType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType();
    String actualFriendlyType = actualRatingSortType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualRatingSortType.getType());
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
   *   <li>{@link RatingSortType#RatingSortType(String, String)}
   *   <li>{@link RatingSortType#getFriendlyType()}
   *   <li>{@link RatingSortType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RatingSortType.<init>()",
    "void RatingSortType.<init>(String)",
    "void RatingSortType.<init>(String, String)",
    "String RatingSortType.getFriendlyType()",
    "String RatingSortType.getType()"
  })
  public void testGettersAndSetters_whenFriendlyType_thenReturnFriendlyType() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("Type", "Friendly Type");
    String actualFriendlyType = actualRatingSortType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualRatingSortType.getType());
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
   *   <li>{@link RatingSortType#RatingSortType(String)}
   *   <li>{@link RatingSortType#getFriendlyType()}
   *   <li>{@link RatingSortType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RatingSortType.<init>()",
    "void RatingSortType.<init>(String)",
    "void RatingSortType.<init>(String, String)",
    "String RatingSortType.getFriendlyType()",
    "String RatingSortType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyTypeIsType() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("Type");
    String actualFriendlyType = actualRatingSortType.getFriendlyType();

    // Assert
    assertEquals("Type", actualFriendlyType);
    assertEquals("Type", actualRatingSortType.getType());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}, and {@link RatingSortType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RatingSortType ratingSortType = RatingSortType.DEFAULT;
    RatingSortType ratingSortType2 = RatingSortType.DEFAULT;

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType2);
    assertEquals(ratingSortType.hashCode(), ratingSortType2.hashCode());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}, and {@link RatingSortType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RatingSortType ratingSortType = RatingSortType.MOST_HELPFUL;
    RatingSortType ratingSortType2 = new RatingSortType("MOST_HELPFUL");

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType2);
    assertEquals(ratingSortType.hashCode(), ratingSortType2.hashCode());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}, and {@link RatingSortType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RatingSortType ratingSortType = new RatingSortType();
    RatingSortType ratingSortType2 = new RatingSortType();

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType2);
    assertEquals(ratingSortType.hashCode(), ratingSortType2.hashCode());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}, and {@link RatingSortType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.MOST_HELPFUL, RatingSortType.DEFAULT);
  }

  /**
   * Test {@link RatingSortType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RatingSortType(), RatingSortType.DEFAULT);
  }

  /**
   * Test {@link RatingSortType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.DEFAULT, null);
  }

  /**
   * Test {@link RatingSortType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.DEFAULT, "Different type to RatingSortType");
  }
}
