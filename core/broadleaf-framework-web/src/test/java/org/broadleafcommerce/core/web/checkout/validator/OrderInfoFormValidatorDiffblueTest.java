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
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

class OrderInfoFormValidatorDiffblueTest {
  /**
   * Method under test: {@link OrderInfoFormValidator#supports(Class)}
   */
  @Test
  void testSupports() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderInfoFormValidator.supports(clazz));
  }

  /**
   * Method under test: {@link OrderInfoFormValidator#supports(Class)}
   */
  @Test
  void testSupports2() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();
    Class<OrderInfoForm> clazz = OrderInfoForm.class;

    // Act and Assert
    assertTrue(orderInfoFormValidator.supports(clazz));
  }

  /**
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
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
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    FieldError fieldError = errors.getFieldError();
    assertEquals("42 Main St", fieldError.getRejectedValue());
    assertEquals("emailAddress", fieldError.getField());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.OrderInfoForm", fieldError.getObjectName());
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
    assertNull(fieldError.getArguments());
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
    assertArrayEquals(
        new String[]{"emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.invalid.emailAddress", "emailAddress.invalid.java.lang.String", "emailAddress.invalid"},
        fieldError.getCodes());
  }

  /**
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
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
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    FieldError fieldError = errors.getFieldError();
    assertEquals("17 High St", fieldError.getRejectedValue());
    assertEquals("emailAddress", fieldError.getField());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.OrderInfoForm", fieldError.getObjectName());
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
    assertNull(fieldError.getArguments());
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
    assertArrayEquals(
        new String[]{"emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.invalid.emailAddress", "emailAddress.invalid.java.lang.String", "emailAddress.invalid"},
        fieldError.getCodes());
  }

  /**
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
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
    assertNull(errors.getFieldError());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getFieldErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasFieldErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getFieldErrors().isEmpty());
    assertEquals(errors, bindingResult);
  }

  /**
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
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
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    FieldError fieldError = errors.getFieldError();
    assertEquals("U@U", fieldError.getRejectedValue());
    assertEquals("emailAddress", fieldError.getField());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.OrderInfoForm", fieldError.getObjectName());
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
    assertNull(fieldError.getArguments());
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
    assertArrayEquals(
        new String[]{"emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.invalid.emailAddress", "emailAddress.invalid.java.lang.String", "emailAddress.invalid"},
        fieldError.getCodes());
  }

  /**
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
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
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    FieldError fieldError = errors.getFieldError();
    assertEquals("", fieldError.getRejectedValue());
    assertEquals("emailAddress", fieldError.getField());
    assertEquals("emailAddress.required", fieldError.getCode());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.OrderInfoForm", fieldError.getObjectName());
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
    assertNull(fieldError.getArguments());
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
    assertArrayEquals(
        new String[]{"emailAddress.required.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.required.emailAddress", "emailAddress.required.java.lang.String", "emailAddress.required"},
        fieldError.getCodes());
  }

  /**
   * Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
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
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    FieldError fieldError = errors.getFieldError();
    assertEquals("42 Main Stjane.doe@example.org", fieldError.getRejectedValue());
    assertEquals("emailAddress", fieldError.getField());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.OrderInfoForm", fieldError.getObjectName());
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
    assertNull(fieldError.getArguments());
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
    assertArrayEquals(
        new String[]{"emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
            "emailAddress.invalid.emailAddress", "emailAddress.invalid.java.lang.String", "emailAddress.invalid"},
        fieldError.getCodes());
  }
}
