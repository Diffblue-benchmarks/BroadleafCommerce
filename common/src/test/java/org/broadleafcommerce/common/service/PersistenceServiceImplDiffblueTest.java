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
package org.broadleafcommerce.common.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
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
  @Mock
  private EntityConfiguration entityConfiguration;

  @Mock
  private List<EntityManager> list;

  @Mock
  private List<Map<String, Map<String, Object>>> list2;

  @Mock
  private Map<String, Map<String, Object>> map;

  @InjectMocks
  private PersistenceServiceImpl persistenceServiceImpl;

  /**
   * Test {@link PersistenceServiceImpl#stop(Runnable)} with {@code Runnable}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#stop(Runnable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PersistenceServiceImpl.stop(Runnable)"})
  public void testStopWithRunnable_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    Runnable callback = mock(Runnable.class);
    doThrow(new RuntimeException("foo")).when(callback).run();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistenceServiceImpl.stop(callback));
    verify(callback).run();
  }

  /**
   * Test {@link PersistenceServiceImpl#stop(Runnable)} with {@code Runnable}.
   * <ul>
   *   <li>When {@link Runnable} {@link Runnable#run()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#stop(Runnable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PersistenceServiceImpl.stop(Runnable)"})
  public void testStopWithRunnable_whenRunnableRunDoesNothing() {
    // Arrange
    Runnable callback = mock(Runnable.class);
    doNothing().when(callback).run();

    // Act
    persistenceServiceImpl.stop(callback);

    // Assert
    verify(callback).run();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistenceServiceImpl#stop()}
   *   <li>{@link PersistenceServiceImpl#getPhase()}
   *   <li>{@link PersistenceServiceImpl#isAutoStartup()}
   *   <li>{@link PersistenceServiceImpl#isRunning()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PersistenceServiceImpl.getPhase()", "boolean PersistenceServiceImpl.isAutoStartup()",
      "boolean PersistenceServiceImpl.isRunning()", "void PersistenceServiceImpl.stop()"})
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
   * <p>
   * Method under test: {@link PersistenceServiceImpl#validateEntityClassName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PersistenceServiceImpl.validateEntityClassName(String)"})
  public void testValidateEntityClassName() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistenceServiceImpl.validateEntityClassName("Entity Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Entity Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#validateEntityClassName(String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#validateEntityClassName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PersistenceServiceImpl.validateEntityClassName(String)"})
  public void testValidateEntityClassName_givenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);

    // Act
    boolean actualValidateEntityClassNameResult = persistenceServiceImpl.validateEntityClassName("Entity Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass(eq("Entity Class Name"));
    assertFalse(actualValidateEntityClassNameResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#validateEntityClassName(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#validateEntityClassName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PersistenceServiceImpl.validateEntityClassName(String)"})
  public void testValidateEntityClassName_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistenceServiceImpl.validateEntityClassName("Entity Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Entity Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyEntityManager(Class, TargetModeType)} with {@code entityClass}, {@code targetModeType}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#identifyEntityManager(Class, TargetModeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityManager PersistenceServiceImpl.identifyEntityManager(Class, TargetModeType)"})
  public void testIdentifyEntityManagerWithEntityClassTargetModeType_thenThrowRuntimeException() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> persistenceServiceImpl.identifyEntityManager(entityClass, TargetModeType.PRODUCTION));
    verify(entityConfiguration).lookupEntityClass(eq("java.lang.Object"));
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyEntityManager(Class)} with {@code entityClass}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#identifyEntityManager(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityManager PersistenceServiceImpl.identifyEntityManager(Class)"})
  public void testIdentifyEntityManagerWithEntityClass_thenThrowRuntimeException() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistenceServiceImpl.identifyEntityManager(entityClass));
    verify(entityConfiguration).lookupEntityClass(eq("java.lang.Object"));
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyTransactionManager(String, TargetModeType)}.
   * <p>
   * Method under test: {@link PersistenceServiceImpl#identifyTransactionManager(String, TargetModeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PlatformTransactionManager PersistenceServiceImpl.identifyTransactionManager(String, TargetModeType)"})
  public void testIdentifyTransactionManager() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> persistenceServiceImpl.identifyTransactionManager("Class Name", TargetModeType.PRODUCTION));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyTransactionManager(String, TargetModeType)}.
   * <p>
   * Method under test: {@link PersistenceServiceImpl#identifyTransactionManager(String, TargetModeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PlatformTransactionManager PersistenceServiceImpl.identifyTransactionManager(String, TargetModeType)"})
  public void testIdentifyTransactionManager2() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> persistenceServiceImpl.identifyTransactionManager("Class Name", TargetModeType.PRODUCTION));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyTransactionManager(String, TargetModeType)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#identifyTransactionManager(String, TargetModeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PlatformTransactionManager PersistenceServiceImpl.identifyTransactionManager(String, TargetModeType)"})
  public void testIdentifyTransactionManager_givenJavaLangObject_thenThrowRuntimeException() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> persistenceServiceImpl.identifyTransactionManager("Class Name", TargetModeType.PRODUCTION));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyDefaultEntityManager(TargetModeType)}.
   * <ul>
   *   <li>When {@link TargetModeType#PRODUCTION}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#identifyDefaultEntityManager(TargetModeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityManager PersistenceServiceImpl.identifyDefaultEntityManager(TargetModeType)"})
  public void testIdentifyDefaultEntityManager_whenProduction_thenReturnNull() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());

    // Act
    EntityManager actualIdentifyDefaultEntityManagerResult = persistenceServiceImpl
        .identifyDefaultEntityManager(TargetModeType.PRODUCTION);

    // Assert
    verify(map).get(isA(Object.class));
    assertNull(actualIdentifyDefaultEntityManagerResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#getEntityManager(Map)}.
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getEntityManager(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityManager PersistenceServiceImpl.getEntityManager(Map)"})
  public void testGetEntityManager() {
    // Arrange, Act and Assert
    assertNull(persistenceServiceImpl.getEntityManager(new HashMap<>()));
  }

  /**
   * Test {@link PersistenceServiceImpl#identifyDefaultTransactionManager(TargetModeType)}.
   * <ul>
   *   <li>When {@link TargetModeType#PRODUCTION}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#identifyDefaultTransactionManager(TargetModeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PlatformTransactionManager PersistenceServiceImpl.identifyDefaultTransactionManager(TargetModeType)"})
  public void testIdentifyDefaultTransactionManager_whenProduction_thenReturnNull() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());

    // Act
    PlatformTransactionManager actualIdentifyDefaultTransactionManagerResult = persistenceServiceImpl
        .identifyDefaultTransactionManager(TargetModeType.PRODUCTION);

    // Assert
    verify(map).get(isA(Object.class));
    assertNull(actualIdentifyDefaultTransactionManagerResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#getTransactionManager(Map)}.
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getTransactionManager(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PlatformTransactionManager PersistenceServiceImpl.getTransactionManager(Map)"})
  public void testGetTransactionManager() {
    // Arrange, Act and Assert
    assertNull(persistenceServiceImpl.getTransactionManager(new HashMap<>()));
  }

  /**
   * Test {@link PersistenceServiceImpl#getCeilingImplClassFromEntityManagers(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getCeilingImplClassFromEntityManagers(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class PersistenceServiceImpl.getCeilingImplClassFromEntityManagers(String)"})
  public void testGetCeilingImplClassFromEntityManagers_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> persistenceServiceImpl.getCeilingImplClassFromEntityManagers("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)} with {@code targetMode}, {@code className}.
   * <p>
   * Method under test: {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistenceServiceImpl.buildManagerCacheKey(String, String)"})
  public void testBuildManagerCacheKeyWithTargetModeClassName() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);

    // Act
    String actualBuildManagerCacheKeyResult = persistenceServiceImpl.buildManagerCacheKey("Target Mode", "Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
    assertEquals("Target Mode|java.lang.Object", actualBuildManagerCacheKeyResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)} with {@code targetMode}, {@code className}.
   * <p>
   * Method under test: {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistenceServiceImpl.buildManagerCacheKey(String, String)"})
  public void testBuildManagerCacheKeyWithTargetModeClassName2() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> persistenceServiceImpl.buildManagerCacheKey("Target Mode", "Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)} with {@code targetMode}, {@code className}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#buildManagerCacheKey(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistenceServiceImpl.buildManagerCacheKey(String, String)"})
  public void testBuildManagerCacheKeyWithTargetModeClassName_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> persistenceServiceImpl.buildManagerCacheKey("Target Mode", "Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#buildManagerCacheKey(String, Class)} with {@code targetMode}, {@code clazz}.
   * <ul>
   *   <li>Then return {@code Target Mode|Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#buildManagerCacheKey(String, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistenceServiceImpl.buildManagerCacheKey(String, Class)"})
  public void testBuildManagerCacheKeyWithTargetModeClazz_thenReturnTargetModeJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);
    Class<Object> clazz = Object.class;

    // Act
    String actualBuildManagerCacheKeyResult = persistenceServiceImpl.buildManagerCacheKey("Target Mode", clazz);

    // Assert
    verify(entityConfiguration).lookupEntityClass(eq("java.lang.Object"));
    assertEquals("Target Mode|java.lang.Object", actualBuildManagerCacheKeyResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#buildEJB3ConfigDaoCacheKey(Class)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then return {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#buildEJB3ConfigDaoCacheKey(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistenceServiceImpl.buildEJB3ConfigDaoCacheKey(Class)"})
  public void testBuildEJB3ConfigDaoCacheKey_givenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);
    Class<Object> clazz = Object.class;

    // Act
    String actualBuildEJB3ConfigDaoCacheKeyResult = persistenceServiceImpl.buildEJB3ConfigDaoCacheKey(clazz);

    // Assert
    verify(entityConfiguration).lookupEntityClass(eq("java.lang.Object"));
    assertEquals("java.lang.Object", actualBuildEJB3ConfigDaoCacheKeyResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#getManagedClassName(String)}.
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getManagedClassName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistenceServiceImpl.getManagedClassName(String)"})
  public void testGetManagedClassName() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistenceServiceImpl.getManagedClassName("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#getManagedClassName(String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then return {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getManagedClassName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistenceServiceImpl.getManagedClassName(String)"})
  public void testGetManagedClassName_givenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);

    // Act
    String actualManagedClassName = persistenceServiceImpl.getManagedClassName("Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
    assertEquals("java.lang.Object", actualManagedClassName);
  }

  /**
   * Test {@link PersistenceServiceImpl#getManagedClassName(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getManagedClassName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistenceServiceImpl.getManagedClassName(String)"})
  public void testGetManagedClassName_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistenceServiceImpl.getManagedClassName("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#getClassForName(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getClassForName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class PersistenceServiceImpl.getClassForName(String)"})
  public void testGetClassForName_whenClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> persistenceServiceImpl.getClassForName("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#getClassForName(String)}.
   * <ul>
   *   <li>When {@code Map}.</li>
   *   <li>Then return {@link Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getClassForName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class PersistenceServiceImpl.getClassForName(String)"})
  public void testGetClassForName_whenJavaUtilMap_thenReturnMap() {
    // Arrange and Act
    Class<?> actualClassForName = persistenceServiceImpl.getClassForName("java.util.Map");

    // Assert
    Class<Map> expectedClassForName = Map.class;
    assertEquals(expectedClassForName, actualClassForName);
  }
}
