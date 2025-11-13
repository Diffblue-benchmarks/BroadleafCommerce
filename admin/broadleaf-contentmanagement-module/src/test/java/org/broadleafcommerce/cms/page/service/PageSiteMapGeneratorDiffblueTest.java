package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.broadleafcommerce.cms.page.dao.PageDao;
import org.broadleafcommerce.cms.page.dao.PageDaoImpl;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
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
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PageSiteMapGeneratorDiffblueTest {
  /**
   * Test {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#PAGE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenPage_thenReturnTrue() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    SiteMapGeneratorConfiguration siteMapGeneratorConfiguration =
        mock(SiteMapGeneratorConfiguration.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(SiteMapGeneratorType.PAGE);

    // Act
    boolean actualCanHandleSiteMapConfigurationResult =
        pageSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#SiteMapGeneratorType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenSiteMapGeneratorType() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    SiteMapGeneratorConfiguration siteMapGeneratorConfiguration =
        mock(SiteMapGeneratorConfiguration.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType());

    // Act
    boolean actualCanHandleSiteMapConfigurationResult =
        pageSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertFalse(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenTrue() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration =
        new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(
        new SiteMapGeneratorType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType());

    // Act and Assert
    assertFalse(pageSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>When {@link CustomUrlSiteMapGeneratorConfigurationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_whenCustomUrlSiteMapGeneratorConfigurationImpl() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    // Act and Assert
    assertFalse(
        pageSiteMapGenerator.canHandleSiteMapConfiguration(
            new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("https://example.org/example");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);

    PageDaoImpl pageDao = mock(PageDaoImpl.class);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any()))
        .thenReturn(pageList);

    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    pageSiteMapGenerator.setPageDao(pageDao);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(0, 0, "fullUrl");
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PageImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenArrayListAddPageImpl() {
    // Arrange
    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(new PageImpl());

    PageDaoImpl pageDao = mock(PageDaoImpl.class);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any()))
        .thenReturn(pageList);

    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    pageSiteMapGenerator.setPageDao(pageDao);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(0, 0, "fullUrl");
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getExcludeFromSiteMap()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenPageImplGetExcludeFromSiteMapReturnTrue() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(true);

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);

    PageDaoImpl pageDao = mock(PageDaoImpl.class);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any()))
        .thenReturn(pageList);

    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    pageSiteMapGenerator.setPageDao(pageDao);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(0, 0, "fullUrl");
    verify(pageImpl).getExcludeFromSiteMap();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getFullUrl()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenPageImplGetFullUrlReturnEmptyString() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);

    PageDaoImpl pageDao = mock(PageDaoImpl.class);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any()))
        .thenReturn(pageList);

    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    pageSiteMapGenerator.setPageDao(pageDao);
    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(0, 0, "fullUrl");
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getFullUrl()} return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenPageImplGetFullUrlReturnSlash() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("/");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);

    PageDaoImpl pageDao = mock(PageDaoImpl.class);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any()))
        .thenReturn(pageList);

    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    pageSiteMapGenerator.setPageDao(pageDao);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(0, 0, "fullUrl");
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getFullUrl()} return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenPageImplGetFullUrlReturnSlash2() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("/");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);

    PageDaoImpl pageDao = mock(PageDaoImpl.class);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any()))
        .thenReturn(pageList);

    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    pageSiteMapGenerator.setPageDao(pageDao);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(0, 0, "fullUrl");
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Then calls {@link SiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_thenCallsGetSiteMapChangeFreq() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("https://example.org/example");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);

    PageDaoImpl pageDao = mock(PageDaoImpl.class);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any()))
        .thenReturn(pageList);

    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    pageSiteMapGenerator.setPageDao(pageDao);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(0, 0, "fullUrl");
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
  }

  /**
   * Test {@link PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>When {@link CustomUrlSiteMapGeneratorConfigurationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PageSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_whenCustomUrlSiteMapGeneratorConfigurationImpl() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getExcludeFromSiteMap()).thenReturn(false);
    when(pageImpl.getFullUrl()).thenReturn("https://example.org/example");

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);

    PageDaoImpl pageDao = mock(PageDaoImpl.class);
    when(pageDao.readOnlineAndIncludedPages(anyInt(), anyInt(), Mockito.<String>any()))
        .thenReturn(pageList);

    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();
    pageSiteMapGenerator.setPageDao(pageDao);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    pageSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(pageDao).readOnlineAndIncludedPages(0, 0, "fullUrl");
    verify(pageImpl).getExcludeFromSiteMap();
    verify(pageImpl, atLeast(1)).getFullUrl();
  }

  /**
   * Test {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}.
   *
   * <ul>
   *   <li>Then return {@code /https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageSiteMapGenerator.generateUri(SiteMapBuilder, Page)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExample() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    SiteMapBuilder smb = mock(SiteMapBuilder.class);
    when(smb.getBaseUrl()).thenReturn("/");

    PageImpl page = new PageImpl();
    page.setFullUrl("https://example.org/example");

    // Act
    String actualGenerateUriResult = pageSiteMapGenerator.generateUri(smb, page);

    // Assert
    verify(smb).getBaseUrl();
    assertEquals("/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/}.
   * </ul>
   *
   * <p>Method under test: {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageSiteMapGenerator.generateUri(SiteMapBuilder, Page)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExample2() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    SiteMapBuilder smb = mock(SiteMapBuilder.class);
    when(smb.getBaseUrl()).thenReturn("https://example.org/example");

    PageImpl page = new PageImpl();
    page.setFullUrl("/");

    // Act
    String actualGenerateUriResult = pageSiteMapGenerator.generateUri(smb, page);

    // Assert
    verify(smb).getBaseUrl();
    assertEquals("https://example.org/example/", actualGenerateUriResult);
  }

  /**
   * Test {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageSiteMapGenerator.generateUri(SiteMapBuilder, Page)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    SiteMapBuilder smb = mock(SiteMapBuilder.class);
    when(smb.getBaseUrl()).thenReturn("https://example.org/example");

    PageImpl page = new PageImpl();
    page.setFullUrl("https://example.org/example");

    // Act
    String actualGenerateUriResult = pageSiteMapGenerator.generateUri(smb, page);

    // Assert
    verify(smb).getBaseUrl();
    assertEquals(
        "https://example.org/example/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}.
   *
   * <ul>
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link PageSiteMapGenerator#generateUri(SiteMapBuilder, Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageSiteMapGenerator.generateUri(SiteMapBuilder, Page)"})
  public void testGenerateUri_thenReturnSlash() {
    // Arrange
    PageSiteMapGenerator pageSiteMapGenerator = new PageSiteMapGenerator();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPageTemplate(new PageTemplateImpl());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setFullUrl("/");

    // Act and Assert
    assertEquals("/", pageSiteMapGenerator.generateUri(smb, page));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageSiteMapGenerator#setPageDao(PageDao)}
   *   <li>{@link PageSiteMapGenerator#setRowLimit(int)}
   *   <li>{@link PageSiteMapGenerator#getPageDao()}
   *   <li>{@link PageSiteMapGenerator#getRowLimit()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageDao PageSiteMapGenerator.getPageDao()",
    "int PageSiteMapGenerator.getRowLimit()",
    "void PageSiteMapGenerator.setPageDao(PageDao)",
    "void PageSiteMapGenerator.setRowLimit(int)"
  })
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
