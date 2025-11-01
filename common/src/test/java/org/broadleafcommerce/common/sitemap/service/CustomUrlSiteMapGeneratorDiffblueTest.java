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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper;
import org.junit.Test;

public class CustomUrlSiteMapGeneratorDiffblueTest {
  /**
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();

    // Act and Assert
    assertFalse(
        customUrlSiteMapGenerator.canHandleSiteMapConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration2() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration3() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration4() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration5() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries2() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries3() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = mock(SiteMapUrlEntryImpl.class);
    when(siteMapUrlEntryImpl.getLastMod())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(siteMapUrlEntryImpl.getSiteMapChangeFreq()).thenReturn(SiteMapChangeFreqType.ALWAYS);
    when(siteMapUrlEntryImpl.getSiteMapPriority()).thenReturn(SiteMapPriorityType.ONE);
    when(siteMapUrlEntryImpl.getLocation()).thenReturn("https://example.org/example");

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
    verify(siteMapUrlEntryImpl, atLeast(1)).getLastMod();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLocation();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapChangeFreq();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapPriority();
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("1970-01-01T00:00:00+00:00", getResult.getLastmod());
    assertEquals("always", getResult.getChangefreq());
    assertEquals("https://example.org/example", getResult.getLoc());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = mock(SiteMapUrlEntryImpl.class);
    when(siteMapUrlEntryImpl.getLastMod())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(siteMapUrlEntryImpl.getSiteMapChangeFreq()).thenReturn(null);
    when(siteMapUrlEntryImpl.getSiteMapPriority()).thenReturn(SiteMapPriorityType.ONE);
    when(siteMapUrlEntryImpl.getLocation()).thenReturn("https://example.org/example");

    ArrayList<SiteMapUrlEntry> siteMapUrlEntryList = new ArrayList<>();
    siteMapUrlEntryList.add(siteMapUrlEntryImpl);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = mock(CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(SiteMapChangeFreqType.ALWAYS);
    when(smgc.getCustomURLEntries()).thenReturn(siteMapUrlEntryList);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getCustomURLEntries();
    verify(smgc).getSiteMapChangeFreq();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLastMod();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLocation();
    verify(siteMapUrlEntryImpl).getSiteMapChangeFreq();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapPriority();
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("1970-01-01T00:00:00+00:00", getResult.getLastmod());
    assertEquals("always", getResult.getChangefreq());
    assertEquals("https://example.org/example", getResult.getLoc());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = mock(SiteMapUrlEntryImpl.class);
    when(siteMapUrlEntryImpl.getLastMod())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(siteMapUrlEntryImpl.getSiteMapChangeFreq()).thenReturn(SiteMapChangeFreqType.ALWAYS);
    when(siteMapUrlEntryImpl.getSiteMapPriority()).thenReturn(null);
    when(siteMapUrlEntryImpl.getLocation()).thenReturn("https://example.org/example");

    ArrayList<SiteMapUrlEntry> siteMapUrlEntryList = new ArrayList<>();
    siteMapUrlEntryList.add(siteMapUrlEntryImpl);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = mock(CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(smgc.getSiteMapPriority()).thenReturn(SiteMapPriorityType.ONE);
    when(smgc.getCustomURLEntries()).thenReturn(siteMapUrlEntryList);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getCustomURLEntries();
    verify(smgc).getSiteMapPriority();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLastMod();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLocation();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapChangeFreq();
    verify(siteMapUrlEntryImpl).getSiteMapPriority();
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("1970-01-01T00:00:00+00:00", getResult.getLastmod());
    assertEquals("always", getResult.getChangefreq());
    assertEquals("https://example.org/example", getResult.getLoc());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = mock(SiteMapUrlEntryImpl.class);
    when(siteMapUrlEntryImpl.getLastMod())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(siteMapUrlEntryImpl.getSiteMapChangeFreq()).thenReturn(SiteMapChangeFreqType.ALWAYS);
    when(siteMapUrlEntryImpl.getSiteMapPriority()).thenReturn(SiteMapPriorityType.ONE);
    when(siteMapUrlEntryImpl.getLocation()).thenReturn("yyyy-MM-dd'T'HH:mm:ssZ");

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
    verify(siteMapUrlEntryImpl, atLeast(1)).getLastMod();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLocation();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapChangeFreq();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapPriority();
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("1970-01-01T00:00:00+00:00", getResult.getLastmod());
    assertEquals("always", getResult.getChangefreq());
    assertEquals("https://example.org/example/yyyy-MM-dd'T'HH:mm:ssZ", getResult.getLoc());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries8() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = mock(SiteMapUrlEntryImpl.class);
    when(siteMapUrlEntryImpl.getLastMod())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(siteMapUrlEntryImpl.getSiteMapChangeFreq()).thenReturn(null);
    when(siteMapUrlEntryImpl.getSiteMapPriority()).thenReturn(SiteMapPriorityType.ONE);
    when(siteMapUrlEntryImpl.getLocation()).thenReturn("https://example.org/example");

    ArrayList<SiteMapUrlEntry> siteMapUrlEntryList = new ArrayList<>();
    siteMapUrlEntryList.add(siteMapUrlEntryImpl);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = mock(CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(null);
    when(smgc.getCustomURLEntries()).thenReturn(siteMapUrlEntryList);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getCustomURLEntries();
    verify(smgc).getSiteMapChangeFreq();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLastMod();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLocation();
    verify(siteMapUrlEntryImpl).getSiteMapChangeFreq();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapPriority();
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("1970-01-01T00:00:00+00:00", getResult.getLastmod());
    assertEquals("https://example.org/example", getResult.getLoc());
    assertNull(getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = mock(SiteMapUrlEntryImpl.class);
    when(siteMapUrlEntryImpl.getLastMod())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(siteMapUrlEntryImpl.getSiteMapChangeFreq()).thenReturn(SiteMapChangeFreqType.ALWAYS);
    when(siteMapUrlEntryImpl.getSiteMapPriority()).thenReturn(null);
    when(siteMapUrlEntryImpl.getLocation()).thenReturn("https://example.org/example");

    ArrayList<SiteMapUrlEntry> siteMapUrlEntryList = new ArrayList<>();
    siteMapUrlEntryList.add(siteMapUrlEntryImpl);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = mock(CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(smgc.getSiteMapPriority()).thenReturn(null);
    when(smgc.getCustomURLEntries()).thenReturn(siteMapUrlEntryList);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getCustomURLEntries();
    verify(smgc).getSiteMapPriority();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLastMod();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLocation();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapChangeFreq();
    verify(siteMapUrlEntryImpl).getSiteMapPriority();
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1970-01-01T00:00:00+00:00", getResult.getLastmod());
    assertEquals("always", getResult.getChangefreq());
    assertEquals("https://example.org/example", getResult.getLoc());
    assertNull(getResult.getPriority());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  public void testAddSiteMapEntries11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = mock(SiteMapUrlEntryImpl.class);
    when(siteMapUrlEntryImpl.getLastMod())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(siteMapUrlEntryImpl.getSiteMapChangeFreq()).thenReturn(SiteMapChangeFreqType.ALWAYS);
    when(siteMapUrlEntryImpl.getSiteMapPriority()).thenReturn(SiteMapPriorityType.ONE);
    when(siteMapUrlEntryImpl.getLocation()).thenReturn("yyyy-MM-dd'T'HH:mm:ssZ");

    ArrayList<SiteMapUrlEntry> siteMapUrlEntryList = new ArrayList<>();
    siteMapUrlEntryList.add(siteMapUrlEntryImpl);
    CustomUrlSiteMapGeneratorConfigurationImpl smgc = mock(CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(smgc.getCustomURLEntries()).thenReturn(siteMapUrlEntryList);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "://", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getCustomURLEntries();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLastMod();
    verify(siteMapUrlEntryImpl, atLeast(1)).getLocation();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapChangeFreq();
    verify(siteMapUrlEntryImpl, atLeast(1)).getSiteMapPriority();
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("1970-01-01T00:00:00+00:00", getResult.getLastmod());
    assertEquals("://yyyy-MM-dd'T'HH:mm:ssZ", getResult.getLoc());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  public void testGenerateUri() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  public void testGenerateUri2() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  public void testGenerateUri3() {
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
   * Method under test:
   * {@link CustomUrlSiteMapGenerator#generateDate(SiteMapUrlEntry)}
   */
  @Test
  public void testGenerateDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();
    SiteMapUrlEntryImpl urlEntry = mock(SiteMapUrlEntryImpl.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(urlEntry.getLastMod()).thenReturn(fromResult);

    // Act
    Date actualGenerateDateResult = customUrlSiteMapGenerator.generateDate(urlEntry);

    // Assert
    verify(urlEntry, atLeast(1)).getLastMod();
    assertSame(fromResult, actualGenerateDateResult);
  }
}
