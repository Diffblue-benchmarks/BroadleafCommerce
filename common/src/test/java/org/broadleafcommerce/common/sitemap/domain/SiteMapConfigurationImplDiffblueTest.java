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
package org.broadleafcommerce.common.sitemap.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SiteMapConfigurationImplDiffblueTest {
  @Autowired
  private SiteMapConfigurationImpl siteMapConfigurationImpl;

  /**
   * Test new {@link SiteMapConfigurationImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SiteMapConfigurationImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SiteMapConfigurationImpl.getSiteMapGeneratorConfigurations()",
      "void SiteMapConfigurationImpl.setIndexedSiteMapFileName(String)",
      "void SiteMapConfigurationImpl.setIndexedSiteMapFilePattern(String)",
      "void SiteMapConfigurationImpl.setMaximumUrlEntriesPerFile(Integer)",
      "void SiteMapConfigurationImpl.setSiteMapFileName(String)",
      "void SiteMapConfigurationImpl.setSiteMapGeneratorConfigurations(List)"})
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
    List<SiteMapGeneratorConfiguration> actualSiteMapGeneratorConfigurations = siteMapConfigurationImpl
        .getSiteMapGeneratorConfigurations();

    // Assert
    assertTrue(actualSiteMapGeneratorConfigurations.isEmpty());
    assertSame(siteMapGeneratorConfigurations, actualSiteMapGeneratorConfigurations);
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}.
   * <ul>
   *   <li>Then return intValue is {@code 50000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer SiteMapConfigurationImpl.getMaximumUrlEntriesPerFile()"})
  public void testGetMaximumUrlEntriesPerFile_thenReturnIntValueIs50000() {
    // Arrange, Act and Assert
    assertEquals(50000, (new SiteMapConfigurationImpl()).getMaximumUrlEntriesPerFile().intValue());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer SiteMapConfigurationImpl.getMaximumUrlEntriesPerFile()"})
  public void testGetMaximumUrlEntriesPerFile_thenReturnIntValueIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2.setArchived('A');
    siteMapConfigurationImpl2.setAuditable(auditable);
    siteMapConfigurationImpl2.setId(1L);
    siteMapConfigurationImpl2.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl2.setIsDefault(true);
    siteMapConfigurationImpl2.setModuleName("Name");
    siteMapConfigurationImpl2.setPriority(1);
    siteMapConfigurationImpl2.setSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl2.setMaximumUrlEntriesPerFile(1);

    // Act and Assert
    assertEquals(1, siteMapConfigurationImpl2.getMaximumUrlEntriesPerFile().intValue());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.fixSiteUrlPath(String)"})
  public void testFixSiteUrlPath_givenAuditableCreatedByIsOne_whenNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2.setArchived('A');
    siteMapConfigurationImpl2.setAuditable(auditable);
    siteMapConfigurationImpl2.setId(1L);
    siteMapConfigurationImpl2.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl2.setIsDefault(true);
    siteMapConfigurationImpl2.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl2.setModuleName("Name");
    siteMapConfigurationImpl2.setPriority(1);
    siteMapConfigurationImpl2.setSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setSiteMapGeneratorConfigurations(new ArrayList<>());

    // Act and Assert
    assertNull(siteMapConfigurationImpl2.fixSiteUrlPath(null));
  }

  /**
   * Test {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.fixSiteUrlPath(String)"})
  public void testFixSiteUrlPath_givenAuditableCreatedByIsOne_whenSlash_thenReturnEmptyString() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2.setArchived('A');
    siteMapConfigurationImpl2.setAuditable(auditable);
    siteMapConfigurationImpl2.setId(1L);
    siteMapConfigurationImpl2.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl2.setIsDefault(true);
    siteMapConfigurationImpl2.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl2.setModuleName("Name");
    siteMapConfigurationImpl2.setPriority(1);
    siteMapConfigurationImpl2.setSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setSiteMapGeneratorConfigurations(new ArrayList<>());

    // Act and Assert
    assertEquals("", siteMapConfigurationImpl2.fixSiteUrlPath("/"));
  }

  /**
   * Test {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.fixSiteUrlPath(String)"})
  public void testFixSiteUrlPath_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new SiteMapConfigurationImpl()).fixSiteUrlPath("https://example.org/example"));
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapFileName()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapFileName()"})
  public void testGetSiteMapFileName_givenAuditableCreatedByIsOne_thenReturnFoo() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2.setArchived('A');
    siteMapConfigurationImpl2.setAuditable(auditable);
    siteMapConfigurationImpl2.setId(1L);
    siteMapConfigurationImpl2.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl2.setIsDefault(true);
    siteMapConfigurationImpl2.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl2.setModuleName("Name");
    siteMapConfigurationImpl2.setPriority(1);
    siteMapConfigurationImpl2.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl2.setSiteMapFileName("foo");

    // Act and Assert
    assertEquals("foo", siteMapConfigurationImpl2.getSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapFileName()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor) SiteMapFileName is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapFileName()"})
  public void testGetSiteMapFileName_givenSiteMapConfigurationImplSiteMapFileNameIsEmptyString() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2.setSiteMapFileName("");

    // Act and Assert
    assertEquals("sitemap.xml", siteMapConfigurationImpl2.getSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapFileName()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   *   <li>Then return {@code sitemap.xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapFileName()"})
  public void testGetSiteMapFileName_givenSiteMapConfigurationImpl_thenReturnSitemapXml() {
    // Arrange, Act and Assert
    assertEquals("sitemap.xml", (new SiteMapConfigurationImpl()).getSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}.
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getIndexedSiteMapFileName()"})
  public void testGetIndexedSiteMapFileName() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2.setArchived('A');
    siteMapConfigurationImpl2.setAuditable(auditable);
    siteMapConfigurationImpl2.setId(1L);
    siteMapConfigurationImpl2.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl2.setIsDefault(true);
    siteMapConfigurationImpl2.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl2.setModuleName("Name");
    siteMapConfigurationImpl2.setPriority(1);
    siteMapConfigurationImpl2.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl2.setIndexedSiteMapFileName(null);
    siteMapConfigurationImpl2.setSiteMapFileName("foo");

    // Act and Assert
    assertEquals("foo", siteMapConfigurationImpl2.getIndexedSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}.
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getIndexedSiteMapFileName()"})
  public void testGetIndexedSiteMapFileName2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2.setArchived('A');
    siteMapConfigurationImpl2.setAuditable(auditable);
    siteMapConfigurationImpl2.setId(1L);
    siteMapConfigurationImpl2.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl2.setIsDefault(true);
    siteMapConfigurationImpl2.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl2.setModuleName("Name");
    siteMapConfigurationImpl2.setPriority(1);
    siteMapConfigurationImpl2.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl2.setIndexedSiteMapFileName("foo");
    siteMapConfigurationImpl2.setSiteMapFileName(null);

    // Act and Assert
    assertEquals("foo", siteMapConfigurationImpl2.getIndexedSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}.
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getIndexedSiteMapFileName()"})
  public void testGetIndexedSiteMapFileName3() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2.setSiteMapFileName("");

    // Act and Assert
    assertEquals("sitemap.xml", siteMapConfigurationImpl2.getIndexedSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   *   <li>Then return {@code sitemap.xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getIndexedSiteMapFileName()"})
  public void testGetIndexedSiteMapFileName_givenSiteMapConfigurationImpl_thenReturnSitemapXml() {
    // Arrange, Act and Assert
    assertEquals("sitemap.xml", (new SiteMapConfigurationImpl()).getIndexedSiteMapFileName());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}.
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapIndexFilePattern()"})
  public void testGetSiteMapIndexFilePattern() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2.setArchived('A');
    siteMapConfigurationImpl2.setAuditable(auditable);
    siteMapConfigurationImpl2.setId(1L);
    siteMapConfigurationImpl2.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setIsDefault(true);
    siteMapConfigurationImpl2.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl2.setModuleName("Name");
    siteMapConfigurationImpl2.setPriority(1);
    siteMapConfigurationImpl2.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl2.setIndexedSiteMapFilePattern(null);
    siteMapConfigurationImpl2.setSiteMapFileName("foo");

    // Act and Assert
    assertEquals("sitemap###.xml", siteMapConfigurationImpl2.getSiteMapIndexFilePattern());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}.
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapIndexFilePattern()"})
  public void testGetSiteMapIndexFilePattern2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2.setArchived('A');
    siteMapConfigurationImpl2.setAuditable(auditable);
    siteMapConfigurationImpl2.setId(1L);
    siteMapConfigurationImpl2.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setIsDefault(true);
    siteMapConfigurationImpl2.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl2.setModuleName("Name");
    siteMapConfigurationImpl2.setPriority(1);
    siteMapConfigurationImpl2.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl2.setIndexedSiteMapFilePattern("foo");
    siteMapConfigurationImpl2.setSiteMapFileName(null);

    // Act and Assert
    assertEquals("sitemap###.xml", siteMapConfigurationImpl2.getSiteMapIndexFilePattern());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}.
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapIndexFilePattern()"})
  public void testGetSiteMapIndexFilePattern3() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2.setSiteMapFileName("");

    // Act and Assert
    assertEquals("sitemap###.xml", siteMapConfigurationImpl2.getSiteMapIndexFilePattern());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapIndexFilePattern()"})
  public void testGetSiteMapIndexFilePattern_givenSiteMapConfigurationImpl() {
    // Arrange, Act and Assert
    assertEquals("sitemap###.xml", (new SiteMapConfigurationImpl()).getSiteMapIndexFilePattern());
  }

  /**
   * Test {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}.
   * <ul>
   *   <li>Then return {@code ###}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteMapConfigurationImpl.getSiteMapIndexFilePattern()"})
  public void testGetSiteMapIndexFilePattern_thenReturnNumberSignNumberSignNumberSign() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl2 = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl2.setArchived('A');
    siteMapConfigurationImpl2.setAuditable(auditable);
    siteMapConfigurationImpl2.setId(1L);
    siteMapConfigurationImpl2.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl2.setIsDefault(true);
    siteMapConfigurationImpl2.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl2.setModuleName("Name");
    siteMapConfigurationImpl2.setPriority(1);
    siteMapConfigurationImpl2.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl2.setIndexedSiteMapFilePattern("###");
    siteMapConfigurationImpl2.setSiteMapFileName(null);

    // Act and Assert
    assertEquals("###", siteMapConfigurationImpl2.getSiteMapIndexFilePattern());
  }
}
