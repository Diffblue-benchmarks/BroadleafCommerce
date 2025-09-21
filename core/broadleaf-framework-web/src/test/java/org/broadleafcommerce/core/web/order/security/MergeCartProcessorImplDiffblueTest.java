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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.MergeCartService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class MergeCartProcessorImplDiffblueTest {
  @Mock private CustomerService customerService;

  @Mock private CustomerStateRequestProcessor customerStateRequestProcessor;

  @InjectMocks private MergeCartProcessorImpl mergeCartProcessorImpl;

  @Mock private MergeCartService mergeCartService;

  @Mock private OrderService orderService;

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request},
   * {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request2, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(customerService).readCustomerByUsername("Principal");
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request},
   * {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult2() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenReturn(mergeCartResponse);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    mergeCartProcessorImpl.execute(
        request2, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    Object sessionMutex = request2.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(
        new String[] {"bl_merge_cart_response"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request},
   * {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult3() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(orderService.findCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request2, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request},
   * {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult4() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new PricingException("An error occurred"));
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request2, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request},
   * {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult5() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new RuntimeException());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request2, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request},
   * {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult6() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new RemoveFromCartException("An error occurred"));
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request2, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request},
   * {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  void testExecuteWithRequestAuthResult7() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(null);

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenReturn(mergeCartResponse);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    mergeCartProcessorImpl.execute(
        request2, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isNull());
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    Object sessionMutex = request2.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(
        new String[] {"bl_merge_cart_response"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse,
   * Authentication)} with {@code request}, {@code response}, {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName(
      "Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  void testExecuteWithRequestResponseAuthResult() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, response, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(customerService).readCustomerByUsername("Principal");
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse,
   * Authentication)} with {@code request}, {@code response}, {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName(
      "Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  void testExecuteWithRequestResponseAuthResult2()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenReturn(mergeCartResponse);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    mergeCartProcessorImpl.execute(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertArrayEquals(new String[] {"bl_merge_cart_response"}, session.getValueNames());
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse,
   * Authentication)} with {@code request}, {@code response}, {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName(
      "Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  void testExecuteWithRequestResponseAuthResult3() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(orderService.findCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, response, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse,
   * Authentication)} with {@code request}, {@code response}, {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName(
      "Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  void testExecuteWithRequestResponseAuthResult4()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new PricingException("An error occurred"));
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, response, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse,
   * Authentication)} with {@code request}, {@code response}, {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName(
      "Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  void testExecuteWithRequestResponseAuthResult5()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new RuntimeException());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, response, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse,
   * Authentication)} with {@code request}, {@code response}, {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName(
      "Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  void testExecuteWithRequestResponseAuthResult6()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new RemoveFromCartException("An error occurred"));
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, response, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse,
   * Authentication)} with {@code request}, {@code response}, {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName(
      "Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  void testExecuteWithRequestResponseAuthResult7()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(null);

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenReturn(mergeCartResponse);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    mergeCartProcessorImpl.execute(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isNull());
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertArrayEquals(new String[] {"bl_merge_cart_response"}, session.getValueNames());
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse,
   * Authentication)} with {@code request}, {@code response}, {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName(
      "Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  void testExecuteWithRequestResponseAuthResult8() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenThrow(new RuntimeException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    LinkedMultiValueMap<String, MultipartFile> mpFiles = new LinkedMultiValueMap<>();
    HashMap<String, String[]> mpParams = new HashMap<>();

    DefaultMultipartHttpServletRequest request2 =
        new DefaultMultipartHttpServletRequest(request, mpFiles, mpParams, new HashMap<>());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request2, response, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MergeCartProcessorImpl#setMergeCartResponseKey(String)}
   *   <li>{@link MergeCartProcessorImpl#getMergeCartResponseKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MergeCartProcessorImpl.getMergeCartResponseKey()",
    "void MergeCartProcessorImpl.setMergeCartResponseKey(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    MergeCartProcessorImpl mergeCartProcessorImpl = new MergeCartProcessorImpl();

    // Act
    mergeCartProcessorImpl.setMergeCartResponseKey("Merge Cart Response Key");

    // Assert
    assertEquals("Merge Cart Response Key", mergeCartProcessorImpl.getMergeCartResponseKey());
  }
}
