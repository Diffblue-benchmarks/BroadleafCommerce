package org.broadleafcommerce.core.web.linkeddata.generator;

import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbService;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
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

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class AbstractLinkedDataGeneratorDiffblueTest {
  @Autowired
  private AbstractLinkedDataGenerator abstractLinkedDataGenerator;

  @MockBean
  private BaseUrlResolver baseUrlResolver;

  @MockBean
  private BreadcrumbService breadcrumbService;

  @MockBean
  private Environment environment;

  @MockBean(name = "blLinkedDataGeneratorExtensionManager")
  private LinkedDataGeneratorExtensionManager linkedDataGeneratorExtensionManager;

  /**
   * Test
   * {@link AbstractLinkedDataGenerator#getLinkedDataJSON(String, HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGenerator#getLinkedDataJSON(String, HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test getLinkedDataJSON(String, HttpServletRequest, JSONArray)")
  @Disabled("TODO: Complete this test")
  void testGetLinkedDataJSON() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4358 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGenerator abstractLinkedDataGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl = new CategoryLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    categoryLinkedDataGeneratorImpl.getLinkedDataJSON("https://example.org/example", request, new JSONArray(3));
  }

  /**
   * Test {@link AbstractLinkedDataGenerator#getRequestUri()}.
   * <p>
   * Method under test: {@link AbstractLinkedDataGenerator#getRequestUri()}
   */
  @Test
  @DisplayName("Test getRequestUri()")
  @Disabled("TODO: Complete this test")
  void testGetRequestUri() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4540 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGenerator abstractLinkedDataGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CategoryLinkedDataGeneratorImpl()).getRequestUri();
  }

  /**
   * Test {@link AbstractLinkedDataGenerator#getRequestParams()}.
   * <p>
   * Method under test: {@link AbstractLinkedDataGenerator#getRequestParams()}
   */
  @Test
  @DisplayName("Test getRequestParams()")
  @Disabled("TODO: Complete this test")
  void testGetRequestParams() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestContext.getRequestParameterMap(BroadleafRequestContext.java:442)
    //       at org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGenerator.getRequestParams(AbstractLinkedDataGenerator.java:74)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    AbstractLinkedDataGenerator.getRequestParams();
  }

  /**
   * Test {@link AbstractLinkedDataGenerator#getSiteBaseUrl()}.
   * <p>
   * Method under test: {@link AbstractLinkedDataGenerator#getSiteBaseUrl()}
   */
  @Test
  @DisplayName("Test getSiteBaseUrl()")
  @Disabled("TODO: Complete this test")
  void testGetSiteBaseUrl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4542 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGenerator abstractLinkedDataGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CategoryLinkedDataGeneratorImpl()).getSiteBaseUrl();
  }

  /**
   * Test {@link AbstractLinkedDataGenerator#getStructuredDataContext()}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGenerator#getStructuredDataContext()}
   */
  @Test
  @DisplayName("Test getStructuredDataContext()")
  @Disabled("TODO: Complete this test")
  void testGetStructuredDataContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4544 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGenerator abstractLinkedDataGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CategoryLinkedDataGeneratorImpl()).getStructuredDataContext();
  }
}
