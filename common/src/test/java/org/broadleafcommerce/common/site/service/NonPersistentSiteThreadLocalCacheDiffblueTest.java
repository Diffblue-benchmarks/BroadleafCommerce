package org.broadleafcommerce.common.site.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.site.domain.Site;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NonPersistentSiteThreadLocalCacheDiffblueTest {
  /**
   * Test {@link NonPersistentSiteThreadLocalCache#getSitesCache()}.
   *
   * <p>Method under test: {@link NonPersistentSiteThreadLocalCache#getSitesCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NonPersistentSiteThreadLocalCache NonPersistentSiteThreadLocalCache.getSitesCache()"
  })
  public void testGetSitesCache() {
    // Arrange, Act and Assert
    assertTrue(NonPersistentSiteThreadLocalCache.getSitesCache().getSites().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NonPersistentSiteThreadLocalCache}
   *   <li>{@link NonPersistentSiteThreadLocalCache#setSites(Map)}
   *   <li>{@link NonPersistentSiteThreadLocalCache#getSites()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NonPersistentSiteThreadLocalCache.<init>()",
    "Map NonPersistentSiteThreadLocalCache.getSites()",
    "void NonPersistentSiteThreadLocalCache.setSites(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    NonPersistentSiteThreadLocalCache actualNonPersistentSiteThreadLocalCache =
        new NonPersistentSiteThreadLocalCache();
    HashMap<Long, Site> sites = new HashMap<>();
    actualNonPersistentSiteThreadLocalCache.setSites(sites);
    Map<Long, Site> actualSites = actualNonPersistentSiteThreadLocalCache.getSites();

    // Assert
    assertTrue(actualSites.isEmpty());
    assertSame(sites, actualSites);
  }
}
