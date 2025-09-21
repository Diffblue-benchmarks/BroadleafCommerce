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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
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
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.DefaultFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.FieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.MapFieldsFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromFieldTypeRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
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
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class DynamicEntityDaoImplDiffblueTest {
  @InjectMocks private DynamicEntityDaoImpl dynamicEntityDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  @Mock private FieldMetadataProvider fieldMetadataProvider;

  @Mock private Map<String, String> map;

  @Mock private Metadata metadata;

  /**
   * Test {@link DynamicEntityDaoImpl#getPersistentClass(String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPersistentClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.hibernate.mapping.PersistentClass DynamicEntityDaoImpl.getPersistentClass(String)"
  })
  public void testGetPersistentClass() {
    // Arrange, Act and Assert
    assertNull(dynamicEntityDaoImpl.getPersistentClass("Target Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#useCache()}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#useCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.useCache()"})
  public void testUseCache() {
    // Arrange, Act and Assert
    assertFalse(dynamicEntityDaoImpl.useCache());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)} with {@code
   * ceilingClass}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class)"})
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClass() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicDaoHelper.getAllPolymorphicEntitiesFromCeiling(
                Mockito.<Class<?>>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new Class[] {forNameResult});

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> ceilingClass = Object.class;

    // Act
    Class<?>[] actualAllPolymorphicEntitiesFromCeiling =
        dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass);

    // Assert
    verify(dynamicDaoHelper)
        .getAllPolymorphicEntitiesFromCeiling(isA(Class.class), eq(true), eq(false));
    assertEquals(1, actualAllPolymorphicEntitiesFromCeiling.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualAllPolymorphicEntitiesFromCeiling[0]);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)} with
   * {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean)"
  })
  public void
      testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(
        0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)} with
   * {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean)"
  })
  public void
      testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities2() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(
        0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, false).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)} with
   * {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean)"
  })
  public void
      testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities3() {
    // Arrange
    Class<Boolean> ceilingClass = Boolean.class;

    // Act and Assert
    assertEquals(
        0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class, boolean)} with
   * {@code ceilingClass}, {@code includeUnqualifiedPolymorphicEntities}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class, boolean)"
  })
  public void
      testGetAllPolymorphicEntitiesFromCeilingWithCeilingClassIncludeUnqualifiedPolymorphicEntities4() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicDaoHelper.getAllPolymorphicEntitiesFromCeiling(
                Mockito.<Class<?>>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new Class[] {forNameResult});

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> ceilingClass = Object.class;

    // Act
    Class<?>[] actualAllPolymorphicEntitiesFromCeiling =
        dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass, true);

    // Assert
    verify(dynamicDaoHelper)
        .getAllPolymorphicEntitiesFromCeiling(isA(Class.class), eq(true), eq(false));
    assertEquals(1, actualAllPolymorphicEntitiesFromCeiling.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualAllPolymorphicEntitiesFromCeiling[0]);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)} with {@code
   * ceilingClass}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class)"})
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClass_whenJavaLangBoolean() {
    // Arrange
    Class<Boolean> ceilingClass = Boolean.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)} with {@code
   * ceilingClass}.
   *
   * <ul>
   *   <li>When {@code Byte}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class)"})
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClass_whenJavaLangByte() {
    // Arrange
    Class<Byte> ceilingClass = Byte.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)} with {@code
   * ceilingClass}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Class)"})
  public void testGetAllPolymorphicEntitiesFromCeilingWithCeilingClass_whenJavaLangObject() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getUpDownInheritance(Class)"})
  public void testGetUpDownInheritance_givenDynamicEntityDaoImpl_thenReturnArrayLengthIsZero() {
    // Arrange
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getUpDownInheritance(testClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl} (default constructor).
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getUpDownInheritance(Class)"})
  public void testGetUpDownInheritance_givenDynamicEntityDaoImpl_thenReturnArrayLengthIsZero2() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getUpDownInheritance(testClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getUpDownInheritance(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getUpDownInheritance(Class)"})
  public void testGetUpDownInheritance_givenJavaLangObject_thenReturnArrayLengthIsOne() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicDaoHelper.getUpDownInheritance(
                Mockito.<Class<?>>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new Class[] {forNameResult});

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> testClass = Object.class;

    // Act
    Class<?>[] actualUpDownInheritance = dynamicEntityDaoImpl.getUpDownInheritance(testClass);

    // Assert
    verify(dynamicDaoHelper).getUpDownInheritance(isA(Class.class), eq(true), eq(false));
    assertEquals(1, actualUpDownInheritance.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualUpDownInheritance[0]);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code Class Name}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_givenJavaLangObject_whenClassName_thenReturnObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    // Act
    Class<?> actualImplClass = dynamicEntityDaoImpl.getImplClass("Class Name");

    // Assert
    verify(entityConfiguration).lookupEntityClass("Class Name");
    Class<Object> expectedImplClass = Object.class;
    assertEquals(expectedImplClass, actualImplClass);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_thenThrowRuntimeException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.getImplClass("Class Name"));
    verify(entityConfiguration).lookupEntityClass("Class Name");
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getImplClass(String)}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then return {@link Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getImplClass(String)"})
  public void testGetImplClass_whenJavaLangBoolean_thenReturnBoolean() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act
    Class<?> actualImplClass = dynamicEntityDaoImpl.getImplClass("java.lang.Boolean");

    // Assert
    verify(entityConfiguration).lookupEntityClass("java.lang.Boolean");
    Class<Boolean> expectedImplClass = Boolean.class;
    assertEquals(expectedImplClass, actualImplClass);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    Mockito.<Class<?>[]>when(
            dynamicDaoHelper.getAllPolymorphicEntitiesFromCeiling(
                Mockito.<Class<?>>any(), anyBoolean(), anyBoolean()))
        .thenReturn(null);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dynamicEntityDaoImpl.getCeilingImplClass("java.lang.Boolean"));
    verify(dynamicDaoHelper, atLeast(1))
        .getAllPolymorphicEntitiesFromCeiling(isA(Class.class), eq(true), eq(false));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code Boolean}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass_givenJavaLangObject_whenJavaLangBoolean_thenReturnObject() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicDaoHelper.getAllPolymorphicEntitiesFromCeiling(
                Mockito.<Class<?>>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new Class[] {forNameResult});

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);

    // Act
    Class<?> actualCeilingImplClass = dynamicEntityDaoImpl.getCeilingImplClass("java.lang.Boolean");

    // Assert
    verify(dynamicDaoHelper)
        .getAllPolymorphicEntitiesFromCeiling(isA(Class.class), eq(true), eq(false));
    Class<Object> expectedCeilingImplClass = Object.class;
    assertEquals(expectedCeilingImplClass, actualCeilingImplClass);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dynamicEntityDaoImpl.getCeilingImplClass("java.lang.Boolean"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class DynamicEntityDaoImpl.getCeilingImplClass(String)"})
  public void testGetCeilingImplClass_whenClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> dynamicEntityDaoImpl.getCeilingImplClass("Class Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getIdentifier(Object)}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getIdentifier(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Serializable DynamicEntityDaoImpl.getIdentifier(Object)"})
  public void testGetIdentifier_givenDynamicEntityDaoImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(dynamicEntityDaoImpl.getIdentifier("Entity"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getIdentifier(Object)}.
   *
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy/mm/dd}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getIdentifier(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Serializable DynamicEntityDaoImpl.getIdentifier(Object)"})
  public void testGetIdentifier_thenReturnSimpleDateFormatWithYyyyMmDd() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    when(dynamicDaoHelper.getIdentifier(Mockito.<Object>any())).thenReturn(simpleDateFormat);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);

    // Act
    Serializable actualIdentifier = dynamicEntityDaoImpl.getIdentifier("Entity");

    // Assert
    verify(dynamicDaoHelper).getIdentifier(isA(Object.class));
    assertSame(simpleDateFormat, actualIdentifier);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getIdField(Class)}.
   *
   * <ul>
   *   <li>Given {@link DynamicDaoHelperImpl} {@link DynamicDaoHelperImpl#getIdField(Class)} return
   *       {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getIdField(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Field DynamicEntityDaoImpl.getIdField(Class)"})
  public void testGetIdField_givenDynamicDaoHelperImplGetIdFieldReturnNull_thenReturnNull() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.getIdField(Mockito.<Class<?>>any())).thenReturn(null);

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
   *
   * <ul>
   *   <li>Given {@code Boolean}.
   *   <li>Then return first element is {@link Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code Boolean}.
   *   <li>Then return first element is {@link Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.sortEntities(Class, List)"})
  public void testSortEntities_givenJavaLangBoolean_thenReturnFirstElementIsBoolean2() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    ArrayList<Class<?>> entities = new ArrayList<>();
    Class<Boolean> forNameResult = Boolean.class;
    entities.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
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
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.sortEntities(Class, List)"})
  public void testSortEntities_givenObject_whenArrayListAddObject_thenReturnArrayLengthIsOne() {
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
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.sortEntities(Class, List)"})
  public void testSortEntities_givenObject_whenArrayListAddObject_thenReturnArrayLengthIsTwo() {
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#sortEntities(Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.
   *   <li>Then calls {@link ClassTree#getFullyQualifiedClassname()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.addClassToTree(Class, ClassTree)"})
  public void testAddClassToTree_givenNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    ClassTree tree = new ClassTree("Dr Jane Doe");
    tree.setChildren(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.addClassToTree(clazz, tree));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTree(Class[])}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl}.
   *   <li>When empty array of {@link Class}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getClassTree(Class[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTree(Class[])"})
  public void testGetClassTree_givenDynamicEntityDaoImpl_whenEmptyArrayOfClass_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(dynamicEntityDaoImpl.getClassTree(new Class[] {}));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTree(Class[])}.
   *
   * <ul>
   *   <li>Then return first element FriendlyName is {@code Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getClassTree(Class[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTree(Class[])"})
  public void testGetClassTree_thenReturnFirstElementFriendlyNameIsBoolean() {
    // Arrange
    Class<Boolean> forNameResult = Boolean.class;
    Class<Object> forNameResult2 = Object.class;

    // Act
    ClassTree actualClassTree =
        dynamicEntityDaoImpl.getClassTree(new Class[] {forNameResult, forNameResult2});

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
   * Test {@link DynamicEntityDaoImpl#getClassTree(Class[])}.
   *
   * <ul>
   *   <li>Then return Left is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getClassTree(Class[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTree(Class[])"})
  public void testGetClassTree_thenReturnLeftIsOne() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.isExcludeClassFromPolymorphism(Mockito.<Class<?>>any())).thenReturn(true);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> forNameResult = Object.class;

    // Act
    ClassTree actualClassTree = dynamicEntityDaoImpl.getClassTree(new Class[] {forNameResult});

    // Assert
    verify(dynamicDaoHelper).isExcludeClassFromPolymorphism(isA(Class.class));
    assertEquals("Object", actualClassTree.getFriendlyName());
    assertEquals("Object", actualClassTree.getName());
    assertEquals("java.lang.Object", actualClassTree.getFullyQualifiedClassname());
    assertEquals(0, actualClassTree.getChildren().length);
    assertEquals(1, actualClassTree.getLeft());
    assertEquals(2, actualClassTree.getRight());
    assertFalse(actualClassTree.hasChildren());
    assertTrue(actualClassTree.getCollapsedClassTrees().isEmpty());
    assertTrue(actualClassTree.isExcludeFromPolymorphism());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTree(Class[])}.
   *
   * <ul>
   *   <li>When array of {@link Class} with {@link Boolean} and {@link Byte}.
   *   <li>Then return FriendlyName is {@code Byte}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getClassTree(Class[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTree(Class[])"})
  public void testGetClassTree_whenArrayOfClassWithBooleanAndByte_thenReturnFriendlyNameIsByte() {
    // Arrange
    Class<Boolean> forNameResult = Boolean.class;
    Class<Byte> forNameResult2 = Byte.class;

    // Act
    ClassTree actualClassTree =
        dynamicEntityDaoImpl.getClassTree(new Class[] {forNameResult, forNameResult2});

    // Assert
    assertEquals("Byte", actualClassTree.getFriendlyName());
    assertEquals("Byte", actualClassTree.getName());
    assertEquals("java.lang.Byte", actualClassTree.getFullyQualifiedClassname());
    List<ClassTree> collapsedClassTrees = actualClassTree.getCollapsedClassTrees();
    assertEquals(1, collapsedClassTrees.size());
    assertSame(actualClassTree, collapsedClassTrees.get(0));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTree(Class[])}.
   *
   * <ul>
   *   <li>When array of {@link Class} with {@link Object}.
   *   <li>Then return FriendlyName is {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getClassTree(Class[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTree(Class[])"})
  public void testGetClassTree_whenArrayOfClassWithObject_thenReturnFriendlyNameIsObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    ClassTree actualClassTree = dynamicEntityDaoImpl.getClassTree(new Class[] {forNameResult});

    // Assert
    assertEquals("Object", actualClassTree.getFriendlyName());
    assertEquals("Object", actualClassTree.getName());
    assertEquals("java.lang.Object", actualClassTree.getFullyQualifiedClassname());
    assertEquals(0, actualClassTree.getChildren().length);
    List<ClassTree> collapsedClassTrees = actualClassTree.getCollapsedClassTrees();
    assertEquals(1, collapsedClassTrees.size());
    assertEquals(2, actualClassTree.getRight());
    assertFalse(actualClassTree.hasChildren());
    assertSame(actualClassTree, collapsedClassTrees.get(0));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTreeFromCeiling(Class)"})
  public void testGetClassTreeFromCeiling_givenDynamicEntityDaoImpl_thenReturnNull() {
    // Arrange
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertNull(dynamicEntityDaoImpl.getClassTreeFromCeiling(ceilingClass));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTreeFromCeiling(Class)"})
  public void testGetClassTreeFromCeiling_givenDynamicEntityDaoImpl_thenReturnNull2() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertNull(dynamicEntityDaoImpl.getClassTreeFromCeiling(ceilingClass));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}.
   *
   * <ul>
   *   <li>Then return FriendlyName is {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTreeFromCeiling(Class)"})
  public void testGetClassTreeFromCeiling_thenReturnFriendlyNameIsObject() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.isExcludeClassFromPolymorphism(Mockito.<Class<?>>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicDaoHelper.getAllPolymorphicEntitiesFromCeiling(
                Mockito.<Class<?>>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new Class[] {forNameResult});

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> ceilingClass = Object.class;

    // Act
    ClassTree actualClassTreeFromCeiling =
        dynamicEntityDaoImpl.getClassTreeFromCeiling(ceilingClass);

    // Assert
    verify(dynamicDaoHelper)
        .getAllPolymorphicEntitiesFromCeiling(isA(Class.class), eq(true), eq(false));
    verify(dynamicDaoHelper).isExcludeClassFromPolymorphism(isA(Class.class));
    assertEquals("Object", actualClassTreeFromCeiling.getFriendlyName());
    assertEquals("Object", actualClassTreeFromCeiling.getName());
    assertEquals("java.lang.Object", actualClassTreeFromCeiling.getFullyQualifiedClassname());
    assertEquals(0, actualClassTreeFromCeiling.getChildren().length);
    assertEquals(1, actualClassTreeFromCeiling.getLeft());
    assertEquals(2, actualClassTreeFromCeiling.getRight());
    assertFalse(actualClassTreeFromCeiling.hasChildren());
    assertTrue(actualClassTreeFromCeiling.getCollapsedClassTrees().isEmpty());
    assertTrue(actualClassTreeFromCeiling.isExcludeFromPolymorphism());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getClassTreeFromCeiling(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassTree DynamicEntityDaoImpl.getClassTreeFromCeiling(Class)"})
  public void testGetClassTreeFromCeiling_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.isExcludeClassFromPolymorphism(Mockito.<Class<?>>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicDaoHelper.getAllPolymorphicEntitiesFromCeiling(
                Mockito.<Class<?>>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new Class[] {forNameResult});

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.getClassTreeFromCeiling(ceilingClass));
    verify(dynamicDaoHelper)
        .getAllPolymorphicEntitiesFromCeiling(isA(Class.class), eq(true), eq(false));
    verify(dynamicDaoHelper).isExcludeClassFromPolymorphism(isA(Class.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String,
   * PersistencePerspective)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"
  })
  public void testGetSimpleMergedProperties() {
    // Arrange
    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new AdornedTargetCollectionFieldMetadataProvider());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);

    // Act and Assert
    assertTrue(
        dynamicEntityDaoImpl
            .getSimpleMergedProperties("java.lang.Boolean", new PersistencePerspective())
            .isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#getExcluded()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String,
   * PersistencePerspective)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"
  })
  public void testGetSimpleMergedProperties_thenCallsGetExcluded() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(metadata.getFieldMetadataForTargetClass(
            Mockito.<Class<?>>any(),
            Mockito.<Class<?>>any(),
            Mockito.<DynamicEntityDao>any(),
            Mockito.<String>any()))
        .thenReturn(stringFieldMetadataMap);

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties =
        dynamicEntityDaoImpl.getSimpleMergedProperties(
            "java.lang.Boolean", new PersistencePerspective());

    // Assert
    verify(adornedTargetCollectionMetadata).getExcluded();
    verify(metadata)
        .getFieldMetadataForTargetClass(
            isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
    assertTrue(actualSimpleMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#getExcluded()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String,
   * PersistencePerspective)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"
  })
  public void testGetSimpleMergedProperties_thenCallsGetExcluded2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(metadata.getFieldMetadataForTargetClass(
            Mockito.<Class<?>>any(),
            Mockito.<Class<?>>any(),
            Mockito.<DynamicEntityDao>any(),
            Mockito.<String>any()))
        .thenReturn(stringFieldMetadataMap);

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties =
        dynamicEntityDaoImpl.getSimpleMergedProperties(
            "java.lang.Byte", new PersistencePerspective());

    // Assert
    verify(adornedTargetCollectionMetadata).getExcluded();
    verify(metadata)
        .getFieldMetadataForTargetClass(
            isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
    assertTrue(actualSimpleMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String,
   * PersistencePerspective)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"
  })
  public void testGetSimpleMergedProperties_thenReturnEmpty() {
    // Arrange
    when(metadata.getFieldMetadataForTargetClass(
            Mockito.<Class<?>>any(),
            Mockito.<Class<?>>any(),
            Mockito.<DynamicEntityDao>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties =
        dynamicEntityDaoImpl.getSimpleMergedProperties(
            "java.lang.Boolean", new PersistencePerspective());

    // Assert
    verify(metadata)
        .getFieldMetadataForTargetClass(
            isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
    assertTrue(actualSimpleMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String,
   * PersistencePerspective)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"
  })
  public void testGetSimpleMergedProperties_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(metadata.getFieldMetadataForTargetClass(
            Mockito.<Class<?>>any(),
            Mockito.<Class<?>>any(),
            Mockito.<DynamicEntityDao>any(),
            Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.getSimpleMergedProperties(
                "java.lang.Boolean", new PersistencePerspective()));
    verify(metadata)
        .getFieldMetadataForTargetClass(
            isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   *
   * <ul>
   *   <li>When {@code Entity Name}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getSimpleMergedProperties(String,
   * PersistencePerspective)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getSimpleMergedProperties(String, PersistencePerspective)"
  })
  public void testGetSimpleMergedProperties_whenEntityName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dynamicEntityDaoImpl.getSimpleMergedProperties(
                "Entity Name", new PersistencePerspective()));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code
   * ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code
   * additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code
   * mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code
   * excludeFields}, {@code configurationKey}, {@code prefix}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[],
   * ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"
  })
  public void
      testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey()},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {"Include Fields"},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            "Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(false),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code
   * ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code
   * additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code
   * mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code
   * excludeFields}, {@code configurationKey}, {@code prefix}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[],
   * ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"
  })
  public void
      testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix2() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.getMergedProperties(
                "Dr Jane Doe",
                new Class[] {forNameResult},
                foreignField,
                new String[] {"Additional Non Persistent Properties"},
                new ForeignKey[] {new ForeignKey()},
                MergedPropertyType.PRIMARY,
                true,
                new String[] {"Include Fields"},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Prefix"));
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(false),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code
   * ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code
   * additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code
   * mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code
   * excludeFields}, {@code configurationKey}, {@code prefix}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[],
   * ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"
  })
  public void
      testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix3() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey()},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            "Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(false),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code
   * ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code
   * additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code
   * mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code
   * excludeFields}, {@code configurationKey}, {@code prefix}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[],
   * ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"
  })
  public void
      testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix4() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey()},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {},
            new String[] {},
            "Configuration Key",
            "Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(false),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code
   * ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code
   * additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code
   * mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code
   * excludeFields}, {@code configurationKey}, {@code prefix}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[],
   * ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"
  })
  public void
      testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix5() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Object> forNameResult = Object.class;

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey("Many To Field", "Foreign Key Class")},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {"Include Fields"},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            "Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(false),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code
   * ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code
   * additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code
   * mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code
   * excludeFields}, {@code configurationKey}, {@code prefix}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[],
   * ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"
  })
  public void
      testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix6() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Object> forNameResult = Object.class;

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            null,
            MergedPropertyType.PRIMARY,
            true,
            new String[] {"Include Fields"},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            "Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(false),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)} with {@code
   * ceilingEntityFullyQualifiedClassname}, {@code entities}, {@code foreignField}, {@code
   * additionalNonPersistentProperties}, {@code additionalForeignFields}, {@code
   * mergedPropertyType}, {@code populateManyToOneFields}, {@code includeFields}, {@code
   * excludeFields}, {@code configurationKey}, {@code prefix}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(String, Class[],
   * ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedProperties(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String)"
  })
  public void
      testGetMergedPropertiesWithCeilingEntityFullyQualifiedClassnameEntitiesForeignFieldAdditionalNonPersistentPropertiesAdditionalForeignFieldsMergedPropertyTypePopulateManyToOneFieldsIncludeFieldsExcludeFieldsConfigurationKeyPrefix7() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Object> forNameResult = Object.class;

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {foreignKey},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {"Include Fields"},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            "Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(false),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq(""),
            eq(false),
            eq("java.lang.Object"),
            isNull(),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setExcluded(true);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("42", adornedTargetCollectionMetadata2);
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq(""),
            eq(false),
            eq("java.lang.Object"),
            isNull(),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls3() {
    // Arrange
    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new DefaultFieldMetadataProvider());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> cls = Object.class;

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.getMergedProperties(cls).isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls4() {
    // Arrange
    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new MapFieldsFieldMetadataProvider());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> cls = Object.class;

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.getMergedProperties(cls).isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest,
   *       Map)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_thenCallsOverrideViaXml() {
    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider =
        mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.overrideViaXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(MetadataProviderResponse.HANDLED);
    doNothing()
        .when(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any());

    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(defaultFieldMetadataProvider)
        .overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    verify(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <ul>
   *   <li>Then {@code foo} return {@link AdornedTargetCollectionMetadata}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_thenFooReturnAdornedTargetCollectionMetadata() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq(""),
            eq(false),
            eq("java.lang.Object"),
            isNull(),
            isA(DynamicEntityDao.class));
    assertEquals(1, actualMergedProperties.size());
    FieldMetadata getResult = actualMergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertSame(adornedTargetCollectionMetadata, getResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <ul>
   *   <li>Then return containsKey {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_thenReturnContainsKeyFoo() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq(""),
            eq(false),
            eq("java.lang.Object"),
            isNull(),
            isA(DynamicEntityDao.class));
    assertEquals(1, actualMergedProperties.size());
    assertTrue(actualMergedProperties.containsKey("foo"));
    assertSame(stringFieldMetadataMap, actualMergedProperties);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_thenReturnEmpty() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> cls = Object.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq(""),
            eq(false),
            eq("java.lang.Object"),
            isNull(),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class, () -> dynamicEntityDaoImpl.getMergedProperties(cls));
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq(""),
            eq(false),
            eq("java.lang.Object"),
            isNull(),
            isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedProperties(Class)} with {@code cls}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedProperties(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getMergedProperties(Class)"})
  public void testGetMergedPropertiesWithCls_whenJavaLangBoolean() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Boolean> cls = Boolean.class;

    // Act
    Map<String, FieldMetadata> actualMergedProperties =
        dynamicEntityDaoImpl.getMergedProperties(cls);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq(""),
            eq(false),
            eq("java.lang.Boolean"),
            isNull(),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedProperties.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String,
   * Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[],
   * String, List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"
  })
  public void testGetMergedPropertiesRecursively_givenJavaLangObject_whenArrayListAddObject() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively =
        dynamicEntityDaoImpl.getMergedPropertiesRecursively(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey()},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {"Include Fields"},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            parentClasses,
            "Prefix",
            true,
            "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedPropertiesRecursively.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String,
   * Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[],
   * String, List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"
  })
  public void testGetMergedPropertiesRecursively_givenJavaLangObject_whenArrayListAddObject2() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);
    Class<Object> forNameResult3 = Object.class;
    parentClasses.add(forNameResult3);

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively =
        dynamicEntityDaoImpl.getMergedPropertiesRecursively(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey()},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {"Include Fields"},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            parentClasses,
            "Prefix",
            true,
            "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedPropertiesRecursively.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>Then return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String,
   * Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[],
   * String, List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"
  })
  public void testGetMergedPropertiesRecursively_thenReturnHashMap() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    Class<Object> forNameResult = Object.class;

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively =
        dynamicEntityDaoImpl.getMergedPropertiesRecursively(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey("Many To Field", "Foreign Key Class")},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {"Include Fields"},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            new ArrayList<>(),
            "Prefix",
            true,
            "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertSame(stringFieldMetadataMap, actualMergedPropertiesRecursively);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String,
   * Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[],
   * String, List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"
  })
  public void testGetMergedPropertiesRecursively_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.getMergedPropertiesRecursively(
                "Dr Jane Doe",
                new Class[] {forNameResult},
                foreignField,
                new String[] {"Additional Non Persistent Properties"},
                new ForeignKey[] {new ForeignKey()},
                MergedPropertyType.PRIMARY,
                true,
                new String[] {"Include Fields"},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                new ArrayList<>(),
                "Prefix",
                true,
                "Parent Prefix"));
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String,
   * Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[],
   * String, List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"
  })
  public void testGetMergedPropertiesRecursively_whenEmptyArrayOfString_thenReturnEmpty() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively =
        dynamicEntityDaoImpl.getMergedPropertiesRecursively(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey()},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            new ArrayList<>(),
            "Prefix",
            true,
            "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedPropertiesRecursively.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String,
   * Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[],
   * String, List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"
  })
  public void testGetMergedPropertiesRecursively_whenEmptyArrayOfString_thenReturnEmpty2() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively =
        dynamicEntityDaoImpl.getMergedPropertiesRecursively(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey()},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {},
            new String[] {},
            "Configuration Key",
            new ArrayList<>(),
            "Prefix",
            true,
            "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedPropertiesRecursively.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String, Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>When {@link ForeignKey#ForeignKey()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getMergedPropertiesRecursively(String,
   * Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[],
   * String, List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getMergedPropertiesRecursively(String, Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, List, String, Boolean, String)"
  })
  public void testGetMergedPropertiesRecursively_whenForeignKey_thenReturnEmpty() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act
    Map<String, FieldMetadata> actualMergedPropertiesRecursively =
        dynamicEntityDaoImpl.getMergedPropertiesRecursively(
            "Dr Jane Doe",
            new Class[] {forNameResult},
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey()},
            MergedPropertyType.PRIMARY,
            true,
            new String[] {"Include Fields"},
            new String[] {"Exclude Fields"},
            "Configuration Key",
            new ArrayList<>(),
            "Prefix",
            true,
            "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("Prefix"),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertTrue(actualMergedPropertiesRecursively.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence() {
    // Arrange
    ForeignKey foreignField = new ForeignKey("foo", "foo");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField, new ForeignKey[] {new ForeignKey()}, mergedProperties);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertFalse(getResult.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence2() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField,
        new ForeignKey[] {new ForeignKey("Many To Field", "Many To Field")},
        mergedProperties);

    // Assert that nothing has changed
    verify(foreignField).getManyToField();
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <ul>
   *   <li>Given {@code Many To Field}.
   *   <li>When {@code null}.
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
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
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#setExcluded(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence_thenCallsSetExcluded() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("foo");

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField, new ForeignKey[] {foreignKey}, mergedProperties);

    // Assert
    verify(adornedTargetCollectionMetadata).setExcluded(false);
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <ul>
   *   <li>Then not {@link HashMap#HashMap()} {@code foo} Excluded.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence_thenNotHashMapFooExcluded() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("foo");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField, new ForeignKey[] {foreignKey}, mergedProperties);

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
   *
   * <ul>
   *   <li>When array of {@link ForeignKey} with {@link ForeignKey}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence_whenArrayOfForeignKeyWithForeignKey() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField, new ForeignKey[] {foreignKey}, mergedProperties);

    // Assert that nothing has changed
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean,
   * Map)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#setExcluded(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[],
   * String, Boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"
  })
  public void testApplyIncludesAndExcludes_thenCallsSetExcluded() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Prefix",
        true,
        mergedProperties);

    // Assert
    verify(adornedTargetCollectionMetadata).setExcluded(true);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean,
   * Map)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#setExcluded(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[],
   * String, Boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"
  })
  public void testApplyIncludesAndExcludes_thenCallsSetExcluded2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(
        new String[] {}, new String[] {"Prefixfoo"}, "Prefix", true, mergedProperties);

    // Assert
    verify(adornedTargetCollectionMetadata).setExcluded(true);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean,
   * Map)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code foo} Excluded.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[],
   * String, Boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"
  })
  public void testApplyIncludesAndExcludes_thenHashMapFooExcluded() {
    // Arrange
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Prefix",
        true,
        mergedProperties);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertTrue(getResult.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean,
   * Map)}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Prefixfoo}.
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[],
   * String, Boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"
  })
  public void testApplyIncludesAndExcludes_whenArrayOfStringWithPrefixfoo_thenHashMapSizeIsOne() {
    // Arrange
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(
        new String[] {"Prefixfoo"},
        new String[] {"Exclude Fields"},
        "Prefix",
        true,
        mergedProperties);

    // Assert that nothing has changed
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#pad(String, int, char)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code AAA}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#pad(String, int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicEntityDaoImpl.pad(String, int, char)"})
  public void testPad_whenEmptyString_thenReturnAaa() {
    // Arrange, Act and Assert
    assertEquals("AAA", dynamicEntityDaoImpl.pad("", 3, 'A'));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#pad(String, int, char)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#pad(String, int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicEntityDaoImpl.pad(String, int, char)"})
  public void testPad_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", dynamicEntityDaoImpl.pad("foo", 3, 'A'));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[],
   * MergedPropertyType, Boolean, Class, String, Boolean)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code 06d6dd3d151167faaeb6f06fc514db43}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DynamicEntityDaoImpl.getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)"
  })
  public void testGetCacheKey_givenTrue_thenReturn06d6dd3d151167faaeb6f06fc514db43() {
    // Arrange
    ForeignKey foreignField = new ForeignKey();

    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setSortAscending(true);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        "06d6dd3d151167faaeb6f06fc514db43",
        dynamicEntityDaoImpl.getCacheKey(
            "Dr Jane Doe",
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {foreignKey},
            MergedPropertyType.PRIMARY,
            true,
            clazz,
            "Configuration Key",
            true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[],
   * MergedPropertyType, Boolean, Class, String, Boolean)}.
   *
   * <ul>
   *   <li>Then return {@code cfdfd72e475f900ae49ce08efe7d93fb}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DynamicEntityDaoImpl.getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)"
  })
  public void testGetCacheKey_thenReturnCfdfd72e475f900ae49ce08efe7d93fb() {
    // Arrange
    ForeignKey foreignField = new ForeignKey();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        "cfdfd72e475f900ae49ce08efe7d93fb",
        dynamicEntityDaoImpl.getCacheKey(
            "Dr Jane Doe",
            foreignField,
            new String[] {"Additional Non Persistent Properties"},
            new ForeignKey[] {new ForeignKey()},
            MergedPropertyType.PRIMARY,
            true,
            clazz,
            "Configuration Key",
            true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[], ForeignKey[],
   * MergedPropertyType, Boolean, Class, String, Boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 83d7638ab51bce26f4ff6b4a29ddf077}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getCacheKey(String, ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DynamicEntityDaoImpl.getCacheKey(String, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, Class, String, Boolean)"
  })
  public void testGetCacheKey_whenNull_thenReturn83d7638ab51bce26f4ff6b4a29ddf077() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        "83d7638ab51bce26f4ff6b4a29ddf077",
        dynamicEntityDaoImpl.getCacheKey(
            "Dr Jane Doe",
            null,
            null,
            null,
            MergedPropertyType.PRIMARY,
            true,
            clazz,
            "Configuration Key",
            true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildPropertiesFromPolymorphicEntities(Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, Map,
   * List, String, Boolean, String)}.
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#buildPropertiesFromPolymorphicEntities(Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, Map, List,
   * String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildPropertiesFromPolymorphicEntities(Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, Map, List, String, Boolean, String)"
  })
  public void testBuildPropertiesFromPolymorphicEntities() {
    // Arrange
    when(metadata.getFieldMetadataForTargetClass(
            Mockito.<Class<?>>any(),
            Mockito.<Class<?>>any(),
            Mockito.<DynamicEntityDao>any(),
            Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("ForeignKey{"));
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.buildPropertiesFromPolymorphicEntities(
                new Class[] {forNameResult},
                foreignField,
                new String[] {"Additional Non Persistent Properties"},
                new ForeignKey[] {new ForeignKey()},
                MergedPropertyType.PRIMARY,
                true,
                new String[] {"Include Fields"},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Dr Jane Doe",
                mergedProperties,
                new ArrayList<>(),
                "Prefix",
                true,
                "Parent Prefix"));
    verify(metadata)
        .getFieldMetadataForTargetClass(
            isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue() {
    // Arrange
    BasicFieldMetadata value = mock(BasicFieldMetadata.class);
    when(value.getDefaultValue()).thenReturn("not empty");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert
    verify(value, atLeast(1)).getDefaultValue();
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link BasicFieldMetadata} (default constructor) DefaultValue is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_thenBasicFieldMetadataDefaultValueIsEmptyString() {
    // Arrange
    BasicFieldMetadata value = new BasicFieldMetadata();
    value.setDefaultValue("");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert that nothing has changed
    assertEquals("", value.getDefaultValue());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Then {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_thenBasicFieldMetadataDefaultValueIsNotEmpty() {
    // Arrange
    BasicFieldMetadata value = new BasicFieldMetadata();
    value.setDefaultValue("not empty");

    // Act
    dynamicEntityDaoImpl.refreshDecimalDefaultValue(value);

    // Assert that nothing has changed
    assertEquals("not empty", value.getDefaultValue());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Then {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.refreshDecimalDefaultValue(BasicFieldMetadata)"})
  public void testRefreshDecimalDefaultValue_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    BasicFieldMetadata value = mock(BasicFieldMetadata.class);
    doThrow(new NoSuchBeanDefinitionException("."))
        .when(value)
        .setDefaultValue(Mockito.<String>any());
    when(value.getDefaultValue()).thenReturn(",");

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.refreshDecimalDefaultValue(value));
    verify(value, atLeast(1)).getDefaultValue();
    verify(value).setDefaultValue(".");
  }

  /**
   * Test {@link DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#setDefaultValue(String)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#refreshDecimalDefaultValue(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    verify(value).setDefaultValue(".");
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getAllFields(Class)}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then return second element Name is {@code FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllFields(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertEquals(
        "private static final long java.lang.Boolean.serialVersionUID", field5.toGenericString());
    assertEquals(
        "public static final java.lang.Boolean java.lang.Boolean.FALSE", field.toGenericString());
    assertEquals(
        "public static final java.lang.Boolean java.lang.Boolean.TRUE", field2.toGenericString());
    assertEquals(
        "public static final java.lang.Class<java.lang.Boolean> java.lang.Boolean.TYPE",
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
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getAllFields(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Field[] DynamicEntityDaoImpl.getAllFields(Class)"})
  public void testGetAllFields_whenJavaLangObject_thenReturnArrayLengthIsZero() {
    // Arrange
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getAllFields(targetClass).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertiesForPrimitiveClass(String, String, Class, Class,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Then {@code Property Name} return {@link BasicFieldMetadata}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPropertiesForPrimitiveClass(String,
   * String, Class, Class, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getPropertiesForPrimitiveClass(String, String, Class, Class, MergedPropertyType)"
  })
  public void testGetPropertiesForPrimitiveClass_thenPropertyNameReturnBasicFieldMetadata() {
    // Arrange
    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(new AdornedTargetCollectionFieldMetadataProvider());

    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new AdornedTargetCollectionFieldMetadataProvider());
    metadata.setFieldMetadataProviders(fieldMetadataProviders);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Boolean> targetClass = Boolean.class;
    Class<Object> parentClass = Object.class;

    // Act
    Map<String, FieldMetadata> actualPropertiesForPrimitiveClass =
        dynamicEntityDaoImpl.getPropertiesForPrimitiveClass(
            "Property Name",
            "Friendly Property Name",
            targetClass,
            parentClass,
            MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, actualPropertiesForPrimitiveClass.size());
    FieldMetadata getResult = actualPropertiesForPrimitiveClass.get("Property Name");
    assertTrue(getResult instanceof BasicFieldMetadata);
    assertEquals("Friendly Property Name", getResult.getFriendlyName());
    assertEquals("Property Name", getResult.getFieldName());
    assertEquals("java.lang.Object", getResult.getInheritedFromType());
    assertEquals("java.lang.Object", getResult.getTargetClass());
    assertEquals(
        SupportedFieldType.BOOLEAN, ((BasicFieldMetadata) getResult).getExplicitFieldType());
    assertEquals(VisibilityEnum.VISIBLE_ALL, ((BasicFieldMetadata) getResult).getVisibility());
    assertArrayEquals(new String[] {"java.lang.Object"}, getResult.getAvailableToTypes());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertiesForPrimitiveClass(String, String, Class, Class,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Then return containsKey {@code Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPropertiesForPrimitiveClass(String,
   * String, Class, Class, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getPropertiesForPrimitiveClass(String, String, Class, Class, MergedPropertyType)"
  })
  public void testGetPropertiesForPrimitiveClass_thenReturnContainsKeyPropertyName() {
    // Arrange
    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(new AdornedTargetCollectionFieldMetadataProvider());

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doNothing().when(basicFieldMetadata).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(basicFieldMetadata).setLength(Mockito.<Integer>any());
    doNothing().when(basicFieldMetadata).setPrecision(Mockito.<Integer>any());
    doNothing().when(basicFieldMetadata).setRequired(Mockito.<Boolean>any());
    doNothing().when(basicFieldMetadata).setScale(Mockito.<Integer>any());
    doNothing().when(basicFieldMetadata).setUnique(Mockito.<Boolean>any());

    Metadata metadata = mock(Metadata.class);
    when(metadata.getFieldMetadata(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Property>>any(),
            Mockito.<SupportedFieldType>any(),
            Mockito.<Type>any(),
            Mockito.<Class<?>>any(),
            Mockito.<FieldMetadata>any(),
            Mockito.<MergedPropertyType>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(basicFieldMetadata);
    doNothing()
        .when(metadata)
        .setFieldMetadataProviders(Mockito.<List<FieldMetadataProvider>>any());
    metadata.setFieldMetadataProviders(fieldMetadataProviders);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Boolean> targetClass = Boolean.class;
    Class<Object> parentClass = Object.class;

    // Act
    Map<String, FieldMetadata> actualPropertiesForPrimitiveClass =
        dynamicEntityDaoImpl.getPropertiesForPrimitiveClass(
            "Property Name",
            "Friendly Property Name",
            targetClass,
            parentClass,
            MergedPropertyType.PRIMARY);

    // Assert
    verify(basicFieldMetadata).setForeignKeyCollection(false);
    verify(basicFieldMetadata).setLength(255);
    verify(basicFieldMetadata).setPrecision(100);
    verify(basicFieldMetadata).setRequired(true);
    verify(basicFieldMetadata).setScale(100);
    verify(basicFieldMetadata).setUnique(true);
    verify(metadata)
        .getFieldMetadata(
            eq(""),
            eq("Property Name"),
            isNull(),
            eq(SupportedFieldType.BOOLEAN),
            isNull(),
            isA(Class.class),
            isA(FieldMetadata.class),
            eq(MergedPropertyType.PRIMARY),
            isA(DynamicEntityDao.class));
    verify(metadata).setFieldMetadataProviders(isA(List.class));
    assertEquals(1, actualPropertiesForPrimitiveClass.size());
    assertTrue(actualPropertiesForPrimitiveClass.containsKey("Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertiesForPrimitiveClass(String, String, Class, Class,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Then return {@code Property Name} is {@link BasicFieldMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPropertiesForPrimitiveClass(String,
   * String, Class, Class, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getPropertiesForPrimitiveClass(String, String, Class, Class, MergedPropertyType)"
  })
  public void testGetPropertiesForPrimitiveClass_thenReturnPropertyNameIsBasicFieldMetadata() {
    // Arrange
    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(new AdornedTargetCollectionFieldMetadataProvider());

    Metadata metadata = mock(Metadata.class);
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    when(metadata.getFieldMetadata(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Property>>any(),
            Mockito.<SupportedFieldType>any(),
            Mockito.<Type>any(),
            Mockito.<Class<?>>any(),
            Mockito.<FieldMetadata>any(),
            Mockito.<MergedPropertyType>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(basicFieldMetadata);
    doNothing()
        .when(metadata)
        .setFieldMetadataProviders(Mockito.<List<FieldMetadataProvider>>any());
    metadata.setFieldMetadataProviders(fieldMetadataProviders);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Boolean> targetClass = Boolean.class;
    Class<Object> parentClass = Object.class;

    // Act
    Map<String, FieldMetadata> actualPropertiesForPrimitiveClass =
        dynamicEntityDaoImpl.getPropertiesForPrimitiveClass(
            "Property Name",
            "Friendly Property Name",
            targetClass,
            parentClass,
            MergedPropertyType.PRIMARY);

    // Assert
    verify(metadata)
        .getFieldMetadata(
            eq(""),
            eq("Property Name"),
            isNull(),
            eq(SupportedFieldType.BOOLEAN),
            isNull(),
            isA(Class.class),
            isA(FieldMetadata.class),
            eq(MergedPropertyType.PRIMARY),
            isA(DynamicEntityDao.class));
    verify(metadata).setFieldMetadataProviders(isA(List.class));
    assertEquals(1, actualPropertiesForPrimitiveClass.size());
    assertSame(basicFieldMetadata, actualPropertiesForPrimitiveClass.get("Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertiesForPrimitiveClass(String, String, Class, Class,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>When {@code Byte}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPropertiesForPrimitiveClass(String,
   * String, Class, Class, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getPropertiesForPrimitiveClass(String, String, Class, Class, MergedPropertyType)"
  })
  public void testGetPropertiesForPrimitiveClass_whenJavaLangByte() {
    // Arrange
    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(new AdornedTargetCollectionFieldMetadataProvider());

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doNothing().when(basicFieldMetadata).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(basicFieldMetadata).setLength(Mockito.<Integer>any());
    doNothing().when(basicFieldMetadata).setPrecision(Mockito.<Integer>any());
    doNothing().when(basicFieldMetadata).setRequired(Mockito.<Boolean>any());
    doNothing().when(basicFieldMetadata).setScale(Mockito.<Integer>any());
    doNothing().when(basicFieldMetadata).setUnique(Mockito.<Boolean>any());

    Metadata metadata = mock(Metadata.class);
    when(metadata.getFieldMetadata(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Property>>any(),
            Mockito.<SupportedFieldType>any(),
            Mockito.<Type>any(),
            Mockito.<Class<?>>any(),
            Mockito.<FieldMetadata>any(),
            Mockito.<MergedPropertyType>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(basicFieldMetadata);
    doNothing()
        .when(metadata)
        .setFieldMetadataProviders(Mockito.<List<FieldMetadataProvider>>any());
    metadata.setFieldMetadataProviders(fieldMetadataProviders);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    Class<Byte> targetClass = Byte.class;
    Class<Object> parentClass = Object.class;

    // Act
    Map<String, FieldMetadata> actualPropertiesForPrimitiveClass =
        dynamicEntityDaoImpl.getPropertiesForPrimitiveClass(
            "Property Name",
            "Friendly Property Name",
            targetClass,
            parentClass,
            MergedPropertyType.PRIMARY);

    // Assert
    verify(basicFieldMetadata).setForeignKeyCollection(false);
    verify(basicFieldMetadata).setLength(255);
    verify(basicFieldMetadata).setPrecision(100);
    verify(basicFieldMetadata).setRequired(true);
    verify(basicFieldMetadata).setScale(100);
    verify(basicFieldMetadata).setUnique(true);
    verify(metadata)
        .getFieldMetadata(
            eq(""),
            eq("Property Name"),
            isNull(),
            eq(SupportedFieldType.INTEGER),
            isNull(),
            isA(Class.class),
            isA(FieldMetadata.class),
            eq(MergedPropertyType.PRIMARY),
            isA(DynamicEntityDao.class));
    verify(metadata).setFieldMetadataProviders(isA(List.class));
    assertEquals(1, actualPropertiesForPrimitiveClass.size());
    assertTrue(actualPropertiesForPrimitiveClass.containsKey("Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getIdMetadata(Class)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getIdMetadata(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getIdMetadata(Class)"})
  public void testGetIdMetadata_thenReturnEmpty() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.getIdMetadata(Mockito.<Class<?>>any(), Mockito.<EntityManager>any()))
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
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPropertyNames(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DynamicEntityDaoImpl.getPropertyNames(Class)"})
  public void testGetPropertyNames_givenDynamicEntityDaoImpl_thenReturnEmpty() {
    // Arrange
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.getPropertyNames(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertyNames(Class)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicDaoHelperImpl#getPropertyNames(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPropertyNames(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DynamicEntityDaoImpl.getPropertyNames(Class)"})
  public void testGetPropertyNames_thenCallsGetPropertyNames() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.getPropertyNames(Mockito.<Class<?>>any())).thenReturn(new ArrayList<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> entityClass = Object.class;

    // Act
    List<String> actualPropertyNames = dynamicEntityDaoImpl.getPropertyNames(entityClass);

    // Assert
    verify(dynamicDaoHelper).getPropertyNames(isA(Class.class));
    assertTrue(actualPropertyNames.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertyTypes(Class)}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPropertyTypes(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DynamicEntityDaoImpl.getPropertyTypes(Class)"})
  public void testGetPropertyTypes_givenDynamicEntityDaoImpl_thenReturnEmpty() {
    // Arrange
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.getPropertyTypes(entityClass).isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertyTypes(Class)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicDaoHelperImpl#getPropertyTypes(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPropertyTypes(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DynamicEntityDaoImpl.getPropertyTypes(Class)"})
  public void testGetPropertyTypes_thenCallsGetPropertyTypes() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.getPropertyTypes(Mockito.<Class<?>>any())).thenReturn(new ArrayList<>());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> entityClass = Object.class;

    // Act
    List<Type> actualPropertyTypes = dynamicEntityDaoImpl.getPropertyTypes(entityClass);

    // Assert
    verify(dynamicDaoHelper).getPropertyTypes(isA(Class.class));
    assertTrue(actualPropertyTypes.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getTabAndGroupMetadata(Class[], ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getTabAndGroupMetadata(Class[],
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getTabAndGroupMetadata(Class[], ClassMetadata)"})
  public void testGetTabAndGroupMetadata_thenReturnEmpty() {
    // Arrange
    when(metadata.getBaseTabAndGroupMetadata(Mockito.<Class<Object>[]>any()))
        .thenReturn(new HashMap<>());
    doNothing()
        .when(metadata)
        .applyTabAndGroupMetadataOverrides(
            Mockito.<Class<Object>[]>any(), Mockito.<Map<String, TabMetadata>>any());
    doNothing()
        .when(metadata)
        .buildAdditionalTabAndGroupMetadataFromCmdProperties(
            Mockito.<ClassMetadata>any(), Mockito.<Map<String, TabMetadata>>any());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(
        new org.broadleafcommerce.openadmin.dto.Property[] {
          new org.broadleafcommerce.openadmin.dto.Property()
        });
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, TabMetadata> actualTabAndGroupMetadata =
        dynamicEntityDaoImpl.getTabAndGroupMetadata(new Class[] {null}, cmd);

    // Assert
    verify(metadata).applyTabAndGroupMetadataOverrides(isA(Class[].class), isA(Map.class));
    verify(metadata)
        .buildAdditionalTabAndGroupMetadataFromCmdProperties(
            isA(ClassMetadata.class), isA(Map.class));
    verify(metadata).getBaseTabAndGroupMetadata(isA(Class[].class));
    assertTrue(actualTabAndGroupMetadata.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getTabAndGroupMetadata(Class[], ClassMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getTabAndGroupMetadata(Class[],
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DynamicEntityDaoImpl.getTabAndGroupMetadata(Class[], ClassMetadata)"})
  public void testGetTabAndGroupMetadata_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(metadata.getBaseTabAndGroupMetadata(Mockito.<Class<Object>[]>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(
        new org.broadleafcommerce.openadmin.dto.Property[] {
          new org.broadleafcommerce.openadmin.dto.Property()
        });
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.getTabAndGroupMetadata(new Class[] {null}, cmd));
    verify(metadata).getBaseTabAndGroupMetadata(isA(Class[].class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getSuperClassHierarchy(Class)"})
  public void testGetSuperClassHierarchy_whenJavaLangBoolean_thenReturnArrayLengthIsOne() {
    // Arrange
    Class<Boolean> ceilingEntity = Boolean.class;

    // Act
    Class<?>[] actualSuperClassHierarchy =
        dynamicEntityDaoImpl.getSuperClassHierarchy(ceilingEntity);

    // Assert
    assertEquals(1, actualSuperClassHierarchy.length);
    Class<Boolean> expectedResultClass = Boolean.class;
    assertEquals(expectedResultClass, actualSuperClassHierarchy[0]);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}.
   *
   * <ul>
   *   <li>When {@code Byte}.
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getSuperClassHierarchy(Class)"})
  public void testGetSuperClassHierarchy_whenJavaLangByte_thenReturnArrayLengthIsTwo() {
    // Arrange
    Class<Byte> ceilingEntity = Byte.class;

    // Act
    Class<?>[] actualSuperClassHierarchy =
        dynamicEntityDaoImpl.getSuperClassHierarchy(ceilingEntity);

    // Assert
    assertEquals(2, actualSuperClassHierarchy.length);
    Class<Byte> expectedResultClass = Byte.class;
    assertEquals(expectedResultClass, actualSuperClassHierarchy[0]);
    Class<Number> expectedResultClass2 = Number.class;
    assertEquals(expectedResultClass2, actualSuperClassHierarchy[1]);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getSuperClassHierarchy(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] DynamicEntityDaoImpl.getSuperClassHierarchy(Class)"})
  public void testGetSuperClassHierarchy_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, dynamicEntityDaoImpl.getSuperClassHierarchy(null).length);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getPropertiesForEntityClass(Class, ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, List, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getPropertiesForEntityClass(Class,
   * ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String,
   * String, List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DynamicEntityDaoImpl.getPropertiesForEntityClass(Class, ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, List, String, Boolean, String)"
  })
  public void testGetPropertiesForEntityClass_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(metadata.getFieldMetadataForTargetClass(
            Mockito.<Class<?>>any(),
            Mockito.<Class<?>>any(),
            Mockito.<DynamicEntityDao>any(),
            Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.getPropertiesForEntityClass(
                targetClass,
                foreignField,
                new String[] {"Additional Non Persistent Properties"},
                new ForeignKey[] {new ForeignKey()},
                MergedPropertyType.PRIMARY,
                true,
                new String[] {"Include Fields"},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Dr Jane Doe",
                new ArrayList<>(),
                "Prefix",
                true,
                "Parent Prefix"));
    verify(metadata)
        .getFieldMetadataForTargetClass(
            isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion() {
    // Arrange
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setExcluded(null);
    presentationAttribute.setChildrenExcluded(null);
    presentationAttribute.setShowIfProperty("");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    assertNull(presentationAttribute.getExcluded());
    assertTrue(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion2() {
    // Arrange
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setExcluded(null);
    presentationAttribute.setChildrenExcluded(true);
    presentationAttribute.setShowIfProperty("");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    assertNull(presentationAttribute.getExcluded());
    assertFalse(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion3() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);

    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setExcluded(null);
    presentationAttribute.setChildrenExcluded(false);
    presentationAttribute.setShowIfProperty("not empty");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map).get(isA(Object.class));
    assertNull(presentationAttribute.getExcluded());
    assertTrue(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion4() {
    // Arrange
    AdornedTargetCollectionMetadata presentationAttribute =
        mock(AdornedTargetCollectionMetadata.class);
    when(presentationAttribute.getChildrenExcluded()).thenReturn(null);
    when(presentationAttribute.getExcluded()).thenReturn(null);
    when(presentationAttribute.getShowIfProperty()).thenReturn("");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(presentationAttribute).getChildrenExcluded();
    verify(presentationAttribute).getExcluded();
    verify(presentationAttribute).getShowIfProperty();
    assertTrue(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion5() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");

    AdornedTargetCollectionMetadata presentationAttribute =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(presentationAttribute).setExcluded(Mockito.<Boolean>any());
    when(presentationAttribute.getChildrenExcluded()).thenReturn(true);
    when(presentationAttribute.getExcluded()).thenReturn(null);
    when(presentationAttribute.getShowIfProperty()).thenReturn("not empty");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(presentationAttribute, atLeast(1)).getChildrenExcluded();
    verify(presentationAttribute).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    verify(presentationAttribute).setExcluded(true);
    assertFalse(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion6() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");

    AdornedTargetCollectionMetadata presentationAttribute =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(presentationAttribute).setExcluded(Mockito.<Boolean>any());
    when(presentationAttribute.getExcluded()).thenReturn(true);
    when(presentationAttribute.getShowIfProperty()).thenReturn("not empty");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(presentationAttribute, atLeast(1)).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    verify(presentationAttribute).setExcluded(true);
    assertFalse(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_givenMapGetReturnNull() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);

    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setExcluded(null);
    presentationAttribute.setChildrenExcluded(null);
    presentationAttribute.setShowIfProperty("not empty");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map).get(isA(Object.class));
    assertNull(presentationAttribute.getExcluded());
    assertTrue(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <ul>
   *   <li>Then {@link AdornedTargetCollectionMetadata} (default constructor) Excluded.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_thenAdornedTargetCollectionMetadataExcluded() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");

    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setExcluded(null);
    presentationAttribute.setChildrenExcluded(null);
    presentationAttribute.setShowIfProperty("not empty");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    assertFalse(actualTestPropertyInclusionResult);
    assertTrue(presentationAttribute.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#getChildrenExcluded()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_thenCallsGetChildrenExcluded() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");

    AdornedTargetCollectionMetadata presentationAttribute =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(presentationAttribute).setExcluded(Mockito.<Boolean>any());
    when(presentationAttribute.getChildrenExcluded()).thenReturn(null);
    when(presentationAttribute.getExcluded()).thenReturn(null);
    when(presentationAttribute.getShowIfProperty()).thenReturn("not empty");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(presentationAttribute).getChildrenExcluded();
    verify(presentationAttribute).getExcluded();
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    verify(presentationAttribute).setExcluded(true);
    assertTrue(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <ul>
   *   <li>Then not {@link AdornedTargetCollectionMetadata} (default constructor) Excluded.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_thenNotAdornedTargetCollectionMetadataExcluded() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);

    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setExcluded(false);
    presentationAttribute.setChildrenExcluded(null);
    presentationAttribute.setShowIfProperty("not empty");

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    verify(map).get(isA(Object.class));
    assertFalse(presentationAttribute.getExcluded());
    assertTrue(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");

    AdornedTargetCollectionMetadata presentationAttribute =
        mock(AdornedTargetCollectionMetadata.class);
    doThrow(new NoSuchBeanDefinitionException("Name"))
        .when(presentationAttribute)
        .setExcluded(Mockito.<Boolean>any());
    when(presentationAttribute.getShowIfProperty()).thenReturn("not empty");

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute));
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(presentationAttribute, atLeast(1)).getShowIfProperty();
    verify(presentationAttribute).setExcluded(true);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_whenAdornedTargetCollectionMetadata() {
    // Arrange
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();

    // Act
    Boolean actualTestPropertyInclusionResult =
        dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute);

    // Assert
    assertNull(presentationAttribute.getExcluded());
    assertTrue(actualTestPropertyInclusionResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor) Excluded is {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_whenAdornedTargetCollectionMetadataExcludedIsTrue() {
    // Arrange
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setExcluded(true);
    presentationAttribute.setChildrenExcluded(null);
    presentationAttribute.setShowIfProperty("");

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.testPropertyInclusion(presentationAttribute));
    assertTrue(presentationAttribute.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyInclusion(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.testPropertyInclusion(FieldMetadata)"})
  public void testTestPropertyInclusion_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(dynamicEntityDaoImpl.testPropertyInclusion(null));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty() {
    // Arrange
    AdornedTargetCollectionMetadata fieldMetadata = new AdornedTargetCollectionMetadata();
    fieldMetadata.setShowIfProperty("");

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert that nothing has changed
    assertNull(fieldMetadata.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty2() {
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
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty3() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");

    AdornedTargetCollectionMetadata fieldMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(fieldMetadata).setExcluded(Mockito.<Boolean>any());
    when(fieldMetadata.getShowIfProperty()).thenReturn("not empty");

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(fieldMetadata, atLeast(1)).getShowIfProperty();
    verify(fieldMetadata).setExcluded(true);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty_givenMapGetReturnNull() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);

    AdornedTargetCollectionMetadata fieldMetadata = new AdornedTargetCollectionMetadata();
    fieldMetadata.setShowIfProperty("not empty");

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert that nothing has changed
    verify(map).get(isA(Object.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   *
   * <ul>
   *   <li>Then {@link AdornedTargetCollectionMetadata} (default constructor) Excluded.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty_thenAdornedTargetCollectionMetadataExcluded() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");

    AdornedTargetCollectionMetadata fieldMetadata = new AdornedTargetCollectionMetadata();
    fieldMetadata.setShowIfProperty("not empty");

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert
    verify(map, atLeast(1)).get(isA(Object.class));
    assertTrue(fieldMetadata.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn("Get");

    AdornedTargetCollectionMetadata fieldMetadata = mock(AdornedTargetCollectionMetadata.class);
    doThrow(new NoSuchBeanDefinitionException("Name"))
        .when(fieldMetadata)
        .setExcluded(Mockito.<Boolean>any());
    when(fieldMetadata.getShowIfProperty()).thenReturn("not empty");

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () -> dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata));
    verify(map, atLeast(1)).get(isA(Object.class));
    verify(fieldMetadata, atLeast(1)).getShowIfProperty();
    verify(fieldMetadata).setExcluded(true);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#setExcludedBasedOnShowIfProperty(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(FieldMetadata)"})
  public void testSetExcludedBasedOnShowIfProperty_whenAdornedTargetCollectionMetadata() {
    // Arrange
    AdornedTargetCollectionMetadata fieldMetadata = new AdornedTargetCollectionMetadata();

    // Act
    dynamicEntityDaoImpl.setExcludedBasedOnShowIfProperty(fieldMetadata);

    // Assert that nothing has changed
    assertNull(fieldMetadata.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String,
   * Class, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean DynamicEntityDaoImpl.testPropertyRecursion(String, List, String, Class, String, Boolean, String)"
  })
  public void testTestPropertyRecursion_givenJavaLangObject_whenEmptyString_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testPropertyRecursion(
            "", parentClasses, "Property Name", targetClass, "Dr Jane Doe", true, "Parent Prefix"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String,
   * Class, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean DynamicEntityDaoImpl.testPropertyRecursion(String, List, String, Class, String, Boolean, String)"
  })
  public void testTestPropertyRecursion_givenJavaLangObject_whenEmptyString_thenReturnFalse2() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testPropertyRecursion(
            "",
            parentClasses,
            "Property Name",
            targetClass,
            "Dr Jane Doe",
            false,
            "Parent Prefix"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String,
   * Class, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean DynamicEntityDaoImpl.testPropertyRecursion(String, List, String, Class, String, Boolean, String)"
  })
  public void testTestPropertyRecursion_givenJavaLangObject_whenNull_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testPropertyRecursion(
            null,
            parentClasses,
            "Property Name",
            targetClass,
            "Dr Jane Doe",
            true,
            "Parent Prefix"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String, Class, String,
   * Boolean, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testPropertyRecursion(String, List, String,
   * Class, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean DynamicEntityDaoImpl.testPropertyRecursion(String, List, String, Class, String, Boolean, String)"
  })
  public void testTestPropertyRecursion_whenArrayList_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testPropertyRecursion(
            "Prefix",
            parentClasses,
            "Property Name",
            targetClass,
            "Dr Jane Doe",
            true,
            "Parent Prefix"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String,
   * Boolean, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean DynamicEntityDaoImpl.testMultiLevelEmbeddableRecursion(String, Boolean, String, String)"
  })
  public void testTestMultiLevelEmbeddableRecursion_whenFalse() {
    // Arrange, Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testMultiLevelEmbeddableRecursion(
            "Prefix", false, "Parent Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String, Boolean, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testMultiLevelEmbeddableRecursion(String,
   * Boolean, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean DynamicEntityDaoImpl.testMultiLevelEmbeddableRecursion(String, Boolean, String, String)"
  })
  public void testTestMultiLevelEmbeddableRecursion_whenTrue() {
    // Arrange, Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testMultiLevelEmbeddableRecursion(
            "Prefix", true, "Parent Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class,
   * String, Boolean)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List,
   * String, Class, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean DynamicEntityDaoImpl.testStandardPropertyRecursion(String, List, String, Class, String, Boolean)"
  })
  public void testTestStandardPropertyRecursion_givenJavaLangObject_whenNull_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testStandardPropertyRecursion(
            null, parentClasses, "Property Name", targetClass, "Dr Jane Doe", true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class,
   * String, Boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List,
   * String, Class, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean DynamicEntityDaoImpl.testStandardPropertyRecursion(String, List, String, Class, String, Boolean)"
  })
  public void testTestStandardPropertyRecursion_whenArrayList_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testStandardPropertyRecursion(
            "Prefix", parentClasses, "Property Name", targetClass, "Dr Jane Doe", true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List, String, Class,
   * String, Boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testStandardPropertyRecursion(String, List,
   * String, Class, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean DynamicEntityDaoImpl.testStandardPropertyRecursion(String, List, String, Class, String, Boolean)"
  })
  public void testTestStandardPropertyRecursion_whenEmptyString_thenReturnFalse() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(
        dynamicEntityDaoImpl.testStandardPropertyRecursion(
            "", parentClasses, "Property Name", targetClass, "Dr Jane Doe", true));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class, Field)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class,
   * Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#determineExclusionForField(List, Class,
   * Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DynamicEntityDaoImpl.determineExclusionForField(List, Class, Field)"})
  public void testDetermineExclusionForField_whenArrayList() {
    // Arrange
    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.determineExclusionForField(parentClasses, targetClass, null));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[],
   * String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String,
   * String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       FieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey,
   * ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[],
   * String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"
  })
  public void testBuildBasicProperty_thenCallsAddMetadataFromFieldType() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromFieldType(
            Mockito.<AddMetadataFromFieldTypeRequest>any(),
            Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();

    // Act
    dynamicEntityDaoImpl.buildBasicProperty(
        null,
        targetClass,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        MergedPropertyType.PRIMARY,
        presentationAttributes,
        componentProperties,
        fields,
        "Id Property",
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        parentClasses,
        "Prefix",
        true,
        "Property Name",
        new BigDecimalType(),
        true,
        1,
        true,
        "Parent Prefix");

    // Assert
    verify(fieldMetadataProvider)
        .addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[],
   * String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String,
   * String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey,
   * ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[],
   * String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"
  })
  public void testBuildBasicProperty_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromFieldType(
            Mockito.<AddMetadataFromFieldTypeRequest>any(),
            Mockito.<Map<String, FieldMetadata>>any()))
        .thenThrow(new NoSuchBeanDefinitionException("\\."));
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.buildBasicProperty(
                null,
                targetClass,
                foreignField,
                new ForeignKey[] {new ForeignKey()},
                new String[] {"Additional Non Persistent Properties"},
                MergedPropertyType.PRIMARY,
                presentationAttributes,
                componentProperties,
                fields,
                "Id Property",
                true,
                new String[] {"Include Fields"},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Dr Jane Doe",
                parentClasses,
                "Prefix",
                true,
                "Property Name",
                new BigDecimalType(),
                true,
                1,
                true,
                "Parent Prefix"));
    verify(fieldMetadataProvider)
        .addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}.
   *
   * <ul>
   *   <li>Given {@code Many To Field}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicEntityDaoImpl.testForeignProperty(ForeignKey, String, String)"
  })
  public void testTestForeignProperty_givenManyToField() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    // Act
    boolean actualTestForeignPropertyResult =
        dynamicEntityDaoImpl.testForeignProperty(foreignField, "Prefix", "Property Name");

    // Assert
    verify(foreignField).getManyToField();
    assertFalse(actualTestForeignPropertyResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicEntityDaoImpl.testForeignProperty(ForeignKey, String, String)"
  })
  public void testTestForeignProperty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        dynamicEntityDaoImpl.testForeignProperty(
            new ForeignKey("PrefixProperty Name", "PrefixProperty Name"),
            "Prefix",
            "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#testForeignProperty(ForeignKey, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicEntityDaoImpl.testForeignProperty(ForeignKey, String, String)"
  })
  public void testTestForeignProperty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(dynamicEntityDaoImpl.testForeignProperty(null, "Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[],
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DynamicEntityDaoImpl.findAdditionalForeignKeyIndex(ForeignKey[], String, String)"
  })
  public void testFindAdditionalForeignKeyIndex() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        dynamicEntityDaoImpl.findAdditionalForeignKeyIndex(
            new ForeignKey[] {new ForeignKey("name", "name")}, "Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[],
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DynamicEntityDaoImpl.findAdditionalForeignKeyIndex(ForeignKey[], String, String)"
  })
  public void testFindAdditionalForeignKeyIndex2() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey("name", "name");
    ForeignKey foreignKey2 = new ForeignKey("name", "name");

    // Act and Assert
    assertEquals(
        -1,
        dynamicEntityDaoImpl.findAdditionalForeignKeyIndex(
            new ForeignKey[] {foreignKey, foreignKey2, new ForeignKey()},
            "Prefix",
            "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   *
   * <ul>
   *   <li>Given {@code Many To Field}.
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[],
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DynamicEntityDaoImpl.findAdditionalForeignKeyIndex(ForeignKey[], String, String)"
  })
  public void testFindAdditionalForeignKeyIndex_givenManyToField_thenReturnMinusTwo() {
    // Arrange
    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");

    // Act
    int actualFindAdditionalForeignKeyIndexResult =
        dynamicEntityDaoImpl.findAdditionalForeignKeyIndex(
            new ForeignKey[] {foreignKey}, "Prefix", "Property Name");

    // Assert
    verify(foreignKey).getManyToField();
    assertEquals(-2, actualFindAdditionalForeignKeyIndexResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   *
   * <ul>
   *   <li>When empty array of {@link ForeignKey}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[],
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DynamicEntityDaoImpl.findAdditionalForeignKeyIndex(ForeignKey[], String, String)"
  })
  public void testFindAdditionalForeignKeyIndex_whenEmptyArrayOfForeignKey_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        dynamicEntityDaoImpl.findAdditionalForeignKeyIndex(
            new ForeignKey[] {}, "Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[], String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#findAdditionalForeignKeyIndex(ForeignKey[],
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DynamicEntityDaoImpl.findAdditionalForeignKeyIndex(ForeignKey[], String, String)"
  })
  public void testFindAdditionalForeignKeyIndex_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(
        -1, dynamicEntityDaoImpl.findAdditionalForeignKeyIndex(null, "Prefix", "Property Name"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenThrow(new NoSuchBeanDefinitionException("Name"));
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.buildEntityProperties(
                fields,
                foreignField,
                new ForeignKey[] {new ForeignKey()},
                new String[] {"Additional Non Persistent Properties"},
                true,
                new String[] {"Include Fields"},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Dr Jane Doe",
                "Property Name",
                returnedClass,
                targetClass,
                new ArrayList<>(),
                "Prefix",
                true,
                "Parent Prefix"));
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties2() {
    // Arrange
    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new DefaultFieldMetadataProvider());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    assertTrue(fields.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties3() {
    // Arrange
    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new MapFieldsFieldMetadataProvider());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    assertTrue(fields.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties4() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey("Many To Field", "Foreign Key Class")},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertSame(adornedTargetCollectionMetadata, fields.get("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties5() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        null,
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertSame(adornedTargetCollectionMetadata, fields.get("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties6() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertSame(adornedTargetCollectionMetadata, fields.get("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties7() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        null,
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertSame(adornedTargetCollectionMetadata, fields.get("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties8() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("Many To Field", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {mock(ForeignKey.class)},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    FieldMetadata getResult = fields.get("Property Name.Many To Field");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertSame(adornedTargetCollectionMetadata, getResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties9() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doThrow(new NoSuchBeanDefinitionException("."))
        .when(adornedTargetCollectionMetadata)
        .setInheritedFromType(Mockito.<String>any());

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.buildEntityProperties(
                fields,
                foreignField,
                new ForeignKey[] {foreignKey},
                new String[] {"Additional Non Persistent Properties"},
                true,
                new String[] {},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Dr Jane Doe",
                "Property Name",
                returnedClass,
                targetClass,
                new ArrayList<>(),
                "Prefix",
                true,
                "Parent Prefix"));
    verify(adornedTargetCollectionMetadata).setInheritedFromType("java.lang.Object");
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Given Bean Name{blMetadata} {@link Metadata#overrideMetadata(Class[], PropertyBuilder,
   *       String, Boolean, String, String, DynamicEntityDao)} return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_givenBeanNameBlMetadataOverrideMetadataReturnHashMap() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ForeignKey} {@link ForeignKey#getManyToField()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_givenFoo_whenForeignKeyGetManyToFieldReturnFoo() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setAvailableToTypes(Mockito.<String[]>any());
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());
    doNothing().when(adornedTargetCollectionMetadata).setInheritedFromType(Mockito.<String>any());

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("foo");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(adornedTargetCollectionMetadata).setAvailableToTypes(isA(String[].class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).setExcluded(Mockito.<Boolean>any());
    verify(adornedTargetCollectionMetadata).setInheritedFromType("java.lang.Object");
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_givenJavaLangObject_thenArrayListSizeIsOne() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        parentClasses,
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertEquals(1, parentClasses.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, parentClasses.get(0));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_givenJavaLangObject_thenArrayListSizeIsTwo() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
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
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        parentClasses,
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    assertEquals(2, parentClasses.size());
    Class<Object> expectedGetResult = Object.class;
    assertEquals(expectedGetResult, parentClasses.get(0));
    assertSame(forNameResult2, parentClasses.get(1));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest,
   *       Map)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_thenCallsOverrideViaXml() {
    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider =
        mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.overrideViaXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(MetadataProviderResponse.HANDLED);
    doNothing()
        .when(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any());

    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    verify(defaultFieldMetadataProvider)
        .overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    verify(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(fields.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} containsKey {@code Property Name.foo}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_thenHashMapContainsKeyPropertyNameFoo() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setAvailableToTypes(Mockito.<String[]>any());
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());
    doNothing().when(adornedTargetCollectionMetadata).setInheritedFromType(Mockito.<String>any());

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(adornedTargetCollectionMetadata).setAvailableToTypes(isA(String[].class));
    verify(adornedTargetCollectionMetadata).setExcluded(true);
    verify(adornedTargetCollectionMetadata).setInheritedFromType("java.lang.Object");
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} containsKey {@code Property Name.Many To Field}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_thenHashMapContainsKeyPropertyNameManyToField() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setAvailableToTypes(Mockito.<String[]>any());
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());
    doNothing().when(adornedTargetCollectionMetadata).setInheritedFromType(Mockito.<String>any());

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("Many To Field", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {mock(ForeignKey.class)},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(adornedTargetCollectionMetadata).setAvailableToTypes(isA(String[].class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).setExcluded(Mockito.<Boolean>any());
    verify(adornedTargetCollectionMetadata).setInheritedFromType("java.lang.Object");
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("Property Name.Many To Field"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Property Name.foo} {@link BasicFieldMetadata}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_thenHashMapPropertyNameFooBasicFieldMetadata() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    stringFieldMetadataMap.put("foo", basicFieldMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    FieldMetadata getResult = fields.get("Property Name.foo");
    assertTrue(getResult instanceof BasicFieldMetadata);
    assertSame(basicFieldMetadata, getResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code PrefixProperty Name.foo}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_whenArrayOfStringWithPrefixPropertyNameFoo() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setAvailableToTypes(Mockito.<String[]>any());
    doNothing().when(adornedTargetCollectionMetadata).setInheritedFromType(Mockito.<String>any());

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"PrefixProperty Name.foo"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(adornedTargetCollectionMetadata).setAvailableToTypes(isA(String[].class));
    verify(adornedTargetCollectionMetadata).setInheritedFromType("java.lang.Object");
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_whenEmptyArrayOfString() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_whenJavaLangBoolean_thenHashMapEmpty() {
    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Boolean> returnedClass = Boolean.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertTrue(fields.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code ADORNEDTARGETLIST} is {@link
   *       AdornedTargetList#AdornedTargetList()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isForeignKey(FieldMetadata)"})
  public void testIsForeignKey_givenHashMapAdornedtargetlistIsAdornedTargetList() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    doNothing()
        .when(persistencePerspective)
        .setPersistencePerspectiveItems(
            Mockito.<Map<PersistencePerspectiveItemType, PersistencePerspectiveItem>>any());
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    BasicCollectionMetadata fieldMetadata = new BasicCollectionMetadata();
    fieldMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    boolean actualIsForeignKeyResult = dynamicEntityDaoImpl.isForeignKey(fieldMetadata);

    // Assert
    verify(persistencePerspective, atLeast(1)).getPersistencePerspectiveItems();
    verify(persistencePerspective).setPersistencePerspectiveItems(isA(Map.class));
    assertFalse(actualIsForeignKeyResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getPersistencePerspectiveItems()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isForeignKey(FieldMetadata)"})
  public void testIsForeignKey_thenCallsGetPersistencePerspectiveItems() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems()).thenReturn(new HashMap<>());
    doNothing()
        .when(persistencePerspective)
        .setPersistencePerspectiveItems(
            Mockito.<Map<PersistencePerspectiveItemType, PersistencePerspectiveItem>>any());
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    BasicCollectionMetadata fieldMetadata = new BasicCollectionMetadata();
    fieldMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    boolean actualIsForeignKeyResult = dynamicEntityDaoImpl.isForeignKey(fieldMetadata);

    // Assert
    verify(persistencePerspective).getPersistencePerspectiveItems();
    verify(persistencePerspective).setPersistencePerspectiveItems(isA(Map.class));
    assertFalse(actualIsForeignKeyResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isForeignKey(FieldMetadata)"})
  public void testIsForeignKey_thenReturnTrue() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    BasicCollectionMetadata fieldMetadata = new BasicCollectionMetadata();
    fieldMetadata.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertTrue(dynamicEntityDaoImpl.isForeignKey(fieldMetadata));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#isForeignKey(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isForeignKey(FieldMetadata)"})
  public void testIsForeignKey_whenAdornedTargetCollectionMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(dynamicEntityDaoImpl.isForeignKey(new AdornedTargetCollectionMetadata()));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setOriginatingFieldForForeignKey(String, String,
   * FieldMetadata)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#setOriginatingFieldForForeignKey(String,
   * String, FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.setOriginatingFieldForForeignKey(String, String, FieldMetadata)"
  })
  public void testSetOriginatingFieldForForeignKey() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new ForeignKey());
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    BasicCollectionMetadata fieldMetadata = new BasicCollectionMetadata();
    fieldMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    dynamicEntityDaoImpl.setOriginatingFieldForForeignKey("Property Name", "Key", fieldMetadata);

    // Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems2 =
        fieldMetadata.getPersistencePerspective().getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems2.size());
    PersistencePerspectiveItem getResult =
        persistencePerspectiveItems2.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult instanceof ForeignKey);
    assertEquals("Property Name.Key", ((ForeignKey) getResult).getOriginatingField());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#setStandardEntityManager(EntityManager)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link DynamicEntityDaoImpl} {@link DynamicEntityDaoImpl#fieldManager}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#setStandardEntityManager(EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.setStandardEntityManager(EntityManager)"})
  public void testSetStandardEntityManager_whenNull_thenDynamicEntityDaoImplFieldManager() {
    // Arrange and Act
    dynamicEntityDaoImpl.setStandardEntityManager(null);

    // Assert
    FieldManager expectedFieldManager = dynamicEntityDaoImpl.fieldManager;
    assertSame(expectedFieldManager, dynamicEntityDaoImpl.getFieldManager());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getFieldManager()}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getFieldManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldManager DynamicEntityDaoImpl.getFieldManager()"})
  public void testGetFieldManager() {
    // Arrange and Act
    FieldManager actualFieldManager = dynamicEntityDaoImpl.getFieldManager();

    // Assert
    assertSame(dynamicEntityDaoImpl.fieldManager, actualFieldManager);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#getFieldManager(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#getFieldManager(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldMetadataProvider DynamicEntityDaoImpl.getDefaultFieldMetadataProvider()",
    "DynamicDaoHelper DynamicEntityDaoImpl.getDynamicDaoHelper()",
    "EntityConfiguration DynamicEntityDaoImpl.getEntityConfiguration()",
    "List DynamicEntityDaoImpl.getFieldMetadataProviders()",
    "Metadata DynamicEntityDaoImpl.getMetadata()",
    "EntityManager DynamicEntityDaoImpl.getStandardEntityManager()",
    "void DynamicEntityDaoImpl.setApplicationContext(ApplicationContext)",
    "void DynamicEntityDaoImpl.setDefaultFieldMetadataProvider(FieldMetadataProvider)",
    "void DynamicEntityDaoImpl.setDynamicDaoHelper(DynamicDaoHelper)",
    "void DynamicEntityDaoImpl.setEntityConfiguration(EntityConfiguration)",
    "void DynamicEntityDaoImpl.setFieldMetadataProviders(List)",
    "void DynamicEntityDaoImpl.setMetadata(Metadata)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act
    dynamicEntityDaoImpl.setApplicationContext(mock(ApplicationContext.class));
    AdornedTargetCollectionFieldMetadataProvider defaultFieldMetadataProvider =
        new AdornedTargetCollectionFieldMetadataProvider();
    dynamicEntityDaoImpl.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);
    DynamicDaoHelperImpl dynamicDaoHelper = new DynamicDaoHelperImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    dynamicEntityDaoImpl.setEntityConfiguration(entityConfiguration);
    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    dynamicEntityDaoImpl.setFieldMetadataProviders(fieldMetadataProviders);
    Metadata metadata = new Metadata();
    dynamicEntityDaoImpl.setMetadata(metadata);
    FieldMetadataProvider actualDefaultFieldMetadataProvider =
        dynamicEntityDaoImpl.getDefaultFieldMetadataProvider();
    DynamicDaoHelper actualDynamicDaoHelper = dynamicEntityDaoImpl.getDynamicDaoHelper();
    EntityConfiguration actualEntityConfiguration = dynamicEntityDaoImpl.getEntityConfiguration();
    List<FieldMetadataProvider> actualFieldMetadataProviders =
        dynamicEntityDaoImpl.getFieldMetadataProviders();
    Metadata actualMetadata = dynamicEntityDaoImpl.getMetadata();

    // Assert
    assertTrue(actualDynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertTrue(
        actualDefaultFieldMetadataProvider instanceof AdornedTargetCollectionFieldMetadataProvider);
    assertNull(dynamicEntityDaoImpl.getStandardEntityManager());
    assertNull(actualEntityConfiguration.getEntityContexts());
    assertTrue(actualFieldMetadataProviders.isEmpty());
    assertSame(fieldMetadataProviders, actualFieldMetadataProviders);
    assertSame(entityConfiguration, actualEntityConfiguration);
    assertSame(dynamicDaoHelper, actualDynamicDaoHelper);
    assertSame(metadata, actualMetadata);
    assertSame(defaultFieldMetadataProvider, actualDefaultFieldMetadataProvider);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isExcludeClassFromPolymorphism(Class)}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isExcludeClassFromPolymorphism(Class)"})
  public void testIsExcludeClassFromPolymorphism_givenDynamicEntityDaoImpl_thenReturnFalse() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(dynamicEntityDaoImpl.isExcludeClassFromPolymorphism(clazz));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#isExcludeClassFromPolymorphism(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#isExcludeClassFromPolymorphism(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicEntityDaoImpl.isExcludeClassFromPolymorphism(Class)"})
  public void testIsExcludeClassFromPolymorphism_thenReturnTrue() {
    // Arrange
    DynamicDaoHelperImpl dynamicDaoHelper = mock(DynamicDaoHelperImpl.class);
    when(dynamicDaoHelper.isExcludeClassFromPolymorphism(Mockito.<Class<?>>any())).thenReturn(true);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    Class<Object> clazz = Object.class;

    // Act
    boolean actualIsExcludeClassFromPolymorphismResult =
        dynamicEntityDaoImpl.isExcludeClassFromPolymorphism(clazz);

    // Assert
    verify(dynamicDaoHelper).isExcludeClassFromPolymorphism(isA(Class.class));
    assertTrue(actualIsExcludeClassFromPolymorphismResult);
  }
}
