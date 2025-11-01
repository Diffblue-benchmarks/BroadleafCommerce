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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionType;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class FilterAndSortCriteriaDiffblueTest {
  @MockBean
  private FilterAndSortCriteria filterAndSortCriteria;

  /**
   * Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  public void testGetFilterValues() {
    // Arrange, Act and Assert
    assertTrue((new FilterAndSortCriteria("42")).getFilterValues().isEmpty());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  public void testGetFilterValues2() {
    // Arrange and Act
    List<String> actualFilterValues = (new FilterAndSortCriteria("42", "42")).getFilterValues();

    // Assert
    assertEquals(1, actualFilterValues.size());
    assertEquals("42", actualFilterValues.get(0));
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  public void testGetFilterValues3() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NOT_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  public void testGetFilterValues4() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  public void testGetSpecialFilterValues() {
    // Arrange, Act and Assert
    assertTrue((new FilterAndSortCriteria("42")).getSpecialFilterValues().isEmpty());
    assertTrue((new FilterAndSortCriteria("42", "42")).getSpecialFilterValues().isEmpty());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  public void testGetSpecialFilterValues2() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NOT_NULL_FILTER_VALUE);

    // Act
    List<String> actualSpecialFilterValues = filterAndSortCriteria.getSpecialFilterValues();

    // Assert
    assertEquals(1, actualSpecialFilterValues.size());
    assertEquals(FilterAndSortCriteria.IS_NOT_NULL_FILTER_VALUE, actualSpecialFilterValues.get(0));
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  public void testGetSpecialFilterValues3() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NULL_FILTER_VALUE);

    // Act
    List<String> actualSpecialFilterValues = filterAndSortCriteria.getSpecialFilterValues();

    // Assert
    assertEquals(1, actualSpecialFilterValues.size());
    assertEquals(FilterAndSortCriteria.IS_NULL_FILTER_VALUE, actualSpecialFilterValues.get(0));
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#getSortAscending()}
   */
  @Test
  public void testGetSortAscending() {
    // Arrange, Act and Assert
    assertNull((new FilterAndSortCriteria("42")).getSortAscending());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#getSortAscending()}
   */
  @Test
  public void testGetSortAscending2() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setSortAscending(true);

    // Act and Assert
    assertTrue(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#getSortAscending()}
   */
  @Test
  public void testGetSortAscending3() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setSortAscending(false);

    // Act and Assert
    assertFalse(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String)}
   */
  @Test
  public void testNewFilterAndSortCriteria() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", "42");

    // Assert
    List<String> filterValues = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("42", filterValues.get(0));
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getOrder());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria2() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", "42", 1);

    // Assert
    List<String> filterValues = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("42", filterValues.get(0));
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualFilterAndSortCriteria.getOrder().intValue());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}
   */
  @Test
  public void testNewFilterAndSortCriteria3() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", new ArrayList<>());

    // Assert
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getOrder());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertTrue(actualFilterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.filterValues.isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}
   */
  @Test
  public void testNewFilterAndSortCriteria4() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", filterValues);

    // Assert
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    List<String> filterValues2 = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues2.size());
    assertEquals("foo", filterValues2.get(0));
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getOrder());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}
   */
  @Test
  public void testNewFilterAndSortCriteria5() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", filterValues);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertEquals("foo", stringList.get(1));
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getOrder());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
    List<String> expectedFilterValues = actualFilterAndSortCriteria.filterValues;
    assertEquals(expectedFilterValues, actualFilterAndSortCriteria.getFilterValues());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria6() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", new ArrayList<>(), 1);

    // Assert
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualFilterAndSortCriteria.getOrder().intValue());
    assertTrue(actualFilterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.filterValues.isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria7() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", filterValues, 1);

    // Assert
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    List<String> filterValues2 = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues2.size());
    assertEquals("foo", filterValues2.get(0));
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualFilterAndSortCriteria.getOrder().intValue());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria8() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", filterValues, 1);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertEquals("foo", stringList.get(1));
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualFilterAndSortCriteria.getOrder().intValue());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
    List<String> expectedFilterValues = actualFilterAndSortCriteria.filterValues;
    assertEquals(expectedFilterValues, actualFilterAndSortCriteria.getFilterValues());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}
   */
  @Test
  public void testNewFilterAndSortCriteria9() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", new ArrayList<>(),
        SortDirection.ASCENDING);

    // Assert
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertNull(actualFilterAndSortCriteria.getOrder());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(SortDirection.ASCENDING, actualFilterAndSortCriteria.getSortDirection());
    assertTrue(actualFilterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.filterValues.isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSortAscending());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}
   */
  @Test
  public void testNewFilterAndSortCriteria10() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", filterValues,
        SortDirection.ASCENDING);

    // Assert
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    List<String> filterValues2 = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues2.size());
    assertEquals("foo", filterValues2.get(0));
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
    assertNull(actualFilterAndSortCriteria.getOrder());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(SortDirection.ASCENDING, actualFilterAndSortCriteria.getSortDirection());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSortAscending());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}
   */
  @Test
  public void testNewFilterAndSortCriteria11() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", filterValues,
        SortDirection.ASCENDING);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertEquals("foo", stringList.get(1));
    assertNull(actualFilterAndSortCriteria.getOrder());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(SortDirection.ASCENDING, actualFilterAndSortCriteria.getSortDirection());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSortAscending());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
    List<String> expectedFilterValues = actualFilterAndSortCriteria.filterValues;
    assertEquals(expectedFilterValues, actualFilterAndSortCriteria.getFilterValues());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria12() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", new ArrayList<>(),
        SortDirection.ASCENDING, 1);

    // Assert
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualFilterAndSortCriteria.getOrder().intValue());
    assertEquals(SortDirection.ASCENDING, actualFilterAndSortCriteria.getSortDirection());
    assertTrue(actualFilterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.filterValues.isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSortAscending());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria13() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", filterValues,
        SortDirection.ASCENDING, 1);

    // Assert
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    List<String> filterValues2 = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues2.size());
    assertEquals("foo", filterValues2.get(0));
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualFilterAndSortCriteria.getOrder().intValue());
    assertEquals(SortDirection.ASCENDING, actualFilterAndSortCriteria.getSortDirection());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSortAscending());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria14() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", filterValues,
        SortDirection.ASCENDING, 1);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertEquals("foo", stringList.get(1));
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualFilterAndSortCriteria.getOrder().intValue());
    assertEquals(SortDirection.ASCENDING, actualFilterAndSortCriteria.getSortDirection());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.getSortAscending());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
    List<String> expectedFilterValues = actualFilterAndSortCriteria.filterValues;
    assertEquals(expectedFilterValues, actualFilterAndSortCriteria.getFilterValues());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String[])}
   */
  @Test
  public void testNewFilterAndSortCriteria15() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", new String[]{"42"});

    // Assert
    List<String> filterValues = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("42", filterValues.get(0));
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getOrder());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String[], int)}
   */
  @Test
  public void testNewFilterAndSortCriteria16() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", new String[]{"42"}, 1);

    // Assert
    List<String> filterValues = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("42", filterValues.get(0));
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("42", actualFilterAndSortCriteria.getPropertyId());
    assertNull(actualFilterAndSortCriteria.getSortAscending());
    assertNull(actualFilterAndSortCriteria.getSortDirection());
    assertNull(actualFilterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualFilterAndSortCriteria.getOrder().intValue());
    assertTrue(actualFilterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(actualFilterAndSortCriteria.isNullsLast());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#setSortAscending(Boolean)}
   */
  @Test
  public void testSetSortAscending() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    filterAndSortCriteria.setSortAscending(true);

    // Assert
    assertEquals(SortDirection.ASCENDING, filterAndSortCriteria.getSortDirection());
    assertTrue(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#setSortAscending(Boolean)}
   */
  @Test
  public void testSetSortAscending2() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    filterAndSortCriteria.setSortAscending(null);

    // Assert
    assertEquals(SortDirection.ASCENDING, filterAndSortCriteria.getSortDirection());
    assertTrue(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#setSortAscending(Boolean)}
   */
  @Test
  public void testSetSortAscending3() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    filterAndSortCriteria.setSortAscending(false);

    // Assert
    assertEquals(SortDirection.DESCENDING, filterAndSortCriteria.getSortDirection());
    assertFalse(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  public void testHasSpecialFilterValue() {
    // Arrange, Act and Assert
    assertFalse((new FilterAndSortCriteria("42")).hasSpecialFilterValue());
    assertFalse((new FilterAndSortCriteria("42", "42")).hasSpecialFilterValue());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  public void testHasSpecialFilterValue2() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setFilterValues(null);

    // Act and Assert
    assertFalse(filterAndSortCriteria.hasSpecialFilterValue());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  public void testHasSpecialFilterValue3() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NOT_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.hasSpecialFilterValue());
  }

  /**
   * Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  public void testHasSpecialFilterValue4() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.hasSpecialFilterValue());
  }

  /**
   * Method under test:
   * {@link FilterAndSortCriteria#getPredicateForSpecialValues(boolean)}
   */
  @Test
  public void testGetPredicateForSpecialValues() {
    // Arrange, Act and Assert
    assertFalse((new FilterAndSortCriteria("42")).getPredicateForSpecialValues(true).evaluate("Value"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FilterAndSortCriteria#FilterAndSortCriteria(String)}
   *   <li>{@link FilterAndSortCriteria#setFilterValues(List)}
   *   <li>{@link FilterAndSortCriteria#setNullsLast(boolean)}
   *   <li>{@link FilterAndSortCriteria#setOrder(Integer)}
   *   <li>{@link FilterAndSortCriteria#setPropertyId(String)}
   *   <li>{@link FilterAndSortCriteria#setRestrictionType(RestrictionType)}
   *   <li>{@link FilterAndSortCriteria#setSortDirection(SortDirection)}
   *   <li>{@link FilterAndSortCriteria#getOrder()}
   *   <li>{@link FilterAndSortCriteria#getPropertyId()}
   *   <li>{@link FilterAndSortCriteria#getRestrictionType()}
   *   <li>{@link FilterAndSortCriteria#getSortDirection()}
   *   <li>{@link FilterAndSortCriteria#isNullsLast()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42");
    actualFilterAndSortCriteria.setFilterValues(new ArrayList<>());
    actualFilterAndSortCriteria.setNullsLast(true);
    actualFilterAndSortCriteria.setOrder(1);
    actualFilterAndSortCriteria.setPropertyId("42");
    actualFilterAndSortCriteria.setRestrictionType(RestrictionType.BOOLEAN);
    actualFilterAndSortCriteria.setSortDirection(SortDirection.ASCENDING);
    Integer actualOrder = actualFilterAndSortCriteria.getOrder();
    String actualPropertyId = actualFilterAndSortCriteria.getPropertyId();
    RestrictionType actualRestrictionType = actualFilterAndSortCriteria.getRestrictionType();
    SortDirection actualSortDirection = actualFilterAndSortCriteria.getSortDirection();
    boolean actualIsNullsLastResult = actualFilterAndSortCriteria.isNullsLast();

    // Assert that nothing has changed
    assertEquals("42", actualPropertyId);
    assertEquals(1, actualOrder.intValue());
    assertEquals(SortDirection.ASCENDING, actualSortDirection);
    assertTrue(actualFilterAndSortCriteria.filterValues.isEmpty());
    assertTrue(actualIsNullsLastResult);
    assertSame(actualRestrictionType.BOOLEAN, actualRestrictionType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FilterAndSortCriteria#FilterAndSortCriteria(String, int)}
   *   <li>{@link FilterAndSortCriteria#setFilterValues(List)}
   *   <li>{@link FilterAndSortCriteria#setNullsLast(boolean)}
   *   <li>{@link FilterAndSortCriteria#setOrder(Integer)}
   *   <li>{@link FilterAndSortCriteria#setPropertyId(String)}
   *   <li>{@link FilterAndSortCriteria#setRestrictionType(RestrictionType)}
   *   <li>{@link FilterAndSortCriteria#setSortDirection(SortDirection)}
   *   <li>{@link FilterAndSortCriteria#getOrder()}
   *   <li>{@link FilterAndSortCriteria#getPropertyId()}
   *   <li>{@link FilterAndSortCriteria#getRestrictionType()}
   *   <li>{@link FilterAndSortCriteria#getSortDirection()}
   *   <li>{@link FilterAndSortCriteria#isNullsLast()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria = new FilterAndSortCriteria("42", 1);
    actualFilterAndSortCriteria.setFilterValues(new ArrayList<>());
    actualFilterAndSortCriteria.setNullsLast(true);
    actualFilterAndSortCriteria.setOrder(1);
    actualFilterAndSortCriteria.setPropertyId("42");
    actualFilterAndSortCriteria.setRestrictionType(RestrictionType.BOOLEAN);
    actualFilterAndSortCriteria.setSortDirection(SortDirection.ASCENDING);
    Integer actualOrder = actualFilterAndSortCriteria.getOrder();
    String actualPropertyId = actualFilterAndSortCriteria.getPropertyId();
    RestrictionType actualRestrictionType = actualFilterAndSortCriteria.getRestrictionType();
    SortDirection actualSortDirection = actualFilterAndSortCriteria.getSortDirection();
    boolean actualIsNullsLastResult = actualFilterAndSortCriteria.isNullsLast();

    // Assert that nothing has changed
    assertEquals("42", actualPropertyId);
    assertEquals(1, actualOrder.intValue());
    assertEquals(SortDirection.ASCENDING, actualSortDirection);
    assertTrue(actualFilterAndSortCriteria.filterValues.isEmpty());
    assertTrue(actualIsNullsLastResult);
    assertSame(actualRestrictionType.BOOLEAN, actualRestrictionType);
  }
}
