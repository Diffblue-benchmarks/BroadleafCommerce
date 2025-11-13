package org.broadleafcommerce.core.web.order.security;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.MergeCartService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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

@RunWith(MockitoJUnitRunner.class)
public class MergeCartProcessorImplDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  public void testExecuteWithRequestAuthResult() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, new TestingAuthenticationToken("Principal", "Credentials")));
    verify(customerService).readCustomerByUsername("Principal");
  }

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with {@code request},
   * {@code authResult}.
   *
   * <p>Method under test: {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  public void testExecuteWithRequestAuthResult2() throws RemoveFromCartException, PricingException {
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    mergeCartProcessorImpl.execute(
        request, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    Object sessionMutex = request.getSessionMutex();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  public void testExecuteWithRequestAuthResult3() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(orderService.findCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, new TestingAuthenticationToken("Principal", "Credentials")));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  public void testExecuteWithRequestAuthResult4() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new PricingException());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, new TestingAuthenticationToken("Principal", "Credentials")));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  public void testExecuteWithRequestAuthResult5() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new RuntimeException());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, new TestingAuthenticationToken("Principal", "Credentials")));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  public void testExecuteWithRequestAuthResult6() throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new RemoveFromCartException());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergeCartProcessorImpl.execute(
                request, new TestingAuthenticationToken("Principal", "Credentials")));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeCartProcessorImpl.execute(WebRequest, Authentication)"})
  public void testExecuteWithRequestAuthResult7() throws RemoveFromCartException, PricingException {
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    mergeCartProcessorImpl.execute(
        request, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isNull());
    verify(customerService).readCustomerByUsername("Principal");
    verify(customerStateRequestProcessor).getAnonymousCustomer(isA(WebRequest.class));
    Object sessionMutex = request.getSessionMutex();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testExecuteWithRequestResponseAuthResult() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testExecuteWithRequestResponseAuthResult2()
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    mergeCartProcessorImpl.execute(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testExecuteWithRequestResponseAuthResult3() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(orderService.findCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testExecuteWithRequestResponseAuthResult4()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new PricingException());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testExecuteWithRequestResponseAuthResult5()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new RuntimeException());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testExecuteWithRequestResponseAuthResult6()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenReturn(new CustomerImpl());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any()))
        .thenThrow(new RemoveFromCartException());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testExecuteWithRequestResponseAuthResult7()
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    mergeCartProcessorImpl.execute(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isNull());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeCartProcessorImpl.execute(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testExecuteWithRequestResponseAuthResult8() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerStateRequestProcessor.getAnonymousCustomer(Mockito.<WebRequest>any()))
        .thenThrow(new RuntimeException());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MergeCartProcessorImpl.getMergeCartResponseKey()",
    "void MergeCartProcessorImpl.setMergeCartResponseKey(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    MergeCartProcessorImpl mergeCartProcessorImpl = new MergeCartProcessorImpl();

    // Act
    mergeCartProcessorImpl.setMergeCartResponseKey("Merge Cart Response Key");

    // Assert
    assertEquals("Merge Cart Response Key", mergeCartProcessorImpl.getMergeCartResponseKey());
  }
}
