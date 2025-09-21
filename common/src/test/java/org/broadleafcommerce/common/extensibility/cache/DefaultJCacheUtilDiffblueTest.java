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
package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.common.extensibility.cache.ehcache.DefaultEhCacheUtil;
import org.broadleafcommerce.common.extensibility.cache.ehcache.NoOpCache;
import org.broadleafcommerce.common.extensibility.cache.ehcache.NoOpCacheManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultJCacheUtilDiffblueTest {
  @Mock private CacheManager cacheManager;

  @InjectMocks private DefaultJCacheUtil defaultJCacheUtil;

  /**
   * Test {@link DefaultJCacheUtil#getCache(String)}.
   *
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultJCacheUtil#getCache(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache DefaultJCacheUtil.getCache(String)"})
  public void testGetCache_givenCacheManagerGetCacheReturnNull_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<Object, Object> actualCache = defaultJCacheUtil.getCache("Cache Name");

    // Assert
    verify(cacheManager).getCache("Cache Name");
    assertNull(actualCache);
  }

  /**
   * Test {@link DefaultJCacheUtil#getCache(String)}.
   *
   * <ul>
   *   <li>Then return {@link NoOpCache}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultJCacheUtil#getCache(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache DefaultJCacheUtil.getCache(String)"})
  public void testGetCache_thenReturnNoOpCache() {
    // Arrange
    NoOpCacheManager cacheManager = new NoOpCacheManager();

    // Act
    Cache<Object, Object> actualCache = new DefaultEhCacheUtil(cacheManager).getCache("Cache Name");

    // Assert
    assertTrue(actualCache instanceof NoOpCache);
    assertEquals("NoOpCache", actualCache.getName());
    assertNull(actualCache.iterator());
    assertFalse(actualCache.isClosed());
    assertSame(cacheManager, actualCache.getCacheManager());
  }
}
