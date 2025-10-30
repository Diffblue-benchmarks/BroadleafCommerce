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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code https://example.org/example/foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"})
  public void testGenerateUri_givenFoo_thenReturnHttpsExampleOrgExampleFoo() {
    // Arrange
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
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"})
  public void testGenerateUri_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange
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
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code ://}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"})
  public void testGenerateUri_givenSlash_thenReturnColonSlashSlash() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "://", true);

    SiteMapUrlEntryImpl urlEntry = mock(SiteMapUrlEntryImpl.class);
    when(urlEntry.getLocation()).thenReturn("/");

    // Act
    String actualGenerateUriResult = customUrlSiteMapGenerator.generateUri(smb, urlEntry);

    // Assert
    verify(urlEntry).getLocation();
    assertEquals("://", actualGenerateUriResult);
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"})
  public void testGenerateUri_givenSlash_thenReturnHttpsExampleOrgExample() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    SiteMapUrlEntryImpl urlEntry = mock(SiteMapUrlEntryImpl.class);
    when(urlEntry.getLocation()).thenReturn("/");

    // Act
    String actualGenerateUriResult = customUrlSiteMapGenerator.generateUri(smb, urlEntry);

    // Assert
    verify(urlEntry).getLocation();
    assertEquals("https://example.org/example/", actualGenerateUriResult);
  }

  /**
   * Test {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}.
   * <ul>
   *   <li>Then return {@code ://foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUrlSiteMapGenerator#generateUri(SiteMapBuilder, SiteMapUrlEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomUrlSiteMapGenerator.generateUri(SiteMapBuilder, SiteMapUrlEntry)"})
  public void testGenerateUri_thenReturnFoo() {
    // Arrange
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
}
