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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.function.Function;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.search.service.SearchService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafSearchControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafSearchController#search(Model, HttpServletRequest, HttpServletResponse, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code redirect:http://localhost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSearchController#search(Model, HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test search(Model, HttpServletRequest, HttpServletResponse, String); given '42'; then return 'redirect:http://localhost'")
  void testSearch_given42_thenReturnRedirectHttpLocalhost() throws IOException, ServletException, ServiceException {
    // Arrange
    BroadleafSearchController broadleafSearchController = new BroadleafSearchController();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("facetField", function);

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("facetField", "42");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    String actualSearchResult = broadleafSearchController.search(model, request, new MockHttpServletResponse(),
        "Query");

    // Assert
    verify(function).apply(eq("facetField"));
    assertEquals("redirect:http://localhost", actualSearchResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafSearchController}
   *   <li>{@link BroadleafSearchController#getSearchService()}
   *   <li>{@link BroadleafSearchController#getSearchView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafSearchController actualBroadleafSearchController = new BroadleafSearchController();
    SearchService actualSearchService = actualBroadleafSearchController.getSearchService();

    // Assert
    assertEquals("catalog/search", actualBroadleafSearchController.getSearchView());
    assertNull(actualSearchService);
  }
}
