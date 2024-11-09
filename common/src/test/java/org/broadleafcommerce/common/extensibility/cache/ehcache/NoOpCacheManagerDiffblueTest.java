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
import static org.mockito.Mockito.mock;
import java.util.List;
import javax.cache.Cache;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.Factory;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.event.CacheEntryEventFilter;
import javax.cache.event.CacheEntryListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NoOpCacheManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NoOpCacheManagerDiffblueTest {
  @Autowired
  private NoOpCacheManager noOpCacheManager;

  /**
   * Test {@link NoOpCacheManager#getURI()}.
   * <p>
   * Method under test: {@link NoOpCacheManager#getURI()}
   */
  @Test
  public void testGetURI() {
    // Arrange, Act and Assert
    assertEquals("noop:cachemanager", (new NoOpCacheManager()).getURI().toString());
  }

  /**
   * Test {@link NoOpCacheManager#getProperties()}.
   * <p>
   * Method under test: {@link NoOpCacheManager#getProperties()}
   */
  @Test
  public void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue((new NoOpCacheManager()).getProperties().isEmpty());
  }

  /**
   * Test {@link NoOpCacheManager#createCache(String, Configuration)}.
   * <p>
   * Method under test:
   * {@link NoOpCacheManager#createCache(String, Configuration)}
   */
  @Test
  public void testCreateCache() throws IllegalArgumentException {
    // Arrange
    MutableConfiguration<Object, Object> mutableConfiguration = new MutableConfiguration<>();
    mutableConfiguration.addCacheEntryListenerConfiguration(
        new MutableCacheEntryListenerConfiguration<>(mock(Factory.class), mock(Factory.class), true, true));

    // Act
    Cache<Object, Object> actualCreateCacheResult = noOpCacheManager.createCache("foo", mutableConfiguration);

    // Assert
    assertTrue(actualCreateCacheResult instanceof NoOpCache);
    assertEquals("NoOpCache", actualCreateCacheResult.getName());
    assertNull(actualCreateCacheResult.iterator());
    assertFalse(actualCreateCacheResult.isClosed());
    assertSame(noOpCacheManager, actualCreateCacheResult.getCacheManager());
  }

  /**
   * Test {@link NoOpCacheManager#createCache(String, Configuration)}.
   * <ul>
   *   <li>When {@link MutableConfiguration#MutableConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NoOpCacheManager#createCache(String, Configuration)}
   */
  @Test
  public void testCreateCache_whenMutableConfiguration() throws IllegalArgumentException {
    // Arrange and Act
    Cache<Object, Object> actualCreateCacheResult = noOpCacheManager.createCache("foo", new MutableConfiguration<>());

    // Assert
    assertTrue(actualCreateCacheResult instanceof NoOpCache);
    assertEquals("NoOpCache", actualCreateCacheResult.getName());
    assertNull(actualCreateCacheResult.iterator());
    assertFalse(actualCreateCacheResult.isClosed());
    assertSame(noOpCacheManager, actualCreateCacheResult.getCacheManager());
  }

  /**
   * Test {@link NoOpCacheManager#getCache(String)} with {@code s}.
   * <p>
   * Method under test: {@link NoOpCacheManager#getCache(String)}
   */
  @Test
  public void testGetCacheWithS() {
    // Arrange and Act
    Cache<Object, Object> actualCache = noOpCacheManager.getCache("foo");

    // Assert
    assertTrue(actualCache instanceof NoOpCache);
    assertEquals("NoOpCache", actualCache.getName());
    assertNull(actualCache.iterator());
    assertFalse(actualCache.isClosed());
    assertSame(noOpCacheManager, actualCache.getCacheManager());
  }

  /**
   * Test {@link NoOpCacheManager#getCache(String, Class, Class)} with {@code s},
   * {@code aClass}, {@code aClass1}.
   * <p>
   * Method under test: {@link NoOpCacheManager#getCache(String, Class, Class)}
   */
  @Test
  public void testGetCacheWithSAClassAClass1() {
    // Arrange
    Class<Object> aClass = Object.class;
    Class<Object> aClass1 = Object.class;

    // Act
    Cache<Object, Object> actualCache = noOpCacheManager.getCache("foo", aClass, aClass1);

    // Assert
    assertTrue(actualCache instanceof NoOpCache);
    assertEquals("NoOpCache", actualCache.getName());
    assertNull(actualCache.iterator());
    assertFalse(actualCache.isClosed());
    assertSame(noOpCacheManager, actualCache.getCacheManager());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NoOpCacheManager#close()}
   *   <li>{@link NoOpCacheManager#destroyCache(String)}
   *   <li>{@link NoOpCacheManager#enableManagement(String, boolean)}
   *   <li>{@link NoOpCacheManager#enableStatistics(String, boolean)}
   *   <li>{@link NoOpCacheManager#getCacheNames()}
   *   <li>{@link NoOpCacheManager#getCachingProvider()}
   *   <li>{@link NoOpCacheManager#getClassLoader()}
   *   <li>{@link NoOpCacheManager#isClosed()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NoOpCacheManager noOpCacheManager = new NoOpCacheManager();

    // Act
    noOpCacheManager.close();
    noOpCacheManager.destroyCache("foo");
    noOpCacheManager.enableManagement("foo", true);
    noOpCacheManager.enableStatistics("foo", true);
    Iterable<String> actualCacheNames = noOpCacheManager.getCacheNames();
    noOpCacheManager.getCachingProvider();
    noOpCacheManager.getClassLoader();

    // Assert that nothing has changed
    assertTrue(actualCacheNames instanceof List);
    assertFalse(noOpCacheManager.isClosed());
  }

  /**
   * Test {@link NoOpCacheManager#unwrap(Class)}.
   * <p>
   * Method under test: {@link NoOpCacheManager#unwrap(Class)}
   */
  @Test
  public void testUnwrap() {
    // Arrange
    NoOpCacheManager noOpCacheManager = new NoOpCacheManager();
    Class<Object> aClass = Object.class;

    // Act and Assert
    assertSame(noOpCacheManager, noOpCacheManager.unwrap(aClass));
  }

  /**
   * Test new {@link NoOpCacheManager} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link NoOpCacheManager}
   */
  @Test
  public void testNewNoOpCacheManager() {
    // Arrange and Act
    NoOpCacheManager actualNoOpCacheManager = new NoOpCacheManager();

    // Assert
    Iterable<String> cacheNames = actualNoOpCacheManager.getCacheNames();
    assertTrue(cacheNames instanceof List);
    assertEquals("noop:cachemanager", actualNoOpCacheManager.getURI().toString());
    assertNull(actualNoOpCacheManager.getClassLoader());
    assertNull(actualNoOpCacheManager.getCachingProvider());
    assertFalse(actualNoOpCacheManager.isClosed());
    assertTrue(((List<String>) cacheNames).isEmpty());
    assertTrue(actualNoOpCacheManager.getProperties().isEmpty());
  }
}
