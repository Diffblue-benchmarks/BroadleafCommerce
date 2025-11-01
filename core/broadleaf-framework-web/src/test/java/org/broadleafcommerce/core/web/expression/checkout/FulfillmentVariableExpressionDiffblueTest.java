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
package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.junit.jupiter.api.Test;

class FulfillmentVariableExpressionDiffblueTest {
  /**
   * Method under test: {@link FulfillmentVariableExpression#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("fulfillment", (new FulfillmentVariableExpression()).getName());
  }

  /**
   * Method under test:
   * {@link FulfillmentVariableExpression#getMultiShipOptions()}
   */
  @Test
  void testGetMultiShipOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentVariableExpression()).getMultiShipOptions().isEmpty());
  }

  /**
   * Method under test:
   * {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}
   */
  @Test
  void testGetFulfillmentEstimateResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentVariableExpression()).getFulfillmentEstimateResponse());
  }

  /**
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  void testIsNullOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentVariableExpression fulfillmentVariableExpression = new FulfillmentVariableExpression();

    // Act and Assert
    assertTrue(fulfillmentVariableExpression.isNullOrder(new NullOrderImpl()));
  }

  /**
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  void testIsNullOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentVariableExpression()).isNullOrder(null));
  }

  /**
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  void testIsNullOrder3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentVariableExpression()).isNullOrder(mock(NullOrderImpl.class)));
  }

  /**
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  void testIsNullOrder4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentVariableExpression fulfillmentVariableExpression = new FulfillmentVariableExpression();

    // Act and Assert
    assertFalse(fulfillmentVariableExpression.isNullOrder(new OrderImpl()));
  }
}
