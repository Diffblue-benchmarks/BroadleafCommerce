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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BroadleafBillingInfoControllerDiffblueTest {
  /**
   * Test new {@link BroadleafBillingInfoController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafBillingInfoController}
   */
  @Test
  @DisplayName("Test new BroadleafBillingInfoController (default constructor)")
  void testNewBroadleafBillingInfoController() {
    // Arrange and Act
    BroadleafBillingInfoController actualBroadleafBillingInfoController = new BroadleafBillingInfoController();

    // Assert
    assertEquals("ajaxredirect:/confirmation", actualBroadleafBillingInfoController.getBaseConfirmationView());
    assertEquals("checkout/checkout", actualBroadleafBillingInfoController.getCheckoutView());
    assertEquals("checkout/partials/checkoutStages", actualBroadleafBillingInfoController.getCheckoutStagesPartial());
    assertEquals("redirect:/cart", actualBroadleafBillingInfoController.getCartPageRedirect());
    assertEquals("redirect:/checkout", actualBroadleafBillingInfoController.getCheckoutPageRedirect());
    assertNull(actualBroadleafBillingInfoController.isoService);
    assertNull(actualBroadleafBillingInfoController.paymentGatewayCheckoutService);
    assertNull(actualBroadleafBillingInfoController.checkoutService);
    assertNull(actualBroadleafBillingInfoController.fulfillmentGroupService);
    assertNull(actualBroadleafBillingInfoController.fulfillmentOptionService);
    assertNull(actualBroadleafBillingInfoController.orderMultishipOptionService);
    assertNull(actualBroadleafBillingInfoController.orderService);
    assertNull(actualBroadleafBillingInfoController.orderPaymentService);
    assertNull(actualBroadleafBillingInfoController.dtoTranslationService);
    assertNull(actualBroadleafBillingInfoController.billingInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.paymentInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.giftCardInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.multishipAddAddressFormValidator);
    assertNull(actualBroadleafBillingInfoController.orderInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.shippingInfoFormValidator);
    assertNull(actualBroadleafBillingInfoController.checkoutControllerExtensionManager);
    assertNull(actualBroadleafBillingInfoController.cartStateService);
    assertNull(actualBroadleafBillingInfoController.initBinderService);
    assertNull(actualBroadleafBillingInfoController.addressService);
    assertNull(actualBroadleafBillingInfoController.countryService);
    assertNull(actualBroadleafBillingInfoController.countrySubdivisionService);
    assertNull(actualBroadleafBillingInfoController.customerAddressService);
    assertNull(actualBroadleafBillingInfoController.customerPaymentService);
    assertNull(actualBroadleafBillingInfoController.customerService);
    assertNull(actualBroadleafBillingInfoController.phoneService);
    assertNull(actualBroadleafBillingInfoController.stateService);
  }
}
