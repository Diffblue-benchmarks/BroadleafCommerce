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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
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
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
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
  @Autowired
  private SkuBundleItemCustomPersistenceHandler skuBundleItemCustomPersistenceHandler;

  @MockBean(name = "blSkuCustomPersistenceHandler")
  private SkuCustomPersistenceHandler skuCustomPersistenceHandler;

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test: {@link SkuBundleItemCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuBundleItemCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(skuBundleItemCustomPersistenceHandler.canHandleInspect(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuBundleItemCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleInspectResult = skuBundleItemCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test: {@link SkuBundleItemCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuBundleItemCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(skuBundleItemCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuBundleItemCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = skuBundleItemCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandle(PersistencePackage)}.
   * <p>
   * Method under test: {@link SkuBundleItemCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuBundleItemCustomPersistenceHandler.canHandle(PersistencePackage)"})
  public void testCanHandle() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(skuBundleItemCustomPersistenceHandler.canHandle(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#canHandle(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuBundleItemCustomPersistenceHandler.canHandle(PersistencePackage)"})
  public void testCanHandle_givenDrJaneDoe_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleResult = skuBundleItemCustomPersistenceHandler.canHandle(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleResult);
  }

  /**
   * Test {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then calls {@link DynamicEntityDao#getAllPolymorphicEntitiesFromCeiling(Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuBundleItemCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_givenJavaLangObject_thenCallsGetAllPolymorphicEntitiesFromCeiling() throws ServiceException {
    // Arrange
    when(skuCustomPersistenceHandler.createConsolidatedOptionField(Mockito.<Class<Object>>any()))
        .thenReturn(new AdornedTargetCollectionMetadata());
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = skuBundleItemCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(skuCustomPersistenceHandler).createConsolidatedOptionField(isA(Class.class));
    verify(persistencePackage).getPersistencePerspective();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.SkuBundleItem"),
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
   * Test {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Then return PromptSearch is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuBundleItemCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_thenReturnPromptSearchIsNull() throws ServiceException {
    // Arrange
    when(skuCustomPersistenceHandler.createConsolidatedOptionField(Mockito.<Class<Object>>any()))
        .thenReturn(new AdornedTargetCollectionMetadata());
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = skuBundleItemCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(skuCustomPersistenceHandler).createConsolidatedOptionField(isA(Class.class));
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.SkuBundleItem"),
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
   * Test {@link SkuBundleItemCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given empty array of {@link Entity}.</li>
   *   <li>Then return PromptSearch is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuBundleItemCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenEmptyArrayOfEntity_thenReturnPromptSearchIsNull() throws ServiceException {
    // Arrange
    doNothing().when(skuCustomPersistenceHandler)
        .applyProductOptionValueCriteria(Mockito.<List<FilterMapping>>any(), Mockito.<CriteriaTransferObject>any(),
            Mockito.<PersistencePackage>any(), Mockito.<String>any());
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{});

    // Act
    DynamicResultSet actualFetchResult = skuBundleItemCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(skuCustomPersistenceHandler).applyProductOptionValueCriteria(isA(List.class),
        isA(CriteriaTransferObject.class), isA(PersistencePackage.class), eq("sku"));
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.SkuBundleItem"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(0, actualFetchResult.getRecords().length);
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
  }
}
