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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-web-applicationContext.xml",
    "/blc-config/site/bl-profile-web-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class CustomerStateRequestProcessorDiffblueTest {
  @Autowired
  private CustomerStateRequestProcessor customerStateRequestProcessor;

  /**
   * Test {@link CustomerStateRequestProcessor#process(WebRequest)}.
   * <p>
   * Method under test: {@link CustomerStateRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest)")
  @Disabled("TODO: Complete this test")
  void testProcess() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1246 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor customerStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor2 = new CustomerStateRequestProcessor();

    // Act
    customerStateRequestProcessor2.process(new ServletWebRequest(new MockHttpServletRequest()));
  }

  /**
   * Test
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}
   */
  @Test
  @DisplayName("Test publishEvent(ApplicationEvent, WebRequest, String, String)")
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
   * Test
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}
   */
  @Test
  @DisplayName("Test publishEvent(ApplicationEvent, WebRequest, String, String)")
  @Disabled("TODO: Complete this test")
  void testPublishEvent2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1329 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor customerStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor2 = new CustomerStateRequestProcessor();
    CustomerAuthenticatedFromCookieEvent event = new CustomerAuthenticatedFromCookieEvent(new CustomerImpl(), "Source");

    // Act
    customerStateRequestProcessor2.publishEvent(event, new ServletWebRequest(new MockHttpServletRequest()),
        "Event Class", "janedoe");
  }

  /**
   * Test
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link WebRequest}
   * {@link RequestAttributes#getAttribute(String, int)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}
   */
  @Test
  @DisplayName("Test publishEvent(ApplicationEvent, WebRequest, String, String); given 'false'; when WebRequest getAttribute(String, int) return 'false'")
  void testPublishEvent_givenFalse_whenWebRequestGetAttributeReturnFalse() {
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
   * Test
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls
   * {@link RequestAttributes#setAttribute(String, Object, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#publishEvent(ApplicationEvent, WebRequest, String, String)}
   */
  @Test
  @DisplayName("Test publishEvent(ApplicationEvent, WebRequest, String, String); given 'true'; then calls setAttribute(String, Object, int)")
  void testPublishEvent_givenTrue_thenCallsSetAttribute() {
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
   * Test
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}
   */
  @Test
  @DisplayName("Test mergeCustomerIfRequired(WebRequest, Customer)")
  void testMergeCustomerIfRequired() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    customerStateRequestProcessor.mergeCustomerIfRequired(request, new CustomerImpl());

    // Assert
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{CustomerStateRequestProcessor.ANONYMOUS_CUSTOMER_MERGED_SESSION_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}
   */
  @Test
  @DisplayName("Test mergeCustomerIfRequired(WebRequest, Customer)")
  @Disabled("TODO: Complete this test")
  void testMergeCustomerIfRequired2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1137 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor customerStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor2 = new CustomerStateRequestProcessor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    customerStateRequestProcessor2.mergeCustomerIfRequired(request, new CustomerImpl());
  }

  /**
   * Test
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link WebRequest}
   * {@link RequestAttributes#getAttribute(String, int)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}
   */
  @Test
  @DisplayName("Test mergeCustomerIfRequired(WebRequest, Customer); given 'false'; when WebRequest getAttribute(String, int) return 'false'")
  void testMergeCustomerIfRequired_givenFalse_whenWebRequestGetAttributeReturnFalse() {
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
   * Test
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link WebRequest}
   * {@link RequestAttributes#getAttribute(String, int)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#mergeCustomerIfRequired(WebRequest, Customer)}
   */
  @Test
  @DisplayName("Test mergeCustomerIfRequired(WebRequest, Customer); given 'true'; when WebRequest getAttribute(String, int) return 'true'")
  void testMergeCustomerIfRequired_givenTrue_whenWebRequestGetAttributeReturnTrue() {
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
   * Test
   * {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)}
   */
  @Test
  @DisplayName("Test copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)")
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
   * Test
   * {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)}
   */
  @Test
  @DisplayName("Test copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)")
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
   * Test
   * {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)}
   */
  @Test
  @DisplayName("Test copyAnonymousCustomerInfoToCustomer(WebRequest, Customer, Customer)")
  @Disabled("TODO: Complete this test")
  void testCopyAnonymousCustomerInfoToCustomer3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass918 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor customerStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor2 = new CustomerStateRequestProcessor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    CustomerImpl anonymous = new CustomerImpl();

    // Act
    customerStateRequestProcessor2.copyAnonymousCustomerInfoToCustomer(request, anonymous, new CustomerImpl());
  }

  /**
   * Test
   * {@link CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}
   */
  @Test
  @DisplayName("Test resolveAuthenticatedCustomer(Authentication)")
  void testResolveAuthenticatedCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();
    customerStateRequestProcessor.setApplicationEventPublisher(mock(ApplicationEventPublisher.class));

    // Act and Assert
    assertNull(customerStateRequestProcessor
        .resolveAuthenticatedCustomer(new TestingAuthenticationToken("Principal", "Credentials")));
  }

  /**
   * Test
   * {@link CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}
   */
  @Test
  @DisplayName("Test resolveAuthenticatedCustomer(Authentication)")
  @Disabled("TODO: Complete this test")
  void testResolveAuthenticatedCustomer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1581 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor customerStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor2 = new CustomerStateRequestProcessor();

    // Act
    customerStateRequestProcessor2
        .resolveAuthenticatedCustomer(new TestingAuthenticationToken("Principal", "Credentials"));
  }

  /**
   * Test
   * {@link CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}.
   * <ul>
   *   <li>Given {@link CustomerStateRequestProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#resolveAuthenticatedCustomer(Authentication)}
   */
  @Test
  @DisplayName("Test resolveAuthenticatedCustomer(Authentication); given CustomerStateRequestProcessor (default constructor)")
  void testResolveAuthenticatedCustomer_givenCustomerStateRequestProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();

    // Act and Assert
    assertNull(customerStateRequestProcessor
        .resolveAuthenticatedCustomer(new TestingAuthenticationToken("Principal", "Credentials")));
  }

  /**
   * Test
   * {@link CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#resolveAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName("Test resolveAnonymousCustomer(WebRequest)")
  @Disabled("TODO: Complete this test")
  void testResolveAnonymousCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1498 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor customerStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor2 = new CustomerStateRequestProcessor();

    // Act
    customerStateRequestProcessor2.resolveAnonymousCustomer(new ServletWebRequest(new MockHttpServletRequest()));
  }

  /**
   * Test {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName("Test getAnonymousCustomer(WebRequest)")
  void testGetAnonymousCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor = new CustomerStateRequestProcessor();

    // Act and Assert
    assertNull(customerStateRequestProcessor.getAnonymousCustomer(new ServletWebRequest(new MockHttpServletRequest())));
  }

  /**
   * Test {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName("Test getAnonymousCustomer(WebRequest)")
  @Disabled("TODO: Complete this test")
  void testGetAnonymousCustomer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1053 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor customerStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateRequestProcessor customerStateRequestProcessor2 = new CustomerStateRequestProcessor();

    // Act
    customerStateRequestProcessor2.getAnonymousCustomer(new ServletWebRequest(new MockHttpServletRequest()));
  }

  /**
   * Test {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#getAnonymousCustomer(WebRequest)}
   */
  @Test
  @DisplayName("Test getAnonymousCustomer(WebRequest); given 'false'; then calls getAttribute(String, int)")
  void testGetAnonymousCustomer_givenFalse_thenCallsGetAttribute() {
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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

  /**
   * Test {@link CustomerStateRequestProcessor#getCustomerRequestAttributeName()}.
   * <p>
   * Method under test:
   * {@link CustomerStateRequestProcessor#getCustomerRequestAttributeName()}
   */
  @Test
  @DisplayName("Test getCustomerRequestAttributeName()")
  @Disabled("TODO: Complete this test")
  void testGetCustomerRequestAttributeName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.getRequestCustomerResolver(BroadleafRequestCustomerResolverImpl.java:79)
    //       at org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor.getCustomerRequestAttributeName(CustomerStateRequestProcessor.java:366)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    CustomerStateRequestProcessor.getCustomerRequestAttributeName();
  }
}
