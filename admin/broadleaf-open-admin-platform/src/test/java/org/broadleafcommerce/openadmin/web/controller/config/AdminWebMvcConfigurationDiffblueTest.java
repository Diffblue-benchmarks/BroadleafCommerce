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
import org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver;
import org.broadleafcommerce.openadmin.web.compatibility.JSFieldNameCompatibilityInterceptor;
import org.broadleafcommerce.openadmin.web.controller.AdminRequestMappingHandlerMapping;
import org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class AdminWebMvcConfigurationDiffblueTest {
  /**
   * Test AdminDefaultWebMvcConfigurerAdapter {@link AdminDefaultWebMvcConfigurerAdapter#blAdminMvcRegistrations()}.
   * <p>
   * Method under test: {@link AdminDefaultWebMvcConfigurerAdapter#blAdminMvcRegistrations()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WebMvcRegistrations AdminDefaultWebMvcConfigurerAdapter.blAdminMvcRegistrations()"})
  public void testAdminDefaultWebMvcConfigurerAdapterBlAdminMvcRegistrations() {
    // Arrange and Act
    WebMvcRegistrations actualBlAdminMvcRegistrationsResult = (new AdminDefaultWebMvcConfigurerAdapter())
        .blAdminMvcRegistrations();

    // Assert
    RequestMappingHandlerMapping requestMappingHandlerMapping = actualBlAdminMvcRegistrationsResult
        .getRequestMappingHandlerMapping();
    assertTrue(requestMappingHandlerMapping instanceof AdminRequestMappingHandlerMapping);
    assertTrue(requestMappingHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(requestMappingHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertTrue(requestMappingHandlerMapping
        .getNamingStrategy() instanceof RequestMappingInfoHandlerMethodMappingNamingStrategy);
    assertNull(requestMappingHandlerMapping.getDefaultHandler());
    assertNull(requestMappingHandlerMapping.getFileExtensions());
    assertNull(requestMappingHandlerMapping.getCorsConfigurationSource());
    assertNull(actualBlAdminMvcRegistrationsResult.getExceptionHandlerExceptionResolver());
    assertNull(actualBlAdminMvcRegistrationsResult.getRequestMappingHandlerAdapter());
    assertNull(requestMappingHandlerMapping.getPatternParser());
    assertFalse(requestMappingHandlerMapping.useRegisteredSuffixPatternMatch());
    assertFalse(requestMappingHandlerMapping.useSuffixPatternMatch());
    assertTrue(requestMappingHandlerMapping.getHandlerMethods().isEmpty());
    assertTrue(requestMappingHandlerMapping.getPathPrefixes().isEmpty());
    assertTrue(requestMappingHandlerMapping.useTrailingSlashMatch());
    assertEquals(Integer.MAX_VALUE, requestMappingHandlerMapping.getOrder());
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter {@link AdminDefaultWebMvcConfigurerAdapter#blJsFieldNameCompatibilityInterceptor()}.
   * <p>
   * Method under test: {@link AdminDefaultWebMvcConfigurerAdapter#blJsFieldNameCompatibilityInterceptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MappedInterceptor AdminDefaultWebMvcConfigurerAdapter.blJsFieldNameCompatibilityInterceptor()"})
  public void testAdminDefaultWebMvcConfigurerAdapterBlJsFieldNameCompatibilityInterceptor() {
    // Arrange and Act
    MappedInterceptor actualBlJsFieldNameCompatibilityInterceptorResult = (new AdminDefaultWebMvcConfigurerAdapter())
        .blJsFieldNameCompatibilityInterceptor();

    // Assert
    assertTrue(actualBlJsFieldNameCompatibilityInterceptorResult
        .getInterceptor() instanceof JSFieldNameCompatibilityInterceptor);
    assertTrue(actualBlJsFieldNameCompatibilityInterceptorResult.getPathMatcher() instanceof AntPathMatcher);
    assertNull(actualBlJsFieldNameCompatibilityInterceptorResult.getPathPatterns());
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter {@link AdminDefaultWebMvcConfigurerAdapter#blLocaleChangeInterceptor()}.
   * <p>
   * Method under test: {@link AdminDefaultWebMvcConfigurerAdapter#blLocaleChangeInterceptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MappedInterceptor AdminDefaultWebMvcConfigurerAdapter.blLocaleChangeInterceptor()"})
  public void testAdminDefaultWebMvcConfigurerAdapterBlLocaleChangeInterceptor() {
    // Arrange and Act
    MappedInterceptor actualBlLocaleChangeInterceptorResult = (new AdminDefaultWebMvcConfigurerAdapter())
        .blLocaleChangeInterceptor();

    // Assert
    assertTrue(actualBlLocaleChangeInterceptorResult.getPathMatcher() instanceof AntPathMatcher);
    HandlerInterceptor interceptor = actualBlLocaleChangeInterceptorResult.getInterceptor();
    assertTrue(interceptor instanceof LocaleChangeInterceptor);
    assertEquals("blLocaleCode", ((LocaleChangeInterceptor) interceptor).getParamName());
    assertNull(actualBlLocaleChangeInterceptorResult.getPathPatterns());
    assertNull(((LocaleChangeInterceptor) interceptor).getHttpMethods());
    assertFalse(((LocaleChangeInterceptor) interceptor).isIgnoreInvalidLocale());
    assertTrue(((LocaleChangeInterceptor) interceptor).isLanguageTagCompliant());
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter {@link AdminDefaultWebMvcConfigurerAdapter#localeResolver()}.
   * <p>
   * Method under test: {@link AdminDefaultWebMvcConfigurerAdapter#localeResolver()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LocaleResolver AdminDefaultWebMvcConfigurerAdapter.localeResolver()"})
  public void testAdminDefaultWebMvcConfigurerAdapterLocaleResolver() {
    // Arrange and Act
    LocaleResolver actualLocaleResolverResult = (new AdminDefaultWebMvcConfigurerAdapter()).localeResolver();

    // Assert
    assertTrue(actualLocaleResolverResult instanceof BroadleafCookieLocaleResolver);
    assertEquals("/", ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookiePath());
    assertEquals("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE",
        ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieName());
    assertNull(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieMaxAge());
    assertNull(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieDomain());
    assertFalse(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isCookieSecure());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isLanguageTagCompliant());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isRejectInvalidCookies());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isCookieHttpOnly());
  }
}
