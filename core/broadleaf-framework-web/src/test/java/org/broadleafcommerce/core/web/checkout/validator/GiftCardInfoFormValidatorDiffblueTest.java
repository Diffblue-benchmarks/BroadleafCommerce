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
package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.core.web.checkout.model.GiftCardInfoForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class GiftCardInfoFormValidatorDiffblueTest {
  /**
   * Test {@link GiftCardInfoFormValidator#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardInfoFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  void testSupports_thenReturnTrue() {
    // Arrange
    GiftCardInfoFormValidator giftCardInfoFormValidator = new GiftCardInfoFormValidator();
    Class<GiftCardInfoForm> clazz = GiftCardInfoForm.class;

    // Act and Assert
    assertTrue(giftCardInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link GiftCardInfoFormValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardInfoFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    GiftCardInfoFormValidator giftCardInfoFormValidator = new GiftCardInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(giftCardInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link GiftCardInfoFormValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link GiftCardInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate() {
    // Arrange
    GiftCardInfoFormValidator giftCardInfoFormValidator = new GiftCardInfoFormValidator();

    GiftCardInfoForm giftCardInfoForm = new GiftCardInfoForm();
    giftCardInfoForm.setGiftCardEmailAddress("42 Main St");
    giftCardInfoForm.setGiftCardNumber("42");

    // Act
    assertDoesNotThrow(() -> giftCardInfoFormValidator.validate(giftCardInfoForm,
        new BindException(giftCardInfoForm, "org.broadleafcommerce.core.web.checkout.model.GiftCardInfoForm")));
  }
}
