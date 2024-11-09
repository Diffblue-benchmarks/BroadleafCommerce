/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreditCardInfoFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CreditCardInfoForm}
   *   <li>{@link CreditCardInfoForm#setCreditCardCvvCode(String)}
   *   <li>{@link CreditCardInfoForm#setCreditCardExpMonth(String)}
   *   <li>{@link CreditCardInfoForm#setCreditCardExpYear(String)}
   *   <li>{@link CreditCardInfoForm#setCreditCardName(String)}
   *   <li>{@link CreditCardInfoForm#setCreditCardNumber(String)}
   *   <li>{@link CreditCardInfoForm#setPaymentMethod(String)}
   *   <li>{@link CreditCardInfoForm#setSelectedCreditCardType(String)}
   *   <li>{@link CreditCardInfoForm#getCreditCardCvvCode()}
   *   <li>{@link CreditCardInfoForm#getCreditCardExpMonth()}
   *   <li>{@link CreditCardInfoForm#getCreditCardExpYear()}
   *   <li>{@link CreditCardInfoForm#getCreditCardName()}
   *   <li>{@link CreditCardInfoForm#getCreditCardNumber()}
   *   <li>{@link CreditCardInfoForm#getPaymentMethod()}
   *   <li>{@link CreditCardInfoForm#getSelectedCreditCardType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CreditCardInfoForm actualCreditCardInfoForm = new CreditCardInfoForm();
    actualCreditCardInfoForm.setCreditCardCvvCode("Credit Card Cvv Code");
    actualCreditCardInfoForm.setCreditCardExpMonth("Credit Card Exp Month");
    actualCreditCardInfoForm.setCreditCardExpYear("Credit Card Exp Year");
    actualCreditCardInfoForm.setCreditCardName("Credit Card Name");
    actualCreditCardInfoForm.setCreditCardNumber("42");
    actualCreditCardInfoForm.setPaymentMethod("Payment Method");
    actualCreditCardInfoForm.setSelectedCreditCardType("Selected Credit Card Type");
    String actualCreditCardCvvCode = actualCreditCardInfoForm.getCreditCardCvvCode();
    String actualCreditCardExpMonth = actualCreditCardInfoForm.getCreditCardExpMonth();
    String actualCreditCardExpYear = actualCreditCardInfoForm.getCreditCardExpYear();
    String actualCreditCardName = actualCreditCardInfoForm.getCreditCardName();
    String actualCreditCardNumber = actualCreditCardInfoForm.getCreditCardNumber();
    String actualPaymentMethod = actualCreditCardInfoForm.getPaymentMethod();

    // Assert that nothing has changed
    assertEquals("42", actualCreditCardNumber);
    assertEquals("Credit Card Cvv Code", actualCreditCardCvvCode);
    assertEquals("Credit Card Exp Month", actualCreditCardExpMonth);
    assertEquals("Credit Card Exp Year", actualCreditCardExpYear);
    assertEquals("Credit Card Name", actualCreditCardName);
    assertEquals("Payment Method", actualPaymentMethod);
    assertEquals("Selected Credit Card Type", actualCreditCardInfoForm.getSelectedCreditCardType());
  }
}
