package org.broadleafcommerce.core.web.checkout.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.web.checkout.model.BillingInfoForm;
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
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutFormServiceImplDiffblueTest {
  @InjectMocks private CheckoutFormServiceImpl checkoutFormServiceImpl;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @Mock private OrderPaymentService orderPaymentService;

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateOrderInfoForm(OrderInfoForm, Order)}.
   *
   * <ul>
   *   <li>Then {@link OrderInfoForm} (default constructor) EmailAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#prePopulateOrderInfoForm(OrderInfoForm,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderInfoForm CheckoutFormServiceImpl.prePopulateOrderInfoForm(OrderInfoForm, Order)"
  })
  public void testPrePopulateOrderInfoForm_thenOrderInfoFormEmailAddressIsNull() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main St");

    // Act
    OrderInfoForm actualPrePopulateOrderInfoFormResult =
        checkoutFormServiceImpl.prePopulateOrderInfoForm(orderInfoForm, new NullOrderImpl());

    // Assert
    assertNull(orderInfoForm.getEmailAddress());
    assertSame(orderInfoForm, actualPrePopulateOrderInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateShippingInfoForm(ShippingInfoForm, Order)}.
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateShippingInfoForm(ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ShippingInfoForm CheckoutFormServiceImpl.prePopulateShippingInfoForm(ShippingInfoForm, Order)"
  })
  public void testPrePopulateShippingInfoForm() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentOptionImpl fulfillmentOption = new FulfillmentOptionImpl();
    fulfillmentGroupImpl.setFulfillmentOption(fulfillmentOption);
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();

    // Act
    ShippingInfoForm actualPrePopulateShippingInfoFormResult =
        checkoutFormServiceImpl.prePopulateShippingInfoForm(shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    assertSame(fulfillmentOption, shippingInfoForm.getFulfillmentOption());
    assertSame(fulfillmentOption, actualPrePopulateShippingInfoFormResult.getFulfillmentOption());
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateShippingInfoForm(ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Then Address return {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateShippingInfoForm(ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ShippingInfoForm CheckoutFormServiceImpl.prePopulateShippingInfoForm(ShippingInfoForm, Order)"
  })
  public void testPrePopulateShippingInfoForm_thenAddressReturnAddressImpl() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(null);
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();

    // Act
    ShippingInfoForm actualPrePopulateShippingInfoFormResult =
        checkoutFormServiceImpl.prePopulateShippingInfoForm(shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    Address address = actualPrePopulateShippingInfoFormResult.getAddress();
    assertTrue(address instanceof AddressImpl);
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

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateShippingInfoForm(ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupService#getFirstShippableFulfillmentGroup(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateShippingInfoForm(ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ShippingInfoForm CheckoutFormServiceImpl.prePopulateShippingInfoForm(ShippingInfoForm, Order)"
  })
  public void testPrePopulateShippingInfoForm_thenCallsGetFirstShippableFulfillmentGroup() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();

    // Act
    checkoutFormServiceImpl.prePopulateShippingInfoForm(shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getAddressLine1()).thenReturn("42 Main St");
    when(address.getAddressLine2()).thenReturn(null);
    when(address.getCity()).thenReturn("Oxford");
    when(address.getStateProvinceRegion()).thenReturn("us-east-2");

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(address);
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setCity("Oxford");
    addressImpl.setAddressLine1("42 Main St");

    ShippingInfoForm shippingInfoForm = mock(ShippingInfoForm.class);
    when(shippingInfoForm.getAddress()).thenReturn(addressImpl);

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    verify(shippingInfoForm).getAddress();
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    verify(address).getStateProvinceRegion();
    assertFalse(billingInfoForm.isUseShippingAddress());
    assertSame(billingInfoForm, actualPrePopulateBillingInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm_givenAddressImpl() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(mock(AddressImpl.class));
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    ShippingInfoForm shippingInfoForm = mock(ShippingInfoForm.class);
    when(shippingInfoForm.getAddress()).thenReturn(null);

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    verify(shippingInfoForm).getAddress();
    assertFalse(billingInfoForm.isUseShippingAddress());
    assertSame(billingInfoForm, actualPrePopulateBillingInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getAddressLine2()} return {@code 42 Main
   *       St}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm_givenAddressImplGetAddressLine2Return42MainSt() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getAddressLine1()).thenReturn("42 Main St");
    when(address.getAddressLine2()).thenReturn("42 Main St");

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(address);
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setAddressLine1("42 Main St");

    ShippingInfoForm shippingInfoForm = mock(ShippingInfoForm.class);
    when(shippingInfoForm.getAddress()).thenReturn(addressImpl);

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    verify(shippingInfoForm).getAddress();
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    assertFalse(billingInfoForm.isUseShippingAddress());
    assertSame(billingInfoForm, actualPrePopulateBillingInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) IsoCountrySubdivision is {@code GB}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm_givenAddressImplIsoCountrySubdivisionIsGb() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    AddressImpl address = new AddressImpl();
    address.setIsoCountrySubdivision("GB");

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);
    billingInfoForm.setAddress(address);

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(new AddressImpl());

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    Address address2 = actualPrePopulateBillingInfoFormResult.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertSame(address, address2);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link BillingInfoForm} (default constructor) Address is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm_givenNull_whenBillingInfoFormAddressIsNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(null);
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(billingInfoForm.isUseShippingAddress());
    assertSame(billingInfoForm, actualPrePopulateBillingInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Then {@link BillingInfoForm} (default constructor) UseShippingAddress.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm_thenBillingInfoFormUseShippingAddress() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    AddressImpl address = new AddressImpl();
    billingInfoForm.setAddress(address);
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    Address address2 = actualPrePopulateBillingInfoFormResult.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertTrue(billingInfoForm.isUseShippingAddress());
    assertTrue(actualPrePopulateBillingInfoFormResult.isUseShippingAddress());
    assertSame(address, address2);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressImpl#getCity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm_thenCallsGetCity() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getAddressLine1()).thenReturn("42 Main St");
    when(address.getAddressLine2()).thenReturn(null);
    when(address.getCity()).thenReturn("Oxford");

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(address);
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setAddressLine1("42 Main St");

    ShippingInfoForm shippingInfoForm = mock(ShippingInfoForm.class);
    when(shippingInfoForm.getAddress()).thenReturn(addressImpl);

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    verify(shippingInfoForm).getAddress();
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    assertFalse(billingInfoForm.isUseShippingAddress());
    assertSame(billingInfoForm, actualPrePopulateBillingInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressImpl#getIsoCountryAlpha2()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm_thenCallsGetIsoCountryAlpha2() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getAddressLine1()).thenReturn("42 Main St");
    when(address.getAddressLine2()).thenReturn(null);
    when(address.getCity()).thenReturn("Oxford");
    when(address.getPostalCode()).thenReturn("Postal Code");
    when(address.getStateProvinceRegion()).thenReturn(null);
    when(address.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(address);
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPostalCode("Postal Code");
    addressImpl.setCity("Oxford");
    addressImpl.setAddressLine1("42 Main St");

    ShippingInfoForm shippingInfoForm = mock(ShippingInfoForm.class);
    when(shippingInfoForm.getAddress()).thenReturn(addressImpl);

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    verify(shippingInfoForm).getAddress();
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    verify(address).getIsoCountryAlpha2();
    verify(address).getPostalCode();
    verify(address).getStateProvinceRegion();
    assertFalse(billingInfoForm.isUseShippingAddress());
    assertSame(billingInfoForm, actualPrePopulateBillingInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressImpl#getPostalCode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm_thenCallsGetPostalCode() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getAddressLine1()).thenReturn("42 Main St");
    when(address.getAddressLine2()).thenReturn(null);
    when(address.getCity()).thenReturn("Oxford");
    when(address.getPostalCode()).thenReturn("Postal Code");
    when(address.getStateProvinceRegion()).thenReturn(null);

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(address);
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setCity("Oxford");
    addressImpl.setAddressLine1("42 Main St");

    ShippingInfoForm shippingInfoForm = mock(ShippingInfoForm.class);
    when(shippingInfoForm.getAddress()).thenReturn(addressImpl);

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    verify(shippingInfoForm).getAddress();
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    verify(address).getPostalCode();
    verify(address).getStateProvinceRegion();
    assertFalse(billingInfoForm.isUseShippingAddress());
    assertSame(billingInfoForm, actualPrePopulateBillingInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm,
   * ShippingInfoForm, Order)}.
   *
   * <ul>
   *   <li>When {@link ShippingInfoForm} (default constructor).
   *   <li>Then calls {@link AddressImpl#getAddressLine1()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BillingInfoForm CheckoutFormServiceImpl.prePopulateBillingInfoForm(BillingInfoForm, ShippingInfoForm, Order)"
  })
  public void testPrePopulateBillingInfoForm_whenShippingInfoForm_thenCallsGetAddressLine1() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getAddressLine1()).thenReturn("42 Main St");

    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(address);
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);
    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();

    // Act
    BillingInfoForm actualPrePopulateBillingInfoFormResult =
        checkoutFormServiceImpl.prePopulateBillingInfoForm(
            billingInfoForm, shippingInfoForm, new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    verify(address).getAddressLine1();
    assertFalse(billingInfoForm.isUseShippingAddress());
    assertSame(billingInfoForm, actualPrePopulateBillingInfoFormResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}.
   *
   * <ul>
   *   <li>Given {@code Cart}.
   *   <li>Then return {@code Cart}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String CheckoutFormServiceImpl.getKnownEmailAddress(Order, Customer)"
  })
  public void testGetKnownEmailAddress_givenCart_thenReturnCart() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    cart.setStatus(new OrderStatus());
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress("Cart");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals("Cart", checkoutFormServiceImpl.getKnownEmailAddress(cart, customer));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@code Customer}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String CheckoutFormServiceImpl.getKnownEmailAddress(Order, Customer)"
  })
  public void testGetKnownEmailAddress_givenNull_thenReturnCustomer() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    cart.setStatus(new OrderStatus());
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String CheckoutFormServiceImpl.getKnownEmailAddress(Order, Customer)"
  })
  public void testGetKnownEmailAddress_givenNull_thenReturnNull() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    cart.setStatus(new OrderStatus());
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);

    // Act and Assert
    assertNull(checkoutFormServiceImpl.getKnownEmailAddress(cart, null));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getKnownEmailAddress(Order, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String CheckoutFormServiceImpl.getKnownEmailAddress(Order, Customer)"
  })
  public void testGetKnownEmailAddress_whenNullOrderImpl_thenReturnNull() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    NullOrderImpl cart = new NullOrderImpl();

    // Act and Assert
    assertNull(checkoutFormServiceImpl.getKnownEmailAddress(cart, new CustomerImpl()));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getBillingAddress(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getBillingAddress()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getBillingAddress(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getBillingAddress(Order)"})
  public void testGetBillingAddress_givenOrderPaymentImplGetBillingAddressReturnNull() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(null);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    Address actualBillingAddress = checkoutFormServiceImpl.getBillingAddress(new NullOrderImpl());

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertNull(actualBillingAddress);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getBillingAddress(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getBillingAddress(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getBillingAddress(Order)"})
  public void testGetBillingAddress_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    Address actualBillingAddress = checkoutFormServiceImpl.getBillingAddress(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertNull(actualBillingAddress);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getBillingAddress(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getBillingAddress(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getBillingAddress(Order)"})
  public void testGetBillingAddress_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    Address actualBillingAddress = checkoutFormServiceImpl.getBillingAddress(new NullOrderImpl());

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertNull(actualBillingAddress);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getBillingAddress(Order)}.
   *
   * <ul>
   *   <li>Then return {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getBillingAddress(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getBillingAddress(Order)"})
  public void testGetBillingAddress_thenReturnAddressImpl() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    AddressImpl addressImpl = new AddressImpl();
    when(orderPaymentImpl.getBillingAddress()).thenReturn(addressImpl);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    Address actualBillingAddress = checkoutFormServiceImpl.getBillingAddress(new NullOrderImpl());

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl, atLeast(1)).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertSame(addressImpl, actualBillingAddress);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getBillingAddress(Order)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getBillingAddress(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getBillingAddress(Order)"})
  public void testGetBillingAddress_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Address actualBillingAddress = checkoutFormServiceImpl.getBillingAddress(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertNull(actualBillingAddress);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}.
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getAddressFromCCOrderPayment(Order)"})
  public void testGetAddressFromCCOrderPayment() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(null);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    Address actualAddressFromCCOrderPayment =
        checkoutFormServiceImpl.getAddressFromCCOrderPayment(new NullOrderImpl());

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertNull(actualAddressFromCCOrderPayment);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getAddressFromCCOrderPayment(Order)"})
  public void testGetAddressFromCCOrderPayment_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    Address actualAddressFromCCOrderPayment =
        checkoutFormServiceImpl.getAddressFromCCOrderPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertNull(actualAddressFromCCOrderPayment);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getAddressFromCCOrderPayment(Order)"})
  public void testGetAddressFromCCOrderPayment_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    Address actualAddressFromCCOrderPayment =
        checkoutFormServiceImpl.getAddressFromCCOrderPayment(new NullOrderImpl());

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertNull(actualAddressFromCCOrderPayment);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}.
   *
   * <ul>
   *   <li>Then return {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getAddressFromCCOrderPayment(Order)"})
  public void testGetAddressFromCCOrderPayment_thenReturnAddressImpl() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    AddressImpl addressImpl = new AddressImpl();
    when(orderPaymentImpl.getBillingAddress()).thenReturn(addressImpl);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    Address actualAddressFromCCOrderPayment =
        checkoutFormServiceImpl.getAddressFromCCOrderPayment(new NullOrderImpl());

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl, atLeast(1)).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertSame(addressImpl, actualAddressFromCCOrderPayment);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#getAddressFromCCOrderPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address CheckoutFormServiceImpl.getAddressFromCCOrderPayment(Order)"})
  public void testGetAddressFromCCOrderPayment_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Address actualAddressFromCCOrderPayment =
        checkoutFormServiceImpl.getAddressFromCCOrderPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertNull(actualAddressFromCCOrderPayment);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();

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
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, shippingInfoForm));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue2() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();

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
    boolean actualShouldUseShippingAddressDefaultValue =
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, shippingInfoForm);

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
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue3() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();

    AddressImpl address = mock(AddressImpl.class);
    when(address.getAddressLine2()).thenReturn("42 Main St");
    when(address.getAddressLine1()).thenReturn("42 Main St");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    AddressImpl address2 = new AddressImpl();
    address2.setActive(true);
    address2.setAddressLine1("42 Main St");
    address2.setAddressLine2("17 High St");
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
    boolean actualShouldUseShippingAddressDefaultValue =
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue4() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();

    AddressImpl address = mock(AddressImpl.class);
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
    address2.setStateProvinceRegion("MD");
    address2.setStreet(true);
    address2.setTokenizedAddress("42 Main St");
    address2.setVerificationLevel("Verification Level");
    address2.setZipFour("21654");

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(address2);

    // Act
    boolean actualShouldUseShippingAddressDefaultValue =
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    verify(address).getStateProvinceRegion();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) City is {@code London}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue_givenAddressImplCityIsLondon() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();

    AddressImpl address = mock(AddressImpl.class);
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
    address2.setCity("London");
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
    boolean actualShouldUseShippingAddressDefaultValue =
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PostalCode is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue_givenAddressImplPostalCodeIs42() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();

    AddressImpl address = mock(AddressImpl.class);
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
    address2.setPostalCode("42");
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
    boolean actualShouldUseShippingAddressDefaultValue =
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, shippingInfoForm);

    // Assert
    verify(address).getAddressLine1();
    verify(address).getAddressLine2();
    verify(address).getCity();
    verify(address).getPostalCode();
    verify(address).getStateProvinceRegion();
    assertFalse(actualShouldUseShippingAddressDefaultValue);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressImpl#getIsoCountrySubdivision()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue_thenCallsGetIsoCountrySubdivision() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();

    AddressImpl address = mock(AddressImpl.class);
    when(address.getIsoCountrySubdivision()).thenReturn("GB");
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
    address2.setIsoCountrySubdivision("GBR");
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
    boolean actualShouldUseShippingAddressDefaultValue =
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, shippingInfoForm);

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
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue_whenNull_thenReturnTrue() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(new AddressImpl());

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(new AddressImpl());

    // Act and Assert
    assertTrue(
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            null, paymentInfoForm, shippingInfoForm));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <ul>
   *   <li>When {@link PaymentInfoForm} (default constructor) Address is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue_whenPaymentInfoFormAddressIsNull() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(null);

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(new AddressImpl());

    // Act and Assert
    assertFalse(
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, shippingInfoForm));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <ul>
   *   <li>When {@link PaymentInfoForm} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue_whenPaymentInfoForm_thenReturnFalse() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();

    // Act and Assert
    assertFalse(
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, new ShippingInfoForm()));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <ul>
   *   <li>When {@link ShippingInfoForm} (default constructor) Address is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue_whenShippingInfoFormAddressIsNull() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    CustomerPaymentImpl customerPaymentUsedForOrder = new CustomerPaymentImpl();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(new AddressImpl());

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(null);

    // Act and Assert
    assertFalse(
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            customerPaymentUsedForOrder, paymentInfoForm, shippingInfoForm));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}.
   *
   * <ul>
   *   <li>When {@link ShippingInfoForm} (default constructor) Address is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckoutFormServiceImpl#getShouldUseShippingAddressDefaultValue(CustomerPayment,
   * PaymentInfoForm, ShippingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(CustomerPayment, PaymentInfoForm, ShippingInfoForm)"
  })
  public void testGetShouldUseShippingAddressDefaultValue_whenShippingInfoFormAddressIsNull2() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(new AddressImpl());

    ShippingInfoForm shippingInfoForm = new ShippingInfoForm();
    shippingInfoForm.setAddress(null);

    // Act and Assert
    assertFalse(
        checkoutFormServiceImpl.getShouldUseShippingAddressDefaultValue(
            null, paymentInfoForm, shippingInfoForm));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>Given {@code GB}.
   *   <li>Then calls {@link AddressImpl#getIsoCountrySubdivision()}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_givenGb_thenCallsGetIsoCountrySubdivision() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn("42 Main St");
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn("Oxford");
    when(address1.getIsoCountrySubdivision()).thenReturn("GB");
    when(address1.getPostalCode()).thenReturn("Postal Code");
    when(address1.getStateProvinceRegion()).thenReturn(null);
    when(address1.getIsoCountryAlpha2()).thenReturn(null);

    AddressImpl address2 = new AddressImpl();
    address2.setPostalCode("Postal Code");
    address2.setCity("Oxford");
    address2.setAddressLine1("42 Main St");

    // Act
    boolean actualAddressesContentsAreEqualResult =
        checkoutFormServiceImpl.addressesContentsAreEqual(address1, address2);

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
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_givenISOCountryImpl() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn("42 Main St");
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn("Oxford");
    when(address1.getPostalCode()).thenReturn("Postal Code");
    when(address1.getStateProvinceRegion()).thenReturn(null);
    when(address1.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());

    AddressImpl address2 = new AddressImpl();
    address2.setPostalCode("Postal Code");
    address2.setCity("Oxford");
    address2.setAddressLine1("42 Main St");

    // Act
    boolean actualAddressesContentsAreEqualResult =
        checkoutFormServiceImpl.addressesContentsAreEqual(address1, address2);

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
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link AddressImpl#getCity()}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_givenNull_thenCallsGetCity() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn("42 Main St");
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn("Oxford");

    AddressImpl address2 = new AddressImpl();
    address2.setAddressLine1("42 Main St");

    // Act
    boolean actualAddressesContentsAreEqualResult =
        checkoutFormServiceImpl.addressesContentsAreEqual(address1, address2);

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    verify(address1).getCity();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>Given {@code Postal Code}.
   *   <li>Then calls {@link AddressImpl#getPostalCode()}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_givenPostalCode_thenCallsGetPostalCode() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn("42 Main St");
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn("Oxford");
    when(address1.getPostalCode()).thenReturn("Postal Code");
    when(address1.getStateProvinceRegion()).thenReturn(null);

    AddressImpl address2 = new AddressImpl();
    address2.setCity("Oxford");
    address2.setAddressLine1("42 Main St");

    // Act
    boolean actualAddressesContentsAreEqualResult =
        checkoutFormServiceImpl.addressesContentsAreEqual(address1, address2);

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    verify(address1).getCity();
    verify(address1).getPostalCode();
    verify(address1).getStateProvinceRegion();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>Given {@code us-east-2}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_givenUsEast2() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn("42 Main St");
    when(address1.getAddressLine2()).thenReturn(null);
    when(address1.getCity()).thenReturn("Oxford");
    when(address1.getStateProvinceRegion()).thenReturn("us-east-2");

    AddressImpl address2 = new AddressImpl();
    address2.setCity("Oxford");
    address2.setAddressLine1("42 Main St");

    // Act
    boolean actualAddressesContentsAreEqualResult =
        checkoutFormServiceImpl.addressesContentsAreEqual(address1, address2);

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    verify(address1).getCity();
    verify(address1).getStateProvinceRegion();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} {@link AddressImpl#getAddressLine2()} return {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_whenAddressImplGetAddressLine2Return42MainSt() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn("42 Main St");
    when(address1.getAddressLine2()).thenReturn("42 Main St");

    AddressImpl address2 = new AddressImpl();
    address2.setAddressLine1("42 Main St");

    // Act
    boolean actualAddressesContentsAreEqualResult =
        checkoutFormServiceImpl.addressesContentsAreEqual(address1, address2);

    // Assert
    verify(address1).getAddressLine1();
    verify(address1).getAddressLine2();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).
   *   <li>Then calls {@link AddressImpl#getAddressLine1()}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_whenAddressImpl_thenCallsGetAddressLine1() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    AddressImpl address1 = mock(AddressImpl.class);
    when(address1.getAddressLine1()).thenReturn("42 Main St");

    // Act
    boolean actualAddressesContentsAreEqualResult =
        checkoutFormServiceImpl.addressesContentsAreEqual(address1, new AddressImpl());

    // Assert
    verify(address1).getAddressLine1();
    assertFalse(actualAddressesContentsAreEqualResult);
  }

  /**
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_whenAddressImpl_thenReturnTrue() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();
    AddressImpl address1 = new AddressImpl();

    // Act and Assert
    assertTrue(checkoutFormServiceImpl.addressesContentsAreEqual(address1, new AddressImpl()));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_whenNull_thenReturnFalse() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    // Act and Assert
    assertFalse(checkoutFormServiceImpl.addressesContentsAreEqual(new AddressImpl(), null));
  }

  /**
   * Test {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address, Address)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormServiceImpl#addressesContentsAreEqual(Address,
   * Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormServiceImpl.addressesContentsAreEqual(Address, Address)"})
  public void testAddressesContentsAreEqual_whenNull_thenReturnFalse2() {
    // Arrange
    CheckoutFormServiceImpl checkoutFormServiceImpl = new CheckoutFormServiceImpl();

    // Act and Assert
    assertFalse(checkoutFormServiceImpl.addressesContentsAreEqual(null, new AddressImpl()));
  }
}
