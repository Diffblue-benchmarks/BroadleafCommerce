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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class BLCArrayUtilsDiffblueTest {
  /**
   * Test {@link BLCArrayUtils#contains(Object[], TypedPredicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TypedPredicate} {@link TypedPredicate#evaluate(Object)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BLCArrayUtils#contains(Object[], TypedPredicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCArrayUtils.contains(Object[], TypedPredicate)"})
  public void testContains_givenFalse_whenTypedPredicateEvaluateReturnFalse_thenReturnFalse() {
    // Arrange
    TypedPredicate<Object> predicate = mock(TypedPredicate.class);
    when(predicate.evaluate(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualContainsResult =
        BLCArrayUtils.contains(new Object[] {BLCFieldUtils.NULL_FIELD}, predicate);

    // Assert
    verify(predicate).evaluate(isA(Object.class));
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link BLCArrayUtils#contains(Object[], TypedPredicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TypedPredicate} {@link TypedPredicate#evaluate(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BLCArrayUtils#contains(Object[], TypedPredicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCArrayUtils.contains(Object[], TypedPredicate)"})
  public void testContains_givenTrue_whenTypedPredicateEvaluateReturnTrue_thenReturnTrue() {
    // Arrange
    TypedPredicate<Object> predicate = mock(TypedPredicate.class);
    when(predicate.evaluate(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualContainsResult =
        BLCArrayUtils.contains(new Object[] {BLCFieldUtils.NULL_FIELD}, predicate);

    // Assert
    verify(predicate).evaluate(isA(Object.class));
    assertTrue(actualContainsResult);
  }

  /**
   * Test {@link BLCArrayUtils#asList(Object[])}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BLCArrayUtils#asList(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList BLCArrayUtils.asList(Object[])"})
  public void testAsList_whenArrayOfObjectWithNull_field_thenReturnSizeIsOne() {
    // Arrange and Act
    ArrayList<Object> actualAsListResult =
        BLCArrayUtils.asList(new Object[] {BLCFieldUtils.NULL_FIELD});

    // Assert
    assertEquals(1, actualAsListResult.size());
  }

  /**
   * Test {@link BLCArrayUtils#asList(Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCArrayUtils#asList(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList BLCArrayUtils.asList(Object[])"})
  public void testAsList_whenNull_thenReturnNull() {
    // Arrange and Act
    ArrayList<Object> actualAsListResult = BLCArrayUtils.asList(null);

    // Assert
    assertNull(actualAsListResult);
  }

  /**
   * Test {@link BLCArrayUtils#collect(Object[], TypedTransformer)}.
   *
   * <p>Method under test: {@link BLCArrayUtils#collect(Object[], TypedTransformer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList BLCArrayUtils.collect(Object[], TypedTransformer)"})
  public void testCollect() {
    // Arrange
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    ArrayList<Object> actualCollectResult =
        BLCArrayUtils.collect(new Object[] {BLCFieldUtils.NULL_FIELD}, transformer);

    // Assert
    verify(transformer).transform(isA(Object.class));
    assertEquals(1, actualCollectResult.size());
  }

  /**
   * Test {@link BLCArrayUtils#collectSet(Object[], TypedTransformer)}.
   *
   * <p>Method under test: {@link BLCArrayUtils#collectSet(Object[], TypedTransformer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"HashSet BLCArrayUtils.collectSet(Object[], TypedTransformer)"})
  public void testCollectSet() {
    // Arrange
    TypedTransformer<Object> transformer = mock(TypedTransformer.class);
    when(transformer.transform(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HashSet<Object> actualCollectSetResult =
        BLCArrayUtils.collectSet(new Object[] {BLCFieldUtils.NULL_FIELD}, transformer);

    // Assert
    verify(transformer).transform(isA(Object.class));
    assertEquals(1, actualCollectSetResult.size());
  }
}
