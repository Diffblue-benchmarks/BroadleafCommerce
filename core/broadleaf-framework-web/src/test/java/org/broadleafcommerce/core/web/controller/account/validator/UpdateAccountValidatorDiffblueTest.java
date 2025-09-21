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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.core.web.controller.account.UpdateAccountForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

class UpdateAccountValidatorDiffblueTest {
  /**
   * Test {@link UpdateAccountValidator#validate(UpdateAccountForm, Errors)} with {@code form},
   * {@code errors}.
   *
   * <p>Method under test: {@link UpdateAccountValidator#validate(UpdateAccountForm, Errors)}
   */
  @Test
  @DisplayName("Test validate(UpdateAccountForm, Errors) with 'form', 'errors'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpdateAccountValidator.validate(UpdateAccountForm, Errors)"})
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
    assertEquals(3, errors.getAllErrors().size());
    assertEquals(3, errors.getErrorCount());
    assertEquals(3, errors.getFieldErrorCount());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
  }

  /**
   * Test {@link UpdateAccountValidator#supports(Class)}.
   *
   * <p>Method under test: {@link UpdateAccountValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateAccountValidator.supports(Class)"})
  void testSupports() {
    // Arrange
    UpdateAccountValidator updateAccountValidator = new UpdateAccountValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(updateAccountValidator.supports(clazz));
  }
}
