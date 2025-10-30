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
package org.broadleafcommerce.openadmin.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminUserProcessorDiffblueTest {
  @InjectMocks
  private AdminUserProcessor adminUserProcessor;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminUserProcessor.getName()", "String AdminUserProcessor.getPrefix()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AdminUserProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, adminUserProcessor.getPrecedence());
  }

  /**
   * Test {@link AdminUserProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AdminUserProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminUserProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  public void testPopulateModelVariables() {
    // Arrange, Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.security.domain.AdminUser AdminUserProcessor.getPersistentAdminUser()"})
  public void testGetPersistentAdminUser() {
    // Arrange, Act and Assert
    assertNull(adminUserProcessor.getPersistentAdminUser());
  }
}
