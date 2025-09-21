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
package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class BroadleafCachingResourceResolverDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafCachingResourceResolver#setOrder(int)}
   *   <li>{@link BroadleafCachingResourceResolver#getCache()}
   *   <li>{@link BroadleafCachingResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Cache BroadleafCachingResourceResolver.getCache()",
    "int BroadleafCachingResourceResolver.getOrder()",
    "void BroadleafCachingResourceResolver.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ConcurrentMapCache cache = new ConcurrentMapCache("Name");
    BroadleafCachingResourceResolver broadleafCachingResourceResolver =
        new BroadleafCachingResourceResolver(cache);

    // Act
    broadleafCachingResourceResolver.setOrder(1);
    Cache actualCache = broadleafCachingResourceResolver.getCache();

    // Assert
    assertEquals(1, broadleafCachingResourceResolver.getOrder());
    assertSame(cache, actualCache);
  }

  /**
   * Test {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest, String)}.
   *
   * <p>Method under test: {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCachingResourceResolver.computeKey(HttpServletRequest, String)"
  })
  public void testComputeKey() {
    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver =
        new BroadleafCachingResourceResolver(new ConcurrentMapCache("Name"));

    // Act and Assert
    assertEquals(
        "resolvedResource:Request Path",
        broadleafCachingResourceResolver.computeKey(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            "Request Path"));
  }

  /**
   * Test {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Given {@code gzip}.
   *   <li>Then return {@code resolvedResource:Request Path+encoding=gzip}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCachingResourceResolver.computeKey(HttpServletRequest, String)"
  })
  public void testComputeKey_givenGzip_thenReturnResolvedResourceRequestPathEncodingGzip() {
    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver =
        new BroadleafCachingResourceResolver(new ConcurrentMapCache("Name"));

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("gzip");
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);

    // Act
    String actualComputeKeyResult =
        broadleafCachingResourceResolver.computeKey(
            new HttpServletRequestWrapper(request2), "Request Path");

    // Assert
    verify(request).getHeader("Accept-Encoding");
    assertEquals("resolvedResource:Request Path+encoding=gzip", actualComputeKeyResult);
  }

  /**
   * Test {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCachingResourceResolver.computeKey(HttpServletRequest, String)"
  })
  public void testComputeKey_givenHttpsExampleOrgExample() {
    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver =
        new BroadleafCachingResourceResolver(new ConcurrentMapCache("Name"));

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);

    // Act
    String actualComputeKeyResult =
        broadleafCachingResourceResolver.computeKey(
            new HttpServletRequestWrapper(request2), "Request Path");

    // Assert
    verify(request).getHeader("Accept-Encoding");
    assertEquals("resolvedResource:Request Path", actualComputeKeyResult);
  }

  /**
   * Test {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code resolvedResource:Request Path}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCachingResourceResolver.computeKey(HttpServletRequest, String)"
  })
  public void testComputeKey_whenNull_thenReturnResolvedResourceRequestPath() {
    // Arrange, Act and Assert
    assertEquals(
        "resolvedResource:Request Path",
        new BroadleafCachingResourceResolver(new ConcurrentMapCache("Name"))
            .computeKey(null, "Request Path"));
  }

  /**
   * Test {@link BroadleafCachingResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentMapCache#ConcurrentMapCache(String)} with {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCachingResourceResolver#resolveUrlPathInternal(String,
   * List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCachingResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenConcurrentMapCacheWithName_thenReturnNull() {
    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver =
        new BroadleafCachingResourceResolver(new ConcurrentMapCache("Name"));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        broadleafCachingResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BroadleafCachingResourceResolver#getThemePathFromBRC()}.
   *
   * <p>Method under test: {@link BroadleafCachingResourceResolver#getThemePathFromBRC()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafCachingResourceResolver.getThemePathFromBRC()"})
  public void testGetThemePathFromBRC() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        new BroadleafCachingResourceResolver(new ConcurrentMapCache("Name")).getThemePathFromBRC());
  }
}
