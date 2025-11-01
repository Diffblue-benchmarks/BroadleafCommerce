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
import org.junit.Test;

public class StatCalcDiffblueTest {
  /**
   * Method under test: {@link StatCalc#enter(double)}
   */
  @Test
  public void testEnter() {
    // Arrange
    StatCalc statCalc = new StatCalc();

    // Act
    statCalc.enter(10.0d);

    // Assert
    assertEquals(0.0d, statCalc.getStandardDeviation(), 0.0);
    assertEquals(1, statCalc.getCount());
    assertEquals(10.0d, statCalc.getMax(), 0.0);
    assertEquals(10.0d, statCalc.getMean(), 0.0);
    assertEquals(10.0d, statCalc.getMin(), 0.0);
    assertEquals(10.0d, statCalc.getSum(), 0.0);
  }

  /**
   * Method under test: {@link StatCalc#enter(double)}
   */
  @Test
  public void testEnter2() {
    // Arrange
    StatCalc statCalc = new StatCalc();

    // Act
    statCalc.enter(Double.NEGATIVE_INFINITY);

    // Assert
    assertEquals(1, statCalc.getCount());
    assertEquals(Double.NEGATIVE_INFINITY, statCalc.getMax(), 0.0);
    assertEquals(Double.NEGATIVE_INFINITY, statCalc.getMean(), 0.0);
    assertEquals(Double.NEGATIVE_INFINITY, statCalc.getMin(), 0.0);
    assertEquals(Double.NEGATIVE_INFINITY, statCalc.getSum(), 0.0);
    assertEquals(Double.NaN, statCalc.getStandardDeviation(), 0.0);
  }

  /**
   * Method under test: {@link StatCalc#enter(double)}
   */
  @Test
  public void testEnter3() {
    // Arrange
    StatCalc statCalc = new StatCalc();

    // Act
    statCalc.enter(Double.POSITIVE_INFINITY);

    // Assert
    assertEquals(1, statCalc.getCount());
    assertEquals(Double.NaN, statCalc.getStandardDeviation(), 0.0);
    assertEquals(Double.POSITIVE_INFINITY, statCalc.getMax(), 0.0);
    assertEquals(Double.POSITIVE_INFINITY, statCalc.getMean(), 0.0);
    assertEquals(Double.POSITIVE_INFINITY, statCalc.getMin(), 0.0);
    assertEquals(Double.POSITIVE_INFINITY, statCalc.getSum(), 0.0);
  }

  /**
   * Method under test: {@link StatCalc#getMean()}
   */
  @Test
  public void testGetMean() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, (new StatCalc()).getMean(), 0.0);
  }

  /**
   * Method under test: {@link StatCalc#getStandardDeviation()}
   */
  @Test
  public void testGetStandardDeviation() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, (new StatCalc()).getStandardDeviation(), 0.0);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StatCalc}
   *   <li>{@link StatCalc#getCount()}
   *   <li>{@link StatCalc#getMax()}
   *   <li>{@link StatCalc#getMin()}
   *   <li>{@link StatCalc#getSum()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StatCalc actualStatCalc = new StatCalc();
    int actualCount = actualStatCalc.getCount();
    double actualMax = actualStatCalc.getMax();
    double actualMin = actualStatCalc.getMin();

    // Assert
    assertEquals(0, actualCount);
    assertEquals(0.0d, actualStatCalc.getSum(), 0.0);
    assertEquals(Double.NEGATIVE_INFINITY, actualMax, 0.0);
    assertEquals(Double.POSITIVE_INFINITY, actualMin, 0.0);
  }
}
