/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class BRCVariableExpressionDiffblueTest {
  /**
   * Test {@link BRCVariableExpression#getName()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("brc", (new BRCVariableExpression()).getName());
  }

  /**
   * Test {@link BRCVariableExpression#getSandbox()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#getSandbox()}
   */
  @Test
  public void testGetSandbox() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BRCVariableExpression()).getSandbox());
  }

  /**
   * Test {@link BRCVariableExpression#get(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#get(String)}
   */
  @Test
  public void testGet_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new BRCVariableExpression()).get(null));
  }

  /**
   * Test {@link BRCVariableExpression#get(String)}.
   * <ul>
   *   <li>When {@code Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#get(String)}
   */
  @Test
  public void testGet_whenPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new BRCVariableExpression()).get("Property Name"));
  }

  /**
   * Test {@link BRCVariableExpression#get(String)}.
   * <ul>
   *   <li>When {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#get(String)}
   */
  @Test
  public void testGet_whenThreadLocalManagerNotifyOrphans() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new BRCVariableExpression()).get("ThreadLocalManager.notify.orphans"));
  }

  /**
   * Test {@link BRCVariableExpression#isCsrMode()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#isCsrMode()}
   */
  @Test
  public void testIsCsrMode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BRCVariableExpression()).isCsrMode());
  }

  /**
   * Test {@link BRCVariableExpression#isQuoteMode()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#isQuoteMode()}
   */
  @Test
  public void testIsQuoteMode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BRCVariableExpression()).isQuoteMode());
  }

  /**
   * Test {@link BRCVariableExpression#isSandboxMode()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#isSandboxMode()}
   */
  @Test
  public void testIsSandboxMode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BRCVariableExpression()).isSandboxMode());
  }

  /**
   * Test {@link BRCVariableExpression#getAdditionalProperty(String)}.
   * <p>
   * Method under test:
   * {@link BRCVariableExpression#getAdditionalProperty(String)}
   */
  @Test
  public void testGetAdditionalProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BRCVariableExpression()).getAdditionalProperty("Property Name"));
  }
}
