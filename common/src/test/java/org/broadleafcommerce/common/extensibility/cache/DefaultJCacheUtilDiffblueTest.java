package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.cache.Cache;
import org.broadleafcommerce.common.extensibility.cache.ehcache.DefaultEhCacheUtil;
import org.broadleafcommerce.common.extensibility.cache.ehcache.NoOpCache;
import org.broadleafcommerce.common.extensibility.cache.ehcache.NoOpCacheManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultJCacheUtilDiffblueTest {
  /**
   * Test {@link DefaultJCacheUtil#getCache(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultEhCacheUtil#DefaultEhCacheUtil(CacheManager)} with cacheManager is
   *       {@link NoOpCacheManager} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DefaultJCacheUtil#getCache(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache DefaultJCacheUtil.getCache(String)"})
  public void testGetCache_givenDefaultEhCacheUtilWithCacheManagerIsNoOpCacheManager() {
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

  /**
   * Test {@link DefaultJCacheUtil#getCache(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultJCacheUtil#DefaultJCacheUtil(CacheManager)} with cacheManager is
   *       {@link NoOpCacheManager} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DefaultJCacheUtil#getCache(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache DefaultJCacheUtil.getCache(String)"})
  public void testGetCache_givenDefaultJCacheUtilWithCacheManagerIsNoOpCacheManager() {
    // Arrange
    NoOpCacheManager cacheManager = new NoOpCacheManager();

    // Act
    Cache<Object, Object> actualCache = new DefaultJCacheUtil(cacheManager).getCache("Cache Name");

    // Assert
    assertTrue(actualCache instanceof NoOpCache);
    assertEquals("NoOpCache", actualCache.getName());
    assertNull(actualCache.iterator());
    assertFalse(actualCache.isClosed());
    assertSame(cacheManager, actualCache.getCacheManager());
  }
}
