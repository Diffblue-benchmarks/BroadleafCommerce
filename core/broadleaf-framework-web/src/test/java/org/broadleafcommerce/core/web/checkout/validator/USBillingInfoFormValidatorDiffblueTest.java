package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.core.web.checkout.model.BillingInfoForm;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

class USBillingInfoFormValidatorDiffblueTest {
  /**
   * Test {@link USBillingInfoFormValidator#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link USBillingInfoFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  void testSupports_thenReturnTrue() {
    // Arrange
    USBillingInfoFormValidator usBillingInfoFormValidator = new USBillingInfoFormValidator();
    Class<BillingInfoForm> clazz = BillingInfoForm.class;

    // Act and Assert
    assertTrue(usBillingInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link USBillingInfoFormValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link USBillingInfoFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    USBillingInfoFormValidator usBillingInfoFormValidator = new USBillingInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(usBillingInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link USBillingInfoFormValidator#validate(Object, Errors)} with
   * {@code obj}, {@code errors}.
   * <p>
   * Method under test:
   * {@link USBillingInfoFormValidator#validate(Object, Errors)}
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
    //       at org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator.validate(BillingInfoFormValidator.java:37)
    //       at org.broadleafcommerce.core.web.checkout.validator.USBillingInfoFormValidator.validate(USBillingInfoFormValidator.java:34)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    USBillingInfoFormValidator usBillingInfoFormValidator = new USBillingInfoFormValidator();

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    // Act
    usBillingInfoFormValidator.validate(billingInfoForm,
        new BindException(billingInfoForm, "org.broadleafcommerce.core.web.checkout.model.BillingInfoForm"));
  }
}
