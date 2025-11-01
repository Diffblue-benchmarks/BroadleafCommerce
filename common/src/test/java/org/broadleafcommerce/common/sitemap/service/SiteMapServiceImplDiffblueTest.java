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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.config.domain.ModuleConfiguration;
import org.broadleafcommerce.common.config.service.ModuleConfigurationService;
import org.broadleafcommerce.common.config.service.ModuleConfigurationServiceImpl;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration;
import org.broadleafcommerce.common.sitemap.exception.SiteMapException;
import org.junit.Test;
import org.mockito.Mockito;

public class SiteMapServiceImplDiffblueTest {
  /**
   * Method under test: {@link SiteMapServiceImpl#generateSiteMap()}
   */
  @Test
  public void testGenerateSiteMap() throws IOException, SiteMapException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationServiceImpl moduleConfigurationService = mock(ModuleConfigurationServiceImpl.class);
    when(moduleConfigurationService.findActiveConfigurationsByType(Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());

    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    siteMapServiceImpl.setModuleConfigurationService(moduleConfigurationService);

    // Act
    SiteMapGenerationResponse actualGenerateSiteMapResult = siteMapServiceImpl.generateSiteMap();

    // Assert
    verify(moduleConfigurationService).findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertEquals("No SiteMap Configuration Found", actualGenerateSiteMapResult.getErrorCode());
    assertEquals("sitemap.xml", actualGenerateSiteMapResult.getSitemapIndexFileName());
    assertTrue(actualGenerateSiteMapResult.getSiteMapFilePaths().isEmpty());
    assertTrue(actualGenerateSiteMapResult.isHasError());
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#findActiveSiteMapConfiguration()}
   */
  @Test
  public void testFindActiveSiteMapConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationServiceImpl moduleConfigurationService = mock(ModuleConfigurationServiceImpl.class);
    when(moduleConfigurationService.findActiveConfigurationsByType(Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());

    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    siteMapServiceImpl.setModuleConfigurationService(moduleConfigurationService);

    // Act
    SiteMapConfiguration actualFindActiveSiteMapConfigurationResult = siteMapServiceImpl
        .findActiveSiteMapConfiguration();

    // Assert
    verify(moduleConfigurationService).findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertNull(actualFindActiveSiteMapConfigurationResult);
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#findActiveSiteMapConfiguration()}
   */
  @Test
  public void testFindActiveSiteMapConfiguration2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    moduleConfigurationList.add(siteMapConfigurationImpl);
    ModuleConfigurationServiceImpl moduleConfigurationService = mock(ModuleConfigurationServiceImpl.class);
    when(moduleConfigurationService.findActiveConfigurationsByType(Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    siteMapServiceImpl.setModuleConfigurationService(moduleConfigurationService);

    // Act
    SiteMapConfiguration actualFindActiveSiteMapConfigurationResult = siteMapServiceImpl
        .findActiveSiteMapConfiguration();

    // Assert
    verify(moduleConfigurationService).findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(siteMapConfigurationImpl, actualFindActiveSiteMapConfigurationResult);
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#findActiveSiteMapConfiguration()}
   */
  @Test
  public void testFindActiveSiteMapConfiguration3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = mock(SiteMapConfigurationImpl.class);
    when(siteMapConfigurationImpl.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(siteMapConfigurationImpl);
    ModuleConfigurationServiceImpl moduleConfigurationService = mock(ModuleConfigurationServiceImpl.class);
    when(moduleConfigurationService.findActiveConfigurationsByType(Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    siteMapServiceImpl.setModuleConfigurationService(moduleConfigurationService);

    // Act
    siteMapServiceImpl.findActiveSiteMapConfiguration();

    // Assert
    verify(siteMapConfigurationImpl).getIsDefault();
    verify(moduleConfigurationService).findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#selectSiteMapGenerator(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testSelectSiteMapGenerator() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();

    // Act and Assert
    assertNull(siteMapServiceImpl.selectSiteMapGenerator(new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#selectSiteMapGenerator(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testSelectSiteMapGenerator2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SiteMapGenerator> siteMapGenerators = new ArrayList<>();
    siteMapGenerators.add(new CustomUrlSiteMapGenerator());

    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    siteMapServiceImpl.setSiteMapGenerators(siteMapGenerators);

    // Act and Assert
    assertNull(siteMapServiceImpl.selectSiteMapGenerator(new CustomUrlSiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#selectSiteMapGenerator(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testSelectSiteMapGenerator3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull(
        (new SiteMapServiceImpl()).selectSiteMapGenerator(mock(CustomUrlSiteMapGeneratorConfigurationImpl.class)));
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#selectSiteMapGenerator(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testSelectSiteMapGenerator4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomUrlSiteMapGenerator customUrlSiteMapGenerator = mock(CustomUrlSiteMapGenerator.class);
    when(customUrlSiteMapGenerator.canHandleSiteMapConfiguration(Mockito.<SiteMapGeneratorConfiguration>any()))
        .thenReturn(true);

    ArrayList<SiteMapGenerator> siteMapGenerators = new ArrayList<>();
    siteMapGenerators.add(customUrlSiteMapGenerator);

    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    siteMapServiceImpl.setSiteMapGenerators(siteMapGenerators);

    // Act
    siteMapServiceImpl.selectSiteMapGenerator(new CustomUrlSiteMapGeneratorConfigurationImpl());

    // Assert
    verify(customUrlSiteMapGenerator).canHandleSiteMapConfiguration(isA(SiteMapGeneratorConfiguration.class));
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#gzipAndDeleteFiles(FileWorkArea, List)}
   */
  @Test
  public void testGzipAndDeleteFiles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    FileWorkArea fileWorkArea = mock(FileWorkArea.class);
    when(fileWorkArea.getFilePathLocation()).thenReturn("/directory/foo.txt");

    ArrayList<String> fileNames = new ArrayList<>();
    fileNames.add("foo");

    // Act
    siteMapServiceImpl.gzipAndDeleteFiles(fileWorkArea, fileNames);

    // Assert
    verify(fileWorkArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#gzipAndDeleteFiles(FileWorkArea, List)}
   */
  @Test
  public void testGzipAndDeleteFiles2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    FileWorkArea fileWorkArea = mock(FileWorkArea.class);
    when(fileWorkArea.getFilePathLocation()).thenReturn("Error writing zip file.");

    ArrayList<String> fileNames = new ArrayList<>();
    fileNames.add("foo");

    // Act
    siteMapServiceImpl.gzipAndDeleteFiles(fileWorkArea, fileNames);

    // Assert
    verify(fileWorkArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#gzipAndDeleteFiles(FileWorkArea, List)}
   */
  @Test
  public void testGzipAndDeleteFiles3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    FileWorkArea fileWorkArea = mock(FileWorkArea.class);
    when(fileWorkArea.getFilePathLocation()).thenReturn("/directory/foo.txt");

    ArrayList<String> fileNames = new ArrayList<>();
    fileNames.add("");

    // Act
    siteMapServiceImpl.gzipAndDeleteFiles(fileWorkArea, fileNames);

    // Assert
    verify(fileWorkArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#gzipAndDeleteFiles(FileWorkArea, List)}
   */
  @Test
  public void testGzipAndDeleteFiles4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    FileWorkArea fileWorkArea = mock(FileWorkArea.class);
    when(fileWorkArea.getFilePathLocation()).thenReturn("");

    ArrayList<String> fileNames = new ArrayList<>();
    fileNames.add("");

    // Act
    siteMapServiceImpl.gzipAndDeleteFiles(fileWorkArea, fileNames);

    // Assert
    verify(fileWorkArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#gzipAndDeleteFiles(FileWorkArea, List, boolean)}
   */
  @Test
  public void testGzipAndDeleteFiles5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    FileWorkArea fileWorkArea = mock(FileWorkArea.class);
    when(fileWorkArea.getFilePathLocation()).thenReturn("/directory/foo.txt");

    ArrayList<String> fileNames = new ArrayList<>();
    fileNames.add("foo");

    // Act
    siteMapServiceImpl.gzipAndDeleteFiles(fileWorkArea, fileNames, true);

    // Assert
    verify(fileWorkArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#gzipAndDeleteFiles(FileWorkArea, List, boolean)}
   */
  @Test
  public void testGzipAndDeleteFiles6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    FileWorkArea fileWorkArea = mock(FileWorkArea.class);
    when(fileWorkArea.getFilePathLocation()).thenReturn("Error writing zip file.");

    ArrayList<String> fileNames = new ArrayList<>();
    fileNames.add("foo");

    // Act
    siteMapServiceImpl.gzipAndDeleteFiles(fileWorkArea, fileNames, true);

    // Assert
    verify(fileWorkArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#gzipAndDeleteFiles(FileWorkArea, List, boolean)}
   */
  @Test
  public void testGzipAndDeleteFiles7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    FileWorkArea fileWorkArea = mock(FileWorkArea.class);
    when(fileWorkArea.getFilePathLocation()).thenReturn("/directory/foo.txt");

    ArrayList<String> fileNames = new ArrayList<>();
    fileNames.add("");

    // Act
    siteMapServiceImpl.gzipAndDeleteFiles(fileWorkArea, fileNames, true);

    // Assert
    verify(fileWorkArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link SiteMapServiceImpl#gzipAndDeleteFiles(FileWorkArea, List, boolean)}
   */
  @Test
  public void testGzipAndDeleteFiles8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    FileWorkArea fileWorkArea = mock(FileWorkArea.class);
    when(fileWorkArea.getFilePathLocation()).thenReturn("");

    ArrayList<String> fileNames = new ArrayList<>();
    fileNames.add("");

    // Act
    siteMapServiceImpl.gzipAndDeleteFiles(fileWorkArea, fileNames, true);

    // Assert
    verify(fileWorkArea).getFilePathLocation();
  }

  /**
   * Method under test: {@link SiteMapServiceImpl#getGzipSiteMapFiles()}
   */
  @Test
  public void testGetGzipSiteMapFiles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    siteMapServiceImpl.setGzipSiteMapFiles(true);

    // Act and Assert
    assertTrue(siteMapServiceImpl.getGzipSiteMapFiles());
  }

  /**
   * Method under test: {@link SiteMapServiceImpl#getGzipSiteMapFiles()}
   */
  @Test
  public void testGetGzipSiteMapFiles2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();
    siteMapServiceImpl.setGzipSiteMapFiles(false);

    // Act and Assert
    assertFalse(siteMapServiceImpl.getGzipSiteMapFiles());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapServiceImpl#setGzipSiteMapFiles(Boolean)}
   *   <li>
   * {@link SiteMapServiceImpl#setModuleConfigurationService(ModuleConfigurationService)}
   *   <li>{@link SiteMapServiceImpl#setSiteMapGenerators(List)}
   *   <li>{@link SiteMapServiceImpl#getModuleConfigurationService()}
   *   <li>{@link SiteMapServiceImpl#getSiteMapGenerators()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SiteMapServiceImpl siteMapServiceImpl = new SiteMapServiceImpl();

    // Act
    siteMapServiceImpl.setGzipSiteMapFiles(true);
    ModuleConfigurationServiceImpl moduleConfigurationService = new ModuleConfigurationServiceImpl();
    siteMapServiceImpl.setModuleConfigurationService(moduleConfigurationService);
    ArrayList<SiteMapGenerator> siteMapGenerators = new ArrayList<>();
    siteMapServiceImpl.setSiteMapGenerators(siteMapGenerators);
    ModuleConfigurationService actualModuleConfigurationService = siteMapServiceImpl.getModuleConfigurationService();
    List<SiteMapGenerator> actualSiteMapGenerators = siteMapServiceImpl.getSiteMapGenerators();

    // Assert that nothing has changed
    assertTrue(actualModuleConfigurationService instanceof ModuleConfigurationServiceImpl);
    assertTrue(actualSiteMapGenerators.isEmpty());
    assertSame(siteMapGenerators, actualSiteMapGenerators);
    assertSame(moduleConfigurationService, actualModuleConfigurationService);
  }
}
