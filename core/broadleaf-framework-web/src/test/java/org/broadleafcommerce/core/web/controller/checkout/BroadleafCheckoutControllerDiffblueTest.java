/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

class BroadleafCheckoutControllerDiffblueTest {
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
