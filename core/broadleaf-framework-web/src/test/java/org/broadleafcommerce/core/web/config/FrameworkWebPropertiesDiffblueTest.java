package org.broadleafcommerce.core.web.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FrameworkWebPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FrameworkWebProperties}
   *   <li>{@link FrameworkWebProperties#getClasspathFolder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("config/bc/web/", (new FrameworkWebProperties()).getClasspathFolder());
  }
}
