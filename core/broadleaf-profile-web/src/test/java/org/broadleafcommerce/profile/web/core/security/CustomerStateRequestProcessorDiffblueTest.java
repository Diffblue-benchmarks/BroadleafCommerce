/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class CustomerStateRequestProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}
   */
  @Test
  void testPublishEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<ApplicationEvent>any());

    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    customerStateRequestProcessor.setApplicationEventPublisher(eventPublisher);
    CustomerAuthenticatedFromCookieEvent event = new CustomerAuthenticatedFromCookieEvent(new CustomerImpl(), "Source");

    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    customerStateRequestProcessor.publishEvent(event, request, "Event Class", "janedoe");

    // Assert
    verify(eventPublisher).publishEvent(isA(ApplicationEvent.class));
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{"_blc_lastPublishedEventClass", "_blc_lastPublishedEventUsername"},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}
   */
  @Test
  void testPublishEvent2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<ApplicationEvent>any());

    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    customerStateRequestProcessor.setApplicationEventPublisher(eventPublisher);
    CustomerAuthenticatedFromCookieEvent event = new CustomerAuthenticatedFromCookieEvent(new CustomerImpl(), "Source");

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    customerStateRequestProcessor.publishEvent(event, request, "Event Class", "janedoe");

    // Assert
    verify(eventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(request, atLeast(1)).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(1));
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}
   */
  @Test
  void testPublishEvent3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<ApplicationEvent>any());

    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    customerStateRequestProcessor.setApplicationEventPublisher(eventPublisher);
    CustomerAuthenticatedFromCookieEvent event = new CustomerAuthenticatedFromCookieEvent(new CustomerImpl(), "Source");

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    customerStateRequestProcessor.publishEvent(event, request, "Event Class", "janedoe");

    // Assert
    verify(eventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(request, atLeast(1)).getAttribute(eq("blOkToUseSession"), eq(0));
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}
   */
  @Test
  void testMergeCustomerIfRequired() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualMergeCustomerIfRequiredResult = customerStateRequestProcessor.mergeCustomerIfRequired(request,
        customer);

    // Assert
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertSame(customer, actualMergeCustomerIfRequiredResult);
    assertArrayEquals(new String[]{CustomerStateRequestProcessor.ANONYMOUS_CUSTOMER_MERGED_SESSION_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}
   */
  @Test
  void testMergeCustomerIfRequired2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualMergeCustomerIfRequiredResult = customerStateRequestProcessor.mergeCustomerIfRequired(request,
        customer);

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), anyInt());
    assertSame(customer, actualMergeCustomerIfRequiredResult);
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}
   */
  @Test
  void testMergeCustomerIfRequired3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualMergeCustomerIfRequiredResult = customerStateRequestProcessor.mergeCustomerIfRequired(request,
        customer);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    assertSame(customer, actualMergeCustomerIfRequiredResult);
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)}
   */
  @Test
  void testCopyAnonymousCustomerInfoToCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    CustomerImpl anonymous = new CustomerImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertSame(customer,
        customerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(request, anonymous, customer));
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)}
   */
  @Test
  void testCopyAnonymousCustomerInfoToCustomer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    ServletWebRequest request = new ServletWebRequest(mock(DefaultMultipartHttpServletRequest.class));
    CustomerImpl anonymous = new CustomerImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertSame(customer,
        customerStateRequestProcessor.copyAnonymousCustomerInfoToCustomer(request, anonymous, customer));
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}
   */
  @Test
  void testResolveAuthenticatedCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();

    // Act and Assert
    assertNull(customerStateRequestProcessor
        .resolveAuthenticatedCustomer(new TestingAuthenticationToken("Principal", "Credentials")));
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}
   */
  @Test
  void testResolveAuthenticatedCustomer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    customerStateRequestProcessor.setApplicationEventPublisher(mock(ApplicationEventPublisher.class));

    // Act and Assert
    assertNull(customerStateRequestProcessor
        .resolveAuthenticatedCustomer(new TestingAuthenticationToken("Principal", "Credentials")));
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}
   */
  @Test
  void testGetAnonymousCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();

    // Act and Assert
    assertNull(customerStateRequestProcessor.getAnonymousCustomer(new ServletWebRequest(new MockHttpServletRequest())));
  }

  /**
   * Method under test:
   * {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}
   */
  @Test
  void testGetAnonymousCustomer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Customer actualAnonymousCustomer = customerStateRequestProcessor.getAnonymousCustomer(request);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    assertNull(actualAnonymousCustomer);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CustomerStateRequestProcessor#setApplicationEventPublisher(ApplicationEventPublisher)}
   *   <li>
   * {@link CustomerStateRequestProcessor#getAnonymousCustomerIdSessionAttributeName()}
   *   <li>
   * {@link CustomerStateRequestProcessor#getAnonymousCustomerMergedSessionAttributeName()}
   *   <li>
   * {@link CustomerStateRequestProcessor#getAnonymousCustomerSessionAttributeName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();

    // Act
    customerStateRequestProcessor.setApplicationEventPublisher(mock(ApplicationEventPublisher.class));
    String actualAnonymousCustomerIdSessionAttributeName = customerStateRequestProcessor
        .getAnonymousCustomerIdSessionAttributeName();
    String actualAnonymousCustomerMergedSessionAttributeName = customerStateRequestProcessor
        .getAnonymousCustomerMergedSessionAttributeName();

    // Assert that nothing has changed
    assertEquals(CustomerStateRequestProcessor.ANONYMOUS_CUSTOMER_ID_SESSION_ATTRIBUTE_NAME,
        actualAnonymousCustomerIdSessionAttributeName);
    assertEquals(CustomerStateRequestProcessor.ANONYMOUS_CUSTOMER_MERGED_SESSION_ATTRIBUTE_NAME,
        actualAnonymousCustomerMergedSessionAttributeName);
    assertEquals(CustomerStateRequestProcessor.ANONYMOUS_CUSTOMER_SESSION_ATTRIBUTE_NAME,
        customerStateRequestProcessor.getAnonymousCustomerSessionAttributeName());
  }
}
