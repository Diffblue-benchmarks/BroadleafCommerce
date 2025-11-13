package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DirectCopyIgnorePatternDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DirectCopyIgnorePattern}
   *   <li>{@link DirectCopyIgnorePattern#setPatterns(String[])}
   *   <li>{@link DirectCopyIgnorePattern#setTemplateTokenPatterns(String[])}
   *   <li>{@link DirectCopyIgnorePattern#getPatterns()}
   *   <li>{@link DirectCopyIgnorePattern#getTemplateTokenPatterns()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DirectCopyIgnorePattern.<init>()",
    "String[] DirectCopyIgnorePattern.getPatterns()",
    "String[] DirectCopyIgnorePattern.getTemplateTokenPatterns()",
    "void DirectCopyIgnorePattern.setPatterns(String[])",
    "void DirectCopyIgnorePattern.setTemplateTokenPatterns(String[])"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DirectCopyIgnorePattern actualDirectCopyIgnorePattern = new DirectCopyIgnorePattern();
    String[] patterns = new String[] {"Patterns"};
    actualDirectCopyIgnorePattern.setPatterns(patterns);
    String[] templateTokenPatterns = new String[] {"ABC123"};
    actualDirectCopyIgnorePattern.setTemplateTokenPatterns(templateTokenPatterns);
    String[] actualPatterns = actualDirectCopyIgnorePattern.getPatterns();
    String[] actualTemplateTokenPatterns = actualDirectCopyIgnorePattern.getTemplateTokenPatterns();

    // Assert
    assertSame(templateTokenPatterns, actualTemplateTokenPatterns);
    assertSame(patterns, actualPatterns);
    assertArrayEquals(new String[] {"ABC123"}, actualTemplateTokenPatterns);
    assertArrayEquals(new String[] {"Patterns"}, actualPatterns);
  }
}
