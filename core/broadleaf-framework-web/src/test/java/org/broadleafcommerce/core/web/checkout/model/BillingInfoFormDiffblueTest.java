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
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BillingInfoFormDiffblueTest {
  /**
   * Test new {@link BillingInfoForm} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BillingInfoForm}
   */
  @Test
  @DisplayName("Test new BillingInfoForm (default constructor)")
  void testNewBillingInfoForm() {
    // Arrange and Act
    BillingInfoForm actualBillingInfoForm = new BillingInfoForm();

    // Assert
    Address address = actualBillingInfoForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertNull(actualBillingInfoForm.getCustomerPaymentId());
    assertNull(address.getId());
    assertNull(phoneFax.getId());
    assertNull(actualBillingInfoForm.getPaymentName());
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
    assertNull(actualBillingInfoForm.getCustomerPayment());
    assertNull(address.getState());
    assertFalse(actualBillingInfoForm.getUseCustomerPayment());
    assertFalse(actualBillingInfoForm.isUseShippingAddress());
    assertFalse(address.getStandardized());
    assertFalse(address.isBusiness());
    assertFalse(address.isDefault());
    assertFalse(address.isMailing());
    assertFalse(address.isStreet());
    assertFalse(phoneFax.isDefault());
    assertFalse(actualBillingInfoForm.useCustomerPayment);
    assertTrue(actualBillingInfoForm.getSaveNewPayment());
    assertTrue(address.isActive());
    assertTrue(phoneFax.isActive());
    assertTrue(actualBillingInfoForm.saveNewPayment);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BillingInfoForm#setAddress(Address)}
   *   <li>{@link BillingInfoForm#setCustomerPayment(CustomerPayment)}
   *   <li>{@link BillingInfoForm#setCustomerPaymentId(Long)}
   *   <li>{@link BillingInfoForm#setPaymentName(String)}
   *   <li>{@link BillingInfoForm#setUseShippingAddress(boolean)}
   *   <li>{@link BillingInfoForm#getAddress()}
   *   <li>{@link BillingInfoForm#getCustomerPayment()}
   *   <li>{@link BillingInfoForm#getCustomerPaymentId()}
   *   <li>{@link BillingInfoForm#getPaymentName()}
   *   <li>{@link BillingInfoForm#isUseShippingAddress()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    AddressImpl address = new AddressImpl();

    // Act
    billingInfoForm.setAddress(address);
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    billingInfoForm.setCustomerPayment(customerPayment);
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setUseShippingAddress(true);
    Address actualAddress = billingInfoForm.getAddress();
    CustomerPayment actualCustomerPayment = billingInfoForm.getCustomerPayment();
    Long actualCustomerPaymentId = billingInfoForm.getCustomerPaymentId();
    String actualPaymentName = billingInfoForm.getPaymentName();
    boolean actualIsUseShippingAddressResult = billingInfoForm.isUseShippingAddress();

    // Assert that nothing has changed
    assertEquals("Payment Name", actualPaymentName);
    assertEquals(1L, actualCustomerPaymentId.longValue());
    assertTrue(actualIsUseShippingAddressResult);
    assertSame(address, actualAddress);
    assertSame(customerPayment, actualCustomerPayment);
  }

  /**
   * Test {@link BillingInfoForm#getUseCustomerPayment()}.
   * <ul>
   *   <li>Given {@link BillingInfoForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BillingInfoForm#getUseCustomerPayment()}
   */
  @Test
  @DisplayName("Test getUseCustomerPayment(); given BillingInfoForm (default constructor); then return 'false'")
  void testGetUseCustomerPayment_givenBillingInfoForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BillingInfoForm()).getUseCustomerPayment());
  }

  /**
   * Test {@link BillingInfoForm#getUseCustomerPayment()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BillingInfoForm#getUseCustomerPayment()}
   */
  @Test
  @DisplayName("Test getUseCustomerPayment(); then return 'true'")
  void testGetUseCustomerPayment_thenReturnTrue() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseShippingAddress(true);
    billingInfoForm.setUseCustomerPayment(true);

    // Act and Assert
    assertTrue(billingInfoForm.getUseCustomerPayment());
  }

  /**
   * Test {@link BillingInfoForm#setUseCustomerPayment(Boolean)}.
   * <ul>
   *   <li>Then {@link BillingInfoForm} (default constructor)
   * UseCustomerPayment.</li>
   * </ul>
   * <p>
   * Method under test: {@link BillingInfoForm#setUseCustomerPayment(Boolean)}
   */
  @Test
  @DisplayName("Test setUseCustomerPayment(Boolean); then BillingInfoForm (default constructor) UseCustomerPayment")
  void testSetUseCustomerPayment_thenBillingInfoFormUseCustomerPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();

    // Act
    billingInfoForm.setUseCustomerPayment(true);

    // Assert
    assertTrue(billingInfoForm.getUseCustomerPayment());
    assertTrue(billingInfoForm.useCustomerPayment);
  }

  /**
   * Test {@link BillingInfoForm#setUseCustomerPayment(Boolean)}.
   * <ul>
   *   <li>Then not {@link BillingInfoForm} (default constructor)
   * UseCustomerPayment.</li>
   * </ul>
   * <p>
   * Method under test: {@link BillingInfoForm#setUseCustomerPayment(Boolean)}
   */
  @Test
  @DisplayName("Test setUseCustomerPayment(Boolean); then not BillingInfoForm (default constructor) UseCustomerPayment")
  void testSetUseCustomerPayment_thenNotBillingInfoFormUseCustomerPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    // Act
    billingInfoForm.setUseCustomerPayment(null);

    // Assert
    assertFalse(billingInfoForm.getUseCustomerPayment());
    assertFalse(billingInfoForm.useCustomerPayment);
  }

  /**
   * Test {@link BillingInfoForm#getSaveNewPayment()}.
   * <ul>
   *   <li>Given {@link BillingInfoForm} (default constructor) Address is
   * {@link AddressImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BillingInfoForm#getSaveNewPayment()}
   */
  @Test
  @DisplayName("Test getSaveNewPayment(); given BillingInfoForm (default constructor) Address is AddressImpl (default constructor); then return 'false'")
  void testGetSaveNewPayment_givenBillingInfoFormAddressIsAddressImpl_thenReturnFalse() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);
    billingInfoForm.setSaveNewPayment(null);

    // Act and Assert
    assertFalse(billingInfoForm.getSaveNewPayment());
  }

  /**
   * Test {@link BillingInfoForm#getSaveNewPayment()}.
   * <ul>
   *   <li>Given {@link BillingInfoForm} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BillingInfoForm#getSaveNewPayment()}
   */
  @Test
  @DisplayName("Test getSaveNewPayment(); given BillingInfoForm (default constructor); then return 'true'")
  void testGetSaveNewPayment_givenBillingInfoForm_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BillingInfoForm()).getSaveNewPayment());
  }

  /**
   * Test {@link BillingInfoForm#setSaveNewPayment(Boolean)}.
   * <ul>
   *   <li>Given {@link BillingInfoForm} (default constructor).</li>
   *   <li>Then {@link BillingInfoForm} (default constructor) SaveNewPayment.</li>
   * </ul>
   * <p>
   * Method under test: {@link BillingInfoForm#setSaveNewPayment(Boolean)}
   */
  @Test
  @DisplayName("Test setSaveNewPayment(Boolean); given BillingInfoForm (default constructor); then BillingInfoForm (default constructor) SaveNewPayment")
  void testSetSaveNewPayment_givenBillingInfoForm_thenBillingInfoFormSaveNewPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();

    // Act
    billingInfoForm.setSaveNewPayment(true);

    // Assert
    assertTrue(billingInfoForm.getSaveNewPayment());
    assertTrue(billingInfoForm.saveNewPayment);
  }

  /**
   * Test {@link BillingInfoForm#setSaveNewPayment(Boolean)}.
   * <ul>
   *   <li>Then not {@link BillingInfoForm} (default constructor)
   * SaveNewPayment.</li>
   * </ul>
   * <p>
   * Method under test: {@link BillingInfoForm#setSaveNewPayment(Boolean)}
   */
  @Test
  @DisplayName("Test setSaveNewPayment(Boolean); then not BillingInfoForm (default constructor) SaveNewPayment")
  void testSetSaveNewPayment_thenNotBillingInfoFormSaveNewPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    // Act
    billingInfoForm.setSaveNewPayment(null);

    // Assert
    assertFalse(billingInfoForm.getSaveNewPayment());
    assertFalse(billingInfoForm.saveNewPayment);
  }
}
