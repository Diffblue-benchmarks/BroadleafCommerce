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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MoneyDiffblueTest {
  /**
   * Test {@link Money#getCurrencyCode(BroadleafCurrency)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Money.getCurrencyCode(BroadleafCurrency)"})
  public void testGetCurrencyCode_thenThrowIllegalArgumentException() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Money.getCurrencyCode(blCurrency));
    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#getCurrencyCode(BroadleafCurrency)}.
   * <ul>
   *   <li>When {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Money.getCurrencyCode(BroadleafCurrency)"})
  public void testGetCurrencyCode_whenBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Money.getCurrencyCode(new BroadleafCurrencyImpl()));
  }

  /**
   * Test {@link Money#getCurrencyCode(BroadleafCurrency)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code GBP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Money.getCurrencyCode(BroadleafCurrency)"})
  public void testGetCurrencyCode_whenNull_thenReturnGbp() {
    // Arrange, Act and Assert
    assertEquals("GBP", Money.getCurrencyCode(null));
  }

  /**
   * Test {@link Money#Money()}.
   * <p>
   * Method under test: {@link Money#Money()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>()"})
  public void testNewMoney() {
    // Arrange and Act
    Money actualMoney = new Money();

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
   * Test {@link Money#Money(int)}.
   * <p>
   * Method under test: {@link Money#Money(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(int)"})
  public void testNewMoney2() {
    // Arrange and Act
    Money actualMoney = new Money(10);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("10.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    Money expectedZeroResult = actualMoney.ZERO;
    assertEquals(expectedZeroResult, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(int, Currency)}.
   * <p>
   * Method under test: {@link Money#Money(int, Currency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(int, Currency)"})
  public void testNewMoney3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(10, (Currency) null));

  }

  /**
   * Test {@link Money#Money(long)}.
   * <p>
   * Method under test: {@link Money#Money(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(long)"})
  public void testNewMoney4() {
    // Arrange and Act
    Money actualMoney = new Money(10L);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("10.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    Money expectedZeroResult = actualMoney.ZERO;
    assertEquals(expectedZeroResult, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(long, Currency)}.
   * <p>
   * Method under test: {@link Money#Money(long, Currency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(long, Currency)"})
  public void testNewMoney5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(10L, (Currency) null));

  }

  /**
   * Test {@link Money#Money(BigDecimal, Currency)}.
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, Currency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, Currency)"})
  public void testNewMoney6() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(BankersRounding.ZERO, (Currency) null));

  }

  /**
   * Test {@link Money#Money(BigDecimal, Currency, int)}.
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, Currency, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, Currency, int)"})
  public void testNewMoney7() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(BankersRounding.ZERO, (Currency) null, 1));

  }

  /**
   * Test {@link Money#Money(Currency)}.
   * <p>
   * Method under test: {@link Money#Money(Currency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(Currency)"})
  public void testNewMoney8() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money((Currency) null));
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency)"})
  public void testNewMoney_thenThrowIllegalArgumentException() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(BankersRounding.ZERO, blCurrency));

    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int)"})
  public void testNewMoney_thenThrowIllegalArgumentException2() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(BankersRounding.ZERO, blCurrency, 1));

    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int, RoundingMode)"})
  public void testNewMoney_thenThrowIllegalArgumentException3() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(BankersRounding.ZERO, blCurrency, 1, RoundingMode.UP));

    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#Money(BroadleafCurrency)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BroadleafCurrency)"})
  public void testNewMoney_thenThrowIllegalArgumentException4() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(blCurrency));
    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency)"})
  public void testNewMoney_whenNull_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, (BroadleafCurrency) null);

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
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int)"})
  public void testNewMoney_whenNull_thenReturnCurrencyDisplayNameIsBritishPound2() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, (BroadleafCurrency) null, 1);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.0");
    assertEquals(expectedAmount, actualMoney.getAmount());
    Money money = actualMoney.ZERO;
    assertEquals(money, actualMoney.abs());
    assertEquals(money, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int, RoundingMode)"})
  public void testNewMoney_whenNull_thenReturnCurrencyDisplayNameIsBritishPound3() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, null, 1, RoundingMode.UP);

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
   * Test {@link Money#Money(BroadleafCurrency)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BroadleafCurrency)"})
  public void testNewMoney_whenNull_thenReturnCurrencyDisplayNameIsBritishPound4() {
    // Arrange and Act
    Money actualMoney = new Money((BroadleafCurrency) null);

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
   * Test {@link Money#Money(double)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(double)"})
  public void testNewMoney_whenTen_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange and Act
    Money actualMoney = new Money(10.0d);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("10.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    Money expectedZeroResult = actualMoney.ZERO;
    assertEquals(expectedZeroResult, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(double, Currency)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(double, Currency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(double, Currency)"})
  public void testNewMoney_whenTen_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(10.0d, (Currency) null));

  }

  /**
   * Test {@link Money#Money(BigDecimal)}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal)"})
  public void testNewMoney_whenZero_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO);

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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Money#toString()}
   *   <li>{@link Money#getAmount()}
   *   <li>{@link Money#getCurrency()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal Money.getAmount()", "Currency Money.getCurrency()", "String Money.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    Money money = new Money();

    // Act
    String actualToStringResult = money.toString();
    BigDecimal actualAmount = money.getAmount();
    Currency actualCurrency = money.getCurrency();

    // Assert
    assertEquals("0.00", actualToStringResult);
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
    assertEquals(new BigDecimal("0.00"), actualAmount);
  }

  /**
   * Test {@link Money#add(Money)}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#add(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.add(Money)"})
  public void testAdd_whenZero_thenReturnZero() {
    // Arrange and Act
    Money actualAddResult = Money.ZERO.add(Money.ZERO);

    // Assert
    assertEquals(actualAddResult.ZERO, actualAddResult);
  }

  /**
   * Test {@link Money#divide(BigDecimal, RoundingMode)} with {@code BigDecimal}, {@code RoundingMode}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(BigDecimal, RoundingMode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.divide(BigDecimal, RoundingMode)"})
  public void testDivideWithBigDecimalRoundingMode_whenBigDecimalWith23_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(new BigDecimal("2.3"), RoundingMode.UP);

    // Assert
    assertEquals(actualDivideResult.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#divide(BigDecimal)} with {@code BigDecimal}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.divide(BigDecimal)"})
  public void testDivideWithBigDecimal_whenBigDecimalWith23_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(new BigDecimal("2.3"));

    // Assert
    assertEquals(actualDivideResult.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#divide(double, RoundingMode)} with {@code double}, {@code RoundingMode}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(double, RoundingMode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.divide(double, RoundingMode)"})
  public void testDivideWithDoubleRoundingMode_givenMoney_whenTen_thenReturnMoney() {
    // Arrange
    Money money = new Money();

    // Act and Assert
    assertEquals(money, money.divide(10.0d, RoundingMode.UP));
  }

  /**
   * Test {@link Money#divide(double, RoundingMode)} with {@code double}, {@code RoundingMode}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(double, RoundingMode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.divide(double, RoundingMode)"})
  public void testDivideWithDoubleRoundingMode_givenZero_whenTen_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(10.0d, RoundingMode.UP);

    // Assert
    assertEquals(actualDivideResult.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#divide(double)} with {@code double}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.divide(double)"})
  public void testDivideWithDouble_givenMoney_whenTen_thenReturnMoney() {
    // Arrange
    Money money = new Money();

    // Act and Assert
    assertEquals(money, money.divide(10.0d));
  }

  /**
   * Test {@link Money#divide(double)} with {@code double}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.divide(double)"})
  public void testDivideWithDouble_givenZero_whenTen_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(10.0d);

    // Assert
    assertEquals(actualDivideResult.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#divide(int, RoundingMode)} with {@code int}, {@code RoundingMode}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(int, RoundingMode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.divide(int, RoundingMode)"})
  public void testDivideWithIntRoundingMode_whenTen_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(10, RoundingMode.UP);

    // Assert
    assertEquals(actualDivideResult.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#divide(int)} with {@code int}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.divide(int)"})
  public void testDivideWithInt_whenTen_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(10);

    // Assert
    assertEquals(actualDivideResult.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#abs()}.
   * <p>
   * Method under test: {@link Money#abs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.abs()"})
  public void testAbs() {
    // Arrange
    Money money = Money.ZERO;

    // Act
    Money actualAbsResult = money.abs();

    // Assert
    Money money2 = actualAbsResult.ZERO;
    assertEquals(money2, actualAbsResult);
    assertEquals(money2, money.zero());
  }

  /**
   * Test {@link Money#abs(Money)} with {@code Money}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#abs(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.abs(Money)"})
  public void testAbsWithMoney_whenZero_thenReturnZero() {
    // Arrange and Act
    Money actualAbsResult = Money.abs(Money.ZERO);

    // Assert
    assertEquals(actualAbsResult.ZERO, actualAbsResult);
  }

  /**
   * Test {@link Money#isZero()}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.isZero()"})
  public void testIsZero_givenMoneyWithAmountIsTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Money(10.0d)).isZero());
  }

  /**
   * Test {@link Money#isZero()}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.isZero()"})
  public void testIsZero_givenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.isZero());
  }

  /**
   * Test {@link Money#lessThan(Money)} with {@code other}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#lessThan(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.lessThan(Money)"})
  public void testLessThanWithOther_whenMoneyWithAmountIsTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.lessThan(new Money(10.0d)));
  }

  /**
   * Test {@link Money#lessThan(Money)} with {@code other}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#lessThan(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.lessThan(Money)"})
  public void testLessThanWithOther_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.lessThan(Money.ZERO));
  }

  /**
   * Test {@link Money#lessThan(BigDecimal)} with {@code value}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#lessThan(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.lessThan(BigDecimal)"})
  public void testLessThanWithValue_whenBigDecimalWith23_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.lessThan(new BigDecimal("2.3")));
  }

  /**
   * Test {@link Money#lessThan(BigDecimal)} with {@code value}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#lessThan(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.lessThan(BigDecimal)"})
  public void testLessThanWithValue_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.lessThan(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#lessThanOrEqual(BigDecimal)} with {@code value}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#lessThanOrEqual(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.lessThanOrEqual(BigDecimal)"})
  public void testLessThanOrEqualWithValue_givenMoneyWithAmountIsTen_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Money(10.0d)).lessThanOrEqual(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#lessThanOrEqual(BigDecimal)} with {@code value}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#lessThanOrEqual(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.lessThanOrEqual(BigDecimal)"})
  public void testLessThanOrEqualWithValue_givenZero_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.lessThanOrEqual(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#greaterThan(Money)} with {@code other}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#greaterThan(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.greaterThan(Money)"})
  public void testGreaterThanWithOther_givenMoneyWithAmountIsTen_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Money(10.0d)).greaterThan(Money.ZERO));
  }

  /**
   * Test {@link Money#greaterThan(Money)} with {@code other}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#greaterThan(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.greaterThan(Money)"})
  public void testGreaterThanWithOther_givenZero_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.greaterThan(Money.ZERO));
  }

  /**
   * Test {@link Money#greaterThan(BigDecimal)} with {@code value}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#greaterThan(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.greaterThan(BigDecimal)"})
  public void testGreaterThanWithValue_givenMoneyWithAmountIsTen_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Money(10.0d)).greaterThan(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#greaterThan(BigDecimal)} with {@code value}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#greaterThan(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.greaterThan(BigDecimal)"})
  public void testGreaterThanWithValue_givenZero_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.greaterThan(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#greaterThanOrEqual(Money)} with {@code other}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#greaterThanOrEqual(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.greaterThanOrEqual(Money)"})
  public void testGreaterThanOrEqualWithOther_whenMoneyWithAmountIsTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.greaterThanOrEqual(new Money(10.0d)));
  }

  /**
   * Test {@link Money#greaterThanOrEqual(Money)} with {@code other}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#greaterThanOrEqual(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.greaterThanOrEqual(Money)"})
  public void testGreaterThanOrEqualWithOther_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.greaterThanOrEqual(Money.ZERO));
  }

  /**
   * Test {@link Money#greaterThanOrEqual(BigDecimal)} with {@code value}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#greaterThanOrEqual(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.greaterThanOrEqual(BigDecimal)"})
  public void testGreaterThanOrEqualWithValue_whenBigDecimalWith23_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.greaterThanOrEqual(new BigDecimal("2.3")));
  }

  /**
   * Test {@link Money#greaterThanOrEqual(BigDecimal)} with {@code value}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#greaterThanOrEqual(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.greaterThanOrEqual(BigDecimal)"})
  public void testGreaterThanOrEqualWithValue_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.greaterThanOrEqual(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#defaultCurrency()}.
   * <p>
   * Method under test: {@link Money#defaultCurrency()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Currency Money.defaultCurrency()"})
  public void testDefaultCurrency() {
    // Arrange and Act
    Currency actualDefaultCurrencyResult = Money.defaultCurrency();

    // Assert
    assertEquals("British Pound", actualDefaultCurrencyResult.getDisplayName());
    assertEquals("GBP", actualDefaultCurrencyResult.getCurrencyCode());
    assertEquals("GBP", actualDefaultCurrencyResult.toString());
    assertEquals("£", actualDefaultCurrencyResult.getSymbol());
    assertEquals(2, actualDefaultCurrencyResult.getDefaultFractionDigits());
    assertEquals(826, actualDefaultCurrencyResult.getNumericCode());
  }

  /**
   * Test {@link Money#compareTo(Money)} with {@code other}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#compareTo(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Money.compareTo(Money)"})
  public void testCompareToWithOther_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Money.ZERO.compareTo(Money.ZERO));
  }

  /**
   * Test {@link Money#compareTo(BigDecimal)} with {@code value}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#compareTo(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Money.compareTo(BigDecimal)"})
  public void testCompareToWithValue_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Money.ZERO.compareTo(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#equals(Object)}, and {@link Money#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Money#equals(Object)}
   *   <li>{@link Money#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Money money = Money.ZERO;
    Money money2 = Money.ZERO;

    // Act and Assert
    assertEquals(money, money2);
    int expectedHashCodeResult = money.hashCode();
    assertEquals(expectedHashCodeResult, money2.hashCode());
  }

  /**
   * Test {@link Money#equals(Object)}, and {@link Money#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Money#equals(Object)}
   *   <li>{@link Money#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Money money = new Money();
    Money money2 = Money.ZERO;

    // Act and Assert
    assertEquals(money, money2);
    int expectedHashCodeResult = money.hashCode();
    assertEquals(expectedHashCodeResult, money2.hashCode());
  }

  /**
   * Test {@link Money#equals(Object)}, and {@link Money#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Money#equals(Object)}
   *   <li>{@link Money#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Money money = new Money(10.0d);
    Money money2 = new Money(10.0d);

    // Act and Assert
    assertEquals(money, money2);
    int expectedHashCodeResult = money.hashCode();
    assertEquals(expectedHashCodeResult, money2.hashCode());
  }

  /**
   * Test {@link Money#equals(Object)}, and {@link Money#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Money#equals(Object)}
   *   <li>{@link Money#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Money money = Money.ZERO;

    // Act and Assert
    assertEquals(money, money);
    int expectedHashCodeResult = money.hashCode();
    assertEquals(expectedHashCodeResult, money.hashCode());
  }

  /**
   * Test {@link Money#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Money(10.0d), Money.ZERO);
  }

  /**
   * Test {@link Money#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Money.ZERO, null);
  }

  /**
   * Test {@link Money#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Money.ZERO, "Different type to Money");
  }

  /**
   * Test {@link Money#clone()}.
   * <p>
   * Method under test: {@link Money#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object Money.clone()"})
  public void testClone() {
    // Arrange and Act
    Object actualCloneResult = Money.ZERO.clone();

    // Assert
    assertTrue(actualCloneResult instanceof Money);
    assertEquals(((Money) actualCloneResult).ZERO, actualCloneResult);
  }

  /**
   * Test {@link Money#doubleValue()}.
   * <p>
   * Method under test: {@link Money#doubleValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Money.doubleValue()"})
  public void testDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Money.ZERO.doubleValue(), 0.0);
  }
}
