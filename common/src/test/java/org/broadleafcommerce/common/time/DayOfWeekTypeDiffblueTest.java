package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DayOfWeekTypeDiffblueTest {
  /**
   * Test {@link DayOfWeekType#equals(Object)}, and {@link DayOfWeekType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DayOfWeekType#equals(Object)}
   *   <li>{@link DayOfWeekType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfWeekType.equals(Object)", "int DayOfWeekType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DayOfWeekType dayOfWeekType = DayOfWeekType.FRIDAY;
    DayOfWeekType dayOfWeekType2 = DayOfWeekType.FRIDAY;

    // Act and Assert
    assertEquals(dayOfWeekType, dayOfWeekType2);
    assertEquals(dayOfWeekType.hashCode(), dayOfWeekType2.hashCode());
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}, and {@link DayOfWeekType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DayOfWeekType#equals(Object)}
   *   <li>{@link DayOfWeekType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfWeekType.equals(Object)", "int DayOfWeekType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DayOfWeekType dayOfWeekType = new DayOfWeekType();
    DayOfWeekType dayOfWeekType2 = new DayOfWeekType();

    // Act and Assert
    assertEquals(dayOfWeekType, dayOfWeekType2);
    assertEquals(dayOfWeekType.hashCode(), dayOfWeekType2.hashCode());
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}, and {@link DayOfWeekType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DayOfWeekType#equals(Object)}
   *   <li>{@link DayOfWeekType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfWeekType.equals(Object)", "int DayOfWeekType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DayOfWeekType dayOfWeekType = DayOfWeekType.FRIDAY;

    // Act and Assert
    assertEquals(dayOfWeekType, dayOfWeekType);
    int expectedHashCodeResult = dayOfWeekType.hashCode();
    assertEquals(expectedHashCodeResult, dayOfWeekType.hashCode());
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DayOfWeekType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfWeekType.equals(Object)", "int DayOfWeekType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfWeekType.MONDAY, DayOfWeekType.FRIDAY);
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DayOfWeekType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfWeekType.equals(Object)", "int DayOfWeekType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DayOfWeekType(), DayOfWeekType.FRIDAY);
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DayOfWeekType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfWeekType.equals(Object)", "int DayOfWeekType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfWeekType.FRIDAY, null);
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DayOfWeekType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DayOfWeekType.equals(Object)", "int DayOfWeekType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfWeekType.FRIDAY, "Different type to DayOfWeekType");
  }
}
