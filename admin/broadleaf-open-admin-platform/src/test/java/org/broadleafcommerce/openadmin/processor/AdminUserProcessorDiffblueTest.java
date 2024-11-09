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
package org.broadleafcommerce.openadmin.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;

public class AdminUserProcessorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserProcessor#getName()}
   *   <li>{@link AdminUserProcessor#getPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminUserProcessor adminUserProcessor = new AdminUserProcessor();

    // Act
    String actualName = adminUserProcessor.getName();

    // Assert
    assertEquals("admin_user", actualName);
    assertEquals("blc_admin", adminUserProcessor.getPrefix());
  }

  /**
   * Test {@link AdminUserProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link AdminUserProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new AdminUserProcessor()).getPrecedence());
  }

  /**
   * Test
   * {@link AdminUserProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminUserProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProcessor adminUserProcessor = new AdminUserProcessor();

    // Act and Assert
    assertTrue(
        adminUserProcessor.populateModelVariables("Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class))
            .isEmpty());
  }

  /**
   * Test {@link AdminUserProcessor#getPersistentAdminUser()}.
   * <p>
   * Method under test: {@link AdminUserProcessor#getPersistentAdminUser()}
   */
  @Test
  public void testGetPersistentAdminUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminUserProcessor()).getPersistentAdminUser());
  }
}
