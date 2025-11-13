package org.broadleafcommerce.openadmin.server.service.sandbox;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SandBoxNameValidatorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SandBoxNameValidator#setSucceedForNullValues(boolean)}
   *   <li>{@link SandBoxNameValidator#isSucceedForNullValues()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SandBoxNameValidator.isSucceedForNullValues()",
    "void SandBoxNameValidator.setSucceedForNullValues(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SandBoxNameValidator sandBoxNameValidator = new SandBoxNameValidator();

    // Act
    sandBoxNameValidator.setSucceedForNullValues(true);

    // Assert
    assertTrue(sandBoxNameValidator.isSucceedForNullValues());
  }
}
