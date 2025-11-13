package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BigMemoryHydratedCacheManagerImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BigMemoryHydratedCacheManagerImpl#getInstance()}
   *   <li>{@link BigMemoryHydratedCacheManagerImpl#getBigMemoryHydratedCacheName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BigMemoryHydratedCacheManagerImpl.getBigMemoryHydratedCacheName()",
    "BigMemoryHydratedCacheManagerImpl BigMemoryHydratedCacheManagerImpl.getInstance()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BigMemoryHydratedCacheManagerImpl actualInstance =
        BigMemoryHydratedCacheManagerImpl.getInstance();
    BigMemoryHydratedCacheManagerImpl actualInstance2 = actualInstance.getInstance();

    // Assert
    assertEquals("hydrated-offheap-cache", actualInstance.getBigMemoryHydratedCacheName());
    assertSame(actualInstance, actualInstance2);
  }

  /**
   * Test new {@link BigMemoryHydratedCacheManagerImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BigMemoryHydratedCacheManagerImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BigMemoryHydratedCacheManagerImpl.<init>()"})
  public void testNewBigMemoryHydratedCacheManagerImpl() {
    // Arrange and Act
    BigMemoryHydratedCacheManagerImpl actualBigMemoryHydratedCacheManagerImpl =
        new BigMemoryHydratedCacheManagerImpl();

    // Assert
    Configuration<String, Object> bigMemoryHydratedCacheConfiguration =
        actualBigMemoryHydratedCacheManagerImpl.getBigMemoryHydratedCacheConfiguration();
    Iterable<CacheEntryListenerConfiguration<String, Object>> cacheEntryListenerConfigurations =
        ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
            .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(bigMemoryHydratedCacheConfiguration instanceof MutableConfiguration);
    assertEquals(
        "hydrated-offheap-cache",
        actualBigMemoryHydratedCacheManagerImpl.getBigMemoryHydratedCacheName());
    assertNull(
        ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
            .getCacheLoaderFactory());
    assertNull(
        ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
            .getCacheWriterFactory());
    assertFalse(
        ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
            .isManagementEnabled());
    assertFalse(
        ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
            .isReadThrough());
    assertFalse(
        ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
            .isStatisticsEnabled());
    assertFalse(
        ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
            .isWriteThrough());
    assertTrue(
        ((Set<CacheEntryListenerConfiguration<String, Object>>) cacheEntryListenerConfigurations)
            .isEmpty());
    assertTrue(bigMemoryHydratedCacheConfiguration.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    assertEquals(expectedKeyType, bigMemoryHydratedCacheConfiguration.getKeyType());
    Class<Object> expectedValueType = Object.class;
    assertEquals(expectedValueType, bigMemoryHydratedCacheConfiguration.getValueType());
  }
}
