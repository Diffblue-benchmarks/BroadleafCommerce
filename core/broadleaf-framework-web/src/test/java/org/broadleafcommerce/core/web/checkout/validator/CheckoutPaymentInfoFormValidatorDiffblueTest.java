package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

public class CheckoutPaymentInfoFormValidatorDiffblueTest {
  /**
   * Test {@link CheckoutPaymentInfoFormValidator#validate(Object, Errors)} with {@code obj}, {@code
   * errors}.
   *
   * <p>Method under test: {@link CheckoutPaymentInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CheckoutPaymentInfoFormValidator.validate(Object, Errors)"})
  public void testValidateWithObjErrors() {
    // Arrange
    CheckoutPaymentInfoFormValidator checkoutPaymentInfoFormValidator =
        new CheckoutPaymentInfoFormValidator();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setShouldUseCustomerPayment(true);
    BindException errors =
        new BindException(
            paymentInfoForm, "org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm");

    // Act
    checkoutPaymentInfoFormValidator.validate(paymentInfoForm, errors);

    // Assert
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm' on field"
            + " 'customerPaymentId': rejected value [null]; codes [checkout.paymentMethod.customerPaymentId.required"
            + ".org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm.customerPaymentId,checkout.paymentMethod"
            + ".customerPaymentId.required.customerPaymentId,checkout.paymentMethod.customerPaymentId.required.java"
            + ".lang.Long,checkout.paymentMethod.customerPaymentId.required]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm' on field"
            + " 'customerPaymentId': rejected value [null]; codes [checkout.paymentMethod.customerPaymentId.required"
            + ".org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm.customerPaymentId,checkout.paymentMethod"
            + ".customerPaymentId.required.customerPaymentId,checkout.paymentMethod.customerPaymentId.required.java"
            + ".lang.Long,checkout.paymentMethod.customerPaymentId.required]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals(1, errors.getAllErrors().size());
    assertEquals(1, errors.getErrorCount());
    assertEquals(1, errors.getFieldErrorCount());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
  }
}
