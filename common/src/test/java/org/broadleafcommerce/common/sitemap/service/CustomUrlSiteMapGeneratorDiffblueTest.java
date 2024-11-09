/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.sitemap.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration;
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntry;
import org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.junit.Test;

public class CustomUrlSiteMapGeneratorDiffblueTest {
  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = mock(
        CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType()).thenReturn(SiteMapGeneratorType.CATEGORY);

    // Act
    boolean actualCanHandleSiteMapConfigurationResult = customUrlSiteMapGenerator
        .canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertFalse(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = mock(
        CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType("CUSTOM", "CUSTOM"));

    // Act
    boolean actualCanHandleSiteMapConfigurationResult = customUrlSiteMapGenerator
        .canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#CUSTOM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_givenCustom() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = mock(
        CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType()).thenReturn(SiteMapGeneratorType.CUSTOM);

    // Act
    boolean actualCanHandleSiteMapConfigurationResult = customUrlSiteMapGenerator
        .canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_givenTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();

    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    siteMapGeneratorConfiguration.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act and Assert
    assertFalse(customUrlSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CustomUrlSiteMapGeneratorConfigurationImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_whenCustomUrlSiteMapGeneratorConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();

    // Act and Assert
    assertFalse(
        customUrlSiteMapGenerator.canHandleSiteMapConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries_givenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = mock(CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(smgc.getCustomURLEntries()).thenReturn(new ArrayList<>());
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getCustomURLEntries();
    assertTrue(siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SiteMapUrlEntryImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries_givenArrayListAddSiteMapUrlEntryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();

    ArrayList<SiteMapUrlEntry> siteMapUrlEntryList = new ArrayList<>();
    siteMapUrlEntryList.add(new SiteMapUrlEntryImpl());
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = mock(CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(smgc.getCustomURLEntries()).thenReturn(siteMapUrlEntryList);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getCustomURLEntries();
    assertTrue(siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link SiteMapUrlEntryImpl}
   * {@link SiteMapUrlEntryImpl#getLocation()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries_givenSiteMapUrlEntryImplGetLocationReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = mock(SiteMapUrlEntryImpl.class);
    when(siteMapUrlEntryImpl.getLocation()).thenReturn("");

    ArrayList<SiteMapUrlEntry> siteMapUrlEntryList = new ArrayList<>();
    siteMapUrlEntryList.add(siteMapUrlEntryImpl);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = mock(CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(smgc.getCustomURLEntries()).thenReturn(siteMapUrlEntryList);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getCustomURLEntries();
    verify(siteMapUrlEntryImpl).getLocation();
    assertTrue(siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>When {@link CustomUrlSiteMapGeneratorConfigurationImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries_whenCustomUrlSiteMapGeneratorConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert that nothing has changed
    assertTrue(siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code https://example.org/example/foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  public void testGenerateUri_givenFoo_thenReturnHttpsExampleOrgExampleFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    SiteMapUrlEntryImpl urlEntry = mock(SiteMapUrlEntryImpl.class);
    when(urlEntry.getLocation()).thenReturn("foo");

    // Act
    String actualGenerateUriResult = customUrlSiteMapGenerator.generateUri(smb, urlEntry);

    // Assert
    verify(urlEntry).getLocation();
    assertEquals("https://example.org/example/foo", actualGenerateUriResult);
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  public void testGenerateUri_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    SiteMapUrlEntryImpl urlEntry = mock(SiteMapUrlEntryImpl.class);
    when(urlEntry.getLocation()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUriResult = customUrlSiteMapGenerator.generateUri(smb, urlEntry);

    // Assert
    verify(urlEntry).getLocation();
    assertEquals("https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test
   * {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Then return {@code ://foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  public void testGenerateUri_thenReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "://", true);

    SiteMapUrlEntryImpl urlEntry = mock(SiteMapUrlEntryImpl.class);
    when(urlEntry.getLocation()).thenReturn("foo");

    // Act
    String actualGenerateUriResult = customUrlSiteMapGenerator.generateUri(smb, urlEntry);

    // Assert
    verify(urlEntry).getLocation();
    assertEquals("://foo", actualGenerateUriResult);
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateDate(SiteMapUrlEntry)}.
   * <ul>
   *   <li>Then calls {@link SiteMapUrlEntryImpl#getLastMod()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#generateDate(SiteMapUrlEntry)}
   */
  @Test
  public void testGenerateDate_thenCallsGetLastMod() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl urlEntry = mock(SiteMapUrlEntryImpl.class);
    when(urlEntry.getLastMod())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    customUrlSiteMapGenerator.generateDate(urlEntry);

    // Assert
    verify(urlEntry, atLeast(1)).getLastMod();
  }
}
