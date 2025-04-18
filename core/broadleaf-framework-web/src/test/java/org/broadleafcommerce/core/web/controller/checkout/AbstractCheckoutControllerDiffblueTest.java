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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.core.checkout.service.CheckoutService;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
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
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;

@ExtendWith(MockitoExtension.class)
class AbstractCheckoutControllerDiffblueTest {
  @Mock
  private AddressService addressService;

  @InjectMocks
  private BroadleafBillingInfoController broadleafBillingInfoController;

  @Mock
  private BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;

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
   * Test {@link AbstractCheckoutController#getCartPageRedirect()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getCartPageRedirect()}
   */
  @Test
  @DisplayName("Test getCartPageRedirect()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractCheckoutController.getCartPageRedirect()"})
  void testGetCartPageRedirect() {
    // Arrange, Act and Assert
    assertEquals("redirect:/cart", (new BroadleafBillingInfoController()).getCartPageRedirect());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutView()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getCheckoutView()}
   */
  @Test
  @DisplayName("Test getCheckoutView()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractCheckoutController.getCheckoutView()"})
  void testGetCheckoutView() {
    // Arrange, Act and Assert
    assertEquals("checkout/checkout", (new BroadleafBillingInfoController()).getCheckoutView());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutStagesPartial()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getCheckoutStagesPartial()}
   */
  @Test
  @DisplayName("Test getCheckoutStagesPartial()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractCheckoutController.getCheckoutStagesPartial()"})
  void testGetCheckoutStagesPartial() {
    // Arrange, Act and Assert
    assertEquals("checkout/partials/checkoutStages", (new BroadleafBillingInfoController()).getCheckoutStagesPartial());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutPageRedirect()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getCheckoutPageRedirect()}
   */
  @Test
  @DisplayName("Test getCheckoutPageRedirect()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractCheckoutController.getCheckoutPageRedirect()"})
  void testGetCheckoutPageRedirect() {
    // Arrange, Act and Assert
    assertEquals("redirect:/checkout", (new BroadleafBillingInfoController()).getCheckoutPageRedirect());
  }

  /**
   * Test {@link AbstractCheckoutController#getBaseConfirmationView()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getBaseConfirmationView()}
   */
  @Test
  @DisplayName("Test getBaseConfirmationView()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractCheckoutController.getBaseConfirmationView()"})
  void testGetBaseConfirmationView() {
    // Arrange, Act and Assert
    assertEquals("ajaxredirect:/confirmation", (new BroadleafBillingInfoController()).getBaseConfirmationView());
  }

  /**
   * Test {@link AbstractCheckoutController#getConfirmationView(String)}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getConfirmationView(String)}
   */
  @Test
  @DisplayName("Test getConfirmationView(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractCheckoutController.getConfirmationView(String)"})
  void testGetConfirmationView() {
    // Arrange, Act and Assert
    assertEquals("ajaxredirect:/confirmation/42", (new BroadleafBillingInfoController()).getConfirmationView("42"));
  }

  /**
   * Test {@link AbstractCheckoutController#populateModelWithReferenceData(HttpServletRequest, Model)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCheckoutController#populateModelWithReferenceData(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test populateModelWithReferenceData(HttpServletRequest, Model); then calls getProxy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCheckoutController.populateModelWithReferenceData(HttpServletRequest, Model)"})
  void testPopulateModelWithReferenceData_thenCallsGetProxy() {
    // Arrange
    BroadleafCheckoutControllerExtensionHandler broadleafCheckoutControllerExtensionHandler = mock(
        BroadleafCheckoutControllerExtensionHandler.class);
    when(broadleafCheckoutControllerExtensionHandler.addAdditionalModelVariables(Mockito.<Model>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(broadleafCheckoutControllerExtensionManager.getProxy())
        .thenReturn(broadleafCheckoutControllerExtensionHandler);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    broadleafBillingInfoController.populateModelWithReferenceData(request, new ConcurrentModel());

    // Assert
    verify(broadleafCheckoutControllerExtensionManager).getProxy();
    verify(broadleafCheckoutControllerExtensionHandler).addAdditionalModelVariables(isA(Model.class));
  }

  /**
   * Test {@link AbstractCheckoutController#initBinder(HttpServletRequest, ServletRequestDataBinder)}.
   * <ul>
   *   <li>Then calls {@link InitBinderService#configAddressInitBinder(ServletRequestDataBinder)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCheckoutController#initBinder(HttpServletRequest, ServletRequestDataBinder)}
   */
  @Test
  @DisplayName("Test initBinder(HttpServletRequest, ServletRequestDataBinder); then calls configAddressInitBinder(ServletRequestDataBinder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCheckoutController.initBinder(HttpServletRequest, ServletRequestDataBinder)"})
  void testInitBinder_thenCallsConfigAddressInitBinder() throws Exception {
    // Arrange
    doNothing().when(initBinderService).configAddressInitBinder(Mockito.<ServletRequestDataBinder>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    broadleafBillingInfoController.initBinder(request, new ServletRequestDataBinder("Target", "Object Name"));

    // Assert
    verify(initBinderService).configAddressInitBinder(isA(ServletRequestDataBinder.class));
  }
}
