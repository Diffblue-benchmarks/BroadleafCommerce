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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractConfirmationControllerExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractConfirmationControllerExtensionHandler#processAdditionalConfirmationActions(Order)}.
   * <p>
   * Method under test: {@link AbstractConfirmationControllerExtensionHandler#processAdditionalConfirmationActions(Order)}
   */
  @Test
  @DisplayName("Test processAdditionalConfirmationActions(Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractConfirmationControllerExtensionHandler.processAdditionalConfirmationActions(Order)"})
  void testProcessAdditionalConfirmationActions() {
    // Arrange
    AbstractConfirmationControllerExtensionHandler abstractConfirmationControllerExtensionHandler = new AbstractConfirmationControllerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractConfirmationControllerExtensionHandler.processAdditionalConfirmationActions(new NullOrderImpl()));
  }

  /**
   * Test new {@link AbstractConfirmationControllerExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AbstractConfirmationControllerExtensionHandler}
   */
  @Test
  @DisplayName("Test new AbstractConfirmationControllerExtensionHandler (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractConfirmationControllerExtensionHandler.<init>()"})
  void testNewAbstractConfirmationControllerExtensionHandler() {
    // Arrange and Act
    AbstractConfirmationControllerExtensionHandler actualAbstractConfirmationControllerExtensionHandler = new AbstractConfirmationControllerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractConfirmationControllerExtensionHandler.getPriority());
    assertTrue(actualAbstractConfirmationControllerExtensionHandler.isEnabled());
  }
}
