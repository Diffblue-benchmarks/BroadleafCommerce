package org.broadleafcommerce.common.sitemap.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteMapConfigurationImplDiffblueTest {
  @Autowired private SiteMapConfigurationImpl siteMapConfigurationImpl;

  /**
   * Test new {@link SiteMapConfigurationImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SiteMapConfigurationImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SiteMapConfigurationImpl.<init>()"})
  public void testNewSiteMapConfigurationImpl() {
    // Arrange and Act
    SiteMapConfigurationImpl actualSiteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Assert
    assertEquals("sitemap###.xml", actualSiteMapConfigurationImpl.getSiteMapIndexFilePattern());
    assertEquals("sitemap.xml", actualSiteMapConfigurationImpl.getIndexedSiteMapFileName());
    assertEquals("sitemap.xml", actualSiteMapConfigurationImpl.getSiteMapFileName());
    assertEquals('N', actualSiteMapConfigurationImpl.getArchived().charValue());
    assertNull(actualSiteMapConfigurationImpl.maximumURLEntriesPerFile);
    assertNull(actualSiteMapConfigurationImpl.getId());
    assertNull(actualSiteMapConfigurationImpl.getModuleName());
    assertNull(actualSiteMapConfigurationImpl.indexedSiteMapFileName);
    assertNull(actualSiteMapConfigurationImpl.indexedSiteMapFilePattern);
    assertNull(actualSiteMapConfigurationImpl.siteMapFileName);
    assertNull(actualSiteMapConfigurationImpl.getActiveEndDate());
    assertNull(actualSiteMapConfigurationImpl.getActiveStartDate());
    assertEquals(100, actualSiteMapConfigurationImpl.getPriority().intValue());
    assertEquals(50000, actualSiteMapConfigurationImpl.getMaximumUrlEntriesPerFile().intValue());
    assertFalse(actualSiteMapConfigurationImpl.getIsDefault());
    assertTrue(actualSiteMapConfigurationImpl.getSiteMapGeneratorConfigurations().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapConfigurationImpl#setIndexedSiteMapFileName(String)}
   *   <li>{@link SiteMapConfigurationImpl#setIndexedSiteMapFilePattern(String)}
   *   <li>{@link SiteMapConfigurationImpl#setMaximumUrlEntriesPerFile(Integer)}
   *   <li>{@link SiteMapConfigurationImpl#setSiteMapFileName(String)}
   *   <li>{@link SiteMapConfigurationImpl#setSiteMapGeneratorConfigurations(List)}
   *   <li>{@link SiteMapConfigurationImpl#getSiteMapGeneratorConfigurations()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SiteMapConfigurationImpl.getSiteMapGeneratorConfigurations()",
    "void SiteMapConfigurationImpl.setIndexedSiteMapFileName(String)",
    "void SiteMapConfigurationImpl.setIndexedSiteMapFilePattern(String)",
    "void SiteMapConfigurationImpl.setMaximumUrlEntriesPerFile(Integer)",
    "void SiteMapConfigurationImpl.setSiteMapFileName(String)",
    "void SiteMapConfigurationImpl.setSiteMapGeneratorConfigurations(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setSiteMapFileName("foo.txt");
    ArrayList<SiteMapGeneratorConfiguration> siteMapGeneratorConfigurations = new ArrayList<>();
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(siteMapGeneratorConfigurations);
    List<SiteMapGeneratorConfiguration> actualSiteMapGeneratorConfigurations =
        siteMapConfigurationImpl.getSiteMapGeneratorConfigurations();

    // Assert
    assertTrue(actualSiteMapGeneratorConfigurations.isEmpty());
    assertSame(siteMapGeneratorConfigurations, actualSiteMapGeneratorConfigurations);
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}.
   *
   * <ul>
   *   <li>Then return intValue is {@code 50000}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SiteMapConfigurationImpl.getMaximumUrlEntriesPerFile()"})
  public void testGetMaximumUrlEntriesPerFile_thenReturnIntValueIs50000() {
    // Arrange, Act and Assert
    assertEquals(50000, siteMapConfigurationImpl.getMaximumUrlEntriesPerFile().intValue());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SiteMapConfigurationImpl.getMaximumUrlEntriesPerFile()"})
  public void testGetMaximumUrlEntriesPerFile_thenReturnIntValueIsOne() {
    // Arrange
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(1);

    // Act and Assert
    assertEquals(1, siteMapConfigurationImpl.getMaximumUrlEntriesPerFile().intValue());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.fixSiteUrlPath(String)"})
  public void testFixSiteUrlPath_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        siteMapConfigurationImpl.fixSiteUrlPath("https://example.org/example"));
  }

  /**
   * Test {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.fixSiteUrlPath(String)"})
  public void testFixSiteUrlPath_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(siteMapConfigurationImpl.fixSiteUrlPath(null));
  }

  /**
   * Test {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.fixSiteUrlPath(String)"})
  public void testFixSiteUrlPath_whenSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", siteMapConfigurationImpl.fixSiteUrlPath("/"));
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapFileName()}.
   *
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} SiteMapFileName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapFileName()"})
  public void testGetSiteMapFileName_givenSiteMapConfigurationImplSiteMapFileNameIsEmptyString() {
    // Arrange
    siteMapConfigurationImpl.setSiteMapFileName("");

    // Act and Assert
    assertEquals("sitemap.xml", siteMapConfigurationImpl.getSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapFileName()}.
   *
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl}.
   *   <li>Then return {@code sitemap.xml}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapFileName()"})
  public void testGetSiteMapFileName_givenSiteMapConfigurationImpl_thenReturnSitemapXml() {
    // Arrange, Act and Assert
    assertEquals("sitemap.xml", siteMapConfigurationImpl.getSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapFileName()}.
   *
   * <ul>
   *   <li>Then return {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapFileName()"})
  public void testGetSiteMapFileName_thenReturnFooTxt() {
    // Arrange
    siteMapConfigurationImpl.setSiteMapFileName("foo.txt");

    // Act and Assert
    assertEquals("foo.txt", siteMapConfigurationImpl.getSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}.
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getIndexedSiteMapFileName()"})
  public void testGetIndexedSiteMapFileName() {
    // Arrange
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setSiteMapFileName("");

    // Act and Assert
    assertEquals("foo.txt", siteMapConfigurationImpl.getIndexedSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}.
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getIndexedSiteMapFileName()"})
  public void testGetIndexedSiteMapFileName2() {
    // Arrange
    siteMapConfigurationImpl.setIndexedSiteMapFileName("");
    siteMapConfigurationImpl.setSiteMapFileName("foo.txt");

    // Act and Assert
    assertEquals("foo.txt", siteMapConfigurationImpl.getIndexedSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}.
   *
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl}.
   *   <li>Then return {@code sitemap.xml}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getIndexedSiteMapFileName()"})
  public void testGetIndexedSiteMapFileName_givenSiteMapConfigurationImpl_thenReturnSitemapXml() {
    // Arrange, Act and Assert
    assertEquals("sitemap.xml", siteMapConfigurationImpl.getIndexedSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}.
   *
   * <ul>
   *   <li>Then return {@code sitemap.xml}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getIndexedSiteMapFileName()"})
  public void testGetIndexedSiteMapFileName_thenReturnSitemapXml() {
    // Arrange
    siteMapConfigurationImpl.setIndexedSiteMapFileName("");
    siteMapConfigurationImpl.setSiteMapFileName("");

    // Act and Assert
    assertEquals("sitemap.xml", siteMapConfigurationImpl.getIndexedSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}.
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapIndexFilePattern()"})
  public void testGetSiteMapIndexFilePattern() {
    // Arrange
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("");
    siteMapConfigurationImpl.setSiteMapFileName(".xml");

    // Act and Assert
    assertEquals("sitemap###.xml", siteMapConfigurationImpl.getSiteMapIndexFilePattern());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}.
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapIndexFilePattern()"})
  public void testGetSiteMapIndexFilePattern2() {
    // Arrange
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern(".xml");
    siteMapConfigurationImpl.setSiteMapFileName(".xml");

    // Act and Assert
    assertEquals("sitemap###.xml", siteMapConfigurationImpl.getSiteMapIndexFilePattern());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}.
   *
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapIndexFilePattern()"})
  public void testGetSiteMapIndexFilePattern_givenSiteMapConfigurationImpl() {
    // Arrange, Act and Assert
    assertEquals("sitemap###.xml", siteMapConfigurationImpl.getSiteMapIndexFilePattern());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}.
   *
   * <ul>
   *   <li>Then return {@code ###}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapIndexFilePattern()"})
  public void testGetSiteMapIndexFilePattern_thenReturnNumberSignNumberSignNumberSign() {
    // Arrange
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("###");
    siteMapConfigurationImpl.setSiteMapFileName(".xml");

    // Act and Assert
    assertEquals("###", siteMapConfigurationImpl.getSiteMapIndexFilePattern());
  }
}
