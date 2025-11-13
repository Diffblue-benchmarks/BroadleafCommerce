package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Mod43CheckDigitUtilDiffblueTest {
  /**
   * Test {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mod43CheckDigitUtil.isValidCheckedValue(String)"})
  public void testIsValidCheckedValue_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Mod43CheckDigitUtil.isValidCheckedValue("42"));
  }

  /**
   * Test {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mod43CheckDigitUtil.isValidCheckedValue(String)"})
  public void testIsValidCheckedValue_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Mod43CheckDigitUtil.isValidCheckedValue(""));
  }

  /**
   * Test {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mod43CheckDigitUtil.isValidCheckedValue(String)"})
  public void testIsValidCheckedValue_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Mod43CheckDigitUtil.isValidCheckedValue(null));
  }

  /**
   * Test {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}.
   *
   * <ul>
   *   <li>When space space.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mod43CheckDigitUtil.isValidCheckedValue(String)"})
  public void testIsValidCheckedValue_whenSpaceSpace_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Mod43CheckDigitUtil.isValidCheckedValue("  "));
  }

  /**
   * Test {@link Mod43CheckDigitUtil#generateCheckDigit(String)}.
   *
   * <p>Method under test: {@link Mod43CheckDigitUtil#generateCheckDigit(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"char Mod43CheckDigitUtil.generateCheckDigit(String)"})
  public void testGenerateCheckDigit() {
    // Arrange, Act and Assert
    assertEquals('A', Mod43CheckDigitUtil.generateCheckDigit("Data"));
  }
}
