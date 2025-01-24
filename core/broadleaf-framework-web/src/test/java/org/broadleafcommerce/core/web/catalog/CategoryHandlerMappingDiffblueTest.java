package org.broadleafcommerce.core.web.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.cors.DefaultCorsProcessor;

@ContextConfiguration(classes = {CategoryHandlerMapping.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class CategoryHandlerMappingDiffblueTest {
  @MockBean
  private CatalogService catalogService;

  @Autowired
  private CategoryHandlerMapping categoryHandlerMapping;

  @MockBean
  private Environment environment;

  /**
   * Test {@link CategoryHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link CategoryHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testGetHandlerInternal() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.catalog;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.CategoryHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2348 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.CategoryHandlerMapping categoryHandlerMapping;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    categoryHandlerMapping.getHandlerInternal(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));
  }

  /**
   * Test
   * {@link CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test findCategoryUsingIdParam(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testFindCategoryUsingIdParam() throws ServletRequestBindingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.catalog;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.CategoryHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2346 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.CategoryHandlerMapping categoryHandlerMapping;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    categoryHandlerMapping.findCategoryUsingIdParam(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));
  }

  /**
   * Test
   * {@link CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test findCategoryUsingIdParam(HttpServletRequest); then return 'null'")
  void testFindCategoryUsingIdParam_thenReturnNull() throws ServletRequestBindingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryHandlerMapping categoryHandlerMapping = new CategoryHandlerMapping();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull(
        categoryHandlerMapping.findCategoryUsingIdParam(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link CategoryHandlerMapping#findCategoryUsingUrl(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link CategoryHandlerMapping#findCategoryUsingUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test findCategoryUsingUrl(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testFindCategoryUsingUrl() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.catalog;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.CategoryHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2347 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.CategoryHandlerMapping categoryHandlerMapping;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    categoryHandlerMapping.findCategoryUsingUrl(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link CategoryHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CategoryHandlerMapping categoryHandlerMapping = new CategoryHandlerMapping();

    // Act
    categoryHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert that nothing has changed
    assertEquals("Default Template Name", categoryHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link CategoryHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CategoryHandlerMapping}
   */
  @Test
  @DisplayName("Test new CategoryHandlerMapping (default constructor)")
  void testNewCategoryHandlerMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CategoryHandlerMapping actualCategoryHandlerMapping = new CategoryHandlerMapping();

    // Assert
    assertTrue(actualCategoryHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualCategoryHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertEquals("catalog/category", actualCategoryHandlerMapping.getDefaultTemplateName());
    assertNull(actualCategoryHandlerMapping.getDefaultHandler());
    assertNull(actualCategoryHandlerMapping.getControllerName());
    assertNull(actualCategoryHandlerMapping.charEncoding);
    assertNull(actualCategoryHandlerMapping.getCorsConfigurationSource());
    assertNull(actualCategoryHandlerMapping.getPatternParser());
    assertTrue(actualCategoryHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualCategoryHandlerMapping.getOrder());
  }

  /**
   * Test new {@link CategoryHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CategoryHandlerMapping}
   */
  @Test
  @DisplayName("Test new CategoryHandlerMapping (default constructor)")
  @Disabled("TODO: Complete this test")
  void testNewCategoryHandlerMapping2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.catalog;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.CategoryHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2345 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.CategoryHandlerMapping categoryHandlerMapping;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new CategoryHandlerMapping();
  }
}
