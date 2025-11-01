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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.SortDirection;
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
   * Method under test:
   * {@link FilterMapping.ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  public void testComparatorByOrderCompare() {
    // Arrange
    FilterMapping.ComparatorByOrder comparatorByOrder = new FilterMapping.ComparatorByOrder();
    FilterMapping o1 = new FilterMapping();

    // Act and Assert
    assertEquals(0, comparatorByOrder.compare(o1, new FilterMapping()));
  }

  /**
   * Method under test:
   * {@link FilterMapping.ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  public void testComparatorByOrderCompare2() {
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
   * Method under test:
   * {@link FilterMapping.ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  public void testComparatorByOrderCompare3() {
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
   * Method under test:
   * {@link FilterMapping.ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  public void testComparatorByOrderCompare4() {
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
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  public void testWithFilterValues() {
    // Arrange, Act and Assert
    assertSame(filterMapping, filterMapping.withFilterValues(new ArrayList<>()));
  }

  /**
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  public void testWithFilterValues2() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("Cannot set both filter values and direct filter values");

    // Act and Assert
    assertSame(filterMapping, filterMapping.withFilterValues(filterValues));
  }

  /**
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  public void testWithFilterValues3() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("foo");
    filterValues.add("Cannot set both filter values and direct filter values");

    // Act and Assert
    assertSame(filterMapping, filterMapping.withFilterValues(filterValues));
  }

  /**
   * Method under test: {@link FilterMapping#withDirectFilterValues(List)}
   */
  @Test
  public void testWithDirectFilterValues() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();

    // Act
    FilterMapping actualWithDirectFilterValuesResult = filterMapping.withDirectFilterValues(directFilterValues);

    // Assert
    assertSame(directFilterValues, filterMapping.getDirectFilterValues());
    assertSame(filterMapping, actualWithDirectFilterValuesResult);
  }

  /**
   * Method under test: {@link FilterMapping#withDirectFilterValues(List)}
   */
  @Test
  public void testWithDirectFilterValues2() {
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
   * Method under test: {@link FilterMapping#withDirectFilterValues(List)}
   */
  @Test
  public void testWithDirectFilterValues3() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();
    directFilterValues.add("42");
    directFilterValues.add("42");

    // Act
    FilterMapping actualWithDirectFilterValuesResult = filterMapping.withDirectFilterValues(directFilterValues);

    // Assert
    assertSame(directFilterValues, filterMapping.getDirectFilterValues());
    assertSame(filterMapping, actualWithDirectFilterValuesResult);
  }

  /**
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
   * Method under test: {@link FilterMapping#withRestriction(Restriction)}
   */
  @Test
  public void testWithRestriction() {
    // Arrange
    Restriction restriction = new Restriction();

    // Act
    FilterMapping actualWithRestrictionResult = filterMapping.withRestriction(restriction);

    // Assert
    assertSame(restriction, filterMapping.getRestriction());
    assertSame(filterMapping, actualWithRestrictionResult);
  }

  /**
   * Method under test: {@link FilterMapping#withRestriction(Restriction)}
   */
  @Test
  public void testWithRestriction2() {
    // Arrange
    Restriction restriction = mock(Restriction.class);

    // Act and Assert
    assertSame(filterMapping, filterMapping.withRestriction(restriction));
    assertSame(restriction, filterMapping.getRestriction());
  }

  /**
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

  /**
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
   * Method under test: {@link FilterMapping#setFilterValues(List)}
   */
  @Test
  public void testSetFilterValues() {
    // Arrange and Act
    filterMapping.setFilterValues(new ArrayList<>());

    // Assert
    assertTrue(filterMapping.getFilterValues().isEmpty());
  }

  /**
   * Method under test: {@link FilterMapping#setFilterValues(List)}
   */
  @Test
  public void testSetFilterValues2() {
    // Arrange
    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add("Cannot set both filter values and direct filter values");

    // Act
    filterMapping.setFilterValues(filterValues);

    // Assert
    List<String> filterValues2 = filterMapping.getFilterValues();
    assertEquals(1, filterValues2.size());
    assertEquals("Cannot set both filter values and direct filter values", filterValues2.get(0));
  }

  /**
   * Method under test: {@link FilterMapping#setFilterValues(List)}
   */
  @Test
  public void testSetFilterValues3() {
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
   * Method under test: {@link FilterMapping#setDirectFilterValues(List)}
   */
  @Test
  public void testSetDirectFilterValues() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();

    // Act
    filterMapping.setDirectFilterValues(directFilterValues);

    // Assert
    assertSame(directFilterValues, filterMapping.getDirectFilterValues());
  }

  /**
   * Method under test: {@link FilterMapping#setDirectFilterValues(List)}
   */
  @Test
  public void testSetDirectFilterValues2() {
    // Arrange
    ArrayList<Object> directFilterValues = new ArrayList<>();
    directFilterValues.add("42");

    // Act
    filterMapping.setDirectFilterValues(directFilterValues);

    // Assert
    assertSame(directFilterValues, filterMapping.getDirectFilterValues());
  }

  /**
   * Method under test: {@link FilterMapping#setDirectFilterValues(List)}
   */
  @Test
  public void testSetDirectFilterValues3() {
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
   * Method under test: {@link FilterMapping#parseFilterValue(String)}
   */
  @Test
  public void testParseFilterValue() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"42"}, filterMapping.parseFilterValue("42"));
    assertArrayEquals(new String[]{"", ""}, filterMapping.parseFilterValue(FilterMapping.RANGE_SPECIFIER_REGEX));
    assertEquals(0, filterMapping.parseFilterValue(null).length);
  }
}
