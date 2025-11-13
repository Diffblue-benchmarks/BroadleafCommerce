package org.broadleafcommerce.core.config;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.config.FrameworkConfig.FrameworkPropertySource;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FrameworkConfigDiffblueTest {
  /**
   * Test FrameworkPropertySource getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FrameworkPropertySource}
   *   <li>{@link FrameworkPropertySource#getClasspathFolder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FrameworkPropertySource.<init>()",
    "java.lang.String FrameworkPropertySource.getClasspathFolder()"
  })
  public void testFrameworkPropertySourceGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("config/bc/fw/", new FrameworkPropertySource().getClasspathFolder());
  }
}
