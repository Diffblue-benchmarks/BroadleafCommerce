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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class PrecompressedArtifactFilterDiffblueTest {
  /**
   * Method under test:
   * {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  public void testGetResourcePath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    // Act and Assert
    assertEquals("", precompressedArtifactFilter
        .getResourcePath(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Method under test:
   * {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  public void testGetResourcePath2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setPathInfo("Request");

    // Act and Assert
    assertEquals("Request", precompressedArtifactFilter.getResourcePath(request));
  }

  /**
   * Method under test:
   * {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  public void testGetResourcePath3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn("javax.servlet.include.servlet_path");

    // Act
    String actualResourcePath = precompressedArtifactFilter.getResourcePath(request);

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any());
    assertEquals("javax.servlet.include.servlet_pathjavax.servlet.include.servlet_path", actualResourcePath);
  }

  /**
   * Method under test:
   * {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}
   */
  @Test
  public void testUseGzipCompression() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(precompressedArtifactFilter.useGzipCompression(request, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Path", "Gzip Path"));
  }

  /**
   * Method under test:
   * {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}
   */
  @Test
  public void testUseGzipCompression2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(precompressedArtifactFilter.useGzipCompression(request, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Path", "Gzip Path"));
  }

  /**
   * Method under test:
   * {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}
   */
  @Test
  public void testUseGzipCompression3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(precompressedArtifactFilter.useGzipCompression(request, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Path", null));
  }

  /**
   * Method under test:
   * {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  public void testFileExtensionInWhitelist() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PrecompressedArtifactFilter()).fileExtensionInWhitelist("Path"));
    assertFalse((new PrecompressedArtifactFilter()).fileExtensionInWhitelist(null));
  }

  /**
   * Method under test:
   * {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  public void testFileExtensionInWhitelist2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    precompressedArtifactFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(precompressedArtifactFilter.fileExtensionInWhitelist("Path"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PrecompressedArtifactFilter#setUseWhileInDefaultEnvironment(boolean)}
   *   <li>{@link PrecompressedArtifactFilter#isUseWhileInDefaultEnvironment()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    // Act
    precompressedArtifactFilter.setUseWhileInDefaultEnvironment(true);

    // Assert that nothing has changed
    assertTrue(precompressedArtifactFilter.isUseWhileInDefaultEnvironment());
  }
}
