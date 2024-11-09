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
package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultJCacheConfigurationBuilderDiffblueTest {
  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  public void testBuildConfigurationWithRegionInformation_givenZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();

    JCacheRegionConfiguration regionInformation = new JCacheRegionConfiguration("Cache Name");
    regionInformation.setTtlSeconds(0);

    // Act
    Configuration actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(regionInformation);

    // Assert
    Iterable<CacheEntryListenerConfiguration> cacheEntryListenerConfigurations = ((MutableConfiguration) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    Class keyType = actualBuildConfigurationResult.getKeyType();
    assertEquals(expectedKeyType, keyType);
    assertSame(keyType, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   * <ul>
   *   <li>Then return ValueType is KeyType.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  public void testBuildConfigurationWithRegionInformation_thenReturnValueTypeIsKeyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();

    // Act
    Configuration actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(new JCacheRegionConfiguration("Cache Name"));

    // Assert
    Iterable<CacheEntryListenerConfiguration> cacheEntryListenerConfigurations = ((MutableConfiguration) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    Class keyType = actualBuildConfigurationResult.getKeyType();
    assertEquals(expectedKeyType, keyType);
    assertSame(keyType, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   * <ul>
   *   <li>Then return ValueType is {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  public void testBuildConfigurationWithRegionInformation_thenReturnValueTypeIsObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();
    JCacheRegionConfiguration regionInformation = mock(JCacheRegionConfiguration.class);
    when(regionInformation.getMaxElementsInMemory()).thenReturn(3);
    when(regionInformation.getTtlSeconds()).thenReturn(1);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(regionInformation.getKey()).thenReturn(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(regionInformation.getValue()).thenReturn(forNameResult2);

    // Act
    Configuration actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(regionInformation);

    // Assert
    verify(regionInformation).getKey();
    verify(regionInformation).getMaxElementsInMemory();
    verify(regionInformation).getTtlSeconds();
    verify(regionInformation).getValue();
    Iterable<CacheEntryListenerConfiguration> cacheEntryListenerConfigurations = ((MutableConfiguration) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    assertEquals(expectedKeyType, actualBuildConfigurationResult.getKeyType());
    assertSame(forNameResult2, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   * with {@code ttlSeconds}, {@code maxElementsInMemory}, {@code keyClass},
   * {@code valueClass}.
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   */
  @Test
  public void testBuildConfigurationWithTtlSecondsMaxElementsInMemoryKeyClassValueClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();
    Class<Object> keyClass = Object.class;
    Class<Object> valueClass = Object.class;

    // Act
    Configuration<Object, Object> actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(1, 3, keyClass, valueClass);

    // Assert
    Iterable<CacheEntryListenerConfiguration<Object, Object>> cacheEntryListenerConfigurations = ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration<Object, Object>>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    assertEquals(expectedKeyType, actualBuildConfigurationResult.getKeyType());
    assertSame(valueClass, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   * with {@code ttlSeconds}, {@code maxElementsInMemory}, {@code keyClass},
   * {@code valueClass}.
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   */
  @Test
  public void testBuildConfigurationWithTtlSecondsMaxElementsInMemoryKeyClassValueClass2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();
    Class<Object> keyClass = Object.class;
    Class<Object> valueClass = Object.class;

    // Act
    Configuration<Object, Object> actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(-1, 3, keyClass, valueClass);

    // Assert
    Iterable<CacheEntryListenerConfiguration<Object, Object>> cacheEntryListenerConfigurations = ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration<Object, Object>>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    assertEquals(expectedKeyType, actualBuildConfigurationResult.getKeyType());
    assertSame(valueClass, actualBuildConfigurationResult.getValueType());
  }
}
