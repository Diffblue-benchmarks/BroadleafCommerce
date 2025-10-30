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
package org.broadleafcommerce.common.sitemap.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteMapBuilderDiffblueTest {
  /**
   * Test {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}.
   * <p>
   * Method under test: {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapBuilder.<init>(SiteMapConfiguration, FileWorkArea, String, boolean)"})
  public void testNewSiteMapBuilder() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    SiteMapBuilder actualSiteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(),
        "https://example.org/example", true);

    // Assert
    SiteMapConfiguration siteMapConfiguration = actualSiteMapBuilder.siteMapConfig;
    assertTrue(siteMapConfiguration instanceof SiteMapConfigurationImpl);
    assertEquals("https://example.org/example", actualSiteMapBuilder.getBaseUrl());
    assertEquals("sitemap###.xml", siteMapConfiguration.getSiteMapIndexFilePattern());
    assertEquals("sitemap.xml", siteMapConfiguration.getIndexedSiteMapFileName());
    assertEquals("sitemap.xml", siteMapConfiguration.getSiteMapFileName());
    assertEquals('N', ((SiteMapConfigurationImpl) siteMapConfiguration).getArchived().charValue());
    assertNull(siteMapConfiguration.getId());
    assertNull(siteMapConfiguration.getModuleName());
    assertNull(siteMapConfiguration.getActiveEndDate());
    assertNull(siteMapConfiguration.getActiveStartDate());
    assertEquals(100, siteMapConfiguration.getPriority().intValue());
    assertEquals(50000, siteMapConfiguration.getMaximumUrlEntriesPerFile().intValue());
    assertFalse(siteMapConfiguration.getIsDefault());
    assertTrue(siteMapConfiguration.getSiteMapGeneratorConfigurations().isEmpty());
    assertTrue(actualSiteMapBuilder.getIndexedFileNames().isEmpty());
    assertTrue(actualSiteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
    assertTrue(actualSiteMapBuilder.gzipSiteMapFiles);
  }

  /**
   * Test {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}.
   * <p>
   * Method under test: {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapBuilder.addUrl(SiteMapURLWrapper)"})
  public void testAddUrl() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);
    SiteMapURLWrapper urlWrapper = new SiteMapURLWrapper();

    // Act
    siteMapBuilder.addUrl(urlWrapper);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    assertSame(urlWrapper, siteMapUrlWrappers.get(0));
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn1() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###");

    // Act and Assert
    assertEquals("1", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1Indexed Site Map File Pattern}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn1IndexedSiteMapFilePattern() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###Indexed Site Map File Pattern");

    // Act and Assert
    assertEquals("1Indexed Site Map File Pattern",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1.xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn1Xml() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###.xml");

    // Act and Assert
    assertEquals("1.xml", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1sitemap.xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn1sitemapXml() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###sitemap.xml");

    // Act and Assert
    assertEquals("1sitemap.xml",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1###}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn12() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("######");

    // Act and Assert
    assertEquals("1###", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 1/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn13() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###/");

    // Act and Assert
    assertEquals("1/", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code 142}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn142() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###42");

    // Act and Assert
    assertEquals("142", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   * <ul>
   *   <li>Then return {@code sitemap1.xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturnSitemap1Xml() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act and Assert
    assertEquals("sitemap1.xml",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapBuilder#getBaseUrl()}
   *   <li>{@link SiteMapBuilder#getIndexedFileNames()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapBuilder.getBaseUrl()", "List SiteMapBuilder.getIndexedFileNames()"})
  public void testGettersAndSetters() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    String actualBaseUrl = siteMapBuilder.getBaseUrl();

    // Assert
    assertEquals("https://example.org/example", actualBaseUrl);
    assertTrue(siteMapBuilder.getIndexedFileNames().isEmpty());
  }
}
