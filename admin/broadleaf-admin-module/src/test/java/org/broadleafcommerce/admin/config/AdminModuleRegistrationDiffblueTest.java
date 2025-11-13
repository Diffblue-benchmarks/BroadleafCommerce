package org.broadleafcommerce.admin.config;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminModuleRegistrationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminModuleRegistration}
   *   <li>{@link AdminModuleRegistration#getModuleName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminModuleRegistration.<init>()",
    "java.lang.String AdminModuleRegistration.getModuleName()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        AdminModuleRegistration.MODULE_NAME, new AdminModuleRegistration().getModuleName());
  }
}
