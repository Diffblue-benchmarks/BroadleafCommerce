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
package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.broadleafcommerce.core.web.checkout.validator.CheckoutPaymentInfoFormValidator;
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.broadleafcommerce.core.web.payment.service.SavedPaymentService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CustomerPaymentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@ExtendWith(MockitoExtension.class)
class BroadleafPaymentInfoControllerDiffblueTest {
  @InjectMocks
  private BroadleafPaymentInfoController broadleafPaymentInfoController;

  @Mock
  private OrderPaymentService orderPaymentService;

  @Mock
  private CustomerPaymentService customerPaymentService;

  @Mock
  private AddressService addressService;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @Mock
  private CartStateService cartStateService;

  @Mock
  private CheckoutPaymentInfoFormValidator checkoutPaymentInfoFormValidator;

  @Mock
  private SavedPaymentService savedPaymentService;

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentGroup#getAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); then calls getAddress()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"})
  void testSavePaymentInfo_thenCallsGetAddress() throws ServiceException, PricingException {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    CustomerPayment customerPayment = mock(CustomerPayment.class);
    when(customerPayment.getBillingAddress()).thenReturn(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(customerPayment);
    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any())).thenReturn(fulfillmentGroup);
    doNothing().when(checkoutPaymentInfoFormValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans"));

    // Act
    String actualSavePaymentInfoResult = broadleafPaymentInfoController.savePaymentInfo(request, response, model,
        paymentForm, result);

    // Assert
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm, atLeast(1)).setAddress(isA(Address.class));
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerPayment).getBillingAddress();
    verify(addressService, atLeast(1)).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(eq(1L));
    assertEquals("redirect:/checkout", actualSavePaymentInfoResult);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   * <ul>
   *   <li>Then {@link PaymentInfoForm} (default constructor) CustomerPaymentId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); then PaymentInfoForm (default constructor) CustomerPaymentId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"})
  void testSavePaymentInfo_thenPaymentInfoFormCustomerPaymentIdLongValueIsOne()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(cartStateService.cartHasCreditCardPaymentWithSameToken(Mockito.<String>any())).thenReturn(true);
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(new CustomerPaymentImpl());
    doNothing().when(checkoutPaymentInfoFormValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    when(savedPaymentService.addSavedPayment(Mockito.<Customer>any(), Mockito.<PaymentInfoForm>any())).thenReturn(1L);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    String actualSavePaymentInfoResult = broadleafPaymentInfoController.savePaymentInfo(request, response, model,
        paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(cartStateService).cartHasCreditCardPaymentWithSameToken(isNull());
    verify(savedPaymentService).addSavedPayment(isNull(), isA(PaymentInfoForm.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(eq(1L));
    assertEquals("redirect:/checkout", actualSavePaymentInfoResult);
    assertEquals(1L, paymentForm.getCustomerPaymentId().longValue());
    assertTrue(paymentForm.getShouldUseCustomerPayment());
    assertTrue(paymentForm.hasCustomerPaymentId());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"})
  void testPreProcessBillingAddress() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(new CustomerPaymentImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(eq(1L));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"})
  void testPreProcessBillingAddress2() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(null);
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(eq(1L));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"})
  void testPreProcessBillingAddress3() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    CustomerPayment customerPayment = mock(CustomerPayment.class);
    when(customerPayment.getBillingAddress()).thenReturn(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(customerPayment);
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any())).thenReturn(null);
    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(customerPayment).getBillingAddress();
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(eq(1L));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"})
  void testPreProcessBillingAddress_givenNull() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any())).thenReturn(fulfillmentGroup);
    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getCustomerPaymentId()).thenReturn(null);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentForm).getAddress();
    verify(paymentForm).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentGroup#getAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order); then calls getAddress()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"})
  void testPreProcessBillingAddress_thenCallsGetAddress() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    CustomerPayment customerPayment = mock(CustomerPayment.class);
    when(customerPayment.getBillingAddress()).thenReturn(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(customerPayment);
    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any())).thenReturn(fulfillmentGroup);
    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm, atLeast(1)).setAddress(isA(Address.class));
    verify(customerPayment).getBillingAddress();
    verify(addressService, atLeast(1)).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(eq(1L));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   * <ul>
   *   <li>Then calls {@link CustomerPayment#getBillingAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order); then calls getBillingAddress()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"})
  void testPreProcessBillingAddress_thenCallsGetBillingAddress() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    CustomerPayment customerPayment = mock(CustomerPayment.class);
    when(customerPayment.getBillingAddress()).thenReturn(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(customerPayment);
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(customerPayment).getBillingAddress();
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(eq(1L));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   * <ul>
   *   <li>When {@link PaymentInfoForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order); when PaymentInfoForm (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"})
  void testPreProcessBillingAddress_whenPaymentInfoForm() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}.
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyShippingAddressToBillingAddress(Order, PaymentInfoForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.copyShippingAddressToBillingAddress(Order, PaymentInfoForm)"})
  void testCopyShippingAddressToBillingAddress() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    broadleafPaymentInfoController.copyShippingAddressToBillingAddress(order, new PaymentInfoForm());

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}.
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyShippingAddressToBillingAddress(Order, PaymentInfoForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.copyShippingAddressToBillingAddress(Order, PaymentInfoForm)"})
  void testCopyShippingAddressToBillingAddress2() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any())).thenReturn(null);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    broadleafPaymentInfoController.copyShippingAddressToBillingAddress(order, new PaymentInfoForm());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#getAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyShippingAddressToBillingAddress(Order, PaymentInfoForm); then calls getAddress()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.copyShippingAddressToBillingAddress(Order, PaymentInfoForm)"})
  void testCopyShippingAddressToBillingAddress_thenCallsGetAddress() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getAddress()).thenReturn(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    broadleafPaymentInfoController.copyShippingAddressToBillingAddress(order, new PaymentInfoForm());

    // Assert
    verify(fulfillmentGroupImpl).getAddress();
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(addressService).copyAddress(isA(Address.class));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}.
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)"})
  void testCopyCustomerPaymentAddressToBillingAddress() {
    // Arrange
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(new CustomerPaymentImpl());
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(paymentForm);

    // Assert that nothing has changed
    verify(customerPaymentService).readCustomerPaymentById(isNull());
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}.
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)"})
  void testCopyCustomerPaymentAddressToBillingAddress2() {
    // Arrange
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(null);
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(paymentForm);

    // Assert that nothing has changed
    verify(customerPaymentService).readCustomerPaymentById(isNull());
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}.
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)"})
  void testCopyCustomerPaymentAddressToBillingAddress3() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);
    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(customerPaymentImpl);
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(paymentForm);

    // Assert
    verify(customerPaymentImpl).getBillingAddress();
    verify(addressService).copyAddress(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(isNull());
    assertSame(addressImpl, paymentForm.getAddress());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#addTemporaryOrderPayment(PaymentInfoForm, Order)}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) Payments is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafPaymentInfoController#addTemporaryOrderPayment(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test addTemporaryOrderPayment(PaymentInfoForm, Order); then OrderImpl (default constructor) Payments is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.addTemporaryOrderPayment(PaymentInfoForm, Order)"})
  void testAddTemporaryOrderPayment_thenOrderImplPaymentsIsArrayList() {
    // Arrange
    when(orderPaymentService.create()).thenReturn(new OrderPaymentImpl());
    PaymentInfoForm paymentForm = new PaymentInfoForm();

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
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    ArrayList<OrderPayment> payments = new ArrayList<>();
    cart.setPayments(payments);
    cart.setStatus(new OrderStatus("Type", "Friendly Type"));
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());

    // Act
    broadleafPaymentInfoController.addTemporaryOrderPayment(paymentForm, cart);

    // Assert
    verify(orderPaymentService).create();
    assertSame(payments, cart.getPayments());
  }

  /**
   * Test new {@link BroadleafPaymentInfoController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BroadleafPaymentInfoController}
   */
  @Test
  @DisplayName("Test new BroadleafPaymentInfoController (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafPaymentInfoController.<init>()"})
  void testNewBroadleafPaymentInfoController() {
    // Arrange and Act
    BroadleafPaymentInfoController actualBroadleafPaymentInfoController = new BroadleafPaymentInfoController();

    // Assert
    assertEquals("ajaxredirect:/confirmation", actualBroadleafPaymentInfoController.getBaseConfirmationView());
    assertEquals("checkout/checkout", actualBroadleafPaymentInfoController.getCheckoutView());
    assertEquals("checkout/partials/checkoutStages", actualBroadleafPaymentInfoController.getCheckoutStagesPartial());
    assertEquals("redirect:/cart", actualBroadleafPaymentInfoController.getCartPageRedirect());
    assertEquals("redirect:/checkout", actualBroadleafPaymentInfoController.getCheckoutPageRedirect());
    assertNull(actualBroadleafPaymentInfoController.isoService);
    assertNull(actualBroadleafPaymentInfoController.paymentGatewayCheckoutService);
    assertNull(actualBroadleafPaymentInfoController.checkoutService);
    assertNull(actualBroadleafPaymentInfoController.fulfillmentGroupService);
    assertNull(actualBroadleafPaymentInfoController.fulfillmentOptionService);
    assertNull(actualBroadleafPaymentInfoController.orderMultishipOptionService);
    assertNull(actualBroadleafPaymentInfoController.orderService);
    assertNull(actualBroadleafPaymentInfoController.orderPaymentService);
    assertNull(actualBroadleafPaymentInfoController.dtoTranslationService);
    assertNull(actualBroadleafPaymentInfoController.billingInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.paymentInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.giftCardInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.multishipAddAddressFormValidator);
    assertNull(actualBroadleafPaymentInfoController.orderInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.shippingInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.checkoutControllerExtensionManager);
    assertNull(actualBroadleafPaymentInfoController.cartStateService);
    assertNull(actualBroadleafPaymentInfoController.savedPaymentService);
    assertNull(actualBroadleafPaymentInfoController.initBinderService);
    assertNull(actualBroadleafPaymentInfoController.addressService);
    assertNull(actualBroadleafPaymentInfoController.countryService);
    assertNull(actualBroadleafPaymentInfoController.countrySubdivisionService);
    assertNull(actualBroadleafPaymentInfoController.customerAddressService);
    assertNull(actualBroadleafPaymentInfoController.customerPaymentService);
    assertNull(actualBroadleafPaymentInfoController.customerService);
    assertNull(actualBroadleafPaymentInfoController.phoneService);
    assertNull(actualBroadleafPaymentInfoController.stateService);
  }
}
