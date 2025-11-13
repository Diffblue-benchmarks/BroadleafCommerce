package org.broadleafcommerce.openadmin.config.properties;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OpenAdminPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OpenAdminProperties}
   *   <li>{@link OpenAdminProperties#getClasspathFolder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OpenAdminProperties.<init>()",
    "java.lang.String OpenAdminProperties.getClasspathFolder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("config/bc/admin/", new OpenAdminProperties().getClasspathFolder());
  }
}
