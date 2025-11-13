package org.broadleafcommerce.common.sandbox.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SandBoxTypeDiffblueTest {
  /**
   * Test {@link SandBoxType#equals(Object)}, and {@link SandBoxType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SandBoxType#equals(Object)}
   *   <li>{@link SandBoxType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxType.equals(Object)", "int SandBoxType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SandBoxType sandBoxType = SandBoxType.APPROVAL;
    SandBoxType sandBoxType2 = SandBoxType.APPROVAL;

    // Act and Assert
    assertEquals(sandBoxType, sandBoxType2);
    assertEquals(sandBoxType.hashCode(), sandBoxType2.hashCode());
  }

  /**
   * Test {@link SandBoxType#equals(Object)}, and {@link SandBoxType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SandBoxType#equals(Object)}
   *   <li>{@link SandBoxType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxType.equals(Object)", "int SandBoxType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SandBoxType sandBoxType = new SandBoxType();
    SandBoxType sandBoxType2 = new SandBoxType();

    // Act and Assert
    assertEquals(sandBoxType, sandBoxType2);
    assertEquals(sandBoxType.hashCode(), sandBoxType2.hashCode());
  }

  /**
   * Test {@link SandBoxType#equals(Object)}, and {@link SandBoxType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SandBoxType#equals(Object)}
   *   <li>{@link SandBoxType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxType.equals(Object)", "int SandBoxType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SandBoxType sandBoxType = SandBoxType.APPROVAL;

    // Act and Assert
    assertEquals(sandBoxType, sandBoxType);
    int expectedHashCodeResult = sandBoxType.hashCode();
    assertEquals(expectedHashCodeResult, sandBoxType.hashCode());
  }

  /**
   * Test {@link SandBoxType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxType.equals(Object)", "int SandBoxType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SandBoxType.DEFAULT, SandBoxType.APPROVAL);
  }

  /**
   * Test {@link SandBoxType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxType.equals(Object)", "int SandBoxType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SandBoxType(), SandBoxType.APPROVAL);
  }

  /**
   * Test {@link SandBoxType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxType.equals(Object)", "int SandBoxType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SandBoxType.APPROVAL, null);
  }

  /**
   * Test {@link SandBoxType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxType.equals(Object)", "int SandBoxType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SandBoxType.APPROVAL, "Different type to SandBoxType");
  }
}
