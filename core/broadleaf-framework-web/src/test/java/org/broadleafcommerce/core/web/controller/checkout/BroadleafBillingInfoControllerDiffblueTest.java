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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.checkout.service.CheckoutService;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.web.checkout.model.BillingInfoForm;
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.broadleafcommerce.core.web.service.InitBinderService;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CountryService;
import org.broadleafcommerce.profile.core.service.CountrySubdivisionService;
import org.broadleafcommerce.profile.core.service.CustomerAddressService;
import org.broadleafcommerce.profile.core.service.CustomerPaymentService;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.core.service.PhoneService;
import org.broadleafcommerce.profile.core.service.StateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BroadleafBillingInfoControllerDiffblueTest {
  @Mock
  private AddressService addressService;

  @InjectMocks
  private BroadleafBillingInfoController broadleafBillingInfoController;

  @Mock
  private CartStateService cartStateService;

  @Mock
  private CheckoutService checkoutService;

  @Mock
  private CountryService countryService;

  @Mock
  private CountrySubdivisionService countrySubdivisionService;

  @Mock
  private CustomerAddressService customerAddressService;

  @Mock
  private CustomerPaymentService customerPaymentService;

  @Mock
  private CustomerService customerService;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @Mock
  private FulfillmentOptionService fulfillmentOptionService;

  @Mock
  private ISOService iSOService;

  @Mock
  private InitBinderService initBinderService;

  @Mock
  private OrderMultishipOptionService orderMultishipOptionService;

  @Mock
  private OrderPaymentService orderPaymentService;

  @Mock
  private OrderService orderService;

  @Mock
  private OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;

  @Mock
  private PhoneService phoneService;

  @Mock
  private StateService stateService;

  /**
   * Test {@link BroadleafBillingInfoController#copyShippingAddressToBillingAddress(Order, BillingInfoForm)}.
   * <ul>
   *   <li>Then calls {@link AddressService#copyAddress(Address)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafBillingInfoController#copyShippingAddressToBillingAddress(Order, BillingInfoForm)}
   */
  @Test
  @DisplayName("Test copyShippingAddressToBillingAddress(Order, BillingInfoForm); then calls copyAddress(Address)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafBillingInfoController.copyShippingAddressToBillingAddress(Order, BillingInfoForm)"})
  void testCopyShippingAddressToBillingAddress_thenCallsCopyAddress() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(new FulfillmentGroupStatusType("Type", "Friendly Type"));
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(new FulfillmentType("Type", "Friendly Type"));
    fulfillmentGroupImpl.setAddress(new AddressImpl());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(new OrderStatus("Type", "Friendly Type"));
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    // Act
    broadleafBillingInfoController.copyShippingAddressToBillingAddress(order, billingInfoForm);

    // Assert
    verify(addressService).copyAddress(isA(Address.class));
  }

  /**
   * Test new {@link BroadleafBillingInfoController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BroadleafBillingInfoController}
   */
  @Test
  @DisplayName("Test new BroadleafBillingInfoController (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafBillingInfoController.<init>()"})
  void testNewBroadleafBillingInfoController() {
    // Arrange and Act
    BroadleafBillingInfoController actualBroadleafBillingInfoController = new BroadleafBillingInfoController();

    // Assert
    assertEquals("ajaxredirect:/confirmation", actualBroadleafBillingInfoController.getBaseConfirmationView());
    assertEquals("checkout/checkout", actualBroadleafBillingInfoController.getCheckoutView());
    assertEquals("checkout/partials/checkoutStages", actualBroadleafBillingInfoController.getCheckoutStagesPartial());
    assertEquals("redirect:/cart", actualBroadleafBillingInfoController.getCartPageRedirect());
    assertEquals("redirect:/checkout", actualBroadleafBillingInfoController.getCheckoutPageRedirect());
    assertNull(actualBroadleafBillingInfoController.isoService);
    assertNull(actualBroadleafBillingInfoController.paymentGatewayCheckoutService);
    assertNull(actualBroadleafBillingInfoController.checkoutService);
    assertNull(actualBroadleafBillingInfoController.fulfillmentGroupService);
    assertNull(actualBroadleafBillingInfoController.fulfillmentOptionService);
    assertNull(actualBroadleafBillingInfoController.orderMultishipOptionService);
    assertNull(actualBroadleafBillingInfoController.orderService);
    assertNull(actualBroadleafBillingInfoController.orderPaymentService);
    assertNull(actualBroadleafBillingInfoController.dtoTranslationService);
    assertNull(actualBroadleafBillingInfoController.billingInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.paymentInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.giftCardInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.multishipAddAddressFormValidator);
    assertNull(actualBroadleafBillingInfoController.orderInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.shippingInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.checkoutControllerExtensionManager);
    assertNull(actualBroadleafBillingInfoController.cartStateService);
    assertNull(actualBroadleafBillingInfoController.initBinderService);
    assertNull(actualBroadleafBillingInfoController.addressService);
    assertNull(actualBroadleafBillingInfoController.countryService);
    assertNull(actualBroadleafBillingInfoController.countrySubdivisionService);
    assertNull(actualBroadleafBillingInfoController.customerAddressService);
    assertNull(actualBroadleafBillingInfoController.customerPaymentService);
    assertNull(actualBroadleafBillingInfoController.customerService);
    assertNull(actualBroadleafBillingInfoController.phoneService);
    assertNull(actualBroadleafBillingInfoController.stateService);
  }
}
