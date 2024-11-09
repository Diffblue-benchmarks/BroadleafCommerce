/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.Mockito.mock;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

class BroadleafCategoryControllerDiffblueTest {
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
