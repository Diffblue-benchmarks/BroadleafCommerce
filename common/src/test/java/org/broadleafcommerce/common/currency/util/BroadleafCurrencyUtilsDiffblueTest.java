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
package org.broadleafcommerce.common.currency.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.BankersRounding;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;

public class BroadleafCurrencyUtilsDiffblueTest {
  /**
   * Test {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)}
   * with {@code amount}, {@code currency}.
   * <ul>
   *   <li>Given {@code GBP}.</li>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)}
   */
  @Test
  public void testGetMoneyWithAmountCurrency_givenGbp_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney(BankersRounding.ZERO, currency);

    // Assert
    verify(currency).getCurrencyCode();
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)}
   * with {@code amount}, {@code currency}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)}
   */
  @Test
  public void testGetMoneyWithAmountCurrency_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BroadleafCurrencyUtils.getMoney(null, null));
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getMoney(BigDecimal)} with {@code amount}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyUtils#getMoney(BigDecimal)}
   */
  @Test
  public void testGetMoneyWithAmount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BroadleafCurrencyUtils.getMoney((BigDecimal) null));
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getMoney(BroadleafCurrency)} with
   * {@code currency}.
   * <ul>
   *   <li>Given {@code GBP}.</li>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyUtils#getMoney(BroadleafCurrency)}
   */
  @Test
  public void testGetMoneyWithCurrency_givenGbp_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney(currency);

    // Assert
    verify(currency).getCurrencyCode();
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getCurrency(BroadleafCurrency)} with
   * {@code currency}.
   * <ul>
   *   <li>Given {@code GBP}.</li>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#getCurrency(BroadleafCurrency)}
   */
  @Test
  public void testGetCurrencyWithCurrency_givenGbp_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Currency actualCurrency = BroadleafCurrencyUtils.getCurrency(currency);

    // Assert
    verify(currency).getCurrencyCode();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getCurrency(Money)} with {@code money}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyUtils#getCurrency(Money)}
   */
  @Test
  public void testGetCurrencyWithMoney_whenZero() {
    // Arrange and Act
    Currency actualCurrency = BroadleafCurrencyUtils.getCurrency(Money.ZERO);

    // Assert
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getUnitAmount(BroadleafCurrency)} with
   * {@code blCurrency}.
   * <ul>
   *   <li>Given {@code GBP}.</li>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#getUnitAmount(BroadleafCurrency)}
   */
  @Test
  public void testGetUnitAmountWithBlCurrency_givenGbp_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualUnitAmount = BroadleafCurrencyUtils.getUnitAmount(blCurrency);

    // Assert
    verify(blCurrency).getCurrencyCode();
    assertEquals(actualUnitAmount, actualUnitAmount.abs());
    Money expectedZeroResult = actualUnitAmount.ZERO;
    assertEquals(expectedZeroResult, actualUnitAmount.zero());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getUnitAmount(Money)} with
   * {@code difference}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyUtils#getUnitAmount(Money)}
   */
  @Test
  public void testGetUnitAmountWithDifference_whenZero_thenReturnAmountIsBigDecimalWith001() {
    // Arrange and Act
    Money actualUnitAmount = BroadleafCurrencyUtils.getUnitAmount(Money.ZERO);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.01");
    assertEquals(expectedAmount, actualUnitAmount.getAmount());
    assertEquals(actualUnitAmount, actualUnitAmount.abs());
    Money expectedZeroResult = actualUnitAmount.ZERO;
    assertEquals(expectedZeroResult, actualUnitAmount.zero());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}
   */
  @Test
  public void testCalculateRemainder_whenMoneyWithAmountIsTen() {
    // Arrange, Act and Assert
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(new Money(10.0d), 1));
  }

  /**
   * Test {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}
   */
  @Test
  public void testCalculateRemainder_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(null, 0));
  }

  /**
   * Test {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}
   */
  @Test
  public void testCalculateRemainder_whenZero() {
    // Arrange, Act and Assert
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(Money.ZERO, 1));
  }
}
