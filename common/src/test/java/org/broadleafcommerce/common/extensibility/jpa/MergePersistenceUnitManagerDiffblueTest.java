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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer;
import org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer;
import org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MergePersistenceUnitManagerDiffblueTest {
  @Mock
  private ApplicationContext applicationContext;

  @Mock
  private EntityMarkerClassTransformer entityMarkerClassTransformer;

  @Mock
  private Environment environment;

  @Mock
  private List<QueryConfiguration> list;

  @Mock
  private Map<String, DataSource> map;

  @InjectMocks
  private MergePersistenceUnitManager mergePersistenceUnitManager;

  @Mock
  private Set<BroadleafClassTransformer> set;

  @Mock
  private Set<String> set2;

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager
        .setMappingResources("Did not recycle through class transformation since this has already occurred");

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
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet_givenArrayOfStringWithJavaText() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setPackagesToScan("java.text");

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
   *   <li>Then calls {@link ResourcePatternResolver#getResources(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet_thenCallsGetResources() throws IOException {
    // Arrange
    when(applicationContext.getResources(Mockito.<String>any())).thenReturn(new Resource[]{});

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert
    verify(applicationContext).getResources(eq("classpath*:META-INF/persistence.xml"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#afterPropertiesSet()}.
   * <ul>
   *   <li>Then {@link MergePersistenceUnitManager} (default constructor) {@link MergePersistenceUnitManager#mergedPus} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet_thenMergePersistenceUnitManagerMergedPusEmpty() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setLoadTimeWeaver(new DefaultContextLoadTimeWeaver());

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert that nothing has changed
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#configureClassTransformers()}.
   * <ul>
   *   <li>Given {@link List} {@link List#addAll(Collection)} return {@code true}.</li>
   *   <li>Then calls {@link List#addAll(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#configureClassTransformers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#getMergedUnit(String, MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MutablePersistenceUnitInfo MergePersistenceUnitManager.getMergedUnit(String, MutablePersistenceUnitInfo)"})
  public void testGetMergedUnit() {
    // Arrange
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();

    // Act
    MutablePersistenceUnitInfo actualMergedUnit = mergePersistenceUnitManager.getMergedUnit("Persistence Unit Name",
        newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertTrue(stringPersistenceUnitInfoMap.containsKey("Persistence Unit Name"));
    assertSame(newPU, actualMergedUnit);
  }

  /**
   * Test {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.preparePersistenceUnitInfos()"})
  public void testPreparePersistenceUnitInfos() {
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
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.preparePersistenceUnitInfos()"})
  public void testPreparePersistenceUnitInfos_givenArrayOfStringWithJavaText() {
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
   *   <li>Then calls {@link ResourcePatternResolver#getResources(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.preparePersistenceUnitInfos()"})
  public void testPreparePersistenceUnitInfos_thenCallsGetResources() throws IOException {
    // Arrange
    when(applicationContext.getResources(Mockito.<String>any())).thenReturn(new Resource[]{});

    // Act
    mergePersistenceUnitManager.preparePersistenceUnitInfos();

    // Assert
    verify(applicationContext).getResources(eq("classpath*:META-INF/persistence.xml"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#addTransformersToPersistenceUnits()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#addTransformersToPersistenceUnits()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergePersistenceUnitManager.addTransformersToPersistenceUnits()"})
  public void testAddTransformersToPersistenceUnits() throws Exception {
    // Arrange, Act and Assert
    assertTrue(mergePersistenceUnitManager.addTransformersToPersistenceUnits());
  }

  /**
   * Test {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergePersistenceUnitManager.addNamedQueriesToPersistenceUnits(boolean)"})
  public void testAddNamedQueriesToPersistenceUnits_whenFalse_thenReturnFalse() throws Exception {
    // Arrange, Act and Assert
    assertFalse(mergePersistenceUnitManager.addNamedQueriesToPersistenceUnits(false));
  }

  /**
   * Test {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#addNamedQueriesToPersistenceUnits(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergePersistenceUnitManager.addNamedQueriesToPersistenceUnits(boolean)"})
  public void testAddNamedQueriesToPersistenceUnits_whenTrue_thenReturnTrue() throws Exception {
    // Arrange, Act and Assert
    assertTrue(mergePersistenceUnitManager.addNamedQueriesToPersistenceUnits(true));
  }

  /**
   * Test {@link MergePersistenceUnitManager#handleClassTransformerRegistrationProblem(BroadleafClassTransformer, Exception)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#handleClassTransformerRegistrationProblem(BroadleafClassTransformer, Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean MergePersistenceUnitManager.handleClassTransformerRegistrationProblem(BroadleafClassTransformer, Exception)"})
  public void testHandleClassTransformerRegistrationProblem_thenReturnFalse() throws Exception {
    // Arrange
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
   * Method under test: {@link MergePersistenceUnitManager#exceptionWithNonTransformed(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.exceptionWithNonTransformed(List)"})
  public void testExceptionWithNonTransformed_whenArrayList_thenThrowIllegalStateException()
      throws ClassNotFoundException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> mergePersistenceUnitManager.exceptionWithNonTransformed(new ArrayList<>()));
  }

  /**
   * Test {@link MergePersistenceUnitManager#detectSpringBootDevtools()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#detectSpringBootDevtools()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergePersistenceUnitManager.detectSpringBootDevtools()"})
  public void testDetectSpringBootDevtools() {
    // Arrange, Act and Assert
    assertFalse(mergePersistenceUnitManager.detectSpringBootDevtools());
  }

  /**
   * Test {@link MergePersistenceUnitManager#detectNonTransformedClasses()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#detectNonTransformedClasses()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MergePersistenceUnitManager.detectNonTransformedClasses()"})
  public void testDetectNonTransformedClasses() {
    // Arrange, Act and Assert
    assertTrue(mergePersistenceUnitManager.detectNonTransformedClasses().isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#triggerClassLoadForManagedClasses()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#triggerClassLoadForManagedClasses()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MergePersistenceUnitManager.triggerClassLoadForManagedClasses()"})
  public void testTriggerClassLoadForManagedClasses() throws ClassNotFoundException {
    // Arrange, Act and Assert
    assertTrue(mergePersistenceUnitManager.triggerClassLoadForManagedClasses().isEmpty());
  }

  /**
   * Test {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"})
  public void testPostProcessPersistenceUnitInfo() {
    // Arrange
    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();

    // Act
    mergePersistenceUnitManager.postProcessPersistenceUnitInfo(newPU);

    // Assert
    HashMap<String, PersistenceUnitInfo> stringPersistenceUnitInfoMap = mergePersistenceUnitManager.mergedPus;
    assertEquals(1, stringPersistenceUnitInfoMap.size());
    assertSame(newPU, stringPersistenceUnitInfoMap.get(null));
  }

  /**
   * Test {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"})
  public void testPostProcessPersistenceUnitInfo2() {
    // Arrange
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
   * Test {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"})
  public void testPostProcessPersistenceUnitInfo3() throws MalformedURLException {
    // Arrange
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
   * Test {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"})
  public void testPostProcessPersistenceUnitInfo4() {
    // Arrange
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
   * Test {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"})
  public void testPostProcessPersistenceUnitInfo5() {
    // Arrange
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
   * Test {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"})
  public void testPostProcessPersistenceUnitInfo_thenThrowIllegalStateException() {
    // Arrange
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
   * Method under test: {@link MergePersistenceUnitManager#obtainPersistenceUnitInfo(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceUnitInfo MergePersistenceUnitManager.obtainPersistenceUnitInfo(String)"})
  public void testObtainPersistenceUnitInfo() {
    // Arrange, Act and Assert
    assertNull(mergePersistenceUnitManager.obtainPersistenceUnitInfo("Persistence Unit Name"));
  }

  /**
   * Test {@link MergePersistenceUnitManager#obtainDefaultPersistenceUnitInfo()}.
   * <p>
   * Method under test: {@link MergePersistenceUnitManager#obtainDefaultPersistenceUnitInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceUnitInfo MergePersistenceUnitManager.obtainDefaultPersistenceUnitInfo()"})
  public void testObtainDefaultPersistenceUnitInfo() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> mergePersistenceUnitManager.obtainDefaultPersistenceUnitInfo());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MergePersistenceUnitManager.getClassTransformers()",
      "boolean MergePersistenceUnitManager.isPersistenceUnitOverrideAllowed()",
      "void MergePersistenceUnitManager.setClassTransformers(List)"})
  public void testGettersAndSetters() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    ArrayList<BroadleafClassTransformer> classTransformers = new ArrayList<>();

    // Act
    mergePersistenceUnitManager.setClassTransformers(classTransformers);
    List<BroadleafClassTransformer> actualClassTransformers = mergePersistenceUnitManager.getClassTransformers();
    boolean actualIsPersistenceUnitOverrideAllowedResult = mergePersistenceUnitManager
        .isPersistenceUnitOverrideAllowed();

    // Assert
    assertTrue(actualClassTransformers.isEmpty());
    assertTrue(actualIsPersistenceUnitOverrideAllowedResult);
    assertSame(classTransformers, actualClassTransformers);
  }

  /**
   * Test new {@link MergePersistenceUnitManager} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MergePersistenceUnitManager}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergePersistenceUnitManager.<init>()"})
  public void testNewMergePersistenceUnitManager() {
    // Arrange and Act
    MergePersistenceUnitManager actualMergePersistenceUnitManager = new MergePersistenceUnitManager();

    // Assert
    assertTrue(actualMergePersistenceUnitManager.getDataSourceLookup() instanceof JndiDataSourceLookup);
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
