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
package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FulfillmentVariableExpressionDiffblueTest {
  /**
   * Test {@link FulfillmentVariableExpression#getName()}.
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("fulfillment", (new FulfillmentVariableExpression()).getName());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getMultiShipOptions()}.
   * <p>
   * Method under test:
   * {@link FulfillmentVariableExpression#getMultiShipOptions()}
   */
  @Test
  @DisplayName("Test getMultiShipOptions()")
  void testGetMultiShipOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentVariableExpression()).getMultiShipOptions().isEmpty());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}.
   * <p>
   * Method under test:
   * {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}
   */
  @Test
  @DisplayName("Test getFulfillmentEstimateResponse()")
  void testGetFulfillmentEstimateResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentVariableExpression()).getFulfillmentEstimateResponse());
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when NullOrderImpl (default constructor); then return 'true'")
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentVariableExpression fulfillmentVariableExpression = new FulfillmentVariableExpression();

    // Act and Assert
    assertTrue(fulfillmentVariableExpression.isNullOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when NullOrderImpl; then return 'true'")
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentVariableExpression()).isNullOrder(mock(NullOrderImpl.class)));
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when 'null'; then return 'true'")
  void testIsNullOrder_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentVariableExpression()).isNullOrder(null));
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when OrderImpl (default constructor); then return 'false'")
  void testIsNullOrder_whenOrderImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentVariableExpression fulfillmentVariableExpression = new FulfillmentVariableExpression();

    // Act and Assert
    assertFalse(fulfillmentVariableExpression.isNullOrder(new OrderImpl()));
  }
}
