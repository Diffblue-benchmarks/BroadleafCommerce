package org.broadleafcommerce.core.web.controller.account.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.security.util.PasswordChange;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

public class ChangePasswordValidatorDiffblueTest {
  /**
   * Test {@link ChangePasswordValidator#validate(PasswordChange, Errors)} with {@code
   * passwordChange}, {@code errors}.
   *
   * <p>Method under test: {@link ChangePasswordValidator#validate(PasswordChange, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChangePasswordValidator.validate(PasswordChange, Errors)"})
  public void testValidateWithPasswordChangeErrors() {
    // Arrange
    ChangePasswordValidator changePasswordValidator = new ChangePasswordValidator();
    PasswordChange passwordChange = new PasswordChange("janedoe");
    MapBindingResult errors = new MapBindingResult(new HashMap<>(), "currentPassword");

    // Act
    changePasswordValidator.validate(passwordChange, errors);

    // Assert
    assertEquals(3, errors.getAllErrors().size());
    assertEquals(3, errors.getErrorCount());
    assertEquals(3, errors.getFieldErrorCount());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
  }

  /**
   * Test {@link ChangePasswordValidator#supports(Class)}.
   *
   * <p>Method under test: {@link ChangePasswordValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChangePasswordValidator.supports(Class)"})
  public void testSupports() {
    // Arrange
    ChangePasswordValidator changePasswordValidator = new ChangePasswordValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(changePasswordValidator.supports(clazz));
  }
}
