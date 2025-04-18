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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.admin.server.service.SkuMetadataCacheService;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationStrategyType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.PersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslator;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SkuCustomPersistenceHandlerDiffblueTest {
  @Mock
  private CatalogService catalogService;

  @Mock
  private CriteriaTranslator criteriaTranslator;

  @Mock
  private PersistenceModule persistenceModule;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @InjectMocks
  private SkuCustomPersistenceHandler skuCustomPersistenceHandler;

  @Mock
  private SkuMetadataCacheService skuMetadataCacheService;

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_givenDrJaneDoe_thenReturnFalse() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleInspectResult = skuCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_thenCallsGetOperationTypes() {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleInspectResult = skuCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch_givenDrJaneDoe_thenReturnFalse() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleFetchResult = skuCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch_thenCallsGetOperationTypes() {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleFetchResult = skuCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_givenDrJaneDoe_thenReturnFalse() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleAddResult = skuCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_thenCallsGetOperationTypes() {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleAddResult = skuCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_givenDrJaneDoe_thenReturnFalse() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleUpdateResult = skuCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_thenCallsGetOperationTypes() {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleUpdateResult = skuCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandle(PersistencePackage, OperationType)"})
  public void testCanHandle() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(skuCustomPersistenceHandler.canHandle(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123"), OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuCustomPersistenceHandler.canHandle(PersistencePackage, OperationType)"})
  public void testCanHandle_givenDrJaneDoe_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleResult = skuCustomPersistenceHandler.canHandle(persistencePackage,
        OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect() throws ServiceException {
    // Arrange
    when(skuMetadataCacheService.getFromCache(Mockito.<String>any())).thenThrow(new NumberFormatException("USD"));
    when(skuMetadataCacheService.useCache()).thenReturn(true);
    when(skuMetadataCacheService.buildCacheKey(Mockito.<String>any())).thenReturn("Build Cache Key");
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> skuCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao, new PersistenceManagerImpl()));
    verify(skuMetadataCacheService).buildCacheKey(isNull());
    verify(skuMetadataCacheService).getFromCache(eq("Build Cache Key"));
    verify(skuMetadataCacheService).useCache();
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect2() throws ServiceException {
    // Arrange
    doNothing().when(persistenceModule).setPersistenceManager(Mockito.<PersistenceManager>any());
    doNothing().when(persistenceModule)
        .updateMergedProperties(Mockito.<PersistencePackage>any(),
            Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any());
    when(skuMetadataCacheService.useCache()).thenReturn(false);
    when(skuMetadataCacheService.buildCacheKey(Mockito.<String>any())).thenReturn("Build Cache Key");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("org.broadleafcommerce.core.catalog.domain.ProductImpl");
    sectionCrumb.setSectionIdentifier("org.broadleafcommerce.core.catalog.domain.ProductImpl");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = skuCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao,
        helper);

    // Assert
    verify(skuMetadataCacheService).buildCacheKey(eq("org.broadleafcommerce.core.catalog.domain.ProductImpl"));
    verify(skuMetadataCacheService, atLeast(1)).useCache();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.SkuImpl"),
        isA(PersistencePerspective.class));
    verify(persistenceModule).setPersistenceManager(isA(PersistenceManager.class));
    verify(persistenceModule).updateMergedProperties(isA(PersistencePackage.class), isA(Map.class));
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
   * Test {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then calls {@link CatalogService#readAllProductOptions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_givenArrayListAddProductOptionImpl_thenCallsReadAllProductOptions() throws ServiceException {
    // Arrange
    doNothing().when(persistenceModule).setPersistenceManager(Mockito.<PersistenceManager>any());
    doNothing().when(persistenceModule)
        .updateMergedProperties(Mockito.<PersistencePackage>any(),
            Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any());

    ArrayList<ProductOption> productOptionList = new ArrayList<>();
    productOptionList.add(new ProductOptionImpl());
    when(catalogService.readAllProductOptions()).thenReturn(productOptionList);
    when(skuMetadataCacheService.useCache()).thenReturn(false);
    when(skuMetadataCacheService.buildCacheKey(Mockito.<String>any())).thenReturn("Build Cache Key");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = skuCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao,
        helper);

    // Assert
    verify(skuMetadataCacheService).buildCacheKey(isNull());
    verify(skuMetadataCacheService, atLeast(1)).useCache();
    verify(catalogService).readAllProductOptions();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.SkuImpl"),
        isA(PersistencePerspective.class));
    verify(persistenceModule).setPersistenceManager(isA(PersistenceManager.class));
    verify(persistenceModule).updateMergedProperties(isA(PersistencePackage.class), isA(Map.class));
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
   * Test {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_givenCatalogServiceFindProductByIdReturnProductBundleImpl() throws ServiceException {
    // Arrange
    doNothing().when(persistenceModule).setPersistenceManager(Mockito.<PersistenceManager>any());
    doNothing().when(persistenceModule)
        .updateMergedProperties(Mockito.<PersistencePackage>any(),
            Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuMetadataCacheService.useCache()).thenReturn(false);
    when(skuMetadataCacheService.buildCacheKey(Mockito.<String>any())).thenReturn("Build Cache Key");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("org.broadleafcommerce.core.catalog.domain.ProductImpl");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = skuCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao,
        helper);

    // Assert
    verify(skuMetadataCacheService).buildCacheKey(eq("42"));
    verify(skuMetadataCacheService, atLeast(1)).useCache();
    verify(catalogService).findProductById(eq(42L));
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.SkuImpl"),
        isA(PersistencePerspective.class));
    verify(persistenceModule).setPersistenceManager(isA(PersistenceManager.class));
    verify(persistenceModule).updateMergedProperties(isA(PersistencePackage.class), isA(Map.class));
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
   * Test {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) SectionIdentifier is {@code 42}.</li>
   *   <li>Then calls {@link SkuMetadataCacheService#getFromCache(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_givenSectionCrumbSectionIdentifierIs42_thenCallsGetFromCache() throws ServiceException {
    // Arrange
    doNothing().when(persistenceModule).setPersistenceManager(Mockito.<PersistenceManager>any());
    doNothing().when(persistenceModule)
        .updateMergedProperties(Mockito.<PersistencePackage>any(),
            Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any());
    when(skuMetadataCacheService.getFromCache(Mockito.<String>any())).thenReturn(new HashMap<>());
    when(skuMetadataCacheService.useCache()).thenReturn(true);
    when(skuMetadataCacheService.buildCacheKey(Mockito.<String>any())).thenReturn("Build Cache Key");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = skuCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao,
        helper);

    // Assert
    verify(skuMetadataCacheService).buildCacheKey(isNull());
    verify(skuMetadataCacheService).getFromCache(eq("Build Cache Key"));
    verify(skuMetadataCacheService).useCache();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(persistenceModule).setPersistenceManager(isA(PersistenceManager.class));
    verify(persistenceModule).updateMergedProperties(isA(PersistencePackage.class), isA(Map.class));
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
   * Test {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_thenCallsGetCeilingEntityFullyQualifiedClassname() throws ServiceException {
    // Arrange
    when(skuMetadataCacheService.useCache()).thenReturn(false);
    when(skuMetadataCacheService.buildCacheKey(Mockito.<String>any())).thenReturn("Build Cache Key");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenThrow(new NumberFormatException("org.broadleafcommerce.core.catalog.domain.ProductImpl"));

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> skuCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao, helper));
    verify(skuMetadataCacheService).buildCacheKey(isNull());
    verify(skuMetadataCacheService).useCache();
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.SkuImpl"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Then calls {@link Product#getProductOptions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_thenCallsGetProductOptions() throws ServiceException {
    // Arrange
    doNothing().when(persistenceModule).setPersistenceManager(Mockito.<PersistenceManager>any());
    doNothing().when(persistenceModule)
        .updateMergedProperties(Mockito.<PersistencePackage>any(),
            Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any());
    Product product = mock(Product.class);
    when(product.getProductOptions()).thenThrow(new NumberFormatException("foo"));
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(product);
    when(skuMetadataCacheService.useCache()).thenReturn(false);
    when(skuMetadataCacheService.buildCacheKey(Mockito.<String>any())).thenReturn("Build Cache Key");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("org.broadleafcommerce.core.catalog.domain.ProductImpl");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = skuCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao,
        helper);

    // Assert
    verify(skuMetadataCacheService).buildCacheKey(eq("42"));
    verify(skuMetadataCacheService, atLeast(1)).useCache();
    verify(product).getProductOptions();
    verify(catalogService).findProductById(eq(42L));
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.SkuImpl"),
        isA(PersistencePerspective.class));
    verify(persistenceModule).setPersistenceManager(isA(PersistenceManager.class));
    verify(persistenceModule).updateMergedProperties(isA(PersistencePackage.class), isA(Map.class));
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
   * Test {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#readAllProductOptions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_thenCallsReadAllProductOptions() throws ServiceException {
    // Arrange
    doNothing().when(persistenceModule).setPersistenceManager(Mockito.<PersistenceManager>any());
    doNothing().when(persistenceModule)
        .updateMergedProperties(Mockito.<PersistencePackage>any(),
            Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any());
    when(catalogService.readAllProductOptions()).thenReturn(new ArrayList<>());
    when(skuMetadataCacheService.useCache()).thenReturn(false);
    when(skuMetadataCacheService.buildCacheKey(Mockito.<String>any())).thenReturn("Build Cache Key");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = skuCustomPersistenceHandler.inspect(persistencePackage, dynamicEntityDao,
        helper);

    // Assert
    verify(skuMetadataCacheService).buildCacheKey(isNull());
    verify(skuMetadataCacheService, atLeast(1)).useCache();
    verify(catalogService).readAllProductOptions();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.SkuImpl"),
        isA(PersistencePerspective.class));
    verify(persistenceModule).setPersistenceManager(isA(PersistenceManager.class));
    verify(persistenceModule).updateMergedProperties(isA(PersistencePackage.class), isA(Map.class));
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
   * Test {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuCustomPersistenceHandler.getOwningProductId(SectionCrumb[])"})
  public void testGetOwningProductId_thenReturn42() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("org.broadleafcommerce.core.catalog.domain.ProductImpl");

    // Act and Assert
    assertEquals("42", skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb}));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}.
   * <ul>
   *   <li>When empty array of {@link SectionCrumb}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuCustomPersistenceHandler.getOwningProductId(SectionCrumb[])"})
  public void testGetOwningProductId_whenEmptyArrayOfSectionCrumb_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{}));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}.
   * <ul>
   *   <li>When {@link SectionCrumb} (default constructor) SectionIdentifier is {@code 42}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuCustomPersistenceHandler.getOwningProductId(SectionCrumb[])"})
  public void testGetOwningProductId_whenSectionCrumbSectionIdentifierIs42_thenReturnNull() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb}));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <ul>
   *   <li>Given {@code defaultProduct.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuCustomPersistenceHandler.filterOutProductMetadata(Map)"})
  public void testFilterOutProductMetadata_givenDefaultProduct() {
    // Arrange
    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.put("defaultProduct.", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert
    assertTrue(map.isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuCustomPersistenceHandler.filterOutProductMetadata(Map)"})
  public void testFilterOutProductMetadata_givenFoo_thenHashMapSizeIsOne() {
    // Arrange
    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert that nothing has changed
    assertEquals(1, map.size());
    assertTrue(map.containsKey("foo"));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <ul>
   *   <li>Given {@code product.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuCustomPersistenceHandler.filterOutProductMetadata(Map)"})
  public void testFilterOutProductMetadata_givenProduct() {
    // Arrange
    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.put("product.", new AdornedTargetCollectionMetadata());
    map.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert
    assertEquals(1, map.size());
    assertTrue(map.containsKey("foo"));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuCustomPersistenceHandler.filterOutProductMetadata(Map)"})
  public void testFilterOutProductMetadata_whenHashMap_thenHashMapEmpty() {
    // Arrange
    HashMap<String, FieldMetadata> map = new HashMap<>();

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert that nothing has changed
    assertTrue(map.isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#createConsolidatedOptionField(Class)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#createConsolidatedOptionField(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldMetadata SkuCustomPersistenceHandler.createConsolidatedOptionField(Class)"})
  public void testCreateConsolidatedOptionField() {
    // Arrange
    when(skuMetadataCacheService.useCache()).thenReturn(false);
    Class<Object> inheritedFromType = Object.class;

    // Act
    FieldMetadata actualCreateConsolidatedOptionFieldResult = skuCustomPersistenceHandler
        .createConsolidatedOptionField(inheritedFromType);

    // Assert
    verify(skuMetadataCacheService).useCache();
    assertTrue(actualCreateConsolidatedOptionFieldResult instanceof BasicFieldMetadata);
    assertEquals("", ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getBroadleafEnumeration());
    assertEquals("", actualCreateConsolidatedOptionFieldResult.getGroup());
    assertEquals("consolidatedProductOptions",
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getName());
    assertEquals("consolidatedProductOptions", actualCreateConsolidatedOptionFieldResult.getFriendlyName());
    assertEquals("java.lang.Object", actualCreateConsolidatedOptionFieldResult.getInheritedFromType());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getIsDerived());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getIsFilter());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getSearchable());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getTranslatable());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getUnique());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).isLargeEntry());
    assertNull(actualCreateConsolidatedOptionFieldResult.getChildrenExcluded());
    assertNull(actualCreateConsolidatedOptionFieldResult.getExcluded());
    assertNull(actualCreateConsolidatedOptionFieldResult.getLazyFetch());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getLength());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getPrecision());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getScale());
    assertNull(actualCreateConsolidatedOptionFieldResult.getGroupOrder());
    assertNull(actualCreateConsolidatedOptionFieldResult.getOrder());
    assertNull(actualCreateConsolidatedOptionFieldResult.getTabOrder());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getColumnWidth());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getDefaultValue());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getEnumerationClass());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForeignKeyProperty());
    assertNull(
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getHelpText());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getHint());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getManyToField());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionListEntity());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getTooltip());
    assertNull(actualCreateConsolidatedOptionFieldResult.getAddFriendlyName());
    assertNull(actualCreateConsolidatedOptionFieldResult.getCurrencyCodeField());
    assertNull(actualCreateConsolidatedOptionFieldResult.getFieldName());
    assertNull(actualCreateConsolidatedOptionFieldResult.getOwningClass());
    assertNull(actualCreateConsolidatedOptionFieldResult.getOwningClassFriendlyName());
    assertNull(actualCreateConsolidatedOptionFieldResult.getPrefix());
    assertNull(actualCreateConsolidatedOptionFieldResult.getSecurityLevel());
    assertNull(actualCreateConsolidatedOptionFieldResult.getShowIfProperty());
    assertNull(actualCreateConsolidatedOptionFieldResult.getTab());
    assertNull(actualCreateConsolidatedOptionFieldResult.getTargetClass());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getCustomCriteria());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getEnumerationValues());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionFilterParams());
    assertNull(actualCreateConsolidatedOptionFieldResult.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getLookupType());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getDisplayType());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getGridFieldComponentRenderer());
    assertEquals(0, actualCreateConsolidatedOptionFieldResult.getAvailableToTypes().length);
    assertEquals(SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getSecondaryType());
    assertEquals(SupportedFieldType.STRING,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getFieldType());
    assertEquals(SupportedFieldType.UNKNOWN,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getExplicitFieldType());
    assertEquals(VisibilityEnum.FORM_HIDDEN,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getVisibility());
    assertEquals(MergedPropertyType.PRIMARY,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getMergedPropertyType());
    assertFalse(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getMutable());
    assertFalse(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getRequired());
    assertFalse(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getRequiredOverride());
    assertFalse(actualCreateConsolidatedOptionFieldResult.getManualFetch());
    assertTrue(
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getValidationConfigurations().isEmpty());
    assertTrue(actualCreateConsolidatedOptionFieldResult.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getReadOnly());
    assertTrue(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).isProminent());
    assertEquals(SkuCustomPersistenceHandlerExtensionHandler.DEFAULT_PRIORITY,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getGridOrder().intValue());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#createConsolidatedOptionField(Class)}.
   * <ul>
   *   <li>Then return {@link BasicFieldMetadata}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#createConsolidatedOptionField(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldMetadata SkuCustomPersistenceHandler.createConsolidatedOptionField(Class)"})
  public void testCreateConsolidatedOptionField_thenReturnBasicFieldMetadata() {
    // Arrange
    when(skuMetadataCacheService.useCache()).thenReturn(true);
    Class<Object> inheritedFromType = Object.class;

    // Act
    FieldMetadata actualCreateConsolidatedOptionFieldResult = skuCustomPersistenceHandler
        .createConsolidatedOptionField(inheritedFromType);

    // Assert
    verify(skuMetadataCacheService).useCache();
    assertTrue(actualCreateConsolidatedOptionFieldResult instanceof BasicFieldMetadata);
    assertEquals("", ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getBroadleafEnumeration());
    assertEquals("", actualCreateConsolidatedOptionFieldResult.getGroup());
    assertEquals("consolidatedProductOptions",
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getName());
    assertEquals("consolidatedProductOptions", actualCreateConsolidatedOptionFieldResult.getFriendlyName());
    assertEquals("java.lang.Object", actualCreateConsolidatedOptionFieldResult.getInheritedFromType());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getIsDerived());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getIsFilter());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getSearchable());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getTranslatable());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getUnique());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).isLargeEntry());
    assertNull(actualCreateConsolidatedOptionFieldResult.getChildrenExcluded());
    assertNull(actualCreateConsolidatedOptionFieldResult.getExcluded());
    assertNull(actualCreateConsolidatedOptionFieldResult.getLazyFetch());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getLength());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getPrecision());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getScale());
    assertNull(actualCreateConsolidatedOptionFieldResult.getGroupOrder());
    assertNull(actualCreateConsolidatedOptionFieldResult.getOrder());
    assertNull(actualCreateConsolidatedOptionFieldResult.getTabOrder());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getColumnWidth());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getDefaultValue());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getEnumerationClass());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForeignKeyProperty());
    assertNull(
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getHelpText());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getHint());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getManyToField());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionListEntity());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getTooltip());
    assertNull(actualCreateConsolidatedOptionFieldResult.getAddFriendlyName());
    assertNull(actualCreateConsolidatedOptionFieldResult.getCurrencyCodeField());
    assertNull(actualCreateConsolidatedOptionFieldResult.getFieldName());
    assertNull(actualCreateConsolidatedOptionFieldResult.getOwningClass());
    assertNull(actualCreateConsolidatedOptionFieldResult.getOwningClassFriendlyName());
    assertNull(actualCreateConsolidatedOptionFieldResult.getPrefix());
    assertNull(actualCreateConsolidatedOptionFieldResult.getSecurityLevel());
    assertNull(actualCreateConsolidatedOptionFieldResult.getShowIfProperty());
    assertNull(actualCreateConsolidatedOptionFieldResult.getTab());
    assertNull(actualCreateConsolidatedOptionFieldResult.getTargetClass());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getCustomCriteria());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getEnumerationValues());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getOptionFilterParams());
    assertNull(actualCreateConsolidatedOptionFieldResult.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getLookupType());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getDisplayType());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getGridFieldComponentRenderer());
    assertEquals(0, actualCreateConsolidatedOptionFieldResult.getAvailableToTypes().length);
    assertEquals(SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getSecondaryType());
    assertEquals(SupportedFieldType.STRING,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getFieldType());
    assertEquals(SupportedFieldType.UNKNOWN,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getExplicitFieldType());
    assertEquals(VisibilityEnum.FORM_HIDDEN,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getVisibility());
    assertEquals(MergedPropertyType.PRIMARY,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getMergedPropertyType());
    assertFalse(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getMutable());
    assertFalse(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getRequired());
    assertFalse(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getRequiredOverride());
    assertFalse(actualCreateConsolidatedOptionFieldResult.getManualFetch());
    assertTrue(
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getValidationConfigurations().isEmpty());
    assertTrue(actualCreateConsolidatedOptionFieldResult.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getReadOnly());
    assertTrue(((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).isProminent());
    assertEquals(SkuCustomPersistenceHandlerExtensionHandler.DEFAULT_PRIORITY,
        ((BasicFieldMetadata) actualCreateConsolidatedOptionFieldResult).getGridOrder().intValue());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#createConsolidatedOptionField(Class)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#createConsolidatedOptionField(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldMetadata SkuCustomPersistenceHandler.createConsolidatedOptionField(Class)"})
  public void testCreateConsolidatedOptionField_thenThrowNumberFormatException() {
    // Arrange
    when(skuMetadataCacheService.useCache()).thenThrow(new NumberFormatException("foo"));
    Class<Object> inheritedFromType = Object.class;

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> skuCustomPersistenceHandler.createConsolidatedOptionField(inheritedFromType));
    verify(skuMetadataCacheService).useCache();
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}.
   * <ul>
   *   <li>Then return RawValue is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property SkuCustomPersistenceHandler.getConsolidatedOptionProperty(Collection)"})
  public void testGetConsolidatedOptionProperty_thenReturnRawValueIsEmptyString() {
    // Arrange
    ArrayList<ProductOptionValue> values = new ArrayList<>();
    values.add(new ProductOptionValueImpl());

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler.getConsolidatedOptionProperty(values);

    // Assert
    assertTrue(actualConsolidatedOptionProperty.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}.
   * <ul>
   *   <li>Then return RawValue is {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property SkuCustomPersistenceHandler.getConsolidatedOptionProperty(Collection)"})
  public void testGetConsolidatedOptionProperty_thenReturnRawValueIsSemicolon() {
    // Arrange
    ArrayList<ProductOptionValue> values = new ArrayList<>();
    values.add(new ProductOptionValueImpl());
    values.add(new ProductOptionValueImpl());

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler.getConsolidatedOptionProperty(values);

    // Assert
    assertTrue(actualConsolidatedOptionProperty.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("; ", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("; ", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("; ", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return RawValue is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property SkuCustomPersistenceHandler.getConsolidatedOptionProperty(Collection)"})
  public void testGetConsolidatedOptionProperty_whenArrayList_thenReturnRawValueIsEmptyString() {
    // Arrange and Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler
        .getConsolidatedOptionProperty(new ArrayList<>());

    // Assert
    assertTrue(actualConsolidatedOptionProperty.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getBlankConsolidatedOptionProperty()}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getBlankConsolidatedOptionProperty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property SkuCustomPersistenceHandler.getBlankConsolidatedOptionProperty()"})
  public void testGetBlankConsolidatedOptionProperty() {
    // Arrange and Act
    Property actualBlankConsolidatedOptionProperty = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty();

    // Assert
    assertTrue(actualBlankConsolidatedOptionProperty.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("", actualBlankConsolidatedOptionProperty.getRawValue());
    assertEquals("", actualBlankConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("", actualBlankConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualBlankConsolidatedOptionProperty.getName());
    assertNull(actualBlankConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualBlankConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualBlankConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualBlankConsolidatedOptionProperty.getDeployDate());
    assertFalse(actualBlankConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualBlankConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(actualBlankConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}.
   * <ul>
   *   <li>Given {@link SkuMetadataCacheService} {@link SkuMetadataCacheService#useCache()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldMetadata SkuCustomPersistenceHandler.createIndividualOptionField(ProductOption, int)"})
  public void testCreateIndividualOptionField_givenSkuMetadataCacheServiceUseCacheReturnFalse() {
    // Arrange
    when(skuMetadataCacheService.useCache()).thenReturn(false);
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getId()).thenReturn(1L);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");

    ArrayList<ProductOptionValue> allowedValues = new ArrayList<>();
    allowedValues.add(productOptionValueImpl);

    ProductOptionImpl option = new ProductOptionImpl();
    option.setAllowedValues(allowedValues);

    // Act
    FieldMetadata actualCreateIndividualOptionFieldResult = skuCustomPersistenceHandler
        .createIndividualOptionField(option, 1);

    // Assert
    verify(skuMetadataCacheService).useCache();
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getId();
    assertTrue(actualCreateIndividualOptionFieldResult instanceof BasicFieldMetadata);
    assertEquals("", ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getBroadleafEnumeration());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl",
        actualCreateIndividualOptionFieldResult.getInheritedFromType());
    assertEquals("productOption_group", actualCreateIndividualOptionFieldResult.getGroup());
    assertEquals("productOptionnull", ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getIsDerived());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getIsFilter());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getSearchable());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getTranslatable());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getUnique());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).isLargeEntry());
    assertNull(actualCreateIndividualOptionFieldResult.getChildrenExcluded());
    assertNull(actualCreateIndividualOptionFieldResult.getExcluded());
    assertNull(actualCreateIndividualOptionFieldResult.getLazyFetch());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGridOrder());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getLength());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getPrecision());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getScale());
    assertNull(actualCreateIndividualOptionFieldResult.getTabOrder());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getColumnWidth());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getDefaultValue());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getEnumerationClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getHelpText());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getHint());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getManyToField());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionListEntity());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getTooltip());
    assertNull(actualCreateIndividualOptionFieldResult.getAddFriendlyName());
    assertNull(actualCreateIndividualOptionFieldResult.getCurrencyCodeField());
    assertNull(actualCreateIndividualOptionFieldResult.getFieldName());
    assertNull(actualCreateIndividualOptionFieldResult.getFriendlyName());
    assertNull(actualCreateIndividualOptionFieldResult.getOwningClass());
    assertNull(actualCreateIndividualOptionFieldResult.getOwningClassFriendlyName());
    assertNull(actualCreateIndividualOptionFieldResult.getPrefix());
    assertNull(actualCreateIndividualOptionFieldResult.getSecurityLevel());
    assertNull(actualCreateIndividualOptionFieldResult.getShowIfProperty());
    assertNull(actualCreateIndividualOptionFieldResult.getTab());
    assertNull(actualCreateIndividualOptionFieldResult.getTargetClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getCustomCriteria());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionFilterParams());
    assertNull(actualCreateIndividualOptionFieldResult.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getLookupType());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getDisplayType());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGridFieldComponentRenderer());
    assertEquals(-1, actualCreateIndividualOptionFieldResult.getGroupOrder().intValue());
    assertEquals(0, actualCreateIndividualOptionFieldResult.getAvailableToTypes().length);
    assertEquals(1, actualCreateIndividualOptionFieldResult.getOrder().intValue());
    assertEquals(1, ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getEnumerationValues().length);
    assertEquals(SupportedFieldType.EXPLICIT_ENUMERATION,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getFieldType());
    assertEquals(SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getExplicitFieldType());
    assertEquals(VisibilityEnum.FORM_EXPLICITLY_SHOWN,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getVisibility());
    assertEquals(MergedPropertyType.PRIMARY,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMergedPropertyType());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getReadOnly());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getRequired());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getRequiredOverride());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).isProminent());
    assertFalse(actualCreateIndividualOptionFieldResult.getManualFetch());
    assertTrue(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getValidationConfigurations().isEmpty());
    assertTrue(actualCreateIndividualOptionFieldResult.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMutable());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link ProductOptionImpl} (default constructor) Required is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldMetadata SkuCustomPersistenceHandler.createIndividualOptionField(ProductOption, int)"})
  public void testCreateIndividualOptionField_givenTrue_whenProductOptionImplRequiredIsTrue() {
    // Arrange
    when(skuMetadataCacheService.useCache()).thenReturn(true);
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getId()).thenReturn(1L);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");

    ArrayList<ProductOptionValue> allowedValues = new ArrayList<>();
    allowedValues.add(productOptionValueImpl);

    ProductOptionImpl option = new ProductOptionImpl();
    option.setRequired(true);
    option.setAllowedValues(allowedValues);

    // Act
    FieldMetadata actualCreateIndividualOptionFieldResult = skuCustomPersistenceHandler
        .createIndividualOptionField(option, 1);

    // Assert
    verify(skuMetadataCacheService).useCache();
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getId();
    assertTrue(actualCreateIndividualOptionFieldResult instanceof BasicFieldMetadata);
    assertEquals("", ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getBroadleafEnumeration());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl",
        actualCreateIndividualOptionFieldResult.getInheritedFromType());
    assertEquals("productOption_group", actualCreateIndividualOptionFieldResult.getGroup());
    assertEquals("productOptionnull", ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getIsDerived());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getIsFilter());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getSearchable());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getTranslatable());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getUnique());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).isLargeEntry());
    assertNull(actualCreateIndividualOptionFieldResult.getChildrenExcluded());
    assertNull(actualCreateIndividualOptionFieldResult.getExcluded());
    assertNull(actualCreateIndividualOptionFieldResult.getLazyFetch());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGridOrder());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getLength());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getPrecision());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getScale());
    assertNull(actualCreateIndividualOptionFieldResult.getTabOrder());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getColumnWidth());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getDefaultValue());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getEnumerationClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getHelpText());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getHint());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getManyToField());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionListEntity());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getTooltip());
    assertNull(actualCreateIndividualOptionFieldResult.getAddFriendlyName());
    assertNull(actualCreateIndividualOptionFieldResult.getCurrencyCodeField());
    assertNull(actualCreateIndividualOptionFieldResult.getFieldName());
    assertNull(actualCreateIndividualOptionFieldResult.getFriendlyName());
    assertNull(actualCreateIndividualOptionFieldResult.getOwningClass());
    assertNull(actualCreateIndividualOptionFieldResult.getOwningClassFriendlyName());
    assertNull(actualCreateIndividualOptionFieldResult.getPrefix());
    assertNull(actualCreateIndividualOptionFieldResult.getSecurityLevel());
    assertNull(actualCreateIndividualOptionFieldResult.getShowIfProperty());
    assertNull(actualCreateIndividualOptionFieldResult.getTab());
    assertNull(actualCreateIndividualOptionFieldResult.getTargetClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getCustomCriteria());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionFilterParams());
    assertNull(actualCreateIndividualOptionFieldResult.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getLookupType());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getDisplayType());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGridFieldComponentRenderer());
    assertEquals(-1, actualCreateIndividualOptionFieldResult.getGroupOrder().intValue());
    assertEquals(0, actualCreateIndividualOptionFieldResult.getAvailableToTypes().length);
    assertEquals(1, actualCreateIndividualOptionFieldResult.getOrder().intValue());
    assertEquals(1, ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getEnumerationValues().length);
    assertEquals(SupportedFieldType.EXPLICIT_ENUMERATION,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getFieldType());
    assertEquals(SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getExplicitFieldType());
    assertEquals(VisibilityEnum.FORM_EXPLICITLY_SHOWN,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getVisibility());
    assertEquals(MergedPropertyType.PRIMARY,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMergedPropertyType());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getReadOnly());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getRequired());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getRequiredOverride());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).isProminent());
    assertFalse(actualCreateIndividualOptionFieldResult.getManualFetch());
    assertTrue(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getValidationConfigurations().isEmpty());
    assertTrue(actualCreateIndividualOptionFieldResult.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMutable());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}.
   * <ul>
   *   <li>Then return {@link BasicFieldMetadata}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldMetadata SkuCustomPersistenceHandler.createIndividualOptionField(ProductOption, int)"})
  public void testCreateIndividualOptionField_thenReturnBasicFieldMetadata() {
    // Arrange
    when(skuMetadataCacheService.useCache()).thenReturn(true);
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getId()).thenReturn(1L);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");

    ArrayList<ProductOptionValue> allowedValues = new ArrayList<>();
    allowedValues.add(productOptionValueImpl);

    ProductOptionImpl option = new ProductOptionImpl();
    option.setAllowedValues(allowedValues);

    // Act
    FieldMetadata actualCreateIndividualOptionFieldResult = skuCustomPersistenceHandler
        .createIndividualOptionField(option, 1);

    // Assert
    verify(skuMetadataCacheService).useCache();
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getId();
    assertTrue(actualCreateIndividualOptionFieldResult instanceof BasicFieldMetadata);
    assertEquals("", ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getBroadleafEnumeration());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl",
        actualCreateIndividualOptionFieldResult.getInheritedFromType());
    assertEquals("productOption_group", actualCreateIndividualOptionFieldResult.getGroup());
    assertEquals("productOptionnull", ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getIsDerived());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getIsFilter());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getSearchable());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getTranslatable());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getUnique());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).isLargeEntry());
    assertNull(actualCreateIndividualOptionFieldResult.getChildrenExcluded());
    assertNull(actualCreateIndividualOptionFieldResult.getExcluded());
    assertNull(actualCreateIndividualOptionFieldResult.getLazyFetch());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGridOrder());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getLength());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getPrecision());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getScale());
    assertNull(actualCreateIndividualOptionFieldResult.getTabOrder());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getColumnWidth());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getDefaultValue());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getEnumerationClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getHelpText());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getHint());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getManyToField());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionListEntity());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getTooltip());
    assertNull(actualCreateIndividualOptionFieldResult.getAddFriendlyName());
    assertNull(actualCreateIndividualOptionFieldResult.getCurrencyCodeField());
    assertNull(actualCreateIndividualOptionFieldResult.getFieldName());
    assertNull(actualCreateIndividualOptionFieldResult.getFriendlyName());
    assertNull(actualCreateIndividualOptionFieldResult.getOwningClass());
    assertNull(actualCreateIndividualOptionFieldResult.getOwningClassFriendlyName());
    assertNull(actualCreateIndividualOptionFieldResult.getPrefix());
    assertNull(actualCreateIndividualOptionFieldResult.getSecurityLevel());
    assertNull(actualCreateIndividualOptionFieldResult.getShowIfProperty());
    assertNull(actualCreateIndividualOptionFieldResult.getTab());
    assertNull(actualCreateIndividualOptionFieldResult.getTargetClass());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getCustomCriteria());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getOptionFilterParams());
    assertNull(actualCreateIndividualOptionFieldResult.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getLookupType());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getDisplayType());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getGridFieldComponentRenderer());
    assertEquals(-1, actualCreateIndividualOptionFieldResult.getGroupOrder().intValue());
    assertEquals(0, actualCreateIndividualOptionFieldResult.getAvailableToTypes().length);
    assertEquals(1, actualCreateIndividualOptionFieldResult.getOrder().intValue());
    assertEquals(1, ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getEnumerationValues().length);
    assertEquals(SupportedFieldType.EXPLICIT_ENUMERATION,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getFieldType());
    assertEquals(SupportedFieldType.INTEGER,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getExplicitFieldType());
    assertEquals(VisibilityEnum.FORM_EXPLICITLY_SHOWN,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getVisibility());
    assertEquals(MergedPropertyType.PRIMARY,
        ((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMergedPropertyType());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getReadOnly());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getRequired());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getRequiredOverride());
    assertFalse(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).isProminent());
    assertFalse(actualCreateIndividualOptionFieldResult.getManualFetch());
    assertTrue(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getValidationConfigurations().isEmpty());
    assertTrue(actualCreateIndividualOptionFieldResult.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) actualCreateIndividualOptionFieldResult).getMutable());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldMetadata SkuCustomPersistenceHandler.createIndividualOptionField(ProductOption, int)"})
  public void testCreateIndividualOptionField_whenProductOptionImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(skuCustomPersistenceHandler.createIndividualOptionField(new ProductOptionImpl(), 1));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadata SkuCustomPersistenceHandler.createExplicitEnumerationIndividualOptionField(ProductOption, int)"})
  public void testCreateExplicitEnumerationIndividualOptionField() {
    // Arrange
    when(skuMetadataCacheService.useCache()).thenReturn(false);
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getId()).thenThrow(new NumberFormatException("foo"));

    ArrayList<ProductOptionValue> allowedValues = new ArrayList<>();
    allowedValues.add(productOptionValueImpl);
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());
    allowedValues.add(new ProductOptionValueImpl());

    ProductOptionImpl option = new ProductOptionImpl();
    option.setAttributeName("Attribute Name");
    option.setDisplayOrder(1);
    option.setErrorCode("An error occurred");
    option.setErrorMessage("An error occurred");
    option.setId(1L);
    option.setLabel("Label");
    option.setName("Name");
    option.setProductOptionValidationStrategyType(new ProductOptionValidationStrategyType());
    option.setProductOptionValidationType(new ProductOptionValidationType("Type", "Friendly Type"));
    option.setProductXrefs(new ArrayList<>());
    option.setRequired(true);
    option.setType(new ProductOptionType("Type", "Friendly Type"));
    option.setUseInSkuGeneration(true);
    option.setValidationString("Validation String");
    option.setAllowedValues(allowedValues);

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> skuCustomPersistenceHandler.createExplicitEnumerationIndividualOptionField(option, 1));
    verify(skuMetadataCacheService).useCache();
    verify(productOptionValueImpl).getId();
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadata SkuCustomPersistenceHandler.createExplicitEnumerationIndividualOptionField(ProductOption, int)"})
  public void testCreateExplicitEnumerationIndividualOptionField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(skuCustomPersistenceHandler.createExplicitEnumerationIndividualOptionField(new ProductOptionImpl(), 1));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria())
        .thenReturn(new String[]{"owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch2() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
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
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code requestingField=sku}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenArrayOfStringWithRequestingFieldSku() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"requestingField=sku"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link PersistencePackage} {@link PersistencePackage#containsCriteria(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenFalse_whenPersistencePackageContainsCriteriaReturnFalse() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(false);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage)
        .containsCriteria(eq("owningClass=com.broadleafcommerce.inventory.advanced.domain.InventoryImpl"));
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String)} with propertyId is {@code 42} and filterValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenFilterAndSortCriteriaWithPropertyIdIs42AndFilterValueIs42() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42", "42"));
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
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
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PersistencePackage} {@link PersistencePackage#getCustomCriteria()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenNull_whenPersistencePackageGetCustomCriteriaReturnNull() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(null);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PersistencePackage} {@link PersistencePackage#getSectionCrumbs()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenNull_whenPersistencePackageGetSectionCrumbsReturnNull() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(null);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link FilterAndSortCriteria#getFilterValues()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_thenCallsGetFilterValues() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(new ArrayList<>());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(filterAndSortCriteria).getFilterValues();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
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
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_thenCriteriaTransferObjectCriteriaMapSizeIsOne() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_thenCriteriaTransferObjectCriteriaMapSizeIsTwo() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.add(new FilterAndSortCriteria("42"));
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
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(2, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(criteriaMap.containsKey("42"));
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_thenThrowServiceException() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenThrow(
        new NumberFormatException("owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl"));
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper));
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyInventoryRestictions(List, CriteriaTransferObject, PersistencePackage)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link PersistencePackage#containsCriteria(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyInventoryRestictions(List, CriteriaTransferObject, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyInventoryRestictions(List, CriteriaTransferObject, PersistencePackage)"})
  public void testApplyInventoryRestictions_givenTrue_thenCallsContainsCriteria() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);

    // Act
    skuCustomPersistenceHandler.applyInventoryRestictions(filterMappings, cto, persistencePackage);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria2() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    HashMap<String, FilterAndSortCriteria> criteriaMap = new HashMap<>();
    criteriaMap.put(SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME,
        new FilterAndSortCriteria("42"));
    criteriaMap.put(SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME,
        new FilterAndSortCriteria("42"));

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.setCriteriaMap(criteriaMap);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(), "");

    // Assert that nothing has changed
    assertTrue(filterMappings.isEmpty());
    assertSame(criteriaMap, cto.getCriteriaMap());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria3() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42", "42"));

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    assertEquals(1, filterMappings.size());
    FilterMapping getResult = filterMappings.get(0);
    List directFilterValues = getResult.getDirectFilterValues();
    assertEquals(1, directFilterValues.size());
    assertEquals("42", directFilterValues.get(0));
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("Sku Property Prefix.productOptionValueXrefs.productOptionValue.attributeValue",
        fieldPath.getTargetProperty());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestriction().getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria4() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    assertEquals(1, filterMappings.size());
    FilterMapping getResult = filterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("Sku Property Prefix.productOptionValueXrefs.productOptionValue.attributeValue",
        fieldPath.getTargetProperty());
    List directFilterValues = getResult.getDirectFilterValues();
    assertEquals(1, directFilterValues.size());
    assertEquals("foo", directFilterValues.get(0));
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestriction().getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria5() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(), "");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    assertEquals(1, filterMappings.size());
    FilterMapping getResult = filterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("", fieldPath.getTargetProperty());
    List directFilterValues = getResult.getDirectFilterValues();
    assertEquals(1, directFilterValues.size());
    assertEquals("foo", directFilterValues.get(0));
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestriction().getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.</li>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria_givenArrayListAddEmptyString_whenEmptyString() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(), "");

    // Assert that nothing has changed
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    assertTrue(filterMappings.isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with propertyId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria_givenFilterAndSortCriteriaWithPropertyIdIs42() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert that nothing has changed
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    assertTrue(filterMappings.isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria_givenFilterMapping() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria_givenFilterMapping2() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)"})
  public void testApplyProductOptionValueCriteria_thenArrayListEmpty() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(new ArrayList<>());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert that nothing has changed
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria).getFilterValues();
    assertTrue(filterMappings.isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getPolymorphicClasses(Class, EntityManager, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] SkuCustomPersistenceHandler.getPolymorphicClasses(Class, EntityManager, boolean)"})
  public void testGetPolymorphicClasses_whenFalse_thenReturnArrayLengthIsZero() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, skuCustomPersistenceHandler.getPolymorphicClasses(clazz, null, false).length);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getPolymorphicClasses(Class, EntityManager, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] SkuCustomPersistenceHandler.getPolymorphicClasses(Class, EntityManager, boolean)"})
  public void testGetPolymorphicClasses_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, skuCustomPersistenceHandler.getPolymorphicClasses(clazz, null, true).length);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getPolymorphicClasses(Class, EntityManager, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] SkuCustomPersistenceHandler.getPolymorphicClasses(Class, EntityManager, boolean)"})
  public void testGetPolymorphicClasses_whenNull_thenReturnArrayLengthIsZero2() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, skuCustomPersistenceHandler.getPolymorphicClasses(clazz, null, true).length);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)"})
  public void testAssociateProductOptionValuesToSku() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    SkuImpl adminInstance = new SkuImpl();

    // Act
    skuCustomPersistenceHandler.associateProductOptionValuesToSku(entity, adminInstance, new DynamicEntityDaoImpl());

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}.
   * <ul>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SkuCustomPersistenceHandler.associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)"})
  public void testAssociateProductOptionValuesToSku_thenCallsGetName() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});
    SkuImpl adminInstance = new SkuImpl();

    // Act
    skuCustomPersistenceHandler.associateProductOptionValuesToSku(entity, adminInstance, new DynamicEntityDaoImpl());

    // Assert
    verify(entity).getProperties();
    verify(property).getName();
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SkuCustomPersistenceHandler.getProductOptionProperties(Entity)"})
  public void testGetProductOptionProperties() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});

    // Act
    List<Property> actualProductOptionProperties = skuCustomPersistenceHandler.getProductOptionProperties(entity);

    // Assert
    verify(entity).getProperties();
    assertTrue(actualProductOptionProperties.isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SkuCustomPersistenceHandler.getProductOptionProperties(Entity)"})
  public void testGetProductOptionProperties_givenPropertyGetNameReturnName_thenCallsGetName() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act
    List<Property> actualProductOptionProperties = skuCustomPersistenceHandler.getProductOptionProperties(entity);

    // Assert
    verify(entity).getProperties();
    verify(property).getName();
    assertTrue(actualProductOptionProperties.isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}.
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity SkuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(Product, List, Sku)"})
  public void testValidateUniqueProductOptionValueCombination() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<Property> productOptionProperties = new ArrayList<>();
    productOptionProperties.add(new Property("Name", "42"));

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(product, productOptionProperties,
        new SkuImpl()));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}.
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity SkuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(Product, List, Sku)"})
  public void testValidateUniqueProductOptionValueCombination_thenCallsGetValue() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    ArrayList<Property> productOptionProperties = new ArrayList<>();
    productOptionProperties.add(property);

    // Act
    Entity actualValidateUniqueProductOptionValueCombinationResult = skuCustomPersistenceHandler
        .validateUniqueProductOptionValueCombination(product, productOptionProperties, new SkuImpl());

    // Assert
    verify(property).getValue();
    assertNull(actualValidateUniqueProductOptionValueCombinationResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity SkuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(Product, List, Sku)"})
  public void testValidateUniqueProductOptionValueCombination_whenArrayList_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    ArrayList<Property> productOptionProperties = new ArrayList<>();

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(product, productOptionProperties,
        new SkuImpl()));
  }
}
