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
package org.broadleafcommerce.openadmin.web.rulebuilder.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.springframework.core.io.Resource;

public class RuleBuilderEnumOptionsResourceHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}
   */
  @Test
  public void testCanHandle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new RuleBuilderEnumOptionsResourceHandler()).canHandle("Path"));
    assertTrue((new RuleBuilderEnumOptionsResourceHandler()).canHandle("admin/components/ruleBuilder-options.js"));
  }

  /**
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    // Act and Assert
    assertFalse(
        ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = mock(GeneratedResource.class);

    // Act and Assert
    assertFalse(
        ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertFalse(ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", locations));
  }

  /**
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertFalse(ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", locations));
  }
}
