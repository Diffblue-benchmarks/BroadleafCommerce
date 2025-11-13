package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StatCalcDiffblueTest {
  /**
   * Test {@link StatCalc#enter(double)}.
   *
   * <ul>
   *   <li>When {@link Double#NEGATIVE_INFINITY}.
   *   <li>Then {@link StatCalc} (default constructor) Max is {@link Double#NEGATIVE_INFINITY}.
   * </ul>
   *
   * <p>Method under test: {@link StatCalc#enter(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatCalc.enter(double)"})
  public void testEnter_whenNegative_infinity_thenStatCalcMaxIsNegative_infinity() {
    // Arrange
    StatCalc statCalc = new StatCalc();

    // Act
    statCalc.enter(Double.NEGATIVE_INFINITY);

    // Assert
    assertEquals(Double.NEGATIVE_INFINITY, statCalc.getMax(), 0.0);
    assertEquals(Double.NEGATIVE_INFINITY, statCalc.getMean(), 0.0);
    assertEquals(Double.NEGATIVE_INFINITY, statCalc.getMin(), 0.0);
    assertEquals(Double.NEGATIVE_INFINITY, statCalc.getSum(), 0.0);
  }

  /**
   * Test {@link StatCalc#enter(double)}.
   *
   * <ul>
   *   <li>When {@link Double#POSITIVE_INFINITY}.
   *   <li>Then {@link StatCalc} (default constructor) Max is {@link Double#POSITIVE_INFINITY}.
   * </ul>
   *
   * <p>Method under test: {@link StatCalc#enter(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatCalc.enter(double)"})
  public void testEnter_whenPositive_infinity_thenStatCalcMaxIsPositive_infinity() {
    // Arrange
    StatCalc statCalc = new StatCalc();

    // Act
    statCalc.enter(Double.POSITIVE_INFINITY);

    // Assert
    assertEquals(Double.POSITIVE_INFINITY, statCalc.getMax(), 0.0);
    assertEquals(Double.POSITIVE_INFINITY, statCalc.getMean(), 0.0);
    assertEquals(Double.POSITIVE_INFINITY, statCalc.getMin(), 0.0);
    assertEquals(Double.POSITIVE_INFINITY, statCalc.getSum(), 0.0);
  }

  /**
   * Test {@link StatCalc#enter(double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link StatCalc} (default constructor) StandardDeviation is zero.
   * </ul>
   *
   * <p>Method under test: {@link StatCalc#enter(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatCalc.enter(double)"})
  public void testEnter_whenTen_thenStatCalcStandardDeviationIsZero() {
    // Arrange
    StatCalc statCalc = new StatCalc();

    // Act
    statCalc.enter(10.0d);

    // Assert
    assertEquals(0.0d, statCalc.getStandardDeviation(), 0.0);
    assertEquals(10.0d, statCalc.getMax(), 0.0);
    assertEquals(10.0d, statCalc.getMean(), 0.0);
    assertEquals(10.0d, statCalc.getMin(), 0.0);
    assertEquals(10.0d, statCalc.getSum(), 0.0);
  }

  /**
   * Test {@link StatCalc#getMean()}.
   *
   * <p>Method under test: {@link StatCalc#getMean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double StatCalc.getMean()"})
  public void testGetMean() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, new StatCalc().getMean(), 0.0);
  }

  /**
   * Test {@link StatCalc#getStandardDeviation()}.
   *
   * <p>Method under test: {@link StatCalc#getStandardDeviation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double StatCalc.getStandardDeviation()"})
  public void testGetStandardDeviation() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, new StatCalc().getStandardDeviation(), 0.0);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StatCalc}
   *   <li>{@link StatCalc#getCount()}
   *   <li>{@link StatCalc#getMax()}
   *   <li>{@link StatCalc#getMin()}
   *   <li>{@link StatCalc#getSum()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StatCalc.<init>()",
    "int StatCalc.getCount()",
    "double StatCalc.getMax()",
    "double StatCalc.getMin()",
    "double StatCalc.getSum()"
  })
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
