package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.web.service.InitBinderService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;

@RunWith(MockitoJUnitRunner.class)
public class AbstractCheckoutControllerDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getCartPageRedirect()"})
  public void testGetCartPageRedirect() {
    // Arrange, Act and Assert
    assertEquals("redirect:/cart", new BroadleafBillingInfoController().getCartPageRedirect());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutView()}.
   *
   * <p>Method under test: {@link AbstractCheckoutController#getCheckoutView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getCheckoutView()"})
  public void testGetCheckoutView() {
    // Arrange, Act and Assert
    assertEquals("checkout/checkout", new BroadleafBillingInfoController().getCheckoutView());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutStagesPartial()}.
   *
   * <p>Method under test: {@link AbstractCheckoutController#getCheckoutStagesPartial()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getCheckoutStagesPartial()"})
  public void testGetCheckoutStagesPartial() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getCheckoutPageRedirect()"})
  public void testGetCheckoutPageRedirect() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getBaseConfirmationView()"})
  public void testGetBaseConfirmationView() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCheckoutController.getConfirmationView(String)"})
  public void testGetConfirmationView() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCheckoutController.populateModelWithReferenceData(HttpServletRequest, Model)"
  })
  public void testPopulateModelWithReferenceData_thenCallsGetProxy() {
    // Arrange
    BroadleafCheckoutControllerExtensionHandler broadleafCheckoutControllerExtensionHandler =
        mock(BroadleafCheckoutControllerExtensionHandler.class);
    when(broadleafCheckoutControllerExtensionHandler.addAdditionalModelVariables(
            Mockito.<Model>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(broadleafCheckoutControllerExtensionManager.getProxy())
        .thenReturn(broadleafCheckoutControllerExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCheckoutController.initBinder(HttpServletRequest, ServletRequestDataBinder)"
  })
  public void testInitBinder_thenCallsConfigAddressInitBinder() throws Exception {
    // Arrange
    doNothing()
        .when(initBinderService)
        .configAddressInitBinder(Mockito.<ServletRequestDataBinder>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    broadleafBillingInfoController.initBinder(
        request, new ServletRequestDataBinder("Target", "Object Name"));

    // Assert
    verify(initBinderService).configAddressInitBinder(isA(ServletRequestDataBinder.class));
  }
}
