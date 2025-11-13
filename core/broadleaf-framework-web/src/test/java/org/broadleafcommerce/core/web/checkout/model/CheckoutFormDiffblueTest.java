package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.common.payment.CreditCardType;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutFormDiffblueTest {
  /**
   * Test new {@link CheckoutForm} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CheckoutForm}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CheckoutForm.<init>()"})
  public void testNewCheckoutForm() {
    // Arrange and Act
    CheckoutForm actualCheckoutForm = new CheckoutForm();

    // Assert
    Address billingAddress = actualCheckoutForm.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    Address shippingAddress = actualCheckoutForm.getShippingAddress();
    assertTrue(shippingAddress instanceof AddressImpl);
    assertNull(actualCheckoutForm.getCreditCardCvvCode());
    assertNull(actualCheckoutForm.getCreditCardExpMonth());
    assertNull(actualCheckoutForm.getCreditCardExpYear());
    assertNull(actualCheckoutForm.getCreditCardNumber());
    assertNull(actualCheckoutForm.getEmailAddress());
    assertNull(actualCheckoutForm.getSelectedCreditCardType());
    assertEquals(3, actualCheckoutForm.getApprovedCreditCardTypes().size());
    assertTrue(actualCheckoutForm.getIsSameAddress());
    assertEquals(billingAddress, shippingAddress);
  }

  /**
   * Test {@link CheckoutForm#getApprovedCreditCardTypes()}.
   *
   * <p>Method under test: {@link CheckoutForm#getApprovedCreditCardTypes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CheckoutForm.getApprovedCreditCardTypes()"})
  public void testGetApprovedCreditCardTypes() {
    // Arrange and Act
    List<CreditCardType> actualApprovedCreditCardTypes =
        new CheckoutForm().getApprovedCreditCardTypes();

    // Assert
    assertEquals(3, actualApprovedCreditCardTypes.size());
    CreditCardType getResult = actualApprovedCreditCardTypes.get(2);
    assertEquals("AMEX", getResult.getType());
    assertEquals("American Express", getResult.getFriendlyType());
    CreditCardType getResult2 = actualApprovedCreditCardTypes.get(1);
    assertEquals("MASTERCARD", getResult2.getType());
    assertEquals("Master Card", getResult2.getFriendlyType());
    CreditCardType getResult3 = actualApprovedCreditCardTypes.get(0);
    assertEquals("VISA", getResult3.getType());
    assertEquals("Visa", getResult3.getFriendlyType());
  }

  /**
   * Test {@link CheckoutForm#getShippingAddress()}.
   *
   * <ul>
   *   <li>Then IsoCountryAlpha2 return {@link ISOCountryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutForm#getShippingAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutForm.getShippingAddress()"})
  public void testGetShippingAddress_thenIsoCountryAlpha2ReturnISOCountryImpl() {
    // Arrange and Act
    Address actualShippingAddress = new CheckoutForm().getShippingAddress();

    // Assert
    assertTrue(actualShippingAddress.getIsoCountryAlpha2() instanceof ISOCountryImpl);
    assertTrue(actualShippingAddress instanceof AddressImpl);
    assertTrue(actualShippingAddress.getCountry() instanceof CountryImpl);
    Phone phoneFax = actualShippingAddress.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = actualShippingAddress.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = actualShippingAddress.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertTrue(actualShippingAddress.getState() instanceof StateImpl);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link CheckoutForm#getShippingAddress()}.
   *
   * <ul>
   *   <li>Then return {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CheckoutForm#getShippingAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutForm.getShippingAddress()"})
  public void testGetShippingAddress_thenReturnAddressImpl() {
    // Arrange
    CheckoutForm checkoutForm = new CheckoutForm();
    AddressImpl billingAddress = new AddressImpl();
    checkoutForm.setBillingAddress(billingAddress);
    checkoutForm.setCreditCardCvvCode("Credit Card Cvv Code");
    checkoutForm.setCreditCardExpMonth("Credit Card Exp Month");
    checkoutForm.setCreditCardExpYear("Credit Card Exp Year");
    checkoutForm.setCreditCardNumber("42");
    checkoutForm.setEmailAddress("42 Main St");
    checkoutForm.setIsSameAddress(true);
    checkoutForm.setSelectedCreditCardType("Selected Credit Card Type");
    checkoutForm.setShippingAddress(null);

    // Act
    Address actualShippingAddress = checkoutForm.getShippingAddress();

    // Assert
    assertTrue(actualShippingAddress instanceof AddressImpl);
    assertEquals(billingAddress, actualShippingAddress);
  }

  /**
   * Test {@link CheckoutForm#getBillingAddress()}.
   *
   * <ul>
   *   <li>Given {@link CheckoutForm} (default constructor).
   *   <li>Then IsoCountryAlpha2 return {@link ISOCountryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutForm#getBillingAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutForm.getBillingAddress()"})
  public void testGetBillingAddress_givenCheckoutForm_thenIsoCountryAlpha2ReturnISOCountryImpl() {
    // Arrange and Act
    Address actualBillingAddress = new CheckoutForm().getBillingAddress();

    // Assert
    assertTrue(actualBillingAddress.getIsoCountryAlpha2() instanceof ISOCountryImpl);
    assertTrue(actualBillingAddress instanceof AddressImpl);
    assertTrue(actualBillingAddress.getCountry() instanceof CountryImpl);
    Phone phoneFax = actualBillingAddress.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = actualBillingAddress.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = actualBillingAddress.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertTrue(actualBillingAddress.getState() instanceof StateImpl);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link CheckoutForm#getBillingAddress()}.
   *
   * <ul>
   *   <li>Then return {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CheckoutForm#getBillingAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutForm.getBillingAddress()"})
  public void testGetBillingAddress_thenReturnAddressImpl() {
    // Arrange
    CheckoutForm checkoutForm = new CheckoutForm();
    checkoutForm.setCreditCardCvvCode("Credit Card Cvv Code");
    checkoutForm.setCreditCardExpMonth("Credit Card Exp Month");
    checkoutForm.setCreditCardExpYear("Credit Card Exp Year");
    checkoutForm.setCreditCardNumber("42");
    checkoutForm.setEmailAddress("42 Main St");
    checkoutForm.setIsSameAddress(true);
    checkoutForm.setSelectedCreditCardType("Selected Credit Card Type");
    AddressImpl shippingAddress = new AddressImpl();
    checkoutForm.setShippingAddress(shippingAddress);
    checkoutForm.setBillingAddress(null);

    // Act
    Address actualBillingAddress = checkoutForm.getBillingAddress();

    // Assert
    assertTrue(actualBillingAddress instanceof AddressImpl);
    assertEquals(shippingAddress, actualBillingAddress);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutForm#setBillingAddress(Address)}
   *   <li>{@link CheckoutForm#setCreditCardCvvCode(String)}
   *   <li>{@link CheckoutForm#setCreditCardExpMonth(String)}
   *   <li>{@link CheckoutForm#setCreditCardExpYear(String)}
   *   <li>{@link CheckoutForm#setCreditCardNumber(String)}
   *   <li>{@link CheckoutForm#setEmailAddress(String)}
   *   <li>{@link CheckoutForm#setIsSameAddress(boolean)}
   *   <li>{@link CheckoutForm#setSelectedCreditCardType(String)}
   *   <li>{@link CheckoutForm#setShippingAddress(Address)}
   *   <li>{@link CheckoutForm#getCreditCardCvvCode()}
   *   <li>{@link CheckoutForm#getCreditCardExpMonth()}
   *   <li>{@link CheckoutForm#getCreditCardExpYear()}
   *   <li>{@link CheckoutForm#getCreditCardNumber()}
   *   <li>{@link CheckoutForm#getEmailAddress()}
   *   <li>{@link CheckoutForm#getIsSameAddress()}
   *   <li>{@link CheckoutForm#getSelectedCreditCardType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CheckoutForm.getCreditCardCvvCode()",
    "String CheckoutForm.getCreditCardExpMonth()",
    "String CheckoutForm.getCreditCardExpYear()",
    "String CheckoutForm.getCreditCardNumber()",
    "String CheckoutForm.getEmailAddress()",
    "boolean CheckoutForm.getIsSameAddress()",
    "String CheckoutForm.getSelectedCreditCardType()",
    "void CheckoutForm.setBillingAddress(Address)",
    "void CheckoutForm.setCreditCardCvvCode(String)",
    "void CheckoutForm.setCreditCardExpMonth(String)",
    "void CheckoutForm.setCreditCardExpYear(String)",
    "void CheckoutForm.setCreditCardNumber(String)",
    "void CheckoutForm.setEmailAddress(String)",
    "void CheckoutForm.setIsSameAddress(boolean)",
    "void CheckoutForm.setSelectedCreditCardType(String)",
    "void CheckoutForm.setShippingAddress(Address)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CheckoutForm checkoutForm = new CheckoutForm();

    // Act
    checkoutForm.setBillingAddress(new AddressImpl());
    checkoutForm.setCreditCardCvvCode("Credit Card Cvv Code");
    checkoutForm.setCreditCardExpMonth("Credit Card Exp Month");
    checkoutForm.setCreditCardExpYear("Credit Card Exp Year");
    checkoutForm.setCreditCardNumber("42");
    checkoutForm.setEmailAddress("42 Main St");
    checkoutForm.setIsSameAddress(true);
    checkoutForm.setSelectedCreditCardType("Selected Credit Card Type");
    checkoutForm.setShippingAddress(new AddressImpl());
    String actualCreditCardCvvCode = checkoutForm.getCreditCardCvvCode();
    String actualCreditCardExpMonth = checkoutForm.getCreditCardExpMonth();
    String actualCreditCardExpYear = checkoutForm.getCreditCardExpYear();
    String actualCreditCardNumber = checkoutForm.getCreditCardNumber();
    String actualEmailAddress = checkoutForm.getEmailAddress();
    boolean actualIsSameAddress = checkoutForm.getIsSameAddress();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("42", actualCreditCardNumber);
    assertEquals("Credit Card Cvv Code", actualCreditCardCvvCode);
    assertEquals("Credit Card Exp Month", actualCreditCardExpMonth);
    assertEquals("Credit Card Exp Year", actualCreditCardExpYear);
    assertEquals("Selected Credit Card Type", checkoutForm.getSelectedCreditCardType());
    assertTrue(actualIsSameAddress);
  }
}
