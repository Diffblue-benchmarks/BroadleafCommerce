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
import org.junit.jupiter.api.Test;

class BillingInfoFormDiffblueTest {
  /**
   * Method under test: {@link BillingInfoForm#getUseCustomerPayment()}
   */
  @Test
  void testGetUseCustomerPayment() {
    // Arrange, Act and Assert
    assertFalse((new BillingInfoForm()).getUseCustomerPayment());
  }

  /**
   * Method under test: {@link BillingInfoForm#getUseCustomerPayment()}
   */
  @Test
  void testGetUseCustomerPayment2() {
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
   * Method under test: {@link BillingInfoForm#setUseCustomerPayment(Boolean)}
   */
  @Test
  void testSetUseCustomerPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();

    // Act
    billingInfoForm.setUseCustomerPayment(true);

    // Assert
    assertTrue(billingInfoForm.getUseCustomerPayment());
    assertTrue(billingInfoForm.useCustomerPayment);
  }

  /**
   * Method under test: {@link BillingInfoForm#setUseCustomerPayment(Boolean)}
   */
  @Test
  void testSetUseCustomerPayment2() {
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
   * Method under test: {@link BillingInfoForm#getSaveNewPayment()}
   */
  @Test
  void testGetSaveNewPayment() {
    // Arrange, Act and Assert
    assertTrue((new BillingInfoForm()).getSaveNewPayment());
  }

  /**
   * Method under test: {@link BillingInfoForm#getSaveNewPayment()}
   */
  @Test
  void testGetSaveNewPayment2() {
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
   * Method under test: {@link BillingInfoForm#setSaveNewPayment(Boolean)}
   */
  @Test
  void testSetSaveNewPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();

    // Act
    billingInfoForm.setSaveNewPayment(true);

    // Assert
    assertTrue(billingInfoForm.getSaveNewPayment());
    assertTrue(billingInfoForm.saveNewPayment);
  }

  /**
   * Method under test: {@link BillingInfoForm#setSaveNewPayment(Boolean)}
   */
  @Test
  void testSetSaveNewPayment2() {
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

  /**
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
   * Method under test: default or parameterless constructor of
   * {@link BillingInfoForm}
   */
  @Test
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
}
