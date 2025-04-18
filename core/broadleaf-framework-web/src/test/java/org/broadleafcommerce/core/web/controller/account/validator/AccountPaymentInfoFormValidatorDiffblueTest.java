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
package org.broadleafcommerce.core.web.controller.account.validator;

import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class AccountPaymentInfoFormValidatorDiffblueTest {
  /**
   * Test {@link AccountPaymentInfoFormValidator#validate(Object, Errors)} with
   * {@code obj}, {@code errors}.
   * <ul>
   *   <li>When {@link PaymentInfoForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccountPaymentInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors) with 'obj', 'errors'; when PaymentInfoForm (default constructor)")
  @Disabled("TODO: Complete this test")
  void testValidateWithObjErrors_whenPaymentInfoForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty(BLCSystemProperty.java:72)
    //       at org.broadleafcommerce.common.web.validator.BroadleafCommonAddressValidator.isCustomValidationEnabled(BroadleafCommonAddressValidator.java:49)
    //       at org.broadleafcommerce.common.web.validator.BroadleafCommonAddressValidator.validate(BroadleafCommonAddressValidator.java:53)
    //       at org.broadleafcommerce.core.web.checkout.validator.PaymentInfoFormValidator.validate(PaymentInfoFormValidator.java:37)
    //       at org.broadleafcommerce.core.web.controller.account.validator.AccountPaymentInfoFormValidator.validate(AccountPaymentInfoFormValidator.java:33)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    AccountPaymentInfoFormValidator accountPaymentInfoFormValidator = new AccountPaymentInfoFormValidator();
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();

    // Act
    accountPaymentInfoFormValidator.validate(paymentInfoForm, new BindException("Target", "Object Name"));
  }
}
