/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertEquals;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.service.SiteMapBuilder;
import org.junit.Test;

public class BroadleafSitemapUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  public void testGenerateImageUrl() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    MediaImpl media = new MediaImpl();
    media.setAltText("/");
    media.setId(1L);
    media.setTags("/");
    media.setTitle("Dr");
    media.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example/https://example.org/example",
        BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }

  /**
   * Method under test:
   * {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  public void testGenerateImageUrl2() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    MediaDto media = new MediaDto();
    media.setUrl("/");

    // Act and Assert
    assertEquals("https://example.org/example/", BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }

  /**
   * Method under test:
   * {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  public void testGenerateImageUrl3() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    MediaImpl media = new MediaImpl();
    media.setAltText("/");
    media.setId(1L);
    media.setTags("/");
    media.setTitle("Dr");
    media.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals("/https://example.org/example", BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }

  /**
   * Method under test:
   * {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  public void testGenerateImageUrl4() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    MediaDto media = new MediaDto();
    media.setUrl("/");

    // Act and Assert
    assertEquals("/", BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }
}
