/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelper;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.FieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromFieldTypeRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.Type;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DynamicEntityDaoImplDiffblueTest {
  @InjectMocks
  private DynamicEntityDaoImpl dynamicEntityDaoImpl;

  @Mock
  private FieldMetadataProvider fieldMetadataProvider;

  @Mock
  private Metadata metadata;

  @Mock
  private EntityConfiguration entityConfiguration;

  @Mock
  private Map<String, String> map;

  /**
   * Test {@link DynamicEntityDaoImpl#getPersistentClass(String)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getPersistentClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.hibernate.mapping.PersistentClass DynamicEntityDaoImpl.getPersistentClass(String)"})
  public void testGetPersistentClass() {
    // Arrange, Act and Assert
    assertNull(dynamicEntityDaoImpl.getPersistentClass("Target Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#useCache()}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#useCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.useCache()"})
  public void testUseCache() {
    // Arrange, Act and Assert
    assertFalse(dynamicEntityDaoImpl.useCache());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)} with {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean)"})
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)} with {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean)"})
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities2() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, false).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)} with {@code ceilingClass}.
   * <ul>
   *   <li>When {@code Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class)"})
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClass_whenJavaLangBoolean() {
    // Arrange
    Class<Boolean> ceilingClass = Boolean.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)} with {@code ceilingClass}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class)"})
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClass_whenJavaLangObject() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getUpDownInheritance(Class)"})
  public void testGetUpDownInheritance_whenJavaLangObject_thenReturnArrayLengthIsZero() {
    // Arrange
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getUpDownInheritance(testClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>Given {@code blEntityConfiguration} {@link EntityConfiguration#lookupEntityClass(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_givenBlEntityConfigurationLookupEntityClassReturnNull() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_givenJavaLangObject_whenClassName_thenReturnObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any())).thenReturn(forNameResult);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass(eq("Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   * <ul>
   *   <li>When {@code Boolean}.</li>
   *   <li>Then return {@link Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_whenJavaLangBoolean_thenReturnBoolean() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass_whenClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.getCeilingImplClass("Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}.
   * <ul>
   *   <li>When {@code Boolean}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass_whenJavaLangBoolean_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> dynamicEntityDaoImpl.getCeilingImplClass("java.lang.Boolean"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getIdentifier(Object)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getIdentifier(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.Serializable DynamicEntityDaoImpl.getIdentifier(Object)"})
  public void testGetIdentifier() {
    // Arrange, Act and Assert
    assertNull(dynamicEntityDaoImpl.getIdentifier("Entity"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getIdField(Class)}.
   * <ul>
   *   <li>Given {@link DynamicDaoHelperImpl} {@link DynamicDaoHelperImpl#getIdField(Class)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getIdField(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field DynamicEntityDaoImpl.getIdField(Class)"})
  public void testGetIdField_givenDynamicDaoHelperImplGetIdFieldReturnNull_thenReturnNull() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.getIdField(Mockito.<Class<Object>>any())).thenReturn(null);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> clazz = Object.class;

    // Act
    Field actualIdField = dynamicEntityDaoImpl.getIdField(clazz);

    // Assert
    verify(dynamicDaoHelper).getIdField(isA(Class.class));
    assertNull(actualIdField);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#sortEntities(Class, List)}.
   * <ul>
   *   <li>Given {@code Boolean}.</li>
   *   <li>Then return first element is {@link Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.sortEntities(Class, List)"})
  public void testSortEntities_givenJavaLangBoolean_thenReturnFirstElementIsBoolean() {
    // Arrange
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
   *   <li>Given {@code Object}.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.sortEntities(Class, List)"})
  public void testSortEntities_givenJavaLangObject_thenReturnArrayLengthIsOne() {
    // Arrange
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
   *   <li>Given {@code Object}.</li>
   *   <li>Then return array length is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.sortEntities(Class, List)"})
  public void testSortEntities_givenJavaLangObject_thenReturnArrayLengthIsTwo() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.sortEntities(Class, List)"})
  public void testSortEntities_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
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
   * Method under test: {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.addClassToTree(Class, ClassTree)"})
  public void testAddClassToTree_givenDrJaneDoe_thenCallsGetFullyQualifiedClassname() {
    // Arrange
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
   *   <li>When {@link ClassTree#ClassTree(String)} with fullyQualifiedClassname is {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.addClassToTree(Class, ClassTree)"})
  public void testAddClassToTree_whenClassTreeWithFullyQualifiedClassnameIsDrJaneDoe() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> dynamicEntityDaoImpl.addClassToTree(clazz, new ClassTree("Dr Jane Doe")));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTree(Class[])}.
   * <ul>
   *   <li>Then return CollapsedClassTrees size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getClassTree(Class[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTree(Class[])"})
  public void testGetClassTree_thenReturnCollapsedClassTreesSizeIsOne() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    ClassTree actualClassTree = dynamicEntityDaoImpl.getClassTree(new Class[]{forNameResult});

    // Assert
    assertEquals(0, actualClassTree.getChildren().length);
    List<ClassTree> collapsedClassTrees = actualClassTree.getCollapsedClassTrees();
    assertEquals(1, collapsedClassTrees.size());
    assertEquals(2, actualClassTree.getRight());
    assertFalse(actualClassTree.hasChildren());
    assertSame(actualClassTree, collapsedClassTrees.get(0));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTree(Class[])"})
  public void testGetClassTree_whenEmptyArrayOfClass_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(dynamicEntityDaoImpl.getClassTree(new Class[]{}));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTree(Class[])}.
   * <ul>
   *   <li>When {@code Boolean}.</li>
   *   <li>Then return first element FriendlyName is {@code Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getClassTree(Class[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTree(Class[])"})
  public void testGetClassTree_whenJavaLangBoolean_thenReturnFirstElementFriendlyNameIsBoolean() {
    // Arrange
    Class<Boolean> forNameResult = Boolean.class;
    Class<Object> forNameResult2 = Object.class;

    // Act
    ClassTree actualClassTree = dynamicEntityDaoImpl.getClassTree(new Class[]{forNameResult, forNameResult2});

    // Assert
    ClassTree[] children = actualClassTree.getChildren();
    ClassTree classTree = children[0];
    assertEquals("Boolean", classTree.getFriendlyName());
    assertEquals("Boolean", classTree.getName());
    assertEquals("java.lang.Boolean", classTree.getFullyQualifiedClassname());
    assertEquals(0, classTree.getChildren().length);
    assertEquals(1, classTree.getCollapsedClassTrees().size());
    assertEquals(1, children.length);
    List<ClassTree> collapsedClassTrees = actualClassTree.getCollapsedClassTrees();
    assertEquals(2, collapsedClassTrees.size());
    assertEquals(2, classTree.getLeft());
    assertEquals(3, classTree.getRight());
    assertEquals(4, actualClassTree.getRight());
    assertFalse(classTree.hasChildren());
    assertFalse(classTree.isExcludeFromPolymorphism());
    assertTrue(actualClassTree.hasChildren());
    assertSame(actualClassTree, collapsedClassTrees.get(0));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTreeFromCeiling(Class)"})
  public void testGetClassTreeFromCeiling_whenJavaLangObject_thenReturnNull() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertNull(dynamicEntityDaoImpl.getClassTreeFromCeiling(ceilingClass));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadata#getExcluded()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"})
  public void testGetSimpleMergedProperties_thenCallsGetExcluded() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(metadata.getFieldMetadataForTargetClass(Mockito.<Class<Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<DynamicEntityDao>any(), Mockito.<String>any())).thenReturn(stringFieldMetadataMap);

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties = dynamicEntityDaoImpl
        .getSimpleMergedProperties("java.lang.Boolean", new PersistencePerspective());

    // Assert
    verify(adornedTargetCollectionMetadata).getExcluded();
    verify(metadata).getFieldMetadataForTargetClass(isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
    assertTrue(actualSimpleMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"})
  public void testGetSimpleMergedProperties_thenReturnEmpty() {
    // Arrange
    when(metadata.getFieldMetadataForTargetClass(Mockito.<Class<Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<DynamicEntityDao>any(), Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties = dynamicEntityDaoImpl
        .getSimpleMergedProperties("java.lang.Boolean", new PersistencePerspective());

    // Assert
    verify(metadata).getFieldMetadataForTargetClass(isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
    assertTrue(actualSimpleMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"})
  public void testGetSimpleMergedProperties_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(metadata.getFieldMetadataForTargetClass(Mockito.<Class<Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<DynamicEntityDao>any(), Mockito.<String>any())).thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.getSimpleMergedProperties("java.lang.Boolean", new PersistencePerspective()));
    verify(metadata).getFieldMetadataForTargetClass(isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   * <ul>
   *   <li>When {@code Entity Name}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"})
  public void testGetSimpleMergedProperties_whenEntityName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> dynamicEntityDaoImpl.getSimpleMergedProperties("Entity Name", new PersistencePerspective()));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   * <ul>
   *   <li>When {@code Byte}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"})
  public void testGetSimpleMergedProperties_whenJavaLangByte_thenReturnEmpty() {
    // Arrange
    when(metadata.getFieldMetadataForTargetClass(Mockito.<Class<Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<DynamicEntityDao>any(), Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties = dynamicEntityDaoImpl
        .getSimpleMergedProperties("java.lang.Byte", new PersistencePerspective());

    // Assert
    verify(metadata).getFieldMetadataForTargetClass(isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
    assertTrue(actualSimpleMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code excludeFields}, {@code configurationKey}, {@code prefix}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"})
  public void testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
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
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code excludeFields}, {@code configurationKey}, {@code prefix}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"})
  public void testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix2() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
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
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code excludeFields}, {@code configurationKey}, {@code prefix}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"})
  public void testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix3() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.getMergedProperties("Dr Jane Doe", new Class[]{forNameResult}, foreignField,
            new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()},
            MergedPropertyType.PRIMARY, true, new String[]{"Include Fields"}, new String[]{"Exclude Fields"},
            "Configuration Key", "Prefix"));
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("Prefix"), eq(false),
        eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
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
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   * <ul>
   *   <li>Then {@code foo} return {@link AdornedTargetCollectionMetadata}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_thenFooReturnAdornedTargetCollectionMetadata() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Object"), isNull(), isA(DynamicEntityDao.class));
    assertEquals(1, actualMergedProperties.size());
    FieldMetadata getResult = actualMergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertSame(adornedTargetCollectionMetadata, getResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   * <ul>
   *   <li>Then return containsKey {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_thenReturnContainsKeyFoo() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
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
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_thenReturnEmpty() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Object"), isNull(), isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class, () -> dynamicEntityDaoImpl.getMergedProperties(cls));
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Object"), isNull(), isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   * <ul>
   *   <li>When {@code Boolean}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_whenJavaLangBoolean_thenReturnEmpty() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Boolean> cls = Boolean.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties = dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq(""), eq(false),
        eq("java.lang.Boolean"), isNull(), isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"})
  public void testGetMergedPropertiesRecursively_givenJavaLangObject_whenArrayListAddObject() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively = dynamicEntityDaoImpl.getMergedPropertiesRecursively(
        "Dr Jane Doe", new Class[]{forNameResult}, foreignField, new String[]{"Additional Non Persistent Properties"},
        new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", parentClasses, "Prefix", true, "Parent Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("Prefix"), eq(true),
        eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
    assertTrue(actualMergedPropertiesRecursively.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"})
  public void testGetMergedPropertiesRecursively_givenJavaLangObject_whenArrayListAddObject2() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);
    Class<Object> forNameResult3 = Object.class;
    parentClasses.add(forNameResult3);

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively = dynamicEntityDaoImpl.getMergedPropertiesRecursively(
        "Dr Jane Doe", new Class[]{forNameResult}, foreignField, new String[]{"Additional Non Persistent Properties"},
        new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", parentClasses, "Prefix", true, "Parent Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("Prefix"), eq(true),
        eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
    assertTrue(actualMergedPropertiesRecursively.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"})
  public void testGetMergedPropertiesRecursively_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.getMergedPropertiesRecursively("Dr Jane Doe", new Class[]{forNameResult},
            foreignField, new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()},
            MergedPropertyType.PRIMARY, true, new String[]{"Include Fields"}, new String[]{"Exclude Fields"},
            "Configuration Key", new ArrayList<>(), "Prefix", true, "Parent Prefix"));
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("Prefix"), eq(true),
        eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"})
  public void testGetMergedPropertiesRecursively_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
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
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"})
  public void testGetMergedPropertiesRecursively_whenEmptyArrayOfString_thenReturnEmpty() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
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
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"})
  public void testApplyForeignKeyPrecedence() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField,
        new ForeignKey[]{new ForeignKey("Many To Field", "Foreign Key Class")}, mergedProperties);

    // Assert that nothing has changed
    verify(foreignField).getManyToField();
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   * <ul>
   *   <li>Given {@code Many To Field}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"})
  public void testApplyForeignKeyPrecedence_givenManyToField_whenNull_thenHashMapSizeIsOne() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField, null, mergedProperties);

    // Assert that nothing has changed
    verify(foreignField).getManyToField();
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   * <ul>
   *   <li>Then not {@link HashMap#HashMap()} {@code foo} Excluded.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"})
  public void testApplyForeignKeyPrecedence_thenNotHashMapFooExcluded() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("foo");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField, new ForeignKey[]{foreignKey}, mergedProperties);

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertFalse(getResult.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   * <ul>
   *   <li>When array of {@link ForeignKey} with {@link ForeignKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"})
  public void testApplyForeignKeyPrecedence_whenArrayOfForeignKeyWithForeignKey() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField, new ForeignKey[]{foreignKey}, mergedProperties);

    // Assert that nothing has changed
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadata#setExcluded(Boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"})
  public void testApplyIncludesAndExcludes_thenCallsSetExcluded() {
    // Arrange
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
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code foo} Excluded.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"})
  public void testApplyIncludesAndExcludes_thenHashMapFooExcluded() {
    // Arrange
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
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}.
   * <ul>
   *   <li>When array of {@link String} with {@code Prefixfoo}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"})
  public void testApplyIncludesAndExcludes_whenArrayOfStringWithPrefixfoo_thenHashMapSizeIsOne() {
    // Arrange
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(new String[]{"Prefixfoo"}, new String[]{"Exclude Fields"}, "Prefix",
        true, mergedProperties);

    // Assert that nothing has changed
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DynamicEntityDaoImpl.pad(String, int, char)"})
  public void testPad_whenEmptyString_thenReturnAaa() {
    // Arrange, Act and Assert
    assertEquals("AAA", dynamicEntityDaoImpl.pad("", 3, 'A'));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DynamicEntityDaoImpl.pad(String, int, char)"})
  public void testPad_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", dynamicEntityDaoImpl.pad("foo", 3, 'A'));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}.
   * <ul>
   *   <li>Then return {@code cfdfd72e475f900ae49ce08efe7d93fb}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DynamicEntityDaoImpl.getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)"})
  public void testGetCacheKey_thenReturnCfdfd72e475f900ae49ce08efe7d93fb() {
    // Arrange
    ForeignKey foreignField = new ForeignKey();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("cfdfd72e475f900ae49ce08efe7d93fb",
        dynamicEntityDaoImpl.getCacheKey("Dr Jane Doe", foreignField,
            new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()},
            MergedPropertyType.PRIMARY, true, clazz, "Configuration Key", true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code 83d7638ab51bce26f4ff6b4a29ddf077}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DynamicEntityDaoImpl.getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)"})
  public void testGetCacheKey_whenNull_thenReturn83d7638ab51bce26f4ff6b4a29ddf077() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("83d7638ab51bce26f4ff6b4a29ddf077", dynamicEntityDaoImpl.getCacheKey("Dr Jane Doe", null, null, null,
        MergedPropertyType.PRIMARY, true, clazz, "Configuration Key", true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}.
   * <ul>
   *   <li>When {@code , originatingField='}.</li>
   *   <li>Then return {@code 0cf062a6e41767af4e8c19ab846b1965}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DynamicEntityDaoImpl.getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)"})
  public void testGetCacheKey_whenOriginatingField_thenReturn0cf062a6e41767af4e8c19ab846b1965() {
    // Arrange
    ForeignKey foreignField = new ForeignKey();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("0cf062a6e41767af4e8c19ab846b1965",
        dynamicEntityDaoImpl.getCacheKey(", originatingField='", foreignField,
            new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()},
            MergedPropertyType.PRIMARY, true, clazz, "Configuration Key", true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_given42() {
    // Arrange
    BasicFieldMetadata value = mock(BasicFieldMetadata.class);
    when(value.getDefaultValue()).thenReturn("42");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    verify(value, atLeast(1)).getDefaultValue();
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_givenDot_whenBasicFieldMetadataDefaultValueIsDot() {
    // Arrange
    BasicFieldMetadata value = new BasicFieldMetadata();
    value.setDefaultValue(".");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert that nothing has changed
    assertEquals(".", value.getDefaultValue());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_givenEmptyString() {
    // Arrange
    BasicFieldMetadata value = mock(BasicFieldMetadata.class);
    when(value.getDefaultValue()).thenReturn("");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    verify(value, atLeast(1)).getDefaultValue();
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Then {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_thenBasicFieldMetadataDefaultValueIsNull() {
    // Arrange
    BasicFieldMetadata value = new BasicFieldMetadata();

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert that nothing has changed
    assertNull(value.getDefaultValue());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
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
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_whenBasicFieldMetadataDefaultValueIsComma() {
    // Arrange
    BasicFieldMetadata value = new BasicFieldMetadata();
    value.setDefaultValue(",");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    assertEquals(".", value.getDefaultValue());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#setDefaultValue(String)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_whenBasicFieldMetadataSetDefaultValueDoesNothing() {
    // Arrange
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
   *   <li>When {@code Boolean}.</li>
   *   <li>Then return second element Name is {@code FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getAllFields(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field[] DynamicEntityDaoImpl.getAllFields(Class)"})
  public void testGetAllFields_whenJavaLangBoolean_thenReturnSecondElementNameIsFalse() {
    // Arrange
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
   *   <li>When {@code Object}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getAllFields(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field[] DynamicEntityDaoImpl.getAllFields(Class)"})
  public void testGetAllFields_whenJavaLangObject_thenReturnArrayLengthIsZero() {
    // Arrange
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllFields(targetClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getIdMetadata(Class)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getIdMetadata(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getIdMetadata(Class)"})
  public void testGetIdMetadata_thenReturnEmpty() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.getIdMetadata(Mockito.<Class<Object>>any(), Mockito.<EntityManager>any()))
        .thenReturn(new HashMap<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> entityClass = Object.class;

    // Act
    Map<String, Object> actualIdMetadata = dynamicEntityDaoImpl.getIdMetadata(entityClass);

    // Assert
    verify(dynamicDaoHelper).getIdMetadata(isA(Class.class), isNull());
    assertTrue(actualIdMetadata.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertyNames(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getPropertyNames(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DynamicEntityDaoImpl.getPropertyNames(Class)"})
  public void testGetPropertyNames_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.getPropertyNames(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertyTypes(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getPropertyTypes(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DynamicEntityDaoImpl.getPropertyTypes(Class)"})
  public void testGetPropertyTypes_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.getPropertyTypes(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getTabAndGroupMetadata(Class[], ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getTabAndGroupMetadata(Class[], ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getTabAndGroupMetadata(Class[], ClassMetadata)"})
  public void testGetTabAndGroupMetadata_thenThrowFactoryBeanNotInitializedException() {
    // Arrange
    when(metadata.getBaseTabAndGroupMetadata(Mockito.<Class<Object>[]>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(
        new org.broadleafcommerce.openadmin.dto.Property[]{new org.broadleafcommerce.openadmin.dto.Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class,
        () -> dynamicEntityDaoImpl.getTabAndGroupMetadata(new Class[]{null}, cmd));
    verify(metadata).getBaseTabAndGroupMetadata(isA(Class[].class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getTabAndGroupMetadata(Class[], ClassMetadata)}.
   * <ul>
   *   <li>When array of {@link Class} with {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getTabAndGroupMetadata(Class[], ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getTabAndGroupMetadata(Class[], ClassMetadata)"})
  public void testGetTabAndGroupMetadata_whenArrayOfClassWithNull_thenReturnEmpty() {
    // Arrange
    when(metadata.getBaseTabAndGroupMetadata(Mockito.<Class<Object>[]>any())).thenReturn(new HashMap<>());
    doNothing().when(metadata)
        .applyTabAndGroupMetadataOverrides(Mockito.<Class<Object>[]>any(), Mockito.<Map<String, TabMetadata>>any());
    doNothing().when(metadata)
        .buildAdditionalTabAndGroupMetadataFromCmdProperties(Mockito.<ClassMetadata>any(),
            Mockito.<Map<String, TabMetadata>>any());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(
        new org.broadleafcommerce.openadmin.dto.Property[]{new org.broadleafcommerce.openadmin.dto.Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, TabMetadata> actualTabAndGroupMetadata = dynamicEntityDaoImpl.getTabAndGroupMetadata(new Class[]{null},
        cmd);

    // Assert
    verify(metadata).applyTabAndGroupMetadataOverrides(isA(Class[].class), isA(Map.class));
    verify(metadata).buildAdditionalTabAndGroupMetadataFromCmdProperties(isA(ClassMetadata.class), isA(Map.class));
    verify(metadata).getBaseTabAndGroupMetadata(isA(Class[].class));
    assertTrue(actualTabAndGroupMetadata.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}.
   * <ul>
   *   <li>When {@code Boolean}.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getSuperClassHierarchy(Class)"})
  public void testGetSuperClassHierarchy_whenJavaLangBoolean_thenReturnArrayLengthIsOne() {
    // Arrange
    Class<Boolean> ceilingEntity = Boolean.class;

    // Act
    Class<?>[] actualSuperClassHierarchy = dynamicEntityDaoImpl.getSuperClassHierarchy(ceilingEntity);

    // Assert
    assertEquals(1, actualSuperClassHierarchy.length);
    Class<Boolean> expectedResultClass = Boolean.class;
    assertEquals(expectedResultClass, actualSuperClassHierarchy[0]);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}.
   * <ul>
   *   <li>When {@code Byte}.</li>
   *   <li>Then return array length is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getSuperClassHierarchy(Class)"})
  public void testGetSuperClassHierarchy_whenJavaLangByte_thenReturnArrayLengthIsTwo() {
    // Arrange
    Class<Byte> ceilingEntity = Byte.class;

    // Act
    Class<?>[] actualSuperClassHierarchy = dynamicEntityDaoImpl.getSuperClassHierarchy(ceilingEntity);

    // Assert
    assertEquals(2, actualSuperClassHierarchy.length);
    Class<Byte> expectedResultClass = Byte.class;
    assertEquals(expectedResultClass, actualSuperClassHierarchy[0]);
    Class<Number> expectedResultClass2 = Number.class;
    assertEquals(expectedResultClass2, actualSuperClassHierarchy[1]);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getSuperClassHierarchy(Class)"})
  public void testGetSuperClassHierarchy_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getSuperClassHierarchy(null).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertiesForEntityClass(Class, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, List, String, Boolean, String)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getPropertiesForEntityClass(Class, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DynamicEntityDaoImpl.getPropertiesForEntityClass(Class, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, List, String, Boolean, String)"})
  public void testGetPropertiesForEntityClass_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(metadata.getFieldMetadataForTargetClass(Mockito.<Class<Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<DynamicEntityDao>any(), Mockito.<String>any())).thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.getPropertiesForEntityClass(targetClass, foreignField,
            new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()},
            MergedPropertyType.PRIMARY, true, new String[]{"Include Fields"}, new String[]{"Exclude Fields"},
            "Configuration Key", "Dr Jane Doe", new ArrayList<>(), "Prefix", true, "Parent Prefix"));
    verify(metadata).getFieldMetadataForTargetClass(isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)"})
  public void testBuildProperties_givenJavaLangObject_thenArrayListSizeIsOne() {
    // Arrange
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
   * Test {@link DynamicEntityDaoImpl#buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildProperties(Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, List, List, String, Boolean, String[], String[], String, String, List, String, Boolean, Boolean, String)"})
  public void testBuildProperties_givenJavaLangObject_thenArrayListSizeIsTwo() {
    // Arrange
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
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");
    AdornedTargetCollectionMetadata presentationAttribute = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(presentationAttribute).setExcluded(Mockito.<Boolean>any());
    when(presentationAttribute.getExcluded()).thenReturn(true);
    when(presentationAttribute.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    Boolean actualTestPropertyInclusionResult = dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(presentationAttribute, atLeast(1)).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    verify(presentationAttribute).setExcluded(eq(true));
    assertFalse(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion2() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");
    AdornedTargetCollectionMetadata presentationAttribute = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(presentationAttribute).setExcluded(Mockito.<Boolean>any());
    when(presentationAttribute.getChildrenExcluded()).thenReturn(true);
    when(presentationAttribute.getExcluded()).thenReturn(false);
    when(presentationAttribute.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    Boolean actualTestPropertyInclusionResult = dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(presentationAttribute, atLeast(1)).getChildrenExcluded();
    verify(presentationAttribute, atLeast(1)).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    verify(presentationAttribute).setExcluded(eq(true));
    assertFalse(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion3() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");
    AdornedTargetCollectionMetadata presentationAttribute = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(presentationAttribute).setExcluded(Mockito.<Boolean>any());
    when(presentationAttribute.getChildrenExcluded()).thenReturn(false);
    when(presentationAttribute.getExcluded()).thenReturn(false);
    when(presentationAttribute.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    Boolean actualTestPropertyInclusionResult = dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(presentationAttribute, atLeast(1)).getChildrenExcluded();
    verify(presentationAttribute, atLeast(1)).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    verify(presentationAttribute).setExcluded(eq(true));
    assertTrue(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_givenEmptyString() {
    // Arrange
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
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_givenMapGetReturnNull() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);
    AdornedTargetCollectionMetadata presentationAttribute = mock(AdornedTargetCollectionMetadata.class);
    when(presentationAttribute.getExcluded()).thenReturn(true);
    when(presentationAttribute.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    Boolean actualTestPropertyInclusionResult = dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map).get(isA(Object.class));
    verify(presentationAttribute, atLeast(1)).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    assertFalse(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");
    AdornedTargetCollectionMetadata presentationAttribute = mock(AdornedTargetCollectionMetadata.class);
    doThrow(new NoSuchBeanDefinitionException("Name")).when(presentationAttribute).setExcluded(Mockito.<Boolean>any());
    when(presentationAttribute.getShowIfProperty()).thenReturn("Show If Property");

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute));
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    verify(presentationAttribute).setExcluded(eq(true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_whenAdornedTargetCollectionMetadata_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(dynamicEntityDaoImpl.testPropertyInclusion(new AdornedTargetCollectionMetadata()));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(dynamicEntityDaoImpl.testPropertyInclusion(null));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");
    AdornedTargetCollectionMetadata fieldMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(fieldMetadata).setExcluded(Mockito.<Boolean>any());
    when(fieldMetadata.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(fieldMetadata, atLeast(1)).getShowIfProperty();
    verify(fieldMetadata).setExcluded(eq(true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty_givenEmptyString() {
    // Arrange
    AdornedTargetCollectionMetadata fieldMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(fieldMetadata.getShowIfProperty()).thenReturn("");

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert
    verify(fieldMetadata).getShowIfProperty();
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.</li>
   *   <li>Then calls {@link Map#get(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty_givenMapGetReturnNull_thenCallsGet() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);
    AdornedTargetCollectionMetadata fieldMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(fieldMetadata.getShowIfProperty()).thenReturn("Show If Property");

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert
    verify(map).get(isA(Object.class));
    verify(fieldMetadata, atLeast(1)).getShowIfProperty();
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");
    AdornedTargetCollectionMetadata fieldMetadata = mock(AdornedTargetCollectionMetadata.class);
    doThrow(new NoSuchBeanDefinitionException("Name")).when(fieldMetadata).setExcluded(Mockito.<Boolean>any());
    when(fieldMetadata.getShowIfProperty()).thenReturn("Show If Property");

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata));
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(fieldMetadata, atLeast(1)).getShowIfProperty();
    verify(fieldMetadata).setExcluded(eq(true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Boolean DynamicEntityDaoImpl.testPropertyRecursion(String, List, String, Class, String, Boolean, String)"})
  public void testTestPropertyRecursion_givenJavaLangObject_whenArrayListAddObject() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyRecursion("Prefix", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", true, "Parent Prefix"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Boolean DynamicEntityDaoImpl.testPropertyRecursion(String, List, String, Class, String, Boolean, String)"})
  public void testTestPropertyRecursion_givenJavaLangObject_whenArrayListAddObject2() {
    // Arrange
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
   * Test {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Boolean DynamicEntityDaoImpl.testPropertyRecursion(String, List, String, Class, String, Boolean, String)"})
  public void testTestPropertyRecursion_whenEmptyString_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyRecursion("", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", true, "Parent Prefix"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Boolean DynamicEntityDaoImpl.testPropertyRecursion(String, List, String, Class, String, Boolean, String)"})
  public void testTestPropertyRecursion_whenEmptyString_thenReturnFalse2() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyRecursion("", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", false, "Parent Prefix"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}.
   * <ul>
   *   <li>When {@code Prefix}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Boolean DynamicEntityDaoImpl.testPropertyRecursion(String, List, String, Class, String, Boolean, String)"})
  public void testTestPropertyRecursion_whenPrefix_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyRecursion("Prefix", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", true, "Parent Prefix"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String, String)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testMultiLevelEmbeddableRecursion(String, Boolean, String, String)"})
  public void testTestMultiLevelEmbeddableRecursion_whenFalse() {
    // Arrange, Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testMultiLevelEmbeddableRecursion("Prefix", false, "Parent Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String, String)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testMultiLevelEmbeddableRecursion(String, Boolean, String, String)"})
  public void testTestMultiLevelEmbeddableRecursion_whenTrue() {
    // Arrange, Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testMultiLevelEmbeddableRecursion("Prefix", true, "Parent Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Boolean DynamicEntityDaoImpl.testStandardPropertyRecursion(String, List, String, Class, String, Boolean)"})
  public void testTestStandardPropertyRecursion_givenJavaLangObject_whenArrayListAddObject() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testStandardPropertyRecursion("Prefix", parentClasses, "Property Name",
        targetClass, "Dr Jane Doe", true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Boolean DynamicEntityDaoImpl.testStandardPropertyRecursion(String, List, String, Class, String, Boolean)"})
  public void testTestStandardPropertyRecursion_givenJavaLangObject_whenArrayListAddObject2() {
    // Arrange
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
   * Test {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Boolean DynamicEntityDaoImpl.testStandardPropertyRecursion(String, List, String, Class, String, Boolean)"})
  public void testTestStandardPropertyRecursion_whenEmptyString_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testStandardPropertyRecursion("", parentClasses, "Property Name", targetClass,
        "Dr Jane Doe", true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}.
   * <ul>
   *   <li>When {@code Prefix}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Boolean DynamicEntityDaoImpl.testStandardPropertyRecursion(String, List, String, Class, String, Boolean)"})
  public void testTestStandardPropertyRecursion_whenPrefix_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testStandardPropertyRecursion("Prefix", parentClasses, "Property Name",
        targetClass, "Dr Jane Doe", true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class, Field)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.determineExclusionForField(List, Class, Field)"})
  public void testDetermineExclusionForField_givenJavaLangObject_whenArrayListAddObject() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.determineExclusionForField(parentClasses, targetClass, null));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class, Field)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.determineExclusionForField(List, Class, Field)"})
  public void testDetermineExclusionForField_whenArrayList() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.determineExclusionForField(parentClasses, targetClass, null));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"})
  public void testBuildBasicProperty_whenArrayListAddObject_thenArrayListSizeIsOne() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromFieldType(Mockito.<AddMetadataFromFieldTypeRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);

    // Act
    dynamicEntityDaoImpl.buildBasicProperty(null, targetClass, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, MergedPropertyType.PRIMARY, presentationAttributes,
        componentProperties, fields, "Id Property", true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", parentClasses, "Prefix", true,
        "Property Name", new BigDecimalType(), true, 1, true, "Parent Prefix");

    // Assert
    verify(fieldMetadataProvider).addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
    assertEquals(1, parentClasses.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, parentClasses.get(0));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"})
  public void testBuildBasicProperty_whenArrayListAddObject_thenArrayListSizeIsTwo() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromFieldType(Mockito.<AddMetadataFromFieldTypeRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);

    // Act
    dynamicEntityDaoImpl.buildBasicProperty(null, targetClass, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, MergedPropertyType.PRIMARY, presentationAttributes,
        componentProperties, fields, "Id Property", true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", parentClasses, "Prefix", true,
        "Property Name", new BigDecimalType(), true, 1, true, "Parent Prefix");

    // Assert
    verify(fieldMetadataProvider).addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
    assertEquals(2, parentClasses.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, parentClasses.get(0));
    assertSame(forNameResult2, parentClasses.get(1));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   * <ul>
   *   <li>When {@link BigDecimalType} (default constructor).</li>
   *   <li>Then calls {@link FieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"})
  public void testBuildBasicProperty_whenBigDecimalType_thenCallsAddMetadataFromFieldType() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromFieldType(Mockito.<AddMetadataFromFieldTypeRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();

    // Act
    dynamicEntityDaoImpl.buildBasicProperty(null, targetClass, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, MergedPropertyType.PRIMARY, presentationAttributes,
        componentProperties, fields, "Id Property", true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", parentClasses, null, true, "Property Name",
        new BigDecimalType(), true, 1, true, "Parent Prefix");

    // Assert
    verify(fieldMetadataProvider).addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then calls {@link FieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"})
  public void testBuildBasicProperty_whenEmptyString_thenCallsAddMetadataFromFieldType() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromFieldType(Mockito.<AddMetadataFromFieldTypeRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();

    // Act
    dynamicEntityDaoImpl.buildBasicProperty(null, targetClass, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, MergedPropertyType.PRIMARY, presentationAttributes,
        componentProperties, fields, "Id Property", true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", parentClasses, "", true, "Property Name",
        new BigDecimalType(), true, 1, true, "Parent Prefix");

    // Assert
    verify(fieldMetadataProvider).addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link FieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"})
  public void testBuildBasicProperty_whenFalse_thenCallsAddMetadataFromFieldType() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromFieldType(Mockito.<AddMetadataFromFieldTypeRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();

    // Act
    dynamicEntityDaoImpl.buildBasicProperty(null, targetClass, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, MergedPropertyType.PRIMARY, presentationAttributes,
        componentProperties, fields, "Id Property", true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", parentClasses, "Prefix", false,
        "Property Name", new BigDecimalType(), true, 1, true, "Parent Prefix");

    // Assert
    verify(fieldMetadataProvider).addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   * <ul>
   *   <li>When {@code Prefix}.</li>
   *   <li>Then calls {@link FieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"})
  public void testBuildBasicProperty_whenPrefix_thenCallsAddMetadataFromFieldType() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromFieldType(Mockito.<AddMetadataFromFieldTypeRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();

    // Act
    dynamicEntityDaoImpl.buildBasicProperty(null, targetClass, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, MergedPropertyType.PRIMARY, presentationAttributes,
        componentProperties, fields, "Id Property", true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", parentClasses, "Prefix", true,
        "Property Name", new BigDecimalType(), true, 1, true, "Parent Prefix");

    // Assert
    verify(fieldMetadataProvider).addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}.
   * <ul>
   *   <li>Given {@code Many To Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.testForeignProperty(ForeignKey, String, String)"})
  public void testTestForeignProperty_givenManyToField() {
    // Arrange
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
   * Test {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.testForeignProperty(ForeignKey, String, String)"})
  public void testTestForeignProperty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(dynamicEntityDaoImpl.testForeignProperty(new ForeignKey("PrefixProperty Name", "PrefixProperty Name"),
        "Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.testForeignProperty(ForeignKey, String, String)"})
  public void testTestForeignProperty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(dynamicEntityDaoImpl.testForeignProperty(null, "Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DynamicEntityDaoImpl.findAdditionalForeignKeyIndex(ForeignKey[], String, String)"})
  public void testFindAdditionalForeignKeyIndex() {
    // Arrange, Act and Assert
    assertEquals(-1, dynamicEntityDaoImpl
        .findAdditionalForeignKeyIndex(new ForeignKey[]{new ForeignKey("name", "name")}, "Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   * <ul>
   *   <li>Given {@code Many To Field}.</li>
   *   <li>Then return minus two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DynamicEntityDaoImpl.findAdditionalForeignKeyIndex(ForeignKey[], String, String)"})
  public void testFindAdditionalForeignKeyIndex_givenManyToField_thenReturnMinusTwo() {
    // Arrange
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
   * Test {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   * <ul>
   *   <li>When empty array of {@link ForeignKey}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DynamicEntityDaoImpl.findAdditionalForeignKeyIndex(ForeignKey[], String, String)"})
  public void testFindAdditionalForeignKeyIndex_whenEmptyArrayOfForeignKey_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, dynamicEntityDaoImpl.findAdditionalForeignKeyIndex(new ForeignKey[]{}, "Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DynamicEntityDaoImpl.findAdditionalForeignKeyIndex(ForeignKey[], String, String)"})
  public void testFindAdditionalForeignKeyIndex_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, dynamicEntityDaoImpl.findAdditionalForeignKeyIndex(null, "Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"})
  public void testBuildEntityProperties_givenJavaLangObject_thenArrayListSizeIsOne() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(fields, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", "Property Name", returnedClass, targetClass,
        parentClasses, "Prefix", true, "Parent Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("PrefixProperty Name."),
        eq(true), eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
    assertEquals(1, parentClasses.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, parentClasses.get(0));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"})
  public void testBuildEntityProperties_givenJavaLangObject_thenArrayListSizeIsTwo() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(fields, foreignField, new ForeignKey[]{new ForeignKey()},
        new String[]{"Additional Non Persistent Properties"}, true, new String[]{"Include Fields"},
        new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", "Property Name", returnedClass, targetClass,
        parentClasses, "Prefix", true, "Parent Prefix");

    // Assert
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("PrefixProperty Name."),
        eq(true), eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
    assertEquals(2, parentClasses.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, parentClasses.get(0));
    assertSame(forNameResult2, parentClasses.get(1));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"})
  public void testBuildEntityProperties_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.buildEntityProperties(fields, foreignField, new ForeignKey[]{new ForeignKey()},
            new String[]{"Additional Non Persistent Properties"}, true, new String[]{"Include Fields"},
            new String[]{"Exclude Fields"}, "Configuration Key", "Dr Jane Doe", "Property Name", returnedClass,
            targetClass, new ArrayList<>(), "Prefix", true, "Parent Prefix"));
    verify(metadata).overrideMetadata(isA(Class[].class), isA(PropertyBuilder.class), eq("PrefixProperty Name."),
        eq(true), eq("Dr Jane Doe"), eq("Configuration Key"), isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"})
  public void testBuildEntityProperties_whenArrayList_thenCallsOverrideMetadata() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
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
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then calls {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"})
  public void testBuildEntityProperties_whenEmptyArrayOfString_thenCallsOverrideMetadata() {
    // Arrange
    when(
        metadata.overrideMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PropertyBuilder>any(), Mockito.<String>any(),
            Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isForeignKey(FieldMetadata)"})
  public void testIsForeignKey() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();

    PersistencePerspective persistencePerspective = new PersistencePerspective(operationTypes,
        new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()});
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.MAPSTRUCTURE,
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
   *   <li>Given {@link HashMap#HashMap()} {@link PersistencePerspectiveItemType#FOREIGNKEY} is {@link AdornedTargetList#AdornedTargetList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isForeignKey(FieldMetadata)"})
  public void testIsForeignKey_givenHashMapForeignkeyIsAdornedTargetList_thenReturnTrue() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isForeignKey(FieldMetadata)"})
  public void testIsForeignKey_givenPersistencePerspective() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isForeignKey(FieldMetadata)"})
  public void testIsForeignKey_whenAdornedTargetCollectionMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(dynamicEntityDaoImpl.isForeignKey(new AdornedTargetCollectionMetadata()));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setOriginatingFieldForForeignKey(String, String, FieldMetadata)}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#setOriginatingFieldForForeignKey(String, String, FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setOriginatingFieldForForeignKey(String, String, FieldMetadata)"})
  public void testSetOriginatingFieldForForeignKey() {
    // Arrange
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
   * Test {@link DynamicEntityDaoImpl#setStandardEntityManager(EntityManager)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link DynamicEntityDaoImpl} {@link DynamicEntityDaoImpl#fieldManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#setStandardEntityManager(EntityManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setStandardEntityManager(EntityManager)"})
  public void testSetStandardEntityManager_whenNull_thenDynamicEntityDaoImplFieldManager() {
    // Arrange and Act
    dynamicEntityDaoImpl.setStandardEntityManager(null);

    // Assert
    FieldManager expectedFieldManager = dynamicEntityDaoImpl.fieldManager;
    assertSame(expectedFieldManager, dynamicEntityDaoImpl.getFieldManager());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getFieldManager(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#getFieldManager(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldManager DynamicEntityDaoImpl.getFieldManager(boolean)"})
  public void testGetFieldManagerWithBoolean() {
    // Arrange and Act
    FieldManager actualFieldManager = dynamicEntityDaoImpl.getFieldManager(true);

    // Assert
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
   *   <li>{@link DynamicEntityDaoImpl#setDefaultFieldMetadataProvider(FieldMetadataProvider)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldMetadataProvider DynamicEntityDaoImpl.getDefaultFieldMetadataProvider()",
      "DynamicDaoHelper DynamicEntityDaoImpl.getDynamicDaoHelper()",
      "EntityConfiguration DynamicEntityDaoImpl.getEntityConfiguration()",
      "List DynamicEntityDaoImpl.getFieldMetadataProviders()", "Metadata DynamicEntityDaoImpl.getMetadata()",
      "EntityManager DynamicEntityDaoImpl.getStandardEntityManager()",
      "void DynamicEntityDaoImpl.setApplicationContext(ApplicationContext)",
      "void DynamicEntityDaoImpl.setDefaultFieldMetadataProvider(FieldMetadataProvider)",
      "void DynamicEntityDaoImpl.setDynamicDaoHelper(DynamicDaoHelper)",
      "void DynamicEntityDaoImpl.setEntityConfiguration(EntityConfiguration)",
      "void DynamicEntityDaoImpl.setFieldMetadataProviders(List)", "void DynamicEntityDaoImpl.setMetadata(Metadata)"})
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
    EntityManager actualStandardEntityManager = dynamicEntityDaoImpl.getStandardEntityManager();

    // Assert
    assertTrue(actualDynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertTrue(actualDefaultFieldMetadataProvider instanceof AdornedTargetCollectionFieldMetadataProvider);
    assertNull(actualEntityConfiguration.getEntityContexts());
    assertNull(actualStandardEntityManager);
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
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityDaoImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isExcludeClassFromPolymorphism(Class)"})
  public void testIsExcludeClassFromPolymorphism_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.isExcludeClassFromPolymorphism(clazz));
  }
}
