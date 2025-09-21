/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.admin.web.rulebuilder.service.extension.CookieFieldServiceExtensionHandler;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldServiceExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminWebConfigDiffblueTest {
  /**
   * Test {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List,
   * RuleBuilderFieldServiceExtensionManager)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List,
   * RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CookieFieldServiceExtensionHandler AdminWebConfig.blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)"
  })
  public void testBlCookieFieldServiceExtensionHandler_given42_whenArrayListAdd42() {
    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();

    ArrayList<Object> configs = new ArrayList<>();
    configs.add("42");

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult =
        adminWebConfig.blCookieFieldServiceExtensionHandler(
            configs, new RuleBuilderFieldServiceExtensionManager());

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }

  /**
   * Test {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List,
   * RuleBuilderFieldServiceExtensionManager)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List,
   * RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CookieFieldServiceExtensionHandler AdminWebConfig.blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)"
  })
  public void testBlCookieFieldServiceExtensionHandler_given42_whenArrayListAdd422() {
    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();

    ArrayList<Object> configs = new ArrayList<>();
    configs.add("42");
    configs.add("42");

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult =
        adminWebConfig.blCookieFieldServiceExtensionHandler(
            configs, new RuleBuilderFieldServiceExtensionManager());

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }

  /**
   * Test {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List,
   * RuleBuilderFieldServiceExtensionManager)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List,
   * RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CookieFieldServiceExtensionHandler AdminWebConfig.blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)"
  })
  public void testBlCookieFieldServiceExtensionHandler_whenArrayList() {
    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();
    ArrayList<Object> configs = new ArrayList<>();

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult =
        adminWebConfig.blCookieFieldServiceExtensionHandler(
            configs, new RuleBuilderFieldServiceExtensionManager());

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }
}
