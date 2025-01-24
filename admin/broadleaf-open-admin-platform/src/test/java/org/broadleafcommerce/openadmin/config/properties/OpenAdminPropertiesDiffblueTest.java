package org.broadleafcommerce.openadmin.config.properties;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OpenAdminPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OpenAdminProperties}
   *   <li>{@link OpenAdminProperties#getClasspathFolder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("config/bc/admin/", (new OpenAdminProperties()).getClasspathFolder());
  }
}
