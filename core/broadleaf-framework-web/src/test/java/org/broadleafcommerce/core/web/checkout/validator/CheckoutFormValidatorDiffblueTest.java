package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.CheckoutForm;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

public class CheckoutFormValidatorDiffblueTest {
  /**
   * Test {@link CheckoutFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormValidator.supports(Class)"})
  public void testSupports_thenReturnTrue() {
    // Arrange
    CheckoutFormValidator checkoutFormValidator = new CheckoutFormValidator();
    Class<CheckoutForm> clazz = CheckoutForm.class;

    // Act and Assert
    assertTrue(checkoutFormValidator.supports(clazz));
  }

  /**
   * Test {@link CheckoutFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormValidator.supports(Class)"})
  public void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CheckoutFormValidator checkoutFormValidator = new CheckoutFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(checkoutFormValidator.supports(clazz));
  }

  /**
   * Test {@link CheckoutFormValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link CheckoutFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CheckoutFormValidator.validate(Object, Errors)"})
  public void testValidate() {
    // Arrange
    CheckoutFormValidator checkoutFormValidator = new CheckoutFormValidator();

    CheckoutForm checkoutForm = new CheckoutForm();
    checkoutForm.setBillingAddress(new AddressImpl());
    checkoutForm.setCreditCardCvvCode("Credit Card Cvv Code");
    checkoutForm.setCreditCardExpMonth("Credit Card Exp Month");
    checkoutForm.setCreditCardExpYear("Credit Card Exp Year");
    checkoutForm.setCreditCardNumber("42");
    checkoutForm.setEmailAddress("42 Main St");
    checkoutForm.setIsSameAddress(true);
    checkoutForm.setSelectedCreditCardType("Selected Credit Card Type");
    checkoutForm.setShippingAddress(new AddressImpl());
    BindException errors =
        new BindException(
            checkoutForm, "org.broadleafcommerce.core.web.checkout.model.CheckoutForm");

    // Act
    checkoutFormValidator.validate(checkoutForm, errors);

    // Assert
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 11 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.addressLine1': rejected value [null]; codes [addressLine1.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.billingAddress.addressLine1,addressLine1.required.billingAddress"
            + ".addressLine1,addressLine1.required.addressLine1,addressLine1.required.java.lang.String,addressLine1"
            + ".required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.phonePrimary': rejected value [null]; codes [phone.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.billingAddress.phonePrimary,phone.required.billingAddress"
            + ".phonePrimary,phone.required.phonePrimary,phone.required.org.broadleafcommerce.profile.core.domain"
            + ".Phone,phone.required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.city': rejected value [null]; codes [city.required.org.broadleafcommerce.core.web"
            + ".checkout.model.CheckoutForm.billingAddress.city,city.required.billingAddress.city,city.required.city"
            + ",city.required.java.lang.String,city.required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.postalCode': rejected value [null]; codes [postalCode.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.billingAddress.postalCode,postalCode.required.billingAddress"
            + ".postalCode,postalCode.required.postalCode,postalCode.required.java.lang.String,postalCode.required];"
            + " arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.firstName': rejected value [null]; codes [firstName.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.billingAddress.firstName,firstName.required.billingAddress"
            + ".firstName,firstName.required.firstName,firstName.required.java.lang.String,firstName.required];"
            + " arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.lastName': rejected value [null]; codes [lastName.required.org.broadleafcommerce.core"
            + ".web.checkout.model.CheckoutForm.billingAddress.lastName,lastName.required.billingAddress.lastName"
            + ",lastName.required.lastName,lastName.required.java.lang.String,lastName.required]; arguments []; default"
            + " message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.addressLine1': rejected value [null]; codes [addressLine1.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.shippingAddress.addressLine1,addressLine1.required.shippingAddress"
            + ".addressLine1,addressLine1.required.addressLine1,addressLine1.required.java.lang.String,addressLine1"
            + ".required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.city': rejected value [null]; codes [city.required.org.broadleafcommerce.core.web"
            + ".checkout.model.CheckoutForm.shippingAddress.city,city.required.shippingAddress.city,city.required"
            + ".city,city.required.java.lang.String,city.required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.postalCode': rejected value [null]; codes [postalCode.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.shippingAddress.postalCode,postalCode.required.shippingAddress"
            + ".postalCode,postalCode.required.postalCode,postalCode.required.java.lang.String,postalCode.required];"
            + " arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.firstName': rejected value [null]; codes [firstName.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.shippingAddress.firstName,firstName.required.shippingAddress"
            + ".firstName,firstName.required.firstName,firstName.required.java.lang.String,firstName.required];"
            + " arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.lastName': rejected value [null]; codes [lastName.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.shippingAddress.lastName,lastName.required.shippingAddress"
            + ".lastName,lastName.required.lastName,lastName.required.java.lang.String,lastName.required]; arguments"
            + " []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 11 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.addressLine1': rejected value [null]; codes [addressLine1.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.billingAddress.addressLine1,addressLine1.required.billingAddress"
            + ".addressLine1,addressLine1.required.addressLine1,addressLine1.required.java.lang.String,addressLine1"
            + ".required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.phonePrimary': rejected value [null]; codes [phone.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.billingAddress.phonePrimary,phone.required.billingAddress"
            + ".phonePrimary,phone.required.phonePrimary,phone.required.org.broadleafcommerce.profile.core.domain"
            + ".Phone,phone.required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.city': rejected value [null]; codes [city.required.org.broadleafcommerce.core.web"
            + ".checkout.model.CheckoutForm.billingAddress.city,city.required.billingAddress.city,city.required.city"
            + ",city.required.java.lang.String,city.required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.postalCode': rejected value [null]; codes [postalCode.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.billingAddress.postalCode,postalCode.required.billingAddress"
            + ".postalCode,postalCode.required.postalCode,postalCode.required.java.lang.String,postalCode.required];"
            + " arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.firstName': rejected value [null]; codes [firstName.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.billingAddress.firstName,firstName.required.billingAddress"
            + ".firstName,firstName.required.firstName,firstName.required.java.lang.String,firstName.required];"
            + " arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'billingAddress.lastName': rejected value [null]; codes [lastName.required.org.broadleafcommerce.core"
            + ".web.checkout.model.CheckoutForm.billingAddress.lastName,lastName.required.billingAddress.lastName"
            + ",lastName.required.lastName,lastName.required.java.lang.String,lastName.required]; arguments []; default"
            + " message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.addressLine1': rejected value [null]; codes [addressLine1.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.shippingAddress.addressLine1,addressLine1.required.shippingAddress"
            + ".addressLine1,addressLine1.required.addressLine1,addressLine1.required.java.lang.String,addressLine1"
            + ".required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.city': rejected value [null]; codes [city.required.org.broadleafcommerce.core.web"
            + ".checkout.model.CheckoutForm.shippingAddress.city,city.required.shippingAddress.city,city.required"
            + ".city,city.required.java.lang.String,city.required]; arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.postalCode': rejected value [null]; codes [postalCode.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.shippingAddress.postalCode,postalCode.required.shippingAddress"
            + ".postalCode,postalCode.required.postalCode,postalCode.required.java.lang.String,postalCode.required];"
            + " arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.firstName': rejected value [null]; codes [firstName.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.shippingAddress.firstName,firstName.required.shippingAddress"
            + ".firstName,firstName.required.firstName,firstName.required.java.lang.String,firstName.required];"
            + " arguments []; default message [null]\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.CheckoutForm' on field"
            + " 'shippingAddress.lastName': rejected value [null]; codes [lastName.required.org.broadleafcommerce"
            + ".core.web.checkout.model.CheckoutForm.shippingAddress.lastName,lastName.required.shippingAddress"
            + ".lastName,lastName.required.lastName,lastName.required.java.lang.String,lastName.required]; arguments"
            + " []; default message [null]",
        errors.getMessage());
    assertEquals(11, errors.getAllErrors().size());
    assertEquals(11, errors.getErrorCount());
    assertEquals(11, errors.getFieldErrorCount());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
  }
}
