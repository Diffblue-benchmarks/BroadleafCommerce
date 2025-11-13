package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HourOfDayTypeDiffblueTest {
  /**
   * Test {@link HourOfDayType#equals(Object)}, and {@link HourOfDayType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HourOfDayType#equals(Object)}
   *   <li>{@link HourOfDayType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HourOfDayType.equals(Object)", "int HourOfDayType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HourOfDayType hourOfDayType = HourOfDayType.EIGHT;
    HourOfDayType hourOfDayType2 = HourOfDayType.EIGHT;

    // Act and Assert
    assertEquals(hourOfDayType, hourOfDayType2);
    assertEquals(hourOfDayType.hashCode(), hourOfDayType2.hashCode());
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}, and {@link HourOfDayType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HourOfDayType#equals(Object)}
   *   <li>{@link HourOfDayType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HourOfDayType.equals(Object)", "int HourOfDayType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HourOfDayType hourOfDayType = new HourOfDayType();
    HourOfDayType hourOfDayType2 = new HourOfDayType();

    // Act and Assert
    assertEquals(hourOfDayType, hourOfDayType2);
    assertEquals(hourOfDayType.hashCode(), hourOfDayType2.hashCode());
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}, and {@link HourOfDayType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HourOfDayType#equals(Object)}
   *   <li>{@link HourOfDayType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HourOfDayType.equals(Object)", "int HourOfDayType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HourOfDayType hourOfDayType = HourOfDayType.EIGHT;

    // Act and Assert
    assertEquals(hourOfDayType, hourOfDayType);
    int expectedHashCodeResult = hourOfDayType.hashCode();
    assertEquals(expectedHashCodeResult, hourOfDayType.hashCode());
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HourOfDayType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HourOfDayType.equals(Object)", "int HourOfDayType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(HourOfDayType.EIGHTEEN, HourOfDayType.EIGHT);
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HourOfDayType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HourOfDayType.equals(Object)", "int HourOfDayType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new HourOfDayType(), HourOfDayType.EIGHT);
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HourOfDayType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HourOfDayType.equals(Object)", "int HourOfDayType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(HourOfDayType.EIGHT, null);
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HourOfDayType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HourOfDayType.equals(Object)", "int HourOfDayType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(HourOfDayType.EIGHT, "Different type to HourOfDayType");
  }
}
