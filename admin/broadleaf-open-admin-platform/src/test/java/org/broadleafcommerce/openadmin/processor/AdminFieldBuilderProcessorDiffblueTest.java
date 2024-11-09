/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class AdminFieldBuilderProcessorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminFieldBuilderProcessor#getName()}
   *   <li>{@link AdminFieldBuilderProcessor#getPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminFieldBuilderProcessor adminFieldBuilderProcessor = new AdminFieldBuilderProcessor();

    // Act
    String actualName = adminFieldBuilderProcessor.getName();

    // Assert
    assertEquals("admin_field_builder", actualName);
    assertEquals("blc_admin", adminFieldBuilderProcessor.getPrefix());
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new AdminFieldBuilderProcessor()).getPrecedence());
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#useGlobalScope()}
   */
  @Test
  public void testUseGlobalScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AdminFieldBuilderProcessor()).useGlobalScope());
  }
}
