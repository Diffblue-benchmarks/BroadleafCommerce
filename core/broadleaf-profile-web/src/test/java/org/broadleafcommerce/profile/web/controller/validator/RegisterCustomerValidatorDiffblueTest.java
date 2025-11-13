package org.broadleafcommerce.profile.web.controller.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegisterCustomerValidatorDiffblueTest {
  /**
   * Test {@link RegisterCustomerValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RegisterCustomerValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegisterCustomerValidator.supports(Class)"})
  void testSupports_thenReturnTrue() {
    // Arrange
    RegisterCustomerValidator registerCustomerValidator = new RegisterCustomerValidator();
    Class<RegisterCustomerForm> clazz = RegisterCustomerForm.class;

    // Act and Assert
    assertTrue(registerCustomerValidator.supports(clazz));
  }

  /**
   * Test {@link RegisterCustomerValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RegisterCustomerValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegisterCustomerValidator.supports(Class)"})
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    RegisterCustomerValidator registerCustomerValidator = new RegisterCustomerValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(registerCustomerValidator.supports(clazz));
  }
}
