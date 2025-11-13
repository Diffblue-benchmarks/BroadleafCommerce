package org.broadleafcommerce.common.sitemap.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea, String,
   * boolean)}.
   *
   * <p>Method under test: {@link SiteMapBuilder#SiteMapBuilder(SiteMapConfiguration, FileWorkArea,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapBuilder.<init>(SiteMapConfiguration, FileWorkArea, String, boolean)"
  })
  public void testNewSiteMapBuilder() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    // Act
    SiteMapBuilder actualSiteMapBuilder =
        new SiteMapBuilder(siteMapConfig, fileWorkArea, "https://example.org/example", true);

    // Assert
    SiteMapConfiguration siteMapConfiguration = actualSiteMapBuilder.siteMapConfig;
    assertTrue(siteMapConfiguration instanceof SiteMapConfigurationImpl);
    assertEquals("/directory/foo.txt/", actualSiteMapBuilder.fileWorkArea.getFilePathLocation());
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
   *
   * <p>Method under test: {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SiteMapBuilder.addUrl(SiteMapURLWrapper)"})
  public void testAddUrl() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);
    SiteMapURLWrapper urlWrapper = new SiteMapURLWrapper();

    // Act
    siteMapBuilder.addUrl(urlWrapper);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    assertSame(urlWrapper, siteMapUrlWrappers.get(0));
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   *
   * <ul>
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn1() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###");

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(siteMapConfig, fileWorkArea, "https://example.org/example", true);

    // Act and Assert
    assertEquals("1", siteMapBuilder.createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   *
   * <ul>
   *   <li>Then return {@code 1Indexed Site Map File Pattern}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn1IndexedSiteMapFilePattern() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###Indexed Site Map File Pattern");

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(siteMapConfig, fileWorkArea, "https://example.org/example", true);

    // Act and Assert
    assertEquals("1Indexed Site Map File Pattern", siteMapBuilder.createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   *
   * <ul>
   *   <li>Then return {@code 1.xml}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn1Xml() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###.xml");

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(siteMapConfig, fileWorkArea, "https://example.org/example", true);

    // Act and Assert
    assertEquals("1.xml", siteMapBuilder.createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   *
   * <ul>
   *   <li>Then return {@code 1sitemap.xml}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn1sitemapXml() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###sitemap.xml");

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(siteMapConfig, fileWorkArea, "https://example.org/example", true);

    // Act and Assert
    assertEquals("1sitemap.xml", siteMapBuilder.createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   *
   * <ul>
   *   <li>Then return {@code 1###}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn12() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("######");

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(siteMapConfig, fileWorkArea, "https://example.org/example", true);

    // Act and Assert
    assertEquals("1###", siteMapBuilder.createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   *
   * <ul>
   *   <li>Then return {@code 1/}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn13() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###/");

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(siteMapConfig, fileWorkArea, "https://example.org/example", true);

    // Act and Assert
    assertEquals("1/", siteMapBuilder.createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   *
   * <ul>
   *   <li>Then return {@code 142}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturn142() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("###42");

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(siteMapConfig, fileWorkArea, "https://example.org/example", true);

    // Act and Assert
    assertEquals("142", siteMapBuilder.createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   *
   * <ul>
   *   <li>Then return {@code Indexed Site Map File Pattern1}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturnIndexedSiteMapFilePattern1() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    siteMapConfig.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern###");

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(siteMapConfig, fileWorkArea, "https://example.org/example", true);

    // Act and Assert
    assertEquals("Indexed Site Map File Pattern1", siteMapBuilder.createNextIndexedFileName());
  }

  /**
   * Test {@link SiteMapBuilder#createNextIndexedFileName()}.
   *
   * <ul>
   *   <li>Then return {@code sitemap1.xml}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapBuilder#createNextIndexedFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapBuilder.createNextIndexedFileName()"})
  public void testCreateNextIndexedFileName_thenReturnSitemap1Xml() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act and Assert
    assertEquals("sitemap1.xml", siteMapBuilder.createNextIndexedFileName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapBuilder#getBaseUrl()}
   *   <li>{@link SiteMapBuilder#getIndexedFileNames()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SiteMapBuilder.getBaseUrl()",
    "List SiteMapBuilder.getIndexedFileNames()"
  })
  public void testGettersAndSetters() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    String actualBaseUrl = siteMapBuilder.getBaseUrl();

    // Assert
    assertEquals("https://example.org/example", actualBaseUrl);
    assertTrue(siteMapBuilder.getIndexedFileNames().isEmpty());
  }
}
