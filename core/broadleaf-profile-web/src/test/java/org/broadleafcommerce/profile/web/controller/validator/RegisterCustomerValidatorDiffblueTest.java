package org.broadleafcommerce.profile.web.controller.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class RegisterCustomerValidatorDiffblueTest {
  /**
   * Test {@link RegisterCustomerValidator#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegisterCustomerValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  void testSupports_thenReturnTrue() {
    // Arrange
    RegisterCustomerValidator registerCustomerValidator = new RegisterCustomerValidator();
    Class<RegisterCustomerForm> clazz = RegisterCustomerForm.class;

    // Act and Assert
    assertTrue(registerCustomerValidator.supports(clazz));
  }

  /**
   * Test {@link RegisterCustomerValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegisterCustomerValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    RegisterCustomerValidator registerCustomerValidator = new RegisterCustomerValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(registerCustomerValidator.supports(clazz));
  }

  /**
   * Test {@link RegisterCustomerValidator#validate(Object, Errors, boolean)} with
   * {@code obj}, {@code errors}, {@code useEmailForUsername}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RegisterCustomerValidator#validate(Object, Errors, boolean)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors, boolean) with 'obj', 'errors', 'useEmailForUsername'; given CustomerImpl (default constructor)")
  @Disabled("TODO: Complete this test")
  void testValidateWithObjErrorsUseEmailForUsername_givenCustomerImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator.validate(RegisterCustomerValidator.java:57)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    RegisterCustomerValidator registerCustomerValidator = new RegisterCustomerValidator();

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");

    // Act
    registerCustomerValidator.validate(registerCustomerForm, new BindException("Target", "Object Name"), true);
  }

  /**
   * Test {@link RegisterCustomerValidator#validate(Object, Errors)} with
   * {@code obj}, {@code errors}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RegisterCustomerValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors) with 'obj', 'errors'; given CustomerImpl (default constructor)")
  @Disabled("TODO: Complete this test")
  void testValidateWithObjErrors_givenCustomerImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator.validate(RegisterCustomerValidator.java:57)
    //       at org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator.validate(RegisterCustomerValidator.java:51)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    RegisterCustomerValidator registerCustomerValidator = new RegisterCustomerValidator();

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");

    // Act
    registerCustomerValidator.validate(registerCustomerForm,
        new BindException(registerCustomerForm, "org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm"));
  }

  /**
   * Test {@link RegisterCustomerValidator#getValidatePasswordExpression()}.
   * <p>
   * Method under test:
   * {@link RegisterCustomerValidator#getValidatePasswordExpression()}
   */
  @Test
  @DisplayName("Test getValidatePasswordExpression()")
  @Disabled("TODO: Complete this test")
  void testGetValidatePasswordExpression() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveSystemProperty(BLCSystemProperty.java:54)
    //       at org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator.getValidatePasswordExpression(RegisterCustomerValidator.java:94)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new RegisterCustomerValidator()).getValidatePasswordExpression();
  }

  /**
   * Test {@link RegisterCustomerValidator#setValidatePasswordExpression(String)}.
   * <p>
   * Method under test:
   * {@link RegisterCustomerValidator#setValidatePasswordExpression(String)}
   */
  @Test
  @DisplayName("Test setValidatePasswordExpression(String)")
  void testSetValidatePasswordExpression() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     RegisterCustomerValidator.customerService
    //     RegisterCustomerValidator.validatePasswordExpression

    // Arrange and Act
    (new RegisterCustomerValidator()).setValidatePasswordExpression("2020-03-01");
  }
}
