package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

class BroadleafManageCustomerPaymentsControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafManageCustomerPaymentsController#viewCustomerPayments(HttpServletRequest, Model, PaymentInfoForm)}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerPaymentsController#viewCustomerPayments(HttpServletRequest, Model, PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test viewCustomerPayments(HttpServletRequest, Model, PaymentInfoForm); then throw SecurityException")
  void testViewCustomerPayments_thenThrowSecurityException() {
    // Arrange
    BroadleafManageCustomerPaymentsController broadleafManageCustomerPaymentsController = new BroadleafManageCustomerPaymentsController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafManageCustomerPaymentsController.viewCustomerPayments(request, model, new PaymentInfoForm()));
  }

  /**
   * Test
   * {@link BroadleafManageCustomerPaymentsController#addCustomerPayment(HttpServletRequest, Model, PaymentInfoForm, BindingResult)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerPaymentsController#addCustomerPayment(HttpServletRequest, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test addCustomerPayment(HttpServletRequest, Model, PaymentInfoForm, BindingResult); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testAddCustomerPayment_whenConcurrentModel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerPaymentsController.addCustomerPayment(BroadleafManageCustomerPaymentsController.java:85)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafManageCustomerPaymentsController broadleafManageCustomerPaymentsController = new BroadleafManageCustomerPaymentsController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();

    // Act
    broadleafManageCustomerPaymentsController.addCustomerPayment(request, model, paymentInfoForm,
        new BindException("Target", "Object Name"));
  }

  /**
   * Test
   * {@link BroadleafManageCustomerPaymentsController#makeDefaultCustomerPayment(HttpServletRequest, Model, Long)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerPaymentsController#makeDefaultCustomerPayment(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test makeDefaultCustomerPayment(HttpServletRequest, Model, Long); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testMakeDefaultCustomerPayment_whenConcurrentModel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerPaymentsController.makeDefaultCustomerPayment(BroadleafManageCustomerPaymentsController.java:111)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafManageCustomerPaymentsController broadleafManageCustomerPaymentsController = new BroadleafManageCustomerPaymentsController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    broadleafManageCustomerPaymentsController.makeDefaultCustomerPayment(request, new ConcurrentModel(), 1L);
  }

  /**
   * Test
   * {@link BroadleafManageCustomerPaymentsController#removeCustomerPayment(HttpServletRequest, Model, Long)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerPaymentsController#removeCustomerPayment(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test removeCustomerPayment(HttpServletRequest, Model, Long); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testRemoveCustomerPayment_whenConcurrentModel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerPaymentsController.removeCustomerPayment(BroadleafManageCustomerPaymentsController.java:123)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafManageCustomerPaymentsController broadleafManageCustomerPaymentsController = new BroadleafManageCustomerPaymentsController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    broadleafManageCustomerPaymentsController.removeCustomerPayment(request, new ConcurrentModel(), 1L);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafManageCustomerPaymentsController}
   *   <li>
   * {@link BroadleafManageCustomerPaymentsController#getCustomerPaymentRedirect()}
   *   <li>
   * {@link BroadleafManageCustomerPaymentsController#getCustomerPaymentView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafManageCustomerPaymentsController actualBroadleafManageCustomerPaymentsController = new BroadleafManageCustomerPaymentsController();
    String actualCustomerPaymentRedirect = actualBroadleafManageCustomerPaymentsController.getCustomerPaymentRedirect();

    // Assert
    assertEquals("account/manageCustomerPayments",
        actualBroadleafManageCustomerPaymentsController.getCustomerPaymentView());
    assertEquals("redirect:/account/payments", actualCustomerPaymentRedirect);
  }
}
