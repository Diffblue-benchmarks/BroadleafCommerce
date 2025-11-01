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
package org.broadleafcommerce.common.file.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BroadleafFileUtilsDiffblueTest {
  /**
   * Method under test: {@link BroadleafFileUtils#buildFilePath(String, String)}
   */
  @Test
  public void testBuildFilePath() {
    // Arrange, Act and Assert
    assertEquals("/directory/foo.txt", BroadleafFileUtils.buildFilePath("/directory", "foo.txt"));
    assertEquals("/foo.txt", BroadleafFileUtils.buildFilePath("/", "foo.txt"));
    assertEquals("/directory/", BroadleafFileUtils.buildFilePath("/directory", "/"));
    assertEquals("/", BroadleafFileUtils.buildFilePath("/", "/"));
  }

  /**
   * Method under test: {@link BroadleafFileUtils#removeLeadingSlash(String)}
   */
  @Test
  public void testRemoveLeadingSlash() {
    // Arrange, Act and Assert
    assertEquals("foo.txt", BroadleafFileUtils.removeLeadingSlash("foo.txt"));
    assertEquals("", BroadleafFileUtils.removeLeadingSlash("/"));
  }

  /**
   * Method under test: {@link BroadleafFileUtils#addLeadingSlash(String)}
   */
  @Test
  public void testAddLeadingSlash() {
    // Arrange, Act and Assert
    assertEquals("/foo.txt", BroadleafFileUtils.addLeadingSlash("foo.txt"));
    assertEquals("/", BroadleafFileUtils.addLeadingSlash("/"));
  }

  /**
   * Method under test: {@link BroadleafFileUtils#appendUnixPaths(String, String)}
   */
  @Test
  public void testAppendUnixPaths() {
    // Arrange, Act and Assert
    assertEquals("/directory/foo.txt", BroadleafFileUtils.appendUnixPaths("/directory", "foo.txt"));
    assertEquals("/foo.txt", BroadleafFileUtils.appendUnixPaths("/", "foo.txt"));
    assertEquals("/directory/", BroadleafFileUtils.appendUnixPaths("/directory", "/"));
    assertEquals("/", BroadleafFileUtils.appendUnixPaths("/", "/"));
  }

  /**
   * Method under test: {@link BroadleafFileUtils#removeLeadingUnixSlash(String)}
   */
  @Test
  public void testRemoveLeadingUnixSlash() {
    // Arrange, Act and Assert
    assertEquals("foo.txt", BroadleafFileUtils.removeLeadingUnixSlash("foo.txt"));
    assertEquals("", BroadleafFileUtils.removeLeadingUnixSlash("/"));
  }

  /**
   * Method under test: {@link BroadleafFileUtils#addLeadingUnixSlash(String)}
   */
  @Test
  public void testAddLeadingUnixSlash() {
    // Arrange, Act and Assert
    assertEquals("/foo.txt", BroadleafFileUtils.addLeadingUnixSlash("foo.txt"));
    assertEquals("/", BroadleafFileUtils.addLeadingUnixSlash("/"));
  }
}
