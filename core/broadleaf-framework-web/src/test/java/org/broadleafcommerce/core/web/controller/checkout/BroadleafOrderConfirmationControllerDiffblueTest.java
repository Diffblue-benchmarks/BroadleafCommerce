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
package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafOrderConfirmationControllerDiffblueTest {
  /**
   * Method under test:
   * {@link BroadleafOrderConfirmationController#displayOrderConfirmationByOrderNumber(String, Model, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testDisplayOrderConfirmationByOrderNumber() {
    // Arrange
    BroadleafOrderConfirmationController broadleafOrderConfirmationController = new BroadleafOrderConfirmationController();
    ConcurrentModel model = new ConcurrentModel();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals("redirect:/", broadleafOrderConfirmationController.displayOrderConfirmationByOrderNumber("42", model,
        request, new MockHttpServletResponse()));
  }

  /**
   * Method under test:
   * {@link BroadleafOrderConfirmationController#displayOrderConfirmationByOrderNumber(String, Model, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testDisplayOrderConfirmationByOrderNumber2() {
    // Arrange
    BroadleafOrderConfirmationController broadleafOrderConfirmationController = new BroadleafOrderConfirmationController();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("ThreadLocalManager.notify.orphans", function);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    String actualDisplayOrderConfirmationByOrderNumberResult = broadleafOrderConfirmationController
        .displayOrderConfirmationByOrderNumber("42", model, request, new MockHttpServletResponse());

    // Assert
    verify(function).apply(eq("ThreadLocalManager.notify.orphans"));
    assertEquals("redirect:/", actualDisplayOrderConfirmationByOrderNumberResult);
  }

  /**
   * Method under test:
   * {@link BroadleafOrderConfirmationController#displayOrderConfirmationByOrderId(Long, Model, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testDisplayOrderConfirmationByOrderId() {
    // Arrange
    BroadleafOrderConfirmationController broadleafOrderConfirmationController = new BroadleafOrderConfirmationController();
    ConcurrentModel model = new ConcurrentModel();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals("redirect:/", broadleafOrderConfirmationController.displayOrderConfirmationByOrderId(1L, model,
        request, new MockHttpServletResponse()));
  }

  /**
   * Method under test:
   * {@link BroadleafOrderConfirmationController#displayOrderConfirmationByOrderId(Long, Model, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testDisplayOrderConfirmationByOrderId2() {
    // Arrange
    BroadleafOrderConfirmationController broadleafOrderConfirmationController = new BroadleafOrderConfirmationController();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("ThreadLocalManager.notify.orphans", function);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    String actualDisplayOrderConfirmationByOrderIdResult = broadleafOrderConfirmationController
        .displayOrderConfirmationByOrderId(1L, model, request, new MockHttpServletResponse());

    // Assert
    verify(function).apply(eq("ThreadLocalManager.notify.orphans"));
    assertEquals("redirect:/", actualDisplayOrderConfirmationByOrderIdResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafOrderConfirmationController}
   *   <li>{@link BroadleafOrderConfirmationController#getOrderConfirmationView()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("checkout/confirmation", (new BroadleafOrderConfirmationController()).getOrderConfirmationView());
  }
}
