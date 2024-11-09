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
package org.broadleafcommerce.common.web.processor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConfigVariableProcessorDiffblueTest {
  /**
   * Test {@link ConfigVariableProcessor#getName()}.
   * <p>
   * Method under test: {@link ConfigVariableProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("config", (new ConfigVariableProcessor()).getName());
  }

  /**
   * Test {@link ConfigVariableProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ConfigVariableProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ConfigVariableProcessor()).getPrecedence());
  }
}