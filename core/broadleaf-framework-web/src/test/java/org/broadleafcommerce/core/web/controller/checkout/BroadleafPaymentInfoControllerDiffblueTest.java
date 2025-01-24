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
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.CheckoutPaymentInfoFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.GiftCardInfoFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.MultishipAddAddressFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.OrderInfoFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator;
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.broadleafcommerce.core.web.payment.service.SavedPaymentService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.core.web.service.InitBinderService;
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

@ContextConfiguration(classes = {BroadleafPaymentInfoController.class})
@ExtendWith(SpringExtension.class)
class BroadleafPaymentInfoControllerDiffblueTest {
  @MockBean
  private AddressService addressService;

  @MockBean(name = "blBillingInfoFormValidator")
  private BillingInfoFormValidator billingInfoFormValidator;

  @MockBean(name = "blCheckoutControllerExtensionManager")
  private BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;

  @Autowired
  private BroadleafPaymentInfoController broadleafPaymentInfoController;

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

  @MockBean
  private SavedPaymentService savedPaymentService;

  @MockBean(name = "blShippingInfoFormValidator")
  private ShippingInfoFormValidator shippingInfoFormValidator;

  @MockBean
  private StateService stateService;

  /**
   * Test
   * {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)")
  @Disabled("TODO: Complete this test")
  void testSavePaymentInfo() throws ServiceException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass915 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController broadleafPaymentInfoController;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.payment.service.SavedPaymentService savedPaymentService;
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
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.savePaymentInfo(request, response, model, paymentForm,
        new BindException("Target", "Object Name"));
  }

  /**
   * Test
   * {@link BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)")
  @Disabled("TODO: Complete this test")
  void testSaveBillingAddress() throws ServiceException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass914 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController broadleafPaymentInfoController;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.payment.service.SavedPaymentService savedPaymentService;
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
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.saveBillingAddress(request, response, model, paymentForm,
        new BindException("Target", "Object Name"));
  }

  /**
   * Test
   * {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   * <p>
   * Method under test:
   * {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order)")
  @Disabled("TODO: Complete this test")
  void testPreProcessBillingAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass913 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController broadleafPaymentInfoController;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.payment.service.SavedPaymentService savedPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blShippingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator shippingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());
  }

  /**
   * Test
   * {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}.
   * <p>
   * Method under test:
   * {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyShippingAddressToBillingAddress(Order, PaymentInfoForm)")
  @Disabled("TODO: Complete this test")
  void testCopyShippingAddressToBillingAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass912 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController broadleafPaymentInfoController;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.payment.service.SavedPaymentService savedPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blShippingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator shippingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    broadleafPaymentInfoController.copyShippingAddressToBillingAddress(order, new PaymentInfoForm());
  }

  /**
   * Test
   * {@link BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}.
   * <p>
   * Method under test:
   * {@link BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)")
  @Disabled("TODO: Complete this test")
  void testCopyCustomerPaymentAddressToBillingAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass911 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController broadleafPaymentInfoController;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.payment.service.SavedPaymentService savedPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blShippingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator shippingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(new PaymentInfoForm());
  }

  /**
   * Test
   * {@link BroadleafPaymentInfoController#addTemporaryOrderPayment(PaymentInfoForm, Order)}.
   * <p>
   * Method under test:
   * {@link BroadleafPaymentInfoController#addTemporaryOrderPayment(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test addTemporaryOrderPayment(PaymentInfoForm, Order)")
  @Disabled("TODO: Complete this test")
  void testAddTemporaryOrderPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass910 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafPaymentInfoController broadleafPaymentInfoController;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.payment.service.SavedPaymentService savedPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blShippingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator shippingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.addTemporaryOrderPayment(paymentForm, new NullOrderImpl());
  }

  /**
   * Test new {@link BroadleafPaymentInfoController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafPaymentInfoController}
   */
  @Test
  @DisplayName("Test new BroadleafPaymentInfoController (default constructor)")
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
