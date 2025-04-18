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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Autowired
  private CustomUrlSiteMapGenerator customUrlSiteMapGenerator;

  /**
   * Test {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomUrlSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_givenCategory() {
    // Arrange
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
   * Test {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#CUSTOM}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomUrlSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_givenCustom_thenReturnTrue() {
    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(SiteMapGeneratorType.CUSTOM);
    siteMapGeneratorConfiguration.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act and Assert
    assertTrue(customUrlSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CustomUrlSiteMapGeneratorConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomUrlSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_whenCustomUrlSiteMapGeneratorConfigurationImpl() {
    // Arrange, Act and Assert
    assertFalse(
        customUrlSiteMapGenerator.canHandleSiteMapConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries() {
    // Arrange
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
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries2() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("/");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("/", getResult.getLoc());
    assertEquals("1.0", getResult.getPriority());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries3() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("/");
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("/", getResult.getLoc());
    assertEquals("1.0", getResult.getPriority());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries4() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("://");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    List<SiteMapURLWrapper> siteMapUrlWrappers = siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers();
    assertEquals(1, siteMapUrlWrappers.size());
    SiteMapURLWrapper getResult = siteMapUrlWrappers.get(0);
    assertEquals("1.0", getResult.getPriority());
    assertEquals("://", getResult.getLoc());
    assertEquals("always", getResult.getChangefreq());
    assertTrue(getResult.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link SiteMapUrlEntryImpl} (default constructor) Location is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenSiteMapUrlEntryImplLocationIsEmptyString() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation("");
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert that nothing has changed
    assertTrue(siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link SiteMapUrlEntryImpl} (default constructor) Location is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomUrlSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenSiteMapUrlEntryImplLocationIsNull() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setLocation(null);
    siteMapUrlEntryImpl.setLastMod(null);

    ArrayList<SiteMapUrlEntry> customURLEntries = new ArrayList<>();
    customURLEntries.add(siteMapUrlEntryImpl);

    CustomUrlSiteMapGeneratorConfigurationImpl smgc = new CustomUrlSiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setId(1L);
    smgc.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    smgc.setSiteMapPriority(SiteMapPriorityType.ONE);
    smgc.setCustomURLEntries(customURLEntries);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    // Act
    customUrlSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert that nothing has changed
    assertTrue(siteMapBuilder.currentURLSetWrapper.getSiteMapUrlWrappers().isEmpty());
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code ://}.</li>
   *   <li>Then return {@code ://}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"})
  public void testGenerateUri_givenColonSlashSlash_thenReturnColonSlashSlash() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    SiteMapUrlEntryImpl urlEntry = new SiteMapUrlEntryImpl();
    urlEntry.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    urlEntry.setId(1L);
    urlEntry.setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    urlEntry.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    urlEntry.setSiteMapPriority(SiteMapPriorityType.ONE);
    urlEntry.setLocation("://");

    // Act and Assert
    assertEquals("://", customUrlSiteMapGenerator.generateUri(smb, urlEntry));
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code Location}.</li>
   *   <li>Then return {@code https://example.org/example/Location}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"})
  public void testGenerateUri_givenLocation_thenReturnHttpsExampleOrgExampleLocation() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    SiteMapUrlEntryImpl urlEntry = new SiteMapUrlEntryImpl();
    urlEntry.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    urlEntry.setId(1L);
    urlEntry.setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    urlEntry.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    urlEntry.setSiteMapPriority(SiteMapPriorityType.ONE);
    urlEntry.setLocation("Location");

    // Act and Assert
    assertEquals("https://example.org/example/Location", customUrlSiteMapGenerator.generateUri(smb, urlEntry));
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code Location}.</li>
   *   <li>Then return {@code /Location}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"})
  public void testGenerateUri_givenLocation_thenReturnLocation() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    SiteMapUrlEntryImpl urlEntry = new SiteMapUrlEntryImpl();
    urlEntry.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    urlEntry.setId(1L);
    urlEntry.setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    urlEntry.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    urlEntry.setSiteMapPriority(SiteMapPriorityType.ONE);
    urlEntry.setLocation("Location");

    // Act and Assert
    assertEquals("/Location", customUrlSiteMapGenerator.generateUri(smb, urlEntry));
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"})
  public void testGenerateUri_givenSlash_thenReturnSlash() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    SiteMapUrlEntryImpl urlEntry = new SiteMapUrlEntryImpl();
    urlEntry.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    urlEntry.setId(1L);
    urlEntry.setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    urlEntry.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    urlEntry.setSiteMapPriority(SiteMapPriorityType.ONE);
    urlEntry.setLocation("/");

    // Act and Assert
    assertEquals("/", customUrlSiteMapGenerator.generateUri(smb, urlEntry));
  }
}
