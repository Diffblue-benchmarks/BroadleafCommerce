package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class OrderInfoFormValidatorDiffblueTest {
  /**
   * Test {@link OrderInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderInfoFormValidator.supports(Class)"})
  public void testSupports_thenReturnTrue() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();
    Class<OrderInfoForm> clazz = OrderInfoForm.class;

    // Act and Assert
    assertTrue(orderInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link OrderInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderInfoFormValidator.supports(Class)"})
  public void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderInfoFormValidator.validate(Object, Errors)"})
  public void testValidate() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main St");
    BindException errors =
        new BindException(
            orderInfoForm, "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("42 Main St", fieldError.getRejectedValue());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value [42 Main St]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
            + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
            + ",emailAddress.invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value [42 Main St]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
            + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
            + ",emailAddress.invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertArrayEquals(
        new String[] {
          "emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
          "emailAddress.invalid.emailAddress",
          "emailAddress.invalid.java.lang.String",
          "emailAddress.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderInfoFormValidator.validate(Object, Errors)"})
  public void testValidate2() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("17 High St");
    BindException errors =
        new BindException(
            orderInfoForm, "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("17 High St", fieldError.getRejectedValue());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value [17 High St]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
            + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
            + ",emailAddress.invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value [17 High St]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
            + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
            + ",emailAddress.invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertArrayEquals(
        new String[] {
          "emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
          "emailAddress.invalid.emailAddress",
          "emailAddress.invalid.java.lang.String",
          "emailAddress.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderInfoFormValidator.validate(Object, Errors)"})
  public void testValidate3() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("jane.doe@example.org");
    BindException errors =
        new BindException(
            orderInfoForm, "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert that nothing has changed
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderInfoFormValidator.validate(Object, Errors)"})
  public void testValidate4() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("xxx@UUU");
    BindException errors =
        new BindException(
            orderInfoForm, "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value [xxx@UUU]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
            + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
            + ",emailAddress.invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value [xxx@UUU]; codes [emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model"
            + ".OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress.invalid.java.lang.String"
            + ",emailAddress.invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("xxx@UUU", fieldError.getRejectedValue());
    assertArrayEquals(
        new String[] {
          "emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
          "emailAddress.invalid.emailAddress",
          "emailAddress.invalid.java.lang.String",
          "emailAddress.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderInfoFormValidator.validate(Object, Errors)"})
  public void testValidate5() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("");
    BindException errors =
        new BindException(
            orderInfoForm, "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("", fieldError.getRejectedValue());
    assertEquals("emailAddress.required", fieldError.getCode());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value []; codes [emailAddress.required.org.broadleafcommerce.core.web.checkout.model"
            + ".OrderInfoForm.emailAddress,emailAddress.required.emailAddress,emailAddress.required.java.lang.String"
            + ",emailAddress.required]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value []; codes [emailAddress.required.org.broadleafcommerce.core.web.checkout.model"
            + ".OrderInfoForm.emailAddress,emailAddress.required.emailAddress,emailAddress.required.java.lang.String"
            + ",emailAddress.required]; arguments []; default message [null]",
        errors.getMessage());
    assertArrayEquals(
        new String[] {
          "emailAddress.required.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
          "emailAddress.required.emailAddress",
          "emailAddress.required.java.lang.String",
          "emailAddress.required"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link OrderInfoFormValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link OrderInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderInfoFormValidator.validate(Object, Errors)"})
  public void testValidate6() {
    // Arrange
    OrderInfoFormValidator orderInfoFormValidator = new OrderInfoFormValidator();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main Stjane.doe@example.org");
    BindException errors =
        new BindException(
            orderInfoForm, "org.broadleafcommerce.core.web.checkout.model.OrderInfoForm");

    // Act
    orderInfoFormValidator.validate(orderInfoForm, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("42 Main Stjane.doe@example.org", fieldError.getRejectedValue());
    assertEquals("emailAddress.invalid", fieldError.getCode());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value [42 Main Stjane.doe@example.org]; codes [emailAddress.invalid.org.broadleafcommerce"
            + ".core.web.checkout.model.OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress"
            + ".invalid.java.lang.String,emailAddress.invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'org.broadleafcommerce.core.web.checkout.model.OrderInfoForm' on field 'emailAddress':"
            + " rejected value [42 Main Stjane.doe@example.org]; codes [emailAddress.invalid.org.broadleafcommerce"
            + ".core.web.checkout.model.OrderInfoForm.emailAddress,emailAddress.invalid.emailAddress,emailAddress"
            + ".invalid.java.lang.String,emailAddress.invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertArrayEquals(
        new String[] {
          "emailAddress.invalid.org.broadleafcommerce.core.web.checkout.model.OrderInfoForm.emailAddress",
          "emailAddress.invalid.emailAddress",
          "emailAddress.invalid.java.lang.String",
          "emailAddress.invalid"
        },
        fieldError.getCodes());
  }
}
