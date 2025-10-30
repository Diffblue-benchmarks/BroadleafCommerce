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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

@RunWith(MockitoJUnitRunner.class)
public class PrecompressedArtifactFilterDiffblueTest {
  @InjectMocks
  private PrecompressedArtifactFilter precompressedArtifactFilter;

  @Mock
  private List<String> list;

  /**
   * Test {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code Request}.</li>
   *   <li>Then return {@code Request}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrecompressedArtifactFilter.getResourcePath(HttpServletRequest)"})
  public void testGetResourcePath_givenRequest_thenReturnRequest() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setPathInfo("Request");

    // Act and Assert
    assertEquals("Request", precompressedArtifactFilter.getResourcePath(request));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrecompressedArtifactFilter.getResourcePath(HttpServletRequest)"})
  public void testGetResourcePath_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", precompressedArtifactFilter
        .getResourcePath(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}.
   * <p>
   * Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"})
  public void testUseGzipCompression() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(precompressedArtifactFilter.useGzipCompression(request, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Path", "Gzip Path"));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code .}.</li>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_givenArrayListAddDot_whenDot_thenReturnTrue() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());

    // Act
    boolean actualFileExtensionInWhitelistResult = precompressedArtifactFilter.fileExtensionInWhitelist(".");

    // Assert
    verify(list).iterator();
    assertTrue(actualFileExtensionInWhitelistResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_givenArrayListAddFoo_whenDot_thenReturnTrue() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());

    // Act
    boolean actualFileExtensionInWhitelistResult = precompressedArtifactFilter.fileExtensionInWhitelist(".");

    // Assert
    verify(list).iterator();
    assertTrue(actualFileExtensionInWhitelistResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_thenReturnFalse() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    when(list.iterator()).thenReturn(stringList.iterator());

    // Act
    boolean actualFileExtensionInWhitelistResult = precompressedArtifactFilter.fileExtensionInWhitelist(".");

    // Assert
    verify(list).iterator();
    assertFalse(actualFileExtensionInWhitelistResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(precompressedArtifactFilter.fileExtensionInWhitelist(null));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(precompressedArtifactFilter.fileExtensionInWhitelist("Path"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PrecompressedArtifactFilter#setUseWhileInDefaultEnvironment(boolean)}
   *   <li>{@link PrecompressedArtifactFilter#isUseWhileInDefaultEnvironment()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.isUseWhileInDefaultEnvironment()",
      "void PrecompressedArtifactFilter.setUseWhileInDefaultEnvironment(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    // Act
    precompressedArtifactFilter.setUseWhileInDefaultEnvironment(true);

    // Assert
    assertTrue(precompressedArtifactFilter.isUseWhileInDefaultEnvironment());
  }
}
