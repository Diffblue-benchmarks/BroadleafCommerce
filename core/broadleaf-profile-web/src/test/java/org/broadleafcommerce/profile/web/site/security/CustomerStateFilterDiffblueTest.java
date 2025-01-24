package org.broadleafcommerce.profile.web.site.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-web-applicationContext.xml",
    "/blc-config/site/bl-profile-web-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class CustomerStateFilterDiffblueTest {
  @Autowired
  private CustomerStateFilter customerStateFilter;

  /**
   * Test
   * {@link CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
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
    //   package org.broadleafcommerce.profile.web.site.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2378 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.site.security.CustomerStateFilter customerStateFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateFilter customerStateFilter2 = new CustomerStateFilter();
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();

    // Act
    customerStateFilter2.doFilterInternalUnlessIgnored(baseRequest, new MockHttpServletResponse(),
        mock(FilterChain.class));
  }

  /**
   * Test
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test isIgnored(HttpServletRequest, HttpServletResponse)")
  @Disabled("TODO: Complete this test")
  void testIsIgnored() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.site.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2504 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.site.security.CustomerStateFilter customerStateFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateFilter customerStateFilter2 = new CustomerStateFilter();
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

    // Act
    customerStateFilter2.isIgnored(httpServletRequest, new MockHttpServletResponse());
  }

  /**
   * Test
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test isIgnored(HttpServletRequest, HttpServletResponse); given 'false'")
  void testIsIgnored_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualIsIgnoredResult = customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse());

    // Assert
    verify(httpServletRequest, atLeast(1)).getAttribute(Mockito.<String>any());
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test isIgnored(HttpServletRequest, HttpServletResponse); given 'true'")
  void testIsIgnored_givenTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsIgnoredResult = customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse());

    // Assert
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test isIgnored(HttpServletRequest, HttpServletResponse); when MockHttpServletRequest(); then return 'false'")
  void testIsIgnored_whenMockHttpServletRequest_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse()));
  }

  /**
   * Test {@link CustomerStateFilter#getOrder()}.
   * <p>
   * Method under test: {@link CustomerStateFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Disabled("TODO: Complete this test")
  void testGetOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.site.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2499 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.site.security.CustomerStateFilter customerStateFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerStateFilter()).getOrder();
  }

  /**
   * Test {@link CustomerStateFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link CustomerStateFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerStateFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder(); given CustomerStateFilter (default constructor)")
  void testGetOrder_givenCustomerStateFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10050, (new CustomerStateFilter()).getOrder());
  }

  /**
   * Test {@link CustomerStateFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link CustomerStateFilter} (default constructor) Environment is
   * {@link StandardEnvironment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerStateFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder(); given CustomerStateFilter (default constructor) Environment is StandardEnvironment")
  void testGetOrder_givenCustomerStateFilterEnvironmentIsStandardEnvironment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    customerStateFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(10050, customerStateFilter.getOrder());
  }

  /**
   * Test {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test: {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch()")
  void testShouldNotFilterErrorDispatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    customerStateFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(customerStateFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test: {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}
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
    //   package org.broadleafcommerce.profile.web.site.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2616 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.site.security.CustomerStateFilter customerStateFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerStateFilter()).shouldNotFilterErrorDispatch();
  }

  /**
   * Test {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}.
   * <ul>
   *   <li>Given {@link CustomerStateFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch(); given CustomerStateFilter (default constructor)")
  void testShouldNotFilterErrorDispatch_givenCustomerStateFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CustomerStateFilter()).shouldNotFilterErrorDispatch());
  }
}
