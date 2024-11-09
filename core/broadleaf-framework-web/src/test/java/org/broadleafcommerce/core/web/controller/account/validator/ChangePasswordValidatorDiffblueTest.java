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
import org.broadleafcommerce.common.security.util.PasswordChange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

class ChangePasswordValidatorDiffblueTest {
  /**
   * Test {@link ChangePasswordValidator#validate(PasswordChange, Errors)} with
   * {@code passwordChange}, {@code errors}.
   * <p>
   * Method under test:
   * {@link ChangePasswordValidator#validate(PasswordChange, Errors)}
   */
  @Test
  @DisplayName("Test validate(PasswordChange, Errors) with 'passwordChange', 'errors'")
  void testValidateWithPasswordChangeErrors() {
    // Arrange
    ChangePasswordValidator changePasswordValidator = new ChangePasswordValidator();
    PasswordChange passwordChange = new PasswordChange("janedoe");
    MapBindingResult errors = new MapBindingResult(new HashMap<>(), "currentPassword");

    // Act
    changePasswordValidator.validate(passwordChange, errors);

    // Assert
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(3, allErrors.size());
    ObjectError getResult = allErrors.get(1);
    assertTrue(getResult instanceof FieldError);
    ObjectError getResult2 = allErrors.get(2);
    assertTrue(getResult2 instanceof FieldError);
    FieldError fieldError = errors.getFieldError();
    assertEquals("currentPassword", fieldError.getField());
    assertEquals("currentPassword", getResult.getObjectName());
    assertEquals("currentPassword", getResult2.getObjectName());
    assertEquals("currentPassword", fieldError.getObjectName());
    assertEquals("currentPassword.required", fieldError.getCode());
    assertEquals("newPassword", ((FieldError) getResult).getField());
    assertEquals("newPassword.required", getResult.getCode());
    assertEquals("newPasswordConfirm", ((FieldError) getResult2).getField());
    assertEquals("newPasswordConfirm.required", getResult2.getCode());
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
    assertArrayEquals(new String[]{"currentPassword.required.currentPassword.currentPassword",
        "currentPassword.required.currentPassword", "currentPassword.required"}, fieldError.getCodes());
    assertArrayEquals(new String[]{"newPassword.required.currentPassword.newPassword",
        "newPassword.required.newPassword", "newPassword.required"}, getResult.getCodes());
    assertArrayEquals(new String[]{"newPasswordConfirm.required.currentPassword.newPasswordConfirm",
        "newPasswordConfirm.required.newPasswordConfirm", "newPasswordConfirm.required"}, getResult2.getCodes());
  }

  /**
   * Test {@link ChangePasswordValidator#validate(PasswordChange, Errors)} with
   * {@code passwordChange}, {@code errors}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChangePasswordValidator#validate(PasswordChange, Errors)}
   */
  @Test
  @DisplayName("Test validate(PasswordChange, Errors) with 'passwordChange', 'errors'; given '42'")
  void testValidateWithPasswordChangeErrors_given42() {
    // Arrange
    ChangePasswordValidator changePasswordValidator = new ChangePasswordValidator();
    PasswordChange passwordChange = new PasswordChange("janedoe");

    HashMap<Object, Object> target = new HashMap<>();
    target.computeIfPresent("42", mock(BiFunction.class));
    MapBindingResult errors = new MapBindingResult(target, "currentPassword");

    // Act
    changePasswordValidator.validate(passwordChange, errors);

    // Assert
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(3, allErrors.size());
    ObjectError getResult = allErrors.get(1);
    assertTrue(getResult instanceof FieldError);
    ObjectError getResult2 = allErrors.get(2);
    assertTrue(getResult2 instanceof FieldError);
    FieldError fieldError = errors.getFieldError();
    assertEquals("currentPassword", fieldError.getField());
    assertEquals("currentPassword", getResult.getObjectName());
    assertEquals("currentPassword", getResult2.getObjectName());
    assertEquals("currentPassword", fieldError.getObjectName());
    assertEquals("currentPassword.required", fieldError.getCode());
    assertEquals("newPassword", ((FieldError) getResult).getField());
    assertEquals("newPassword.required", getResult.getCode());
    assertEquals("newPasswordConfirm", ((FieldError) getResult2).getField());
    assertEquals("newPasswordConfirm.required", getResult2.getCode());
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
    assertArrayEquals(new String[]{"currentPassword.required.currentPassword.currentPassword",
        "currentPassword.required.currentPassword", "currentPassword.required"}, fieldError.getCodes());
    assertArrayEquals(new String[]{"newPassword.required.currentPassword.newPassword",
        "newPassword.required.newPassword", "newPassword.required"}, getResult.getCodes());
    assertArrayEquals(new String[]{"newPasswordConfirm.required.currentPassword.newPasswordConfirm",
        "newPasswordConfirm.required.newPasswordConfirm", "newPasswordConfirm.required"}, getResult2.getCodes());
  }

  /**
   * Test {@link ChangePasswordValidator#supports(Class)}.
   * <p>
   * Method under test: {@link ChangePasswordValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class)")
  void testSupports() {
    // Arrange
    ChangePasswordValidator changePasswordValidator = new ChangePasswordValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(changePasswordValidator.supports(clazz));
  }
}
