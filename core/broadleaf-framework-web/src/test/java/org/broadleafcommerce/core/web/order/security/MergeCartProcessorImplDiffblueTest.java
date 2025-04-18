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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.MergeCartService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ExtendWith(MockitoExtension.class)
class MergeCartProcessorImplDiffblueTest {
  @Mock
  private CustomerService customerService;

  @Mock
  private CustomerStateRequestProcessor customerStateRequestProcessor;

  @InjectMocks
  private MergeCartProcessorImpl mergeCartProcessorImpl;

  @Mock
  private MergeCartService mergeCartService;

  @Mock
  private OrderService orderService;

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request}, {@code authResult}.
   * <p>
   * Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any())).thenReturn(mergeCartResponse);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    mergeCartProcessorImpl.execute(request, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername(eq("Principal"));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{"bl_merge_cart_response"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request}, {@code authResult}.
   * <p>
   * Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult2() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(null);

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any())).thenReturn(mergeCartResponse);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    mergeCartProcessorImpl.execute(request, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isNull());
    verify(customerService).readCustomerByUsername(eq("Principal"));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{"bl_merge_cart_response"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request}, {@code authResult}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult_givenFalse() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    MergeCartResponse mergeCartResponse = mock(MergeCartResponse.class);
    doNothing().when(mergeCartResponse).setAddedItems(Mockito.<List<OrderItem>>any());
    doNothing().when(mergeCartResponse).setMerged(anyBoolean());
    doNothing().when(mergeCartResponse).setOrder(Mockito.<Order>any());
    doNothing().when(mergeCartResponse).setRemovedItems(Mockito.<List<OrderItem>>any());
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any())).thenReturn(mergeCartResponse);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    mergeCartProcessorImpl.execute(request, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(mergeCartResponse).setAddedItems(isA(List.class));
    verify(mergeCartResponse).setMerged(eq(true));
    verify(mergeCartResponse).setOrder(isA(Order.class));
    verify(mergeCartResponse).setRemovedItems(isA(List.class));
    verify(customerService).readCustomerByUsername(eq("Principal"));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request}, {@code authResult}.
   * <ul>
   *   <li>Given {@link MergeCartService}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'; given MergeCartService; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult_givenMergeCartService_thenThrowRuntimeException() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException("foo"));
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> mergeCartProcessorImpl.execute(request, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername(eq("Principal"));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request}, {@code authResult}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link RequestAttributes#setAttribute(String, Object, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'; given 'true'; then calls setAttribute(String, Object, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult_givenTrue_thenCallsSetAttribute()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    MergeCartResponse mergeCartResponse = mock(MergeCartResponse.class);
    doNothing().when(mergeCartResponse).setAddedItems(Mockito.<List<OrderItem>>any());
    doNothing().when(mergeCartResponse).setMerged(anyBoolean());
    doNothing().when(mergeCartResponse).setOrder(Mockito.<Order>any());
    doNothing().when(mergeCartResponse).setRemovedItems(Mockito.<List<OrderItem>>any());
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any())).thenReturn(mergeCartResponse);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    mergeCartProcessorImpl.execute(request, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(mergeCartResponse).setAddedItems(isA(List.class));
    verify(mergeCartResponse).setMerged(eq(true));
    verify(mergeCartResponse).setOrder(isA(Order.class));
    verify(mergeCartResponse).setRemovedItems(isA(List.class));
    verify(customerService).readCustomerByUsername(eq("Principal"));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request).setAttribute(eq("bl_merge_cart_response"), isA(Object.class), eq(1));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse, Authentication)} with {@code request}, {@code response}, {@code authResult}.
   * <p>
   * Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName("Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"})
  void testExecuteWithRequestResponseAuthResult() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any())).thenReturn(mergeCartResponse);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    mergeCartProcessorImpl.execute(request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername(eq("Principal"));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertArrayEquals(new String[]{"bl_merge_cart_response"}, session.getValueNames());
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse, Authentication)} with {@code request}, {@code response}, {@code authResult}.
   * <p>
   * Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName("Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"})
  void testExecuteWithRequestResponseAuthResult2() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(null);

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any())).thenReturn(mergeCartResponse);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    mergeCartProcessorImpl.execute(request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isNull());
    verify(customerService).readCustomerByUsername(eq("Principal"));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertArrayEquals(new String[]{"bl_merge_cart_response"}, session.getValueNames());
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse, Authentication)} with {@code request}, {@code response}, {@code authResult}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName("Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"})
  void testExecuteWithRequestResponseAuthResult_thenThrowRuntimeException() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException("foo"));
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mergeCartProcessorImpl.execute(request, response,
        new TestingAuthenticationToken("Principal", "Credentials")));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername(eq("Principal"));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MergeCartProcessorImpl#setMergeCartResponseKey(String)}
   *   <li>{@link MergeCartProcessorImpl#getMergeCartResponseKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MergeCartProcessorImpl.getMergeCartResponseKey()",
      "void MergeCartProcessorImpl.setMergeCartResponseKey(String)"})
  void testGettersAndSetters() {
    // Arrange
    MergeCartProcessorImpl mergeCartProcessorImpl = new MergeCartProcessorImpl();

    // Act
    mergeCartProcessorImpl.setMergeCartResponseKey("Merge Cart Response Key");

    // Assert
    assertEquals("Merge Cart Response Key", mergeCartProcessorImpl.getMergeCartResponseKey());
  }
}
