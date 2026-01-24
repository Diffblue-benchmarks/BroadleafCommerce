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
import java.lang.reflect.UndeclaredThrowableException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer;
import org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class MergePersistenceUnitManagerDiffblueTest {
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
  public void testAfterPropertiesSet() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setMappingResources(
        "Did not recycle through class transformation since this has already occurred");

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
   * <p>Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet2() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setLoadTimeWeaver(new DefaultContextLoadTimeWeaver());

    // Act
    mergePersistenceUnitManager.afterPropertiesSet();

    // Assert that nothing has changed
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
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
  public void testAfterPropertiesSet_givenArrayOfStringWithJavaText() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    mergePersistenceUnitManager.setPackagesToScan("java.text");

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
   *   <li>Given {@link MergePersistenceUnitManager} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#afterPropertiesSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.afterPropertiesSet()"})
  public void testAfterPropertiesSet_givenMergePersistenceUnitManager() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

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
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
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
   *   <li>Then {@link MergePersistenceUnitManager} (default constructor) {@link
   *       MergePersistenceUnitManager#mergedPus} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#preparePersistenceUnitInfos()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.preparePersistenceUnitInfos()"})
  public void testPreparePersistenceUnitInfos_thenMergePersistenceUnitManagerMergedPusEmpty() {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    // Act
    mergePersistenceUnitManager.preparePersistenceUnitInfos();

    // Assert that nothing has changed
    assertTrue(mergePersistenceUnitManager.mergedPus.isEmpty());
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
    assertTrue(new MergePersistenceUnitManager().addTransformersToPersistenceUnits());
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
    assertFalse(new MergePersistenceUnitManager().addNamedQueriesToPersistenceUnits(false));
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
    assertTrue(new MergePersistenceUnitManager().addNamedQueriesToPersistenceUnits(true));
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
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
    AlterTableNameClassTransformer transformer = new AlterTableNameClassTransformer();

    Exception exception = new Exception("foo");
    exception.initCause(new IllegalStateException());

    // Act and Assert
    assertFalse(
        mergePersistenceUnitManager.handleClassTransformerRegistrationProblem(
            transformer, new UndeclaredThrowableException(exception)));
  }

  /**
   * Test {@link MergePersistenceUnitManager#exceptionWithNonTransformed(List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link MergePersistenceUnitManager#exceptionWithNonTransformed(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergePersistenceUnitManager.exceptionWithNonTransformed(List)"})
  public void testExceptionWithNonTransformed_thenThrowIllegalStateException()
      throws ClassNotFoundException {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    // Act and Assert
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
    assertFalse(new MergePersistenceUnitManager().detectSpringBootDevtools());
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
    assertTrue(new MergePersistenceUnitManager().detectNonTransformedClasses().isEmpty());
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
    assertTrue(new MergePersistenceUnitManager().triggerClassLoadForManagedClasses().isEmpty());
  }

  /**
   * Test {@link
   * MergePersistenceUnitManager#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <ul>
   *   <li>Given {@code New PU}.
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
  public void testPostProcessPersistenceUnitInfo_givenNewPu() throws MalformedURLException {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();
    newPU.addManagedClassName("New PU");
    newPU.addMappingFileName("New PU");
    newPU.addJarFileUrl(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    newPU.setProperties(new Properties());
    newPU.setJtaDataSource(mock(DataSource.class));
    newPU.setNonJtaDataSource(mock(DataSource.class));
    newPU.setPersistenceProviderClassName("New PU");
    newPU.setPersistenceProviderPackageName("New PU");
    newPU.setTransactionType(PersistenceUnitTransactionType.JTA);

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
   *   <li>Given {@link Properties#Properties()} {@link BLCFieldUtils#NULL_FIELD} is {@link
   *       BLCFieldUtils#NULL_FIELD}.
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
  public void testPostProcessPersistenceUnitInfo_givenPropertiesNull_fieldIsNull_field()
      throws MalformedURLException {
    // Arrange
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();

    Properties properties = new Properties();
    properties.put(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD);

    MutablePersistenceUnitInfo newPU = new MutablePersistenceUnitInfo();
    newPU.addManagedClassName("New PU");
    newPU.addMappingFileName("New PU");
    newPU.addJarFileUrl(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    newPU.setProperties(properties);
    newPU.setJtaDataSource(mock(DataSource.class));
    newPU.setNonJtaDataSource(mock(DataSource.class));
    newPU.setPersistenceProviderClassName("New PU");
    newPU.setPersistenceProviderPackageName("New PU");
    newPU.setTransactionType(PersistenceUnitTransactionType.JTA);

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
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

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
    MergePersistenceUnitManager mergePersistenceUnitManager = new MergePersistenceUnitManager();
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
    assertNull(
        new MergePersistenceUnitManager().obtainPersistenceUnitInfo("Persistence Unit Name"));
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
        () -> new MergePersistenceUnitManager().obtainDefaultPersistenceUnitInfo());
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
