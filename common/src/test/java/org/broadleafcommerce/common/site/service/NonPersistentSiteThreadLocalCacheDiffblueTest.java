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
package org.broadleafcommerce.common.site.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.site.domain.Site;
import org.junit.Test;

public class NonPersistentSiteThreadLocalCacheDiffblueTest {
  /**
   * Test {@link NonPersistentSiteThreadLocalCache#getSitesCache()}.
   * <p>
   * Method under test: {@link NonPersistentSiteThreadLocalCache#getSitesCache()}
   */
  @Test
  public void testGetSitesCache() {
    // Arrange, Act and Assert
    assertTrue(NonPersistentSiteThreadLocalCache.getSitesCache().getSites().isEmpty());
  }

  /**
   * Test
   * {@link NonPersistentSiteThreadLocalCache#setSitesCache(NonPersistentSiteThreadLocalCache)}.
   * <ul>
   *   <li>When {@link NonPersistentSiteThreadLocalCache} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NonPersistentSiteThreadLocalCache#setSitesCache(NonPersistentSiteThreadLocalCache)}
   */
  @Test
  public void testSetSitesCache_whenNonPersistentSiteThreadLocalCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    NonPersistentSiteThreadLocalCache.setSitesCache(new NonPersistentSiteThreadLocalCache());
  }

  /**
   * Test {@link NonPersistentSiteThreadLocalCache#clear()}.
   * <ul>
   *   <li>Given {@link NonPersistentSiteThreadLocalCache} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link NonPersistentSiteThreadLocalCache#clear()}
   */
  @Test
  public void testClear_givenNonPersistentSiteThreadLocalCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new NonPersistentSiteThreadLocalCache()).clear();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link NonPersistentSiteThreadLocalCache}
   *   <li>{@link NonPersistentSiteThreadLocalCache#setSites(Map)}
   *   <li>{@link NonPersistentSiteThreadLocalCache#getSites()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NonPersistentSiteThreadLocalCache actualNonPersistentSiteThreadLocalCache = new NonPersistentSiteThreadLocalCache();
    HashMap<Long, Site> sites = new HashMap<>();
    actualNonPersistentSiteThreadLocalCache.setSites(sites);
    Map<Long, Site> actualSites = actualNonPersistentSiteThreadLocalCache.getSites();

    // Assert that nothing has changed
    assertTrue(actualSites.isEmpty());
    assertSame(sites, actualSites);
  }
}
