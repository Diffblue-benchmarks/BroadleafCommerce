package org.broadleafcommerce.common.currency.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.BankersRounding;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafCurrencyUtilsDiffblueTest {
  /**
   * Test {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)} with {@code
   * amount}, {@code currency}.
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getMoney(BigDecimal, BroadleafCurrency)"})
  public void testGetMoneyWithAmountCurrency() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney(BankersRounding.ZERO, currency);

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualMoney.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)} with {@code
   * amount}, {@code currency}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getMoney(BigDecimal, BroadleafCurrency)"})
  public void testGetMoneyWithAmountCurrency_whenNull_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange and Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney(BankersRounding.ZERO, null);

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
   * Test {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)} with {@code
   * amount}, {@code currency}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getMoney(BigDecimal, BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getMoney(BigDecimal, BroadleafCurrency)"})
  public void testGetMoneyWithAmountCurrency_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BroadleafCurrencyUtils.getMoney(null, new BroadleafCurrencyImpl()));
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getMoney(BigDecimal)} with {@code amount}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getMoney(BigDecimal)"})
  public void testGetMoneyWithAmount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BroadleafCurrencyUtils.getMoney((BigDecimal) null));
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getMoney(BigDecimal)} with {@code amount}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getMoney(BigDecimal)"})
  public void testGetMoneyWithAmount_whenZero_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange and Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney(BankersRounding.ZERO);

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
   * Test {@link BroadleafCurrencyUtils#getMoney(BroadleafCurrency)} with {@code currency}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getMoney(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getMoney(BroadleafCurrency)"})
  public void testGetMoneyWithCurrency_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney(currency);

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualMoney.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualMoney.abs();
    assertEquals(actualMoney, actualAbsResult);
    Money actualZeroResult = actualMoney.zero();
    assertEquals(actualMoney, actualZeroResult);
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getMoney(BroadleafCurrency)} with {@code currency}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getMoney(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getMoney(BroadleafCurrency)"})
  public void testGetMoneyWithCurrency_whenNull_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange and Act
    Money actualMoney = BroadleafCurrencyUtils.getMoney((BroadleafCurrency) null);

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
   * Test {@link BroadleafCurrencyUtils#getCurrency(BroadleafCurrency)} with {@code currency}.
   *
   * <ul>
   *   <li>Given {@code GBP}.
   *   <li>Then return DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getCurrency(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency BroadleafCurrencyUtils.getCurrency(BroadleafCurrency)"})
  public void testGetCurrencyWithCurrency_givenGbp_thenReturnDisplayNameIsBritishPoundSterling() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Currency actualCurrency = BroadleafCurrencyUtils.getCurrency(currency);

    // Assert
    verify(currency).getCurrencyCode();
    assertEquals("British Pound Sterling", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.getSymbol());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getCurrency(BroadleafCurrency)} with {@code currency}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getCurrency(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency BroadleafCurrencyUtils.getCurrency(BroadleafCurrency)"})
  public void testGetCurrencyWithCurrency_whenNull_thenReturnDisplayNameIsUsDollar() {
    // Arrange and Act
    Currency actualCurrency = BroadleafCurrencyUtils.getCurrency((BroadleafCurrency) null);

    // Assert
    assertEquals("US Dollar", actualCurrency.getDisplayName());
    assertEquals("USD", actualCurrency.getCurrencyCode());
    assertEquals("USD", actualCurrency.getSymbol());
    assertEquals("USD", actualCurrency.toString());
    assertEquals(840, actualCurrency.getNumericCode());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getCurrency(Money)} with {@code money}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getCurrency(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency BroadleafCurrencyUtils.getCurrency(Money)"})
  public void testGetCurrencyWithMoney_whenNull() {
    // Arrange and Act
    Currency actualCurrency = BroadleafCurrencyUtils.getCurrency((Money) null);

    // Assert
    assertEquals("US Dollar", actualCurrency.getDisplayName());
    assertEquals("USD", actualCurrency.getCurrencyCode());
    assertEquals("USD", actualCurrency.getSymbol());
    assertEquals("USD", actualCurrency.toString());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(840, actualCurrency.getNumericCode());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getCurrency(Money)} with {@code money}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getCurrency(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency BroadleafCurrencyUtils.getCurrency(Money)"})
  public void testGetCurrencyWithMoney_whenZero() {
    // Arrange and Act
    Currency actualCurrency = BroadleafCurrencyUtils.getCurrency(Money.ZERO);

    // Assert
    assertEquals("US Dollar", actualCurrency.getDisplayName());
    assertEquals("USD", actualCurrency.getCurrencyCode());
    assertEquals("USD", actualCurrency.getSymbol());
    assertEquals("USD", actualCurrency.toString());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(840, actualCurrency.getNumericCode());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getUnitAmount(BroadleafCurrency)} with {@code blCurrency}.
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getUnitAmount(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getUnitAmount(BroadleafCurrency)"})
  public void testGetUnitAmountWithBlCurrency() {
    // Arrange
    BroadleafCurrency blCurrency = mock(BroadleafCurrency.class);
    when(blCurrency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Money actualUnitAmount = BroadleafCurrencyUtils.getUnitAmount(blCurrency);

    // Assert
    verify(blCurrency).getCurrencyCode();
    Currency currency = actualUnitAmount.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(826, currency.getNumericCode());
    Money zeroResult = actualUnitAmount.zero();
    assertEquals(zeroResult.zero(), zeroResult.zero());
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
    assertEquals(actualUnitAmount, actualUnitAmount.abs().abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getUnitAmount(BroadleafCurrency)} with {@code blCurrency}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getUnitAmount(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getUnitAmount(BroadleafCurrency)"})
  public void testGetUnitAmountWithBlCurrency_whenNull_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange and Act
    Money actualUnitAmount = BroadleafCurrencyUtils.getUnitAmount((BroadleafCurrency) null);

    // Assert
    Currency currency = actualUnitAmount.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    Money actualAbsResult = actualUnitAmount.abs();
    assertEquals(actualUnitAmount, actualAbsResult);
    assertEquals(Money.ZERO, actualUnitAmount.zero());
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getUnitAmount(Money)} with {@code difference}.
   *
   * <ul>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code -0.01}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getUnitAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getUnitAmount(Money)"})
  public void testGetUnitAmountWithDifference_thenReturnAmountIsBigDecimalWith001() {
    // Arrange and Act
    Money actualUnitAmount = BroadleafCurrencyUtils.getUnitAmount(new Money(-0.5d));

    // Assert
    assertEquals(new BigDecimal("-0.01"), actualUnitAmount.getAmount());
    BigDecimal expectedAmount = new BigDecimal("0.01");
    Money absResult = actualUnitAmount.abs();
    assertEquals(expectedAmount, absResult.getAmount());
    assertEquals(absResult.abs(), absResult.abs());
    Money zeroResult = actualUnitAmount.zero();
    BigDecimal amount = zeroResult.zero().getAmount();
    assertSame(amount, zeroResult.abs().getAmount());
    assertSame(amount, absResult.zero().getAmount());
    assertSame(amount, amount);
  }

  /**
   * Test {@link BroadleafCurrencyUtils#getUnitAmount(Money)} with {@code difference}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.01}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#getUnitAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BroadleafCurrencyUtils.getUnitAmount(Money)"})
  public void testGetUnitAmountWithDifference_whenZero_thenReturnAmountIsBigDecimalWith001() {
    // Arrange and Act
    Money actualUnitAmount = BroadleafCurrencyUtils.getUnitAmount(Money.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.01"), actualUnitAmount.getAmount());
    Money actualAbsResult = actualUnitAmount.abs();
    assertEquals(actualUnitAmount, actualAbsResult);
    Money zeroResult = actualUnitAmount.zero();
    BigDecimal amount = zeroResult.zero().getAmount();
    assertSame(amount, zeroResult.abs().getAmount());
    assertSame(amount, amount);
  }

  /**
   * Test {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}.
   *
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BroadleafCurrencyUtils.calculateRemainder(Money, int)"})
  public void testCalculateRemainder_whenMoneyWithAmountIsTen() {
    // Arrange, Act and Assert
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(new Money(10.0d), 1));
  }

  /**
   * Test {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}.
   *
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BroadleafCurrencyUtils.calculateRemainder(Money, int)"})
  public void testCalculateRemainder_whenMoneyWithAmountIsTen2() {
    // Arrange, Act and Assert
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(new Money(10.0d), 0));
  }

  /**
   * Test {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BroadleafCurrencyUtils.calculateRemainder(Money, int)"})
  public void testCalculateRemainder_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(null, 0));
  }

  /**
   * Test {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BroadleafCurrencyUtils.calculateRemainder(Money, int)"})
  public void testCalculateRemainder_whenZero() {
    // Arrange, Act and Assert
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(Money.ZERO, 1));
  }
}
