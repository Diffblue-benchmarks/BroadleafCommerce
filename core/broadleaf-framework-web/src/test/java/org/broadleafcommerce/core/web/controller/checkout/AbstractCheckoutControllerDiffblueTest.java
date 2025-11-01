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
import org.junit.jupiter.api.Test;

class AbstractCheckoutControllerDiffblueTest {
  /**
   * Method under test: {@link AbstractCheckoutController#getCartPageRedirect()}
   */
  @Test
  void testGetCartPageRedirect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/cart", (new BroadleafBillingInfoController()).getCartPageRedirect());
  }

  /**
   * Method under test: {@link AbstractCheckoutController#getCheckoutView()}
   */
  @Test
  void testGetCheckoutView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("checkout/checkout", (new BroadleafBillingInfoController()).getCheckoutView());
  }

  /**
   * Method under test:
   * {@link AbstractCheckoutController#getCheckoutStagesPartial()}
   */
  @Test
  void testGetCheckoutStagesPartial() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("checkout/partials/checkoutStages", (new BroadleafBillingInfoController()).getCheckoutStagesPartial());
  }

  /**
   * Method under test:
   * {@link AbstractCheckoutController#getCheckoutPageRedirect()}
   */
  @Test
  void testGetCheckoutPageRedirect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/checkout", (new BroadleafBillingInfoController()).getCheckoutPageRedirect());
  }

  /**
   * Method under test:
   * {@link AbstractCheckoutController#getBaseConfirmationView()}
   */
  @Test
  void testGetBaseConfirmationView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ajaxredirect:/confirmation", (new BroadleafBillingInfoController()).getBaseConfirmationView());
  }

  /**
   * Method under test:
   * {@link AbstractCheckoutController#getConfirmationView(String)}
   */
  @Test
  void testGetConfirmationView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ajaxredirect:/confirmation/42", (new BroadleafBillingInfoController()).getConfirmationView("42"));
  }
}
