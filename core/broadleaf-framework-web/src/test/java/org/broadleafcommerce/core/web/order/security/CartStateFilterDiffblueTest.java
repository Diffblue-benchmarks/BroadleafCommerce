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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.order.service.OrderLockManager;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.web.order.security.exception.OrderLockAcquisitionFailureException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {CartStateFilter.class})
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class CartStateFilterDiffblueTest {
  @Autowired private CartStateFilter cartStateFilter;

  @MockBean(name = "blCartStateRequestProcessor")
  private CartStateRequestProcessor cartStateRequestProcessor;

  @MockBean(name = "blOrderLockManager")
  private OrderLockManager orderLockManager;

  @MockBean(name = "blOrderService")
  private OrderService orderService;

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // Arrange
    doThrow(new OrderLockAcquisitionFailureException("An error occurred"))
        .when(cartStateRequestProcessor)
        .process(Mockito.<WebRequest>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () ->
            cartStateFilter.doFilterInternalUnlessIgnored(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive())
        .thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () ->
            cartStateFilter.doFilterInternalUnlessIgnored(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(orderLockManager).isActive();
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored3() throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new OrderLockAcquisitionFailureException("An error occurred"))
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () -> cartStateFilter.doFilterInternalUnlessIgnored(request, response, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(orderLockManager).isActive();
    verify(cartStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored4() throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive()).thenReturn(false);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
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
   * Test {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); then calls doFilter(ServletRequest, ServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored_thenCallsDoFilter() throws IOException, ServletException {
    // Arrange
    doNothing().when(cartStateRequestProcessor).process(Mockito.<WebRequest>any());
    when(orderLockManager.isActive()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
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
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock() {
    // Arrange
    when(orderLockManager.isActive())
        .thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () ->
            cartStateFilter.requestRequiresLock(
                new HttpServletRequestWrapper(
                    new SearchRequestWrapper(new MockHttpServletRequest()))));
    verify(orderLockManager).isActive();
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>Given Bean Name{blOrderLockManager}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); given Bean Name{blOrderLockManager}")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_givenBeanNameBlOrderLockManager() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertFalse(cartStateFilter.requestRequiresLock(new ServletRequestWrapper(request)));
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>Given Bean Name{blOrderLockManager} {@link OrderLockManager#isActive()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName(
      "Test requestRequiresLock(ServletRequest); given Bean Name{blOrderLockManager} isActive() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_givenBeanNameBlOrderLockManagerIsActiveReturnFalse() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(false);

    // Act
    boolean actualRequestRequiresLockResult =
        cartStateFilter.requestRequiresLock(mock(DefaultMultipartHttpServletRequest.class));

    // Assert
    verify(orderLockManager).isActive();
    assertFalse(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getMethod()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); then calls getMethod()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_thenCallsGetMethod() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);

    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getMethod())
        .thenThrow(new OrderLockAcquisitionFailureException("An error occurred"));
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);

    // Act and Assert
    assertThrows(
        OrderLockAcquisitionFailureException.class,
        () -> cartStateFilter.requestRequiresLock(new HttpServletRequestWrapper(request)));
    verify(servletRequest).getMethod();
    verify(orderLockManager).isActive();
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_thenReturnFalse() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);

    // Act
    boolean actualRequestRequiresLockResult =
        cartStateFilter.requestRequiresLock(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(orderLockManager).isActive();
    assertFalse(actualRequestRequiresLockResult);
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.requestRequiresLock(ServletRequest)"})
  void testRequestRequiresLock_thenReturnTrue() {
    // Arrange
    when(orderLockManager.isActive()).thenReturn(true);

    // Act
    boolean actualRequestRequiresLockResult =
        cartStateFilter.requestRequiresLock(
            new HttpServletRequestWrapper(
                new SearchRequestWrapper(new MockMultipartHttpServletRequest())));

    // Assert
    verify(orderLockManager).isActive();
    assertTrue(actualRequestRequiresLockResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CartStateFilter#setExcludedOrderLockRequestPatterns(List)}
   *   <li>{@link CartStateFilter#getExcludedOrderLockRequestPatterns()}
   *   <li>{@link CartStateFilter#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CartStateFilter.getExcludedOrderLockRequestPatterns()",
    "int CartStateFilter.getOrder()",
    "void CartStateFilter.setExcludedOrderLockRequestPatterns(List)"
  })
  void testGettersAndSetters() {
    // Arrange
    CartStateFilter cartStateFilter = new CartStateFilter();
    ArrayList<String> excludedOrderLockRequestPatterns = new ArrayList<>();

    // Act
    cartStateFilter.setExcludedOrderLockRequestPatterns(excludedOrderLockRequestPatterns);
    List<String> actualExcludedOrderLockRequestPatterns =
        cartStateFilter.getExcludedOrderLockRequestPatterns();

    // Assert
    assertEquals(1000000, cartStateFilter.getOrder());
    assertTrue(actualExcludedOrderLockRequestPatterns.isEmpty());
    assertSame(excludedOrderLockRequestPatterns, actualExcludedOrderLockRequestPatterns);
  }

  /**
   * Test {@link CartStateFilter#shouldNotFilterErrorDispatch()}.
   *
   * <p>Method under test: {@link CartStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateFilter.shouldNotFilterErrorDispatch()"})
  void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(cartStateFilter.shouldNotFilterErrorDispatch());
  }
}
