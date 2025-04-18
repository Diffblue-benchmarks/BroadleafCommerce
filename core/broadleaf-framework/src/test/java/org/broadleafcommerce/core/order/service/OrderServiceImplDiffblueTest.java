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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Jdk13LumberjackLogger;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.offer.service.exception.OfferAlreadyAddedException;
import org.broadleafcommerce.core.offer.service.exception.OfferException;
import org.broadleafcommerce.core.offer.service.exception.OfferExpiredException;
import org.broadleafcommerce.core.offer.service.exception.OfferMaxUseExceededException;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderFactory;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.GiftWrapOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.exception.UpdateCartException;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDao;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.secure.Referenced;
import org.broadleafcommerce.core.payment.service.SecureOrderPaymentService;
import org.broadleafcommerce.core.pricing.service.PricingService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.workflow.Processor;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionStatus;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderServiceImplDiffblueTest {
  @Mock
  private CustomerService customerService;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @Mock
  private MergeCartService mergeCartService;

  @Mock
  private NullOrderFactory nullOrderFactory;

  @Mock
  private OfferDao offerDao;

  @Mock
  private OfferService offerService;

  @Mock
  private OrderDao orderDao;

  @Mock
  private OrderItemService orderItemService;

  @Mock
  private OrderMultishipOptionService orderMultishipOptionService;

  @Mock
  private OrderPaymentDao orderPaymentDao;

  @Mock
  private OrderServiceExtensionManager orderServiceExtensionManager;

  @InjectMocks
  private OrderServiceImpl orderServiceImpl;

  @Mock
  private PlatformTransactionManager platformTransactionManager;

  @Mock
  private PricingService pricingService;

  @Mock
  private Processor processor;

  @Mock
  private SecureOrderPaymentService secureOrderPaymentService;

  /**
   * Test {@link OrderServiceImpl#createNewCartForCustomer(Customer)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getId()} return one.</li>
   *   <li>Then calls {@link CustomerImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.createNewCartForCustomer(Customer)"})
  public void testCreateNewCartForCustomer_givenCustomerImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(customerImpl);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualCreateNewCartForCustomerResult = orderServiceImpl.createNewCartForCustomer(new CustomerImpl());

    // Assert
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(customerImpl, atLeast(1)).getId();
    verify(customerService).saveCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualCreateNewCartForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#createNewCartForCustomer(Customer)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.createNewCartForCustomer(Customer)"})
  public void testCreateNewCartForCustomer_thenReturnNullOrderImpl() {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualCreateNewCartForCustomerResult = orderServiceImpl.createNewCartForCustomer(new CustomerImpl());

    // Assert
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(customerService).saveCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualCreateNewCartForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#createNewCartForCustomer(Customer)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.createNewCartForCustomer(Customer)"})
  public void testCreateNewCartForCustomer_thenThrowRuntimeException() {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.createNewCartForCustomer(new CustomerImpl()));
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(customerService).saveCustomer(isA(Customer.class));
  }

  /**
   * Test {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.createNamedOrderForCustomer(String, Customer)"})
  public void testCreateNamedOrderForCustomer() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new OrderServiceExtensionManager());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("NullOrder does not support any modification operations.");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    when(orderDao.create()).thenReturn(orderImpl);

    // Act
    Order actualCreateNamedOrderForCustomerResult = orderServiceImpl.createNamedOrderForCustomer("Name",
        new CustomerImpl());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).create();
    verify(orderDao).save(isA(Order.class));
    assertSame(nullOrderImpl, actualCreateNamedOrderForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.createNamedOrderForCustomer(String, Customer)"})
  public void testCreateNamedOrderForCustomer_thenReturnNullOrderImpl() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("NullOrder does not support any modification operations.");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    when(orderDao.create()).thenReturn(orderImpl);

    // Act
    Order actualCreateNamedOrderForCustomerResult = orderServiceImpl.createNamedOrderForCustomer("Name",
        new CustomerImpl());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).create();
    verify(orderDao).save(isA(Order.class));
    assertSame(nullOrderImpl, actualCreateNamedOrderForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.createNamedOrderForCustomer(String, Customer)"})
  public void testCreateNamedOrderForCustomer_thenThrowRuntimeException() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("NullOrder does not support any modification operations.");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new RuntimeException("foo"));
    when(orderDao.create()).thenReturn(orderImpl);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.createNamedOrderForCustomer("Name", new CustomerImpl()));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).create();
    verify(orderDao).save(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findNamedOrderForCustomer(String, Customer)"})
  public void testFindNamedOrderForCustomer_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readNamedOrderForCustomer(Mockito.<Customer>any(), Mockito.<String>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindNamedOrderForCustomerResult = orderServiceImpl.findNamedOrderForCustomer("Name",
        new CustomerImpl());

    // Assert
    verify(orderDao).readNamedOrderForCustomer(isA(Customer.class), eq("Name"));
    assertSame(nullOrderImpl, actualFindNamedOrderForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findNamedOrderForCustomer(String, Customer)"})
  public void testFindNamedOrderForCustomer_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readNamedOrderForCustomer(Mockito.<Customer>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findNamedOrderForCustomer("Name", new CustomerImpl()));
    verify(orderDao).readNamedOrderForCustomer(isA(Customer.class), eq("Name"));
  }

  /**
   * Test {@link OrderServiceImpl#findOrderById(Long, boolean)} with {@code orderId}, {@code refresh}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrderById(Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderById(Long, boolean)"})
  public void testFindOrderByIdWithOrderIdRefresh_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindOrderByIdResult = orderServiceImpl.findOrderById(1L, true);

    // Assert
    verify(orderDao).readOrderById(eq(1L), eq(true));
    assertSame(nullOrderImpl, actualFindOrderByIdResult);
  }

  /**
   * Test {@link OrderServiceImpl#findOrderById(Long, boolean)} with {@code orderId}, {@code refresh}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrderById(Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderById(Long, boolean)"})
  public void testFindOrderByIdWithOrderIdRefresh_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any(), anyBoolean())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrderById(1L, true));
    verify(orderDao).readOrderById(eq(1L), eq(true));
  }

  /**
   * Test {@link OrderServiceImpl#findOrderById(Long)} with {@code orderId}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrderById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderById(Long)"})
  public void testFindOrderByIdWithOrderId_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindOrderByIdResult = orderServiceImpl.findOrderById(1L);

    // Assert
    verify(orderDao).readOrderById(eq(1L));
    assertSame(nullOrderImpl, actualFindOrderByIdResult);
  }

  /**
   * Test {@link OrderServiceImpl#findOrderById(Long)} with {@code orderId}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrderById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderById(Long)"})
  public void testFindOrderByIdWithOrderId_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrderById(1L));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#getNullOrder()}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#getNullOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.getNullOrder()"})
  public void testGetNullOrder_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(nullOrderFactory.getNullOrder()).thenReturn(nullOrderImpl);

    // Act
    Order actualNullOrder = orderServiceImpl.getNullOrder();

    // Assert
    verify(nullOrderFactory).getNullOrder();
    assertSame(nullOrderImpl, actualNullOrder);
  }

  /**
   * Test {@link OrderServiceImpl#getNullOrder()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#getNullOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.getNullOrder()"})
  public void testGetNullOrder_thenThrowRuntimeException() {
    // Arrange
    when(nullOrderFactory.getNullOrder()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.getNullOrder());
    verify(nullOrderFactory).getNullOrder();
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByIds(List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByIds(List)"})
  public void testFindOrdersByIds_givenOne_whenArrayListAddOne_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> orderIds = new ArrayList<>();
    orderIds.add(1L);

    // Act
    List<Order> actualFindOrdersByIdsResult = orderServiceImpl.findOrdersByIds(orderIds);

    // Assert
    verify(orderDao).readOrdersByIds(isA(List.class));
    assertTrue(actualFindOrdersByIdsResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByIds(List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByIds(List)"})
  public void testFindOrdersByIds_givenZero_whenArrayListAddZero_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> orderIds = new ArrayList<>();
    orderIds.add(0L);
    orderIds.add(1L);

    // Act
    List<Order> actualFindOrdersByIdsResult = orderServiceImpl.findOrdersByIds(orderIds);

    // Assert
    verify(orderDao).readOrdersByIds(isA(List.class));
    assertTrue(actualFindOrdersByIdsResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByIds(List)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByIds(List)"})
  public void testFindOrdersByIds_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersByIds(Mockito.<List<Long>>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrdersByIds(new ArrayList<>()));
    verify(orderDao).readOrdersByIds(isA(List.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByIds(List)"})
  public void testFindOrdersByIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    // Act
    List<Order> actualFindOrdersByIdsResult = orderServiceImpl.findOrdersByIds(new ArrayList<>());

    // Assert
    verify(orderDao).readOrdersByIds(isA(List.class));
    assertTrue(actualFindOrdersByIdsResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomer(Customer)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findCartForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomer(Customer)"})
  public void testFindCartForCustomer_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindCartForCustomerResult = orderServiceImpl.findCartForCustomer(new CustomerImpl());

    // Assert
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualFindCartForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomer(Customer)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findCartForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomer(Customer)"})
  public void testFindCartForCustomer_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findCartForCustomer(new CustomerImpl()));
    verify(orderDao).readCartForCustomer(isA(Customer.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomer(Customer, OrderStatus)} with {@code customer}, {@code status}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersForCustomer(Customer, OrderStatus)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomer(Customer, OrderStatus)"})
  public void testFindOrdersForCustomerWithCustomerStatus_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersForCustomer(Mockito.<Customer>any(), Mockito.<OrderStatus>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Order> actualFindOrdersForCustomerResult = orderServiceImpl.findOrdersForCustomer(new CustomerImpl(),
        OrderStatus.ARCHIVED);

    // Assert
    verify(orderDao).readOrdersForCustomer(isA(Customer.class), isA(OrderStatus.class));
    assertTrue(actualFindOrdersForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomer(Customer, OrderStatus)} with {@code customer}, {@code status}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersForCustomer(Customer, OrderStatus)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomer(Customer, OrderStatus)"})
  public void testFindOrdersForCustomerWithCustomerStatus_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersForCustomer(Mockito.<Customer>any(), Mockito.<OrderStatus>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.findOrdersForCustomer(new CustomerImpl(), OrderStatus.ARCHIVED));
    verify(orderDao).readOrdersForCustomer(isA(Customer.class), isA(OrderStatus.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomer(Customer)"})
  public void testFindOrdersForCustomerWithCustomer_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersForCustomer(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<Order> actualFindOrdersForCustomerResult = orderServiceImpl.findOrdersForCustomer(new CustomerImpl());

    // Assert
    verify(orderDao).readOrdersForCustomer(isNull());
    assertTrue(actualFindOrdersForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomer(Customer)"})
  public void testFindOrdersForCustomerWithCustomer_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersForCustomer(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrdersForCustomer(new CustomerImpl()));
    verify(orderDao).readOrdersForCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#findOrderByOrderNumber(String)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrderByOrderNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderByOrderNumber(String)"})
  public void testFindOrderByOrderNumber_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderByOrderNumber(Mockito.<String>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindOrderByOrderNumberResult = orderServiceImpl.findOrderByOrderNumber("42");

    // Assert
    verify(orderDao).readOrderByOrderNumber(eq("42"));
    assertSame(nullOrderImpl, actualFindOrderByOrderNumberResult);
  }

  /**
   * Test {@link OrderServiceImpl#findOrderByOrderNumber(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrderByOrderNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderByOrderNumber(String)"})
  public void testFindOrderByOrderNumber_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrderByOrderNumber(Mockito.<String>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrderByOrderNumber("42"));
    verify(orderDao).readOrderByOrderNumber(eq("42"));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByDateRange(Date, Date)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByDateRange(Date, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByDateRange(Date, Date)"})
  public void testFindOrdersByDateRange_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersByDateRange(Mockito.<Date>any(), Mockito.<Date>any())).thenReturn(new ArrayList<>());
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Order> actualFindOrdersByDateRangeResult = orderServiceImpl.findOrdersByDateRange(startDate,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderDao).readOrdersByDateRange(isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrdersByDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByDateRange(Date, Date)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByDateRange(Date, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByDateRange(Date, Date)"})
  public void testFindOrdersByDateRange_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersByDateRange(Mockito.<Date>any(), Mockito.<Date>any()))
        .thenThrow(new RuntimeException("foo"));
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrdersByDateRange(startDate,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    verify(orderDao).readOrdersByDateRange(isA(Date.class), isA(Date.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByDaysCount(Integer, Integer)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByDaysCount(Integer, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByDaysCount(Integer, Integer)"})
  public void testFindOrdersByDaysCount_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersOlderThanDaysCount(Mockito.<Integer>any(), Mockito.<Integer>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Order> actualFindOrdersByDaysCountResult = orderServiceImpl.findOrdersByDaysCount(3, 3);

    // Assert
    verify(orderDao).readOrdersOlderThanDaysCount(eq(3), eq(3));
    assertTrue(actualFindOrdersByDaysCountResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByDaysCount(Integer, Integer)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByDaysCount(Integer, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByDaysCount(Integer, Integer)"})
  public void testFindOrdersByDaysCount_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersOlderThanDaysCount(Mockito.<Integer>any(), Mockito.<Integer>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrdersByDaysCount(3, 3));
    verify(orderDao).readOrdersOlderThanDaysCount(eq(3), eq(3));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrdersForCustomersInDateRange_givenOne_whenArrayListAddOne() {
    // Arrange
    when(
        orderDao.readOrdersForCustomersInDateRange(Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> customerIds = new ArrayList<>();
    customerIds.add(1L);
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Order> actualFindOrdersForCustomersInDateRangeResult = orderServiceImpl.findOrdersForCustomersInDateRange(
        customerIds, startDate, Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderDao).readOrdersForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrdersForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrdersForCustomersInDateRange_givenZero_whenArrayListAddZero() {
    // Arrange
    when(
        orderDao.readOrdersForCustomersInDateRange(Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> customerIds = new ArrayList<>();
    customerIds.add(0L);
    customerIds.add(1L);
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Order> actualFindOrdersForCustomersInDateRangeResult = orderServiceImpl.findOrdersForCustomersInDateRange(
        customerIds, startDate, Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderDao).readOrdersForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrdersForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrdersForCustomersInDateRange_thenThrowRuntimeException() {
    // Arrange
    when(
        orderDao.readOrdersForCustomersInDateRange(Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenThrow(new RuntimeException("foo"));
    ArrayList<Long> customerIds = new ArrayList<>();
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrdersForCustomersInDateRange(customerIds,
        startDate, Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    verify(orderDao).readOrdersForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrdersForCustomersInDateRange_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(
        orderDao.readOrdersForCustomersInDateRange(Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> customerIds = new ArrayList<>();
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Order> actualFindOrdersForCustomersInDateRangeResult = orderServiceImpl.findOrdersForCustomersInDateRange(
        customerIds, startDate, Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderDao).readOrdersForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrdersForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findPaymentsForOrder(Order)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findPaymentsForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findPaymentsForOrder(Order)"})
  public void testFindPaymentsForOrder_thenReturnEmpty() {
    // Arrange
    when(orderPaymentDao.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    List<OrderPayment> actualFindPaymentsForOrderResult = orderServiceImpl.findPaymentsForOrder(new NullOrderImpl());

    // Assert
    verify(orderPaymentDao).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualFindPaymentsForOrderResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findPaymentsForOrder(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findPaymentsForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findPaymentsForOrder(Order)"})
  public void testFindPaymentsForOrder_thenThrowRuntimeException() {
    // Arrange
    when(orderPaymentDao.readPaymentsForOrder(Mockito.<Order>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findPaymentsForOrder(new NullOrderImpl()));
    verify(orderPaymentDao).readPaymentsForOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment, Referenced)}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) Payments size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment, Referenced)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPayment OrderServiceImpl.addPaymentToOrder(Order, OrderPayment, Referenced)"})
  public void testAddPaymentToOrder_thenOrderImplPaymentsSizeIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    payments.add(orderPaymentImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(payments);
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderDao.save(Mockito.<Order>any())).thenReturn(orderImpl);
    when(secureOrderPaymentService.save(Mockito.<Referenced>any())).thenReturn(mock(Referenced.class));

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    ArrayList<OrderPayment> payments2 = new ArrayList<>();
    order.setPayments(payments2);
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    OrderPayment actualAddPaymentToOrderResult = orderServiceImpl.addPaymentToOrder(order, new OrderPaymentImpl(),
        mock(Referenced.class));

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(secureOrderPaymentService).save(isA(Referenced.class));
    List<OrderPayment> payments3 = order.getPayments();
    assertEquals(1, payments3.size());
    assertSame(payments2, payments3);
    assertSame(orderPaymentImpl, actualAddPaymentToOrderResult);
  }

  /**
   * Test {@link OrderServiceImpl#save(Order, Boolean)} with {@code order}, {@code priceOrder}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#save(Order, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.save(Order, Boolean)"})
  public void testSaveWithOrderPriceOrder_whenFalse_thenReturnNullOrderImpl()
      throws PricingException, TransactionException {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    DefaultTransactionStatus defaultTransactionStatus = mock(DefaultTransactionStatus.class);
    when(defaultTransactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(defaultTransactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act
    Order actualSaveResult = orderServiceImpl.save(new NullOrderImpl(), false);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(defaultTransactionStatus).isRollbackOnly();
    assertSame(nullOrderImpl, actualSaveResult);
  }

  /**
   * Test {@link OrderServiceImpl#persist(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} return {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#persist(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.persist(Order)"})
  public void testPersist_givenOrderDaoSaveReturnNullOrderImpl_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualPersistResult = orderServiceImpl.persist(new NullOrderImpl());

    // Assert
    verify(orderDao).save(isA(Order.class));
    assertSame(nullOrderImpl, actualPersistResult);
  }

  /**
   * Test {@link OrderServiceImpl#persist(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#persist(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.persist(Order)"})
  public void testPersist_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.persist(new NullOrderImpl()));
    verify(orderDao).save(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#cancelOrder(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#delete(Order)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#cancelOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.cancelOrder(Order)"})
  public void testCancelOrder_givenOrderDaoDeleteDoesNothing() {
    // Arrange
    doNothing().when(orderDao).delete(Mockito.<Order>any());

    // Act
    orderServiceImpl.cancelOrder(new NullOrderImpl());

    // Assert
    verify(orderDao).delete(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#cancelOrder(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#cancelOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.cancelOrder(Order)"})
  public void testCancelOrder_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException("foo")).when(orderDao).delete(Mockito.<Order>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.cancelOrder(new NullOrderImpl()));
    verify(orderDao).delete(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#deleteOrder(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#delete(Order)} does nothing.</li>
   *   <li>Then calls {@link OrderDao#delete(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#deleteOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.deleteOrder(Order)"})
  public void testDeleteOrder_givenOrderDaoDeleteDoesNothing_thenCallsDelete() {
    // Arrange
    doNothing().when(orderDao).delete(Mockito.<Order>any());
    doNothing().when(orderMultishipOptionService).deleteAllOrderMultishipOptions(Mockito.<Order>any());

    // Act
    orderServiceImpl.deleteOrder(new NullOrderImpl());

    // Assert
    verify(orderDao).delete(isA(Order.class));
    verify(orderMultishipOptionService).deleteAllOrderMultishipOptions(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#deleteOrder(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#deleteOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.deleteOrder(Order)"})
  public void testDeleteOrder_givenOrderDao_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException("foo")).when(orderMultishipOptionService)
        .deleteAllOrderMultishipOptions(Mockito.<Order>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.deleteOrder(new NullOrderImpl()));
    verify(orderMultishipOptionService).deleteAllOrderMultishipOptions(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link OfferCodeImpl} {@link OfferCodeImpl#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_givenFalse_whenOfferCodeImplIsActiveReturnFalse()
      throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.verifyMaxCustomerUsageThreshold(Mockito.<Order>any(), Mockito.<OfferCode>any())).thenReturn(true);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    OrderImpl order = new OrderImpl();
    OfferCodeImpl offerCode = mock(OfferCodeImpl.class);
    when(offerCode.isActive()).thenReturn(false);
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(OfferExpiredException.class, () -> orderServiceImpl.addOfferCode(order, offerCode, true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerCode).getOffer();
    verify(offerCode).isActive();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(offerService).verifyMaxCustomerUsageThreshold(isA(Order.class), isA(OfferCode.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link OfferImpl} (default constructor).</li>
   *   <li>Then throw {@link OfferAlreadyAddedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_givenHashSetAddOfferImpl_thenThrowOfferAlreadyAddedException()
      throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());

    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(new OfferImpl());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);
    OrderImpl order = new OrderImpl();
    OfferCodeImpl offerCode = mock(OfferCodeImpl.class);
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(OfferAlreadyAddedException.class, () -> orderServiceImpl.addOfferCode(order, offerCode, true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerCode).getOffer();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>When {@link OrderImpl} (default constructor) addAddedOfferCode {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_givenOfferCodeImpl_whenOrderImplAddAddedOfferCodeOfferCodeImpl()
      throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());

    // Act and Assert
    assertThrows(OfferAlreadyAddedException.class,
        () -> orderServiceImpl.addOfferCode(order, new OfferCodeImpl(), true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then throw {@link OfferExpiredException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_givenOfferImpl_thenThrowOfferExpiredException() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.verifyMaxCustomerUsageThreshold(Mockito.<Order>any(), Mockito.<OfferCode>any())).thenReturn(true);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    OrderImpl order = new OrderImpl();
    OfferCodeImpl offerCode = mock(OfferCodeImpl.class);
    when(offerCode.isActive()).thenReturn(true);
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(OfferExpiredException.class, () -> orderServiceImpl.addOfferCode(order, offerCode, true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerCode, atLeast(1)).getOffer();
    verify(offerCode).isActive();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(offerService).verifyMaxCustomerUsageThreshold(isA(Order.class), isA(OfferCode.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   * <ul>
   *   <li>Then throw {@link OfferMaxUseExceededException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_thenThrowOfferMaxUseExceededException() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.verifyMaxCustomerUsageThreshold(Mockito.<Order>any(), Mockito.<OfferCode>any()))
        .thenReturn(false);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    OrderImpl order = new OrderImpl();
    OfferCodeImpl offerCode = mock(OfferCodeImpl.class);
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(OfferMaxUseExceededException.class, () -> orderServiceImpl.addOfferCode(order, offerCode, true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerCode).getOffer();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(offerService).verifyMaxCustomerUsageThreshold(isA(Order.class), isA(OfferCode.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_thenThrowRuntimeException() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenThrow(new RuntimeException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.addOfferCode(order, new OfferCodeImpl(), true));
    verify(orderServiceExtensionManager).getProxy();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new OrderServiceExtensionManager());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualAddOfferCodesResult = orderServiceImpl.addOfferCodes(order, new ArrayList<>(), true);

    // Assert
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    assertSame(order, actualAddOfferCodesResult);
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes_thenThrowRuntimeException() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenThrow(new RuntimeException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.addOfferCodes(order, new ArrayList<>(), true));
    verify(orderServiceExtensionManager).getProxy();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes_whenArrayList_thenReturnNullOrderImpl() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualAddOfferCodesResult = orderServiceImpl.addOfferCodes(order, new ArrayList<>(), true);

    // Assert
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    assertSame(order, actualAddOfferCodesResult);
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenArrayListAddBundleOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(orderItems);
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

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(order, 1L, 1L));
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenAuditableCreatedByIsOne() {
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
    order.setCurrency(new BroadleafCurrencyImpl());
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

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(order, 1L, 1L));
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_whenNullOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(new NullOrderImpl(), 1L, 1L));
  }

  /**
   * Test {@link OrderServiceImpl#confirmOrder(Order)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#confirmOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.confirmOrder(Order)"})
  public void testConfirmOrder_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.submitOrder(Mockito.<Order>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualConfirmOrderResult = orderServiceImpl.confirmOrder(new NullOrderImpl());

    // Assert
    verify(orderDao).submitOrder(isA(Order.class));
    assertSame(nullOrderImpl, actualConfirmOrderResult);
  }

  /**
   * Test {@link OrderServiceImpl#confirmOrder(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#confirmOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.confirmOrder(Order)"})
  public void testConfirmOrder_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.submitOrder(Mockito.<Order>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.confirmOrder(new NullOrderImpl()));
    verify(orderDao).submitOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}.
   * <ul>
   *   <li>Given {@link CustomerService}.</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addAllItemsFromNamedOrder(Order, boolean)"})
  public void testAddAllItemsFromNamedOrder_givenCustomerService_thenReturnNullOrderImpl()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    doNothing().when(orderDao).delete(Mockito.<Order>any());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl namedOrder = new OrderImpl();
    namedOrder.setAdditionalOfferInformation(new HashMap<>());
    namedOrder.setAuditable(auditable);
    namedOrder.setCandidateOrderOffers(new ArrayList<>());
    namedOrder.setCurrency(new BroadleafCurrencyImpl());
    namedOrder.setCustomer(new CustomerImpl());
    namedOrder.setEmailAddress("42 Main St");
    namedOrder.setFulfillmentGroups(new ArrayList<>());
    namedOrder.setId(1L);
    namedOrder.setLocale(new LocaleImpl());
    namedOrder.setName("Name");
    namedOrder.setOrderAttributes(new HashMap<>());
    namedOrder.setOrderItems(new ArrayList<>());
    namedOrder.setOrderMessages(new ArrayList<>());
    namedOrder.setOrderNumber("42");
    namedOrder.setPayments(new ArrayList<>());
    namedOrder.setStatus(OrderStatus.ARCHIVED);
    namedOrder.setSubTotal(new Money());
    namedOrder.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    namedOrder.setTaxOverride(true);
    namedOrder.setTotal(new Money());
    namedOrder.setTotalFulfillmentCharges(new Money());
    namedOrder.setTotalTax(new Money());

    // Act
    Order actualAddAllItemsFromNamedOrderResult = orderServiceImpl.addAllItemsFromNamedOrder(namedOrder, true);

    // Assert
    verify(orderDao).delete(isA(Order.class));
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualAddAllItemsFromNamedOrderResult);
  }

  /**
   * Test {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}.
   * <ul>
   *   <li>Then calls {@link Order#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addAllItemsFromNamedOrder(Order, boolean)"})
  public void testAddAllItemsFromNamedOrder_thenCallsGetId() throws AddToCartException, RemoveFromCartException {
    // Arrange
    Order order = mock(Order.class);
    when(order.getId()).thenThrow(new RuntimeException("foo"));
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(order);
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new OrderItemRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl namedOrder = new OrderImpl();
    namedOrder.setAdditionalOfferInformation(new HashMap<>());
    namedOrder.setAuditable(auditable);
    namedOrder.setCandidateOrderOffers(new ArrayList<>());
    namedOrder.setCurrency(new BroadleafCurrencyImpl());
    namedOrder.setCustomer(new CustomerImpl());
    namedOrder.setEmailAddress("42 Main St");
    namedOrder.setFulfillmentGroups(new ArrayList<>());
    namedOrder.setId(1L);
    namedOrder.setLocale(new LocaleImpl());
    namedOrder.setName("Name");
    namedOrder.setOrderAttributes(new HashMap<>());
    namedOrder.setOrderItems(orderItems);
    namedOrder.setOrderMessages(new ArrayList<>());
    namedOrder.setOrderNumber("42");
    namedOrder.setPayments(new ArrayList<>());
    namedOrder.setStatus(OrderStatus.ARCHIVED);
    namedOrder.setSubTotal(new Money());
    namedOrder.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    namedOrder.setTaxOverride(true);
    namedOrder.setTotal(new Money());
    namedOrder.setTotalFulfillmentCharges(new Money());
    namedOrder.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.addAllItemsFromNamedOrder(namedOrder, true));
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    verify(order).getId();
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}.
   * <ul>
   *   <li>Then calls {@link OrderDao#readOrderById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addAllItemsFromNamedOrder(Order, boolean)"})
  public void testAddAllItemsFromNamedOrder_thenCallsReadOrderById()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new OrderItemRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl namedOrder = new OrderImpl();
    namedOrder.setAdditionalOfferInformation(new HashMap<>());
    namedOrder.setAuditable(auditable);
    namedOrder.setCandidateOrderOffers(new ArrayList<>());
    namedOrder.setCurrency(new BroadleafCurrencyImpl());
    namedOrder.setCustomer(new CustomerImpl());
    namedOrder.setEmailAddress("42 Main St");
    namedOrder.setFulfillmentGroups(new ArrayList<>());
    namedOrder.setId(1L);
    namedOrder.setLocale(new LocaleImpl());
    namedOrder.setName("Name");
    namedOrder.setOrderAttributes(new HashMap<>());
    namedOrder.setOrderItems(orderItems);
    namedOrder.setOrderMessages(new ArrayList<>());
    namedOrder.setOrderNumber("42");
    namedOrder.setPayments(new ArrayList<>());
    namedOrder.setStatus(OrderStatus.ARCHIVED);
    namedOrder.setSubTotal(new Money());
    namedOrder.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    namedOrder.setTaxOverride(true);
    namedOrder.setTotal(new Money());
    namedOrder.setTotalFulfillmentCharges(new Money());
    namedOrder.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.addAllItemsFromNamedOrder(namedOrder, true));
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    verify(orderDao).readOrderById(isNull());
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addAllItemsFromNamedOrder(Order, boolean)"})
  public void testAddAllItemsFromNamedOrder_thenThrowIllegalArgumentException()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> orderServiceImpl.addAllItemsFromNamedOrder(new NullOrderImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code namedOrder}, {@code item}, {@code priceOrder}.
   * <ul>
   *   <li>Then calls {@link Order#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder_thenCallsGetId()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    Order order = mock(Order.class);
    when(order.getId()).thenThrow(new RuntimeException("foo"));
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(order);
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new OrderItemRequestDTO());
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(order).getId();
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code namedOrder}, {@code item}, {@code priceOrder}.
   * <ul>
   *   <li>Then calls {@link OrderDao#readOrderById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder_thenCallsReadOrderById()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new OrderItemRequestDTO());
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(orderDao).readOrderById(isNull());
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), 2, true));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder_whenZero()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), 0, true));
  }

  /**
   * Test {@link OrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderServiceImpl.addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)"})
  public void testAddGiftWrapItemToOrder_thenThrowRuntimeException() throws PricingException {
    // Arrange
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenThrow(new RuntimeException("foo"));
    when(orderItemService.createGiftWrapOrderItem(Mockito.<GiftWrapOrderItemRequest>any()))
        .thenReturn(new GiftWrapOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.addGiftWrapItemToOrder(order, new GiftWrapOrderItemRequest(), true));
    verify(orderItemService).createGiftWrapOrderItem(isA(GiftWrapOrderItemRequest.class));
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addItem(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItem_thenThrowRuntimeException() throws AddToCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.addItem(1L, new OrderItemRequestDTO(), true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#addItemWithPriceOverrides(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addItemWithPriceOverrides(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.addItemWithPriceOverrides(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemWithPriceOverrides_thenThrowRuntimeException() throws AddToCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.addItemWithPriceOverrides(1L, new OrderItemRequestDTO(), true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#getTotalChildOrderItems(OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#getTotalChildOrderItems(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OrderServiceImpl.getTotalChildOrderItems(OrderItemRequestDTO)"})
  public void testGetTotalChildOrderItems_givenArrayListAddOrderItemRequestDTO_thenReturnTwo() {
    // Arrange
    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(new OrderItemRequestDTO());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(childOrderItems);
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Pricing Model Type");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertEquals(2, orderServiceImpl.getTotalChildOrderItems(orderItemRequestDTO));
  }

  /**
   * Test {@link OrderServiceImpl#getTotalChildOrderItems(OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#getTotalChildOrderItems(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OrderServiceImpl.getTotalChildOrderItems(OrderItemRequestDTO)"})
  public void testGetTotalChildOrderItems_whenOrderItemRequestDTO_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, orderServiceImpl.getTotalChildOrderItems(new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)}.
   * <ul>
   *   <li>Then {@link OrderItemRequestDTO#OrderItemRequestDTO()} ChildOrderItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)"})
  public void testAddDependentOrderItem_thenOrderItemRequestDTOChildOrderItemsSizeIsOne() {
    // Arrange
    OrderItemRequestDTO parentOrderItemRequest = new OrderItemRequestDTO();
    OrderItemRequestDTO dependentOrderItem = new OrderItemRequestDTO();

    // Act
    orderServiceImpl.addDependentOrderItem(parentOrderItemRequest, dependentOrderItem);

    // Assert
    List<OrderItemRequestDTO> childOrderItems = parentOrderItemRequest.getChildOrderItems();
    assertEquals(1, childOrderItems.size());
    assertSame(dependentOrderItem, childOrderItems.get(0));
  }

  /**
   * Test {@link OrderServiceImpl#updateItemQuantity(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#updateItemQuantity(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.updateItemQuantity(Long, OrderItemRequestDTO, boolean)"})
  public void testUpdateItemQuantity_givenOrderDaoReadOrderByIdThrowRuntimeExceptionWithFoo()
      throws RemoveFromCartException, UpdateCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.updateItemQuantity(1L, new OrderItemRequestDTO(), true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#updateItemQuantity(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#updateItemQuantity(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.updateItemQuantity(Long, OrderItemRequestDTO, boolean)"})
  public void testUpdateItemQuantity_thenCallsGetDiscreteOrderItems()
      throws RemoveFromCartException, UpdateCartException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new RuntimeException("foo"));
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(0);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.updateItemQuantity(1L, orderItemRequestDTO, true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderDao, atLeast(1)).readOrderById(eq(1L));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(orderItemService).readOrderItemById(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#updateItemQuantity(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then throw {@link RemoveFromCartException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#updateItemQuantity(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.updateItemQuantity(Long, OrderItemRequestDTO, boolean)"})
  public void testUpdateItemQuantity_thenThrowRemoveFromCartException()
      throws RemoveFromCartException, UpdateCartException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(null);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(0);

    // Act and Assert
    assertThrows(RemoveFromCartException.class,
        () -> orderServiceImpl.updateItemQuantity(1L, orderItemRequestDTO, true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(orderDao, atLeast(1)).readOrderById(eq(1L));
    verify(orderItemService).readOrderItemById(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#removeItem(Long, Long, boolean)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#removeItem(Long, Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeItem(Long, Long, boolean)"})
  public void testRemoveItem() throws RemoveFromCartException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenThrow(new RuntimeException("Could not remove from cart"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.removeItem(1L, 1L, true));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#removeItem(Long, Long, boolean)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#removeItem(Long, Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeItem(Long, Long, boolean)"})
  public void testRemoveItem2() throws RemoveFromCartException {
    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager2.addOfferCodes(order, new ArrayList<>(), false);
    when(orderServiceExtensionManager.getProxy()).thenReturn(orderServiceExtensionManager2);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new RuntimeException("foo"));
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.removeItem(1L, 1L, true));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).readOrderById(eq(1L));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#removeItem(Long, Long, boolean)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#removeItem(Long, Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeItem(Long, Long, boolean)"})
  public void testRemoveItem3() throws RemoveFromCartException {
    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    orderServiceExtensionManager2.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager2.addOfferCodes(order, new ArrayList<>(), false);
    when(orderServiceExtensionManager.getProxy()).thenReturn(orderServiceExtensionManager2);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new RuntimeException("foo"));
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.removeItem(1L, 1L, true));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).readOrderById(eq(1L));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#removeItem(Long, Long, boolean)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeItem(Long, Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeItem(Long, Long, boolean)"})
  public void testRemoveItem_thenCallsGetDiscreteOrderItems() throws RemoveFromCartException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new RuntimeException("foo"));
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.removeItem(1L, 1L, true));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).readOrderById(eq(1L));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#removeItem(Long, Long, boolean)}.
   * <ul>
   *   <li>Then throw {@link RemoveFromCartException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeItem(Long, Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeItem(Long, Long, boolean)"})
  public void testRemoveItem_thenThrowRemoveFromCartException() throws RemoveFromCartException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(RemoveFromCartException.class, () -> orderServiceImpl.removeItem(1L, 1L, true));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.findAllChildrenToRemove(List, OrderItem)"})
  public void testFindAllChildrenToRemove_givenAuditableCreatedByIsOne_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setChildOrderItems(childOrderItems);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(1, childrenToRemove.size());
    assertEquals(1L, childrenToRemove.get(0).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.findAllChildrenToRemove(List, OrderItem)"})
  public void testFindAllChildrenToRemove_thenArrayListSizeIsFour() {
    // Arrange
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    Auditable auditable5 = new Auditable();
    auditable5.setCreatedBy(1L);
    auditable5.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable5);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable4);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl bundleOrderItemImpl3 = new BundleOrderItemImpl();
    bundleOrderItemImpl3.setAuditable(auditable3);
    bundleOrderItemImpl3.setBaseRetailPrice(new Money());
    bundleOrderItemImpl3.setBaseSalePrice(new Money());
    bundleOrderItemImpl3.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl3.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl3.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl3.setDiscountingAllowed(true);
    bundleOrderItemImpl3.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl3.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl3.setHasValidationError(true);
    bundleOrderItemImpl3.setId(1L);
    bundleOrderItemImpl3.setName("Name");
    bundleOrderItemImpl3.setOrder(new NullOrderImpl());
    bundleOrderItemImpl3.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl3.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl3.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl3.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl3.setPrice(new Money());
    bundleOrderItemImpl3.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setQuantity(1);
    bundleOrderItemImpl3.setRetailPrice(new Money());
    bundleOrderItemImpl3.setRetailPriceOverride(true);
    bundleOrderItemImpl3.setSalePrice(new Money());
    bundleOrderItemImpl3.setSalePriceOverride(true);
    bundleOrderItemImpl3.setTaxable(true);
    bundleOrderItemImpl3.updateSaleAndRetailPrices();
    bundleOrderItemImpl3.setChildOrderItems(childOrderItems2);

    ArrayList<OrderItem> childOrderItems3 = new ArrayList<>();
    childOrderItems3.add(bundleOrderItemImpl3);

    BundleOrderItemImpl bundleOrderItemImpl4 = new BundleOrderItemImpl();
    bundleOrderItemImpl4.setAuditable(auditable2);
    bundleOrderItemImpl4.setBaseRetailPrice(new Money());
    bundleOrderItemImpl4.setBaseSalePrice(new Money());
    bundleOrderItemImpl4.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl4.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl4.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl4.setDiscountingAllowed(true);
    bundleOrderItemImpl4.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl4.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl4.setHasValidationError(true);
    bundleOrderItemImpl4.setId(1L);
    bundleOrderItemImpl4.setName("Name");
    bundleOrderItemImpl4.setOrder(new NullOrderImpl());
    bundleOrderItemImpl4.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl4.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl4.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl4.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl4.setPrice(new Money());
    bundleOrderItemImpl4.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setQuantity(1);
    bundleOrderItemImpl4.setRetailPrice(new Money());
    bundleOrderItemImpl4.setRetailPriceOverride(true);
    bundleOrderItemImpl4.setSalePrice(new Money());
    bundleOrderItemImpl4.setSalePriceOverride(true);
    bundleOrderItemImpl4.setTaxable(true);
    bundleOrderItemImpl4.updateSaleAndRetailPrices();
    bundleOrderItemImpl4.setChildOrderItems(childOrderItems3);

    ArrayList<OrderItem> childOrderItems4 = new ArrayList<>();
    childOrderItems4.add(bundleOrderItemImpl4);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setChildOrderItems(childOrderItems4);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(4, childrenToRemove.size());
    assertEquals(1L, childrenToRemove.get(1).longValue());
    assertEquals(1L, childrenToRemove.get(2).longValue());
    assertEquals(1L, childrenToRemove.get(3).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.findAllChildrenToRemove(List, OrderItem)"})
  public void testFindAllChildrenToRemove_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable3);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable2);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setChildOrderItems(childOrderItems2);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(2, childrenToRemove.size());
    assertEquals(1L, childrenToRemove.get(0).longValue());
    assertEquals(1L, childrenToRemove.get(1).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.findAllChildrenToRemove(List, OrderItem)"})
  public void testFindAllChildrenToRemove_whenBundleOrderItemImpl_thenArrayListEmpty() {
    // Arrange
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, new BundleOrderItemImpl());

    // Assert that nothing has changed
    assertTrue(childrenToRemove.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#removeItemInternal(Long, Long, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeItemInternal(Long, Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeItemInternal(Long, Long, boolean)"})
  public void testRemoveItemInternal_thenThrowRuntimeException() throws WorkflowException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.removeItemInternal(1L, 1L, true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@link OrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeInactiveItems(Long, boolean)"})
  public void testRemoveInactiveItems_givenArrayListAddBundleOrderItemImpl_thenReturnOrderImpl()
      throws RemoveFromCartException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Could not remove from cart");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(orderItems);
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(orderImpl);

    // Act
    Order actualRemoveInactiveItemsResult = orderServiceImpl.removeInactiveItems(1L, true);

    // Assert
    verify(orderDao, atLeast(1)).readOrderById(eq(1L));
    assertTrue(actualRemoveInactiveItemsResult instanceof OrderImpl);
    assertSame(orderItems, actualRemoveInactiveItemsResult.getOrderItems());
  }

  /**
   * Test {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeInactiveItems(Long, boolean)"})
  public void testRemoveInactiveItems_givenAuditableCreatedByIsOne_thenReturnOrderImpl()
      throws RemoveFromCartException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Could not remove from cart");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(orderImpl);

    // Act
    Order actualRemoveInactiveItemsResult = orderServiceImpl.removeInactiveItems(1L, true);

    // Assert
    verify(orderDao, atLeast(1)).readOrderById(eq(1L));
    assertSame(orderImpl, actualRemoveInactiveItemsResult);
  }

  /**
   * Test {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeInactiveItems(Long, boolean)"})
  public void testRemoveInactiveItems_givenOrderDaoReadOrderByIdReturnNull() throws RemoveFromCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(RemoveFromCartException.class, () -> orderServiceImpl.removeInactiveItems(1L, true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeInactiveItems(Long, boolean)"})
  public void testRemoveInactiveItems_givenOrderDaoReadOrderByIdReturnNullOrderImpl() throws RemoveFromCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    // Act and Assert
    assertThrows(RemoveFromCartException.class, () -> orderServiceImpl.removeInactiveItems(1L, true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeInactiveItems(Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.removeInactiveItems(Long, boolean)"})
  public void testRemoveInactiveItems_thenThrowRuntimeException() throws RemoveFromCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException("Could not remove from cart"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.removeInactiveItems(1L, true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.getAutomaticallyMergeLikeItems()"})
  public void testGetAutomaticallyMergeLikeItems_thenReturnFalse() {
    // Arrange
    orderServiceImpl.setAutomaticallyMergeLikeItems(false);

    // Act and Assert
    assertFalse(orderServiceImpl.getAutomaticallyMergeLikeItems());
  }

  /**
   * Test {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.getAutomaticallyMergeLikeItems()"})
  public void testGetAutomaticallyMergeLikeItems_thenReturnTrue() {
    // Arrange
    orderServiceImpl.setAutomaticallyMergeLikeItems(true);

    // Act and Assert
    assertTrue(orderServiceImpl.getAutomaticallyMergeLikeItems());
  }

  /**
   * Test {@link OrderServiceImpl#setAutomaticallyMergeLikeItems(boolean)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#setAutomaticallyMergeLikeItems(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.setAutomaticallyMergeLikeItems(boolean)"})
  public void testSetAutomaticallyMergeLikeItems() {
    // Arrange and Act
    orderServiceImpl.setAutomaticallyMergeLikeItems(true);

    // Assert
    assertTrue(orderServiceImpl.getAutomaticallyMergeLikeItems());
    assertTrue(orderServiceImpl.automaticallyMergeLikeItems);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderServiceImpl#setDeleteEmptyNamedOrders(boolean)}
   *   <li>{@link OrderServiceImpl#setMoveNamedOrderItems(boolean)}
   *   <li>{@link OrderServiceImpl#isDeleteEmptyNamedOrders()}
   *   <li>{@link OrderServiceImpl#isMoveNamedOrderItems()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.isDeleteEmptyNamedOrders()",
      "boolean OrderServiceImpl.isMoveNamedOrderItems()", "void OrderServiceImpl.setDeleteEmptyNamedOrders(boolean)",
      "void OrderServiceImpl.setMoveNamedOrderItems(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    // Act
    orderServiceImpl.setDeleteEmptyNamedOrders(true);
    orderServiceImpl.setMoveNamedOrderItems(true);
    boolean actualIsDeleteEmptyNamedOrdersResult = orderServiceImpl.isDeleteEmptyNamedOrders();

    // Assert
    assertTrue(actualIsDeleteEmptyNamedOrdersResult);
    assertTrue(orderServiceImpl.isMoveNamedOrderItems());
  }

  /**
   * Test {@link OrderServiceImpl#removeAllPaymentsFromOrder(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#removeAllPaymentsFromOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removeAllPaymentsFromOrder(Order)"})
  public void testRemoveAllPaymentsFromOrder() throws WorkflowException {
    // Arrange
    when(orderPaymentDao.readPaymentById(Mockito.<Long>any())).thenReturn(new OrderPaymentImpl());
    doNothing().when(orderPaymentDao).delete(Mockito.<OrderPayment>any());
    doNothing().when(secureOrderPaymentService)
        .findAndRemoveSecurePaymentInfo(Mockito.<String>any(), Mockito.<PaymentType>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(new OrderPaymentImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setPayments(payments);
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    orderServiceImpl.removeAllPaymentsFromOrder(order);

    // Assert
    verify(orderPaymentDao).delete(isA(OrderPayment.class));
    verify(orderPaymentDao).readPaymentById(isNull());
    verify(secureOrderPaymentService).findAndRemoveSecurePaymentInfo(isNull(), isNull());
    assertTrue(order.getPayments().isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#removeAllPaymentsFromOrder(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#removeAllPaymentsFromOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removeAllPaymentsFromOrder(Order)"})
  public void testRemoveAllPaymentsFromOrder2() throws WorkflowException {
    // Arrange
    when(orderPaymentDao.readPaymentById(Mockito.<Long>any())).thenReturn(new OrderPaymentImpl());
    doNothing().when(orderPaymentDao).delete(Mockito.<OrderPayment>any());
    doThrow(new WorkflowException("An error occurred")).when(secureOrderPaymentService)
        .findAndRemoveSecurePaymentInfo(Mockito.<String>any(), Mockito.<PaymentType>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(new OrderPaymentImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setPayments(payments);
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    orderServiceImpl.removeAllPaymentsFromOrder(order);

    // Assert
    verify(orderPaymentDao).delete(isA(OrderPayment.class));
    verify(orderPaymentDao).readPaymentById(isNull());
    verify(secureOrderPaymentService).findAndRemoveSecurePaymentInfo(isNull(), isNull());
    assertTrue(order.getPayments().isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#removeAllPaymentsFromOrder(Order)}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) Payments Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeAllPaymentsFromOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removeAllPaymentsFromOrder(Order)"})
  public void testRemoveAllPaymentsFromOrder_thenOrderImplPaymentsEmpty() {
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
    order.setCurrency(new BroadleafCurrencyImpl());
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

    // Act
    orderServiceImpl.removeAllPaymentsFromOrder(order);

    // Assert that nothing has changed
    assertTrue(order.getPayments().isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#removeAllPaymentsFromOrder(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removeAllPaymentsFromOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removeAllPaymentsFromOrder(Order)"})
  public void testRemoveAllPaymentsFromOrder_thenThrowRuntimeException() throws WorkflowException {
    // Arrange
    doThrow(new RuntimeException("foo")).when(secureOrderPaymentService)
        .findAndRemoveSecurePaymentInfo(Mockito.<String>any(), Mockito.<PaymentType>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(new OrderPaymentImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setPayments(payments);
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.removeAllPaymentsFromOrder(order));
    verify(secureOrderPaymentService).findAndRemoveSecurePaymentInfo(isNull(), isNull());
  }

  /**
   * Test {@link OrderServiceImpl#removePaymentsFromOrder(Order, PaymentType)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link PaymentType#PaymentType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removePaymentsFromOrder(Order, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removePaymentsFromOrder(Order, PaymentType)"})
  public void testRemovePaymentsFromOrder_givenOrderPaymentImplGetTypeReturnPaymentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(orderPaymentImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setPayments(payments);
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    orderServiceImpl.removePaymentsFromOrder(order, new PaymentType("Type", "Friendly Type"));

    // Assert
    verify(orderPaymentImpl).getType();
  }

  /**
   * Test {@link OrderServiceImpl#removePaymentsFromOrder(Order, PaymentType)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removePaymentsFromOrder(Order, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removePaymentsFromOrder(Order, PaymentType)"})
  public void testRemovePaymentsFromOrder_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getReferenceNumber()).thenThrow(new RuntimeException("Type"));
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(orderPaymentImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setPayments(payments);
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.removePaymentsFromOrder(order, new PaymentType("Type", "Friendly Type")));
    verify(orderPaymentImpl).getReferenceNumber();
    verify(orderPaymentImpl).getType();
  }

  /**
   * Test {@link OrderServiceImpl#removePaymentFromOrder(Order, OrderPayment)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#removePaymentFromOrder(Order, OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removePaymentFromOrder(Order, OrderPayment)"})
  public void testRemovePaymentFromOrder() throws WorkflowException {
    // Arrange
    when(orderPaymentDao.readPaymentById(Mockito.<Long>any())).thenReturn(new OrderPaymentImpl());
    doNothing().when(orderPaymentDao).delete(Mockito.<OrderPayment>any());
    doNothing().when(secureOrderPaymentService)
        .findAndRemoveSecurePaymentInfo(Mockito.<String>any(), Mockito.<PaymentType>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(new OrderPaymentImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setPayments(payments);
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    orderServiceImpl.removePaymentFromOrder(order, new OrderPaymentImpl());

    // Assert
    verify(orderPaymentDao).delete(isA(OrderPayment.class));
    verify(orderPaymentDao).readPaymentById(isNull());
    verify(secureOrderPaymentService).findAndRemoveSecurePaymentInfo(isNull(), isNull());
    assertTrue(order.getPayments().isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#removePaymentFromOrder(Order, OrderPayment)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#removePaymentFromOrder(Order, OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removePaymentFromOrder(Order, OrderPayment)"})
  public void testRemovePaymentFromOrder2() throws WorkflowException {
    // Arrange
    when(orderPaymentDao.readPaymentById(Mockito.<Long>any())).thenReturn(new OrderPaymentImpl());
    doNothing().when(orderPaymentDao).delete(Mockito.<OrderPayment>any());
    doThrow(new WorkflowException("An error occurred")).when(secureOrderPaymentService)
        .findAndRemoveSecurePaymentInfo(Mockito.<String>any(), Mockito.<PaymentType>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(new OrderPaymentImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setPayments(payments);
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    orderServiceImpl.removePaymentFromOrder(order, new OrderPaymentImpl());

    // Assert
    verify(orderPaymentDao).delete(isA(OrderPayment.class));
    verify(orderPaymentDao).readPaymentById(isNull());
    verify(secureOrderPaymentService).findAndRemoveSecurePaymentInfo(isNull(), isNull());
    assertTrue(order.getPayments().isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#removePaymentFromOrder(Order, OrderPayment)}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) Payments Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removePaymentFromOrder(Order, OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removePaymentFromOrder(Order, OrderPayment)"})
  public void testRemovePaymentFromOrder_thenOrderImplPaymentsEmpty() {
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
    order.setCurrency(new BroadleafCurrencyImpl());
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

    // Act
    orderServiceImpl.removePaymentFromOrder(order, new OrderPaymentImpl());

    // Assert that nothing has changed
    assertTrue(order.getPayments().isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#removePaymentFromOrder(Order, OrderPayment)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#removePaymentFromOrder(Order, OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.removePaymentFromOrder(Order, OrderPayment)"})
  public void testRemovePaymentFromOrder_thenThrowRuntimeException() throws WorkflowException {
    // Arrange
    doThrow(new RuntimeException("foo")).when(secureOrderPaymentService)
        .findAndRemoveSecurePaymentInfo(Mockito.<String>any(), Mockito.<PaymentType>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(new OrderPaymentImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setPayments(payments);
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.removePaymentFromOrder(order, new OrderPaymentImpl()));
    verify(secureOrderPaymentService).findAndRemoveSecurePaymentInfo(isNull(), isNull());
  }

  /**
   * Test {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Throwable OrderServiceImpl.getCartOperationExceptionRootCause(WorkflowException)"})
  public void testGetCartOperationExceptionRootCause() {
    // Arrange
    WorkflowException e = new WorkflowException("An error occurred");

    // Act and Assert
    assertSame(e, orderServiceImpl.getCartOperationExceptionRootCause(e));
  }

  /**
   * Test {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>Then return {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Throwable OrderServiceImpl.getCartOperationExceptionRootCause(WorkflowException)"})
  public void testGetCartOperationExceptionRootCause_givenThrowable_thenReturnThrowable() {
    // Arrange
    WorkflowException e = new WorkflowException("An error occurred");
    Throwable throwable = new Throwable();
    e.initCause(throwable);

    // Act and Assert
    assertSame(throwable, orderServiceImpl.getCartOperationExceptionRootCause(e));
  }

  /**
   * Test {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}.
   * <ul>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#getCartOperationExceptionRootCause(WorkflowException)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Throwable OrderServiceImpl.getCartOperationExceptionRootCause(WorkflowException)"})
  public void testGetCartOperationExceptionRootCause_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable throwable = new Throwable();
    Throwable throwable2 = new Throwable();
    throwable.initCause(throwable2);

    WorkflowException e = new WorkflowException("An error occurred");
    e.initCause(throwable);

    // Act and Assert
    assertSame(throwable2, orderServiceImpl.getCartOperationExceptionRootCause(e).getCause());
  }

  /**
   * Test {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.compareAttributes(Map, OrderItemRequestDTO)"})
  public void testCompareAttributes_givenFoo_thenReturnFalse() {
    // Arrange
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();
    item1Attributes.put("foo", new OrderItemAttributeImpl());

    // Act and Assert
    assertFalse(orderServiceImpl.compareAttributes(item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.compareAttributes(Map, OrderItemRequestDTO)"})
  public void testCompareAttributes_whenHashMap_thenReturnTrue() {
    // Arrange
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    // Act and Assert
    assertTrue(orderServiceImpl.compareAttributes(item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link SkuImpl} {@link SkuImpl#getId()} return one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.itemMatches(Sku, Product, Map, OrderItemRequestDTO)"})
  public void testItemMatches_givenOne_whenSkuImplGetIdReturnOne_thenReturnTrue() {
    // Arrange
    SkuImpl item1Sku = mock(SkuImpl.class);
    when(item1Sku.getId()).thenReturn(1L);
    ProductBundleImpl item1Product = new ProductBundleImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    ConfigurableOrderItemRequest item2 = new ConfigurableOrderItemRequest();
    item2.setAdditionalAttributes(new HashMap<>());
    item2.setCategoryId(1L);
    item2.setChildOrderItems(new ArrayList<>());
    item2.setDiscountsAllowed(true);
    item2.setDisplayPrice(new Money());
    item2.setExpandable(true);
    item2.setFirstExpandable(true);
    item2.setHasConfigurationError(true);
    item2.setHasOverridenPrice(true);
    item2.setIsMultiSelect(true);
    item2.setItemAttributes(new HashMap<>());
    item2.setLastExpandable(true);
    item2.setMaxQuantity(3);
    item2.setMinQuantity(1);
    item2.setOrderItemId(1L);
    item2.setOrderItemIndex(1);
    item2.setOverrideRetailPrice(new Money());
    item2.setOverrideSalePrice(new Money());
    item2.setParentOrderItemId(1L);
    item2.setPricingModelType("Pricing Model Type");
    item2.setProduct(new ProductBundleImpl());
    item2.setProductChoices(new ArrayList<>());
    item2.setProductId(1L);
    item2.setQuantity(1);
    item2.setSku(new SkuImpl());
    item2.setSkuId(1L);

    // Act
    boolean actualItemMatchesResult = orderServiceImpl.itemMatches(item1Sku, item1Product, item1Attributes, item2);

    // Assert
    verify(item1Sku).getId();
    assertTrue(actualItemMatchesResult);
  }

  /**
   * Test {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link SkuImpl} {@link SkuImpl#getId()} return zero.</li>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.itemMatches(Sku, Product, Map, OrderItemRequestDTO)"})
  public void testItemMatches_givenZero_whenSkuImplGetIdReturnZero_thenCallsGetId() {
    // Arrange
    SkuImpl item1Sku = mock(SkuImpl.class);
    when(item1Sku.getId()).thenReturn(0L);
    ProductBundleImpl item1Product = new ProductBundleImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    ConfigurableOrderItemRequest item2 = new ConfigurableOrderItemRequest();
    item2.setAdditionalAttributes(new HashMap<>());
    item2.setCategoryId(1L);
    item2.setChildOrderItems(new ArrayList<>());
    item2.setDiscountsAllowed(true);
    item2.setDisplayPrice(new Money());
    item2.setExpandable(true);
    item2.setFirstExpandable(true);
    item2.setHasConfigurationError(true);
    item2.setHasOverridenPrice(true);
    item2.setIsMultiSelect(true);
    item2.setItemAttributes(new HashMap<>());
    item2.setLastExpandable(true);
    item2.setMaxQuantity(3);
    item2.setMinQuantity(1);
    item2.setOrderItemId(1L);
    item2.setOrderItemIndex(1);
    item2.setOverrideRetailPrice(new Money());
    item2.setOverrideSalePrice(new Money());
    item2.setParentOrderItemId(1L);
    item2.setPricingModelType("Pricing Model Type");
    item2.setProduct(new ProductBundleImpl());
    item2.setProductChoices(new ArrayList<>());
    item2.setProductId(1L);
    item2.setQuantity(1);
    item2.setSku(new SkuImpl());
    item2.setSkuId(1L);

    // Act
    boolean actualItemMatchesResult = orderServiceImpl.itemMatches(item1Sku, item1Product, item1Attributes, item2);

    // Assert
    verify(item1Sku).getId();
    assertFalse(actualItemMatchesResult);
  }

  /**
   * Test {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.itemMatches(Sku, Product, Map, OrderItemRequestDTO)"})
  public void testItemMatches_whenOrderItemRequestDTO_thenReturnFalse() {
    // Arrange
    SkuImpl item1Sku = new SkuImpl();
    ProductBundleImpl item1Product = new ProductBundleImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    // Act and Assert
    assertFalse(orderServiceImpl.itemMatches(item1Sku, item1Product, item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.itemMatches(Sku, Product, Map, OrderItemRequestDTO)"})
  public void testItemMatches_whenOrderItemRequestDTO_thenReturnFalse2() {
    // Arrange
    ProductBundleImpl item1Product = new ProductBundleImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    // Act and Assert
    assertFalse(orderServiceImpl.itemMatches(null, item1Product, item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#itemMatches(Sku, Product, Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.itemMatches(Sku, Product, Map, OrderItemRequestDTO)"})
  public void testItemMatches_whenOrderItemRequestDTO_thenReturnFalse3() {
    // Arrange
    SkuImpl item1Sku = new SkuImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    // Act and Assert
    assertFalse(orderServiceImpl.itemMatches(item1Sku, null, item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem_givenAuditableCreatedByIsOne() {
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
    order.setCurrency(new BroadleafCurrencyImpl());
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

    // Act and Assert
    assertNull(orderServiceImpl.findMatchingItem(order, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderServiceImpl.findMatchingItem(null, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#updateProductOptionsForItem(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#updateProductOptionsForItem(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.updateProductOptionsForItem(Long, OrderItemRequestDTO, boolean)"})
  public void testUpdateProductOptionsForItem_thenThrowRuntimeException() throws UpdateCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.updateProductOptionsForItem(1L, new OrderItemRequestDTO(), true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link OrderServiceImpl#reloadOrder(Order)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link OrderImpl} (default constructor) Id is {@code null}.</li>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#reloadOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.reloadOrder(Order)"})
  public void testReloadOrder_givenNull_whenOrderImplIdIsNull_thenReturnOrderImpl() {
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
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
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
    order.setId(null);

    // Act and Assert
    assertSame(order, orderServiceImpl.reloadOrder(order));
  }

  /**
   * Test {@link OrderServiceImpl#reloadOrder(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long, boolean)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#reloadOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.reloadOrder(Order)"})
  public void testReloadOrder_givenOrderDaoReadOrderByIdThrowRuntimeExceptionWithFoo() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any(), anyBoolean())).thenThrow(new RuntimeException("foo"));
    Order order = mock(Order.class);
    when(order.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.reloadOrder(order));
    verify(orderDao).readOrderById(eq(1L), eq(true));
    verify(order, atLeast(1)).getId();
  }

  /**
   * Test {@link OrderServiceImpl#reloadOrder(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#reloadOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.reloadOrder(Order)"})
  public void testReloadOrder_givenOrderDao_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderServiceImpl.reloadOrder(null));
  }

  /**
   * Test {@link OrderServiceImpl#reloadOrder(Order)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#reloadOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.reloadOrder(Order)"})
  public void testReloadOrder_givenRuntimeExceptionWithFoo() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getId()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.reloadOrder(order));
    verify(order).getId();
  }

  /**
   * Test {@link OrderServiceImpl#reloadOrder(Order)}.
   * <ul>
   *   <li>Then return OrderAdjustmentsValue abs is OrderAdjustmentsValue.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#reloadOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.reloadOrder(Order)"})
  public void testReloadOrder_thenReturnOrderAdjustmentsValueAbsIsOrderAdjustmentsValue() {
    // Arrange and Act
    Order actualReloadOrderResult = orderServiceImpl.reloadOrder(new NullOrderImpl());

    // Assert
    assertTrue(actualReloadOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualReloadOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualReloadOrderResult.getSubTotal());
  }

  /**
   * Test {@link OrderServiceImpl#reloadOrder(Order)}.
   * <ul>
   *   <li>Then return SubTotal is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#reloadOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.reloadOrder(Order)"})
  public void testReloadOrder_thenReturnSubTotalIsMoney() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    Money subTotal = new Money();
    order.setSubTotal(subTotal);
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    Money totalTax = new Money();
    order.setTotalTax(totalTax);
    order.setId(1L);

    // Act
    Order actualReloadOrderResult = orderServiceImpl.reloadOrder(order);

    // Assert
    verify(orderDao).readOrderById(eq(1L), eq(true));
    assertTrue(actualReloadOrderResult instanceof NullOrderImpl);
    assertEquals(subTotal, actualReloadOrderResult.getSubTotal());
    Money expectedOrderAdjustmentsValue = totalTax.ZERO;
    assertSame(expectedOrderAdjustmentsValue, actualReloadOrderResult.getOrderAdjustmentsValue());
  }

  /**
   * Test {@link OrderServiceImpl#acquireLock(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#acquireLock(Order)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#acquireLock(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.acquireLock(Order)"})
  public void testAcquireLock_givenOrderDaoAcquireLockReturnFalse_thenReturnFalse() {
    // Arrange
    when(orderDao.acquireLock(Mockito.<Order>any())).thenReturn(false);

    // Act
    boolean actualAcquireLockResult = orderServiceImpl.acquireLock(new NullOrderImpl());

    // Assert
    verify(orderDao).acquireLock(isA(Order.class));
    assertFalse(actualAcquireLockResult);
  }

  /**
   * Test {@link OrderServiceImpl#acquireLock(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#acquireLock(Order)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#acquireLock(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.acquireLock(Order)"})
  public void testAcquireLock_givenOrderDaoAcquireLockReturnTrue_thenReturnTrue() {
    // Arrange
    when(orderDao.acquireLock(Mockito.<Order>any())).thenReturn(true);

    // Act
    boolean actualAcquireLockResult = orderServiceImpl.acquireLock(new NullOrderImpl());

    // Assert
    verify(orderDao).acquireLock(isA(Order.class));
    assertTrue(actualAcquireLockResult);
  }

  /**
   * Test {@link OrderServiceImpl#acquireLock(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#acquireLock(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.acquireLock(Order)"})
  public void testAcquireLock_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.acquireLock(Mockito.<Order>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.acquireLock(new NullOrderImpl()));
    verify(orderDao).acquireLock(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#releaseLock(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#releaseLock(Order)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#releaseLock(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.releaseLock(Order)"})
  public void testReleaseLock_givenOrderDaoReleaseLockReturnFalse_thenReturnFalse() {
    // Arrange
    when(orderDao.releaseLock(Mockito.<Order>any())).thenReturn(false);

    // Act
    boolean actualReleaseLockResult = orderServiceImpl.releaseLock(new NullOrderImpl());

    // Assert
    verify(orderDao).releaseLock(isA(Order.class));
    assertFalse(actualReleaseLockResult);
  }

  /**
   * Test {@link OrderServiceImpl#releaseLock(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#releaseLock(Order)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#releaseLock(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.releaseLock(Order)"})
  public void testReleaseLock_givenOrderDaoReleaseLockReturnTrue_thenReturnTrue() {
    // Arrange
    when(orderDao.releaseLock(Mockito.<Order>any())).thenReturn(true);

    // Act
    boolean actualReleaseLockResult = orderServiceImpl.releaseLock(new NullOrderImpl());

    // Assert
    verify(orderDao).releaseLock(isA(Order.class));
    assertTrue(actualReleaseLockResult);
  }

  /**
   * Test {@link OrderServiceImpl#releaseLock(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#releaseLock(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceImpl.releaseLock(Order)"})
  public void testReleaseLock_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.releaseLock(Mockito.<Order>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.releaseLock(new NullOrderImpl()));
    verify(orderDao).releaseLock(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#printOrder(Order, Log)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code Order Item}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#printOrder(Order, Log)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.printOrder(Order, Log)"})
  public void testPrintOrder_givenRuntimeExceptionWithOrderItem_thenThrowRuntimeException() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money());
    when(order.getSubTotal()).thenReturn(new Money());
    when(order.getTotal()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    Jdk13LumberjackLogger log = mock(Jdk13LumberjackLogger.class);
    doThrow(new RuntimeException("Order Item")).when(log).debug(Mockito.<Object>any());
    when(log.isDebugEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.printOrder(order, log));
    verify(log).debug(isA(Object.class));
    verify(log).isDebugEnabled();
    verify(order).getOrderAdjustmentsValue();
    verify(order).getOrderItems();
    verify(order).getSubTotal();
    verify(order).getTotal();
    verify(order).getTotalShipping();
    verify(order).getTotalTax();
  }

  /**
   * Test {@link OrderServiceImpl#printOrder(Order, Log)}.
   * <ul>
   *   <li>When {@link Jdk13LumberjackLogger} {@link Jdk13LumberjackLogger#debug(Object)} does nothing.</li>
   *   <li>Then calls {@link Jdk13LumberjackLogger#debug(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#printOrder(Order, Log)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.printOrder(Order, Log)"})
  public void testPrintOrder_whenJdk13LumberjackLoggerDebugDoesNothing_thenCallsDebug() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money());
    when(order.getSubTotal()).thenReturn(new Money());
    when(order.getTotal()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    Jdk13LumberjackLogger log = mock(Jdk13LumberjackLogger.class);
    doNothing().when(log).debug(Mockito.<Object>any());
    when(log.isDebugEnabled()).thenReturn(true);

    // Act
    orderServiceImpl.printOrder(order, log);

    // Assert
    verify(log).debug(isA(Object.class));
    verify(log).isDebugEnabled();
    verify(order).getOrderAdjustmentsValue();
    verify(order).getOrderItems();
    verify(order).getSubTotal();
    verify(order).getTotal();
    verify(order).getTotalShipping();
    verify(order).getTotalTax();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateCartOperation(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateCartOperation(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateCartOperation(Order)"})
  public void testPreValidateCartOperation() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());

    // Act
    orderServiceImpl.preValidateCartOperation(new NullOrderImpl());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateCartOperation(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateCartOperation(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateCartOperation(Order)"})
  public void testPreValidateCartOperation2() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new OrderServiceExtensionManager());

    // Act
    orderServiceImpl.preValidateCartOperation(new NullOrderImpl());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateCartOperation(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateCartOperation(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateCartOperation(Order)"})
  public void testPreValidateCartOperation3() {
    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager2.addOfferCodes(order, new ArrayList<>(), false);
    when(orderServiceExtensionManager.getProxy()).thenReturn(orderServiceExtensionManager2);

    // Act
    orderServiceImpl.preValidateCartOperation(new NullOrderImpl());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateCartOperation(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateCartOperation(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateCartOperation(Order)"})
  public void testPreValidateCartOperation4() {
    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    orderServiceExtensionManager2.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager2.addOfferCodes(order, new ArrayList<>(), false);
    when(orderServiceExtensionManager.getProxy()).thenReturn(orderServiceExtensionManager2);

    // Act
    orderServiceImpl.preValidateCartOperation(new NullOrderImpl());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateCartOperation(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateCartOperation(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateCartOperation(Order)"})
  public void testPreValidateCartOperation_thenThrowRuntimeException() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.preValidateCartOperation(new NullOrderImpl()));
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)"})
  public void testPreValidateUpdateQuantityOperation() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl cart = new NullOrderImpl();

    // Act
    orderServiceImpl.preValidateUpdateQuantityOperation(cart, new OrderItemRequestDTO());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)"})
  public void testPreValidateUpdateQuantityOperation2() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new OrderServiceExtensionManager());
    NullOrderImpl cart = new NullOrderImpl();

    // Act
    orderServiceImpl.preValidateUpdateQuantityOperation(cart, new OrderItemRequestDTO());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)"})
  public void testPreValidateUpdateQuantityOperation3() {
    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager2.addOfferCodes(order, new ArrayList<>(), false);
    when(orderServiceExtensionManager.getProxy()).thenReturn(orderServiceExtensionManager2);
    NullOrderImpl cart = new NullOrderImpl();

    // Act
    orderServiceImpl.preValidateUpdateQuantityOperation(cart, new OrderItemRequestDTO());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)"})
  public void testPreValidateUpdateQuantityOperation4() {
    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    orderServiceExtensionManager2.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager2.addOfferCodes(order, new ArrayList<>(), false);
    when(orderServiceExtensionManager.getProxy()).thenReturn(orderServiceExtensionManager2);
    NullOrderImpl cart = new NullOrderImpl();

    // Act
    orderServiceImpl.preValidateUpdateQuantityOperation(cart, new OrderItemRequestDTO());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO)"})
  public void testPreValidateUpdateQuantityOperation_thenThrowRuntimeException() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenThrow(new RuntimeException("foo"));
    NullOrderImpl cart = new NullOrderImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.preValidateUpdateQuantityOperation(cart, new OrderItemRequestDTO()));
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#refresh(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#refresh(Order)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#refresh(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.refresh(Order)"})
  public void testRefresh_givenOrderDaoRefreshDoesNothing() {
    // Arrange
    doNothing().when(orderDao).refresh(Mockito.<Order>any());

    // Act
    orderServiceImpl.refresh(new NullOrderImpl());

    // Assert
    verify(orderDao).refresh(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#refresh(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#refresh(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderServiceImpl.refresh(Order)"})
  public void testRefresh_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException("foo")).when(orderDao).refresh(Mockito.<Order>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.refresh(new NullOrderImpl()));
    verify(orderDao).refresh(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)} with {@code customer}, {@code candidateOrder}.
   * <p>
   * Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer, Order)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateOrder() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(Mockito.<Customer>any(), Mockito.<Order>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateOrder = new NullOrderImpl();

    // Act
    Order actualFindCartForCustomerWithEnhancementsResult = orderServiceImpl
        .findCartForCustomerWithEnhancements(customer, candidateOrder);

    // Assert
    verify(orderServiceExtensionManager).findCartForCustomerWithEnhancements(isA(Customer.class), isA(Order.class),
        isA(ExtensionResultHolder.class));
    assertSame(candidateOrder, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)} with {@code customer}, {@code candidateOrder}.
   * <p>
   * Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer, Order)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateOrder2() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(Mockito.<Customer>any(), Mockito.<Order>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenThrow(new RuntimeException("foo"));
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.findCartForCustomerWithEnhancements(customer, new NullOrderImpl()));
    verify(orderServiceExtensionManager).findCartForCustomerWithEnhancements(isA(Customer.class), isA(Order.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)} with {@code customer}, {@code candidateOrder}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer, Order)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateOrder_thenReturnNull() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(Mockito.<Customer>any(), Mockito.<Order>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    CustomerImpl customer = new CustomerImpl();

    // Act
    Order actualFindCartForCustomerWithEnhancementsResult = orderServiceImpl
        .findCartForCustomerWithEnhancements(customer, new NullOrderImpl());

    // Assert
    verify(orderServiceExtensionManager).findCartForCustomerWithEnhancements(isA(Customer.class), isA(Order.class),
        isA(ExtensionResultHolder.class));
    assertNull(actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomer_thenReturnNull() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    Order actualFindCartForCustomerWithEnhancementsResult = orderServiceImpl
        .findCartForCustomerWithEnhancements(new CustomerImpl());

    // Assert
    verify(orderServiceExtensionManager).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(ExtensionResultHolder.class));
    assertNull(actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomer_thenReturnNullOrderImpl() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindCartForCustomerWithEnhancementsResult = orderServiceImpl
        .findCartForCustomerWithEnhancements(new CustomerImpl());

    // Assert
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    verify(orderServiceExtensionManager).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(ExtensionResultHolder.class));
    assertSame(nullOrderImpl, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomer_thenThrowRuntimeException() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> orderServiceImpl.findCartForCustomerWithEnhancements(new CustomerImpl()));
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    verify(orderServiceExtensionManager).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByEmail(String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByEmail(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByEmail(String)"})
  public void testFindOrdersByEmail_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Order> actualFindOrdersByEmailResult = orderServiceImpl.findOrdersByEmail("jane.doe@example.org");

    // Assert
    verify(orderDao).readOrdersByEmail(eq("jane.doe@example.org"));
    assertTrue(actualFindOrdersByEmailResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByEmail(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#findOrdersByEmail(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByEmail(String)"})
  public void testFindOrdersByEmail_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersByEmail(Mockito.<String>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrdersByEmail("jane.doe@example.org"));
    verify(orderDao).readOrdersByEmail(eq("jane.doe@example.org"));
  }

  /**
   * Test {@link OrderServiceImpl#readBatchOrders(int, int, List)}.
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OrderStatus#ARCHIVED}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#readBatchOrders(int, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.readBatchOrders(int, int, List)"})
  public void testReadBatchOrders_givenArchived_whenArrayListAddArchived_thenReturnEmpty() {
    // Arrange
    when(orderDao.readBatchOrders(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any())).thenReturn(new ArrayList<>());

    ArrayList<OrderStatus> orderStatusList = new ArrayList<>();
    orderStatusList.add(OrderStatus.ARCHIVED);

    // Act
    List<Order> actualReadBatchOrdersResult = orderServiceImpl.readBatchOrders(1, 3, orderStatusList);

    // Assert
    verify(orderDao).readBatchOrders(eq(1), eq(3), isA(List.class));
    assertTrue(actualReadBatchOrdersResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#readBatchOrders(int, int, List)}.
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OrderStatus#ARCHIVED}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#readBatchOrders(int, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.readBatchOrders(int, int, List)"})
  public void testReadBatchOrders_givenArchived_whenArrayListAddArchived_thenReturnEmpty2() {
    // Arrange
    when(orderDao.readBatchOrders(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any())).thenReturn(new ArrayList<>());

    ArrayList<OrderStatus> orderStatusList = new ArrayList<>();
    orderStatusList.add(OrderStatus.ARCHIVED);
    orderStatusList.add(OrderStatus.ARCHIVED);

    // Act
    List<Order> actualReadBatchOrdersResult = orderServiceImpl.readBatchOrders(1, 3, orderStatusList);

    // Assert
    verify(orderDao).readBatchOrders(eq(1), eq(3), isA(List.class));
    assertTrue(actualReadBatchOrdersResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#readBatchOrders(int, int, List)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#readBatchOrders(int, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.readBatchOrders(int, int, List)"})
  public void testReadBatchOrders_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readBatchOrders(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.readBatchOrders(1, 3, new ArrayList<>()));
    verify(orderDao).readBatchOrders(eq(1), eq(3), isA(List.class));
  }

  /**
   * Test {@link OrderServiceImpl#readBatchOrders(int, int, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#readBatchOrders(int, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderServiceImpl.readBatchOrders(int, int, List)"})
  public void testReadBatchOrders_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(orderDao.readBatchOrders(anyInt(), anyInt(), Mockito.<List<OrderStatus>>any())).thenReturn(new ArrayList<>());

    // Act
    List<Order> actualReadBatchOrdersResult = orderServiceImpl.readBatchOrders(1, 3, new ArrayList<>());

    // Assert
    verify(orderDao).readBatchOrders(eq(1), eq(3), isA(List.class));
    assertTrue(actualReadBatchOrdersResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#readNumberOfOrders()}.
   * <ul>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#readNumberOfOrders()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OrderServiceImpl.readNumberOfOrders()"})
  public void testReadNumberOfOrders_thenReturnLongValueIsOne() {
    // Arrange
    when(orderDao.readNumberOfOrders()).thenReturn(1L);

    // Act
    Long actualReadNumberOfOrdersResult = orderServiceImpl.readNumberOfOrders();

    // Assert
    verify(orderDao).readNumberOfOrders();
    assertEquals(1L, actualReadNumberOfOrdersResult.longValue());
  }

  /**
   * Test {@link OrderServiceImpl#readNumberOfOrders()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceImpl#readNumberOfOrders()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OrderServiceImpl.readNumberOfOrders()"})
  public void testReadNumberOfOrders_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readNumberOfOrders()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.readNumberOfOrders());
    verify(orderDao).readNumberOfOrders();
  }
}
