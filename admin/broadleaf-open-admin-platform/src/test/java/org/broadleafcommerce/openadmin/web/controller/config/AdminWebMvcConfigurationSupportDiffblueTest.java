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
package org.broadleafcommerce.openadmin.web.controller.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.controller.AdminRequestMappingHandlerMapping;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RunWith(MockitoJUnitRunner.class)
public class AdminWebMvcConfigurationSupportDiffblueTest {
  @InjectMocks
  private AdminWebMvcConfigurationSupport adminWebMvcConfigurationSupport;

  /**
   * Test {@link AdminWebMvcConfigurationSupport#createRequestMappingHandlerMapping()}.
   * <p>
   * Method under test: {@link AdminWebMvcConfigurationSupport#createRequestMappingHandlerMapping()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "RequestMappingHandlerMapping AdminWebMvcConfigurationSupport.createRequestMappingHandlerMapping()"})
  public void testCreateRequestMappingHandlerMapping() {
    // Arrange and Act
    RequestMappingHandlerMapping actualCreateRequestMappingHandlerMappingResult = adminWebMvcConfigurationSupport
        .createRequestMappingHandlerMapping();

    // Assert
    assertTrue(actualCreateRequestMappingHandlerMappingResult instanceof AdminRequestMappingHandlerMapping);
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertTrue(actualCreateRequestMappingHandlerMappingResult
        .getNamingStrategy() instanceof RequestMappingInfoHandlerMethodMappingNamingStrategy);
    assertNull(actualCreateRequestMappingHandlerMappingResult.getDefaultHandler());
    assertNull(actualCreateRequestMappingHandlerMappingResult.getFileExtensions());
    assertNull(actualCreateRequestMappingHandlerMappingResult.getCorsConfigurationSource());
    assertNull(actualCreateRequestMappingHandlerMappingResult.getPatternParser());
    assertFalse(actualCreateRequestMappingHandlerMappingResult.useRegisteredSuffixPatternMatch());
    assertFalse(actualCreateRequestMappingHandlerMappingResult.useSuffixPatternMatch());
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getHandlerMethods().isEmpty());
    assertTrue(actualCreateRequestMappingHandlerMappingResult.getPathPrefixes().isEmpty());
    assertTrue(actualCreateRequestMappingHandlerMappingResult.useTrailingSlashMatch());
    assertEquals(Integer.MAX_VALUE, actualCreateRequestMappingHandlerMappingResult.getOrder());
  }

  /**
   * Test new {@link AdminWebMvcConfigurationSupport} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AdminWebMvcConfigurationSupport}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminWebMvcConfigurationSupport.<init>()"})
  public void testNewAdminWebMvcConfigurationSupport() {
    // Arrange and Act
    AdminWebMvcConfigurationSupport actualAdminWebMvcConfigurationSupport = new AdminWebMvcConfigurationSupport();

    // Assert
    assertNull(actualAdminWebMvcConfigurationSupport.getServletContext());
    assertNull(actualAdminWebMvcConfigurationSupport.getApplicationContext());
  }
}
