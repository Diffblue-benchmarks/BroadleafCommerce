package org.broadleafcommerce.cms.config;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CmsPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CmsProperties}
   *   <li>{@link CmsProperties#getClasspathFolder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("config/bc/cms/", (new CmsProperties()).getClasspathFolder());
  }
}
