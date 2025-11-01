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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.core.web.checkout.model.CreditCardInfoForm;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class CreditCardInfoFormValidatorDiffblueTest {
  /**
   * Method under test: {@link CreditCardInfoFormValidator#supports(Class)}
   */
  @Test
  void testSupports() {
    // Arrange
    CreditCardInfoFormValidator creditCardInfoFormValidator = new CreditCardInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(creditCardInfoFormValidator.supports(clazz));
  }

  /**
   * Method under test: {@link CreditCardInfoFormValidator#supports(Class)}
   */
  @Test
  void testSupports2() {
    // Arrange
    CreditCardInfoFormValidator creditCardInfoFormValidator = new CreditCardInfoFormValidator();
    Class<CreditCardInfoForm> clazz = CreditCardInfoForm.class;

    // Act and Assert
    assertTrue(creditCardInfoFormValidator.supports(clazz));
  }

  /**
   * Method under test:
   * {@link CreditCardInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  void testValidate() {
    // Arrange
    CreditCardInfoFormValidator creditCardInfoFormValidator = new CreditCardInfoFormValidator();

    CreditCardInfoForm creditCardInfoForm = new CreditCardInfoForm();
    creditCardInfoForm.setCreditCardCvvCode("Credit Card Cvv Code");
    creditCardInfoForm.setCreditCardExpMonth("Credit Card Exp Month");
    creditCardInfoForm.setCreditCardExpYear("Credit Card Exp Year");
    creditCardInfoForm.setCreditCardName("Credit Card Name");
    creditCardInfoForm.setCreditCardNumber("42");
    creditCardInfoForm.setPaymentMethod("Payment Method");
    creditCardInfoForm.setSelectedCreditCardType("Selected Credit Card Type");

    // Act
    assertDoesNotThrow(() -> creditCardInfoFormValidator.validate(creditCardInfoForm,
        new BindException(creditCardInfoForm, "org.broadleafcommerce.core.web.checkout.model.CreditCardInfoForm")));
  }
}
