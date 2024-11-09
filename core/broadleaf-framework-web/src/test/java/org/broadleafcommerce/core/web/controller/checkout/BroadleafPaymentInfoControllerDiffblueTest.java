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

class BroadleafPaymentInfoControllerDiffblueTest {
  /**
   * Test new {@link BroadleafPaymentInfoController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafPaymentInfoController}
   */
  @Test
  @DisplayName("Test new BroadleafPaymentInfoController (default constructor)")
  void testNewBroadleafPaymentInfoController() {
    // Arrange and Act
    BroadleafPaymentInfoController actualBroadleafPaymentInfoController = new BroadleafPaymentInfoController();

    // Assert
    assertEquals("ajaxredirect:/confirmation", actualBroadleafPaymentInfoController.getBaseConfirmationView());
    assertEquals("checkout/checkout", actualBroadleafPaymentInfoController.getCheckoutView());
    assertEquals("checkout/partials/checkoutStages", actualBroadleafPaymentInfoController.getCheckoutStagesPartial());
    assertEquals("redirect:/cart", actualBroadleafPaymentInfoController.getCartPageRedirect());
    assertEquals("redirect:/checkout", actualBroadleafPaymentInfoController.getCheckoutPageRedirect());
    assertNull(actualBroadleafPaymentInfoController.isoService);
    assertNull(actualBroadleafPaymentInfoController.paymentGatewayCheckoutService);
    assertNull(actualBroadleafPaymentInfoController.checkoutService);
    assertNull(actualBroadleafPaymentInfoController.fulfillmentGroupService);
    assertNull(actualBroadleafPaymentInfoController.fulfillmentOptionService);
    assertNull(actualBroadleafPaymentInfoController.orderMultishipOptionService);
    assertNull(actualBroadleafPaymentInfoController.orderService);
    assertNull(actualBroadleafPaymentInfoController.orderPaymentService);
    assertNull(actualBroadleafPaymentInfoController.dtoTranslationService);
    assertNull(actualBroadleafPaymentInfoController.billingInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.paymentInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.giftCardInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.multishipAddAddressFormValidator);
    assertNull(actualBroadleafPaymentInfoController.orderInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.shippingInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.checkoutControllerExtensionManager);
    assertNull(actualBroadleafPaymentInfoController.cartStateService);
    assertNull(actualBroadleafPaymentInfoController.savedPaymentService);
    assertNull(actualBroadleafPaymentInfoController.initBinderService);
    assertNull(actualBroadleafPaymentInfoController.addressService);
    assertNull(actualBroadleafPaymentInfoController.countryService);
    assertNull(actualBroadleafPaymentInfoController.countrySubdivisionService);
    assertNull(actualBroadleafPaymentInfoController.customerAddressService);
    assertNull(actualBroadleafPaymentInfoController.customerPaymentService);
    assertNull(actualBroadleafPaymentInfoController.customerService);
    assertNull(actualBroadleafPaymentInfoController.phoneService);
    assertNull(actualBroadleafPaymentInfoController.stateService);
  }
}
