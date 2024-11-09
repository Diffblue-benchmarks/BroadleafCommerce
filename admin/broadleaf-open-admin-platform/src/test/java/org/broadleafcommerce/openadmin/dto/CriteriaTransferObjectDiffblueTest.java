/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CriteriaTransferObject.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CriteriaTransferObjectDiffblueTest {
  @Autowired
  private CriteriaTransferObject criteriaTransferObject;

  /**
   * Test {@link CriteriaTransferObject#add(FilterAndSortCriteria)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTransferObject#add(FilterAndSortCriteria)}
   */
  @Test
  public void testAdd_thenCriteriaTransferObjectCriteriaMapSizeIsOne() {
    // Arrange
    CriteriaTransferObject criteriaTransferObject = new CriteriaTransferObject();
    FilterAndSortCriteria criteria = new FilterAndSortCriteria("42");

    // Act
    criteriaTransferObject.add(criteria);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = criteriaTransferObject.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    assertSame(criteria, criteriaMap.get("42"));
  }

  /**
   * Test {@link CriteriaTransferObject#addAll(Collection)}.
   * <p>
   * Method under test: {@link CriteriaTransferObject#addAll(Collection)}
   */
  @Test
  public void testAddAll() {
    // Arrange
    CriteriaTransferObject criteriaTransferObject = new CriteriaTransferObject();

    ArrayList<FilterAndSortCriteria> criterias = new ArrayList<>();
    criterias.add(new FilterAndSortCriteria("42"));
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    criterias.add(filterAndSortCriteria);

    // Act
    criteriaTransferObject.addAll(criterias);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = criteriaTransferObject.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    assertSame(filterAndSortCriteria, criteriaMap.get("42"));
  }

  /**
   * Test {@link CriteriaTransferObject#addAll(Collection)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * {@code 42} PropertyId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTransferObject#addAll(Collection)}
   */
  @Test
  public void testAddAll_thenCriteriaTransferObjectCriteriaMap42PropertyIdIs42() {
    // Arrange
    CriteriaTransferObject criteriaTransferObject = new CriteriaTransferObject();

    LinkedHashSet<FilterAndSortCriteria> criterias = new LinkedHashSet<>();
    criterias.add(new FilterAndSortCriteria("42"));

    // Act
    criteriaTransferObject.addAll(criterias);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = criteriaTransferObject.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("42");
    assertEquals("42", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.filterValues.isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link CriteriaTransferObject#addAll(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTransferObject#addAll(Collection)}
   */
  @Test
  public void testAddAll_whenArrayList_thenCriteriaTransferObjectCriteriaMapEmpty() {
    // Arrange
    CriteriaTransferObject criteriaTransferObject = new CriteriaTransferObject();

    // Act
    criteriaTransferObject.addAll(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(criteriaTransferObject.getCriteriaMap().isEmpty());
  }

  /**
   * Test {@link CriteriaTransferObject#get(String)}.
   * <p>
   * Method under test: {@link CriteriaTransferObject#get(String)}
   */
  @Test
  public void testGet() {
    // Arrange and Act
    FilterAndSortCriteria actualGetResult = criteriaTransferObject
        .get("org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria");

    // Assert
    assertEquals("org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria", actualGetResult.getPropertyId());
    assertNull(actualGetResult.getSortAscending());
    assertNull(actualGetResult.getOrder());
    assertNull(actualGetResult.getSortDirection());
    assertNull(actualGetResult.getRestrictionType());
    Map<String, FilterAndSortCriteria> criteriaMap = criteriaTransferObject.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    assertTrue(actualGetResult.getFilterValues().isEmpty());
    assertTrue(actualGetResult.getSpecialFilterValues().isEmpty());
    assertTrue(actualGetResult.filterValues.isEmpty());
    assertTrue(criteriaMap.containsKey("org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria"));
    assertTrue(actualGetResult.isNullsLast());
  }

  /**
   * Test {@link CriteriaTransferObject#get(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return PropertyId is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTransferObject#get(String)}
   */
  @Test
  public void testGet_whenName_thenReturnPropertyIdIsName() {
    // Arrange and Act
    FilterAndSortCriteria actualGetResult = criteriaTransferObject.get("Name");

    // Assert
    assertEquals("Name", actualGetResult.getPropertyId());
    assertNull(actualGetResult.getSortAscending());
    assertNull(actualGetResult.getOrder());
    assertNull(actualGetResult.getSortDirection());
    assertNull(actualGetResult.getRestrictionType());
    Map<String, FilterAndSortCriteria> criteriaMap = criteriaTransferObject.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    assertTrue(actualGetResult.getFilterValues().isEmpty());
    assertTrue(actualGetResult.getSpecialFilterValues().isEmpty());
    assertTrue(actualGetResult.filterValues.isEmpty());
    assertTrue(criteriaMap.containsKey("Name"));
    assertTrue(actualGetResult.isNullsLast());
  }

  /**
   * Test
   * {@link CriteriaTransferObject#defaultSortDirectionForFieldIfUnset(String, SortDirection)}.
   * <p>
   * Method under test:
   * {@link CriteriaTransferObject#defaultSortDirectionForFieldIfUnset(String, SortDirection)}
   */
  @Test
  public void testDefaultSortDirectionForFieldIfUnset() {
    // Arrange and Act
    criteriaTransferObject.defaultSortDirectionForFieldIfUnset("Name", SortDirection.ASCENDING);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = criteriaTransferObject.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("Name");
    assertEquals("Name", getResult.getPropertyId());
    assertNull(getResult.getOrder());
    assertNull(getResult.getRestrictionType());
    assertEquals(SortDirection.ASCENDING, getResult.getSortDirection());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.filterValues.isEmpty());
    assertTrue(getResult.getSortAscending());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link CriteriaTransferObject#isFolderLookup()}.
   * <ul>
   *   <li>Given {@link CriteriaTransferObject} (default constructor) FolderLookup
   * is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTransferObject#isFolderLookup()}
   */
  @Test
  public void testIsFolderLookup_givenCriteriaTransferObjectFolderLookupIsTrue_thenReturnTrue() {
    // Arrange
    CriteriaTransferObject criteriaTransferObject = new CriteriaTransferObject();
    criteriaTransferObject.setFolderLookup(true);

    // Act and Assert
    assertTrue(criteriaTransferObject.isFolderLookup());
  }

  /**
   * Test {@link CriteriaTransferObject#isFolderLookup()}.
   * <ul>
   *   <li>Given {@link CriteriaTransferObject} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTransferObject#isFolderLookup()}
   */
  @Test
  public void testIsFolderLookup_givenCriteriaTransferObject_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new CriteriaTransferObject()).isFolderLookup());
  }

  /**
   * Test {@link CriteriaTransferObject#isFolderLookup()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CriteriaTransferObject#isFolderLookup()}
   */
  @Test
  public void testIsFolderLookup_givenHashMapComputeIfPresentFooAndBiFunction_thenReturnFalse() {
    // Arrange
    HashMap<String, FilterAndSortCriteria> criteriaMap = new HashMap<>();
    criteriaMap.computeIfPresent("foo", mock(BiFunction.class));

    CriteriaTransferObject criteriaTransferObject = new CriteriaTransferObject();
    criteriaTransferObject.setCriteriaMap(criteriaMap);

    // Act and Assert
    assertFalse(criteriaTransferObject.isFolderLookup());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CriteriaTransferObject}
   *   <li>{@link CriteriaTransferObject#setAdditionalFilterMappings(List)}
   *   <li>{@link CriteriaTransferObject#setCriteriaMap(Map)}
   *   <li>{@link CriteriaTransferObject#setFirstId(Long)}
   *   <li>{@link CriteriaTransferObject#setFirstResult(Integer)}
   *   <li>{@link CriteriaTransferObject#setFolderId(Long)}
   *   <li>{@link CriteriaTransferObject#setFolderLookup(Boolean)}
   *   <li>{@link CriteriaTransferObject#setLastId(Long)}
   *   <li>{@link CriteriaTransferObject#setLowerCount(Integer)}
   *   <li>{@link CriteriaTransferObject#setMaxResults(Integer)}
   *   <li>{@link CriteriaTransferObject#setNonCountAdditionalFilterMappings(List)}
   *   <li>{@link CriteriaTransferObject#setPresentationFetch(Boolean)}
   *   <li>{@link CriteriaTransferObject#setUpperCount(Integer)}
   *   <li>{@link CriteriaTransferObject#getAdditionalFilterMappings()}
   *   <li>{@link CriteriaTransferObject#getCriteriaMap()}
   *   <li>{@link CriteriaTransferObject#getFirstId()}
   *   <li>{@link CriteriaTransferObject#getFirstResult()}
   *   <li>{@link CriteriaTransferObject#getFolderId()}
   *   <li>{@link CriteriaTransferObject#getLastId()}
   *   <li>{@link CriteriaTransferObject#getLowerCount()}
   *   <li>{@link CriteriaTransferObject#getMaxResults()}
   *   <li>{@link CriteriaTransferObject#getNonCountAdditionalFilterMappings()}
   *   <li>{@link CriteriaTransferObject#getPresentationFetch()}
   *   <li>{@link CriteriaTransferObject#getUpperCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CriteriaTransferObject actualCriteriaTransferObject = new CriteriaTransferObject();
    ArrayList<FilterMapping> additionalFilterMappings = new ArrayList<>();
    actualCriteriaTransferObject.setAdditionalFilterMappings(additionalFilterMappings);
    HashMap<String, FilterAndSortCriteria> criteriaMap = new HashMap<>();
    actualCriteriaTransferObject.setCriteriaMap(criteriaMap);
    actualCriteriaTransferObject.setFirstId(1L);
    actualCriteriaTransferObject.setFirstResult(1);
    actualCriteriaTransferObject.setFolderId(1L);
    actualCriteriaTransferObject.setFolderLookup(true);
    actualCriteriaTransferObject.setLastId(1L);
    actualCriteriaTransferObject.setLowerCount(3);
    actualCriteriaTransferObject.setMaxResults(3);
    ArrayList<FilterMapping> nonCountAdditionalFilterMappings = new ArrayList<>();
    actualCriteriaTransferObject.setNonCountAdditionalFilterMappings(nonCountAdditionalFilterMappings);
    actualCriteriaTransferObject.setPresentationFetch(true);
    actualCriteriaTransferObject.setUpperCount(3);
    List<FilterMapping> actualAdditionalFilterMappings = actualCriteriaTransferObject.getAdditionalFilterMappings();
    Map<String, FilterAndSortCriteria> actualCriteriaMap = actualCriteriaTransferObject.getCriteriaMap();
    Long actualFirstId = actualCriteriaTransferObject.getFirstId();
    Integer actualFirstResult = actualCriteriaTransferObject.getFirstResult();
    Long actualFolderId = actualCriteriaTransferObject.getFolderId();
    Long actualLastId = actualCriteriaTransferObject.getLastId();
    Integer actualLowerCount = actualCriteriaTransferObject.getLowerCount();
    Integer actualMaxResults = actualCriteriaTransferObject.getMaxResults();
    List<FilterMapping> actualNonCountAdditionalFilterMappings = actualCriteriaTransferObject
        .getNonCountAdditionalFilterMappings();
    Boolean actualPresentationFetch = actualCriteriaTransferObject.getPresentationFetch();
    Integer actualUpperCount = actualCriteriaTransferObject.getUpperCount();

    // Assert that nothing has changed
    assertEquals(1, actualFirstResult.intValue());
    assertEquals(1L, actualFirstId.longValue());
    assertEquals(1L, actualFolderId.longValue());
    assertEquals(1L, actualLastId.longValue());
    assertEquals(3, actualLowerCount.intValue());
    assertEquals(3, actualMaxResults.intValue());
    assertEquals(3, actualUpperCount.intValue());
    assertTrue(actualAdditionalFilterMappings.isEmpty());
    assertTrue(actualNonCountAdditionalFilterMappings.isEmpty());
    assertTrue(actualCriteriaMap.isEmpty());
    assertTrue(actualPresentationFetch);
    assertSame(additionalFilterMappings, actualAdditionalFilterMappings);
    assertSame(nonCountAdditionalFilterMappings, actualNonCountAdditionalFilterMappings);
    assertSame(criteriaMap, actualCriteriaMap);
  }
}
