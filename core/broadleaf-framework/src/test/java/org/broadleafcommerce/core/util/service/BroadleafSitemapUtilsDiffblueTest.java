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
   * Test {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  public void testGenerateImageUrl_givenOne_thenReturnHttpsExampleOrgExample() {
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
   * Test {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>When {@link MediaDto} (default constructor) Url is {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  public void testGenerateImageUrl_givenSlash_whenMediaDtoUrlIsSlash_thenReturnSlash() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    MediaDto media = new MediaDto();
    media.setUrl("/");

    // Act and Assert
    assertEquals("/", BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }

  /**
   * Test {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  public void testGenerateImageUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
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
   * Test {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}.
   * <ul>
   *   <li>When {@link MediaDto} (default constructor) Url is {@code /}.</li>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSitemapUtils#generateImageUrl(SiteMapBuilder, Media)}
   */
  @Test
  public void testGenerateImageUrl_whenMediaDtoUrlIsSlash_thenReturnHttpsExampleOrgExample() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    MediaDto media = new MediaDto();
    media.setUrl("/");

    // Act and Assert
    assertEquals("https://example.org/example/", BroadleafSitemapUtils.generateImageUrl(siteMapBuilder, media));
  }
}
