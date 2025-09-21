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
package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.sql.DataSource;
import org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer;
import org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class MergePersistenceUnitManagerDiffblueTest {
  @Mock private ApplicationContext applicationContext;

  @Mock private List<QueryConfiguration> list;

  @InjectMocks private MergePersistenceUnitManager mergePersistenceUnitManager;

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet() throws IOException {
    // Arrange
    when(applicationContext.getResources(Mockito.<String>any())).thenReturn(new Resource[] {});
    new FileSystemResource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    verify(applicationContext).getResources("classpath*:META-INF/persistence.xml");
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet_givenArrayOfStringWithJavaText() throws Exception {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setPackagesToScan("java.text");
    mergePersistenceUnitManager.addTransformersToPersistenceUnits();

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("default"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Mapping Resources}.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet_givenArrayOfStringWithMappingResources() throws Exception {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setMappingResources("Mapping Resources");
    mergePersistenceUnitManager.addTransformersToPersistenceUnits();

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("default"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationContext#getResources(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet_thenCallsGetResources() throws IOException {
    // Arrange
    when(applicationContext.getResources(Mockito.<String>any())).thenReturn(new Resource[] {});

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    verify(applicationContext).getResources("classpath*:META-INF/persistence.xml");
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   *
   * <ul>
   *   <li>Then {@link MergePersistenceUnitManager} (default constructor) {@link
   *       MergePersistenceUnitManager#mergedPus} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet_thenMergePersistenceUnitManagerMergedPusEmpty()
      throws Exception {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setLoadTimeWeaver(new DefaultContextLoadTimeWeaver());
    mergePersistenceUnitManager.addTransformersToPersistenceUnits();

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert that nothing has changed
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#configureClassTransformers()}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#addAll(Collection)} return {@code true}.
   *   <li>Then calls {@link List#addAll(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#configureClassTransformers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.configureClassTransformers()"})
  public void testConfigureClassTransformers_givenListAddAllReturnTrue_thenCallsAddAll()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    when(list.addAll(Mockito.<Collection<QueryConfiguration>>any())).thenReturn(true);

    // Act
    mergePersistenceUnitManager.configureClassTransformers();

    // Assert
    verify(list).addAll(isNull());
  }

  /**
   * Test {@link MergePersistenceUnitManager#getMergedUnit(String, MutablePersistenceUnitInfo)}.
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#getMergedUnit(String,
   * MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MutablePersistenceUnitInfo MergePersistenceUnitManager.getMergedUnit(String, MutablePersistenceUnitInfo)"
  })
  public void testGetMergedUnit() {
    // Arrange
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();

    // Act
    MutablePersistenceUnitInfo actualMergedUnit =
        mergePersistenceUnitManager.getMergedUnit("Persistence Unit Name", newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("Persistence Unit Name"));
    assertSame(newPU, actualMergedUnit);
  }

  /**
   * Test {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}.
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.preparePersistenceUnitInfos()"})
  public void testPreparePersistenceUnitInfos() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setMappingResources(
        "Did not recycle through class transformation since this has already occurred");

    // Act
    mergePersistenceUnitManager.preparePersistenceUnitInfos();

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("default"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.preparePersistenceUnitInfos()"})
  public void testPreparePersistenceUnitInfos_givenArrayOfStringWithJavaText() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setPackagesToScan("java.text");

    // Act
    mergePersistenceUnitManager.preparePersistenceUnitInfos();

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("default"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationContext#getResources(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.preparePersistenceUnitInfos()"})
  public void testPreparePersistenceUnitInfos_thenCallsGetResources() throws IOException {
    // Arrange
    when(applicationContext.getResources(Mockito.<String>any())).thenReturn(new Resource[] {});

    // Act
    mergePersistenceUnitManager.preparePersistenceUnitInfos();

    // Assert
    verify(applicationContext).getResources("classpath*:META-INF/persistence.xml");
  }

  /**
   * Test {@link MergePersistenceUnitManager#addTransformersToPersistenceUnits()}.
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#addTransformersToPersistenceUnits()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MergePersistenceUnitManager.addTransformersToPersistenceUnits()"})
  public void testAddTransformersToPersistenceUnits() throws Exception {
    // Arrange, Act and Assert
    assertTrue(mergePersistenceUnitManager.addTransformersToPersistenceUnits());
  }

  /**
   * Test {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergePersistenceUnitManager.addNamedQueriesToPersistenceUnits(boolean)"
  })
  public void testAddNamedQueriesToPersistenceUnits_whenFalse_thenReturnFalse() throws Exception {
    // Arrange, Act and Assert
    assertFalse(mergePersistenceUnitManager.addNamedQueriesToPersistenceUnits(false));
  }

  /**
   * Test {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergePersistenceUnitManager.addNamedQueriesToPersistenceUnits(boolean)"
  })
  public void testAddNamedQueriesToPersistenceUnits_whenTrue_thenReturnTrue() throws Exception {
    // Arrange, Act and Assert
    assertTrue(mergePersistenceUnitManager.addNamedQueriesToPersistenceUnits(true));
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#handleClassTransformerRegistrationProblem(BroadleafClassTransformer,
   * Exception)}.
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#handleClassTransformerRegistrationProblem(BroadleafClassTransformer,
   * Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergePersistenceUnitManager.handleClassTransformerRegistrationProblem(BroadleafClassTransformer, Exception)"
  })
  public void testHandleClassTransformerRegistrationProblem() throws Exception {
    // Arrange
    AlterTableNameClassTransformer transformer = new AlterTableNameClassTransformer();

    IllegalStateException illegalStateException = new IllegalStateException();
    illegalStateException.initCause(null);

    // Act
    boolean actualHandleClassTransformerRegistrationProblemResult =
        mergePersistenceUnitManager.handleClassTransformerRegistrationProblem(
            transformer,
            new InvocationTargetException(new InvocationTargetException(illegalStateException)));

    // Assert
    assertFalse(actualHandleClassTransformerRegistrationProblemResult);
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#handleClassTransformerRegistrationProblem(BroadleafClassTransformer,
   * Exception)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#handleClassTransformerRegistrationProblem(BroadleafClassTransformer,
   * Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergePersistenceUnitManager.handleClassTransformerRegistrationProblem(BroadleafClassTransformer, Exception)"
  })
  public void testHandleClassTransformerRegistrationProblem_thenReturnFalse() throws Exception {
    // Arrange
    AlterTableNameClassTransformer transformer = new AlterTableNameClassTransformer();

    // Act and Assert
    assertFalse(
        mergePersistenceUnitManager.handleClassTransformerRegistrationProblem(
            transformer, new IllegalStateException()));
  }

  /**
   * Test {@link MergePersistenceUnitManager#exceptionWithNonTransformed(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#exceptionWithNonTransformed(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.exceptionWithNonTransformed(List)"})
  public void testExceptionWithNonTransformed_whenArrayList_thenThrowIllegalStateException()
      throws ClassNotFoundException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> mergePersistenceUnitManager.exceptionWithNonTransformed(new ArrayList<>()));
  }

  /**
   * Test {@link MergePersistenceUnitManager#detectSpringBootDevtools()}.
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#detectSpringBootDevtools()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MergePersistenceUnitManager.detectSpringBootDevtools()"})
  public void testDetectSpringBootDevtools() {
    // Arrange, Act and Assert
    assertFalse(mergePersistenceUnitManager.detectSpringBootDevtools());
  }

  /**
   * Test {@link MergePersistenceUnitManager#detectNonTransformedClasses()}.
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#detectNonTransformedClasses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MergePersistenceUnitManager.detectNonTransformedClasses()"})
  public void testDetectNonTransformedClasses() {
    // Arrange, Act and Assert
    assertTrue(mergePersistenceUnitManager.detectNonTransformedClasses().isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#triggerClassLoadForManagedClasses()}.
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#triggerClassLoadForManagedClasses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MergePersistenceUnitManager.triggerClassLoadForManagedClasses()"})
  public void testTriggerClassLoadForManagedClasses() throws ClassNotFoundException {
    // Arrange, Act and Assert
    assertTrue(mergePersistenceUnitManager.triggerClassLoadForManagedClasses().isEmpty());
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo() throws MalformedURLException {
    // Arrange
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();
    newPU.addManagedClassName("New PU");
    newPU.addMappingFileName("New PU");
    newPU.addJarFileUrl(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    newPU.setProperties(new Properties());
    newPU.setJtaDataSource(null);
    newPU.setNonJtaDataSource(null);
    newPU.setPersistenceProviderClassName(null);
    newPU.setPersistenceProviderPackageName(null);
    newPU.setTransactionType(null);

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get(null));
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo2() throws MalformedURLException {
    // Arrange
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();
    newPU.addManagedClassName("New PU");
    newPU.addMappingFileName("New PU");
    newPU.addJarFileUrl(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    newPU.setProperties(new Properties());
    newPU.setJtaDataSource(null);
    newPU.setNonJtaDataSource(null);
    newPU.setPersistenceProviderClassName(null);
    newPU.setPersistenceProviderPackageName("New PU");
    newPU.setTransactionType(null);

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get(null));
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo3() throws MalformedURLException {
    // Arrange
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();
    newPU.addManagedClassName("New PU");
    newPU.addMappingFileName("New PU");
    newPU.addJarFileUrl(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    newPU.setProperties(new Properties());
    newPU.setJtaDataSource(null);
    newPU.setNonJtaDataSource(null);
    newPU.setPersistenceProviderClassName("New PU");
    newPU.setPersistenceProviderPackageName(null);
    newPU.setTransactionType(null);

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get(null));
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo4() throws MalformedURLException {
    // Arrange
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();
    newPU.addManagedClassName("New PU");
    newPU.addMappingFileName("New PU");
    newPU.addJarFileUrl(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    newPU.setProperties(new Properties());
    newPU.setJtaDataSource(null);
    newPU.setNonJtaDataSource(mock(DataSource.class));
    newPU.setPersistenceProviderClassName(null);
    newPU.setPersistenceProviderPackageName(null);
    newPU.setTransactionType(null);

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get(null));
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo5() throws MalformedURLException {
    // Arrange
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();
    newPU.addManagedClassName("New PU");
    newPU.addMappingFileName("New PU");
    newPU.addJarFileUrl(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    newPU.setProperties(new Properties());
    newPU.setJtaDataSource(mock(DataSource.class));
    newPU.setNonJtaDataSource(null);
    newPU.setPersistenceProviderClassName(null);
    newPU.setPersistenceProviderPackageName(null);
    newPU.setTransactionType(null);

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get(null));
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo_thenThrowRuntimeException() {
    // Arrange
    PersistenceUnitPostProcessor persistenceUnitPostProcessor =
        mock(PersistenceUnitPostProcessor.class);
    doThrow(new RuntimeException())
        .when(persistenceUnitPostProcessor)
        .postProcessPersistenceUnitInfo(Mockito.<MutablePersistenceUnitInfo>any());

    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setPersistenceUnitPostProcessors(persistenceUnitPostProcessor);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            mergePersistenceUnitManager.postProcessPersistenceUnitInfo(
                mock(MutablePersistenceUnitInfo.class)));
    verify(persistenceUnitPostProcessor)
        .postProcessPersistenceUnitInfo(isA(MutablePersistenceUnitInfo.class));
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <ul>
   *   <li>When {@link MutablePersistenceUnitInfo} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo_whenMutablePersistenceUnitInfo() {
    // Arrange
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap =
        mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get(null));
  }

  /**
   * Test {@link MergePersistenceUnitManager#obtainPersistenceUnitInfo(String)}.
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#obtainPersistenceUnitInfo(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceUnitInfo MergePersistenceUnitManager.obtainPersistenceUnitInfo(String)"
  })
  public void testObtainPersistenceUnitInfo() {
    // Arrange, Act and Assert
    assertNull(mergePersistenceUnitManager.obtainPersistenceUnitInfo("Persistence Unit Name"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#obtainDefaultPersistenceUnitInfo()}.
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#obtainDefaultPersistenceUnitInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceUnitInfo MergePersistenceUnitManager.obtainDefaultPersistenceUnitInfo()"
  })
  public void testObtainDefaultPersistenceUnitInfo() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> mergePersistenceUnitManager.obtainDefaultPersistenceUnitInfo());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MergePersistenceUnitManager#setClassTransformers(List)}
   *   <li>{@link MergePersistenceUnitManager#getClassTransformers()}
   *   <li>{@link MergePersistenceUnitManager#isPersistenceUnitOverrideAllowed()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MergePersistenceUnitManager.getClassTransformers()",
    "boolean MergePersistenceUnitManager.isPersistenceUnitOverrideAllowed()",
    "void MergePersistenceUnitManager.setClassTransformers(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    ArrayList<BroadleafClassTransformer> classTransformers = new ArrayList<>();

    // Act
    mergePersistenceUnitManager.setClassTransformers(classTransformers);
    List<BroadleafClassTransformer> actualClassTransformers =
        mergePersistenceUnitManager.getClassTransformers();
    boolean actualIsPersistenceUnitOverrideAllowedResult =
        mergePersistenceUnitManager.isPersistenceUnitOverrideAllowed();

    // Assert
    assertTrue(actualClassTransformers.isEmpty());
    assertTrue(actualIsPersistenceUnitOverrideAllowedResult);
    assertSame(classTransformers, actualClassTransformers);
  }

  /**
   * Test new {@link MergePersistenceUnitManager} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * MergePersistenceUnitManager}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.<init>()"})
  public void testNewMergePersistenceUnitManager() {
    // Arrange and Act
    MergePersistenceUnitManager actualMergePersistenceUnitManager =
        new MergePersistenceUnitManager();

    // Assert
    assertTrue(
        actualMergePersistenceUnitManager.getDataSourceLookup() instanceof JndiDataSourceLookup);
    assertNull(actualMergePersistenceUnitManager.mergedDataSources);
    assertNull(actualMergePersistenceUnitManager.mergedPersistenceXmlLocations);
    assertNull(actualMergePersistenceUnitManager.mergedClassTransformers);
    assertNull(actualMergePersistenceUnitManager.getDefaultDataSource());
    assertNull(actualMergePersistenceUnitManager.getDefaultJtaDataSource());
    assertNull(actualMergePersistenceUnitManager.entityMarkerClassTransformer);
    assertNull(actualMergePersistenceUnitManager.applicationContext);
    assertNull(actualMergePersistenceUnitManager.environment);
    assertNull(actualMergePersistenceUnitManager.getLoadTimeWeaver());
    assertNull(actualMergePersistenceUnitManager.mBeanExporter);
    assertNull(actualMergePersistenceUnitManager.getPersistenceUnitPostProcessors());
    assertTrue(actualMergePersistenceUnitManager.mergedPus.isEmpty());
    assertTrue(actualMergePersistenceUnitManager.getClassTransformers().isEmpty());
    assertTrue(actualMergePersistenceUnitManager.queryConfigurations.isEmpty());
    assertTrue(actualMergePersistenceUnitManager.isPersistenceUnitOverrideAllowed());
  }
}
