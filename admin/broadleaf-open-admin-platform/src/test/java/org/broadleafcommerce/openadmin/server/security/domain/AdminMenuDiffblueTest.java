package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminMenuDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminMenu}
   *   <li>{@link AdminMenu#setAdminModule(List)}
   *   <li>{@link AdminMenu#getAdminModules()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminMenu.<init>()",
    "List AdminMenu.getAdminModules()",
    "void AdminMenu.setAdminModule(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminMenu actualAdminMenu = new AdminMenu();
    ArrayList<AdminModule> adminModules = new ArrayList<>();
    actualAdminMenu.setAdminModule(adminModules);
    List<AdminModule> actualAdminModules = actualAdminMenu.getAdminModules();

    // Assert
    assertTrue(actualAdminModules.isEmpty());
    assertSame(adminModules, actualAdminModules);
  }
}
