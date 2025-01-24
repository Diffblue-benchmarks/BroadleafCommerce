package org.broadleafcommerce.openadmin.server.security.remote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AdminUserDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminUser}
   *   <li>{@link AdminUser#setCurrentSandBoxId(String)}
   *   <li>{@link AdminUser#setEmail(String)}
   *   <li>{@link AdminUser#setId(Long)}
   *   <li>{@link AdminUser#setName(String)}
   *   <li>{@link AdminUser#setPermissions(List)}
   *   <li>{@link AdminUser#setPhoneNumber(String)}
   *   <li>{@link AdminUser#setRoles(List)}
   *   <li>{@link AdminUser#setUserName(String)}
   *   <li>{@link AdminUser#getCurrentSandBoxId()}
   *   <li>{@link AdminUser#getEmail()}
   *   <li>{@link AdminUser#getId()}
   *   <li>{@link AdminUser#getName()}
   *   <li>{@link AdminUser#getPermissions()}
   *   <li>{@link AdminUser#getPhoneNumber()}
   *   <li>{@link AdminUser#getRoles()}
   *   <li>{@link AdminUser#getUserName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminUser actualAdminUser = new AdminUser();
    actualAdminUser.setCurrentSandBoxId("42");
    actualAdminUser.setEmail("jane.doe@example.org");
    actualAdminUser.setId(1L);
    actualAdminUser.setName("Name");
    ArrayList<String> permissions = new ArrayList<>();
    actualAdminUser.setPermissions(permissions);
    actualAdminUser.setPhoneNumber("6625550144");
    ArrayList<String> roles = new ArrayList<>();
    actualAdminUser.setRoles(roles);
    actualAdminUser.setUserName("janedoe");
    String actualCurrentSandBoxId = actualAdminUser.getCurrentSandBoxId();
    String actualEmail = actualAdminUser.getEmail();
    Long actualId = actualAdminUser.getId();
    String actualName = actualAdminUser.getName();
    List<String> actualPermissions = actualAdminUser.getPermissions();
    String actualPhoneNumber = actualAdminUser.getPhoneNumber();
    List<String> actualRoles = actualAdminUser.getRoles();

    // Assert that nothing has changed
    assertEquals("42", actualCurrentSandBoxId);
    assertEquals("6625550144", actualPhoneNumber);
    assertEquals("Name", actualName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("janedoe", actualAdminUser.getUserName());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualPermissions.isEmpty());
    assertTrue(actualRoles.isEmpty());
    assertSame(permissions, actualPermissions);
    assertSame(roles, actualRoles);
  }
}
