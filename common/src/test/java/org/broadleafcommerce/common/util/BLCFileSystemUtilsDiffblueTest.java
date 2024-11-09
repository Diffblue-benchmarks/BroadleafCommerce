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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class BLCFileSystemUtilsDiffblueTest {
  /**
   * Test {@link BLCFileSystemUtils#getClasspathFileContents(String)}.
   * <ul>
   *   <li>When {@code /directory/foo.txt}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCFileSystemUtils#getClasspathFileContents(String)}
   */
  @Test
  public void testGetClasspathFileContents_whenDirectoryFooTxt_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCFileSystemUtils.getClasspathFileContents("/directory/foo.txt"));
  }

  /**
   * Test {@link BLCFileSystemUtils#getClasspathFileInputStream(String)}.
   * <ul>
   *   <li>When {@code /directory/foo.txt}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCFileSystemUtils#getClasspathFileInputStream(String)}
   */
  @Test
  public void testGetClasspathFileInputStream_whenDirectoryFooTxt_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCFileSystemUtils.getClasspathFileInputStream("/directory/foo.txt"));
  }
}
