package org.broadleafcommerce.openadmin.web.controller.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver;
import org.broadleafcommerce.openadmin.web.compatibility.JSFieldNameCompatibilityInterceptor;
import org.broadleafcommerce.openadmin.web.controller.AdminRequestMappingHandlerMapping;
import org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@ContextConfiguration(classes = {AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminWebMvcConfigurationDiffblueTest {
  @Autowired
  private AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter adminDefaultWebMvcConfigurerAdapter;

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#basicErrorController()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#basicErrorController()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdminDefaultWebMvcConfigurerAdapterBasicErrorController() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.config;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter adminDefaultWebMvcConfigurerAdapter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminDefaultWebMvcConfigurerAdapter.basicErrorController();
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#blAdminMvcRegistrations()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#blAdminMvcRegistrations()}
   */
  @Test
  public void testAdminDefaultWebMvcConfigurerAdapterBlAdminMvcRegistrations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    WebMvcRegistrations actualBlAdminMvcRegistrationsResult = (new AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter())
        .blAdminMvcRegistrations();

    // Assert
    RequestMappingHandlerMapping requestMappingHandlerMapping = actualBlAdminMvcRegistrationsResult
        .getRequestMappingHandlerMapping();
    assertTrue(requestMappingHandlerMapping instanceof AdminRequestMappingHandlerMapping);
    assertTrue(requestMappingHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    ContentNegotiationManager contentNegotiationManager = requestMappingHandlerMapping.getContentNegotiationManager();
    List<ContentNegotiationStrategy> strategies = contentNegotiationManager.getStrategies();
    assertEquals(1, strategies.size());
    assertTrue(strategies.get(0) instanceof HeaderContentNegotiationStrategy);
    assertTrue(requestMappingHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertTrue(requestMappingHandlerMapping
        .getNamingStrategy() instanceof RequestMappingInfoHandlerMethodMappingNamingStrategy);
    assertNull(requestMappingHandlerMapping.getDefaultHandler());
    RequestMappingInfo.BuilderConfiguration builderConfiguration = requestMappingHandlerMapping
        .getBuilderConfiguration();
    assertNull(builderConfiguration.getFileExtensions());
    assertNull(requestMappingHandlerMapping.getFileExtensions());
    assertNull(builderConfiguration.getPathMatcher());
    assertNull(builderConfiguration.getContentNegotiationManager());
    assertNull(requestMappingHandlerMapping.getCorsConfigurationSource());
    assertNull(actualBlAdminMvcRegistrationsResult.getExceptionHandlerExceptionResolver());
    assertNull(actualBlAdminMvcRegistrationsResult.getRequestMappingHandlerAdapter());
    assertNull(requestMappingHandlerMapping.getPatternParser());
    assertNull(builderConfiguration.getPatternParser());
    assertFalse(requestMappingHandlerMapping.useRegisteredSuffixPatternMatch());
    assertFalse(requestMappingHandlerMapping.useSuffixPatternMatch());
    assertTrue(contentNegotiationManager.getAllFileExtensions().isEmpty());
    assertTrue(requestMappingHandlerMapping.getHandlerMethods().isEmpty());
    Map<String, Predicate<Class<?>>> pathPrefixes = requestMappingHandlerMapping.getPathPrefixes();
    assertTrue(pathPrefixes.isEmpty());
    assertTrue(requestMappingHandlerMapping.useTrailingSlashMatch());
    assertTrue(requestMappingHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertTrue(builderConfiguration.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, requestMappingHandlerMapping.getOrder());
    assertSame(pathPrefixes, contentNegotiationManager.getMediaTypeMappings());
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#blAdminMvcRegistrations()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#blAdminMvcRegistrations()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdminDefaultWebMvcConfigurerAdapterBlAdminMvcRegistrations2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.config;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter adminDefaultWebMvcConfigurerAdapter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminDefaultWebMvcConfigurerAdapter.blAdminMvcRegistrations();
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#blJsFieldNameCompatibilityInterceptor()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#blJsFieldNameCompatibilityInterceptor()}
   */
  @Test
  public void testAdminDefaultWebMvcConfigurerAdapterBlJsFieldNameCompatibilityInterceptor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    MappedInterceptor actualBlJsFieldNameCompatibilityInterceptorResult = (new AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter())
        .blJsFieldNameCompatibilityInterceptor();

    // Assert
    assertTrue(actualBlJsFieldNameCompatibilityInterceptorResult
        .getInterceptor() instanceof JSFieldNameCompatibilityInterceptor);
    assertTrue(actualBlJsFieldNameCompatibilityInterceptorResult.getPathMatcher() instanceof AntPathMatcher);
    assertNull(actualBlJsFieldNameCompatibilityInterceptorResult.getPathPatterns());
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#blJsFieldNameCompatibilityInterceptor()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#blJsFieldNameCompatibilityInterceptor()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdminDefaultWebMvcConfigurerAdapterBlJsFieldNameCompatibilityInterceptor2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.config;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter adminDefaultWebMvcConfigurerAdapter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminDefaultWebMvcConfigurerAdapter.blJsFieldNameCompatibilityInterceptor();
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#blLocaleChangeInterceptor()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#blLocaleChangeInterceptor()}
   */
  @Test
  public void testAdminDefaultWebMvcConfigurerAdapterBlLocaleChangeInterceptor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    MappedInterceptor actualBlLocaleChangeInterceptorResult = (new AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter())
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
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#blLocaleChangeInterceptor()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#blLocaleChangeInterceptor()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdminDefaultWebMvcConfigurerAdapterBlLocaleChangeInterceptor2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.config;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter adminDefaultWebMvcConfigurerAdapter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminDefaultWebMvcConfigurerAdapter.blLocaleChangeInterceptor();
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#configureContentNegotiation(ContentNegotiationConfigurer)}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#configureContentNegotiation(ContentNegotiationConfigurer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdminDefaultWebMvcConfigurerAdapterConfigureContentNegotiation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.config;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter adminDefaultWebMvcConfigurerAdapter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminDefaultWebMvcConfigurerAdapter
        .configureContentNegotiation(new ContentNegotiationConfigurer(new MockServletContext()));
  }

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#localeResolver()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#localeResolver()}
   */
  @Test
  public void testAdminDefaultWebMvcConfigurerAdapterLocaleResolver() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    LocaleResolver actualLocaleResolverResult = (new AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter())
        .localeResolver();

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

  /**
   * Test AdminDefaultWebMvcConfigurerAdapter
   * {@link AdminDefaultWebMvcConfigurerAdapter#localeResolver()}.
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter#localeResolver()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdminDefaultWebMvcConfigurerAdapterLocaleResolver2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.config;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfiguration.AdminDefaultWebMvcConfigurerAdapter adminDefaultWebMvcConfigurerAdapter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminDefaultWebMvcConfigurerAdapter.localeResolver();
  }
}
