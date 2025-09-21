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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.crossapp.service.CrossAppAuthService;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.MergeCartService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
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
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class CartStateRequestProcessorDiffblueTest {
  @InjectMocks private CartStateRequestProcessor cartStateRequestProcessor;

  @Mock private CrossAppAuthService crossAppAuthService;

  @Mock private CustomerStateRequestProcessor customerStateRequestProcessor;

  @Mock private MergeCartService mergeCartService;

  @Mock private OrderService orderService;

  /**
   * Test {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link MockHttpServletRequest#addParameter(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest,
   * Order)}
   */
  @Test
  @DisplayName(
      "Test updateCartRequestAttributes(WebRequest, Order); given HashMap(); then calls addParameter(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateRequestProcessor.updateCartRequestAttributes(WebRequest, Order)"
  })
  void testUpdateCartRequestAttributes_givenHashMap_thenCallsAddParameter()
      throws UnsupportedEncodingException {
    // Arrange
    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    when(servletRequest.getSession(anyBoolean())).thenReturn(new MockHttpSession());
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new HashMap<>());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter(CartStateRequestProcessor.BLC_RULE_MAP_PARAM, "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding(CartStateRequestProcessor.BLC_RULE_MAP_PARAM);
    request.setAttribute(CartStateRequestProcessor.BLC_RULE_MAP_PARAM, "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    ServletWebRequest request3 = new ServletWebRequest(request2);
    request3.setAttribute(CartStateRequestProcessor.BLC_RULE_MAP_PARAM, "Value", 1);

    // Act
    cartStateRequestProcessor.updateCartRequestAttributes(request3, new NullOrderImpl());

    // Assert
    verify(servletRequest).addParameter("blRuleMap", "42");
    verify(servletRequest).getAttribute("blRuleMap");
    verify(servletRequest).getSession(true);
    verify(servletRequest, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    verify(servletRequest).setCharacterEncoding("blRuleMap");
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertNull(cartStateRequestProcessor.getOverrideCart(new ServletWebRequest(request)));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart2() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getStatus()).thenReturn(new OrderStatus("SUBMITTED", "Friendly Type"));
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession(anyBoolean())).thenReturn(mockHttpSession);

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act
    Order actualOverrideCart = cartStateRequestProcessor.getOverrideCart(request2);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getSession(anyBoolean());
    verify(order).getStatus();
    verify(orderService).findOrderById(1L);
    verify(mockHttpSession).getAttribute("_blc_overrideCartId");
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    verify(mockHttpSession).setAttribute(eq("_blc_overrideCartId"), isA(Object.class));
    assertNull(actualOverrideCart);
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenFalse() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(false);
    when(request.getSession(anyBoolean())).thenReturn(new MockHttpSession());

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act
    Order actualOverrideCart = cartStateRequestProcessor.getOverrideCart(request2);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    verify(request).getSession(true);
    assertNull(actualOverrideCart);
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link Order} {@link Order#getStatus()} return {@link OrderStatus#CANCELLED}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getOverrideCart(WebRequest); given Order getStatus() return CANCELLED; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenOrderGetStatusReturnCancelled_thenReturnNull() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getStatus()).thenReturn(OrderStatus.CANCELLED);
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession(anyBoolean())).thenReturn(mockHttpSession);

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act
    Order actualOverrideCart = cartStateRequestProcessor.getOverrideCart(request2);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getSession(anyBoolean());
    verify(order, atLeast(1)).getStatus();
    verify(orderService).findOrderById(1L);
    verify(mockHttpSession).getAttribute("_blc_overrideCartId");
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    verify(mockHttpSession).setAttribute(eq("_blc_overrideCartId"), isA(Object.class));
    assertNull(actualOverrideCart);
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link Order} {@link Order#getStatus()} return {@link
   *       OrderStatus#OrderStatus(String, String)} with {@code Type} and {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getOverrideCart(WebRequest); given Order getStatus() return OrderStatus(String, String) with 'Type' and 'Friendly Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenOrderGetStatusReturnOrderStatusWithTypeAndFriendlyType() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getStatus()).thenReturn(new OrderStatus("Type", "Friendly Type"));
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession(anyBoolean())).thenReturn(mockHttpSession);

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act
    cartStateRequestProcessor.getOverrideCart(request2);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getSession(anyBoolean());
    verify(order, atLeast(1)).getStatus();
    verify(orderService).findOrderById(1L);
    verify(mockHttpSession).getAttribute("_blc_overrideCartId");
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    verify(mockHttpSession).setAttribute(eq("_blc_overrideCartId"), isA(Object.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link Order} {@link Order#getStatus()} return {@link OrderStatus#OrderStatus()}.
   *   <li>Then calls {@link Order#getStatus()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getOverrideCart(WebRequest); given Order getStatus() return OrderStatus(); then calls getStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenOrderGetStatusReturnOrderStatus_thenCallsGetStatus() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getStatus()).thenReturn(new OrderStatus());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession(anyBoolean())).thenReturn(mockHttpSession);

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act
    cartStateRequestProcessor.getOverrideCart(request2);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getSession(anyBoolean());
    verify(order, atLeast(1)).getStatus();
    verify(orderService).findOrderById(1L);
    verify(mockHttpSession).getAttribute("_blc_overrideCartId");
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    verify(mockHttpSession).setAttribute(eq("_blc_overrideCartId"), isA(Object.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link Order} {@link Order#getStatus()} return {@link OrderStatus}.
   *   <li>Then calls {@link Order#getStatus()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getOverrideCart(WebRequest); given Order getStatus() return OrderStatus; then calls getStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenOrderGetStatusReturnOrderStatus_thenCallsGetStatus2() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getStatus()).thenReturn(mock(OrderStatus.class));
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession(anyBoolean())).thenReturn(mockHttpSession);

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act
    cartStateRequestProcessor.getOverrideCart(request2);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getSession(anyBoolean());
    verify(order, atLeast(1)).getStatus();
    verify(orderService).findOrderById(1L);
    verify(mockHttpSession).getAttribute("_blc_overrideCartId");
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    verify(mockHttpSession).setAttribute(eq("_blc_overrideCartId"), isA(Object.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link Order} {@link Order#getStatus()} return {@link OrderStatus#SUBMITTED}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getOverrideCart(WebRequest); given Order getStatus() return SUBMITTED; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenOrderGetStatusReturnSubmitted_thenReturnNull() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getStatus()).thenReturn(OrderStatus.SUBMITTED);
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession(anyBoolean())).thenReturn(mockHttpSession);

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act
    Order actualOverrideCart = cartStateRequestProcessor.getOverrideCart(request2);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getSession(anyBoolean());
    verify(order).getStatus();
    verify(orderService).findOrderById(1L);
    verify(mockHttpSession).getAttribute("_blc_overrideCartId");
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    verify(mockHttpSession).setAttribute(eq("_blc_overrideCartId"), isA(Object.class));
    assertNull(actualOverrideCart);
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link Order} {@link Order#getStatus()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest); given Order getStatus() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenOrderGetStatusThrowRuntimeException() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getStatus()).thenThrow(new RuntimeException());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession(anyBoolean())).thenReturn(mockHttpSession);

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> cartStateRequestProcessor.getOverrideCart(request2));
    verify(request).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getSession(anyBoolean());
    verify(order).getStatus();
    verify(orderService).findOrderById(1L);
    verify(mockHttpSession).getAttribute("_blc_overrideCartId");
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    verify(mockHttpSession).setAttribute(eq("_blc_overrideCartId"), isA(Object.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getOverrideCart(WebRequest); given OrderService findOrderById(Long) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenOrderServiceFindOrderByIdReturnNull_thenReturnNull() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(null);

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession(anyBoolean())).thenReturn(mockHttpSession);

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act
    Order actualOverrideCart = cartStateRequestProcessor.getOverrideCart(request2);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getSession(anyBoolean());
    verify(orderService).findOrderById(1L);
    verify(mockHttpSession).getAttribute("_blc_overrideCartId");
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    verify(mockHttpSession).setAttribute(eq("_blc_overrideCartId"), isA(Object.class));
    assertNull(actualOverrideCart);
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getOverrideCart(WebRequest); given OrderService findOrderById(Long) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenOrderServiceFindOrderByIdThrowRuntimeException() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException());

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession(anyBoolean())).thenReturn(mockHttpSession);

    ServletWebRequest request2 = new ServletWebRequest(request);
    request2.setAttribute(CartStateRequestProcessor.OVERRIDE_CART_ATTR_NAME, "Value", 1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> cartStateRequestProcessor.getOverrideCart(request2));
    verify(request).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getSession(anyBoolean());
    verify(orderService).findOrderById(1L);
    verify(mockHttpSession).getAttribute("_blc_overrideCartId");
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    verify(mockHttpSession).setAttribute(eq("_blc_overrideCartId"), isA(Object.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    CustomerImpl customer = new CustomerImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    boolean actualMergeCartNeededResult =
        cartStateRequestProcessor.mergeCartNeeded(customer, new ServletWebRequest(request));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertFalse(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded2() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> cartStateRequestProcessor.mergeCartNeeded(customer, new ServletWebRequest(request)));
    verify(crossAppAuthService).isAuthedFromAdmin();
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded3() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> cartStateRequestProcessor.mergeCartNeeded(customer, new ServletWebRequest(request)));
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName(
      "Test mergeCartNeeded(Customer, WebRequest); given Auditable (default constructor) CreatedBy is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded_givenAuditableCreatedByIsOne_thenReturnTrue() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setId(1L);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    boolean actualMergeCartNeededResult =
        cartStateRequestProcessor.mergeCartNeeded(customer, new ServletWebRequest(request));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertTrue(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded_thenReturnFalse() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    CustomerImpl customer = new CustomerImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    boolean actualMergeCartNeededResult =
        cartStateRequestProcessor.mergeCartNeeded(customer, new ServletWebRequest(request));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertFalse(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCart(Customer, WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart() {
    // Arrange
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> cartStateRequestProcessor.mergeCart(customer, new ServletWebRequest(request)));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link WebRequest} {@link WebRequest#getAttribute(String, int)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName(
      "Test mergeCart(Customer, WebRequest); given 'false'; when WebRequest getAttribute(String, int) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart_givenFalse_whenWebRequestGetAttributeReturnFalse()
      throws RemoveFromCartException, PricingException {
    // Arrange
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
    CustomerImpl customer = new CustomerImpl();

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Order actualMergeCartResult = cartStateRequestProcessor.mergeCart(customer, request);

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    verify(request).getAttribute("blOkToUseSession", 0);
    assertTrue(actualMergeCartResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeCartResult.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, actualMergeCartResult.getSubTotal());
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findCartForCustomer(Customer)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName(
      "Test mergeCart(Customer, WebRequest); given OrderService findCartForCustomer(Customer) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart_givenOrderServiceFindCartForCustomerThrowRuntimeException() {
    // Arrange
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(orderService.findCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> cartStateRequestProcessor.mergeCart(customer, new ServletWebRequest(request)));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link WebRequest#removeAttribute(String, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName(
      "Test mergeCart(Customer, WebRequest); given 'true'; then calls removeAttribute(String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart_givenTrue_thenCallsRemoveAttribute()
      throws RemoveFromCartException, PricingException {
    // Arrange
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
    CustomerImpl customer = new CustomerImpl();

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).removeAttribute(Mockito.<String>any(), anyInt());

    // Act
    Order actualMergeCartResult = cartStateRequestProcessor.mergeCart(customer, request);

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request, atLeast(1)).removeAttribute(Mockito.<String>any(), eq(1));
    assertTrue(actualMergeCartResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeCartResult.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, actualMergeCartResult.getSubTotal());
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCart(Customer, WebRequest); then return NullOrderImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart_thenReturnNullOrderImpl() throws RemoveFromCartException, PricingException {
    // Arrange
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
    CustomerImpl customer = new CustomerImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    Order actualMergeCartResult =
        cartStateRequestProcessor.mergeCart(customer, new ServletWebRequest(request));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertTrue(actualMergeCartResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeCartResult.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, actualMergeCartResult.getSubTotal());
  }
}
