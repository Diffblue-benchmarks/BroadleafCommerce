package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService;
import org.broadleafcommerce.core.checkout.service.CheckoutService;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;

@ContextConfiguration(classes = {BroadleafBillingInfoController.class})
@ExtendWith(SpringExtension.class)
class AbstractCheckoutControllerDiffblueTest {
  @Autowired
  private AbstractCheckoutController abstractCheckoutController;

  @MockBean
  private AddressService addressService;

  @MockBean(name = "blBillingInfoFormValidator")
  private BillingInfoFormValidator billingInfoFormValidator;

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
   * Test {@link AbstractCheckoutController#getCartPageRedirect()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getCartPageRedirect()}
   */
  @Test
  @DisplayName("Test getCartPageRedirect()")
  void testGetCartPageRedirect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/cart", (new BroadleafBillingInfoController()).getCartPageRedirect());
  }

  /**
   * Test {@link AbstractCheckoutController#getCartPageRedirect()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getCartPageRedirect()}
   */
  @Test
  @DisplayName("Test getCartPageRedirect()")
  @Disabled("TODO: Complete this test")
  void testGetCartPageRedirect2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass889 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.AbstractCheckoutController abstractCheckoutController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
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

    // Arrange and Act
    abstractCheckoutController.getCartPageRedirect();
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutView()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getCheckoutView()}
   */
  @Test
  @DisplayName("Test getCheckoutView()")
  void testGetCheckoutView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("checkout/checkout", (new BroadleafBillingInfoController()).getCheckoutView());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutView()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getCheckoutView()}
   */
  @Test
  @DisplayName("Test getCheckoutView()")
  @Disabled("TODO: Complete this test")
  void testGetCheckoutView2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass892 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.AbstractCheckoutController abstractCheckoutController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
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

    // Arrange and Act
    abstractCheckoutController.getCheckoutView();
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutStagesPartial()}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getCheckoutStagesPartial()}
   */
  @Test
  @DisplayName("Test getCheckoutStagesPartial()")
  void testGetCheckoutStagesPartial() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("checkout/partials/checkoutStages", (new BroadleafBillingInfoController()).getCheckoutStagesPartial());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutStagesPartial()}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getCheckoutStagesPartial()}
   */
  @Test
  @DisplayName("Test getCheckoutStagesPartial()")
  @Disabled("TODO: Complete this test")
  void testGetCheckoutStagesPartial2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass891 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.AbstractCheckoutController abstractCheckoutController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
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

    // Arrange and Act
    abstractCheckoutController.getCheckoutStagesPartial();
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutPageRedirect()}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getCheckoutPageRedirect()}
   */
  @Test
  @DisplayName("Test getCheckoutPageRedirect()")
  void testGetCheckoutPageRedirect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/checkout", (new BroadleafBillingInfoController()).getCheckoutPageRedirect());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutPageRedirect()}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getCheckoutPageRedirect()}
   */
  @Test
  @DisplayName("Test getCheckoutPageRedirect()")
  @Disabled("TODO: Complete this test")
  void testGetCheckoutPageRedirect2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass890 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.AbstractCheckoutController abstractCheckoutController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
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

    // Arrange and Act
    abstractCheckoutController.getCheckoutPageRedirect();
  }

  /**
   * Test {@link AbstractCheckoutController#getBaseConfirmationView()}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getBaseConfirmationView()}
   */
  @Test
  @DisplayName("Test getBaseConfirmationView()")
  void testGetBaseConfirmationView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ajaxredirect:/confirmation", (new BroadleafBillingInfoController()).getBaseConfirmationView());
  }

  /**
   * Test {@link AbstractCheckoutController#getBaseConfirmationView()}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getBaseConfirmationView()}
   */
  @Test
  @DisplayName("Test getBaseConfirmationView()")
  @Disabled("TODO: Complete this test")
  void testGetBaseConfirmationView2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass888 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.AbstractCheckoutController abstractCheckoutController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
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

    // Arrange and Act
    abstractCheckoutController.getBaseConfirmationView();
  }

  /**
   * Test {@link AbstractCheckoutController#getConfirmationView(String)}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getConfirmationView(String)}
   */
  @Test
  @DisplayName("Test getConfirmationView(String)")
  void testGetConfirmationView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ajaxredirect:/confirmation/42", (new BroadleafBillingInfoController()).getConfirmationView("42"));
  }

  /**
   * Test {@link AbstractCheckoutController#getConfirmationView(String)}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getConfirmationView(String)}
   */
  @Test
  @DisplayName("Test getConfirmationView(String)")
  @Disabled("TODO: Complete this test")
  void testGetConfirmationView2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass893 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.AbstractCheckoutController abstractCheckoutController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
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

    // Arrange and Act
    abstractCheckoutController.getConfirmationView("42");
  }

  /**
   * Test
   * {@link AbstractCheckoutController#populateModelWithReferenceData(HttpServletRequest, Model)}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#populateModelWithReferenceData(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test populateModelWithReferenceData(HttpServletRequest, Model)")
  @Disabled("TODO: Complete this test")
  void testPopulateModelWithReferenceData() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass895 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.AbstractCheckoutController abstractCheckoutController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
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

    // Act
    abstractCheckoutController.populateModelWithReferenceData(request, new ConcurrentModel());
  }

  /**
   * Test
   * {@link AbstractCheckoutController#initBinder(HttpServletRequest, ServletRequestDataBinder)}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#initBinder(HttpServletRequest, ServletRequestDataBinder)}
   */
  @Test
  @DisplayName("Test initBinder(HttpServletRequest, ServletRequestDataBinder)")
  @Disabled("TODO: Complete this test")
  void testInitBinder() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafBillingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass894 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.AbstractCheckoutController abstractCheckoutController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
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

    // Act
    abstractCheckoutController.initBinder(request, new ServletRequestDataBinder("Target", "Object Name"));
  }
}
