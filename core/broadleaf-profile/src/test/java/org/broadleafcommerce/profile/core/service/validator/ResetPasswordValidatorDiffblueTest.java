/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.service.validator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ResetPasswordValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link ResetPasswordValidator#validate(String, String, String, Errors)}
   */
  @Test
  public void testValidate() {
    // Arrange
    ResetPasswordValidator resetPasswordValidator = new ResetPasswordValidator();

    BindException errors = new BindException("Target", "Object Name");
    errors.addError(new ObjectError("password.valid.regex", "password.valid.regex"));

    // Act
    resetPasswordValidator.validate("janedoe", "iloveyou", "iloveyou", errors);

    // Assert that nothing has changed
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Error in object 'password.valid.regex': codes []; arguments []; default message [password.valid" + ".regex]",
        errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
        + "Error in object 'password.valid.regex': codes []; arguments []; default message [password.valid" + ".regex]",
        errors.getMessage());
    assertEquals(1, errors.getAllErrors().size());
    assertEquals(1, errors.getGlobalErrors().size());
    assertEquals(1, errors.getErrorCount());
    assertEquals(1, errors.getGlobalErrorCount());
    assertEquals(errors, bindingResult);
  }

  /**
   * Method under test:
   * {@link ResetPasswordValidator#validate(String, String, String, Errors)}
   */
  @Test
  public void testValidate2() {
    // Arrange
    ResetPasswordValidator resetPasswordValidator = new ResetPasswordValidator();

    BindException errors = new BindException("Target", "Object Name");
    errors.addError(new ObjectError("password.valid.regex", "password.valid.regex"));

    // Act
    resetPasswordValidator.validate("", "iloveyou", "iloveyou", errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(2, allErrors.size());
    ObjectError getResult = allErrors.get(1);
    assertEquals("Object Name", getResult.getObjectName());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 2 errors\n"
        + "Error in object 'password.valid.regex': codes []; arguments []; default message [password.valid.regex]"
        + "\n" + "Error in object 'Object Name': codes [username.Object Name,username]; arguments []; default message"
        + " [username.required]", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 2 errors\n"
        + "Error in object 'password.valid.regex': codes []; arguments []; default message [password.valid.regex]"
        + "\n" + "Error in object 'Object Name': codes [username.Object Name,username]; arguments []; default message"
        + " [username.required]", errors.getMessage());
    assertEquals("username", getResult.getCode());
    assertEquals("username.required", getResult.getDefaultMessage());
    assertNull(getResult.getArguments());
    assertEquals(2, errors.getErrorCount());
    assertEquals(2, errors.getGlobalErrorCount());
    assertEquals(errors, bindingResult);
    assertEquals(allErrors, errors.getGlobalErrors());
    assertArrayEquals(new String[]{"username.Object Name", "username"}, getResult.getCodes());
  }

  /**
   * Method under test:
   * {@link ResetPasswordValidator#validate(String, String, String, Errors)}
   */
  @Test
  public void testValidate3() {
    // Arrange
    ResetPasswordValidator resetPasswordValidator = new ResetPasswordValidator();

    BindException errors = new BindException("Target", "Object Name");
    errors.addError(new ObjectError("password.valid.regex", "password.valid.regex"));

    // Act
    resetPasswordValidator.validate("janedoe", "", "iloveyou", errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(2, allErrors.size());
    ObjectError getResult = allErrors.get(1);
    assertEquals("Object Name", getResult.getObjectName());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 2 errors\n"
        + "Error in object 'password.valid.regex': codes []; arguments []; default message [password.valid.regex]"
        + "\n" + "Error in object 'Object Name': codes [password.Object Name,password]; arguments []; default message"
        + " [password.required]", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 2 errors\n"
        + "Error in object 'password.valid.regex': codes []; arguments []; default message [password.valid.regex]"
        + "\n" + "Error in object 'Object Name': codes [password.Object Name,password]; arguments []; default message"
        + " [password.required]", errors.getMessage());
    assertEquals("password", getResult.getCode());
    assertEquals("password.required", getResult.getDefaultMessage());
    assertNull(getResult.getArguments());
    assertEquals(2, errors.getErrorCount());
    assertEquals(2, errors.getGlobalErrorCount());
    assertEquals(errors, bindingResult);
    assertEquals(allErrors, errors.getGlobalErrors());
    assertArrayEquals(new String[]{"password.Object Name", "password"}, getResult.getCodes());
  }

  /**
   * Method under test: {@link ResetPasswordValidator#supports(Class)}
   */
  @Test
  public void testSupports() {
    // Arrange
    ResetPasswordValidator resetPasswordValidator = new ResetPasswordValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(resetPasswordValidator.supports(clazz));
  }
}
