/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PageSiteMapGeneratorDiffblueTest {
  @Mock
  private PageDao pageDao;

  @InjectMocks
  private PageSiteMapGenerator pageSiteMapGenerator;

  /**
   * Test {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test: {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration() {
    // Arrange
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
   * Test {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_thenReturnTrue() {
    // Arrange
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
   * Test {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CustomUrlSiteMapGeneratorConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_whenCustomUrlSiteMapGeneratorConfigurationImpl() {
    // Arrange, Act and Assert
    assertFalse(pageSiteMapGenerator.canHandleSiteMapConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test: {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("https://example.org/example");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any())).thenReturn(pageList);
    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true));

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(eq(0), eq(0), eq("fullUrl"));
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PageImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenArrayListAddPageImpl() {
    // Arrange
    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(new PageImpl());
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any())).thenReturn(pageList);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(eq(0), eq(0), eq("fullUrl"));
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getExcludeFromSiteMap()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenPageImplGetExcludeFromSiteMapReturnTrue() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(true);

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any())).thenReturn(pageList);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(eq(0), eq(0), eq("fullUrl"));
    verify(pageImpl).getExcludeFromSiteMap();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getFullUrl()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenPageImplGetFullUrlReturnEmptyString() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any())).thenReturn(pageList);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(eq(0), eq(0), eq("fullUrl"));
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getFullUrl()} return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenPageImplGetFullUrlReturnSlash() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("/");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any())).thenReturn(pageList);
    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true));

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(eq(0), eq(0), eq("fullUrl"));
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getFullUrl()} return {@code /}.</li>
   *   <li>Then calls {@link PageImpl#getFullUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenPageImplGetFullUrlReturnSlash_thenCallsGetFullUrl() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("/");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any())).thenReturn(pageList);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(eq(0), eq(0), eq("fullUrl"));
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Then calls {@link PageImpl#getFullUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_thenCallsGetFullUrl() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("https://example.org/example");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any())).thenReturn(pageList);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(eq(0), eq(0), eq("fullUrl"));
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Then calls {@link SiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_thenCallsGetSiteMapChangeFreq() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("https://example.org/example");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any())).thenReturn(pageList);
    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(eq(0), eq(0), eq("fullUrl"));
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
  }

  /**
   * Test {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageSiteMapGenerator.generateUri(SiteMapBuilder, Page)"})
  public void testGenerateUri_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange
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
   * Method under test: {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageSiteMapGenerator.generateUri(SiteMapBuilder, Page)"})
  public void testGenerateUri_givenSlash_thenReturnHttpsExampleOrgExample() {
    // Arrange
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
   * Method under test: {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageSiteMapGenerator.generateUri(SiteMapBuilder, Page)"})
  public void testGenerateUri_givenSlash_thenReturnSlash() {
    // Arrange
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
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageSiteMapGenerator.generateUri(SiteMapBuilder, Page)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDao PageSiteMapGenerator.getPageDao()", "int PageSiteMapGenerator.getRowLimit()",
      "void PageSiteMapGenerator.setPageDao(PageDao)", "void PageSiteMapGenerator.setRowLimit(int)"})
  public void testGettersAndSetters() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    PageDaoImpl pageDao = new PageDaoImpl();

    // Act
    pageSiteMapGenerator.setPageDao(pageDao);
    pageSiteMapGenerator.setRowLimit(1);
    PageDao actualPageDao = pageSiteMapGenerator.getPageDao();

    // Assert
    assertTrue(actualPageDao instanceof PageDaoImpl);
    assertEquals(1, pageSiteMapGenerator.getRowLimit());
    assertSame(pageDao, actualPageDao);
  }
}
