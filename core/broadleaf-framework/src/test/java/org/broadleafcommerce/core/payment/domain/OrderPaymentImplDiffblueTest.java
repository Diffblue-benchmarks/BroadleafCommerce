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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPaymentImplDiffblueTest {
  @Autowired private OrderPaymentImpl orderPaymentImpl;

  /**
   * Test {@link OrderPaymentImpl#getAmount()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getAmount()"})
  public void testGetAmount_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money amount = new Money();
    orderPaymentImpl.setAmount(amount);
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertEquals(amount, orderPaymentImpl.getAmount());
  }

  /**
   * Test {@link OrderPaymentImpl#getAmount()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getAmount()"})
  public void testGetAmount_givenOrderPaymentImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderPaymentImpl.getAmount());
  }

  /**
   * Test {@link OrderPaymentImpl#getAmount()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getAmount()"})
  public void testGetAmount_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
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
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualAmount.abs();
    assertEquals(actualAmount, actualAbsResult);
    Money actualZeroResult = actualAmount.zero();
    assertEquals(actualAmount, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#setAmount(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link OrderPaymentImpl} {@link OrderPaymentImpl#amount} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.setAmount(Money)"})
  public void testSetAmount_whenMoney_thenOrderPaymentImplAmountIsBigDecimalWith000() {
    // Arrange
    Money amount = new Money();

    // Act
    orderPaymentImpl.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderPaymentImpl.amount);
    BigDecimal bigDecimal = orderPaymentImpl.amount;
    Money absResult = amount.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = amount.zero();
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
   * Test {@link OrderPaymentImpl#setAmount(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OrderPaymentImpl} {@link OrderPaymentImpl#amount} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.setAmount(Money)"})
  public void testSetAmount_whenNull_thenOrderPaymentImplAmountIsNull() {
    // Arrange and Act
    orderPaymentImpl.setAmount(null);

    // Assert that nothing has changed
    assertNull(orderPaymentImpl.amount);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Address OrderPaymentImpl.getBillingAddress()",
    "Long OrderPaymentImpl.getId()",
    "Order OrderPaymentImpl.getOrder()",
    "String OrderPaymentImpl.getReferenceNumber()",
    "List OrderPaymentImpl.getTransactions()",
    "void OrderPaymentImpl.setBillingAddress(Address)",
    "void OrderPaymentImpl.setId(Long)",
    "void OrderPaymentImpl.setOrder(Order)",
    "void OrderPaymentImpl.setReferenceNumber(String)",
    "void OrderPaymentImpl.setTransactions(List)"
  })
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

    // Assert
    assertEquals("42", actualReferenceNumber);
    assertEquals(1L, actualId.longValue());
    assertSame(transactions, actualTransactions);
    assertSame(order, actualOrder);
    assertSame(billingAddress, actualBillingAddress);
  }

  /**
   * Test {@link OrderPaymentImpl#setType(PaymentType)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then {@link OrderPaymentImpl} Type Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#setType(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.setType(PaymentType)"})
  public void testSetType_givenType_thenOrderPaymentImplTypeTypeIsType() {
    // Arrange
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
   * Test {@link OrderPaymentImpl#setType(PaymentType)}.
   *
   * <ul>
   *   <li>Then {@link OrderPaymentImpl} Type is {@link PaymentType#PaymentType(String, String)}
   *       with {@code Type} and {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#setType(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.setType(PaymentType)"})
  public void testSetType_thenOrderPaymentImplTypeIsPaymentTypeWithTypeAndFriendlyType() {
    // Arrange
    PaymentType type = new PaymentType("Type", "Friendly Type");

    // Act
    orderPaymentImpl.setType(type);

    // Assert
    assertEquals("Type", orderPaymentImpl.type);
    assertEquals(type, orderPaymentImpl.getType());
  }

  /**
   * Test {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.setPaymentGatewayType(PaymentGatewayType)"})
  public void testSetPaymentGatewayType() {
    // Arrange
    PaymentGatewayType gatewayType = new PaymentGatewayType("Type", "Friendly Type");

    // Act
    orderPaymentImpl.setPaymentGatewayType(gatewayType);

    // Assert
    assertEquals("Type", orderPaymentImpl.gatewayType);
    assertEquals(gatewayType, orderPaymentImpl.getGatewayType());
  }

  /**
   * Test {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then {@link OrderPaymentImpl} GatewayType Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.setPaymentGatewayType(PaymentGatewayType)"})
  public void testSetPaymentGatewayType_givenType_thenOrderPaymentImplGatewayTypeTypeIsType() {
    // Arrange
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
   * Test {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.addTransaction(PaymentTransaction)"})
  public void testAddTransaction() {
    // Arrange
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
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    List<PaymentTransaction> actualTransactionsForType =
        orderPaymentImpl.getTransactionsForType(null);

    // Assert
    verify(paymentTransactionImpl).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType2() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(mock(PaymentTransactionType.class));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    List<PaymentTransaction> actualTransactionsForType =
        orderPaymentImpl.getTransactionsForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(paymentTransactionImpl).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType3() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(new PaymentTransactionType());

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    List<PaymentTransaction> actualTransactionsForType =
        orderPaymentImpl.getTransactionsForType(new PaymentTransactionType());

    // Assert
    verify(paymentTransactionImpl).getType();
    assertEquals(1, actualTransactionsForType.size());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType_givenOrderPaymentImpl() {
    // Arrange, Act and Assert
    assertTrue(
        orderPaymentImpl
            .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"))
            .isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType_thenReturnSizeIsOne() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    List<PaymentTransaction> actualTransactionsForType =
        orderPaymentImpl.getTransactionsForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(paymentTransactionImpl).getType();
    assertEquals(1, actualTransactionsForType.size());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>When {@link PaymentTransactionType#PaymentTransactionType()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType_whenPaymentTransactionType() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    List<PaymentTransaction> actualTransactionsForType =
        orderPaymentImpl.getTransactionsForType(new PaymentTransactionType());

    // Assert
    verify(paymentTransactionImpl).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getInitialTransaction()"})
  public void testGetInitialTransaction() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl.setDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act and Assert
    assertNull(orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getInitialTransaction()"})
  public void testGetInitialTransaction_givenOrderPaymentImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   *
   * <ul>
   *   <li>Then return {@link PaymentTransactionImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getInitialTransaction()"})
  public void testGetInitialTransaction_thenReturnPaymentTransactionImpl() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl.setDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setParentTransaction(null);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act and Assert
    assertSame(paymentTransactionImpl, orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    PaymentTransaction actualAuthorizeTransaction = orderPaymentImpl.getAuthorizeTransaction();

    // Assert
    verify(paymentTransactionImpl, atLeast(1)).getType();
    assertNull(actualAuthorizeTransaction);
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction2() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("AUTHORIZE", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    orderPaymentImpl.getAuthorizeTransaction();

    // Assert
    verify(paymentTransactionImpl).getType();
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction3() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    orderPaymentImpl.getAuthorizeTransaction();

    // Assert
    verify(paymentTransactionImpl, atLeast(1)).getType();
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(new PaymentTransactionImpl());
    orderPaymentImpl.setTransactions(transactions);

    // Act and Assert
    assertNull(orderPaymentImpl.getAuthorizeTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction_givenOrderPaymentImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderPaymentImpl.getAuthorizeTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType =
        orderPaymentImpl.getTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualTransactionAmountForType.abs();
    assertEquals(actualTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualTransactionAmountForType.zero();
    assertEquals(actualTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType());

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType =
        orderPaymentImpl.getTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Money actualAbsResult = actualTransactionAmountForType.abs();
    assertEquals(actualTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualTransactionAmountForType.zero();
    assertEquals(actualTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getType()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_givenPaymentTransactionImplGetTypeReturnNull() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType =
        orderPaymentImpl.getTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Money actualAbsResult = actualTransactionAmountForType.abs();
    assertEquals(actualTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualTransactionAmountForType.zero();
    assertEquals(actualTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType =
        orderPaymentImpl.getTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualTransactionAmountForType.abs();
    assertEquals(actualTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualTransactionAmountForType.zero();
    assertEquals(actualTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_thenReturnZero() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act
    Money actualTransactionAmountForType =
        orderPaymentImpl.getTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals(Money.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>When {@link PaymentTransactionType#PaymentTransactionType()}.
   *   <li>Then calls {@link PaymentTransactionImpl#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_whenPaymentTransactionType_thenCallsGetType() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType =
        orderPaymentImpl.getTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Money actualAbsResult = actualTransactionAmountForType.abs();
    assertEquals(actualTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualTransactionAmountForType.zero();
    assertEquals(actualTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>When {@link PaymentTransactionType}.
   *   <li>Then calls {@link PaymentTransactionImpl#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_whenPaymentTransactionType_thenCallsGetType2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType =
        orderPaymentImpl.getTransactionAmountForType(mock(PaymentTransactionType.class));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Money actualAbsResult = actualTransactionAmountForType.abs();
    assertEquals(actualTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualTransactionAmountForType.zero();
    assertEquals(actualTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"
  })
  public void testGetSuccessfulTransactionAmountForType() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType =
        orderPaymentImpl.getSuccessfulTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualSuccessfulTransactionAmountForType.abs();
    assertEquals(actualSuccessfulTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualSuccessfulTransactionAmountForType.zero();
    assertEquals(actualSuccessfulTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"
  })
  public void testGetSuccessfulTransactionAmountForType2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType());

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType =
        orderPaymentImpl.getSuccessfulTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Money actualAbsResult = actualSuccessfulTransactionAmountForType.abs();
    assertEquals(actualSuccessfulTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualSuccessfulTransactionAmountForType.zero();
    assertEquals(actualSuccessfulTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"
  })
  public void testGetSuccessfulTransactionAmountForType3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType =
        orderPaymentImpl.getSuccessfulTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Money actualAbsResult = actualSuccessfulTransactionAmountForType.abs();
    assertEquals(actualSuccessfulTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualSuccessfulTransactionAmountForType.zero();
    assertEquals(actualSuccessfulTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"
  })
  public void testGetSuccessfulTransactionAmountForType4() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    PaymentTransactionImpl transaction2 = new PaymentTransactionImpl();
    transaction2.setSuccess(false);
    transaction2.setOrderPayment(mock(OrderPayment.class));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction2);
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType =
        orderPaymentImpl.getSuccessfulTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Money actualAbsResult = actualSuccessfulTransactionAmountForType.abs();
    assertEquals(actualSuccessfulTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualSuccessfulTransactionAmountForType.zero();
    assertEquals(actualSuccessfulTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"
  })
  public void testGetSuccessfulTransactionAmountForType_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType =
        orderPaymentImpl.getSuccessfulTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money actualAbsResult = actualSuccessfulTransactionAmountForType.abs();
    assertEquals(actualSuccessfulTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualSuccessfulTransactionAmountForType.zero();
    assertEquals(actualSuccessfulTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"
  })
  public void testGetSuccessfulTransactionAmountForType_thenCallsGetSuccess() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(false);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    PaymentTransactionImpl transaction2 = new PaymentTransactionImpl();
    transaction2.setOrderPayment(mock(OrderPayment.class));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction2);
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType =
        orderPaymentImpl.getSuccessfulTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getSuccess();
    verify(transaction).getType();
    Money actualAbsResult = actualSuccessfulTransactionAmountForType.abs();
    assertEquals(actualSuccessfulTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualSuccessfulTransactionAmountForType.zero();
    assertEquals(actualSuccessfulTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"
  })
  public void testGetSuccessfulTransactionAmountForType_thenCallsGetType() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType =
        orderPaymentImpl.getSuccessfulTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Money actualAbsResult = actualSuccessfulTransactionAmountForType.abs();
    assertEquals(actualSuccessfulTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualSuccessfulTransactionAmountForType.zero();
    assertEquals(actualSuccessfulTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"
  })
  public void testGetSuccessfulTransactionAmountForType_thenReturnZero() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act
    Money actualSuccessfulTransactionAmountForType =
        orderPaymentImpl.getSuccessfulTransactionAmountForType(
            new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals(Money.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>When {@link PaymentTransactionType}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"
  })
  public void testGetSuccessfulTransactionAmountForType_whenPaymentTransactionType() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType =
        orderPaymentImpl.getSuccessfulTransactionAmountForType(mock(PaymentTransactionType.class));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    Money actualAbsResult = actualSuccessfulTransactionAmountForType.abs();
    assertEquals(actualSuccessfulTransactionAmountForType, actualAbsResult);
    Money actualZeroResult = actualSuccessfulTransactionAmountForType.zero();
    assertEquals(actualSuccessfulTransactionAmountForType, actualZeroResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getStatus()}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#getStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.payment.service.type.OrderPaymentStatus OrderPaymentImpl.getStatus()"
  })
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertNull(orderPaymentImpl.getStatus());
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(paymentTransactionImpl, atLeast(1)).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed2() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("AUTHORIZE", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl, atLeast(1)).getType();
    assertTrue(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed_givenArrayListAddPaymentTransactionImpl_thenReturnFalse() {
    // Arrange
    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(new PaymentTransactionImpl());
    orderPaymentImpl.setTransactions(transactions);

    // Act and Assert
    assertFalse(orderPaymentImpl.isConfirmed());
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed_givenOrderPaymentImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderPaymentImpl.isConfirmed());
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getSuccess()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed_givenPaymentTransactionImplGetSuccessReturnFalse() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getSuccess()} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed_givenPaymentTransactionImplGetSuccessReturnTrue_thenReturnTrue() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertTrue(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getType()} return
   *       {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed_givenPaymentTransactionImplGetTypeReturnNull_thenReturnFalse() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(null);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);
    orderPaymentImpl.setTransactions(transactions);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(paymentTransactionImpl, atLeast(1)).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrency()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafCurrency OrderPaymentImpl.getCurrency()"})
  public void testGetCurrency_givenOrderPaymentImpl() {
    // Arrange, Act and Assert
    assertNull(orderPaymentImpl.getCurrency());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrency()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} Order is {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafCurrency OrderPaymentImpl.getCurrency()"})
  public void testGetCurrency_givenOrderPaymentImplOrderIsNullOrderImpl() {
    // Arrange
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrency());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderPaymentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(new BroadleafCurrencyImpl());
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderPaymentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderPaymentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderPaymentImpl() {
    // Arrange, Act and Assert
    assertNull(orderPaymentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getArchived()}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character OrderPaymentImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', orderPaymentImpl.getArchived().charValue());
  }

  /**
   * Test {@link OrderPaymentImpl#setArchived(Character)}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange and Act
    orderPaymentImpl.setArchived('A');

    // Assert
    assertEquals('A', orderPaymentImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', orderPaymentImpl.getArchived().charValue());
  }

  /**
   * Test {@link OrderPaymentImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.isActive()"})
  public void testIsActive_givenOrderPaymentImplArchivedIsY_thenReturnFalse() {
    // Arrange
    orderPaymentImpl.setArchived('Y');

    // Act and Assert
    assertFalse(orderPaymentImpl.isActive());
  }

  /**
   * Test {@link OrderPaymentImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.isActive()"})
  public void testIsActive_givenOrderPaymentImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(orderPaymentImpl.isActive());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}, and {@link OrderPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
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
    assertEquals(orderPaymentImpl.hashCode(), orderPaymentImpl2.hashCode());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}, and {@link OrderPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
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
   * Test {@link OrderPaymentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
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
   * Test {@link OrderPaymentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
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
   * Test {@link OrderPaymentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
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
   * Test {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new OrderPaymentImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderPayment> actualCreateOrRetrieveCopyInstanceResult =
        orderPaymentImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(orderPaymentImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderPayment> actualCreateOrRetrieveCopyInstanceResult =
        orderPaymentImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new PaymentTransactionImpl(), true));
    when(transaction.isActive()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OrderPaymentImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    orderPaymentImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(transaction).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(transaction).isActive();
  }

  /**
   * Test {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());
    when(transaction.isActive()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OrderPaymentImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> orderPaymentImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(transaction).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(transaction).isActive();
  }

  /**
   * Test {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance5() throws CloneNotSupportedException {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new PaymentTransactionImpl(), true));
    when(transaction.isActive()).thenReturn(true);

    AddressImpl billingAddress = mock(AddressImpl.class);
    when(billingAddress.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new AddressImpl(), true));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setBillingAddress(billingAddress);
    orderPaymentImpl.addTransaction(transaction);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OrderPaymentImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    orderPaymentImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(transaction).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(transaction).isActive();
    verify(billingAddress).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance6() throws CloneNotSupportedException {
    // Arrange
    AddressImpl billingAddress = mock(AddressImpl.class);
    when(billingAddress.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setBillingAddress(billingAddress);
    orderPaymentImpl.addTransaction(mock(PaymentTransactionImpl.class));

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OrderPaymentImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> orderPaymentImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(billingAddress).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Amount is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenOrderPaymentImplAmountIsMoney()
      throws CloneNotSupportedException {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new PaymentTransactionImpl(), true));
    when(transaction.isActive()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.addTransaction(transaction);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OrderPaymentImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    orderPaymentImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(transaction).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(transaction).isActive();
  }

  /**
   * Test {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#isActive()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenPaymentTransactionImplIsActiveReturnFalse()
      throws CloneNotSupportedException {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.isActive()).thenReturn(false);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OrderPaymentImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    orderPaymentImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(transaction).isActive();
  }
}
