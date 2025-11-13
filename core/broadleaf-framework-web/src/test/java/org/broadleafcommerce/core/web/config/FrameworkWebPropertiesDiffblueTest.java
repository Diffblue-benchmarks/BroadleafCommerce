package org.broadleafcommerce.core.web.config;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FrameworkWebPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FrameworkWebProperties}
   *   <li>{@link FrameworkWebProperties#getClasspathFolder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FrameworkWebProperties.<init>()",
    "java.lang.String FrameworkWebProperties.getClasspathFolder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("config/bc/web/", new FrameworkWebProperties().getClasspathFolder());
  }
}
