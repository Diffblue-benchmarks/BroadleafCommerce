package org.broadleafcommerce.core.web.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;

@ContextConfiguration(classes = {SkuHandlerMapping.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class SkuHandlerMappingDiffblueTest {
  @MockBean
  private CatalogService catalogService;

  @MockBean
  private Environment environment;

  @Autowired
  private SkuHandlerMapping skuHandlerMapping;

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
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
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.SkuHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2846 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.SkuHandlerMapping skuHandlerMapping;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    skuHandlerMapping.getHandlerInternal(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} RequestURI
   * is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest); when MockHttpServletRequest() RequestURI is 'null'; then return 'null'")
  void testGetHandlerInternal_whenMockHttpServletRequestRequestURIIsNull_thenReturnNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuHandlerMapping skuHandlerMapping = new SkuHandlerMapping();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI(null);
    request.setContextPath(null);

    // Act and Assert
    assertNull(skuHandlerMapping.getHandlerInternal(request));
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest); when 'null'; then return 'null'")
  void testGetHandlerInternal_whenNull_thenReturnNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuHandlerMapping()).getHandlerInternal(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link SkuHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    SkuHandlerMapping skuHandlerMapping = new SkuHandlerMapping();

    // Act
    skuHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert that nothing has changed
    assertEquals("Default Template Name", skuHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link SkuHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SkuHandlerMapping}
   */
  @Test
  @DisplayName("Test new SkuHandlerMapping (default constructor)")
  void testNewSkuHandlerMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SkuHandlerMapping actualSkuHandlerMapping = new SkuHandlerMapping();

    // Assert
    assertTrue(actualSkuHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualSkuHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertEquals("catalog/sku", actualSkuHandlerMapping.getDefaultTemplateName());
    assertNull(actualSkuHandlerMapping.getDefaultHandler());
    assertNull(actualSkuHandlerMapping.getControllerName());
    assertNull(actualSkuHandlerMapping.getCorsConfigurationSource());
    assertNull(actualSkuHandlerMapping.getPatternParser());
    assertTrue(actualSkuHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualSkuHandlerMapping.getOrder());
  }

  /**
   * Test new {@link SkuHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SkuHandlerMapping}
   */
  @Test
  @DisplayName("Test new SkuHandlerMapping (default constructor)")
  @Disabled("TODO: Complete this test")
  void testNewSkuHandlerMapping2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.catalog;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.catalog.SkuHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2845 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.catalog.SkuHandlerMapping skuHandlerMapping;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new SkuHandlerMapping();
  }
}
