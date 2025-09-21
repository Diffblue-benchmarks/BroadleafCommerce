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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.config.domain.ModuleConfiguration;
import org.broadleafcommerce.common.config.service.ModuleConfigurationService;
import org.broadleafcommerce.common.config.service.ModuleConfigurationServiceImpl;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.broadleafcommerce.common.file.service.BroadleafFileService;
import org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration;
import org.broadleafcommerce.common.sitemap.exception.SiteMapException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class SiteMapServiceImplDiffblueTest {
  @Mock private BroadleafFileService broadleafFileService;

  @Mock private ModuleConfigurationService moduleConfigurationService;

  @InjectMocks private SiteMapServiceImpl siteMapServiceImpl;

  /**
   * Test {@link SiteMapServiceImpl#generateSiteMap()}.
   *
   * <p>Method under test: {@link SiteMapServiceImpl#generateSiteMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteMapGenerationResponse SiteMapServiceImpl.generateSiteMap()"})
  public void testGenerateSiteMap() throws IOException, SiteMapException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenThrow(new SiteMapException("An error occurred"));

    // Act and Assert
    assertThrows(SiteMapException.class, () -> siteMapServiceImpl.generateSiteMap());
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link SiteMapServiceImpl#generateSiteMap()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafFileService#initializeWorkArea()}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapServiceImpl#generateSiteMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteMapGenerationResponse SiteMapServiceImpl.generateSiteMap()"})
  public void testGenerateSiteMap_thenCallsInitializeWorkArea()
      throws IOException, SiteMapException {
    // Arrange
    when(broadleafFileService.initializeWorkArea())
        .thenThrow(new SiteMapException("An error occurred"));

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(new SiteMapConfigurationImpl());
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    // Act and Assert
    assertThrows(SiteMapException.class, () -> siteMapServiceImpl.generateSiteMap());
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(broadleafFileService).initializeWorkArea();
  }

  /**
   * Test {@link SiteMapServiceImpl#generateSiteMap()}.
   *
   * <ul>
   *   <li>Then return ErrorCode is {@code No SiteMap Configuration Found}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapServiceImpl#generateSiteMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteMapGenerationResponse SiteMapServiceImpl.generateSiteMap()"})
  public void testGenerateSiteMap_thenReturnErrorCodeIsNoSiteMapConfigurationFound()
      throws IOException, SiteMapException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SiteMapGenerationResponse actualGenerateSiteMapResult = siteMapServiceImpl.generateSiteMap();

    // Assert
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertEquals("No SiteMap Configuration Found", actualGenerateSiteMapResult.getErrorCode());
    assertEquals("sitemap.xml", actualGenerateSiteMapResult.getSitemapIndexFileName());
    assertTrue(actualGenerateSiteMapResult.getSiteMapFilePaths().isEmpty());
    assertTrue(actualGenerateSiteMapResult.isHasError());
  }

  /**
   * Test {@link SiteMapServiceImpl#findActiveSiteMapConfiguration()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapServiceImpl#findActiveSiteMapConfiguration()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteMapConfiguration SiteMapServiceImpl.findActiveSiteMapConfiguration()"})
  public void testFindActiveSiteMapConfiguration_thenReturnNull() {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SiteMapConfiguration actualFindActiveSiteMapConfigurationResult =
        siteMapServiceImpl.findActiveSiteMapConfiguration();

    // Assert
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertNull(actualFindActiveSiteMapConfigurationResult);
  }

  /**
   * Test {@link SiteMapServiceImpl#findActiveSiteMapConfiguration()}.
   *
   * <ul>
   *   <li>Then return {@link SiteMapConfigurationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SiteMapServiceImpl#findActiveSiteMapConfiguration()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteMapConfiguration SiteMapServiceImpl.findActiveSiteMapConfiguration()"})
  public void testFindActiveSiteMapConfiguration_thenReturnSiteMapConfigurationImpl() {
    // Arrange
    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    moduleConfigurationList.add(siteMapConfigurationImpl);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    // Act
    SiteMapConfiguration actualFindActiveSiteMapConfigurationResult =
        siteMapServiceImpl.findActiveSiteMapConfiguration();

    // Assert
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(siteMapConfigurationImpl, actualFindActiveSiteMapConfigurationResult);
  }

  /**
   * Test {@link SiteMapServiceImpl#findActiveSiteMapConfiguration()}.
   *
   * <ul>
   *   <li>Then throw {@link SiteMapException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapServiceImpl#findActiveSiteMapConfiguration()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteMapConfiguration SiteMapServiceImpl.findActiveSiteMapConfiguration()"})
  public void testFindActiveSiteMapConfiguration_thenThrowSiteMapException() {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenThrow(new SiteMapException("An error occurred"));

    // Act and Assert
    assertThrows(SiteMapException.class, () -> siteMapServiceImpl.findActiveSiteMapConfiguration());
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link SiteMapServiceImpl#selectSiteMapGenerator(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       CustomUrlSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SiteMapServiceImpl#selectSiteMapGenerator(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SiteMapGenerator SiteMapServiceImpl.selectSiteMapGenerator(SiteMapGeneratorConfiguration)"
  })
  public void testSelectSiteMapGenerator_thenCallsCanHandleSiteMapConfiguration() {
    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = mock(CustomUrlSiteMapGenerator.class);
    when(customUrlSiteMapGenerator.canHandleSiteMapConfiguration(
            Mockito.<SiteMapGeneratorConfiguration>any()))
        .thenReturn(true);

    ArrayList<SiteMapGenerator> siteMapGenerators = new ArrayList<>();
    siteMapGenerators.add(customUrlSiteMapGenerator);
    siteMapServiceImpl.setSiteMapGenerators(siteMapGenerators);

    // Act
    siteMapServiceImpl.selectSiteMapGenerator(new CustomUrlSiteMapGeneratorConfigurationImpl());

    // Assert
    verify(customUrlSiteMapGenerator)
        .canHandleSiteMapConfiguration(isA(SiteMapGeneratorConfiguration.class));
  }

  /**
   * Test {@link SiteMapServiceImpl#selectSiteMapGenerator(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SiteMapServiceImpl#selectSiteMapGenerator(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SiteMapGenerator SiteMapServiceImpl.selectSiteMapGenerator(SiteMapGeneratorConfiguration)"
  })
  public void testSelectSiteMapGenerator_thenReturnNull() {
    // Arrange
    ArrayList<SiteMapGenerator> siteMapGenerators = new ArrayList<>();
    siteMapGenerators.add(new CustomUrlSiteMapGenerator());
    siteMapServiceImpl.setSiteMapGenerators(siteMapGenerators);

    // Act and Assert
    assertNull(
        siteMapServiceImpl.selectSiteMapGenerator(
            new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapServiceImpl#setGzipSiteMapFiles(Boolean)}
   *   <li>{@link SiteMapServiceImpl#setModuleConfigurationService(ModuleConfigurationService)}
   *   <li>{@link SiteMapServiceImpl#setSiteMapGenerators(List)}
   *   <li>{@link SiteMapServiceImpl#getModuleConfigurationService()}
   *   <li>{@link SiteMapServiceImpl#getSiteMapGenerators()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModuleConfigurationService SiteMapServiceImpl.getModuleConfigurationService()",
    "List SiteMapServiceImpl.getSiteMapGenerators()",
    "void SiteMapServiceImpl.setGzipSiteMapFiles(Boolean)",
    "void SiteMapServiceImpl.setModuleConfigurationService(ModuleConfigurationService)",
    "void SiteMapServiceImpl.setSiteMapGenerators(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();

    // Act
    siteMapServiceImpl.setGzipSiteMapFiles(true);
    ModuleConfigurationServiceImpl moduleConfigurationService =
        new ModuleConfigurationServiceImpl();
    siteMapServiceImpl.setModuleConfigurationService(moduleConfigurationService);
    ArrayList<SiteMapGenerator> siteMapGenerators = new ArrayList<>();
    siteMapServiceImpl.setSiteMapGenerators(siteMapGenerators);
    ModuleConfigurationService actualModuleConfigurationService =
        siteMapServiceImpl.getModuleConfigurationService();
    List<SiteMapGenerator> actualSiteMapGenerators = siteMapServiceImpl.getSiteMapGenerators();

    // Assert
    assertTrue(actualModuleConfigurationService instanceof ModuleConfigurationServiceImpl);
    assertTrue(actualSiteMapGenerators.isEmpty());
    assertSame(siteMapGenerators, actualSiteMapGenerators);
    assertSame(moduleConfigurationService, actualModuleConfigurationService);
  }

  /**
   * Test {@link SiteMapServiceImpl#getGzipSiteMapFiles()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapServiceImpl#getGzipSiteMapFiles()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteMapServiceImpl.getGzipSiteMapFiles()"})
  public void testGetGzipSiteMapFiles_thenReturnFalse() {
    // Arrange
    siteMapServiceImpl.setGzipSiteMapFiles(false);

    // Act and Assert
    assertFalse(siteMapServiceImpl.getGzipSiteMapFiles());
  }

  /**
   * Test {@link SiteMapServiceImpl#getGzipSiteMapFiles()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapServiceImpl#getGzipSiteMapFiles()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteMapServiceImpl.getGzipSiteMapFiles()"})
  public void testGetGzipSiteMapFiles_thenReturnTrue() {
    // Arrange
    siteMapServiceImpl.setGzipSiteMapFiles(true);

    // Act and Assert
    assertTrue(siteMapServiceImpl.getGzipSiteMapFiles());
  }
}
