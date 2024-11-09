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
import java.util.Set;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.junit.Test;

public class BigMemoryHydratedCacheManagerImplDiffblueTest {
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
