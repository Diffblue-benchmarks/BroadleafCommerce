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
package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.EventType;
import org.junit.Test;

public class BigMemoryHydratedCacheEventListenerDiffblueTest {
  /**
   * Test {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}.
   * <ul>
   *   <li>Given {@code CREATED}.</li>
   *   <li>When {@link CacheEvent} {@link CacheEvent#getType()} return
   * {@code CREATED}.</li>
   *   <li>Then calls {@link CacheEvent#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent_givenCreated_whenCacheEventGetTypeReturnCreated_thenCallsGetType() {
    // Arrange
    BigMemoryHydratedCacheEventListener bigMemoryHydratedCacheEventListener = new BigMemoryHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getType()).thenReturn(EventType.CREATED);

    // Act
    bigMemoryHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert that nothing has changed
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Test {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}.
   * <ul>
   *   <li>Given {@code EVICTED}.</li>
   *   <li>When {@link CacheEvent} {@link CacheEvent#getType()} return
   * {@code EVICTED}.</li>
   *   <li>Then calls {@link CacheEvent#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent_givenEvicted_whenCacheEventGetTypeReturnEvicted_thenCallsGetKey() {
    // Arrange
    BigMemoryHydratedCacheEventListener bigMemoryHydratedCacheEventListener = new BigMemoryHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getKey()).thenReturn(1);
    when(cacheEvent.getType()).thenReturn(EventType.EVICTED);

    // Act
    bigMemoryHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert
    verify(cacheEvent).getKey();
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Test {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}.
   * <ul>
   *   <li>Given {@code EXPIRED}.</li>
   *   <li>When {@link CacheEvent} {@link CacheEvent#getType()} return
   * {@code EXPIRED}.</li>
   *   <li>Then calls {@link CacheEvent#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent_givenExpired_whenCacheEventGetTypeReturnExpired_thenCallsGetKey() {
    // Arrange
    BigMemoryHydratedCacheEventListener bigMemoryHydratedCacheEventListener = new BigMemoryHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getKey()).thenReturn(1);
    when(cacheEvent.getType()).thenReturn(EventType.EXPIRED);

    // Act
    bigMemoryHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert
    verify(cacheEvent).getKey();
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Test {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}.
   * <ul>
   *   <li>Given {@code REMOVED}.</li>
   *   <li>When {@link CacheEvent} {@link CacheEvent#getType()} return
   * {@code REMOVED}.</li>
   *   <li>Then calls {@link CacheEvent#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent_givenRemoved_whenCacheEventGetTypeReturnRemoved_thenCallsGetKey() {
    // Arrange
    BigMemoryHydratedCacheEventListener bigMemoryHydratedCacheEventListener = new BigMemoryHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getKey()).thenReturn(1);
    when(cacheEvent.getType()).thenReturn(EventType.REMOVED);

    // Act
    bigMemoryHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert
    verify(cacheEvent).getKey();
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Test {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}.
   * <ul>
   *   <li>Given {@code UPDATED}.</li>
   *   <li>When {@link CacheEvent} {@link CacheEvent#getType()} return
   * {@code UPDATED}.</li>
   *   <li>Then calls {@link CacheEvent#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheEventListener#onEvent(CacheEvent)}
   */
  @Test
  public void testOnEvent_givenUpdated_whenCacheEventGetTypeReturnUpdated_thenCallsGetKey() {
    // Arrange
    BigMemoryHydratedCacheEventListener bigMemoryHydratedCacheEventListener = new BigMemoryHydratedCacheEventListener();
    CacheEvent cacheEvent = mock(CacheEvent.class);
    when(cacheEvent.getKey()).thenReturn(1);
    when(cacheEvent.getType()).thenReturn(EventType.UPDATED);

    // Act
    bigMemoryHydratedCacheEventListener.onEvent(cacheEvent);

    // Assert
    verify(cacheEvent).getKey();
    verify(cacheEvent, atLeast(1)).getType();
  }

  /**
   * Test {@link BigMemoryHydratedCacheEventListener#useCacheRegionInKey()}.
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheEventListener#useCacheRegionInKey()}
   */
  @Test
  public void testUseCacheRegionInKey() {
    // Arrange, Act and Assert
    assertFalse((new BigMemoryHydratedCacheEventListener()).useCacheRegionInKey());
  }

  /**
   * Test new {@link BigMemoryHydratedCacheEventListener} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BigMemoryHydratedCacheEventListener}
   */
  @Test
  public void testNewBigMemoryHydratedCacheEventListener() {
    // Arrange and Act
    BigMemoryHydratedCacheEventListener actualBigMemoryHydratedCacheEventListener = new BigMemoryHydratedCacheEventListener();

    // Assert
    Configuration<String, Object> bigMemoryHydratedCacheConfiguration = actualBigMemoryHydratedCacheEventListener
        .getBigMemoryHydratedCacheConfiguration();
    Iterable<CacheEntryListenerConfiguration<String, Object>> cacheEntryListenerConfigurations = ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(bigMemoryHydratedCacheConfiguration instanceof MutableConfiguration);
    assertEquals("hydrated-offheap-cache", actualBigMemoryHydratedCacheEventListener.getBigMemoryHydratedCacheName());
    assertNull(((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration).getCacheLoaderFactory());
    assertNull(((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration).getCacheWriterFactory());
    assertFalse(((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration).isManagementEnabled());
    assertFalse(((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration).isReadThrough());
    assertFalse(((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration).isStatisticsEnabled());
    assertFalse(((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration<String, Object>>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(bigMemoryHydratedCacheConfiguration.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    Class<String> keyType = bigMemoryHydratedCacheConfiguration.getKeyType();
    assertEquals(expectedKeyType, keyType);
    assertSame(keyType, bigMemoryHydratedCacheConfiguration.getValueType());
  }
}
