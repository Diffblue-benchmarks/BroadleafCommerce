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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.util.ArrayList;
import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryListenerException;
import org.junit.Test;

public class EhcacheHydratedCacheJcacheEventListenerDiffblueTest {
  /**
   * Test {@link EhcacheHydratedCacheJcacheEventListener#onExpired(Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EhcacheHydratedCacheJcacheEventListener#onExpired(Iterable)}
   */
  @Test
  public void testOnExpired_givenArrayListIterator_thenCallsIterator() throws CacheEntryListenerException {
    // Arrange
    EhcacheHydratedCacheJcacheEventListener ehcacheHydratedCacheJcacheEventListener = new EhcacheHydratedCacheJcacheEventListener();
    Iterable<CacheEntryEvent<Serializable, Object>> events = mock(Iterable.class);

    ArrayList<CacheEntryEvent<Serializable, Object>> cacheEntryEventList = new ArrayList<>();
    when(events.iterator()).thenReturn(cacheEntryEventList.iterator());

    // Act
    ehcacheHydratedCacheJcacheEventListener.onExpired(events);

    // Assert that nothing has changed
    verify(events).iterator();
  }

  /**
   * Test {@link EhcacheHydratedCacheJcacheEventListener#onRemoved(Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EhcacheHydratedCacheJcacheEventListener#onRemoved(Iterable)}
   */
  @Test
  public void testOnRemoved_givenArrayListIterator_thenCallsIterator() throws CacheEntryListenerException {
    // Arrange
    EhcacheHydratedCacheJcacheEventListener ehcacheHydratedCacheJcacheEventListener = new EhcacheHydratedCacheJcacheEventListener();
    Iterable<CacheEntryEvent<Serializable, Object>> events = mock(Iterable.class);

    ArrayList<CacheEntryEvent<Serializable, Object>> cacheEntryEventList = new ArrayList<>();
    when(events.iterator()).thenReturn(cacheEntryEventList.iterator());

    // Act
    ehcacheHydratedCacheJcacheEventListener.onRemoved(events);

    // Assert that nothing has changed
    verify(events).iterator();
  }

  /**
   * Test {@link EhcacheHydratedCacheJcacheEventListener#onUpdated(Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EhcacheHydratedCacheJcacheEventListener#onUpdated(Iterable)}
   */
  @Test
  public void testOnUpdated_givenArrayListIterator_thenCallsIterator() throws CacheEntryListenerException {
    // Arrange
    EhcacheHydratedCacheJcacheEventListener ehcacheHydratedCacheJcacheEventListener = new EhcacheHydratedCacheJcacheEventListener();
    Iterable<CacheEntryEvent<Serializable, Object>> events = mock(Iterable.class);

    ArrayList<CacheEntryEvent<Serializable, Object>> cacheEntryEventList = new ArrayList<>();
    when(events.iterator()).thenReturn(cacheEntryEventList.iterator());

    // Act
    ehcacheHydratedCacheJcacheEventListener.onUpdated(events);

    // Assert that nothing has changed
    verify(events).iterator();
  }

  /**
   * Test {@link EhcacheHydratedCacheJcacheEventListener#removeCache(Iterable)}
   * with {@code events}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EhcacheHydratedCacheJcacheEventListener#removeCache(Iterable)}
   */
  @Test
  public void testRemoveCacheWithEvents_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    EhcacheHydratedCacheJcacheEventListener ehcacheHydratedCacheJcacheEventListener = new EhcacheHydratedCacheJcacheEventListener();
    Iterable<CacheEntryEvent<Serializable, Object>> events = mock(Iterable.class);

    ArrayList<CacheEntryEvent<Serializable, Object>> cacheEntryEventList = new ArrayList<>();
    when(events.iterator()).thenReturn(cacheEntryEventList.iterator());

    // Act
    ehcacheHydratedCacheJcacheEventListener.removeCache(events);

    // Assert that nothing has changed
    verify(events).iterator();
  }

  /**
   * Test new {@link EhcacheHydratedCacheJcacheEventListener} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link EhcacheHydratedCacheJcacheEventListener}
   */
  @Test
  public void testNewEhcacheHydratedCacheJcacheEventListener() {
    // Arrange, Act and Assert
    assertEquals(EhcacheHydratedCacheManagerImpl.HYDRATED_CACHE_NAME,
        (new EhcacheHydratedCacheJcacheEventListener()).getHydratedCacheName());
  }
}
