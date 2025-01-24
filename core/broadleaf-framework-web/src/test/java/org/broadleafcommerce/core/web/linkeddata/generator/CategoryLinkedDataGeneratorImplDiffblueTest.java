package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class CategoryLinkedDataGeneratorImplDiffblueTest {
  @Autowired
  private CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl;

  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testCanHandle() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3474 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl2 = new CategoryLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    categoryLinkedDataGeneratorImpl2.canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code Attribute}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); given 'Attribute'; then return 'true'")
  void testCanHandle_givenAttribute_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl = new CategoryLinkedDataGeneratorImpl();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    boolean actualCanHandleResult = categoryLinkedDataGeneratorImpl
        .canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert
    verify(servletRequest).getAttribute(eq("category"));
    assertTrue(actualCanHandleResult);
  }

  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); then return 'false'")
  void testCanHandle_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl = new CategoryLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(categoryLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test
   * {@link CategoryLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link CategoryLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)}
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
    //   public class DiffblueFakeClass3630 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl2 = new CategoryLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    categoryLinkedDataGeneratorImpl2.getLinkedDataJsonInternal("https://example.org/example", request,
        new JSONArray(3));
  }

  /**
   * Test
   * {@link CategoryLinkedDataGeneratorImpl#addCategoryProductData(HttpServletRequest, JSONObject)}.
   * <p>
   * Method under test:
   * {@link CategoryLinkedDataGeneratorImpl#addCategoryProductData(HttpServletRequest, JSONObject)}
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
    //   public class DiffblueFakeClass3290 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl2 = new CategoryLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    categoryLinkedDataGeneratorImpl2.addCategoryProductData(request, new JSONObject("String"));
  }

  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#getProducts(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link CategoryLinkedDataGeneratorImpl#getProducts(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getProducts(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testGetProducts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3813 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl2 = new CategoryLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    categoryLinkedDataGeneratorImpl2.getProducts(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }
}
