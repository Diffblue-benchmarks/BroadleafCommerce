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
package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BroadleafShippingInfoControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafShippingInfoController#copyBillingAddressToShippingAddress(Order, ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link NullOrderImpl#getPayments()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#copyBillingAddressToShippingAddress(Order, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test copyBillingAddressToShippingAddress(Order, ShippingInfoForm); given ArrayList(); then calls getPayments()")
  void testCopyBillingAddressToShippingAddress_givenArrayList_thenCallsGetPayments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController = new BroadleafShippingInfoController();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getPayments()).thenReturn(new ArrayList<>());

    // Act
    broadleafShippingInfoController.copyBillingAddressToShippingAddress(order, new ShippingInfoForm());

    // Assert
    verify(order, atLeast(1)).getPayments();
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#copyBillingAddressToShippingAddress(Order, ShippingInfoForm)}.
   * <ul>
   *   <li>Then calls {@link OrderPaymentImpl#isActive()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#copyBillingAddressToShippingAddress(Order, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test copyBillingAddressToShippingAddress(Order, ShippingInfoForm); then calls isActive()")
  void testCopyBillingAddressToShippingAddress_thenCallsIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController = new BroadleafShippingInfoController();
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getPayments()).thenReturn(orderPaymentList);

    // Act
    broadleafShippingInfoController.copyBillingAddressToShippingAddress(order, new ShippingInfoForm());

    // Assert
    verify(order, atLeast(1)).getPayments();
    verify(orderPaymentImpl).isActive();
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor)")
  void testRemoveUnusedPhones_givenAddressImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController = new BroadleafShippingInfoController();
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Fax is {@code Fax}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor) Fax is 'Fax'")
  void testRemoveUnusedPhones_givenAddressImplFaxIsFax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController = new BroadleafShippingInfoController();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setFax("Fax");
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PrimaryPhone is
   * {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  void testRemoveUnusedPhones_givenAddressImplPrimaryPhoneIs6625550144() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController = new BroadleafShippingInfoController();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("6625550144");
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) SecondaryPhone is
   * {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  void testRemoveUnusedPhones_givenAddressImplSecondaryPhoneIs6625550144() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController = new BroadleafShippingInfoController();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setSecondaryPhone("6625550144");
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link PhoneImpl} (default constructor) PhoneNumber is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given PhoneImpl (default constructor) PhoneNumber is empty string")
  void testRemoveUnusedPhones_givenPhoneImplPhoneNumberIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController = new BroadleafShippingInfoController();

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setPhoneNumber("");
    AddressImpl addressImpl = mock(AddressImpl.class);
    doNothing().when(addressImpl).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());
    when(addressImpl.getPhoneFax()).thenReturn(phoneImpl);
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhoneFax(isNull());
    verify(addressImpl).setPhonePrimary(isNull());
    verify(addressImpl).setPhoneSecondary(isNull());
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#getPhoneFax()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); then calls getPhoneFax()")
  void testRemoveUnusedPhones_thenCallsGetPhoneFax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController = new BroadleafShippingInfoController();
    AddressImpl addressImpl = mock(AddressImpl.class);
    doNothing().when(addressImpl).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhoneFax(isNull());
    verify(addressImpl).setPhonePrimary(isNull());
    verify(addressImpl).setPhoneSecondary(isNull());
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Then {@link ShippingInfoForm} (default constructor) Address
   * {@link AddressImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); then ShippingInfoForm (default constructor) Address AddressImpl")
  void testRemoveUnusedPhones_thenShippingInfoFormAddressAddressImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController = new BroadleafShippingInfoController();
    ShippingInfoForm form = new ShippingInfoForm();

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    Address address = form.getAddress();
    assertTrue(address instanceof AddressImpl);
    assertNull(address.getPhoneFax());
    assertNull(address.getPhonePrimary());
    assertNull(address.getPhoneSecondary());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafShippingInfoController}
   *   <li>
   * {@link BroadleafShippingInfoController#getMultishipAddAddressSuccessView()}
   *   <li>{@link BroadleafShippingInfoController#getMultishipAddAddressView()}
   *   <li>{@link BroadleafShippingInfoController#getMultishipSuccessView()}
   *   <li>{@link BroadleafShippingInfoController#getMultishipView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafShippingInfoController actualBroadleafShippingInfoController = new BroadleafShippingInfoController();
    String actualMultishipAddAddressSuccessView = actualBroadleafShippingInfoController
        .getMultishipAddAddressSuccessView();
    String actualMultishipAddAddressView = actualBroadleafShippingInfoController.getMultishipAddAddressView();
    String actualMultishipSuccessView = actualBroadleafShippingInfoController.getMultishipSuccessView();

    // Assert
    assertEquals("checkout/multiship", actualBroadleafShippingInfoController.getMultishipView());
    assertEquals("checkout/multishipAddAddressForm", actualMultishipAddAddressView);
    assertEquals("redirect:/checkout", actualMultishipSuccessView);
    assertEquals("redirect:/checkout/multiship", actualMultishipAddAddressSuccessView);
  }
}
