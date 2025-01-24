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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@ContextConfiguration(classes = {AdminWebMvcConfigurationSupport.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminWebMvcConfigurationSupportDiffblueTest {
  @Autowired
  private AdminWebMvcConfigurationSupport adminWebMvcConfigurationSupport;

  @Autowired
  private List<WebMvcConfigurer> list;

  @MockBean
  private WebMvcConfigurer webMvcConfigurer;

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
   * <p>
   * Method under test:
   * {@link AdminWebMvcConfigurationSupport#createRequestMappingHandlerMapping()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateRequestMappingHandlerMapping2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfigurationSupport
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.config;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfigurationSupport.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfigurationSupport adminWebMvcConfigurationSupport;
    //     @org.springframework.beans.factory.annotation.Autowired java.util.List<Lorg.springframework.web.servlet.config.annotation.WebMvcConfigurer;> list;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.web.servlet.config.annotation.WebMvcConfigurer webMvcConfigurer;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminWebMvcConfigurationSupport.createRequestMappingHandlerMapping();
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

  /**
   * Test new {@link AdminWebMvcConfigurationSupport} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminWebMvcConfigurationSupport}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewAdminWebMvcConfigurationSupport2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfigurationSupport
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.config;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfigurationSupport.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.config.AdminWebMvcConfigurationSupport adminWebMvcConfigurationSupport;
    //     @org.springframework.beans.factory.annotation.Autowired java.util.List<Lorg.springframework.web.servlet.config.annotation.WebMvcConfigurer;> list;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.web.servlet.config.annotation.WebMvcConfigurer webMvcConfigurer;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new AdminWebMvcConfigurationSupport();
  }
}
