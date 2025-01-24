package org.broadleafcommerce.admin.config;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdminModuleRegistrationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminModuleRegistration}
   *   <li>{@link AdminModuleRegistration#getModuleName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(AdminModuleRegistration.MODULE_NAME, (new AdminModuleRegistration()).getModuleName());
  }
}
