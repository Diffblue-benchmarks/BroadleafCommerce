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
package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.broadleafcommerce.common.i18n.domain.ISOCountry;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.common.payment.CreditCardType;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckoutFormDiffblueTest {
  /**
   * Test new {@link CheckoutForm} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CheckoutForm}
   */
  @Test
  @DisplayName("Test new CheckoutForm (default constructor)")
  void testNewCheckoutForm() {
    // Arrange and Act
    CheckoutForm actualCheckoutForm = new CheckoutForm();

    // Assert
    Address billingAddress = actualCheckoutForm.getBillingAddress();
    ISOCountry isoCountryAlpha2 = billingAddress.getIsoCountryAlpha2();
    assertTrue(isoCountryAlpha2 instanceof ISOCountryImpl);
    assertTrue(billingAddress instanceof AddressImpl);
    Address shippingAddress = actualCheckoutForm.getShippingAddress();
    assertTrue(shippingAddress instanceof AddressImpl);
    Country country = billingAddress.getCountry();
    assertTrue(country instanceof CountryImpl);
    Phone phoneFax = billingAddress.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = billingAddress.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = billingAddress.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    State state = billingAddress.getState();
    assertTrue(state instanceof StateImpl);
    List<CreditCardType> approvedCreditCardTypes = actualCheckoutForm.getApprovedCreditCardTypes();
    assertEquals(3, approvedCreditCardTypes.size());
    CreditCardType getResult = approvedCreditCardTypes.get(2);
    assertEquals("AMEX", getResult.getType());
    assertEquals("American Express", getResult.getFriendlyType());
    CreditCardType getResult2 = approvedCreditCardTypes.get(1);
    assertEquals("MASTERCARD", getResult2.getType());
    assertEquals("Master Card", getResult2.getFriendlyType());
    CreditCardType getResult3 = approvedCreditCardTypes.get(0);
    assertEquals("VISA", getResult3.getType());
    assertEquals("Visa", getResult3.getFriendlyType());
    assertNull(isoCountryAlpha2.getNumericCode());
    assertNull(billingAddress.getId());
    assertNull(phoneFax.getId());
    assertNull(isoCountryAlpha2.getAlpha2());
    assertNull(isoCountryAlpha2.getAlpha3());
    assertNull(isoCountryAlpha2.getName());
    assertNull(((ISOCountryImpl) isoCountryAlpha2).getMainEntityName());
    assertNull(actualCheckoutForm.getCreditCardCvvCode());
    assertNull(actualCheckoutForm.getCreditCardExpMonth());
    assertNull(actualCheckoutForm.getCreditCardExpYear());
    assertNull(actualCheckoutForm.getCreditCardNumber());
    assertNull(actualCheckoutForm.getEmailAddress());
    assertNull(actualCheckoutForm.getSelectedCreditCardType());
    assertNull(billingAddress.getAddressLine1());
    assertNull(billingAddress.getAddressLine2());
    assertNull(billingAddress.getAddressLine3());
    assertNull(billingAddress.getCity());
    assertNull(billingAddress.getCompanyName());
    assertNull(billingAddress.getCounty());
    assertNull(billingAddress.getEmailAddress());
    assertNull(billingAddress.getFax());
    assertNull(billingAddress.getFirstName());
    assertNull(billingAddress.getFullName());
    assertNull(billingAddress.getIsoCountrySubdivision());
    assertNull(billingAddress.getLastName());
    assertNull(billingAddress.getPostalCode());
    assertNull(billingAddress.getPrimaryPhone());
    assertNull(billingAddress.getSecondaryPhone());
    assertNull(billingAddress.getStateProvinceRegion());
    assertNull(billingAddress.getTokenizedAddress());
    assertNull(billingAddress.getVerificationLevel());
    assertNull(billingAddress.getZipFour());
    assertNull(country.getAbbreviation());
    assertNull(country.getName());
    assertNull(((CountryImpl) country).getMainEntityName());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertNull(state.getAbbreviation());
    assertNull(state.getName());
    assertNull(isoCountryAlpha2.getStatus());
    assertNull(state.getCountry());
    assertFalse(billingAddress.getStandardized());
    assertFalse(billingAddress.isBusiness());
    assertFalse(billingAddress.isDefault());
    assertFalse(billingAddress.isMailing());
    assertFalse(billingAddress.isStreet());
    assertFalse(phoneFax.isDefault());
    assertTrue(actualCheckoutForm.getIsSameAddress());
    assertTrue(billingAddress.isActive());
    assertTrue(phoneFax.isActive());
    assertEquals(billingAddress, shippingAddress);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link CheckoutForm#getApprovedCreditCardTypes()}.
   * <p>
   * Method under test: {@link CheckoutForm#getApprovedCreditCardTypes()}
   */
  @Test
  @DisplayName("Test getApprovedCreditCardTypes()")
  void testGetApprovedCreditCardTypes() {
    // Arrange and Act
    List<CreditCardType> actualApprovedCreditCardTypes = (new CheckoutForm()).getApprovedCreditCardTypes();

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
   * <ul>
   *   <li>Then IsoCountryAlpha2 return {@link ISOCountryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutForm#getShippingAddress()}
   */
  @Test
  @DisplayName("Test getShippingAddress(); then IsoCountryAlpha2 return ISOCountryImpl")
  void testGetShippingAddress_thenIsoCountryAlpha2ReturnISOCountryImpl() {
    // Arrange and Act
    Address actualShippingAddress = (new CheckoutForm()).getShippingAddress();

    // Assert
    ISOCountry isoCountryAlpha2 = actualShippingAddress.getIsoCountryAlpha2();
    assertTrue(isoCountryAlpha2 instanceof ISOCountryImpl);
    assertTrue(actualShippingAddress instanceof AddressImpl);
    Country country = actualShippingAddress.getCountry();
    assertTrue(country instanceof CountryImpl);
    Phone phoneFax = actualShippingAddress.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = actualShippingAddress.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = actualShippingAddress.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    State state = actualShippingAddress.getState();
    assertTrue(state instanceof StateImpl);
    assertNull(isoCountryAlpha2.getNumericCode());
    assertNull(phoneFax.getId());
    assertNull(isoCountryAlpha2.getAlpha2());
    assertNull(isoCountryAlpha2.getAlpha3());
    assertNull(isoCountryAlpha2.getName());
    assertNull(((ISOCountryImpl) isoCountryAlpha2).getMainEntityName());
    assertNull(country.getAbbreviation());
    assertNull(country.getName());
    assertNull(((CountryImpl) country).getMainEntityName());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertNull(state.getAbbreviation());
    assertNull(state.getName());
    assertNull(isoCountryAlpha2.getStatus());
    assertNull(state.getCountry());
    assertFalse(phoneFax.isDefault());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link CheckoutForm#getShippingAddress()}.
   * <ul>
   *   <li>Then return {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutForm#getShippingAddress()}
   */
  @Test
  @DisplayName("Test getShippingAddress(); then return AddressImpl (default constructor)")
  void testGetShippingAddress_thenReturnAddressImpl() {
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
   * <ul>
   *   <li>Given {@link CheckoutForm} (default constructor).</li>
   *   <li>Then IsoCountryAlpha2 return {@link ISOCountryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutForm#getBillingAddress()}
   */
  @Test
  @DisplayName("Test getBillingAddress(); given CheckoutForm (default constructor); then IsoCountryAlpha2 return ISOCountryImpl")
  void testGetBillingAddress_givenCheckoutForm_thenIsoCountryAlpha2ReturnISOCountryImpl() {
    // Arrange and Act
    Address actualBillingAddress = (new CheckoutForm()).getBillingAddress();

    // Assert
    ISOCountry isoCountryAlpha2 = actualBillingAddress.getIsoCountryAlpha2();
    assertTrue(isoCountryAlpha2 instanceof ISOCountryImpl);
    assertTrue(actualBillingAddress instanceof AddressImpl);
    Country country = actualBillingAddress.getCountry();
    assertTrue(country instanceof CountryImpl);
    Phone phoneFax = actualBillingAddress.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = actualBillingAddress.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = actualBillingAddress.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    State state = actualBillingAddress.getState();
    assertTrue(state instanceof StateImpl);
    assertNull(isoCountryAlpha2.getNumericCode());
    assertNull(phoneFax.getId());
    assertNull(isoCountryAlpha2.getAlpha2());
    assertNull(isoCountryAlpha2.getAlpha3());
    assertNull(isoCountryAlpha2.getName());
    assertNull(((ISOCountryImpl) isoCountryAlpha2).getMainEntityName());
    assertNull(country.getAbbreviation());
    assertNull(country.getName());
    assertNull(((CountryImpl) country).getMainEntityName());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertNull(state.getAbbreviation());
    assertNull(state.getName());
    assertNull(isoCountryAlpha2.getStatus());
    assertNull(state.getCountry());
    assertFalse(phoneFax.isDefault());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link CheckoutForm#getBillingAddress()}.
   * <ul>
   *   <li>Then return {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutForm#getBillingAddress()}
   */
  @Test
  @DisplayName("Test getBillingAddress(); then return AddressImpl (default constructor)")
  void testGetBillingAddress_thenReturnAddressImpl() {
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
   * <p>
   * Methods under test:
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
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

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("42", actualCreditCardNumber);
    assertEquals("Credit Card Cvv Code", actualCreditCardCvvCode);
    assertEquals("Credit Card Exp Month", actualCreditCardExpMonth);
    assertEquals("Credit Card Exp Year", actualCreditCardExpYear);
    assertEquals("Selected Credit Card Type", checkoutForm.getSelectedCreditCardType());
    assertTrue(actualIsSameAddress);
  }
}
