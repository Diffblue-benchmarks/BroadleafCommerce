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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderPaymentImplDiffblueTest {
  @Autowired
  private OrderPaymentImpl orderPaymentImpl;

  /**
   * Test {@link OrderPaymentImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getAmount()"})
  public void testGetAmount_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));
    Money amount = new Money();
    orderPaymentImpl2.setAmount(amount);
    orderPaymentImpl2.setOrder(order);

    // Act and Assert
    assertEquals(amount, orderPaymentImpl2.getAmount());
  }

  /**
   * Test {@link OrderPaymentImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getAmount()"})
  public void testGetAmount_givenOrderPaymentImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getAmount());
  }

  /**
   * Test {@link OrderPaymentImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) {@link OrderPaymentImpl#amount} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderPaymentImpl.setAmount(Money)"})
  public void testSetAmount_whenMoney_thenOrderPaymentImplAmountIsBigDecimalWith000() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    Money amount = new Money();

    // Act
    orderPaymentImpl2.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderPaymentImpl2.amount);
    BigDecimal bigDecimal = orderPaymentImpl2.amount;
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) {@link OrderPaymentImpl#amount} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderPaymentImpl.setAmount(Money)"})
  public void testSetAmount_whenNull_thenOrderPaymentImplAmountIsNull() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();

    // Act
    orderPaymentImpl2.setAmount(null);

    // Assert that nothing has changed
    assertNull(orderPaymentImpl2.amount);
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Address OrderPaymentImpl.getBillingAddress()", "Long OrderPaymentImpl.getId()",
      "Order OrderPaymentImpl.getOrder()", "String OrderPaymentImpl.getReferenceNumber()",
      "List OrderPaymentImpl.getTransactions()", "void OrderPaymentImpl.setBillingAddress(Address)",
      "void OrderPaymentImpl.setId(Long)", "void OrderPaymentImpl.setOrder(Order)",
      "void OrderPaymentImpl.setReferenceNumber(String)", "void OrderPaymentImpl.setTransactions(List)"})
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
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) Type Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setType(PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderPaymentImpl.setType(PaymentType)"})
  public void testSetType_givenType_thenOrderPaymentImplTypeTypeIsType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    PaymentType type = mock(PaymentType.class);
    when(type.getType()).thenReturn("Type");

    // Act
    orderPaymentImpl2.setType(type);

    // Assert
    verify(type).getType();
    assertEquals("Type", orderPaymentImpl2.getType().getType());
    assertEquals("Type", orderPaymentImpl2.type);
  }

  /**
   * Test {@link OrderPaymentImpl#setType(PaymentType)}.
   * <ul>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) Type is {@link PaymentType#PaymentType(String, String)} with {@code Type} and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setType(PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderPaymentImpl.setType(PaymentType)"})
  public void testSetType_thenOrderPaymentImplTypeIsPaymentTypeWithTypeAndFriendlyType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    PaymentType type = new PaymentType("Type", "Friendly Type");

    // Act
    orderPaymentImpl2.setType(type);

    // Assert
    assertEquals("Type", orderPaymentImpl2.type);
    assertEquals(type, orderPaymentImpl2.getType());
  }

  /**
   * Test {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderPaymentImpl.setPaymentGatewayType(PaymentGatewayType)"})
  public void testSetPaymentGatewayType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    PaymentGatewayType gatewayType = new PaymentGatewayType("Type", "Friendly Type");

    // Act
    orderPaymentImpl2.setPaymentGatewayType(gatewayType);

    // Assert
    assertEquals("Type", orderPaymentImpl2.gatewayType);
    assertEquals(gatewayType, orderPaymentImpl2.getGatewayType());
  }

  /**
   * Test {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) GatewayType Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderPaymentImpl.setPaymentGatewayType(PaymentGatewayType)"})
  public void testSetPaymentGatewayType_givenType_thenOrderPaymentImplGatewayTypeTypeIsType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getType()).thenReturn("Type");

    // Act
    orderPaymentImpl2.setPaymentGatewayType(gatewayType);

    // Assert
    verify(gatewayType).getType();
    assertEquals("Type", orderPaymentImpl2.getGatewayType().getType());
    assertEquals("Type", orderPaymentImpl2.gatewayType);
  }

  /**
   * Test {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderPaymentImpl.addTransaction(PaymentTransaction)"})
  public void testAddTransaction() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    PaymentTransactionImpl transaction = new PaymentTransactionImpl();

    // Act
    orderPaymentImpl2.addTransaction(transaction);

    // Assert
    List<PaymentTransaction> transactions = orderPaymentImpl2.getTransactions();
    assertEquals(1, transactions.size());
    assertSame(transaction, transactions.get(0));
    assertSame(transaction, orderPaymentImpl2.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("42", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl2
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType2() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType());

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl2
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType3() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(mock(PaymentTransactionType.class));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl2
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType_givenOrderPaymentImpl_thenReturnEmpty() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();

    // Act and Assert
    assertTrue(orderPaymentImpl2.getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type")).isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType_thenReturnSizeIsOne() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl2
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertEquals(1, actualTransactionsForType.size());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType_whenNull() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl2.getTransactionsForType(null);

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link PaymentTransactionType#PaymentTransactionType()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderPaymentImpl.getTransactionsForType(PaymentTransactionType)"})
  public void testGetTransactionsForType_whenPaymentTransactionType_thenReturnSizeIsOne() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType());

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl2
        .getTransactionsForType(new PaymentTransactionType());

    // Assert
    verify(transaction).getType();
    assertEquals(1, actualTransactionsForType.size());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getInitialTransaction()"})
  public void testGetInitialTransaction() {
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

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl2.setTransactions(transactions);

    // Act and Assert
    assertNull(orderPaymentImpl2.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getInitialTransaction()"})
  public void testGetInitialTransaction_givenOrderPaymentImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   * <ul>
   *   <li>Then return {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getInitialTransaction()"})
  public void testGetInitialTransaction_thenReturnPaymentTransactionImpl() {
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

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl2.setTransactions(transactions);

    // Act and Assert
    assertSame(paymentTransactionImpl, orderPaymentImpl2.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(new PaymentTransactionImpl());

    // Act and Assert
    assertNull(orderPaymentImpl2.getAuthorizeTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction2() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    PaymentTransaction actualAuthorizeTransaction = orderPaymentImpl2.getAuthorizeTransaction();

    // Assert
    verify(transaction, atLeast(1)).getType();
    assertNull(actualAuthorizeTransaction);
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction3() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    orderPaymentImpl2.getAuthorizeTransaction();

    // Assert
    verify(transaction).getType();
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction4() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    orderPaymentImpl2.getAuthorizeTransaction();

    // Assert
    verify(transaction, atLeast(1)).getType();
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentTransaction OrderPaymentImpl.getAuthorizeTransaction()"})
  public void testGetAuthorizeTransaction_givenOrderPaymentImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getAuthorizeTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(new PaymentTransactionImpl());
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl2
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType2() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType());

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl2
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Order is {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_givenOrderPaymentImplOrderIsNullOrderImpl() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setOrder(new NullOrderImpl());

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl2
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_thenReturnMoney() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    Money money = new Money();
    when(transaction.getAmount()).thenReturn(money);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl2
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getAmount();
    verify(transaction).getType();
    assertEquals(money, actualTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_thenReturnZero() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl2
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link PaymentTransactionType#PaymentTransactionType()}.</li>
   *   <li>Then calls {@link PaymentTransactionImpl#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_whenPaymentTransactionType_thenCallsGetType() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl2.getTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link PaymentTransactionType}.</li>
   *   <li>Then calls {@link PaymentTransactionImpl#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getTransactionAmountForType(PaymentTransactionType)"})
  public void testGetTransactionAmountForType_whenPaymentTransactionType_thenCallsGetType2() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl2
        .getTransactionAmountForType(mock(PaymentTransactionType.class));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"})
  public void testGetSuccessfulTransactionAmountForType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setOrder(new NullOrderImpl());

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl2
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"})
  public void testGetSuccessfulTransactionAmountForType2() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(new PaymentTransactionImpl());
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl2
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"})
  public void testGetSuccessfulTransactionAmountForType3() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType());

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl2
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"})
  public void testGetSuccessfulTransactionAmountForType_thenReturnMoney() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    Money money = new Money();
    when(transaction.getAmount()).thenReturn(money);
    when(transaction.getSuccess()).thenReturn(true);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl2
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getAmount();
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertEquals(money, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"})
  public void testGetSuccessfulTransactionAmountForType_thenReturnZero() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl2
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link PaymentTransactionType#PaymentTransactionType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"})
  public void testGetSuccessfulTransactionAmountForType_whenPaymentTransactionType() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl2
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link PaymentTransactionType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderPaymentImpl.getSuccessfulTransactionAmountForType(PaymentTransactionType)"})
  public void testGetSuccessfulTransactionAmountForType_whenPaymentTransactionType2() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);
    orderPaymentImpl2.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl2
        .getSuccessfulTransactionAmountForType(mock(PaymentTransactionType.class));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getStatus()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.payment.service.type.OrderPaymentStatus OrderPaymentImpl.getStatus()"})
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getStatus());
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl2.isConfirmed();

    // Assert
    verify(transaction, atLeast(1)).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed2() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(true);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl2.isConfirmed();

    // Assert
    verify(transaction).getSuccess();
    verify(transaction, atLeast(1)).getType();
    assertTrue(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) addTransaction {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed_givenOrderPaymentImplAddTransactionPaymentTransactionImpl() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(new PaymentTransactionImpl());

    // Act and Assert
    assertFalse(orderPaymentImpl2.isConfirmed());
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed_givenOrderPaymentImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderPaymentImpl()).isConfirmed());
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getSuccess()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed_givenPaymentTransactionImplGetSuccessReturnFalse() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(false);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl2.isConfirmed();

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getSuccess()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentImpl.isConfirmed()"})
  public void testIsConfirmed_givenPaymentTransactionImplGetSuccessReturnTrue_thenReturnTrue() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(true);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl2.isConfirmed();

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertTrue(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.common.currency.domain.BroadleafCurrency OrderPaymentImpl.getCurrency()"})
  public void testGetCurrency_givenOrderPaymentImpl() {
    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getCurrency());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Amount is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.common.currency.domain.BroadleafCurrency OrderPaymentImpl.getCurrency()"})
  public void testGetCurrency_givenOrderPaymentImplAmountIsMoney() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl2.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNull(orderPaymentImpl2.getCurrency());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderPaymentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl() {
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
    order.setTotalTax(new Money());
    order.setCurrency(new BroadleafCurrencyImpl());

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl2.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderPaymentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl2.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderPaymentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderPaymentImpl() {
    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getArchived()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getArchived()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Character OrderPaymentImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', (new OrderPaymentImpl()).getArchived().charValue());
  }

  /**
   * Test {@link OrderPaymentImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#setArchived(Character)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderPaymentImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();

    // Act
    orderPaymentImpl2.setArchived('A');

    // Assert
    assertEquals('A', orderPaymentImpl2.archiveStatus.getArchived().charValue());
    assertEquals('A', orderPaymentImpl2.getArchived().charValue());
  }

  /**
   * Test {@link OrderPaymentImpl#isActive()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Archived is {@code Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentImpl.isActive()"})
  public void testIsActive_givenOrderPaymentImplArchivedIsY_thenReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setArchived('Y');

    // Act and Assert
    assertFalse(orderPaymentImpl2.isActive());
  }

  /**
   * Test {@link OrderPaymentImpl#isActive()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentImpl.isActive()"})
  public void testIsActive_givenOrderPaymentImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OrderPaymentImpl()).isActive());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}, and {@link OrderPaymentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    int expectedHashCodeResult = orderPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentImpl2.hashCode());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}, and {@link OrderPaymentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderPayment> actualCreateOrRetrieveCopyInstanceResult = orderPaymentImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link OrderPaymentImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse OrderPaymentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnOrderPaymentImpl() throws CloneNotSupportedException {
    // Arrange
    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<OrderPayment> actualCreateOrRetrieveCopyInstanceResult = orderPaymentImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.payment.domain.OrderPaymentImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    OrderPayment clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof OrderPaymentImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(orderPaymentImpl2, clone);
  }
}
