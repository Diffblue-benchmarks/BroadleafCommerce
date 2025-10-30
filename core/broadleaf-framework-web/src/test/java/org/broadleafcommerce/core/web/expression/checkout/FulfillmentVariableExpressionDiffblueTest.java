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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FulfillmentVariableExpressionDiffblueTest {
  @InjectMocks
  private FulfillmentVariableExpression fulfillmentVariableExpression;

  @Mock
  private FulfillmentOptionService fulfillmentOptionService;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  /**
   * Test {@link FulfillmentVariableExpression#getName()}.
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String FulfillmentVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("fulfillment", (new FulfillmentVariableExpression()).getName());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getNumShippableFulfillmentGroups()}.
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#getNumShippableFulfillmentGroups()}
   */
  @Test
  @DisplayName("Test getNumShippableFulfillmentGroups()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FulfillmentVariableExpression.getNumShippableFulfillmentGroups()"})
  void testGetNumShippableFulfillmentGroups() {
    // Arrange
    when(fulfillmentGroupService.calculateNumShippableFulfillmentGroups(Mockito.<Order>any())).thenReturn(10);

    // Act
    int actualNumShippableFulfillmentGroups = fulfillmentVariableExpression.getNumShippableFulfillmentGroups();

    // Assert
    verify(fulfillmentGroupService).calculateNumShippableFulfillmentGroups(isNull());
    assertEquals(10, actualNumShippableFulfillmentGroups);
  }

  /**
   * Test {@link FulfillmentVariableExpression#getFulfillmentOptions()}.
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#getFulfillmentOptions()}
   */
  @Test
  @DisplayName("Test getFulfillmentOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FulfillmentVariableExpression.getFulfillmentOptions()"})
  void testGetFulfillmentOptions() {
    // Arrange
    when(fulfillmentOptionService.readAllFulfillmentOptions()).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentOption> actualFulfillmentOptions = fulfillmentVariableExpression.getFulfillmentOptions();

    // Assert
    verify(fulfillmentOptionService).readAllFulfillmentOptions();
    assertTrue(actualFulfillmentOptions.isEmpty());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getMultiShipOptions()}.
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#getMultiShipOptions()}
   */
  @Test
  @DisplayName("Test getMultiShipOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FulfillmentVariableExpression.getMultiShipOptions()"})
  void testGetMultiShipOptions() {
    // Arrange, Act and Assert
    assertTrue(fulfillmentVariableExpression.getMultiShipOptions().isEmpty());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}.
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}
   */
  @Test
  @DisplayName("Test getFulfillmentEstimateResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse FulfillmentVariableExpression.getFulfillmentEstimateResponse()"})
  void testGetFulfillmentEstimateResponse() {
    // Arrange, Act and Assert
    assertNull(fulfillmentVariableExpression.getFulfillmentEstimateResponse());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FulfillmentVariableExpression.isNullOrder(Order)"})
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(fulfillmentVariableExpression.isNullOrder(new NullOrderImpl()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FulfillmentVariableExpression.isNullOrder(Order)"})
  void testIsNullOrder_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(fulfillmentVariableExpression.isNullOrder(null));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FulfillmentVariableExpression.isNullOrder(Order)"})
  void testIsNullOrder_whenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentVariableExpression.isNullOrder(new OrderImpl()));
  }
}
