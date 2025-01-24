package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class AbstractLinkedDataGeneratorExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addDefaultData(HttpServletRequest, JSONArray)")
  void testAddDefaultData() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addDefaultData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addDefaultData(HttpServletRequest, JSONArray)")
  void testAddDefaultData2() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addDefaultData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addDefaultData(HttpServletRequest, JSONArray)")
  @Disabled("TODO: Complete this test")
  void testAddDefaultData3() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1544 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addDefaultData(request, new JSONArray(3));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addBreadcrumbData(HttpServletRequest, JSONObject)")
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
    //   public class DiffblueFakeClass434 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addBreadcrumbData(request, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addBreadcrumbData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddBreadcrumbData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddBreadcrumbDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addBreadcrumbData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddBreadcrumbDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addBreadcrumbListItemData(HttpServletRequest, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddBreadcrumbListItemData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass804 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addBreadcrumbListItemData(request, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addBreadcrumbListItemData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddBreadcrumbListItemData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddBreadcrumbListItemDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addBreadcrumbListItemData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddBreadcrumbListItemDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addBreadcrumbItemData(HttpServletRequest, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddBreadcrumbItemData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass619 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addBreadcrumbItemData(request, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addBreadcrumbItemData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddBreadcrumbItemData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddBreadcrumbItemDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addBreadcrumbItemData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddBreadcrumbItemDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addHomepageData(HttpServletRequest, JSONArray)")
  void testAddHomepageData() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addHomepageData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addHomepageData(HttpServletRequest, JSONArray)")
  void testAddHomepageData2() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addHomepageData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addHomepageData(HttpServletRequest, JSONArray)")
  @Disabled("TODO: Complete this test")
  void testAddHomepageData3() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1724 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addHomepageData(request, new JSONArray(3));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addWebSiteData(HttpServletRequest, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddWebSiteData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3105 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addWebSiteData(request, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addWebSiteData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddWebSiteData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddWebSiteDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addWebSiteData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddWebSiteDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addOrganizationData(HttpServletRequest, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddOrganizationData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1904 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addOrganizationData(request, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addOrganizationData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddOrganizationData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddOrganizationDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addOrganizationData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddOrganizationDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addContactData(HttpServletRequest, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddContactData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1359 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addContactData(request, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addContactData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddContactData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddContactDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addContactData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddContactDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addSocialMediaData(HttpServletRequest, JSONArray)")
  void testAddSocialMediaData() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addSocialMediaData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addSocialMediaData(HttpServletRequest, JSONArray)")
  void testAddSocialMediaData2() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addSocialMediaData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addSocialMediaData(HttpServletRequest, JSONArray)")
  @Disabled("TODO: Complete this test")
  void testAddSocialMediaData3() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2925 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addSocialMediaData(request, new JSONArray(3));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addPotentialActionsData(HttpServletRequest, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddPotentialActionsData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2089 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addPotentialActionsData(request, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addPotentialActionsData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddPotentialActionsData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddPotentialActionsDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addPotentialActionsData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddPotentialActionsDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addCategoryData(HttpServletRequest, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddCategoryData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass989 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addCategoryData(request, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addCategoryData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddCategoryData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddCategoryDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addCategoryData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddCategoryDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addCategoryProductData(HttpServletRequest, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddCategoryProductData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1174 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addCategoryProductData(request, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addCategoryProductData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddCategoryProductData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddCategoryProductDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addCategoryProductData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddCategoryProductDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest, Product, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addReviewData(HttpServletRequest, Product, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddReviewData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2491 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addReviewData(request, product, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addReviewData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddReviewData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddReviewDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addReviewData(request, product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddReviewDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addAggregateReviewData(HttpServletRequest, Product, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddAggregateReviewData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addAggregateReviewData(request, product, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addAggregateReviewData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddAggregateReviewData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddAggregateReviewDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addAggregateReviewData(request, product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddAggregateReviewDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest, Product, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addProductData(HttpServletRequest, Product, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddProductData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2274 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addProductData(request, product, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addProductData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddProductData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddProductDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addProductData(request, product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddProductDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addSkuData(HttpServletRequest, Product, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddSkuData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2708 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addSkuData(request, product, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addSkuData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddSkuData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddSkuDataResult = defaultLinkedDataGeneratorExtensionHandler.addSkuData(request,
        product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddSkuDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest, Product, JSONObject)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addAggregateSkuData(HttpServletRequest, Product, JSONObject)")
  @Disabled("TODO: Complete this test")
  void testAddAggregateSkuData() throws JSONException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass217 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    defaultLinkedDataGeneratorExtensionHandler.addAggregateSkuData(request, product, new JSONObject("String"));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addAggregateSkuData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddAggregateSkuData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddAggregateSkuDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addAggregateSkuData(request, product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddAggregateSkuDataResult);
  }
}
