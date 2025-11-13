package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.broadleafcommerce.common.extensibility.cache.ehcache.DefaultEhCacheConfigurationBuilder;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultJCacheConfigurationBuilderDiffblueTest {
  /**
   * Test {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   *
   * <p>Method under test: {@link
   * DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configuration DefaultJCacheConfigurationBuilder.buildConfiguration(JCacheRegionConfiguration)"
  })
  public void testBuildConfigurationWithRegionInformation() {
    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder =
        new DefaultJCacheConfigurationBuilder();

    // Act
    Configuration actualBuildConfigurationResult =
        defaultJCacheConfigurationBuilder.buildConfiguration(
            new JCacheRegionConfiguration("Cache Name"));

    // Assert
    Iterable<CacheEntryListenerConfiguration> cacheEntryListenerConfigurations =
        ((MutableConfiguration) actualBuildConfigurationResult)
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
    Class<Object> expectedValueType = Object.class;
    assertEquals(expectedValueType, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   *
   * <p>Method under test: {@link
   * DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configuration DefaultJCacheConfigurationBuilder.buildConfiguration(JCacheRegionConfiguration)"
  })
  public void testBuildConfigurationWithRegionInformation2() {
    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder =
        new DefaultJCacheConfigurationBuilder();

    JCacheRegionConfiguration regionInformation = new JCacheRegionConfiguration("Cache Name");
    regionInformation.setTtlSeconds(0);

    // Act
    Configuration actualBuildConfigurationResult =
        defaultJCacheConfigurationBuilder.buildConfiguration(regionInformation);

    // Assert
    Iterable<CacheEntryListenerConfiguration> cacheEntryListenerConfigurations =
        ((MutableConfiguration) actualBuildConfigurationResult)
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
    Class<Object> expectedValueType = Object.class;
    assertEquals(expectedValueType, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   *
   * <ul>
   *   <li>Then calls {@link JCacheRegionConfiguration#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configuration DefaultJCacheConfigurationBuilder.buildConfiguration(JCacheRegionConfiguration)"
  })
  public void testBuildConfigurationWithRegionInformation_thenCallsGetKey() {
    // Arrange
    DefaultEhCacheConfigurationBuilder defaultEhCacheConfigurationBuilder =
        new DefaultEhCacheConfigurationBuilder();

    JCacheRegionConfiguration regionInformation = mock(JCacheRegionConfiguration.class);
    when(regionInformation.getTtlSeconds()).thenReturn(0);
    when(regionInformation.getMaxElementsInMemory()).thenReturn(3);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(regionInformation.getKey()).thenReturn(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    org.mockito.Mockito.<Class<?>>when(regionInformation.getValue()).thenReturn(forNameResult2);

    // Act
    defaultEhCacheConfigurationBuilder.buildConfiguration(regionInformation);

    // Assert
    verify(regionInformation).getKey();
    verify(regionInformation).getMaxElementsInMemory();
    verify(regionInformation).getTtlSeconds();
    verify(regionInformation).getValue();
  }

  /**
   * Test {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)} with
   * {@code ttlSeconds}, {@code maxElementsInMemory}, {@code keyClass}, {@code valueClass}.
   *
   * <p>Method under test: {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int,
   * Class, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configuration DefaultJCacheConfigurationBuilder.buildConfiguration(int, int, Class, Class)"
  })
  public void testBuildConfigurationWithTtlSecondsMaxElementsInMemoryKeyClassValueClass() {
    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder =
        new DefaultJCacheConfigurationBuilder();
    Class<Object> keyClass = Object.class;
    Class<Object> valueClass = Object.class;

    // Act
    Configuration<Object, Object> actualBuildConfigurationResult =
        defaultJCacheConfigurationBuilder.buildConfiguration(1, 3, keyClass, valueClass);

    // Assert
    Iterable<CacheEntryListenerConfiguration<Object, Object>> cacheEntryListenerConfigurations =
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .getCacheLoaderFactory());
    assertNull(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .getCacheWriterFactory());
    assertFalse(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .isManagementEnabled());
    assertFalse(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isReadThrough());
    assertFalse(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .isStatisticsEnabled());
    assertFalse(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(
        ((Set<CacheEntryListenerConfiguration<Object, Object>>) cacheEntryListenerConfigurations)
            .isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    assertEquals(expectedKeyType, actualBuildConfigurationResult.getKeyType());
    Class<Object> expectedValueType = Object.class;
    assertEquals(expectedValueType, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)} with
   * {@code ttlSeconds}, {@code maxElementsInMemory}, {@code keyClass}, {@code valueClass}.
   *
   * <p>Method under test: {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int,
   * Class, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configuration DefaultJCacheConfigurationBuilder.buildConfiguration(int, int, Class, Class)"
  })
  public void testBuildConfigurationWithTtlSecondsMaxElementsInMemoryKeyClassValueClass2() {
    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder =
        new DefaultJCacheConfigurationBuilder();
    Class<Object> keyClass = Object.class;
    Class<Object> valueClass = Object.class;

    // Act
    Configuration<Object, Object> actualBuildConfigurationResult =
        defaultJCacheConfigurationBuilder.buildConfiguration(-1, 3, keyClass, valueClass);

    // Assert
    Iterable<CacheEntryListenerConfiguration<Object, Object>> cacheEntryListenerConfigurations =
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .getCacheLoaderFactory());
    assertNull(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .getCacheWriterFactory());
    assertFalse(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .isManagementEnabled());
    assertFalse(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isReadThrough());
    assertFalse(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
            .isStatisticsEnabled());
    assertFalse(
        ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(
        ((Set<CacheEntryListenerConfiguration<Object, Object>>) cacheEntryListenerConfigurations)
            .isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    assertEquals(expectedKeyType, actualBuildConfigurationResult.getKeyType());
    Class<Object> expectedValueType = Object.class;
    assertEquals(expectedValueType, actualBuildConfigurationResult.getValueType());
  }
}
