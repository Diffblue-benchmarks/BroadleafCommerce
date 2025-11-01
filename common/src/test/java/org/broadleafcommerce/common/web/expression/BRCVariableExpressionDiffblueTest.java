/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class BRCVariableExpressionDiffblueTest {
  /**
   * Method under test: {@link BRCVariableExpression#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("brc", (new BRCVariableExpression()).getName());
  }

  /**
   * Method under test: {@link BRCVariableExpression#getSandbox()}
   */
  @Test
  public void testGetSandbox() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BRCVariableExpression()).getSandbox());
  }

  /**
   * Method under test: {@link BRCVariableExpression#getSite()}
   */
  @Test
  public void testGetSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BRCVariableExpression()).getSite());
  }

  /**
   * Method under test: {@link BRCVariableExpression#getCurrentProfile()}
   */
  @Test
  public void testGetCurrentProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BRCVariableExpression()).getCurrentProfile());
  }

  /**
   * Method under test: {@link BRCVariableExpression#getCurrentCatalog()}
   */
  @Test
  public void testGetCurrentCatalog() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BRCVariableExpression()).getCurrentCatalog());
  }

  /**
   * Method under test: {@link BRCVariableExpression#get(String)}
   */
  @Test
  public void testGet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new BRCVariableExpression()).get("Property Name"));
    assertThrows(RuntimeException.class, () -> (new BRCVariableExpression()).get(null));
    assertThrows(RuntimeException.class, () -> (new BRCVariableExpression()).get("ThreadLocalManager.notify.orphans"));
  }

  /**
   * Method under test: {@link BRCVariableExpression#isCsrMode()}
   */
  @Test
  public void testIsCsrMode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BRCVariableExpression()).isCsrMode());
  }

  /**
   * Method under test: {@link BRCVariableExpression#isQuoteMode()}
   */
  @Test
  public void testIsQuoteMode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BRCVariableExpression()).isQuoteMode());
  }

  /**
   * Method under test: {@link BRCVariableExpression#isSandboxMode()}
   */
  @Test
  public void testIsSandboxMode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BRCVariableExpression()).isSandboxMode());
  }

  /**
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
