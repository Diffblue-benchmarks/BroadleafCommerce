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
package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.EventType;
import org.junit.Test;

public class EhcacheHydratedCacheEventListenerDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link EhcacheHydratedCacheEventListener}
   */
  @Test
  public void testNewEhcacheHydratedCacheEventListener() {
    // Arrange, Act and Assert
    assertEquals(EhcacheHydratedCacheManagerImpl.HYDRATED_CACHE_NAME,
        (new EhcacheHydratedCacheEventListener()).getHydratedCacheName());
  }

  /**
   * Method under test:
   * {@link EhcacheHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent() {
    // Arrange
    EhcacheHydratedCacheEventListener ehcacheHydratedCacheEventListener = new EhcacheHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getKey()).thenReturn(1);
    when(cacheEvent.getType()).thenReturn(EventType.EVICTED);

    // Act
    ehcacheHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert
    verify(cacheEvent).getKey();
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Method under test:
   * {@link EhcacheHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent2() {
    // Arrange
    EhcacheHydratedCacheEventListener ehcacheHydratedCacheEventListener = new EhcacheHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getType()).thenReturn(EventType.CREATED);

    // Act
    ehcacheHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert that nothing has changed
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Method under test:
   * {@link EhcacheHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent3() {
    // Arrange
    EhcacheHydratedCacheEventListener ehcacheHydratedCacheEventListener = new EhcacheHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getKey()).thenReturn(1);
    when(cacheEvent.getType()).thenReturn(EventType.EXPIRED);

    // Act
    ehcacheHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert
    verify(cacheEvent).getKey();
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Method under test:
   * {@link EhcacheHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent4() {
    // Arrange
    EhcacheHydratedCacheEventListener ehcacheHydratedCacheEventListener = new EhcacheHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getKey()).thenReturn(1);
    when(cacheEvent.getType()).thenReturn(EventType.REMOVED);

    // Act
    ehcacheHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert
    verify(cacheEvent).getKey();
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Method under test:
   * {@link EhcacheHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent5() {
    // Arrange
    EhcacheHydratedCacheEventListener ehcacheHydratedCacheEventListener = new EhcacheHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getKey()).thenReturn(1);
    when(cacheEvent.getType()).thenReturn(EventType.UPDATED);

    // Act
    ehcacheHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert
    verify(cacheEvent).getKey();
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Method under test:
   * {@link EhcacheHydratedCacheEventListener#useCacheRegionInKey()}
   */
  @Test
  public void testUseCacheRegionInKey() {
    // Arrange, Act and Assert
    assertFalse((new EhcacheHydratedCacheEventListener()).useCacheRegionInKey());
  }
}
