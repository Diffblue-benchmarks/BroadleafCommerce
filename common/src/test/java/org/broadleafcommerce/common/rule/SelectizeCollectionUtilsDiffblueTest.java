/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import bsh.util.NameCompletionTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.spi.DefaultThreadContextStack;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class SelectizeCollectionUtilsDiffblueTest {
  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls {@link DefaultThreadContextStack#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  public void testIntersection_givenArrayListAddNull_field_thenCallsIterator() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BLCFieldUtils.NULL_FIELD);
    objectList.add(BLCFieldUtils.NULL_FIELD);
    Iterator<Object> iteratorResult = objectList.iterator();
    NameCompletionTable nameCompletionTable = mock(NameCompletionTable.class);
    when(nameCompletionTable.isEmpty()).thenReturn(true);
    when(nameCompletionTable.iterator()).thenReturn(iteratorResult);
    DefaultThreadContextStack defaultThreadContextStack = mock(DefaultThreadContextStack.class);

    ArrayList<String> stringList = new ArrayList<>();
    when(defaultThreadContextStack.iterator()).thenReturn(stringList.iterator());

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(nameCompletionTable,
        defaultThreadContextStack);

    // Assert
    verify(nameCompletionTable).isEmpty();
    verify(nameCompletionTable, atLeast(1)).iterator();
    verify(defaultThreadContextStack, atLeast(1)).iterator();
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link NameCompletionTable} {@link ArrayList#isEmpty()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  public void testIntersection_givenFalse_whenNameCompletionTableIsEmptyReturnFalse() {
    // Arrange
    NameCompletionTable nameCompletionTable = mock(NameCompletionTable.class);
    when(nameCompletionTable.isEmpty()).thenReturn(false);

    ArrayList<Object> objectList = new ArrayList<>();
    when(nameCompletionTable.iterator()).thenReturn(objectList.iterator());

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(nameCompletionTable,
        BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(nameCompletionTable).isEmpty();
    verify(nameCompletionTable, atLeast(1)).iterator();
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  public void testIntersection_givenTrue_whenArrayList_thenReturnArrayList() {
    // Arrange
    NameCompletionTable nameCompletionTable = mock(NameCompletionTable.class);
    when(nameCompletionTable.isEmpty()).thenReturn(true);

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
   *   <li>Given {@code true}.</li>
   *   <li>When {@link NameCompletionTable} {@link ArrayList#isEmpty()} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  public void testIntersection_givenTrue_whenNameCompletionTableIsEmptyReturnTrue() {
    // Arrange
    NameCompletionTable nameCompletionTable = mock(NameCompletionTable.class);
    when(nameCompletionTable.isEmpty()).thenReturn(true);

    ArrayList<Object> objectList = new ArrayList<>();
    when(nameCompletionTable.iterator()).thenReturn(objectList.iterator());

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(nameCompletionTable,
        BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(nameCompletionTable).isEmpty();
    verify(nameCompletionTable, atLeast(1)).iterator();
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
   * Method under test:
   * {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  public void testIntersection_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act and Assert
    assertEquals(objectList, SelectizeCollectionUtils.intersection(objectList, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>When {@link DefaultThreadContextStack}
   * {@link DefaultThreadContextStack#isEmpty()} return {@code true}.</li>
   *   <li>Then calls {@link DefaultThreadContextStack#isEmpty()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  public void testIntersection_whenDefaultThreadContextStackIsEmptyReturnTrue_thenCallsIsEmpty() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BLCFieldUtils.NULL_FIELD);
    objectList.add(BLCFieldUtils.NULL_FIELD);
    Iterator<Object> iteratorResult = objectList.iterator();
    NameCompletionTable nameCompletionTable = mock(NameCompletionTable.class);
    when(nameCompletionTable.isEmpty()).thenReturn(false);
    when(nameCompletionTable.iterator()).thenReturn(iteratorResult);
    DefaultThreadContextStack defaultThreadContextStack = mock(DefaultThreadContextStack.class);
    when(defaultThreadContextStack.isEmpty()).thenReturn(true);

    ArrayList<String> stringList = new ArrayList<>();
    when(defaultThreadContextStack.iterator()).thenReturn(stringList.iterator());

    // Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(nameCompletionTable,
        defaultThreadContextStack);

    // Assert
    verify(nameCompletionTable).isEmpty();
    verify(nameCompletionTable, atLeast(1)).iterator();
    verify(defaultThreadContextStack).isEmpty();
    verify(defaultThreadContextStack, atLeast(1)).iterator();
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>When {@link NameCompletionTable}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  public void testIntersection_whenNameCompletionTable_thenReturnEmpty() {
    // Arrange and Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(mock(NameCompletionTable.class), null);

    // Assert
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SelectizeCollectionUtils#intersection(Object, Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
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
   * Method under test:
   * {@link SelectizeCollectionUtils#intersection(Object, Object)}
   */
  @Test
  public void testIntersection_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Collection actualIntersectionResult = SelectizeCollectionUtils.intersection(null, BLCFieldUtils.NULL_FIELD);

    // Assert
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult.isEmpty());
  }
}
