package org.broadleafcommerce.openadmin.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SectionKeyValidationExceptionDiffblueTest {
  /**
   * Test
   * {@link SectionKeyValidationException#SectionKeyValidationException(String)}.
   * <p>
   * Method under test:
   * {@link SectionKeyValidationException#SectionKeyValidationException(String)}
   */
  @Test
  public void testNewSectionKeyValidationException() {
    // Arrange and Act
    SectionKeyValidationException actualSectionKeyValidationException = new SectionKeyValidationException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualSectionKeyValidationException.getMessage());
    assertNull(actualSectionKeyValidationException.getCause());
    assertEquals(0, actualSectionKeyValidationException.getSuppressed().length);
  }
}
