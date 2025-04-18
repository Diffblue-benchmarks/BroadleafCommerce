/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import bsh.util.NameCompletionTable;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.value.ValueAssignable;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SelectizeCollectionUtilsDiffblueTest {
  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_givenFalse_whenArrayList_thenReturnArrayList() {
    // Arrange
    NameCompletionTable nameCompletionTable = mock(NameCompletionTable.class);
    when(nameCompletionTable.isEmpty()).thenReturn(false);

    ArrayList<Object> objectList = new ArrayList<>();
    when(nameCompletionTable.iterator()).thenReturn(objectList.iterator());

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(nameCompletionTable, new ArrayList<>());

    // Assert
    verify(nameCompletionTable).isEmpty();
    verify(nameCompletionTable, atLeast(1)).iterator();
    assertEquals(objectList, actualIntersectionResult);
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_givenFoo_whenArrayListAddFoo_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("foo");

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(BLCFieldUtils.NULL_FIELD, objectList);

    // Assert
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls {@link ArrayList#get(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_givenNull_field_thenCallsGet() {
    // Arrange
    NameCompletionTable nameCompletionTable = mock(NameCompletionTable.class);
    when(nameCompletionTable.get(anyInt())).thenReturn(BLCFieldUtils.NULL_FIELD);
    when(nameCompletionTable.isEmpty()).thenReturn(false);

    ArrayList<Object> objectList = new ArrayList<>();
    when(nameCompletionTable.iterator()).thenReturn(objectList.iterator());

    ArrayList<Object> objectList2 = new ArrayList<>();
    objectList2.add(BLCFieldUtils.NULL_FIELD);

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(nameCompletionTable, objectList2);

    // Assert
    verify(nameCompletionTable).get(eq(0));
    verify(nameCompletionTable).isEmpty();
    verify(nameCompletionTable, atLeast(1)).iterator();
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls {@link ArrayList#get(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_givenNull_field_thenCallsGet2() {
    // Arrange
    NameCompletionTable nameCompletionTable = mock(NameCompletionTable.class);
    when(nameCompletionTable.get(anyInt())).thenReturn(BLCFieldUtils.NULL_FIELD);
    when(nameCompletionTable.isEmpty()).thenReturn(false);

    ArrayList<Object> objectList = new ArrayList<>();
    when(nameCompletionTable.iterator()).thenReturn(objectList.iterator());

    ArrayList<Object> objectList2 = new ArrayList<>();
    objectList2.add(BLCFieldUtils.NULL_FIELD);
    objectList2.add(BLCFieldUtils.NULL_FIELD);

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(nameCompletionTable, objectList2);

    // Assert
    verify(nameCompletionTable).get(eq(0));
    verify(nameCompletionTable).isEmpty();
    verify(nameCompletionTable, atLeast(1)).iterator();
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_givenTwo_whenArrayListAddTwo_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(mock(ValueAssignable.class));

    ArrayList<Object> objectList2 = new ArrayList<>();
    objectList2.add(2);

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(objectList, objectList2);

    // Assert
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Given {@link ValueAssignable}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ValueAssignable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_givenValueAssignable_whenArrayListAddValueAssignable() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(mock(ValueAssignable.class));

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(objectList, BLCFieldUtils.NULL_FIELD);

    // Assert
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Then calls {@link ValueAssignable#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_thenCallsGetValue() {
    // Arrange
    ValueAssignable<Serializable> valueAssignable = mock(ValueAssignable.class);
    when(valueAssignable.getValue()).thenReturn(MvelHelper.BLC_RULE_MAP_PARAM);

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(valueAssignable);

    ArrayList<Object> objectList2 = new ArrayList<>();
    objectList2.add("foo");

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(objectList, objectList2);

    // Assert
    verify(valueAssignable).getValue();
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act and Assert
    assertEquals(objectList, SelectizeCollectionUtils.intersection(objectList, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_whenNull_field_thenReturnSizeIsOne() {
    // Arrange and Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(BLCFieldUtils.NULL_FIELD,
        BLCFieldUtils.NULL_FIELD);

    // Assert
    assertTrue(actualIntersectionResult instanceof List);
    assertEquals(1, actualIntersectionResult.size());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(null, null);

    // Assert
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SelectizeCollectionUtils.intersection(Object, Object)"})
  public void testIntersection_whenNull_thenReturnEmpty2() {
    // Arrange and Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(BLCFieldUtils.NULL_FIELD, null);

    // Assert
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }
}
