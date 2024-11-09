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
package org.broadleafcommerce.common.file.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BroadleafFileUtilsDiffblueTest {
  /**
   * Test {@link BroadleafFileUtils#buildFilePath(String, String)}.
   * <ul>
   *   <li>When {@code /directory}.</li>
   *   <li>Then return {@code /directory/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#buildFilePath(String, String)}
   */
  @Test
  public void testBuildFilePath_whenDirectory_thenReturnDirectory() {
    // Arrange, Act and Assert
    assertEquals("/directory/", BroadleafFileUtils.buildFilePath("/directory", "/"));
  }

  /**
   * Test {@link BroadleafFileUtils#buildFilePath(String, String)}.
   * <ul>
   *   <li>When {@code /directory}.</li>
   *   <li>Then return {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#buildFilePath(String, String)}
   */
  @Test
  public void testBuildFilePath_whenDirectory_thenReturnDirectoryFooTxt() {
    // Arrange, Act and Assert
    assertEquals("/directory/foo.txt", BroadleafFileUtils.buildFilePath("/directory", "foo.txt"));
  }

  /**
   * Test {@link BroadleafFileUtils#buildFilePath(String, String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code /foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#buildFilePath(String, String)}
   */
  @Test
  public void testBuildFilePath_whenFooTxt_thenReturnFooTxt() {
    // Arrange, Act and Assert
    assertEquals("/foo.txt", BroadleafFileUtils.buildFilePath("/", "foo.txt"));
  }

  /**
   * Test {@link BroadleafFileUtils#buildFilePath(String, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#buildFilePath(String, String)}
   */
  @Test
  public void testBuildFilePath_whenSlash_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", BroadleafFileUtils.buildFilePath("/", "/"));
  }

  /**
   * Test {@link BroadleafFileUtils#removeLeadingSlash(String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#removeLeadingSlash(String)}
   */
  @Test
  public void testRemoveLeadingSlash_whenFooTxt_thenReturnFooTxt() {
    // Arrange, Act and Assert
    assertEquals("foo.txt", BroadleafFileUtils.removeLeadingSlash("foo.txt"));
  }

  /**
   * Test {@link BroadleafFileUtils#removeLeadingSlash(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#removeLeadingSlash(String)}
   */
  @Test
  public void testRemoveLeadingSlash_whenSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", BroadleafFileUtils.removeLeadingSlash("/"));
  }

  /**
   * Test {@link BroadleafFileUtils#addLeadingSlash(String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code /foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#addLeadingSlash(String)}
   */
  @Test
  public void testAddLeadingSlash_whenFooTxt_thenReturnFooTxt() {
    // Arrange, Act and Assert
    assertEquals("/foo.txt", BroadleafFileUtils.addLeadingSlash("foo.txt"));
  }

  /**
   * Test {@link BroadleafFileUtils#addLeadingSlash(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#addLeadingSlash(String)}
   */
  @Test
  public void testAddLeadingSlash_whenSlash_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", BroadleafFileUtils.addLeadingSlash("/"));
  }

  /**
   * Test {@link BroadleafFileUtils#appendUnixPaths(String, String)}.
   * <ul>
   *   <li>When {@code /directory}.</li>
   *   <li>Then return {@code /directory/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#appendUnixPaths(String, String)}
   */
  @Test
  public void testAppendUnixPaths_whenDirectory_thenReturnDirectory() {
    // Arrange, Act and Assert
    assertEquals("/directory/", BroadleafFileUtils.appendUnixPaths("/directory", "/"));
  }

  /**
   * Test {@link BroadleafFileUtils#appendUnixPaths(String, String)}.
   * <ul>
   *   <li>When {@code /directory}.</li>
   *   <li>Then return {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#appendUnixPaths(String, String)}
   */
  @Test
  public void testAppendUnixPaths_whenDirectory_thenReturnDirectoryFooTxt() {
    // Arrange, Act and Assert
    assertEquals("/directory/foo.txt", BroadleafFileUtils.appendUnixPaths("/directory", "foo.txt"));
  }

  /**
   * Test {@link BroadleafFileUtils#appendUnixPaths(String, String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code /foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#appendUnixPaths(String, String)}
   */
  @Test
  public void testAppendUnixPaths_whenFooTxt_thenReturnFooTxt() {
    // Arrange, Act and Assert
    assertEquals("/foo.txt", BroadleafFileUtils.appendUnixPaths("/", "foo.txt"));
  }

  /**
   * Test {@link BroadleafFileUtils#appendUnixPaths(String, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#appendUnixPaths(String, String)}
   */
  @Test
  public void testAppendUnixPaths_whenSlash_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", BroadleafFileUtils.appendUnixPaths("/", "/"));
  }

  /**
   * Test {@link BroadleafFileUtils#removeLeadingUnixSlash(String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#removeLeadingUnixSlash(String)}
   */
  @Test
  public void testRemoveLeadingUnixSlash_whenFooTxt_thenReturnFooTxt() {
    // Arrange, Act and Assert
    assertEquals("foo.txt", BroadleafFileUtils.removeLeadingUnixSlash("foo.txt"));
  }

  /**
   * Test {@link BroadleafFileUtils#removeLeadingUnixSlash(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#removeLeadingUnixSlash(String)}
   */
  @Test
  public void testRemoveLeadingUnixSlash_whenSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", BroadleafFileUtils.removeLeadingUnixSlash("/"));
  }

  /**
   * Test {@link BroadleafFileUtils#addLeadingUnixSlash(String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code /foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#addLeadingUnixSlash(String)}
   */
  @Test
  public void testAddLeadingUnixSlash_whenFooTxt_thenReturnFooTxt() {
    // Arrange, Act and Assert
    assertEquals("/foo.txt", BroadleafFileUtils.addLeadingUnixSlash("foo.txt"));
  }

  /**
   * Test {@link BroadleafFileUtils#addLeadingUnixSlash(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileUtils#addLeadingUnixSlash(String)}
   */
  @Test
  public void testAddLeadingUnixSlash_whenSlash_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", BroadleafFileUtils.addLeadingUnixSlash("/"));
  }
}
