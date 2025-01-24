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

@ContextConfiguration(classes = {ProductHandlerMapping.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class ProductHandlerMappingDiffblueTest {
  @MockBean
  private CatalogService catalogService;

  @MockBean
  private Environment environment;

  @Autowired
  private ProductHandlerMapping productHandlerMapping;

  /**
   * Test {@link ProductHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link ProductHandlerMapping#getHandlerInternal(HttpServletRequest)}
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
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.ProductHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2843 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.ProductHandlerMapping productHandlerMapping;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    productHandlerMapping.getHandlerInternal(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));
  }

  /**
   * Test {@link ProductHandlerMapping#shouldSkipExecution(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link ProductHandlerMapping#shouldSkipExecution(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test shouldSkipExecution(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testShouldSkipExecution() throws ServletRequestBindingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.catalog;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.ProductHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2844 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.ProductHandlerMapping productHandlerMapping;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    productHandlerMapping.shouldSkipExecution(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));
  }

  /**
   * Test
   * {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test findProductUsingIdParam(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testFindProductUsingIdParam() throws ServletRequestBindingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.catalog;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.ProductHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2841 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.ProductHandlerMapping productHandlerMapping;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    productHandlerMapping.findProductUsingIdParam(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));
  }

  /**
   * Test
   * {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test findProductUsingIdParam(HttpServletRequest); then return 'null'")
  void testFindProductUsingIdParam_thenReturnNull() throws ServletRequestBindingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductHandlerMapping productHandlerMapping = new ProductHandlerMapping();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull(
        productHandlerMapping.findProductUsingIdParam(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link ProductHandlerMapping#findProductUsingUrl(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link ProductHandlerMapping#findProductUsingUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test findProductUsingUrl(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testFindProductUsingUrl() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.catalog;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.ProductHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2842 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.ProductHandlerMapping productHandlerMapping;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    productHandlerMapping.findProductUsingUrl(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link ProductHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ProductHandlerMapping productHandlerMapping = new ProductHandlerMapping();

    // Act
    productHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert that nothing has changed
    assertEquals("Default Template Name", productHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link ProductHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProductHandlerMapping}
   */
  @Test
  @DisplayName("Test new ProductHandlerMapping (default constructor)")
  void testNewProductHandlerMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductHandlerMapping actualProductHandlerMapping = new ProductHandlerMapping();

    // Assert
    assertTrue(actualProductHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualProductHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertEquals("catalog/product", actualProductHandlerMapping.getDefaultTemplateName());
    assertNull(actualProductHandlerMapping.getDefaultHandler());
    assertNull(actualProductHandlerMapping.getControllerName());
    assertNull(actualProductHandlerMapping.charEncoding);
    assertNull(actualProductHandlerMapping.catalogService);
    assertNull(actualProductHandlerMapping.getCorsConfigurationSource());
    assertNull(actualProductHandlerMapping.getPatternParser());
    assertTrue(actualProductHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualProductHandlerMapping.getOrder());
  }

  /**
   * Test new {@link ProductHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProductHandlerMapping}
   */
  @Test
  @DisplayName("Test new ProductHandlerMapping (default constructor)")
  @Disabled("TODO: Complete this test")
  void testNewProductHandlerMapping2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.catalog;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.ProductHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2840 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.ProductHandlerMapping productHandlerMapping;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new ProductHandlerMapping();
  }
}
