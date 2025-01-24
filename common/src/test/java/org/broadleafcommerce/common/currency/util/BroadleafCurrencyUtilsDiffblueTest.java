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
package org.broadleafcommerce.common.currency.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.BankersRounding;
import org.broadleafcommerce.common.money.Money;
import org.junit.Ignore;
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
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)}
   */
  @Test
  public void testGetMoneyWithAmountCurrency_whenNull() {
    // Arrange and Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney(BankersRounding.ZERO, null);

    // Assert
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
   * Test {@link BroadleafCurrencyUtils#getMoney(BigDecimal)} with {@code amount}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyUtils#getMoney(BigDecimal)}
   */
  @Test
  public void testGetMoneyWithAmount_whenZero_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange and Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney(BankersRounding.ZERO);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
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
   * Test {@link BroadleafCurrencyUtils#getMoney(BroadleafCurrency)} with
   * {@code currency}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyUtils#getMoney(BroadleafCurrency)}
   */
  @Test
  public void testGetMoneyWithCurrency_whenNull() {
    // Arrange and Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney((BroadleafCurrency) null);

    // Assert
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
   * Test {@link BroadleafCurrencyUtils#getCurrency(BroadleafCurrency)} with
   * {@code currency}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#getCurrency(BroadleafCurrency)}
   */
  @Test
  public void testGetCurrencyWithCurrency_whenNull_thenReturnDisplayNameIsBritishPound() {
    // Arrange and Act
    Currency actualCurrency = BroadleafCurrencyUtils.getCurrency((BroadleafCurrency) null);

    // Assert
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
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyUtils#getCurrency(Money)}
   */
  @Test
  public void testGetCurrencyWithMoney_whenNull() {
    // Arrange and Act
    Currency actualCurrency = BroadleafCurrencyUtils.getCurrency((Money) null);

    // Assert
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
   * Test {@link BroadleafCurrencyUtils#getUnitAmount(BroadleafCurrency)} with
   * {@code blCurrency}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#getUnitAmount(BroadleafCurrency)}
   */
  @Test
  public void testGetUnitAmountWithBlCurrency_whenNull_thenReturnZero() {
    // Arrange and Act
    Money actualUnitAmount = BroadleafCurrencyUtils.getUnitAmount((BroadleafCurrency) null);

    // Assert
    assertEquals(actualUnitAmount, actualUnitAmount.abs());
    Money expectedZeroResult = actualUnitAmount.ZERO;
    assertEquals(expectedZeroResult, actualUnitAmount.zero());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getUnitAmount(Money)} with
   * {@code difference}.
   * <ul>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code -0.01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyUtils#getUnitAmount(Money)}
   */
  @Test
  public void testGetUnitAmountWithDifference_thenReturnAmountIsBigDecimalWith001() {
    // Arrange and Act
    Money actualUnitAmount = BroadleafCurrencyUtils.getUnitAmount(new Money(-0.5d));

    // Assert
    BigDecimal expectedAmount = new BigDecimal("-0.01");
    assertEquals(expectedAmount, actualUnitAmount.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.01");
    Money absResult = actualUnitAmount.abs();
    assertEquals(expectedAmount2, absResult.getAmount());
    assertEquals(absResult.abs(), absResult.abs());
    Money money = actualUnitAmount.ZERO;
    assertEquals(money, absResult.zero());
    assertEquals(money, actualUnitAmount.zero());
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
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(new Money(10.0d), 0));
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

  /**
   * Test
   * {@link BroadleafCurrencyUtils#getNumberFormatFromCache(Locale, Currency, Map)}
   * with {@code locale}, {@code currency}, {@code localeToChange}.
   * <ul>
   *   <li>When Default.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#getNumberFormatFromCache(Locale, Currency, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetNumberFormatFromCacheWithLocaleCurrencyLocaleToChange_whenDefault() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.getNumberFormatFromCache(BroadleafCurrencyUtils.java:145)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Locale locale = Locale.getDefault();

    // Act
    BroadleafCurrencyUtils.getNumberFormatFromCache(locale, null, new HashMap<>());
  }

  /**
   * Test
   * {@link BroadleafCurrencyUtils#getNumberFormatFromCache(Locale, Currency)}
   * with {@code locale}, {@code currency}.
   * <ul>
   *   <li>When Default.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCurrencyUtils#getNumberFormatFromCache(Locale, Currency)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetNumberFormatFromCacheWithLocaleCurrency_whenDefault() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.getNumberFormatFromCache(BroadleafCurrencyUtils.java:145)
    //       at org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.getNumberFormatFromCache(BroadleafCurrencyUtils.java:141)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BroadleafCurrencyUtils.getNumberFormatFromCache(Locale.getDefault(), null);
  }
}
