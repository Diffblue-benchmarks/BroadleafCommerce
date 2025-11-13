package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EhcacheHydratedCacheJcacheEventListenerDiffblueTest {
  /**
   * Test new {@link EhcacheHydratedCacheJcacheEventListener} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * EhcacheHydratedCacheJcacheEventListener}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EhcacheHydratedCacheJcacheEventListener.<init>()"})
  public void testNewEhcacheHydratedCacheJcacheEventListener() {
    // Arrange, Act and Assert
    assertEquals(
        EhcacheHydratedCacheManagerImpl.HYDRATED_CACHE_NAME,
        new EhcacheHydratedCacheJcacheEventListener().getHydratedCacheName());
  }
}
