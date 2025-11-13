package org.broadleafcommerce.core.checkout.service.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.config.service.SystemPropertiesService;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.AbstractPaymentGatewayConfigurationService;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationServiceProvider;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.core.checkout.service.exception.CheckoutException;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.payment.service.SecureOrderPaymentService;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderPaymentConfirmationStrategyImplDiffblueTest {
  @InjectMocks private OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl;

  @Mock private OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;

  @Mock
  private PaymentGatewayConfigurationServiceProvider paymentGatewayConfigurationServiceProvider;

  @Mock private SecureOrderPaymentService secureOrderPaymentService;

  @Mock private SystemPropertiesService systemPropertiesService;

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction,
   * ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Customer is {@code null}.
   *   <li>Then return ResponseMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransaction(PaymentTransaction, ProcessContext)"
  })
  public void testConfirmTransaction_givenOrderImplCustomerIsNull_thenReturnResponseMapEmpty()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(
            Mockito.<Money>any(), Mockito.<PaymentTransaction>any(), anyBoolean()))
        .thenReturn(paymentRequestDTO);
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(
            Mockito.<PaymentGatewayType>any()))
        .thenReturn(new AbstractPaymentGatewayConfigurationService());
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any()))
        .thenReturn(true);

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
    orderImpl.setCustomer(null);
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

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType();
    when(orderPaymentImpl.getGatewayType()).thenReturn(paymentGatewayType);
    PaymentType paymentType = new PaymentType();
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());

    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    PaymentResponseDTO actualConfirmTransactionResult =
        orderPaymentConfirmationStrategyImpl.confirmTransaction(
            tx, new DefaultProcessContextImpl<>());

    // Assert
    verify(systemPropertiesService)
        .resolveBooleanSystemProperty("gateway.config.global.enablePendingPayments");
    verify(paymentRequestDTO).getAdditionalFields();
    verify(paymentRequestDTO).getTransactionTotal();
    verify(paymentGatewayConfigurationServiceProvider)
        .getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl, atLeast(1)).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService)
        .populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class), eq(true));
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConfirmTransactionResult.getRawResponse());
    assertNull(actualConfirmTransactionResult.getOrderId());
    assertNull(actualConfirmTransactionResult.getPaymentToken());
    assertNull(actualConfirmTransactionResult.getBillTo());
    assertNull(actualConfirmTransactionResult.getShipTo());
    assertNull(actualConfirmTransactionResult.getCreditCard());
    assertNull(actualConfirmTransactionResult.getCustomer());
    assertTrue(actualConfirmTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualConfirmTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualConfirmTransactionResult.getResponseMap().isEmpty());
    assertTrue(actualConfirmTransactionResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConfirmTransactionResult.isSuccessful());
    assertTrue(actualConfirmTransactionResult.isValid());
    assertSame(paymentGatewayType, actualConfirmTransactionResult.getPaymentGatewayType());
    assertSame(paymentType, actualConfirmTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction,
   * ProcessContext)}.
   *
   * <ul>
   *   <li>Then return ResponseMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransaction(PaymentTransaction, ProcessContext)"
  })
  public void testConfirmTransaction_thenReturnResponseMapEmpty()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(
            Mockito.<Money>any(), Mockito.<PaymentTransaction>any(), anyBoolean()))
        .thenReturn(paymentRequestDTO);
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(
            Mockito.<PaymentGatewayType>any()))
        .thenReturn(new AbstractPaymentGatewayConfigurationService());
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any()))
        .thenReturn(true);

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

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType();
    when(orderPaymentImpl.getGatewayType()).thenReturn(paymentGatewayType);
    PaymentType paymentType = new PaymentType();
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());

    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    PaymentResponseDTO actualConfirmTransactionResult =
        orderPaymentConfirmationStrategyImpl.confirmTransaction(
            tx, new DefaultProcessContextImpl<>());

    // Assert
    verify(systemPropertiesService)
        .resolveBooleanSystemProperty("gateway.config.global.enablePendingPayments");
    verify(paymentRequestDTO).getAdditionalFields();
    verify(paymentRequestDTO).getTransactionTotal();
    verify(paymentGatewayConfigurationServiceProvider)
        .getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl, atLeast(1)).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService)
        .populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class), eq(true));
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConfirmTransactionResult.getRawResponse());
    assertNull(actualConfirmTransactionResult.getOrderId());
    assertNull(actualConfirmTransactionResult.getPaymentToken());
    assertNull(actualConfirmTransactionResult.getBillTo());
    assertNull(actualConfirmTransactionResult.getShipTo());
    assertNull(actualConfirmTransactionResult.getCreditCard());
    assertNull(actualConfirmTransactionResult.getCustomer());
    assertTrue(actualConfirmTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualConfirmTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualConfirmTransactionResult.getResponseMap().isEmpty());
    assertTrue(actualConfirmTransactionResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConfirmTransactionResult.isSuccessful());
    assertTrue(actualConfirmTransactionResult.isValid());
    assertSame(paymentGatewayType, actualConfirmTransactionResult.getPaymentGatewayType());
    assertSame(paymentType, actualConfirmTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction,
   * ProcessContext)}.
   *
   * <ul>
   *   <li>Then return ResponseMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransaction(PaymentTransaction, ProcessContext)"
  })
  public void testConfirmTransaction_thenReturnResponseMapSizeIsOne()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("gateway.config.global.enablePendingPayments", "42");

    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getAdditionalFields()).thenReturn(stringObjectMap);
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(
            Mockito.<Money>any(), Mockito.<PaymentTransaction>any(), anyBoolean()))
        .thenReturn(paymentRequestDTO);
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(
            Mockito.<PaymentGatewayType>any()))
        .thenReturn(new AbstractPaymentGatewayConfigurationService());
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any()))
        .thenReturn(true);

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

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType();
    when(orderPaymentImpl.getGatewayType()).thenReturn(paymentGatewayType);
    PaymentType paymentType = new PaymentType();
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());

    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    PaymentResponseDTO actualConfirmTransactionResult =
        orderPaymentConfirmationStrategyImpl.confirmTransaction(
            tx, new DefaultProcessContextImpl<>());

    // Assert
    verify(systemPropertiesService)
        .resolveBooleanSystemProperty("gateway.config.global.enablePendingPayments");
    verify(paymentRequestDTO, atLeast(1)).getAdditionalFields();
    verify(paymentRequestDTO).getTransactionTotal();
    verify(paymentGatewayConfigurationServiceProvider)
        .getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl, atLeast(1)).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService)
        .populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class), eq(true));
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConfirmTransactionResult.getRawResponse());
    assertNull(actualConfirmTransactionResult.getOrderId());
    assertNull(actualConfirmTransactionResult.getPaymentToken());
    assertNull(actualConfirmTransactionResult.getBillTo());
    assertNull(actualConfirmTransactionResult.getShipTo());
    assertNull(actualConfirmTransactionResult.getCreditCard());
    assertNull(actualConfirmTransactionResult.getCustomer());
    Map<String, String> responseMap = actualConfirmTransactionResult.getResponseMap();
    assertEquals(1, responseMap.size());
    assertTrue(actualConfirmTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualConfirmTransactionResult.getGiftCards().isEmpty());
    assertTrue(responseMap.containsKey("gateway.config.global.enablePendingPayments"));
    assertTrue(actualConfirmTransactionResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConfirmTransactionResult.isSuccessful());
    assertTrue(actualConfirmTransactionResult.isValid());
    assertSame(paymentGatewayType, actualConfirmTransactionResult.getPaymentGatewayType());
    assertSame(paymentType, actualConfirmTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction,
   * ProcessContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CheckoutException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransaction(PaymentTransaction, ProcessContext)"
  })
  public void testConfirmTransaction_thenThrowCheckoutException()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl =
        new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl tx = new PaymentTransactionImpl();

    // Act and Assert
    assertThrows(
        CheckoutException.class,
        () ->
            orderPaymentConfirmationStrategyImpl.confirmTransaction(
                tx, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction,
   * ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Customer is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction,
   * ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmPendingTransaction(PaymentTransaction, ProcessContext)"
  })
  public void testConfirmPendingTransaction_givenOrderImplCustomerIsNull()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(
            Mockito.<Money>any(), Mockito.<PaymentTransaction>any(), anyBoolean()))
        .thenReturn(new PaymentRequestDTO());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(
            Mockito.<PaymentGatewayType>any()))
        .thenReturn(new AbstractPaymentGatewayConfigurationService());
    when(secureOrderPaymentService.findSecurePaymentInfo(
            Mockito.<String>any(), Mockito.<PaymentType>any()))
        .thenThrow(new WorkflowException("An error occurred"));

    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(null);
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

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getReferenceNumber()).thenReturn("42");
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());

    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act and Assert
    assertThrows(
        WorkflowException.class,
        () ->
            orderPaymentConfirmationStrategyImpl.confirmPendingTransaction(
                tx, new DefaultProcessContextImpl<>()));
    verify(paymentType).isCreditCardType();
    verify(paymentGatewayConfigurationServiceProvider)
        .getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl, atLeast(1)).getReferenceNumber();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService)
        .populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class), eq(true));
    verify(secureOrderPaymentService).findSecurePaymentInfo(eq("42"), isA(PaymentType.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction,
   * ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderToPaymentRequestDTOService#populateCustomerInfo(Order,
   *       PaymentRequestDTO)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction,
   * ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmPendingTransaction(PaymentTransaction, ProcessContext)"
  })
  public void testConfirmPendingTransaction_thenCallsPopulateCustomerInfo()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(
            Mockito.<Money>any(), Mockito.<PaymentTransaction>any(), anyBoolean()))
        .thenReturn(new PaymentRequestDTO());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(
            Mockito.<PaymentGatewayType>any()))
        .thenReturn(new AbstractPaymentGatewayConfigurationService());
    when(secureOrderPaymentService.findSecurePaymentInfo(
            Mockito.<String>any(), Mockito.<PaymentType>any()))
        .thenThrow(new WorkflowException("An error occurred"));

    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

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

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getReferenceNumber()).thenReturn("42");
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());

    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act and Assert
    assertThrows(
        WorkflowException.class,
        () ->
            orderPaymentConfirmationStrategyImpl.confirmPendingTransaction(
                tx, new DefaultProcessContextImpl<>()));
    verify(paymentType).isCreditCardType();
    verify(paymentGatewayConfigurationServiceProvider)
        .getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl, atLeast(1)).getReferenceNumber();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService)
        .populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class), eq(true));
    verify(secureOrderPaymentService).findSecurePaymentInfo(eq("42"), isA(PaymentType.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction,
   * ProcessContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CheckoutException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction,
   * ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmPendingTransaction(PaymentTransaction, ProcessContext)"
  })
  public void testConfirmPendingTransaction_thenThrowCheckoutException()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl =
        new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl tx = new PaymentTransactionImpl();

    // Act and Assert
    assertThrows(
        CheckoutException.class,
        () ->
            orderPaymentConfirmationStrategyImpl.confirmPendingTransaction(
                tx, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction,
   * ProcessContext, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Customer is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction,
   * ProcessContext, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransactionInternal(PaymentTransaction, ProcessContext, boolean)"
  })
  public void testConfirmTransactionInternal_givenOrderImplCustomerIsNull()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(
            Mockito.<Money>any(), Mockito.<PaymentTransaction>any(), anyBoolean()))
        .thenReturn(paymentRequestDTO);
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(
            Mockito.<PaymentGatewayType>any()))
        .thenReturn(new AbstractPaymentGatewayConfigurationService());
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any()))
        .thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(null);
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

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType();
    when(orderPaymentImpl.getGatewayType()).thenReturn(paymentGatewayType);
    PaymentType paymentType = new PaymentType();
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());

    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    PaymentResponseDTO actualConfirmTransactionInternalResult =
        orderPaymentConfirmationStrategyImpl.confirmTransactionInternal(
            tx, new DefaultProcessContextImpl<>(), true);

    // Assert
    verify(systemPropertiesService)
        .resolveBooleanSystemProperty("gateway.config.global.enablePendingPayments");
    verify(paymentRequestDTO).getAdditionalFields();
    verify(paymentRequestDTO).getTransactionTotal();
    verify(paymentGatewayConfigurationServiceProvider)
        .getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl, atLeast(1)).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService)
        .populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class), eq(true));
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConfirmTransactionInternalResult.getRawResponse());
    assertNull(actualConfirmTransactionInternalResult.getOrderId());
    assertNull(actualConfirmTransactionInternalResult.getPaymentToken());
    assertNull(actualConfirmTransactionInternalResult.getBillTo());
    assertNull(actualConfirmTransactionInternalResult.getShipTo());
    assertNull(actualConfirmTransactionInternalResult.getCreditCard());
    assertNull(actualConfirmTransactionInternalResult.getCustomer());
    assertTrue(actualConfirmTransactionInternalResult.getCustomerCredits().isEmpty());
    assertTrue(actualConfirmTransactionInternalResult.getGiftCards().isEmpty());
    assertTrue(actualConfirmTransactionInternalResult.getResponseMap().isEmpty());
    assertTrue(actualConfirmTransactionInternalResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConfirmTransactionInternalResult.isSuccessful());
    assertTrue(actualConfirmTransactionInternalResult.isValid());
    assertSame(paymentGatewayType, actualConfirmTransactionInternalResult.getPaymentGatewayType());
    assertSame(paymentType, actualConfirmTransactionInternalResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction,
   * ProcessContext, boolean)}.
   *
   * <ul>
   *   <li>Then return ResponseMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction,
   * ProcessContext, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransactionInternal(PaymentTransaction, ProcessContext, boolean)"
  })
  public void testConfirmTransactionInternal_thenReturnResponseMapEmpty()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(
            Mockito.<Money>any(), Mockito.<PaymentTransaction>any(), anyBoolean()))
        .thenReturn(paymentRequestDTO);
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(
            Mockito.<PaymentGatewayType>any()))
        .thenReturn(new AbstractPaymentGatewayConfigurationService());
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any()))
        .thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

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

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType();
    when(orderPaymentImpl.getGatewayType()).thenReturn(paymentGatewayType);
    PaymentType paymentType = new PaymentType();
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());

    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    PaymentResponseDTO actualConfirmTransactionInternalResult =
        orderPaymentConfirmationStrategyImpl.confirmTransactionInternal(
            tx, new DefaultProcessContextImpl<>(), true);

    // Assert
    verify(systemPropertiesService)
        .resolveBooleanSystemProperty("gateway.config.global.enablePendingPayments");
    verify(paymentRequestDTO).getAdditionalFields();
    verify(paymentRequestDTO).getTransactionTotal();
    verify(paymentGatewayConfigurationServiceProvider)
        .getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl, atLeast(1)).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService)
        .populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class), eq(true));
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConfirmTransactionInternalResult.getRawResponse());
    assertNull(actualConfirmTransactionInternalResult.getOrderId());
    assertNull(actualConfirmTransactionInternalResult.getPaymentToken());
    assertNull(actualConfirmTransactionInternalResult.getBillTo());
    assertNull(actualConfirmTransactionInternalResult.getShipTo());
    assertNull(actualConfirmTransactionInternalResult.getCreditCard());
    assertNull(actualConfirmTransactionInternalResult.getCustomer());
    assertTrue(actualConfirmTransactionInternalResult.getCustomerCredits().isEmpty());
    assertTrue(actualConfirmTransactionInternalResult.getGiftCards().isEmpty());
    assertTrue(actualConfirmTransactionInternalResult.getResponseMap().isEmpty());
    assertTrue(actualConfirmTransactionInternalResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConfirmTransactionInternalResult.isSuccessful());
    assertTrue(actualConfirmTransactionInternalResult.isValid());
    assertSame(paymentGatewayType, actualConfirmTransactionInternalResult.getPaymentGatewayType());
    assertSame(paymentType, actualConfirmTransactionInternalResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction,
   * ProcessContext, boolean)}.
   *
   * <ul>
   *   <li>Then return ResponseMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction,
   * ProcessContext, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransactionInternal(PaymentTransaction, ProcessContext, boolean)"
  })
  public void testConfirmTransactionInternal_thenReturnResponseMapSizeIsOne()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("gateway.config.global.enablePendingPayments", "42");

    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getAdditionalFields()).thenReturn(stringObjectMap);
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(
            Mockito.<Money>any(), Mockito.<PaymentTransaction>any(), anyBoolean()))
        .thenReturn(paymentRequestDTO);
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(
            Mockito.<PaymentGatewayType>any()))
        .thenReturn(new AbstractPaymentGatewayConfigurationService());
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any()))
        .thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

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

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType();
    when(orderPaymentImpl.getGatewayType()).thenReturn(paymentGatewayType);
    PaymentType paymentType = new PaymentType();
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());

    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    PaymentResponseDTO actualConfirmTransactionInternalResult =
        orderPaymentConfirmationStrategyImpl.confirmTransactionInternal(
            tx, new DefaultProcessContextImpl<>(), true);

    // Assert
    verify(systemPropertiesService)
        .resolveBooleanSystemProperty("gateway.config.global.enablePendingPayments");
    verify(paymentRequestDTO, atLeast(1)).getAdditionalFields();
    verify(paymentRequestDTO).getTransactionTotal();
    verify(paymentGatewayConfigurationServiceProvider)
        .getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl, atLeast(1)).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService)
        .populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService)
        .translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class), eq(true));
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConfirmTransactionInternalResult.getRawResponse());
    assertNull(actualConfirmTransactionInternalResult.getOrderId());
    assertNull(actualConfirmTransactionInternalResult.getPaymentToken());
    assertNull(actualConfirmTransactionInternalResult.getBillTo());
    assertNull(actualConfirmTransactionInternalResult.getShipTo());
    assertNull(actualConfirmTransactionInternalResult.getCreditCard());
    assertNull(actualConfirmTransactionInternalResult.getCustomer());
    Map<String, String> responseMap = actualConfirmTransactionInternalResult.getResponseMap();
    assertEquals(1, responseMap.size());
    assertTrue(actualConfirmTransactionInternalResult.getCustomerCredits().isEmpty());
    assertTrue(actualConfirmTransactionInternalResult.getGiftCards().isEmpty());
    assertTrue(responseMap.containsKey("gateway.config.global.enablePendingPayments"));
    assertTrue(actualConfirmTransactionInternalResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConfirmTransactionInternalResult.isSuccessful());
    assertTrue(actualConfirmTransactionInternalResult.isValid());
    assertSame(paymentGatewayType, actualConfirmTransactionInternalResult.getPaymentGatewayType());
    assertSame(paymentType, actualConfirmTransactionInternalResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction,
   * ProcessContext, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link CheckoutException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction,
   * ProcessContext, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransactionInternal(PaymentTransaction, ProcessContext, boolean)"
  })
  public void testConfirmTransactionInternal_thenThrowCheckoutException()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl =
        new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl tx = new PaymentTransactionImpl();

    // Act and Assert
    assertThrows(
        CheckoutException.class,
        () ->
            orderPaymentConfirmationStrategyImpl.confirmTransactionInternal(
                tx, new DefaultProcessContextImpl<>(), true));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentConfirmationStrategyImpl.orderContainsMultipleFinalPayments(Order)"
  })
  public void testOrderContainsMultipleFinalPayments() {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl =
        new OrderPaymentConfirmationStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.isActive()).thenReturn(true);

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
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setPayments(payments);

    // Act
    boolean actualOrderContainsMultipleFinalPaymentsResult =
        orderPaymentConfirmationStrategyImpl.orderContainsMultipleFinalPayments(order);

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentImpl).isFinalPayment();
    assertFalse(actualOrderContainsMultipleFinalPaymentsResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentConfirmationStrategyImpl.orderContainsMultipleFinalPayments(Order)"
  })
  public void testOrderContainsMultipleFinalPayments2() {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl =
        new OrderPaymentConfirmationStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(false);
    when(orderPaymentImpl.isActive()).thenReturn(true);

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
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setPayments(payments);

    // Act
    boolean actualOrderContainsMultipleFinalPaymentsResult =
        orderPaymentConfirmationStrategyImpl.orderContainsMultipleFinalPayments(order);

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentImpl).isFinalPayment();
    assertFalse(actualOrderContainsMultipleFinalPaymentsResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentConfirmationStrategyImpl.orderContainsMultipleFinalPayments(Order)"
  })
  public void testOrderContainsMultipleFinalPayments_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl =
        new OrderPaymentConfirmationStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

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
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setPayments(payments);

    // Act
    boolean actualOrderContainsMultipleFinalPaymentsResult =
        orderPaymentConfirmationStrategyImpl.orderContainsMultipleFinalPayments(order);

    // Assert
    verify(orderPaymentImpl).isActive();
    assertFalse(actualOrderContainsMultipleFinalPaymentsResult);
  }

  /**
   * Test {@link
   * OrderPaymentConfirmationStrategyImpl#transactionIsDetachedCreditRequest(PaymentTransaction)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#transactionIsDetachedCreditRequest(PaymentTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentConfirmationStrategyImpl.transactionIsDetachedCreditRequest(PaymentTransaction)"
  })
  public void testTransactionIsDetachedCreditRequest_thenReturnFalse() {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl =
        new OrderPaymentConfirmationStrategyImpl();

    // Act and Assert
    assertFalse(
        orderPaymentConfirmationStrategyImpl.transactionIsDetachedCreditRequest(
            new PaymentTransactionImpl()));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType,
   * PaymentGatewayType, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return ResponseMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType,
   * PaymentGatewayType, PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)"
  })
  public void testConstructPendingTransaction_givenHashMap_thenReturnResponseMapEmpty() {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl =
        new OrderPaymentConfirmationStrategyImpl();
    PaymentType paymentType = new PaymentType();
    PaymentGatewayType gatewayType = new PaymentGatewayType();

    PaymentRequestDTO confirmationRequest = mock(PaymentRequestDTO.class);
    when(confirmationRequest.getAdditionalFields()).thenReturn(new HashMap<>());
    when(confirmationRequest.getTransactionTotal()).thenReturn("42");

    // Act
    PaymentResponseDTO actualConstructPendingTransactionResult =
        orderPaymentConfirmationStrategyImpl.constructPendingTransaction(
            paymentType, gatewayType, confirmationRequest);

    // Assert
    verify(confirmationRequest).getAdditionalFields();
    verify(confirmationRequest).getTransactionTotal();
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConstructPendingTransactionResult.getRawResponse());
    assertNull(actualConstructPendingTransactionResult.getOrderId());
    assertNull(actualConstructPendingTransactionResult.getPaymentToken());
    assertNull(actualConstructPendingTransactionResult.getBillTo());
    assertNull(actualConstructPendingTransactionResult.getShipTo());
    assertNull(actualConstructPendingTransactionResult.getCreditCard());
    assertNull(actualConstructPendingTransactionResult.getCustomer());
    assertTrue(actualConstructPendingTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.getResponseMap().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConstructPendingTransactionResult.isSuccessful());
    assertTrue(actualConstructPendingTransactionResult.isValid());
    assertSame(gatewayType, actualConstructPendingTransactionResult.getPaymentGatewayType());
    assertSame(paymentType, actualConstructPendingTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType,
   * PaymentGatewayType, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Then return ResponseMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType,
   * PaymentGatewayType, PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)"
  })
  public void testConstructPendingTransaction_thenReturnResponseMapSizeIsOne() {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl =
        new OrderPaymentConfirmationStrategyImpl();
    PaymentType paymentType = new PaymentType();
    PaymentGatewayType gatewayType = new PaymentGatewayType();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("currency.default", "42");

    PaymentRequestDTO confirmationRequest = mock(PaymentRequestDTO.class);
    when(confirmationRequest.getAdditionalFields()).thenReturn(stringObjectMap);
    when(confirmationRequest.getTransactionTotal()).thenReturn("42");

    // Act
    PaymentResponseDTO actualConstructPendingTransactionResult =
        orderPaymentConfirmationStrategyImpl.constructPendingTransaction(
            paymentType, gatewayType, confirmationRequest);

    // Assert
    verify(confirmationRequest, atLeast(1)).getAdditionalFields();
    verify(confirmationRequest).getTransactionTotal();
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConstructPendingTransactionResult.getRawResponse());
    assertNull(actualConstructPendingTransactionResult.getOrderId());
    assertNull(actualConstructPendingTransactionResult.getPaymentToken());
    assertNull(actualConstructPendingTransactionResult.getBillTo());
    assertNull(actualConstructPendingTransactionResult.getShipTo());
    assertNull(actualConstructPendingTransactionResult.getCreditCard());
    assertNull(actualConstructPendingTransactionResult.getCustomer());
    Map<String, String> responseMap = actualConstructPendingTransactionResult.getResponseMap();
    assertEquals(1, responseMap.size());
    assertTrue(actualConstructPendingTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.getGiftCards().isEmpty());
    assertTrue(responseMap.containsKey("currency.default"));
    assertTrue(actualConstructPendingTransactionResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConstructPendingTransactionResult.isSuccessful());
    assertTrue(actualConstructPendingTransactionResult.isValid());
    assertSame(gatewayType, actualConstructPendingTransactionResult.getPaymentGatewayType());
    assertSame(paymentType, actualConstructPendingTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#populateCreditCardOnRequest(PaymentRequestDTO,
   * OrderPayment)}.
   *
   * <ul>
   *   <li>Then throw {@link WorkflowException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#populateCreditCardOnRequest(PaymentRequestDTO,
   * OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderPaymentConfirmationStrategyImpl.populateCreditCardOnRequest(PaymentRequestDTO, OrderPayment)"
  })
  public void testPopulateCreditCardOnRequest_thenThrowWorkflowException()
      throws WorkflowException {
    // Arrange
    when(secureOrderPaymentService.findSecurePaymentInfo(
            Mockito.<String>any(), Mockito.<PaymentType>any()))
        .thenThrow(new WorkflowException("An error occurred"));
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setOrder(new NullOrderImpl());
    payment.setPaymentGatewayType(new PaymentGatewayType());
    payment.setTransactions(new ArrayList<>());
    payment.setType(new PaymentType());
    payment.setReferenceNumber("Payment");

    // Act and Assert
    assertThrows(
        WorkflowException.class,
        () ->
            orderPaymentConfirmationStrategyImpl.populateCreditCardOnRequest(requestDTO, payment));
    verify(secureOrderPaymentService).findSecurePaymentInfo(eq("Payment"), isA(PaymentType.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#populateCreditCardOnRequest(PaymentRequestDTO,
   * OrderPayment)}.
   *
   * <ul>
   *   <li>When {@link OrderPaymentImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#populateCreditCardOnRequest(PaymentRequestDTO,
   * OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderPaymentConfirmationStrategyImpl.populateCreditCardOnRequest(PaymentRequestDTO, OrderPayment)"
  })
  public void testPopulateCreditCardOnRequest_whenOrderPaymentImpl_thenDoesNotThrow()
      throws WorkflowException {
    // Arrange
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act and Assert
    orderPaymentConfirmationStrategyImpl.populateCreditCardOnRequest(
        requestDTO, new OrderPaymentImpl());
  }

  /**
   * Test {@link
   * OrderPaymentConfirmationStrategyImpl#populateBillingAddressOnRequest(PaymentRequestDTO,
   * OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderToPaymentRequestDTOService#populateBillTo(Order,
   *       PaymentRequestDTO)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#populateBillingAddressOnRequest(PaymentRequestDTO,
   * OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderPaymentConfirmationStrategyImpl.populateBillingAddressOnRequest(PaymentRequestDTO, OrderPayment)"
  })
  public void testPopulateBillingAddressOnRequest_thenCallsPopulateBillTo() {
    // Arrange
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setId(1L);
    payment.setOrder(new NullOrderImpl());
    payment.setPaymentGatewayType(new PaymentGatewayType());
    payment.setReferenceNumber("42");
    payment.setTransactions(new ArrayList<>());
    payment.setType(new PaymentType());
    payment.setBillingAddress(new AddressImpl());

    // Act
    orderPaymentConfirmationStrategyImpl.populateBillingAddressOnRequest(requestDTO, payment);

    // Assert
    verify(orderToPaymentRequestDTOService)
        .populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#populateCustomerOnRequest(PaymentRequestDTO,
   * OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderToPaymentRequestDTOService#populateCustomerInfo(Order,
   *       PaymentRequestDTO)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#populateCustomerOnRequest(PaymentRequestDTO,
   * OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderPaymentConfirmationStrategyImpl.populateCustomerOnRequest(PaymentRequestDTO, OrderPayment)"
  })
  public void testPopulateCustomerOnRequest_thenCallsPopulateCustomerInfo() {
    // Arrange
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

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
    order.setCustomer(new CustomerImpl());

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setPaymentGatewayType(new PaymentGatewayType());
    payment.setReferenceNumber("42");
    payment.setTransactions(new ArrayList<>());
    payment.setType(new PaymentType());
    payment.setOrder(order);

    // Act
    orderPaymentConfirmationStrategyImpl.populateCustomerOnRequest(requestDTO, payment);

    // Assert
    verify(orderToPaymentRequestDTOService)
        .populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
  }

  /**
   * Test {@link
   * OrderPaymentConfirmationStrategyImpl#populateShippingAddressOnRequest(PaymentRequestDTO,
   * OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderToPaymentRequestDTOService#populateShipTo(Order,
   *       PaymentRequestDTO)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#populateShippingAddressOnRequest(PaymentRequestDTO,
   * OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderPaymentConfirmationStrategyImpl.populateShippingAddressOnRequest(PaymentRequestDTO, OrderPayment)"
  })
  public void testPopulateShippingAddressOnRequest_thenCallsPopulateShipTo() {
    // Arrange
    doNothing()
        .when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setPaymentGatewayType(new PaymentGatewayType());
    payment.setReferenceNumber("42");
    payment.setTransactions(new ArrayList<>());
    payment.setType(new PaymentType());
    payment.setOrder(new NullOrderImpl());

    // Act
    orderPaymentConfirmationStrategyImpl.populateShippingAddressOnRequest(requestDTO, payment);

    // Assert
    verify(orderToPaymentRequestDTOService)
        .populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OrderPaymentConfirmationStrategyImpl.constructExpirationDate(Integer, Integer)"
  })
  public void testConstructExpirationDate() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn(" ");

    // Act
    String actualConstructExpirationDateResult =
        orderPaymentConfirmationStrategyImpl.constructExpirationDate(1, 1);

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("gateway.config.global.expDateFormat");
    assertEquals("01/01", actualConstructExpirationDateResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OrderPaymentConfirmationStrategyImpl.constructExpirationDate(Integer, Integer)"
  })
  public void testConstructExpirationDate2() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("");

    // Act
    String actualConstructExpirationDateResult =
        orderPaymentConfirmationStrategyImpl.constructExpirationDate(1, 1);

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("gateway.config.global.expDateFormat");
    assertEquals("01/01", actualConstructExpirationDateResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OrderPaymentConfirmationStrategyImpl.constructExpirationDate(Integer, Integer)"
  })
  public void testConstructExpirationDate_thenReturn42() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("42");

    // Act
    String actualConstructExpirationDateResult =
        orderPaymentConfirmationStrategyImpl.constructExpirationDate(1, 1);

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("gateway.config.global.expDateFormat");
    assertEquals("42", actualConstructExpirationDateResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}.
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OrderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat()"
  })
  public void testGetGatewayExpirationDateFormat() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn(" ");

    // Act
    String actualGatewayExpirationDateFormat =
        orderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat();

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("gateway.config.global.expDateFormat");
    assertEquals("MM/YY", actualGatewayExpirationDateFormat);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}.
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OrderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat()"
  })
  public void testGetGatewayExpirationDateFormat2() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("");

    // Act
    String actualGatewayExpirationDateFormat =
        orderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat();

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("gateway.config.global.expDateFormat");
    assertEquals("MM/YY", actualGatewayExpirationDateFormat);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}.
   *
   * <ul>
   *   <li>Then return {@code Resolve System Property}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OrderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat()"
  })
  public void testGetGatewayExpirationDateFormat_thenReturnResolveSystemProperty() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any()))
        .thenReturn("Resolve System Property");

    // Act
    String actualGatewayExpirationDateFormat =
        orderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat();

    // Assert
    verify(systemPropertiesService).resolveSystemProperty("gateway.config.global.expDateFormat");
    assertEquals("Resolve System Property", actualGatewayExpirationDateFormat);
  }

  /**
   * Test {@link
   * OrderPaymentConfirmationStrategyImpl#enablePendingPaymentsOnCheckoutConfirmation()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#enablePendingPaymentsOnCheckoutConfirmation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentConfirmationStrategyImpl.enablePendingPaymentsOnCheckoutConfirmation()"
  })
  public void testEnablePendingPaymentsOnCheckoutConfirmation_thenReturnFalse() {
    // Arrange
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualEnablePendingPaymentsOnCheckoutConfirmationResult =
        orderPaymentConfirmationStrategyImpl.enablePendingPaymentsOnCheckoutConfirmation();

    // Assert
    verify(systemPropertiesService)
        .resolveBooleanSystemProperty("gateway.config.global.enablePendingPayments");
    assertFalse(actualEnablePendingPaymentsOnCheckoutConfirmationResult);
  }

  /**
   * Test {@link
   * OrderPaymentConfirmationStrategyImpl#enablePendingPaymentsOnCheckoutConfirmation()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentConfirmationStrategyImpl#enablePendingPaymentsOnCheckoutConfirmation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentConfirmationStrategyImpl.enablePendingPaymentsOnCheckoutConfirmation()"
  })
  public void testEnablePendingPaymentsOnCheckoutConfirmation_thenReturnTrue() {
    // Arrange
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualEnablePendingPaymentsOnCheckoutConfirmationResult =
        orderPaymentConfirmationStrategyImpl.enablePendingPaymentsOnCheckoutConfirmation();

    // Assert
    verify(systemPropertiesService)
        .resolveBooleanSystemProperty("gateway.config.global.enablePendingPayments");
    assertTrue(actualEnablePendingPaymentsOnCheckoutConfirmationResult);
  }
}
