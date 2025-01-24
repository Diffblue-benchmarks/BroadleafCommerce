/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import org.junit.Test;

public class BLCFileSystemUtilsDiffblueTest {
  /**
   * Test {@link BLCFileSystemUtils#getClasspathFileContents(String)}.
   * <ul>
   *   <li>When {@code classpath:}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCFileSystemUtils#getClasspathFileContents(String)}
   */
  @Test
  public void testGetClasspathFileContents_whenClasspath_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "application.properties\n" + "blc-config\n" + "common-test-properties\n" + "context\n" + "log4j2.xml\n"
            + "META-INF\n" + "my\n" + "org\n" + "overridestest.properties\n" + "sharedoverridestest.properties\n",
        BLCFileSystemUtils.getClasspathFileContents("classpath:"));
  }

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
   * Test {@link BLCFileSystemUtils#getClasspathFileContents(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCFileSystemUtils#getClasspathFileContents(String)}
   */
  @Test
  public void testGetClasspathFileContents_whenEmptyString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "application.properties\n" + "blc-config\n" + "common-test-properties\n" + "context\n" + "log4j2.xml\n"
            + "META-INF\n" + "my\n" + "org\n" + "overridestest.properties\n" + "sharedoverridestest.properties\n",
        BLCFileSystemUtils.getClasspathFileContents(""));
  }

  /**
   * Test {@link BLCFileSystemUtils#getClasspathFileInputStream(String)}.
   * <ul>
   *   <li>When {@code classpath:}.</li>
   *   <li>Then return read is fifty-one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCFileSystemUtils#getClasspathFileInputStream(String)}
   */
  @Test
  public void testGetClasspathFileInputStream_whenClasspath_thenReturnReadIsFiftyOne() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(51, BLCFileSystemUtils.getClasspathFileInputStream("classpath:").read(byteArray));
    assertArrayEquals("application.properties\nblc-config\ncommon-test-prope".getBytes("UTF-8"), byteArray);
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
