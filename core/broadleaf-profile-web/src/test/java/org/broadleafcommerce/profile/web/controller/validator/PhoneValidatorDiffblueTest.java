package org.broadleafcommerce.profile.web.controller.validator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

class PhoneValidatorDiffblueTest {
  /**
   * Test {@link PhoneValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhoneValidator.supports(Class)"})
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(phoneValidator.supports(clazz));
  }

  /**
   * Test {@link PhoneValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Phone}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName(
      "Test supports(Class); when 'org.broadleafcommerce.profile.core.domain.Phone'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhoneValidator.supports(Class)"})
  void testSupports_whenOrgBroadleafcommerceProfileCoreDomainPhone_thenReturnTrue() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();
    Class<Phone> clazz = Phone.class;

    // Act and Assert
    assertTrue(phoneValidator.supports(clazz));
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();
    PhoneImpl phoneImpl = new PhoneImpl();
    BindException errors =
        new BindException(phoneImpl, "org.broadleafcommerce.profile.core.domain.Phone");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("org.broadleafcommerce.profile.core.domain.Phone", fieldError.getObjectName());
    assertEquals("phone.required", fieldError.getCode());
    assertNull(fieldError.getRejectedValue());
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(1, allErrors.size());
    Object[] arguments = fieldError.getArguments();
    assertEquals(1, arguments.length);
    assertSame(phoneImpl, arguments[0]);
    assertSame(fieldError, allErrors.get(0));
    assertArrayEquals(
        new String[] {
          "phone.required.org.broadleafcommerce.profile.core.domain.Phone.phoneNumber",
          "phone.required.phoneNumber",
          "phone.required.java.lang.String",
          "phone.required"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate2() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6625550144");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert that nothing has changed
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertTrue(errors.getAllErrors().isEmpty());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate3() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("+44 1865 4960636");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("+44 1865 4960636", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [+44 1865 4960636]; codes"
            + " [phone.ten_digits_required.Object Name.phoneNumber,phone.ten_digits_required.phoneNumber,phone.ten"
            + "_digits_required.java.lang.String,phone.ten_digits_required]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [+44 1865 4960636]; codes"
            + " [phone.ten_digits_required.Object Name.phoneNumber,phone.ten_digits_required.phoneNumber,phone.ten"
            + "_digits_required.java.lang.String,phone.ten_digits_required]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.ten_digits_required", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.ten_digits_required.Object Name.phoneNumber",
          "phone.ten_digits_required.phoneNumber",
          "phone.ten_digits_required.java.lang.String",
          "phone.ten_digits_required"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate4() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("U");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("U", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [U]; codes [phone.ten_digits"
            + "_required.Object Name.phoneNumber,phone.ten_digits_required.phoneNumber,phone.ten_digits_required.java"
            + ".lang.String,phone.ten_digits_required]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [U]; codes [phone.ten_digits"
            + "_required.Object Name.phoneNumber,phone.ten_digits_required.phoneNumber,phone.ten_digits_required.java"
            + ".lang.String,phone.ten_digits_required]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.ten_digits_required", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.ten_digits_required.Object Name.phoneNumber",
          "phone.ten_digits_required.phoneNumber",
          "phone.ten_digits_required.java.lang.String",
          "phone.ten_digits_required"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate5() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("0000000000");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("0000000000", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [0000000000]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [0000000000]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate6() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("1111111111");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("1111111111", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [1111111111]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [1111111111]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate7() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("2222222222");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("2222222222", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [2222222222]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [2222222222]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate8() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("3333333333");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("3333333333", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [3333333333]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [3333333333]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate9() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("4444444444");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("4444444444", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [4444444444]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [4444444444]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate10() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("Phone Number");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("Phone Number", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [Phone Number]; codes"
            + " [phone.ten_digits_required.Object Name.phoneNumber,phone.ten_digits_required.phoneNumber,phone.ten"
            + "_digits_required.java.lang.String,phone.ten_digits_required]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [Phone Number]; codes"
            + " [phone.ten_digits_required.Object Name.phoneNumber,phone.ten_digits_required.phoneNumber,phone.ten"
            + "_digits_required.java.lang.String,phone.ten_digits_required]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.ten_digits_required", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.ten_digits_required.Object Name.phoneNumber",
          "phone.ten_digits_required.phoneNumber",
          "phone.ten_digits_required.java.lang.String",
          "phone.ten_digits_required"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate11() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("5555555555");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("5555555555", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [5555555555]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [5555555555]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate12() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6666666666");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("6666666666", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [6666666666]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [6666666666]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate13() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("7777777777");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("7777777777", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [7777777777]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [7777777777]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate14() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("8888888888");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("8888888888", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [8888888888]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [8888888888]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }

  /**
   * Test {@link PhoneValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link PhoneValidator#validate(Object, Errors)}
   */
  @Test
  @DisplayName("Test validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneValidator.validate(Object, Errors)"})
  void testValidate15() {
    // Arrange
    PhoneValidator phoneValidator = new PhoneValidator();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("Extension");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("9999999999");
    BindException errors = new BindException(phoneImpl, "Object Name");

    // Act
    phoneValidator.validate(phoneImpl, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("9999999999", fieldError.getRejectedValue());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [9999999999]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Field error in object 'Object Name' on field 'phoneNumber': rejected value [9999999999]; codes"
            + " [phone.invalid.Object Name.phoneNumber,phone.invalid.phoneNumber,phone.invalid.java.lang.String,phone"
            + ".invalid]; arguments []; default message [null]",
        errors.getMessage());
    assertEquals("phone.invalid", fieldError.getCode());
    assertArrayEquals(
        new String[] {
          "phone.invalid.Object Name.phoneNumber",
          "phone.invalid.phoneNumber",
          "phone.invalid.java.lang.String",
          "phone.invalid"
        },
        fieldError.getCodes());
  }
}
