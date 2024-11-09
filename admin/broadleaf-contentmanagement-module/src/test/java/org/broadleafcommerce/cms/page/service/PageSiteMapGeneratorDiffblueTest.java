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
package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.cms.page.dao.PageDao;
import org.broadleafcommerce.cms.page.dao.PageDaoImpl;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration;
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.service.SiteMapBuilder;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.junit.Test;

public class PageSiteMapGeneratorDiffblueTest {
  /**
   * Test
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));

    // Act and Assert
    assertFalse(pageSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = mock(
        CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType("Type", "Friendly Type"));

    // Act
    boolean actualCanHandleSiteMapConfigurationResult = pageSiteMapGenerator
        .canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertFalse(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = mock(
        CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType("PAGE", "Friendly Type"));

    // Act
    boolean actualCanHandleSiteMapConfigurationResult = pageSiteMapGenerator
        .canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(new SiteMapGeneratorType("PAGE", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));

    // Act and Assert
    assertTrue(pageSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CustomUrlSiteMapGeneratorConfigurationImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_whenCustomUrlSiteMapGeneratorConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    // Act and Assert
    assertFalse(pageSiteMapGenerator.canHandleSiteMapConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  public void testGenerateUri_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    PageImpl page = mock(PageImpl.class);
    when(page.getFullUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUriResult = pageSiteMapGenerator.generateUri(smb, page);

    // Assert
    verify(page).getFullUrl();
    assertEquals("/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  public void testGenerateUri_givenSlash_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    PageImpl page = mock(PageImpl.class);
    when(page.getFullUrl()).thenReturn("/");

    // Act
    String actualGenerateUriResult = pageSiteMapGenerator.generateUri(smb, page);

    // Assert
    verify(page).getFullUrl();
    assertEquals("https://example.org/example/", actualGenerateUriResult);
  }

  /**
   * Test {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  public void testGenerateUri_givenSlash_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    PageImpl page = mock(PageImpl.class);
    when(page.getFullUrl()).thenReturn("/");

    // Act
    String actualGenerateUriResult = pageSiteMapGenerator.generateUri(smb, page);

    // Assert
    verify(page).getFullUrl();
    assertEquals("/", actualGenerateUriResult);
  }

  /**
   * Test {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    PageImpl page = mock(PageImpl.class);
    when(page.getFullUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUriResult = pageSiteMapGenerator.generateUri(smb, page);

    // Assert
    verify(page).getFullUrl();
    assertEquals("https://example.org/example/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageSiteMapGenerator#setPageDao(PageDao)}
   *   <li>{@link PageSiteMapGenerator#setRowLimit(int)}
   *   <li>{@link PageSiteMapGenerator#getPageDao()}
   *   <li>{@link PageSiteMapGenerator#getRowLimit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    PageDaoImpl pageDao = new PageDaoImpl();

    // Act
    pageSiteMapGenerator.setPageDao(pageDao);
    pageSiteMapGenerator.setRowLimit(1);
    PageDao actualPageDao = pageSiteMapGenerator.getPageDao();

    // Assert that nothing has changed
    assertTrue(actualPageDao instanceof PageDaoImpl);
    assertEquals(1, pageSiteMapGenerator.getRowLimit());
    assertSame(pageDao, actualPageDao);
  }
}
