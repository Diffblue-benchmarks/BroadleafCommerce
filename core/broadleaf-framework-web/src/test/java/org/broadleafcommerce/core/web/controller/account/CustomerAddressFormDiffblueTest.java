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
package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerAddressFormDiffblueTest {
  /**
   * Test new {@link CustomerAddressForm} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CustomerAddressForm}
   */
  @Test
  @DisplayName("Test new CustomerAddressForm (default constructor)")
  void testNewCustomerAddressForm() {
    // Arrange and Act
    CustomerAddressForm actualCustomerAddressForm = new CustomerAddressForm();

    // Assert
    Address address = actualCustomerAddressForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertNull(actualCustomerAddressForm.getCustomerAddressId());
    assertNull(address.getId());
    assertNull(phoneFax.getId());
    assertNull(actualCustomerAddressForm.getAddressName());
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
   *   <li>{@link CustomerAddressForm#setAddressName(String)}
   *   <li>{@link CustomerAddressForm#setCustomerAddressId(Long)}
   *   <li>{@link CustomerAddressForm#getAddress()}
   *   <li>{@link CustomerAddressForm#getAddressName()}
   *   <li>{@link CustomerAddressForm#getCustomerAddressId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    // Act
    customerAddressForm.setAddressName("42 Main St");
    customerAddressForm.setCustomerAddressId(1L);
    Address actualAddress = customerAddressForm.getAddress();
    String actualAddressName = customerAddressForm.getAddressName();

    // Assert that nothing has changed
    assertTrue(actualAddress instanceof AddressImpl);
    assertEquals("42 Main St", actualAddressName);
    assertEquals(1L, customerAddressForm.getCustomerAddressId().longValue());
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>Given {@code 6625550144}.</li>
   *   <li>When {@link AddressImpl} (default constructor) PrimaryPhone is
   * {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); given '6625550144'; when AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  void testSetAddress_given6625550144_whenAddressImplPrimaryPhoneIs6625550144() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setPrimaryPhone("6625550144");

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    assertTrue(address.getPhonePrimary() instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertNull(phoneFax.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>Given {@code Fax}.</li>
   *   <li>Then {@link AddressImpl} (default constructor) PhonePrimary Id is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); given 'Fax'; then AddressImpl (default constructor) PhonePrimary Id is 'null'")
  void testSetAddress_givenFax_thenAddressImplPhonePrimaryIdIsNull() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setFax("Fax");

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    assertNull(phonePrimary.getId());
    assertNull(phonePrimary.getCountryCode());
    assertNull(phonePrimary.getExtension());
    assertNull(phonePrimary.getPhoneNumber());
    assertFalse(phonePrimary.isDefault());
    assertTrue(phonePrimary.isActive());
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>Given {@link PhoneImpl} (default constructor).</li>
   *   <li>When {@link AddressImpl} (default constructor) PhonePrimary is
   * {@link PhoneImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); given PhoneImpl (default constructor); when AddressImpl (default constructor) PhonePrimary is PhoneImpl (default constructor)")
  void testSetAddress_givenPhoneImpl_whenAddressImplPhonePrimaryIsPhoneImpl() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setPhonePrimary(new PhoneImpl());

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    assertTrue(address.getPhoneFax() instanceof PhoneImpl);
    assertTrue(address.getPhoneSecondary() instanceof PhoneImpl);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>Given {@link Phone}.</li>
   *   <li>When {@link AddressImpl} (default constructor) PhonePrimary is
   * {@link Phone}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); given Phone; when AddressImpl (default constructor) PhonePrimary is Phone")
  void testSetAddress_givenPhone_whenAddressImplPhonePrimaryIsPhone() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setPhonePrimary(mock(Phone.class));

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertNull(phoneFax.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>Then {@link AddressImpl} (default constructor) PhonePrimary is
   * {@link PhoneImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); then AddressImpl (default constructor) PhonePrimary is PhoneImpl (default constructor)")
  void testSetAddress_thenAddressImplPhonePrimaryIsPhoneImpl() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    PhoneImpl phoneFax = new PhoneImpl();
    address.setPhoneFax(phoneFax);

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax2 = address.getPhoneFax();
    assertTrue(phoneFax2 instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
    assertSame(phoneFax, phoneFax2);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor) PhoneSecondary is
   * {@link PhoneImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); when AddressImpl (default constructor) PhoneSecondary is PhoneImpl (default constructor)")
  void testSetAddress_whenAddressImplPhoneSecondaryIsPhoneImpl() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    PhoneImpl phoneSecondary = new PhoneImpl();
    address.setPhoneSecondary(phoneSecondary);

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    assertTrue(address.getPhoneFax() instanceof PhoneImpl);
    assertTrue(address.getPhonePrimary() instanceof PhoneImpl);
    Phone phoneSecondary2 = address.getPhoneSecondary();
    assertTrue(phoneSecondary2 instanceof PhoneImpl);
    assertSame(phoneSecondary, phoneSecondary2);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor) SecondaryPhone is
   * {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); when AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  void testSetAddress_whenAddressImplSecondaryPhoneIs6625550144() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setSecondaryPhone("6625550144");

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    assertTrue(address.getPhoneSecondary() instanceof PhoneImpl);
    assertNull(phoneFax.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phonePrimary);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).</li>
   *   <li>Then {@link AddressImpl} (default constructor) PhonePrimary is
   * {@link AddressImpl} (default constructor) PhoneFax.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); when AddressImpl (default constructor); then AddressImpl (default constructor) PhonePrimary is AddressImpl (default constructor) PhoneFax")
  void testSetAddress_whenAddressImpl_thenAddressImplPhonePrimaryIsAddressImplPhoneFax() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();
    AddressImpl address = new AddressImpl();

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertNull(phoneFax.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }
}
