package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class DefaultLinkedDataGeneratorImplDiffblueTest {
  @Autowired
  private DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl;

  /**
   * Test {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest)")
  void testCanHandle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl = new DefaultLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertTrue(defaultLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest)")
  void testCanHandle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl = new DefaultLinkedDataGeneratorImpl();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);

    // Act and Assert
    assertTrue(defaultLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testCanHandle3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4128 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl2 = new DefaultLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    defaultLinkedDataGeneratorImpl2.canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test
   * {@link DefaultLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link DefaultLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)")
  @Disabled("TODO: Complete this test")
  void testGetLinkedDataJsonInternal() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4284 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl2 = new DefaultLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorImpl2.getLinkedDataJsonInternal("https://example.org/example", request, new JSONArray(3));
  }

  /**
   * Test
   * {@link DefaultLinkedDataGeneratorImpl#addBreadcrumbData(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultLinkedDataGeneratorImpl#addBreadcrumbData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test addBreadcrumbData(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testAddBreadcrumbData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3972 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl2 = new DefaultLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    defaultLinkedDataGeneratorImpl2.addBreadcrumbData(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }
}
