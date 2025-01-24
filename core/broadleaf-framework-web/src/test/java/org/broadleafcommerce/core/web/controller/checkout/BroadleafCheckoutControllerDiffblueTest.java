package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.core.checkout.service.CheckoutService;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
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
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ContextConfiguration(classes = {BroadleafCheckoutController.class})
@ExtendWith(SpringExtension.class)
class BroadleafCheckoutControllerDiffblueTest {
  @MockBean
  private AddressService addressService;

  @MockBean(name = "blBillingInfoFormValidator")
  private BillingInfoFormValidator billingInfoFormValidator;

  @Autowired
  private BroadleafCheckoutController broadleafCheckoutController;

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
   * {@link BroadleafCheckoutController#checkout(HttpServletRequest, HttpServletResponse, Model, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#checkout(HttpServletRequest, HttpServletResponse, Model, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test checkout(HttpServletRequest, HttpServletResponse, Model, RedirectAttributes)")
  @Disabled("TODO: Complete this test")
  void testCheckout() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass898 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController broadleafCheckoutController;
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

    // Act
    broadleafCheckoutController.checkout(request, response, model, new RedirectAttributesModelMap());
  }

  /**
   * Test {@link BroadleafCheckoutController#preValidateCartOperation(Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#preValidateCartOperation(Model)}
   */
  @Test
  @DisplayName("Test preValidateCartOperation(Model)")
  @Disabled("TODO: Complete this test")
  void testPreValidateCartOperation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass903 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController broadleafCheckoutController;
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
    broadleafCheckoutController.preValidateCartOperation(new ConcurrentModel());
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)")
  void testGetCheckoutStagePartial() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCheckoutController broadleafCheckoutController = new BroadleafCheckoutController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualCheckoutStagePartial = broadleafCheckoutController.getCheckoutStagePartial(request, response, model,
        "Stage", new RedirectAttributesModelMap());

    // Assert
    assertEquals(1, model.size());
    assertEquals("Stage", model.get("activeStage"));
    assertEquals("checkout/partials/checkoutStages", actualCheckoutStagePartial);
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)")
  void testGetCheckoutStagePartial2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCheckoutController broadleafCheckoutController = new BroadleafCheckoutController();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualCheckoutStagePartial = broadleafCheckoutController.getCheckoutStagePartial(request, response, model,
        "Stage", new RedirectAttributesModelMap());

    // Assert
    assertEquals(1, model.size());
    assertEquals("Stage", model.get("activeStage"));
    assertEquals("checkout/partials/checkoutStages", actualCheckoutStagePartial);
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)")
  @Disabled("TODO: Complete this test")
  void testGetCheckoutStagePartial3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass899 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController broadleafCheckoutController;
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

    // Act
    broadleafCheckoutController.getCheckoutStagePartial(request, response, model, "Stage",
        new RedirectAttributesModelMap());
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm, BindingResult)")
  @Disabled("TODO: Complete this test")
  void testSaveGlobalOrderDetails() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass906 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController broadleafCheckoutController;
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
    ConcurrentModel model = new ConcurrentModel();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main St");

    // Act
    broadleafCheckoutController.saveGlobalOrderDetails(request, model, orderInfoForm,
        new BindException("Target", "Object Name"));
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#processPassthroughCheckout(RedirectAttributes, PaymentType)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#processPassthroughCheckout(RedirectAttributes, PaymentType)}
   */
  @Test
  @DisplayName("Test processPassthroughCheckout(RedirectAttributes, PaymentType)")
  @Disabled("TODO: Complete this test")
  void testProcessPassthroughCheckout() throws PaymentException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass905 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController broadleafCheckoutController;
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
    RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

    // Act
    broadleafCheckoutController.processPassthroughCheckout(redirectAttributes,
        new PaymentType("Type", "Friendly Type"));
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processCompleteCheckoutOrderFinalized(RedirectAttributes)")
  @Disabled("TODO: Complete this test")
  void testProcessCompleteCheckoutOrderFinalized() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass904 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController broadleafCheckoutController;
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
    broadleafCheckoutController.processCompleteCheckoutOrderFinalized(new RedirectAttributesModelMap());
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processCompleteCheckoutOrderFinalized(RedirectAttributes); given BiFunction")
  void testProcessCompleteCheckoutOrderFinalized_givenBiFunction() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCheckoutController broadleafCheckoutController = new BroadleafCheckoutController();

    RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
    redirectAttributes.replaceAll(mock(BiFunction.class));

    // Act and Assert
    assertEquals("redirect:/checkout",
        broadleafCheckoutController.processCompleteCheckoutOrderFinalized(redirectAttributes));
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}.
   * <ul>
   *   <li>When
   * {@link RedirectAttributesModelMap#RedirectAttributesModelMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processCompleteCheckoutOrderFinalized(RedirectAttributes); when RedirectAttributesModelMap()")
  void testProcessCompleteCheckoutOrderFinalized_whenRedirectAttributesModelMap() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCheckoutController broadleafCheckoutController = new BroadleafCheckoutController();

    // Act and Assert
    assertEquals("redirect:/checkout",
        broadleafCheckoutController.processCompleteCheckoutOrderFinalized(new RedirectAttributesModelMap()));
  }

  /**
   * Test {@link BroadleafCheckoutController#initiateCheckout(Long)}.
   * <p>
   * Method under test: {@link BroadleafCheckoutController#initiateCheckout(Long)}
   */
  @Test
  @DisplayName("Test initiateCheckout(Long)")
  void testInitiateCheckout() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BroadleafCheckoutController()).initiateCheckout(1L));
  }

  /**
   * Test {@link BroadleafCheckoutController#initiateCheckout(Long)}.
   * <p>
   * Method under test: {@link BroadleafCheckoutController#initiateCheckout(Long)}
   */
  @Test
  @DisplayName("Test initiateCheckout(Long)")
  @Disabled("TODO: Complete this test")
  void testInitiateCheckout2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass902 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController broadleafCheckoutController;
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
    broadleafCheckoutController.initiateCheckout(1L);
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test handleProcessingException(Exception, RedirectAttributes)")
  @Disabled("TODO: Complete this test")
  void testHandleProcessingException() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass901 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController broadleafCheckoutController;
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
    Exception e = new Exception("foo");

    // Act
    broadleafCheckoutController.handleProcessingException(e, new RedirectAttributesModelMap());
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test handleProcessingException(Exception, RedirectAttributes); given BiFunction")
  void testHandleProcessingException_givenBiFunction() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCheckoutController broadleafCheckoutController = new BroadleafCheckoutController();
    Exception e = new Exception("foo");

    RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
    redirectAttributes.replaceAll(mock(BiFunction.class));

    // Act
    broadleafCheckoutController.handleProcessingException(e, redirectAttributes);

    // Assert that nothing has changed
    assertEquals(1, redirectAttributes.size());
    assertEquals("cart.paymentProcessingError", redirectAttributes.get("PAYMENT_PROCESSING_ERROR"));
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test handleProcessingException(Exception, RedirectAttributes); given Throwable()")
  void testHandleProcessingException_givenThrowable() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCheckoutController broadleafCheckoutController = new BroadleafCheckoutController();

    Exception e = new Exception("foo");
    e.initCause(new Throwable());
    RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

    // Act
    broadleafCheckoutController.handleProcessingException(e, redirectAttributes);

    // Assert that nothing has changed
    assertEquals(1, redirectAttributes.size());
    assertEquals("cart.paymentProcessingError", redirectAttributes.get("PAYMENT_PROCESSING_ERROR"));
  }

  /**
   * Test
   * {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}.
   * <ul>
   *   <li>When {@link Exception#Exception(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test handleProcessingException(Exception, RedirectAttributes); when Exception(String) with 'foo'")
  void testHandleProcessingException_whenExceptionWithFoo() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCheckoutController broadleafCheckoutController = new BroadleafCheckoutController();
    Exception e = new Exception("foo");
    RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

    // Act
    broadleafCheckoutController.handleProcessingException(e, redirectAttributes);

    // Assert that nothing has changed
    assertEquals(1, redirectAttributes.size());
    assertEquals("cart.paymentProcessingError", redirectAttributes.get("PAYMENT_PROCESSING_ERROR"));
  }

  /**
   * Test {@link BroadleafCheckoutController#getConfirmationViewRedirect(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#getConfirmationViewRedirect(String)}
   */
  @Test
  @DisplayName("Test getConfirmationViewRedirect(String)")
  void testGetConfirmationViewRedirect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/confirmation/42", (new BroadleafCheckoutController()).getConfirmationViewRedirect("42"));
  }

  /**
   * Test {@link BroadleafCheckoutController#getConfirmationViewRedirect(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutController#getConfirmationViewRedirect(String)}
   */
  @Test
  @DisplayName("Test getConfirmationViewRedirect(String)")
  @Disabled("TODO: Complete this test")
  void testGetConfirmationViewRedirect2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass900 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutController broadleafCheckoutController;
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
    broadleafCheckoutController.getConfirmationViewRedirect("42");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafCheckoutController}
   *   <li>{@link BroadleafCheckoutController#getBaseConfirmationRedirect()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("redirect:/confirmation", (new BroadleafCheckoutController()).getBaseConfirmationRedirect());
  }
}
