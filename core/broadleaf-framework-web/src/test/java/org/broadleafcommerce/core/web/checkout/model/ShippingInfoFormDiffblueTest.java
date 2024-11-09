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
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShippingInfoFormDiffblueTest {
  /**
   * Test new {@link ShippingInfoForm} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ShippingInfoForm}
   */
  @Test
  @DisplayName("Test new ShippingInfoForm (default constructor)")
  void testNewShippingInfoForm() {
    // Arrange and Act
    ShippingInfoForm actualShippingInfoForm = new ShippingInfoForm();

    // Assert
    PersonalMessage personalMessage = actualShippingInfoForm.getPersonalMessage();
    assertTrue(personalMessage instanceof PersonalMessageImpl);
    Address address = actualShippingInfoForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertNull(personalMessage.getId());
    assertNull(actualShippingInfoForm.getFulfillmentOptionId());
    assertNull(address.getId());
    assertNull(phoneFax.getId());
    assertNull(personalMessage.getMessage());
    assertNull(personalMessage.getMessageFrom());
    assertNull(personalMessage.getMessageTo());
    assertNull(personalMessage.getOccasion());
    assertNull(actualShippingInfoForm.getAddressName());
    assertNull(actualShippingInfoForm.getDeliveryMessage());
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
    assertNull(actualShippingInfoForm.getFulfillmentOption());
    assertNull(address.getCountry());
    assertNull(address.getState());
    assertFalse(actualShippingInfoForm.hasValidAddress());
    assertFalse(actualShippingInfoForm.isSaveAsDefault());
    assertFalse(actualShippingInfoForm.isUseBillingAddress());
    assertFalse(address.getStandardized());
    assertFalse(address.isBusiness());
    assertFalse(address.isDefault());
    assertFalse(address.isMailing());
    assertFalse(address.isStreet());
    assertFalse(phoneFax.isDefault());
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
   *   <li>{@link ShippingInfoForm#setAddress(Address)}
   *   <li>{@link ShippingInfoForm#setAddressName(String)}
   *   <li>{@link ShippingInfoForm#setDeliveryMessage(String)}
   *   <li>{@link ShippingInfoForm#setFulfillmentOption(FulfillmentOption)}
   *   <li>{@link ShippingInfoForm#setFulfillmentOptionId(Long)}
   *   <li>{@link ShippingInfoForm#setPersonalMessage(PersonalMessage)}
   *   <li>{@link ShippingInfoForm#setSaveAsDefault(boolean)}
   *   <li>{@link ShippingInfoForm#setUseBillingAddress(boolean)}
   *   <li>{@link ShippingInfoForm#getAddress()}
   *   <li>{@link ShippingInfoForm#getAddressName()}
   *   <li>{@link ShippingInfoForm#getDeliveryMessage()}
   *   <li>{@link ShippingInfoForm#getFulfillmentOption()}
   *   <li>{@link ShippingInfoForm#getFulfillmentOptionId()}
   *   <li>{@link ShippingInfoForm#getPersonalMessage()}
   *   <li>{@link ShippingInfoForm#isSaveAsDefault()}
   *   <li>{@link ShippingInfoForm#isUseBillingAddress()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    AddressImpl address = new AddressImpl();

    // Act
    shippingInfoForm.setAddress(address);
    shippingInfoForm.setAddressName("42 Main St");
    shippingInfoForm.setDeliveryMessage("Delivery Message");
    FulfillmentOptionImpl fulfillmentOption = new FulfillmentOptionImpl();
    shippingInfoForm.setFulfillmentOption(fulfillmentOption);
    shippingInfoForm.setFulfillmentOptionId(1L);
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    shippingInfoForm.setPersonalMessage(personalMessage);
    shippingInfoForm.setSaveAsDefault(true);
    shippingInfoForm.setUseBillingAddress(true);
    Address actualAddress = shippingInfoForm.getAddress();
    String actualAddressName = shippingInfoForm.getAddressName();
    String actualDeliveryMessage = shippingInfoForm.getDeliveryMessage();
    FulfillmentOption actualFulfillmentOption = shippingInfoForm.getFulfillmentOption();
    Long actualFulfillmentOptionId = shippingInfoForm.getFulfillmentOptionId();
    PersonalMessage actualPersonalMessage = shippingInfoForm.getPersonalMessage();
    boolean actualIsSaveAsDefaultResult = shippingInfoForm.isSaveAsDefault();
    boolean actualIsUseBillingAddressResult = shippingInfoForm.isUseBillingAddress();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddressName);
    assertEquals("Delivery Message", actualDeliveryMessage);
    assertEquals(1L, actualFulfillmentOptionId.longValue());
    assertTrue(actualIsSaveAsDefaultResult);
    assertTrue(actualIsUseBillingAddressResult);
    assertSame(fulfillmentOption, actualFulfillmentOption);
    assertSame(personalMessage, actualPersonalMessage);
    assertSame(address, actualAddress);
  }

  /**
   * Test {@link ShippingInfoForm#shouldUseBillingAddress()}.
   * <ul>
   *   <li>Given {@link ShippingInfoForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#shouldUseBillingAddress()}
   */
  @Test
  @DisplayName("Test shouldUseBillingAddress(); given ShippingInfoForm (default constructor); then return 'false'")
  void testShouldUseBillingAddress_givenShippingInfoForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ShippingInfoForm()).shouldUseBillingAddress());
  }

  /**
   * Test {@link ShippingInfoForm#shouldUseBillingAddress()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#shouldUseBillingAddress()}
   */
  @Test
  @DisplayName("Test shouldUseBillingAddress(); then return 'true'")
  void testShouldUseBillingAddress_thenReturnTrue() {
    // Arrange
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setUseBillingAddress(true);

    // Act and Assert
    assertTrue(shippingInfoForm.shouldUseBillingAddress());
  }

  /**
   * Test {@link ShippingInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) City is {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#hasValidAddress()}
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
    address.setCity("foo");
    address.setAddressLine1("foo");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address);

    // Act and Assert
    assertTrue(shippingInfoForm.hasValidAddress());
  }

  /**
   * Test {@link ShippingInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Country is
   * {@link CountryImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#hasValidAddress()}
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
    address.setCity(null);
    address.setAddressLine1("foo");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address);

    // Act and Assert
    assertFalse(shippingInfoForm.hasValidAddress());
  }

  /**
   * Test {@link ShippingInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Country is
   * {@link Country}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#hasValidAddress()}
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
    address.setCity(null);
    address.setAddressLine1("foo");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address);

    // Act and Assert
    assertFalse(shippingInfoForm.hasValidAddress());
  }

  /**
   * Test {@link ShippingInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link ShippingInfoForm} (default constructor) Address is
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given ShippingInfoForm (default constructor) Address is 'null'; then return 'false'")
  void testHasValidAddress_givenShippingInfoFormAddressIsNull_thenReturnFalse() {
    // Arrange
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(null);

    // Act and Assert
    assertFalse(shippingInfoForm.hasValidAddress());
  }

  /**
   * Test {@link ShippingInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link ShippingInfoForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given ShippingInfoForm (default constructor); then return 'false'")
  void testHasValidAddress_givenShippingInfoForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ShippingInfoForm()).hasValidAddress());
  }
}
