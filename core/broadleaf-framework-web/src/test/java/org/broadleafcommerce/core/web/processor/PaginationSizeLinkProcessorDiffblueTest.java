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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaginationSizeLinkProcessorDiffblueTest {
  /**
   * Test {@link PaginationSizeLinkProcessor#getName()}.
   * <p>
   * Method under test: {@link PaginationSizeLinkProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("pagination-size-link", (new PaginationSizeLinkProcessor()).getName());
  }

  /**
   * Test {@link PaginationSizeLinkProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link PaginationSizeLinkProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new PaginationSizeLinkProcessor()).getPrecedence());
  }
}
