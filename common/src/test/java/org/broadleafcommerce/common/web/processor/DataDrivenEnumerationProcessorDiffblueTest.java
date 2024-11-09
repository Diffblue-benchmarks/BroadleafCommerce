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

public class DataDrivenEnumerationProcessorDiffblueTest {
  /**
   * Test {@link DataDrivenEnumerationProcessor#getName()}.
   * <p>
   * Method under test: {@link DataDrivenEnumerationProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("enumeration", (new DataDrivenEnumerationProcessor()).getName());
  }

  /**
   * Test {@link DataDrivenEnumerationProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link DataDrivenEnumerationProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new DataDrivenEnumerationProcessor()).getPrecedence());
  }
}
