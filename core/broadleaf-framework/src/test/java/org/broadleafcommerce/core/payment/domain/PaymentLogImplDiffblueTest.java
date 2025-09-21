/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.payment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Currency;
import java.util.Date;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentLogEventType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentLogImplDiffblueTest {
  @Autowired private PaymentLogImpl paymentLogImpl;

  /**
   * Test {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentLogImpl.setTransactionType(PaymentTransactionType)"})
  public void testSetTransactionType() {
    // Arrange
    PaymentTransactionType transactionType = new PaymentTransactionType("Type", "Friendly Type");

    // Act
    paymentLogImpl.setTransactionType(transactionType);

    // Assert
    assertEquals("Type", paymentLogImpl.transactionType);
    assertEquals(transactionType, paymentLogImpl.getTransactionType());
  }

  /**
   * Test {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then {@link PaymentLogImpl} TransactionType Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentLogImpl.setTransactionType(PaymentTransactionType)"})
  public void testSetTransactionType_givenType_thenPaymentLogImplTransactionTypeTypeIsType() {
    // Arrange
    PaymentTransactionType transactionType = mock(PaymentTransactionType.class);
    when(transactionType.getType()).thenReturn("Type");

    // Act
    paymentLogImpl.setTransactionType(transactionType);

    // Assert
    verify(transactionType).getType();
    assertEquals("Type", paymentLogImpl.getTransactionType().getType());
    assertEquals("Type", paymentLogImpl.transactionType);
  }

  /**
   * Test {@link PaymentLogImpl#getLogType()}.
   *
   * <p>Method under test: {@link PaymentLogImpl#getLogType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentLogEventType PaymentLogImpl.getLogType()"})
  public void testGetLogType() {
    // Arrange, Act and Assert
    assertNull(paymentLogImpl.getLogType());
  }

  /**
   * Test {@link PaymentLogImpl#setLogType(PaymentLogEventType)}.
   *
   * <p>Method under test: {@link PaymentLogImpl#setLogType(PaymentLogEventType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentLogImpl.setLogType(PaymentLogEventType)"})
  public void testSetLogType() {
    // Arrange
    PaymentLogEventType logType = new PaymentLogEventType("Type", "Friendly Type");

    // Act
    paymentLogImpl.setLogType(logType);

    // Assert
    assertEquals("Type", paymentLogImpl.logType);
    assertEquals(logType, paymentLogImpl.getLogType());
  }

  /**
   * Test {@link PaymentLogImpl#setLogType(PaymentLogEventType)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then {@link PaymentLogImpl} LogType Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#setLogType(PaymentLogEventType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentLogImpl.setLogType(PaymentLogEventType)"})
  public void testSetLogType_givenType_thenPaymentLogImplLogTypeTypeIsType() {
    // Arrange
    PaymentLogEventType logType = mock(PaymentLogEventType.class);
    when(logType.getType()).thenReturn("Type");

    // Act
    paymentLogImpl.setLogType(logType);

    // Assert
    verify(logType).getType();
    assertEquals("Type", paymentLogImpl.getLogType().getType());
    assertEquals("Type", paymentLogImpl.logType);
  }

  /**
   * Test {@link PaymentLogImpl#getTransactionSuccess()}.
   *
   * <ul>
   *   <li>Given {@link PaymentLogImpl} TransactionSuccess is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean PaymentLogImpl.getTransactionSuccess()"})
  public void testGetTransactionSuccess_givenPaymentLogImplTransactionSuccessIsNull() {
    // Arrange
    paymentLogImpl.setTransactionSuccess(null);

    // Act and Assert
    assertFalse(paymentLogImpl.getTransactionSuccess());
  }

  /**
   * Test {@link PaymentLogImpl#getTransactionSuccess()}.
   *
   * <ul>
   *   <li>Given {@link PaymentLogImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean PaymentLogImpl.getTransactionSuccess()"})
  public void testGetTransactionSuccess_givenPaymentLogImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(paymentLogImpl.getTransactionSuccess());
  }

  /**
   * Test {@link PaymentLogImpl#getTransactionSuccess()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean PaymentLogImpl.getTransactionSuccess()"})
  public void testGetTransactionSuccess_thenReturnTrue() {
    // Arrange
    paymentLogImpl.setTransactionSuccess(true);

    // Act and Assert
    assertTrue(paymentLogImpl.getTransactionSuccess());
  }

  /**
   * Test {@link PaymentLogImpl#getAmountPaid()}.
   *
   * <ul>
   *   <li>Given {@link PaymentLogImpl} Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money PaymentLogImpl.getAmountPaid()"})
  public void testGetAmountPaid_givenPaymentLogImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Money amountPaid = new Money();
    paymentLogImpl.setAmountPaid(amountPaid);
    paymentLogImpl.setCurrency(null);

    // Act and Assert
    assertEquals(amountPaid, paymentLogImpl.getAmountPaid());
  }

  /**
   * Test {@link PaymentLogImpl#getAmountPaid()}.
   *
   * <ul>
   *   <li>Given {@link PaymentLogImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money PaymentLogImpl.getAmountPaid()"})
  public void testGetAmountPaid_givenPaymentLogImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(paymentLogImpl.getAmountPaid());
  }

  /**
   * Test {@link PaymentLogImpl#getAmountPaid()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money PaymentLogImpl.getAmountPaid()"})
  public void testGetAmountPaid_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(currency);

    // Act
    Money actualAmountPaid = paymentLogImpl.getAmountPaid();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualAmountPaid.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualAmountPaid.abs();
    assertEquals(actualAmountPaid, actualAbsResult);
    Money actualZeroResult = actualAmountPaid.zero();
    assertEquals(actualAmountPaid, actualZeroResult);
  }

  /**
   * Test {@link PaymentLogImpl#setAmountPaid(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link PaymentLogImpl} {@link PaymentLogImpl#amountPaid} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#setAmountPaid(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentLogImpl.setAmountPaid(Money)"})
  public void testSetAmountPaid_whenMoney_thenPaymentLogImplAmountPaidIsBigDecimalWith000() {
    // Arrange
    Money amountPaid = new Money();

    // Act
    paymentLogImpl.setAmountPaid(amountPaid);

    // Assert
    assertEquals(new BigDecimal("0.00"), paymentLogImpl.amountPaid);
    BigDecimal bigDecimal = paymentLogImpl.amountPaid;
    Money absResult = amountPaid.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = amountPaid.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link PaymentLogImpl#setAmountPaid(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PaymentLogImpl} {@link PaymentLogImpl#amountPaid} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#setAmountPaid(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentLogImpl.setAmountPaid(Money)"})
  public void testSetAmountPaid_whenNull_thenPaymentLogImplAmountPaidIsNull() {
    // Arrange and Act
    paymentLogImpl.setAmountPaid(null);

    // Assert that nothing has changed
    assertNull(paymentLogImpl.amountPaid);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and {@link PaymentLogImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    assertEquals(paymentLogImpl.hashCode(), paymentLogImpl2.hashCode());
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and {@link PaymentLogImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    assertEquals(paymentLogImpl.hashCode(), paymentLogImpl2.hashCode());
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and {@link PaymentLogImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(null);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    assertEquals(paymentLogImpl.hashCode(), paymentLogImpl2.hashCode());
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and {@link PaymentLogImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(null);
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(null);
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    assertEquals(paymentLogImpl.hashCode(), paymentLogImpl2.hashCode());
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and {@link PaymentLogImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(null);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(null);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    assertEquals(paymentLogImpl.hashCode(), paymentLogImpl2.hashCode());
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and {@link PaymentLogImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber(null);
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber(null);
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    assertEquals(paymentLogImpl.hashCode(), paymentLogImpl2.hashCode());
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and {@link PaymentLogImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(null);
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(null);
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    assertEquals(paymentLogImpl.hashCode(), paymentLogImpl2.hashCode());
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and {@link PaymentLogImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName(null);

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName(null);

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    assertEquals(paymentLogImpl.hashCode(), paymentLogImpl2.hashCode());
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and {@link PaymentLogImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl);
    int expectedHashCodeResult = paymentLogImpl.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogImpl.hashCode());
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(2L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(null);
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(mock(CustomerImpl.class));
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(2L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(null);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("janedoe");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber(null);
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(new Date());
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(null);
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("42");

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(null);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName(null);

    PaymentLogImpl paymentLogImpl2 = new PaymentLogImpl();
    paymentLogImpl2.setAmountPaid(new Money());
    paymentLogImpl2.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl2.setCustomer(new CustomerImpl());
    paymentLogImpl2.setExceptionMessage("An error occurred");
    paymentLogImpl2.setId(1L);
    paymentLogImpl2.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl2.setPaymentInfoId(1L);
    paymentLogImpl2.setPaymentInfoReferenceNumber("42");
    paymentLogImpl2.setTransactionSuccess(true);
    paymentLogImpl2.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, null);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentLogImpl.equals(Object)", "int PaymentLogImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(new Money());
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl.setTransactionTimestamp(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, "Different type to PaymentLogImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PaymentLogImpl}
   *   <li>{@link PaymentLogImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link PaymentLogImpl#setCustomer(Customer)}
   *   <li>{@link PaymentLogImpl#setExceptionMessage(String)}
   *   <li>{@link PaymentLogImpl#setId(Long)}
   *   <li>{@link PaymentLogImpl#setPaymentInfoId(Long)}
   *   <li>{@link PaymentLogImpl#setPaymentInfoReferenceNumber(String)}
   *   <li>{@link PaymentLogImpl#setTransactionSuccess(Boolean)}
   *   <li>{@link PaymentLogImpl#setTransactionTimestamp(Date)}
   *   <li>{@link PaymentLogImpl#setUserName(String)}
   *   <li>{@link PaymentLogImpl#getCurrency()}
   *   <li>{@link PaymentLogImpl#getCustomer()}
   *   <li>{@link PaymentLogImpl#getExceptionMessage()}
   *   <li>{@link PaymentLogImpl#getId()}
   *   <li>{@link PaymentLogImpl#getPaymentInfoId()}
   *   <li>{@link PaymentLogImpl#getPaymentInfoReferenceNumber()}
   *   <li>{@link PaymentLogImpl#getTransactionTimestamp()}
   *   <li>{@link PaymentLogImpl#getUserName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentLogImpl.<init>()",
    "BroadleafCurrency PaymentLogImpl.getCurrency()",
    "Customer PaymentLogImpl.getCustomer()",
    "String PaymentLogImpl.getExceptionMessage()",
    "Long PaymentLogImpl.getId()",
    "Long PaymentLogImpl.getPaymentInfoId()",
    "String PaymentLogImpl.getPaymentInfoReferenceNumber()",
    "Date PaymentLogImpl.getTransactionTimestamp()",
    "String PaymentLogImpl.getUserName()",
    "void PaymentLogImpl.setCurrency(BroadleafCurrency)",
    "void PaymentLogImpl.setCustomer(Customer)",
    "void PaymentLogImpl.setExceptionMessage(String)",
    "void PaymentLogImpl.setId(Long)",
    "void PaymentLogImpl.setPaymentInfoId(Long)",
    "void PaymentLogImpl.setPaymentInfoReferenceNumber(String)",
    "void PaymentLogImpl.setTransactionSuccess(Boolean)",
    "void PaymentLogImpl.setTransactionTimestamp(Date)",
    "void PaymentLogImpl.setUserName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentLogImpl actualPaymentLogImpl = new PaymentLogImpl();
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    actualPaymentLogImpl.setCurrency(currency);
    CustomerImpl customer = new CustomerImpl();
    actualPaymentLogImpl.setCustomer(customer);
    actualPaymentLogImpl.setExceptionMessage("An error occurred");
    actualPaymentLogImpl.setId(1L);
    actualPaymentLogImpl.setPaymentInfoId(1L);
    actualPaymentLogImpl.setPaymentInfoReferenceNumber("42");
    actualPaymentLogImpl.setTransactionSuccess(true);
    Date transactionTimestamp =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualPaymentLogImpl.setTransactionTimestamp(transactionTimestamp);
    actualPaymentLogImpl.setUserName("janedoe");
    BroadleafCurrency actualCurrency = actualPaymentLogImpl.getCurrency();
    Customer actualCustomer = actualPaymentLogImpl.getCustomer();
    String actualExceptionMessage = actualPaymentLogImpl.getExceptionMessage();
    Long actualId = actualPaymentLogImpl.getId();
    Long actualPaymentInfoId = actualPaymentLogImpl.getPaymentInfoId();
    String actualPaymentInfoReferenceNumber = actualPaymentLogImpl.getPaymentInfoReferenceNumber();
    Date actualTransactionTimestamp = actualPaymentLogImpl.getTransactionTimestamp();

    // Assert
    assertEquals("42", actualPaymentInfoReferenceNumber);
    assertEquals("An error occurred", actualExceptionMessage);
    assertEquals("janedoe", actualPaymentLogImpl.getUserName());
    assertEquals(1L, actualId.longValue());
    assertEquals(1L, actualPaymentInfoId.longValue());
    assertSame(currency, actualCurrency);
    assertSame(customer, actualCustomer);
    assertSame(transactionTimestamp, actualTransactionTimestamp);
  }
}
