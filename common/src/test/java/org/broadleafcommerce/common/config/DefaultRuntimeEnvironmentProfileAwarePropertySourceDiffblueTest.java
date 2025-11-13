package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultRuntimeEnvironmentProfileAwarePropertySourceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link
   *       DefaultRuntimeEnvironmentProfileAwarePropertySource}
   *   <li>{@link DefaultRuntimeEnvironmentProfileAwarePropertySource#getClasspathFolder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultRuntimeEnvironmentProfileAwarePropertySource.<init>()",
    "java.lang.String DefaultRuntimeEnvironmentProfileAwarePropertySource.getClasspathFolder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "runtime-properties",
        new DefaultRuntimeEnvironmentProfileAwarePropertySource().getClasspathFolder());
  }
}
