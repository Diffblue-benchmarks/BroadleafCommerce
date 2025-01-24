package org.broadleafcommerce.core.web.order.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
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

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class CartStateRequestProcessorDiffblueTest {
  @Autowired
  private CartStateRequestProcessor cartStateRequestProcessor;

  /**
   * Test {@link CartStateRequestProcessor#process(WebRequest)}.
   * <p>
   * Method under test: {@link CartStateRequestProcessor#process(WebRequest)}
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
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8508 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.CartStateRequestProcessor cartStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor2 = new CartStateRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    cartStateRequestProcessor2
        .process(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test
   * {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}.
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}
   */
  @Test
  @DisplayName("Test updateCartRequestAttributes(WebRequest, Order)")
  @Disabled("TODO: Complete this test")
  void testUpdateCartRequestAttributes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8678 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.CartStateRequestProcessor cartStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor2 = new CartStateRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    cartStateRequestProcessor2.updateCartRequestAttributes(request, new NullOrderImpl());
  }

  /**
   * Test
   * {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}
   */
  @Test
  @DisplayName("Test updateCartRequestAttributes(WebRequest, Order); given HashMap(); then calls getAttribute(String, int)")
  void testUpdateCartRequestAttributes_givenHashMap_thenCallsGetAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();
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
   * Method under test:
   * {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest)")
  void testGetOverrideCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull(cartStateRequestProcessor
        .getOverrideCart(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})))));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest)")
  void testGetOverrideCart2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();

    // Act and Assert
    assertNull(cartStateRequestProcessor.getOverrideCart(
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(new MockHttpServletRequest(),
            mock(Environment.class), new String[]{"White List Param Names"})))));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest)")
  @Disabled("TODO: Complete this test")
  void testGetOverrideCart3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7946 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.CartStateRequestProcessor cartStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor2 = new CartStateRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    cartStateRequestProcessor2
        .getOverrideCart(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest); given 'false'; then calls getAttribute(String, int)")
  void testGetOverrideCart_givenFalse_thenCallsGetAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();
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
   * Method under test:
   * {@link CartStateRequestProcessor#mergeCartNeeded(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCartNeeded(Customer, WebRequest)")
  @Disabled("TODO: Complete this test")
  void testMergeCartNeeded() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8312 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.CartStateRequestProcessor cartStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor2 = new CartStateRequestProcessor();
    CustomerImpl customer = new CustomerImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    cartStateRequestProcessor2.mergeCartNeeded(customer,
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}.
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#mergeCart(Customer, WebRequest)}
   */
  @Test
  @DisplayName("Test mergeCart(Customer, WebRequest)")
  @Disabled("TODO: Complete this test")
  void testMergeCart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8116 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.CartStateRequestProcessor cartStateRequestProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor2 = new CartStateRequestProcessor();
    CustomerImpl customer = new CustomerImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    cartStateRequestProcessor2.mergeCart(customer,
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CartStateRequestProcessor#getCartRequestAttributeName()}
   *   <li>{@link CartStateRequestProcessor#setCartRequestAttributeName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();

    // Act
    String actualCartRequestAttributeName = cartStateRequestProcessor.getCartRequestAttributeName();
    cartStateRequestProcessor.setCartRequestAttributeName("Cart Request Attribute Name");

    // Assert
    assertEquals("Cart Request Attribute Name", actualCartRequestAttributeName);
  }
}
