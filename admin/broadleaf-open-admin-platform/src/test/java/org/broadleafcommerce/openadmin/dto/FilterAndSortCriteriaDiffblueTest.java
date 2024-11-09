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
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionType;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class FilterAndSortCriteriaDiffblueTest {
  @MockBean
  private FilterAndSortCriteria filterAndSortCriteria;

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
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
  public void testGettersAndSetters_when42() {
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
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
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
  public void testGettersAndSetters_whenOne() {
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

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String)}.
   * <p>
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
   * Test
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String, int)}.
   * <p>
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
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String[])}.
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String[])}
   */
  @Test
  public void testNewFilterAndSortCriteria3() {
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
   * Test
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String[], int)}.
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String[], int)}
   */
  @Test
  public void testNewFilterAndSortCriteria4() {
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
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}
   */
  @Test
  public void testNewFilterAndSortCriteria_given42_thenReturnFilterValuesSizeIsTwo() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act and Assert
    List<String> stringList = (new FilterAndSortCriteria("42", filterValues)).filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria_given42_thenReturnFilterValuesSizeIsTwo2() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act and Assert
    List<String> stringList = (new FilterAndSortCriteria("42", filterValues, 1)).filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }

  /**
   * Test
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}
   */
  @Test
  public void testNewFilterAndSortCriteria_given42_thenReturnFilterValuesSizeIsTwo3() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act and Assert
    List<String> stringList = (new FilterAndSortCriteria("42", filterValues, SortDirection.ASCENDING)).filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }

  /**
   * Test
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria_given42_thenReturnFilterValuesSizeIsTwo4() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act and Assert
    List<String> stringList = (new FilterAndSortCriteria("42", filterValues, SortDirection.ASCENDING, 1)).filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}
   */
  @Test
  public void testNewFilterAndSortCriteria_givenFoo_thenReturnFilterValuesSizeIsOne() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act and Assert
    List<String> stringList = (new FilterAndSortCriteria("42", filterValues)).filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria_givenFoo_thenReturnFilterValuesSizeIsOne2() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act and Assert
    List<String> stringList = (new FilterAndSortCriteria("42", filterValues, 1)).filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}
   */
  @Test
  public void testNewFilterAndSortCriteria_givenFoo_thenReturnFilterValuesSizeIsOne3() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act and Assert
    List<String> stringList = (new FilterAndSortCriteria("42", filterValues, SortDirection.ASCENDING)).filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria_givenFoo_thenReturnFilterValuesSizeIsOne4() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act and Assert
    List<String> stringList = (new FilterAndSortCriteria("42", filterValues, SortDirection.ASCENDING, 1)).filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return PropertyId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}
   */
  @Test
  public void testNewFilterAndSortCriteria_whenArrayList_thenReturnPropertyIdIs42() {
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
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return PropertyId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria_whenArrayList_thenReturnPropertyIdIs422() {
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
   * Test
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return PropertyId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}
   */
  @Test
  public void testNewFilterAndSortCriteria_whenArrayList_thenReturnPropertyIdIs423() {
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
   * Test
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return PropertyId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}
   */
  @Test
  public void testNewFilterAndSortCriteria_whenArrayList_thenReturnPropertyIdIs424() {
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
   * Test {@link FilterAndSortCriteria#getFilterValues()}.
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  public void testGetFilterValues() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NOT_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getFilterValues()}.
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  public void testGetFilterValues2() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getFilterValues()}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with
   * propertyId is {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  public void testGetFilterValues_givenFilterAndSortCriteriaWithPropertyIdIs42_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new FilterAndSortCriteria("42")).getFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getFilterValues()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  public void testGetFilterValues_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualFilterValues = (new FilterAndSortCriteria("42", "42")).getFilterValues();

    // Assert
    assertEquals(1, actualFilterValues.size());
    assertEquals("42", actualFilterValues.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#getSpecialFilterValues()}.
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  public void testGetSpecialFilterValues() {
    // Arrange, Act and Assert
    assertTrue((new FilterAndSortCriteria("42", "42")).getSpecialFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getSpecialFilterValues()}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with
   * propertyId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  public void testGetSpecialFilterValues_givenFilterAndSortCriteriaWithPropertyIdIs42() {
    // Arrange, Act and Assert
    assertTrue((new FilterAndSortCriteria("42")).getSpecialFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getSpecialFilterValues()}.
   * <ul>
   *   <li>Then return first is
   * {@link FilterAndSortCriteria#IS_NOT_NULL_FILTER_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  public void testGetSpecialFilterValues_thenReturnFirstIsIs_not_null_filter_value() {
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
   * Test {@link FilterAndSortCriteria#getSpecialFilterValues()}.
   * <ul>
   *   <li>Then return first is
   * {@link FilterAndSortCriteria#IS_NULL_FILTER_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  public void testGetSpecialFilterValues_thenReturnFirstIsIs_null_filter_value() {
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
   * Test {@link FilterAndSortCriteria#getSortAscending()}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with
   * propertyId is {@code 42}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getSortAscending()}
   */
  @Test
  public void testGetSortAscending_givenFilterAndSortCriteriaWithPropertyIdIs42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FilterAndSortCriteria("42")).getSortAscending());
  }

  /**
   * Test {@link FilterAndSortCriteria#getSortAscending()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getSortAscending()}
   */
  @Test
  public void testGetSortAscending_thenReturnFalse() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setSortAscending(false);

    // Act and Assert
    assertFalse(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Test {@link FilterAndSortCriteria#getSortAscending()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#getSortAscending()}
   */
  @Test
  public void testGetSortAscending_thenReturnTrue() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setSortAscending(true);

    // Act and Assert
    assertTrue(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Test {@link FilterAndSortCriteria#setSortAscending(Boolean)}.
   * <p>
   * Method under test: {@link FilterAndSortCriteria#setSortAscending(Boolean)}
   */
  @Test
  public void testSetSortAscending() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    filterAndSortCriteria.setSortAscending(false);

    // Assert
    assertEquals(SortDirection.DESCENDING, filterAndSortCriteria.getSortDirection());
    assertFalse(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Test {@link FilterAndSortCriteria#setSortAscending(Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#setSortAscending(Boolean)}
   */
  @Test
  public void testSetSortAscending_whenNull() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    filterAndSortCriteria.setSortAscending(null);

    // Assert
    assertEquals(SortDirection.ASCENDING, filterAndSortCriteria.getSortDirection());
    assertTrue(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Test {@link FilterAndSortCriteria#setSortAscending(Boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#setSortAscending(Boolean)}
   */
  @Test
  public void testSetSortAscending_whenTrue() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    filterAndSortCriteria.setSortAscending(true);

    // Assert
    assertEquals(SortDirection.ASCENDING, filterAndSortCriteria.getSortDirection());
    assertTrue(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Test {@link FilterAndSortCriteria#hasSpecialFilterValue()}.
   * <p>
   * Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  public void testHasSpecialFilterValue() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setFilterValues(null);

    // Act and Assert
    assertFalse(filterAndSortCriteria.hasSpecialFilterValue());
  }

  /**
   * Test {@link FilterAndSortCriteria#hasSpecialFilterValue()}.
   * <p>
   * Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  public void testHasSpecialFilterValue2() {
    // Arrange, Act and Assert
    assertFalse((new FilterAndSortCriteria("42", "42")).hasSpecialFilterValue());
  }

  /**
   * Test {@link FilterAndSortCriteria#hasSpecialFilterValue()}.
   * <p>
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
   * Test {@link FilterAndSortCriteria#hasSpecialFilterValue()}.
   * <p>
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
   * Test {@link FilterAndSortCriteria#hasSpecialFilterValue()}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with
   * propertyId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  public void testHasSpecialFilterValue_givenFilterAndSortCriteriaWithPropertyIdIs42() {
    // Arrange, Act and Assert
    assertFalse((new FilterAndSortCriteria("42")).hasSpecialFilterValue());
  }

  /**
   * Test {@link FilterAndSortCriteria#getPredicateForSpecialValues(boolean)}.
   * <p>
   * Method under test:
   * {@link FilterAndSortCriteria#getPredicateForSpecialValues(boolean)}
   */
  @Test
  public void testGetPredicateForSpecialValues() {
    // Arrange, Act and Assert
    assertFalse((new FilterAndSortCriteria("42")).getPredicateForSpecialValues(true).evaluate("Value"));
  }
}
