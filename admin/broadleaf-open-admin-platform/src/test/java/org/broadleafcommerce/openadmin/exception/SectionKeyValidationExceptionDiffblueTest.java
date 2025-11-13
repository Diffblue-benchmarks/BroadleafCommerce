package org.broadleafcommerce.openadmin.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SectionKeyValidationExceptionDiffblueTest {
  /**
   * Test {@link SectionKeyValidationException#SectionKeyValidationException(String)}.
   *
   * <p>Method under test: {@link
   * SectionKeyValidationException#SectionKeyValidationException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SectionKeyValidationException.<init>(String)"})
  public void testNewSectionKeyValidationException() {
    // Arrange and Act
    SectionKeyValidationException actualSectionKeyValidationException =
        new SectionKeyValidationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSectionKeyValidationException.getMessage());
    assertNull(actualSectionKeyValidationException.getCause());
    assertEquals(0, actualSectionKeyValidationException.getSuppressed().length);
  }
}
