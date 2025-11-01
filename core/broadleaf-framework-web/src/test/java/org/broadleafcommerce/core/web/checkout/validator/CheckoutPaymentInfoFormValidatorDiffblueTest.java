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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

class CheckoutPaymentInfoFormValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link CheckoutPaymentInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  void testValidate() {
    // Arrange
    CheckoutPaymentInfoFormValidator checkoutPaymentInfoFormValidator = new CheckoutPaymentInfoFormValidator();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setShouldUseCustomerPayment(true);
    BindException errors = new BindException(paymentInfoForm,
        "org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm");

    // Act
    checkoutPaymentInfoFormValidator.validate(paymentInfoForm, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    FieldError fieldError = errors.getFieldError();
    assertEquals("checkout.paymentMethod.customerPaymentId.required", fieldError.getCode());
    assertEquals("customerPaymentId", fieldError.getField());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm", fieldError.getObjectName());
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
    assertNull(fieldError.getArguments());
    assertNull(fieldError.getRejectedValue());
    assertNull(fieldError.getDefaultMessage());
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(1, allErrors.size());
    List<FieldError> fieldErrors = errors.getFieldErrors();
    assertEquals(1, fieldErrors.size());
    assertEquals(1, errors.getErrorCount());
    assertEquals(1, errors.getFieldErrorCount());
    assertFalse(fieldError.isBindingFailure());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
    assertEquals(errors, bindingResult);
    assertSame(fieldError, fieldErrors.get(0));
    assertSame(fieldError, allErrors.get(0));
    assertArrayEquals(new String[]{
        "checkout.paymentMethod.customerPaymentId.required.org.broadleafcommerce.core.web.checkout.model"
            + ".PaymentInfoForm.customerPaymentId",
        "checkout.paymentMethod.customerPaymentId.required.customerPaymentId",
        "checkout.paymentMethod.customerPaymentId.required.java.lang.Long",
        "checkout.paymentMethod.customerPaymentId.required"}, fieldError.getCodes());
  }
}
