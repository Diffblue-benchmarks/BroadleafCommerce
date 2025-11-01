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
import org.mockito.Mockito;

public class SearchFacetRangeCustomPersistenceHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(searchFacetRangeCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = searchFacetRangeCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl");

    // Act
    Boolean actualCanHandleFetchResult = searchFacetRangeCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(searchFacetRangeCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleRemoveResult = searchFacetRangeCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl");

    // Act
    Boolean actualCanHandleRemoveResult = searchFacetRangeCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleRemoveResult);
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  public void testCanHandle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(searchFacetRangeCustomPersistenceHandler.canHandle(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  public void testCanHandle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleResult = searchFacetRangeCustomPersistenceHandler.canHandle(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleResult);
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  public void testCanHandle3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl");

    // Act
    Boolean actualCanHandleResult = searchFacetRangeCustomPersistenceHandler.canHandle(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleResult);
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = searchFacetRangeCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(3, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("embeddablePriceList.priceList");
    assertEquals("embeddablePriceList.priceList", getResult.getPropertyId());
    FilterAndSortCriteria getResult2 = criteriaMap.get("maxValue");
    assertEquals("maxValue", getResult2.getPropertyId());
    FilterAndSortCriteria getResult3 = criteriaMap.get("minValue");
    assertEquals("minValue", getResult3.getPropertyId());
    assertNull(getResult.getRestrictionType());
    assertNull(getResult2.getRestrictionType());
    assertNull(getResult3.getRestrictionType());
    assertEquals(0, getResult.getOrder().intValue());
    assertEquals(1, getResult3.getOrder().intValue());
    assertEquals(2, getResult2.getOrder().intValue());
    assertEquals(SortDirection.ASCENDING, getResult.getSortDirection());
    assertEquals(SortDirection.ASCENDING, getResult2.getSortDirection());
    assertEquals(SortDirection.ASCENDING, getResult3.getSortDirection());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult3.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult2.getSpecialFilterValues().isEmpty());
    assertTrue(getResult3.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.getSortAscending());
    assertTrue(getResult2.getSortAscending());
    assertTrue(getResult3.getSortAscending());
    assertTrue(getResult.isNullsLast());
    assertTrue(getResult2.isNullsLast());
    assertTrue(getResult3.isNullsLast());
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    searchFacetRangeCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(3, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("embeddablePriceList.priceList");
    assertEquals("embeddablePriceList.priceList", getResult.getPropertyId());
    FilterAndSortCriteria getResult2 = criteriaMap.get("maxValue");
    assertEquals("maxValue", getResult2.getPropertyId());
    FilterAndSortCriteria getResult3 = criteriaMap.get("minValue");
    assertEquals("minValue", getResult3.getPropertyId());
    assertNull(getResult.getRestrictionType());
    assertNull(getResult2.getRestrictionType());
    assertNull(getResult3.getRestrictionType());
    assertEquals(0, getResult.getOrder().intValue());
    assertEquals(1, getResult3.getOrder().intValue());
    assertEquals(2, getResult2.getOrder().intValue());
    assertEquals(SortDirection.ASCENDING, getResult.getSortDirection());
    assertEquals(SortDirection.ASCENDING, getResult2.getSortDirection());
    assertEquals(SortDirection.ASCENDING, getResult3.getSortDirection());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult3.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult2.getSpecialFilterValues().isEmpty());
    assertTrue(getResult3.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.getSortAscending());
    assertTrue(getResult2.getSortAscending());
    assertTrue(getResult3.getSortAscending());
    assertTrue(getResult.isNullsLast());
    assertTrue(getResult2.isNullsLast());
    assertTrue(getResult3.isNullsLast());
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.add(new FilterAndSortCriteria("42"));

    // Act
    searchFacetRangeCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(4, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("embeddablePriceList.priceList");
    assertEquals("embeddablePriceList.priceList", getResult.getPropertyId());
    FilterAndSortCriteria getResult2 = criteriaMap.get("maxValue");
    assertEquals("maxValue", getResult2.getPropertyId());
    FilterAndSortCriteria getResult3 = criteriaMap.get("minValue");
    assertEquals("minValue", getResult3.getPropertyId());
    assertNull(getResult.getRestrictionType());
    assertNull(getResult2.getRestrictionType());
    assertNull(getResult3.getRestrictionType());
    assertEquals(0, getResult.getOrder().intValue());
    assertEquals(1, getResult3.getOrder().intValue());
    assertEquals(2, getResult2.getOrder().intValue());
    assertEquals(SortDirection.ASCENDING, getResult.getSortDirection());
    assertEquals(SortDirection.ASCENDING, getResult2.getSortDirection());
    assertEquals(SortDirection.ASCENDING, getResult3.getSortDirection());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult3.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult2.getSpecialFilterValues().isEmpty());
    assertTrue(getResult3.getSpecialFilterValues().isEmpty());
    assertTrue(criteriaMap.containsKey("42"));
    assertTrue(getResult.getSortAscending());
    assertTrue(getResult2.getSortAscending());
    assertTrue(getResult3.getSortAscending());
    assertTrue(getResult.isNullsLast());
    assertTrue(getResult2.isNullsLast());
    assertTrue(getResult3.isNullsLast());
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    cto.add(new FilterAndSortCriteria("42"));

    // Act
    searchFacetRangeCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    verify(cto, atLeast(1)).add(Mockito.<FilterAndSortCriteria>any());
    verify(cto, atLeast(1)).getCriteriaMap();
  }

  /**
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testRemove() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> searchFacetRangeCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.search.domain.SearchFacetRange"), isNull());
  }
}
