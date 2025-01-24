package org.broadleafcommerce.core.web.geolocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class GeolocationRequestProcessorDiffblueTest {
  @Autowired
  private GeolocationRequestProcessor geolocationRequestProcessor;

  /**
   * Test {@link GeolocationRequestProcessor#process(WebRequest)}.
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
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
    //   package org.broadleafcommerce.core.web.geolocation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4186 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.geolocation.GeolocationRequestProcessor geolocationRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor2 = new GeolocationRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    geolocationRequestProcessor2
        .process(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link GeolocationRequestProcessor#isGeolocationEnabled()}.
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#isGeolocationEnabled()}
   */
  @Test
  @DisplayName("Test isGeolocationEnabled()")
  @Disabled("TODO: Complete this test")
  void testIsGeolocationEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.geolocation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4185 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.geolocation.GeolocationRequestProcessor geolocationRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new GeolocationRequestProcessor()).isGeolocationEnabled();
  }

  /**
   * Test {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}.
   * <p>
   * Method under test:
   * {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getIPAddress(ServletWebRequest)")
  @Disabled("TODO: Complete this test")
  void testGetIPAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.geolocation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3849 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.geolocation.GeolocationRequestProcessor geolocationRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor2 = new GeolocationRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    geolocationRequestProcessor2
        .getIPAddress(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}.
   * <ul>
   *   <li>Given {@code 42 Main St}.</li>
   *   <li>Then return {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getIPAddress(ServletWebRequest); given '42 Main St'; then return '42 Main St'")
  void testGetIPAddress_given42MainSt_thenReturn42MainSt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRemoteAddr()).thenReturn("42 Main St");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("");

    // Act
    String actualIPAddress = geolocationRequestProcessor
        .getIPAddress(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(servletRequest).getRemoteAddr();
    verify(servletRequest).getHeader(eq("X-FORWARDED-FOR"));
    assertEquals("42 Main St", actualIPAddress);
  }

  /**
   * Test {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getIPAddress(ServletWebRequest); given 'https://example.org/example'; then return 'https://example.org/example'")
  void testGetIPAddress_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualIPAddress = geolocationRequestProcessor
        .getIPAddress(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(servletRequest).getHeader(eq("X-FORWARDED-FOR"));
    assertEquals("https://example.org/example", actualIPAddress);
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   * <p>
   * Method under test:
   * {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest)")
  void testGetRuleMapFromRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertTrue(geolocationRequestProcessor
        .getRuleMapFromRequest(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))))
        .isEmpty());
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   * <p>
   * Method under test:
   * {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest)")
  void testGetRuleMapFromRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();

    // Act and Assert
    assertTrue(
        geolocationRequestProcessor
            .getRuleMapFromRequest(
                new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(new MockHttpServletRequest(),
                    mock(Environment.class), new String[]{"White List Param Names"}))))
            .isEmpty());
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   * <p>
   * Method under test:
   * {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest)")
  @Disabled("TODO: Complete this test")
  void testGetRuleMapFromRequest3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.geolocation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4015 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.geolocation.GeolocationRequestProcessor geolocationRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor2 = new GeolocationRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    geolocationRequestProcessor2
        .getRuleMapFromRequest(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest); given HashMap(); then calls getAttribute(String, int)")
  void testGetRuleMapFromRequest_givenHashMap_thenCallsGetAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(new HashMap<>());

    // Act
    Map<String, Object> actualRuleMapFromRequest = geolocationRequestProcessor.getRuleMapFromRequest(request);

    // Assert
    verify(request).getAttribute(eq("blRuleMap"), eq(0));
    assertTrue(actualRuleMapFromRequest.isEmpty());
  }
}
