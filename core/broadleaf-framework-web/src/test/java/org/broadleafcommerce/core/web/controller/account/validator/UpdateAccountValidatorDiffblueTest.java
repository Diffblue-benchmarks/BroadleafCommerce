package org.broadleafcommerce.core.web.controller.account.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.core.web.controller.account.UpdateAccountForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

public class UpdateAccountValidatorDiffblueTest {
  /**
   * Test {@link UpdateAccountValidator#validate(UpdateAccountForm, Errors)} with {@code form},
   * {@code errors}.
   *
   * <p>Method under test: {@link UpdateAccountValidator#validate(UpdateAccountForm, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpdateAccountValidator.validate(UpdateAccountForm, Errors)"})
  public void testValidateWithFormErrors() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateAccountValidator.supports(Class)"})
  public void testSupports() {
    // Arrange
    UpdateAccountValidator updateAccountValidator = new UpdateAccountValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(updateAccountValidator.supports(clazz));
  }
}
