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
package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ConditionalFieldAnnotationsClassTransformerDiffblueTest {
  /**
   * Test
   * {@link ConditionalFieldAnnotationsClassTransformer#ConditionalFieldAnnotationsClassTransformer(String)}.
   * <p>
   * Method under test:
   * {@link ConditionalFieldAnnotationsClassTransformer#ConditionalFieldAnnotationsClassTransformer(String)}
   */
  @Test
  public void testNewConditionalFieldAnnotationsClassTransformer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ConditionalFieldAnnotationsClassTransformer actualConditionalFieldAnnotationsClassTransformer = new ConditionalFieldAnnotationsClassTransformer(
        "Module Name");

    // Assert
    assertEquals("Module Name", actualConditionalFieldAnnotationsClassTransformer.moduleName);
    assertNull(actualConditionalFieldAnnotationsClassTransformer.manager);
    assertTrue(actualConditionalFieldAnnotationsClassTransformer.preLoadClassNamePatterns.isEmpty());
  }
}
