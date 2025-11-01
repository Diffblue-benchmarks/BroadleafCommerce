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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class BroadleafCachingResourceResolverDiffblueTest {
  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest, String)}
   */
  @Test
  public void testComputeKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver = new BroadleafCachingResourceResolver(
        new ConcurrentMapCache("Name"));

    // Act and Assert
    assertEquals("resolvedResource:Request Path", broadleafCachingResourceResolver
        .computeKey(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "Request Path"));
  }

  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest, String)}
   */
  @Test
  public void testComputeKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("resolvedResource:Request Path",
        (new BroadleafCachingResourceResolver(new ConcurrentMapCache("Name"))).computeKey(null, "Request Path"));
  }

  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest, String)}
   */
  @Test
  public void testComputeKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver = new BroadleafCachingResourceResolver(
        mock(ConcurrentMapCache.class));

    // Act and Assert
    assertEquals("resolvedResource:Request Path", broadleafCachingResourceResolver
        .computeKey(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "Request Path"));
  }

  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest, String)}
   */
  @Test
  public void testComputeKey4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver = new BroadleafCachingResourceResolver(
        new ConcurrentMapCache("Name"));
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualComputeKeyResult = broadleafCachingResourceResolver
        .computeKey(new SessionlessHttpServletRequestWrapper(request), "Request Path");

    // Assert
    verify(request).getHeader(eq("Accept-Encoding"));
    assertEquals("resolvedResource:Request Path", actualComputeKeyResult);
  }

  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#computeKey(HttpServletRequest, String)}
   */
  @Test
  public void testComputeKey5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver = new BroadleafCachingResourceResolver(
        new ConcurrentMapCache("Name"));
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("gzip");

    // Act
    String actualComputeKeyResult = broadleafCachingResourceResolver
        .computeKey(new SessionlessHttpServletRequestWrapper(request), "Request Path");

    // Assert
    verify(request).getHeader(eq("Accept-Encoding"));
    assertEquals("resolvedResource:Request Path+encoding=gzip", actualComputeKeyResult);
  }

  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver = new BroadleafCachingResourceResolver(
        new ConcurrentMapCache("Name"));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(broadleafCachingResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver = new BroadleafCachingResourceResolver(
        mock(ConcurrentMapCache.class));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(broadleafCachingResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver = new BroadleafCachingResourceResolver(
        new ConcurrentMapCache("Name"));

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafCachingResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCachingResourceResolver broadleafCachingResourceResolver = new BroadleafCachingResourceResolver(
        new ConcurrentMapCache("Name"));

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafCachingResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BroadleafCachingResourceResolver#getThemePathFromBRC()}
   */
  @Test
  public void testGetThemePathFromBRC() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new BroadleafCachingResourceResolver(new ConcurrentMapCache("Name"))).getThemePathFromBRC());
    assertEquals("", (new BroadleafCachingResourceResolver(mock(Cache.class))).getThemePathFromBRC());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafCachingResourceResolver#setOrder(int)}
   *   <li>{@link BroadleafCachingResourceResolver#getCache()}
   *   <li>{@link BroadleafCachingResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ConcurrentMapCache cache = new ConcurrentMapCache("Name");
    BroadleafCachingResourceResolver broadleafCachingResourceResolver = new BroadleafCachingResourceResolver(cache);

    // Act
    broadleafCachingResourceResolver.setOrder(1);
    Cache actualCache = broadleafCachingResourceResolver.getCache();

    // Assert that nothing has changed
    assertEquals(1, broadleafCachingResourceResolver.getOrder());
    assertSame(cache, actualCache);
  }
}
