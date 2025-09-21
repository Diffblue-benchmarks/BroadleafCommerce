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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.SortDirection;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SearchFacetRangeCustomPersistenceHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchFacetRangeCustomPersistenceHandlerDiffblueTest {
  @Autowired
  private SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler;

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean SearchFacetRangeCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(searchFacetRangeCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean SearchFacetRangeCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(searchFacetRangeCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean SearchFacetRangeCustomPersistenceHandler.canHandle(PersistencePackage)"
  })
  public void testCanHandle_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(searchFacetRangeCustomPersistenceHandler.canHandle(new PersistencePackage()));
  }

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is four.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetRangeCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet SearchFacetRangeCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_thenCriteriaTransferObjectCriteriaMapSizeIsFour() throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.add(new FilterAndSortCriteria("42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(new DynamicResultSet());

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    searchFacetRangeCustomPersistenceHandler.fetch(
        persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(4, criteriaMap.size());
    assertTrue(criteriaMap.containsKey("42"));
    assertTrue(criteriaMap.containsKey("embeddablePriceList.priceList"));
    assertTrue(criteriaMap.containsKey("maxValue"));
    assertTrue(criteriaMap.containsKey("minValue"));
  }

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetRangeCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet SearchFacetRangeCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_thenCriteriaTransferObjectCriteriaMapSizeIsOne() throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    FilterAndSortCriteria criteria = mock(FilterAndSortCriteria.class);
    when(criteria.getPropertyId()).thenReturn("42");
    when(criteria.getSortDirection()).thenReturn(SortDirection.ASCENDING);

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.add(criteria);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult =
        searchFacetRangeCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(criteria).getPropertyId();
    verify(criteria).getSortDirection();
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    assertTrue(criteriaMap.containsKey("42"));
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is three.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetRangeCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet SearchFacetRangeCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_thenCriteriaTransferObjectCriteriaMapSizeIsThree() throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(new DynamicResultSet());

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    searchFacetRangeCustomPersistenceHandler.fetch(
        persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(3, criteriaMap.size());
    assertTrue(criteriaMap.containsKey("embeddablePriceList.priceList"));
    assertTrue(criteriaMap.containsKey("maxValue"));
    assertTrue(criteriaMap.containsKey("minValue"));
  }

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is four.
   * </ul>
   *
   * <p>Method under test: {@link
   * SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchFacetRangeCustomPersistenceHandler.addDefaultSort(CriteriaTransferObject)"
  })
  public void testAddDefaultSort_thenCriteriaTransferObjectCriteriaMapSizeIsFour() {
    // Arrange
    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.add(new FilterAndSortCriteria("42"));

    // Act
    searchFacetRangeCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(4, criteriaMap.size());
    assertTrue(criteriaMap.containsKey("42"));
    assertTrue(criteriaMap.containsKey("embeddablePriceList.priceList"));
    assertTrue(criteriaMap.containsKey("maxValue"));
    assertTrue(criteriaMap.containsKey("minValue"));
  }

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchFacetRangeCustomPersistenceHandler.addDefaultSort(CriteriaTransferObject)"
  })
  public void testAddDefaultSort_thenCriteriaTransferObjectCriteriaMapSizeIsOne() {
    // Arrange
    FilterAndSortCriteria criteria = mock(FilterAndSortCriteria.class);
    when(criteria.getPropertyId()).thenReturn("42");
    when(criteria.getSortDirection()).thenReturn(SortDirection.ASCENDING);

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.add(criteria);

    // Act
    searchFacetRangeCustomPersistenceHandler.addDefaultSort(cto);

    // Assert that nothing has changed
    verify(criteria).getPropertyId();
    verify(criteria).getSortDirection();
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    assertTrue(criteriaMap.containsKey("42"));
  }

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchFacetRangeCustomPersistenceHandler.addDefaultSort(CriteriaTransferObject)"
  })
  public void testAddDefaultSort_thenCriteriaTransferObjectCriteriaMapSizeIsThree() {
    // Arrange
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    searchFacetRangeCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(3, criteriaMap.size());
    assertTrue(criteriaMap.containsKey("embeddablePriceList.priceList"));
    assertTrue(criteriaMap.containsKey("maxValue"));
    assertTrue(criteriaMap.containsKey("minValue"));
  }

  /**
   * Test {@link SearchFacetRangeCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SearchFacetRangeCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchFacetRangeCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            searchFacetRangeCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.search.domain.SearchFacetRange"), isNull());
  }
}
