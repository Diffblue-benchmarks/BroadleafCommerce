/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SkuBundleItemCustomPersistenceHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuBundleItemCustomPersistenceHandlerDiffblueTest {
  @Autowired private SkuBundleItemCustomPersistenceHandler skuBundleItemCustomPersistenceHandler;

  @MockBean(name = "blSkuCustomPersistenceHandler")
  private SkuCustomPersistenceHandler skuCustomPersistenceHandler;

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * SkuBundleItemCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean SkuBundleItemCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(skuBundleItemCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuBundleItemCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean SkuBundleItemCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleInspectResult =
        skuBundleItemCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * SkuBundleItemCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean SkuBundleItemCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(skuBundleItemCustomPersistenceHandler.canHandleFetch(persistencePackage));
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuBundleItemCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean SkuBundleItemCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult =
        skuBundleItemCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandle(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * SkuBundleItemCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SkuBundleItemCustomPersistenceHandler.canHandle(PersistencePackage)"})
  public void testCanHandle() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(skuBundleItemCustomPersistenceHandler.canHandle(persistencePackage));
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandle(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuBundleItemCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SkuBundleItemCustomPersistenceHandler.canHandle(PersistencePackage)"})
  public void testCanHandle_givenDrJaneDoe_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleResult =
        skuBundleItemCustomPersistenceHandler.canHandle(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleResult);
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao,
   * InspectHelper)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then calls {@link DynamicEntityDao#getAllPolymorphicEntitiesFromCeiling(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage,
   * DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet SkuBundleItemCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"
  })
  public void testInspect_givenJavaLangObject_thenCallsGetAllPolymorphicEntitiesFromCeiling()
      throws ServiceException {
    // Arrange
    when(skuCustomPersistenceHandler.createConsolidatedOptionField(Mockito.<Class<?>>any()))
        .thenReturn(new AdornedTargetCollectionMetadata());

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(
            dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<?>>any()))
        .thenReturn(new Class[] {forNameResult});

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put(
        SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME,
        new AdornedTargetCollectionMetadata());

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());

    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    when(helper.buildClassMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any()))
        .thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult =
        skuBundleItemCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(skuCustomPersistenceHandler).createConsolidatedOptionField(isA(Class.class));
    verify(persistencePackage).getPersistencePerspective();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(helper)
        .buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.SkuBundleItem"),
            isA(PersistencePerspective.class));
    assertNull(actualInspectResult.getPromptSearch());
    assertNull(actualInspectResult.getTotalCountLessThanPageSize());
    assertNull(actualInspectResult.getBatchId());
    assertNull(actualInspectResult.getLowerCount());
    assertNull(actualInspectResult.getUpperCount());
    assertNull(actualInspectResult.getFirstId());
    assertNull(actualInspectResult.getLastId());
    assertNull(actualInspectResult.getFetchType());
    assertEquals(0, actualInspectResult.getPageSize().intValue());
    assertEquals(0, actualInspectResult.getStartIndex().intValue());
    assertEquals(0, actualInspectResult.getTotalRecords().intValue());
    assertEquals(0, actualInspectResult.getRecords().length);
    assertTrue(actualInspectResult.getUnselectedTabMetadata().isEmpty());
    assertSame(classMetadata, actualInspectResult.getClassMetaData());
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao,
   * InspectHelper)}.
   *
   * <ul>
   *   <li>Then return PromptSearch is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage,
   * DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet SkuBundleItemCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"
  })
  public void testInspect_thenReturnPromptSearchIsNull() throws ServiceException {
    // Arrange
    when(skuCustomPersistenceHandler.createConsolidatedOptionField(Mockito.<Class<?>>any()))
        .thenReturn(new AdornedTargetCollectionMetadata());

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put(
        SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME,
        new AdornedTargetCollectionMetadata());

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());

    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    when(helper.buildClassMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any()))
        .thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult =
        skuBundleItemCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(skuCustomPersistenceHandler).createConsolidatedOptionField(isA(Class.class));
    verify(persistencePackage).getPersistencePerspective();
    verify(helper)
        .buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.SkuBundleItem"),
            isA(PersistencePerspective.class));
    assertNull(actualInspectResult.getPromptSearch());
    assertNull(actualInspectResult.getTotalCountLessThanPageSize());
    assertNull(actualInspectResult.getBatchId());
    assertNull(actualInspectResult.getLowerCount());
    assertNull(actualInspectResult.getUpperCount());
    assertNull(actualInspectResult.getFirstId());
    assertNull(actualInspectResult.getLastId());
    assertNull(actualInspectResult.getFetchType());
    assertEquals(0, actualInspectResult.getPageSize().intValue());
    assertEquals(0, actualInspectResult.getStartIndex().intValue());
    assertEquals(0, actualInspectResult.getTotalRecords().intValue());
    assertEquals(0, actualInspectResult.getRecords().length);
    assertTrue(actualInspectResult.getUnselectedTabMetadata().isEmpty());
    assertSame(classMetadata, actualInspectResult.getClassMetaData());
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao,
   * InspectHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage,
   * DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet SkuBundleItemCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"
  })
  public void testInspect_thenThrowServiceException() throws ServiceException {
    // Arrange
    when(skuCustomPersistenceHandler.createConsolidatedOptionField(Mockito.<Class<?>>any()))
        .thenThrow(new RuntimeException());

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put(
        SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME,
        new AdornedTargetCollectionMetadata());

    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            skuBundleItemCustomPersistenceHandler.inspect(
                persistencePackage, dynamicEntityDao, helper));
    verify(skuCustomPersistenceHandler).createConsolidatedOptionField(isA(Class.class));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.SkuBundleItem"),
            isA(PersistencePerspective.class));
  }
}
