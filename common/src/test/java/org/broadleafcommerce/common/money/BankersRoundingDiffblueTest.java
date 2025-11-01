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
package org.broadleafcommerce.common.money;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.Currency;
import org.junit.Test;

public class BankersRoundingDiffblueTest {
  /**
   * Method under test: {@link BankersRounding#getScaleForCurrency(Currency)}
   */
  @Test
  public void testGetScaleForCurrency() {
    // Arrange, Act and Assert
    assertEquals(2, BankersRounding.getScaleForCurrency(null));
  }

  /**
   * Method under test: {@link BankersRounding#setScale(double)}
   */
  @Test
  public void testSetScale() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(10.0d);

    // Assert
    assertEquals(new BigDecimal("10.00"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(int, double)}
   */
  @Test
  public void testSetScale2() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(3, 10.0d);

    // Assert
    assertEquals(new BigDecimal("10.000"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(int, double)}
   */
  @Test
  public void testSetScale3() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(6, 10.0d);

    // Assert
    assertEquals(new BigDecimal("10.000000"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(int, double)}
   */
  @Test
  public void testSetScale4() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(1, 10.0d);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(int, double)}
   */
  @Test
  public void testSetScale5() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(0, 10.0d);

    // Assert
    assertEquals(new BigDecimal("10"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(int, BigDecimal)}
   */
  @Test
  public void testSetScale6() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(3, BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.000"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(int, BigDecimal)}
   */
  @Test
  public void testSetScale7() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(6, BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.000000"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(int, BigDecimal)}
   */
  @Test
  public void testSetScale8() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(1, BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.0"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(int, BigDecimal)}
   */
  @Test
  public void testSetScale9() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(0, BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(BigDecimal)}
   */
  @Test
  public void testSetScale10() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(BigDecimal, int)}
   */
  @Test
  public void testSetScale11() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(BankersRounding.ZERO, 3);

    // Assert
    assertEquals(new BigDecimal("0.000"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(BigDecimal, int)}
   */
  @Test
  public void testSetScale12() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(new BigDecimal("2.3"), 3);

    // Assert
    assertEquals(new BigDecimal("2.300"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#setScale(BigDecimal, int)}
   */
  @Test
  public void testSetScale13() {
    // Arrange and Act
    BigDecimal actualSetScaleResult = BankersRounding.setScale(BigDecimal.valueOf(6L), 3);

    // Assert
    assertEquals(new BigDecimal("6.000"), actualSetScaleResult);
  }

  /**
   * Method under test: {@link BankersRounding#multiply(int, double, double)}
   */
  @Test
  public void testMultiply() {
    // Arrange, Act and Assert
    assertEquals(100.0d, BankersRounding.multiply(3, 10.0d, 10.0d), 0.0);
    assertEquals(100.0d, BankersRounding.multiply(6, 10.0d, 10.0d), 0.0);
    assertEquals(100.0d, BankersRounding.multiply(1, 10.0d, 10.0d), 0.0);
    assertEquals(100.0d, BankersRounding.multiply(0, 10.0d, 10.0d), 0.0);
  }

  /**
   * Method under test: {@link BankersRounding#divide(int, double, double)}
   */
  @Test
  public void testDivide() {
    // Arrange, Act and Assert
    assertEquals(1.0d, BankersRounding.divide(3, 10.0d, 10.0d), 0.0);
    assertEquals(1.0d, BankersRounding.divide(6, 10.0d, 10.0d), 0.0);
    assertEquals(1.0d, BankersRounding.divide(2, 10.0d, 10.0d), 0.0);
    assertEquals(1.0d, BankersRounding.divide(1, 10.0d, 10.0d), 0.0);
  }

  /**
   * Method under test:
   * {@link BankersRounding#divide(int, BigDecimal, BigDecimal)}
   */
  @Test
  public void testDivide2() {
    // Arrange and Act
    BigDecimal actualDivideResult = BankersRounding.divide(3, BankersRounding.ZERO, new BigDecimal("2.3"));

    // Assert
    assertEquals(new BigDecimal("0.000"), actualDivideResult);
  }

  /**
   * Method under test: {@link BankersRounding#divide(BigDecimal, BigDecimal)}
   */
  @Test
  public void testDivide3() {
    // Arrange and Act
    BigDecimal actualDivideResult = BankersRounding.divide(BankersRounding.ZERO, new BigDecimal("2.3"));

    // Assert
    assertEquals(new BigDecimal("0.00"), actualDivideResult);
  }

  /**
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
