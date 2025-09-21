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
package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDao;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentLog;
import org.broadleafcommerce.core.payment.domain.PaymentLogImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CustomerPaymentService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderPaymentServiceImplDiffblueTest {
  @Mock private AddressService addressService;

  @Mock private CustomerPaymentService customerPaymentService;

  @Mock private OrderPaymentDao orderPaymentDao;

  @InjectMocks private OrderPaymentServiceImpl orderPaymentServiceImpl;

  /**
   * Test {@link OrderPaymentServiceImpl#save(PaymentLog)} with {@code log}.
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#save(PaymentLog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentLog OrderPaymentServiceImpl.save(PaymentLog)"})
  public void testSaveWithLog() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    when(orderPaymentDao.save(Mockito.<PaymentLog>any())).thenReturn(paymentLogImpl);

    // Act
    PaymentLog actualSaveResult = orderPaymentServiceImpl.save(new PaymentLogImpl());

    // Assert
    verify(orderPaymentDao).save(isA(PaymentLog.class));
    assertSame(paymentLogImpl, actualSaveResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#save(OrderPayment)} with {@code payment}.
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#save(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment OrderPaymentServiceImpl.save(OrderPayment)"})
  public void testSaveWithPayment() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(orderPaymentDao.save(Mockito.<OrderPayment>any())).thenReturn(orderPaymentImpl);

    // Act
    OrderPayment actualSaveResult = orderPaymentServiceImpl.save(new OrderPaymentImpl());

    // Assert
    verify(orderPaymentDao).save(isA(OrderPayment.class));
    assertSame(orderPaymentImpl, actualSaveResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#save(PaymentTransaction)} with {@code transaction}.
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#save(PaymentTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentServiceImpl.save(PaymentTransaction)"})
  public void testSaveWithTransaction() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    when(orderPaymentDao.save(Mockito.<PaymentTransaction>any()))
        .thenReturn(paymentTransactionImpl);

    // Act
    PaymentTransaction actualSaveResult =
        orderPaymentServiceImpl.save(new PaymentTransactionImpl());

    // Assert
    verify(orderPaymentDao).save(isA(PaymentTransaction.class));
    assertSame(paymentTransactionImpl, actualSaveResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#readPaymentById(Long)}.
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#readPaymentById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment OrderPaymentServiceImpl.readPaymentById(Long)"})
  public void testReadPaymentById() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(orderPaymentDao.readPaymentById(Mockito.<Long>any())).thenReturn(orderPaymentImpl);

    // Act
    OrderPayment actualReadPaymentByIdResult = orderPaymentServiceImpl.readPaymentById(1L);

    // Assert
    verify(orderPaymentDao).readPaymentById(1L);
    assertSame(orderPaymentImpl, actualReadPaymentByIdResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#readPaymentsForOrder(Order)}.
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#readPaymentsForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderPaymentServiceImpl.readPaymentsForOrder(Order)"})
  public void testReadPaymentsForOrder() {
    // Arrange
    when(orderPaymentDao.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    List<OrderPayment> actualReadPaymentsForOrderResult =
        orderPaymentServiceImpl.readPaymentsForOrder(new NullOrderImpl());

    // Assert
    verify(orderPaymentDao).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualReadPaymentsForOrderResult.isEmpty());
  }

  /**
   * Test {@link OrderPaymentServiceImpl#create()}.
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment OrderPaymentServiceImpl.create()"})
  public void testCreate() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(orderPaymentDao.create()).thenReturn(orderPaymentImpl);

    // Act
    OrderPayment actualCreateResult = orderPaymentServiceImpl.create();

    // Assert
    verify(orderPaymentDao).create();
    assertSame(orderPaymentImpl, actualCreateResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#delete(OrderPayment)}.
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#delete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentServiceImpl.delete(OrderPayment)"})
  public void testDelete() {
    // Arrange
    doNothing().when(orderPaymentDao).delete(Mockito.<OrderPayment>any());

    // Act
    orderPaymentServiceImpl.delete(new OrderPaymentImpl());

    // Assert
    verify(orderPaymentDao).delete(isA(OrderPayment.class));
  }

  /**
   * Test {@link OrderPaymentServiceImpl#createLog()}.
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#createLog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentLog OrderPaymentServiceImpl.createLog()"})
  public void testCreateLog() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    when(orderPaymentDao.createLog()).thenReturn(paymentLogImpl);

    // Act
    PaymentLog actualCreateLogResult = orderPaymentServiceImpl.createLog();

    // Assert
    verify(orderPaymentDao).createLog();
    assertSame(paymentLogImpl, actualCreateLogResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#createTransaction()}.
   *
   * <ul>
   *   <li>Then return {@link PaymentTransactionImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#createTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentServiceImpl.createTransaction()"})
  public void testCreateTransaction_thenReturnPaymentTransactionImpl() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    when(orderPaymentDao.createTransaction()).thenReturn(paymentTransactionImpl);

    // Act
    PaymentTransaction actualCreateTransactionResult = orderPaymentServiceImpl.createTransaction();

    // Assert
    verify(orderPaymentDao).createTransaction();
    assertSame(paymentTransactionImpl, actualCreateTransactionResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#readTransactionById(Long)}.
   *
   * <p>Method under test: {@link OrderPaymentServiceImpl#readTransactionById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentServiceImpl.readTransactionById(Long)"})
  public void testReadTransactionById() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    when(orderPaymentDao.readTransactionById(Mockito.<Long>any()))
        .thenReturn(paymentTransactionImpl);

    // Act
    PaymentTransaction actualReadTransactionByIdResult =
        orderPaymentServiceImpl.readTransactionById(1L);

    // Assert
    verify(orderPaymentDao).readTransactionById(1L);
    assertSame(paymentTransactionImpl, actualReadTransactionByIdResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order,
   * CustomerPayment, Money)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPayment OrderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)"
  })
  public void testCreateOrderPaymentFromCustomerPayment() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(orderPaymentDao.save(Mockito.<OrderPayment>any())).thenReturn(orderPaymentImpl);
    when(orderPaymentDao.createTransaction()).thenReturn(new PaymentTransactionImpl());
    when(orderPaymentDao.create()).thenReturn(new OrderPaymentImpl());
    NullOrderImpl order = new NullOrderImpl();
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    OrderPayment actualCreateOrderPaymentFromCustomerPaymentResult =
        orderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(
            order, customerPayment, new Money());

    // Assert
    verify(orderPaymentDao).create();
    verify(orderPaymentDao).createTransaction();
    verify(orderPaymentDao).save(isA(OrderPayment.class));
    verify(addressService).copyAddress(isNull());
    assertSame(orderPaymentImpl, actualCreateOrderPaymentFromCustomerPaymentResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order,
   * CustomerPayment, Money)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPayment OrderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)"
  })
  public void testCreateOrderPaymentFromCustomerPayment2() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());

    OrderPayment orderPayment = mock(OrderPayment.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    doNothing().when(orderPayment).setAmount(Mockito.<Money>any());
    doNothing().when(orderPayment).setBillingAddress(Mockito.<Address>any());
    doNothing().when(orderPayment).setOrder(Mockito.<Order>any());
    doNothing().when(orderPayment).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPayment).setType(Mockito.<PaymentType>any());
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(orderPaymentDao.save(Mockito.<OrderPayment>any())).thenReturn(orderPaymentImpl);
    when(orderPaymentDao.createTransaction()).thenReturn(new PaymentTransactionImpl());
    when(orderPaymentDao.create()).thenReturn(orderPayment);
    NullOrderImpl order = new NullOrderImpl();

    CustomerPayment customerPayment = mock(CustomerPayment.class);
    when(customerPayment.getPaymentToken()).thenReturn("ABC123");
    when(customerPayment.getAdditionalFields()).thenReturn(new HashMap<>());
    when(customerPayment.getPaymentGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(customerPayment.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(customerPayment.getBillingAddress()).thenReturn(new AddressImpl());

    // Act
    OrderPayment actualCreateOrderPaymentFromCustomerPaymentResult =
        orderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(
            order, customerPayment, new Money());

    // Assert
    verify(orderPaymentDao).create();
    verify(orderPaymentDao).createTransaction();
    verify(orderPaymentDao).save(isA(OrderPayment.class));
    verify(orderPayment).getTransactions();
    verify(orderPayment).setAmount(isA(Money.class));
    verify(orderPayment).setBillingAddress(isA(Address.class));
    verify(orderPayment).setOrder(isA(Order.class));
    verify(orderPayment).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(orderPayment).setType(isA(PaymentType.class));
    verify(customerPayment, atLeast(1)).getAdditionalFields();
    verify(customerPayment).getBillingAddress();
    verify(customerPayment).getPaymentGatewayType();
    verify(customerPayment).getPaymentToken();
    verify(customerPayment).getPaymentType();
    verify(addressService).copyAddress(isA(Address.class));
    assertSame(orderPaymentImpl, actualCreateOrderPaymentFromCustomerPaymentResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order,
   * CustomerPayment, Money)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPayment OrderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)"
  })
  public void testCreateOrderPaymentFromCustomerPayment3() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());

    OrderPayment orderPayment = mock(OrderPayment.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    doNothing().when(orderPayment).setAmount(Mockito.<Money>any());
    doNothing().when(orderPayment).setBillingAddress(Mockito.<Address>any());
    doNothing().when(orderPayment).setOrder(Mockito.<Order>any());
    doNothing().when(orderPayment).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPayment).setType(Mockito.<PaymentType>any());
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(orderPaymentDao.save(Mockito.<OrderPayment>any())).thenReturn(orderPaymentImpl);
    when(orderPaymentDao.createTransaction()).thenReturn(new PaymentTransactionImpl());
    when(orderPaymentDao.create()).thenReturn(orderPayment);
    NullOrderImpl order = new NullOrderImpl();

    CustomerPayment customerPayment = mock(CustomerPayment.class);
    when(customerPayment.getPaymentToken()).thenReturn("ABC123");
    when(customerPayment.getAdditionalFields()).thenReturn(new HashMap<>());
    when(customerPayment.getPaymentGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(customerPayment.getPaymentType()).thenReturn(null);
    when(customerPayment.getBillingAddress()).thenReturn(new AddressImpl());

    // Act
    OrderPayment actualCreateOrderPaymentFromCustomerPaymentResult =
        orderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(
            order, customerPayment, new Money());

    // Assert
    verify(orderPaymentDao).create();
    verify(orderPaymentDao).createTransaction();
    verify(orderPaymentDao).save(isA(OrderPayment.class));
    verify(orderPayment).getTransactions();
    verify(orderPayment).setAmount(isA(Money.class));
    verify(orderPayment).setBillingAddress(isA(Address.class));
    verify(orderPayment).setOrder(isA(Order.class));
    verify(orderPayment).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(orderPayment).setType(isNull());
    verify(customerPayment, atLeast(1)).getAdditionalFields();
    verify(customerPayment).getBillingAddress();
    verify(customerPayment).getPaymentGatewayType();
    verify(customerPayment).getPaymentToken();
    verify(customerPayment).getPaymentType();
    verify(addressService).copyAddress(isA(Address.class));
    assertSame(orderPaymentImpl, actualCreateOrderPaymentFromCustomerPaymentResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order,
   * CustomerPayment, Money)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPayment OrderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)"
  })
  public void testCreateOrderPaymentFromCustomerPayment_givenHashMap() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());

    OrderPayment orderPayment = mock(OrderPayment.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    doNothing().when(orderPayment).setAmount(Mockito.<Money>any());
    doNothing().when(orderPayment).setBillingAddress(Mockito.<Address>any());
    doNothing().when(orderPayment).setOrder(Mockito.<Order>any());
    doNothing().when(orderPayment).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPayment).setType(Mockito.<PaymentType>any());
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(orderPaymentDao.save(Mockito.<OrderPayment>any())).thenReturn(orderPaymentImpl);
    when(orderPaymentDao.createTransaction()).thenReturn(new PaymentTransactionImpl());
    when(orderPaymentDao.create()).thenReturn(orderPayment);
    NullOrderImpl order = new NullOrderImpl();

    CustomerPayment customerPayment = mock(CustomerPayment.class);
    when(customerPayment.getPaymentToken()).thenReturn("ABC123");
    when(customerPayment.getAdditionalFields()).thenReturn(new HashMap<>());
    when(customerPayment.getPaymentGatewayType()).thenReturn(null);
    when(customerPayment.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(customerPayment.getBillingAddress()).thenReturn(new AddressImpl());

    // Act
    OrderPayment actualCreateOrderPaymentFromCustomerPaymentResult =
        orderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(
            order, customerPayment, new Money());

    // Assert
    verify(orderPaymentDao).create();
    verify(orderPaymentDao).createTransaction();
    verify(orderPaymentDao).save(isA(OrderPayment.class));
    verify(orderPayment).getTransactions();
    verify(orderPayment).setAmount(isA(Money.class));
    verify(orderPayment).setBillingAddress(isA(Address.class));
    verify(orderPayment).setOrder(isA(Order.class));
    verify(orderPayment).setPaymentGatewayType(isNull());
    verify(orderPayment).setType(isA(PaymentType.class));
    verify(customerPayment, atLeast(1)).getAdditionalFields();
    verify(customerPayment).getBillingAddress();
    verify(customerPayment).getPaymentGatewayType();
    verify(customerPayment).getPaymentToken();
    verify(customerPayment).getPaymentType();
    verify(addressService).copyAddress(isA(Address.class));
    assertSame(orderPaymentImpl, actualCreateOrderPaymentFromCustomerPaymentResult);
  }

  /**
   * Test {@link OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order,
   * CustomerPayment, Money)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentServiceImpl#createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPayment OrderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(Order, CustomerPayment, Money)"
  })
  public void testCreateOrderPaymentFromCustomerPayment_givenHashMap42Is42() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());

    OrderPayment orderPayment = mock(OrderPayment.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    doNothing().when(orderPayment).setAmount(Mockito.<Money>any());
    doNothing().when(orderPayment).setBillingAddress(Mockito.<Address>any());
    doNothing().when(orderPayment).setOrder(Mockito.<Order>any());
    doNothing().when(orderPayment).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPayment).setType(Mockito.<PaymentType>any());
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(orderPaymentDao.save(Mockito.<OrderPayment>any())).thenReturn(orderPaymentImpl);
    when(orderPaymentDao.createTransaction()).thenReturn(new PaymentTransactionImpl());
    when(orderPaymentDao.create()).thenReturn(orderPayment);
    NullOrderImpl order = new NullOrderImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("42", "42");

    CustomerPayment customerPayment = mock(CustomerPayment.class);
    when(customerPayment.getPaymentToken()).thenReturn("ABC123");
    when(customerPayment.getAdditionalFields()).thenReturn(stringStringMap);
    when(customerPayment.getPaymentGatewayType()).thenReturn(null);
    when(customerPayment.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(customerPayment.getBillingAddress()).thenReturn(new AddressImpl());

    // Act
    OrderPayment actualCreateOrderPaymentFromCustomerPaymentResult =
        orderPaymentServiceImpl.createOrderPaymentFromCustomerPayment(
            order, customerPayment, new Money());

    // Assert
    verify(orderPaymentDao).create();
    verify(orderPaymentDao).createTransaction();
    verify(orderPaymentDao).save(isA(OrderPayment.class));
    verify(orderPayment).getTransactions();
    verify(orderPayment).setAmount(isA(Money.class));
    verify(orderPayment).setBillingAddress(isA(Address.class));
    verify(orderPayment).setOrder(isA(Order.class));
    verify(orderPayment).setPaymentGatewayType(isNull());
    verify(orderPayment).setType(isA(PaymentType.class));
    verify(customerPayment, atLeast(1)).getAdditionalFields();
    verify(customerPayment).getBillingAddress();
    verify(customerPayment).getPaymentGatewayType();
    verify(customerPayment).getPaymentToken();
    verify(customerPayment).getPaymentType();
    verify(addressService).copyAddress(isA(Address.class));
    assertSame(orderPaymentImpl, actualCreateOrderPaymentFromCustomerPaymentResult);
  }

  /**
   * Test {@link
   * OrderPaymentServiceImpl#createCustomerPaymentFromPaymentTransaction(PaymentTransaction)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentServiceImpl#createCustomerPaymentFromPaymentTransaction(PaymentTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment OrderPaymentServiceImpl.createCustomerPaymentFromPaymentTransaction(PaymentTransaction)"
  })
  public void testCreateCustomerPaymentFromPaymentTransaction() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(customerPaymentImpl);
    when(customerPaymentService.create()).thenReturn(new CustomerPaymentImpl());

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getGatewayType()).thenReturn(null);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getOrder()).thenReturn(new NullOrderImpl());

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getAdditionalFields()).thenReturn(new HashMap<>());
    when(transaction.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    CustomerPayment actualCreateCustomerPaymentFromPaymentTransactionResult =
        orderPaymentServiceImpl.createCustomerPaymentFromPaymentTransaction(transaction);

    // Assert
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getOrder();
    verify(orderPaymentImpl).getType();
    verify(transaction, atLeast(1)).getAdditionalFields();
    verify(transaction, atLeast(1)).getOrderPayment();
    verify(addressService).copyAddress(isA(Address.class));
    verify(customerPaymentService).create();
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertSame(customerPaymentImpl, actualCreateCustomerPaymentFromPaymentTransactionResult);
  }

  /**
   * Test {@link
   * OrderPaymentServiceImpl#createCustomerPaymentFromPaymentTransaction(PaymentTransaction)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentServiceImpl#createCustomerPaymentFromPaymentTransaction(PaymentTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment OrderPaymentServiceImpl.createCustomerPaymentFromPaymentTransaction(PaymentTransaction)"
  })
  public void testCreateCustomerPaymentFromPaymentTransaction2() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(customerPaymentImpl);
    when(customerPaymentService.create()).thenReturn(new CustomerPaymentImpl());

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(null);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getOrder()).thenReturn(new NullOrderImpl());

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getAdditionalFields()).thenReturn(new HashMap<>());
    when(transaction.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    CustomerPayment actualCreateCustomerPaymentFromPaymentTransactionResult =
        orderPaymentServiceImpl.createCustomerPaymentFromPaymentTransaction(transaction);

    // Assert
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getOrder();
    verify(orderPaymentImpl).getType();
    verify(transaction, atLeast(1)).getAdditionalFields();
    verify(transaction, atLeast(1)).getOrderPayment();
    verify(addressService).copyAddress(isA(Address.class));
    verify(customerPaymentService).create();
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertSame(customerPaymentImpl, actualCreateCustomerPaymentFromPaymentTransactionResult);
  }

  /**
   * Test {@link
   * OrderPaymentServiceImpl#createCustomerPaymentFromPaymentTransaction(PaymentTransaction)}.
   *
   * <ul>
   *   <li>Then return {@link CustomerPaymentImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentServiceImpl#createCustomerPaymentFromPaymentTransaction(PaymentTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment OrderPaymentServiceImpl.createCustomerPaymentFromPaymentTransaction(PaymentTransaction)"
  })
  public void testCreateCustomerPaymentFromPaymentTransaction_thenReturnCustomerPaymentImpl() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(customerPaymentImpl);
    when(customerPaymentService.create()).thenReturn(new CustomerPaymentImpl());

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getOrder()).thenReturn(new NullOrderImpl());

    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getAdditionalFields()).thenReturn(new HashMap<>());
    when(transaction.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    CustomerPayment actualCreateCustomerPaymentFromPaymentTransactionResult =
        orderPaymentServiceImpl.createCustomerPaymentFromPaymentTransaction(transaction);

    // Assert
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getOrder();
    verify(orderPaymentImpl).getType();
    verify(transaction, atLeast(1)).getAdditionalFields();
    verify(transaction, atLeast(1)).getOrderPayment();
    verify(addressService).copyAddress(isA(Address.class));
    verify(customerPaymentService).create();
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertSame(customerPaymentImpl, actualCreateCustomerPaymentFromPaymentTransactionResult);
  }
}
