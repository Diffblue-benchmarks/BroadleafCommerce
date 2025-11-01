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
package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.call.AddToCartItem;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.junit.jupiter.api.Test;

class AbstractUpdateCartServiceExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}
   */
  @Test
  void testUpdateAndValidateCart() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder resultHolder = new ExtensionResultHolder();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        i18nUpdateCartServiceExtensionHandler.updateAndValidateCart(cart, resultHolder));
  }

  /**
   * Method under test:
   * {@link AbstractUpdateCartServiceExtensionHandler#validateAddToCartItem(OrderItemRequestDTO, Order)}
   */
  @Test
  void testValidateAddToCartItem() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nUpdateCartServiceExtensionHandler.validateAddToCartItem(itemRequest, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractUpdateCartServiceExtensionHandler#validateAddToCartItem(OrderItemRequestDTO, Order)}
   */
  @Test
  void testValidateAddToCartItem2() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    AddToCartItem itemRequest = mock(AddToCartItem.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nUpdateCartServiceExtensionHandler.validateAddToCartItem(itemRequest, new NullOrderImpl()));
  }
}
