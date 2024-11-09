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
package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer;
import org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;

public class MergePersistenceUnitManagerDiffblueTest {
  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  public void testAfterPropertiesSet() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager
        .setMappingResources("Did not recycle through class transformation since this has already occurred");
    mergePersistenceUnitManager.addTransformersToPersistenceUnits();

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("default"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  public void testAfterPropertiesSet2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setDataSourceLookup(mock(DataSourceLookup.class));
    mergePersistenceUnitManager.addTransformersToPersistenceUnits();

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  public void testAfterPropertiesSet3() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setLoadTimeWeaver(new DefaultContextLoadTimeWeaver());
    mergePersistenceUnitManager.addTransformersToPersistenceUnits();

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  public void testAfterPropertiesSet_givenArrayOfStringWithJavaText() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setPackagesToScan("java.text");
    mergePersistenceUnitManager.addTransformersToPersistenceUnits();

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("default"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   * <ul>
   *   <li>Given {@link MergePersistenceUnitManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  public void testAfterPropertiesSet_givenMergePersistenceUnitManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   * <ul>
   *   <li>Then {@link MergePersistenceUnitManager} (default constructor)
   * {@link MergePersistenceUnitManager#mergedPus} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  public void testAfterPropertiesSet_thenMergePersistenceUnitManagerMergedPusEmpty() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.addTransformersToPersistenceUnits();

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#getMergedUnit(String, MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#getMergedUnit(String, MutablePersistenceUnitInfo)}
   */
  @Test
  public void testGetMergedUnit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();

    // Act
    MutablePersistenceUnitInfo actualMergedUnit = mergePersistenceUnitManager.getMergedUnit("Persistence Unit Name",
        newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get("Persistence Unit Name"));
    assertSame(newPU, actualMergedUnit);
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#getMergedUnit(String, MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#getMergedUnit(String, MutablePersistenceUnitInfo)}
   */
  @Test
  public void testGetMergedUnit2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    MutablePersistenceUnitInfo newPU = mock(MutablePersistenceUnitInfo.class);

    // Act
    MutablePersistenceUnitInfo actualMergedUnit = mergePersistenceUnitManager.getMergedUnit("Persistence Unit Name",
        newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get("Persistence Unit Name"));
    assertSame(newPU, actualMergedUnit);
  }

  /**
   * Test {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  public void testPreparePersistenceUnitInfos() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager
        .setMappingResources("Did not recycle through class transformation since this has already occurred");

    // Act
    mergePersistenceUnitManager.preparePersistenceUnitInfos();

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("default"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  public void testPreparePersistenceUnitInfos2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setDataSourceLookup(mock(DataSourceLookup.class));

    // Act
    mergePersistenceUnitManager.preparePersistenceUnitInfos();

    // Assert
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  public void testPreparePersistenceUnitInfos_givenArrayOfStringWithJavaText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setPackagesToScan("java.text");

    // Act
    mergePersistenceUnitManager.preparePersistenceUnitInfos();

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("default"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}.
   * <ul>
   *   <li>Given {@link MergePersistenceUnitManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  public void testPreparePersistenceUnitInfos_givenMergePersistenceUnitManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    // Act
    mergePersistenceUnitManager.preparePersistenceUnitInfos();

    // Assert
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#addTransformersToPersistenceUnits()}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#addTransformersToPersistenceUnits()}
   */
  @Test
  public void testAddTransformersToPersistenceUnits() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setDataSourceLookup(mock(DataSourceLookup.class));

    // Act and Assert
    assertTrue(mergePersistenceUnitManager.addTransformersToPersistenceUnits());
  }

  /**
   * Test {@link MergePersistenceUnitManager#addTransformersToPersistenceUnits()}.
   * <ul>
   *   <li>Given {@link MergePersistenceUnitManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#addTransformersToPersistenceUnits()}
   */
  @Test
  public void testAddTransformersToPersistenceUnits_givenMergePersistenceUnitManager() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MergePersistenceUnitManager()).addTransformersToPersistenceUnits());
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}
   */
  @Test
  public void testAddNamedQueriesToPersistenceUnits() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setDataSourceLookup(mock(DataSourceLookup.class));

    // Act and Assert
    assertTrue(mergePersistenceUnitManager.addNamedQueriesToPersistenceUnits(true));
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}
   */
  @Test
  public void testAddNamedQueriesToPersistenceUnits_thenReturnTrue() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MergePersistenceUnitManager()).addNamedQueriesToPersistenceUnits(true));
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}
   */
  @Test
  public void testAddNamedQueriesToPersistenceUnits_whenFalse_thenReturnFalse() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MergePersistenceUnitManager()).addNamedQueriesToPersistenceUnits(false));
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#handleClassTransformerRegistrationProblem(BroadleafClassTransformer, Exception)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#handleClassTransformerRegistrationProblem(BroadleafClassTransformer, Exception)}
   */
  @Test
  public void testHandleClassTransformerRegistrationProblem_thenReturnFalse() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    AlterTableNameClassTransformer transformer = new AlterTableNameClassTransformer();

    // Act and Assert
    assertFalse(mergePersistenceUnitManager.handleClassTransformerRegistrationProblem(transformer,
        new IllegalStateException("foo")));
  }

  /**
   * Test {@link MergePersistenceUnitManager#exceptionWithNonTransformed(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#exceptionWithNonTransformed(List)}
   */
  @Test
  public void testExceptionWithNonTransformed_whenArrayList_thenThrowIllegalStateException()
      throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> mergePersistenceUnitManager.exceptionWithNonTransformed(new ArrayList<>()));
  }

  /**
   * Test {@link MergePersistenceUnitManager#detectSpringBootDevtools()}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#detectSpringBootDevtools()}
   */
  @Test
  public void testDetectSpringBootDevtools() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setDataSourceLookup(mock(DataSourceLookup.class));

    // Act and Assert
    assertFalse(mergePersistenceUnitManager.detectSpringBootDevtools());
  }

  /**
   * Test {@link MergePersistenceUnitManager#detectSpringBootDevtools()}.
   * <ul>
   *   <li>Given {@link MergePersistenceUnitManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#detectSpringBootDevtools()}
   */
  @Test
  public void testDetectSpringBootDevtools_givenMergePersistenceUnitManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MergePersistenceUnitManager()).detectSpringBootDevtools());
  }

  /**
   * Test {@link MergePersistenceUnitManager#detectNonTransformedClasses()}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#detectNonTransformedClasses()}
   */
  @Test
  public void testDetectNonTransformedClasses() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setDataSourceLookup(mock(DataSourceLookup.class));

    // Act and Assert
    assertTrue(mergePersistenceUnitManager.detectNonTransformedClasses().isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#detectNonTransformedClasses()}.
   * <ul>
   *   <li>Given {@link MergePersistenceUnitManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#detectNonTransformedClasses()}
   */
  @Test
  public void testDetectNonTransformedClasses_givenMergePersistenceUnitManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MergePersistenceUnitManager()).detectNonTransformedClasses().isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#triggerClassLoadForManagedClasses()}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#triggerClassLoadForManagedClasses()}
   */
  @Test
  public void testTriggerClassLoadForManagedClasses() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setDataSourceLookup(mock(DataSourceLookup.class));

    // Act and Assert
    assertTrue(mergePersistenceUnitManager.triggerClassLoadForManagedClasses().isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#triggerClassLoadForManagedClasses()}.
   * <ul>
   *   <li>Given {@link MergePersistenceUnitManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#triggerClassLoadForManagedClasses()}
   */
  @Test
  public void testTriggerClassLoadForManagedClasses_givenMergePersistenceUnitManager() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MergePersistenceUnitManager()).triggerClassLoadForManagedClasses().isEmpty());
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get(null));
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    MutablePersistenceUnitInfo newPU = mock(MutablePersistenceUnitInfo.class);
    doNothing().when(newPU).setJtaDataSource(Mockito.<DataSource>any());
    doNothing().when(newPU).setNonJtaDataSource(Mockito.<DataSource>any());
    doNothing().when(newPU).setPersistenceProviderClassName(Mockito.<String>any());
    doNothing().when(newPU).setPersistenceProviderPackageName(Mockito.<String>any());
    when(newPU.getPersistenceProviderClassName()).thenReturn("Persistence Provider Class Name");
    when(newPU.getPersistenceProviderPackageName()).thenReturn("java.text");
    when(newPU.getTransactionType()).thenReturn(PersistenceUnitTransactionType.JTA);
    when(newPU.getJtaDataSource()).thenReturn(mock(DataSource.class));
    when(newPU.getNonJtaDataSource()).thenReturn(mock(DataSource.class));
    doNothing().when(newPU).setTransactionType(Mockito.<PersistenceUnitTransactionType>any());
    when(newPU.excludeUnlistedClasses()).thenReturn(true);
    when(newPU.getPersistenceUnitName()).thenReturn("Persistence Unit Name");
    when(newPU.getJarFileUrls()).thenReturn(new ArrayList<>());
    when(newPU.getManagedClassNames()).thenReturn(new ArrayList<>());
    when(newPU.getMappingFileNames()).thenReturn(new ArrayList<>());
    when(newPU.getProperties()).thenReturn(new Properties());
    doNothing().when(newPU).setExcludeUnlistedClasses(anyBoolean());

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    verify(newPU).excludeUnlistedClasses();
    verify(newPU).getJarFileUrls();
    verify(newPU, atLeast(1)).getJtaDataSource();
    verify(newPU).getManagedClassNames();
    verify(newPU).getMappingFileNames();
    verify(newPU, atLeast(1)).getNonJtaDataSource();
    verify(newPU, atLeast(1)).getPersistenceProviderClassName();
    verify(newPU, atLeast(1)).getPersistenceProviderPackageName();
    verify(newPU).getPersistenceUnitName();
    verify(newPU, atLeast(1)).getProperties();
    verify(newPU).getTransactionType();
    verify(newPU).setExcludeUnlistedClasses(eq(true));
    verify(newPU).setJtaDataSource(isA(DataSource.class));
    verify(newPU).setNonJtaDataSource(isA(DataSource.class));
    verify(newPU).setPersistenceProviderClassName(eq("Persistence Provider Class Name"));
    verify(newPU).setPersistenceProviderPackageName(eq("java.text"));
    verify(newPU).setTransactionType(eq(PersistenceUnitTransactionType.JTA));
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get("Persistence Unit Name"));
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo3() throws MalformedURLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    ArrayList<URL> urlList = new ArrayList<>();
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    MutablePersistenceUnitInfo newPU = mock(MutablePersistenceUnitInfo.class);
    doNothing().when(newPU).setJtaDataSource(Mockito.<DataSource>any());
    doNothing().when(newPU).setNonJtaDataSource(Mockito.<DataSource>any());
    doNothing().when(newPU).setPersistenceProviderClassName(Mockito.<String>any());
    doNothing().when(newPU).setPersistenceProviderPackageName(Mockito.<String>any());
    when(newPU.getPersistenceProviderClassName()).thenReturn("Persistence Provider Class Name");
    when(newPU.getPersistenceProviderPackageName()).thenReturn("java.text");
    when(newPU.getTransactionType()).thenReturn(PersistenceUnitTransactionType.JTA);
    when(newPU.getJtaDataSource()).thenReturn(mock(DataSource.class));
    when(newPU.getNonJtaDataSource()).thenReturn(mock(DataSource.class));
    doNothing().when(newPU).setTransactionType(Mockito.<PersistenceUnitTransactionType>any());
    when(newPU.excludeUnlistedClasses()).thenReturn(true);
    when(newPU.getPersistenceUnitName()).thenReturn("Persistence Unit Name");
    when(newPU.getJarFileUrls()).thenReturn(urlList);
    when(newPU.getManagedClassNames()).thenReturn(new ArrayList<>());
    when(newPU.getMappingFileNames()).thenReturn(new ArrayList<>());
    when(newPU.getProperties()).thenReturn(new Properties());
    doNothing().when(newPU).setExcludeUnlistedClasses(anyBoolean());

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    verify(newPU).excludeUnlistedClasses();
    verify(newPU, atLeast(1)).getJarFileUrls();
    verify(newPU, atLeast(1)).getJtaDataSource();
    verify(newPU).getManagedClassNames();
    verify(newPU).getMappingFileNames();
    verify(newPU, atLeast(1)).getNonJtaDataSource();
    verify(newPU, atLeast(1)).getPersistenceProviderClassName();
    verify(newPU, atLeast(1)).getPersistenceProviderPackageName();
    verify(newPU).getPersistenceUnitName();
    verify(newPU, atLeast(1)).getProperties();
    verify(newPU).getTransactionType();
    verify(newPU).setExcludeUnlistedClasses(eq(true));
    verify(newPU).setJtaDataSource(isA(DataSource.class));
    verify(newPU).setNonJtaDataSource(isA(DataSource.class));
    verify(newPU).setPersistenceProviderClassName(eq("Persistence Provider Class Name"));
    verify(newPU).setPersistenceProviderPackageName(eq("java.text"));
    verify(newPU).setTransactionType(eq(PersistenceUnitTransactionType.JTA));
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get("Persistence Unit Name"));
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("ThreadLocalManager.notify.orphans");
    MutablePersistenceUnitInfo newPU = mock(MutablePersistenceUnitInfo.class);
    doNothing().when(newPU).setJtaDataSource(Mockito.<DataSource>any());
    doNothing().when(newPU).setNonJtaDataSource(Mockito.<DataSource>any());
    doNothing().when(newPU).setPersistenceProviderClassName(Mockito.<String>any());
    doNothing().when(newPU).setPersistenceProviderPackageName(Mockito.<String>any());
    when(newPU.getPersistenceProviderClassName()).thenReturn("Persistence Provider Class Name");
    when(newPU.getPersistenceProviderPackageName()).thenReturn("java.text");
    when(newPU.getTransactionType()).thenReturn(PersistenceUnitTransactionType.JTA);
    when(newPU.getJtaDataSource()).thenReturn(mock(DataSource.class));
    when(newPU.getNonJtaDataSource()).thenReturn(mock(DataSource.class));
    doNothing().when(newPU).setTransactionType(Mockito.<PersistenceUnitTransactionType>any());
    when(newPU.excludeUnlistedClasses()).thenReturn(true);
    when(newPU.getPersistenceUnitName()).thenReturn("Persistence Unit Name");
    when(newPU.getJarFileUrls()).thenReturn(new ArrayList<>());
    when(newPU.getManagedClassNames()).thenReturn(stringList);
    when(newPU.getMappingFileNames()).thenReturn(new ArrayList<>());
    when(newPU.getProperties()).thenReturn(new Properties());
    doNothing().when(newPU).setExcludeUnlistedClasses(anyBoolean());

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    verify(newPU).excludeUnlistedClasses();
    verify(newPU).getJarFileUrls();
    verify(newPU, atLeast(1)).getJtaDataSource();
    verify(newPU, atLeast(1)).getManagedClassNames();
    verify(newPU).getMappingFileNames();
    verify(newPU, atLeast(1)).getNonJtaDataSource();
    verify(newPU, atLeast(1)).getPersistenceProviderClassName();
    verify(newPU, atLeast(1)).getPersistenceProviderPackageName();
    verify(newPU).getPersistenceUnitName();
    verify(newPU, atLeast(1)).getProperties();
    verify(newPU).getTransactionType();
    verify(newPU).setExcludeUnlistedClasses(eq(true));
    verify(newPU).setJtaDataSource(isA(DataSource.class));
    verify(newPU).setNonJtaDataSource(isA(DataSource.class));
    verify(newPU).setPersistenceProviderClassName(eq("Persistence Provider Class Name"));
    verify(newPU).setPersistenceProviderPackageName(eq("java.text"));
    verify(newPU).setTransactionType(eq(PersistenceUnitTransactionType.JTA));
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get("Persistence Unit Name"));
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("ThreadLocalManager.notify.orphans");
    MutablePersistenceUnitInfo newPU = mock(MutablePersistenceUnitInfo.class);
    doNothing().when(newPU).setJtaDataSource(Mockito.<DataSource>any());
    doNothing().when(newPU).setNonJtaDataSource(Mockito.<DataSource>any());
    doNothing().when(newPU).setPersistenceProviderClassName(Mockito.<String>any());
    doNothing().when(newPU).setPersistenceProviderPackageName(Mockito.<String>any());
    when(newPU.getPersistenceProviderClassName()).thenReturn("Persistence Provider Class Name");
    when(newPU.getPersistenceProviderPackageName()).thenReturn("java.text");
    when(newPU.getTransactionType()).thenReturn(PersistenceUnitTransactionType.JTA);
    when(newPU.getJtaDataSource()).thenReturn(mock(DataSource.class));
    when(newPU.getNonJtaDataSource()).thenReturn(mock(DataSource.class));
    doNothing().when(newPU).setTransactionType(Mockito.<PersistenceUnitTransactionType>any());
    when(newPU.excludeUnlistedClasses()).thenReturn(true);
    when(newPU.getPersistenceUnitName()).thenReturn("Persistence Unit Name");
    when(newPU.getJarFileUrls()).thenReturn(new ArrayList<>());
    when(newPU.getManagedClassNames()).thenReturn(new ArrayList<>());
    when(newPU.getMappingFileNames()).thenReturn(stringList);
    when(newPU.getProperties()).thenReturn(new Properties());
    doNothing().when(newPU).setExcludeUnlistedClasses(anyBoolean());

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    verify(newPU).excludeUnlistedClasses();
    verify(newPU).getJarFileUrls();
    verify(newPU, atLeast(1)).getJtaDataSource();
    verify(newPU).getManagedClassNames();
    verify(newPU, atLeast(1)).getMappingFileNames();
    verify(newPU, atLeast(1)).getNonJtaDataSource();
    verify(newPU, atLeast(1)).getPersistenceProviderClassName();
    verify(newPU, atLeast(1)).getPersistenceProviderPackageName();
    verify(newPU).getPersistenceUnitName();
    verify(newPU, atLeast(1)).getProperties();
    verify(newPU).getTransactionType();
    verify(newPU).setExcludeUnlistedClasses(eq(true));
    verify(newPU).setJtaDataSource(isA(DataSource.class));
    verify(newPU).setNonJtaDataSource(isA(DataSource.class));
    verify(newPU).setPersistenceProviderClassName(eq("Persistence Provider Class Name"));
    verify(newPU).setPersistenceProviderPackageName(eq("java.text"));
    verify(newPU).setTransactionType(eq(PersistenceUnitTransactionType.JTA));
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get("Persistence Unit Name"));
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    MutablePersistenceUnitInfo newPU = mock(MutablePersistenceUnitInfo.class);
    doThrow(new IllegalStateException("ThreadLocalManager.notify.orphans")).when(newPU)
        .setJtaDataSource(Mockito.<DataSource>any());
    when(newPU.getJtaDataSource()).thenReturn(mock(DataSource.class));
    when(newPU.excludeUnlistedClasses()).thenReturn(true);
    when(newPU.getPersistenceUnitName()).thenReturn("Persistence Unit Name");
    when(newPU.getJarFileUrls()).thenReturn(new ArrayList<>());
    when(newPU.getManagedClassNames()).thenReturn(new ArrayList<>());
    when(newPU.getMappingFileNames()).thenReturn(new ArrayList<>());
    when(newPU.getProperties()).thenReturn(new Properties());
    doNothing().when(newPU).setExcludeUnlistedClasses(anyBoolean());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU));
    verify(newPU).excludeUnlistedClasses();
    verify(newPU).getJarFileUrls();
    verify(newPU, atLeast(1)).getJtaDataSource();
    verify(newPU).getManagedClassNames();
    verify(newPU).getMappingFileNames();
    verify(newPU).getPersistenceUnitName();
    verify(newPU, atLeast(1)).getProperties();
    verify(newPU).setExcludeUnlistedClasses(eq(true));
    verify(newPU).setJtaDataSource(isA(DataSource.class));
  }

  /**
   * Test {@link MergePersistenceUnitManager#obtainPersistenceUnitInfo(String)}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#obtainPersistenceUnitInfo(String)}
   */
  @Test
  public void testObtainPersistenceUnitInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setDataSourceLookup(mock(DataSourceLookup.class));

    // Act and Assert
    assertNull(mergePersistenceUnitManager.obtainPersistenceUnitInfo("Persistence Unit Name"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#obtainPersistenceUnitInfo(String)}.
   * <ul>
   *   <li>Given {@link MergePersistenceUnitManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#obtainPersistenceUnitInfo(String)}
   */
  @Test
  public void testObtainPersistenceUnitInfo_givenMergePersistenceUnitManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new MergePersistenceUnitManager()).obtainPersistenceUnitInfo("Persistence Unit Name"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#obtainDefaultPersistenceUnitInfo()}.
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#obtainDefaultPersistenceUnitInfo()}
   */
  @Test
  public void testObtainDefaultPersistenceUnitInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new MergePersistenceUnitManager()).obtainDefaultPersistenceUnitInfo());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MergePersistenceUnitManager#setClassTransformers(List)}
   *   <li>{@link MergePersistenceUnitManager#getClassTransformers()}
   *   <li>{@link MergePersistenceUnitManager#isPersistenceUnitOverrideAllowed()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    ArrayList<BroadleafClassTransformer> classTransformers = new ArrayList<>();

    // Act
    mergePersistenceUnitManager.setClassTransformers(classTransformers);
    List<BroadleafClassTransformer> actualClassTransformers = mergePersistenceUnitManager.getClassTransformers();
    boolean actualIsPersistenceUnitOverrideAllowedResult = mergePersistenceUnitManager
        .isPersistenceUnitOverrideAllowed();

    // Assert that nothing has changed
    assertTrue(actualClassTransformers.isEmpty());
    assertTrue(actualIsPersistenceUnitOverrideAllowedResult);
    assertSame(classTransformers, actualClassTransformers);
  }

  /**
   * Test
   * {@link MergePersistenceUnitManager#disableSchemaCreateIfApplicable(String, MutablePersistenceUnitInfo)}.
   * <ul>
   *   <li>Given {@link Properties#Properties()}.</li>
   *   <li>Then calls {@link MutablePersistenceUnitInfo#getProperties()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergePersistenceUnitManager#disableSchemaCreateIfApplicable(String, MutablePersistenceUnitInfo)}
   */
  @Test
  public void testDisableSchemaCreateIfApplicable_givenProperties_thenCallsGetProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    MutablePersistenceUnitInfo pui = mock(MutablePersistenceUnitInfo.class);
    when(pui.getProperties()).thenReturn(new Properties());

    // Act
    mergePersistenceUnitManager.disableSchemaCreateIfApplicable("Persistence Unit Name", pui);

    // Assert
    verify(pui).getProperties();
  }

  /**
   * Test new {@link MergePersistenceUnitManager} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link MergePersistenceUnitManager}
   */
  @Test
  public void testNewMergePersistenceUnitManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    MergePersistenceUnitManager actualMergePersistenceUnitManager = new MergePersistenceUnitManager();

    // Assert
    DataSourceLookup dataSourceLookup = actualMergePersistenceUnitManager.getDataSourceLookup();
    assertTrue(dataSourceLookup instanceof JndiDataSourceLookup);
    assertNull(actualMergePersistenceUnitManager.getPersistenceUnitPostProcessors());
    assertNull(actualMergePersistenceUnitManager.mergedDataSources);
    assertNull(((JndiDataSourceLookup) dataSourceLookup).getJndiEnvironment());
    assertNull(((JndiDataSourceLookup) dataSourceLookup).getJndiTemplate().getEnvironment());
    assertNull(actualMergePersistenceUnitManager.mergedPersistenceXmlLocations);
    assertNull(actualMergePersistenceUnitManager.mergedClassTransformers);
    assertNull(actualMergePersistenceUnitManager.getDefaultDataSource());
    assertNull(actualMergePersistenceUnitManager.getDefaultJtaDataSource());
    assertNull(actualMergePersistenceUnitManager.entityMarkerClassTransformer);
    assertNull(actualMergePersistenceUnitManager.applicationContext);
    assertNull(actualMergePersistenceUnitManager.environment);
    assertNull(actualMergePersistenceUnitManager.getLoadTimeWeaver());
    assertNull(actualMergePersistenceUnitManager.mBeanExporter);
    assertTrue(actualMergePersistenceUnitManager.mergedPus.isEmpty());
    assertTrue(actualMergePersistenceUnitManager.getClassTransformers().isEmpty());
    assertTrue(actualMergePersistenceUnitManager.queryConfigurations.isEmpty());
    assertTrue(actualMergePersistenceUnitManager.isPersistenceUnitOverrideAllowed());
    assertTrue(((JndiDataSourceLookup) dataSourceLookup).isResourceRef());
  }
}
