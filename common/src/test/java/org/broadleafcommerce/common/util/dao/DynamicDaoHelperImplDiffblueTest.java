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
package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.exception.ProxyDetectionException;
import org.hibernate.proxy.HibernateProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicDaoHelperImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicDaoHelperImplDiffblueTest {
  @Autowired
  private DynamicDaoHelperImpl dynamicDaoHelperImpl;

  /**
   * Test
   * {@link DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}.
   * <ul>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}
   */
  @Test
  public void testGetNonProxyImplementationClassIfNecessary_thenReturnObject() {
    // Arrange
    Class<Object> candidate = Object.class;

    // Act
    Class<?> actualNonProxyImplementationClassIfNecessary = DynamicDaoHelperImpl
        .getNonProxyImplementationClassIfNecessary(candidate);

    // Assert
    Class<Object> expectedNonProxyImplementationClassIfNecessary = Object.class;
    assertEquals(expectedNonProxyImplementationClassIfNecessary, actualNonProxyImplementationClassIfNecessary);
  }

  /**
   * Test
   * {@link DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}.
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}
   */
  @Test
  public void testGetNonProxyImplementationClassIfNecessary_thenThrowProxyDetectionException() {
    // Arrange
    Class<HibernateProxy> candidate = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class,
        () -> DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(candidate));
  }

  /**
   * Test
   * {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)}.
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> ceilingClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class,
        () -> dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true, true));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}
   */
  @Test
  public void testGetCachedPolymorphicEntityList_givenBiFunction() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();

    HashMap<Class<?>, Class<?>[]> polymorphicEntityCache = new HashMap<>();
    Class<Object> forNameResult = Object.class;
    polymorphicEntityCache.computeIfPresent(forNameResult, mock(BiFunction.class));
    Class<Object> forNameResult2 = Object.class;
    Class<Object> forNameResult3 = Object.class;
    polymorphicEntityCache.put(forNameResult2, new Class[]{forNameResult3});
    Class<Object> ceilingClass = Object.class;

    // Act
    Class<?>[] actualCachedPolymorphicEntityList = dynamicDaoHelperImpl
        .getCachedPolymorphicEntityList(polymorphicEntityCache, ceilingClass);

    // Assert
    assertEquals(1, actualCachedPolymorphicEntityList.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualCachedPolymorphicEntityList[0]);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}
   */
  @Test
  public void testGetCachedPolymorphicEntityList_thenReturnArrayLengthIsOne() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();

    HashMap<Class<?>, Class<?>[]> polymorphicEntityCache = new HashMap<>();
    Class<Object> forNameResult = Object.class;
    Class<Object> forNameResult2 = Object.class;
    polymorphicEntityCache.put(forNameResult, new Class[]{forNameResult2});
    Class<Object> ceilingClass = Object.class;

    // Act
    Class<?>[] actualCachedPolymorphicEntityList = dynamicDaoHelperImpl
        .getCachedPolymorphicEntityList(polymorphicEntityCache, ceilingClass);

    // Assert
    assertEquals(1, actualCachedPolymorphicEntityList.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualCachedPolymorphicEntityList[0]);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}
   */
  @Test
  public void testGetCachedPolymorphicEntityList_whenHashMap_thenReturnNull() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    HashMap<Class<?>, Class<?>[]> polymorphicEntityCache = new HashMap<>();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertNull(dynamicDaoHelperImpl.getCachedPolymorphicEntityList(polymorphicEntityCache, ceilingClass));
  }

  /**
   * Test
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}.
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}
   */
  @Test
  public void testGetUpDownInheritance_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> testClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getUpDownInheritance(testClass, true, true));
  }

  /**
   * Test
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}.
   * <ul>
   *   <li>When {@code java.lang.Class}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}
   */
  @Test
  public void testGetUpDownInheritance_whenJavaLangClass_thenReturnArrayLengthIsZero() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Class> testClass = Class.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, true, true).length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>Given {@code java.lang.Class}.</li>
   *   <li>Then return first element is {@link Class}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_givenJavaLangClass_thenReturnFirstElementIsClass() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Class> forNameResult = Class.class;
    entities.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    entities.add(forNameResult2);

    // Act
    Class<?>[] actualSortEntitiesResult = dynamicDaoHelperImpl.sortEntities(ceilingClass, entities);

    // Assert
    assertEquals(2, actualSortEntitiesResult.length);
    assertTrue(entities.isEmpty());
    Class<Class> expectedResultClass = Class.class;
    assertEquals(expectedResultClass, actualSortEntitiesResult[0]);
    Class<Object> expectedResultClass2 = Object.class;
    assertEquals(expectedResultClass2, actualSortEntitiesResult[1]);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>Given {@code java.lang.Class}.</li>
   *   <li>Then return first element is {@link Class}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_givenJavaLangClass_thenReturnFirstElementIsClass2() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    entities.add(forNameResult);
    Class<Class> forNameResult2 = Class.class;
    entities.add(forNameResult2);

    // Act
    Class<?>[] actualSortEntitiesResult = dynamicDaoHelperImpl.sortEntities(ceilingClass, entities);

    // Assert
    assertEquals(2, actualSortEntitiesResult.length);
    assertTrue(entities.isEmpty());
    Class<Class> expectedResultClass = Class.class;
    assertEquals(expectedResultClass, actualSortEntitiesResult[0]);
    Class<Object> expectedResultClass2 = Object.class;
    assertEquals(expectedResultClass2, actualSortEntitiesResult[1]);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>Given {@code java.lang.Class}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_givenJavaLangClass_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Class> forNameResult = Class.class;
    entities.add(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> dynamicDaoHelperImpl.sortEntities(ceilingClass, entities));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_givenJavaLangObject_thenReturnArrayLengthIsOne() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    entities.add(forNameResult);

    // Act
    Class<?>[] actualSortEntitiesResult = dynamicDaoHelperImpl.sortEntities(ceilingClass, entities);

    // Assert
    assertEquals(1, actualSortEntitiesResult.length);
    assertTrue(entities.isEmpty());
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualSortEntitiesResult[0]);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return first element is {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_givenJavaLangObject_thenReturnFirstElementIsObject() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    entities.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    entities.add(forNameResult2);

    // Act
    Class<?>[] actualSortEntitiesResult = dynamicDaoHelperImpl.sortEntities(ceilingClass, entities);

    // Assert
    assertEquals(2, actualSortEntitiesResult.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualSortEntitiesResult[0]);
    assertSame(forNameResult2, actualSortEntitiesResult[1]);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    Class<Object> ceilingClass = Object.class;
    ArrayList<Class<?>> entities = new ArrayList<>();

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.sortEntities(ceilingClass, entities).length);
    assertTrue(entities.isEmpty());
  }

  /**
   * Test {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  public void testIsExcludeClassFromPolymorphism_thenReturnTrue() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> clazz = HibernateProxy.class;

    // Act and Assert
    assertTrue(dynamicDaoHelperImpl.isExcludeClassFromPolymorphism(clazz));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  public void testIsExcludeClassFromPolymorphism_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(dynamicDaoHelperImpl.isExcludeClassFromPolymorphism(clazz));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getPropertyNames(Class)}.
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#getPropertyNames(Class)}
   */
  @Test
  public void testGetPropertyNames_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> entityClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getPropertyNames(entityClass));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getPropertyNames(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#getPropertyNames(Class)}
   */
  @Test
  public void testGetPropertyNames_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicDaoHelperImpl.getPropertyNames(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}.
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}
   */
  @Test
  public void testGetPropertyTypes_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> entityClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getPropertyTypes(entityClass));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}
   */
  @Test
  public void testGetPropertyTypes_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicDaoHelperImpl.getPropertyTypes(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getIdentifier(Object)}.
   * <ul>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#getIdentifier(Object)}
   */
  @Test
  public void testGetIdentifier_whenLock_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(dynamicDaoHelperImpl.getIdentifier(DynamicDaoHelperImpl.LOCK_OBJECT));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getIdField(Class)}.
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicDaoHelperImpl#getIdField(Class)}
   */
  @Test
  public void testGetIdField_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> clazz = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getIdField(clazz));
  }
}
