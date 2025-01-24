package org.broadleafcommerce.core.web.controller.account.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.core.web.controller.account.CustomerAddressForm;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class USCustomerAddressValidatorDiffblueTest {
  /**
   * Test {@link USCustomerAddressValidator#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link USCustomerAddressValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  void testSupports_thenReturnTrue() {
    // Arrange
    USCustomerAddressValidator usCustomerAddressValidator = new USCustomerAddressValidator();
    Class<CustomerAddressValidator> clazz = CustomerAddressValidator.class;

    // Act and Assert
    assertTrue(usCustomerAddressValidator.supports(clazz));
  }

  /**
   * Test {@link USCustomerAddressValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link USCustomerAddressValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    USCustomerAddressValidator usCustomerAddressValidator = new USCustomerAddressValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(usCustomerAddressValidator.supports(clazz));
  }

  /**
   * Test {@link USCustomerAddressValidator#validate(Object, Errors)} with
   * {@code obj}, {@code errors}.
   * <p>
   * Method under test:
   * {@link USCustomerAddressValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors) with 'obj', 'errors'")
  @Disabled("TODO: Complete this test")
  void testValidateWithObjErrors() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty(BLCSystemProperty.java:72)
    //       at org.broadleafcommerce.common.web.validator.BroadleafCommonAddressValidator.isCustomValidationEnabled(BroadleafCommonAddressValidator.java:49)
    //       at org.broadleafcommerce.common.web.validator.BroadleafCommonAddressValidator.validate(BroadleafCommonAddressValidator.java:53)
    //       at org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator.validate(CustomerAddressValidator.java:37)
    //       at org.broadleafcommerce.core.web.controller.account.validator.USCustomerAddressValidator.validate(USCustomerAddressValidator.java:33)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    USCustomerAddressValidator usCustomerAddressValidator = new USCustomerAddressValidator();

    CustomerAddressForm customerAddressForm = new CustomerAddressForm();
    customerAddressForm.setAddress(new AddressImpl());
    customerAddressForm.setAddressName("42 Main St");
    customerAddressForm.setCustomerAddressId(1L);

    // Act
    usCustomerAddressValidator.validate(customerAddressForm, new BindException(customerAddressForm,
        "org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator"));
  }
}
