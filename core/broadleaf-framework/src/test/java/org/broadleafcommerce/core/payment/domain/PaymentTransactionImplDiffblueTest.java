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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.junit.Test;
import org.mockito.Mockito;

public class PaymentTransactionImplDiffblueTest {
  /**
   * Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  public void testGetOrderPayment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();

    // Act and Assert
    assertNull(paymentTransactionImpl.getOrderPayment());
    assertNull(paymentTransactionImpl.orderPayment);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  public void testGetOrderPayment2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setOrderPayment(null);
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());

    // Act and Assert
    assertNull(paymentTransactionImpl.getOrderPayment());
    assertNull(paymentTransactionImpl.orderPayment);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  public void testGetOrderPayment3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    paymentTransactionImpl.setOrderPayment(orderPayment);
    paymentTransactionImpl.setParentTransaction(null);

    // Act
    OrderPayment actualOrderPayment = paymentTransactionImpl.getOrderPayment();

    // Assert
    OrderPayment orderPayment2 = paymentTransactionImpl.orderPayment;
    assertTrue(orderPayment2 instanceof OrderPaymentImpl);
    assertSame(orderPayment, actualOrderPayment);
    assertSame(((OrderPaymentImpl) actualOrderPayment).archiveStatus, ((OrderPaymentImpl) orderPayment2).archiveStatus);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  public void testGetOrderPayment4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));

    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(amount);
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setOrderPayment(null);
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());

    // Act
    OrderPayment actualOrderPayment = paymentTransactionImpl.getOrderPayment();

    // Assert
    verify(amount).getAmount();
    assertNull(actualOrderPayment);
    assertNull(paymentTransactionImpl.orderPayment);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  public void testGetOrderPayment5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));
    PaymentTransaction parentTransaction = mock(PaymentTransaction.class);
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(parentTransaction.getOrderPayment()).thenReturn(orderPaymentImpl);

    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(amount);
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setOrderPayment(null);
    paymentTransactionImpl.setParentTransaction(parentTransaction);

    // Act
    OrderPayment actualOrderPayment = paymentTransactionImpl.getOrderPayment();

    // Assert
    verify(amount).getAmount();
    verify(parentTransaction).getOrderPayment();
    assertNull(paymentTransactionImpl.orderPayment);
    assertSame(orderPaymentImpl, actualOrderPayment);
  }

  /**
   * Method under test:
   * {@link PaymentTransactionImpl#setType(PaymentTransactionType)}
   */
  @Test
  public void testSetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();

