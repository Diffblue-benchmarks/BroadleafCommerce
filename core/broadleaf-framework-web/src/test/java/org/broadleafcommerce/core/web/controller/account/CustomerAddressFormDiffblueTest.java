/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
import org.junit.jupiter.api.Test;

class CustomerAddressFormDiffblueTest {
  /**
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
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  void testSetAddress() {
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
    assertSame(address, customerAddressForm.getAddress());
  }

  /**
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  void testSetAddress2() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setPrimaryPhone("6625550144");

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals("6625550144", phonePrimary.getPhoneNumber());
    assertNull(phoneFax.getId());
    assertNull(phonePrimary.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phonePrimary.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phonePrimary.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertFalse(phonePrimary.isDefault());
    assertTrue(phoneFax.isActive());
    assertTrue(phonePrimary.isActive());
    assertEquals(phoneFax, phoneSecondary);
    assertSame(address, customerAddressForm.getAddress());
  }

  /**
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  void testSetAddress3() {
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
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals("6625550144", phoneSecondary.getPhoneNumber());
    assertNull(phoneFax.getId());
    assertNull(phoneSecondary.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneSecondary.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneSecondary.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertFalse(phoneSecondary.isDefault());
    assertTrue(phoneFax.isActive());
    assertTrue(phoneSecondary.isActive());
    assertEquals(phoneFax, phonePrimary);
    assertSame(address, customerAddressForm.getAddress());
  }

  /**
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  void testSetAddress4() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setFax("Fax");

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals("Fax", phoneFax.getPhoneNumber());
    assertNull(phoneFax.getId());
    assertNull(phonePrimary.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phonePrimary.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phonePrimary.getExtension());
    assertNull(phonePrimary.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertFalse(phonePrimary.isDefault());
    assertTrue(phoneFax.isActive());
    assertTrue(phonePrimary.isActive());
    assertEquals(phonePrimary, phoneSecondary);
    assertSame(address, customerAddressForm.getAddress());
  }

  /**
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  void testSetAddress5() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    PhoneImpl phonePrimary = new PhoneImpl();
    address.setPhonePrimary(phonePrimary);

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phonePrimary, phoneFax);
    assertEquals(phonePrimary, phoneSecondary);
    assertSame(address, customerAddressForm.getAddress());
    assertSame(phonePrimary, address.getPhonePrimary());
  }

  /**
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  void testSetAddress6() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    PhoneImpl phoneSecondary = new PhoneImpl();
    address.setPhoneSecondary(phoneSecondary);

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    assertEquals(phoneSecondary, phoneFax);
    assertEquals(phoneSecondary, phonePrimary);
    assertSame(address, customerAddressForm.getAddress());
    assertSame(phoneSecondary, address.getPhoneSecondary());
  }

  /**
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  void testSetAddress7() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    PhoneImpl phoneFax = new PhoneImpl();
    address.setPhoneFax(phoneFax);

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
    assertSame(address, customerAddressForm.getAddress());
    assertSame(phoneFax, address.getPhoneFax());
  }

  /**
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  void testSetAddress8() {
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
    assertSame(address, customerAddressForm.getAddress());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CustomerAddressForm}
   */
  @Test
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
}
