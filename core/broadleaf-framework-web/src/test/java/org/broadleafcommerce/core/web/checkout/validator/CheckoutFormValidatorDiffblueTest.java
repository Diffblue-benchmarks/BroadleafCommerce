/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.broadleafcommerce.core.web.checkout.model.CheckoutForm;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

class CheckoutFormValidatorDiffblueTest {
  /**
   * Test {@link CheckoutFormValidator#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  void testSupports_thenReturnTrue() {
    // Arrange
    CheckoutFormValidator checkoutFormValidator = new CheckoutFormValidator();
    Class<CheckoutForm> clazz = CheckoutForm.class;

    // Act and Assert
    assertTrue(checkoutFormValidator.supports(clazz));
  }

  /**
   * Test {@link CheckoutFormValidator#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutFormValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CheckoutFormValidator checkoutFormValidator = new CheckoutFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(checkoutFormValidator.supports(clazz));
  }

  /**
   * Test {@link CheckoutFormValidator#validate(Object, Errors)}.
   * <p>
   * Method under test: {@link CheckoutFormValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  void testValidate() {
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
    BindException errors = new BindException(checkoutForm,
        "org.broadleafcommerce.core.web.checkout.model.CheckoutForm");

    // Act
    checkoutFormValidator.validate(checkoutForm, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(11, allErrors.size());
    ObjectError getResult = allErrors.get(1);
    assertTrue(getResult instanceof FieldError);
    ObjectError getResult2 = allErrors.get(10);
    assertTrue(getResult2 instanceof FieldError);
    ObjectError getResult3 = allErrors.get(2);
    assertTrue(getResult3 instanceof FieldError);
    ObjectError getResult4 = allErrors.get(8);
    assertTrue(getResult4 instanceof FieldError);
    ObjectError getResult5 = allErrors.get(9);
    assertTrue(getResult5 instanceof FieldError);
    FieldError fieldError = errors.getFieldError();
    assertEquals("addressLine1.required", fieldError.getCode());
    assertEquals("billingAddress.addressLine1", fieldError.getField());
    assertEquals("billingAddress.city", ((FieldError) getResult3).getField());
    assertEquals("billingAddress.phonePrimary", ((FieldError) getResult).getField());
    assertEquals("city.required", getResult3.getCode());
    assertEquals("firstName.required", getResult5.getCode());
    assertEquals("lastName.required", getResult2.getCode());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.CheckoutForm", getResult.getObjectName());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.CheckoutForm", getResult2.getObjectName());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.CheckoutForm", getResult3.getObjectName());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.CheckoutForm", getResult4.getObjectName());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.CheckoutForm", getResult5.getObjectName());
    assertEquals("org.broadleafcommerce.core.web.checkout.model.CheckoutForm", fieldError.getObjectName());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 11 errors\n"
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
        + " []; default message [null]", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 11 errors\n"
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
        + " []; default message [null]", errors.getMessage());
    assertEquals("phone.required", getResult.getCode());
    assertEquals("postalCode.required", getResult4.getCode());
    assertEquals("shippingAddress.firstName", ((FieldError) getResult5).getField());
    assertEquals("shippingAddress.lastName", ((FieldError) getResult2).getField());
    assertEquals("shippingAddress.postalCode", ((FieldError) getResult4).getField());
    assertNull(getResult.getArguments());
    assertNull(getResult2.getArguments());
    assertNull(getResult3.getArguments());
    assertNull(getResult4.getArguments());
    assertNull(getResult5.getArguments());
    assertNull(fieldError.getArguments());
    assertNull(fieldError.getRejectedValue());
    assertNull(((FieldError) getResult).getRejectedValue());
    assertNull(((FieldError) getResult2).getRejectedValue());
    assertNull(((FieldError) getResult3).getRejectedValue());
    assertNull(((FieldError) getResult4).getRejectedValue());
    assertNull(((FieldError) getResult5).getRejectedValue());
    assertNull(getResult.getDefaultMessage());
    assertNull(getResult2.getDefaultMessage());
    assertNull(getResult3.getDefaultMessage());
    assertNull(getResult4.getDefaultMessage());
    assertNull(getResult5.getDefaultMessage());
    assertNull(fieldError.getDefaultMessage());
    assertEquals(11, errors.getErrorCount());
    assertEquals(11, errors.getFieldErrorCount());
    assertEquals(11, bindingResult.getErrorCount());
    assertEquals(11, bindingResult.getFieldErrorCount());
    assertFalse(fieldError.isBindingFailure());
    assertFalse(((FieldError) getResult).isBindingFailure());
    assertFalse(((FieldError) getResult2).isBindingFailure());
    assertFalse(((FieldError) getResult3).isBindingFailure());
    assertFalse(((FieldError) getResult4).isBindingFailure());
    assertFalse(((FieldError) getResult5).isBindingFailure());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
    assertTrue(bindingResult.hasErrors());
    assertTrue(bindingResult.hasFieldErrors());
    assertEquals(allErrors, errors.getFieldErrors());
    assertEquals(allErrors, bindingResult.getAllErrors());
    assertEquals(allErrors, bindingResult.getFieldErrors());
    assertSame(fieldError, allErrors.get(0));
    assertSame(fieldError, bindingResult.getFieldError());
    assertArrayEquals(
        new String[]{
            "addressLine1.required.org.broadleafcommerce.core.web.checkout.model.CheckoutForm.billingAddress"
                + ".addressLine1",
            "addressLine1.required.billingAddress.addressLine1", "addressLine1.required.addressLine1",
            "addressLine1.required.java.lang.String", "addressLine1.required"},
        fieldError.getCodes());
    assertArrayEquals(new String[]{
        "city.required.org.broadleafcommerce.core.web.checkout.model.CheckoutForm.billingAddress.city",
        "city.required.billingAddress.city", "city.required.city", "city.required.java.lang.String", "city.required"},
        getResult3.getCodes());
    assertArrayEquals(
        new String[]{
            "firstName.required.org.broadleafcommerce.core.web.checkout.model.CheckoutForm.shippingAddress"
                + ".firstName",
            "firstName.required.shippingAddress.firstName", "firstName.required.firstName",
            "firstName.required.java.lang.String", "firstName.required"},
        getResult5.getCodes());
    assertArrayEquals(
        new String[]{
            "lastName.required.org.broadleafcommerce.core.web.checkout.model.CheckoutForm.shippingAddress"
                + ".lastName",
            "lastName.required.shippingAddress.lastName", "lastName.required.lastName",
            "lastName.required.java.lang.String", "lastName.required"},
        getResult2.getCodes());
    assertArrayEquals(
        new String[]{
            "phone.required.org.broadleafcommerce.core.web.checkout.model.CheckoutForm.billingAddress"
                + ".phonePrimary",
            "phone.required.billingAddress.phonePrimary", "phone.required.phonePrimary",
            "phone.required.org.broadleafcommerce.profile.core.domain.Phone", "phone.required"},
        getResult.getCodes());
    assertArrayEquals(new String[]{
        "postalCode.required.org.broadleafcommerce.core.web.checkout.model.CheckoutForm.shippingAddress"
            + ".postalCode",
        "postalCode.required.shippingAddress.postalCode", "postalCode.required.postalCode",
        "postalCode.required.java.lang.String", "postalCode.required"}, getResult4.getCodes());
  }
}
