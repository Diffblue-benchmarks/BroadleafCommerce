package org.broadleafcommerce.common.web.validator;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.broadleafcommerce.common.web.form.BroadleafFormType;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class BroadleafCommonAddressValidatorDiffblueTest {
  /**
   * Test {@link BroadleafCommonAddressValidator#isValidateFullNameOnly()}.
   * <p>
   * Method under test:
   * {@link BroadleafCommonAddressValidator#isValidateFullNameOnly()}
   */
  @Test
  @DisplayName("Test isValidateFullNameOnly()")
  @Disabled("TODO: Complete this test")
  void testIsValidateFullNameOnly() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty(BLCSystemProperty.java:72)
    //       at org.broadleafcommerce.common.web.validator.BroadleafCommonAddressValidator.isValidateFullNameOnly(BroadleafCommonAddressValidator.java:45)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new BroadleafCommonAddressValidator()).isValidateFullNameOnly();
  }

  /**
   * Test {@link BroadleafCommonAddressValidator#isCustomValidationEnabled()}.
   * <p>
   * Method under test:
   * {@link BroadleafCommonAddressValidator#isCustomValidationEnabled()}
   */
  @Test
  @DisplayName("Test isCustomValidationEnabled()")
  @Disabled("TODO: Complete this test")
  void testIsCustomValidationEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty(BLCSystemProperty.java:72)
    //       at org.broadleafcommerce.common.web.validator.BroadleafCommonAddressValidator.isCustomValidationEnabled(BroadleafCommonAddressValidator.java:49)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new BroadleafCommonAddressValidator()).isCustomValidationEnabled();
  }

  /**
   * Test
   * {@link BroadleafCommonAddressValidator#validate(BroadleafFormType, Address, Errors)}.
   * <p>
   * Method under test:
   * {@link BroadleafCommonAddressValidator#validate(BroadleafFormType, Address, Errors)}
   */
  @Test
  @DisplayName("Test validate(BroadleafFormType, Address, Errors)")
  @Disabled("TODO: Complete this test")
  void testValidate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty(BLCSystemProperty.java:72)
    //       at org.broadleafcommerce.common.web.validator.BroadleafCommonAddressValidator.isCustomValidationEnabled(BroadleafCommonAddressValidator.java:49)
    //       at org.broadleafcommerce.common.web.validator.BroadleafCommonAddressValidator.validate(BroadleafCommonAddressValidator.java:53)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafCommonAddressValidator broadleafCommonAddressValidator = new BroadleafCommonAddressValidator();
    BroadleafFormType formType = new BroadleafFormType("Type", "Friendly Type");

    AddressImpl address = new AddressImpl();

    // Act
    broadleafCommonAddressValidator.validate(formType, address, new BindException("Target", "Object Name"));
  }

  /**
   * Test new {@link BroadleafCommonAddressValidator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafCommonAddressValidator}
   */
  @Test
  @DisplayName("Test new BroadleafCommonAddressValidator (default constructor)")
  void testNewBroadleafCommonAddressValidator() {
    // Arrange, Act and Assert
    assertNull((new BroadleafCommonAddressValidator()).validatorExtensionManager);
  }
}
