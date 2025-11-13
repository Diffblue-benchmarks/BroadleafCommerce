package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class CustomerStateRequestProcessorDiffblueTest {
  @Mock private AnonymousCustomerExtensionManager anonymousCustomerExtensionManager;

  @Mock private CustomerMergeExtensionManager customerMergeExtensionManager;

  @Mock private CustomerService customerService;

  @InjectMocks private CustomerStateRequestProcessor customerStateRequestProcessor;

  /**
   * Test {@link CustomerStateRequestProcessor#process(WebRequest)}.
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerStateRequestProcessor.process(WebRequest)"})
  void testProcess() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            customerStateRequestProcessor.process(
                new ServletWebRequest(new MockHttpServletRequest())));
    verify(anonymousCustomerExtensionManager).getProxy();
  }

  /**
   * Test {@link CustomerStateRequestProcessor#process(WebRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerService#createCustomerWithNullId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest); then calls createCustomerWithNullId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerStateRequestProcessor.process(WebRequest)"})
  void testProcess_thenCallsCreateCustomerWithNullId() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy())
        .thenReturn(new AbstractAnonymousCustomerExtensionHandler());
    when(customerService.createCustomerWithNullId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            customerStateRequestProcessor.process(
                new ServletWebRequest(new MockHttpServletRequest())));
    verify(anonymousCustomerExtensionManager).getProxy();
    verify(customerService).createCustomerWithNullId();
  }

  /**
   * Test {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String,
   * String)}.
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent,
   * WebRequest, String, String)}
   */
  @Test
  @DisplayName("Test publishEvent(ApplicationEvent, WebRequest, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerStateRequestProcessor.publishEvent(ApplicationEvent, WebRequest, String, String)"
  })
  void testPublishEvent() {
    // Arrange
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<ApplicationEvent>any());

    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();
    customerStateRequestProcessor.setApplicationEventPublisher(eventPublisher);
    CustomerAuthenticatedFromCookieEvent event =
        new CustomerAuthenticatedFromCookieEvent(new CustomerImpl(), "Source");
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    customerStateRequestProcessor.publishEvent(event, request, "Event Class", "janedoe");

    // Assert
    verify(eventPublisher).publishEvent(isA(ApplicationEvent.class));
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(
        new String[] {"_blc_lastPublishedEventClass", "_blc_lastPublishedEventUsername"},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link WebRequest} {@link WebRequest#getAttribute(String, int)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent,
   * WebRequest, String, String)}
   */
  @Test
  @DisplayName(
      "Test publishEvent(ApplicationEvent, WebRequest, String, String); given 'false'; when WebRequest getAttribute(String, int) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerStateRequestProcessor.publishEvent(ApplicationEvent, WebRequest, String, String)"
  })
  void testPublishEvent_givenFalse_whenWebRequestGetAttributeReturnFalse() {
    // Arrange
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<ApplicationEvent>any());

    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();
    customerStateRequestProcessor.setApplicationEventPublisher(eventPublisher);
    CustomerAuthenticatedFromCookieEvent event =
        new CustomerAuthenticatedFromCookieEvent(new CustomerImpl(), "Source");

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    customerStateRequestProcessor.publishEvent(event, request, "Event Class", "janedoe");

    // Assert
    verify(eventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(request, atLeast(1)).getAttribute("blOkToUseSession", 0);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link WebRequest#setAttribute(String, Object, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent,
   * WebRequest, String, String)}
   */
  @Test
  @DisplayName(
      "Test publishEvent(ApplicationEvent, WebRequest, String, String); given 'true'; then calls setAttribute(String, Object, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerStateRequestProcessor.publishEvent(ApplicationEvent, WebRequest, String, String)"
  })
  void testPublishEvent_givenTrue_thenCallsSetAttribute() {
    // Arrange
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<ApplicationEvent>any());

    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();
    customerStateRequestProcessor.setApplicationEventPublisher(eventPublisher);
    CustomerAuthenticatedFromCookieEvent event =
        new CustomerAuthenticatedFromCookieEvent(new CustomerImpl(), "Source");

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    customerStateRequestProcessor.publishEvent(event, request, "Event Class", "janedoe");

    // Assert
    verify(eventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(request, atLeast(1)).getAttribute("blOkToUseSession", 0);
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(1));
  }

  /**
   * Test {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest,
   * Customer)}
   */
  @Test
  @DisplayName("Test mergeCustomerIfRequired(WebRequest, Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.mergeCustomerIfRequired(WebRequest, Customer)"
  })
  void testMergeCustomerIfRequired() {
    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();

    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    request.setAttribute(
        CustomerStateRequestProcessor.ANONYMOUS_CUSTOMER_MERGED_SESSION_ATTRIBUTE_NAME, "Value", 1);
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualMergeCustomerIfRequiredResult =
        customerStateRequestProcessor.mergeCustomerIfRequired(request, customer);

    // Assert
    assertSame(customer, actualMergeCustomerIfRequiredResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest,
   * Customer)}
   */
  @Test
  @DisplayName("Test mergeCustomerIfRequired(WebRequest, Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.mergeCustomerIfRequired(WebRequest, Customer)"
  })
  void testMergeCustomerIfRequired2() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy()).thenThrow(new RuntimeException());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> customerStateRequestProcessor.mergeCustomerIfRequired(request, new CustomerImpl()));
    verify(anonymousCustomerExtensionManager).getProxy();
  }

  /**
   * Test {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest,
   * Customer)}
   */
  @Test
  @DisplayName("Test mergeCustomerIfRequired(WebRequest, Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.mergeCustomerIfRequired(WebRequest, Customer)"
  })
  void testMergeCustomerIfRequired3() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy())
        .thenReturn(new AbstractAnonymousCustomerExtensionHandler());
    when(customerMergeExtensionManager.getProxy()).thenThrow(new RuntimeException());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> customerStateRequestProcessor.mergeCustomerIfRequired(request, new CustomerImpl()));
    verify(anonymousCustomerExtensionManager).getProxy();
    verify(customerMergeExtensionManager).getProxy();
  }

  /**
   * Test {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest,
   * Customer)}
   */
  @Test
  @DisplayName("Test mergeCustomerIfRequired(WebRequest, Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.mergeCustomerIfRequired(WebRequest, Customer)"
  })
  void testMergeCustomerIfRequired4() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy())
        .thenReturn(new AbstractAnonymousCustomerExtensionHandler());
    when(customerMergeExtensionManager.getProxy())
        .thenReturn(new DefaultCustomerMergeExtensionHandler());
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> customerStateRequestProcessor.mergeCustomerIfRequired(request, new CustomerImpl()));
    verify(anonymousCustomerExtensionManager).getProxy();
    verify(customerMergeExtensionManager).getProxy();
    verify(customerService).saveCustomer(isA(Customer.class));
  }

  /**
   * Test {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   *
   * <ul>
   *   <li>Given {@link CustomerStateRequestProcessor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest,
   * Customer)}
   */
  @Test
  @DisplayName(
      "Test mergeCustomerIfRequired(WebRequest, Customer); given CustomerStateRequestProcessor (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.mergeCustomerIfRequired(WebRequest, Customer)"
  })
  void testMergeCustomerIfRequired_givenCustomerStateRequestProcessor() {
    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualMergeCustomerIfRequiredResult =
        customerStateRequestProcessor.mergeCustomerIfRequired(request, customer);

    // Assert
    assertSame(customer, actualMergeCustomerIfRequiredResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link WebRequest} {@link WebRequest#getAttribute(String, int)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest,
   * Customer)}
   */
  @Test
  @DisplayName(
      "Test mergeCustomerIfRequired(WebRequest, Customer); given 'false'; when WebRequest getAttribute(String, int) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.mergeCustomerIfRequired(WebRequest, Customer)"
  })
  void testMergeCustomerIfRequired_givenFalse_whenWebRequestGetAttributeReturnFalse() {
    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualMergeCustomerIfRequiredResult =
        customerStateRequestProcessor.mergeCustomerIfRequired(request, customer);

    // Assert
    verify(request).getAttribute("blOkToUseSession", 0);
    assertSame(customer, actualMergeCustomerIfRequiredResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link WebRequest} {@link WebRequest#getAttribute(String, int)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest,
   * Customer)}
   */
  @Test
  @DisplayName(
      "Test mergeCustomerIfRequired(WebRequest, Customer); given 'true'; when WebRequest getAttribute(String, int) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.mergeCustomerIfRequired(WebRequest, Customer)"
  })
  void testMergeCustomerIfRequired_givenTrue_whenWebRequestGetAttributeReturnTrue() {
    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualMergeCustomerIfRequiredResult =
        customerStateRequestProcessor.mergeCustomerIfRequired(request, customer);

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), anyInt());
    assertSame(customer, actualMergeCustomerIfRequiredResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerService#saveCustomer(Customer)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest,
   * Customer)}
   */
  @Test
  @DisplayName(
      "Test mergeCustomerIfRequired(WebRequest, Customer); then calls saveCustomer(Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.mergeCustomerIfRequired(WebRequest, Customer)"
  })
  void testMergeCustomerIfRequired_thenCallsSaveCustomer() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy())
        .thenReturn(new AbstractAnonymousCustomerExtensionHandler());
    when(customerMergeExtensionManager.getProxy())
        .thenReturn(new DefaultCustomerMergeExtensionHandler());
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(customerImpl);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    Customer actualMergeCustomerIfRequiredResult =
        customerStateRequestProcessor.mergeCustomerIfRequired(request, new CustomerImpl());

    // Assert
    verify(anonymousCustomerExtensionManager).getProxy();
    verify(customerMergeExtensionManager).getProxy();
    verify(customerService).saveCustomer(isA(Customer.class));
    assertSame(customerImpl, actualMergeCustomerIfRequiredResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest,
   * Customer, Customer)}.
   *
   * <p>Method under test: {@link
   * CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer,
   * Customer)}
   */
  @Test
  @DisplayName("Test copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)"
  })
  void testCopyAnonymousCustomerInfoToCustomer() {
    // Arrange
    when(customerMergeExtensionManager.getProxy()).thenThrow(new RuntimeException());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    CustomerImpl anonymous = new CustomerImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            customerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(
                request, anonymous, new CustomerImpl()));
    verify(customerMergeExtensionManager).getProxy();
  }

  /**
   * Test {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest,
   * Customer, Customer)}.
   *
   * <p>Method under test: {@link
   * CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer,
   * Customer)}
   */
  @Test
  @DisplayName("Test copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)"
  })
  void testCopyAnonymousCustomerInfoToCustomer2() {
    // Arrange
    when(customerMergeExtensionManager.getProxy())
        .thenReturn(new DefaultCustomerMergeExtensionHandler());
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    CustomerImpl anonymous = new CustomerImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            customerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(
                request, anonymous, new CustomerImpl()));
    verify(customerMergeExtensionManager).getProxy();
    verify(customerService).saveCustomer(isA(Customer.class));
  }

  /**
   * Test {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest,
   * Customer, Customer)}.
   *
   * <ul>
   *   <li>Given {@link CustomerStateRequestProcessor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer,
   * Customer)}
   */
  @Test
  @DisplayName(
      "Test copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer); given CustomerStateRequestProcessor (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)"
  })
  void testCopyAnonymousCustomerInfoToCustomer_givenCustomerStateRequestProcessor() {
    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    CustomerImpl anonymous = new CustomerImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualCopyAnonymousCustomerInfoToCustomerResult =
        customerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(
            request, anonymous, customer);

    // Assert
    assertSame(customer, actualCopyAnonymousCustomerInfoToCustomerResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest,
   * Customer, Customer)}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer,
   * Customer)}
   */
  @Test
  @DisplayName(
      "Test copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer); then return CustomerImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)"
  })
  void testCopyAnonymousCustomerInfoToCustomer_thenReturnCustomerImpl() {
    // Arrange
    when(customerMergeExtensionManager.getProxy())
        .thenReturn(new DefaultCustomerMergeExtensionHandler());
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(customerImpl);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    CustomerImpl anonymous = new CustomerImpl();

    // Act
    Customer actualCopyAnonymousCustomerInfoToCustomerResult =
        customerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(
            request, anonymous, new CustomerImpl());

    // Assert
    verify(customerMergeExtensionManager).getProxy();
    verify(customerService).saveCustomer(isA(Customer.class));
    assertSame(customerImpl, actualCopyAnonymousCustomerInfoToCustomerResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}.
   *
   * <p>Method under test: {@link
   * CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}
   */
  @Test
  @DisplayName("Test resolveAuthenticatedCustomer(Authentication)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerStateRequestProcessor.resolveAuthenticatedCustomer(Authentication)"
  })
  void testResolveAuthenticatedCustomer() {
    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();

    // Act
    Customer actualResolveAuthenticatedCustomerResult =
        customerStateRequestProcessor.resolveAuthenticatedCustomer(
            new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    assertNull(actualResolveAuthenticatedCustomerResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}.
   *
   * <p>Method under test: {@link
   * CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName("Test resolveAnonymousCustomer(WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerStateRequestProcessor.resolveAnonymousCustomer(WebRequest)"})
  void testResolveAnonymousCustomer() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            customerStateRequestProcessor.resolveAnonymousCustomer(
                new ServletWebRequest(new MockHttpServletRequest())));
    verify(anonymousCustomerExtensionManager).getProxy();
  }

  /**
   * Test {@link CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}.
   *
   * <p>Method under test: {@link
   * CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName("Test resolveAnonymousCustomer(WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerStateRequestProcessor.resolveAnonymousCustomer(WebRequest)"})
  void testResolveAnonymousCustomer2() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy())
        .thenReturn(new AbstractAnonymousCustomerExtensionHandler());
    when(customerService.createCustomerWithNullId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            customerStateRequestProcessor.resolveAnonymousCustomer(
                new ServletWebRequest(new MockHttpServletRequest())));
    verify(anonymousCustomerExtensionManager).getProxy();
    verify(customerService).createCustomerWithNullId();
  }

  /**
   * Test {@link CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       AbstractAnonymousCustomerExtensionHandler#getAnonymousCustomer(ExtensionResultHolder,
   *       WebRequest)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test resolveAnonymousCustomer(WebRequest); then calls getAnonymousCustomer(ExtensionResultHolder, WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerStateRequestProcessor.resolveAnonymousCustomer(WebRequest)"})
  void testResolveAnonymousCustomer_thenCallsGetAnonymousCustomer() {
    // Arrange
    AbstractAnonymousCustomerExtensionHandler abstractAnonymousCustomerExtensionHandler =
        mock(AbstractAnonymousCustomerExtensionHandler.class);
    when(abstractAnonymousCustomerExtensionHandler.getAnonymousCustomer(
            Mockito.<ExtensionResultHolder<Customer>>any(), Mockito.<WebRequest>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(anonymousCustomerExtensionManager.getProxy())
        .thenReturn(abstractAnonymousCustomerExtensionHandler);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerService.createCustomerWithNullId()).thenReturn(customerImpl);

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Customer actualResolveAnonymousCustomerResult =
        customerStateRequestProcessor.resolveAnonymousCustomer(request);

    // Assert
    verify(anonymousCustomerExtensionManager).getProxy();
    verify(customerService).createCustomerWithNullId();
    verify(abstractAnonymousCustomerExtensionHandler)
        .getAnonymousCustomer(isA(ExtensionResultHolder.class), isA(WebRequest.class));
    verify(request, atLeast(1)).getAttribute("blOkToUseSession", 0);
    assertSame(customerImpl, actualResolveAnonymousCustomerResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test resolveAnonymousCustomer(WebRequest); then return CustomerImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerStateRequestProcessor.resolveAnonymousCustomer(WebRequest)"})
  void testResolveAnonymousCustomer_thenReturnCustomerImpl() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy())
        .thenReturn(new AbstractAnonymousCustomerExtensionHandler());
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerService.createCustomerWithNullId()).thenReturn(customerImpl);

    // Act
    Customer actualResolveAnonymousCustomerResult =
        customerStateRequestProcessor.resolveAnonymousCustomer(
            new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(anonymousCustomerExtensionManager).getProxy();
    verify(customerService).createCustomerWithNullId();
    assertSame(customerImpl, actualResolveAnonymousCustomerResult);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}.
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName("Test getAnonymousCustomer(WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerStateRequestProcessor.getAnonymousCustomer(WebRequest)"})
  void testGetAnonymousCustomer() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy())
        .thenReturn(new AbstractAnonymousCustomerExtensionHandler());

    // Act
    Customer actualAnonymousCustomer =
        customerStateRequestProcessor.getAnonymousCustomer(
            new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(anonymousCustomerExtensionManager).getProxy();
    assertNull(actualAnonymousCustomer);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link CustomerStateRequestProcessor} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getAnonymousCustomer(WebRequest); given CustomerStateRequestProcessor (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerStateRequestProcessor.getAnonymousCustomer(WebRequest)"})
  void testGetAnonymousCustomer_givenCustomerStateRequestProcessor_thenReturnNull() {
    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();

    // Act
    Customer actualAnonymousCustomer =
        customerStateRequestProcessor.getAnonymousCustomer(
            new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    assertNull(actualAnonymousCustomer);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       AbstractAnonymousCustomerExtensionHandler#getAnonymousCustomer(ExtensionResultHolder,
   *       WebRequest)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getAnonymousCustomer(WebRequest); then calls getAnonymousCustomer(ExtensionResultHolder, WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerStateRequestProcessor.getAnonymousCustomer(WebRequest)"})
  void testGetAnonymousCustomer_thenCallsGetAnonymousCustomer() {
    // Arrange
    AbstractAnonymousCustomerExtensionHandler abstractAnonymousCustomerExtensionHandler =
        mock(AbstractAnonymousCustomerExtensionHandler.class);
    when(abstractAnonymousCustomerExtensionHandler.getAnonymousCustomer(
            Mockito.<ExtensionResultHolder<Customer>>any(), Mockito.<WebRequest>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(anonymousCustomerExtensionManager.getProxy())
        .thenReturn(abstractAnonymousCustomerExtensionHandler);

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Customer actualAnonymousCustomer = customerStateRequestProcessor.getAnonymousCustomer(request);

    // Assert
    verify(anonymousCustomerExtensionManager).getProxy();
    verify(abstractAnonymousCustomerExtensionHandler)
        .getAnonymousCustomer(isA(ExtensionResultHolder.class), isA(WebRequest.class));
    verify(request).getAttribute("blOkToUseSession", 0);
    assertNull(actualAnonymousCustomer);
  }

  /**
   * Test {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName("Test getAnonymousCustomer(WebRequest); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerStateRequestProcessor.getAnonymousCustomer(WebRequest)"})
  void testGetAnonymousCustomer_thenThrowRuntimeException() {
    // Arrange
    when(anonymousCustomerExtensionManager.getProxy()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            customerStateRequestProcessor.getAnonymousCustomer(
                new ServletWebRequest(new MockHttpServletRequest())));
    verify(anonymousCustomerExtensionManager).getProxy();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       CustomerStateRequestProcessor#setApplicationEventPublisher(ApplicationEventPublisher)}
   *   <li>{@link CustomerStateRequestProcessor#getAnonymousCustomerIdSessionAttributeName()}
   *   <li>{@link CustomerStateRequestProcessor#getAnonymousCustomerMergedSessionAttributeName()}
   *   <li>{@link CustomerStateRequestProcessor#getAnonymousCustomerSessionAttributeName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CustomerStateRequestProcessor.getAnonymousCustomerIdSessionAttributeName()",
    "String CustomerStateRequestProcessor.getAnonymousCustomerMergedSessionAttributeName()",
    "String CustomerStateRequestProcessor.getAnonymousCustomerSessionAttributeName()",
    "void CustomerStateRequestProcessor.setApplicationEventPublisher(ApplicationEventPublisher)"
  })
  void testGettersAndSetters() {
    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor =
        new CustomerStateRequestProcessor();

    // Act
    customerStateRequestProcessor.setApplicationEventPublisher(
        mock(ApplicationEventPublisher.class));
    String actualAnonymousCustomerIdSessionAttributeName =
        customerStateRequestProcessor.getAnonymousCustomerIdSessionAttributeName();
    String actualAnonymousCustomerMergedSessionAttributeName =
        customerStateRequestProcessor.getAnonymousCustomerMergedSessionAttributeName();

    // Assert
    assertEquals(
        CustomerStateRequestProcessor.ANONYMOUS_CUSTOMER_ID_SESSION_ATTRIBUTE_NAME,
        actualAnonymousCustomerIdSessionAttributeName);
    assertEquals(
        CustomerStateRequestProcessor.ANONYMOUS_CUSTOMER_MERGED_SESSION_ATTRIBUTE_NAME,
        actualAnonymousCustomerMergedSessionAttributeName);
    assertEquals(
        CustomerStateRequestProcessor.ANONYMOUS_CUSTOMER_SESSION_ATTRIBUTE_NAME,
        customerStateRequestProcessor.getAnonymousCustomerSessionAttributeName());
  }
}
