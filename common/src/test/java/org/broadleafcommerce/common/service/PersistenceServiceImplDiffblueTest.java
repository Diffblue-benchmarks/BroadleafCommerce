package org.broadleafcommerce.common.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(MockitoJUnitRunner.class)
public class PersistenceServiceImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @Mock private Map<String, Map<String, Object>> map;

  @InjectMocks private PersistenceServiceImpl persistenceServiceImpl;

  /**
   * Test {@link PersistenceServiceImpl#stop(Runnable)} with {@code Runnable}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#stop(Runnable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceServiceImpl.stop(Runnable)"})
  public void testStopWithRunnable_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();

    Runnable callback = mock(Runnable.class);
    doThrow(new RuntimeException()).when(callback).run();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistenceServiceImpl.stop(callback));
    verify(callback).run();
  }

  /**
   * Test {@link PersistenceServiceImpl#stop(Runnable)} with {@code Runnable}.
   *
   * <ul>
   *   <li>When {@link Runnable} {@link Runnable#run()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#stop(Runnable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceServiceImpl.stop(Runnable)"})
  public void testStopWithRunnable_whenRunnableRunDoesNothing() {
    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();

    Runnable callback = mock(Runnable.class);
    doNothing().when(callback).run();

    // Act
    persistenceServiceImpl.stop(callback);

    // Assert
    verify(callback).run();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistenceServiceImpl#stop()}
   *   <li>{@link PersistenceServiceImpl#getPhase()}
   *   <li>{@link PersistenceServiceImpl#isAutoStartup()}
   *   <li>{@link PersistenceServiceImpl#isRunning()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PersistenceServiceImpl.getPhase()",
    "boolean PersistenceServiceImpl.isAutoStartup()",
    "boolean PersistenceServiceImpl.isRunning()",
    "void PersistenceServiceImpl.stop()"
  })
  public void testGettersAndSetters() {
    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();

    // Act
    persistenceServiceImpl.stop();
    int actualPhase = persistenceServiceImpl.getPhase();
    boolean actualIsAutoStartupResult = persistenceServiceImpl.isAutoStartup();

    // Assert
    assertEquals(0, actualPhase);
    assertFalse(persistenceServiceImpl.isRunning());
    assertTrue(actualIsAutoStartupResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#validateEntityClassName(String)}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#validateEntityClassName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PersistenceServiceImpl.validateEntityClassName(String)"})
  public void testValidateEntityClassName() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> persistenceServiceImpl.validateEntityClassName("Entity Class Name"));
    verify(entityConfiguration).lookupEntityClass("Entity Class Name");
  }

  /**
   * Test {@link PersistenceServiceImpl#validateEntityClassName(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#validateEntityClassName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PersistenceServiceImpl.validateEntityClassName(String)"})
  public void testValidateEntityClassName_thenReturnFalse() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    // Act
    boolean actualValidateEntityClassNameResult =
        persistenceServiceImpl.validateEntityClassName("Entity Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass("Entity Class Name");
    assertFalse(actualValidateEntityClassNameResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#validateEntityClassName(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#validateEntityClassName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PersistenceServiceImpl.validateEntityClassName(String)"})
  public void testValidateEntityClassName_thenThrowRuntimeException() {
    // Arrange
    Class<Object> type = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> persistenceServiceImpl.validateEntityClassName("Entity Class Name"));
    verify(entityConfiguration).lookupEntityClass("Entity Class Name");
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyEntityManager(Class)} with {@code entityClass}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#identifyEntityManager(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager PersistenceServiceImpl.identifyEntityManager(Class)"})
  public void testIdentifyEntityManagerWithEntityClass() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> persistenceServiceImpl.identifyEntityManager(entityClass));
    verify(entityConfiguration).lookupEntityClass("java.lang.Object");
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyEntityManager(Class)} with {@code entityClass}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#identifyEntityManager(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager PersistenceServiceImpl.identifyEntityManager(Class)"})
  public void testIdentifyEntityManagerWithEntityClass2() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> persistenceServiceImpl.identifyEntityManager(entityClass));
    verify(entityConfiguration).lookupEntityClass("java.lang.Object");
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyEntityManager(Class, TargetModeType)} with {@code
   * entityClass}, {@code targetModeType}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#identifyEntityManager(Class,
   * TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityManager PersistenceServiceImpl.identifyEntityManager(Class, TargetModeType)"
  })
  public void testIdentifyEntityManagerWithEntityClassTargetModeType() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> persistenceServiceImpl.identifyEntityManager(entityClass, TargetModeType.PRODUCTION));
    verify(entityConfiguration).lookupEntityClass("java.lang.Object");
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyEntityManager(Class, TargetModeType)} with {@code
   * entityClass}, {@code targetModeType}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#identifyEntityManager(Class,
   * TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityManager PersistenceServiceImpl.identifyEntityManager(Class, TargetModeType)"
  })
  public void testIdentifyEntityManagerWithEntityClassTargetModeType2() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> persistenceServiceImpl.identifyEntityManager(entityClass, TargetModeType.PRODUCTION));
    verify(entityConfiguration).lookupEntityClass("java.lang.Object");
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyTransactionManager(String, TargetModeType)}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#identifyTransactionManager(String,
   * TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTransactionManager PersistenceServiceImpl.identifyTransactionManager(String, TargetModeType)"
  })
  public void testIdentifyTransactionManager() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            persistenceServiceImpl.identifyTransactionManager(
                "Class Name", TargetModeType.PRODUCTION));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyTransactionManager(String, TargetModeType)}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#identifyTransactionManager(String,
   * TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTransactionManager PersistenceServiceImpl.identifyTransactionManager(String, TargetModeType)"
  })
  public void testIdentifyTransactionManager2() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            persistenceServiceImpl.identifyTransactionManager(
                "Class Name", TargetModeType.PRODUCTION));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyTransactionManager(String, TargetModeType)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#identifyTransactionManager(String,
   * TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTransactionManager PersistenceServiceImpl.identifyTransactionManager(String, TargetModeType)"
  })
  public void testIdentifyTransactionManager_thenThrowRuntimeException() {
    // Arrange
    Class<Object> type = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            persistenceServiceImpl.identifyTransactionManager(
                "Class Name", TargetModeType.PRODUCTION));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyDefaultEntityManager(TargetModeType)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PersistenceServiceImpl#identifyDefaultEntityManager(TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityManager PersistenceServiceImpl.identifyDefaultEntityManager(TargetModeType)"
  })
  public void testIdentifyDefaultEntityManager_givenMapGetReturnHashMap_thenReturnNull() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());

    // Act
    EntityManager actualIdentifyDefaultEntityManagerResult =
        persistenceServiceImpl.identifyDefaultEntityManager(TargetModeType.PRODUCTION);

    // Assert
    verify(map).get(isA(Object.class));
    assertNull(actualIdentifyDefaultEntityManagerResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#getEntityManager(Map)}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#getEntityManager(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager PersistenceServiceImpl.getEntityManager(Map)"})
  public void testGetEntityManager() {
    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();

    // Act and Assert
    assertNull(persistenceServiceImpl.getEntityManager(new HashMap<>()));
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyDefaultTransactionManager(TargetModeType)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PersistenceServiceImpl#identifyDefaultTransactionManager(TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTransactionManager PersistenceServiceImpl.identifyDefaultTransactionManager(TargetModeType)"
  })
  public void testIdentifyDefaultTransactionManager_givenMapGetReturnHashMap_thenReturnNull() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());

    // Act
    PlatformTransactionManager actualIdentifyDefaultTransactionManagerResult =
        persistenceServiceImpl.identifyDefaultTransactionManager(TargetModeType.PRODUCTION);

    // Assert
    verify(map).get(isA(Object.class));
    assertNull(actualIdentifyDefaultTransactionManagerResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#getTransactionManager(Map)}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#getTransactionManager(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTransactionManager PersistenceServiceImpl.getTransactionManager(Map)"
  })
  public void testGetTransactionManager() {
    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();

    // Act and Assert
    assertNull(persistenceServiceImpl.getTransactionManager(new HashMap<>()));
  }

  /**
   * Test {@link PersistenceServiceImpl#getCeilingImplClassFromEntityManagers(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PersistenceServiceImpl#getCeilingImplClassFromEntityManagers(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class PersistenceServiceImpl.getCeilingImplClassFromEntityManagers(String)"})
  public void testGetCeilingImplClassFromEntityManagers_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new PersistenceServiceImpl().getCeilingImplClassFromEntityManagers("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)} with {@code
   * targetMode}, {@code className}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.buildManagerCacheKey(String, String)"})
  public void testBuildManagerCacheKeyWithTargetModeClassName() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    // Act
    String actualBuildManagerCacheKeyResult =
        persistenceServiceImpl.buildManagerCacheKey("Target Mode", "Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass("Class Name");
    assertEquals("Target Mode|java.lang.Object", actualBuildManagerCacheKeyResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)} with {@code
   * targetMode}, {@code className}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.buildManagerCacheKey(String, String)"})
  public void testBuildManagerCacheKeyWithTargetModeClassName2() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> persistenceServiceImpl.buildManagerCacheKey("Target Mode", "Class Name"));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)} with {@code
   * targetMode}, {@code className}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.buildManagerCacheKey(String, String)"})
  public void testBuildManagerCacheKeyWithTargetModeClassName_thenThrowRuntimeException() {
    // Arrange
    Class<Object> type = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> persistenceServiceImpl.buildManagerCacheKey("Target Mode", "Class Name"));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link PersistenceServiceImpl#buildManagerCacheKey(String, Class)} with {@code
   * targetMode}, {@code clazz}.
   *
   * <ul>
   *   <li>Then return {@code Target Mode|Object}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#buildManagerCacheKey(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.buildManagerCacheKey(String, Class)"})
  public void testBuildManagerCacheKeyWithTargetModeClazz_thenReturnTargetModeJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    Class<Object> clazz = Object.class;

    // Act
    String actualBuildManagerCacheKeyResult =
        persistenceServiceImpl.buildManagerCacheKey("Target Mode", clazz);

    // Assert
    verify(entityConfiguration).lookupEntityClass("java.lang.Object");
    assertEquals("Target Mode|java.lang.Object", actualBuildManagerCacheKeyResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#buildManagerCacheKey(String, Class)} with {@code
   * targetMode}, {@code clazz}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#buildManagerCacheKey(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.buildManagerCacheKey(String, Class)"})
  public void testBuildManagerCacheKeyWithTargetModeClazz_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> persistenceServiceImpl.buildManagerCacheKey("Target Mode", clazz));
    verify(entityConfiguration).lookupEntityClass("java.lang.Object");
  }

  /**
   * Test {@link PersistenceServiceImpl#buildEJB3ConfigDaoCacheKey(Class)}.
   *
   * <ul>
   *   <li>Then return {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#buildEJB3ConfigDaoCacheKey(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.buildEJB3ConfigDaoCacheKey(Class)"})
  public void testBuildEJB3ConfigDaoCacheKey_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    Class<Object> clazz = Object.class;

    // Act
    String actualBuildEJB3ConfigDaoCacheKeyResult =
        persistenceServiceImpl.buildEJB3ConfigDaoCacheKey(clazz);

    // Assert
    verify(entityConfiguration).lookupEntityClass("java.lang.Object");
    assertEquals("java.lang.Object", actualBuildEJB3ConfigDaoCacheKeyResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#buildEJB3ConfigDaoCacheKey(Class)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#buildEJB3ConfigDaoCacheKey(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.buildEJB3ConfigDaoCacheKey(Class)"})
  public void testBuildEJB3ConfigDaoCacheKey_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> persistenceServiceImpl.buildEJB3ConfigDaoCacheKey(clazz));
    verify(entityConfiguration).lookupEntityClass("java.lang.Object");
  }

  /**
   * Test {@link PersistenceServiceImpl#getManagedClassName(String)}.
   *
   * <p>Method under test: {@link PersistenceServiceImpl#getManagedClassName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.getManagedClassName(String)"})
  public void testGetManagedClassName() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> persistenceServiceImpl.getManagedClassName("Class Name"));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link PersistenceServiceImpl#getManagedClassName(String)}.
   *
   * <ul>
   *   <li>Then return {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#getManagedClassName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.getManagedClassName(String)"})
  public void testGetManagedClassName_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    // Act
    String actualManagedClassName = persistenceServiceImpl.getManagedClassName("Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass("Class Name");
    assertEquals("java.lang.Object", actualManagedClassName);
  }

  /**
   * Test {@link PersistenceServiceImpl#getManagedClassName(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#getManagedClassName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistenceServiceImpl.getManagedClassName(String)"})
  public void testGetManagedClassName_thenThrowRuntimeException() {
    // Arrange
    Class<Object> type = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> persistenceServiceImpl.getManagedClassName("Class Name"));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link PersistenceServiceImpl#getClassForName(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#getClassForName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class PersistenceServiceImpl.getClassForName(String)"})
  public void testGetClassForName_whenClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new PersistenceServiceImpl().getClassForName("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#getClassForName(String)}.
   *
   * <ul>
   *   <li>When {@code Map}.
   *   <li>Then return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceServiceImpl#getClassForName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class PersistenceServiceImpl.getClassForName(String)"})
  public void testGetClassForName_whenJavaUtilMap_thenReturnMap() {
    // Arrange and Act
    Class<?> actualClassForName = new PersistenceServiceImpl().getClassForName("java.util.Map");

    // Assert
    Class<Map> expectedClassForName = Map.class;
    assertEquals(expectedClassForName, actualClassForName);
  }
}
