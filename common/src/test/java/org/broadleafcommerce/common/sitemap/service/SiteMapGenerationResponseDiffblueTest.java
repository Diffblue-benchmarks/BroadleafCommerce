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
package org.broadleafcommerce.common.sitemap.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SiteMapGenerationResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapGenerationResponse}
   *   <li>{@link SiteMapGenerationResponse#setErrorCode(String)}
   *   <li>{@link SiteMapGenerationResponse#setHasError(boolean)}
   *   <li>{@link SiteMapGenerationResponse#setSiteMapFilePaths(List)}
   *   <li>{@link SiteMapGenerationResponse#setSitemapIndexFileName(String)}
   *   <li>{@link SiteMapGenerationResponse#getErrorCode()}
   *   <li>{@link SiteMapGenerationResponse#getSiteMapFilePaths()}
   *   <li>{@link SiteMapGenerationResponse#getSitemapIndexFileName()}
   *   <li>{@link SiteMapGenerationResponse#isHasError()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapGenerationResponse actualSiteMapGenerationResponse = new SiteMapGenerationResponse();
    actualSiteMapGenerationResponse.setErrorCode("An error occurred");
    actualSiteMapGenerationResponse.setHasError(true);
    ArrayList<String> siteMapFilePaths = new ArrayList<>();
    actualSiteMapGenerationResponse.setSiteMapFilePaths(siteMapFilePaths);
    actualSiteMapGenerationResponse.setSitemapIndexFileName("foo.txt");
    String actualErrorCode = actualSiteMapGenerationResponse.getErrorCode();
    List<String> actualSiteMapFilePaths = actualSiteMapGenerationResponse.getSiteMapFilePaths();
    String actualSitemapIndexFileName = actualSiteMapGenerationResponse.getSitemapIndexFileName();
    boolean actualIsHasErrorResult = actualSiteMapGenerationResponse.isHasError();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualErrorCode);
    assertEquals("foo.txt", actualSitemapIndexFileName);
    assertTrue(actualSiteMapFilePaths.isEmpty());
    assertTrue(actualIsHasErrorResult);
    assertSame(siteMapFilePaths, actualSiteMapFilePaths);
  }
}
