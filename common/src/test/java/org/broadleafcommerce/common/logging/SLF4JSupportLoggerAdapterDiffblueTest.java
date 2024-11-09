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
package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SLF4JSupportLoggerAdapterDiffblueTest {
  /**
   * Test {@link SLF4JSupportLoggerAdapter#getSupportLevel()}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#getSupportLevel()}
   */
  @Test
  public void testGetSupportLevel() {
    // Arrange, Act and Assert
    assertEquals(AbstractSupportLoggerAdapter.LOG_LEVEL_WARN, (new SLF4JSupportLoggerAdapter()).getSupportLevel());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SLF4JSupportLoggerAdapter}
   *   <li>{@link SLF4JSupportLoggerAdapter#setName(String)}
   *   <li>{@link SLF4JSupportLoggerAdapter#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SLF4JSupportLoggerAdapter actualSlf4jSupportLoggerAdapter = new SLF4JSupportLoggerAdapter();
    actualSlf4jSupportLoggerAdapter.setName("Name");

    // Assert that nothing has changed
    assertEquals("Name", actualSlf4jSupportLoggerAdapter.getName());
  }
}
