/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class CheckoutPaymentInfoFormValidatorDiffblueTest {
  /**
   * Test {@link CheckoutPaymentInfoFormValidator#validate(Object, Errors)} with {@code obj}, {@code
   * errors}.
   *
   * <p>Method under test: {@link CheckoutPaymentInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors) with 'obj', 'errors'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CheckoutPaymentInfoFormValidator.validate(Object, Errors)"})
  void testValidateWithObjErrors() {
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
