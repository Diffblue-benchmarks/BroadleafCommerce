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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService;
import org.broadleafcommerce.core.checkout.service.CheckoutService;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.MultiShipInstructionForm;
import org.broadleafcommerce.core.web.checkout.model.OrderMultishipOptionForm;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
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
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
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
import org.mockito.Mockito;
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

@ContextConfiguration(classes = {BroadleafShippingInfoController.class})
@ExtendWith(SpringExtension.class)
class BroadleafShippingInfoControllerDiffblueTest {
  @MockBean
  private AddressService addressService;

  @MockBean(name = "blBillingInfoFormValidator")
  private BillingInfoFormValidator billingInfoFormValidator;

  @MockBean(name = "blCheckoutControllerExtensionManager")
  private BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;

  @Autowired
  private BroadleafShippingInfoController broadleafShippingInfoController;

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
   * {@link BroadleafShippingInfoController#convertToSingleship(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#convertToSingleship(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test convertToSingleship(HttpServletRequest, HttpServletResponse, Model)")
  @Disabled("TODO: Complete this test")
  void testConvertToSingleship() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass916 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController broadleafShippingInfoController;
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

    // Act
    broadleafShippingInfoController.convertToSingleship(request, response, new ConcurrentModel());
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#saveSingleShip(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#saveSingleShip(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveSingleShip(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)")
  @Disabled("TODO: Complete this test")
  void testSaveSingleShip() throws ServiceException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass922 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController broadleafShippingInfoController;
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
    ShippingInfoForm shippingForm = new ShippingInfoForm();

    // Act
    broadleafShippingInfoController.saveSingleShip(request, response, model, shippingForm,
        new BindException("Target", "Object Name"));
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#copyBillingAddressToShippingAddress(Order, ShippingInfoForm)}.
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#copyBillingAddressToShippingAddress(Order, ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test copyBillingAddressToShippingAddress(Order, ShippingInfoForm)")
  @Disabled("TODO: Complete this test")
  void testCopyBillingAddressToShippingAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass917 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController broadleafShippingInfoController;
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

    // Act
    broadleafShippingInfoController.copyBillingAddressToShippingAddress(order, new ShippingInfoForm());
  }

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
   * {@link BroadleafShippingInfoController#showMultiship(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#showMultiship(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test showMultiship(HttpServletRequest, HttpServletResponse, Model)")
  @Disabled("TODO: Complete this test")
  void testShowMultiship() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass923 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController broadleafShippingInfoController;
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

    // Act
    broadleafShippingInfoController.showMultiship(request, response, new ConcurrentModel());
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)")
  @Disabled("TODO: Complete this test")
  void testSaveMultiship() throws ServiceException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass920 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController broadleafShippingInfoController;
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

    OrderMultishipOptionForm orderMultishipOptionForm = new OrderMultishipOptionForm();
    orderMultishipOptionForm.setOptions(new ArrayList<>());

    // Act
    broadleafShippingInfoController.saveMultiship(request, response, model, orderMultishipOptionForm,
        new BindException("Target", "Object Name"));
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)")
  @Disabled("TODO: Complete this test")
  void testShowMultishipAddAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass924 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController broadleafShippingInfoController;
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

    // Act
    broadleafShippingInfoController.showMultishipAddAddress(request, response, new ConcurrentModel());
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)")
  @Disabled("TODO: Complete this test")
  void testSaveMultishipAddAddress() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass921 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController broadleafShippingInfoController;
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
    ShippingInfoForm addressForm = new ShippingInfoForm();

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(request, response, model, addressForm,
        new BindException("Target", "Object Name"));
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#saveMultiShipInstruction(HttpServletRequest, HttpServletResponse, Model, MultiShipInstructionForm)}.
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#saveMultiShipInstruction(HttpServletRequest, HttpServletResponse, Model, MultiShipInstructionForm)}
   */
  @Test
  @DisplayName("Test saveMultiShipInstruction(HttpServletRequest, HttpServletResponse, Model, MultiShipInstructionForm)")
  @Disabled("TODO: Complete this test")
  void testSaveMultiShipInstruction() throws ServiceException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass919 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController broadleafShippingInfoController;
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

    MultiShipInstructionForm instructionForm = new MultiShipInstructionForm();
    instructionForm.setDeliveryMessage("Delivery Message");
    instructionForm.setFulfillmentGroupId(1L);
    instructionForm.setPersonalMessage(new PersonalMessageImpl());

    // Act
    broadleafShippingInfoController.saveMultiShipInstruction(request, response, model, instructionForm);
  }

  /**
   * Test
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <p>
   * Method under test:
   * {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm)")
  @Disabled("TODO: Complete this test")
  void testRemoveUnusedPhones() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass918 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blBillingInfoFormValidator") org.broadleafcommerce.core.web.checkout.validator.BillingInfoFormValidator billingInfoFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCheckoutControllerExtensionManager") org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafShippingInfoController broadleafShippingInfoController;
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
    broadleafShippingInfoController.removeUnusedPhones(new ShippingInfoForm());
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
