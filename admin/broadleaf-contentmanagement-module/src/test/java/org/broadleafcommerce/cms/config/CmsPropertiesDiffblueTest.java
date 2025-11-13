package org.broadleafcommerce.cms.config;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CmsPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CmsProperties}
   *   <li>{@link CmsProperties#getClasspathFolder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CmsProperties.<init>()",
    "java.lang.String CmsProperties.getClasspathFolder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("config/bc/cms/", new CmsProperties().getClasspathFolder());
  }
}
