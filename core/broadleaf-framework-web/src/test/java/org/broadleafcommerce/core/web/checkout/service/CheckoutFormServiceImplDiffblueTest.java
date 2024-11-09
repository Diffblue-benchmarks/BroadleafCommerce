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
package org.broadleafcommerce.core.web.checkout.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CheckoutFormServiceImplDiffblueTest {
  /**
   * Test
   * {@link CheckoutFormServiceImpl#prePopulateOrderInfoForm(OrderInfoForm, Order)}.
   * <ul>
   *   <li>Then {@link OrderInfoForm} (default constructor) EmailAddress is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#prePopulateOrderInfoForm(OrderInfoForm, Order)}
   */
  @Test
  @DisplayName("Test prePopulateOrderInfoForm(OrderInfoForm, Order); then OrderInfoForm (default constructor) EmailAddress is 'null'")
  void testPrePopulateOrderInfoForm_thenOrderInfoFormEmailAddressIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main St");

    // Act
    OrderInfoForm actualPrePopulateOrderInfoFormResult = checkoutFormServiceImpl.prePopulateOrderInfoForm(orderInfoForm,
        new NullOrderImpl());

    // Assert
    assertNull(orderInfoForm.getEmailAddress());
    assertSame(orderInfoForm, actualPrePopulateOrderInfoFormResult);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#prePopulateOrderInfoForm(OrderInfoForm, Order)}.
   * <ul>
   *   <li>Then return {@link OrderInfoForm}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#prePopulateOrderInfoForm(OrderInfoForm, Order)}
   */
  @Test
  @DisplayName("Test prePopulateOrderInfoForm(OrderInfoForm, Order); then return OrderInfoForm")
  void testPrePopulateOrderInfoForm_thenReturnOrderInfoForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    OrderInfoForm orderInfoForm = mock(OrderInfoForm.class);
    doNothing().when(orderInfoForm).setEmailAddress(Mockito.<String>any());
    orderInfoForm.setEmailAddress("42 Main St");

    // Act
    OrderInfoForm actualPrePopulateOrderInfoFormResult = checkoutFormServiceImpl.prePopulateOrderInfoForm(orderInfoForm,
        new NullOrderImpl());

    // Assert
    verify(orderInfoForm, atLeast(1)).setEmailAddress(Mockito.<String>any());
    assertSame(orderInfoForm, actualPrePopulateOrderInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}.
   * <ul>
   *   <li>Given {@code 42 Main St}.</li>
   *   <li>Then return {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}
   */
  @Test
  @DisplayName("Test getKnownEmailAddress(Order, Customer); given '42 Main St'; then return '42 Main St'")
  void testGetKnownEmailAddress_given42MainSt_thenReturn42MainSt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    NullOrderImpl cart = mock(NullOrderImpl.class);
    when(cart.getEmailAddress()).thenReturn("42 Main St");

    // Act
    String actualKnownEmailAddress = checkoutFormServiceImpl.getKnownEmailAddress(cart, new CustomerImpl());

    // Assert
    verify(cart, atLeast(1)).getEmailAddress();
    assertEquals("42 Main St", actualKnownEmailAddress);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}.
   * <ul>
   *   <li>Given {@code Cart}.</li>
   *   <li>Then return {@code Cart}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}
   */
  @Test
  @DisplayName("Test getKnownEmailAddress(Order, Customer); given 'Cart'; then return 'Cart'")
  void testGetKnownEmailAddress_givenCart_thenReturnCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(new OrderStatus("Type", "Friendly Type"));
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress("Cart");

    // Act and Assert
    assertEquals("Cart", checkoutFormServiceImpl.getKnownEmailAddress(cart, null));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}.
   * <ul>
   *   <li>Given {@code Challenge Answer}.</li>
   *   <li>Then return {@code Customer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}
   */
  @Test
  @DisplayName("Test getKnownEmailAddress(Order, Customer); given 'Challenge Answer'; then return 'Customer'")
  void testGetKnownEmailAddress_givenChallengeAnswer_thenReturnCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(new OrderStatus("Type", "Friendly Type"));
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("Customer");

    // Act and Assert
    assertEquals("Customer", checkoutFormServiceImpl.getKnownEmailAddress(cart, customer));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}
   */
  @Test
  @DisplayName("Test getKnownEmailAddress(Order, Customer); given 'null'; then return 'null'")
  void testGetKnownEmailAddress_givenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(new OrderStatus("Type", "Friendly Type"));
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);

    // Act and Assert
    assertNull(checkoutFormServiceImpl.getKnownEmailAddress(cart, null));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}
   */
  @Test
  @DisplayName("Test getKnownEmailAddress(Order, Customer); when NullOrderImpl (default constructor); then return 'null'")
  void testGetKnownEmailAddress_whenNullOrderImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    NullOrderImpl cart = new NullOrderImpl();

    // Act and Assert
    assertNull(checkoutFormServiceImpl.getKnownEmailAddress(cart, new CustomerImpl()));
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)")
  void testGetShouldUseShippingAddressDefaultValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getIsoCountryAlpha2()).thenReturn(null);
    when(address.getPostalCode()).thenReturn("Postal Code");
    when(address.getStateProvinceRegion()).thenReturn("us-east-2");
    when(address.getCity()).thenReturn("Oxford");
    when(address.getAddressLine2()).thenReturn("42 Main St");
    when(address.getAddressLine1()).thenReturn("42 Main St");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    AddressImpl address2 = new AddressImpl();
    address2.setActive(true);
    address2.setAddressLine1("42 Main St");
    address2.setAddressLine2("42 Main St");
    address2.setAddressLine3("42 Main St");
    address2.setBusiness(true);
    address2.setCity("Oxford");
    address2.setCompanyName("Company Name");
    address2.setCountry(new CountryImpl());
    address2.setCounty("3");
    address2.setDefault(true);
    address2.setEmailAddress("42 Main St");
    address2.setFax("Fax");
    address2.setFirstName("Jane");
    address2.setFullName("Dr Jane Doe");
    address2.setId(1L);
    address2.setIsoCountryAlpha2(new ISOCountryImpl());
    address2.setIsoCountrySubdivision("GB");
    address2.setLastName("Doe");
    address2.setMailing(true);
    address2.setPhoneFax(new PhoneImpl());
    address2.setPhonePrimary(new PhoneImpl());
    address2.setPhoneSecondary(new PhoneImpl());
    address2.setPostalCode("Postal Code");
    address2.setPrimaryPhone("6625550144");
    address2.setSecondaryPhone("6625550144");
    address2.setStandardized(true);
    address2.setState(new StateImpl());
    address2.setStateProvinceRegion("us-east-2");
    address2.setStreet(true);
    address2.setTokenizedAddress("42 Main St");
    address2.setVerificationLevel("Verification Level");
    address2.setZipFour("21654");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address2);

    // Act
    boolean actualShouldUseShippingAddressDefaultValue = checkoutFormServiceImpl
        .getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    verify(address).getIsoCountryAlpha2();
    verify(address).getPostalCode();
    verify(address).getStateProvinceRegion();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)")
  void testGetShouldUseShippingAddressDefaultValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getPostalCode()).thenReturn("foo");
    when(address.getStateProvinceRegion()).thenReturn("us-east-2");
    when(address.getCity()).thenReturn("Oxford");
    when(address.getAddressLine2()).thenReturn("42 Main St");
    when(address.getAddressLine1()).thenReturn("42 Main St");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    AddressImpl address2 = new AddressImpl();
    address2.setActive(true);
    address2.setAddressLine1("42 Main St");
    address2.setAddressLine2("42 Main St");
    address2.setAddressLine3("42 Main St");
    address2.setBusiness(true);
    address2.setCity("Oxford");
    address2.setCompanyName("Company Name");
    address2.setCountry(new CountryImpl());
    address2.setCounty("3");
    address2.setDefault(true);
    address2.setEmailAddress("42 Main St");
    address2.setFax("Fax");
    address2.setFirstName("Jane");
    address2.setFullName("Dr Jane Doe");
    address2.setId(1L);
    address2.setIsoCountryAlpha2(new ISOCountryImpl());
    address2.setIsoCountrySubdivision("GB");
    address2.setLastName("Doe");
    address2.setMailing(true);
    address2.setPhoneFax(new PhoneImpl());
    address2.setPhonePrimary(new PhoneImpl());
    address2.setPhoneSecondary(new PhoneImpl());
    address2.setPostalCode("Postal Code");
    address2.setPrimaryPhone("6625550144");
    address2.setSecondaryPhone("6625550144");
    address2.setStandardized(true);
    address2.setState(new StateImpl());
    address2.setStateProvinceRegion("us-east-2");
    address2.setStreet(true);
    address2.setTokenizedAddress("42 Main St");
    address2.setVerificationLevel("Verification Level");
    address2.setZipFour("21654");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address2);

    // Act
    boolean actualShouldUseShippingAddressDefaultValue = checkoutFormServiceImpl
        .getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    verify(address).getPostalCode();
    verify(address).getStateProvinceRegion();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)")
  void testGetShouldUseShippingAddressDefaultValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getStateProvinceRegion()).thenReturn("foo");
    when(address.getCity()).thenReturn("Oxford");
    when(address.getAddressLine2()).thenReturn("42 Main St");
    when(address.getAddressLine1()).thenReturn("42 Main St");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    AddressImpl address2 = new AddressImpl();
    address2.setActive(true);
    address2.setAddressLine1("42 Main St");
    address2.setAddressLine2("42 Main St");
    address2.setAddressLine3("42 Main St");
    address2.setBusiness(true);
    address2.setCity("Oxford");
    address2.setCompanyName("Company Name");
    address2.setCountry(new CountryImpl());
    address2.setCounty("3");
    address2.setDefault(true);
    address2.setEmailAddress("42 Main St");
    address2.setFax("Fax");
    address2.setFirstName("Jane");
    address2.setFullName("Dr Jane Doe");
    address2.setId(1L);
    address2.setIsoCountryAlpha2(new ISOCountryImpl());
    address2.setIsoCountrySubdivision("GB");
    address2.setLastName("Doe");
    address2.setMailing(true);
    address2.setPhoneFax(new PhoneImpl());
    address2.setPhonePrimary(new PhoneImpl());
    address2.setPhoneSecondary(new PhoneImpl());
    address2.setPostalCode("Postal Code");
    address2.setPrimaryPhone("6625550144");
    address2.setSecondaryPhone("6625550144");
    address2.setStandardized(true);
    address2.setState(new StateImpl());
    address2.setStateProvinceRegion("us-east-2");
    address2.setStreet(true);
    address2.setTokenizedAddress("42 Main St");
    address2.setVerificationLevel("Verification Level");
    address2.setZipFour("21654");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address2);

    // Act
    boolean actualShouldUseShippingAddressDefaultValue = checkoutFormServiceImpl
        .getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    verify(address).getStateProvinceRegion();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)")
  void testGetShouldUseShippingAddressDefaultValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getAddressLine2()).thenReturn("foo");
    when(address.getAddressLine1()).thenReturn("42 Main St");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    AddressImpl address2 = new AddressImpl();
    address2.setActive(true);
    address2.setAddressLine1("42 Main St");
    address2.setAddressLine2("42 Main St");
    address2.setAddressLine3("42 Main St");
    address2.setBusiness(true);
    address2.setCity("Oxford");
    address2.setCompanyName("Company Name");
    address2.setCountry(new CountryImpl());
    address2.setCounty("3");
    address2.setDefault(true);
    address2.setEmailAddress("42 Main St");
    address2.setFax("Fax");
    address2.setFirstName("Jane");
    address2.setFullName("Dr Jane Doe");
    address2.setId(1L);
    address2.setIsoCountryAlpha2(new ISOCountryImpl());
    address2.setIsoCountrySubdivision("GB");
    address2.setLastName("Doe");
    address2.setMailing(true);
    address2.setPhoneFax(new PhoneImpl());
    address2.setPhonePrimary(new PhoneImpl());
    address2.setPhoneSecondary(new PhoneImpl());
    address2.setPostalCode("Postal Code");
    address2.setPrimaryPhone("6625550144");
    address2.setSecondaryPhone("6625550144");
    address2.setStandardized(true);
    address2.setState(new StateImpl());
    address2.setStateProvinceRegion("us-east-2");
    address2.setStreet(true);
    address2.setTokenizedAddress("42 Main St");
    address2.setVerificationLevel("Verification Level");
    address2.setZipFour("21654");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address2);

    // Act
    boolean actualShouldUseShippingAddressDefaultValue = checkoutFormServiceImpl
        .getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm); given AddressImpl (default constructor)")
  void testGetShouldUseShippingAddressDefaultValue_givenAddressImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(new AddressImpl());

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
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

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address);

    // Act and Assert
    assertFalse(
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm));
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getCity()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm); given AddressImpl getCity() return 'foo'")
  void testGetShouldUseShippingAddressDefaultValue_givenAddressImplGetCityReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getCity()).thenReturn("foo");
    when(address.getAddressLine2()).thenReturn("42 Main St");
    when(address.getAddressLine1()).thenReturn("42 Main St");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    AddressImpl address2 = new AddressImpl();
    address2.setActive(true);
    address2.setAddressLine1("42 Main St");
    address2.setAddressLine2("42 Main St");
    address2.setAddressLine3("42 Main St");
    address2.setBusiness(true);
    address2.setCity("Oxford");
    address2.setCompanyName("Company Name");
    address2.setCountry(new CountryImpl());
    address2.setCounty("3");
    address2.setDefault(true);
    address2.setEmailAddress("42 Main St");
    address2.setFax("Fax");
    address2.setFirstName("Jane");
    address2.setFullName("Dr Jane Doe");
    address2.setId(1L);
    address2.setIsoCountryAlpha2(new ISOCountryImpl());
    address2.setIsoCountrySubdivision("GB");
    address2.setLastName("Doe");
    address2.setMailing(true);
    address2.setPhoneFax(new PhoneImpl());
    address2.setPhonePrimary(new PhoneImpl());
    address2.setPhoneSecondary(new PhoneImpl());
    address2.setPostalCode("Postal Code");
    address2.setPrimaryPhone("6625550144");
    address2.setSecondaryPhone("6625550144");
    address2.setStandardized(true);
    address2.setState(new StateImpl());
    address2.setStateProvinceRegion("us-east-2");
    address2.setStreet(true);
    address2.setTokenizedAddress("42 Main St");
    address2.setVerificationLevel("Verification Level");
    address2.setZipFour("21654");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address2);

    // Act
    boolean actualShouldUseShippingAddressDefaultValue = checkoutFormServiceImpl
        .getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm); given AddressImpl (default constructor); then return 'true'")
  void testGetShouldUseShippingAddressDefaultValue_givenAddressImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(new AddressImpl());

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(new AddressImpl());

    // Act and Assert
    assertTrue(
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm));
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm); given 'null'")
  void testGetShouldUseShippingAddressDefaultValue_givenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(new AddressImpl());

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(null);

    // Act and Assert
    assertFalse(
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm));
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#getIsoCountrySubdivision()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm); then calls getIsoCountrySubdivision()")
  void testGetShouldUseShippingAddressDefaultValue_thenCallsGetIsoCountrySubdivision() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getIsoCountrySubdivision()).thenReturn("foo");
    when(address.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    when(address.getPostalCode()).thenReturn("Postal Code");
    when(address.getStateProvinceRegion()).thenReturn("us-east-2");
    when(address.getCity()).thenReturn("Oxford");
    when(address.getAddressLine2()).thenReturn("42 Main St");
    when(address.getAddressLine1()).thenReturn("42 Main St");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    AddressImpl address2 = new AddressImpl();
    address2.setActive(true);
    address2.setAddressLine1("42 Main St");
    address2.setAddressLine2("42 Main St");
    address2.setAddressLine3("42 Main St");
    address2.setBusiness(true);
    address2.setCity("Oxford");
    address2.setCompanyName("Company Name");
    address2.setCountry(new CountryImpl());
    address2.setCounty("3");
    address2.setDefault(true);
    address2.setEmailAddress("42 Main St");
    address2.setFax("Fax");
    address2.setFirstName("Jane");
    address2.setFullName("Dr Jane Doe");
    address2.setId(1L);
    address2.setIsoCountryAlpha2(new ISOCountryImpl());
    address2.setIsoCountrySubdivision("GB");
    address2.setLastName("Doe");
    address2.setMailing(true);
    address2.setPhoneFax(new PhoneImpl());
    address2.setPhonePrimary(new PhoneImpl());
    address2.setPhoneSecondary(new PhoneImpl());
    address2.setPostalCode("Postal Code");
    address2.setPrimaryPhone("6625550144");
    address2.setSecondaryPhone("6625550144");
    address2.setStandardized(true);
    address2.setState(new StateImpl());
    address2.setStateProvinceRegion("us-east-2");
    address2.setStreet(true);
    address2.setTokenizedAddress("42 Main St");
    address2.setVerificationLevel("Verification Level");
    address2.setZipFour("21654");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address2);

    // Act
    boolean actualShouldUseShippingAddressDefaultValue = checkoutFormServiceImpl
        .getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    verify(address).getIsoCountryAlpha2();
    verify(address).getIsoCountrySubdivision();
    verify(address).getPostalCode();
    verify(address).getStateProvinceRegion();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <ul>
   *   <li>When {@link CustomerPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm); when CustomerPaymentImpl (default constructor)")
  void testGetShouldUseShippingAddressDefaultValue_whenCustomerPaymentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();

    // Act and Assert
    assertFalse(checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(customerPaymentUsedForOrder,
        paymentInfoForm, new ShippingInfoForm()));
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <ul>
   *   <li>When {@link CustomerPaymentImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm); when CustomerPaymentImpl")
  void testGetShouldUseShippingAddressDefaultValue_whenCustomerPaymentImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = mock(CustomerPaymentImpl.class);
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();

    // Act and Assert
    assertFalse(checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(customerPaymentUsedForOrder,
        paymentInfoForm, new ShippingInfoForm()));
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}.
   * <ul>
   *   <li>When {@link PaymentInfoForm} (default constructor) Address is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm); when PaymentInfoForm (default constructor) Address is 'null'")
  void testGetShouldUseShippingAddressDefaultValue_whenPaymentInfoFormAddressIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(null);

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(null);

    // Act and Assert
    assertFalse(
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(null, paymentInfoForm, shippingInfoForm));
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>Given {@code GB}.</li>
   *   <li>Then calls {@link AddressImpl#getIsoCountrySubdivision()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); given 'GB'; then calls getIsoCountrySubdivision()")
  void testAddressesContentsAreEqual_givenGb_thenCallsGetIsoCountrySubdivision() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn(null);
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn(null);
    when(address1.getIsoCountrySubdivision()).thenReturn("GB");
    when(address1.getPostalCode()).thenReturn(null);
    when(address1.getStateProvinceRegion()).thenReturn(null);
    when(address1.getIsoCountryAlpha2()).thenReturn(null);

    // Act
    boolean actualAddressesContentsAreEqualResult = checkoutFormServiceImpl.addressesContentsAreEqual(address1,
        new AddressImpl());

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    verify(address1).getCity();
    verify(address1).getIsoCountryAlpha2();
    verify(address1).getIsoCountrySubdivision();
    verify(address1).getPostalCode();
    verify(address1).getStateProvinceRegion();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); given ISOCountryImpl (default constructor)")
  void testAddressesContentsAreEqual_givenISOCountryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn(null);
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn(null);
    when(address1.getPostalCode()).thenReturn(null);
    when(address1.getStateProvinceRegion()).thenReturn(null);
    when(address1.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());

    // Act
    boolean actualAddressesContentsAreEqualResult = checkoutFormServiceImpl.addressesContentsAreEqual(address1,
        new AddressImpl());

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    verify(address1).getCity();
    verify(address1).getIsoCountryAlpha2();
    verify(address1).getPostalCode();
    verify(address1).getStateProvinceRegion();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>Given {@code Oxford}.</li>
   *   <li>When {@link AddressImpl} {@link AddressImpl#getCity()} return
   * {@code Oxford}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); given 'Oxford'; when AddressImpl getCity() return 'Oxford'")
  void testAddressesContentsAreEqual_givenOxford_whenAddressImplGetCityReturnOxford() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn(null);
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn("Oxford");

    // Act
    boolean actualAddressesContentsAreEqualResult = checkoutFormServiceImpl.addressesContentsAreEqual(address1,
        new AddressImpl());

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    verify(address1).getCity();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>Given {@code Postal Code}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); given 'Postal Code'")
  void testAddressesContentsAreEqual_givenPostalCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn(null);
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn(null);
    when(address1.getPostalCode()).thenReturn("Postal Code");
    when(address1.getStateProvinceRegion()).thenReturn(null);

    // Act
    boolean actualAddressesContentsAreEqualResult = checkoutFormServiceImpl.addressesContentsAreEqual(address1,
        new AddressImpl());

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    verify(address1).getCity();
    verify(address1).getPostalCode();
    verify(address1).getStateProvinceRegion();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>Given {@code us-east-2}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); given 'us-east-2'")
  void testAddressesContentsAreEqual_givenUsEast2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn(null);
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn(null);
    when(address1.getStateProvinceRegion()).thenReturn("us-east-2");

    // Act
    boolean actualAddressesContentsAreEqualResult = checkoutFormServiceImpl.addressesContentsAreEqual(address1,
        new AddressImpl());

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    verify(address1).getCity();
    verify(address1).getStateProvinceRegion();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} {@link AddressImpl#getAddressLine1()} return
   * {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); when AddressImpl getAddressLine1() return '42 Main St'")
  void testAddressesContentsAreEqual_whenAddressImplGetAddressLine1Return42MainSt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn("42 Main St");

    // Act
    boolean actualAddressesContentsAreEqualResult = checkoutFormServiceImpl.addressesContentsAreEqual(address1,
        new AddressImpl());

    // Assert
    verify(address1).getAddressLine1();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} {@link AddressImpl#getAddressLine2()} return
   * {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); when AddressImpl getAddressLine2() return '42 Main St'")
  void testAddressesContentsAreEqual_whenAddressImplGetAddressLine2Return42MainSt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn(null);
    when(address1.getAddressLine2()).thenReturn("42 Main St");

    // Act
    boolean actualAddressesContentsAreEqualResult = checkoutFormServiceImpl.addressesContentsAreEqual(address1,
        new AddressImpl());

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); when AddressImpl (default constructor); then return 'true'")
  void testAddressesContentsAreEqual_whenAddressImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address1 = new AddressImpl();

    // Act and Assert
    assertTrue(checkoutFormServiceImpl.addressesContentsAreEqual(address1, new AddressImpl()));
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); when 'null'; then return 'false'")
  void testAddressesContentsAreEqual_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CheckoutFormServiceImpl()).addressesContentsAreEqual(null, null));
  }

  /**
   * Test
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}
   */
  @Test
  @DisplayName("Test addressesContentsAreEqual(Address, Address); when 'null'; then return 'false'")
  void testAddressesContentsAreEqual_whenNull_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    // Act and Assert
    assertFalse(checkoutFormServiceImpl.addressesContentsAreEqual(new AddressImpl(), null));
  }
}
