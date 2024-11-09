/*-
 * #%L
 * BroadleafCommerce Framework
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
   * Test {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}
   */
  @Test
  public void testSetTransactionType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    PaymentTransactionType transactionType = new PaymentTransactionType("Type", "Friendly Type");

    // Act
    paymentLogImpl.setTransactionType(transactionType);

    // Assert
    assertEquals("Type", paymentLogImpl.transactionType);
    assertEquals(transactionType, paymentLogImpl.getTransactionType());
  }

  /**
   * Test {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link PaymentLogImpl} (default constructor) TransactionType Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentLogImpl#setTransactionType(PaymentTransactionType)}
   */
  @Test
  public void testSetTransactionType_givenType_thenPaymentLogImplTransactionTypeTypeIsType() {
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
   * Test {@link PaymentLogImpl#setLogType(PaymentLogEventType)}.
   * <p>
   * Method under test: {@link PaymentLogImpl#setLogType(PaymentLogEventType)}
   */
  @Test
  public void testSetLogType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    PaymentLogEventType logType = new PaymentLogEventType("Type", "Friendly Type");

    // Act
    paymentLogImpl.setLogType(logType);

    // Assert
    assertEquals("Type", paymentLogImpl.logType);
    assertEquals(logType, paymentLogImpl.getLogType());
  }

  /**
   * Test {@link PaymentLogImpl#setLogType(PaymentLogEventType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link PaymentLogImpl} (default constructor) LogType Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#setLogType(PaymentLogEventType)}
   */
  @Test
  public void testSetLogType_givenType_thenPaymentLogImplLogTypeTypeIsType() {
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
   * Test {@link PaymentLogImpl#getTransactionSuccess()}.
   * <ul>
   *   <li>Given {@link PaymentLogImpl} (default constructor) AmountPaid is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  public void testGetTransactionSuccess_givenPaymentLogImplAmountPaidIsMoney_thenReturnFalse() {
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
   * Test {@link PaymentLogImpl#getTransactionSuccess()}.
   * <ul>
   *   <li>Given {@link PaymentLogImpl} (default constructor) AmountPaid is
   * {@link Money}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  public void testGetTransactionSuccess_givenPaymentLogImplAmountPaidIsMoney_thenReturnFalse2() {
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
   * Test {@link PaymentLogImpl#getTransactionSuccess()}.
   * <ul>
   *   <li>Given {@link PaymentLogImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  public void testGetTransactionSuccess_givenPaymentLogImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentLogImpl()).getTransactionSuccess());
  }

  /**
   * Test {@link PaymentLogImpl#getTransactionSuccess()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#getTransactionSuccess()}
   */
  @Test
  public void testGetTransactionSuccess_thenReturnTrue() {
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
   * Test {@link PaymentLogImpl#getAmountPaid()}.
   * <ul>
   *   <li>Given {@link PaymentLogImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  public void testGetAmountPaid_givenPaymentLogImplCurrencyIsNull_thenReturnMoney() {
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
   * Test {@link PaymentLogImpl#getAmountPaid()}.
   * <ul>
   *   <li>Given {@link PaymentLogImpl} (default constructor) Customer is
   * {@link Customer}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  public void testGetAmountPaid_givenPaymentLogImplCustomerIsCustomer_thenReturnMoney() {
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
   * Test {@link PaymentLogImpl#getAmountPaid()}.
   * <ul>
   *   <li>Given {@link PaymentLogImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  public void testGetAmountPaid_givenPaymentLogImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PaymentLogImpl()).getAmountPaid());
  }

  /**
   * Test {@link PaymentLogImpl#getAmountPaid()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#getAmountPaid()}
   */
  @Test
  public void testGetAmountPaid_thenCallsGetCurrencyCode() {
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
    Money amountPaid = new Money();
    paymentLogImpl.setAmountPaid(amountPaid);
    paymentLogImpl.setCurrency(currency);

    // Act
    Money actualAmountPaid = paymentLogImpl.getAmountPaid();

    // Assert
    verify(currency).getCurrencyCode();
    assertEquals(amountPaid, actualAmountPaid);
  }

  /**
   * Test {@link PaymentLogImpl#setAmountPaid(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link PaymentLogImpl} (default constructor)
   * {@link PaymentLogImpl#amountPaid} is {@link BigDecimal#BigDecimal(String)}
   * with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#setAmountPaid(Money)}
   */
  @Test
  public void testSetAmountPaid_whenMoney_thenPaymentLogImplAmountPaidIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
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
    Money absResult3 = absResult2.abs();
    assertSame(bigDecimal, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(bigDecimal, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(bigDecimal, absResult5.getAmount());
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = amountPaid.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(bigDecimal, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(bigDecimal, absResult19.abs().getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(bigDecimal, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(bigDecimal, absResult25.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    Money zeroResult60 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link PaymentLogImpl#setAmountPaid(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then {@link PaymentLogImpl} (default constructor)
   * {@link PaymentLogImpl#amountPaid} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#setAmountPaid(Money)}
   */
  @Test
  public void testSetAmountPaid_whenMoney_thenPaymentLogImplAmountPaidIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();

    // Act
    paymentLogImpl.setAmountPaid(mock(Money.class));

    // Assert
    assertNull(paymentLogImpl.amountPaid);
  }

  /**
   * Test {@link PaymentLogImpl#setAmountPaid(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PaymentLogImpl} (default constructor)
   * {@link PaymentLogImpl#amountPaid} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogImpl#setAmountPaid(Money)}
   */
  @Test
  public void testSetAmountPaid_whenNull_thenPaymentLogImplAmountPaidIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();

    // Act
    paymentLogImpl.setAmountPaid(null);

    // Assert
    assertNull(paymentLogImpl.amountPaid);
  }

  /**
   * Test {@link PaymentLogImpl#equals(Object)}, and
   * {@link PaymentLogImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentLogImpl#equals(Object)}, and
   * {@link PaymentLogImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentLogImpl#equals(Object)}, and
   * {@link PaymentLogImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentLogImpl#equals(Object)}, and
   * {@link PaymentLogImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentLogImpl#equals(Object)}, and
   * {@link PaymentLogImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentLogImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentLogImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentLogImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test getters and setters.
   * <p>
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
