package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.template.TemplateOverrideExtensionManager;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.common.web.deeplink.DeepLinkService;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.search.service.SearchService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.core.web.service.SearchFacetDTOService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {BroadleafCategoryController.class})
@ExtendWith(SpringExtension.class)
class BroadleafCategoryControllerDiffblueTest {
  @Autowired
  private BroadleafCategoryController broadleafCategoryController;

  @MockBean(name = "blCategoryDeepLinkService")
  private DeepLinkService<Category> deepLinkService;

  @MockBean
  private SearchFacetDTOService searchFacetDTOService;

  @MockBean
  private SearchService searchService;

  @MockBean(name = "blTemplateOverrideExtensionManager")
  private TemplateOverrideExtensionManager templateOverrideExtensionManager;

  /**
   * Test
   * {@link BroadleafCategoryController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link BroadleafCategoryController#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test handleRequest(HttpServletRequest, HttpServletResponse)")
  void testHandleRequest() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCategoryController broadleafCategoryController = new BroadleafCategoryController();

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("facetField", "42");
    servletRequest.addParameter("https://example.org/example", "https://example.org/example");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    ModelAndView actualHandleRequestResult = broadleafCategoryController.handleRequest(request,
        new MockHttpServletResponse());

    // Assert
    assertEquals("redirect:http://localhost?https%3A%2F%2Fexample.org%2Fexample=https%3A%2F%2Fexample.org%2Fexample",
        actualHandleRequestResult.getViewName());
    assertNull(actualHandleRequestResult.getStatus());
    assertNull(actualHandleRequestResult.getView());
    assertFalse(actualHandleRequestResult.isEmpty());
    Map<String, Object> model = actualHandleRequestResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestResult.hasView());
    assertTrue(actualHandleRequestResult.isReference());
    assertSame(model, actualHandleRequestResult.getModelMap());
  }

  /**
   * Test
   * {@link BroadleafCategoryController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link BroadleafCategoryController#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test handleRequest(HttpServletRequest, HttpServletResponse)")
  @Disabled("TODO: Complete this test")
  void testHandleRequest2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.catalog;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.catalog.BroadleafCategoryController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass29 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.catalog.BroadleafCategoryController broadleafCategoryController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCategoryDeepLinkService") org.broadleafcommerce.common.web.deeplink.DeepLinkService<Lorg.broadleafcommerce.core.catalog.domain.Category;> deepLinkService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.SearchFacetDTOService searchFacetDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.SearchService searchService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blTemplateOverrideExtensionManager") org.broadleafcommerce.common.template.TemplateOverrideExtensionManager templateOverrideExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    broadleafCategoryController.handleRequest(request, new MockHttpServletResponse());
  }

  /**
   * Test
   * {@link BroadleafCategoryController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given Default.</li>
   *   <li>Then return ViewName is {@code redirect:http://localhost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCategoryController#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test handleRequest(HttpServletRequest, HttpServletResponse); given Default; then return ViewName is 'redirect:http://localhost'")
  void testHandleRequest_givenDefault_thenReturnViewNameIsRedirectHttpLocalhost() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCategoryController broadleafCategoryController = new BroadleafCategoryController();

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("facetField", "42");
    servletRequest.addPreferredLocale(Locale.getDefault());
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    ModelAndView actualHandleRequestResult = broadleafCategoryController.handleRequest(request,
        new MockHttpServletResponse());

    // Assert
    assertEquals("redirect:http://localhost", actualHandleRequestResult.getViewName());
    assertNull(actualHandleRequestResult.getStatus());
    assertNull(actualHandleRequestResult.getView());
    assertFalse(actualHandleRequestResult.isEmpty());
    Map<String, Object> model = actualHandleRequestResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualHandleRequestResult.hasView());
    assertTrue(actualHandleRequestResult.isReference());
    assertSame(model, actualHandleRequestResult.getModelMap());
  }

  /**
   * Test
   * {@link BroadleafCategoryController#getExpectedTemplateName(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCategoryController#getExpectedTemplateName(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getExpectedTemplateName(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testGetExpectedTemplateName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.catalog;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.catalog.BroadleafCategoryController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass27 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.catalog.BroadleafCategoryController broadleafCategoryController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCategoryDeepLinkService") org.broadleafcommerce.common.web.deeplink.DeepLinkService<Lorg.broadleafcommerce.core.catalog.domain.Category;> deepLinkService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.SearchFacetDTOService searchFacetDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.SearchService searchService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blTemplateOverrideExtensionManager") org.broadleafcommerce.common.template.TemplateOverrideExtensionManager templateOverrideExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    broadleafCategoryController.getExpectedTemplateName(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  void testGetTemplateType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCategoryController broadleafCategoryController = new BroadleafCategoryController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    TemplateType actualTemplateType = broadleafCategoryController
        .getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertSame(actualTemplateType.CATEGORY, actualTemplateType);
  }

  /**
   * Test {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  void testGetTemplateType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCategoryController broadleafCategoryController = new BroadleafCategoryController();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);

    // Act
    TemplateType actualTemplateType = broadleafCategoryController
        .getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertSame(actualTemplateType.CATEGORY, actualTemplateType);
  }

  /**
   * Test {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testGetTemplateType3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.catalog;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.catalog.BroadleafCategoryController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass28 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.catalog.BroadleafCategoryController broadleafCategoryController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCategoryDeepLinkService") org.broadleafcommerce.common.web.deeplink.DeepLinkService<Lorg.broadleafcommerce.core.catalog.domain.Category;> deepLinkService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.SearchFacetDTOService searchFacetDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.SearchService searchService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blTemplateOverrideExtensionManager") org.broadleafcommerce.common.template.TemplateOverrideExtensionManager templateOverrideExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    broadleafCategoryController.getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafCategoryController}
   *   <li>{@link BroadleafCategoryController#getDefaultCategoryView()}
   *   <li>{@link BroadleafCategoryController#getSearchService()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafCategoryController actualBroadleafCategoryController = new BroadleafCategoryController();
    String actualDefaultCategoryView = actualBroadleafCategoryController.getDefaultCategoryView();

    // Assert
    assertEquals("catalog/category", actualDefaultCategoryView);
    assertNull(actualBroadleafCategoryController.getSearchService());
  }
}
