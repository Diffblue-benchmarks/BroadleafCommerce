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
package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JSCompatibilityHelperDiffblueTest {
  /**
   * Test {@link JSCompatibilityHelper#encode(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityHelper#encode(String)}
   */
  @Test
  public void testEncode_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JSCompatibilityHelper.encode(""));
  }

  /**
   * Test {@link JSCompatibilityHelper#encode(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityHelper#encode(String)}
   */
  @Test
  public void testEncode_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", JSCompatibilityHelper.encode("Name"));
  }

  /**
   * Test {@link JSCompatibilityHelper#unencode(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityHelper#unencode(String)}
   */
  @Test
  public void testUnencode_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JSCompatibilityHelper.unencode(""));
  }

  /**
   * Test {@link JSCompatibilityHelper#unencode(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityHelper#unencode(String)}
   */
  @Test
  public void testUnencode_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", JSCompatibilityHelper.unencode("Name"));
  }
}
