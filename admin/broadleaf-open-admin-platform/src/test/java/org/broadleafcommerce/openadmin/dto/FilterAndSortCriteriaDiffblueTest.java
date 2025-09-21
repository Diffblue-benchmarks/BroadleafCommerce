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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FilterAndSortCriteriaDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FilterAndSortCriteria.<init>(String)",
    "void FilterAndSortCriteria.<init>(String, int)",
    "Integer FilterAndSortCriteria.getOrder()",
    "String FilterAndSortCriteria.getPropertyId()",
    "RestrictionType FilterAndSortCriteria.getRestrictionType()",
    "SortDirection FilterAndSortCriteria.getSortDirection()",
    "boolean FilterAndSortCriteria.isNullsLast()",
    "void FilterAndSortCriteria.setFilterValues(List)",
    "void FilterAndSortCriteria.setNullsLast(boolean)",
    "void FilterAndSortCriteria.setOrder(Integer)",
    "void FilterAndSortCriteria.setPropertyId(String)",
    "void FilterAndSortCriteria.setRestrictionType(RestrictionType)",
    "void FilterAndSortCriteria.setSortDirection(SortDirection)"
  })
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

    // Assert
    assertEquals("42", actualPropertyId);
    assertEquals(1, actualOrder.intValue());
    assertEquals(SortDirection.ASCENDING, actualSortDirection);
    assertTrue(actualFilterAndSortCriteria.filterValues.isEmpty());
    assertTrue(actualIsNullsLastResult);
    assertSame(RestrictionType.BOOLEAN, actualRestrictionType);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FilterAndSortCriteria.<init>(String)",
    "void FilterAndSortCriteria.<init>(String, int)",
    "Integer FilterAndSortCriteria.getOrder()",
    "String FilterAndSortCriteria.getPropertyId()",
    "RestrictionType FilterAndSortCriteria.getRestrictionType()",
    "SortDirection FilterAndSortCriteria.getSortDirection()",
    "boolean FilterAndSortCriteria.isNullsLast()",
    "void FilterAndSortCriteria.setFilterValues(List)",
    "void FilterAndSortCriteria.setNullsLast(boolean)",
    "void FilterAndSortCriteria.setOrder(Integer)",
    "void FilterAndSortCriteria.setPropertyId(String)",
    "void FilterAndSortCriteria.setRestrictionType(RestrictionType)",
    "void FilterAndSortCriteria.setSortDirection(SortDirection)"
  })
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

    // Assert
    assertEquals("42", actualPropertyId);
    assertEquals(1, actualOrder.intValue());
    assertEquals(SortDirection.ASCENDING, actualSortDirection);
    assertTrue(actualFilterAndSortCriteria.filterValues.isEmpty());
    assertTrue(actualIsNullsLastResult);
    assertSame(RestrictionType.BOOLEAN, actualRestrictionType);
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List)"})
  public void testNewFilterAndSortCriteria_given42_thenReturnFilterValuesSizeIsTwo() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List, int)"})
  public void testNewFilterAndSortCriteria_given42_thenReturnFilterValuesSizeIsTwo2() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues, 1);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List,
   * SortDirection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List, SortDirection)"})
  public void testNewFilterAndSortCriteria_given42_thenReturnFilterValuesSizeIsTwo3() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues, SortDirection.ASCENDING);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List,
   * SortDirection, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List, SortDirection, int)"})
  public void testNewFilterAndSortCriteria_given42_thenReturnFilterValuesSizeIsTwo4() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("42");
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues, SortDirection.ASCENDING, 1);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List)"})
  public void testNewFilterAndSortCriteria_givenFoo_thenReturnFilterValuesSizeIsOne() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List, int)"})
  public void testNewFilterAndSortCriteria_givenFoo_thenReturnFilterValuesSizeIsOne2() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues, 1);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List,
   * SortDirection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List, SortDirection)"})
  public void testNewFilterAndSortCriteria_givenFoo_thenReturnFilterValuesSizeIsOne3() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues, SortDirection.ASCENDING);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@link FilterAndSortCriteria#filterValues} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List,
   * SortDirection, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List, SortDirection, int)"})
  public void testNewFilterAndSortCriteria_givenFoo_thenReturnFilterValuesSizeIsOne4() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues, SortDirection.ASCENDING, 1);

    // Assert
    List<String> stringList = actualFilterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String)}.
   *
   * <ul>
   *   <li>Then return FilterValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, String)"})
  public void testNewFilterAndSortCriteria_thenReturnFilterValuesSizeIsOne() {
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
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String, int)}.
   *
   * <ul>
   *   <li>Then return FilterValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, String, int)"})
  public void testNewFilterAndSortCriteria_thenReturnFilterValuesSizeIsOne2() {
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
   *
   * <ul>
   *   <li>Then return FilterValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, String[])"})
  public void testNewFilterAndSortCriteria_thenReturnFilterValuesSizeIsOne3() {
    // Arrange
    String[] filterValues = new String[] {"42"};

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues);

    // Assert
    List<String> filterValues2 = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues2.size());
    assertEquals("42", filterValues2.get(0));
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
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String[], int)}.
   *
   * <ul>
   *   <li>Then return FilterValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String[],
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, String[], int)"})
  public void testNewFilterAndSortCriteria_thenReturnFilterValuesSizeIsOne4() {
    // Arrange
    String[] filterValues = new String[] {"42"};

    // Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", filterValues, 1);

    // Assert
    List<String> filterValues2 = actualFilterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues2.size());
    assertEquals("42", filterValues2.get(0));
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return PropertyId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List)"})
  public void testNewFilterAndSortCriteria_whenArrayList_thenReturnPropertyIdIs42() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", new ArrayList<>());

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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return PropertyId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List, int)"})
  public void testNewFilterAndSortCriteria_whenArrayList_thenReturnPropertyIdIs422() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", new ArrayList<>(), 1);

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
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return PropertyId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List,
   * SortDirection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List, SortDirection)"})
  public void testNewFilterAndSortCriteria_whenArrayList_thenReturnPropertyIdIs423() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", new ArrayList<>(), SortDirection.ASCENDING);

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
   * Test {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List, SortDirection, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return PropertyId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#FilterAndSortCriteria(String, List,
   * SortDirection, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.<init>(String, List, SortDirection, int)"})
  public void testNewFilterAndSortCriteria_whenArrayList_thenReturnPropertyIdIs424() {
    // Arrange and Act
    FilterAndSortCriteria actualFilterAndSortCriteria =
        new FilterAndSortCriteria("42", new ArrayList<>(), SortDirection.ASCENDING, 1);

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
   * Test {@link FilterAndSortCriteria#setFilterValue(String)}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#setFilterValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.setFilterValue(String)"})
  public void testSetFilterValue() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    filterAndSortCriteria.setFilterValue("42");

    // Assert
    List<String> filterValues = filterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("42", filterValues.get(0));
    List<String> stringList = filterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("42", stringList.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#addFilterValue(String)}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#addFilterValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.addFilterValue(String)"})
  public void testAddFilterValue() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");

    // Act
    filterAndSortCriteria.addFilterValue("42");

    // Assert
    List<String> filterValues = filterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("42", filterValues.get(0));
    List<String> stringList = filterAndSortCriteria.filterValues;
    assertEquals(1, stringList.size());
    assertEquals("42", stringList.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#getFilterValues()}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FilterAndSortCriteria.getFilterValues()"})
  public void testGetFilterValues() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NOT_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getFilterValues()}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FilterAndSortCriteria.getFilterValues()"})
  public void testGetFilterValues2() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getFilterValues()}.
   *
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with propertyId is
   *       {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FilterAndSortCriteria.getFilterValues()"})
  public void testGetFilterValues_givenFilterAndSortCriteriaWithPropertyIdIs42_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new FilterAndSortCriteria("42").getFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getFilterValues()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getFilterValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FilterAndSortCriteria.getFilterValues()"})
  public void testGetFilterValues_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualFilterValues = new FilterAndSortCriteria("42", "42").getFilterValues();

    // Assert
    assertEquals(1, actualFilterValues.size());
    assertEquals("42", actualFilterValues.get(0));
  }

  /**
   * Test {@link FilterAndSortCriteria#getSpecialFilterValues()}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FilterAndSortCriteria.getSpecialFilterValues()"})
  public void testGetSpecialFilterValues() {
    // Arrange, Act and Assert
    assertTrue(new FilterAndSortCriteria("42", "42").getSpecialFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getSpecialFilterValues()}.
   *
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with propertyId is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FilterAndSortCriteria.getSpecialFilterValues()"})
  public void testGetSpecialFilterValues_givenFilterAndSortCriteriaWithPropertyIdIs42() {
    // Arrange, Act and Assert
    assertTrue(new FilterAndSortCriteria("42").getSpecialFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterAndSortCriteria#getSpecialFilterValues()}.
   *
   * <ul>
   *   <li>Then return first is {@link FilterAndSortCriteria#IS_NOT_NULL_FILTER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FilterAndSortCriteria.getSpecialFilterValues()"})
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
   *
   * <ul>
   *   <li>Then return first is {@link FilterAndSortCriteria#IS_NULL_FILTER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getSpecialFilterValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FilterAndSortCriteria.getSpecialFilterValues()"})
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
   *
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with propertyId is
   *       {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getSortAscending()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FilterAndSortCriteria.getSortAscending()"})
  public void testGetSortAscending_givenFilterAndSortCriteriaWithPropertyIdIs42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FilterAndSortCriteria("42").getSortAscending());
  }

  /**
   * Test {@link FilterAndSortCriteria#getSortAscending()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getSortAscending()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FilterAndSortCriteria.getSortAscending()"})
  public void testGetSortAscending_thenReturnFalse() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setSortAscending(false);

    // Act and Assert
    assertFalse(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Test {@link FilterAndSortCriteria#getSortAscending()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getSortAscending()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FilterAndSortCriteria.getSortAscending()"})
  public void testGetSortAscending_thenReturnTrue() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setSortAscending(null);

    // Act and Assert
    assertTrue(filterAndSortCriteria.getSortAscending());
  }

  /**
   * Test {@link FilterAndSortCriteria#setSortAscending(Boolean)}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#setSortAscending(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.setSortAscending(Boolean)"})
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
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#setSortAscending(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.setSortAscending(Boolean)"})
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
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#setSortAscending(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterAndSortCriteria.setSortAscending(Boolean)"})
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
   *
   * <p>Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FilterAndSortCriteria.hasSpecialFilterValue()"})
  public void testHasSpecialFilterValue() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.setFilterValues(null);

    // Act and Assert
    assertFalse(filterAndSortCriteria.hasSpecialFilterValue());
  }

  /**
   * Test {@link FilterAndSortCriteria#hasSpecialFilterValue()}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FilterAndSortCriteria.hasSpecialFilterValue()"})
  public void testHasSpecialFilterValue2() {
    // Arrange, Act and Assert
    assertFalse(new FilterAndSortCriteria("42", "42").hasSpecialFilterValue());
  }

  /**
   * Test {@link FilterAndSortCriteria#hasSpecialFilterValue()}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FilterAndSortCriteria.hasSpecialFilterValue()"})
  public void testHasSpecialFilterValue3() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NOT_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.hasSpecialFilterValue());
  }

  /**
   * Test {@link FilterAndSortCriteria#hasSpecialFilterValue()}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FilterAndSortCriteria.hasSpecialFilterValue()"})
  public void testHasSpecialFilterValue4() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = new FilterAndSortCriteria("42");
    filterAndSortCriteria.addFilterValue(FilterAndSortCriteria.IS_NULL_FILTER_VALUE);

    // Act and Assert
    assertTrue(filterAndSortCriteria.hasSpecialFilterValue());
  }

  /**
   * Test {@link FilterAndSortCriteria#hasSpecialFilterValue()}.
   *
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with propertyId is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FilterAndSortCriteria#hasSpecialFilterValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FilterAndSortCriteria.hasSpecialFilterValue()"})
  public void testHasSpecialFilterValue_givenFilterAndSortCriteriaWithPropertyIdIs42() {
    // Arrange, Act and Assert
    assertFalse(new FilterAndSortCriteria("42").hasSpecialFilterValue());
  }

  /**
   * Test {@link FilterAndSortCriteria#getPredicateForSpecialValues(boolean)}.
   *
   * <p>Method under test: {@link FilterAndSortCriteria#getPredicateForSpecialValues(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.TypedPredicate FilterAndSortCriteria.getPredicateForSpecialValues(boolean)"
  })
  public void testGetPredicateForSpecialValues() {
    // Arrange, Act and Assert
    assertFalse(
        new FilterAndSortCriteria("42").getPredicateForSpecialValues(true).evaluate("Value"));
  }
}
