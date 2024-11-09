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
   * Test {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls {@link TypedTransformer#transform(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}
   */
  @Test
  public void testCollect_givenNull_field_whenArrayListAddNull_field_thenCallsTransform() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    Collection<Object> actualCollectResult = BLCCollectionUtils.collect(inputCollection, transformer);

    // Assert
    verify(transformer).transform(isA(Object.class));
    assertEquals(inputCollection, actualCollectResult);
  }

  /**
   * Test {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls {@link TypedTransformer#transform(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}
   */
  @Test
  public void testCollect_givenNull_field_whenArrayListAddNull_field_thenCallsTransform2() {
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
   * Test {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}
   */
  @Test
  public void testCollect_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();

    // Act
    Collection<Object> actualCollectResult = BLCCollectionUtils.collect(inputCollection, null);

    // Assert
    assertEquals(inputCollection, actualCollectResult);
  }

  /**
   * Test {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}.
   * <ul>
   *   <li>When {@link TypedTransformer}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collect(Collection, TypedTransformer)}
   */
  @Test
  public void testCollect_whenTypedTransformer_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();

    // Act
    Collection<Object> actualCollectResult = BLCCollectionUtils.<Object>collect(inputCollection,
        mock(TypedTransformer.class));

    // Assert
    assertEquals(inputCollection, actualCollectResult);
  }

  /**
   * Test {@link BLCCollectionUtils#collectList(Collection, TypedTransformer)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collectList(Collection, TypedTransformer)}
   */
  @Test
  public void testCollectList_givenNull_field_whenArrayListAddNull_field_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    List<Object> actualCollectListResult = BLCCollectionUtils.collectList(inputCollection, transformer);

    // Assert
    verify(transformer).transform(isA(Object.class));
    assertEquals(inputCollection, actualCollectListResult);
  }

  /**
   * Test {@link BLCCollectionUtils#collectList(Collection, TypedTransformer)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collectList(Collection, TypedTransformer)}
   */
  @Test
  public void testCollectList_givenNull_field_whenArrayListAddNull_field_thenReturnArrayList2() {
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
   * Test {@link BLCCollectionUtils#collectList(Collection, TypedTransformer)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collectList(Collection, TypedTransformer)}
   */
  @Test
  public void testCollectList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualCollectListResult = BLCCollectionUtils.<Object>collectList(new ArrayList<>(),
        mock(TypedTransformer.class));

    // Assert
    assertTrue(actualCollectListResult.isEmpty());
  }

  /**
   * Test
   * {@link BLCCollectionUtils#collectArray(Collection, TypedTransformer, Class)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collectArray(Collection, TypedTransformer, Class)}
   */
  @Test
  public void testCollectArray_givenNull_field_whenJavaLangObject_thenReturnArrayLengthIsOne() {
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
   * Test
   * {@link BLCCollectionUtils#collectArray(Collection, TypedTransformer, Class)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return array length is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collectArray(Collection, TypedTransformer, Class)}
   */
  @Test
  public void testCollectArray_givenNull_field_whenJavaLangObject_thenReturnArrayLengthIsTwo() {
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
   * Test
   * {@link BLCCollectionUtils#collectArray(Collection, TypedTransformer, Class)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#collectArray(Collection, TypedTransformer, Class)}
   */
  @Test
  public void testCollectArray_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, BLCCollectionUtils.collectArray(inputCollection, transformer, clazz).length);
  }

  /**
   * Test {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link TypedPredicate} {@link TypedPredicate#evaluate(Object)}
   * return {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList_givenFalse_whenTypedPredicateEvaluateReturnFalse_thenReturnEmpty() {
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
   * Test {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList_givenTrue_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> inputCollection = new ArrayList<>();
    inputCollection.add(BLCFieldUtils.NULL_FIELD);
    TypedPredicate<Object> predicate = mock(TypedPredicate.class);
    when(predicate.evaluate(Mockito.<Object>any())).thenReturn(true);

    // Act
    List<Object> actualSelectListResult = BLCCollectionUtils.selectList(inputCollection, predicate);

    // Assert
    verify(predicate).evaluate(isA(Object.class));
    assertEquals(inputCollection, actualSelectListResult);
  }

  /**
   * Test {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList_givenTrue_thenReturnArrayList2() {
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
   * Test {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSelectListResult = BLCCollectionUtils.selectList(new ArrayList<>(), null);

    // Assert
    assertTrue(actualSelectListResult.isEmpty());
  }

  /**
   * Test {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}.
   * <ul>
   *   <li>When {@link TypedPredicate}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#selectList(Collection, TypedPredicate)}
   */
  @Test
  public void testSelectList_whenTypedPredicate_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSelectListResult = BLCCollectionUtils.selectList(new ArrayList<>(), mock(TypedPredicate.class));

    // Assert
    assertTrue(actualSelectListResult.isEmpty());
  }

  /**
   * Test {@link BLCCollectionUtils#createIfNull(List)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCCollectionUtils#createIfNull(List)}
   */
  @Test
  public void testCreateIfNull_givenNull_field_whenArrayListAddNull_field_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add(BLCFieldUtils.NULL_FIELD);

    // Act
    List<Object> actualCreateIfNullResult = BLCCollectionUtils.createIfNull(list);

    // Assert
    assertEquals(1, actualCreateIfNullResult.size());
  }

  /**
   * Test {@link BLCCollectionUtils#createIfNull(List)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCCollectionUtils#createIfNull(List)}
   */
  @Test
  public void testCreateIfNull_givenNull_field_whenArrayListAddNull_field_thenReturnSizeIsTwo() {
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
   * Test {@link BLCCollectionUtils#createIfNull(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCCollectionUtils#createIfNull(List)}
   */
  @Test
  public void testCreateIfNull_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualCreateIfNullResult = BLCCollectionUtils.createIfNull(new ArrayList<>());

    // Assert
    assertTrue(actualCreateIfNullResult.isEmpty());
  }

  /**
   * Test
   * {@link BLCCollectionUtils#createChangeAwareCollection(WorkOnChange, Collection)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#createChangeAwareCollection(WorkOnChange, Collection)}
   */
  @Test
  public void testCreateChangeAwareCollection_givenNull_field_whenArrayListAddNull_field() {
    // Arrange
    WorkOnChange work = mock(WorkOnChange.class);

    ArrayList<Object> original = new ArrayList<>();
    original.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(original, BLCCollectionUtils.createChangeAwareCollection(work, original));
  }

  /**
   * Test
   * {@link BLCCollectionUtils#createChangeAwareCollection(WorkOnChange, Collection)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#createChangeAwareCollection(WorkOnChange, Collection)}
   */
  @Test
  public void testCreateChangeAwareCollection_givenNull_field_whenArrayListAddNull_field2() {
    // Arrange
    WorkOnChange work = mock(WorkOnChange.class);

    ArrayList<Object> original = new ArrayList<>();
    original.add(BLCFieldUtils.NULL_FIELD);
    original.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(original, BLCCollectionUtils.createChangeAwareCollection(work, original));
  }

  /**
   * Test
   * {@link BLCCollectionUtils#createChangeAwareCollection(WorkOnChange, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCCollectionUtils#createChangeAwareCollection(WorkOnChange, Collection)}
   */
  @Test
  public void testCreateChangeAwareCollection_whenArrayList() {
    // Arrange
    WorkOnChange work = mock(WorkOnChange.class);
    ArrayList<Object> original = new ArrayList<>();

    // Act and Assert
    assertEquals(original, BLCCollectionUtils.createChangeAwareCollection(work, original));
  }
}
