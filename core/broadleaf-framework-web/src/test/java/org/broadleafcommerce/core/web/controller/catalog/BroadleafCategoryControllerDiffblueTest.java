package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.template.TemplateType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.servlet.ModelAndView;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BroadleafCategoryControllerDiffblueTest {
  /**
   * Test {@link BroadleafCategoryController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return ViewName is {@code redirect:http://localhost?Name=42}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCategoryController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafCategoryController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequest_givenName_thenReturnViewNameIsRedirectHttpLocalhostName42()
      throws Exception {
    // Arrange
    BroadleafCategoryController broadleafCategoryController = new BroadleafCategoryController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("facetField", "42");
    request.addParameter("Name", "42");
    request.addParameters(new HashMap<>());

    // Act
    ModelAndView actualHandleRequestResult =
        broadleafCategoryController.handleRequest(request, new MockHttpServletResponse());

    // Assert
    assertEquals("redirect:http://localhost?Name=42", actualHandleRequestResult.getViewName());
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
   * Test {@link BroadleafCategoryController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return ViewName is {@code redirect:http://localhost}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCategoryController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafCategoryController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequest_thenReturnViewNameIsRedirectHttpLocalhost() throws Exception {
    // Arrange
    BroadleafCategoryController broadleafCategoryController = new BroadleafCategoryController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("facetField", "42");

    // Act
    ModelAndView actualHandleRequestResult =
        broadleafCategoryController.handleRequest(request, new MockHttpServletResponse());

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
   * Test {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TemplateType BroadleafCategoryController.getTemplateType(HttpServletRequest)"
  })
  public void testGetTemplateType() {
    // Arrange
    BroadleafCategoryController broadleafCategoryController = new BroadleafCategoryController();

    // Act and Assert
    assertSame(
        TemplateType.CATEGORY,
        broadleafCategoryController.getTemplateType(new MockHttpServletRequest()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafCategoryController}
   *   <li>{@link BroadleafCategoryController#getDefaultCategoryView()}
   *   <li>{@link BroadleafCategoryController#getSearchService()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCategoryController.<init>()",
    "String BroadleafCategoryController.getDefaultCategoryView()",
    "org.broadleafcommerce.core.search.service.SearchService BroadleafCategoryController.getSearchService()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafCategoryController actualBroadleafCategoryController =
        new BroadleafCategoryController();
    String actualDefaultCategoryView = actualBroadleafCategoryController.getDefaultCategoryView();

    // Assert
    assertEquals("catalog/category", actualDefaultCategoryView);
    assertNull(actualBroadleafCategoryController.getSearchService());
  }
}
