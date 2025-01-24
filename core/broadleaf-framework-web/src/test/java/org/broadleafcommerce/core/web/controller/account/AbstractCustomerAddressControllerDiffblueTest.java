package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;

class AbstractCustomerAddressControllerDiffblueTest {
  /**
   * Test
   * {@link AbstractCustomerAddressController#initBinder(HttpServletRequest, ServletRequestDataBinder)}.
   * <p>
   * Method under test:
   * {@link AbstractCustomerAddressController#initBinder(HttpServletRequest, ServletRequestDataBinder)}
   */
  @Test
  @DisplayName("Test initBinder(HttpServletRequest, ServletRequestDataBinder)")
  @Disabled("TODO: Complete this test")
  void testInitBinder() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.AbstractCustomerAddressController.initBinder(AbstractCustomerAddressController.java:84)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    AbstractCustomerAddressController abstractCustomerAddressController = new AbstractCustomerAddressController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    abstractCustomerAddressController.initBinder(request, new ServletRequestDataBinder("Target", "Object Name"));
  }

  /**
   * Test {@link AbstractCustomerAddressController#populateStates()}.
   * <p>
   * Method under test: {@link AbstractCustomerAddressController#populateStates()}
   */
  @Test
  @DisplayName("Test populateStates()")
  @Disabled("TODO: Complete this test")
  void testPopulateStates() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.AbstractCustomerAddressController.populateStates(AbstractCustomerAddressController.java:88)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new AbstractCustomerAddressController()).populateStates();
  }

  /**
   * Test {@link AbstractCustomerAddressController#populateCountries()}.
   * <p>
   * Method under test:
   * {@link AbstractCustomerAddressController#populateCountries()}
   */
  @Test
  @DisplayName("Test populateCountries()")
  @Disabled("TODO: Complete this test")
  void testPopulateCountries() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.AbstractCustomerAddressController.populateCountries(AbstractCustomerAddressController.java:92)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new AbstractCustomerAddressController()).populateCountries();
  }

  /**
   * Test {@link AbstractCustomerAddressController#populateCustomerAddresses()}.
   * <p>
   * Method under test:
   * {@link AbstractCustomerAddressController#populateCustomerAddresses()}
   */
  @Test
  @DisplayName("Test populateCustomerAddresses()")
  @Disabled("TODO: Complete this test")
  void testPopulateCustomerAddresses() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.AbstractCustomerAddressController.populateCustomerAddresses(AbstractCustomerAddressController.java:96)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new AbstractCustomerAddressController()).populateCustomerAddresses();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link AbstractCustomerAddressController}
   *   <li>{@link AbstractCustomerAddressController#getCustomerAddressesRedirect()}
   *   <li>{@link AbstractCustomerAddressController#getCustomerAddressesView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AbstractCustomerAddressController actualAbstractCustomerAddressController = new AbstractCustomerAddressController();
    String actualCustomerAddressesRedirect = actualAbstractCustomerAddressController.getCustomerAddressesRedirect();

    // Assert
    assertEquals("account/manageCustomerAddresses", actualAbstractCustomerAddressController.getCustomerAddressesView());
    assertEquals("redirect:/account/addresses", actualCustomerAddressesRedirect);
  }
}
