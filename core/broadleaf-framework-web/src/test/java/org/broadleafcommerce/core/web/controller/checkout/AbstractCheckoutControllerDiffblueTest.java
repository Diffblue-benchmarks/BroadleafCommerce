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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.service.InitBinderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;

@ExtendWith(MockitoExtension.class)
class AbstractCheckoutControllerDiffblueTest {
  @InjectMocks private BroadleafBillingInfoController broadleafBillingInfoController;

  @Mock
  private BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;

  @Mock private InitBinderService initBinderService;

  /**
   * Test {@link AbstractCheckoutController#getCartPageRedirect()}.
   *
   * <p>Method under test: {@link AbstractCheckoutController#getCartPageRedirect()}
   */
  @Test
  @DisplayName("Test getCartPageRedirect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getCartPageRedirect()"})
  void testGetCartPageRedirect() {
    // Arrange, Act and Assert
    assertEquals("redirect:/cart", new BroadleafBillingInfoController().getCartPageRedirect());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutView()}.
   *
   * <p>Method under test: {@link AbstractCheckoutController#getCheckoutView()}
   */
  @Test
  @DisplayName("Test getCheckoutView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getCheckoutView()"})
  void testGetCheckoutView() {
    // Arrange, Act and Assert
    assertEquals("checkout/checkout", new BroadleafBillingInfoController().getCheckoutView());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutStagesPartial()}.
   *
   * <p>Method under test: {@link AbstractCheckoutController#getCheckoutStagesPartial()}
   */
  @Test
  @DisplayName("Test getCheckoutStagesPartial()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getCheckoutStagesPartial()"})
  void testGetCheckoutStagesPartial() {
    // Arrange, Act and Assert
    assertEquals(
        "checkout/partials/checkoutStages",
        new BroadleafBillingInfoController().getCheckoutStagesPartial());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutPageRedirect()}.
   *
   * <p>Method under test: {@link AbstractCheckoutController#getCheckoutPageRedirect()}
   */
  @Test
  @DisplayName("Test getCheckoutPageRedirect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getCheckoutPageRedirect()"})
  void testGetCheckoutPageRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "redirect:/checkout", new BroadleafBillingInfoController().getCheckoutPageRedirect());
  }

  /**
   * Test {@link AbstractCheckoutController#getBaseConfirmationView()}.
   *
   * <p>Method under test: {@link AbstractCheckoutController#getBaseConfirmationView()}
   */
  @Test
  @DisplayName("Test getBaseConfirmationView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getBaseConfirmationView()"})
  void testGetBaseConfirmationView() {
    // Arrange, Act and Assert
    assertEquals(
        "ajaxredirect:/confirmation",
        new BroadleafBillingInfoController().getBaseConfirmationView());
  }

  /**
   * Test {@link AbstractCheckoutController#getConfirmationView(String)}.
   *
   * <p>Method under test: {@link AbstractCheckoutController#getConfirmationView(String)}
   */
  @Test
  @DisplayName("Test getConfirmationView(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getConfirmationView(String)"})
  void testGetConfirmationView() {
    // Arrange, Act and Assert
    assertEquals(
        "ajaxredirect:/confirmation/42",
        new BroadleafBillingInfoController().getConfirmationView("42"));
  }

  /**
   * Test {@link AbstractCheckoutController#populateModelWithReferenceData(HttpServletRequest,
   * Model)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCheckoutControllerExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCheckoutController#populateModelWithReferenceData(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName(
      "Test populateModelWithReferenceData(HttpServletRequest, Model); then calls getProxy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCheckoutController.populateModelWithReferenceData(HttpServletRequest, Model)"
  })
  void testPopulateModelWithReferenceData_thenCallsGetProxy() {
    // Arrange
    BroadleafCheckoutControllerExtensionHandler broadleafCheckoutControllerExtensionHandler =
        mock(BroadleafCheckoutControllerExtensionHandler.class);
    when(broadleafCheckoutControllerExtensionHandler.addAdditionalModelVariables(
            Mockito.<Model>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(broadleafCheckoutControllerExtensionManager.getProxy())
        .thenReturn(broadleafCheckoutControllerExtensionHandler);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafBillingInfoController.populateModelWithReferenceData(request, new ConcurrentModel());

    // Assert
    verify(broadleafCheckoutControllerExtensionManager).getProxy();
    verify(broadleafCheckoutControllerExtensionHandler)
        .addAdditionalModelVariables(isA(Model.class));
  }

  /**
   * Test {@link AbstractCheckoutController#initBinder(HttpServletRequest,
   * ServletRequestDataBinder)}.
   *
   * <ul>
   *   <li>Then calls {@link InitBinderService#configAddressInitBinder(ServletRequestDataBinder)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCheckoutController#initBinder(HttpServletRequest,
   * ServletRequestDataBinder)}
   */
  @Test
  @DisplayName(
      "Test initBinder(HttpServletRequest, ServletRequestDataBinder); then calls configAddressInitBinder(ServletRequestDataBinder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCheckoutController.initBinder(HttpServletRequest, ServletRequestDataBinder)"
  })
  void testInitBinder_thenCallsConfigAddressInitBinder() throws Exception {
    // Arrange
    doNothing()
        .when(initBinderService)
        .configAddressInitBinder(Mockito.<ServletRequestDataBinder>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafBillingInfoController.initBinder(
        request, new ServletRequestDataBinder("Target", "Object Name"));

    // Assert
    verify(initBinderService).configAddressInitBinder(isA(ServletRequestDataBinder.class));
  }
}
