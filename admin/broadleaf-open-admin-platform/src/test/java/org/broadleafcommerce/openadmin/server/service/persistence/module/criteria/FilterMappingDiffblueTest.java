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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.SortDirection;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping.ComparatorByOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FilterMapping.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FilterMappingDiffblueTest {
  @Autowired
  private FilterMapping filterMapping;

  /**
   * Test ComparatorByOrder {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)} with {@code FilterMapping}, {@code FilterMapping}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ComparatorByOrder.compare(FilterMapping, FilterMapping)"})
  public void testComparatorByOrderCompareWithFilterMappingFilterMapping_thenReturnMinusOne() {
    // Arrange
    ComparatorByOrder comparatorByOrder = new ComparatorByOrder();

    FilterMapping o1 = new FilterMapping();
    o1.setOrder(1);

    FilterMapping o2 = new FilterMapping();
    o2.setOrder(null);

    // Act and Assert
    assertEquals(-1, comparatorByOrder.compare(o1, o2));
  }

  /**
   * Test ComparatorByOrder {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)} with {@code FilterMapping}, {@code FilterMapping}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ComparatorByOrder.compare(FilterMapping, FilterMapping)"})
  public void testComparatorByOrderCompareWithFilterMappingFilterMapping_thenReturnOne() {
    // Arrange
    ComparatorByOrder comparatorByOrder = new ComparatorByOrder();

    FilterMapping o1 = new FilterMapping();
    o1.setOrder(null);

    FilterMapping o2 = new FilterMapping();
    o2.setOrder(1);

    // Act and Assert
    assertEquals(1, comparatorByOrder.compare(o1, o2));
  }

  /**
   * Test ComparatorByOrder {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)} with {@code FilterMapping}, {@code FilterMapping}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ComparatorByOrder.compare(FilterMapping, FilterMapping)"})
  public void testComparatorByOrderCompareWithFilterMappingFilterMapping_thenReturnZero() {
    // Arrange
    ComparatorByOrder comparatorByOrder = new ComparatorByOrder();
    FilterMapping o1 = new FilterMapping();

    // Act and Assert
    assertEquals(0, comparatorByOrder.compare(o1, new FilterMapping()));
  }

  /**
   * Test ComparatorByOrder {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)} with {@code FilterMapping}, {@code FilterMapping}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparatorByOrder#compare(FilterMapping, FilterMapping)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ComparatorByOrder.compare(FilterMapping, FilterMapping)"})
  public void testComparatorByOrderCompareWithFilterMappingFilterMapping_thenReturnZero2() {
    // Arrange
    ComparatorByOrder comparatorByOrder = new ComparatorByOrder();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withOrder(Integer)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withFullPropertyName(String)"})
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
   *   <li>Given {@code Cannot set both filter values and direct filter values}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withFilterValues(List)"})
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
   *   <li>Then return {@link FilterMapping}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withFilterValues(List)"})
  public void testWithFilterValues_givenFoo_whenArrayListAddFoo_thenReturnFilterMapping() {
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
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link FilterMapping}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withFilterValues(List)"})
  public void testWithFilterValues_givenNull_whenArrayListAddNull_thenReturnFilterMapping() {
    // Arrange
    filterMapping.setDirectFilterValues(null);

    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add(null);

    // Act and Assert
    assertSame(filterMapping, filterMapping.withFilterValues(filterValues));
  }

  /**
   * Test {@link FilterMapping#withFilterValues(List)}.
   * <ul>
   *   <li>Given {@link FilterMapping#RANGE_SPECIFIER_REGEX}.</li>
   *   <li>Then return FilterValues size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withFilterValues(List)"})
  public void testWithFilterValues_givenRange_specifier_regex_thenReturnFilterValuesSizeIsTwo() {
    // Arrange
    filterMapping.setDirectFilterValues(null);

    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add(FilterMapping.RANGE_SPECIFIER_REGEX);

    // Act
    FilterMapping actualWithFilterValuesResult = filterMapping.withFilterValues(filterValues);

    // Assert
    List<String> filterValues2 = actualWithFilterValuesResult.getFilterValues();
    assertEquals(2, filterValues2.size());
    assertEquals("", filterValues2.get(0));
    assertEquals("", filterValues2.get(1));
    assertNull(actualWithFilterValuesResult.getDirectFilterValues());
  }

  /**
   * Test {@link FilterMapping#withFilterValues(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return DirectFilterValues Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withFilterValues(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withFilterValues(List)"})
  public void testWithFilterValues_whenArrayList_thenReturnDirectFilterValuesEmpty() {
    // Arrange and Act
    FilterMapping actualWithFilterValuesResult = filterMapping.withFilterValues(new ArrayList<>());

    // Assert
    assertTrue(actualWithFilterValuesResult.getDirectFilterValues().isEmpty());
    assertTrue(actualWithFilterValuesResult.getFilterValues().isEmpty());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withDirectFilterValues(List)"})
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
   *   <li>Then {@link FilterMapping} DirectFilterValues is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#withDirectFilterValues(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withDirectFilterValues(List)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withDirectFilterValues(List)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withSortDirection(SortDirection)"})
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
   * <p>
   * Method under test: {@link FilterMapping#withRestriction(Restriction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withRestriction(Restriction)"})
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
   * Test {@link FilterMapping#withFieldPath(FieldPath)}.
   * <p>
   * Method under test: {@link FilterMapping#withFieldPath(FieldPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withFieldPath(FieldPath)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withInheritedFromClass(Class)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterMapping FilterMapping.withNullsLast(boolean)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterMapping.setFilterValues(List)"})
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
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#setFilterValues(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterMapping.setFilterValues(List)"})
  public void testSetFilterValues_givenNull_whenArrayListAddNull() {
    // Arrange
    filterMapping.setDirectFilterValues(null);

    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add(null);

    // Act
    filterMapping.setFilterValues(filterValues);

    // Assert that nothing has changed
    assertTrue(filterMapping.getFilterValues().isEmpty());
  }

  /**
   * Test {@link FilterMapping#setFilterValues(List)}.
   * <ul>
   *   <li>Then {@link FilterMapping} FilterValues is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#setFilterValues(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterMapping.setFilterValues(List)"})
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
   *   <li>Then {@link FilterMapping} FilterValues size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#setFilterValues(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterMapping.setFilterValues(List)"})
  public void testSetFilterValues_thenFilterMappingFilterValuesSizeIsTwo() {
    // Arrange
    filterMapping.setDirectFilterValues(null);

    ArrayList<String> filterValues = new ArrayList<>();
    filterValues.add(FilterMapping.RANGE_SPECIFIER_REGEX);

    // Act
    filterMapping.setFilterValues(filterValues);

    // Assert
    List<String> filterValues2 = filterMapping.getFilterValues();
    assertEquals(2, filterValues2.size());
    assertEquals("", filterValues2.get(0));
    assertEquals("", filterValues2.get(1));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterMapping.setFilterValues(List)"})
  public void testSetFilterValues_whenArrayList_thenFilterMappingFilterValuesEmpty() {
    // Arrange and Act
    filterMapping.setFilterValues(new ArrayList<>());

    // Assert that nothing has changed
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterMapping.setDirectFilterValues(List)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterMapping.setDirectFilterValues(List)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterMapping.setDirectFilterValues(List)"})
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
   *   <li>Then return array of {@link String} with empty string and empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterMapping#parseFilterValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] FilterMapping.parseFilterValue(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] FilterMapping.parseFilterValue(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] FilterMapping.parseFilterValue(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterMapping.<init>()", "List FilterMapping.getDirectFilterValues()",
      "FieldPath FilterMapping.getFieldPath()", "List FilterMapping.getFilterValues()",
      "String FilterMapping.getFullPropertyName()", "Class FilterMapping.getInheritedFromClass()",
      "Boolean FilterMapping.getNullsLast()", "Integer FilterMapping.getOrder()",
      "Restriction FilterMapping.getRestriction()", "SortDirection FilterMapping.getSortDirection()",
      "void FilterMapping.setFieldPath(FieldPath)", "void FilterMapping.setFullPropertyName(String)",
      "void FilterMapping.setInheritedFromClass(Class)", "void FilterMapping.setNullsLast(Boolean)",
      "void FilterMapping.setOrder(Integer)", "void FilterMapping.setRestriction(Restriction)",
      "void FilterMapping.setSortDirection(SortDirection)"})
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

    // Assert
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
