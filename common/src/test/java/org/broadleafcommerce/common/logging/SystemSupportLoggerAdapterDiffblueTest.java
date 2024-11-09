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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SystemSupportLoggerAdapterDiffblueTest {
  /**
   * Test {@link SystemSupportLoggerAdapter#getShowDateTime()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowDateTime()}
   */
  @Test
  public void testGetShowDateTime() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getShowDateTime());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowThreadName()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowThreadName()}
   */
  @Test
  public void testGetShowThreadName() {
    // Arrange, Act and Assert
    assertFalse((new SystemSupportLoggerAdapter()).getShowThreadName());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowLogName()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowLogName()}
   */
  @Test
  public void testGetShowLogName() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getShowLogName());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getLevelInBrackets()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getLevelInBrackets()}
   */
  @Test
  public void testGetLevelInBrackets() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getLevelInBrackets());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowNonSupportLevels()}.
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#getShowNonSupportLevels()}
   */
  @Test
  public void testGetShowNonSupportLevels() {
    // Arrange, Act and Assert
    assertFalse((new SystemSupportLoggerAdapter()).getShowNonSupportLevels());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SystemSupportLoggerAdapter}
   *   <li>{@link SystemSupportLoggerAdapter#setName(String)}
   *   <li>{@link SystemSupportLoggerAdapter#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SystemSupportLoggerAdapter actualSystemSupportLoggerAdapter = new SystemSupportLoggerAdapter();
    actualSystemSupportLoggerAdapter.setName("Name");

    // Assert that nothing has changed
    assertEquals("Name", actualSystemSupportLoggerAdapter.getName());
  }
}
