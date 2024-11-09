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
package org.broadleafcommerce.openadmin.web.controller.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.broadleafcommerce.openadmin.web.controller.AdminRequestMappingHandlerMapping;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class AdminWebMvcConfigurationSupportDiffblueTest {
  /**
   * Test
   * {@link AdminWebMvcConfigurationSupport#createRequestMappingHandlerMapping()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfigurationSupport#createRequestMappingHandlerMapping()}
   */
  @Test
  public void testCreateRequestMappingHandlerMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminWebMvcConfigurationSupport adminWebMvcConfigurationSupport = new AdminWebMvcConfigurationSupport();
    adminWebMvcConfigurationSupport.setApplicationContext(mock(AnnotationConfigApplicationContext.class));

    // Act
    RequestMappingHandlerMapping actualCreateRequestMappingHandlerMappingResult = adminWebMvcConfigurationSupport
        .createRequestMappingHandlerMapping();

    // Assert
    assertTrue(actualCreateRequestMappingHandlerMappingResult instanceof AdminRequestMappingHandlerMapping);
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getPathMatcher() instanceof AntPathMatcher);
    ContentNegotiationManager contentNegotiationManager = actualCreateRequestMappingHandlerMappingResult
        .getContentNegotiationManager();
    List<ContentNegotiationStrategy> strategies = contentNegotiationManager.getStrategies();
    assertEquals(1, strategies.size());
    assertTrue(strategies.get(0) instanceof HeaderContentNegotiationStrategy);
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertTrue(actualCreateRequestMappingHandlerMappingResult
        .getNamingStrategy() instanceof RequestMappingInfoHandlerMethodMappingNamingStrategy);
    assertNull(actualCreateRequestMappingHandlerMappingResult.getDefaultHandler());
    RequestMappingInfo.BuilderConfiguration builderConfiguration = actualCreateRequestMappingHandlerMappingResult
        .getBuilderConfiguration();
    assertNull(builderConfiguration.getFileExtensions());
    assertNull(actualCreateRequestMappingHandlerMappingResult.getFileExtensions());
    assertNull(builderConfiguration.getPathMatcher());
    assertNull(builderConfiguration.getContentNegotiationManager());
    assertNull(actualCreateRequestMappingHandlerMappingResult.getCorsConfigurationSource());
    assertNull(actualCreateRequestMappingHandlerMappingResult.getPatternParser());
    assertNull(builderConfiguration.getPatternParser());
    assertFalse(actualCreateRequestMappingHandlerMappingResult.useRegisteredSuffixPatternMatch());
    assertFalse(actualCreateRequestMappingHandlerMappingResult.useSuffixPatternMatch());
    assertTrue(contentNegotiationManager.getAllFileExtensions().isEmpty());
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getHandlerMethods().isEmpty());
    Map<String, Predicate<Class<?>>> pathPrefixes = actualCreateRequestMappingHandlerMappingResult.getPathPrefixes();
    assertTrue(pathPrefixes.isEmpty());
    assertTrue(actualCreateRequestMappingHandlerMappingResult.useTrailingSlashMatch());
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getUrlPathHelper().isUrlDecode());
    assertTrue(builderConfiguration.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualCreateRequestMappingHandlerMappingResult.getOrder());
    assertSame(pathPrefixes, contentNegotiationManager.getMediaTypeMappings());
  }

  /**
   * Test
   * {@link AdminWebMvcConfigurationSupport#createRequestMappingHandlerMapping()}.
   * <ul>
   *   <li>Given {@link AdminWebMvcConfigurationSupport} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfigurationSupport#createRequestMappingHandlerMapping()}
   */
  @Test
  public void testCreateRequestMappingHandlerMapping_givenAdminWebMvcConfigurationSupport() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    RequestMappingHandlerMapping actualCreateRequestMappingHandlerMappingResult = (new AdminWebMvcConfigurationSupport())
        .createRequestMappingHandlerMapping();

    // Assert
    assertTrue(actualCreateRequestMappingHandlerMappingResult instanceof AdminRequestMappingHandlerMapping);
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getPathMatcher() instanceof AntPathMatcher);
    ContentNegotiationManager contentNegotiationManager = actualCreateRequestMappingHandlerMappingResult
        .getContentNegotiationManager();
    List<ContentNegotiationStrategy> strategies = contentNegotiationManager.getStrategies();
    assertEquals(1, strategies.size());
    assertTrue(strategies.get(0) instanceof HeaderContentNegotiationStrategy);
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertTrue(actualCreateRequestMappingHandlerMappingResult
        .getNamingStrategy() instanceof RequestMappingInfoHandlerMethodMappingNamingStrategy);
    assertNull(actualCreateRequestMappingHandlerMappingResult.getDefaultHandler());
    RequestMappingInfo.BuilderConfiguration builderConfiguration = actualCreateRequestMappingHandlerMappingResult
        .getBuilderConfiguration();
    assertNull(builderConfiguration.getFileExtensions());
    assertNull(actualCreateRequestMappingHandlerMappingResult.getFileExtensions());
    assertNull(builderConfiguration.getPathMatcher());
    assertNull(builderConfiguration.getContentNegotiationManager());
    assertNull(actualCreateRequestMappingHandlerMappingResult.getCorsConfigurationSource());
    assertNull(actualCreateRequestMappingHandlerMappingResult.getPatternParser());
    assertNull(builderConfiguration.getPatternParser());
    assertFalse(actualCreateRequestMappingHandlerMappingResult.useRegisteredSuffixPatternMatch());
    assertFalse(actualCreateRequestMappingHandlerMappingResult.useSuffixPatternMatch());
    assertTrue(contentNegotiationManager.getAllFileExtensions().isEmpty());
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getHandlerMethods().isEmpty());
    Map<String, Predicate<Class<?>>> pathPrefixes = actualCreateRequestMappingHandlerMappingResult.getPathPrefixes();
    assertTrue(pathPrefixes.isEmpty());
    assertTrue(actualCreateRequestMappingHandlerMappingResult.useTrailingSlashMatch());
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getUrlPathHelper().isUrlDecode());
    assertTrue(builderConfiguration.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualCreateRequestMappingHandlerMappingResult.getOrder());
    assertSame(pathPrefixes, contentNegotiationManager.getMediaTypeMappings());
  }

  /**
   * Test new {@link AdminWebMvcConfigurationSupport} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminWebMvcConfigurationSupport}
   */
  @Test
  public void testNewAdminWebMvcConfigurationSupport() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AdminWebMvcConfigurationSupport actualAdminWebMvcConfigurationSupport = new AdminWebMvcConfigurationSupport();

    // Assert
    assertNull(actualAdminWebMvcConfigurationSupport.getServletContext());
    assertNull(actualAdminWebMvcConfigurationSupport.getApplicationContext());
  }
}
