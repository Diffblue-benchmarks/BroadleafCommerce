package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.AbstractPaymentGatewayConfiguration;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;
import org.broadleafcommerce.core.checkout.service.CheckoutService;
import org.broadleafcommerce.core.checkout.service.exception.CheckoutException;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultPaymentGatewayCheckoutServiceDiffblueTest {
  @Mock private CheckoutService checkoutService;

  @InjectMocks private DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService;

  @Mock private OrderPaymentService orderPaymentService;

  @Mock private OrderService orderService;

  @Mock private PaymentResponseDTOToEntityService paymentResponseDTOToEntityService;

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testApplyPaymentToOrder() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.applyPaymentToOrder(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(orderService).findOrderById(42L);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testApplyPaymentToOrder2() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(14L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(14L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer(
        "Cannot apply another payment to an Order that is not IN_PROCESS or CSR_OWNED");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setFirstName("");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(
        "Cannot apply another payment to an Order that is not IN_PROCESS or CSR_OWNED");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.CSR_OWNED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCustomer(customer);
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(orderImpl);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.applyPaymentToOrder(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(orderService).findOrderById(42L);
    verify(paymentResponseDTOToEntityService)
        .populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testApplyPaymentToOrder3() {
    // Arrange
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    when(orderPaymentService.create()).thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(14L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(14L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer(
        "Cannot apply another payment to an Order that is not IN_PROCESS or CSR_OWNED");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setFirstName("");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(
        "Cannot apply another payment to an Order that is not IN_PROCESS or CSR_OWNED");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.CSR_OWNED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCustomer(customer);
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(orderImpl);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.applyPaymentToOrder(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(orderService).findOrderById(42L);
    verify(orderPaymentService).create();
    verify(paymentResponseDTOToEntityService)
        .populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link DefaultPaymentGatewayCheckoutService} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testApplyPaymentToOrder_givenDefaultPaymentGatewayCheckoutService_whenNull() {
    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService =
        new DefaultPaymentGatewayCheckoutService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaymentResponseDTO} {@link PaymentResponseDTO#isValid()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testApplyPaymentToOrder_givenFalse_whenPaymentResponseDTOIsValidReturnFalse() {
    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService =
        new DefaultPaymentGatewayCheckoutService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.applyPaymentToOrder(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Status is {@link OrderStatus#ARCHIVED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testApplyPaymentToOrder_givenOrderImplStatusIsArchived() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(14L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(14L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer(
        "Cannot apply another payment to an Order that is not IN_PROCESS or CSR_OWNED");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setFirstName("");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(
        "Cannot apply another payment to an Order that is not IN_PROCESS or CSR_OWNED");
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
    orderImpl.setCustomer(customer);
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(orderImpl);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.applyPaymentToOrder(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(orderService).findOrderById(42L);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long)} return {@link
   *       NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testApplyPaymentToOrder_givenOrderServiceFindOrderByIdReturnNullOrderImpl() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.applyPaymentToOrder(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(orderService).findOrderById(42L);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testApplyPaymentToOrder_thenThrowIllegalArgumentException() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.applyPaymentToOrder(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(orderService).findOrderById(42L);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(OrderPayment)"
  })
  public void testHandleUnsuccessfulTransaction() {
    // Arrange
    when(orderPaymentService.readPaymentById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(
                new OrderPaymentImpl()));
    verify(orderPaymentService).readPaymentById(isNull());
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(OrderPayment)"
  })
  public void testHandleUnsuccessfulTransaction2() {
    // Arrange
    when(orderPaymentService.save(Mockito.<OrderPayment>any()))
        .thenThrow(new IllegalArgumentException());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any()))
        .thenReturn(new OrderPaymentImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(
                new OrderPaymentImpl()));
    verify(orderPaymentService).readPaymentById(isNull());
    verify(orderPaymentService).save(isA(OrderPayment.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(OrderPayment)"
  })
  public void testHandleUnsuccessfulTransaction3() {
    // Arrange
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(
                new OrderPaymentImpl()));
    verify(orderPaymentService).readPaymentById(isNull());
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderPaymentService#save(OrderPayment)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(OrderPayment)"
  })
  public void testHandleUnsuccessfulTransaction_thenCallsSave() {
    // Arrange
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any()))
        .thenReturn(new OrderPaymentImpl());

    // Act
    defaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(new OrderPaymentImpl());

    // Assert
    verify(orderPaymentService).readPaymentById(isNull());
    verify(orderPaymentService).save(isA(OrderPayment.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderPaymentImpl#setArchived(Character)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(OrderPayment)"
  })
  public void testHandleUnsuccessfulTransaction_thenCallsSetArchived() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doThrow(new IllegalArgumentException())
        .when(orderPaymentImpl)
        .setArchived(Mockito.<Character>any());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(orderPaymentImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(
                new OrderPaymentImpl()));
    verify(orderPaymentImpl).setArchived('Y');
    verify(orderPaymentService).readPaymentById(isNull());
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid() {
    // Arrange
    when(orderPaymentService.readPaymentById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L));
    verify(orderPaymentService).readPaymentById(1L);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid2() {
    // Arrange
    when(orderPaymentService.save(Mockito.<OrderPayment>any()))
        .thenThrow(new IllegalArgumentException());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any()))
        .thenReturn(new OrderPaymentImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L));
    verify(orderPaymentService).readPaymentById(1L);
    verify(orderPaymentService).save(isA(OrderPayment.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid3() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(orderPaymentImpl);

    // Act
    defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L);

    // Assert
    verify(orderPaymentService).readPaymentById(1L);
    verify(orderPaymentService).save(isA(OrderPayment.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentService} {@link OrderPaymentService#readPaymentById(Long)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid_givenOrderPaymentServiceReadPaymentByIdReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L));
    verify(orderPaymentService).readPaymentById(1L);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderPaymentService#save(OrderPayment)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid_thenCallsSave() {
    // Arrange
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any()))
        .thenReturn(new OrderPaymentImpl());

    // Act
    defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L);

    // Assert
    verify(orderPaymentService).readPaymentById(1L);
    verify(orderPaymentService).save(isA(OrderPayment.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderPaymentImpl#setArchived(Character)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid_thenCallsSetArchived() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doThrow(new IllegalArgumentException())
        .when(orderPaymentImpl)
        .setArchived(Mockito.<Character>any());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(orderPaymentImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L));
    verify(orderPaymentImpl).setArchived('Y');
    verify(orderPaymentService).readPaymentById(1L);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout() throws Exception {
    // Arrange
    when(checkoutService.performCheckout(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new OrderImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(orderService).findOrderById(1L, true);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_givenAuditableCreatedByIsOne_thenReturn42() throws Exception {
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
    orderImpl.setName("Order Number for Order ID: ");
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

    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    when(checkoutResponse.getOrder()).thenReturn(orderImpl);
    when(checkoutService.performCheckout(Mockito.<Order>any())).thenReturn(checkoutResponse);
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean()))
        .thenReturn(mock(OrderImpl.class));

    // Act
    String actualInitiateCheckoutResult = defaultPaymentGatewayCheckoutService.initiateCheckout(1L);

    // Assert
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(checkoutResponse, atLeast(1)).getOrder();
    verify(orderService).findOrderById(1L, true);
    assertEquals("42", actualInitiateCheckoutResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Given {@link CheckoutResponse} {@link CheckoutResponse#getOrder()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_givenCheckoutResponseGetOrderThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    when(checkoutResponse.getOrder()).thenThrow(new IllegalArgumentException());
    when(checkoutService.performCheckout(Mockito.<Order>any())).thenReturn(checkoutResponse);
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new OrderImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(checkoutResponse).getOrder();
    verify(orderService).findOrderById(1L, true);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long, boolean)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_givenOrderServiceFindOrderByIdReturnNull() throws Exception {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(orderService).findOrderById(1L, true);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long, boolean)} return
   *       {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_givenOrderServiceFindOrderByIdReturnNullOrderImpl()
      throws Exception {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(orderService).findOrderById(1L, true);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long, boolean)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_givenOrderServiceFindOrderByIdThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(orderService).findOrderById(1L, true);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_thenCallsGetId() throws Exception {
    // Arrange
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    when(checkoutResponse.getOrder()).thenReturn(new NullOrderImpl());
    when(checkoutService.performCheckout(Mockito.<Order>any())).thenReturn(checkoutResponse);

    OrderImpl orderImpl = mock(OrderImpl.class);
    when(orderImpl.getId()).thenThrow(new IllegalArgumentException());
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(orderImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(checkoutResponse).getOrder();
    verify(orderImpl).getId();
    verify(orderService).findOrderById(1L, true);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_thenReturnNull() throws Exception {
    // Arrange
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    when(checkoutResponse.getOrder()).thenReturn(new NullOrderImpl());
    when(checkoutService.performCheckout(Mockito.<Order>any())).thenReturn(checkoutResponse);
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new OrderImpl());

    // Act
    String actualInitiateCheckoutResult = defaultPaymentGatewayCheckoutService.initiateCheckout(1L);

    // Assert
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(checkoutResponse, atLeast(1)).getOrder();
    verify(orderService).findOrderById(1L, true);
    assertNull(actualInitiateCheckoutResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_thenThrowException() throws Exception {
    // Arrange
    when(checkoutService.performCheckout(Mockito.<Order>any())).thenThrow(new CheckoutException());
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new OrderImpl());

    // Act and Assert
    assertThrows(Exception.class, () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(orderService).findOrderById(1L, true);
  }

  /**
   * Test {@link
   * DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}.
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DefaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(PaymentResponseDTO)"
  })
  public void testLookupOrderNumberFromOrderId() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(responseDTO));
    verify(responseDTO).getOrderId();
    verify(orderService).findOrderById(42L, true);
  }

  /**
   * Test {@link
   * DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long, boolean)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DefaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(PaymentResponseDTO)"
  })
  public void testLookupOrderNumberFromOrderId_givenOrderServiceFindOrderByIdReturnNull() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(null);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(responseDTO));
    verify(responseDTO, atLeast(1)).getOrderId();
    verify(orderService).findOrderById(42L, true);
  }

  /**
   * Test {@link
   * DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link Order#getOrderNumber()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DefaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(PaymentResponseDTO)"
  })
  public void testLookupOrderNumberFromOrderId_thenCallsGetOrderNumber() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderNumber()).thenThrow(new IllegalArgumentException());
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(order);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(responseDTO));
    verify(responseDTO).getOrderId();
    verify(order).getOrderNumber();
    verify(orderService).findOrderById(42L, true);
  }

  /**
   * Test {@link
   * DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DefaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(PaymentResponseDTO)"
  })
  public void testLookupOrderNumberFromOrderId_thenReturnNull() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");

    // Act
    String actualLookupOrderNumberFromOrderIdResult =
        defaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(responseDTO);

    // Assert
    verify(responseDTO).getOrderId();
    verify(orderService).findOrderById(42L, true);
    assertNull(actualLookupOrderNumberFromOrderIdResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultPaymentGatewayCheckoutService#setUseBillingAddressFromGateway(boolean)}
   *   <li>{@link DefaultPaymentGatewayCheckoutService#isUseBillingAddressFromGateway()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultPaymentGatewayCheckoutService.isUseBillingAddressFromGateway()",
    "void DefaultPaymentGatewayCheckoutService.setUseBillingAddressFromGateway(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService =
        new DefaultPaymentGatewayCheckoutService();

    // Act
    defaultPaymentGatewayCheckoutService.setUseBillingAddressFromGateway(true);

    // Assert
    assertTrue(defaultPaymentGatewayCheckoutService.isUseBillingAddressFromGateway());
  }
}
