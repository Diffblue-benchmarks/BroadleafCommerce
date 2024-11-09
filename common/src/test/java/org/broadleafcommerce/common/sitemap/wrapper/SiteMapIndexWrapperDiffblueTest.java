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
package org.broadleafcommerce.common.sitemap.wrapper;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SiteMapIndexWrapperDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapIndexWrapper}
   *   <li>{@link SiteMapIndexWrapper#setSiteMapWrappers(List)}
   *   <li>{@link SiteMapIndexWrapper#getSiteMapWrappers()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapIndexWrapper actualSiteMapIndexWrapper = new SiteMapIndexWrapper();
    ArrayList<SiteMapWrapper> siteMapWrappers = new ArrayList<>();
    actualSiteMapIndexWrapper.setSiteMapWrappers(siteMapWrappers);
    List<SiteMapWrapper> actualSiteMapWrappers = actualSiteMapIndexWrapper.getSiteMapWrappers();

    // Assert that nothing has changed
    assertTrue(actualSiteMapWrappers.isEmpty());
    assertSame(siteMapWrappers, actualSiteMapWrappers);
  }
}
