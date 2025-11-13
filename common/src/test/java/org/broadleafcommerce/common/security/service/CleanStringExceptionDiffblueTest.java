package org.broadleafcommerce.common.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.owasp.validator.html.CleanResults;

public class CleanStringExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CleanStringException#CleanStringException(CleanResults)}
   *   <li>{@link CleanStringException#setCleanResults(CleanResults)}
   *   <li>{@link CleanStringException#getCleanResults()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CleanStringException.<init>(CleanResults)",
    "CleanResults CleanStringException.getCleanResults()",
    "void CleanStringException.setCleanResults(CleanResults)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CleanStringException actualCleanStringException = new CleanStringException(new CleanResults());
    CleanResults cleanResults = new CleanResults();
    actualCleanStringException.setCleanResults(cleanResults);
    CleanResults actualCleanResults = actualCleanStringException.getCleanResults();

    // Assert
    assertNull(actualCleanStringException.getMessage());
    assertNull(actualCleanStringException.getCause());
    assertEquals(0, actualCleanStringException.getSuppressed().length);
    assertSame(cleanResults, actualCleanResults);
  }
}
