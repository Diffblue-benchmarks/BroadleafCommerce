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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentInfoFormDiffblueTest {
  /**
   * Test new {@link PaymentInfoForm} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PaymentInfoForm}
   */
  @Test
  @DisplayName("Test new PaymentInfoForm (default constructor)")
  void testNewPaymentInfoForm() {
    // Arrange and Act
    PaymentInfoForm actualPaymentInfoForm = new PaymentInfoForm();

    // Assert
    Address address = actualPaymentInfoForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertNull(actualPaymentInfoForm.getCustomerPaymentId());
    assertNull(address.getId());
    assertNull(phoneFax.getId());
    assertNull(actualPaymentInfoForm.getEmailAddress());
    assertNull(actualPaymentInfoForm.getPaymentName());
    assertNull(actualPaymentInfoForm.getPaymentToken());
    assertNull(address.getAddressLine1());
    assertNull(address.getAddressLine2());
    assertNull(address.getAddressLine3());
    assertNull(address.getCity());
    assertNull(address.getCompanyName());
    assertNull(address.getCounty());
    assertNull(address.getEmailAddress());
    assertNull(address.getFax());
    assertNull(address.getFirstName());
    assertNull(address.getFullName());
    assertNull(address.getIsoCountrySubdivision());
    assertNull(address.getLastName());
    assertNull(address.getPostalCode());
    assertNull(address.getPrimaryPhone());
    assertNull(address.getSecondaryPhone());
    assertNull(address.getStateProvinceRegion());
    assertNull(address.getTokenizedAddress());
    assertNull(address.getVerificationLevel());
    assertNull(address.getZipFour());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertNull(address.getIsoCountryAlpha2());
    assertNull(address.getCountry());
    assertNull(address.getState());
    assertFalse(actualPaymentInfoForm.getIsDefault());
    assertFalse(actualPaymentInfoForm.getShouldUseCustomerPayment());
    assertFalse(actualPaymentInfoForm.getShouldUseShippingAddress());
    assertFalse(actualPaymentInfoForm.hasCustomerPaymentId());
    assertFalse(actualPaymentInfoForm.hasValidAddress());
    assertFalse(address.getStandardized());
    assertFalse(address.isBusiness());
    assertFalse(address.isDefault());
    assertFalse(address.isMailing());
    assertFalse(address.isStreet());
    assertFalse(phoneFax.isDefault());
    assertTrue(actualPaymentInfoForm.getShouldSaveNewPayment());
    assertTrue(address.isActive());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentInfoForm#setAddress(Address)}
   *   <li>{@link PaymentInfoForm#setCustomerPaymentId(Long)}
   *   <li>{@link PaymentInfoForm#setEmailAddress(String)}
   *   <li>{@link PaymentInfoForm#setIsDefault(boolean)}
   *   <li>{@link PaymentInfoForm#setPaymentName(String)}
   *   <li>{@link PaymentInfoForm#setPaymentToken(String)}
   *   <li>{@link PaymentInfoForm#setShouldSaveNewPayment(boolean)}
   *   <li>{@link PaymentInfoForm#setShouldUseCustomerPayment(boolean)}
   *   <li>{@link PaymentInfoForm#setShouldUseShippingAddress(boolean)}
   *   <li>{@link PaymentInfoForm#getAddress()}
   *   <li>{@link PaymentInfoForm#getCustomerPaymentId()}
   *   <li>{@link PaymentInfoForm#getEmailAddress()}
   *   <li>{@link PaymentInfoForm#getIsDefault()}
   *   <li>{@link PaymentInfoForm#getPaymentName()}
   *   <li>{@link PaymentInfoForm#getPaymentToken()}
   *   <li>{@link PaymentInfoForm#getShouldSaveNewPayment()}
   *   <li>{@link PaymentInfoForm#getShouldUseCustomerPayment()}
   *   <li>{@link PaymentInfoForm#getShouldUseShippingAddress()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    AddressImpl address = new AddressImpl();

    // Act
    paymentInfoForm.setAddress(address);
    paymentInfoForm.setCustomerPaymentId(1L);
    paymentInfoForm.setEmailAddress("42 Main St");
    paymentInfoForm.setIsDefault(true);
    paymentInfoForm.setPaymentName("Payment Name");
    paymentInfoForm.setPaymentToken("ABC123");
    paymentInfoForm.setShouldSaveNewPayment(true);
    paymentInfoForm.setShouldUseCustomerPayment(true);
    paymentInfoForm.setShouldUseShippingAddress(true);
    Address actualAddress = paymentInfoForm.getAddress();
    Long actualCustomerPaymentId = paymentInfoForm.getCustomerPaymentId();
    String actualEmailAddress = paymentInfoForm.getEmailAddress();
    boolean actualIsDefault = paymentInfoForm.getIsDefault();
    String actualPaymentName = paymentInfoForm.getPaymentName();
    String actualPaymentToken = paymentInfoForm.getPaymentToken();
    boolean actualShouldSaveNewPayment = paymentInfoForm.getShouldSaveNewPayment();
    boolean actualShouldUseCustomerPayment = paymentInfoForm.getShouldUseCustomerPayment();
    boolean actualShouldUseShippingAddress = paymentInfoForm.getShouldUseShippingAddress();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("ABC123", actualPaymentToken);
    assertEquals("Payment Name", actualPaymentName);
    assertEquals(1L, actualCustomerPaymentId.longValue());
    assertTrue(actualIsDefault);
    assertTrue(actualShouldSaveNewPayment);
    assertTrue(actualShouldUseCustomerPayment);
    assertTrue(actualShouldUseShippingAddress);
    assertSame(address, actualAddress);
  }

  /**
   * Test {@link PaymentInfoForm#hasCustomerPaymentId()}.
   * <ul>
   *   <li>Given {@link PaymentInfoForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentInfoForm#hasCustomerPaymentId()}
   */
  @Test
  @DisplayName("Test hasCustomerPaymentId(); given PaymentInfoForm (default constructor); then return 'false'")
  void testHasCustomerPaymentId_givenPaymentInfoForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PaymentInfoForm()).hasCustomerPaymentId());
  }

  /**
   * Test {@link PaymentInfoForm#hasCustomerPaymentId()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentInfoForm#hasCustomerPaymentId()}
   */
  @Test
  @DisplayName("Test hasCustomerPaymentId(); then return 'true'")
  void testHasCustomerPaymentId_thenReturnTrue() {
    // Arrange
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setCustomerPaymentId(1L);

    // Act and Assert
    assertTrue(paymentInfoForm.hasCustomerPaymentId());
  }

  /**
   * Test {@link PaymentInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) City is {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given AddressImpl (default constructor) City is 'foo'; then return 'true'")
  void testHasValidAddress_givenAddressImplCityIsFoo_thenReturnTrue() {
    // Arrange
    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStateProvinceRegion("us-east-2");
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setAddressLine1("foo");
    address.setCity("foo");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    // Act and Assert
    assertTrue(paymentInfoForm.hasValidAddress());
  }

  /**
   * Test {@link PaymentInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Country is
   * {@link CountryImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given AddressImpl (default constructor) Country is CountryImpl (default constructor); then return 'false'")
  void testHasValidAddress_givenAddressImplCountryIsCountryImpl_thenReturnFalse() {
    // Arrange
    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStateProvinceRegion("us-east-2");
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setAddressLine1("foo");
    address.setCity(null);

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    // Act and Assert
    assertFalse(paymentInfoForm.hasValidAddress());
  }

  /**
   * Test {@link PaymentInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Country is
   * {@link Country}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given AddressImpl (default constructor) Country is Country; then return 'false'")
  void testHasValidAddress_givenAddressImplCountryIsCountry_thenReturnFalse() {
    // Arrange
    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCountry(mock(Country.class));
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStateProvinceRegion("us-east-2");
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setAddressLine1("foo");
    address.setCity(null);

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    // Act and Assert
    assertFalse(paymentInfoForm.hasValidAddress());
  }

  /**
   * Test {@link PaymentInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link PaymentInfoForm} (default constructor) Address is
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given PaymentInfoForm (default constructor) Address is 'null'; then return 'false'")
  void testHasValidAddress_givenPaymentInfoFormAddressIsNull_thenReturnFalse() {
    // Arrange
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(null);

    // Act and Assert
    assertFalse(paymentInfoForm.hasValidAddress());
  }

  /**
   * Test {@link PaymentInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link PaymentInfoForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given PaymentInfoForm (default constructor); then return 'false'")
  void testHasValidAddress_givenPaymentInfoForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PaymentInfoForm()).hasValidAddress());
  }
}
