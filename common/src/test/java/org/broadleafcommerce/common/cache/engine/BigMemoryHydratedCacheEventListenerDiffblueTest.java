package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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

public class BigMemoryHydratedCacheEventListenerDiffblueTest {
  /**
   * Test new {@link BigMemoryHydratedCacheEventListener} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BigMemoryHydratedCacheEventListener}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BigMemoryHydratedCacheEventListener.<init>()"})
  public void testNewBigMemoryHydratedCacheEventListener() {
    // Arrange and Act
    BigMemoryHydratedCacheEventListener actualBigMemoryHydratedCacheEventListener =
        new BigMemoryHydratedCacheEventListener();

    // Assert
    Configuration<String, Object> bigMemoryHydratedCacheConfiguration =
        actualBigMemoryHydratedCacheEventListener.getBigMemoryHydratedCacheConfiguration();
    Iterable<CacheEntryListenerConfiguration<String, Object>> cacheEntryListenerConfigurations =
        ((MutableConfiguration<String, Object>) bigMemoryHydratedCacheConfiguration)
            .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(bigMemoryHydratedCacheConfiguration instanceof MutableConfiguration);
    assertEquals(
        "hydrated-offheap-cache",
        actualBigMemoryHydratedCacheEventListener.getBigMemoryHydratedCacheName());
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
