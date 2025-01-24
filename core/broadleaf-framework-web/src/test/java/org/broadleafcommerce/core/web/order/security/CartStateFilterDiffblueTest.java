package org.broadleafcommerce.core.web.order.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class CartStateFilterDiffblueTest {
  @Autowired
  private CartStateFilter cartStateFilter;

  /**
   * Test
   * {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link CartStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)")
  @Disabled("TODO: Complete this test")
  void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7565 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.CartStateFilter cartStateFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CartStateFilter cartStateFilter2 = new CartStateFilter();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    cartStateFilter2.doFilterInternalUnlessIgnored(request, new MockHttpServletResponse(), mock(FilterChain.class));
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <p>
   * Method under test:
   * {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest)")
  @Disabled("TODO: Complete this test")
  void testRequestRequiresLock() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7780 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.CartStateFilter cartStateFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CartStateFilter cartStateFilter2 = new CartStateFilter();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    cartStateFilter2.requestRequiresLock(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); when 'null'; then return 'false'")
  void testRequestRequiresLock_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CartStateFilter()).requestRequiresLock(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CartStateFilter#setExcludedOrderLockRequestPatterns(List)}
   *   <li>{@link CartStateFilter#getExcludedOrderLockRequestPatterns()}
   *   <li>{@link CartStateFilter#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CartStateFilter cartStateFilter = new CartStateFilter();
    ArrayList<String> excludedOrderLockRequestPatterns = new ArrayList<>();

    // Act
    cartStateFilter.setExcludedOrderLockRequestPatterns(excludedOrderLockRequestPatterns);
    List<String> actualExcludedOrderLockRequestPatterns = cartStateFilter.getExcludedOrderLockRequestPatterns();

    // Assert that nothing has changed
    assertEquals(1000000, cartStateFilter.getOrder());
    assertTrue(actualExcludedOrderLockRequestPatterns.isEmpty());
    assertSame(excludedOrderLockRequestPatterns, actualExcludedOrderLockRequestPatterns);
  }

  /**
   * Test {@link CartStateFilter#getErrorInsteadOfQueue()}.
   * <p>
   * Method under test: {@link CartStateFilter#getErrorInsteadOfQueue()}
   */
  @Test
  @DisplayName("Test getErrorInsteadOfQueue()")
  @Disabled("TODO: Complete this test")
  void testGetErrorInsteadOfQueue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7774 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.CartStateFilter cartStateFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateFilter()).getErrorInsteadOfQueue();
  }

  /**
   * Test {@link CartStateFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test: {@link CartStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch()")
  void testShouldNotFilterErrorDispatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateFilter cartStateFilter = new CartStateFilter();
    cartStateFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(cartStateFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link CartStateFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test: {@link CartStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch()")
  @Disabled("TODO: Complete this test")
  void testShouldNotFilterErrorDispatch2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7940 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.CartStateFilter cartStateFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CartStateFilter()).shouldNotFilterErrorDispatch();
  }

  /**
   * Test {@link CartStateFilter#shouldNotFilterErrorDispatch()}.
   * <ul>
   *   <li>Given {@link CartStateFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch(); given CartStateFilter (default constructor)")
  void testShouldNotFilterErrorDispatch_givenCartStateFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CartStateFilter()).shouldNotFilterErrorDispatch());
  }
}
