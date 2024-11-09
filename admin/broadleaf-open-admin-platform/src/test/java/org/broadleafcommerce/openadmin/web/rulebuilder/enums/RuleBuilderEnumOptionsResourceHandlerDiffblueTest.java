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
   * Test {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}.
   * <ul>
   *   <li>When {@code admin/components/ruleBuilder-options.js}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}
   */
  @Test
  public void testCanHandle_whenAdminComponentsRuleBuilderOptionsJs_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new RuleBuilderEnumOptionsResourceHandler()).canHandle("admin/components/ruleBuilder-options.js"));
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}
   */
  @Test
  public void testCanHandle_whenPath_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new RuleBuilderEnumOptionsResourceHandler()).canHandle("Path"));
  }

  /**
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired_givenGeneratedResource() {
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
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired_givenGeneratedResource2() {
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

  /**
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    // Act and Assert
    assertFalse(
        ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", new ArrayList<>()));
  }

  /**
   * Test
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}.
   * <ul>
   *   <li>When {@link GeneratedResource}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  public void testIsCachedResourceExpired_whenGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler = new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = mock(GeneratedResource.class);

    // Act and Assert
    assertFalse(
        ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(cachedResource, "Path", new ArrayList<>()));
  }
}