    // Act
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals("Type", paymentTransactionImpl.getType().getType());
    assertEquals("Type", paymentTransactionImpl.type);
    assertNull(paymentTransactionImpl.getParentTransaction());
  }

  /**
   * Method under test:
   * {@link PaymentTransactionImpl#setType(PaymentTransactionType)}
   */
  @Test
  public void testSetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    PaymentTransactionType type = mock(PaymentTransactionType.class);
    when(type.getType()).thenReturn("Type");

    // Act
    paymentTransactionImpl.setType(type);

    // Assert
    verify(type).getType();
    assertEquals("Type", paymentTransactionImpl.getType().getType());
    assertEquals("Type", paymentTransactionImpl.type);
    assertNull(paymentTransactionImpl.getParentTransaction());
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  public void testGetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setAmount(null);
    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    paymentTransactionImpl.setOrderPayment(orderPayment);
    paymentTransactionImpl.setParentTransaction(null);

    // Act
    Money actualAmount = paymentTransactionImpl.getAmount();

    // Assert
    OrderPayment orderPayment2 = paymentTransactionImpl.orderPayment;
    assertTrue(orderPayment2 instanceof OrderPaymentImpl);
    assertEquals(actualAmount.ZERO, actualAmount);
    assertSame(orderPayment.archiveStatus, ((OrderPaymentImpl) orderPayment2).archiveStatus);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  public void testGetAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    Money amount = new Money();
    paymentTransactionImpl.setAmount(amount);
    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    paymentTransactionImpl.setOrderPayment(orderPayment);
    paymentTransactionImpl.setParentTransaction(null);

    // Act and Assert
    OrderPayment orderPayment2 = paymentTransactionImpl.orderPayment;
    assertTrue(orderPayment2 instanceof OrderPaymentImpl);
    assertEquals(amount, paymentTransactionImpl.getAmount());
    assertSame(orderPayment.archiveStatus, ((OrderPaymentImpl) orderPayment2).archiveStatus);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  public void testGetAmount3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransaction parentTransaction = mock(PaymentTransaction.class);
    when(parentTransaction.getOrderPayment()).thenReturn(new OrderPaymentImpl());

    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setAmount(null);
    paymentTransactionImpl.setOrderPayment(null);
    paymentTransactionImpl.setParentTransaction(parentTransaction);

    // Act
    Money actualAmount = paymentTransactionImpl.getAmount();

    // Assert
    verify(parentTransaction).getOrderPayment();
    assertNull(paymentTransactionImpl.orderPayment);
    assertEquals(actualAmount.ZERO, actualAmount);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  public void testGetAmount4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getCurrency()).thenReturn(broadleafCurrencyImpl);

    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setAmount(null);
    paymentTransactionImpl.setOrderPayment(orderPayment);
    paymentTransactionImpl.setParentTransaction(mock(PaymentTransaction.class));

    // Act
    Money actualAmount = paymentTransactionImpl.getAmount();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(orderPayment).getCurrency();
    Currency currency = actualAmount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualAmount.getAmount());
    assertEquals(actualAmount, actualAmount.abs());
    assertEquals(actualAmount, actualAmount.zero());
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    Money amount = new Money();

    // Act
    paymentTransactionImpl.setAmount(amount);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount2 = amount.getAmount();
    assertEquals(expectedAmount, amount2);
    assertEquals(new BigDecimal("0.00"), paymentTransactionImpl.amount);
    assertEquals(amount, amount.abs());
    assertEquals(amount, amount.zero());
    assertSame(paymentTransactionImpl.amount, amount2);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));

    // Act
    paymentTransactionImpl.setAmount(null);

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), paymentTransactionImpl.amount);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    paymentTransactionImpl.setAmount(amount);

    // Assert
    verify(amount).getAmount();
    assertEquals(new BigDecimal("2.3"), paymentTransactionImpl.amount);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#isSaveToken()}
   */
  @Test
  public void testIsSaveToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentTransactionImpl()).isSaveToken());
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#isSaveToken()}
   */
  @Test
  public void testIsSaveToken2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setSaveToken(true);

    // Act and Assert
    assertTrue(paymentTransactionImpl.isSaveToken());
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#isSaveToken()}
   */
  @Test
  public void testIsSaveToken3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));

    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(amount);
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setSaveToken(true);

    // Act
    boolean actualIsSaveTokenResult = paymentTransactionImpl.isSaveToken();

    // Assert
    verify(amount).getAmount();
    assertTrue(actualIsSaveTokenResult);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#setSaveToken(boolean)}
   */
  @Test
  public void testSetSaveToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();

    // Act
    paymentTransactionImpl.setSaveToken(true);

    // Assert
    assertTrue(paymentTransactionImpl.saveToken);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#setSaveToken(boolean)}
   */
  @Test
  public void testSetSaveToken2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setOrderPayment(mock(OrderPaymentImpl.class));

    // Act
    paymentTransactionImpl.setSaveToken(true);

    // Assert
    assertTrue(paymentTransactionImpl.saveToken);
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new PaymentTransactionImpl()).getArchived().charValue());
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#getArchived()}
   */
  @Test
  public void testGetArchived2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setOrderPayment(mock(OrderPaymentImpl.class));

    // Act and Assert
    assertEquals('N', paymentTransactionImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();

    // Act
    paymentTransactionImpl.setArchived('A');

    // Assert
    assertEquals('A', paymentTransactionImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', paymentTransactionImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setOrderPayment(mock(OrderPaymentImpl.class));

    // Act
    paymentTransactionImpl.setArchived('A');

    // Assert
    assertEquals('A', paymentTransactionImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', paymentTransactionImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PaymentTransactionImpl()).isActive());
  }

  /**
   * Method under test: {@link PaymentTransactionImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setArchived('Y');

    // Act and Assert
    assertFalse(paymentTransactionImpl.isActive());
  }

  /**
   * Method under test:
   * {@link PaymentTransactionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PaymentTransaction> actualCreateOrRetrieveCopyInstanceResult = paymentTransactionImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentTransactionImpl#setAdditionalFields(Map)}
   *   <li>{@link PaymentTransactionImpl#setCustomerIpAddress(String)}
   *   <li>{@link PaymentTransactionImpl#setDate(Date)}
   *   <li>{@link PaymentTransactionImpl#setId(Long)}
   *   <li>{@link PaymentTransactionImpl#setOrderPayment(OrderPayment)}
   *   <li>{@link PaymentTransactionImpl#setParentTransaction(PaymentTransaction)}
   *   <li>{@link PaymentTransactionImpl#setRawResponse(String)}
   *   <li>{@link PaymentTransactionImpl#setSuccess(Boolean)}
   *   <li>{@link PaymentTransactionImpl#getAdditionalFields()}
   *   <li>{@link PaymentTransactionImpl#getCustomerIpAddress()}
   *   <li>{@link PaymentTransactionImpl#getDate()}
   *   <li>{@link PaymentTransactionImpl#getId()}
   *   <li>{@link PaymentTransactionImpl#getParentTransaction()}
   *   <li>{@link PaymentTransactionImpl#getRawResponse()}
   *   <li>{@link PaymentTransactionImpl#getSuccess()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    HashMap<String, String> additionalFields = new HashMap<>();

    // Act
    paymentTransactionImpl.setAdditionalFields(additionalFields);
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    paymentTransactionImpl.setDate(date);
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    PaymentTransactionImpl parentTransaction = new PaymentTransactionImpl();
    paymentTransactionImpl.setParentTransaction(parentTransaction);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSuccess(true);
    Map<String, String> actualAdditionalFields = paymentTransactionImpl.getAdditionalFields();
    String actualCustomerIpAddress = paymentTransactionImpl.getCustomerIpAddress();
    Date actualDate = paymentTransactionImpl.getDate();
    Long actualId = paymentTransactionImpl.getId();
    PaymentTransaction actualParentTransaction = paymentTransactionImpl.getParentTransaction();
    String actualRawResponse = paymentTransactionImpl.getRawResponse();
    Boolean actualSuccess = paymentTransactionImpl.getSuccess();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualCustomerIpAddress);
    assertEquals("Raw Response", actualRawResponse);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalFields.isEmpty());
    assertTrue(actualSuccess);
    assertSame(additionalFields, actualAdditionalFields);
    assertSame(parentTransaction, actualParentTransaction);
    assertSame(date, actualDate);
  }
}
