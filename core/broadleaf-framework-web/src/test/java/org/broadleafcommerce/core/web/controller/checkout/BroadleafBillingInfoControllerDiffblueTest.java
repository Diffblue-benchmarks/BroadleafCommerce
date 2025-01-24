package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService;
import org.broadleafcommerce.core.checkout.service.CheckoutService;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.BillingInfoForm;
import org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.CheckoutPaymentInfoFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.GiftCardInfoFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.MultishipAddAddressFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.OrderInfoFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator;
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.core.web.service.InitBinderService;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CountryService;
import org.broadleafcommerce.profile.core.service.CountrySubdivisionService;
import org.broadleafcommerce.profile.core.service.CustomerAddressService;
import org.broadleafcommerce.profile.core.service.CustomerPaymentService;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.core.service.PhoneService;
import org.broadleafcommerce.profile.core.service.StateService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@ContextConfiguration(classes = {BroadleafBillingInfoController.class})
@ExtendWith(SpringExtension.class)
class BroadleafBillingInfoControllerDiffblueTest {
  @MockBean
  private AddressService addressService;

  @MockBean(name = "blBillingInfoFormValidator")
  private BillingInfoFormValidator billingInfoFormValidator;

  @Autowired
  private BroadleafBillingInfoController broadleafBillingInfoController;

  @MockBean(name = "blCheckoutControllerExtensionManager")
  private BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;

  @MockBean
  private CartStateService cartStateService;

  @MockBean(name = "blCheckoutPaymentInfoFormValidator")
  private CheckoutPaymentInfoFormValidator checkoutPaymentInfoFormValidator;

  @MockBean
  private CheckoutService checkoutService;

  @MockBean
  private CountryService countryService;

  @MockBean
  private CountrySubdivisionService countrySubdivisionService;

  @MockBean
  private CustomerAddressService customerAddressService;

  @MockBean
  private CustomerPaymentService customerPaymentService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private FulfillmentGroupService fulfillmentGroupService;

  @MockBean
  private FulfillmentOptionService fulfillmentOptionService;

  @MockBean(name = "blGiftCardInfoFormValidator")
  private GiftCardInfoFormValidator giftCardInfoFormValidator;

  @MockBean
  private ISOService iSOService;

  @MockBean
  private InitBinderService initBinderService;

  @MockBean(name = "blMultishipAddAddressFormValidator")
  private MultishipAddAddressFormValidator multishipAddAddressFormValidator;

  @MockBean(name = "blOrderInfoFormValidator")
  private OrderInfoFormValidator orderInfoFormValidator;

  @MockBean
  private OrderMultishipOptionService orderMultishipOptionService;

  @MockBean
  private OrderPaymentService orderPaymentService;

  @MockBean
  private OrderService orderService;

  @MockBean
  private OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;

  @MockBean(name = "blPaymentGatewayCheckoutService")
  private PaymentGatewayCheckoutService paymentGatewayCheckoutService;

  @MockBean
  private PhoneService phoneService;

  @MockBean(name = "blShippingInfoFormValidator")
  private ShippingInfoFormValidator shippingInfoFormValidator;

  @MockBean
  private StateService stateService;

  /**
   * Test
   * {@link BroadleafBillingInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, BillingInfoForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link BroadleafBillingInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, BillingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, BillingInfoForm, BindingResult)")
  @Disabled("TODO: Complete this test")
  void testSaveBillingAddress() throws ServiceException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass897 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController broadleafBillingInfoController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.order.service.CartStateService cartStateService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutPaymentInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.CheckoutPaymentInfoFormValidator checkoutPaymentInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.checkout.service.CheckoutService checkoutService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountryService countryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountrySubdivisionService countrySubdivisionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerAddressService customerAddressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerPaymentService customerPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentOptionService fulfillmentOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blGiftCardInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.GiftCardInfoFormValidator giftCardInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.i18n.service.ISOService iSOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.InitBinderService initBinderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blMultishipAddAddressFormValidator") org.broadleafcommerce.core.web.checkout.validator.MultishipAddAddressFormValidator multishipAddAddressFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.OrderInfoFormValidator orderInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderPaymentService orderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blPaymentGatewayCheckoutService") org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService paymentGatewayCheckoutService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.PhoneService phoneService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blShippingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator shippingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    BillingInfoForm billingForm = new BillingInfoForm();
    billingForm.setAddress(new AddressImpl());
    billingForm.setCustomerPayment(new CustomerPaymentImpl());
    billingForm.setCustomerPaymentId(1L);
    billingForm.setPaymentName("Payment Name");
    billingForm.setSaveNewPayment(true);
    billingForm.setUseCustomerPayment(true);
    billingForm.setUseShippingAddress(true);

    // Act
    broadleafBillingInfoController.saveBillingAddress(request, response, model, billingForm,
        new BindException("Target", "Object Name"));
  }

  /**
   * Test
   * {@link BroadleafBillingInfoController#copyShippingAddressToBillingAddress(Order, BillingInfoForm)}.
   * <p>
   * Method under test:
   * {@link BroadleafBillingInfoController#copyShippingAddressToBillingAddress(Order, BillingInfoForm)}
   */
  @Test
  @DisplayName("Test copyShippingAddressToBillingAddress(Order, BillingInfoForm)")
  @Disabled("TODO: Complete this test")
  void testCopyShippingAddressToBillingAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass896 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController broadleafBillingInfoController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.order.service.CartStateService cartStateService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutPaymentInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.CheckoutPaymentInfoFormValidator checkoutPaymentInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.checkout.service.CheckoutService checkoutService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountryService countryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountrySubdivisionService countrySubdivisionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerAddressService customerAddressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerPaymentService customerPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentOptionService fulfillmentOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blGiftCardInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.GiftCardInfoFormValidator giftCardInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.i18n.service.ISOService iSOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.InitBinderService initBinderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blMultishipAddAddressFormValidator") org.broadleafcommerce.core.web.checkout.validator.MultishipAddAddressFormValidator multishipAddAddressFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.OrderInfoFormValidator orderInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderPaymentService orderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blPaymentGatewayCheckoutService") org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService paymentGatewayCheckoutService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.PhoneService phoneService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blShippingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator shippingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

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
  }

  /**
   * Test new {@link BroadleafBillingInfoController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafBillingInfoController}
   */
  @Test
  @DisplayName("Test new BroadleafBillingInfoController (default constructor)")
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
