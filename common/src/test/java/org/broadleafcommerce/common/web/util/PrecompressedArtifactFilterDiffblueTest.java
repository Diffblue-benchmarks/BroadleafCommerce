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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;

@RunWith(MockitoJUnitRunner.class)
public class PrecompressedArtifactFilterDiffblueTest {
  @Mock private List<String> list;

  @InjectMocks private PrecompressedArtifactFilter precompressedArtifactFilter;

  /**
   * Test {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code Request}.
   *   <li>Then return {@code Request}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PrecompressedArtifactFilter.getResourcePath(HttpServletRequest)"})
  public void testGetResourcePath_givenRequest_thenReturnRequest() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setPathInfo("Request");

    // Act and Assert
    assertEquals("Request", precompressedArtifactFilter.getResourcePath(request));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PrecompressedArtifactFilter.getResourcePath(HttpServletRequest)"})
  public void testGetResourcePath_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        precompressedArtifactFilter.getResourcePath(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code .}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_givenArrayListAddDot_thenThrowIllegalStateException()
      throws MalformedURLException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            precompressedArtifactFilter.useGzipCompression(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                ".",
                "Gzip Path"));
    verify(list).iterator();
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_givenArrayListAddFoo_thenThrowIllegalStateException()
      throws MalformedURLException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            precompressedArtifactFilter.useGzipCompression(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                ".",
                "Gzip Path"));
    verify(list).iterator();
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_whenDot_thenReturnFalse() throws MalformedURLException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    when(list.iterator()).thenReturn(stringList.iterator());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    boolean actualUseGzipCompressionResult =
        precompressedArtifactFilter.useGzipCompression(
            request,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())),
            ".",
            "Gzip Path");

    // Assert
    verify(list).iterator();
    assertFalse(actualUseGzipCompressionResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_whenPath_thenReturnFalse() throws MalformedURLException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertFalse(
        precompressedArtifactFilter.useGzipCompression(
            request,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())),
            "Path",
            "Gzip Path"));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_whenPath_thenReturnFalse2() throws MalformedURLException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertFalse(
        precompressedArtifactFilter.useGzipCompression(
            request,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())),
            "Path",
            null));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code .}.
   *   <li>When {@code .}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_givenArrayListAddDot_whenDot_thenReturnTrue() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());

    // Act
    boolean actualFileExtensionInWhitelistResult =
        precompressedArtifactFilter.fileExtensionInWhitelist(".");

    // Assert
    verify(list).iterator();
    assertTrue(actualFileExtensionInWhitelistResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>When {@code .}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_givenArrayListAddFoo_whenDot_thenReturnTrue() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());

    // Act
    boolean actualFileExtensionInWhitelistResult =
        precompressedArtifactFilter.fileExtensionInWhitelist(".");

    // Assert
    verify(list).iterator();
    assertTrue(actualFileExtensionInWhitelistResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_thenReturnFalse() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    when(list.iterator()).thenReturn(stringList.iterator());

    // Act
    boolean actualFileExtensionInWhitelistResult =
        precompressedArtifactFilter.fileExtensionInWhitelist(".");

    // Assert
    verify(list).iterator();
    assertFalse(actualFileExtensionInWhitelistResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(precompressedArtifactFilter.fileExtensionInWhitelist(null));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(precompressedArtifactFilter.fileExtensionInWhitelist("Path"));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#isUseWhileInDefaultEnvironment()}.
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#isUseWhileInDefaultEnvironment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.isUseWhileInDefaultEnvironment()",
    "void PrecompressedArtifactFilter.setUseWhileInDefaultEnvironment(boolean)"
  })
  public void testIsUseWhileInDefaultEnvironment() {
    // Arrange, Act and Assert
    assertTrue(new PrecompressedArtifactFilter().isUseWhileInDefaultEnvironment());
  }
}
