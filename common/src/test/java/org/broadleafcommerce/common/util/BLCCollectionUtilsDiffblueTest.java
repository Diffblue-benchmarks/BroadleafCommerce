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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class BLCCollectionUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}
   */
  @Test
  public void testCollect() {
    // Arrange and Act
    Collection<Object> actualCollectResult = BLCCollectionUtils.<Object>collect(new ArrayList<>(),
        mock(TypedTransformer.class));

    // Assert
    assertTrue(actualCollectResult instanceof List);
    assertTrue(actualCollectResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}
   */
  @Test
  public void testCollect2() {
    // Arrange and Act
    Collection<Object> actualCollectResult = BLCCollectionUtils.collect(new ArrayList<>(), null);

    // Assert
    assertTrue(actualCollectResult instanceof List);
    assertTrue(actualCollectResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}
   */
  @Test
  public void testCollect3() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    Collection<Object> actualCollectResult = BLCCollectionUtils.collect(inputCollection, transformer);

    // Assert
    verify(transformer).transform(isA(Object.class));
    assertTrue(actualCollectResult instanceof List);
    assertEquals(1, actualCollectResult.size());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}
   */
  @Test
  public void testCollect4() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    Collection<Object> actualCollectResult = BLCCollectionUtils.collect(inputCollection, transformer);

    // Assert
    verify(transformer, atLeast(1)).transform(isA(Object.class));
    assertEquals(inputCollection, actualCollectResult);
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#collectList(Collection, TypedTransformer)}
   */
  @Test
  public void testCollectList() {
    // Arrange and Act
    List<Object> actualCollectListResult = BLCCollectionUtils.<Object>collectList(new ArrayList<>(),
        mock(TypedTransformer.class));

    // Assert
    assertTrue(actualCollectListResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#collectList(Collection, TypedTransformer)}
   */
  @Test
  public void testCollectList2() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    List<Object> actualCollectListResult = BLCCollectionUtils.collectList(inputCollection, transformer);

    // Assert
    verify(transformer).transform(isA(Object.class));
    assertEquals(1, actualCollectListResult.size());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#collectList(Collection, TypedTransformer)}
   */
  @Test
  public void testCollectList3() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    List<Object> actualCollectListResult = BLCCollectionUtils.collectList(inputCollection, transformer);

    // Assert
    verify(transformer, atLeast(1)).transform(isA(Object.class));
    assertEquals(inputCollection, actualCollectListResult);
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#collectArray(Collection, TypedTransformer, Class)}
   */
  @Test
  public void testCollectArray() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, BLCCollectionUtils.collectArray(inputCollection, transformer, clazz).length);
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#collectArray(Collection, TypedTransformer, Class)}
   */
  @Test
  public void testCollectArray2() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    Class<Object> clazz = Object.class;

    // Act
    Object[] actualCollectArrayResult = BLCCollectionUtils.collectArray(inputCollection, transformer, clazz);

    // Assert
    verify(transformer).transform(isA(Object.class));
    assertEquals(1, actualCollectArrayResult.length);
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#collectArray(Collection, TypedTransformer, Class)}
   */
  @Test
  public void testCollectArray3() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    Class<Object> clazz = Object.class;

    // Act
    Object[] actualCollectArrayResult = BLCCollectionUtils.collectArray(inputCollection, transformer, clazz);

    // Assert
    verify(transformer, atLeast(1)).transform(isA(Object.class));
    assertEquals(2, actualCollectArrayResult.length);
    assertSame(actualCollectArrayResult[0], actualCollectArrayResult[1]);
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList() {
    // Arrange and Act
    List<Object> actualSelectListResult = BLCCollectionUtils.selectList(new ArrayList<>(), mock(TypedPredicate.class));

    // Assert
    assertTrue(actualSelectListResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList2() {
    // Arrange and Act
    List<Object> actualSelectListResult = BLCCollectionUtils.selectList(new ArrayList<>(), null);

    // Assert
    assertTrue(actualSelectListResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList3() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedPredicate<Object> predicate = mock(TypedPredicate.class);
    when(predicate.evaluate(Mockito.<Object>any())).thenReturn(true);

    // Act
    List<Object> actualSelectListResult = BLCCollectionUtils.selectList(inputCollection, predicate);

    // Assert
    verify(predicate).evaluate(isA(Object.class));
    assertEquals(1, actualSelectListResult.size());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList4() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedPredicate<Object> predicate = mock(TypedPredicate.class);
    when(predicate.evaluate(Mockito.<Object>any())).thenReturn(true);

    // Act
    List<Object> actualSelectListResult = BLCCollectionUtils.selectList(inputCollection, predicate);

    // Assert
    verify(predicate, atLeast(1)).evaluate(isA(Object.class));
    assertEquals(inputCollection, actualSelectListResult);
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList5() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedPredicate<Object> predicate = mock(TypedPredicate.class);
    when(predicate.evaluate(Mockito.<Object>any())).thenReturn(false);

    // Act
    List<Object> actualSelectListResult = BLCCollectionUtils.selectList(inputCollection, predicate);

    // Assert
    verify(predicate).evaluate(isA(Object.class));
    assertTrue(actualSelectListResult.isEmpty());
  }

  /**
   * Method under test: {@link BLCCollectionUtils#createIfNull(List)}
   */
  @Test
  public void testCreateIfNull() {
    // Arrange and Act
    List<Object> actualCreateIfNullResult = BLCCollectionUtils.createIfNull(new ArrayList<>());

    // Assert
    assertTrue(actualCreateIfNullResult.isEmpty());
  }

  /**
   * Method under test: {@link BLCCollectionUtils#createIfNull(List)}
   */
  @Test
  public void testCreateIfNull2() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add(BLCFieldUtils.NULL_FIELD);

    // Act
    List<Object> actualCreateIfNullResult = BLCCollectionUtils.createIfNull(list);

    // Assert
    assertEquals(1, actualCreateIfNullResult.size());
  }

  /**
   * Method under test: {@link BLCCollectionUtils#createIfNull(List)}
   */
  @Test
  public void testCreateIfNull3() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add(BLCFieldUtils.NULL_FIELD);
    list.add(BLCFieldUtils.NULL_FIELD);

    // Act
    List<Object> actualCreateIfNullResult = BLCCollectionUtils.createIfNull(list);

    // Assert
    assertEquals(2, actualCreateIfNullResult.size());
    assertSame(actualCreateIfNullResult.get(0), actualCreateIfNullResult.get(1));
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#createChangeAwareCollection(WorkOnChange, Collection)}
   */
  @Test
  public void testCreateChangeAwareCollection() {
    // Arrange
    WorkOnChange work = mock(WorkOnChange.class);

    // Act
    Collection actualCreateChangeAwareCollectionResult = BLCCollectionUtils.createChangeAwareCollection(work,
        new ArrayList<>());

    // Assert
    assertTrue(actualCreateChangeAwareCollectionResult instanceof List);
    assertTrue(actualCreateChangeAwareCollectionResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#createChangeAwareCollection(WorkOnChange, Collection)}
   */
  @Test
  public void testCreateChangeAwareCollection2() {
    // Arrange
    WorkOnChange work = mock(WorkOnChange.class);

    ArrayList<Object> original = new ArrayList<>();
    original.add(BLCFieldUtils.NULL_FIELD);

    // Act
    Collection actualCreateChangeAwareCollectionResult = BLCCollectionUtils.createChangeAwareCollection(work, original);

    // Assert
    assertTrue(actualCreateChangeAwareCollectionResult instanceof List);
    assertEquals(1, actualCreateChangeAwareCollectionResult.size());
  }

  /**
   * Method under test:
   * {@link BLCCollectionUtils#createChangeAwareCollection(WorkOnChange, Collection)}
   */
  @Test
  public void testCreateChangeAwareCollection3() {
    // Arrange
    WorkOnChange work = mock(WorkOnChange.class);

    ArrayList<Object> original = new ArrayList<>();
    original.add(BLCFieldUtils.NULL_FIELD);
    original.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(original, BLCCollectionUtils.createChangeAwareCollection(work, original));
  }
}
