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
import static org.junit.Assert.assertTrue;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomUrlSiteMapGenerator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomUrlSiteMapGeneratorDiffblueTest {
  @Autowired private CustomUrlSiteMapGenerator customUrlSiteMapGenerator;

  /**
   * Test {@link
   * CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomUrlSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration() {
    // Arrange
    SiteMapGeneratorConfiguration siteMapGeneratorConfiguration =
        mock(SiteMapGeneratorConfiguration.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType("CUSTOM", "Friendly Type"));

    // Act
    boolean actualCanHandleSiteMapConfigurationResult =
        customUrlSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test {@link
   * CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#CUSTOM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomUrlSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenCustom() {
    // Arrange
    SiteMapGeneratorConfiguration siteMapGeneratorConfiguration =
        mock(SiteMapGeneratorConfiguration.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(SiteMapGeneratorType.CUSTOM);

    // Act
    boolean actualCanHandleSiteMapConfigurationResult =
        customUrlSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test {@link
   * CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomUrlSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenTrue() {
    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration =
        new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    siteMapGeneratorConfiguration.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act and Assert
    assertFalse(
        customUrlSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link
   * CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>When {@link CustomUrlSiteMapGeneratorConfigurationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomUrlSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_whenCustomUrlSiteMapGeneratorConfigurationImpl() {
    // Arrange, Act and Assert
    assertFalse(
        customUrlSiteMapGenerator.canHandleSiteMapConfiguration(
            new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries() {
    // Arrange
    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert that nothing has changed
    assertTrue(siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries2() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("://");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("://", getResult.getLoc());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries3() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("://");
    siteMapUrlEntryImpl.setLastMod(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("://", getResult.getLoc());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries4() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("/");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("/", getResult.getLoc());
    assertEquals("1.0", getResult.getPriority());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries5() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("Location");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("/Location", getResult.getLoc());
    assertEquals("1.0", getResult.getPriority());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries6() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("Location");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("/Location", getResult.getLoc());
    assertEquals("1.0", getResult.getPriority());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries7() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(new SiteMapPriorityType());
    siteMapUrlEntryImpl.setLocation("Location");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("/Location", getResult.getLoc());
    assertEquals("1.0", getResult.getPriority());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries8() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("Location");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("always", getResult.getChangefreq());
    assertEquals("https://example.org/example/Location", getResult.getLoc());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries9() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("Location");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("/Location", getResult.getLoc());
    assertEquals("1.0", getResult.getPriority());
    assertNull(getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries10() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(new SiteMapPriorityType());
    siteMapUrlEntryImpl.setLocation("Location");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(new SiteMapPriorityType());
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("/Location", getResult.getLoc());
    assertEquals("always", getResult.getChangefreq());
    assertNull(getResult.getPriority());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries11() {
    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = new CustomUrlSiteMapGenerator();

    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("/");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers =
        siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("always", getResult.getChangefreq());
    assertEquals("https://example.org/example/", getResult.getLoc());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapUrlEntryImpl} (default constructor) Location is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenSiteMapUrlEntryImplLocationIsEmptyString() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert that nothing has changed
    assertTrue(siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapUrlEntryImpl} (default constructor) Location is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenSiteMapUrlEntryImplLocationIsNull() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation(null);
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert that nothing has changed
    assertTrue(siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   *
   * <ul>
   *   <li>Given {@code ://}.
   *   <li>Then return {@code ://}.
   * </ul>
   *
   * <p>Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder,
   * SiteMapUrlEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"
  })
  public void testGenerateUri_givenColonSlashSlash_thenReturnColonSlashSlash() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    SiteMapUrlEntryImpl urlEntry = new SiteMapUrlEntryImpl();
    urlEntry.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    urlEntry.setId(1L);
    urlEntry.setLastMod(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    urlEntry.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    urlEntry.setSiteMapPriority(SiteMapPriorityType.ONE);
    urlEntry.setLocation("://");

    // Act and Assert
    assertEquals("://", customUrlSiteMapGenerator.generateUri(smb, urlEntry));
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link SiteMapBuilder} {@link SiteMapBuilder#getBaseUrl()} return {@code /}.
   *   <li>Then return {@code /foo}.
   * </ul>
   *
   * <p>Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder,
   * SiteMapUrlEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"
  })
  public void testGenerateUri_givenFoo_whenSiteMapBuilderGetBaseUrlReturnSlash_thenReturnFoo() {
    // Arrange
    SiteMapBuilder smb = mock(SiteMapBuilder.class);
    when(smb.getBaseUrl()).thenReturn("/");

    SiteMapUrlEntry urlEntry = mock(SiteMapUrlEntry.class);
    when(urlEntry.getLocation()).thenReturn("foo");

    // Act
    String actualGenerateUriResult = customUrlSiteMapGenerator.generateUri(smb, urlEntry);

    // Assert
    verify(urlEntry).getLocation();
    verify(smb).getBaseUrl();
    assertEquals("/foo", actualGenerateUriResult);
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then return {@code https://example.org/example/foo}.
   * </ul>
   *
   * <p>Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder,
   * SiteMapUrlEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"
  })
  public void testGenerateUri_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExampleFoo() {
    // Arrange
    SiteMapBuilder smb = mock(SiteMapBuilder.class);
    when(smb.getBaseUrl()).thenReturn("https://example.org/example");

    SiteMapUrlEntry urlEntry = mock(SiteMapUrlEntry.class);
    when(urlEntry.getLocation()).thenReturn("foo");

    // Act
    String actualGenerateUriResult = customUrlSiteMapGenerator.generateUri(smb, urlEntry);

    // Assert
    verify(urlEntry).getLocation();
    verify(smb).getBaseUrl();
    assertEquals("https://example.org/example/foo", actualGenerateUriResult);
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/}.
   * </ul>
   *
   * <p>Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder,
   * SiteMapUrlEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"
  })
  public void testGenerateUri_thenReturnHttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    SiteMapUrlEntry urlEntry = mock(SiteMapUrlEntry.class);
    when(urlEntry.getLocation()).thenReturn("/");

    // Act
    String actualGenerateUriResult = customUrlSiteMapGenerator.generateUri(smb, urlEntry);

    // Assert
    verify(urlEntry).getLocation();
    assertEquals("https://example.org/example/", actualGenerateUriResult);
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   *
   * <ul>
   *   <li>When {@link SiteMapUrlEntryImpl} (default constructor) Location is {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder,
   * SiteMapUrlEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"
  })
  public void testGenerateUri_whenSiteMapUrlEntryImplLocationIsSlash_thenReturnSlash() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    SiteMapUrlEntryImpl urlEntry = new SiteMapUrlEntryImpl();
    urlEntry.setCustomUrlSiteMapGeneratorConfiguration(
        new CustomUrlSiteMapGeneratorConfigurationImpl());
    urlEntry.setId(1L);
    urlEntry.setLastMod(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    urlEntry.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    urlEntry.setSiteMapPriority(SiteMapPriorityType.ONE);
    urlEntry.setLocation("/");

    // Act and Assert
    assertEquals("/", customUrlSiteMapGenerator.generateUri(smb, urlEntry));
  }
}
