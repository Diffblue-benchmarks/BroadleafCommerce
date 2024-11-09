/*-
 * #%L
 * BroadleafCommerce Admin Module
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenDrJaneDoe() {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_thenReturnTrue() {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(searchFacetRangeCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_givenDrJaneDoe() {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_thenReturnTrue() {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(searchFacetRangeCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  public void testCanHandle_givenDrJaneDoe() {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  public void testCanHandle_thenReturnTrue() {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#canHandle(PersistencePackage)}
   */
  @Test
  public void testCanHandle_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetRangeCustomPersistenceHandler searchFacetRangeCustomPersistenceHandler = new SearchFacetRangeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(searchFacetRangeCustomPersistenceHandler.canHandle(new PersistencePackage()));
  }

  /**
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenCriteriaTransferObjectCriteriaMapSizeIsThree() throws ServiceException {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls
   * {@link CriteriaTransferObject#add(FilterAndSortCriteria)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort_givenHashMap_thenCallsAdd() {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort_thenCriteriaTransferObjectCriteriaMapSizeIsFour() {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort_thenCriteriaTransferObjectCriteriaMapSizeIsThree() {
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
   * Test
   * {@link SearchFacetRangeCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()} Entity is
   * {@link Entity}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetRangeCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testRemove_whenPersistencePackageEntityIsEntity_thenThrowServiceException() throws ServiceException {
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
