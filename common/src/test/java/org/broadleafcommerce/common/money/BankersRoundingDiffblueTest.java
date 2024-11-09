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
package org.broadleafcommerce.common.money;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.Currency;
import org.junit.Test;

public class BankersRoundingDiffblueTest {
  /**
   * Test {@link BankersRounding#getScaleForCurrency(Currency)}.
   * <p>
   * Method under test: {@link BankersRounding#getScaleForCurrency(Currency)}
   */
  @Test
  public void testGetScaleForCurrency() {
    // Arrange, Act and Assert
    assertEquals(2, BankersRounding.getScaleForCurrency(null));
  }

  /**
   * Test {@link BankersRounding#setScale(BigDecimal, int)} with
   * {@code BigDecimal}, {@code int}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 2.300}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(BigDecimal, int)}
   */
  @Test
  public void testSetScaleWithBigDecimalInt_whenBigDecimalWith23_thenReturnBigDecimalWith2300() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(new BigDecimal("2.3"), 3);

    // Assert
    assertEquals(new BigDecimal("2.300"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(BigDecimal, int)} with
   * {@code BigDecimal}, {@code int}.
   * <ul>
   *   <li>When valueOf six.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 6.000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(BigDecimal, int)}
   */
  @Test
  public void testSetScaleWithBigDecimalInt_whenValueOfSix_thenReturnBigDecimalWith6000() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(BigDecimal.valueOf(6L), 3);

    // Assert
    assertEquals(new BigDecimal("6.000"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(BigDecimal, int)} with
   * {@code BigDecimal}, {@code int}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(BigDecimal, int)}
   */
  @Test
  public void testSetScaleWithBigDecimalInt_whenZero_thenReturnBigDecimalWith0000() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(BankersRounding.ZERO, 3);

