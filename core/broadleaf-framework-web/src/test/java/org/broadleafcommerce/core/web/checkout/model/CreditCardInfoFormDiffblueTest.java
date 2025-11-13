package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CreditCardInfoFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CreditCardInfoForm}
   *   <li>{@link CreditCardInfoForm#setCreditCardCvvCode(String)}
   *   <li>{@link CreditCardInfoForm#setCreditCardExpMonth(String)}
   *   <li>{@link CreditCardInfoForm#setCreditCardExpYear(String)}
   *   <li>{@link CreditCardInfoForm#setCreditCardName(String)}
   *   <li>{@link CreditCardInfoForm#setCreditCardNumber(String)}
   *   <li>{@link CreditCardInfoForm#setPaymentMethod(String)}
   *   <li>{@link CreditCardInfoForm#setSelectedCreditCardType(String)}
   *   <li>{@link CreditCardInfoForm#getCreditCardCvvCode()}
   *   <li>{@link CreditCardInfoForm#getCreditCardExpMonth()}
   *   <li>{@link CreditCardInfoForm#getCreditCardExpYear()}
   *   <li>{@link CreditCardInfoForm#getCreditCardName()}
   *   <li>{@link CreditCardInfoForm#getCreditCardNumber()}
   *   <li>{@link CreditCardInfoForm#getPaymentMethod()}
   *   <li>{@link CreditCardInfoForm#getSelectedCreditCardType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreditCardInfoForm.<init>()",
    "String CreditCardInfoForm.getCreditCardCvvCode()",
    "String CreditCardInfoForm.getCreditCardExpMonth()",
    "String CreditCardInfoForm.getCreditCardExpYear()",
    "String CreditCardInfoForm.getCreditCardName()",
    "String CreditCardInfoForm.getCreditCardNumber()",
    "String CreditCardInfoForm.getPaymentMethod()",
    "String CreditCardInfoForm.getSelectedCreditCardType()",
    "void CreditCardInfoForm.setCreditCardCvvCode(String)",
    "void CreditCardInfoForm.setCreditCardExpMonth(String)",
    "void CreditCardInfoForm.setCreditCardExpYear(String)",
    "void CreditCardInfoForm.setCreditCardName(String)",
    "void CreditCardInfoForm.setCreditCardNumber(String)",
    "void CreditCardInfoForm.setPaymentMethod(String)",
    "void CreditCardInfoForm.setSelectedCreditCardType(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CreditCardInfoForm actualCreditCardInfoForm = new CreditCardInfoForm();
    actualCreditCardInfoForm.setCreditCardCvvCode("Credit Card Cvv Code");
    actualCreditCardInfoForm.setCreditCardExpMonth("Credit Card Exp Month");
    actualCreditCardInfoForm.setCreditCardExpYear("Credit Card Exp Year");
    actualCreditCardInfoForm.setCreditCardName("Credit Card Name");
    actualCreditCardInfoForm.setCreditCardNumber("42");
    actualCreditCardInfoForm.setPaymentMethod("Payment Method");
    actualCreditCardInfoForm.setSelectedCreditCardType("Selected Credit Card Type");
    String actualCreditCardCvvCode = actualCreditCardInfoForm.getCreditCardCvvCode();
    String actualCreditCardExpMonth = actualCreditCardInfoForm.getCreditCardExpMonth();
    String actualCreditCardExpYear = actualCreditCardInfoForm.getCreditCardExpYear();
    String actualCreditCardName = actualCreditCardInfoForm.getCreditCardName();
    String actualCreditCardNumber = actualCreditCardInfoForm.getCreditCardNumber();
    String actualPaymentMethod = actualCreditCardInfoForm.getPaymentMethod();

    // Assert
    assertEquals("42", actualCreditCardNumber);
    assertEquals("Credit Card Cvv Code", actualCreditCardCvvCode);
    assertEquals("Credit Card Exp Month", actualCreditCardExpMonth);
    assertEquals("Credit Card Exp Year", actualCreditCardExpYear);
    assertEquals("Credit Card Name", actualCreditCardName);
    assertEquals("Payment Method", actualPaymentMethod);
    assertEquals("Selected Credit Card Type", actualCreditCardInfoForm.getSelectedCreditCardType());
  }
}
