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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.crossapp.service.CrossAppAuthService;
import org.broadleafcommerce.common.money.Money;
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
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ExtendWith(MockitoExtension.class)
class CartStateRequestProcessorDiffblueTest {
  @InjectMocks
  private CartStateRequestProcessor cartStateRequestProcessor;

  @Mock
  private CustomerStateRequestProcessor customerStateRequestProcessor;

  @Mock
  private MergeCartService mergeCartService;

  @Mock
  private OrderService orderService;

  @Mock
  private CrossAppAuthService crossAppAuthService;

  /**
   * Test {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}
   */
  @Test
  @DisplayName("Test updateCartRequestAttributes(WebRequest, Order); given HashMap(); then calls getAttribute(String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CartStateRequestProcessor.updateCartRequestAttributes(WebRequest, Order)"})
  void testUpdateCartRequestAttributes_givenHashMap_thenCallsGetAttribute() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(new HashMap<>());
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    cartStateRequestProcessor.updateCartRequestAttributes(request, new NullOrderImpl());

    // Assert
    verify(request).getAttribute(eq("blRuleMap"), eq(0));
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(0));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   * <p>
   * Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull(cartStateRequestProcessor
        .getOverrideCart(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})))));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest); given 'false'; then calls getAttribute(String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  void testGetOverrideCart_givenFalse_thenCallsGetAttribute() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Order actualOverrideCart = cartStateRequestProcessor.getOverrideCart(request);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    assertNull(actualOverrideCart);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    CustomerImpl customer = new CustomerImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    boolean actualMergeCartNeededResult = cartStateRequestProcessor.mergeCartNeeded(customer,
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertFalse(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded2() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(null);
    CustomerImpl customer = new CustomerImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    boolean actualMergeCartNeededResult = cartStateRequestProcessor.mergeCartNeeded(customer,
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertFalse(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   * <ul>
   *   <li>Given {@code blCrossAppAuthService} {@link CrossAppAuthService#isAuthedFromAdmin()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest); given 'blCrossAppAuthService' isAuthedFromAdmin() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded_givenBlCrossAppAuthServiceIsAuthedFromAdminReturnTrue() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    CustomerImpl customer = new CustomerImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    boolean actualMergeCartNeededResult = cartStateRequestProcessor.mergeCartNeeded(customer,
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertFalse(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getId()} return one.</li>
   *   <li>Then calls {@link CustomerImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest); given CustomerImpl getId() return one; then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded_givenCustomerImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(customerImpl);
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    boolean actualMergeCartNeededResult = cartStateRequestProcessor.mergeCartNeeded(customer,
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerImpl).getId();
    verify(customer, atLeast(1)).getId();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertFalse(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getId()} return one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest); given one; when CustomerImpl getId() return one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  void testMergeCartNeeded_givenOne_whenCustomerImplGetIdReturnOne_thenReturnTrue() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    boolean actualMergeCartNeededResult = cartStateRequestProcessor.mergeCartNeeded(customer,
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customer, atLeast(1)).getId();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertTrue(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCart(Customer, WebRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart() {
    // Arrange
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    when(orderService.findCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException("_blc_anonymousCustomer"));
    CustomerImpl customer = new CustomerImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> cartStateRequestProcessor.mergeCart(customer,
            new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
                new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})))));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link WebRequest} {@link RequestAttributes#getAttribute(String, int)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCart(Customer, WebRequest); given 'false'; when WebRequest getAttribute(String, int) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart_givenFalse_whenWebRequestGetAttributeReturnFalse()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    MergeCartResponse mergeCartResponse = mock(MergeCartResponse.class);
    when(mergeCartResponse.getOrder()).thenReturn(new NullOrderImpl());
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
    CustomerImpl customer = new CustomerImpl();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Order actualMergeCartResult = cartStateRequestProcessor.mergeCart(customer, request);

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(mergeCartResponse).getOrder();
    verify(mergeCartResponse).setAddedItems(isA(List.class));
    verify(mergeCartResponse).setMerged(eq(true));
    verify(mergeCartResponse).setOrder(isA(Order.class));
    verify(mergeCartResponse).setRemovedItems(isA(List.class));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    assertTrue(actualMergeCartResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeCartResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualMergeCartResult.getSubTotal());
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   * <ul>
   *   <li>Given {@link MergeCartResponse} (default constructor) AddedItems is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCart(Customer, WebRequest); given MergeCartResponse (default constructor) AddedItems is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart_givenMergeCartResponseAddedItemsIsArrayList() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any())).thenReturn(mergeCartResponse);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    CustomerImpl customer = new CustomerImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    Order actualMergeCartResult = cartStateRequestProcessor.mergeCart(customer,
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertTrue(actualMergeCartResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeCartResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualMergeCartResult.getSubTotal());
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   * <ul>
   *   <li>Given {@link MergeCartResponse} {@link MergeCartResponse#getOrder()} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCart(Customer, WebRequest); given MergeCartResponse getOrder() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart_givenMergeCartResponseGetOrderThrowRuntimeExceptionWithFoo()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    MergeCartResponse mergeCartResponse = mock(MergeCartResponse.class);
    when(mergeCartResponse.getOrder()).thenThrow(new RuntimeException("foo"));
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
    CustomerImpl customer = new CustomerImpl();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).removeAttribute(Mockito.<String>any(), anyInt());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> cartStateRequestProcessor.mergeCart(customer, request));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(mergeCartResponse).getOrder();
    verify(mergeCartResponse).setAddedItems(isA(List.class));
    verify(mergeCartResponse).setMerged(eq(true));
    verify(mergeCartResponse).setOrder(isA(Order.class));
    verify(mergeCartResponse).setRemovedItems(isA(List.class));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request, atLeast(1)).removeAttribute(Mockito.<String>any(), eq(1));
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   * <ul>
   *   <li>Then calls {@link RequestAttributes#removeAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCart(Customer, WebRequest); then calls removeAttribute(String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  void testMergeCart_thenCallsRemoveAttribute() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any())).thenReturn(new CustomerImpl());
    MergeCartResponse mergeCartResponse = mock(MergeCartResponse.class);
    when(mergeCartResponse.getOrder()).thenReturn(new NullOrderImpl());
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
    CustomerImpl customer = new CustomerImpl();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).removeAttribute(Mockito.<String>any(), anyInt());

    // Act
    Order actualMergeCartResult = cartStateRequestProcessor.mergeCart(customer, request);

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(mergeCartResponse).getOrder();
    verify(mergeCartResponse).setAddedItems(isA(List.class));
    verify(mergeCartResponse).setMerged(eq(true));
    verify(mergeCartResponse).setOrder(isA(Order.class));
    verify(mergeCartResponse).setRemovedItems(isA(List.class));
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request, atLeast(1)).removeAttribute(Mockito.<String>any(), eq(1));
    assertTrue(actualMergeCartResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeCartResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualMergeCartResult.getSubTotal());
  }
}
