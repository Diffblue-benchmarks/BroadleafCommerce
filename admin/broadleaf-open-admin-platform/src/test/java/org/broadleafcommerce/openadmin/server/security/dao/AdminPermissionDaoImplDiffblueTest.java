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
package org.broadleafcommerce.openadmin.server.security.dao;

import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;

public class AdminPermissionDaoImplDiffblueTest {
  /**
   * Test
   * {@link AdminPermissionDaoImpl#isUserQualifiedForOperationOnCeilingEntity(AdminUser, PermissionType, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionDaoImpl#isUserQualifiedForOperationOnCeilingEntity(AdminUser, PermissionType, String)}
   */
  @Test
  public void testIsUserQualifiedForOperationOnCeilingEntity_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionDaoImpl adminPermissionDaoImpl = new AdminPermissionDaoImpl();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminPermissionDaoImpl
        .isUserQualifiedForOperationOnCeilingEntity(new AdminUserImpl(), PermissionType.ALL, "Dr Jane Doe"));
  }

  /**
   * Test
   * {@link AdminPermissionDaoImpl#isUserQualifiedForOperationOnCeilingEntityViaDefaultPermissions(String)}.
   * <p>
   * Method under test:
   * {@link AdminPermissionDaoImpl#isUserQualifiedForOperationOnCeilingEntityViaDefaultPermissions(String)}
   */
  @Test
  public void testIsUserQualifiedForOperationOnCeilingEntityViaDefaultPermissions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new AdminPermissionDaoImpl())
        .isUserQualifiedForOperationOnCeilingEntityViaDefaultPermissions("Dr Jane Doe"));
  }

  /**
   * Test
   * {@link AdminPermissionDaoImpl#doesOperationExistForCeilingEntity(PermissionType, String)}.
   * <ul>
   *   <li>When {@link PermissionType#ALL}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionDaoImpl#doesOperationExistForCeilingEntity(PermissionType, String)}
   */
  @Test
  public void testDoesOperationExistForCeilingEntity_whenAll_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new AdminPermissionDaoImpl()).doesOperationExistForCeilingEntity(PermissionType.ALL, "Dr Jane Doe"));
  }
}
