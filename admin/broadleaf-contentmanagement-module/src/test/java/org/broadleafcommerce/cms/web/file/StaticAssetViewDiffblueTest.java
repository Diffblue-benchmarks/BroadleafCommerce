/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StaticAssetViewDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetView}
   *   <li>{@link StaticAssetView#setBrowserAssetCachingEnabled(boolean)}
   *   <li>{@link StaticAssetView#setCacheSeconds(long)}
   *   <li>{@link StaticAssetView#getCacheSeconds()}
   *   <li>{@link StaticAssetView#getContentType()}
   *   <li>{@link StaticAssetView#isBrowserAssetCachingEnabled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetView actualStaticAssetView = new StaticAssetView();
    actualStaticAssetView.setBrowserAssetCachingEnabled(true);
    actualStaticAssetView.setCacheSeconds(1L);
    long actualCacheSeconds = actualStaticAssetView.getCacheSeconds();
    actualStaticAssetView.getContentType();

    // Assert that nothing has changed
    assertEquals(1L, actualCacheSeconds);
    assertTrue(actualStaticAssetView.isBrowserAssetCachingEnabled());
  }
}
