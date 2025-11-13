package org.broadleafcommerce.openadmin.web.controller.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.controller.AdminRequestMappingHandlerMapping;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class AdminWebMvcConfigurationSupportDiffblueTest {
  /**
   * Test {@link AdminWebMvcConfigurationSupport#createRequestMappingHandlerMapping()}.
   *
   * <p>Method under test: {@link
   * AdminWebMvcConfigurationSupport#createRequestMappingHandlerMapping()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RequestMappingHandlerMapping AdminWebMvcConfigurationSupport.createRequestMappingHandlerMapping()"
  })
  public void testCreateRequestMappingHandlerMapping() {
    // Arrange and Act
    RequestMappingHandlerMapping actualCreateRequestMappingHandlerMappingResult =
        new AdminWebMvcConfigurationSupport().createRequestMappingHandlerMapping();

    // Assert
    assertTrue(
        actualCreateRequestMappingHandlerMappingResult
            instanceof AdminRequestMappingHandlerMapping);
    assertTrue(
        actualCreateRequestMappingHandlerMappingResult.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(
        actualCreateRequestMappingHandlerMappingResult.getCorsProcessor()
            instanceof DefaultCorsProcessor);
    assertTrue(
        actualCreateRequestMappingHandlerMappingResult.getNamingStrategy()
            instanceof RequestMappingInfoHandlerMethodMappingNamingStrategy);
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
}
