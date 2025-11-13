package org.broadleafcommerce.profile.core.service.validator;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

public class RegistrationValidatorDiffblueTest {
  /**
   * Test {@link RegistrationValidator#validate(Customer, String, String, Errors)} with {@code
   * customer}, {@code password}, {@code passwordConfirm}, {@code errors}.
   *
   * <ul>
   *   <li>Then calls {@link BeanPropertyBindingResult#getFieldValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link RegistrationValidator#validate(Customer, String, String, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegistrationValidator.validate(Customer, String, String, Errors)"})
  public void testValidateWithCustomerPasswordPasswordConfirmErrors_thenCallsGetFieldValue()
      throws IllegalStateException {
    // Arrange
    RegistrationValidator registrationValidator = new RegistrationValidator();

    BeanPropertyBindingResult errors = mock(BeanPropertyBindingResult.class);
    when(errors.hasErrors()).thenReturn(false);
    when(errors.getFieldValue(Mockito.<String>any())).thenReturn("Field Value");
    doNothing().when(errors).popNestedPath();
    doNothing().when(errors).pushNestedPath(Mockito.<String>any());

    // Act
    registrationValidator.validate(null, "iloveyou", "Password Confirm", errors);

    // Assert
    verify(errors, atLeast(1)).getFieldValue(Mockito.<String>any());
    verify(errors).hasErrors();
    verify(errors).popNestedPath();
    verify(errors).pushNestedPath("customer");
  }

  /**
   * Test {@link RegistrationValidator#supports(Class)}.
   *
   * <p>Method under test: {@link RegistrationValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistrationValidator.supports(Class)"})
  public void testSupports() {
    // Arrange
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(registrationValidator.supports(clazz));
  }
}
