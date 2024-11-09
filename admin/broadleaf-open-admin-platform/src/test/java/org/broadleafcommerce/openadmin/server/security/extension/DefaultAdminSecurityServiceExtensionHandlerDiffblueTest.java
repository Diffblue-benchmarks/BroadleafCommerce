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
package org.broadleafcommerce.openadmin.server.security.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;

public class DefaultAdminSecurityServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link DefaultAdminSecurityServiceExtensionHandler#hasPrivilegesForOperation(AdminUser, PermissionType, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link AdminUserImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminSecurityServiceExtensionHandler#hasPrivilegesForOperation(AdminUser, PermissionType, ExtensionResultHolder)}
   */
  @Test
  public void testHasPrivilegesForOperation_whenAdminUserImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminSecurityServiceExtensionHandler defaultAdminSecurityServiceExtensionHandler = new DefaultAdminSecurityServiceExtensionHandler();
    AdminUserImpl adminUser = new AdminUserImpl();

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultAdminSecurityServiceExtensionHandler.hasPrivilegesForOperation(adminUser, PermissionType.ALL, erh));
  }

  /**
   * Test
   * {@link DefaultAdminSecurityServiceExtensionHandler#hasPrivilegesForOperation(AdminUser, PermissionType, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link AdminUserImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminSecurityServiceExtensionHandler#hasPrivilegesForOperation(AdminUser, PermissionType, ExtensionResultHolder)}
   */
  @Test
  public void testHasPrivilegesForOperation_whenAdminUserImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminSecurityServiceExtensionHandler defaultAdminSecurityServiceExtensionHandler = new DefaultAdminSecurityServiceExtensionHandler();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultAdminSecurityServiceExtensionHandler.hasPrivilegesForOperation(adminUser, PermissionType.ALL, erh));
  }
}
