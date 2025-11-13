package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DayOfMonthTypeDiffblueTest {
  /**
   * Test {@link DayOfMonthType#equals(Object)}, and {@link DayOfMonthType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DayOfMonthType#equals(Object)}
   *   <li>{@link DayOfMonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DayOfMonthType dayOfMonthType = DayOfMonthType.EIGHT;
    DayOfMonthType dayOfMonthType2 = DayOfMonthType.EIGHT;

    // Act and Assert
    assertEquals(dayOfMonthType, dayOfMonthType2);
    assertEquals(dayOfMonthType.hashCode(), dayOfMonthType2.hashCode());
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}, and {@link DayOfMonthType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DayOfMonthType#equals(Object)}
   *   <li>{@link DayOfMonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DayOfMonthType dayOfMonthType = new DayOfMonthType();
    DayOfMonthType dayOfMonthType2 = new DayOfMonthType();

    // Act and Assert
    assertEquals(dayOfMonthType, dayOfMonthType2);
    assertEquals(dayOfMonthType.hashCode(), dayOfMonthType2.hashCode());
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}, and {@link DayOfMonthType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DayOfMonthType#equals(Object)}
   *   <li>{@link DayOfMonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DayOfMonthType dayOfMonthType = DayOfMonthType.EIGHT;

    // Act and Assert
    assertEquals(dayOfMonthType, dayOfMonthType);
    int expectedHashCodeResult = dayOfMonthType.hashCode();
    assertEquals(expectedHashCodeResult, dayOfMonthType.hashCode());
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfMonthType.EIGHTEEN, DayOfMonthType.EIGHT);
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DayOfMonthType(), DayOfMonthType.EIGHT);
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfMonthType.EIGHT, null);
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfMonthType.EIGHT, "Different type to DayOfMonthType");
  }
}
