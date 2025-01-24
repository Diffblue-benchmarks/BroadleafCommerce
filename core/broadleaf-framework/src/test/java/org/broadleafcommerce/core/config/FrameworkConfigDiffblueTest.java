package org.broadleafcommerce.core.config;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrameworkConfigDiffblueTest {
  /**
   * Test FrameworkPropertySource getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FrameworkConfig.FrameworkPropertySource}
   *   <li>{@link FrameworkConfig.FrameworkPropertySource#getClasspathFolder()}
   * </ul>
   */
  @Test
  public void testFrameworkPropertySourceGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("config/bc/fw/", (new FrameworkConfig.FrameworkPropertySource()).getClasspathFolder());
  }
}
