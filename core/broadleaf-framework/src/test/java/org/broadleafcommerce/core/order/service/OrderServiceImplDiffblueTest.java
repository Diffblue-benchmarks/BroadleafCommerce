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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.offer.service.exception.OfferAlreadyAddedException;
import org.broadleafcommerce.core.offer.service.exception.OfferException;
import org.broadleafcommerce.core.offer.service.exception.OfferExpiredException;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.dao.OrderDaoImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.AddToCartItem;
import org.broadleafcommerce.core.order.service.call.GiftWrapOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.exception.UpdateCartException;
import org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDao;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.secure.Referenced;
import org.broadleafcommerce.core.payment.service.SecureOrderPaymentService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.hibernate.exception.LockAcquisitionException;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplDiffblueTest {
  @Mock private CustomerService customerService;

  @Mock private OfferService offerService;

  @Mock private OrderDao orderDao;

  @Mock private OrderItemService orderItemService;

  @Mock private OrderMultishipOptionService orderMultishipOptionService;

  @Mock private OrderPaymentDao orderPaymentDao;

  @Mock private OrderServiceExtensionManager orderServiceExtensionManager;

  @InjectMocks private OrderServiceImpl orderServiceImpl;

  @Mock private PlatformTransactionManager platformTransactionManager;

  @Mock private SecureOrderPaymentService secureOrderPaymentService;

  /**
   * Test {@link OrderServiceImpl#createNewCartForCustomer(Customer)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.createNewCartForCustomer(Customer)"})
  public void testCreateNewCartForCustomer() {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.createNewCartForCustomer(new CustomerImpl()));
    verify(customerService).saveCustomer(isA(Customer.class));
  }

  /**
   * Test {@link OrderServiceImpl#createNewCartForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getId()} return one.
   *   <li>Then calls {@link CustomerImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.createNewCartForCustomer(Customer)"})
  public void testCreateNewCartForCustomer_givenCustomerImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.createNewCartForCustomer(new CustomerImpl()));
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(customerImpl, atLeast(1)).getId();
    verify(customerService).saveCustomer(isA(Customer.class));
  }

  /**
   * Test {@link OrderServiceImpl#createNewCartForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Given {@link CustomerService} {@link CustomerService#saveCustomer(Customer)} return
   *       {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.createNewCartForCustomer(Customer)"})
  public void testCreateNewCartForCustomer_givenCustomerServiceSaveCustomerReturnCustomerImpl() {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.createNewCartForCustomer(new CustomerImpl()));
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(customerService).saveCustomer(isA(Customer.class));
  }

  /**
   * Test {@link OrderServiceImpl#createNewCartForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.createNewCartForCustomer(Customer)"})
  public void testCreateNewCartForCustomer_thenReturnNullOrderImpl() {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualCreateNewCartForCustomerResult =
        orderServiceImpl.createNewCartForCustomer(new CustomerImpl());

    // Assert
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(customerService).saveCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualCreateNewCartForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.createNamedOrderForCustomer(String, Customer)"})
  public void testCreateNamedOrderForCustomer() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderDao.create()).thenReturn(orderImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.createNamedOrderForCustomer("Name", new CustomerImpl()));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).create();
  }

  /**
   * Test {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.createNamedOrderForCustomer(String, Customer)"})
  public void testCreateNamedOrderForCustomer2() {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new OrderServiceExtensionManager());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    when(orderDao.create()).thenReturn(orderImpl);

    // Act
    Order actualCreateNamedOrderForCustomerResult =
        orderServiceImpl.createNamedOrderForCustomer("Name", new CustomerImpl());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).create();
    verify(orderDao).save(isA(Order.class));
    assertSame(nullOrderImpl, actualCreateNamedOrderForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#create()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.createNamedOrderForCustomer(String, Customer)"})
  public void testCreateNamedOrderForCustomer_givenOrderDaoCreateThrowRuntimeException() {
    // Arrange
    when(orderDao.create()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.createNamedOrderForCustomer("Name", new CustomerImpl()));
    verify(orderDao).create();
  }

  /**
   * Test {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.createNamedOrderForCustomer(String, Customer)"})
  public void testCreateNamedOrderForCustomer_givenOrderDaoSaveThrowRuntimeException() {
    // Arrange
    when(orderServiceExtensionManager.getProxy())
        .thenReturn(new CartMessageOrderItemServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new RuntimeException());
    when(orderDao.create()).thenReturn(orderImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.createNamedOrderForCustomer("Name", new CustomerImpl()));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).create();
    verify(orderDao).save(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.createNamedOrderForCustomer(String, Customer)"})
  public void testCreateNamedOrderForCustomer_thenReturnNullOrderImpl() {
    // Arrange
    when(orderServiceExtensionManager.getProxy())
        .thenReturn(new CartMessageOrderItemServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    when(orderDao.create()).thenReturn(orderImpl);

    // Act
    Order actualCreateNamedOrderForCustomerResult =
        orderServiceImpl.createNamedOrderForCustomer("Name", new CustomerImpl());

    // Assert
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).create();
    verify(orderDao).save(isA(Order.class));
    assertSame(nullOrderImpl, actualCreateNamedOrderForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findNamedOrderForCustomer(String, Customer)"})
  public void testFindNamedOrderForCustomer_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readNamedOrderForCustomer(Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(nullOrderImpl);

    // Act
    Order actualFindNamedOrderForCustomerResult =
        orderServiceImpl.findNamedOrderForCustomer("Name", new CustomerImpl());

    // Assert
    verify(orderDao).readNamedOrderForCustomer(isA(Customer.class), eq("Name"));
    assertSame(nullOrderImpl, actualFindNamedOrderForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findNamedOrderForCustomer(String, Customer)"})
  public void testFindNamedOrderForCustomer_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readNamedOrderForCustomer(Mockito.<Customer>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.findNamedOrderForCustomer("Name", new CustomerImpl()));
    verify(orderDao).readNamedOrderForCustomer(isA(Customer.class), eq("Name"));
  }

  /**
   * Test {@link OrderServiceImpl#findOrderById(Long, boolean)} with {@code orderId}, {@code
   * refresh}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrderById(Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderById(Long, boolean)"})
  public void testFindOrderByIdWithOrderIdRefresh_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindOrderByIdResult = orderServiceImpl.findOrderById(1L, true);

    // Assert
    verify(orderDao).readOrderById(1L, true);
    assertSame(nullOrderImpl, actualFindOrderByIdResult);
  }

  /**
   * Test {@link OrderServiceImpl#findOrderById(Long, boolean)} with {@code orderId}, {@code
   * refresh}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrderById(Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderById(Long, boolean)"})
  public void testFindOrderByIdWithOrderIdRefresh_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any(), anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrderById(1L, true));
    verify(orderDao).readOrderById(1L, true);
  }

  /**
   * Test {@link OrderServiceImpl#findOrderById(Long)} with {@code orderId}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrderById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderById(Long)"})
  public void testFindOrderByIdWithOrderId_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindOrderByIdResult = orderServiceImpl.findOrderById(1L);

    // Assert
    verify(orderDao).readOrderById(1L);
    assertSame(nullOrderImpl, actualFindOrderByIdResult);
  }

  /**
   * Test {@link OrderServiceImpl#findOrderById(Long)} with {@code orderId}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrderById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderById(Long)"})
  public void testFindOrderByIdWithOrderId_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrderById(1L));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByIds(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByIds(List)"})
  public void testFindOrdersByIds_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersByIds(Mockito.<List<Long>>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrdersByIds(new ArrayList<>()));
    verify(orderDao).readOrdersByIds(isA(List.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findCartForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomer(Customer)"})
  public void testFindCartForCustomer_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindCartForCustomerResult =
        orderServiceImpl.findCartForCustomer(new CustomerImpl());

    // Assert
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualFindCartForCustomerResult);
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findCartForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomer(Customer)"})
  public void testFindCartForCustomer_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> orderServiceImpl.findCartForCustomer(new CustomerImpl()));
    verify(orderDao).readCartForCustomer(isA(Customer.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomer(Customer, OrderStatus)} with {@code
   * customer}, {@code status}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersForCustomer(Customer, OrderStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomer(Customer, OrderStatus)"})
  public void testFindOrdersForCustomerWithCustomerStatus_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersForCustomer(Mockito.<Customer>any(), Mockito.<OrderStatus>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Order> actualFindOrdersForCustomerResult =
        orderServiceImpl.findOrdersForCustomer(new CustomerImpl(), OrderStatus.ARCHIVED);

    // Assert
    verify(orderDao).readOrdersForCustomer(isA(Customer.class), isA(OrderStatus.class));
    assertTrue(actualFindOrdersForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomer(Customer, OrderStatus)} with {@code
   * customer}, {@code status}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersForCustomer(Customer, OrderStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomer(Customer, OrderStatus)"})
  public void testFindOrdersForCustomerWithCustomerStatus_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersForCustomer(Mockito.<Customer>any(), Mockito.<OrderStatus>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.findOrdersForCustomer(new CustomerImpl(), OrderStatus.ARCHIVED));
    verify(orderDao).readOrdersForCustomer(isA(Customer.class), isA(OrderStatus.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomer(Customer)"})
  public void testFindOrdersForCustomerWithCustomer_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersForCustomer(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<Order> actualFindOrdersForCustomerResult =
        orderServiceImpl.findOrdersForCustomer(new CustomerImpl());

    // Assert
    verify(orderDao).readOrdersForCustomer(isNull());
    assertTrue(actualFindOrdersForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomer(Customer)"})
  public void testFindOrdersForCustomerWithCustomer_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersForCustomer(Mockito.<Long>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> orderServiceImpl.findOrdersForCustomer(new CustomerImpl()));
    verify(orderDao).readOrdersForCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#findOrderByOrderNumber(String)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrderByOrderNumber(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderByOrderNumber(String)"})
  public void testFindOrderByOrderNumber_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderByOrderNumber(Mockito.<String>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindOrderByOrderNumberResult = orderServiceImpl.findOrderByOrderNumber("42");

    // Assert
    verify(orderDao).readOrderByOrderNumber("42");
    assertSame(nullOrderImpl, actualFindOrderByOrderNumberResult);
  }

  /**
   * Test {@link OrderServiceImpl#findOrderByOrderNumber(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrderByOrderNumber(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findOrderByOrderNumber(String)"})
  public void testFindOrderByOrderNumber_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrderByOrderNumber(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrderByOrderNumber("42"));
    verify(orderDao).readOrderByOrderNumber("42");
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByDateRange(Date, Date)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByDateRange(Date, Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByDateRange(Date, Date)"})
  public void testFindOrdersByDateRange_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersByDateRange(Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Order> actualFindOrdersByDateRangeResult =
        orderServiceImpl.findOrdersByDateRange(
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderDao).readOrdersByDateRange(isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrdersByDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByDateRange(Date, Date)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByDateRange(Date, Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByDateRange(Date, Date)"})
  public void testFindOrdersByDateRange_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersByDateRange(Mockito.<Date>any(), Mockito.<Date>any()))
        .thenThrow(new RuntimeException());
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            orderServiceImpl.findOrdersByDateRange(
                startDate,
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    verify(orderDao).readOrdersByDateRange(isA(Date.class), isA(Date.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByDaysCount(Integer, Integer)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByDaysCount(Integer, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByDaysCount(Integer, Integer)"})
  public void testFindOrdersByDaysCount_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersOlderThanDaysCount(Mockito.<Integer>any(), Mockito.<Integer>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Order> actualFindOrdersByDaysCountResult = orderServiceImpl.findOrdersByDaysCount(3, 3);

    // Assert
    verify(orderDao).readOrdersOlderThanDaysCount(3, 3);
    assertTrue(actualFindOrdersByDaysCountResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByDaysCount(Integer, Integer)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByDaysCount(Integer, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByDaysCount(Integer, Integer)"})
  public void testFindOrdersByDaysCount_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersOlderThanDaysCount(Mockito.<Integer>any(), Mockito.<Integer>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.findOrdersByDaysCount(3, 3));
    verify(orderDao).readOrdersOlderThanDaysCount(3, 3);
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date,
   * Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrdersForCustomersInDateRange_givenOne_whenArrayListAddOne() {
    // Arrange
    when(orderDao.readOrdersForCustomersInDateRange(
            Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> customerIds = new ArrayList<>();
    customerIds.add(1L);
    customerIds.add(3L);
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Order> actualFindOrdersForCustomersInDateRangeResult =
        orderServiceImpl.findOrdersForCustomersInDateRange(
            customerIds,
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderDao)
        .readOrdersForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrdersForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link ArrayList#ArrayList()} add three.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date,
   * Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrdersForCustomersInDateRange_givenThree_whenArrayListAddThree() {
    // Arrange
    when(orderDao.readOrdersForCustomersInDateRange(
            Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> customerIds = new ArrayList<>();
    customerIds.add(3L);
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Order> actualFindOrdersForCustomersInDateRangeResult =
        orderServiceImpl.findOrdersForCustomersInDateRange(
            customerIds,
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderDao)
        .readOrdersForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrdersForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date,
   * Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrdersForCustomersInDateRange_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersForCustomersInDateRange(
            Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenThrow(new RuntimeException());
    ArrayList<Long> customerIds = new ArrayList<>();
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            orderServiceImpl.findOrdersForCustomersInDateRange(
                customerIds,
                startDate,
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    verify(orderDao)
        .readOrdersForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date, Date)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersForCustomersInDateRange(List, Date,
   * Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersForCustomersInDateRange(List, Date, Date)"})
  public void testFindOrdersForCustomersInDateRange_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersForCustomersInDateRange(
            Mockito.<List<Long>>any(), Mockito.<Date>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> customerIds = new ArrayList<>();
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Order> actualFindOrdersForCustomersInDateRangeResult =
        orderServiceImpl.findOrdersForCustomersInDateRange(
            customerIds,
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(orderDao)
        .readOrdersForCustomersInDateRange(isA(List.class), isA(Date.class), isA(Date.class));
    assertTrue(actualFindOrdersForCustomersInDateRangeResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findPaymentsForOrder(Order)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findPaymentsForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findPaymentsForOrder(Order)"})
  public void testFindPaymentsForOrder_thenReturnEmpty() {
    // Arrange
    when(orderPaymentDao.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    List<OrderPayment> actualFindPaymentsForOrderResult =
        orderServiceImpl.findPaymentsForOrder(new NullOrderImpl());

    // Assert
    verify(orderPaymentDao).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualFindPaymentsForOrderResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findPaymentsForOrder(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findPaymentsForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findPaymentsForOrder(Order)"})
  public void testFindPaymentsForOrder_thenThrowRuntimeException() {
    // Arrange
    when(orderPaymentDao.readPaymentsForOrder(Mockito.<Order>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> orderServiceImpl.findPaymentsForOrder(new NullOrderImpl()));
    verify(orderPaymentDao).readPaymentsForOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment, Referenced)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment,
   * Referenced)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPayment OrderServiceImpl.addPaymentToOrder(Order, OrderPayment, Referenced)"
  })
  public void testAddPaymentToOrder_givenOrderDaoSaveThrowRuntimeException() {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new RuntimeException());

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            orderServiceImpl.addPaymentToOrder(
                order, new OrderPaymentImpl(), mock(Referenced.class)));
    verify(orderDao).save(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment, Referenced)}.
   *
   * <ul>
   *   <li>Given {@link SecureOrderPaymentService} {@link
   *       SecureOrderPaymentService#save(Referenced)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment,
   * Referenced)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPayment OrderServiceImpl.addPaymentToOrder(Order, OrderPayment, Referenced)"
  })
  public void testAddPaymentToOrder_givenSecureOrderPaymentServiceSaveThrowRuntimeException() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderDao.save(Mockito.<Order>any())).thenReturn(orderImpl);
    when(secureOrderPaymentService.save(Mockito.<Referenced>any()))
        .thenThrow(new RuntimeException());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            orderServiceImpl.addPaymentToOrder(
                order, new OrderPaymentImpl(), mock(Referenced.class)));
    verify(orderDao).save(isA(Order.class));
    verify(secureOrderPaymentService).save(isA(Referenced.class));
  }

  /**
   * Test {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment, Referenced)}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) Payments size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment,
   * Referenced)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPayment OrderServiceImpl.addPaymentToOrder(Order, OrderPayment, Referenced)"
  })
  public void testAddPaymentToOrder_thenOrderImplPaymentsSizeIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderDao.save(Mockito.<Order>any())).thenReturn(orderImpl);
    when(secureOrderPaymentService.save(Mockito.<Referenced>any()))
        .thenReturn(mock(Referenced.class));

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    OrderPayment actualAddPaymentToOrderResult =
        orderServiceImpl.addPaymentToOrder(order, new OrderPaymentImpl(), mock(Referenced.class));

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(secureOrderPaymentService).save(isA(Referenced.class));
    List<OrderPayment> payments3 = order.getPayments();
    assertEquals(1, payments3.size());
    assertSame(payments2, payments3);
    assertSame(orderPaymentImpl, actualAddPaymentToOrderResult);
  }

  /**
   * Test {@link OrderServiceImpl#cancelOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#delete(Order)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#cancelOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#cancelOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderServiceImpl.cancelOrder(Order)"})
  public void testCancelOrder_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(orderDao).delete(Mockito.<Order>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.cancelOrder(new NullOrderImpl()));
    verify(orderDao).delete(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#deleteOrder(Order)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#deleteOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderServiceImpl.deleteOrder(Order)"})
  public void testDeleteOrder() {
    // Arrange
    doThrow(new RuntimeException())
        .when(orderMultishipOptionService)
        .deleteAllOrderMultishipOptions(Mockito.<Order>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.deleteOrder(new NullOrderImpl()));
    verify(orderMultishipOptionService).deleteAllOrderMultishipOptions(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#deleteOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#delete(Order)} does nothing.
   *   <li>Then calls {@link OrderDao#delete(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#deleteOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderServiceImpl.deleteOrder(Order)"})
  public void testDeleteOrder_givenOrderDaoDeleteDoesNothing_thenCallsDelete() {
    // Arrange
    doNothing().when(orderDao).delete(Mockito.<Order>any());
    doNothing()
        .when(orderMultishipOptionService)
        .deleteAllOrderMultishipOptions(Mockito.<Order>any());

    // Act
    orderServiceImpl.deleteOrder(new NullOrderImpl());

    // Assert
    verify(orderDao).delete(isA(Order.class));
    verify(orderMultishipOptionService).deleteAllOrderMultishipOptions(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#deleteOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#delete(Order)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#deleteOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderServiceImpl.deleteOrder(Order)"})
  public void testDeleteOrder_givenOrderDaoDeleteThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(orderDao).delete(Mockito.<Order>any());
    doNothing()
        .when(orderMultishipOptionService)
        .deleteAllOrderMultishipOptions(Mockito.<Order>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.deleteOrder(new NullOrderImpl()));
    verify(orderDao).delete(isA(Order.class));
    verify(orderMultishipOptionService).deleteAllOrderMultishipOptions(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addOfferCode(order, new OfferCodeImpl(), true));
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode2() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy())
        .thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.verifyMaxCustomerUsageThreshold(
            Mockito.<Order>any(), Mockito.<OfferCode>any()))
        .thenThrow(new RuntimeException());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addOfferCode(order, new OfferCodeImpl(), true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(offerService).verifyMaxCustomerUsageThreshold(isA(Order.class), isA(OfferCode.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_givenBundleOrderItemImpl() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy())
        .thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.verifyMaxCustomerUsageThreshold(
            Mockito.<Order>any(), Mockito.<OfferCode>any()))
        .thenReturn(true);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(new BundleOrderItemImpl());

    OfferCodeImpl offerCode = mock(OfferCodeImpl.class);
    when(offerCode.isActive()).thenReturn(true);
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(
        OfferExpiredException.class, () -> orderServiceImpl.addOfferCode(order, offerCode, true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerCode, atLeast(1)).getOffer();
    verify(offerCode).isActive();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(offerService).verifyMaxCustomerUsageThreshold(isA(Order.class), isA(OfferCode.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link OfferImpl} (default constructor).
   *   <li>Then throw {@link OfferAlreadyAddedException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_givenHashSetAddOfferImpl_thenThrowOfferAlreadyAddedException()
      throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy())
        .thenReturn(new CartMessageOrderItemServiceExtensionHandler());

    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(new OfferImpl());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);
    OrderImpl order = new OrderImpl();

    OfferCodeImpl offerCode = mock(OfferCodeImpl.class);
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(
        OfferAlreadyAddedException.class,
        () -> orderServiceImpl.addOfferCode(order, offerCode, true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerCode).getOffer();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).
   *   <li>When {@link OrderImpl} (default constructor) addAddedOfferCode {@link OfferCodeImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_givenOfferCodeImpl_whenOrderImplAddAddedOfferCodeOfferCodeImpl()
      throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy())
        .thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());

    // Act and Assert
    assertThrows(
        OfferAlreadyAddedException.class,
        () -> orderServiceImpl.addOfferCode(order, new OfferCodeImpl(), true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>Then throw {@link OfferExpiredException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCode(Order, OfferCode, boolean)"})
  public void testAddOfferCode_givenOfferImpl_thenThrowOfferExpiredException()
      throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy())
        .thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.verifyMaxCustomerUsageThreshold(
            Mockito.<Order>any(), Mockito.<OfferCode>any()))
        .thenReturn(true);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    OrderImpl order = new OrderImpl();

    OfferCodeImpl offerCode = mock(OfferCodeImpl.class);
    when(offerCode.isActive()).thenReturn(true);
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(
        OfferExpiredException.class, () -> orderServiceImpl.addOfferCode(order, offerCode, true));
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerCode, atLeast(1)).getOffer();
    verify(offerCode).isActive();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(offerService).verifyMaxCustomerUsageThreshold(isA(Order.class), isA(OfferCode.class));
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addOfferCodes(order, new ArrayList<>(), true));
    verify(orderServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes2() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy())
        .thenReturn(new CartMessageOrderItemServiceExtensionHandler());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualAddOfferCodesResult =
        orderServiceImpl.addOfferCodes(order, new ArrayList<>(), true);

    // Assert
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    assertSame(order, actualAddOfferCodesResult);
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes_thenReturnNullOrderImpl() throws OfferException, PricingException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenReturn(new OrderServiceExtensionManager());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualAddOfferCodesResult =
        orderServiceImpl.addOfferCodes(order, new ArrayList<>(), true);

    // Assert
    verify(orderServiceExtensionManager, atLeast(1)).getProxy();
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    assertSame(order, actualAddOfferCodesResult);
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act
    OrderItem actualFindLastMatchingItemResult =
        orderServiceImpl.findLastMatchingItem(order, null, 1L);

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getProduct();
    assertNull(actualFindLastMatchingItemResult);
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem2() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act
    OrderItem actualFindLastMatchingItemResult =
        orderServiceImpl.findLastMatchingItem(order, null, 1L);

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getProduct();
    assertNull(actualFindLastMatchingItemResult);
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenArrayListAddBundleOrderItemImpl_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(order, 1L, 1L));
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenArrayListAddDiscreteOrderItemImpl_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(order, 1L, 1L));
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenAuditableCreatedByIsOne_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

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
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
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
    order.setOrderItems(new ArrayList<>());

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(order, 1L, 1L));
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getProduct()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenBundleOrderItemImplGetProductThrowRuntimeException() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProduct()).thenThrow(new RuntimeException());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> orderServiceImpl.findLastMatchingItem(order, null, 1L));
    verify(bundleOrderItemImpl).getProduct();
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link
   *       SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenBundleOrderItemImplGetSkuReturnSkuImpl() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act
    OrderItem actualFindLastMatchingItemResult =
        orderServiceImpl.findLastMatchingItem(order, 1L, 1L);

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
    assertNull(actualFindLastMatchingItemResult);
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenBundleOrderItemImplGetSkuThrowRuntimeException() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenThrow(new RuntimeException());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> orderServiceImpl.findLastMatchingItem(order, 1L, 1L));
    verify(bundleOrderItemImpl).getSku();
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenOrderItemImplAuditableIsAuditable_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(order, 1L, 1L));
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderServiceImpl} (default constructor).
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenOrderServiceImpl_whenNullOrderImpl_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(new NullOrderImpl(), 1L, 1L));
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductBundleImpl#getId()} return one.
   *   <li>Then calls {@link ProductBundleImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenProductBundleImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenReturn(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act
    orderServiceImpl.findLastMatchingItem(order, null, 1L);

    // Assert
    verify(productBundleImpl).getId();
    verify(bundleOrderItemImpl, atLeast(1)).getProduct();
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductBundleImpl#getId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenProductBundleImplGetIdThrowRuntimeException() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenThrow(new RuntimeException());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> orderServiceImpl.findLastMatchingItem(order, null, 1L));
    verify(productBundleImpl).getId();
    verify(bundleOrderItemImpl, atLeast(1)).getProduct();
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenSkuImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act
    orderServiceImpl.findLastMatchingItem(order, 1L, 1L);

    // Assert
    verify(skuImpl).getId();
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_givenSkuImplGetIdThrowRuntimeException_thenCallsGetId() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenThrow(new RuntimeException());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> orderServiceImpl.findLastMatchingItem(order, 1L, 1L));
    verify(skuImpl).getId();
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findLastMatchingItem(Order, Long, Long)"})
  public void testFindLastMatchingItem_whenNull_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(mock(BundleOrderItemImpl.class));

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(order, null, null));
  }

  /**
   * Test {@link OrderServiceImpl#confirmOrder(Order)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#confirmOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#confirmOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.confirmOrder(Order)"})
  public void testConfirmOrder_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.submitOrder(Mockito.<Order>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.confirmOrder(new NullOrderImpl()));
    verify(orderDao).submitOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addAllItemsFromNamedOrder(Order, boolean)"})
  public void testAddAllItemsFromNamedOrder() throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addAllItemsFromNamedOrder(new NullOrderImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addAllItemsFromNamedOrder(Order, boolean)"})
  public void testAddAllItemsFromNamedOrder2() throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addAllItemsFromNamedOrder(new NullOrderImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(customerService).saveCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addAllItemsFromNamedOrder(Order, boolean)"})
  public void testAddAllItemsFromNamedOrder3() throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addAllItemsFromNamedOrder(new NullOrderImpl(), true));
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(orderDao).readCartForCustomer(isNull());
    verify(customerService).saveCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link LockAcquisitionException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addAllItemsFromNamedOrder(Order, boolean)"})
  public void testAddAllItemsFromNamedOrder_thenThrowLockAcquisitionException()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(customerImpl);
    LockAcquisitionException lockAcquisitionException =
        new LockAcquisitionException("String", new SQLException());
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(lockAcquisitionException);
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        LockAcquisitionException.class,
        () -> orderServiceImpl.addAllItemsFromNamedOrder(new NullOrderImpl(), true));
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(orderDao).readCartForCustomer(isNull());
    verify(customerImpl, atLeast(1)).getId();
    verify(customerService).saveCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code
   * namedOrder}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code
   * namedOrder}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder2()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenThrow(new RuntimeException());
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code
   * namedOrder}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder3()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new OrderItemRequestDTO());
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(orderDao).readOrderById(isNull());
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code
   * namedOrder}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder4()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(null);
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(customerService).saveCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code
   * namedOrder}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder5()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(null);
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(orderDao).readCartForCustomer(isNull());
    verify(customerService).saveCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code
   * namedOrder}, {@code item}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder6()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(customerImpl);
    LockAcquisitionException lockAcquisitionException =
        new LockAcquisitionException("String", new SQLException());
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(lockAcquisitionException);
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(null);
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        LockAcquisitionException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(orderDao).readCartForCustomer(isNull());
    verify(customerImpl, atLeast(1)).getId();
    verify(customerService).saveCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code
   * namedOrder}, {@code item}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder_thenCallsGetId()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getId()).thenThrow(new RuntimeException());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new OrderItemRequestDTO());
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(nullOrderImpl).getId();
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)} with {@code
   * namedOrder}, {@code item}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then calls {@link OrderServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, boolean)"})
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder_thenCallsGetProxy()
      throws AddToCartException, RemoveFromCartException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new OrderItemRequestDTO());
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).readCartForCustomer(isNull());
    verify(orderDao).readOrderById(isNull());
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code
   * namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"
  })
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), 2, true));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code
   * namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"
  })
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder2()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());
    NullOrderImpl namedOrder = new NullOrderImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, item, 1, true));
    verify(orderDao).readCartForCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code
   * namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"
  })
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder3()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenThrow(new RuntimeException());
    NullOrderImpl namedOrder = new NullOrderImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, item, 1, true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code
   * namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"
  })
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder4()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new OrderItemRequestDTO());
    NullOrderImpl namedOrder = new NullOrderImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, item, 1, true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(orderDao).readOrderById(isNull());
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code
   * namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"
  })
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder5()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(null);
    NullOrderImpl namedOrder = new NullOrderImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, item, 1, true));
    verify(orderDao).readCartForCustomer(isNull());
    verify(customerService).saveCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code
   * namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"
  })
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder6()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(null);
    NullOrderImpl namedOrder = new NullOrderImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, item, 1, true));
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(orderDao).readCartForCustomer(isNull());
    verify(customerService).saveCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code
   * namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"
  })
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder7()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(customerImpl);
    LockAcquisitionException lockAcquisitionException =
        new LockAcquisitionException("String", new SQLException());
    when(orderDao.createNewCartForCustomer(Mockito.<Customer>any()))
        .thenThrow(lockAcquisitionException);
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(null);
    NullOrderImpl namedOrder = new NullOrderImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        LockAcquisitionException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, item, 1, true));
    verify(orderDao).createNewCartForCustomer(isA(Customer.class));
    verify(orderDao).readCartForCustomer(isNull());
    verify(customerImpl, atLeast(1)).getId();
    verify(customerService).saveCustomer(isNull());
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code
   * namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then calls {@link OrderServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"
  })
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder_thenCallsGetProxy()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.buildOrderItemRequestDTOFromOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new OrderItemRequestDTO());
    NullOrderImpl namedOrder = new NullOrderImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, item, 1, true));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).readCartForCustomer(isNull());
    verify(orderDao).readOrderById(isNull());
    verify(orderItemService).buildOrderItemRequestDTOFromOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)} with {@code
   * namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemFromNamedOrder(Order, OrderItem, int, boolean)"
  })
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder_whenZero()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), 0, true));
  }

  /**
   * Test {@link OrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addGiftWrapItemToOrder(Order,
   * GiftWrapOrderItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderServiceImpl.addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)"
  })
  public void testAddGiftWrapItemToOrder() throws PricingException {
    // Arrange
    when(orderItemService.createGiftWrapOrderItem(Mockito.<GiftWrapOrderItemRequest>any()))
        .thenThrow(new RuntimeException());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addGiftWrapItemToOrder(order, new GiftWrapOrderItemRequest(), true));
    verify(orderItemService).createGiftWrapOrderItem(isA(GiftWrapOrderItemRequest.class));
  }

  /**
   * Test {@link OrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addGiftWrapItemToOrder(Order,
   * GiftWrapOrderItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderServiceImpl.addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)"
  })
  public void testAddGiftWrapItemToOrder2() throws PricingException {
    // Arrange
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any()))
        .thenThrow(new RuntimeException());
    when(orderItemService.createGiftWrapOrderItem(Mockito.<GiftWrapOrderItemRequest>any()))
        .thenReturn(new GiftWrapOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addGiftWrapItemToOrder(order, new GiftWrapOrderItemRequest(), true));
    verify(orderItemService).createGiftWrapOrderItem(isA(GiftWrapOrderItemRequest.class));
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link OrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addGiftWrapItemToOrder(Order,
   * GiftWrapOrderItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderServiceImpl.addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)"
  })
  public void testAddGiftWrapItemToOrder_thenCallsCommit()
      throws PricingException, TransactionException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = mock(GiftWrapOrderItemImpl.class);
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    GiftWrapOrderItemImpl giftWrapOrderItemImpl2 = new GiftWrapOrderItemImpl();
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(giftWrapOrderItemImpl2);
    when(orderItemService.createGiftWrapOrderItem(Mockito.<GiftWrapOrderItemRequest>any()))
        .thenReturn(giftWrapOrderItemImpl);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(false);
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(order).addOrderItem(Mockito.<OrderItem>any());
    order.addOrderItem(new BundleOrderItemImpl());

    // Act
    OrderItem actualAddGiftWrapItemToOrderResult =
        orderServiceImpl.addGiftWrapItemToOrder(order, new GiftWrapOrderItemRequest(), false);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(giftWrapOrderItemImpl).setOrder(isA(Order.class));
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order).getOrderItems();
    verify(orderItemService).createGiftWrapOrderItem(isA(GiftWrapOrderItemRequest.class));
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(transactionStatus).isRollbackOnly();
    assertSame(giftWrapOrderItemImpl2, actualAddGiftWrapItemToOrderResult);
  }

  /**
   * Test {@link OrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#rollback(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addGiftWrapItemToOrder(Order,
   * GiftWrapOrderItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem OrderServiceImpl.addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)"
  })
  public void testAddGiftWrapItemToOrder_thenCallsRollback()
      throws PricingException, TransactionException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = mock(GiftWrapOrderItemImpl.class);
    doNothing().when(giftWrapOrderItemImpl).setOrder(Mockito.<Order>any());
    GiftWrapOrderItemImpl giftWrapOrderItemImpl2 = new GiftWrapOrderItemImpl();
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(giftWrapOrderItemImpl2);
    when(orderItemService.createGiftWrapOrderItem(Mockito.<GiftWrapOrderItemRequest>any()))
        .thenReturn(giftWrapOrderItemImpl);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(order).addOrderItem(Mockito.<OrderItem>any());
    order.addOrderItem(new BundleOrderItemImpl());

    // Act
    OrderItem actualAddGiftWrapItemToOrderResult =
        orderServiceImpl.addGiftWrapItemToOrder(order, new GiftWrapOrderItemRequest(), false);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(giftWrapOrderItemImpl).setOrder(isA(Order.class));
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order).getOrderItems();
    verify(orderItemService).createGiftWrapOrderItem(isA(GiftWrapOrderItemRequest.class));
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertSame(giftWrapOrderItemImpl2, actualAddGiftWrapItemToOrderResult);
  }

  /**
   * Test {@link OrderServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItem(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItem_givenOrderDaoReadOrderByIdThrowRuntimeException()
      throws AddToCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItem(1L, new OrderItemRequestDTO(), true));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link OrderServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.addItem(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItem_thenCallsGetProxy() throws AddToCartException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItem(1L, new OrderItemRequestDTO(), true));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link OrderServiceImpl#addItemWithPriceOverrides(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemWithPriceOverrides(Long,
   * OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemWithPriceOverrides(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemWithPriceOverrides_givenOrderDaoReadOrderByIdThrowRuntimeException()
      throws AddToCartException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemWithPriceOverrides(1L, new OrderItemRequestDTO(), true));
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link OrderServiceImpl#addItemWithPriceOverrides(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addItemWithPriceOverrides(Long,
   * OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OrderServiceImpl.addItemWithPriceOverrides(Long, OrderItemRequestDTO, boolean)"
  })
  public void testAddItemWithPriceOverrides_thenCallsGetProxy() throws AddToCartException {
    // Arrange
    when(orderServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.addItemWithPriceOverrides(1L, new OrderItemRequestDTO(), true));
    verify(orderServiceExtensionManager).getProxy();
    verify(orderDao).readOrderById(1L);
  }

  /**
   * Test {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int, ProcessContext,
   * List)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int,
   * ProcessContext, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderServiceImpl.addChildItems(OrderItemRequestDTO, int, int, ProcessContext, List)"
  })
  public void testAddChildItems() throws WorkflowException {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setQuantity(0);

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(nonDiscreteOrderItemRequestDTO);

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO2 =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO2.setQuantity(0);
    nonDiscreteOrderItemRequestDTO2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItemRequestDTO> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(nonDiscreteOrderItemRequestDTO2);

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setChildOrderItems(childOrderItems2);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrderItem(new BundleOrderItemImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    orderServiceImpl.addChildItems(orderItemRequestDTO, 10, 2, context, new ArrayList<>());
  }

  /**
   * Test {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int, ProcessContext,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link CartOperationRequest} {@link CartOperationRequest#getOrder()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int,
   * ProcessContext, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderServiceImpl.addChildItems(OrderItemRequestDTO, int, int, ProcessContext, List)"
  })
  public void testAddChildItems_givenCartOperationRequestGetOrderThrowRuntimeException()
      throws WorkflowException {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setQuantity(0);

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(nonDiscreteOrderItemRequestDTO);

    AddToCartItem addToCartItem = mock(AddToCartItem.class);
    when(addToCartItem.getQuantity()).thenReturn(1);
    when(addToCartItem.setQuantity(Mockito.<Integer>any())).thenReturn(new OrderItemRequestDTO());
    doNothing().when(addToCartItem).setChildOrderItems(Mockito.<List<OrderItemRequestDTO>>any());
    doNothing().when(addToCartItem).setParentOrderItemId(Mockito.<Long>any());
    addToCartItem.setQuantity(0);
    addToCartItem.setChildOrderItems(childOrderItems);

    ArrayList<OrderItemRequestDTO> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(addToCartItem);

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setChildOrderItems(childOrderItems2);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenThrow(new RuntimeException());
    when(cartOperationRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            orderServiceImpl.addChildItems(orderItemRequestDTO, 10, 2, context, new ArrayList<>()));
    verify(addToCartItem).getQuantity();
    verify(addToCartItem).setChildOrderItems(isA(List.class));
    verify(addToCartItem).setParentOrderItemId(isNull());
    verify(addToCartItem).setQuantity(0);
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).getOrderItem();
  }

  /**
   * Test {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int, ProcessContext,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link OrderServiceImpl} (default constructor).
   *   <li>Then calls {@link CartOperationRequest#getOrderItem()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int,
   * ProcessContext, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderServiceImpl.addChildItems(OrderItemRequestDTO, int, int, ProcessContext, List)"
  })
  public void testAddChildItems_givenOrderServiceImpl_thenCallsGetOrderItem()
      throws WorkflowException {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setQuantity(0);

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(nonDiscreteOrderItemRequestDTO);

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO2 =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO2.setQuantity(0);
    nonDiscreteOrderItemRequestDTO2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItemRequestDTO> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(nonDiscreteOrderItemRequestDTO2);

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setChildOrderItems(childOrderItems2);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    orderServiceImpl.addChildItems(orderItemRequestDTO, 10, 2, context, new ArrayList<>());

    // Assert
    verify(cartOperationRequest).getOrderItem();
  }

  /**
   * Test {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int, ProcessContext,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link OrderServiceImpl} (default constructor).
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int,
   * ProcessContext, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderServiceImpl.addChildItems(OrderItemRequestDTO, int, int, ProcessContext, List)"
  })
  public void testAddChildItems_givenOrderServiceImpl_whenOrderItemRequestDTO_thenDoesNotThrow()
      throws WorkflowException {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    orderServiceImpl.addChildItems(orderItemRequestDTO, 10, 2, context, new ArrayList<>());
  }

  /**
   * Test {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int, ProcessContext,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link AddToCartItem#getChildOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int,
   * ProcessContext, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderServiceImpl.addChildItems(OrderItemRequestDTO, int, int, ProcessContext, List)"
  })
  public void testAddChildItems_thenCallsGetChildOrderItems() throws WorkflowException {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setQuantity(0);

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(nonDiscreteOrderItemRequestDTO);

    AddToCartItem addToCartItem = mock(AddToCartItem.class);
    when(addToCartItem.getChildOrderItems()).thenThrow(new RuntimeException());
    when(addToCartItem.getQuantity()).thenReturn(1);
    when(addToCartItem.setQuantity(Mockito.<Integer>any())).thenReturn(new OrderItemRequestDTO());
    doNothing().when(addToCartItem).setChildOrderItems(Mockito.<List<OrderItemRequestDTO>>any());
    doNothing().when(addToCartItem).setParentOrderItemId(Mockito.<Long>any());
    addToCartItem.setQuantity(0);
    addToCartItem.setChildOrderItems(childOrderItems);

    ArrayList<OrderItemRequestDTO> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(addToCartItem);

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setChildOrderItems(childOrderItems2);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(new NullOrderImpl());
    when(cartOperationRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            orderServiceImpl.addChildItems(orderItemRequestDTO, 10, 2, context, new ArrayList<>()));
    verify(addToCartItem).getChildOrderItems();
    verify(addToCartItem).getQuantity();
    verify(addToCartItem).setChildOrderItems(isA(List.class));
    verify(addToCartItem).setParentOrderItemId(isNull());
    verify(addToCartItem).setQuantity(0);
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).getOrderItem();
  }

  /**
   * Test {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemRequestDTO#OrderItemRequestDTO()} ChildOrderItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderServiceImpl.addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)"
  })
  public void testAddDependentOrderItem_thenOrderItemRequestDTOChildOrderItemsSizeIsOne() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
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
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) ChildOrderItems is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderServiceImpl.findAllChildrenToRemove(List, OrderItem)"})
  public void testFindAllChildrenToRemove_givenBundleOrderItemImplChildOrderItemsIsNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   *
   * <ul>
   *   <li>Given {@link OrderServiceImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderServiceImpl.findAllChildrenToRemove(List, OrderItem)"})
  public void testFindAllChildrenToRemove_givenOrderServiceImpl_thenArrayListSizeIsOne() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());

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
   *
   * <ul>
   *   <li>Given {@link OrderServiceImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderServiceImpl.findAllChildrenToRemove(List, OrderItem)"})
  public void testFindAllChildrenToRemove_givenOrderServiceImpl_thenArrayListSizeIsThree() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(new BundleOrderItemImpl());

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
    bundleOrderItemImpl.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl);

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
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems2);

    ArrayList<OrderItem> childOrderItems3 = new ArrayList<>();
    childOrderItems3.add(bundleOrderItemImpl2);

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
    orderItem.setChildOrderItems(childOrderItems3);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(3, childrenToRemove.size());
    assertNull(childrenToRemove.get(0));
    assertEquals(1L, childrenToRemove.get(1).longValue());
    assertEquals(1L, childrenToRemove.get(2).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   *
   * <ul>
   *   <li>Given {@link OrderServiceImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderServiceImpl.findAllChildrenToRemove(List, OrderItem)"})
  public void testFindAllChildrenToRemove_givenOrderServiceImpl_thenArrayListSizeIsTwo() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());

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
   *
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderServiceImpl.findAllChildrenToRemove(List, OrderItem)"})
  public void testFindAllChildrenToRemove_whenBundleOrderItemImpl_thenArrayListEmpty() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, new BundleOrderItemImpl());

    // Assert that nothing has changed
    assertTrue(childrenToRemove.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderServiceImpl.getAutomaticallyMergeLikeItems()"})
  public void testGetAutomaticallyMergeLikeItems_thenReturnFalse() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    orderServiceImpl.setAutomaticallyMergeLikeItems(false);

    // Act and Assert
    assertFalse(orderServiceImpl.getAutomaticallyMergeLikeItems());
  }

  /**
   * Test {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#getAutomaticallyMergeLikeItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderServiceImpl.getAutomaticallyMergeLikeItems()"})
  public void testGetAutomaticallyMergeLikeItems_thenReturnTrue() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    orderServiceImpl.setAutomaticallyMergeLikeItems(true);

    // Act and Assert
    assertTrue(orderServiceImpl.getAutomaticallyMergeLikeItems());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderServiceImpl#setDeleteEmptyNamedOrders(boolean)}
   *   <li>{@link OrderServiceImpl#setMoveNamedOrderItems(boolean)}
   *   <li>{@link OrderServiceImpl#isDeleteEmptyNamedOrders()}
   *   <li>{@link OrderServiceImpl#isMoveNamedOrderItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderServiceImpl.isDeleteEmptyNamedOrders()",
    "boolean OrderServiceImpl.isMoveNamedOrderItems()",
    "void OrderServiceImpl.setDeleteEmptyNamedOrders(boolean)",
    "void OrderServiceImpl.setMoveNamedOrderItems(boolean)"
  })
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
   * Test {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderServiceImpl.compareAttributes(Map, OrderItemRequestDTO)"})
  public void testCompareAttributes_givenFoo_thenReturnFalse() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();
    item1Attributes.put("foo", new OrderItemAttributeImpl());

    // Act and Assert
    assertFalse(orderServiceImpl.compareAttributes(item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderServiceImpl.compareAttributes(Map, OrderItemRequestDTO)"})
  public void testCompareAttributes_givenFoo_thenReturnFalse2() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();
    item1Attributes.put("foo", new OrderItemAttributeImpl());

    NonDiscreteOrderItemRequestDTO item2 =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    item2.setItemAttributes(null);

    // Act and Assert
    assertFalse(orderServiceImpl.compareAttributes(item1Attributes, item2));
  }

  /**
   * Test {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderServiceImpl.compareAttributes(Map, OrderItemRequestDTO)"})
  public void testCompareAttributes_givenHashMap() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    NonDiscreteOrderItemRequestDTO item2 =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    item2.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertTrue(orderServiceImpl.compareAttributes(null, item2));
  }

  /**
   * Test {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderServiceImpl.compareAttributes(Map, OrderItemRequestDTO)"})
  public void testCompareAttributes_whenOrderItemRequestDTO_thenReturnTrue() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    // Act and Assert
    assertTrue(orderServiceImpl.compareAttributes(item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    NonDiscreteOrderItemRequestDTO itemToFind =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemToFind.setSkuId(1L);
    itemToFind.setProductId(42L);
    itemToFind.setItemAttributes(new HashMap<>());

    // Act
    orderServiceImpl.findMatchingItem(order, itemToFind);

    // Assert
    verify(skuImpl).getId();
    verify(bundleOrderItemImpl).getProduct();
    verify(bundleOrderItemImpl).getSku();
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem_givenArrayListAddBundleOrderItemImpl_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    NonDiscreteOrderItemRequestDTO itemToFind =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemToFind.setSkuId(42L);
    itemToFind.setProductId(42L);
    itemToFind.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertNull(orderServiceImpl.findMatchingItem(order, itemToFind));
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem_givenArrayListAddDiscreteOrderItemImpl_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    NonDiscreteOrderItemRequestDTO itemToFind =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemToFind.setSkuId(42L);
    itemToFind.setProductId(42L);
    itemToFind.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertNull(orderServiceImpl.findMatchingItem(order, itemToFind));
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem_givenOrderItemImplAuditableIsAuditable_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    NonDiscreteOrderItemRequestDTO itemToFind =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemToFind.setSkuId(42L);
    itemToFind.setProductId(42L);
    itemToFind.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertNull(orderServiceImpl.findMatchingItem(order, itemToFind));
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link OrderServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem_givenOrderServiceImpl_whenNull_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    // Act and Assert
    assertNull(orderServiceImpl.findMatchingItem(null, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem_givenSkuImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    NonDiscreteOrderItemRequestDTO itemToFind =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemToFind.setSkuId(42L);
    itemToFind.setProductId(42L);
    itemToFind.setItemAttributes(new HashMap<>());

    // Act
    OrderItem actualFindMatchingItemResult = orderServiceImpl.findMatchingItem(order, itemToFind);

    // Assert
    verify(skuImpl).getId();
    verify(bundleOrderItemImpl).getProduct();
    verify(bundleOrderItemImpl).getSku();
    assertNull(actualFindMatchingItemResult);
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem_thenReturnNull() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    NonDiscreteOrderItemRequestDTO itemToFind =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemToFind.setSkuId(42L);
    itemToFind.setProductId(42L);
    itemToFind.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertNull(orderServiceImpl.findMatchingItem(order, itemToFind));
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderServiceImpl.findMatchingItem(Order, OrderItemRequestDTO)"})
  public void testFindMatchingItem_thenThrowRuntimeException() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenThrow(new RuntimeException());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    NonDiscreteOrderItemRequestDTO itemToFind =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemToFind.setSkuId(42L);
    itemToFind.setProductId(42L);
    itemToFind.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> orderServiceImpl.findMatchingItem(order, itemToFind));
    verify(bundleOrderItemImpl).getSku();
  }

  /**
   * Test {@link OrderServiceImpl#acquireLock(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderDaoImpl} {@link OrderDaoImpl#acquireLock(Order)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#acquireLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderServiceImpl.acquireLock(Order)"})
  public void testAcquireLock_givenOrderDaoImplAcquireLockReturnFalse_thenReturnFalse() {
    // Arrange
    OrderDaoImpl orderDao = mock(OrderDaoImpl.class);
    when(orderDao.acquireLock(Mockito.<Order>any())).thenReturn(false);

    LegacyCartServiceImpl legacyCartServiceImpl = new LegacyCartServiceImpl();
    legacyCartServiceImpl.setOrderDao(orderDao);

    // Act
    boolean actualAcquireLockResult = legacyCartServiceImpl.acquireLock(new NullOrderImpl());

    // Assert
    verify(orderDao).acquireLock(isA(Order.class));
    assertFalse(actualAcquireLockResult);
  }

  /**
   * Test {@link OrderServiceImpl#acquireLock(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderDaoImpl} {@link OrderDaoImpl#acquireLock(Order)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#acquireLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderServiceImpl.acquireLock(Order)"})
  public void testAcquireLock_givenOrderDaoImplAcquireLockReturnTrue_thenReturnTrue() {
    // Arrange
    OrderDaoImpl orderDao = mock(OrderDaoImpl.class);
    when(orderDao.acquireLock(Mockito.<Order>any())).thenReturn(true);

    LegacyCartServiceImpl legacyCartServiceImpl = new LegacyCartServiceImpl();
    legacyCartServiceImpl.setOrderDao(orderDao);

    // Act
    boolean actualAcquireLockResult = legacyCartServiceImpl.acquireLock(new NullOrderImpl());

    // Assert
    verify(orderDao).acquireLock(isA(Order.class));
    assertTrue(actualAcquireLockResult);
  }

  /**
   * Test {@link OrderServiceImpl#acquireLock(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#acquireLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderServiceImpl.acquireLock(Order)"})
  public void testAcquireLock_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.acquireLock(Mockito.<Order>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderServiceImpl.acquireLock(new NullOrderImpl()));
    verify(orderDao).acquireLock(isA(Order.class));
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)} with {@code
   * customer}.
   *
   * <p>Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomer() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(
            Mockito.<Customer>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.findCartForCustomerWithEnhancements(new CustomerImpl()));
    verify(orderServiceExtensionManager)
        .findCartForCustomerWithEnhancements(isA(Customer.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)} with {@code
   * customer}.
   *
   * <p>Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomer2() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(
            Mockito.<Customer>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.findCartForCustomerWithEnhancements(new CustomerImpl()));
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    verify(orderServiceExtensionManager)
        .findCartForCustomerWithEnhancements(isA(Customer.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)} with {@code
   * customer}, {@code candidateOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer, Order)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateOrder() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(
            Mockito.<Customer>any(),
            Mockito.<Order>any(),
            Mockito.<ExtensionResultHolder<Object>>any()))
        .thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> orderServiceImpl.findCartForCustomerWithEnhancements(customer, new NullOrderImpl()));
    verify(orderServiceExtensionManager)
        .findCartForCustomerWithEnhancements(
            isA(Customer.class), isA(Order.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)} with {@code
   * customer}, {@code candidateOrder}.
   *
   * <p>Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer, Order)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateOrder2() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(
            Mockito.<Customer>any(),
            Mockito.<Order>any(),
            Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateOrder = new NullOrderImpl();

    // Act
    Order actualFindCartForCustomerWithEnhancementsResult =
        orderServiceImpl.findCartForCustomerWithEnhancements(customer, candidateOrder);

    // Assert
    verify(orderServiceExtensionManager)
        .findCartForCustomerWithEnhancements(
            isA(Customer.class), isA(Order.class), isA(ExtensionResultHolder.class));
    assertSame(candidateOrder, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)} with {@code
   * customer}, {@code candidateOrder}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer, Order)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateOrder_thenReturnNull() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(
            Mockito.<Customer>any(),
            Mockito.<Order>any(),
            Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    CustomerImpl customer = new CustomerImpl();

    // Act
    Order actualFindCartForCustomerWithEnhancementsResult =
        orderServiceImpl.findCartForCustomerWithEnhancements(customer, new NullOrderImpl());

    // Assert
    verify(orderServiceExtensionManager)
        .findCartForCustomerWithEnhancements(
            isA(Customer.class), isA(Order.class), isA(ExtensionResultHolder.class));
    assertNull(actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)} with {@code
   * customer}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomer_thenReturnNull() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(
            Mockito.<Customer>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    Order actualFindCartForCustomerWithEnhancementsResult =
        orderServiceImpl.findCartForCustomerWithEnhancements(new CustomerImpl());

    // Assert
    verify(orderServiceExtensionManager)
        .findCartForCustomerWithEnhancements(isA(Customer.class), isA(ExtensionResultHolder.class));
    assertNull(actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)} with {@code
   * customer}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderServiceImpl.findCartForCustomerWithEnhancements(Customer)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomer_thenReturnNullOrderImpl() {
    // Arrange
    when(orderServiceExtensionManager.findCartForCustomerWithEnhancements(
            Mockito.<Customer>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindCartForCustomerWithEnhancementsResult =
        orderServiceImpl.findCartForCustomerWithEnhancements(new CustomerImpl());

    // Assert
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    verify(orderServiceExtensionManager)
        .findCartForCustomerWithEnhancements(isA(Customer.class), isA(ExtensionResultHolder.class));
    assertSame(nullOrderImpl, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByEmail(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByEmail(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByEmail(String)"})
  public void testFindOrdersByEmail_thenReturnEmpty() {
    // Arrange
    when(orderDao.readOrdersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Order> actualFindOrdersByEmailResult =
        orderServiceImpl.findOrdersByEmail("jane.doe@example.org");

    // Assert
    verify(orderDao).readOrdersByEmail("jane.doe@example.org");
    assertTrue(actualFindOrdersByEmailResult.isEmpty());
  }

  /**
   * Test {@link OrderServiceImpl#findOrdersByEmail(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderServiceImpl#findOrdersByEmail(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderServiceImpl.findOrdersByEmail(String)"})
  public void testFindOrdersByEmail_thenThrowRuntimeException() {
    // Arrange
    when(orderDao.readOrdersByEmail(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> orderServiceImpl.findOrdersByEmail("jane.doe@example.org"));
    verify(orderDao).readOrdersByEmail("jane.doe@example.org");
  }
}
