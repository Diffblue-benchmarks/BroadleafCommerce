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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.exception.NoPossibleResultsException;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CriteriaTranslatorImplDiffblueTest {
  @InjectMocks
  private CriteriaTranslatorImpl criteriaTranslatorImpl;

  @Mock
  private List<CriteriaTranslatorEventHandler> list;

  @Mock
  private RowLevelSecurityService rowLevelSecurityService;

  @Mock
  private SecurityVerifier securityVerifier;

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   * <ul>
   *   <li>Given {@link ClassTree#ClassTree()}.</li>
   *   <li>When {@link DynamicEntityDao} {@link DynamicEntityDao#getClassTree(Class[])} return {@link ClassTree#ClassTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_givenClassTree_whenDynamicEntityDaoGetClassTreeReturnClassTree()
      throws NoPossibleResultsException {
    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(new ClassTree());
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, new ArrayList<>()));
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_givenFilterMapping_whenArrayListAddFilterMapping() throws NoPossibleResultsException {
    // Arrange
    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);
    Class<Serializable> ceilingMarker = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, filterMappings));
    verify(classTree).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_givenFilterMapping_whenArrayListAddFilterMapping2() throws NoPossibleResultsException {
    // Arrange
    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);
    Class<Serializable> ceilingMarker = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, filterMappings));
    verify(classTree).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   * <ul>
   *   <li>Then calls {@link ClassTree#getFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_thenCallsGetFullyQualifiedClassname() throws NoPossibleResultsException {
    // Arrange
    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, new ArrayList<>()));
    verify(classTree).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   * <ul>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_thenReturnObject() throws NoPossibleResultsException {
    // Arrange
    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getFullyQualifiedClassname()).thenReturn("java.lang.Object");
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act
    Class<Serializable> actualDetermineRootResult = criteriaTranslatorImpl.determineRoot(dynamicEntityDao,
        ceilingMarker, new ArrayList<>());

    // Assert
    verify(classTree).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
    Class<Object> expectedDetermineRootResult = Object.class;
    assertEquals(expectedDetermineRootResult, actualDetermineRootResult);
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   * <ul>
   *   <li>When {@link DynamicEntityDaoImpl} (default constructor).</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_whenDynamicEntityDaoImpl_thenThrowIllegalStateException()
      throws NoPossibleResultsException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, new ArrayList<>()));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"})
  public void testDetermineRootInternal() {
    // Arrange
    ClassTree root = new ClassTree("Dr Jane Doe");
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Object> classToCheck = Object.class;

    // Act and Assert
    assertNull(criteriaTranslatorImpl.determineRootInternal(root, parents, classToCheck));
    assertEquals(1, parents.size());
    assertEquals(parents, root.getCollapsedClassTrees());
    assertSame(root, parents.get(0));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"})
  public void testDetermineRootInternal2() {
    // Arrange
    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[]{new ClassTree("Dr Jane Doe")});
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult = criteriaTranslatorImpl.determineRootInternal(root, parents,
        classToCheck);

    // Assert
    verify(root).getChildren();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertNull(actualDetermineRootInternalResult);
    assertEquals(1, parents.size());
    assertSame(root, parents.get(0));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"})
  public void testDetermineRootInternal3() {
    // Arrange
    ClassTree classTree = mock(ClassTree.class);
    ClassTree classTree2 = new ClassTree();
    when(classTree.find(Mockito.<String>any())).thenReturn(classTree2);
    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[]{classTree});
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    ClassTree classTree3 = mock(ClassTree.class);
    when(classTree3.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    ArrayList<ClassTree> parents = new ArrayList<>();
    parents.add(classTree3);
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult = criteriaTranslatorImpl.determineRootInternal(root, parents,
        classToCheck);

    // Assert
    verify(classTree).find(eq("java.lang.Object"));
    verify(root).getChildren();
    verify(classTree3).getFullyQualifiedClassname();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertEquals(2, parents.size());
    assertSame(classTree2, actualDetermineRootInternalResult);
    assertSame(root, parents.get(1));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"})
  public void testDetermineRootInternal4() {
    // Arrange
    ClassTree root = mock(ClassTree.class);
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getFullyQualifiedClassname()).thenReturn("java.lang.Object");

    ArrayList<ClassTree> parents = new ArrayList<>();
    parents.add(classTree);
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult = criteriaTranslatorImpl.determineRootInternal(root, parents,
        classToCheck);

    // Assert
    verify(root).getFullyQualifiedClassname();
    verify(classTree).getFullyQualifiedClassname();
    assertEquals(1, parents.size());
    assertSame(root, actualDetermineRootInternalResult);
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   * <ul>
   *   <li>Given {@link ClassTree} {@link ClassTree#find(String)} return {@link ClassTree#ClassTree()}.</li>
   *   <li>Then return {@link ClassTree#ClassTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"})
  public void testDetermineRootInternal_givenClassTreeFindReturnClassTree_thenReturnClassTree() {
    // Arrange
    ClassTree classTree = mock(ClassTree.class);
    ClassTree classTree2 = new ClassTree();
    when(classTree.find(Mockito.<String>any())).thenReturn(classTree2);
    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[]{classTree});
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult = criteriaTranslatorImpl.determineRootInternal(root, parents,
        classToCheck);

    // Assert
    verify(classTree).find(eq("java.lang.Object"));
    verify(root).getChildren();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertEquals(1, parents.size());
    assertSame(classTree2, actualDetermineRootInternalResult);
    assertSame(root, parents.get(0));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   * <ul>
   *   <li>Given {@link ClassTree#ClassTree(String)} with fullyQualifiedClassname is {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"})
  public void testDetermineRootInternal_givenClassTreeWithFullyQualifiedClassnameIsDrJaneDoe() {
    // Arrange
    ClassTree classTree = mock(ClassTree.class);
    ClassTree classTree2 = new ClassTree();
    when(classTree.find(Mockito.<String>any())).thenReturn(classTree2);
    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[]{classTree});
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    ArrayList<ClassTree> parents = new ArrayList<>();
    ClassTree classTree3 = new ClassTree("Dr Jane Doe");
    parents.add(classTree3);
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult = criteriaTranslatorImpl.determineRootInternal(root, parents,
        classToCheck);

    // Assert
    verify(classTree).find(eq("java.lang.Object"));
    verify(root).getChildren();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertEquals(2, parents.size());
    assertSame(classTree2, actualDetermineRootInternalResult);
    assertSame(classTree3, parents.get(0));
    assertSame(root, parents.get(1));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"})
  public void testDetermineRootInternal_givenJavaLangObject_thenArrayListEmpty() {
    // Arrange
    ClassTree root = mock(ClassTree.class);
    when(root.getFullyQualifiedClassname()).thenReturn("java.lang.Object");
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult = criteriaTranslatorImpl.determineRootInternal(root, parents,
        classToCheck);

    // Assert
    verify(root).getFullyQualifiedClassname();
    assertTrue(parents.isEmpty());
    assertSame(root, actualDetermineRootInternalResult);
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@code Integer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"})
  public void testDetermineRootInternal_givenJavaLangObject_whenJavaLangInteger() {
    // Arrange
    ClassTree classTree = mock(ClassTree.class);
    ClassTree classTree2 = new ClassTree();
    when(classTree.find(Mockito.<String>any())).thenReturn(classTree2);
    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[]{classTree});
    when(root.getFullyQualifiedClassname()).thenReturn("java.lang.Object");
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Integer> classToCheck = Integer.class;

    // Act
    ClassTree actualDetermineRootInternalResult = criteriaTranslatorImpl.determineRootInternal(root, parents,
        classToCheck);

    // Assert
    verify(classTree).find(eq("java.lang.Integer"));
    verify(root).getChildren();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertEquals(1, parents.size());
    assertSame(classTree2, actualDetermineRootInternalResult);
    assertSame(root, parents.get(0));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}.
   * <ul>
   *   <li>Then return intValue is {@link Integer#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object CriteriaTranslatorImpl.getAppropriateLargeSortingValue(Class)"})
  public void testGetAppropriateLargeSortingValue_thenReturnIntValueIsMax_value() {
    // Arrange
    Class<Integer> javaType = Integer.class;

    // Act and Assert
    assertEquals(Integer.MAX_VALUE,
        ((Integer) criteriaTranslatorImpl.getAppropriateLargeSortingValue(javaType)).intValue());
  }

  /**
   * Test {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}.
   * <ul>
   *   <li>Then return longValue is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object CriteriaTranslatorImpl.getAppropriateLargeSortingValue(Class)"})
  public void testGetAppropriateLargeSortingValue_thenReturnLongValueIsMax_value() {
    // Arrange
    Class<Long> javaType = Long.class;

    // Act and Assert
    assertEquals(Long.MAX_VALUE, ((Long) criteriaTranslatorImpl.getAppropriateLargeSortingValue(javaType)).longValue());
  }

  /**
   * Test {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object CriteriaTranslatorImpl.getAppropriateLargeSortingValue(Class)"})
  public void testGetAppropriateLargeSortingValue_whenJavaLangObject_thenReturnNull() {
    // Arrange
    Class<Object> javaType = Object.class;

    // Act and Assert
    assertNull(criteriaTranslatorImpl.getAppropriateLargeSortingValue(javaType));
  }
}
