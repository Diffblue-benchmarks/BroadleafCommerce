package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EhcacheHydratedCacheEventListenerDiffblueTest {
  /**
   * Test new {@link EhcacheHydratedCacheEventListener} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * EhcacheHydratedCacheEventListener}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EhcacheHydratedCacheEventListener.<init>()"})
  public void testNewEhcacheHydratedCacheEventListener() {
    // Arrange, Act and Assert
    assertEquals(
        EhcacheHydratedCacheManagerImpl.HYDRATED_CACHE_NAME,
        new EhcacheHydratedCacheEventListener().getHydratedCacheName());
  }
}
