/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
