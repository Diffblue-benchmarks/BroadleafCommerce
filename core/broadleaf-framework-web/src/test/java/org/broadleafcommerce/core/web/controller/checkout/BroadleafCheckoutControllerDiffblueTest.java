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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.core.checkout.service.CheckoutService;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
import org.broadleafcommerce.core.web.checkout.validator.OrderInfoFormValidator;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ExtendWith(MockitoExtension.class)
class BroadleafCheckoutControllerDiffblueTest {
  @Mock
  private AddressService addressService;

  @InjectMocks
  private BroadleafCheckoutController broadleafCheckoutController;

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
  private OrderInfoFormValidator orderInfoFormValidator;

  @Mock
  private OrderMultishipOptionService orderMultishipOptionService;

  @Mock
  private OrderPaymentService orderPaymentService;

  @Mock
  private OrderService orderService;

  @Mock
  private OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;

  @Mock
  private PaymentGatewayCheckoutService paymentGatewayCheckoutService;

  @Mock
  private PhoneService phoneService;

  @Mock
  private StateService stateService;

  /**
   * Test {@link BroadleafCheckoutController#preValidateCartOperation(Model)}.
   * <p>
   * Method under test: {@link BroadleafCheckoutController#preValidateCartOperation(Model)}
   */
  @Test
  @DisplayName("Test preValidateCartOperation(Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCheckoutController.preValidateCartOperation(Model)"})
  void testPreValidateCartOperation() {
    // Arrange
    doNothing().when(orderService).preValidateCartOperation(Mockito.<Order>any());

    // Act
    broadleafCheckoutController.preValidateCartOperation(new ConcurrentModel());

    // Assert
    verify(orderService).preValidateCartOperation(isNull());
  }

  /**
   * Test {@link BroadleafCheckoutController#preValidateCartOperation(Model)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCheckoutController#preValidateCartOperation(Model)}
   */
  @Test
  @DisplayName("Test preValidateCartOperation(Model); then throw RequiredAttributeNotProvidedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCheckoutController.preValidateCartOperation(Model)"})
  void testPreValidateCartOperation_thenThrowRequiredAttributeNotProvidedException() {
    // Arrange
    doThrow(new RequiredAttributeNotProvidedException("ThreadLocalManager.notify.orphans")).when(orderService)
        .preValidateCartOperation(Mockito.<Order>any());

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> broadleafCheckoutController.preValidateCartOperation(new ConcurrentModel()));
    verify(orderService).preValidateCartOperation(isNull());
  }

  /**
   * Test {@link BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)}.
   * <p>
   * Method under test: {@link BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCheckoutController.getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)"})
  void testGetCheckoutStagePartial() {
    // Arrange
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
   * Test {@link BroadleafCheckoutController#saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm, BindingResult)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCheckoutController#saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm, BindingResult); then throw RequiredAttributeNotProvidedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCheckoutController.saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm, BindingResult)"})
  void testSaveGlobalOrderDetails_thenThrowRequiredAttributeNotProvidedException() throws ServiceException {
    // Arrange
    doThrow(new RequiredAttributeNotProvidedException("ThreadLocalManager.notify.orphans")).when(orderInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main St");

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class, () -> broadleafCheckoutController
        .saveGlobalOrderDetails(request, model, orderInfoForm, new BindException("Target", "Object Name")));
    verify(orderInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
  }

  /**
   * Test {@link BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}.
   * <p>
   * Method under test: {@link BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processCompleteCheckoutOrderFinalized(RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCheckoutController.processCompleteCheckoutOrderFinalized(RedirectAttributes)"})
  void testProcessCompleteCheckoutOrderFinalized() throws PaymentException {
    // Arrange, Act and Assert
    assertEquals("redirect:/checkout",
        broadleafCheckoutController.processCompleteCheckoutOrderFinalized(new RedirectAttributesModelMap()));
  }

  /**
   * Test {@link BroadleafCheckoutController#initiateCheckout(Long)}.
   * <ul>
   *   <li>Then return {@code Initiate Checkout}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCheckoutController#initiateCheckout(Long)}
   */
  @Test
  @DisplayName("Test initiateCheckout(Long); then return 'Initiate Checkout'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCheckoutController.initiateCheckout(Long)"})
  void testInitiateCheckout_thenReturnInitiateCheckout() throws Exception {
    // Arrange
    when(paymentGatewayCheckoutService.initiateCheckout(Mockito.<Long>any())).thenReturn("Initiate Checkout");

    // Act
    String actualInitiateCheckoutResult = broadleafCheckoutController.initiateCheckout(1L);

    // Assert
    verify(paymentGatewayCheckoutService).initiateCheckout(eq(1L));
    assertEquals("Initiate Checkout", actualInitiateCheckoutResult);
  }

  /**
   * Test {@link BroadleafCheckoutController#initiateCheckout(Long)}.
   * <ul>
   *   <li>Then throw {@link PricingException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCheckoutController#initiateCheckout(Long)}
   */
  @Test
  @DisplayName("Test initiateCheckout(Long); then throw PricingException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCheckoutController.initiateCheckout(Long)"})
  void testInitiateCheckout_thenThrowPricingException() throws Exception {
    // Arrange
    when(paymentGatewayCheckoutService.initiateCheckout(Mockito.<Long>any()))
        .thenThrow(new PricingException("An error occurred"));

    // Act and Assert
    assertThrows(PricingException.class, () -> broadleafCheckoutController.initiateCheckout(1L));
    verify(paymentGatewayCheckoutService).initiateCheckout(eq(1L));
  }

  /**
   * Test {@link BroadleafCheckoutController#initiateCheckout(Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCheckoutController#initiateCheckout(Long)}
   */
  @Test
  @DisplayName("Test initiateCheckout(Long); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCheckoutController.initiateCheckout(Long)"})
  void testInitiateCheckout_whenNull_thenReturnNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(broadleafCheckoutController.initiateCheckout(null));
  }

  /**
   * Test {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test handleProcessingException(Exception, RedirectAttributes); given Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCheckoutController.handleProcessingException(Exception, RedirectAttributes)"})
  void testHandleProcessingException_givenThrowable() throws PaymentException {
    // Arrange
    Exception e = new Exception("foo");
    e.initCause(new Throwable());
    RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

    // Act
    broadleafCheckoutController.handleProcessingException(e, redirectAttributes);

    // Assert
    assertEquals(1, redirectAttributes.size());
    assertEquals("cart.paymentProcessingError", redirectAttributes.get("PAYMENT_PROCESSING_ERROR"));
  }

  /**
   * Test {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}.
   * <ul>
   *   <li>When {@link Exception#Exception(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCheckoutController#handleProcessingException(Exception, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test handleProcessingException(Exception, RedirectAttributes); when Exception(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCheckoutController.handleProcessingException(Exception, RedirectAttributes)"})
  void testHandleProcessingException_whenExceptionWithFoo() throws PaymentException {
    // Arrange
    Exception e = new Exception("foo");
    RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

    // Act
    broadleafCheckoutController.handleProcessingException(e, redirectAttributes);

    // Assert
    assertEquals(1, redirectAttributes.size());
    assertEquals("cart.paymentProcessingError", redirectAttributes.get("PAYMENT_PROCESSING_ERROR"));
  }

  /**
   * Test {@link BroadleafCheckoutController#getConfirmationViewRedirect(String)}.
   * <p>
   * Method under test: {@link BroadleafCheckoutController#getConfirmationViewRedirect(String)}
   */
  @Test
  @DisplayName("Test getConfirmationViewRedirect(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCheckoutController.getConfirmationViewRedirect(String)"})
  void testGetConfirmationViewRedirect() {
    // Arrange, Act and Assert
    assertEquals("redirect:/confirmation/42", broadleafCheckoutController.getConfirmationViewRedirect("42"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafCheckoutController}
   *   <li>{@link BroadleafCheckoutController#getBaseConfirmationRedirect()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCheckoutController.<init>()",
      "String BroadleafCheckoutController.getBaseConfirmationRedirect()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("redirect:/confirmation", (new BroadleafCheckoutController()).getBaseConfirmationRedirect());
  }
}
