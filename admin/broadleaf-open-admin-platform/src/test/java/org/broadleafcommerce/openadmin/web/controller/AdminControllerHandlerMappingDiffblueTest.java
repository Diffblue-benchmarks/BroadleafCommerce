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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicEntityController;
import org.junit.Test;
import org.springframework.util.StringValueResolver;

public class AdminControllerHandlerMappingDiffblueTest {
  /**
   * Method under test: {@link AdminControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminControllerHandlerMapping adminControllerHandlerMapping = new AdminControllerHandlerMapping();
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(adminControllerHandlerMapping.isHandler(beanType));
  }

  /**
   * Method under test: {@link AdminControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminControllerHandlerMapping adminControllerHandlerMapping = new AdminControllerHandlerMapping();
    Class<AdminBasicEntityController> beanType = AdminBasicEntityController.class;

    // Act and Assert
    assertTrue(adminControllerHandlerMapping.isHandler(beanType));
  }

  /**
   * Method under test: {@link AdminControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminControllerHandlerMapping adminControllerHandlerMapping = new AdminControllerHandlerMapping();
    adminControllerHandlerMapping.setEmbeddedValueResolver(mock(StringValueResolver.class));
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(adminControllerHandlerMapping.isHandler(beanType));
  }
}
