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
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.junit.Test;

public class SiteMapConfigurationImplDiffblueTest {
  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}
   */
  @Test
  public void testGetMaximumUrlEntriesPerFile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(50000, (new SiteMapConfigurationImpl()).getMaximumUrlEntriesPerFile().intValue());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}
   */
  @Test
  public void testGetMaximumUrlEntriesPerFile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(1);

    // Act and Assert
    assertEquals(1, siteMapConfigurationImpl.getMaximumUrlEntriesPerFile().intValue());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getMaximumUrlEntriesPerFile()}
   */
  @Test
  public void testGetMaximumUrlEntriesPerFile3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setActiveEndDate(mock(java.sql.Date.class));
    siteMapConfigurationImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(1);

    // Act and Assert
    assertEquals(1, siteMapConfigurationImpl.getMaximumUrlEntriesPerFile().intValue());
  }

  /**
   * Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  public void testFixSiteUrlPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new SiteMapConfigurationImpl()).fixSiteUrlPath("https://example.org/example"));
  }

  /**
   * Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  public void testFixSiteUrlPath2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());

    // Act and Assert
    assertNull(siteMapConfigurationImpl.fixSiteUrlPath(null));
  }

  /**
   * Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  public void testFixSiteUrlPath3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());

    // Act and Assert
    assertEquals("", siteMapConfigurationImpl.fixSiteUrlPath("/"));
  }

  /**
   * Method under test: {@link SiteMapConfigurationImpl#fixSiteUrlPath(String)}
   */
  @Test
  public void testFixSiteUrlPath4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setActiveEndDate(mock(java.sql.Date.class));
    siteMapConfigurationImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());

    // Act and Assert
    assertNull(siteMapConfigurationImpl.fixSiteUrlPath(null));
  }

  /**
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  public void testGetSiteMapFileName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("sitemap.xml", (new SiteMapConfigurationImpl()).getSiteMapFileName());
  }

  /**
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  public void testGetSiteMapFileName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setSiteMapFileName("foo");

    // Act and Assert
    assertEquals("foo", siteMapConfigurationImpl.getSiteMapFileName());
  }

  /**
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  public void testGetSiteMapFileName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setActiveEndDate(mock(java.sql.Date.class));
    siteMapConfigurationImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setSiteMapFileName("foo");

    // Act and Assert
    assertEquals("foo", siteMapConfigurationImpl.getSiteMapFileName());
  }

  /**
   * Method under test: {@link SiteMapConfigurationImpl#getSiteMapFileName()}
   */
  @Test
  public void testGetSiteMapFileName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setSiteMapFileName("");

    // Act and Assert
    assertEquals("sitemap.xml", siteMapConfigurationImpl.getSiteMapFileName());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  public void testGetIndexedSiteMapFileName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("sitemap.xml", (new SiteMapConfigurationImpl()).getIndexedSiteMapFileName());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  public void testGetIndexedSiteMapFileName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setIndexedSiteMapFileName(null);
    siteMapConfigurationImpl.setSiteMapFileName("foo");

    // Act and Assert
    assertEquals("foo", siteMapConfigurationImpl.getIndexedSiteMapFileName());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  public void testGetIndexedSiteMapFileName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo");
    siteMapConfigurationImpl.setSiteMapFileName(null);

    // Act and Assert
    assertEquals("foo", siteMapConfigurationImpl.getIndexedSiteMapFileName());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  public void testGetIndexedSiteMapFileName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setActiveEndDate(mock(java.sql.Date.class));
    siteMapConfigurationImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setIndexedSiteMapFileName(null);
    siteMapConfigurationImpl.setSiteMapFileName("foo");

    // Act and Assert
    assertEquals("foo", siteMapConfigurationImpl.getIndexedSiteMapFileName());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getIndexedSiteMapFileName()}
   */
  @Test
  public void testGetIndexedSiteMapFileName5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("Indexed Site Map File Pattern");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setIndexedSiteMapFileName("");
    siteMapConfigurationImpl.setSiteMapFileName("foo");

    // Act and Assert
    assertEquals("foo", siteMapConfigurationImpl.getIndexedSiteMapFileName());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  public void testGetSiteMapIndexFilePattern() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("sitemap###.xml", (new SiteMapConfigurationImpl()).getSiteMapIndexFilePattern());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  public void testGetSiteMapIndexFilePattern2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("###");
    siteMapConfigurationImpl.setSiteMapFileName(null);

    // Act and Assert
    assertEquals("###", siteMapConfigurationImpl.getSiteMapIndexFilePattern());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  public void testGetSiteMapIndexFilePattern3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern(null);
    siteMapConfigurationImpl.setSiteMapFileName("foo");

    // Act and Assert
    assertEquals("sitemap###.xml", siteMapConfigurationImpl.getSiteMapIndexFilePattern());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  public void testGetSiteMapIndexFilePattern4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("foo");
    siteMapConfigurationImpl.setSiteMapFileName(null);

    // Act and Assert
    assertEquals("sitemap###.xml", siteMapConfigurationImpl.getSiteMapIndexFilePattern());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  public void testGetSiteMapIndexFilePattern5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setActiveEndDate(mock(java.sql.Date.class));
    siteMapConfigurationImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("###");
    siteMapConfigurationImpl.setSiteMapFileName(null);

    // Act and Assert
    assertEquals("###", siteMapConfigurationImpl.getSiteMapIndexFilePattern());
  }

  /**
   * Method under test:
   * {@link SiteMapConfigurationImpl#getSiteMapIndexFilePattern()}
   */
  @Test
  public void testGetSiteMapIndexFilePattern6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setArchived('A');
    siteMapConfigurationImpl.setAuditable(auditable);
    siteMapConfigurationImpl.setId(1L);
    siteMapConfigurationImpl.setIndexedSiteMapFileName("foo.txt");
    siteMapConfigurationImpl.setIsDefault(true);
    siteMapConfigurationImpl.setMaximumUrlEntriesPerFile(3);
    siteMapConfigurationImpl.setModuleName("Name");
    siteMapConfigurationImpl.setPriority(1);
    siteMapConfigurationImpl.setSiteMapGeneratorConfigurations(new ArrayList<>());
    siteMapConfigurationImpl.setIndexedSiteMapFilePattern("");
    siteMapConfigurationImpl.setSiteMapFileName(null);

    // Act and Assert
    assertEquals("sitemap###.xml", siteMapConfigurationImpl.getSiteMapIndexFilePattern());
  }

  /**
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

    // Assert that nothing has changed
    assertTrue(actualSiteMapGeneratorConfigurations.isEmpty());
    assertSame(siteMapGeneratorConfigurations, actualSiteMapGeneratorConfigurations);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link SiteMapConfigurationImpl}
   */
  @Test
  public void testNewSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SiteMapConfigurationImpl actualSiteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Assert
    ModuleConfigurationType moduleConfigurationType = actualSiteMapConfigurationImpl.getModuleConfigurationType();
    assertEquals("SITE_MAP", moduleConfigurationType.getType());
    assertEquals("Site Map Generator", moduleConfigurationType.getFriendlyType());
    assertEquals("sitemap###.xml", actualSiteMapConfigurationImpl.getSiteMapIndexFilePattern());
    assertEquals("sitemap.xml", actualSiteMapConfigurationImpl.getIndexedSiteMapFileName());
    assertEquals("sitemap.xml", actualSiteMapConfigurationImpl.getSiteMapFileName());
    assertEquals('N', actualSiteMapConfigurationImpl.getArchived().charValue());
    assertNull(actualSiteMapConfigurationImpl.maximumURLEntriesPerFile);
    Auditable auditable = actualSiteMapConfigurationImpl.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(actualSiteMapConfigurationImpl.getId());
    assertNull(actualSiteMapConfigurationImpl.getModuleName());
    assertNull(actualSiteMapConfigurationImpl.indexedSiteMapFileName);
    assertNull(actualSiteMapConfigurationImpl.indexedSiteMapFilePattern);
    assertNull(actualSiteMapConfigurationImpl.siteMapFileName);
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(actualSiteMapConfigurationImpl.getActiveEndDate());
    assertNull(actualSiteMapConfigurationImpl.getActiveStartDate());
    assertEquals(100, actualSiteMapConfigurationImpl.getPriority().intValue());
    assertEquals(50000, actualSiteMapConfigurationImpl.getMaximumUrlEntriesPerFile().intValue());
    assertFalse(actualSiteMapConfigurationImpl.getIsDefault());
    assertTrue(actualSiteMapConfigurationImpl.getSiteMapGeneratorConfigurations().isEmpty());
  }
}
