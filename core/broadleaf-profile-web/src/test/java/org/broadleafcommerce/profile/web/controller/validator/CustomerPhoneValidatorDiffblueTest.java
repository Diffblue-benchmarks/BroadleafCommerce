package org.broadleafcommerce.profile.web.controller.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.profile.core.domain.CustomerPhoneImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class CustomerPhoneValidatorDiffblueTest {
  /**
   * Test {@link CustomerPhoneValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CustomerPhoneValidator customerPhoneValidator = new CustomerPhoneValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(customerPhoneValidator.supports(clazz));
  }

  /**
   * Test {@link CustomerPhoneValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.profile.core.domain.Phone}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'org.broadleafcommerce.profile.core.domain.Phone'; then return 'true'")
  void testSupports_whenOrgBroadleafcommerceProfileCoreDomainPhone_thenReturnTrue() {
    // Arrange
    CustomerPhoneValidator customerPhoneValidator = new CustomerPhoneValidator();
    Class<Phone> clazz = Phone.class;

    // Act and Assert
    assertTrue(customerPhoneValidator.supports(clazz));
  }

  /**
   * Test {@link CustomerPhoneValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link CustomerPhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Disabled("TODO: Complete this test")
  void testValidate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.profile.web.controller.validator.CustomerPhoneValidator.validate(CustomerPhoneValidator.java:51)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    CustomerPhoneValidator customerPhoneValidator = new CustomerPhoneValidator();
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();

    // Act
    customerPhoneValidator.validate(customerPhoneImpl,
        new BindException(customerPhoneImpl, "org.broadleafcommerce.profile.core.domain.CustomerPhone"));
  }
}
