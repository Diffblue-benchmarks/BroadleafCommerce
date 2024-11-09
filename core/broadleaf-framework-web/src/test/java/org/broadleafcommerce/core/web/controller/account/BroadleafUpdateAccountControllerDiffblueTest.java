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
package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BroadleafUpdateAccountControllerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafUpdateAccountController}
   *   <li>{@link BroadleafUpdateAccountController#getAccountRedirectView()}
   *   <li>{@link BroadleafUpdateAccountController#getAccountUpdatedMessage()}
   *   <li>{@link BroadleafUpdateAccountController#getUpdateAccountView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafUpdateAccountController actualBroadleafUpdateAccountController = new BroadleafUpdateAccountController();
    String actualAccountRedirectView = actualBroadleafUpdateAccountController.getAccountRedirectView();
    String actualAccountUpdatedMessage = actualBroadleafUpdateAccountController.getAccountUpdatedMessage();

    // Assert
    assertEquals("Account successfully updated", actualAccountUpdatedMessage);
    assertEquals("account/updateAccount", actualBroadleafUpdateAccountController.getUpdateAccountView());
    assertEquals("redirect:/account", actualAccountRedirectView);
  }
}
