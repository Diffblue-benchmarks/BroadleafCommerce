/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.controller.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class PhoneValidatorDiffblueTest {
  /**
   * Test {@link PhoneValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PhoneValidator.supports(Class)"})
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
   *   <li>When {@code Phone}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'org.broadleafcommerce.profile.core.domain.Phone'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PhoneValidator.supports(Class)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();
    PhoneImpl phoneImpl = new PhoneImpl();
    BindException errors = new BindException(phoneImpl, "org.broadleafcommerce.profile.core.domain.Phone");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    assertEquals(1, errors.getAllErrors().size());
    assertEquals(1, errors.getErrorCount());
    assertEquals(1, errors.getFieldErrorCount());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
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

    // Assert that nothing has changed
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getFieldErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasFieldErrors());
    assertTrue(errors.getAllErrors().isEmpty());
  }
}
