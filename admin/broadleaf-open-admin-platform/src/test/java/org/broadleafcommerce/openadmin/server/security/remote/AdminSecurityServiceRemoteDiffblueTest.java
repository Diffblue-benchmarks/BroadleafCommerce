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
package org.broadleafcommerce.openadmin.server.security.remote;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.junit.Test;

public class AdminSecurityServiceRemoteDiffblueTest {
  /**
   * Method under test: {@link AdminSecurityServiceRemote#getAdminUser()}
   */
  @Test
  public void testGetAdminUser() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminSecurityServiceRemote()).getAdminUser());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceRemote#getPersistentAdminUser()}
   */
  @Test
  public void testGetPersistentAdminUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminSecurityServiceRemote()).getPersistentAdminUser());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  public void testSecurityCheck() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(SecurityServiceException.class,
        () -> (new AdminSecurityServiceRemote()).securityCheck((String[]) null, EntityOperationType.FETCH));
  }
}
