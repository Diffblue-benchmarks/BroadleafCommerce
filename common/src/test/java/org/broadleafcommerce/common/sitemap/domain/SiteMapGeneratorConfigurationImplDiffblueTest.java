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
package org.broadleafcommerce.common.sitemap.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteMapGeneratorConfigurationImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapGeneratorConfigurationImpl}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#setDisabled(Boolean)}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#setId(Long)}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#setSiteMapConfiguration(SiteMapConfiguration)}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#getId()}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#getSiteMapConfiguration()}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#isDisabled()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapGeneratorConfigurationImpl.<init>()",
      "Long SiteMapGeneratorConfigurationImpl.getId()",
      "SiteMapConfiguration SiteMapGeneratorConfigurationImpl.getSiteMapConfiguration()",
      "Boolean SiteMapGeneratorConfigurationImpl.isDisabled()",
      "void SiteMapGeneratorConfigurationImpl.setDisabled(Boolean)",
      "void SiteMapGeneratorConfigurationImpl.setId(Long)",
      "void SiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(SiteMapConfiguration)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapGeneratorConfigurationImpl actualSiteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    actualSiteMapGeneratorConfigurationImpl.setDisabled(true);
    actualSiteMapGeneratorConfigurationImpl.setId(1L);
    SiteMapConfigurationImpl siteMapConfiguration = new SiteMapConfigurationImpl();
    actualSiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(siteMapConfiguration);
    Long actualId = actualSiteMapGeneratorConfigurationImpl.getId();
    SiteMapConfiguration actualSiteMapConfiguration = actualSiteMapGeneratorConfigurationImpl.getSiteMapConfiguration();
    Boolean actualIsDisabledResult = actualSiteMapGeneratorConfigurationImpl.isDisabled();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertTrue(actualIsDisabledResult);
    assertSame(siteMapConfiguration, actualSiteMapConfiguration);
  }
}
