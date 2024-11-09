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
import java.util.List;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentMethodVariableExpressionDiffblueTest {
  /**
   * Test {@link PaymentMethodVariableExpression#getName()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("paymentMethod", (new PaymentMethodVariableExpression()).getName());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}
   */
  @Test
  @DisplayName("Test getPaymentRequestDTO()")
  void testGetPaymentRequestDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PaymentMethodVariableExpression()).getPaymentRequestDTO());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when NullOrderImpl (default constructor); then return 'true'")
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression = new PaymentMethodVariableExpression();

    // Act and Assert
    assertTrue(paymentMethodVariableExpression.isNullOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when NullOrderImpl; then return 'true'")
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PaymentMethodVariableExpression()).isNullOrder(mock(NullOrderImpl.class)));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when 'null'; then return 'true'")
  void testIsNullOrder_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PaymentMethodVariableExpression()).isNullOrder(null));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when OrderImpl (default constructor); then return 'false'")
  void testIsNullOrder_whenOrderImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression = new PaymentMethodVariableExpression();

    // Act and Assert
    assertFalse(paymentMethodVariableExpression.isNullOrder(new OrderImpl()));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}
   */
  @Test
  @DisplayName("Test getExpirationMonthOptions()")
  void testGetExpirationMonthOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<String> actualExpirationMonthOptions = (new PaymentMethodVariableExpression()).getExpirationMonthOptions();

    // Assert
    assertEquals(12, actualExpirationMonthOptions.size());
    assertEquals("01 - January", actualExpirationMonthOptions.get(0));
    assertEquals("02 - February", actualExpirationMonthOptions.get(1));
    assertEquals("03 - March", actualExpirationMonthOptions.get(2));
    assertEquals("04 - April", actualExpirationMonthOptions.get(3));
    assertEquals("05 - May", actualExpirationMonthOptions.get(4));
    assertEquals("06 - June", actualExpirationMonthOptions.get(5));
    assertEquals("07 - July", actualExpirationMonthOptions.get(6));
    assertEquals("08 - August", actualExpirationMonthOptions.get(7));
    assertEquals("09 - September", actualExpirationMonthOptions.get(8));
    assertEquals("10 - October", actualExpirationMonthOptions.get(9));
    assertEquals("11 - November", actualExpirationMonthOptions.get(10));
    assertEquals("12 - December", actualExpirationMonthOptions.get(11));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getExpirationYearOptions()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getExpirationYearOptions()}
   */
  @Test
  @DisplayName("Test getExpirationYearOptions()")
  void testGetExpirationYearOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10, (new PaymentMethodVariableExpression()).getExpirationYearOptions().size());
  }
}
