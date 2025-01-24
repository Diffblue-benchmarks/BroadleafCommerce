package org.broadleafcommerce.profile.web.core;

import static org.junit.jupiter.api.Assertions.assertNull;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class CustomerStateDiffblueTest {
  /**
   * Test {@link CustomerState#getCustomer()}.
   * <p>
   * Method under test: {@link CustomerState#getCustomer()}
   */
  @Test
  @DisplayName("Test getCustomer()")
  void testGetCustomer() {
    // Arrange, Act and Assert
    assertNull(CustomerState.getCustomer());
  }

  /**
   * Test {@link CustomerState#getCustomer(HttpServletRequest)} with
   * {@code HttpServletRequest}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerState#getCustomer(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getCustomer(HttpServletRequest) with 'HttpServletRequest'; when MockHttpServletRequest()")
  @Disabled("TODO: Complete this test")
  void testGetCustomerWithHttpServletRequest_whenMockHttpServletRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.getRequestCustomerResolver(BroadleafRequestCustomerResolverImpl.java:79)
    //       at org.broadleafcommerce.profile.web.core.CustomerState.getCustomer(CustomerState.java:39)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    CustomerState.getCustomer(new MockHttpServletRequest());
  }

  /**
   * Test {@link CustomerState#getCustomer(WebRequest)} with {@code WebRequest}.
   * <p>
   * Method under test: {@link CustomerState#getCustomer(WebRequest)}
   */
  @Test
  @DisplayName("Test getCustomer(WebRequest) with 'WebRequest'")
  @Disabled("TODO: Complete this test")
  void testGetCustomerWithWebRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.getRequestCustomerResolver(BroadleafRequestCustomerResolverImpl.java:79)
    //       at org.broadleafcommerce.profile.web.core.CustomerState.getCustomer(CustomerState.java:43)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    CustomerState.getCustomer(new ServletWebRequest(new MockHttpServletRequest()));
  }

  /**
   * Test {@link CustomerState#setCustomer(Customer)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerState#setCustomer(Customer)}
   */
  @Test
  @DisplayName("Test setCustomer(Customer); when CustomerImpl (default constructor)")
  @Disabled("TODO: Complete this test")
  void testSetCustomer_whenCustomerImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.getRequestCustomerResolver(BroadleafRequestCustomerResolverImpl.java:79)
    //       at org.broadleafcommerce.profile.web.core.CustomerState.setCustomer(CustomerState.java:55)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    CustomerState.setCustomer(new CustomerImpl());
  }
}
