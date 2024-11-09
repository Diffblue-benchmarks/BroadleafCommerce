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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

class OrderInfoFormValidatorDiffblueTest {
  /**
   * Test {@link OrderInfoFormValidator#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderInfoFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  void testSupports_thenReturnTrue() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();
    Class<OrderInfoForm> clazz = OrderInfoForm.class;

    // Act and Assert
    assertTrue(orderInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link OrderInfoFormValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderInfoFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main St");
    BindException errors = new BindException(orderInfoForm,
        "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("42 Main St", fieldError.getRejectedValue());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value [42 Main St]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
        + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
        + ",emailAddress.invalid]; arguments []; default message [null]", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value [42 Main St]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
        + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
        + ",emailAddress.invalid]; arguments []; default message [null]", errors.getMessage());
    assertArrayEquals(
        new String[]{"emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.invalid.emailAddress", "emailAddress.invalid.java.lang.String", "emailAddress.invalid"},
        fieldError.getCodes());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate2() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("17 High St");
    BindException errors = new BindException(orderInfoForm,
        "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("17 High St", fieldError.getRejectedValue());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value [17 High St]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
        + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
        + ",emailAddress.invalid]; arguments []; default message [null]", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value [17 High St]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
        + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
        + ",emailAddress.invalid]; arguments []; default message [null]", errors.getMessage());
    assertArrayEquals(
        new String[]{"emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.invalid.emailAddress", "emailAddress.invalid.java.lang.String", "emailAddress.invalid"},
        fieldError.getCodes());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate3() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("jane.doe@example.org");
    BindException errors = new BindException(orderInfoForm,
        "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertNull(bindingResult.getFieldError());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getFieldErrorCount());
    assertEquals(0, bindingResult.getErrorCount());
    assertEquals(0, bindingResult.getFieldErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasFieldErrors());
    assertFalse(bindingResult.hasErrors());
    assertFalse(bindingResult.hasFieldErrors());
    assertTrue(errors.getAllErrors().isEmpty());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate4() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("U@U");
    BindException errors = new BindException(orderInfoForm,
        "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("U@U", fieldError.getRejectedValue());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value [U@U]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
        + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
        + ",emailAddress.invalid]; arguments []; default message [null]", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value [U@U]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
        + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
        + ",emailAddress.invalid]; arguments []; default message [null]", errors.getMessage());
    assertArrayEquals(
        new String[]{"emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.invalid.emailAddress", "emailAddress.invalid.java.lang.String", "emailAddress.invalid"},
        fieldError.getCodes());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate5() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("");
    BindException errors = new BindException(orderInfoForm,
        "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("", fieldError.getRejectedValue());
    assertEquals("emailAddress.required", fieldError.getCode());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value []; codes [emailAddress.required.org.broadleafcommerce.core.web.checkout.model"
        + ".OrderInfoForm.emailAddress,emailAddress.required.emailAddress,emailAddress.required.java.lang.String"
        + ",emailAddress.required]; arguments []; default message [null]", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value []; codes [emailAddress.required.org.broadleafcommerce.core.web.checkout.model"
        + ".OrderInfoForm.emailAddress,emailAddress.required.emailAddress,emailAddress.required.java.lang.String"
        + ",emailAddress.required]; arguments []; default message [null]", errors.getMessage());
    assertArrayEquals(
        new String[]{"emailAddress.required.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.required.emailAddress", "emailAddress.required.java.lang.String", "emailAddress.required"},
        fieldError.getCodes());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate6() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main Stjane.doe@example.org");
    BindException errors = new BindException(orderInfoForm,
        "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("42 Main Stjane.doe@example.org", fieldError.getRejectedValue());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value [42 Main Stjane.doe@example.org]; codes [emailAddress.invalid.org.broadleafcommerce"
        + ".core.web.checkout.model.OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress"
        + ".invalid.java.lang.String,emailAddress.invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
        + " rejected value [42 Main Stjane.doe@example.org]; codes [emailAddress.invalid.org.broadleafcommerce"
        + ".core.web.checkout.model.OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress"
        + ".invalid.java.lang.String,emailAddress.invalid]; arguments []; default message [null]", errors.getMessage());
    assertArrayEquals(
        new String[]{"emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.invalid.emailAddress", "emailAddress.invalid.java.lang.String", "emailAddress.invalid"},
        fieldError.getCodes());
  }
}