    // Assert
    assertEquals(new BigDecimal("0.000"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(BigDecimal)} with {@code BigDecimal}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(BigDecimal)}
   */
  @Test
  public void testSetScaleWithBigDecimal_whenZero_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(double)} with {@code double}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(double)}
   */
  @Test
  public void testSetScaleWithDouble_whenTen_thenReturnBigDecimalWith1000() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(10.0d);

    // Assert
    assertEquals(new BigDecimal("10.00"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(int, BigDecimal)} with {@code int},
   * {@code BigDecimal}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(int, BigDecimal)}
   */
  @Test
  public void testSetScaleWithIntBigDecimal_whenOne_thenReturnBigDecimalWith00() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(1, BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.0"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(int, BigDecimal)} with {@code int},
   * {@code BigDecimal}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(int, BigDecimal)}
   */
  @Test
  public void testSetScaleWithIntBigDecimal_whenSix_thenReturnBigDecimalWith0000000() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(6, BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.000000"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(int, BigDecimal)} with {@code int},
   * {@code BigDecimal}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(int, BigDecimal)}
   */
  @Test
  public void testSetScaleWithIntBigDecimal_whenThree_thenReturnBigDecimalWith0000() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(3, BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.000"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(int, BigDecimal)} with {@code int},
   * {@code BigDecimal}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(int, BigDecimal)}
   */
  @Test
  public void testSetScaleWithIntBigDecimal_whenZero_thenReturnBigDecimalWith0() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(0, BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(int, double)} with {@code int},
   * {@code double}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(int, double)}
   */
  @Test
  public void testSetScaleWithIntDouble_whenOne_thenReturnBigDecimalWith100() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(1, 10.0d);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(int, double)} with {@code int},
   * {@code double}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 10.000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(int, double)}
   */
  @Test
  public void testSetScaleWithIntDouble_whenSix_thenReturnBigDecimalWith10000000() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(6, 10.0d);

    // Assert
    assertEquals(new BigDecimal("10.000000"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(int, double)} with {@code int},
   * {@code double}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 10.000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(int, double)}
   */
  @Test
  public void testSetScaleWithIntDouble_whenThree_thenReturnBigDecimalWith10000() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(3, 10.0d);

    // Assert
    assertEquals(new BigDecimal("10.000"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#setScale(int, double)} with {@code int},
   * {@code double}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#setScale(int, double)}
   */
  @Test
  public void testSetScaleWithIntDouble_whenZero_thenReturnBigDecimalWith10() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(0, 10.0d);

    // Assert
    assertEquals(new BigDecimal("10"), actualSetScaleResult);
  }

  /**
   * Test {@link BankersRounding#multiply(int, double, double)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#multiply(int, double, double)}
   */
  @Test
  public void testMultiply_whenOne_thenReturnOneHundred() {
    // Arrange, Act and Assert
    assertEquals(100.0d, BankersRounding.multiply(1, 10.0d, 10.0d), 0.0);
  }

  /**
   * Test {@link BankersRounding#multiply(int, double, double)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#multiply(int, double, double)}
   */
  @Test
  public void testMultiply_whenSix_thenReturnOneHundred() {
    // Arrange, Act and Assert
    assertEquals(100.0d, BankersRounding.multiply(6, 10.0d, 10.0d), 0.0);
  }

  /**
   * Test {@link BankersRounding#multiply(int, double, double)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#multiply(int, double, double)}
   */
  @Test
  public void testMultiply_whenThree_thenReturnOneHundred() {
    // Arrange, Act and Assert
    assertEquals(100.0d, BankersRounding.multiply(3, 10.0d, 10.0d), 0.0);
  }

  /**
   * Test {@link BankersRounding#multiply(int, double, double)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#multiply(int, double, double)}
   */
  @Test
  public void testMultiply_whenZero_thenReturnOneHundred() {
    // Arrange, Act and Assert
    assertEquals(100.0d, BankersRounding.multiply(0, 10.0d, 10.0d), 0.0);
  }

  /**
   * Test {@link BankersRounding#divide(BigDecimal, BigDecimal)} with
   * {@code BigDecimal}, {@code BigDecimal}.
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#divide(BigDecimal, BigDecimal)}
   */
  @Test
  public void testDivideWithBigDecimalBigDecimal_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualDivideResult = BankersRounding.divide(BankersRounding.ZERO, new BigDecimal("2.3"));

    // Assert
    assertEquals(new BigDecimal("0.00"), actualDivideResult);
  }

  /**
   * Test {@link BankersRounding#divide(int, BigDecimal, BigDecimal)} with
   * {@code int}, {@code BigDecimal}, {@code BigDecimal}.
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BankersRounding#divide(int, BigDecimal, BigDecimal)}
   */
  @Test
  public void testDivideWithIntBigDecimalBigDecimal_thenReturnBigDecimalWith0000() {
    // Arrange and Act
    BigDecimal actualDivideResult = BankersRounding.divide(3, BankersRounding.ZERO, new BigDecimal("2.3"));

    // Assert
    assertEquals(new BigDecimal("0.000"), actualDivideResult);
  }

  /**
   * Test {@link BankersRounding#divide(int, double, double)} with {@code int},
   * {@code double}, {@code double}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#divide(int, double, double)}
   */
  @Test
  public void testDivideWithIntDoubleDouble_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0d, BankersRounding.divide(1, 10.0d, 10.0d), 0.0);
  }

  /**
   * Test {@link BankersRounding#divide(int, double, double)} with {@code int},
   * {@code double}, {@code double}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#divide(int, double, double)}
   */
  @Test
  public void testDivideWithIntDoubleDouble_whenSix_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0d, BankersRounding.divide(6, 10.0d, 10.0d), 0.0);
  }

  /**
   * Test {@link BankersRounding#divide(int, double, double)} with {@code int},
   * {@code double}, {@code double}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#divide(int, double, double)}
   */
  @Test
  public void testDivideWithIntDoubleDouble_whenThree_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0d, BankersRounding.divide(3, 10.0d, 10.0d), 0.0);
  }

  /**
   * Test {@link BankersRounding#divide(int, double, double)} with {@code int},
   * {@code double}, {@code double}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankersRounding#divide(int, double, double)}
   */
  @Test
  public void testDivideWithIntDoubleDouble_whenTwo_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0d, BankersRounding.divide(2, 10.0d, 10.0d), 0.0);
  }

  /**
   * Test {@link BankersRounding#zeroAmount()}.
   * <p>
   * Method under test: {@link BankersRounding#zeroAmount()}
   */
  @Test
  public void testZeroAmount() {
    // Arrange and Act
    BigDecimal actualZeroAmountResult = BankersRounding.zeroAmount();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualZeroAmountResult);
  }
}
