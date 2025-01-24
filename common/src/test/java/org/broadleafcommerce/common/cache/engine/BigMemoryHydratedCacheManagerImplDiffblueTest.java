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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Set;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BigMemoryHydratedCacheManagerImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BigMemoryHydratedCacheManagerImplDiffblueTest {
  @Autowired
  private BigMemoryHydratedCacheManagerImpl bigMemoryHydratedCacheManagerImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BigMemoryHydratedCacheManagerImpl#getInstance()}
   *   <li>{@link BigMemoryHydratedCacheManagerImpl#getBigMemoryHydratedCacheName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BigMemoryHydratedCacheManagerImpl actualInstance = BigMemoryHydratedCacheManagerImpl.getInstance();
    BigMemoryHydratedCacheManagerImpl actualInstance2 = actualInstance.getInstance();

    // Assert
    assertEquals("hydrated-offheap-cache", actualInstance.getBigMemoryHydratedCacheName());
    assertSame(actualInstance, actualInstance2);
  }

  /**
   * Test
   * {@link BigMemoryHydratedCacheManagerImpl#getBigMemoryHydratedCacheConfiguration()}.
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheManagerImpl#getBigMemoryHydratedCacheConfiguration()}
   */
  @Test
  public void testGetBigMemoryHydratedCacheConfiguration() {
    // Arrange and Act
    Configuration<String, Object> actualBigMemoryHydratedCacheConfiguration = BigMemoryHydratedCacheManagerImpl
        .getInstance()
        .getBigMemoryHydratedCacheConfiguration();

    // Assert
    Iterable<CacheEntryListenerConfiguration<String, Object>> cacheEntryListenerConfigurations = ((MutableConfiguration<String, Object>) actualBigMemoryHydratedCacheConfiguration)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBigMemoryHydratedCacheConfiguration instanceof MutableConfiguration);
    assertNull(
        ((MutableConfiguration<String, Object>) actualBigMemoryHydratedCacheConfiguration).getCacheLoaderFactory());
    assertNull(
        ((MutableConfiguration<String, Object>) actualBigMemoryHydratedCacheConfiguration).getCacheWriterFactory());
    assertFalse(
        ((MutableConfiguration<String, Object>) actualBigMemoryHydratedCacheConfiguration).isManagementEnabled());
    assertFalse(((MutableConfiguration<String, Object>) actualBigMemoryHydratedCacheConfiguration).isReadThrough());
    assertFalse(
        ((MutableConfiguration<String, Object>) actualBigMemoryHydratedCacheConfiguration).isStatisticsEnabled());
    assertFalse(((MutableConfiguration<String, Object>) actualBigMemoryHydratedCacheConfiguration).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration<String, Object>>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBigMemoryHydratedCacheConfiguration.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    Class<String> keyType = actualBigMemoryHydratedCacheConfiguration.getKeyType();
    assertEquals(expectedKeyType, keyType);
    assertSame(keyType, actualBigMemoryHydratedCacheConfiguration.getValueType());
  }

  /**
   * Test
   * {@link BigMemoryHydratedCacheManagerImpl#getHydratedCacheElementItem(String, String, Serializable, String)}.
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheManagerImpl#getHydratedCacheElementItem(String, String, Serializable, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetHydratedCacheElementItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.getHeap(BigMemoryHydratedCacheManagerImpl.java:60)
    //       at org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.getHydratedCacheElementItem(BigMemoryHydratedCacheManagerImpl.java:89)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    bigMemoryHydratedCacheManagerImpl.getHydratedCacheElementItem("us-east-2", "Cache Name",
        new SimpleDateFormat("yyyy/mm/dd"), "Element Item Name");
  }

  /**
   * Test
   * {@link BigMemoryHydratedCacheManagerImpl#addHydratedCacheElementItem(String, String, Serializable, String, Object)}.
   * <ul>
   *   <li>When {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy/mm/dd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheManagerImpl#addHydratedCacheElementItem(String, String, Serializable, String, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddHydratedCacheElementItem_whenSimpleDateFormatWithYyyyMmDd() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.getHeap(BigMemoryHydratedCacheManagerImpl.java:60)
    //       at org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.addHydratedCacheElementItem(BigMemoryHydratedCacheManagerImpl.java:105)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    bigMemoryHydratedCacheManagerImpl.addHydratedCacheElementItem("us-east-2", "Cache Name",
        new SimpleDateFormat("yyyy/mm/dd"), "Element Item Name", BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link BigMemoryHydratedCacheManagerImpl#removeCache(String, Serializable)}
   * with {@code cacheRegion}, {@code key}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheManagerImpl#removeCache(String, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveCacheWithCacheRegionKey_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.removeCache(BigMemoryHydratedCacheManagerImpl.java:115)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    bigMemoryHydratedCacheManagerImpl.removeCache("us-east-2", null);
  }

  /**
   * Test
   * {@link BigMemoryHydratedCacheManagerImpl#removeCache(String, Serializable)}
   * with {@code cacheRegion}, {@code key}.
   * <ul>
   *   <li>When {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy/mm/dd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheManagerImpl#removeCache(String, Serializable)}
   */
  @Test
  public void testRemoveCacheWithCacheRegionKey_whenSimpleDateFormatWithYyyyMmDd() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    bigMemoryHydratedCacheManagerImpl.removeCache("us-east-2", new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test {@link BigMemoryHydratedCacheManagerImpl#removeCache(Serializable)} with
   * {@code key}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheManagerImpl#removeCache(Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveCacheWithKey_givenInstance_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.removeCache(BigMemoryHydratedCacheManagerImpl.java:115)
    //       at org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.removeCache(BigMemoryHydratedCacheManagerImpl.java:109)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BigMemoryHydratedCacheManagerImpl.getInstance().removeCache(null);
  }

  /**
   * Test {@link BigMemoryHydratedCacheManagerImpl#removeCache(Serializable)} with
   * {@code key}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy/mm/dd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BigMemoryHydratedCacheManagerImpl#removeCache(Serializable)}
   */
  @Test
  public void testRemoveCacheWithKey_givenInstance_whenSimpleDateFormatWithYyyyMmDd() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BigMemoryHydratedCacheManagerImpl instance = BigMemoryHydratedCacheManagerImpl.getInstance();

    // Act
    instance.removeCache(new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test new {@link BigMemoryHydratedCacheManagerImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BigMemoryHydratedCacheManagerImpl}
   */
  @Test
  public void testNewBigMemoryHydratedCacheManagerImpl() {
    // Arrange and Act
    BigMemoryHydratedCacheManagerImpl actualBigMemoryHydratedCacheManagerImpl = new BigMemoryHydratedCacheManagerImpl();

    // Assert
    Configuration<String, Object> bigMemoryHydratedCacheConfiguration = actualBigMemoryHydratedCacheManagerImpl
        .getBigMemoryHydratedCacheConfiguration();
    Iterable<CacheEntryListenerConfiguration<String, Object>> cacheEntryListenerConfigurations = ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(bigMemoryHydratedCacheConfiguration instanceof MutableConfiguration);
    assertEquals("hydrated-offheap-cache", actualBigMemoryHydratedCacheManagerImpl.getBigMemoryHydratedCacheName());
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
