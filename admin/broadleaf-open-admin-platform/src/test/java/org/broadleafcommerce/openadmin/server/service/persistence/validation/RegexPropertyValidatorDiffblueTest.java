package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RegexPropertyValidatorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegexPropertyValidator#setSucceedForInvalidRegex(boolean)}
   *   <li>{@link RegexPropertyValidator#setSucceedForNullValues(boolean)}
   *   <li>{@link RegexPropertyValidator#isSucceedForInvalidRegex()}
   *   <li>{@link RegexPropertyValidator#isSucceedForNullValues()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RegexPropertyValidator.isSucceedForInvalidRegex()",
    "boolean RegexPropertyValidator.isSucceedForNullValues()",
    "void RegexPropertyValidator.setSucceedForInvalidRegex(boolean)",
    "void RegexPropertyValidator.setSucceedForNullValues(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    RegexPropertyValidator regexPropertyValidator = new RegexPropertyValidator();

    // Act
    regexPropertyValidator.setSucceedForInvalidRegex(true);
    regexPropertyValidator.setSucceedForNullValues(true);
    boolean actualIsSucceedForInvalidRegexResult =
        regexPropertyValidator.isSucceedForInvalidRegex();

    // Assert
    assertTrue(actualIsSucceedForInvalidRegexResult);
    assertTrue(regexPropertyValidator.isSucceedForNullValues());
  }
}
