package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class BroadleafManageCustomerPaymentsControllerDiffblueTest {
  /**
   * Test {@link BroadleafManageCustomerPaymentsController#viewCustomerPayments(HttpServletRequest,
   * Model, PaymentInfoForm)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerPaymentsController#viewCustomerPayments(HttpServletRequest, Model,
   * PaymentInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerPaymentsController.viewCustomerPayments(HttpServletRequest, Model, PaymentInfoForm)"
  })
  public void testViewCustomerPayments() {
    // Arrange
    BroadleafManageCustomerPaymentsController broadleafManageCustomerPaymentsController =
        new BroadleafManageCustomerPaymentsController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafManageCustomerPaymentsController.viewCustomerPayments(
                request, model, new PaymentInfoForm()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafManageCustomerPaymentsController}
   *   <li>{@link BroadleafManageCustomerPaymentsController#getCustomerPaymentRedirect()}
   *   <li>{@link BroadleafManageCustomerPaymentsController#getCustomerPaymentView()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerPaymentsController.<init>()",
    "String BroadleafManageCustomerPaymentsController.getCustomerPaymentRedirect()",
    "String BroadleafManageCustomerPaymentsController.getCustomerPaymentView()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafManageCustomerPaymentsController actualBroadleafManageCustomerPaymentsController =
        new BroadleafManageCustomerPaymentsController();
    String actualCustomerPaymentRedirect =
        actualBroadleafManageCustomerPaymentsController.getCustomerPaymentRedirect();

    // Assert
    assertEquals(
        "account/manageCustomerPayments",
        actualBroadleafManageCustomerPaymentsController.getCustomerPaymentView());
    assertEquals("redirect:/account/payments", actualCustomerPaymentRedirect);
  }
}
