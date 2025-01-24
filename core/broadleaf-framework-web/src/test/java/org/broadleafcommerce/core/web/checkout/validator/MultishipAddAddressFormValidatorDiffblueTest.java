package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class MultishipAddAddressFormValidatorDiffblueTest {
  /**
   * Test {@link MultishipAddAddressFormValidator#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultishipAddAddressFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  void testSupports_thenReturnTrue() {
    // Arrange
    MultishipAddAddressFormValidator multishipAddAddressFormValidator = new MultishipAddAddressFormValidator();
    Class<ShippingInfoForm> clazz = ShippingInfoForm.class;

    // Act and Assert
    assertTrue(multishipAddAddressFormValidator.supports(clazz));
  }

  /**
   * Test {@link MultishipAddAddressFormValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultishipAddAddressFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    MultishipAddAddressFormValidator multishipAddAddressFormValidator = new MultishipAddAddressFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(multishipAddAddressFormValidator.supports(clazz));
  }

  /**
   * Test {@link MultishipAddAddressFormValidator#validate(Object, Errors)} with
   * {@code obj}, {@code errors}.
   * <p>
   * Method under test:
   * {@link MultishipAddAddressFormValidator#validate(Object, Errors)}
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
    //       at org.broadleafcommerce.core.web.checkout.validator.MultishipAddAddressFormValidator.validate(MultishipAddAddressFormValidator.java:38)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    MultishipAddAddressFormValidator multishipAddAddressFormValidator = new MultishipAddAddressFormValidator();
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();

    // Act
    multishipAddAddressFormValidator.validate(shippingInfoForm,
        new BindException(shippingInfoForm, "org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm"));
  }
}
