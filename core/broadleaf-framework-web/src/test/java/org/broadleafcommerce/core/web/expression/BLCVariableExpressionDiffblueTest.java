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
package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BLCVariableExpressionDiffblueTest {
  /**
   * Method under test: {@link BLCVariableExpression#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("blc", (new BLCVariableExpression()).getName());
  }

  /**
   * Method under test: {@link BLCVariableExpression#getCurrentUrl()}
   */
  @Test
  void testGetCurrentUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new BLCVariableExpression()).getCurrentUrl());
  }

  /**
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  void testGetPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("$10.00", (new BLCVariableExpression()).getPrice("10"));
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("U"));
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("Amount"));
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("USD"));
    assertEquals("$42.00", (new BLCVariableExpression()).getPrice("42"));
    assertEquals("$10.00", (new BLCVariableExpression()).getPrice("10U"));
    assertEquals("$10.00", (new BLCVariableExpression()).getPrice("10[^\\d.]+"));
    assertEquals("$10.00", (new BLCVariableExpression()).getPrice("10true"));
    assertEquals("$10.00", (new BLCVariableExpression()).getPrice("10currency.default"));
    assertEquals("$10.00", (new BLCVariableExpression()).getPrice("10Amount"));
    assertEquals("$10.00", (new BLCVariableExpression()).getPrice("10USD"));
    assertEquals("$10.00", (new BLCVariableExpression()).getPrice("U10"));
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("UU"));
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("Utrue"));
    assertEquals("$10.00", (new PromotionMessageVariableExpression()).getPrice("Amount10"));
    assertEquals("$ 0.00", (new PromotionMessageVariableExpression()).getPrice("AmountAmount"));
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("UAmount"));
    assertEquals("$42.00", (new PromotionMessageVariableExpression()).getPrice("Amount42"));
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("UUSD"));
    assertEquals("$42.00", (new BLCVariableExpression()).getPrice("U42"));
    assertEquals("$42.00", (new PromotionMessageVariableExpression()).getPrice("42Amount"));
    assertEquals("$0.10", (new BLCVariableExpression()).getPrice("[^\\d.]+10"));
    assertEquals("$1,010.00", (new PromotionMessageVariableExpression()).getPrice("1010Amount"));
    assertEquals("$1,010.00", (new PromotionMessageVariableExpression()).getPrice("10Amount10"));
    assertEquals("$10.00", (new PromotionMessageVariableExpression()).getPrice("10AmountAmount"));
    assertEquals("$1,042.00", (new PromotionMessageVariableExpression()).getPrice("10Amount42"));
    assertEquals("$0.42", (new BLCVariableExpression()).getPrice("[^\\d.]+42"));
  }

  /**
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  void testGetPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCVariableExpression blcVariableExpression = new BLCVariableExpression();

    // Act and Assert
    assertEquals("$ 0.00", blcVariableExpression.getPrice(Boolean.TRUE.toString()));
  }
}
