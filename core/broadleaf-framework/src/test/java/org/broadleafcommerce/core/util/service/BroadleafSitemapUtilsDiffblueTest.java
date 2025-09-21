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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.service.SiteMapBuilder;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafSitemapUtilsDiffblueTest {
  /**
   * Test {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}.
   *
   * <ul>
   *   <li>Given {@code Alt Text}.
   *   <li>Then return {@code /https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String BroadleafSitemapUtils.generateImageUrl(SiteMapBuilder, Media)"
  })
  public void testGenerateImageUrl_givenAltText_thenReturnHttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    MediaImpl media = new MediaImpl();
    media.setAltText("Alt Text");
    media.setId(1L);
    media.setTags("Tags");
    media.setTitle("Dr");
    media.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(
        "/https://example.org/example",
        BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }

  /**
   * Test {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>When {@link MediaDto} (default constructor) Url is {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String BroadleafSitemapUtils.generateImageUrl(SiteMapBuilder, Media)"
  })
  public void testGenerateImageUrl_givenSlash_whenMediaDtoUrlIsSlash_thenReturnSlash() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    MediaDto media = new MediaDto();
    media.setUrl("/");

    // Act and Assert
    assertEquals("/", BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }

  /**
   * Test {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String BroadleafSitemapUtils.generateImageUrl(SiteMapBuilder, Media)"
  })
  public void testGenerateImageUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    MediaImpl media = new MediaImpl();
    media.setAltText("/");
    media.setId(1L);
    media.setTags("/");
    media.setTitle("Dr");
    media.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(
        "https://example.org/example/https://example.org/example",
        BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }

  /**
   * Test {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}.
   *
   * <ul>
   *   <li>When {@link MediaDto} (default constructor) Url is {@code /}.
   *   <li>Then return {@code https://example.org/example/}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String BroadleafSitemapUtils.generateImageUrl(SiteMapBuilder, Media)"
  })
  public void testGenerateImageUrl_whenMediaDtoUrlIsSlash_thenReturnHttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    MediaDto media = new MediaDto();
    media.setUrl("/");

    // Act and Assert
    assertEquals(
        "https://example.org/example/",
        BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }
}
