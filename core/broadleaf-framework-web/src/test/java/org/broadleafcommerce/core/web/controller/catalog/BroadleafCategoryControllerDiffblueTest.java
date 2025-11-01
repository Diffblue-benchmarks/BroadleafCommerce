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
import static org.mockito.Mockito.mock;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

class BroadleafCategoryControllerDiffblueTest {
  /**
   * Method under test:
   * {@link BroadleafCategoryController#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
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
   * Method under test:
   * {@link BroadleafCategoryController#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testHandleRequest2() throws Exception {
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
   * Method under test:
   * {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}
   */
  @Test
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
   * Method under test:
   * {@link BroadleafCategoryController#getTemplateType(HttpServletRequest)}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafCategoryController}
   *   <li>{@link BroadleafCategoryController#getDefaultCategoryView()}
   *   <li>{@link BroadleafCategoryController#getSearchService()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafCategoryController actualBroadleafCategoryController = new BroadleafCategoryController();
    String actualDefaultCategoryView = actualBroadleafCategoryController.getDefaultCategoryView();

    // Assert
    assertEquals("catalog/category", actualDefaultCategoryView);
    assertNull(actualBroadleafCategoryController.getSearchService());
  }
}
