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
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ModuleVariableExpressionDiffblueTest {
  /**
   * Test {@link ModuleVariableExpression#getName()}.
   * <p>
   * Method under test: {@link ModuleVariableExpression#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("module", (new ModuleVariableExpression()).getName());
  }

  /**
   * Test {@link ModuleVariableExpression#isPresent(String)}.
   * <ul>
   *   <li>When {@code CommonTest}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModuleVariableExpression#isPresent(String)}
   */
  @Test
  public void testIsPresent_whenCommonTest_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ModuleVariableExpression()).isPresent("CommonTest"));
  }

  /**
   * Test {@link ModuleVariableExpression#isPresent(String)}.
   * <ul>
   *   <li>When {@code Module In Question}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModuleVariableExpression#isPresent(String)}
   */
  @Test
  public void testIsPresent_whenModuleInQuestion_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ModuleVariableExpression()).isPresent("Module In Question"));
  }
}
