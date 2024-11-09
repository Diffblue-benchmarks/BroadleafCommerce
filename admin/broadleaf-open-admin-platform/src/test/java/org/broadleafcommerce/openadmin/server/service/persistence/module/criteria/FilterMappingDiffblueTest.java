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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.SortDirection;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping.ComparatorByOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {FilterMapping.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FilterMappingDiffblueTest {
  @Autowired
  private FilterMapping filterMapping;

  /**
   * Test ComparatorByOrder
   * {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)} with
   * {@code FilterMapping}, {@code FilterMapping}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterMapping.ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  public void testComparatorByOrderCompareWithFilterMappingFilterMapping_thenReturnMinusOne() {
    // Arrange
    FilterMapping.ComparatorByOrder comparatorByOrder = new FilterMapping.ComparatorByOrder();

    FilterMapping o1 = new FilterMapping();
    o1.setOrder(1);

    FilterMapping o2 = new FilterMapping();
    o2.setOrder(null);

    // Act and Assert
    assertEquals(-1, comparatorByOrder.compare(o1, o2));
  }

  /**
   * Test ComparatorByOrder
   * {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)} with
   * {@code FilterMapping}, {@code FilterMapping}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterMapping.ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  public void testComparatorByOrderCompareWithFilterMappingFilterMapping_thenReturnOne() {
    // Arrange
    FilterMapping.ComparatorByOrder comparatorByOrder = new FilterMapping.ComparatorByOrder();

    FilterMapping o1 = new FilterMapping();
    o1.setOrder(null);

    FilterMapping o2 = new FilterMapping();
    o2.setOrder(1);

    // Act and Assert
    assertEquals(1, comparatorByOrder.compare(o1, o2));
  }

  /**
   * Test ComparatorByOrder
   * {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)} with
   * {@code FilterMapping}, {@code FilterMapping}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterMapping.ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  public void testComparatorByOrderCompareWithFilterMappingFilterMapping_thenReturnZero() {
    // Arrange
    FilterMapping.ComparatorByOrder comparatorByOrder = new FilterMapping.ComparatorByOrder();
    FilterMapping o1 = new FilterMapping();

    // Act and Assert
    assertEquals(0, comparatorByOrder.compare(o1, new FilterMapping()));
  }

  /**
   * Test ComparatorByOrder
   * {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)} with
   * {@code FilterMapping}, {@code FilterMapping}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterMapping.ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  public void testComparatorByOrderCompareWithFilterMappingFilterMapping_thenReturnZero2() {
    // Arrange
    FilterMapping.ComparatorByOrder comparatorByOrder = new FilterMapping.ComparatorByOrder();

    FilterMapping o1 = new FilterMapping();
    o1.setOrder(1);

    FilterMapping o2 = new FilterMapping();
    o2.setOrder(1);

    // Act and Assert
    assertEquals(0, comparatorByOrder.compare(o1, o2));
  }

  /**
   * Test {@link FilterMapping#withOrder(Integer)}.
   * <p>
   * Method under test: {@link FilterMapping#withOrder(Integer)}
   */
  @Test
  public void testWithOrder() {
    // Arrange
    FilterMapping filterMapping = new FilterMapping();

    // Act
    FilterMapping actualWithOrderResult = filterMapping.withOrder(1);

    // Assert
    assertEquals(1, filterMapping.getOrder().intValue());
    assertSame(filterMapping, actualWithOrderResult);
  }

  /**
   * Test {@link FilterMapping#withFullPropertyName(String)}.
   * <p>
   * Method under test: {@link FilterMapping#withFullPropertyName(String)}
   */
  @Test
  public void testWithFullPropertyName() {
    // Arrange and Act
    FilterMapping actualWithFullPropertyNameResult = filterMapping.withFullPropertyName("Dr Jane Doe");

    // Assert
    assertEquals("Dr Jane Doe", filterMapping.getFullPropertyName());
    assertSame(filterMapping, actualWithFullPropertyNameResult);
  }

  /**
   * Test {@link FilterMapping#withFilterValues(List)}.
   * <ul>
   *   <li>Given
   * {@code Cannot set both filter values and direct filter values}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  public void testWithFilterValues_givenCannotSetBothFilterValuesAndDirectFilterValues() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("Cannot set both filter values and direct filter values");

    // Act and Assert
    assertSame(filterMapping, filterMapping.withFilterValues(filterValues));
  }

  /**
   * Test {@link FilterMapping#withFilterValues(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  public void testWithFilterValues_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");
    filterValues.add("Cannot set both filter values and direct filter values");

    // Act and Assert
    assertSame(filterMapping, filterMapping.withFilterValues(filterValues));
  }

  /**
   * Test {@link FilterMapping#withFilterValues(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  public void testWithFilterValues_whenArrayList() {
    // Arrange, Act and Assert
    assertSame(filterMapping, filterMapping.withFilterValues(new ArrayList<>()));
  }

  /**
   * Test {@link FilterMapping#withDirectFilterValues(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return DirectFilterValues size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withDirectFilterValues(List)}
   */
  @Test
  public void testWithDirectFilterValues_given42_thenReturnDirectFilterValuesSizeIsTwo() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();
    directFilterValues.add("42");
    directFilterValues.add("42");

    // Act and Assert
    List directFilterValues2 = filterMapping.withDirectFilterValues(directFilterValues).getDirectFilterValues();
    assertEquals(2, directFilterValues2.size());
    assertEquals("42", directFilterValues2.get(0));
    assertEquals("42", directFilterValues2.get(1));
  }

  /**
   * Test {@link FilterMapping#withDirectFilterValues(List)}.
   * <ul>
   *   <li>Then {@link FilterMapping} DirectFilterValues is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withDirectFilterValues(List)}
   */
  @Test
  public void testWithDirectFilterValues_thenFilterMappingDirectFilterValuesIsArrayList() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();
    directFilterValues.add("42");

    // Act
    FilterMapping actualWithDirectFilterValuesResult = filterMapping.withDirectFilterValues(directFilterValues);

    // Assert
    assertSame(directFilterValues, filterMapping.getDirectFilterValues());
    assertSame(filterMapping, actualWithDirectFilterValuesResult);
  }

  /**
   * Test {@link FilterMapping#withDirectFilterValues(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withDirectFilterValues(List)}
   */
  @Test
  public void testWithDirectFilterValues_whenArrayList() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();

    // Act
    FilterMapping actualWithDirectFilterValuesResult = filterMapping.withDirectFilterValues(directFilterValues);

    // Assert
    assertSame(directFilterValues, filterMapping.getDirectFilterValues());
    assertSame(filterMapping, actualWithDirectFilterValuesResult);
  }

  /**
   * Test {@link FilterMapping#withSortDirection(SortDirection)}.
   * <p>
   * Method under test: {@link FilterMapping#withSortDirection(SortDirection)}
   */
  @Test
  public void testWithSortDirection() {
    // Arrange
    FilterMapping filterMapping = new FilterMapping();

    // Act
    FilterMapping actualWithSortDirectionResult = filterMapping.withSortDirection(SortDirection.ASCENDING);

    // Assert
    assertEquals(SortDirection.ASCENDING, filterMapping.getSortDirection());
    assertSame(filterMapping, actualWithSortDirectionResult);
  }

  /**
   * Test {@link FilterMapping#withRestriction(Restriction)}.
   * <ul>
   *   <li>When {@link Restriction}.</li>
   *   <li>Then return {@link FilterMapping}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withRestriction(Restriction)}
   */
  @Test
  public void testWithRestriction_whenRestriction_thenReturnFilterMapping() {
    // Arrange
    Restriction restriction = mock(Restriction.class);

    // Act and Assert
    assertSame(filterMapping, filterMapping.withRestriction(restriction));
    assertSame(restriction, filterMapping.getRestriction());
  }

  /**
   * Test {@link FilterMapping#withRestriction(Restriction)}.
   * <ul>
   *   <li>When {@link Restriction} (default constructor).</li>
   *   <li>Then return Restriction is {@link Restriction} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withRestriction(Restriction)}
   */
  @Test
  public void testWithRestriction_whenRestriction_thenReturnRestrictionIsRestriction() {
    // Arrange
    Restriction restriction = new Restriction();

    // Act and Assert
    assertSame(restriction, filterMapping.withRestriction(restriction).getRestriction());
    assertSame(restriction, filterMapping.getRestriction());
  }

  /**
   * Test {@link FilterMapping#withFieldPath(FieldPath)}.
   * <p>
   * Method under test: {@link FilterMapping#withFieldPath(FieldPath)}
   */
  @Test
  public void testWithFieldPath() {
    // Arrange
    FilterMapping filterMapping = new FilterMapping();
    FieldPath fieldPath = new FieldPath();

    // Act
    FilterMapping actualWithFieldPathResult = filterMapping.withFieldPath(fieldPath);

    // Assert
    assertSame(fieldPath, filterMapping.getFieldPath());
    assertSame(filterMapping, actualWithFieldPathResult);
  }

  /**
   * Test {@link FilterMapping#withInheritedFromClass(Class)}.
   * <p>
   * Method under test: {@link FilterMapping#withInheritedFromClass(Class)}
   */
  @Test
  public void testWithInheritedFromClass() {
    // Arrange
    FilterMapping filterMapping = new FilterMapping();
    Class<Object> inheritedFromClass = Object.class;

    // Act and Assert
    assertSame(filterMapping, filterMapping.withInheritedFromClass(inheritedFromClass));
    assertSame(inheritedFromClass, filterMapping.getInheritedFromClass());
  }

  /**
   * Test {@link FilterMapping#withNullsLast(boolean)}.
   * <p>
   * Method under test: {@link FilterMapping#withNullsLast(boolean)}
   */
  @Test
  public void testWithNullsLast() {
    // Arrange
    FilterMapping filterMapping = new FilterMapping();

    // Act and Assert
    assertSame(filterMapping, filterMapping.withNullsLast(true));
  }

  /**
   * Test {@link FilterMapping#setFilterValues(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#setFilterValues(List)}
   */
  @Test
  public void testSetFilterValues_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");
    filterValues.add("Cannot set both filter values and direct filter values");

    // Act
    filterMapping.setFilterValues(filterValues);

    // Assert
    assertEquals(filterValues, filterMapping.getFilterValues());
  }

  /**
   * Test {@link FilterMapping#setFilterValues(List)}.
   * <ul>
   *   <li>Then {@link FilterMapping} FilterValues is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#setFilterValues(List)}
   */
  @Test
  public void testSetFilterValues_thenFilterMappingFilterValuesIsArrayList() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("Cannot set both filter values and direct filter values");

    // Act
    filterMapping.setFilterValues(filterValues);

    // Assert
    assertEquals(filterValues, filterMapping.getFilterValues());
  }

  /**
   * Test {@link FilterMapping#setFilterValues(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FilterMapping} FilterValues Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#setFilterValues(List)}
   */
  @Test
  public void testSetFilterValues_whenArrayList_thenFilterMappingFilterValuesEmpty() {
    // Arrange and Act
    filterMapping.setFilterValues(new ArrayList<>());

    // Assert
    assertTrue(filterMapping.getFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterMapping#setDirectFilterValues(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#setDirectFilterValues(List)}
   */
  @Test
  public void testSetDirectFilterValues_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();
    directFilterValues.add("42");

    // Act
    filterMapping.setDirectFilterValues(directFilterValues);

    // Assert
    assertSame(directFilterValues, filterMapping.getDirectFilterValues());
  }

  /**
   * Test {@link FilterMapping#setDirectFilterValues(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#setDirectFilterValues(List)}
   */
  @Test
  public void testSetDirectFilterValues_given42_whenArrayListAdd422() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();
    directFilterValues.add("42");
    directFilterValues.add("42");

    // Act
    filterMapping.setDirectFilterValues(directFilterValues);

    // Assert
    assertSame(directFilterValues, filterMapping.getDirectFilterValues());
  }

  /**
   * Test {@link FilterMapping#setDirectFilterValues(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#setDirectFilterValues(List)}
   */
  @Test
  public void testSetDirectFilterValues_whenArrayList() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();

    // Act
    filterMapping.setDirectFilterValues(directFilterValues);

    // Assert
    assertSame(directFilterValues, filterMapping.getDirectFilterValues());
  }

  /**
   * Test {@link FilterMapping#parseFilterValue(String)}.
   * <ul>
   *   <li>Then return array of {@link String} with empty string and empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#parseFilterValue(String)}
   */
  @Test
  public void testParseFilterValue_thenReturnArrayOfStringWithEmptyStringAndEmptyString() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"", ""}, filterMapping.parseFilterValue(FilterMapping.RANGE_SPECIFIER_REGEX));
  }

  /**
   * Test {@link FilterMapping#parseFilterValue(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return array of {@link String} with {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#parseFilterValue(String)}
   */
  @Test
  public void testParseFilterValue_when42_thenReturnArrayOfStringWith42() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"42"}, filterMapping.parseFilterValue("42"));
  }

  /**
   * Test {@link FilterMapping#parseFilterValue(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#parseFilterValue(String)}
   */
  @Test
  public void testParseFilterValue_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, filterMapping.parseFilterValue(null).length);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FilterMapping}
   *   <li>{@link FilterMapping#setFieldPath(FieldPath)}
   *   <li>{@link FilterMapping#setFullPropertyName(String)}
   *   <li>{@link FilterMapping#setInheritedFromClass(Class)}
   *   <li>{@link FilterMapping#setNullsLast(Boolean)}
   *   <li>{@link FilterMapping#setOrder(Integer)}
   *   <li>{@link FilterMapping#setRestriction(Restriction)}
   *   <li>{@link FilterMapping#setSortDirection(SortDirection)}
   *   <li>{@link FilterMapping#getDirectFilterValues()}
   *   <li>{@link FilterMapping#getFieldPath()}
   *   <li>{@link FilterMapping#getFilterValues()}
   *   <li>{@link FilterMapping#getFullPropertyName()}
   *   <li>{@link FilterMapping#getInheritedFromClass()}
   *   <li>{@link FilterMapping#getNullsLast()}
   *   <li>{@link FilterMapping#getOrder()}
   *   <li>{@link FilterMapping#getRestriction()}
   *   <li>{@link FilterMapping#getSortDirection()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FilterMapping actualFilterMapping = new FilterMapping();
    FieldPath fieldPath = new FieldPath();
    actualFilterMapping.setFieldPath(fieldPath);
    actualFilterMapping.setFullPropertyName("Dr Jane Doe");
    Class<Object> inheritedFromClass = Object.class;
    actualFilterMapping.setInheritedFromClass(inheritedFromClass);
    actualFilterMapping.setNullsLast(true);
    actualFilterMapping.setOrder(1);
    Restriction restriction = new Restriction();
    actualFilterMapping.setRestriction(restriction);
    actualFilterMapping.setSortDirection(SortDirection.ASCENDING);
    List actualDirectFilterValues = actualFilterMapping.getDirectFilterValues();
    FieldPath actualFieldPath = actualFilterMapping.getFieldPath();
    List<String> actualFilterValues = actualFilterMapping.getFilterValues();
    String actualFullPropertyName = actualFilterMapping.getFullPropertyName();
    Class<?> actualInheritedFromClass = actualFilterMapping.getInheritedFromClass();
    Boolean actualNullsLast = actualFilterMapping.getNullsLast();
    Integer actualOrder = actualFilterMapping.getOrder();
    Restriction actualRestriction = actualFilterMapping.getRestriction();
    SortDirection actualSortDirection = actualFilterMapping.getSortDirection();

    // Assert that nothing has changed
    assertEquals("Dr Jane Doe", actualFullPropertyName);
    assertEquals(1, actualOrder.intValue());
    assertEquals(SortDirection.ASCENDING, actualSortDirection);
    assertTrue(actualDirectFilterValues.isEmpty());
    assertTrue(actualFilterValues.isEmpty());
    assertTrue(actualNullsLast);
    Class<Object> expectedInheritedFromClass = Object.class;
    assertEquals(expectedInheritedFromClass, actualInheritedFromClass);
    assertSame(fieldPath, actualFieldPath);
    assertSame(restriction, actualRestriction);
    assertSame(inheritedFromClass, actualInheritedFromClass);
  }
}
