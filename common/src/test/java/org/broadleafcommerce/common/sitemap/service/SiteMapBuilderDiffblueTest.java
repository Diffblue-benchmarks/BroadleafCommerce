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
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper;
import org.junit.Test;

public class SiteMapBuilderDiffblueTest {
  /**
   * Method under test: {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}
   */
  @Test
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
   * Method under test: {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}
   */
  @Test
  public void testAddUrl2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(50000L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(50000L);

    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setAuditable(auditable);
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
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act and Assert
    assertEquals("sitemap1.xml",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName2() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###");

    // Act and Assert
    assertEquals("1", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName3() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("######");

    // Act and Assert
    assertEquals("1###", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName4() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###Indexed Site Map File Pattern");

    // Act and Assert
    assertEquals("1Indexed Site Map File Pattern",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName5() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###42");

    // Act and Assert
    assertEquals("142", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName6() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###.xml");

    // Act and Assert
    assertEquals("1.xml", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName7() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###/");

    // Act and Assert
    assertEquals("1/", (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
        .createNextIndexedFileName());
  }

  /**
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName8() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###sitemap.xml");

    // Act and Assert
    assertEquals("1sitemap.xml",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName9() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setAuditable(auditable);

    // Act and Assert
    assertEquals("sitemap1.xml",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  public void testCreateNextIndexedFileName10() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern###");

    // Act and Assert
    assertEquals("Indexed Site Map File Pattern1",
        (new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true))
            .createNextIndexedFileName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapBuilder#getBaseUrl()}
   *   <li>{@link SiteMapBuilder#getIndexedFileNames()}
   * </ul>
   */
  @Test
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

  /**
   * Method under test:
   * {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}
   */
  @Test
  public void testNewSiteMapBuilder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    SiteMapBuilder actualSiteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(),
        "https://example.org/example", true);

    // Assert
    SiteMapConfiguration siteMapConfiguration = actualSiteMapBuilder.siteMapConfig;
    assertTrue(siteMapConfiguration instanceof SiteMapConfigurationImpl);
    ModuleConfigurationType moduleConfigurationType = siteMapConfiguration.getModuleConfigurationType();
    assertEquals("SITE_MAP", moduleConfigurationType.getType());
    assertEquals("Site Map Generator", moduleConfigurationType.getFriendlyType());
    assertEquals("https://example.org/example", actualSiteMapBuilder.getBaseUrl());
    assertEquals("sitemap###.xml", siteMapConfiguration.getSiteMapIndexFilePattern());
    assertEquals("sitemap.xml", siteMapConfiguration.getIndexedSiteMapFileName());
    assertEquals("sitemap.xml", siteMapConfiguration.getSiteMapFileName());
    assertEquals('N', ((SiteMapConfigurationImpl) siteMapConfiguration).getArchived().charValue());
    Auditable auditable = siteMapConfiguration.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(siteMapConfiguration.getId());
    assertNull(siteMapConfiguration.getModuleName());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
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
   * Method under test:
   * {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String, boolean)}
   */
  @Test
  public void testNewSiteMapBuilder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfig = mock(SiteMapConfigurationImpl.class);

    // Act
    SiteMapBuilder actualSiteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(),
        "https://example.org/example", true);

    // Assert
    assertEquals("https://example.org/example", actualSiteMapBuilder.getBaseUrl());
    assertTrue(actualSiteMapBuilder.getIndexedFileNames().isEmpty());
    assertTrue(actualSiteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
    assertTrue(actualSiteMapBuilder.gzipSiteMapFiles);
  }
}
