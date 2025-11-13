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
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletResponse;

public class CacheAwareResponseHandlerDiffblueTest {
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
    CacheAwareResponseHandler cacheAwareResponseHandler = new CacheAwareResponseHandler();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    cacheAwareResponseHandler.setHeaders(
        response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
        "text/plain");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(2, headerNames.size());
    assertTrue(headerNames instanceof Set);
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
