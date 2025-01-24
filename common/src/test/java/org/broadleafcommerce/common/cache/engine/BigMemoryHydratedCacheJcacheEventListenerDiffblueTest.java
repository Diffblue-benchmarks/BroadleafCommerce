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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryListenerException;
import org.junit.Test;

public class BigMemoryHydratedCacheJcacheEventListenerDiffblueTest {
  /**
   * Test {@link BigMemoryHydratedCacheJcacheEventListener#onExpired(Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheJcacheEventListener#onExpired(Iterable)}
   */
  @Test
  public void testOnExpired_givenArrayListIterator_thenCallsIterator() throws CacheEntryListenerException {
    // Arrange
    BigMemoryHydratedCacheJcacheEventListener bigMemoryHydratedCacheJcacheEventListener = new BigMemoryHydratedCacheJcacheEventListener();
    Iterable<CacheEntryEvent<Serializable, Object>> events = mock(Iterable.class);

    ArrayList<CacheEntryEvent<Serializable, Object>> cacheEntryEventList = new ArrayList<>();
    when(events.iterator()).thenReturn(cacheEntryEventList.iterator());

    // Act
    bigMemoryHydratedCacheJcacheEventListener.onExpired(events);

    // Assert that nothing has changed
    verify(events).iterator();
  }

  /**
   * Test {@link BigMemoryHydratedCacheJcacheEventListener#onRemoved(Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheJcacheEventListener#onRemoved(Iterable)}
   */
  @Test
  public void testOnRemoved_givenArrayListIterator_thenCallsIterator() throws CacheEntryListenerException {
    // Arrange
    BigMemoryHydratedCacheJcacheEventListener bigMemoryHydratedCacheJcacheEventListener = new BigMemoryHydratedCacheJcacheEventListener();
    Iterable<CacheEntryEvent<Serializable, Object>> events = mock(Iterable.class);

    ArrayList<CacheEntryEvent<Serializable, Object>> cacheEntryEventList = new ArrayList<>();
    when(events.iterator()).thenReturn(cacheEntryEventList.iterator());

    // Act
    bigMemoryHydratedCacheJcacheEventListener.onRemoved(events);

    // Assert that nothing has changed
    verify(events).iterator();
  }

  /**
   * Test {@link BigMemoryHydratedCacheJcacheEventListener#onUpdated(Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheJcacheEventListener#onUpdated(Iterable)}
   */
  @Test
  public void testOnUpdated_givenArrayListIterator_thenCallsIterator() throws CacheEntryListenerException {
    // Arrange
    BigMemoryHydratedCacheJcacheEventListener bigMemoryHydratedCacheJcacheEventListener = new BigMemoryHydratedCacheJcacheEventListener();
    Iterable<CacheEntryEvent<Serializable, Object>> events = mock(Iterable.class);

    ArrayList<CacheEntryEvent<Serializable, Object>> cacheEntryEventList = new ArrayList<>();
    when(events.iterator()).thenReturn(cacheEntryEventList.iterator());

    // Act
    bigMemoryHydratedCacheJcacheEventListener.onUpdated(events);

    // Assert that nothing has changed
    verify(events).iterator();
  }

  /**
   * Test {@link BigMemoryHydratedCacheJcacheEventListener#removeCache(Iterable)}
   * with {@code events}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheJcacheEventListener#removeCache(Iterable)}
   */
  @Test
  public void testRemoveCacheWithEvents_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    BigMemoryHydratedCacheJcacheEventListener bigMemoryHydratedCacheJcacheEventListener = new BigMemoryHydratedCacheJcacheEventListener();
    Iterable<CacheEntryEvent<Serializable, Object>> events = mock(Iterable.class);

    ArrayList<CacheEntryEvent<Serializable, Object>> cacheEntryEventList = new ArrayList<>();
    when(events.iterator()).thenReturn(cacheEntryEventList.iterator());

    // Act
    bigMemoryHydratedCacheJcacheEventListener.removeCache(events);

    // Assert that nothing has changed
    verify(events).iterator();
  }

  /**
   * Test new {@link BigMemoryHydratedCacheJcacheEventListener} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BigMemoryHydratedCacheJcacheEventListener}
   */
  @Test
  public void testNewBigMemoryHydratedCacheJcacheEventListener() {
    // Arrange and Act
    BigMemoryHydratedCacheJcacheEventListener actualBigMemoryHydratedCacheJcacheEventListener = new BigMemoryHydratedCacheJcacheEventListener();

    // Assert
    Configuration<String, Object> bigMemoryHydratedCacheConfiguration = actualBigMemoryHydratedCacheJcacheEventListener
        .getBigMemoryHydratedCacheConfiguration();
    Iterable<CacheEntryListenerConfiguration<String, Object>> cacheEntryListenerConfigurations = ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(bigMemoryHydratedCacheConfiguration instanceof MutableConfiguration);
    assertEquals("hydrated-offheap-cache",
        actualBigMemoryHydratedCacheJcacheEventListener.getBigMemoryHydratedCacheName());
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
