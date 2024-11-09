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
package org.broadleafcommerce.common.extensibility.cache.ehcache;

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
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultEhCacheUtilDiffblueTest {
  /**
   * Test {@link DefaultEhCacheUtil#getCache(String)}.
   * <ul>
   *   <li>Given {@link NoOpCacheManager} {@link NoOpCacheManager#getCache(String)}
   * return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEhCacheUtil#getCache(String)}
   */
  @Test
  public void testGetCache_givenNoOpCacheManagerGetCacheReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NoOpCacheManager cacheManager = mock(NoOpCacheManager.class);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<Object, Object> actualCache = (new DefaultEhCacheUtil(cacheManager)).getCache("Cache Name");

    // Assert
    verify(cacheManager).getCache(eq("Cache Name"));
    assertNull(actualCache);
  }

  /**
   * Test {@link DefaultEhCacheUtil#getCache(String)}.
   * <ul>
   *   <li>Then return {@link NoOpCache}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEhCacheUtil#getCache(String)}
   */
  @Test
  public void testGetCache_thenReturnNoOpCache() {
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
}
