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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicEntityController;
import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringValueResolver;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;

public class AdminRequestMappingHandlerMappingDiffblueTest {
  /**
   * Test {@link AdminRequestMappingHandlerMapping#isHandler(Class)}.
   * <p>
   * Method under test: {@link AdminRequestMappingHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler() {
    // Arrange
    AdminRequestMappingHandlerMapping adminRequestMappingHandlerMapping = new AdminRequestMappingHandlerMapping();
    Class<AdminBasicEntityController> beanType = AdminBasicEntityController.class;

    // Act and Assert
    assertFalse(adminRequestMappingHandlerMapping.isHandler(beanType));
  }

  /**
   * Test {@link AdminRequestMappingHandlerMapping#isHandler(Class)}.
   * <p>
   * Method under test: {@link AdminRequestMappingHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler2() {
    // Arrange
    AdminRequestMappingHandlerMapping adminRequestMappingHandlerMapping = new AdminRequestMappingHandlerMapping();
    adminRequestMappingHandlerMapping.setEmbeddedValueResolver(mock(StringValueResolver.class));
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(adminRequestMappingHandlerMapping.isHandler(beanType));
  }

  /**
   * Test {@link AdminRequestMappingHandlerMapping#isHandler(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRequestMappingHandlerMapping#isHandler(Class)}
   */
  @Test
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
   * Method under test: default or parameterless constructor of
   * {@link AdminRequestMappingHandlerMapping}
   */
  @Test
  public void testNewAdminRequestMappingHandlerMapping() {
    // Arrange and Act
    AdminRequestMappingHandlerMapping actualAdminRequestMappingHandlerMapping = new AdminRequestMappingHandlerMapping();

    // Assert
    assertTrue(actualAdminRequestMappingHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    ContentNegotiationManager contentNegotiationManager = actualAdminRequestMappingHandlerMapping
        .getContentNegotiationManager();
    List<ContentNegotiationStrategy> strategies = contentNegotiationManager.getStrategies();
    assertEquals(1, strategies.size());
    assertTrue(strategies.get(0) instanceof HeaderContentNegotiationStrategy);
    assertTrue(actualAdminRequestMappingHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertTrue(actualAdminRequestMappingHandlerMapping
        .getNamingStrategy() instanceof RequestMappingInfoHandlerMethodMappingNamingStrategy);
    assertNull(actualAdminRequestMappingHandlerMapping.getDefaultHandler());
    RequestMappingInfo.BuilderConfiguration builderConfiguration = actualAdminRequestMappingHandlerMapping
        .getBuilderConfiguration();
    assertNull(builderConfiguration.getFileExtensions());
    assertNull(actualAdminRequestMappingHandlerMapping.getFileExtensions());
    assertNull(builderConfiguration.getPathMatcher());
    assertNull(builderConfiguration.getContentNegotiationManager());
    assertNull(actualAdminRequestMappingHandlerMapping.getCorsConfigurationSource());
    assertNull(actualAdminRequestMappingHandlerMapping.getPatternParser());
    assertNull(builderConfiguration.getPatternParser());
    assertFalse(actualAdminRequestMappingHandlerMapping.useRegisteredSuffixPatternMatch());
    assertFalse(actualAdminRequestMappingHandlerMapping.useSuffixPatternMatch());
    assertTrue(contentNegotiationManager.getAllFileExtensions().isEmpty());
    assertTrue(actualAdminRequestMappingHandlerMapping.getHandlerMethods().isEmpty());
    Map<String, Predicate<Class<?>>> pathPrefixes = actualAdminRequestMappingHandlerMapping.getPathPrefixes();
    assertTrue(pathPrefixes.isEmpty());
    assertTrue(actualAdminRequestMappingHandlerMapping.useTrailingSlashMatch());
    assertTrue(actualAdminRequestMappingHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertTrue(builderConfiguration.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualAdminRequestMappingHandlerMapping.getOrder());
    assertSame(pathPrefixes, contentNegotiationManager.getMediaTypeMappings());
  }
}
