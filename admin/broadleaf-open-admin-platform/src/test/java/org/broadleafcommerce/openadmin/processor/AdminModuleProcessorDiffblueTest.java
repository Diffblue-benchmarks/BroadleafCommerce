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

public class AdminModuleProcessorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminModuleProcessor#getName()}
   *   <li>{@link AdminModuleProcessor#getPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminModuleProcessor adminModuleProcessor = new AdminModuleProcessor();

    // Act
    String actualName = adminModuleProcessor.getName();

    // Assert
    assertEquals("admin_module", actualName);
    assertEquals("blc_admin", adminModuleProcessor.getPrefix());
  }

  /**
   * Test {@link AdminModuleProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link AdminModuleProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10001, (new AdminModuleProcessor()).getPrecedence());
  }

  /**
   * Test
   * {@link AdminModuleProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminModuleProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminModuleProcessor adminModuleProcessor = new AdminModuleProcessor();

    // Act and Assert
    assertTrue(
        adminModuleProcessor.populateModelVariables("Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class))
            .isEmpty());
  }

  /**
   * Test {@link AdminModuleProcessor#getPersistentAdminUser()}.
   * <p>
   * Method under test: {@link AdminModuleProcessor#getPersistentAdminUser()}
   */
  @Test
  public void testGetPersistentAdminUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminModuleProcessor()).getPersistentAdminUser());
  }
}
