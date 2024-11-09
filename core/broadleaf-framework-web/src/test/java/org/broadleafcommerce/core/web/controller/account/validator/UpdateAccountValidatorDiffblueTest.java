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
package org.broadleafcommerce.core.web.controller.account.validator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.broadleafcommerce.core.web.controller.account.UpdateAccountForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

class UpdateAccountValidatorDiffblueTest {
  /**
   * Test {@link UpdateAccountValidator#validate(UpdateAccountForm, Errors)} with
   * {@code form}, {@code errors}.
   * <p>
   * Method under test:
   * {@link UpdateAccountValidator#validate(UpdateAccountForm, Errors)}
   */
  @Test
  @DisplayName("Test validate(UpdateAccountForm, Errors) with 'form', 'errors'")
  void testValidateWithFormErrors() {
    // Arrange
    UpdateAccountValidator updateAccountValidator = new UpdateAccountValidator();

    UpdateAccountForm form = new UpdateAccountForm();
    form.setEmailAddress("42 Main St");
    form.setFirstName("Jane");
    form.setLastName("Doe");
    MapBindingResult errors = new MapBindingResult(new HashMap<>(), "emailAddress");

    // Act
    updateAccountValidator.validate(form, errors);

    // Assert
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(3, allErrors.size());
    ObjectError getResult = allErrors.get(1);
    assertTrue(getResult instanceof FieldError);
    ObjectError getResult2 = allErrors.get(2);
    assertTrue(getResult2 instanceof FieldError);
    FieldError fieldError = errors.getFieldError();
    assertEquals("emailAddress", fieldError.getField());
    assertEquals("emailAddress", getResult.getObjectName());
    assertEquals("emailAddress", getResult2.getObjectName());
    assertEquals("emailAddress", fieldError.getObjectName());
    assertEquals("emailAddress.required", fieldError.getCode());
    assertEquals("firstName", ((FieldError) getResult).getField());
    assertEquals("firstName.required", getResult.getCode());
    assertEquals("lastName", ((FieldError) getResult2).getField());
    assertEquals("lastName.required", getResult2.getCode());
    assertNull(getResult.getArguments());
    assertNull(getResult2.getArguments());
    assertNull(fieldError.getArguments());
    assertNull(fieldError.getRejectedValue());
    assertNull(((FieldError) getResult).getRejectedValue());
    assertNull(((FieldError) getResult2).getRejectedValue());
    assertNull(getResult.getDefaultMessage());
    assertNull(getResult2.getDefaultMessage());
    assertNull(fieldError.getDefaultMessage());
    assertEquals(3, errors.getErrorCount());
    assertEquals(3, errors.getFieldErrorCount());
    assertFalse(fieldError.isBindingFailure());
    assertFalse(((FieldError) getResult).isBindingFailure());
    assertFalse(((FieldError) getResult2).isBindingFailure());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
    assertEquals(allErrors, errors.getFieldErrors());
    assertSame(fieldError, allErrors.get(0));
    assertArrayEquals(new String[]{"emailAddress.required.emailAddress.emailAddress",
        "emailAddress.required.emailAddress", "emailAddress.required"}, fieldError.getCodes());
    assertArrayEquals(
        new String[]{"firstName.required.emailAddress.firstName", "firstName.required.firstName", "firstName.required"},
        getResult.getCodes());
    assertArrayEquals(
        new String[]{"lastName.required.emailAddress.lastName", "lastName.required.lastName", "lastName.required"},
        getResult2.getCodes());
  }

  /**
   * Test {@link UpdateAccountValidator#validate(UpdateAccountForm, Errors)} with
   * {@code form}, {@code errors}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code 42} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateAccountValidator#validate(UpdateAccountForm, Errors)}
   */
  @Test
  @DisplayName("Test validate(UpdateAccountForm, Errors) with 'form', 'errors'; given '42'; when HashMap() computeIfPresent '42' and BiFunction")
  void testValidateWithFormErrors_given42_whenHashMapComputeIfPresent42AndBiFunction() {
    // Arrange
    UpdateAccountValidator updateAccountValidator = new UpdateAccountValidator();

    UpdateAccountForm form = new UpdateAccountForm();
    form.setEmailAddress("42 Main St");
    form.setFirstName("Jane");
    form.setLastName("Doe");

    HashMap<Object, Object> target = new HashMap<>();
    target.computeIfPresent("42", mock(BiFunction.class));
    MapBindingResult errors = new MapBindingResult(target, "emailAddress");

    // Act
    updateAccountValidator.validate(form, errors);

    // Assert
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(3, allErrors.size());
    ObjectError getResult = allErrors.get(1);
    assertTrue(getResult instanceof FieldError);
    ObjectError getResult2 = allErrors.get(2);
    assertTrue(getResult2 instanceof FieldError);
    FieldError fieldError = errors.getFieldError();
    assertEquals("emailAddress", fieldError.getField());
    assertEquals("emailAddress", getResult.getObjectName());
    assertEquals("emailAddress", getResult2.getObjectName());
    assertEquals("emailAddress", fieldError.getObjectName());
    assertEquals("emailAddress.required", fieldError.getCode());
    assertEquals("firstName", ((FieldError) getResult).getField());
    assertEquals("firstName.required", getResult.getCode());
    assertEquals("lastName", ((FieldError) getResult2).getField());
    assertEquals("lastName.required", getResult2.getCode());
    assertNull(getResult.getArguments());
    assertNull(getResult2.getArguments());
    assertNull(fieldError.getArguments());
    assertNull(fieldError.getRejectedValue());
    assertNull(((FieldError) getResult).getRejectedValue());
    assertNull(((FieldError) getResult2).getRejectedValue());
    assertNull(getResult.getDefaultMessage());
    assertNull(getResult2.getDefaultMessage());
    assertNull(fieldError.getDefaultMessage());
    assertEquals(3, errors.getErrorCount());
    assertEquals(3, errors.getFieldErrorCount());
    assertFalse(fieldError.isBindingFailure());
    assertFalse(((FieldError) getResult).isBindingFailure());
    assertFalse(((FieldError) getResult2).isBindingFailure());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
    assertEquals(allErrors, errors.getFieldErrors());
    assertSame(fieldError, allErrors.get(0));
    assertArrayEquals(new String[]{"emailAddress.required.emailAddress.emailAddress",
        "emailAddress.required.emailAddress", "emailAddress.required"}, fieldError.getCodes());
    assertArrayEquals(
        new String[]{"firstName.required.emailAddress.firstName", "firstName.required.firstName", "firstName.required"},
        getResult.getCodes());
    assertArrayEquals(
        new String[]{"lastName.required.emailAddress.lastName", "lastName.required.lastName", "lastName.required"},
        getResult2.getCodes());
  }

  /**
   * Test {@link UpdateAccountValidator#supports(Class)}.
   * <p>
   * Method under test: {@link UpdateAccountValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class)")
  void testSupports() {
    // Arrange
    UpdateAccountValidator updateAccountValidator = new UpdateAccountValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(updateAccountValidator.supports(clazz));
  }
}
