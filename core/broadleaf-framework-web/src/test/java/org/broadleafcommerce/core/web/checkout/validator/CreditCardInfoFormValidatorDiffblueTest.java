package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.CreditCardInfoForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

public class CreditCardInfoFormValidatorDiffblueTest {
  /**
   * Test {@link CreditCardInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardInfoFormValidator.supports(Class)"})
  public void testSupports_thenReturnTrue() {
    // Arrange
    CreditCardInfoFormValidator creditCardInfoFormValidator = new CreditCardInfoFormValidator();
    Class<CreditCardInfoForm> clazz = CreditCardInfoForm.class;

    // Act and Assert
    assertTrue(creditCardInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link CreditCardInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardInfoFormValidator.supports(Class)"})
  public void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CreditCardInfoFormValidator creditCardInfoFormValidator = new CreditCardInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(creditCardInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link CreditCardInfoFormValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link CreditCardInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CreditCardInfoFormValidator.validate(Object, Errors)"})
  public void testValidate() {
    // Arrange
    CreditCardInfoFormValidator creditCardInfoFormValidator = new CreditCardInfoFormValidator();

    CreditCardInfoForm creditCardInfoForm = new CreditCardInfoForm();
    creditCardInfoForm.setCreditCardCvvCode("Credit Card Cvv Code");
    creditCardInfoForm.setCreditCardExpMonth("Credit Card Exp Month");
    creditCardInfoForm.setCreditCardExpYear("Credit Card Exp Year");
    creditCardInfoForm.setCreditCardName("Credit Card Name");
    creditCardInfoForm.setCreditCardNumber("42");
    creditCardInfoForm.setPaymentMethod("Payment Method");
    creditCardInfoForm.setSelectedCreditCardType("Selected Credit Card Type");
    BindException errors =
        new BindException(
            creditCardInfoForm, "org.broadleafcommerce.core.web.checkout.model.CreditCardInfoForm");

    // Act and Assert
    creditCardInfoFormValidator.validate(creditCardInfoForm, errors);
  }
}
