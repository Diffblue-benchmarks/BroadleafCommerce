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

public class PaymentLogImplDiffblueTest {
  /**
   * Method under test:
   * {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}
   */
  @Test
  public void testSetTransactionType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();

    // Act
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals("Type", paymentLogImpl.getTransactionType().getType());
    assertEquals("Type", paymentLogImpl.transactionType);
  }

  /**
   * Method under test:
   * {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}
   */
  @Test
  public void testSetTransactionType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
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
   * Method under test: {@link PaymentLogImpl#setLogType(PaymentLogEventType)}
   */
  @Test
  public void testSetLogType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();

    // Act
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));

    // Assert
    assertEquals("Type", paymentLogImpl.getLogType().getType());
    assertEquals("Type", paymentLogImpl.logType);
  }

  /**
   * Method under test: {@link PaymentLogImpl#setLogType(PaymentLogEventType)}
   */
  @Test
  public void testSetLogType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
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
   * Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  public void testGetTransactionSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentLogImpl()).getTransactionSuccess());
  }

  /**
   * Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  public void testGetTransactionSuccess2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");
    paymentLogImpl.setTransactionSuccess(null);

    // Act and Assert
    assertFalse(paymentLogImpl.getTransactionSuccess());
  }

  /**
   * Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  public void testGetTransactionSuccess3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");
    paymentLogImpl.setTransactionSuccess(true);

    // Act and Assert
    assertTrue(paymentLogImpl.getTransactionSuccess());
  }

  /**
   * Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  public void testGetTransactionSuccess4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(mock(Money.class));
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");
    paymentLogImpl.setTransactionSuccess(null);

    // Act and Assert
    assertFalse(paymentLogImpl.getTransactionSuccess());
  }

  /**
   * Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  public void testGetAmountPaid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PaymentLogImpl()).getAmountPaid());
  }

  /**
   * Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  public void testGetAmountPaid2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");
    Money amountPaid = new Money();
    paymentLogImpl.setAmountPaid(amountPaid);
    paymentLogImpl.setCurrency(null);

    // Act and Assert
    assertEquals(amountPaid, paymentLogImpl.getAmountPaid());
  }

  /**
   * Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  public void testGetAmountPaid3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setCustomer(mock(Customer.class));
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");
    Money amountPaid = new Money();
    paymentLogImpl.setAmountPaid(amountPaid);
    paymentLogImpl.setCurrency(null);

    // Act and Assert
    assertEquals(amountPaid, paymentLogImpl.getAmountPaid());
  }

  /**
   * Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  public void testGetAmountPaid4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");
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
    assertEquals(2, currency2.getDefaultFractionDigits());
    assertEquals(826, currency2.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = actualAmountPaid.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(actualAmountPaid, actualAmountPaid.abs());
    assertEquals(actualAmountPaid, actualAmountPaid.zero());
    assertSame(paymentLogImpl.amountPaid, amount);
  }

  /**
   * Method under test: {@link PaymentLogImpl#setAmountPaid(Money)}
   */
  @Test
  public void testSetAmountPaid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    Money amountPaid = new Money();

    // Act
    paymentLogImpl.setAmountPaid(amountPaid);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = amountPaid.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), paymentLogImpl.amountPaid);
    assertEquals(amountPaid, amountPaid.abs());
    assertEquals(amountPaid, amountPaid.zero());
    assertSame(paymentLogImpl.amountPaid, amount);
  }

  /**
   * Method under test: {@link PaymentLogImpl#setAmountPaid(Money)}
   */
  @Test
  public void testSetAmountPaid2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();

    // Act
    paymentLogImpl.setAmountPaid(null);

    // Assert
    assertNull(paymentLogImpl.amountPaid);
  }

  /**
   * Method under test: {@link PaymentLogImpl#setAmountPaid(Money)}
   */
  @Test
  public void testSetAmountPaid3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();

    // Act
    paymentLogImpl.setAmountPaid(mock(Money.class));

    // Assert
    assertNull(paymentLogImpl.amountPaid);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
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
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    paymentLogImpl2
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    int expectedHashCodeResult = paymentLogImpl.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    paymentLogImpl.setAmountPaid(mock(Money.class));
    paymentLogImpl.setCurrency(new BroadleafCurrencyImpl());
    paymentLogImpl.setCustomer(new CustomerImpl());
    paymentLogImpl.setExceptionMessage("An error occurred");
    paymentLogImpl.setId(1L);
    paymentLogImpl.setLogType(new PaymentLogEventType("Type", "Friendly Type"));
    paymentLogImpl.setPaymentInfoId(1L);
    paymentLogImpl.setPaymentInfoReferenceNumber("42");
    paymentLogImpl.setTransactionSuccess(true);
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    paymentLogImpl2
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    int expectedHashCodeResult = paymentLogImpl.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    paymentLogImpl2
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    int expectedHashCodeResult = paymentLogImpl.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    paymentLogImpl2
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl2);
    int expectedHashCodeResult = paymentLogImpl.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogImpl#equals(Object)}
   *   <li>{@link PaymentLogImpl#hashCode()}
   * </ul>
   */
  @Test
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
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    // Act and Assert
    assertEquals(paymentLogImpl, paymentLogImpl);
    int expectedHashCodeResult = paymentLogImpl.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogImpl.hashCode());
  }

  /**
   * Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
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
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    paymentLogImpl2
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl2.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, paymentLogImpl2);
  }

  /**
   * Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
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
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, null);
  }

  /**
   * Method under test: {@link PaymentLogImpl#equals(Object)}
   */
  @Test
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
    paymentLogImpl
        .setTransactionTimestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentLogImpl.setTransactionType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentLogImpl.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(paymentLogImpl, "Different type to PaymentLogImpl");
  }

  /**
   * Methods under test:
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
    Date transactionTimestamp = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualPaymentLogImpl.setTransactionTimestamp(transactionTimestamp);
    actualPaymentLogImpl.setUserName("janedoe");
    BroadleafCurrency actualCurrency = actualPaymentLogImpl.getCurrency();
    Customer actualCustomer = actualPaymentLogImpl.getCustomer();
    String actualExceptionMessage = actualPaymentLogImpl.getExceptionMessage();
    Long actualId = actualPaymentLogImpl.getId();
    Long actualPaymentInfoId = actualPaymentLogImpl.getPaymentInfoId();
    String actualPaymentInfoReferenceNumber = actualPaymentLogImpl.getPaymentInfoReferenceNumber();
    Date actualTransactionTimestamp = actualPaymentLogImpl.getTransactionTimestamp();

    // Assert that nothing has changed
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
