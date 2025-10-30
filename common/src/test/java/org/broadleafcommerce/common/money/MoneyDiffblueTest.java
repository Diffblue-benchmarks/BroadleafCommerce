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
import static org.junit.Assert.assertSame;
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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Money.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MoneyDiffblueTest {
  @Autowired
  private Money money;

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
   *   <li>Then return {@code USD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Money.getCurrencyCode(BroadleafCurrency)"})
  public void testGetCurrencyCode_whenNull_thenReturnUsd() {
    // Arrange, Act and Assert
    assertEquals("USD", Money.getCurrencyCode(null));
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
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
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
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
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
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
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
   * Test {@link Money#Money(int, String)}.
   * <p>
   * Method under test: {@link Money#Money(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(int, String)"})
  public void testNewMoney9() {
    // Arrange and Act
    Money actualMoney = new Money(10, "GBP");

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualMoney.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("10.00");
    assertEquals(expectedAmount2, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs().abs());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link Money#Money(long, String)}.
   * <p>
   * Method under test: {@link Money#Money(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(long, String)"})
  public void testNewMoney10() {
    // Arrange and Act
    Money actualMoney = new Money(10L, "GBP");

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualMoney.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("10.00");
    assertEquals(expectedAmount2, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs().abs());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertSame(currency, zeroResult.getCurrency());
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
   * Test {@link Money#Money(String, String)}.
   * <ul>
   *   <li>When {@code 10}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(String, String)"})
  public void testNewMoney_when10_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange and Act
    Money actualMoney = new Money("10", "GBP");

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualMoney.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("10.00");
    assertEquals(expectedAmount2, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs().abs());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link Money#Money(String)}.
   * <ul>
   *   <li>When {@code 10}.</li>
   *   <li>Then return Currency Symbol is {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(String)"})
  public void testNewMoney_when10_thenReturnCurrencySymbolIsDollarSign() {
    // Arrange and Act
    Money actualMoney = new Money("10");

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("10.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    Money expectedZeroResult = actualMoney.ZERO;
    assertEquals(expectedZeroResult, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(String, Currency)}.
   * <ul>
   *   <li>When {@code 10}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(String, Currency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(String, Currency)"})
  public void testNewMoney_when10_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money("10", (Currency) null));

  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Currency Symbol is {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency)"})
  public void testNewMoney_whenNull_thenReturnCurrencySymbolIsDollarSign() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, (BroadleafCurrency) null);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Currency Symbol is {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int)"})
  public void testNewMoney_whenNull_thenReturnCurrencySymbolIsDollarSign2() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, (BroadleafCurrency) null, 1);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
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
   *   <li>Then return Currency Symbol is {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int, RoundingMode)"})
  public void testNewMoney_whenNull_thenReturnCurrencySymbolIsDollarSign3() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, null, 1, RoundingMode.UP);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BroadleafCurrency)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Currency Symbol is {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BroadleafCurrency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BroadleafCurrency)"})
  public void testNewMoney_whenNull_thenReturnCurrencySymbolIsDollarSign4() {
    // Arrange and Act
    Money actualMoney = new Money((BroadleafCurrency) null);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(double, String)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(double, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(double, String)"})
  public void testNewMoney_whenTen_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange and Act
    Money actualMoney = new Money(10.0d, "GBP");

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualMoney.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("10.00");
    assertEquals(expectedAmount2, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs().abs());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link Money#Money(double)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return Currency Symbol is {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(double)"})
  public void testNewMoney_whenTen_thenReturnCurrencySymbolIsDollarSign() {
    // Arrange and Act
    Money actualMoney = new Money(10.0d);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
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
   * Test {@link Money#Money(BigDecimal, String)}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal, String)"})
  public void testNewMoney_whenZero_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, "GBP");

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
   * Test {@link Money#Money(BigDecimal)}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return Currency Symbol is {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Money.<init>(BigDecimal)"})
  public void testNewMoney_whenZero_thenReturnCurrencySymbolIsDollarSign() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
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
    assertEquals("$", actualCurrency.getSymbol());
    assertEquals("0.00", actualToStringResult);
    assertEquals("US Dollar", actualCurrency.getDisplayName());
    assertEquals("USD", actualCurrency.getCurrencyCode());
    assertEquals("USD", actualCurrency.toString());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(840, actualCurrency.getNumericCode());
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
   * Test {@link Money#subtract(Money)}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#subtract(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.subtract(Money)"})
  public void testSubtract_whenZero_thenReturnZero() {
    // Arrange and Act
    Money actualSubtractResult = Money.ZERO.subtract(Money.ZERO);

    // Assert
    assertEquals(actualSubtractResult.ZERO, actualSubtractResult);
  }

  /**
   * Test {@link Money#multiply(BigDecimal, RoundingMode)} with {@code BigDecimal}, {@code RoundingMode}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#multiply(BigDecimal, RoundingMode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.multiply(BigDecimal, RoundingMode)"})
  public void testMultiplyWithBigDecimalRoundingMode_whenZero_thenReturnZero() {
    // Arrange and Act
    Money actualMultiplyResult = Money.ZERO.multiply(BankersRounding.ZERO, RoundingMode.UP);

    // Assert
    assertEquals(actualMultiplyResult.ZERO, actualMultiplyResult);
  }

  /**
   * Test {@link Money#multiply(BigDecimal)} with {@code BigDecimal}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#multiply(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.multiply(BigDecimal)"})
  public void testMultiplyWithBigDecimal_whenZero_thenReturnZero() {
    // Arrange and Act
    Money actualMultiplyResult = Money.ZERO.multiply(BankersRounding.ZERO);

    // Assert
    assertEquals(actualMultiplyResult.ZERO, actualMultiplyResult);
  }

  /**
   * Test {@link Money#multiply(double)} with {@code double}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#multiply(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.multiply(double)"})
  public void testMultiplyWithDouble_givenMoney_whenTen_thenReturnMoney() {
    // Arrange
    Money money = new Money();

    // Act and Assert
    assertEquals(money, money.multiply(10.0d));
  }

  /**
   * Test {@link Money#multiply(double)} with {@code double}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#multiply(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.multiply(double)"})
  public void testMultiplyWithDouble_givenZero_whenTen_thenReturnZero() {
    // Arrange and Act
    Money actualMultiplyResult = Money.ZERO.multiply(10.0d);

    // Assert
    assertEquals(actualMultiplyResult.ZERO, actualMultiplyResult);
  }

  /**
   * Test {@link Money#multiply(int)} with {@code int}.
   * <p>
   * Method under test: {@link Money#multiply(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.multiply(int)"})
  public void testMultiplyWithInt() {
    // Arrange and Act
    Money actualMultiplyResult = Money.ZERO.multiply(10);

    // Assert
    assertEquals(actualMultiplyResult.ZERO, actualMultiplyResult);
  }

  /**
   * Test {@link Money#multiplyWithRounding(int, RoundingMode)}.
   * <ul>
   *   <li>When {@code UP}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#multiplyWithRounding(int, RoundingMode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.multiplyWithRounding(int, RoundingMode)"})
  public void testMultiplyWithRounding_whenUp_thenReturnZero() {
    // Arrange and Act
    Money actualMultiplyWithRoundingResult = Money.ZERO.multiplyWithRounding(1, RoundingMode.UP);

    // Assert
    assertEquals(actualMultiplyWithRoundingResult.ZERO, actualMultiplyWithRoundingResult);
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
   * Test {@link Money#min(Money, Money)} with {@code left}, {@code right}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#min(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.min(Money, Money)"})
  public void testMinWithLeftRight_whenMoneyWithAmountIsTen_thenReturnAbsIsZero() {
    // Arrange and Act
    Money actualMinResult = Money.min(Money.ZERO, new Money(10.0d));

    // Assert
    Money money = actualMinResult.ZERO;
    assertEquals(money, actualMinResult.abs());
    assertEquals(money, actualMinResult.zero());
  }

  /**
   * Test {@link Money#min(Money, Money)} with {@code left}, {@code right}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#min(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.min(Money, Money)"})
  public void testMinWithLeftRight_whenNull_thenReturnAbsIsZero() {
    // Arrange and Act
    Money actualMinResult = Money.min(Money.ZERO, null);

    // Assert
    Money money = actualMinResult.ZERO;
    assertEquals(money, actualMinResult.abs());
    assertEquals(money, actualMinResult.zero());
  }

  /**
   * Test {@link Money#min(Money, Money)} with {@code left}, {@code right}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#min(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.min(Money, Money)"})
  public void testMinWithLeftRight_whenZero_thenReturnAbsIsZero() {
    // Arrange and Act
    Money actualMinResult = Money.min(Money.ZERO, Money.ZERO);

    // Assert
    Money money = actualMinResult.ZERO;
    assertEquals(money, actualMinResult.abs());
    assertEquals(money, actualMinResult.zero());
  }

  /**
   * Test {@link Money#min(Money)} with {@code other}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#min(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.min(Money)"})
  public void testMinWithOther_whenMoneyWithAmountIsTen() {
    // Arrange and Act
    Money actualMinResult = Money.ZERO.min(new Money(10.0d));

    // Assert
    assertSame(actualMinResult.ZERO, actualMinResult);
  }

  /**
   * Test {@link Money#min(Money)} with {@code other}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#min(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.min(Money)"})
  public void testMinWithOther_whenNull() {
    // Arrange and Act
    Money actualMinResult = Money.ZERO.min(null);

    // Assert
    assertSame(actualMinResult.ZERO, actualMinResult);
  }

  /**
   * Test {@link Money#min(Money)} with {@code other}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#min(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.min(Money)"})
  public void testMinWithOther_whenZero() {
    // Arrange and Act
    Money actualMinResult = Money.ZERO.min(Money.ZERO);

    // Assert
    assertSame(actualMinResult.ZERO, actualMinResult);
  }

  /**
   * Test {@link Money#max(Money, Money)} with {@code left}, {@code right}.
   * <ul>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code 10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#max(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.max(Money, Money)"})
  public void testMaxWithLeftRight_thenReturnAmountIsBigDecimalWith1000() {
    // Arrange and Act
    Money actualMaxResult = Money.max(new Money(10.0d), Money.ZERO);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("10.00");
    assertEquals(expectedAmount, actualMaxResult.getAmount());
    assertEquals(actualMaxResult, actualMaxResult.abs());
    Money expectedZeroResult = actualMaxResult.ZERO;
    assertEquals(expectedZeroResult, actualMaxResult.zero());
  }

  /**
   * Test {@link Money#max(Money, Money)} with {@code left}, {@code right}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#max(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.max(Money, Money)"})
  public void testMaxWithLeftRight_whenNull_thenReturnAbsIsZero() {
    // Arrange and Act
    Money actualMaxResult = Money.max(Money.ZERO, null);

    // Assert
    Money money = actualMaxResult.ZERO;
    assertEquals(money, actualMaxResult.abs());
    assertEquals(money, actualMaxResult.zero());
  }

  /**
   * Test {@link Money#max(Money, Money)} with {@code left}, {@code right}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#max(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.max(Money, Money)"})
  public void testMaxWithLeftRight_whenZero_thenReturnAbsIsZero() {
    // Arrange and Act
    Money actualMaxResult = Money.max(Money.ZERO, Money.ZERO);

    // Assert
    Money money = actualMaxResult.ZERO;
    assertEquals(money, actualMaxResult.abs());
    assertEquals(money, actualMaxResult.zero());
  }

  /**
   * Test {@link Money#max(Money)} with {@code other}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#max(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.max(Money)"})
  public void testMaxWithOther_givenMoneyWithAmountIsTen_thenReturnMoneyWithAmountIsTen() {
    // Arrange
    Money money = new Money(10.0d);

    // Act and Assert
    assertSame(money, money.max(Money.ZERO));
  }

  /**
   * Test {@link Money#max(Money)} with {@code other}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#max(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.max(Money)"})
  public void testMaxWithOther_givenZero_whenNull_thenReturnZero() {
    // Arrange and Act
    Money actualMaxResult = Money.ZERO.max(null);

    // Assert
    assertSame(actualMaxResult.ZERO, actualMaxResult);
  }

  /**
   * Test {@link Money#max(Money)} with {@code other}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#max(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.max(Money)"})
  public void testMaxWithOther_givenZero_whenZero_thenReturnZero() {
    // Arrange and Act
    Money actualMaxResult = Money.ZERO.max(Money.ZERO);

    // Assert
    assertSame(actualMaxResult.ZERO, actualMaxResult);
  }

  /**
   * Test {@link Money#toAmount(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#toAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal Money.toAmount(Money)"})
  public void testToAmount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Money.toAmount(null));
  }

  /**
   * Test {@link Money#toAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#toAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal Money.toAmount(Money)"})
  public void testToAmount_whenZero_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualToAmountResult = Money.toAmount(Money.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualToAmountResult);
  }

  /**
   * Test {@link Money#toCurrency(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#toCurrency(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Currency Money.toCurrency(Money)"})
  public void testToCurrency_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Money.toCurrency(null));
  }

  /**
   * Test {@link Money#toCurrency(Money)}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return Symbol is {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#toCurrency(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Currency Money.toCurrency(Money)"})
  public void testToCurrency_whenZero_thenReturnSymbolIsDollarSign() {
    // Arrange and Act
    Currency actualToCurrencyResult = Money.toCurrency(Money.ZERO);

    // Assert
    assertEquals("$", actualToCurrencyResult.getSymbol());
    assertEquals("US Dollar", actualToCurrencyResult.getDisplayName());
    assertEquals("USD", actualToCurrencyResult.getCurrencyCode());
    assertEquals("USD", actualToCurrencyResult.toString());
    assertEquals(2, actualToCurrencyResult.getDefaultFractionDigits());
    assertEquals(840, actualToCurrencyResult.getNumericCode());
  }

  /**
   * Test {@link Money#negate()}.
   * <p>
   * Method under test: {@link Money#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.negate()"})
  public void testNegate() {
    // Arrange and Act
    Money actualNegateResult = Money.ZERO.negate();

    // Assert
    assertEquals(actualNegateResult.ZERO, actualNegateResult);
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
   * Test {@link Money#zero()}.
   * <p>
   * Method under test: {@link Money#zero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.zero()"})
  public void testZero() {
    // Arrange
    Money money = Money.ZERO;

    // Act
    Money actualZeroResult = money.zero();

    // Assert
    Money money2 = actualZeroResult.ZERO;
    assertEquals(money2, money.abs());
    assertEquals(money2, actualZeroResult);
  }

  /**
   * Test {@link Money#zero(Currency)} with {@code currency}.
   * <p>
   * Method under test: {@link Money#zero(Currency)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.zero(Currency)"})
  public void testZeroWithCurrency() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Money.zero((Currency) null));
  }

  /**
   * Test {@link Money#zero(String)} with {@code currencyCode}.
   * <ul>
   *   <li>When {@code GBP}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#zero(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.zero(String)"})
  public void testZeroWithCurrencyCode_whenGbp_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange and Act
    Money actualZeroResult = Money.zero("GBP");

    // Assert
    Currency currency = actualZeroResult.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualZeroResult.getAmount());
    assertEquals(actualZeroResult, actualZeroResult.abs());
    assertEquals(actualZeroResult, actualZeroResult.zero());
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
   * Test {@link Money#lessThanOrEqual(Money)} with {@code other}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#lessThanOrEqual(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.lessThanOrEqual(Money)"})
  public void testLessThanOrEqualWithOther_givenMoneyWithAmountIsTen_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Money(10.0d)).lessThanOrEqual(Money.ZERO));
  }

  /**
   * Test {@link Money#lessThanOrEqual(Money)} with {@code other}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#lessThanOrEqual(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Money.lessThanOrEqual(Money)"})
  public void testLessThanOrEqualWithOther_givenZero_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.lessThanOrEqual(Money.ZERO));
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
    assertEquals("$", actualDefaultCurrencyResult.getSymbol());
    assertEquals("US Dollar", actualDefaultCurrencyResult.getDisplayName());
    assertEquals("USD", actualDefaultCurrencyResult.getCurrencyCode());
    assertEquals("USD", actualDefaultCurrencyResult.toString());
    assertEquals(2, actualDefaultCurrencyResult.getDefaultFractionDigits());
    assertEquals(840, actualDefaultCurrencyResult.getNumericCode());
  }

  /**
   * Test {@link Money#trimUnnecessaryScaleToCurrency(Money)}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#trimUnnecessaryScaleToCurrency(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money Money.trimUnnecessaryScaleToCurrency(Money)"})
  public void testTrimUnnecessaryScaleToCurrency_whenZero_thenReturnZero() {
    // Arrange and Act
    Money actualTrimUnnecessaryScaleToCurrencyResult = Money.trimUnnecessaryScaleToCurrency(Money.ZERO);

    // Assert
    assertEquals(actualTrimUnnecessaryScaleToCurrencyResult.ZERO, actualTrimUnnecessaryScaleToCurrencyResult);
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

  /**
   * Test {@link Money#stringValue()}.
   * <p>
   * Method under test: {@link Money#stringValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Money.stringValue()"})
  public void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("0.00 USD", Money.ZERO.stringValue());
  }
}
