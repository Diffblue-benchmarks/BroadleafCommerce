package org.broadleafcommerce.common.security.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PasswordUtilsDiffblueTest {
  /**
   * Test {@link PasswordUtils#generateSecurePassword(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PasswordUtils#generateSecurePassword(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PasswordUtils.generateSecurePassword(int)"})
  public void testGenerateSecurePassword_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", PasswordUtils.generateSecurePassword(0));
  }
}
