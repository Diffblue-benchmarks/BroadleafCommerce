/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelper;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.FieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.hibernate.mapping.Property;
import org.hibernate.type.Type;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class DynamicEntityDaoImplDiffblueTest {
  /**
   * Test {@link DynamicEntityDaoImpl#getPersistentClass(String)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getPersistentClass(String)}
   */
  @Test
  public void testGetPersistentClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DynamicEntityDaoImpl()).getPersistentClass("Target Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#useCache()}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#useCache()}
   */
  @Test
  public void testUseCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DynamicEntityDaoImpl()).useCache());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   * with {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true).length);
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   * with {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, false).length);
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   * with {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities3()
      throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true).length);
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   * with {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities4()
      throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setApplicationContext(applicationContext);
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true).length);
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   * with {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities5()
      throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, false).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   * with {@code ceilingClass}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClass_whenJavaLangBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Boolean> ceilingClass = Boolean.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   * with {@code ceilingClass}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClass_whenJavaLangObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}
   */
  @Test
  public void testGetUpDownInheritance() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getUpDownInheritance(testClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}
   */
  @Test
  public void testGetUpDownInheritance2() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setApplicationContext(applicationContext);
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getUpDownInheritance(testClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}.
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl} (default constructor).</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}
   */
  @Test
  public void testGetUpDownInheritance_givenDynamicEntityDaoImpl_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getUpDownInheritance(testClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>Given {@link EntityConfiguration}
   * {@link EntityConfiguration#lookupEntityClass(String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  public void testGetImplClass_givenEntityConfigurationLookupEntityClassReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = mock(EntityConfiguration.class);
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(null);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setEntityConfiguration(entityConfiguration);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  public void testGetImplClass_givenJavaLangObject_whenClassName_thenReturnObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = mock(EntityConfiguration.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setEntityConfiguration(entityConfiguration);

    // Act
    Class<?> actualImplClass = dynamicEntityDaoImpl.getImplClass("Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
    Class<Object> expectedImplClass = Object.class;
    assertEquals(expectedImplClass, actualImplClass);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  public void testGetImplClass_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = mock(EntityConfiguration.class);
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setEntityConfiguration(entityConfiguration);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   *   <li>Then return {@link Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  public void testGetImplClass_whenJavaLangBoolean_thenReturnBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = mock(EntityConfiguration.class);
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setEntityConfiguration(entityConfiguration);

    // Act
    Class<?> actualImplClass = dynamicEntityDaoImpl.getImplClass("java.lang.Boolean");

    // Assert
    verify(entityConfiguration).lookupEntityClass(eq("java.lang.Boolean"));
    Class<Boolean> expectedImplClass = Boolean.class;
    assertEquals(expectedImplClass, actualImplClass);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  public void testGetCeilingImplClass_whenClassName_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new DynamicEntityDaoImpl()).getCeilingImplClass("Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  public void testGetCeilingImplClass_whenJavaLangBoolean_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new DynamicEntityDaoImpl()).getCeilingImplClass("java.lang.Boolean"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getIdentifier(Object)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getIdentifier(Object)}
   */
  @Test
  public void testGetIdentifier() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DynamicEntityDaoImpl()).getIdentifier("Entity"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>Given {@code java.lang.Boolean}.</li>
   *   <li>Then return first element is {@link Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_givenJavaLangBoolean_thenReturnFirstElementIsBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    entities.add(forNameResult);
    Class<Boolean> forNameResult2 = Boolean.class;
    entities.add(forNameResult2);

    // Act
    Class<?>[] actualSortEntitiesResult = dynamicEntityDaoImpl.sortEntities(ceilingClass, entities);

    // Assert
    assertEquals(2, actualSortEntitiesResult.length);
    assertTrue(entities.isEmpty());
    Class<Boolean> expectedResultClass = Boolean.class;
    assertEquals(expectedResultClass, actualSortEntitiesResult[0]);
    Class<Object> expectedResultClass2 = Object.class;
    assertEquals(expectedResultClass2, actualSortEntitiesResult[1]);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_givenJavaLangObject_thenReturnArrayLengthIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    entities.add(forNameResult);

    // Act
    Class<?>[] actualSortEntitiesResult = dynamicEntityDaoImpl.sortEntities(ceilingClass, entities);

    // Assert
    assertEquals(1, actualSortEntitiesResult.length);
    assertTrue(entities.isEmpty());
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualSortEntitiesResult[0]);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return array length is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_givenJavaLangObject_thenReturnArrayLengthIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    entities.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    entities.add(forNameResult2);

    // Act
    Class<?>[] actualSortEntitiesResult = dynamicEntityDaoImpl.sortEntities(ceilingClass, entities);

    // Assert
    assertEquals(2, actualSortEntitiesResult.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualSortEntitiesResult[0]);
    assertSame(forNameResult2, actualSortEntitiesResult[1]);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  public void testSortEntities_whenArrayList_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> ceilingClass = Object.class;
    ArrayList<Class<?>> entities = new ArrayList<>();

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.sortEntities(ceilingClass, entities).length);
    assertTrue(entities.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then calls {@link ClassTree#getFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}
   */
  @Test
  public void testAddClassToTree_givenDrJaneDoe_thenCallsGetFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> clazz = Object.class;
    ClassTree tree = mock(ClassTree.class);
    when(tree.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.addClassToTree(clazz, tree));
    verify(tree).getFullyQualifiedClassname();
  }

  /**
   * Test {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}.
   * <ul>
   *   <li>When {@link ClassTree#ClassTree(String)} with fullyQualifiedClassname is
   * {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}
   */
  @Test
  public void testAddClassToTree_whenClassTreeWithFullyQualifiedClassnameIsDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> dynamicEntityDaoImpl.addClassToTree(clazz, new ClassTree("Dr Jane Doe")));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTree(Class[])}.
   * <ul>
   *   <li>When empty array of {@link Class}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getClassTree(Class[])}
   */
  @Test
  public void testGetClassTree_whenEmptyArrayOfClass_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DynamicEntityDaoImpl()).getClassTree(new Class[]{}));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTree(Class[])}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return FriendlyName is {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getClassTree(Class[])}
   */
  @Test
  public void testGetClassTree_whenJavaLangObject_thenReturnFriendlyNameIsObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> forNameResult = Object.class;

    // Act
    ClassTree actualClassTree = dynamicEntityDaoImpl.getClassTree(new Class[]{forNameResult});

    // Assert
    assertEquals("Object", actualClassTree.getFriendlyName());
    assertEquals("Object", actualClassTree.getName());
    assertEquals("java.lang.Object", actualClassTree.getFullyQualifiedClassname());
    assertEquals(0, actualClassTree.getChildren().length);
    List<ClassTree> collapsedClassTrees = actualClassTree.getCollapsedClassTrees();
    assertEquals(1, collapsedClassTrees.size());
    assertEquals(1, actualClassTree.getLeft());
    assertEquals(2, actualClassTree.getRight());
    assertFalse(actualClassTree.hasChildren());
    assertFalse(actualClassTree.isExcludeFromPolymorphism());
    assertSame(actualClassTree, collapsedClassTrees.get(0));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}
   */
  @Test
  public void testGetClassTreeFromCeiling() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertNull(dynamicEntityDaoImpl.getClassTreeFromCeiling(ceilingClass));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}
   */
  @Test
  public void testGetClassTreeFromCeiling2() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setApplicationContext(applicationContext);
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertNull(dynamicEntityDaoImpl.getClassTreeFromCeiling(ceilingClass));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}.
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}
   */
  @Test
  public void testGetClassTreeFromCeiling_givenDynamicEntityDaoImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertNull(dynamicEntityDaoImpl.getClassTreeFromCeiling(ceilingClass));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  public void testGetSimpleMergedProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> dynamicEntityDaoImpl.getSimpleMergedProperties("Entity Name", new PersistencePerspective()));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)}
   * with {@code ceilingEntityFullyQualifiedClassname}, {@code entities},
   * {@code foreignField}, {@code additionalNonPersistentProperties},
   * {@code additionalForeignFields}, {@code mergedPropertyType},
   * {@code populateManyToOneFields}, {@code includeFields},
   * {@code excludeFields}, {@code configurationKey}, {@code prefix}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)}
   */
  @Test
  public void testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(new HashMap<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties("Dr Jane Doe",
        new Class[]{forNameResult}, foreignField, new String[]{"Additional Non Persistent Properties"},
        new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("Prefix"), eq(false),
        eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)}
   * with {@code ceilingEntityFullyQualifiedClassname}, {@code entities},
   * {@code foreignField}, {@code additionalNonPersistentProperties},
   * {@code additionalForeignFields}, {@code mergedPropertyType},
   * {@code populateManyToOneFields}, {@code includeFields},
   * {@code excludeFields}, {@code configurationKey}, {@code prefix}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)}
   */
  @Test
  public void testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(new HashMap<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties("Dr Jane Doe",
        new Class[]{forNameResult}, foreignField, new String[]{"Additional Non Persistent Properties"},
        new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, true, new String[]{},
        new String[]{"Exclude Fields"}, "Configuration Key", "Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("Prefix"), eq(false),
        eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with
   * {@code cls}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  public void testGetMergedPropertiesWithCls() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(stringFieldMetadataMap);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Object"), isNull(), isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with
   * {@code cls}.
   * <ul>
   *   <li>Then return containsKey {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  public void testGetMergedPropertiesWithCls_thenReturnContainsKeyFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(stringFieldMetadataMap);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Object"), isNull(), isA(DynamicEntityDao.class));
    assertEquals(1, actualMergedProperties.size());
    assertTrue(actualMergedProperties.containsKey("foo"));
    assertSame(stringFieldMetadataMap, actualMergedProperties);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with
   * {@code cls}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  public void testGetMergedPropertiesWithCls_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(new HashMap<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Object"), isNull(), isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with
   * {@code cls}.
   * <ul>
   *   <li>Then return {@code foo} is {@link AdornedTargetCollectionMetadata}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  public void testGetMergedPropertiesWithCls_thenReturnFooIsAdornedTargetCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(stringFieldMetadataMap);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Object"), isNull(), isA(DynamicEntityDao.class));
    assertEquals(1, actualMergedProperties.size());
    assertSame(adornedTargetCollectionMetadata, actualMergedProperties.get("foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with
   * {@code cls}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  public void testGetMergedPropertiesWithCls_whenJavaLangBoolean_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(new HashMap<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Boolean> cls = Boolean.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Boolean"), isNull(), isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with
   * {@code cls}.
   * <ul>
   *   <li>When {@code java.lang.Long}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  public void testGetMergedPropertiesWithCls_whenJavaLangLong() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(stringFieldMetadataMap);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Long> cls = Long.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Long"), isNull(), isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}
   */
  @Test
  public void testGetMergedPropertiesRecursively_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(new HashMap<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively = dynamicEntityDaoImpl.getMergedPropertiesRecursively(
        "Dr Jane Doe", new Class[]{forNameResult}, foreignField, new String[]{"Additional Non Persistent Properties"},
        new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", new ArrayList<>(), "Prefix", true, "Parent Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("Prefix"), eq(true),
        eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
    assertTrue(actualMergedPropertiesRecursively.isEmpty());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}
   */
  @Test
  public void testGetMergedPropertiesRecursively_whenEmptyArrayOfString_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(new HashMap<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively = dynamicEntityDaoImpl.getMergedPropertiesRecursively(
        "Dr Jane Doe", new Class[]{forNameResult}, foreignField, new String[]{"Additional Non Persistent Properties"},
        new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, true, new String[]{},
        new String[]{"Exclude Fields"}, "Configuration Key", new ArrayList<>(), "Prefix", true, "Parent Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("Prefix"), eq(true),
        eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
    assertTrue(actualMergedPropertiesRecursively.isEmpty());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}
   */
  @Test
  public void testApplyForeignKeyPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField,
        new ForeignKey[]{new ForeignKey("Many To Field", "Foreign Key Class")}, mergedProperties);

    // Assert
    verify(foreignField).getManyToField();
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertNull(getResult.getExcluded());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} empty string Excluded is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}
   */
  @Test
  public void testApplyForeignKeyPrecedence_thenHashMapEmptyStringExcludedIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField, new ForeignKey[]{foreignKey}, mergedProperties);

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertNull(getResult.getExcluded());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   * <ul>
   *   <li>Then not {@link HashMap#HashMap()} empty string Excluded.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}
   */
  @Test
  public void testApplyForeignKeyPrecedence_thenNotHashMapEmptyStringExcluded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("");
    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField, new ForeignKey[]{foreignKey}, mergedProperties);

    // Assert
    verify(foreignField).getManyToField();
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertFalse(getResult.getExcluded());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   * <ul>
   *   <li>Then not {@link HashMap#HashMap()} empty string Excluded.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}
   */
  @Test
  public void testApplyForeignKeyPrecedence_thenNotHashMapEmptyStringExcluded2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField, new ForeignKey[]{foreignKey}, mergedProperties);

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertFalse(getResult.getExcluded());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link HashMap#HashMap()} empty string Excluded is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}
   */
  @Test
  public void testApplyForeignKeyPrecedence_whenNull_thenHashMapEmptyStringExcludedIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField, null, mergedProperties);

    // Assert
    verify(foreignField).getManyToField();
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertNull(getResult.getExcluded());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}
   */
  @Test
  public void testApplyIncludesAndExcludes_givenDot() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.computeIfPresent(".", mock(BiFunction.class));
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(new String[]{"Include Fields"}, new String[]{"Exclude Fields"},
        "Prefix", true, mergedProperties);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertTrue(getResult.getExcluded());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadata#setExcluded(Boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}
   */
  @Test
  public void testApplyIncludesAndExcludes_thenCallsSetExcluded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(new String[]{"Include Fields"}, new String[]{"Exclude Fields"},
        "Prefix", true, mergedProperties);

    // Assert
    verify(adornedTargetCollectionMetadata).setExcluded(eq(true));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code foo} Excluded.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}
   */
  @Test
  public void testApplyIncludesAndExcludes_thenHashMapFooExcluded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(new String[]{"Include Fields"}, new String[]{"Exclude Fields"},
        "Prefix", true, mergedProperties);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertTrue(getResult.getExcluded());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code foo} Excluded is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}
   */
  @Test
  public void testApplyIncludesAndExcludes_thenHashMapFooExcludedIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(new String[]{"Prefixfoo"}, new String[]{"Exclude Fields"}, "Prefix",
        true, mergedProperties);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertNull(getResult.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#pad(String, int, char)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code AAA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#pad(String, int, char)}
   */
  @Test
  public void testPad_whenEmptyString_thenReturnAaa() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("AAA", (new DynamicEntityDaoImpl()).pad("", 3, 'A'));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#pad(String, int, char)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#pad(String, int, char)}
   */
  @Test
  public void testPad_whenFoo_thenReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("foo", (new DynamicEntityDaoImpl()).pad("foo", 3, 'A'));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}.
   * <ul>
   *   <li>Then return {@code cfdfd72e475f900ae49ce08efe7d93fb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}
   */
  @Test
  public void testGetCacheKey_thenReturnCfdfd72e475f900ae49ce08efe7d93fb() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("cfdfd72e475f900ae49ce08efe7d93fb",
        dynamicEntityDaoImpl.getCacheKey("Dr Jane Doe", foreignField,
            new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()},
            MergedPropertyType.PRIMARY, true, clazz, "Configuration Key", true));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code 83d7638ab51bce26f4ff6b4a29ddf077}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}
   */
  @Test
  public void testGetCacheKey_whenNull_thenReturn83d7638ab51bce26f4ff6b4a29ddf077() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("83d7638ab51bce26f4ff6b4a29ddf077", dynamicEntityDaoImpl.getCacheKey("Dr Jane Doe", null, null, null,
        MergedPropertyType.PRIMARY, true, clazz, "Configuration Key", true));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}.
   * <ul>
   *   <li>When {@code , originatingField='}.</li>
   *   <li>Then return {@code 0cf062a6e41767af4e8c19ab846b1965}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}
   */
  @Test
  public void testGetCacheKey_whenOriginatingField_thenReturn0cf062a6e41767af4e8c19ab846b1965() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("0cf062a6e41767af4e8c19ab846b1965",
        dynamicEntityDaoImpl.getCacheKey(", originatingField='", foreignField,
            new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()},
            MergedPropertyType.PRIMARY, true, clazz, "Configuration Key", true));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  public void testRefreshDecimalDefaultValue_given42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    BasicFieldMetadata value = mock(BasicFieldMetadata.class);
    when(value.getDefaultValue()).thenReturn("42");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    verify(value, atLeast(1)).getDefaultValue();
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) DefaultValue is
   * {@code .}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  public void testRefreshDecimalDefaultValue_givenDot_whenBasicFieldMetadataDefaultValueIsDot() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    BasicFieldMetadata value = new BasicFieldMetadata();
    value.setDefaultValue(".");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    assertEquals(".", value.getDefaultValue());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  public void testRefreshDecimalDefaultValue_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    BasicFieldMetadata value = mock(BasicFieldMetadata.class);
    when(value.getDefaultValue()).thenReturn("");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    verify(value, atLeast(1)).getDefaultValue();
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Then {@link BasicFieldMetadata} (default constructor) DefaultValue is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  public void testRefreshDecimalDefaultValue_thenBasicFieldMetadataDefaultValueIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    BasicFieldMetadata value = new BasicFieldMetadata();

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    assertNull(value.getDefaultValue());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  public void testRefreshDecimalDefaultValue_thenThrowNoSuchBeanDefinitionException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    BasicFieldMetadata value = mock(BasicFieldMetadata.class);
    doThrow(new NoSuchBeanDefinitionException("ThreadLocalManager.notify.orphans")).when(value)
        .setDefaultValue(Mockito.<String>any());
    when(value.getDefaultValue()).thenReturn(",");

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class, () -> dynamicEntityDaoImpl.refreshDecimalDefaultValue(value));
    verify(value, atLeast(1)).getDefaultValue();
    verify(value).setDefaultValue(eq("."));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) DefaultValue is
   * {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  public void testRefreshDecimalDefaultValue_whenBasicFieldMetadataDefaultValueIsComma() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    BasicFieldMetadata value = new BasicFieldMetadata();
    value.setDefaultValue(",");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    assertEquals(".", value.getDefaultValue());
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata}
   * {@link BasicFieldMetadata#setDefaultValue(String)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  public void testRefreshDecimalDefaultValue_whenBasicFieldMetadataSetDefaultValueDoesNothing() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    BasicFieldMetadata value = mock(BasicFieldMetadata.class);
    doNothing().when(value).setDefaultValue(Mockito.<String>any());
    when(value.getDefaultValue()).thenReturn(",");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    verify(value, atLeast(1)).getDefaultValue();
    verify(value).setDefaultValue(eq("."));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllFields(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   *   <li>Then return second element Name is {@code FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getAllFields(Class)}
   */
  @Test
  public void testGetAllFields_whenJavaLangBoolean_thenReturnSecondElementNameIsFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Boolean> targetClass = Boolean.class;

    // Act
    Field[] actualAllFields = dynamicEntityDaoImpl.getAllFields(targetClass);

    // Assert
    Field field = actualAllFields[1];
    assertEquals("FALSE", field.getName());
    Field field2 = actualAllFields[0];
    assertEquals("TRUE", field2.getName());
    Field field3 = actualAllFields[2];
    assertEquals("TYPE", field3.getName());
    assertEquals("java.lang.Class<java.lang.Boolean>", field3.getGenericType().getTypeName());
    Field field4 = actualAllFields[3];
    assertEquals("private final boolean java.lang.Boolean.value", field4.toGenericString());
    Field field5 = actualAllFields[4];
    assertEquals("private static final long java.lang.Boolean.serialVersionUID", field5.toGenericString());
    assertEquals("public static final java.lang.Boolean java.lang.Boolean.FALSE", field.toGenericString());
    assertEquals("public static final java.lang.Boolean java.lang.Boolean.TRUE", field2.toGenericString());
    assertEquals("public static final java.lang.Class<java.lang.Boolean> java.lang.Boolean.TYPE",
        field3.toGenericString());
    assertEquals("serialVersionUID", field5.getName());
    assertEquals("value", field4.getName());
    Annotation[] annotations = field2.getAnnotations();
    assertEquals(0, annotations.length);
    assertEquals(18, field4.getModifiers());
    assertEquals(25, field2.getModifiers());
    assertEquals(25, field.getModifiers());
    assertEquals(25, field3.getModifiers());
    assertEquals(26, field5.getModifiers());
    assertEquals(5, actualAllFields.length);
    assertFalse(field2.isAccessible());
    assertFalse(field.isAccessible());
    assertFalse(field3.isAccessible());
    assertFalse(field4.isAccessible());
    assertFalse(field5.isAccessible());
    assertFalse(field2.isEnumConstant());
    assertFalse(field.isEnumConstant());
    assertFalse(field3.isEnumConstant());
    assertFalse(field4.isEnumConstant());
    assertFalse(field5.isEnumConstant());
    assertFalse(field2.isSynthetic());
    assertFalse(field.isSynthetic());
    assertFalse(field3.isSynthetic());
    assertFalse(field4.isSynthetic());
    assertFalse(field5.isSynthetic());
    Class<Boolean> expectedDeclaringClass = Boolean.class;
    assertEquals(expectedDeclaringClass, field2.getDeclaringClass());
    Class<Class> expectedType = Class.class;
    assertEquals(expectedType, field3.getType());
    assertSame(annotations, field.getAnnotations());
    assertSame(annotations, field3.getAnnotations());
    assertSame(annotations, field4.getAnnotations());
    assertSame(annotations, field5.getAnnotations());
    assertSame(annotations, field2.getDeclaredAnnotations());
    assertSame(annotations, field.getDeclaredAnnotations());
    assertSame(annotations, field3.getDeclaredAnnotations());
    assertSame(annotations, field4.getDeclaredAnnotations());
    assertSame(annotations, field5.getDeclaredAnnotations());
    assertSame(targetClass, field.getDeclaringClass());
    assertSame(targetClass, field3.getDeclaringClass());
    assertSame(targetClass, field4.getDeclaringClass());
    assertSame(targetClass, field5.getDeclaringClass());
    assertSame(targetClass, field2.getGenericType());
    assertSame(targetClass, field.getGenericType());
    assertSame(targetClass, field2.getType());
    assertSame(targetClass, field.getType());
    assertSame(field4.getGenericType(), field4.getType());
    assertSame(field5.getGenericType(), field5.getType());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllFields(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getAllFields(Class)}
   */
  @Test
  public void testGetAllFields_whenJavaLangObject_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllFields(targetClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertyNames(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getPropertyNames(Class)}
   */
  @Test
  public void testGetPropertyNames_whenJavaLangObject_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.getPropertyNames(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertyTypes(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getPropertyTypes(Class)}
   */
  @Test
  public void testGetPropertyTypes_whenJavaLangObject_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.getPropertyTypes(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}
   */
  @Test
  public void testGetSuperClassHierarchy_whenNull_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new DynamicEntityDaoImpl()).getSuperClassHierarchy(null).length);
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)}
   */
  @Test
  public void testBuildProperties_givenJavaLangObject_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<String> propertyNames = new ArrayList<>();
    ArrayList<Type> propertyTypes = new ArrayList<>();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);

    // Act
    dynamicEntityDaoImpl.buildProperties(targetClass, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, MergedPropertyType.PRIMARY, presentationAttributes,
        componentProperties, fields, propertyNames, propertyTypes, "Id Property", true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", parentClasses, "Prefix", true, true,
        "Parent Prefix");

    // Assert
    assertEquals(1, parentClasses.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, parentClasses.get(0));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)}
   */
  @Test
  public void testBuildProperties_givenJavaLangObject_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<String> propertyNames = new ArrayList<>();
    ArrayList<Type> propertyTypes = new ArrayList<>();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);

    // Act
    dynamicEntityDaoImpl.buildProperties(targetClass, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, MergedPropertyType.PRIMARY, presentationAttributes,
        componentProperties, fields, propertyNames, propertyTypes, "Id Property", true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", parentClasses, "Prefix", true, true,
        "Parent Prefix");

    // Assert
    assertEquals(2, parentClasses.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, parentClasses.get(0));
    assertSame(forNameResult2, parentClasses.get(1));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  public void testTestPropertyInclusion() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    AdornedTargetCollectionMetadata presentationAttribute = mock(AdornedTargetCollectionMetadata.class);
    when(presentationAttribute.getExcluded()).thenReturn(true);
    when(presentationAttribute.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    Boolean actualTestPropertyInclusionResult = dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(presentationAttribute, atLeast(1)).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    assertFalse(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  public void testTestPropertyInclusion2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    AdornedTargetCollectionMetadata presentationAttribute = mock(AdornedTargetCollectionMetadata.class);
    when(presentationAttribute.getChildrenExcluded()).thenReturn(true);
    when(presentationAttribute.getExcluded()).thenReturn(false);
    when(presentationAttribute.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    Boolean actualTestPropertyInclusionResult = dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(presentationAttribute, atLeast(1)).getChildrenExcluded();
    verify(presentationAttribute, atLeast(1)).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    assertFalse(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  public void testTestPropertyInclusion3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    AdornedTargetCollectionMetadata presentationAttribute = mock(AdornedTargetCollectionMetadata.class);
    when(presentationAttribute.getChildrenExcluded()).thenReturn(false);
    when(presentationAttribute.getExcluded()).thenReturn(false);
    when(presentationAttribute.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    Boolean actualTestPropertyInclusionResult = dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(presentationAttribute, atLeast(1)).getChildrenExcluded();
    verify(presentationAttribute, atLeast(1)).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    assertTrue(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  public void testTestPropertyInclusion_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    AdornedTargetCollectionMetadata presentationAttribute = mock(AdornedTargetCollectionMetadata.class);
    when(presentationAttribute.getExcluded()).thenReturn(true);
    when(presentationAttribute.getShowIfProperty()).thenReturn("");

    // Act
    Boolean actualTestPropertyInclusionResult = dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(presentationAttribute, atLeast(1)).getExcluded();
    verify(presentationAttribute).getShowIfProperty();
    assertFalse(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  public void testTestPropertyInclusion_whenAdornedTargetCollectionMetadata_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.testPropertyInclusion(new AdornedTargetCollectionMetadata()));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  public void testTestPropertyInclusion_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new DynamicEntityDaoImpl()).testPropertyInclusion(null));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  public void testSetExcludedBasedOnShowIfProperty_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    AdornedTargetCollectionMetadata fieldMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(fieldMetadata.getShowIfProperty()).thenReturn("");

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert
    verify(fieldMetadata).getShowIfProperty();
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   * <ul>
   *   <li>Given {@code Show If Property}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  public void testSetExcludedBasedOnShowIfProperty_givenShowIfProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    AdornedTargetCollectionMetadata fieldMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(fieldMetadata.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert
    verify(fieldMetadata, atLeast(1)).getShowIfProperty();
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  public void testTestPropertyRecursion_givenJavaLangObject_whenArrayListAddObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyRecursion("Prefix", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", true, "Parent Prefix"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  public void testTestPropertyRecursion_givenJavaLangObject_whenArrayListAddObject2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyRecursion("Prefix", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", true, "Parent Prefix"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  public void testTestPropertyRecursion_whenEmptyString_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyRecursion("", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", true, "Parent Prefix"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  public void testTestPropertyRecursion_whenEmptyString_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyRecursion("", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", false, "Parent Prefix"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>When {@code Prefix}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  public void testTestPropertyRecursion_whenPrefix_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyRecursion("Prefix", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", true, "Parent Prefix"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String, String)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String, String)}
   */
  @Test
  public void testTestMultiLevelEmbeddableRecursion_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DynamicEntityDaoImpl()).testMultiLevelEmbeddableRecursion("Prefix", false, "Parent Prefix",
        "Property Name"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String, String)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String, String)}
   */
  @Test
  public void testTestMultiLevelEmbeddableRecursion_whenTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DynamicEntityDaoImpl()).testMultiLevelEmbeddableRecursion("Prefix", true, "Parent Prefix",
        "Property Name"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}
   */
  @Test
  public void testTestStandardPropertyRecursion_givenJavaLangObject_whenArrayListAddObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testStandardPropertyRecursion("Prefix", parentClasses, "Property Name",
        targetClass, "Dr Jane Doe", true));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}
   */
  @Test
  public void testTestStandardPropertyRecursion_givenJavaLangObject_whenArrayListAddObject2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testStandardPropertyRecursion("Prefix", parentClasses, "Property Name",
        targetClass, "Dr Jane Doe", true));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}
   */
  @Test
  public void testTestStandardPropertyRecursion_whenEmptyString_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testStandardPropertyRecursion("", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", true));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}.
   * <ul>
   *   <li>When {@code Prefix}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}
   */
  @Test
  public void testTestStandardPropertyRecursion_whenPrefix_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testStandardPropertyRecursion("Prefix", parentClasses, "Property Name",
        targetClass, "Dr Jane Doe", true));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class, Field)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class, Field)}
   */
  @Test
  public void testDetermineExclusionForField_givenJavaLangObject_whenArrayListAddObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.determineExclusionForField(parentClasses, targetClass, null));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class, Field)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class, Field)}
   */
  @Test
  public void testDetermineExclusionForField_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.determineExclusionForField(parentClasses, targetClass, null));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}.
   * <ul>
   *   <li>Given {@code Many To Field}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}
   */
  @Test
  public void testTestForeignProperty_givenManyToField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    // Act
    boolean actualTestForeignPropertyResult = dynamicEntityDaoImpl.testForeignProperty(foreignField, "Prefix",
        "Property Name");

    // Assert
    verify(foreignField).getManyToField();
    assertFalse(actualTestForeignPropertyResult);
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}
   */
  @Test
  public void testTestForeignProperty_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.testForeignProperty(new ForeignKey("PrefixProperty Name", "PrefixProperty Name"),
        "Prefix", "Property Name"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}
   */
  @Test
  public void testTestForeignProperty_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DynamicEntityDaoImpl()).testForeignProperty(null, "Prefix", "Property Name"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}
   */
  @Test
  public void testFindAdditionalForeignKeyIndex() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act and Assert
    assertEquals(-1, dynamicEntityDaoImpl
        .findAdditionalForeignKeyIndex(new ForeignKey[]{new ForeignKey("name", "name")}, "Prefix", "Property Name"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   * <ul>
   *   <li>Given {@code Many To Field}.</li>
   *   <li>Then return minus two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}
   */
  @Test
  public void testFindAdditionalForeignKeyIndex_givenManyToField_thenReturnMinusTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");

    // Act
    int actualFindAdditionalForeignKeyIndexResult = dynamicEntityDaoImpl
        .findAdditionalForeignKeyIndex(new ForeignKey[]{foreignKey}, "Prefix", "Property Name");

    // Assert
    verify(foreignKey).getManyToField();
    assertEquals(-2, actualFindAdditionalForeignKeyIndexResult);
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   * <ul>
   *   <li>When empty array of {@link ForeignKey}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}
   */
  @Test
  public void testFindAdditionalForeignKeyIndex_whenEmptyArrayOfForeignKey_thenReturnMinusOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(-1,
        (new DynamicEntityDaoImpl()).findAdditionalForeignKeyIndex(new ForeignKey[]{}, "Prefix", "Property Name"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}
   */
  @Test
  public void testFindAdditionalForeignKeyIndex_whenNull_thenReturnMinusOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(-1, (new DynamicEntityDaoImpl()).findAdditionalForeignKeyIndex(null, "Prefix", "Property Name"));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}.
   * <ul>
   *   <li>Then calls
   * {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}
   */
  @Test
  public void testBuildEntityProperties_thenCallsOverrideMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(new HashMap<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(fields, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", "Property Name", returnedClass, targetClass,
        new ArrayList<>(), "Prefix", true, "Parent Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("PrefixProperty Name."),
        eq(true), eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then calls
   * {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}
   */
  @Test
  public void testBuildEntityProperties_whenEmptyArrayOfString_thenCallsOverrideMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
                .thenReturn(new HashMap<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(fields, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, true, new String[]{}, new String[]{"Exclude Fields"},
        "Configuration Key", "Dr Jane Doe", "Property Name", returnedClass, targetClass, new ArrayList<>(), "Prefix",
        true, "Parent Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("PrefixProperty Name."),
        eq(true), eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}
   */
  @Test
  public void testIsForeignKey() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    BasicCollectionMetadata fieldMetadata = mock(BasicCollectionMetadata.class);
    when(fieldMetadata.getPersistencePerspective()).thenReturn(persistencePerspective);

    // Act
    boolean actualIsForeignKeyResult = dynamicEntityDaoImpl.isForeignKey(fieldMetadata);

    // Assert
    verify(fieldMetadata, atLeast(1)).getPersistencePerspective();
    assertFalse(actualIsForeignKeyResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}
   * {@link PersistencePerspectiveItemType#FOREIGNKEY} is
   * {@link AdornedTargetList#AdornedTargetList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}
   */
  @Test
  public void testIsForeignKey_givenHashMapForeignkeyIsAdornedTargetList_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    BasicCollectionMetadata fieldMetadata = new BasicCollectionMetadata();
    fieldMetadata.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.isForeignKey(fieldMetadata));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}
   */
  @Test
  public void testIsForeignKey_givenPersistencePerspective() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    BasicCollectionMetadata fieldMetadata = mock(BasicCollectionMetadata.class);
    when(fieldMetadata.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    // Act
    boolean actualIsForeignKeyResult = dynamicEntityDaoImpl.isForeignKey(fieldMetadata);

    // Assert
    verify(fieldMetadata).getPersistencePerspective();
    assertFalse(actualIsForeignKeyResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}.
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}
   */
  @Test
  public void testIsForeignKey_whenAdornedTargetCollectionMetadata_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.isForeignKey(new AdornedTargetCollectionMetadata()));
  }

  /**
   * Test
   * {@link DynamicEntityDaoImpl#setOriginatingFieldForForeignKey(String, String, FieldMetadata)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#setOriginatingFieldForForeignKey(String, String, FieldMetadata)}
   */
  @Test
  public void testSetOriginatingFieldForForeignKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new ForeignKey());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    BasicCollectionMetadata fieldMetadata = new BasicCollectionMetadata();
    fieldMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    dynamicEntityDaoImpl.setOriginatingFieldForForeignKey("Property Name", "Key", fieldMetadata);

    // Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems2 = fieldMetadata
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems2.size());
    PersistencePerspectiveItem getResult = persistencePerspectiveItems2.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult instanceof ForeignKey);
    assertEquals("Property Name.Key", ((ForeignKey) getResult).getOriginatingField());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getFieldManager()}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getFieldManager()}
   */
  @Test
  public void testGetFieldManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act
    FieldManager actualFieldManager = dynamicEntityDaoImpl.getFieldManager();

    // Assert
    assertNull(actualFieldManager.getEntityConfiguration());
    assertSame(dynamicEntityDaoImpl.fieldManager, actualFieldManager);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getFieldManager(boolean)} with
   * {@code boolean}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getFieldManager(boolean)}
   */
  @Test
  public void testGetFieldManagerWithBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act
    FieldManager actualFieldManager = dynamicEntityDaoImpl.getFieldManager(true);

    // Assert
    assertNull(actualFieldManager.getEntityConfiguration());
    assertNull(dynamicEntityDaoImpl.fieldManager.getEntityConfiguration());
    FieldManager fieldManager = dynamicEntityDaoImpl.fieldManager;
    assertSame(fieldManager, dynamicEntityDaoImpl.getFieldManager());
    assertSame(fieldManager, actualFieldManager);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicEntityDaoImpl#setApplicationContext(ApplicationContext)}
   *   <li>
   * {@link DynamicEntityDaoImpl#setDefaultFieldMetadataProvider(FieldMetadataProvider)}
   *   <li>{@link DynamicEntityDaoImpl#setDynamicDaoHelper(DynamicDaoHelper)}
   *   <li>{@link DynamicEntityDaoImpl#setEntityConfiguration(EntityConfiguration)}
   *   <li>{@link DynamicEntityDaoImpl#setFieldMetadataProviders(List)}
   *   <li>{@link DynamicEntityDaoImpl#setMetadata(Metadata)}
   *   <li>{@link DynamicEntityDaoImpl#getDefaultFieldMetadataProvider()}
   *   <li>{@link DynamicEntityDaoImpl#getDynamicDaoHelper()}
   *   <li>{@link DynamicEntityDaoImpl#getEntityConfiguration()}
   *   <li>{@link DynamicEntityDaoImpl#getFieldMetadataProviders()}
   *   <li>{@link DynamicEntityDaoImpl#getMetadata()}
   *   <li>{@link DynamicEntityDaoImpl#getStandardEntityManager()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act
    dynamicEntityDaoImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    AdornedTargetCollectionFieldMetadataProvider defaultFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    dynamicEntityDaoImpl.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);
    DynamicDaoHelperImpl dynamicDaoHelper = new DynamicDaoHelperImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    dynamicEntityDaoImpl.setEntityConfiguration(entityConfiguration);
    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    dynamicEntityDaoImpl.setFieldMetadataProviders(fieldMetadataProviders);
    Metadata metadata = new Metadata();
    dynamicEntityDaoImpl.setMetadata(metadata);
    FieldMetadataProvider actualDefaultFieldMetadataProvider = dynamicEntityDaoImpl.getDefaultFieldMetadataProvider();
    DynamicDaoHelper actualDynamicDaoHelper = dynamicEntityDaoImpl.getDynamicDaoHelper();
    EntityConfiguration actualEntityConfiguration = dynamicEntityDaoImpl.getEntityConfiguration();
    List<FieldMetadataProvider> actualFieldMetadataProviders = dynamicEntityDaoImpl.getFieldMetadataProviders();
    Metadata actualMetadata = dynamicEntityDaoImpl.getMetadata();
    dynamicEntityDaoImpl.getStandardEntityManager();

    // Assert that nothing has changed
    assertTrue(actualDynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertTrue(actualDefaultFieldMetadataProvider instanceof AdornedTargetCollectionFieldMetadataProvider);
    assertTrue(actualFieldMetadataProviders.isEmpty());
    assertSame(fieldMetadataProviders, actualFieldMetadataProviders);
    assertSame(entityConfiguration, actualEntityConfiguration);
    assertSame(dynamicDaoHelper, actualDynamicDaoHelper);
    assertSame(metadata, actualMetadata);
    assertSame(defaultFieldMetadataProvider, actualDefaultFieldMetadataProvider);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isExcludeClassFromPolymorphism(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicEntityDaoImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  public void testIsExcludeClassFromPolymorphism_whenJavaLangObject_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.isExcludeClassFromPolymorphism(clazz));
  }
}
