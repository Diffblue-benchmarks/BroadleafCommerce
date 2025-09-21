/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.servlet.ModelAndView;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class BroadleafCategoryControllerDiffblueTest {
  @InjectMocks private BroadleafCategoryController broadleafCategoryController;

  /**
   * Test {@link BroadleafCategoryController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link BroadleafCategoryController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName("Test handleRequest(HttpServletRequest, HttpServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafCategoryController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  void testHandleRequest() throws Exception {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("facetField", "42");
    servletRequest.addParameter("https://example.org/example", "https://example.org/example");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest));

    // Act
    ModelAndView actualHandleRequestResult =
        broadleafCategoryController.handleRequest(request, new MockHttpServletResponse());

    // Assert
    assertEquals(
        "redirect:http://localhost?https%3A%2F%2Fexample.org%2Fexample=https%3A%2F%2Fexample.org%2Fexample",
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
  @DisplayName(
      "Test handleRequest(HttpServletRequest, HttpServletResponse); then return ViewName is 'redirect:http://localhost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafCategoryController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  void testHandleRequest_thenReturnViewNameIsRedirectHttpLocalhost() throws Exception {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("facetField", "https://example.org/example");
    servletRequest.addParameter("https://example.org/example", "https://example.org/example");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest));

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
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TemplateType BroadleafCategoryController.getTemplateType(HttpServletRequest)"
  })
  void testGetTemplateType() {
    // Arrange, Act and Assert
    assertSame(
        TemplateType.CATEGORY,
        broadleafCategoryController.getTemplateType(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()))));
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCategoryController.<init>()",
    "String BroadleafCategoryController.getDefaultCategoryView()",
    "org.broadleafcommerce.core.search.service.SearchService BroadleafCategoryController.getSearchService()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafCategoryController actualBroadleafCategoryController =
        new BroadleafCategoryController();
    String actualDefaultCategoryView = actualBroadleafCategoryController.getDefaultCategoryView();

    // Assert
    assertEquals("catalog/category", actualDefaultCategoryView);
    assertNull(actualBroadleafCategoryController.getSearchService());
  }
}
