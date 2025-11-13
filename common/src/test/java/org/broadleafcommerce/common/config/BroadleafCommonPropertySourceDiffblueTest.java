package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafCommonPropertySourceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafCommonPropertySource}
   *   <li>{@link BroadleafCommonPropertySource#getClasspathFolder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCommonPropertySource.<init>()",
    "java.lang.String BroadleafCommonPropertySource.getClasspathFolder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("config/bc/", new BroadleafCommonPropertySource().getClasspathFolder());
  }
}
