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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.exception.IllegalCartOperationException;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
import org.broadleafcommerce.core.web.checkout.validator.OrderInfoFormValidator;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
  @InjectMocks private BroadleafCheckoutController broadleafCheckoutController;

  @Mock private OrderInfoFormValidator orderInfoFormValidator;

  @Mock private OrderService orderService;

  @Mock private PaymentGatewayCheckoutService paymentGatewayCheckoutService;

  /**
   * Test {@link BroadleafCheckoutController#preValidateCartOperation(Model)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCheckoutController#preValidateCartOperation(Model)}
   */
  @Test
  @DisplayName("Test preValidateCartOperation(Model); then ConcurrentModel() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCheckoutController.preValidateCartOperation(Model)"})
  void testPreValidateCartOperation_thenConcurrentModelEmpty() {
    // Arrange
    doNothing().when(orderService).preValidateCartOperation(Mockito.<Order>any());
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCheckoutController.preValidateCartOperation(model);

    // Assert that nothing has changed
    verify(orderService).preValidateCartOperation(isNull());
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafCheckoutController#preValidateCartOperation(Model)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCheckoutController#preValidateCartOperation(Model)}
   */
  @Test
  @DisplayName("Test preValidateCartOperation(Model); then ConcurrentModel() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCheckoutController.preValidateCartOperation(Model)"})
  void testPreValidateCartOperation_thenConcurrentModelSizeIsOne() {
    // Arrange
    doThrow(mock(IllegalCartOperationException.class))
        .when(orderService)
        .preValidateCartOperation(Mockito.<Order>any());
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCheckoutController.preValidateCartOperation(model);

    // Assert
    verify(orderService).preValidateCartOperation(isNull());
    assertEquals(1, model.size());
    assertTrue((Boolean) model.get("cartRequiresLock"));
  }

  /**
   * Test {@link BroadleafCheckoutController#preValidateCartOperation(Model)}.
   *
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCheckoutController#preValidateCartOperation(Model)}
   */
  @Test
  @DisplayName(
      "Test preValidateCartOperation(Model); then throw RequiredAttributeNotProvidedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCheckoutController.preValidateCartOperation(Model)"})
  void testPreValidateCartOperation_thenThrowRequiredAttributeNotProvidedException() {
    // Arrange
    doThrow(new RequiredAttributeNotProvidedException("Attribute Name"))
        .when(orderService)
        .preValidateCartOperation(Mockito.<Order>any());

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> broadleafCheckoutController.preValidateCartOperation(new ConcurrentModel()));
    verify(orderService).preValidateCartOperation(isNull());
  }

  /**
   * Test {@link BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest,
   * HttpServletResponse, Model, String, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafCheckoutController#getCheckoutStagePartial(HttpServletRequest, HttpServletResponse,
   * Model, String, RedirectAttributes)}
   */
  @Test
  @DisplayName(
      "Test getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCheckoutController.getCheckoutStagePartial(HttpServletRequest, HttpServletResponse, Model, String, RedirectAttributes)"
  })
  void testGetCheckoutStagePartial() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualCheckoutStagePartial =
        broadleafCheckoutController.getCheckoutStagePartial(
            request, response, model, "Stage", new RedirectAttributesModelMap());

    // Assert
    assertEquals(1, model.size());
    assertEquals("Stage", model.get("activeStage"));
    assertEquals("checkout/partials/checkoutStages", actualCheckoutStagePartial);
  }

  /**
   * Test {@link BroadleafCheckoutController#saveGlobalOrderDetails(HttpServletRequest, Model,
   * OrderInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafCheckoutController#saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm,
   * BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm, BindingResult); then throw RequiredAttributeNotProvidedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCheckoutController.saveGlobalOrderDetails(HttpServletRequest, Model, OrderInfoForm, BindingResult)"
  })
  void testSaveGlobalOrderDetails_thenThrowRequiredAttributeNotProvidedException()
      throws ServiceException {
    // Arrange
    doThrow(new RequiredAttributeNotProvidedException("Attribute Name"))
        .when(orderInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ConcurrentModel model = new ConcurrentModel();

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main St");

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () ->
            broadleafCheckoutController.saveGlobalOrderDetails(
                request, model, orderInfoForm, new BindException("Target", "Object Name")));
    verify(orderInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
  }

  /**
   * Test {@link
   * BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafCheckoutController#processCompleteCheckoutOrderFinalized(RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processCompleteCheckoutOrderFinalized(RedirectAttributes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCheckoutController.processCompleteCheckoutOrderFinalized(RedirectAttributes)"
  })
  void testProcessCompleteCheckoutOrderFinalized() throws PaymentException {
    // Arrange, Act and Assert
    assertEquals(
        "redirect:/checkout",
        broadleafCheckoutController.processCompleteCheckoutOrderFinalized(
            new RedirectAttributesModelMap()));
  }

  /**
   * Test {@link BroadleafCheckoutController#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Then return {@code Initiate Checkout}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCheckoutController#initiateCheckout(Long)}
   */
  @Test
  @DisplayName("Test initiateCheckout(Long); then return 'Initiate Checkout'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafCheckoutController.initiateCheckout(Long)"})
  void testInitiateCheckout_thenReturnInitiateCheckout() throws Exception {
    // Arrange
    when(paymentGatewayCheckoutService.initiateCheckout(Mockito.<Long>any()))
        .thenReturn("Initiate Checkout");

    // Act
    String actualInitiateCheckoutResult = broadleafCheckoutController.initiateCheckout(1L);

    // Assert
    verify(paymentGatewayCheckoutService).initiateCheckout(1L);
    assertEquals("Initiate Checkout", actualInitiateCheckoutResult);
  }

  /**
   * Test {@link BroadleafCheckoutController#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCheckoutController#initiateCheckout(Long)}
   */
  @Test
  @DisplayName("Test initiateCheckout(Long); then throw PricingException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafCheckoutController.initiateCheckout(Long)"})
  void testInitiateCheckout_thenThrowPricingException() throws Exception {
    // Arrange
    when(paymentGatewayCheckoutService.initiateCheckout(Mockito.<Long>any()))
        .thenThrow(new PricingException("An error occurred"));

    // Act and Assert
    assertThrows(PricingException.class, () -> broadleafCheckoutController.initiateCheckout(1L));
    verify(paymentGatewayCheckoutService).initiateCheckout(1L);
  }

  /**
   * Test {@link BroadleafCheckoutController#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCheckoutController#initiateCheckout(Long)}
   */
  @Test
  @DisplayName("Test initiateCheckout(Long); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafCheckoutController.initiateCheckout(Long)"})
  void testInitiateCheckout_whenNull_thenReturnNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(broadleafCheckoutController.initiateCheckout(null));
  }

  /**
   * Test {@link BroadleafCheckoutController#handleProcessingException(Exception,
   * RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCheckoutController#handleProcessingException(Exception,
   * RedirectAttributes)}
   */
  @Test
  @DisplayName("Test handleProcessingException(Exception, RedirectAttributes); given Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCheckoutController.handleProcessingException(Exception, RedirectAttributes)"
  })
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
   * Test {@link BroadleafCheckoutController#handleProcessingException(Exception,
   * RedirectAttributes)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCheckoutController#handleProcessingException(Exception,
   * RedirectAttributes)}
   */
  @Test
  @DisplayName("Test handleProcessingException(Exception, RedirectAttributes); when Exception()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCheckoutController.handleProcessingException(Exception, RedirectAttributes)"
  })
  void testHandleProcessingException_whenException() throws PaymentException {
    // Arrange
    Exception e = new Exception();
    RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

    // Act
    broadleafCheckoutController.handleProcessingException(e, redirectAttributes);

    // Assert
    assertEquals(1, redirectAttributes.size());
    assertEquals("cart.paymentProcessingError", redirectAttributes.get("PAYMENT_PROCESSING_ERROR"));
  }

  /**
   * Test {@link BroadleafCheckoutController#getConfirmationViewRedirect(String)}.
   *
   * <p>Method under test: {@link BroadleafCheckoutController#getConfirmationViewRedirect(String)}
   */
  @Test
  @DisplayName("Test getConfirmationViewRedirect(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafCheckoutController.getConfirmationViewRedirect(String)"})
  void testGetConfirmationViewRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "redirect:/confirmation/42", broadleafCheckoutController.getConfirmationViewRedirect("42"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafCheckoutController}
   *   <li>{@link BroadleafCheckoutController#getBaseConfirmationRedirect()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCheckoutController.<init>()",
    "String BroadleafCheckoutController.getBaseConfirmationRedirect()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "redirect:/confirmation", new BroadleafCheckoutController().getBaseConfirmationRedirect());
  }
}
