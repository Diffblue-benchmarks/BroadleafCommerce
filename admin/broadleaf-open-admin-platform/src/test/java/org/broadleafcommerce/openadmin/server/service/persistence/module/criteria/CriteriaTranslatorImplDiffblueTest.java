package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.exception.NoPossibleResultsException;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class CriteriaTranslatorImplDiffblueTest {
  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot() throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getChildren()).thenThrow(new NoPossibleResultsException("An error occurred"));
    when(classTree.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<?>>any()))
        .thenReturn(new Class[] {forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);
    Class<Serializable> ceilingMarker = Serializable.class;

    FilterMapping filterMapping = new FilterMapping();
    Class<Object> inheritedFromClass = Object.class;
    filterMapping.setInheritedFromClass(inheritedFromClass);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        NoPossibleResultsException.class,
        () ->
            criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, filterMappings));
    verify(classTree).getChildren();
    verify(classTree, atLeast(1)).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot2() throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getChildren()).thenReturn(new ClassTree[] {new ClassTree("Dr Jane Doe")});
    when(classTree.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<?>>any()))
        .thenReturn(new Class[] {forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);
    Class<Serializable> ceilingMarker = Serializable.class;

    FilterMapping filterMapping = new FilterMapping();
    Class<Object> inheritedFromClass = Object.class;
    filterMapping.setInheritedFromClass(inheritedFromClass);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        NoPossibleResultsException.class,
        () ->
            criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, filterMappings));
    verify(classTree).getChildren();
    verify(classTree, atLeast(1)).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <ul>
   *   <li>Given {@link ClassTree} {@link ClassTree#find(String)} return {@link
   *       ClassTree#ClassTree()}.
   *   <li>Then calls {@link ClassTree#find(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_givenClassTreeFindReturnClassTree_thenCallsFind()
      throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    when(classTree.find(Mockito.<String>any())).thenReturn(new ClassTree());

    ClassTree classTree2 = mock(ClassTree.class);
    when(classTree2.getChildren()).thenReturn(new ClassTree[] {classTree});
    when(classTree2.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<?>>any()))
        .thenReturn(new Class[] {forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree2);
    Class<Serializable> ceilingMarker = Serializable.class;

    FilterMapping filterMapping = new FilterMapping();
    Class<Object> inheritedFromClass = Object.class;
    filterMapping.setInheritedFromClass(inheritedFromClass);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, filterMappings));
    verify(classTree).find("java.lang.Object");
    verify(classTree2).getChildren();
    verify(classTree2, atLeast(1)).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <ul>
   *   <li>Given {@link ClassTree#ClassTree()}.
   *   <li>When {@link DynamicEntityDao} {@link DynamicEntityDao#getClassTree(Class[])} return
   *       {@link ClassTree#ClassTree()}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_givenClassTree_whenDynamicEntityDaoGetClassTreeReturnClassTree()
      throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<?>>any()))
        .thenReturn(new Class[] {forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(new ClassTree());
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            criteriaTranslatorImpl.determineRoot(
                dynamicEntityDao, ceilingMarker, new ArrayList<>()));
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link DynamicEntityDaoImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_givenFilterMapping_whenDynamicEntityDaoImpl()
      throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Class<Serializable> ceilingMarker = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, filterMappings));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link DynamicEntityDaoImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_givenFilterMapping_whenDynamicEntityDaoImpl2()
      throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Class<Serializable> ceilingMarker = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, filterMappings));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <ul>
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_thenReturnObject() throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getFullyQualifiedClassname()).thenReturn("java.lang.Object");

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<?>>any()))
        .thenReturn(new Class[] {forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act
    Class<Serializable> actualDetermineRootResult =
        criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, new ArrayList<>());

    // Assert
    verify(classTree).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
    Class<Object> expectedDetermineRootResult = Object.class;
    assertEquals(expectedDetermineRootResult, actualDetermineRootResult);
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <ul>
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_thenReturnObject2() throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getFullyQualifiedClassname()).thenReturn("java.lang.Object");

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<?>>any()))
        .thenReturn(new Class[] {forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);
    Class<Serializable> ceilingMarker = Serializable.class;

    FilterMapping filterMapping = new FilterMapping();
    Class<Object> inheritedFromClass = Object.class;
    filterMapping.setInheritedFromClass(inheritedFromClass);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    Class<Serializable> actualDetermineRootResult =
        criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, filterMappings);

    // Assert
    verify(classTree, atLeast(1)).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
    Class<Object> expectedDetermineRootResult = Object.class;
    assertEquals(expectedDetermineRootResult, actualDetermineRootResult);
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_whenArrayList_thenThrowIllegalStateException()
      throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<?>>any()))
        .thenReturn(new Class[] {forNameResult});
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            criteriaTranslatorImpl.determineRoot(
                dynamicEntityDao, ceilingMarker, new ArrayList<>()));
    verify(classTree).getFullyQualifiedClassname();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   *
   * <ul>
   *   <li>When {@link DynamicEntityDaoImpl} (default constructor).
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CriteriaTranslatorImpl.determineRoot(DynamicEntityDao, Class, List)"})
  public void testDetermineRoot_whenDynamicEntityDaoImpl_thenThrowIllegalStateException()
      throws NoPossibleResultsException {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            criteriaTranslatorImpl.determineRoot(
                dynamicEntityDao, ceilingMarker, new ArrayList<>()));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"
  })
  public void testDetermineRootInternal() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
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
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"
  })
  public void testDetermineRootInternal2() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[] {new ClassTree("Dr Jane Doe")});
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult =
        criteriaTranslatorImpl.determineRootInternal(root, parents, classToCheck);

    // Assert
    verify(root).getChildren();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertNull(actualDetermineRootInternalResult);
    assertEquals(1, parents.size());
    assertSame(root, parents.get(0));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"
  })
  public void testDetermineRootInternal3() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree root = mock(ClassTree.class);
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    ArrayList<ClassTree> parents = new ArrayList<>();
    ClassTree classTree = new ClassTree("java.lang.Object");
    parents.add(classTree);
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult =
        criteriaTranslatorImpl.determineRootInternal(root, parents, classToCheck);

    // Assert
    verify(root).getFullyQualifiedClassname();
    assertEquals(1, parents.size());
    assertSame(classTree, parents.get(0));
    assertSame(root, actualDetermineRootInternalResult);
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"
  })
  public void testDetermineRootInternal4() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    ClassTree classTree2 = new ClassTree();
    when(classTree.find(Mockito.<String>any())).thenReturn(classTree2);

    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[] {classTree});
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    ClassTree classTree3 = mock(ClassTree.class);
    when(classTree3.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    ArrayList<ClassTree> parents = new ArrayList<>();
    parents.add(classTree3);
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult =
        criteriaTranslatorImpl.determineRootInternal(root, parents, classToCheck);

    // Assert
    verify(classTree).find("java.lang.Object");
    verify(root).getChildren();
    verify(classTree3).getFullyQualifiedClassname();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertEquals(2, parents.size());
    assertSame(classTree2, actualDetermineRootInternalResult);
    assertSame(root, parents.get(1));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   *
   * <ul>
   *   <li>Given {@link ClassTree} {@link ClassTree#find(String)} return {@link
   *       ClassTree#ClassTree()}.
   *   <li>Then return {@link ClassTree#ClassTree()}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"
  })
  public void testDetermineRootInternal_givenClassTreeFindReturnClassTree_thenReturnClassTree() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    ClassTree classTree2 = new ClassTree();
    when(classTree.find(Mockito.<String>any())).thenReturn(classTree2);

    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[] {classTree});
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult =
        criteriaTranslatorImpl.determineRootInternal(root, parents, classToCheck);

    // Assert
    verify(classTree).find("java.lang.Object");
    verify(root).getChildren();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertEquals(1, parents.size());
    assertSame(classTree2, actualDetermineRootInternalResult);
    assertSame(root, parents.get(0));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   *
   * <ul>
   *   <li>Given {@link ClassTree#ClassTree(String)} with fullyQualifiedClassname is {@code Dr Jane
   *       Doe}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"
  })
  public void testDetermineRootInternal_givenClassTreeWithFullyQualifiedClassnameIsDrJaneDoe() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    ClassTree classTree2 = new ClassTree();
    when(classTree.find(Mockito.<String>any())).thenReturn(classTree2);

    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[] {classTree});
    when(root.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    ArrayList<ClassTree> parents = new ArrayList<>();
    ClassTree classTree3 = new ClassTree("Dr Jane Doe");
    parents.add(classTree3);
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult =
        criteriaTranslatorImpl.determineRootInternal(root, parents, classToCheck);

    // Assert
    verify(classTree).find("java.lang.Object");
    verify(root).getChildren();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertEquals(2, parents.size());
    assertSame(classTree2, actualDetermineRootInternalResult);
    assertSame(classTree3, parents.get(0));
    assertSame(root, parents.get(1));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"
  })
  public void testDetermineRootInternal_givenJavaLangObject_thenArrayListEmpty() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree root = mock(ClassTree.class);
    when(root.getFullyQualifiedClassname()).thenReturn("java.lang.Object");
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Object> classToCheck = Object.class;

    // Act
    ClassTree actualDetermineRootInternalResult =
        criteriaTranslatorImpl.determineRootInternal(root, parents, classToCheck);

    // Assert
    verify(root).getFullyQualifiedClassname();
    assertTrue(parents.isEmpty());
    assertSame(root, actualDetermineRootInternalResult);
  }

  /**
   * Test {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code Integer}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree CriteriaTranslatorImpl.determineRootInternal(ClassTree, List, Class)"
  })
  public void testDetermineRootInternal_givenJavaLangObject_whenJavaLangInteger() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();

    ClassTree classTree = mock(ClassTree.class);
    ClassTree classTree2 = new ClassTree();
    when(classTree.find(Mockito.<String>any())).thenReturn(classTree2);

    ClassTree root = mock(ClassTree.class);
    when(root.getChildren()).thenReturn(new ClassTree[] {classTree});
    when(root.getFullyQualifiedClassname()).thenReturn("java.lang.Object");
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Integer> classToCheck = Integer.class;

    // Act
    ClassTree actualDetermineRootInternalResult =
        criteriaTranslatorImpl.determineRootInternal(root, parents, classToCheck);

    // Assert
    verify(classTree).find("java.lang.Integer");
    verify(root).getChildren();
    verify(root, atLeast(1)).getFullyQualifiedClassname();
    assertEquals(1, parents.size());
    assertSame(classTree2, actualDetermineRootInternalResult);
    assertSame(root, parents.get(0));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}.
   *
   * <ul>
   *   <li>Then return intValue is {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CriteriaTranslatorImpl.getAppropriateLargeSortingValue(Class)"})
  public void testGetAppropriateLargeSortingValue_thenReturnIntValueIsMax_value() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    Class<Integer> javaType = Integer.class;

    // Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        ((Integer) criteriaTranslatorImpl.getAppropriateLargeSortingValue(javaType)).intValue());
  }

  /**
   * Test {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}.
   *
   * <ul>
   *   <li>Then return longValue is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CriteriaTranslatorImpl.getAppropriateLargeSortingValue(Class)"})
  public void testGetAppropriateLargeSortingValue_thenReturnLongValueIsMax_value() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    Class<Long> javaType = Long.class;

    // Act and Assert
    assertEquals(
        Long.MAX_VALUE,
        ((Long) criteriaTranslatorImpl.getAppropriateLargeSortingValue(javaType)).longValue());
  }

  /**
   * Test {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CriteriaTranslatorImpl.getAppropriateLargeSortingValue(Class)"})
  public void testGetAppropriateLargeSortingValue_whenJavaLangObject_thenReturnNull() {
    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    Class<Object> javaType = Object.class;

    // Act and Assert
    assertNull(criteriaTranslatorImpl.getAppropriateLargeSortingValue(javaType));
  }
}
