/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.core.web.resolver;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DatabaseResourceResolverExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseResourceResolverExtensionManagerDiffblueTest {
  @Autowired
  private DatabaseResourceResolverExtensionManager databaseResourceResolverExtensionManager;

  /**
   * Test {@link DatabaseResourceResolverExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link DatabaseResourceResolverExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseResourceResolverExtensionManager databaseResourceResolverExtensionManager = new DatabaseResourceResolverExtensionManager();
    databaseResourceResolverExtensionManager.registerHandler(mock(DatabaseResourceResolverExtensionHandler.class));

    // Act and Assert
    assertFalse(databaseResourceResolverExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link DatabaseResourceResolverExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link DatabaseResourceResolverExtensionManager#continueOnHandled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testContinueOnHandled2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.broadleafcommerce.core.web.resolver.DatabaseResourceResolverExtensionManager
    //   when running class:
    //   package org.broadleafcommerce.core.web.resolver;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.resolver.DatabaseResourceResolverExtensionManager.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass39 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.resolver.DatabaseResourceResolverExtensionManager databaseResourceResolverExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    databaseResourceResolverExtensionManager.continueOnHandled();
  }

  /**
   * Test {@link DatabaseResourceResolverExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link DatabaseResourceResolverExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseResourceResolverExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenDatabaseResourceResolverExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DatabaseResourceResolverExtensionManager()).continueOnHandled());
  }
}
