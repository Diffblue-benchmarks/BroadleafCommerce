package org.broadleafcommerce.profile.core.service.validator;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

public class RegistrationValidatorDiffblueTest {
  /**
   * Test {@link RegistrationValidator#validate(Customer, String, String, Errors)}
   * with {@code customer}, {@code password}, {@code passwordConfirm},
   * {@code errors}.
   * <ul>
   *   <li>Then calls {@link AbstractBindingResult#getFieldValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RegistrationValidator#validate(Customer, String, String, Errors)}
   */
  @Test
  public void testValidateWithCustomerPasswordPasswordConfirmErrors_thenCallsGetFieldValue()
      throws IllegalStateException {
    // Arrange
    RegistrationValidator registrationValidator = new RegistrationValidator();
    CustomerImpl customer = new CustomerImpl();
    BeanPropertyBindingResult errors = mock(BeanPropertyBindingResult.class);
    when(errors.hasErrors()).thenReturn(false);
    when(errors.getFieldValue(Mockito.<String>any())).thenReturn("Field Value");
    doNothing().when(errors).popNestedPath();
    doNothing().when(errors).pushNestedPath(Mockito.<String>any());

    // Act
    registrationValidator.validate(customer, "iloveyou", "Password Confirm", errors);

    // Assert
    verify(errors, atLeast(1)).getFieldValue(Mockito.<String>any());
    verify(errors).hasErrors();
    verify(errors).popNestedPath();
    verify(errors).pushNestedPath(eq("customer"));
  }

  /**
   * Test {@link RegistrationValidator#validate(Object, Errors)} with
   * {@code target}, {@code errors}.
   * <p>
   * Method under test: {@link RegistrationValidator#validate(Object, Errors)}
   */
  @Test
  public void testValidateWithTargetErrors() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange
    RegistrationValidator registrationValidator = new RegistrationValidator();

    // Act
    registrationValidator.validate("Target", new BindException("Target", "Object Name"));
  }

  /**
   * Test {@link RegistrationValidator#getValidNameRegex()}.
   * <p>
   * Method under test: {@link RegistrationValidator#getValidNameRegex()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetValidNameRegex() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveSystemProperty(BLCSystemProperty.java:54)
    //       at org.broadleafcommerce.profile.core.service.validator.RegistrationValidator.getValidNameRegex(RegistrationValidator.java:72)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    RegistrationValidator.getValidNameRegex();
  }

  /**
   * Test {@link RegistrationValidator#getValidPasswordRegex()}.
   * <p>
   * Method under test: {@link RegistrationValidator#getValidPasswordRegex()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetValidPasswordRegex() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveSystemProperty(BLCSystemProperty.java:54)
    //       at org.broadleafcommerce.profile.core.service.validator.RegistrationValidator.getValidPasswordRegex(RegistrationValidator.java:76)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    RegistrationValidator.getValidPasswordRegex();
  }

  /**
   * Test {@link RegistrationValidator#supports(Class)}.
   * <p>
   * Method under test: {@link RegistrationValidator#supports(Class)}
   */
  @Test
  public void testSupports() {
    // Arrange
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(registrationValidator.supports(clazz));
  }
}
