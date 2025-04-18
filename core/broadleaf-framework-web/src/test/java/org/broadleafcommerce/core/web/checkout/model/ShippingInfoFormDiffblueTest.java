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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ShippingInfoFormDiffblueTest {
  /**
   * Test new {@link ShippingInfoForm} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ShippingInfoForm}
   */
  @Test
  @DisplayName("Test new ShippingInfoForm (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ShippingInfoForm.<init>()"})
  void testNewShippingInfoForm() {
    // Arrange and Act
    ShippingInfoForm actualShippingInfoForm = new ShippingInfoForm();

    // Assert
    assertTrue(actualShippingInfoForm.getPersonalMessage() instanceof PersonalMessageImpl);
    assertTrue(actualShippingInfoForm.getAddress() instanceof AddressImpl);
    assertNull(actualShippingInfoForm.getFulfillmentOptionId());
    assertNull(actualShippingInfoForm.getAddressName());
    assertNull(actualShippingInfoForm.getDeliveryMessage());
    assertNull(actualShippingInfoForm.getFulfillmentOption());
    assertFalse(actualShippingInfoForm.hasValidAddress());
    assertFalse(actualShippingInfoForm.isSaveAsDefault());
    assertFalse(actualShippingInfoForm.isUseBillingAddress());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Address ShippingInfoForm.getAddress()", "String ShippingInfoForm.getAddressName()",
      "String ShippingInfoForm.getDeliveryMessage()", "FulfillmentOption ShippingInfoForm.getFulfillmentOption()",
      "Long ShippingInfoForm.getFulfillmentOptionId()", "PersonalMessage ShippingInfoForm.getPersonalMessage()",
      "boolean ShippingInfoForm.isSaveAsDefault()", "boolean ShippingInfoForm.isUseBillingAddress()",
      "void ShippingInfoForm.setAddress(Address)", "void ShippingInfoForm.setAddressName(String)",
      "void ShippingInfoForm.setDeliveryMessage(String)",
      "void ShippingInfoForm.setFulfillmentOption(FulfillmentOption)",
      "void ShippingInfoForm.setFulfillmentOptionId(Long)", "void ShippingInfoForm.setPersonalMessage(PersonalMessage)",
      "void ShippingInfoForm.setSaveAsDefault(boolean)", "void ShippingInfoForm.setUseBillingAddress(boolean)"})
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

    // Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShippingInfoForm.shouldUseBillingAddress()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShippingInfoForm.shouldUseBillingAddress()"})
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
   *   <li>Given {@link AddressImpl} (default constructor) City is {@code not blank}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given AddressImpl (default constructor) City is 'not blank'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShippingInfoForm.hasValidAddress()"})
  void testHasValidAddress_givenAddressImplCityIsNotBlank_thenReturnTrue() {
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
    address.setAddressLine1("not blank");
    address.setCity("not blank");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address);

    // Act and Assert
    assertTrue(shippingInfoForm.hasValidAddress());
  }

  /**
   * Test {@link ShippingInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) City is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given AddressImpl (default constructor) City is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShippingInfoForm.hasValidAddress()"})
  void testHasValidAddress_givenAddressImplCityIsNull_thenReturnFalse() {
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
    address.setAddressLine1("not blank");
    address.setCity(null);

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address);

    // Act and Assert
    assertFalse(shippingInfoForm.hasValidAddress());
  }

  /**
   * Test {@link ShippingInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) City is space.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given AddressImpl (default constructor) City is space; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShippingInfoForm.hasValidAddress()"})
  void testHasValidAddress_givenAddressImplCityIsSpace_thenReturnFalse() {
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
    address.setAddressLine1("not blank");
    address.setCity(" ");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address);

    // Act and Assert
    assertFalse(shippingInfoForm.hasValidAddress());
  }

  /**
   * Test {@link ShippingInfoForm#hasValidAddress()}.
   * <ul>
   *   <li>Given {@link ShippingInfoForm} (default constructor) Address is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingInfoForm#hasValidAddress()}
   */
  @Test
  @DisplayName("Test hasValidAddress(); given ShippingInfoForm (default constructor) Address is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShippingInfoForm.hasValidAddress()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShippingInfoForm.hasValidAddress()"})
  void testHasValidAddress_givenShippingInfoForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ShippingInfoForm()).hasValidAddress());
  }
}
