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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.junit.Test;

public class MoneyDiffblueTest {
  /**
   * Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
  public void testGetCurrencyCode() {
    // Arrange, Act and Assert
    assertNull(Money.getCurrencyCode(new BroadleafCurrencyImpl()));
  }

  /**
   * Method under test: {@link Money#isZero()}
   */
  @Test
  public void testIsZero() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.isZero());
  }

  /**
   * Method under test: {@link Money#lessThan(BigDecimal)}
   */
  @Test
  public void testLessThan() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.lessThan(BankersRounding.ZERO));
    assertTrue(Money.ZERO.lessThan(new BigDecimal("2.3")));
    assertFalse(Money.ZERO.lessThan(Money.ZERO));
  }

  /**
   * Method under test: {@link Money#lessThanOrEqual(BigDecimal)}
   */
  @Test
  public void testLessThanOrEqual() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.lessThanOrEqual(BankersRounding.ZERO));
    assertFalse((new Money(10.0d)).lessThanOrEqual(BankersRounding.ZERO));
    assertTrue(Money.ZERO.lessThanOrEqual(Money.ZERO));
  }

  /**
   * Method under test: {@link Money#greaterThan(BigDecimal)}
   */
  @Test
  public void testGreaterThan() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.greaterThan(BankersRounding.ZERO));
    assertTrue((new Money(10.0d)).greaterThan(BankersRounding.ZERO));
    assertFalse(Money.ZERO.greaterThan(Money.ZERO));
  }

  /**
   * Method under test: {@link Money#greaterThanOrEqual(BigDecimal)}
   */
  @Test
  public void testGreaterThanOrEqual() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.greaterThanOrEqual(BankersRounding.ZERO));
    assertFalse(Money.ZERO.greaterThanOrEqual(new BigDecimal("2.3")));
    assertTrue(Money.ZERO.greaterThanOrEqual(Money.ZERO));
  }

  /**
   * Method under test: {@link Money#compareTo(BigDecimal)}
   */
  @Test
  public void testCompareTo() {
    // Arrange, Act and Assert
    assertEquals(0, Money.ZERO.compareTo(BankersRounding.ZERO));
  }
}
