package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MinuteTypeDiffblueTest {
  /**
   * Test {@link MinuteType#equals(Object)}, and {@link MinuteType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MinuteType#equals(Object)}
   *   <li>{@link MinuteType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinuteType.equals(Object)", "int MinuteType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MinuteType minuteType = MinuteType.EIGHT;
    MinuteType minuteType2 = MinuteType.EIGHT;

    // Act and Assert
    assertEquals(minuteType, minuteType2);
    assertEquals(minuteType.hashCode(), minuteType2.hashCode());
  }

  /**
   * Test {@link MinuteType#equals(Object)}, and {@link MinuteType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MinuteType#equals(Object)}
   *   <li>{@link MinuteType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinuteType.equals(Object)", "int MinuteType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MinuteType minuteType = new MinuteType();
    MinuteType minuteType2 = new MinuteType();

    // Act and Assert
    assertEquals(minuteType, minuteType2);
    assertEquals(minuteType.hashCode(), minuteType2.hashCode());
  }

  /**
   * Test {@link MinuteType#equals(Object)}, and {@link MinuteType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MinuteType#equals(Object)}
   *   <li>{@link MinuteType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinuteType.equals(Object)", "int MinuteType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MinuteType minuteType = MinuteType.EIGHT;

    // Act and Assert
    assertEquals(minuteType, minuteType);
    int expectedHashCodeResult = minuteType.hashCode();
    assertEquals(expectedHashCodeResult, minuteType.hashCode());
  }

  /**
   * Test {@link MinuteType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MinuteType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinuteType.equals(Object)", "int MinuteType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MinuteType.EIGHTEEN, MinuteType.EIGHT);
  }

  /**
   * Test {@link MinuteType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MinuteType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinuteType.equals(Object)", "int MinuteType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new MinuteType(), MinuteType.EIGHT);
  }

  /**
   * Test {@link MinuteType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MinuteType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinuteType.equals(Object)", "int MinuteType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MinuteType.EIGHT, null);
  }

  /**
   * Test {@link MinuteType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MinuteType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinuteType.equals(Object)", "int MinuteType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MinuteType.EIGHT, "Different type to MinuteType");
  }
}
