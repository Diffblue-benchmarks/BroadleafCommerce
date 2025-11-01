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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OrderPaymentImplDiffblueTest {
  /**
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  public void testGetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getAmount());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  public void testGetAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    Money amount = new Money();
    orderPaymentImpl.setAmount(amount);
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertEquals(amount, orderPaymentImpl.getAmount());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  public void testGetAmount3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));

    // Act and Assert
    assertNull(orderPaymentImpl.getAmount());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  public void testGetAmount4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BroadleafCurrencyImpl currency = mock(BroadleafCurrencyImpl.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualAmount = orderPaymentImpl.getAmount();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualAmount.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(2, currency2.getDefaultFractionDigits());
    assertEquals(826, currency2.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = actualAmount.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(actualAmount, actualAmount.abs());
    assertEquals(actualAmount, actualAmount.zero());
    assertSame(orderPaymentImpl.amount, amount);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    Money amount = new Money();

    // Act
    orderPaymentImpl.setAmount(amount);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount2 = amount.getAmount();
    assertEquals(expectedAmount, amount2);
    assertEquals(new BigDecimal("0.00"), orderPaymentImpl.amount);
    assertEquals(amount, amount.abs());
    assertEquals(amount, amount.zero());
    assertSame(orderPaymentImpl.amount, amount2);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act
    orderPaymentImpl.setAmount(null);

    // Assert
    assertNull(orderPaymentImpl.amount);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act
    orderPaymentImpl.setAmount(mock(Money.class));

    // Assert
    assertNull(orderPaymentImpl.amount);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#setType(PaymentType)}
   */
  @Test
  public void testSetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    // Assert
    assertEquals("Type", orderPaymentImpl.getType().getType());
    assertEquals("Type", orderPaymentImpl.type);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#setType(PaymentType)}
   */
  @Test
  public void testSetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentType type = mock(PaymentType.class);
    when(type.getType()).thenReturn("Type");

    // Act
    orderPaymentImpl.setType(type);

    // Assert
    verify(type).getType();
    assertEquals("Type", orderPaymentImpl.getType().getType());
    assertEquals("Type", orderPaymentImpl.type);
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  public void testSetPaymentGatewayType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));

    // Assert
    assertEquals("Type", orderPaymentImpl.getGatewayType().getType());
    assertEquals("Type", orderPaymentImpl.gatewayType);
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  public void testSetPaymentGatewayType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getType()).thenReturn("Type");

    // Act
    orderPaymentImpl.setPaymentGatewayType(gatewayType);

    // Assert
    verify(gatewayType).getType();
    assertEquals("Type", orderPaymentImpl.getGatewayType().getType());
    assertEquals("Type", orderPaymentImpl.gatewayType);
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}
   */
  @Test
  public void testAddTransaction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentTransactionImpl transaction = new PaymentTransactionImpl();

    // Act
    orderPaymentImpl.addTransaction(transaction);

    // Assert
    List<PaymentTransaction> transactions = orderPaymentImpl.getTransactions();
    assertEquals(1, transactions.size());
    assertSame(transaction, transactions.get(0));
    assertSame(transaction, orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}
   */
  @Test
  public void testAddTransaction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);

    // Act
    orderPaymentImpl.addTransaction(transaction);

    // Assert
    List<PaymentTransaction> transactions = orderPaymentImpl.getTransactions();
    assertEquals(1, transactions.size());
    assertSame(transaction, transactions.get(0));
    assertSame(transaction, orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act and Assert
    assertTrue(orderPaymentImpl.getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type")).isEmpty());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderPaymentImpl()).getTransactionsForType(mock(PaymentTransactionType.class)).isEmpty());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertEquals(1, actualTransactionsForType.size());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("42", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(mock(PaymentTransactionType.class));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl.getTransactionsForType(null);

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  public void testGetInitialTransaction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getInitialTransaction());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  public void testGetInitialTransaction2() {
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
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setParentTransaction(null);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setTransactions(transactions);

    // Act and Assert
    assertSame(paymentTransactionImpl, orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  public void testGetInitialTransaction3() {
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
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setTransactions(transactions);

    // Act and Assert
    assertNull(orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  public void testGetInitialTransaction4() {
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
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setParentTransaction(null);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setTransactions(transactions);

    // Act and Assert
    assertSame(paymentTransactionImpl, orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getAuthorizeTransaction());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());

    // Act and Assert
    assertNull(orderPaymentImpl.getAuthorizeTransaction());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    PaymentTransaction actualAuthorizeTransaction = orderPaymentImpl.getAuthorizeTransaction();

    // Assert
    verify(transaction, atLeast(1)).getType();
    assertNull(actualAuthorizeTransaction);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    orderPaymentImpl.getAuthorizeTransaction();

    // Assert
    verify(transaction).getType();
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    orderPaymentImpl.getAuthorizeTransaction();

    // Assert
    verify(transaction, atLeast(1)).getType();
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualTransactionAmountForType.getAmount());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.abs());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.zero());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualTransactionAmountForType.getAmount());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.abs());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.zero());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Currency currency = actualTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualTransactionAmountForType.getAmount());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.abs());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.zero());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl.getTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Currency currency = actualTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualTransactionAmountForType.getAmount());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.abs());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.zero());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(mock(PaymentTransactionType.class));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Currency currency = actualTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualTransactionAmountForType.getAmount());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.abs());
    assertEquals(actualTransactionAmountForType, actualTransactionAmountForType.zero());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualSuccessfulTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualSuccessfulTransactionAmountForType.getAmount());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.abs());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.zero());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualSuccessfulTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualSuccessfulTransactionAmountForType.getAmount());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.abs());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.zero());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Currency currency = actualSuccessfulTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualSuccessfulTransactionAmountForType.getAmount());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.abs());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.zero());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Currency currency = actualSuccessfulTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualSuccessfulTransactionAmountForType.getAmount());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.abs());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.zero());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(mock(PaymentTransactionType.class));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Currency currency = actualSuccessfulTransactionAmountForType.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualSuccessfulTransactionAmountForType.getAmount());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.abs());
    assertEquals(actualSuccessfulTransactionAmountForType, actualSuccessfulTransactionAmountForType.zero());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getStatus()}
   */
  @Test
  public void testGetStatus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getStatus());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getStatus()}
   */
  @Test
  public void testGetStatus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(mock(PaymentTransactionImpl.class));

    // Act and Assert
    assertNull(orderPaymentImpl.getStatus());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderPaymentImpl()).isConfirmed());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());

    // Act and Assert
    assertFalse(orderPaymentImpl.isConfirmed());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction, atLeast(1)).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(true);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertTrue(actualIsConfirmedResult);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(false);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction, atLeast(1)).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(true);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction).getSuccess();
    verify(transaction, atLeast(1)).getType();
    assertTrue(actualIsConfirmedResult);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getCurrency());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrency());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrency());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getCurrencyCode());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrencyCode());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(new BroadleafCurrencyImpl());

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrencyCode());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrencyCode());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new OrderPaymentImpl()).getArchived().charValue());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#getArchived()}
   */
  @Test
  public void testGetArchived2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(mock(PaymentTransactionImpl.class));

    // Act and Assert
    assertEquals('N', orderPaymentImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act
    orderPaymentImpl.setArchived('A');

    // Assert
    assertEquals('A', orderPaymentImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', orderPaymentImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(mock(PaymentTransactionImpl.class));

    // Act
    orderPaymentImpl.setArchived('A');

    // Assert
    assertEquals('A', orderPaymentImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', orderPaymentImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderPaymentImpl()).isActive());
  }

  /**
   * Method under test: {@link OrderPaymentImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setArchived('Y');

    // Act and Assert
    assertFalse(orderPaymentImpl.isActive());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(orderPaymentImpl, orderPaymentImpl2);
    int expectedHashCodeResult = orderPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(orderPaymentImpl, orderPaymentImpl2);
    int expectedHashCodeResult = orderPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(orderPaymentImpl, orderPaymentImpl);
    int expectedHashCodeResult = orderPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentImpl.hashCode());
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<OrderPayment> actualCreateOrRetrieveCopyInstanceResult = orderPaymentImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.payment.domain.OrderPaymentImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    OrderPayment clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof OrderPaymentImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(orderPaymentImpl, clone);
  }

  /**
   * Method under test:
   * {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderPayment> actualCreateOrRetrieveCopyInstanceResult = orderPaymentImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(2L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(orderPaymentImpl, orderPaymentImpl2);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(orderPaymentImpl, null);
  }

  /**
   * Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(orderPaymentImpl, "Different type to OrderPaymentImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#setBillingAddress(Address)}
   *   <li>{@link OrderPaymentImpl#setId(Long)}
   *   <li>{@link OrderPaymentImpl#setOrder(Order)}
   *   <li>{@link OrderPaymentImpl#setReferenceNumber(String)}
   *   <li>{@link OrderPaymentImpl#setTransactions(List)}
   *   <li>{@link OrderPaymentImpl#getBillingAddress()}
   *   <li>{@link OrderPaymentImpl#getId()}
   *   <li>{@link OrderPaymentImpl#getOrder()}
   *   <li>{@link OrderPaymentImpl#getReferenceNumber()}
   *   <li>{@link OrderPaymentImpl#getTransactions()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    AddressImpl billingAddress = new AddressImpl();

    // Act
    orderPaymentImpl.setBillingAddress(billingAddress);
    orderPaymentImpl.setId(1L);
    NullOrderImpl order = new NullOrderImpl();
    orderPaymentImpl.setOrder(order);
    orderPaymentImpl.setReferenceNumber("42");
    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    orderPaymentImpl.setTransactions(transactions);
    Address actualBillingAddress = orderPaymentImpl.getBillingAddress();
    Long actualId = orderPaymentImpl.getId();
    Order actualOrder = orderPaymentImpl.getOrder();
    String actualReferenceNumber = orderPaymentImpl.getReferenceNumber();
    List<PaymentTransaction> actualTransactions = orderPaymentImpl.getTransactions();

    // Assert that nothing has changed
    assertEquals("42", actualReferenceNumber);
    assertEquals(1L, actualId.longValue());
    assertSame(transactions, actualTransactions);
    assertSame(order, actualOrder);
    assertSame(billingAddress, actualBillingAddress);
  }
}
