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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.Test;
import org.mockito.Mockito;

public class BLCArrayUtilsDiffblueTest {
  /**
   * Test {@link BLCArrayUtils#contains(Object[], TypedPredicate)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link TypedPredicate} {@link TypedPredicate#evaluate(Object)}
   * return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCArrayUtils#contains(Object[], TypedPredicate)}
   */
  @Test
  public void testContains_givenFalse_whenTypedPredicateEvaluateReturnFalse_thenReturnFalse() {
    // Arrange
    TypedPredicate<Object> predicate = mock(TypedPredicate.class);
    when(predicate.evaluate(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualContainsResult = BLCArrayUtils.contains(new Object[]{BLCFieldUtils.NULL_FIELD}, predicate);

    // Assert
    verify(predicate).evaluate(isA(Object.class));
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link BLCArrayUtils#contains(Object[], TypedPredicate)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link TypedPredicate} {@link TypedPredicate#evaluate(Object)}
   * return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCArrayUtils#contains(Object[], TypedPredicate)}
   */
  @Test
  public void testContains_givenTrue_whenTypedPredicateEvaluateReturnTrue_thenReturnTrue() {
    // Arrange
    TypedPredicate<Object> predicate = mock(TypedPredicate.class);
    when(predicate.evaluate(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualContainsResult = BLCArrayUtils.contains(new Object[]{BLCFieldUtils.NULL_FIELD}, predicate);

    // Assert
    verify(predicate).evaluate(isA(Object.class));
    assertTrue(actualContainsResult);
  }

  /**
   * Test {@link BLCArrayUtils#contains(Object[], TypedPredicate)}.
   * <ul>
   *   <li>When empty array of {@link Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCArrayUtils#contains(Object[], TypedPredicate)}
   */
  @Test
  public void testContains_whenEmptyArrayOfObject_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BLCArrayUtils.contains(new Object[]{}, mock(TypedPredicate.class)));
  }

  /**
   * Test {@link BLCArrayUtils#asList(Object[])}.
   * <ul>
   *   <li>When array of {@link Object} with {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCArrayUtils#asList(Object[])}
   */
  @Test
  public void testAsList_whenArrayOfObjectWithNull_field_thenReturnSizeIsOne() {
    // Arrange and Act
    ArrayList<Object> actualAsListResult = BLCArrayUtils.asList(new Object[]{BLCFieldUtils.NULL_FIELD});

    // Assert
    assertEquals(1, actualAsListResult.size());
  }

  /**
   * Test {@link BLCArrayUtils#asList(Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCArrayUtils#asList(Object[])}
   */
  @Test
  public void testAsList_whenNull_thenReturnNull() {
    // Arrange and Act
    ArrayList<Object> actualAsListResult = BLCArrayUtils.asList(null);

    // Assert
    assertNull(actualAsListResult);
  }

  /**
   * Test {@link BLCArrayUtils#collect(Object[], TypedTransformer)}.
   * <p>
   * Method under test: {@link BLCArrayUtils#collect(Object[], TypedTransformer)}
   */
  @Test
  public void testCollect() {
    // Arrange
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    ArrayList<Object> actualCollectResult = BLCArrayUtils.collect(new Object[]{BLCFieldUtils.NULL_FIELD}, transformer);

    // Assert
    verify(transformer).transform(isA(Object.class));
    assertEquals(1, actualCollectResult.size());
  }

  /**
   * Test {@link BLCArrayUtils#collectSet(Object[], TypedTransformer)}.
   * <p>
   * Method under test:
   * {@link BLCArrayUtils#collectSet(Object[], TypedTransformer)}
   */
  @Test
  public void testCollectSet() {
    // Arrange
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HashSet<Object> actualCollectSetResult = BLCArrayUtils.collectSet(new Object[]{BLCFieldUtils.NULL_FIELD},
        transformer);

    // Assert
    verify(transformer).transform(isA(Object.class));
    assertEquals(1, actualCollectSetResult.size());
  }
}
