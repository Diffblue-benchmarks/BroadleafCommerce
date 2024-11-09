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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import javassist.util.proxy.ProxyObjectOutputStream;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mvel2.util.InternalNumber;
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
   *   <li>Given {@code GBP}.</li>
   *   <li>When {@link BroadleafCurrency}
   * {@link BroadleafCurrency#getCurrencyCode()} return {@code GBP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
  public void testGetCurrencyCode_givenGbp_whenBroadleafCurrencyGetCurrencyCodeReturnGbp() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    String actualCurrencyCode = Money.getCurrencyCode(blCurrency);

    // Assert
    verify(blCurrency).getCurrencyCode();
    assertEquals("GBP", actualCurrencyCode);
  }

  /**
   * Test {@link Money#getCurrencyCode(BroadleafCurrency)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
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
    BigDecimal expectedAmount = new BigDecimal("10.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    Money expectedZeroResult = actualMoney.ZERO;
    assertEquals(expectedZeroResult, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(long, String)}.
   * <p>
   * Method under test: {@link Money#Money(long, String)}
   */
  @Test
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
    BigDecimal expectedAmount = new BigDecimal("10.00");
    assertEquals(expectedAmount, actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs());
    Money expectedZeroResult = actualMoney.ZERO;
    assertEquals(expectedZeroResult, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency)}.
   * <ul>
   *   <li>Given {@code GBP}.</li>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency)}
   */
  @Test
  public void testNewMoney_givenGbp_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = new Money(BankersRounding.ZERO, blCurrency);

    // Assert
    verify(blCurrency).getCurrencyCode();
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int)}.
   * <ul>
   *   <li>Given {@code GBP}.</li>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int)}
   */
  @Test
  public void testNewMoney_givenGbp_thenCallsGetCurrencyCode2() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = new Money(BankersRounding.ZERO, blCurrency, 1);

    // Assert
    verify(blCurrency).getCurrencyCode();
    Money money = actualMoney.ZERO;
    assertEquals(money, actualMoney.abs());
    assertEquals(money, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}.
   * <ul>
   *   <li>Given {@code GBP}.</li>
   *   <li>When {@link BroadleafCurrency}
   * {@link BroadleafCurrency#getCurrencyCode()} return {@code GBP}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}
   */
  @Test
  public void testNewMoney_givenGbp_whenBroadleafCurrencyGetCurrencyCodeReturnGbp() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = new Money(BankersRounding.ZERO, blCurrency, 1, RoundingMode.UP);

    // Assert
    verify(blCurrency).getCurrencyCode();
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BroadleafCurrency)}.
   * <ul>
   *   <li>Given {@code GBP}.</li>
   *   <li>When {@link BroadleafCurrency}
   * {@link BroadleafCurrency#getCurrencyCode()} return {@code GBP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BroadleafCurrency)}
   */
  @Test
  public void testNewMoney_givenGbp_whenBroadleafCurrencyGetCurrencyCodeReturnGbp2() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = new Money(blCurrency);

    // Assert
    verify(blCurrency).getCurrencyCode();
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, String)}.
   * <ul>
   *   <li>Given {@link BankersRounding#ZERO}.</li>
   *   <li>When {@link InternalNumber} {@link BigDecimal#setScale(int, int)} return
   * {@link BankersRounding#ZERO}.</li>
   *   <li>Then calls {@link BigDecimal#setScale(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, String)}
   */
  @Test
  public void testNewMoney_givenZero_whenInternalNumberSetScaleReturnZero_thenCallsSetScale() {
    // Arrange
    InternalNumber amount = mock(InternalNumber.class);
    when(amount.setScale(anyInt(), anyInt())).thenReturn(BankersRounding.ZERO);

    // Act
    Money actualMoney = new Money(amount, "GBP");

    // Assert
    verify(amount).setScale(eq(2), eq(6));
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}
   */
  @Test
  public void testNewMoney_thenThrowIllegalArgumentException() {
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
  public void testNewMoney_thenThrowIllegalArgumentException2() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(blCurrency));
    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#Money(String)}.
   * <ul>
   *   <li>When {@code 10}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(String)}
   */
  @Test
  public void testNewMoney_when10_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange and Act
    Money actualMoney = new Money("10");

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
   * Test {@link Money#Money(String, String)}.
   * <ul>
   *   <li>When {@code 10}.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(String, String)}
   */
  @Test
  public void testNewMoney_when10_thenReturnCurrencyDisplayNameIsBritishPound2() {
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
  public void testNewMoney_when10_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money("10", (Currency) null));

  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency)}
   */
  @Test
  public void testNewMoney_whenNull() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, (BroadleafCurrency) null);

    // Assert
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}
   */
  @Test
  public void testNewMoney_whenNull2() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, null, 1, RoundingMode.UP);

    // Assert
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BroadleafCurrency)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BroadleafCurrency)}
   */
  @Test
  public void testNewMoney_whenNull3() {
    // Arrange and Act
    Money actualMoney = new Money((BroadleafCurrency) null);

    // Assert
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int)}
   */
  @Test
  public void testNewMoney_whenNull_thenReturnAbsIsZero() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, (BroadleafCurrency) null, 1);

    // Assert
    Money money = actualMoney.ZERO;
    assertEquals(money, actualMoney.abs());
    assertEquals(money, actualMoney.zero());
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
   * Test {@link Money#Money(double, String)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(double, String)}
   */
  @Test
  public void testNewMoney_whenTen_thenReturnCurrencyDisplayNameIsBritishPound2() {
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
  public void testNewMoney_whenTen_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(10.0d, (Currency) null));

  }

  /**
   * Test {@link Money#Money(BigDecimal, String)}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#Money(BigDecimal, String)}
   */
  @Test
  public void testNewMoney_whenZero() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, "GBP");

    // Assert
    assertEquals(actualMoney, actualMoney.abs());
    assertEquals(actualMoney, actualMoney.zero());
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
  public void testSubtract_whenZero_thenReturnZero() {
    // Arrange and Act
    Money actualSubtractResult = Money.ZERO.subtract(Money.ZERO);

    // Assert
    assertEquals(actualSubtractResult.ZERO, actualSubtractResult);
  }

  /**
   * Test {@link Money#multiply(BigDecimal, RoundingMode)} with
   * {@code BigDecimal}, {@code RoundingMode}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#multiply(BigDecimal, RoundingMode)}
   */
  @Test
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
  public void testMultiplyWithRounding_whenUp_thenReturnZero() {
    // Arrange and Act
    Money actualMultiplyWithRoundingResult = Money.ZERO.multiplyWithRounding(1, RoundingMode.UP);

    // Assert
    assertEquals(actualMultiplyWithRoundingResult.ZERO, actualMultiplyWithRoundingResult);
  }

  /**
   * Test {@link Money#divide(BigDecimal, RoundingMode)} with {@code BigDecimal},
   * {@code RoundingMode}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(BigDecimal, RoundingMode)}
   */
  @Test
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
  public void testDivideWithBigDecimal_whenBigDecimalWith23_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(new BigDecimal("2.3"));

    // Assert
    assertEquals(actualDivideResult.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#divide(double, RoundingMode)} with {@code double},
   * {@code RoundingMode}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(double, RoundingMode)}
   */
  @Test
  public void testDivideWithDoubleRoundingMode_givenMoney_whenTen_thenReturnMoney() {
    // Arrange
    Money money = new Money();

    // Act and Assert
    assertEquals(money, money.divide(10.0d, RoundingMode.UP));
  }

  /**
   * Test {@link Money#divide(double, RoundingMode)} with {@code double},
   * {@code RoundingMode}.
   * <ul>
   *   <li>Given {@link Money#ZERO}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(double, RoundingMode)}
   */
  @Test
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
  public void testDivideWithDouble_givenZero_whenTen_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(10.0d);

    // Assert
    assertEquals(actualDivideResult.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#divide(int, RoundingMode)} with {@code int},
   * {@code RoundingMode}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#divide(int, RoundingMode)}
   */
  @Test
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
  public void testMinWithOther_whenZero() {
    // Arrange and Act
    Money actualMinResult = Money.ZERO.min(Money.ZERO);

    // Assert
    assertSame(actualMinResult.ZERO, actualMinResult);
  }

  /**
   * Test {@link Money#max(Money, Money)} with {@code left}, {@code right}.
   * <ul>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#max(Money, Money)}
   */
  @Test
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
  public void testToCurrency_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Money.toCurrency(null));
  }

  /**
   * Test {@link Money#toCurrency(Money)}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#toCurrency(Money)}
   */
  @Test
  public void testToCurrency_whenZero_thenReturnDisplayNameIsBritishPound() {
    // Arrange and Act
    Currency actualToCurrencyResult = Money.toCurrency(Money.ZERO);

    // Assert
    assertEquals("British Pound", actualToCurrencyResult.getDisplayName());
    assertEquals("GBP", actualToCurrencyResult.getCurrencyCode());
    assertEquals("GBP", actualToCurrencyResult.toString());
    assertEquals("£", actualToCurrencyResult.getSymbol());
    assertEquals(2, actualToCurrencyResult.getDefaultFractionDigits());
    assertEquals(826, actualToCurrencyResult.getNumericCode());
  }

  /**
   * Test {@link Money#negate()}.
   * <p>
   * Method under test: {@link Money#negate()}
   */
  @Test
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
   * Test {@link Money#writeExternal(ObjectOutput)}.
   * <ul>
   *   <li>Then calls {@link ObjectOutputStream#writeFloat(float)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Money#writeExternal(ObjectOutput)}
   */
  @Test
  public void testWriteExternal_thenCallsWriteFloat() throws IOException {
    // Arrange
    ProxyObjectOutputStream out = mock(ProxyObjectOutputStream.class);
    doNothing().when(out).writeFloat(anyFloat());

    // Act
    Money.ZERO.writeExternal(out);

    // Assert
    verify(out).writeFloat(eq(0.0f));
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
  public void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("0.00 GBP", Money.ZERO.stringValue());
  }
}
