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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.exception.ProxyDetectionException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.hibernate.metamodel.internal.MetamodelImpl;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.spi.TypeConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicDaoHelperImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicDaoHelperImplDiffblueTest {
  @Autowired private DynamicDaoHelperImpl dynamicDaoHelperImpl;

  /**
   * Test {@link DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}.
   *
   * <ul>
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(Class)"})
  public void testGetNonProxyImplementationClassIfNecessary_thenReturnObject() {
    // Arrange
    Class<Object> candidate = Object.class;

    // Act
    Class<?> actualNonProxyImplementationClassIfNecessary =
        DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(candidate);

    // Assert
    Class<Object> expectedNonProxyImplementationClassIfNecessary = Object.class;
    assertEquals(
        expectedNonProxyImplementationClassIfNecessary,
        actualNonProxyImplementationClassIfNecessary);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}.
   *
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicDaoHelperImpl#getNonProxyImplementationClassIfNecessary(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(Class)"})
  public void testGetNonProxyImplementationClassIfNecessary_thenThrowProxyDetectionException() {
    // Arrange
    Class<HibernateProxy> candidate = HibernateProxy.class;

    // Act and Assert
    assertThrows(
        ProxyDetectionException.class,
        () -> DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(candidate));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)"
  })
  public void testGetAllPolymorphicEntitiesFromCeiling_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> ceilingClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(
        ProxyDetectionException.class,
        () -> dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true, true));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code Class}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)"
  })
  public void testGetAllPolymorphicEntitiesFromCeiling_whenJavaLangClass() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Class> ceilingClass = Class.class;

    // Act and Assert
    assertEquals(
        0,
        dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, false, false)
            .length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)"
  })
  public void testGetAllPolymorphicEntitiesFromCeiling_whenJavaLangObject() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(
        0,
        dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true, true).length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)"
  })
  public void testGetAllPolymorphicEntitiesFromCeiling_whenJavaLangObject2() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(
        0,
        dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, false, false)
            .length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)"
  })
  public void testGetAllPolymorphicEntitiesFromCeiling_whenJavaLangObject3() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(
        0,
        dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, false, true)
            .length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean, boolean)"
  })
  public void testGetAllPolymorphicEntitiesFromCeiling_whenJavaLangObject4() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(
        0,
        dynamicDaoHelperImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true, false)
            .length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.getCachedPolymorphicEntityList(Map, Class)"})
  public void testGetCachedPolymorphicEntityList_thenReturnArrayLengthIsOne() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();

    HashMap<Class<?>, Class<?>[]> polymorphicEntityCache = new HashMap<>();
    Class<Object> forNameResult = Object.class;
    Class<Object> forNameResult2 = Object.class;
    polymorphicEntityCache.put(forNameResult, new Class[] {forNameResult2});
    Class<Object> ceilingClass = Object.class;

    // Act
    Class<?>[] actualCachedPolymorphicEntityList =
        dynamicDaoHelperImpl.getCachedPolymorphicEntityList(polymorphicEntityCache, ceilingClass);

    // Assert
    assertEquals(1, actualCachedPolymorphicEntityList.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualCachedPolymorphicEntityList[0]);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getCachedPolymorphicEntityList(Map, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.getCachedPolymorphicEntityList(Map, Class)"})
  public void testGetCachedPolymorphicEntityList_whenHashMap_thenReturnNull() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    HashMap<Class<?>, Class<?>[]> polymorphicEntityCache = new HashMap<>();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertNull(
        dynamicDaoHelperImpl.getCachedPolymorphicEntityList(polymorphicEntityCache, ceilingClass));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.getUpDownInheritance(Class, boolean, boolean)"})
  public void testGetUpDownInheritance_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> testClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(
        ProxyDetectionException.class,
        () -> dynamicDaoHelperImpl.getUpDownInheritance(testClass, true, true));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.getUpDownInheritance(Class, boolean, boolean)"})
  public void testGetUpDownInheritance_whenFalse_thenReturnArrayLengthIsZero() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, false, true).length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.getUpDownInheritance(Class, boolean, boolean)"})
  public void testGetUpDownInheritance_whenFalse_thenReturnArrayLengthIsZero2() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, true, false).length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.getUpDownInheritance(Class, boolean, boolean)"})
  public void testGetUpDownInheritance_whenFalse_thenReturnArrayLengthIsZero3() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, false, false).length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getUpDownInheritance(Class, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.getUpDownInheritance(Class, boolean, boolean)"})
  public void testGetUpDownInheritance_whenJavaLangObject_thenReturnArrayLengthIsZero() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.getUpDownInheritance(testClass, true, true).length);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   *
   * <ul>
   *   <li>Given {@code Class}.
   *   <li>Then return array length is four.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.sortEntities(Class, List)"})
  public void testSortEntities_givenJavaLangClass_thenReturnArrayLengthIsFour() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    entities.add(forNameResult);
    Class<Class> forNameResult2 = Class.class;
    entities.add(forNameResult2);
    Class<Object> forNameResult3 = Object.class;
    entities.add(forNameResult3);
    Class<Object> forNameResult4 = Object.class;
    entities.add(forNameResult4);

    // Act
    Class<?>[] actualSortEntitiesResult = dynamicDaoHelperImpl.sortEntities(ceilingClass, entities);

    // Assert
    assertEquals(4, actualSortEntitiesResult.length);
    Class<Class> expectedResultClass = Class.class;
    assertEquals(expectedResultClass, actualSortEntitiesResult[0]);
    Class<Object> expectedResultClass2 = Object.class;
    assertEquals(expectedResultClass2, actualSortEntitiesResult[1]);
    assertSame(forNameResult4, actualSortEntitiesResult[2]);
    assertSame(forNameResult4, actualSortEntitiesResult[3]);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   *
   * <ul>
   *   <li>Given {@code Class}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.sortEntities(Class, List)"})
  public void testSortEntities_givenJavaLangClass_thenReturnArrayLengthIsThree() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Class> forNameResult = Class.class;
    entities.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    entities.add(forNameResult2);
    Class<Object> forNameResult3 = Object.class;
    entities.add(forNameResult3);

    // Act
    Class<?>[] actualSortEntitiesResult = dynamicDaoHelperImpl.sortEntities(ceilingClass, entities);

    // Assert
    assertEquals(3, actualSortEntitiesResult.length);
    Class<Class> expectedResultClass = Class.class;
    assertEquals(expectedResultClass, actualSortEntitiesResult[0]);
    Class<Object> expectedResultClass2 = Object.class;
    assertEquals(expectedResultClass2, actualSortEntitiesResult[1]);
    assertSame(forNameResult3, actualSortEntitiesResult[2]);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   *
   * <ul>
   *   <li>Given {@code Class}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.sortEntities(Class, List)"})
  public void testSortEntities_givenJavaLangClass_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Class> forNameResult = Class.class;
    entities.add(forNameResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dynamicDaoHelperImpl.sortEntities(ceilingClass, entities));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.sortEntities(Class, List)"})
  public void testSortEntities_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    Class<Object> ceilingClass = Object.class;
    ArrayList<Class<?>> entities = new ArrayList<>();

    // Act and Assert
    assertEquals(0, dynamicDaoHelperImpl.sortEntities(ceilingClass, entities).length);
    assertTrue(entities.isEmpty());
  }

  /**
   * Test {@link DynamicDaoHelperImpl#sortEntities(Class, List)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.sortEntities(Class, List)"})
  public void testSortEntities_whenJavaLangObject_thenReturnArrayLengthIsOne() {
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
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.sortEntities(Class, List)"})
  public void testSortEntities_whenJavaLangObject_thenReturnArrayLengthIsTwo() {
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
   *
   * <ul>
   *   <li>When {@code DynamicDaoHelperImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicDaoHelperImpl.sortEntities(Class, List)"})
  public void testSortEntities_whenOrgBroadleafcommerceCommonUtilDaoDynamicDaoHelperImpl() {
    // Arrange
    Class<DynamicDaoHelperImpl> ceilingClass = DynamicDaoHelperImpl.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Class> forNameResult = Class.class;
    entities.add(forNameResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dynamicDaoHelperImpl.sortEntities(ceilingClass, entities));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicDaoHelperImpl.isExcludeClassFromPolymorphism(Class)"})
  public void testIsExcludeClassFromPolymorphism_thenReturnTrue() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> clazz = HibernateProxy.class;

    // Act and Assert
    assertTrue(dynamicDaoHelperImpl.isExcludeClassFromPolymorphism(clazz));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicDaoHelperImpl.isExcludeClassFromPolymorphism(Class)"})
  public void testIsExcludeClassFromPolymorphism_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(dynamicDaoHelperImpl.isExcludeClassFromPolymorphism(clazz));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getIdMetadata(Class, EntityManager)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getIdMetadata(Class, EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicDaoHelperImpl.getIdMetadata(Class, EntityManager)"})
  public void testGetIdMetadata_thenReturnNull() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> entityClass = Object.class;

    SessionFactoryDelegatingImpl sessionFactoryDelegatingImpl =
        mock(SessionFactoryDelegatingImpl.class);
    SessionFactoryDelegatingImpl sessionFactory = new SessionFactoryDelegatingImpl(null);
    MetamodelImpl metamodelImpl = new MetamodelImpl(sessionFactory, new TypeConfiguration());
    when(sessionFactoryDelegatingImpl.getMetamodel()).thenReturn(metamodelImpl);

    SessionDelegatorBaseImpl sessionDelegatorBaseImpl = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl.getSessionFactory()).thenReturn(sessionFactoryDelegatingImpl);

    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    when(entityManager.unwrap(Mockito.<Class<Session>>any())).thenReturn(sessionDelegatorBaseImpl);

    // Act
    Map<String, Object> actualIdMetadata =
        dynamicDaoHelperImpl.getIdMetadata(entityClass, entityManager);

    // Assert
    verify(sessionDelegatorBaseImpl).getSessionFactory();
    verify(entityManager).unwrap(isA(Class.class));
    verify(sessionFactoryDelegatingImpl).getMetamodel();
    assertNull(actualIdMetadata);
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getPropertyNames(Class)}.
   *
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getPropertyNames(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DynamicDaoHelperImpl.getPropertyNames(Class)"})
  public void testGetPropertyNames_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> entityClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(
        ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getPropertyNames(entityClass));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getPropertyNames(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getPropertyNames(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DynamicDaoHelperImpl.getPropertyNames(Class)"})
  public void testGetPropertyNames_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicDaoHelperImpl.getPropertyNames(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}.
   *
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DynamicDaoHelperImpl.getPropertyTypes(Class)"})
  public void testGetPropertyTypes_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> entityClass = HibernateProxy.class;

    // Act and Assert
    assertThrows(
        ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getPropertyTypes(entityClass));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DynamicDaoHelperImpl.getPropertyTypes(Class)"})
  public void testGetPropertyTypes_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicDaoHelperImpl.getPropertyTypes(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getIdentifier(Object)}.
   *
   * <ul>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getIdentifier(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.Serializable DynamicDaoHelperImpl.getIdentifier(Object)"})
  public void testGetIdentifier_whenLock_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(dynamicDaoHelperImpl.getIdentifier(DynamicDaoHelperImpl.LOCK_OBJECT));
  }

  /**
   * Test {@link DynamicDaoHelperImpl#getIdField(Class)}.
   *
   * <ul>
   *   <li>Then throw {@link ProxyDetectionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDaoHelperImpl#getIdField(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.reflect.Field DynamicDaoHelperImpl.getIdField(Class)"})
  public void testGetIdField_thenThrowProxyDetectionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelperImpl = new DynamicDaoHelperImpl();
    Class<HibernateProxy> clazz = HibernateProxy.class;

    // Act and Assert
    assertThrows(ProxyDetectionException.class, () -> dynamicDaoHelperImpl.getIdField(clazz));
  }
}
