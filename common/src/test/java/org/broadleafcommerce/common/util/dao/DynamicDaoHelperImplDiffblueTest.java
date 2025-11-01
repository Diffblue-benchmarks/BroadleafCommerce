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
   * Method under test:
   * {@link DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}
   */
  @Test
  public void testGetNonProxyImplementationClassIfNecessary() {
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
   * Method under test:
   * {@link DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}
   */
  @Test
  public void testGetNonProxyImplementationClassIfNecessary2() {
    // Arrange
    Class<HibernateProxy> candidate = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class,
        () -> DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(candidate));
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true, true).length);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling2() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, false, true).length);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling3() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true, false).length);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling4() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, false, false).length);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling5() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> ceilingClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class,
        () -> dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true, true));
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}
   */
  @Test
  public void testGetCachedPolymorphicEntityList() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    HashMap<Class<?>, Class<?>[]> polymorphicEntityCache = new HashMap<>();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertNull(dynamicDaoHelperImpl.getCachedPolymorphicEntityList(polymorphicEntityCache, ceilingClass));
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}
   */
  @Test
  public void testGetCachedPolymorphicEntityList2() {
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
    Class<?> resultClass = actualCachedPolymorphicEntityList[0];
    assertEquals(expectedResultClass, resultClass);
    assertSame(ceilingClass, resultClass);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}
   */
  @Test
  public void testGetCachedPolymorphicEntityList3() {
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
    Class<?> resultClass = actualCachedPolymorphicEntityList[0];
    assertEquals(expectedResultClass, resultClass);
    assertSame(ceilingClass, resultClass);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}
   */
  @Test
  public void testGetUpDownInheritance() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, true, true).length);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}
   */
  @Test
  public void testGetUpDownInheritance2() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, false, true).length);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}
   */
  @Test
  public void testGetUpDownInheritance3() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, true, false).length);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}
   */
  @Test
  public void testGetUpDownInheritance4() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Class> testClass = Class.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, true, true).length);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}
   */
  @Test
  public void testGetUpDownInheritance5() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, false, false).length);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}
   */
  @Test
  public void testGetUpDownInheritance6() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> testClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getUpDownInheritance(testClass, true, true));
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities() {
    // Arrange
    Class<Object> ceilingClass = Object.class;
    ArrayList<Class<?>> entities = new ArrayList<>();

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.sortEntities(ceilingClass, entities).length);
    assertTrue(entities.isEmpty());
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities2() {
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
    Class<?> resultClass = actualSortEntitiesResult[0];
    assertEquals(expectedResultClass, resultClass);
    assertSame(forNameResult, resultClass);
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities3() {
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
    assertTrue(entities.isEmpty());
    Class<Object> expectedResultClass = Object.class;
    Class<?> resultClass = actualSortEntitiesResult[0];
    assertEquals(expectedResultClass, resultClass);
    assertSame(forNameResult2, resultClass);
    assertSame(forNameResult2, actualSortEntitiesResult[1]);
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities4() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Class> forNameResult = Class.class;
    entities.add(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> dynamicDaoHelperImpl.sortEntities(ceilingClass, entities));
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities5() {
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
    Class<?> resultClass = actualSortEntitiesResult[0];
    assertEquals(expectedResultClass, resultClass);
    Class<Object> expectedResultClass2 = Object.class;
    Class<?> resultClass2 = actualSortEntitiesResult[1];
    assertEquals(expectedResultClass2, resultClass2);
    assertSame(forNameResult, resultClass);
    assertSame(forNameResult2, resultClass2);
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities6() {
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
    Class<?> resultClass = actualSortEntitiesResult[0];
    assertEquals(expectedResultClass, resultClass);
    Class<Object> expectedResultClass2 = Object.class;
    Class<?> resultClass2 = actualSortEntitiesResult[1];
    assertEquals(expectedResultClass2, resultClass2);
    assertSame(forNameResult2, resultClass);
    assertSame(forNameResult, resultClass2);
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  public void testIsExcludeClassFromPolymorphism() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(dynamicDaoHelperImpl.isExcludeClassFromPolymorphism(clazz));
  }

  /**
   * Method under test:
   * {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  public void testIsExcludeClassFromPolymorphism2() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> clazz = HibernateProxy.class;

    // Act and Assert
    assertTrue(dynamicDaoHelperImpl.isExcludeClassFromPolymorphism(clazz));
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#getPropertyNames(Class)}
   */
  @Test
  public void testGetPropertyNames() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicDaoHelperImpl.getPropertyNames(entityClass).isEmpty());
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#getPropertyNames(Class)}
   */
  @Test
  public void testGetPropertyNames2() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> entityClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getPropertyNames(entityClass));
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}
   */
  @Test
  public void testGetPropertyTypes() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicDaoHelperImpl.getPropertyTypes(entityClass).isEmpty());
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}
   */
  @Test
  public void testGetPropertyTypes2() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> entityClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getPropertyTypes(entityClass));
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#getIdentifier(Object)}
   */
  @Test
  public void testGetIdentifier() {
    // Arrange, Act and Assert
    assertNull(dynamicDaoHelperImpl.getIdentifier(DynamicDaoHelperImpl.LOCK_OBJECT));
  }

  /**
   * Method under test: {@link DynamicDaoHelperImpl#getIdField(Class)}
   */
  @Test
  public void testGetIdField() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> clazz = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getIdField(clazz));
  }
}
