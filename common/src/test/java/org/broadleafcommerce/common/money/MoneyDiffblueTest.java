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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
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
  @Autowired private Money money;

  /**
   * Test {@link Money#getCurrencyCode(BroadleafCurrency)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Money.getCurrencyCode(BroadleafCurrency)"})
  public void testGetCurrencyCode_thenThrowIllegalArgumentException() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Money.getCurrencyCode(blCurrency));
    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#getCurrencyCode(BroadleafCurrency)}.
   *
   * <ul>
   *   <li>When {@link BroadleafCurrencyImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Money.getCurrencyCode(BroadleafCurrency)"})
  public void testGetCurrencyCode_whenBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Money.getCurrencyCode(new BroadleafCurrencyImpl()));
  }

  /**
   * Test {@link Money#getCurrencyCode(BroadleafCurrency)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code USD}.
   * </ul>
   *
   * <p>Method under test: {@link Money#getCurrencyCode(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Money.getCurrencyCode(BroadleafCurrency)"})
  public void testGetCurrencyCode_whenNull_thenReturnUsd() {
    // Arrange, Act and Assert
    assertEquals("USD", Money.getCurrencyCode(null));
  }

  /**
   * Test {@link Money#Money()}.
   *
   * <p>Method under test: {@link Money#Money()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>()"})
  public void testNewMoney() {
    // Arrange and Act
    Money actualMoney = new Money();

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertEquals(new BigDecimal("0.00"), actualMoney.getAmount());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link Money#Money(int)}.
   *
   * <p>Method under test: {@link Money#Money(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(int)"})
  public void testNewMoney2() {
    // Arrange and Act
    Money actualMoney = new Money(10);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertEquals(new BigDecimal("10.00"), actualMoney.getAmount());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    assertEquals(Money.ZERO, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(int, Currency)}.
   *
   * <p>Method under test: {@link Money#Money(int, Currency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(int, Currency)"})
  public void testNewMoney3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(10, (Currency) null));
  }

  /**
   * Test {@link Money#Money(long)}.
   *
   * <p>Method under test: {@link Money#Money(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(long)"})
  public void testNewMoney4() {
    // Arrange and Act
    Money actualMoney = new Money(10L);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertEquals(new BigDecimal("10.00"), actualMoney.getAmount());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    assertEquals(Money.ZERO, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(long, Currency)}.
   *
   * <p>Method under test: {@link Money#Money(long, Currency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(long, Currency)"})
  public void testNewMoney5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(10L, (Currency) null));
  }

  /**
   * Test {@link Money#Money(BigDecimal, Currency)}.
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, Currency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, Currency)"})
  public void testNewMoney6() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new Money(BankersRounding.ZERO, (Currency) null));
  }

  /**
   * Test {@link Money#Money(BigDecimal, Currency, int)}.
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, Currency, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, Currency, int)"})
  public void testNewMoney7() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new Money(BankersRounding.ZERO, (Currency) null, 1));
  }

  /**
   * Test {@link Money#Money(Currency)}.
   *
   * <p>Method under test: {@link Money#Money(Currency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(Currency)"})
  public void testNewMoney8() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money((Currency) null));
  }

  /**
   * Test {@link Money#Money(int, String)}.
   *
   * <p>Method under test: {@link Money#Money(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(int, String)"})
  public void testNewMoney9() {
    // Arrange and Act
    Money actualMoney = new Money(10, "GBP");

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualMoney.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    assertEquals(new BigDecimal("10.00"), actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs().abs());
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link Money#Money(long, String)}.
   *
   * <p>Method under test: {@link Money#Money(long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(long, String)"})
  public void testNewMoney10() {
    // Arrange and Act
    Money actualMoney = new Money(10L, "GBP");

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualMoney.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    assertEquals(new BigDecimal("10.00"), actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs().abs());
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency)}.
   *
   * <ul>
   *   <li>Given {@code GBP}.
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency)"})
  public void testNewMoney_givenGbp_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = new Money(BankersRounding.ZERO, blCurrency);

    // Assert
    verify(blCurrency).getCurrencyCode();
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int)}.
   *
   * <ul>
   *   <li>Given {@code GBP}.
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int)"})
  public void testNewMoney_givenGbp_thenReturnCurrencyDisplayNameIsBritishPoundSterling2() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = new Money(BankersRounding.ZERO, blCurrency, 1);

    // Assert
    verify(blCurrency).getCurrencyCode();
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(826, currency.getNumericCode());
    Money absResult = actualMoney.abs();
    Money absResult2 = absResult.abs();
    assertEquals(absResult2, absResult2);
    assertEquals(absResult2, actualMoney.zero());
    assertEquals(absResult2, absResult.zero());
    assertSame(currency, absResult.getCurrency());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}.
   *
   * <ul>
   *   <li>Given {@code GBP}.
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int, RoundingMode)"})
  public void testNewMoney_givenGbp_thenReturnCurrencyDisplayNameIsBritishPoundSterling3() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = new Money(BankersRounding.ZERO, blCurrency, 1, RoundingMode.UP);

    // Assert
    verify(blCurrency).getCurrencyCode();
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link Money#Money(BroadleafCurrency)}.
   *
   * <ul>
   *   <li>Given {@code GBP}.
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BroadleafCurrency)"})
  public void testNewMoney_givenGbp_thenReturnCurrencyDisplayNameIsBritishPoundSterling4() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = new Money(blCurrency);

    // Assert
    verify(blCurrency).getCurrencyCode();
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency)"})
  public void testNewMoney_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(BankersRounding.ZERO, blCurrency));
    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int)"})
  public void testNewMoney_givenIllegalArgumentException_thenThrowIllegalArgumentException2() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new Money(BankersRounding.ZERO, blCurrency, 1));
    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int, RoundingMode)"})
  public void testNewMoney_givenIllegalArgumentException_thenThrowIllegalArgumentException3() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Money(BankersRounding.ZERO, blCurrency, 1, RoundingMode.UP));
    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#Money(BroadleafCurrency)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BroadleafCurrency)"})
  public void testNewMoney_givenIllegalArgumentException_thenThrowIllegalArgumentException4() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(blCurrency));
    verify(blCurrency).getCurrencyCode();
  }

  /**
   * Test {@link Money#Money(double, String)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.50}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(double, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(double, String)"})
  public void testNewMoney_when05_thenReturnAmountIsBigDecimalWith050() {
    // Arrange and Act
    Money actualMoney = new Money(0.5d, "GBP");

    // Assert
    assertEquals(new BigDecimal("0.50"), actualMoney.getAmount());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money zeroResult = actualMoney.zero();
    Money actualAbsResult2 = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult2);
    assertEquals(zeroResult.zero(), zeroResult.zero());
  }

  /**
   * Test {@link Money#Money(String, String)}.
   *
   * <ul>
   *   <li>When {@code 10}.
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code 10.00}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(String, String)"})
  public void testNewMoney_when10_thenReturnAmountIsBigDecimalWith1000() {
    // Arrange and Act
    Money actualMoney = new Money("10", "GBP");

    // Assert
    assertEquals(new BigDecimal("10.00"), actualMoney.getAmount());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money zeroResult = actualMoney.zero();
    Money actualAbsResult2 = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult2);
    assertEquals(zeroResult.zero(), zeroResult.zero());
  }

  /**
   * Test {@link Money#Money(String)}.
   *
   * <ul>
   *   <li>When {@code 10}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(String)"})
  public void testNewMoney_when10_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange and Act
    Money actualMoney = new Money("10");

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualMoney.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    assertEquals(new BigDecimal("10.00"), actualMoney.getAmount());
    assertEquals(actualMoney, actualMoney.abs().abs());
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link Money#Money(String, Currency)}.
   *
   * <ul>
   *   <li>When {@code 10}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(String, Currency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(String, Currency)"})
  public void testNewMoney_when10_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money("10", (Currency) null));
  }

  /**
   * Test {@link Money#Money(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code 42.00}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(String, String)"})
  public void testNewMoney_when42_thenReturnAmountIsBigDecimalWith4200() {
    // Arrange and Act
    Money actualMoney = new Money("42", "GBP");

    // Assert
    assertEquals(new BigDecimal("42.00"), actualMoney.getAmount());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money zeroResult = actualMoney.zero();
    Money actualAbsResult2 = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult2);
    assertEquals(zeroResult.zero(), zeroResult.zero());
  }

  /**
   * Test {@link Money#Money(String, Currency)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(String, Currency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(String, Currency)"})
  public void testNewMoney_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money("42", (Currency) null));
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency)"})
  public void testNewMoney_whenNull_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, (BroadleafCurrency) null);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int)"})
  public void testNewMoney_whenNull_thenReturnCurrencyDisplayNameIsUsDollar2() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, (BroadleafCurrency) null, 1);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    Money money = Money.ZERO;
    assertEquals(money, actualMoney.abs());
    assertEquals(money, actualMoney.zero());
  }

  /**
   * Test {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, BroadleafCurrency, int, RoundingMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, BroadleafCurrency, int, RoundingMode)"})
  public void testNewMoney_whenNull_thenReturnCurrencyDisplayNameIsUsDollar3() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, null, 1, RoundingMode.UP);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link Money#Money(BroadleafCurrency)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BroadleafCurrency)"})
  public void testNewMoney_whenNull_thenReturnCurrencyDisplayNameIsUsDollar4() {
    // Arrange and Act
    Money actualMoney = new Money((BroadleafCurrency) null);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link Money#Money(double, String)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code 10.00}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(double, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(double, String)"})
  public void testNewMoney_whenTen_thenReturnAmountIsBigDecimalWith1000() {
    // Arrange and Act
    Money actualMoney = new Money(10.0d, "GBP");

    // Assert
    assertEquals(new BigDecimal("10.00"), actualMoney.getAmount());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money zeroResult = actualMoney.zero();
    Money actualAbsResult2 = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult2);
    assertEquals(zeroResult.zero(), zeroResult.zero());
  }

  /**
   * Test {@link Money#Money(double, Currency)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(double, Currency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(double, Currency)"})
  public void testNewMoney_whenTen_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Money(10.0d, (Currency) null));
  }

  /**
   * Test {@link Money#Money(BigDecimal, String)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal, String)"})
  public void testNewMoney_whenZero_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO, "GBP");

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertEquals(new BigDecimal("0.00"), actualMoney.getAmount());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link Money#Money(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link Money#Money(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.<init>(BigDecimal)"})
  public void testNewMoney_whenZero_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange and Act
    Money actualMoney = new Money(BankersRounding.ZERO);

    // Assert
    Currency currency = actualMoney.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertEquals(new BigDecimal("0.00"), actualMoney.getAmount());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Money#toString()}
   *   <li>{@link Money#getAmount()}
   *   <li>{@link Money#getCurrency()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal Money.getAmount()",
    "Currency Money.getCurrency()",
    "String Money.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Money money = new Money();

    // Act
    String actualToStringResult = money.toString();
    BigDecimal actualAmount = money.getAmount();
    Currency actualCurrency = money.getCurrency();

    // Assert
    assertEquals("0.00", actualToStringResult);
    assertEquals("US Dollar", actualCurrency.getDisplayName());
    assertEquals("USD", actualCurrency.getCurrencyCode());
    assertEquals("USD", actualCurrency.getSymbol());
    assertEquals("USD", actualCurrency.toString());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(840, actualCurrency.getNumericCode());
    assertEquals(new BigDecimal("0.00"), actualAmount);
  }

  /**
   * Test {@link Money#subtract(Money)}.
   *
   * <ul>
   *   <li>Given {@link Money#ZERO}.
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link Money#subtract(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.subtract(Money)"})
  public void testSubtract_givenZero_whenZero_thenReturnAmountIsBigDecimalWith000() {
    // Arrange and Act
    Money actualSubtractResult = Money.ZERO.subtract(Money.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualSubtractResult.getAmount());
    Money actualAbsResult = actualSubtractResult.abs();
    assertEquals(actualSubtractResult, actualAbsResult);
    Money actualZeroResult = actualSubtractResult.zero();
    assertEquals(actualSubtractResult, actualZeroResult);
  }

  /**
   * Test {@link Money#multiply(BigDecimal, RoundingMode)} with {@code BigDecimal}, {@code
   * RoundingMode}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Money#multiply(BigDecimal, RoundingMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.multiply(BigDecimal, RoundingMode)"})
  public void testMultiplyWithBigDecimalRoundingMode_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, Money.ZERO.multiply(BankersRounding.ZERO, RoundingMode.UP));
  }

  /**
   * Test {@link Money#multiply(BigDecimal)} with {@code BigDecimal}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Money#multiply(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.multiply(BigDecimal)"})
  public void testMultiplyWithBigDecimal_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, Money.ZERO.multiply(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#multiply(double)} with {@code double}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Money#multiply(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.multiply(double)"})
  public void testMultiplyWithDouble_whenTen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, Money.ZERO.multiply(10.0d));
  }

  /**
   * Test {@link Money#multiply(int)} with {@code int}.
   *
   * <p>Method under test: {@link Money#multiply(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.multiply(int)"})
  public void testMultiplyWithInt() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, Money.ZERO.multiply(10));
  }

  /**
   * Test {@link Money#multiplyWithRounding(int, RoundingMode)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Money#multiplyWithRounding(int, RoundingMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.multiplyWithRounding(int, RoundingMode)"})
  public void testMultiplyWithRounding_whenUp_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, Money.ZERO.multiplyWithRounding(1, RoundingMode.UP));
  }

  /**
   * Test {@link Money#divide(BigDecimal, RoundingMode)} with {@code BigDecimal}, {@code
   * RoundingMode}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Money#divide(BigDecimal, RoundingMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.divide(BigDecimal, RoundingMode)"})
  public void testDivideWithBigDecimalRoundingMode_whenBigDecimalWith23_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(new BigDecimal("2.3"), RoundingMode.UP);

    // Assert
    assertEquals(Money.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#divide(BigDecimal)} with {@code BigDecimal}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Money#divide(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.divide(BigDecimal)"})
  public void testDivideWithBigDecimal_whenBigDecimalWith23_thenReturnZero() {
    // Arrange and Act
    Money actualDivideResult = Money.ZERO.divide(new BigDecimal("2.3"));

    // Assert
    assertEquals(Money.ZERO, actualDivideResult);
  }

  /**
   * Test {@link Money#divide(double, RoundingMode)} with {@code double}, {@code RoundingMode}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Money#divide(double, RoundingMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.divide(double, RoundingMode)"})
  public void testDivideWithDoubleRoundingMode_whenTen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, Money.ZERO.divide(10.0d, RoundingMode.UP));
  }

  /**
   * Test {@link Money#abs()}.
   *
   * <p>Method under test: {@link Money#abs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.abs()"})
  public void testAbs() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, Money.ZERO.abs());
  }

  /**
   * Test {@link Money#abs(Money)} with {@code Money}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Money#abs(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.abs(Money)"})
  public void testAbsWithMoney_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, Money.abs(Money.ZERO));
  }

  /**
   * Test {@link Money#min(Money, Money)} with {@code left}, {@code right}.
   *
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link Money#min(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.min(Money, Money)"})
  public void testMinWithLeftRight_whenMoneyWithAmountIsTen() {
    // Arrange and Act
    Money actualMinResult = Money.min(Money.ZERO, new Money(10.0d));

    // Assert
    Money actualAbsResult = actualMinResult.abs();
    assertEquals(actualMinResult, actualAbsResult);
    Money actualZeroResult = actualMinResult.zero();
    assertEquals(actualMinResult, actualZeroResult);
  }

  /**
   * Test {@link Money#max(Money, Money)} with {@code left}, {@code right}.
   *
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link Money#max(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.max(Money, Money)"})
  public void testMaxWithLeftRight_thenReturnZeroAmountIsBigDecimalWith000() {
    // Arrange and Act
    Money actualMaxResult = Money.max(new Money(10.0d), Money.ZERO);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualMaxResult.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    assertEquals(new BigDecimal("10.00"), actualMaxResult.getAmount());
    Money actualAbsResult = actualMaxResult.abs();
    assertEquals(actualMaxResult, actualAbsResult);
    BigDecimal amount = zeroResult.zero().getAmount();
    assertSame(amount, zeroResult.abs().getAmount());
    assertSame(amount, amount);
  }

  /**
   * Test {@link Money#max(Money)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   *   <li>Then return {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link Money#max(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.max(Money)"})
  public void testMaxWithOther_givenMoneyWithAmountIsTen_thenReturnMoneyWithAmountIsTen() {
    // Arrange
    Money money = new Money(10.0d);

    // Act
    Money actualMaxResult = money.max(Money.ZERO);

    // Assert
    assertSame(money, actualMaxResult);
  }

  /**
   * Test {@link Money#toAmount(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Money#toAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Money.toAmount(Money)"})
  public void testToAmount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Money.toAmount(null));
  }

  /**
   * Test {@link Money#toCurrency(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Money#toCurrency(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency Money.toCurrency(Money)"})
  public void testToCurrency_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Money.toCurrency(null));
  }

  /**
   * Test {@link Money#toCurrency(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link Money#toCurrency(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency Money.toCurrency(Money)"})
  public void testToCurrency_whenZero_thenReturnDisplayNameIsUsDollar() {
    // Arrange and Act
    Currency actualToCurrencyResult = Money.toCurrency(Money.ZERO);

    // Assert
    assertEquals("US Dollar", actualToCurrencyResult.getDisplayName());
    assertEquals("USD", actualToCurrencyResult.getCurrencyCode());
    assertEquals("USD", actualToCurrencyResult.getSymbol());
    assertEquals("USD", actualToCurrencyResult.toString());
    assertEquals(2, actualToCurrencyResult.getDefaultFractionDigits());
    assertEquals(840, actualToCurrencyResult.getNumericCode());
  }

  /**
   * Test {@link Money#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Money#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.isZero()"})
  public void testIsZero_givenMoneyWithAmountIsTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Money(10.0d).isZero());
  }

  /**
   * Test {@link Money#zero()}.
   *
   * <p>Method under test: {@link Money#zero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.zero()"})
  public void testZero() {
    // Arrange and Act
    Money actualZeroResult = Money.ZERO.zero();

    // Assert
    Currency currency = actualZeroResult.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertEquals(new BigDecimal("0.00"), actualZeroResult.getAmount());
    Money actualAbsResult = actualZeroResult.abs();
    assertEquals(actualZeroResult, actualAbsResult);
  }

  /**
   * Test {@link Money#zero(Currency)} with {@code currency}.
   *
   * <p>Method under test: {@link Money#zero(Currency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.zero(Currency)"})
  public void testZeroWithCurrency() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Money.zero((Currency) null));
  }

  /**
   * Test {@link Money#zero(String)} with {@code currencyCode}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link Money#zero(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.zero(String)"})
  public void testZeroWithCurrencyCode_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange and Act
    Money actualZeroResult = Money.zero("GBP");

    // Assert
    Currency currency = actualZeroResult.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertEquals(new BigDecimal("0.00"), actualZeroResult.getAmount());
    Money actualAbsResult = actualZeroResult.abs();
    assertEquals(actualZeroResult, actualAbsResult);
    Money actualZeroResult2 = actualZeroResult.zero();
    assertEquals(actualZeroResult, actualZeroResult2);
  }

  /**
   * Test {@link Money#lessThan(Money)} with {@code other}.
   *
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Money#lessThan(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.lessThan(Money)"})
  public void testLessThanWithOther_whenMoneyWithAmountIsTen_thenReturnTrue() {
    // Arrange and Act
    boolean actualLessThanResult = Money.ZERO.lessThan(new Money(10.0d));

    // Assert
    assertTrue(actualLessThanResult);
  }

  /**
   * Test {@link Money#lessThan(Money)} with {@code other}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Money#lessThan(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.lessThan(Money)"})
  public void testLessThanWithOther_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.lessThan(Money.ZERO));
  }

  /**
   * Test {@link Money#lessThan(BigDecimal)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Money#lessThan(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.lessThan(BigDecimal)"})
  public void testLessThanWithValue_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.lessThan(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#lessThanOrEqual(Money)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link Money#ZERO}.
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Money#lessThanOrEqual(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.lessThanOrEqual(Money)"})
  public void testLessThanOrEqualWithOther_givenZero_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.lessThanOrEqual(Money.ZERO));
  }

  /**
   * Test {@link Money#lessThanOrEqual(BigDecimal)} with {@code value}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Money#lessThanOrEqual(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.lessThanOrEqual(BigDecimal)"})
  public void testLessThanOrEqualWithValue_givenMoneyWithAmountIsTen_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Money(10.0d).lessThanOrEqual(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#greaterThan(Money)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Money#greaterThan(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.greaterThan(Money)"})
  public void testGreaterThanWithOther_givenMoneyWithAmountIsTen_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Money(10.0d).greaterThan(Money.ZERO));
  }

  /**
   * Test {@link Money#greaterThan(Money)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link Money#ZERO}.
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Money#greaterThan(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.greaterThan(Money)"})
  public void testGreaterThanWithOther_givenZero_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Money.ZERO.greaterThan(Money.ZERO));
  }

  /**
   * Test {@link Money#greaterThan(BigDecimal)} with {@code value}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Money#greaterThan(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.greaterThan(BigDecimal)"})
  public void testGreaterThanWithValue_givenMoneyWithAmountIsTen_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Money(10.0d).greaterThan(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#greaterThanOrEqual(Money)} with {@code other}.
   *
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Money#greaterThanOrEqual(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.greaterThanOrEqual(Money)"})
  public void testGreaterThanOrEqualWithOther_whenMoneyWithAmountIsTen_thenReturnFalse() {
    // Arrange and Act
    boolean actualGreaterThanOrEqualResult = Money.ZERO.greaterThanOrEqual(new Money(10.0d));

    // Assert
    assertFalse(actualGreaterThanOrEqualResult);
  }

  /**
   * Test {@link Money#greaterThanOrEqual(Money)} with {@code other}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Money#greaterThanOrEqual(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.greaterThanOrEqual(Money)"})
  public void testGreaterThanOrEqualWithOther_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.greaterThanOrEqual(Money.ZERO));
  }

  /**
   * Test {@link Money#greaterThanOrEqual(BigDecimal)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Money#greaterThanOrEqual(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.greaterThanOrEqual(BigDecimal)"})
  public void testGreaterThanOrEqualWithValue_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Money.ZERO.greaterThanOrEqual(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#defaultCurrency()}.
   *
   * <p>Method under test: {@link Money#defaultCurrency()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency Money.defaultCurrency()"})
  public void testDefaultCurrency() {
    // Arrange and Act
    Currency actualDefaultCurrencyResult = Money.defaultCurrency();

    // Assert
    assertEquals("US Dollar", actualDefaultCurrencyResult.getDisplayName());
    assertEquals("USD", actualDefaultCurrencyResult.getCurrencyCode());
    assertEquals("USD", actualDefaultCurrencyResult.getSymbol());
    assertEquals("USD", actualDefaultCurrencyResult.toString());
    assertEquals(2, actualDefaultCurrencyResult.getDefaultFractionDigits());
    assertEquals(840, actualDefaultCurrencyResult.getNumericCode());
  }

  /**
   * Test {@link Money#readExternal(ObjectInput)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then calls {@link ObjectInputStream#readFloat()}.
   * </ul>
   *
   * <p>Method under test: {@link Money#readExternal(ObjectInput)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Money.readExternal(ObjectInput)"})
  public void testReadExternal_givenTen_thenCallsReadFloat()
      throws IOException, ClassNotFoundException {
    // Arrange
    ObjectInputStream in = mock(ObjectInputStream.class);
    when(in.readFloat()).thenReturn(10.0f);

    // Act
    Money.ZERO.readExternal(in);

    // Assert
    verify(in).readFloat();
  }

  /**
   * Test {@link Money#trimUnnecessaryScaleToCurrency(Money)}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link Money#trimUnnecessaryScaleToCurrency(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money Money.trimUnnecessaryScaleToCurrency(Money)"})
  public void testTrimUnnecessaryScaleToCurrency_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange and Act
    Money actualTrimUnnecessaryScaleToCurrencyResult =
        Money.trimUnnecessaryScaleToCurrency(Money.ZERO);

    // Assert
    Currency currency = actualTrimUnnecessaryScaleToCurrencyResult.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualTrimUnnecessaryScaleToCurrencyResult.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    assertEquals(new BigDecimal("10.00"), actualTrimUnnecessaryScaleToCurrencyResult.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
    assertEquals(
        actualTrimUnnecessaryScaleToCurrencyResult,
        actualTrimUnnecessaryScaleToCurrencyResult.abs().abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link Money#compareTo(Money)} with {@code other}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Money#compareTo(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Money.compareTo(Money)"})
  public void testCompareToWithOther_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Money.ZERO.compareTo(Money.ZERO));
  }

  /**
   * Test {@link Money#compareTo(BigDecimal)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Money#compareTo(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Money.compareTo(BigDecimal)"})
  public void testCompareToWithValue_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Money.ZERO.compareTo(BankersRounding.ZERO));
  }

  /**
   * Test {@link Money#equals(Object)}, and {@link Money#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Money#equals(Object)}
   *   <li>{@link Money#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Money money = Money.ZERO;
    Money money2 = Money.ZERO;

    // Act and Assert
    assertEquals(money, money2);
    assertEquals(money.hashCode(), money2.hashCode());
  }

  /**
   * Test {@link Money#equals(Object)}, and {@link Money#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Money#equals(Object)}
   *   <li>{@link Money#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Money money = new Money(10.0d);
    Money money2 = new Money(10.0d);

    // Act and Assert
    assertEquals(money, money2);
    assertEquals(money.hashCode(), money2.hashCode());
  }

  /**
   * Test {@link Money#equals(Object)}, and {@link Money#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Money#equals(Object)}
   *   <li>{@link Money#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Money#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Money(10.0d), Money.ZERO);
  }

  /**
   * Test {@link Money#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Money#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Money.ZERO, null);
  }

  /**
   * Test {@link Money#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Money#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Money.equals(Object)", "int Money.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Money.ZERO, "Different type to Money");
  }

  /**
   * Test {@link Money#clone()}.
   *
   * <p>Method under test: {@link Money#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Money.clone()"})
  public void testClone() {
    // Arrange and Act
    Object actualCloneResult = Money.ZERO.clone();

    // Assert
    assertTrue(actualCloneResult instanceof Money);
    assertEquals(((Money) actualCloneResult).ZERO, actualCloneResult);
  }

  /**
   * Test {@link Money#stringValue()}.
   *
   * <p>Method under test: {@link Money#stringValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Money.stringValue()"})
  public void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("10 USD", Money.ZERO.stringValue());
  }
}
