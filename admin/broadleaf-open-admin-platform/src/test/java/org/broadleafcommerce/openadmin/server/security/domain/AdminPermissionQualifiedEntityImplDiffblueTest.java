/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminPermissionQualifiedEntityImplDiffblueTest {
  /**
   * Test {@link AdminPermissionQualifiedEntityImpl#clone()}.
   * <p>
   * Method under test: {@link AdminPermissionQualifiedEntityImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminPermissionQualifiedEntity AdminPermissionQualifiedEntityImpl.clone()"})
  public void testClone() {
    // Arrange and Act
    AdminPermissionQualifiedEntity actualCloneResult = (new AdminPermissionQualifiedEntityImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionQualifiedEntityImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getCeilingEntityFullyQualifiedName());
    assertNull(actualCloneResult.getAdminPermission());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminPermissionQualifiedEntityImpl}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#setAdminPermission(AdminPermission)}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#setCeilingEntityFullyQualifiedName(String)}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#setId(Long)}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#getAdminPermission()}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#getCeilingEntityFullyQualifiedName()}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#getId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminPermissionQualifiedEntityImpl.<init>()",
      "AdminPermission AdminPermissionQualifiedEntityImpl.getAdminPermission()",
      "String AdminPermissionQualifiedEntityImpl.getCeilingEntityFullyQualifiedName()",
      "Long AdminPermissionQualifiedEntityImpl.getId()",
      "void AdminPermissionQualifiedEntityImpl.setAdminPermission(AdminPermission)",
      "void AdminPermissionQualifiedEntityImpl.setCeilingEntityFullyQualifiedName(String)",
      "void AdminPermissionQualifiedEntityImpl.setId(Long)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminPermissionQualifiedEntityImpl actualAdminPermissionQualifiedEntityImpl = new AdminPermissionQualifiedEntityImpl();
    AdminPermissionImpl adminPermission = new AdminPermissionImpl();
    actualAdminPermissionQualifiedEntityImpl.setAdminPermission(adminPermission);
    actualAdminPermissionQualifiedEntityImpl.setCeilingEntityFullyQualifiedName("Dr Jane Doe");
    actualAdminPermissionQualifiedEntityImpl.setId(1L);
    AdminPermission actualAdminPermission = actualAdminPermissionQualifiedEntityImpl.getAdminPermission();
    String actualCeilingEntityFullyQualifiedName = actualAdminPermissionQualifiedEntityImpl
        .getCeilingEntityFullyQualifiedName();

    // Assert
    assertEquals("Dr Jane Doe", actualCeilingEntityFullyQualifiedName);
    assertEquals(1L, actualAdminPermissionQualifiedEntityImpl.getId().longValue());
    assertSame(adminPermission, actualAdminPermission);
  }
}
