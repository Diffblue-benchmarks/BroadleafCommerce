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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicEntityController;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;

public class AdminRequestMappingHandlerMappingDiffblueTest {
  /**
   * Test {@link AdminRequestMappingHandlerMapping#isHandler(Class)}.
   * <p>
   * Method under test: {@link AdminRequestMappingHandlerMapping#isHandler(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminRequestMappingHandlerMapping.isHandler(Class)"})
  public void testIsHandler() {
    // Arrange
    AdminRequestMappingHandlerMapping adminRequestMappingHandlerMapping = new AdminRequestMappingHandlerMapping();
    Class<AdminBasicEntityController> beanType = AdminBasicEntityController.class;

    // Act and Assert
    assertFalse(adminRequestMappingHandlerMapping.isHandler(beanType));
  }

  /**
   * Test {@link AdminRequestMappingHandlerMapping#isHandler(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRequestMappingHandlerMapping#isHandler(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminRequestMappingHandlerMapping.isHandler(Class)"})
  public void testIsHandler_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    AdminRequestMappingHandlerMapping adminRequestMappingHandlerMapping = new AdminRequestMappingHandlerMapping();
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(adminRequestMappingHandlerMapping.isHandler(beanType));
  }

  /**
   * Test new {@link AdminRequestMappingHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AdminRequestMappingHandlerMapping}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminRequestMappingHandlerMapping.<init>()"})
  public void testNewAdminRequestMappingHandlerMapping() {
    // Arrange and Act
    AdminRequestMappingHandlerMapping actualAdminRequestMappingHandlerMapping = new AdminRequestMappingHandlerMapping();

    // Assert
    assertTrue(actualAdminRequestMappingHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualAdminRequestMappingHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertTrue(actualAdminRequestMappingHandlerMapping
        .getNamingStrategy() instanceof RequestMappingInfoHandlerMethodMappingNamingStrategy);
    assertNull(actualAdminRequestMappingHandlerMapping.getDefaultHandler());
    assertNull(actualAdminRequestMappingHandlerMapping.getFileExtensions());
    assertNull(actualAdminRequestMappingHandlerMapping.getCorsConfigurationSource());
    assertNull(actualAdminRequestMappingHandlerMapping.getPatternParser());
    assertFalse(actualAdminRequestMappingHandlerMapping.useRegisteredSuffixPatternMatch());
    assertFalse(actualAdminRequestMappingHandlerMapping.useSuffixPatternMatch());
    assertTrue(actualAdminRequestMappingHandlerMapping.getHandlerMethods().isEmpty());
    assertTrue(actualAdminRequestMappingHandlerMapping.getPathPrefixes().isEmpty());
    assertTrue(actualAdminRequestMappingHandlerMapping.useTrailingSlashMatch());
    assertEquals(Integer.MAX_VALUE, actualAdminRequestMappingHandlerMapping.getOrder());
  }
}
