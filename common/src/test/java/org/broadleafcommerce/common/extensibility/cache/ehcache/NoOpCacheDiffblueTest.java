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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.cache.CacheManager;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Factory;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.event.CacheEntryEventFilter;
import javax.cache.event.CacheEntryListener;
import javax.cache.integration.CompletionListener;
import javax.cache.integration.CompletionListenerFuture;
import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NoOpCache.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NoOpCacheDiffblueTest {
  @Autowired
  private NoOpCache noOpCache;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NoOpCache#NoOpCache()}
   *   <li>{@link NoOpCache#clear()}
   *   <li>{@link NoOpCache#close()}
   *   <li>
   * {@link NoOpCache#deregisterCacheEntryListener(CacheEntryListenerConfiguration)}
   *   <li>{@link NoOpCache#loadAll(Set, boolean, CompletionListener)}
   *   <li>{@link NoOpCache#put(Object, Object)}
   *   <li>{@link NoOpCache#putAll(Map)}
   *   <li>
   * {@link NoOpCache#registerCacheEntryListener(CacheEntryListenerConfiguration)}
   *   <li>{@link NoOpCache#removeAll()}
   *   <li>{@link NoOpCache#removeAll(Set)}
   *   <li>{@link NoOpCache#getCacheManager()}
   *   <li>{@link NoOpCache#getName()}
   *   <li>{@link NoOpCache#isClosed()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NoOpCache actualNoOpCache = new NoOpCache();
    actualNoOpCache.clear();
    actualNoOpCache.close();
    actualNoOpCache.deregisterCacheEntryListener(
        new MutableCacheEntryListenerConfiguration(mock(Factory.class), mock(Factory.class), true, true));
    HashSet<Object> set = new HashSet<>();
    actualNoOpCache.loadAll(set, true, new CompletionListenerFuture());
    actualNoOpCache.put(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD);
    actualNoOpCache.putAll(new HashMap<>());
    actualNoOpCache.registerCacheEntryListener(
        new MutableCacheEntryListenerConfiguration(mock(Factory.class), mock(Factory.class), true, true));
    actualNoOpCache.removeAll();
    actualNoOpCache.removeAll(new HashSet<>());
    actualNoOpCache.getCacheManager();
    String actualName = actualNoOpCache.getName();

    // Assert that nothing has changed
    assertEquals("NoOpCache", actualName);
    assertFalse(actualNoOpCache.isClosed());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return CacheManager is {@link NoOpCacheManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NoOpCache#NoOpCache(NoOpCacheManager)}
   *   <li>{@link NoOpCache#clear()}
   *   <li>{@link NoOpCache#close()}
   *   <li>
   * {@link NoOpCache#deregisterCacheEntryListener(CacheEntryListenerConfiguration)}
   *   <li>{@link NoOpCache#loadAll(Set, boolean, CompletionListener)}
   *   <li>{@link NoOpCache#put(Object, Object)}
   *   <li>{@link NoOpCache#putAll(Map)}
   *   <li>
   * {@link NoOpCache#registerCacheEntryListener(CacheEntryListenerConfiguration)}
   *   <li>{@link NoOpCache#removeAll()}
   *   <li>{@link NoOpCache#removeAll(Set)}
   *   <li>{@link NoOpCache#getCacheManager()}
   *   <li>{@link NoOpCache#getName()}
   *   <li>{@link NoOpCache#isClosed()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_thenReturnCacheManagerIsNoOpCacheManager() {
    // Arrange
    NoOpCacheManager noOpCacheManager = new NoOpCacheManager();

    // Act
    NoOpCache actualNoOpCache = new NoOpCache(noOpCacheManager);
    actualNoOpCache.clear();
    actualNoOpCache.close();
    actualNoOpCache.deregisterCacheEntryListener(
        new MutableCacheEntryListenerConfiguration(mock(Factory.class), mock(Factory.class), true, true));
    HashSet<Object> set = new HashSet<>();
    actualNoOpCache.loadAll(set, true, new CompletionListenerFuture());
    actualNoOpCache.put(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD);
    actualNoOpCache.putAll(new HashMap<>());
    actualNoOpCache.registerCacheEntryListener(
        new MutableCacheEntryListenerConfiguration(mock(Factory.class), mock(Factory.class), true, true));
    actualNoOpCache.removeAll();
    actualNoOpCache.removeAll(new HashSet<>());
    CacheManager actualCacheManager = actualNoOpCache.getCacheManager();
    String actualName = actualNoOpCache.getName();

    // Assert that nothing has changed
    assertEquals("NoOpCache", actualName);
    assertFalse(actualNoOpCache.isClosed());
    assertSame(noOpCacheManager, actualCacheManager);
  }

  /**
   * Test {@link NoOpCache#get(Object)}.
   * <p>
   * Method under test: {@link NoOpCache#get(Object)}
   */
  @Test
  public void testGet() {
    // Arrange, Act and Assert
    assertNull(noOpCache.get(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#getAll(Set)}.
   * <ul>
   *   <li>Given {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   *   <li>When {@link HashSet#HashSet()} add
   * {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoOpCache#getAll(Set)}
   */
  @Test
  public void testGetAll_givenLock_object_whenHashSetAddLock_object() {
    // Arrange
    NoOpCache noOpCache = new NoOpCache();

    HashSet<Object> set = new HashSet<>();
    set.add(DynamicDaoHelperImpl.LOCK_OBJECT);
    set.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertNull(noOpCache.getAll(set));
  }

  /**
   * Test {@link NoOpCache#getAll(Set)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoOpCache#getAll(Set)}
   */
  @Test
  public void testGetAll_givenNull_field_whenHashSetAddNull_field() {
    // Arrange
    NoOpCache noOpCache = new NoOpCache();

    HashSet<Object> set = new HashSet<>();
    set.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertNull(noOpCache.getAll(set));
  }

  /**
   * Test {@link NoOpCache#getAll(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoOpCache#getAll(Set)}
   */
  @Test
  public void testGetAll_whenHashSet() {
    // Arrange
    NoOpCache noOpCache = new NoOpCache();

    // Act and Assert
    assertNull(noOpCache.getAll(new HashSet<>()));
  }

  /**
   * Test {@link NoOpCache#containsKey(Object)}.
   * <p>
   * Method under test: {@link NoOpCache#containsKey(Object)}
   */
  @Test
  public void testContainsKey() {
    // Arrange, Act and Assert
    assertFalse(noOpCache.containsKey(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#getAndPut(Object, Object)}.
   * <p>
   * Method under test: {@link NoOpCache#getAndPut(Object, Object)}
   */
  @Test
  public void testGetAndPut() {
    // Arrange, Act and Assert
    assertNull(noOpCache.getAndPut(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#putIfAbsent(Object, Object)}.
   * <p>
   * Method under test: {@link NoOpCache#putIfAbsent(Object, Object)}
   */
  @Test
  public void testPutIfAbsent() {
    // Arrange, Act and Assert
    assertFalse(noOpCache.putIfAbsent(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#remove(Object)} with {@code o}.
   * <p>
   * Method under test: {@link NoOpCache#remove(Object)}
   */
  @Test
  public void testRemoveWithO() {
    // Arrange, Act and Assert
    assertFalse(noOpCache.remove(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#remove(Object, Object)} with {@code o}, {@code o2}.
   * <p>
   * Method under test: {@link NoOpCache#remove(Object, Object)}
   */
  @Test
  public void testRemoveWithOO2() {
    // Arrange, Act and Assert
    assertFalse(noOpCache.remove(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#getAndRemove(Object)}.
   * <p>
   * Method under test: {@link NoOpCache#getAndRemove(Object)}
   */
  @Test
  public void testGetAndRemove() {
    // Arrange, Act and Assert
    assertNull(noOpCache.getAndRemove(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#replace(Object, Object)} with {@code o}, {@code o2}.
   * <p>
   * Method under test: {@link NoOpCache#replace(Object, Object)}
   */
  @Test
  public void testReplaceWithOO2() {
    // Arrange, Act and Assert
    assertFalse(noOpCache.replace(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#replace(Object, Object, Object)} with {@code o},
   * {@code o2}, {@code v1}.
   * <p>
   * Method under test: {@link NoOpCache#replace(Object, Object, Object)}
   */
  @Test
  public void testReplaceWithOO2V1() {
    // Arrange, Act and Assert
    assertFalse(noOpCache.replace(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#getAndReplace(Object, Object)}.
   * <p>
   * Method under test: {@link NoOpCache#getAndReplace(Object, Object)}
   */
  @Test
  public void testGetAndReplace() {
    // Arrange, Act and Assert
    assertNull(noOpCache.getAndReplace(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#iterator()}.
   * <p>
   * Method under test: {@link NoOpCache#iterator()}
   */
  @Test
  public void testIterator() {
    // Arrange, Act and Assert
    assertNull((new NoOpCache()).iterator());
  }

  /**
   * Test {@link NoOpCache#unwrap(Class)}.
   * <p>
   * Method under test: {@link NoOpCache#unwrap(Class)}
   */
  @Test
  public void testUnwrap() {
    // Arrange
    NoOpCache noOpCache = new NoOpCache();
    Class<Object> aClass = Object.class;

    // Act and Assert
    assertNull(noOpCache.unwrap(aClass));
  }

  /**
   * Test {@link NoOpCache#invokeAll(Set, EntryProcessor, Object[])}.
   * <ul>
   *   <li>Given {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   *   <li>When {@link HashSet#HashSet()} add
   * {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoOpCache#invokeAll(Set, EntryProcessor, Object[])}
   */
  @Test
  public void testInvokeAll_givenLock_object_whenHashSetAddLock_object() {
    // Arrange
    NoOpCache noOpCache = new NoOpCache();

    HashSet<Object> set = new HashSet<>();
    set.add(DynamicDaoHelperImpl.LOCK_OBJECT);
    set.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertNull(noOpCache.invokeAll(set, mock(EntryProcessor.class), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#invokeAll(Set, EntryProcessor, Object[])}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoOpCache#invokeAll(Set, EntryProcessor, Object[])}
   */
  @Test
  public void testInvokeAll_givenNull_field_whenHashSetAddNull_field() {
    // Arrange
    NoOpCache noOpCache = new NoOpCache();

    HashSet<Object> set = new HashSet<>();
    set.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertNull(noOpCache.invokeAll(set, mock(EntryProcessor.class), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#invokeAll(Set, EntryProcessor, Object[])}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoOpCache#invokeAll(Set, EntryProcessor, Object[])}
   */
  @Test
  public void testInvokeAll_whenHashSet() {
    // Arrange
    NoOpCache noOpCache = new NoOpCache();

    // Act and Assert
    assertNull(noOpCache.invokeAll(new HashSet<>(), mock(EntryProcessor.class), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#invoke(Object, EntryProcessor, Object[])}.
   * <p>
   * Method under test: {@link NoOpCache#invoke(Object, EntryProcessor, Object[])}
   */
  @Test
  public void testInvoke() throws EntryProcessorException {
    // Arrange, Act and Assert
    assertNull(noOpCache.invoke(BLCFieldUtils.NULL_FIELD, mock(EntryProcessor.class), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link NoOpCache#getConfiguration(Class)}.
   * <p>
   * Method under test: {@link NoOpCache#getConfiguration(Class)}
   */
  @Test
  public void testGetConfiguration() {
    // Arrange
    NoOpCache noOpCache = new NoOpCache();
    Class<Object> aClass = Object.class;

    // Act and Assert
    assertNull(noOpCache.getConfiguration(aClass));
  }
}
