package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.search.service.SearchService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class BroadleafSearchControllerDiffblueTest {
  /**
   * Test {@link BroadleafSearchController#search(Model, HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return {@code redirect:http://localhost?=}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSearchController#search(Model, HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSearchController.search(Model, HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSearch_givenEmptyString_thenReturnRedirectHttpLocalhost()
      throws IOException, ServletException, ServiceException {
    // Arrange
    BroadleafSearchController broadleafSearchController = new BroadleafSearchController();
    ConcurrentModel model = new ConcurrentModel();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("", "");
    request.addParameter("facetField", "42");

    // Act and Assert
    assertEquals(
        "redirect:http://localhost?=",
        broadleafSearchController.search(model, request, new MockHttpServletResponse(), "Query"));
  }

  /**
   * Test {@link BroadleafSearchController#search(Model, HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code Request}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSearchController#search(Model, HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSearchController.search(Model, HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSearch_givenRequest() throws IOException, ServletException, ServiceException {
    // Arrange
    BroadleafSearchController broadleafSearchController = new BroadleafSearchController();
    ConcurrentModel model = new ConcurrentModel();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("facetField", "Request");

    // Act and Assert
    assertEquals(
        "redirect:http://localhost",
        broadleafSearchController.search(
            model, request, new MockHttpServletResponse(), "not empty"));
  }

  /**
   * Test {@link BroadleafSearchController#search(Model, HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code
   *       facetField} and {@code facetField}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSearchController#search(Model, HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSearchController.search(Model, HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSearch_whenMockHttpServletRequestAddParameterFacetFieldAndFacetField()
      throws IOException, ServletException, ServiceException {
    // Arrange
    BroadleafSearchController broadleafSearchController = new BroadleafSearchController();
    ConcurrentModel model = new ConcurrentModel();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("facetField", "facetField");

    // Act and Assert
    assertEquals(
        "redirect:http://localhost",
        broadleafSearchController.search(
            model, request, new MockHttpServletResponse(), "not empty"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafSearchController}
   *   <li>{@link BroadleafSearchController#getSearchService()}
   *   <li>{@link BroadleafSearchController#getSearchView()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafSearchController.<init>()",
    "SearchService BroadleafSearchController.getSearchService()",
    "String BroadleafSearchController.getSearchView()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafSearchController actualBroadleafSearchController = new BroadleafSearchController();
    SearchService actualSearchService = actualBroadleafSearchController.getSearchService();

    // Assert
    assertEquals("catalog/search", actualBroadleafSearchController.getSearchView());
    assertNull(actualSearchService);
  }
}
