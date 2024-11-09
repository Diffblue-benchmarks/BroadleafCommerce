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
package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.cache.Cache;
import org.broadleafcommerce.common.extensibility.cache.ehcache.DefaultEhCacheUtil;
import org.broadleafcommerce.common.extensibility.cache.ehcache.NoOpCache;
import org.broadleafcommerce.common.extensibility.cache.ehcache.NoOpCacheManager;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultJCacheUtilDiffblueTest {
  /**
   * Test {@link DefaultJCacheUtil#getCache(String)}.
   * <ul>
   *   <li>Given {@link DefaultEhCacheUtil#DefaultEhCacheUtil(CacheManager)} with
   * cacheManager is {@link NoOpCacheManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJCacheUtil#getCache(String)}
   */
  @Test
  public void testGetCache_givenDefaultEhCacheUtilWithCacheManagerIsNoOpCacheManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NoOpCacheManager cacheManager = new NoOpCacheManager();

    // Act
    Cache<Object, Object> actualCache = (new DefaultEhCacheUtil(cacheManager)).getCache("Cache Name");

    // Assert
    assertTrue(actualCache instanceof NoOpCache);
    assertEquals("NoOpCache", actualCache.getName());
    assertNull(actualCache.iterator());
    assertFalse(actualCache.isClosed());
    assertSame(cacheManager, actualCache.getCacheManager());
  }

  /**
   * Test {@link DefaultJCacheUtil#getCache(String)}.
   * <ul>
   *   <li>Given {@link DefaultJCacheUtil#DefaultJCacheUtil(CacheManager)} with
   * cacheManager is {@link NoOpCacheManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJCacheUtil#getCache(String)}
   */
  @Test
  public void testGetCache_givenDefaultJCacheUtilWithCacheManagerIsNoOpCacheManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NoOpCacheManager cacheManager = new NoOpCacheManager();

    // Act
    Cache<Object, Object> actualCache = (new DefaultJCacheUtil(cacheManager)).getCache("Cache Name");

    // Assert
    assertTrue(actualCache instanceof NoOpCache);
    assertEquals("NoOpCache", actualCache.getName());
    assertNull(actualCache.iterator());
    assertFalse(actualCache.isClosed());
    assertSame(cacheManager, actualCache.getCacheManager());
  }

  /**
   * Test {@link DefaultJCacheUtil#getCache(String)}.
   * <ul>
   *   <li>Given {@link NoOpCacheManager} {@link NoOpCacheManager#getCache(String)}
   * return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJCacheUtil#getCache(String)}
   */
  @Test
  public void testGetCache_givenNoOpCacheManagerGetCacheReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NoOpCacheManager cacheManager = mock(NoOpCacheManager.class);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<Object, Object> actualCache = (new DefaultJCacheUtil(cacheManager)).getCache("Cache Name");

    // Assert
    verify(cacheManager).getCache(eq("Cache Name"));
    assertNull(actualCache);
  }
}
