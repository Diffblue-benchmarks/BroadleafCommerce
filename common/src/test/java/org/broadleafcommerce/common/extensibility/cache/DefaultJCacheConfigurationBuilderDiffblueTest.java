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
package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultJCacheConfigurationBuilderDiffblueTest {
  @InjectMocks
  private DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder;

  /**
   * Test {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)} with {@code regionInformation}.
   * <p>
   * Method under test: {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Configuration DefaultJCacheConfigurationBuilder.buildConfiguration(JCacheRegionConfiguration)"})
  public void testBuildConfigurationWithRegionInformation() {
    // Arrange and Act
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
   * Test {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)} with {@code regionInformation}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Configuration DefaultJCacheConfigurationBuilder.buildConfiguration(JCacheRegionConfiguration)"})
  public void testBuildConfigurationWithRegionInformation_givenZero() {
    // Arrange
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
   * Test {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)} with {@code ttlSeconds}, {@code maxElementsInMemory}, {@code keyClass}, {@code valueClass}.
   * <p>
   * Method under test: {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Configuration DefaultJCacheConfigurationBuilder.buildConfiguration(int, int, Class, Class)"})
  public void testBuildConfigurationWithTtlSecondsMaxElementsInMemoryKeyClassValueClass() {
    // Arrange
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
   * Test {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)} with {@code ttlSeconds}, {@code maxElementsInMemory}, {@code keyClass}, {@code valueClass}.
   * <p>
   * Method under test: {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Configuration DefaultJCacheConfigurationBuilder.buildConfiguration(int, int, Class, Class)"})
  public void testBuildConfigurationWithTtlSecondsMaxElementsInMemoryKeyClassValueClass2() {
    // Arrange
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
