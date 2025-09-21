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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class CacheAwareResponseHandlerDiffblueTest {
  @InjectMocks private CacheAwareResponseHandler cacheAwareResponseHandler;

  /**
   * Test {@link CacheAwareResponseHandler#setHeaders(HttpServletResponse, File, String)} with
   * {@code response}, {@code targetFile}, {@code mimeType}.
   *
   * <p>Method under test: {@link CacheAwareResponseHandler#setHeaders(HttpServletResponse, File,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CacheAwareResponseHandler.setHeaders(HttpServletResponse, File, String)"
  })
  public void testSetHeadersWithResponseTargetFileMimeType() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    cacheAwareResponseHandler.setHeaders(
        response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
        "text/plain");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(2, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("text/plain", response2.getContentType());
    assertEquals("text/plain", response3.getContentType());
    assertEquals("text/plain", response.getContentType());
    assertTrue(headerNames.contains("Accept-Ranges"));
    assertTrue(headerNames.contains("Content-Type"));
  }

  /**
   * Test {@link CacheAwareResponseHandler#setHeaders(HttpServletResponse, File, String)} with
   * {@code response}, {@code targetFile}, {@code mimeType}.
   *
   * <p>Method under test: {@link CacheAwareResponseHandler#setHeaders(HttpServletResponse, File,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CacheAwareResponseHandler.setHeaders(HttpServletResponse, File, String)"
  })
  public void testSetHeadersWithResponseTargetFileMimeType2() throws IOException {
    // Arrange
    cacheAwareResponseHandler.setUseCacheControlHeader(false);
    cacheAwareResponseHandler.setCacheSeconds(1);
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    cacheAwareResponseHandler.setHeaders(
        response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
        "text/plain");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(2, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("text/plain", response2.getContentType());
    assertEquals("text/plain", response3.getContentType());
    assertEquals("text/plain", response.getContentType());
    assertTrue(headerNames.contains("Accept-Ranges"));
    assertTrue(headerNames.contains("Content-Type"));
  }

  /**
   * Test new {@link CacheAwareResponseHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CacheAwareResponseHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CacheAwareResponseHandler.<init>()"})
  public void testNewCacheAwareResponseHandler() {
    // Arrange and Act
    CacheAwareResponseHandler actualCacheAwareResponseHandler = new CacheAwareResponseHandler();

    // Assert
    assertNull(actualCacheAwareResponseHandler.getVaryByRequestHeaders());
    assertNull(actualCacheAwareResponseHandler.getCacheControl());
    assertNull(actualCacheAwareResponseHandler.getResourceHttpMessageConverter());
    assertNull(actualCacheAwareResponseHandler.getResourceRegionHttpMessageConverter());
    assertNull(actualCacheAwareResponseHandler.getContentNegotiationManager());
    assertNull(actualCacheAwareResponseHandler.getUrlPathHelper());
    assertEquals(-1, actualCacheAwareResponseHandler.getCacheSeconds());
    assertEquals(2, actualCacheAwareResponseHandler.getSupportedMethods().length);
    assertFalse(actualCacheAwareResponseHandler.isOptimizeLocations());
    assertFalse(actualCacheAwareResponseHandler.isAlwaysMustRevalidate());
    assertFalse(actualCacheAwareResponseHandler.isRequireSession());
    assertFalse(actualCacheAwareResponseHandler.isUseExpiresHeader());
    assertTrue(actualCacheAwareResponseHandler.getLocations().isEmpty());
    assertTrue(actualCacheAwareResponseHandler.getResourceResolvers().isEmpty());
    assertTrue(actualCacheAwareResponseHandler.getResourceTransformers().isEmpty());
    assertTrue(actualCacheAwareResponseHandler.getMediaTypes().isEmpty());
    assertTrue(actualCacheAwareResponseHandler.isUseLastModified());
    assertTrue(actualCacheAwareResponseHandler.isUseCacheControlHeader());
    assertTrue(actualCacheAwareResponseHandler.isUseCacheControlNoStore());
  }
}
