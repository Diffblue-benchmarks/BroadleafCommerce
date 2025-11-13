package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MonthTypeDiffblueTest {
  /**
   * Test {@link MonthType#equals(Object)}, and {@link MonthType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MonthType#equals(Object)}
   *   <li>{@link MonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MonthType monthType = MonthType.APRIL;
    MonthType monthType2 = MonthType.APRIL;

    // Act and Assert
    assertEquals(monthType, monthType2);
    assertEquals(monthType.hashCode(), monthType2.hashCode());
  }

  /**
   * Test {@link MonthType#equals(Object)}, and {@link MonthType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MonthType#equals(Object)}
   *   <li>{@link MonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MonthType monthType = new MonthType();
    MonthType monthType2 = new MonthType();

    // Act and Assert
    assertEquals(monthType, monthType2);
    assertEquals(monthType.hashCode(), monthType2.hashCode());
  }

  /**
   * Test {@link MonthType#equals(Object)}, and {@link MonthType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MonthType#equals(Object)}
   *   <li>{@link MonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MonthType monthType = MonthType.APRIL;

    // Act and Assert
    assertEquals(monthType, monthType);
    int expectedHashCodeResult = monthType.hashCode();
    assertEquals(expectedHashCodeResult, monthType.hashCode());
  }

  /**
   * Test {@link MonthType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MonthType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MonthType.AUGUST, MonthType.APRIL);
  }

  /**
   * Test {@link MonthType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MonthType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new MonthType(), MonthType.APRIL);
  }

  /**
   * Test {@link MonthType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MonthType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MonthType.APRIL, null);
  }

  /**
   * Test {@link MonthType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MonthType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MonthType.APRIL, "Different type to MonthType");
  }
}
