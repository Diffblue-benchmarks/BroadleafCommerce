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
package org.broadleafcommerce.core.web.order.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.order.service.OrderLockManager;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.web.order.security.exception.OrderLockAcquisitionFailureException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {CartStateFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CartStateFilterDiffblueTest {
  @Autowired
  private CartStateFilter cartStateFilter;

  @MockBean(name = "blCartStateRequestProcessor")
  private CartStateRequestProcessor cartStateRequestProcessor;

  @MockBean(name = "blOrderLockManager")
  private OrderLockManager orderLockManager;

  @MockBean(name = "blOrderService")
  private OrderService orderService;

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code blOrderLockManager} {@link OrderLockManager#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); given 'blOrderLockManager' isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored_givenBlOrderLockManagerIsActiveReturnFalse()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive()).thenReturn(false);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cartStateFilter.doFilterInternalUnlessIgnored(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(orderLockManager).isActive();
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); then calls doFilter(ServletRequest, ServletResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored_thenCallsDoFilter() throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive()).thenReturn(true);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cartStateFilter.doFilterInternalUnlessIgnored(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(orderLockManager).isActive();
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link OrderLockAcquisitionFailureException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); then throw OrderLockAcquisitionFailureException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored_thenThrowOrderLockAcquisitionFailureException()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive()).thenReturn(true);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doThrow(new OrderLockAcquisitionFailureException("An error occurred")).when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(OrderLockAcquisitionFailureException.class,
        () -> cartStateFilter.doFilterInternalUnlessIgnored(request, response, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(orderLockManager).isActive();
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <p>
   * Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(cartStateFilter
        .requestRequiresLock(new ServletRequestWrapper(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})))));
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <p>
   * Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock2() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);
    cartStateFilter.setExcludedOrderLockRequestPatterns(new ArrayList<>());

    MockHttpServletRequest req = new MockHttpServletRequest();
    req.setMethod("post");

    // Act
    boolean actualRequestRequiresLockResult = cartStateFilter.requestRequiresLock(req);

    // Assert
    verify(orderLockManager).isActive();
    assertTrue(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <ul>
   *   <li>Given {@code blOrderLockManager} {@link OrderLockManager#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); given 'blOrderLockManager' isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_givenBlOrderLockManagerIsActiveReturnFalse() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(false);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    boolean actualRequestRequiresLockResult = cartStateFilter
        .requestRequiresLock(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    verify(orderLockManager).isActive();
    assertFalse(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_thenReturnFalse() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    boolean actualRequestRequiresLockResult = cartStateFilter
        .requestRequiresLock(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    verify(orderLockManager).isActive();
    assertFalse(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_thenReturnTrue() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);
    cartStateFilter.setExcludedOrderLockRequestPatterns(null);

    MockHttpServletRequest req = new MockHttpServletRequest();
    req.setMethod("post");

    // Act
    boolean actualRequestRequiresLockResult = cartStateFilter.requestRequiresLock(req);

    // Assert
    verify(orderLockManager).isActive();
    assertTrue(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <ul>
   *   <li>Then throw {@link OrderLockAcquisitionFailureException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); then throw OrderLockAcquisitionFailureException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_thenThrowOrderLockAcquisitionFailureException() {
    // Arrange
    when(orderLockManager.isActive()).thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));
    cartStateFilter.setExcludedOrderLockRequestPatterns(null);

    MockHttpServletRequest req = new MockHttpServletRequest();
    req.setMethod("post");

    // Act and Assert
    assertThrows(OrderLockAcquisitionFailureException.class, () -> cartStateFilter.requestRequiresLock(req));
    verify(orderLockManager).isActive();
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <ul>
   *   <li>When {@link MockMultipartHttpServletRequest#MockMultipartHttpServletRequest()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); when MockMultipartHttpServletRequest(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_whenMockMultipartHttpServletRequest_thenReturnTrue() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);

    // Act
    boolean actualRequestRequiresLockResult = cartStateFilter
        .requestRequiresLock(new MockMultipartHttpServletRequest());

    // Assert
    verify(orderLockManager).isActive();
    assertTrue(actualRequestRequiresLockResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CartStateFilter#setExcludedOrderLockRequestPatterns(List)}
   *   <li>{@link CartStateFilter#getExcludedOrderLockRequestPatterns()}
   *   <li>{@link CartStateFilter#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CartStateFilter.getExcludedOrderLockRequestPatterns()", "int CartStateFilter.getOrder()",
      "void CartStateFilter.setExcludedOrderLockRequestPatterns(List)"})
  void testGettersAndSetters() {
    // Arrange
    CartStateFilter cartStateFilter = new CartStateFilter();
    ArrayList<String> excludedOrderLockRequestPatterns = new ArrayList<>();

    // Act
    cartStateFilter.setExcludedOrderLockRequestPatterns(excludedOrderLockRequestPatterns);
    List<String> actualExcludedOrderLockRequestPatterns = cartStateFilter.getExcludedOrderLockRequestPatterns();

    // Assert
    assertEquals(1000000, cartStateFilter.getOrder());
    assertTrue(actualExcludedOrderLockRequestPatterns.isEmpty());
    assertSame(excludedOrderLockRequestPatterns, actualExcludedOrderLockRequestPatterns);
  }

  /**
   * Test {@link CartStateFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test: {@link CartStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateFilter.shouldNotFilterErrorDispatch()"})
  void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(cartStateFilter.shouldNotFilterErrorDispatch());
  }
}
