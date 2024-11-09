/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.admin.web.rulebuilder.service.extension.CookieFieldServiceExtensionHandler;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldServiceExtensionManager;
import org.junit.Test;

public class AdminWebConfigDiffblueTest {
  /**
   * Test
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}.
   * <p>
   * Method under test:
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  public void testBlCookieFieldServiceExtensionHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult = adminWebConfig
        .blCookieFieldServiceExtensionHandler(new ArrayList<>(), mock(RuleBuilderFieldServiceExtensionManager.class));

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }

  /**
   * Test
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  public void testBlCookieFieldServiceExtensionHandler_given42_whenArrayListAdd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();

    ArrayList<Object> configs = new ArrayList<>();
    configs.add("42");

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult = adminWebConfig
        .blCookieFieldServiceExtensionHandler(configs, new RuleBuilderFieldServiceExtensionManager());

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }

  /**
   * Test
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  public void testBlCookieFieldServiceExtensionHandler_given42_whenArrayListAdd422() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();

    ArrayList<Object> configs = new ArrayList<>();
    configs.add("42");
    configs.add("42");

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult = adminWebConfig
        .blCookieFieldServiceExtensionHandler(configs, new RuleBuilderFieldServiceExtensionManager());

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }

  /**
   * Test
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  public void testBlCookieFieldServiceExtensionHandler_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();
    ArrayList<Object> configs = new ArrayList<>();

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult = adminWebConfig
        .blCookieFieldServiceExtensionHandler(configs, new RuleBuilderFieldServiceExtensionManager());

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }
}
