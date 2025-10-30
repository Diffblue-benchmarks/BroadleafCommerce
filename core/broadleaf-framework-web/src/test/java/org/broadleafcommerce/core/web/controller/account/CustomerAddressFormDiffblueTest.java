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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomerAddressFormDiffblueTest {
  /**
   * Test new {@link CustomerAddressForm} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CustomerAddressForm}
   */
  @Test
  @DisplayName("Test new CustomerAddressForm (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerAddressForm.<init>()"})
  void testNewCustomerAddressForm() {
    // Arrange and Act
    CustomerAddressForm actualCustomerAddressForm = new CustomerAddressForm();

    // Assert
    assertTrue(actualCustomerAddressForm.getAddress() instanceof AddressImpl);
    assertNull(actualCustomerAddressForm.getCustomerAddressId());
    assertNull(actualCustomerAddressForm.getAddressName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Address CustomerAddressForm.getAddress()", "String CustomerAddressForm.getAddressName()",
      "Long CustomerAddressForm.getCustomerAddressId()", "void CustomerAddressForm.setAddressName(String)",
      "void CustomerAddressForm.setCustomerAddressId(Long)"})
  void testGettersAndSetters() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    // Act
    customerAddressForm.setAddressName("42 Main St");
    customerAddressForm.setCustomerAddressId(1L);
    Address actualAddress = customerAddressForm.getAddress();
    String actualAddressName = customerAddressForm.getAddressName();

    // Assert
    assertTrue(actualAddress instanceof AddressImpl);
    assertEquals("42 Main St", actualAddressName);
    assertEquals(1L, customerAddressForm.getCustomerAddressId().longValue());
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>Given {@code Fax}.</li>
   *   <li>Then {@link AddressImpl} (default constructor) PhonePrimary Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); given 'Fax'; then AddressImpl (default constructor) PhonePrimary Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
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
   *   <li>Then {@link AddressImpl} (default constructor) PhoneFax is {@link PhoneImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); then AddressImpl (default constructor) PhoneFax is PhoneImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  void testSetAddress_thenAddressImplPhoneFaxIsPhoneImpl() {
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
   *   <li>When {@link AddressImpl} (default constructor) PhonePrimary is {@link PhoneImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); when AddressImpl (default constructor) PhonePrimary is PhoneImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  void testSetAddress_whenAddressImplPhonePrimaryIsPhoneImpl() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    PhoneImpl phonePrimary = new PhoneImpl();
    address.setPhonePrimary(phonePrimary);

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    assertTrue(address.getPhoneFax() instanceof PhoneImpl);
    Phone phonePrimary2 = address.getPhonePrimary();
    assertTrue(phonePrimary2 instanceof PhoneImpl);
    assertTrue(address.getPhoneSecondary() instanceof PhoneImpl);
    assertSame(phonePrimary, phonePrimary2);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor) PhoneSecondary is {@link PhoneImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); when AddressImpl (default constructor) PhoneSecondary is PhoneImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
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
   *   <li>When {@link AddressImpl} (default constructor) PrimaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); when AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  void testSetAddress_whenAddressImplPrimaryPhoneIs6625550144() {
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
   *   <li>When {@link AddressImpl} (default constructor) SecondaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); when AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
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
   *   <li>Then {@link AddressImpl} (default constructor) PhonePrimary is {@link AddressImpl} (default constructor) PhoneFax.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @DisplayName("Test setAddress(Address); when AddressImpl (default constructor); then AddressImpl (default constructor) PhonePrimary is AddressImpl (default constructor) PhoneFax")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
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
