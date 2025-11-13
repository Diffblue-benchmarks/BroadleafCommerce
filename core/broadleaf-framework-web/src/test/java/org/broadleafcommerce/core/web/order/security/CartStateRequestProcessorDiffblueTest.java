package org.broadleafcommerce.core.web.order.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.crossapp.service.CrossAppAuthService;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.MergeCartService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class CartStateRequestProcessorDiffblueTest {
  @InjectMocks private CartStateRequestProcessor cartStateRequestProcessor;

  @Mock private CrossAppAuthService crossAppAuthService;

  @Mock private CustomerStateRequestProcessor customerStateRequestProcessor;

  @Mock private MergeCartService mergeCartService;

  @Mock private OrderService orderService;

  /**
   * Test {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}.
   *
   * <ul>
   *   <li>Then calls {@link WebRequest#getAttribute(String, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateRequestProcessor.updateCartRequestAttributes(WebRequest, Order)"
  })
  public void testUpdateCartRequestAttributes_thenCallsGetAttribute() {
    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(new HashMap<>());
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    cartStateRequestProcessor.updateCartRequestAttributes(request, new NullOrderImpl());

    // Assert
    verify(request).getAttribute("blRuleMap", 0);
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(0));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link CartStateRequestProcessor} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.getOverrideCart(WebRequest)"})
  public void testGetOverrideCart_givenCartStateRequestProcessor_thenReturnNull() {
    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();

    // Act
    Order actualOverrideCart =
        cartStateRequestProcessor.getOverrideCart(
            new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    assertNull(actualOverrideCart);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  public void testMergeCartNeeded() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualMergeCartNeededResult =
        cartStateRequestProcessor.mergeCartNeeded(
            customer, new ServletWebRequest(new MockHttpServletRequest()));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  public void testMergeCartNeeded2() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cartStateRequestProcessor.mergeCartNeeded(
                customer, new ServletWebRequest(new MockHttpServletRequest())));
    verify(crossAppAuthService).isAuthedFromAdmin();
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  public void testMergeCartNeeded3() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualMergeCartNeededResult =
        cartStateRequestProcessor.mergeCartNeeded(
            customer, new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertFalse(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  public void testMergeCartNeeded4() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cartStateRequestProcessor.mergeCartNeeded(
                customer, new ServletWebRequest(new MockHttpServletRequest())));
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  public void testMergeCartNeeded5() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(null);
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act
    boolean actualMergeCartNeededResult =
        cartStateRequestProcessor.mergeCartNeeded(
            customer, new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertFalse(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getId()} return one.
   *   <li>Then calls {@link CustomerImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  public void testMergeCartNeeded_givenCustomerImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);

    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(customerImpl);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);

    // Act
    boolean actualMergeCartNeededResult =
        cartStateRequestProcessor.mergeCartNeeded(
            customer, new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerImpl).getId();
    verify(customer, atLeast(1)).getId();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertFalse(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  public void testMergeCartNeeded_givenCustomerImplGetIdThrowRuntimeException() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);

    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getId()).thenThrow(new RuntimeException());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(customerImpl);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cartStateRequestProcessor.mergeCartNeeded(
                customer, new ServletWebRequest(new MockHttpServletRequest())));
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customerImpl).getId();
    verify(customer, atLeast(1)).getId();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateRequestProcessor.mergeCartNeeded(Customer, WebRequest)"})
  public void testMergeCartNeeded_thenReturnTrue() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);

    // Act
    boolean actualMergeCartNeededResult =
        cartStateRequestProcessor.mergeCartNeeded(
            customer, new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(customer, atLeast(1)).getId();
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    assertTrue(actualMergeCartNeededResult);
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   *
   * <p>Method under test: {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  public void testMergeCart() {
    // Arrange
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cartStateRequestProcessor.mergeCart(
                customer, new ServletWebRequest(new MockHttpServletRequest())));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  public void testMergeCart_givenFalse_whenWebRequestGetAttributeReturnFalse()
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  public void testMergeCart_givenOrderServiceFindCartForCustomerThrowRuntimeException() {
    // Arrange
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(orderService.findCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cartStateRequestProcessor.mergeCart(
                customer, new ServletWebRequest(new MockHttpServletRequest())));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  public void testMergeCart_givenTrue_thenCallsRemoveAttribute()
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order CartStateRequestProcessor.mergeCart(Customer, WebRequest)"})
  public void testMergeCart_thenReturnNullOrderImpl()
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

    // Act
    Order actualMergeCartResult =
        cartStateRequestProcessor.mergeCart(
            customer, new ServletWebRequest(new MockHttpServletRequest()));

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
