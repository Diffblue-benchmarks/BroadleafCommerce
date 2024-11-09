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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractCheckoutControllerDiffblueTest {
  /**
   * Test {@link AbstractCheckoutController#getCartPageRedirect()}.
   * <p>
   * Method under test: {@link AbstractCheckoutController#getCartPageRedirect()}
   */
  @Test
  @DisplayName("Test getCartPageRedirect()")
  void testGetCartPageRedirect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  void testGetCheckoutView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("checkout/checkout", (new BroadleafBillingInfoController()).getCheckoutView());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutStagesPartial()}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getCheckoutStagesPartial()}
   */
  @Test
  @DisplayName("Test getCheckoutStagesPartial()")
  void testGetCheckoutStagesPartial() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("checkout/partials/checkoutStages", (new BroadleafBillingInfoController()).getCheckoutStagesPartial());
  }

  /**
   * Test {@link AbstractCheckoutController#getCheckoutPageRedirect()}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getCheckoutPageRedirect()}
   */
  @Test
  @DisplayName("Test getCheckoutPageRedirect()")
  void testGetCheckoutPageRedirect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/checkout", (new BroadleafBillingInfoController()).getCheckoutPageRedirect());
  }

  /**
   * Test {@link AbstractCheckoutController#getBaseConfirmationView()}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getBaseConfirmationView()}
   */
  @Test
  @DisplayName("Test getBaseConfirmationView()")
  void testGetBaseConfirmationView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ajaxredirect:/confirmation", (new BroadleafBillingInfoController()).getBaseConfirmationView());
  }

  /**
   * Test {@link AbstractCheckoutController#getConfirmationView(String)}.
   * <p>
   * Method under test:
   * {@link AbstractCheckoutController#getConfirmationView(String)}
   */
  @Test
  @DisplayName("Test getConfirmationView(String)")
  void testGetConfirmationView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ajaxredirect:/confirmation/42", (new BroadleafBillingInfoController()).getConfirmationView("42"));
  }
}
