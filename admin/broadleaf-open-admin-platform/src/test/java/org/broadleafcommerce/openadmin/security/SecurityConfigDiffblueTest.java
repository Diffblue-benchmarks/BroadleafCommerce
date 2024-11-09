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
package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.server.security.remote.EntityOperationType;
import org.junit.Test;

public class SecurityConfigDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SecurityConfig}
   *   <li>{@link SecurityConfig#setCeilingEntityFullyQualifiedName(String)}
   *   <li>{@link SecurityConfig#setPermissions(List)}
   *   <li>{@link SecurityConfig#setRequiredTypes(List)}
   *   <li>{@link SecurityConfig#setRoles(List)}
   *   <li>{@link SecurityConfig#getCeilingEntityFullyQualifiedName()}
   *   <li>{@link SecurityConfig#getPermissions()}
   *   <li>{@link SecurityConfig#getRequiredTypes()}
   *   <li>{@link SecurityConfig#getRoles()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SecurityConfig actualSecurityConfig = new SecurityConfig();
    actualSecurityConfig.setCeilingEntityFullyQualifiedName("Dr Jane Doe");
    ArrayList<String> permissions = new ArrayList<>();
    actualSecurityConfig.setPermissions(permissions);
    ArrayList<EntityOperationType> requiredTypes = new ArrayList<>();
    actualSecurityConfig.setRequiredTypes(requiredTypes);
    ArrayList<String> roles = new ArrayList<>();
    actualSecurityConfig.setRoles(roles);
    String actualCeilingEntityFullyQualifiedName = actualSecurityConfig.getCeilingEntityFullyQualifiedName();
    List<String> actualPermissions = actualSecurityConfig.getPermissions();
    List<EntityOperationType> actualRequiredTypes = actualSecurityConfig.getRequiredTypes();
    List<String> actualRoles = actualSecurityConfig.getRoles();

    // Assert that nothing has changed
    assertEquals("Dr Jane Doe", actualCeilingEntityFullyQualifiedName);
    assertTrue(actualPermissions.isEmpty());
    assertTrue(actualRequiredTypes.isEmpty());
    assertTrue(actualRoles.isEmpty());
    assertSame(permissions, actualPermissions);
    assertSame(requiredTypes, actualRequiredTypes);
    assertSame(roles, actualRoles);
  }
}
