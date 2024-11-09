/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.controller.validator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

class PhoneValidatorDiffblueTest {
  /**
   * Test {@link PhoneValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(phoneValidator.supports(clazz));
  }

  /**
   * Test {@link PhoneValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.profile.core.domain.Phone}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'org.broadleafcommerce.profile.core.domain.Phone'; then return 'true'")
  void testSupports_whenOrgBroadleafcommerceProfileCoreDomainPhone_thenReturnTrue() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();
    Class<Phone> clazz = Phone.class;

    // Act and Assert
    assertTrue(phoneValidator.supports(clazz));
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();
    PhoneImpl phoneImpl = new PhoneImpl();
    BindException errors = new BindException(phoneImpl, "org.broadleafcommerce.profile.core.domain.Phone");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    FieldError fieldError = errors.getFieldError();
    assertEquals("org.broadleafcommerce.profile.core.domain.Phone", fieldError.getObjectName());
    assertEquals("phone.required", fieldError.getCode());
    assertEquals("phoneNumber", fieldError.getField());
    assertNull(fieldError.getRejectedValue());
    assertNull(fieldError.getDefaultMessage());
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(1, allErrors.size());
    assertEquals(1, errors.getErrorCount());
    assertEquals(1, errors.getFieldErrorCount());
    assertEquals(1, bindingResult.getErrorCount());
    assertEquals(1, bindingResult.getFieldErrorCount());
    Object[] arguments = fieldError.getArguments();
    assertEquals(1, arguments.length);
    assertFalse(fieldError.isBindingFailure());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
    assertTrue(bindingResult.hasErrors());
    assertTrue(bindingResult.hasFieldErrors());
    assertSame(phoneImpl, arguments[0]);
    assertSame(fieldError, allErrors.get(0));
    assertSame(fieldError, bindingResult.getFieldError());
    assertArrayEquals(new String[]{"phone.required.org.broadleafcommerce.profile.core.domain.Phone.phoneNumber",
        "phone.required.phoneNumber", "phone.required.java.lang.String", "phone.required"}, fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate2() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6625550144");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

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
}
