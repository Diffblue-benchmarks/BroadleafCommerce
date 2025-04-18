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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.persistence.PostLoaderDao;
import org.broadleafcommerce.core.offer.domain.CandidateOrderOffer;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferInfo;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderAttribute;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.call.ActivityMessageDTO;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl.NameResponse;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderToPaymentRequestDTOServiceImplDiffblueTest {
  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks
  private OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;

  @Mock
  private PaymentRequestDTOService paymentRequestDTOService;

  @Mock
  private PostLoaderDao postLoaderDao;

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and {@link NameResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NameResponse#equals(Object)}
   *   <li>{@link NameResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and {@link NameResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NameResponse#equals(Object)}
   *   <li>{@link NameResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse.setFirstName("Jane");

    NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse2.setFirstName("Jane");

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and {@link NameResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NameResponse#equals(Object)}
   *   <li>{@link NameResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse.setLastName("Doe");

    NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse2.setLastName("Doe");

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and {@link NameResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NameResponse#equals(Object)}
   *   <li>{@link NameResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();

    // Act and Assert
    assertEquals(nameResponse, nameResponse);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new OrderToPaymentRequestDTOServiceImpl()).new NameResponse(), 1);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(nameResponse, (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse.setLastName("Doe");

    // Act and Assert
    assertNotEquals(nameResponse, (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();

    NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse2.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(nameResponse, nameResponse2);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();

    NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse2.setLastName("Doe");

    // Act and Assert
    assertNotEquals(nameResponse, nameResponse2);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new OrderToPaymentRequestDTOServiceImpl()).new NameResponse(), null);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new OrderToPaymentRequestDTOServiceImpl()).new NameResponse(), "Different type to NameResponse");
  }

  /**
   * Test NameResponse getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NameResponse#NameResponse(OrderToPaymentRequestDTOServiceImpl)}
   *   <li>{@link NameResponse#setFirstName(String)}
   *   <li>{@link NameResponse#setLastName(String)}
   *   <li>{@link NameResponse#toString()}
   *   <li>{@link NameResponse#getFirstName()}
   *   <li>{@link NameResponse#getLastName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NameResponse.<init>(OrderToPaymentRequestDTOServiceImpl)",
      "String NameResponse.getFirstName()", "String NameResponse.getLastName()",
      "void NameResponse.setFirstName(String)", "void NameResponse.setLastName(String)",
      "String NameResponse.toString()"})
  public void testNameResponseGettersAndSetters() {
    // Arrange and Act
    NameResponse actualNameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    actualNameResponse.setFirstName("Jane");
    actualNameResponse.setLastName("Doe");
    String actualToStringResult = actualNameResponse.toString();
    String actualFirstName = actualNameResponse.getFirstName();

    // Assert
    assertEquals("Doe", actualNameResponse.getLastName());
    assertEquals("Jane", actualFirstName);
    assertEquals("OrderToPaymentRequestDTOServiceImpl.NameResponse(firstName=Jane, lastName=Doe)",
        actualToStringResult);
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   * <ul>
   *   <li>Given {@link PaymentRequestDTOService}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_givenPaymentRequestDTOService_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderToPaymentRequestDTOServiceImpl.translateOrder(null));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_whenNullOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderToPaymentRequestDTOServiceImpl.translateOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)} with {@code transactionAmount}, {@code paymentTransaction}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransaction() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

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
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl());

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    assertEquals("1", actualTranslatePaymentTransactionResult.getOrderId());
    assertEquals("2.3", actualTranslatePaymentTransactionResult.getOrderSubtotal());
    assertEquals("2.3", actualTranslatePaymentTransactionResult.getTransactionTotal());
    assertNull(actualTranslatePaymentTransactionResult.getOrderCurrencyCode());
    assertNull(actualTranslatePaymentTransactionResult.getOrderDescription());
    assertNull(actualTranslatePaymentTransactionResult.getGatewayRequestType());
    assertNull(actualTranslatePaymentTransactionResult.getBillTo());
    assertNull(actualTranslatePaymentTransactionResult.getShipTo());
    assertNull(actualTranslatePaymentTransactionResult.getCreditCard());
    assertNull(actualTranslatePaymentTransactionResult.getCustomer());
    assertNull(actualTranslatePaymentTransactionResult.getSubscription());
    assertTrue(actualTranslatePaymentTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getLineItems().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.isCompleteCheckoutOnCallback());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL,
        actualTranslatePaymentTransactionResult.getShippingTotal());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL, actualTranslatePaymentTransactionResult.getTaxTotal());
    assertSame(paymentType, actualTranslatePaymentTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)} with {@code transactionAmount}, {@code paymentTransaction}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransaction2() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

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
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL, OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(stringStringMap);
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl());

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    Map<String, Object> additionalFields = actualTranslatePaymentTransactionResult.getAdditionalFields();
    assertEquals(1, additionalFields.size());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL,
        additionalFields.get(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)} with {@code transactionAmount}, {@code paymentTransaction}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransaction3() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl());

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    assertEquals("1", actualTranslatePaymentTransactionResult.getOrderId());
    assertEquals("2.3", actualTranslatePaymentTransactionResult.getOrderSubtotal());
    assertEquals("2.3", actualTranslatePaymentTransactionResult.getTransactionTotal());
    assertNull(actualTranslatePaymentTransactionResult.getOrderCurrencyCode());
    assertNull(actualTranslatePaymentTransactionResult.getOrderDescription());
    assertNull(actualTranslatePaymentTransactionResult.getGatewayRequestType());
    assertNull(actualTranslatePaymentTransactionResult.getBillTo());
    assertNull(actualTranslatePaymentTransactionResult.getShipTo());
    assertNull(actualTranslatePaymentTransactionResult.getCreditCard());
    assertNull(actualTranslatePaymentTransactionResult.getCustomer());
    assertNull(actualTranslatePaymentTransactionResult.getSubscription());
    assertTrue(actualTranslatePaymentTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getLineItems().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.isCompleteCheckoutOnCallback());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL,
        actualTranslatePaymentTransactionResult.getShippingTotal());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL, actualTranslatePaymentTransactionResult.getTaxTotal());
    assertSame(paymentType, actualTranslatePaymentTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)} with {@code transactionAmount}, {@code paymentTransaction}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransaction4() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any())).thenReturn(null);
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl());

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    assertEquals("1", actualTranslatePaymentTransactionResult.getOrderId());
    assertEquals("2.3", actualTranslatePaymentTransactionResult.getOrderSubtotal());
    assertEquals("2.3", actualTranslatePaymentTransactionResult.getTransactionTotal());
    assertNull(actualTranslatePaymentTransactionResult.getOrderCurrencyCode());
    assertNull(actualTranslatePaymentTransactionResult.getOrderDescription());
    assertNull(actualTranslatePaymentTransactionResult.getGatewayRequestType());
    assertNull(actualTranslatePaymentTransactionResult.getBillTo());
    assertNull(actualTranslatePaymentTransactionResult.getShipTo());
    assertNull(actualTranslatePaymentTransactionResult.getCreditCard());
    assertNull(actualTranslatePaymentTransactionResult.getCustomer());
    assertNull(actualTranslatePaymentTransactionResult.getSubscription());
    assertTrue(actualTranslatePaymentTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getLineItems().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.isCompleteCheckoutOnCallback());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL,
        actualTranslatePaymentTransactionResult.getShippingTotal());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL, actualTranslatePaymentTransactionResult.getTaxTotal());
    assertSame(paymentType, actualTranslatePaymentTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)} with {@code transactionAmount}, {@code paymentTransaction}, {@code autoCalculateFinalPaymentTotals}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction, boolean)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransactionAutoCalculateFinalPaymentTotals() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    OrderImpl orderImpl = mock(OrderImpl.class);
    when(orderImpl.getSubTotal()).thenReturn(new Money());
    when(orderImpl.getId()).thenReturn(1L);
    when(orderImpl.getEmailAddress()).thenReturn("42 Main St");
    when(orderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(orderImpl.getPayments()).thenReturn(new ArrayList<>());
    when(orderImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(orderImpl.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(orderImpl.getTotalShipping()).thenReturn(new Money());
    when(orderImpl.getTotalTax()).thenReturn(new Money());
    when(orderImpl.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(orderImpl).setAdditionalOfferInformation(Mockito.<Map<Offer, OfferInfo>>any());
    doNothing().when(orderImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(orderImpl).setCandidateOrderOffers(Mockito.<List<CandidateOrderOffer>>any());
    doNothing().when(orderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(orderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(orderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(orderImpl).setFulfillmentGroups(Mockito.<List<FulfillmentGroup>>any());
    doNothing().when(orderImpl).setId(Mockito.<Long>any());
    doNothing().when(orderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(orderImpl).setName(Mockito.<String>any());
    doNothing().when(orderImpl).setOrderAttributes(Mockito.<Map<String, OrderAttribute>>any());
    doNothing().when(orderImpl).setOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(orderImpl).setOrderMessages(Mockito.<List<ActivityMessageDTO>>any());
    doNothing().when(orderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(orderImpl).setPayments(Mockito.<List<OrderPayment>>any());
    doNothing().when(orderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(orderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(orderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(orderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalTax(Mockito.<Money>any());
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl(), true);

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(orderImpl).getCurrency();
    verify(orderImpl).getCustomer();
    verify(orderImpl).getEmailAddress();
    verify(orderImpl).getFulfillmentGroups();
    verify(orderImpl).getId();
    verify(orderImpl).getPayments();
    verify(orderImpl, atLeast(1)).getSubTotal();
    verify(orderImpl, atLeast(1)).getTotalAfterAppliedPayments();
    verify(orderImpl, atLeast(1)).getTotalShipping();
    verify(orderImpl, atLeast(1)).getTotalTax();
    verify(orderImpl).setAdditionalOfferInformation(isA(Map.class));
    verify(orderImpl).setAuditable(isA(Auditable.class));
    verify(orderImpl).setCandidateOrderOffers(isA(List.class));
    verify(orderImpl).setCurrency(isA(BroadleafCurrency.class));
    verify(orderImpl).setCustomer(isA(Customer.class));
    verify(orderImpl).setEmailAddress(eq("42 Main St"));
    verify(orderImpl).setFulfillmentGroups(isA(List.class));
    verify(orderImpl).setId(eq(1L));
    verify(orderImpl).setLocale(isA(Locale.class));
    verify(orderImpl).setName(eq("0"));
    verify(orderImpl).setOrderAttributes(isA(Map.class));
    verify(orderImpl).setOrderItems(isA(List.class));
    verify(orderImpl).setOrderMessages(isA(List.class));
    verify(orderImpl).setOrderNumber(eq("42"));
    verify(orderImpl).setPayments(isA(List.class));
    verify(orderImpl).setStatus(isA(OrderStatus.class));
    verify(orderImpl).setSubTotal(isA(Money.class));
    verify(orderImpl).setSubmitDate(isA(Date.class));
    verify(orderImpl).setTaxOverride(eq(true));
    verify(orderImpl).setTotal(isA(Money.class));
    verify(orderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(orderImpl).setTotalTax(isA(Money.class));
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getOrderSubtotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getShippingTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTaxTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTransactionTotal());
    assertEquals("1", actualTranslatePaymentTransactionResult.getOrderId());
    assertNull(actualTranslatePaymentTransactionResult.getOrderCurrencyCode());
    assertNull(actualTranslatePaymentTransactionResult.getOrderDescription());
    assertNull(actualTranslatePaymentTransactionResult.getGatewayRequestType());
    assertNull(actualTranslatePaymentTransactionResult.getBillTo());
    assertNull(actualTranslatePaymentTransactionResult.getShipTo());
    assertNull(actualTranslatePaymentTransactionResult.getCreditCard());
    assertNull(actualTranslatePaymentTransactionResult.getCustomer());
    assertNull(actualTranslatePaymentTransactionResult.getSubscription());
    assertTrue(actualTranslatePaymentTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getLineItems().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.isCompleteCheckoutOnCallback());
    assertSame(paymentType, actualTranslatePaymentTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)} with {@code transactionAmount}, {@code paymentTransaction}, {@code autoCalculateFinalPaymentTotals}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction, boolean)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransactionAutoCalculateFinalPaymentTotals2() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    OrderImpl orderImpl = mock(OrderImpl.class);
    when(orderImpl.getSubTotal()).thenReturn(new Money());
    when(orderImpl.getId()).thenReturn(1L);
    when(orderImpl.getEmailAddress()).thenReturn("42 Main St");
    when(orderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(orderImpl.getPayments()).thenReturn(new ArrayList<>());
    when(orderImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(orderImpl.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(orderImpl.getTotalShipping()).thenReturn(new Money());
    when(orderImpl.getTotalTax()).thenReturn(new Money());
    when(orderImpl.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(orderImpl).setAdditionalOfferInformation(Mockito.<Map<Offer, OfferInfo>>any());
    doNothing().when(orderImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(orderImpl).setCandidateOrderOffers(Mockito.<List<CandidateOrderOffer>>any());
    doNothing().when(orderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(orderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(orderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(orderImpl).setFulfillmentGroups(Mockito.<List<FulfillmentGroup>>any());
    doNothing().when(orderImpl).setId(Mockito.<Long>any());
    doNothing().when(orderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(orderImpl).setName(Mockito.<String>any());
    doNothing().when(orderImpl).setOrderAttributes(Mockito.<Map<String, OrderAttribute>>any());
    doNothing().when(orderImpl).setOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(orderImpl).setOrderMessages(Mockito.<List<ActivityMessageDTO>>any());
    doNothing().when(orderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(orderImpl).setPayments(Mockito.<List<OrderPayment>>any());
    doNothing().when(orderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(orderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(orderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(orderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalTax(Mockito.<Money>any());
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL, OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(stringStringMap);
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl(), true);

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(orderImpl).getCurrency();
    verify(orderImpl).getCustomer();
    verify(orderImpl).getEmailAddress();
    verify(orderImpl).getFulfillmentGroups();
    verify(orderImpl).getId();
    verify(orderImpl).getPayments();
    verify(orderImpl, atLeast(1)).getSubTotal();
    verify(orderImpl, atLeast(1)).getTotalAfterAppliedPayments();
    verify(orderImpl, atLeast(1)).getTotalShipping();
    verify(orderImpl, atLeast(1)).getTotalTax();
    verify(orderImpl).setAdditionalOfferInformation(isA(Map.class));
    verify(orderImpl).setAuditable(isA(Auditable.class));
    verify(orderImpl).setCandidateOrderOffers(isA(List.class));
    verify(orderImpl).setCurrency(isA(BroadleafCurrency.class));
    verify(orderImpl).setCustomer(isA(Customer.class));
    verify(orderImpl).setEmailAddress(eq("42 Main St"));
    verify(orderImpl).setFulfillmentGroups(isA(List.class));
    verify(orderImpl).setId(eq(1L));
    verify(orderImpl).setLocale(isA(Locale.class));
    verify(orderImpl).setName(eq("0"));
    verify(orderImpl).setOrderAttributes(isA(Map.class));
    verify(orderImpl).setOrderItems(isA(List.class));
    verify(orderImpl).setOrderMessages(isA(List.class));
    verify(orderImpl).setOrderNumber(eq("42"));
    verify(orderImpl).setPayments(isA(List.class));
    verify(orderImpl).setStatus(isA(OrderStatus.class));
    verify(orderImpl).setSubTotal(isA(Money.class));
    verify(orderImpl).setSubmitDate(isA(Date.class));
    verify(orderImpl).setTaxOverride(eq(true));
    verify(orderImpl).setTotal(isA(Money.class));
    verify(orderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(orderImpl).setTotalTax(isA(Money.class));
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    Map<String, Object> additionalFields = actualTranslatePaymentTransactionResult.getAdditionalFields();
    assertEquals(1, additionalFields.size());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL,
        additionalFields.get(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)} with {@code transactionAmount}, {@code paymentTransaction}, {@code autoCalculateFinalPaymentTotals}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction, boolean)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransactionAutoCalculateFinalPaymentTotals3() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    OrderImpl orderImpl = mock(OrderImpl.class);
    when(orderImpl.getSubTotal()).thenReturn(null);
    when(orderImpl.getId()).thenReturn(1L);
    when(orderImpl.getEmailAddress()).thenReturn("42 Main St");
    when(orderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(orderImpl.getPayments()).thenReturn(new ArrayList<>());
    when(orderImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(orderImpl.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(orderImpl.getTotalShipping()).thenReturn(new Money());
    when(orderImpl.getTotalTax()).thenReturn(new Money());
    when(orderImpl.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(orderImpl).setAdditionalOfferInformation(Mockito.<Map<Offer, OfferInfo>>any());
    doNothing().when(orderImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(orderImpl).setCandidateOrderOffers(Mockito.<List<CandidateOrderOffer>>any());
    doNothing().when(orderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(orderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(orderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(orderImpl).setFulfillmentGroups(Mockito.<List<FulfillmentGroup>>any());
    doNothing().when(orderImpl).setId(Mockito.<Long>any());
    doNothing().when(orderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(orderImpl).setName(Mockito.<String>any());
    doNothing().when(orderImpl).setOrderAttributes(Mockito.<Map<String, OrderAttribute>>any());
    doNothing().when(orderImpl).setOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(orderImpl).setOrderMessages(Mockito.<List<ActivityMessageDTO>>any());
    doNothing().when(orderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(orderImpl).setPayments(Mockito.<List<OrderPayment>>any());
    doNothing().when(orderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(orderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(orderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(orderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalTax(Mockito.<Money>any());
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl(), true);

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(orderImpl).getCurrency();
    verify(orderImpl).getCustomer();
    verify(orderImpl).getEmailAddress();
    verify(orderImpl).getFulfillmentGroups();
    verify(orderImpl).getId();
    verify(orderImpl).getPayments();
    verify(orderImpl).getSubTotal();
    verify(orderImpl, atLeast(1)).getTotalAfterAppliedPayments();
    verify(orderImpl, atLeast(1)).getTotalShipping();
    verify(orderImpl, atLeast(1)).getTotalTax();
    verify(orderImpl).setAdditionalOfferInformation(isA(Map.class));
    verify(orderImpl).setAuditable(isA(Auditable.class));
    verify(orderImpl).setCandidateOrderOffers(isA(List.class));
    verify(orderImpl).setCurrency(isA(BroadleafCurrency.class));
    verify(orderImpl).setCustomer(isA(Customer.class));
    verify(orderImpl).setEmailAddress(eq("42 Main St"));
    verify(orderImpl).setFulfillmentGroups(isA(List.class));
    verify(orderImpl).setId(eq(1L));
    verify(orderImpl).setLocale(isA(Locale.class));
    verify(orderImpl).setName(eq("0"));
    verify(orderImpl).setOrderAttributes(isA(Map.class));
    verify(orderImpl).setOrderItems(isA(List.class));
    verify(orderImpl).setOrderMessages(isA(List.class));
    verify(orderImpl).setOrderNumber(eq("42"));
    verify(orderImpl).setPayments(isA(List.class));
    verify(orderImpl).setStatus(isA(OrderStatus.class));
    verify(orderImpl).setSubTotal(isA(Money.class));
    verify(orderImpl).setSubmitDate(isA(Date.class));
    verify(orderImpl).setTaxOverride(eq(true));
    verify(orderImpl).setTotal(isA(Money.class));
    verify(orderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(orderImpl).setTotalTax(isA(Money.class));
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getShippingTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTaxTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTransactionTotal());
    assertEquals("1", actualTranslatePaymentTransactionResult.getOrderId());
    assertNull(actualTranslatePaymentTransactionResult.getOrderCurrencyCode());
    assertNull(actualTranslatePaymentTransactionResult.getOrderDescription());
    assertNull(actualTranslatePaymentTransactionResult.getGatewayRequestType());
    assertNull(actualTranslatePaymentTransactionResult.getBillTo());
    assertNull(actualTranslatePaymentTransactionResult.getShipTo());
    assertNull(actualTranslatePaymentTransactionResult.getCreditCard());
    assertNull(actualTranslatePaymentTransactionResult.getCustomer());
    assertNull(actualTranslatePaymentTransactionResult.getSubscription());
    assertTrue(actualTranslatePaymentTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getLineItems().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.isCompleteCheckoutOnCallback());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL,
        actualTranslatePaymentTransactionResult.getOrderSubtotal());
    assertSame(paymentType, actualTranslatePaymentTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)} with {@code transactionAmount}, {@code paymentTransaction}, {@code autoCalculateFinalPaymentTotals}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction, boolean)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransactionAutoCalculateFinalPaymentTotals4() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    OrderImpl orderImpl = mock(OrderImpl.class);
    when(orderImpl.getSubTotal()).thenReturn(mock(Money.class));
    when(orderImpl.getId()).thenReturn(1L);
    when(orderImpl.getEmailAddress()).thenReturn("42 Main St");
    when(orderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(orderImpl.getPayments()).thenReturn(new ArrayList<>());
    when(orderImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(orderImpl.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(orderImpl.getTotalShipping()).thenReturn(new Money());
    when(orderImpl.getTotalTax()).thenReturn(new Money());
    when(orderImpl.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(orderImpl).setAdditionalOfferInformation(Mockito.<Map<Offer, OfferInfo>>any());
    doNothing().when(orderImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(orderImpl).setCandidateOrderOffers(Mockito.<List<CandidateOrderOffer>>any());
    doNothing().when(orderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(orderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(orderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(orderImpl).setFulfillmentGroups(Mockito.<List<FulfillmentGroup>>any());
    doNothing().when(orderImpl).setId(Mockito.<Long>any());
    doNothing().when(orderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(orderImpl).setName(Mockito.<String>any());
    doNothing().when(orderImpl).setOrderAttributes(Mockito.<Map<String, OrderAttribute>>any());
    doNothing().when(orderImpl).setOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(orderImpl).setOrderMessages(Mockito.<List<ActivityMessageDTO>>any());
    doNothing().when(orderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(orderImpl).setPayments(Mockito.<List<OrderPayment>>any());
    doNothing().when(orderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(orderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(orderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(orderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalTax(Mockito.<Money>any());
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl(), true);

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(orderImpl).getCurrency();
    verify(orderImpl).getCustomer();
    verify(orderImpl).getEmailAddress();
    verify(orderImpl).getFulfillmentGroups();
    verify(orderImpl).getId();
    verify(orderImpl).getPayments();
    verify(orderImpl, atLeast(1)).getSubTotal();
    verify(orderImpl, atLeast(1)).getTotalAfterAppliedPayments();
    verify(orderImpl, atLeast(1)).getTotalShipping();
    verify(orderImpl, atLeast(1)).getTotalTax();
    verify(orderImpl).setAdditionalOfferInformation(isA(Map.class));
    verify(orderImpl).setAuditable(isA(Auditable.class));
    verify(orderImpl).setCandidateOrderOffers(isA(List.class));
    verify(orderImpl).setCurrency(isA(BroadleafCurrency.class));
    verify(orderImpl).setCustomer(isA(Customer.class));
    verify(orderImpl).setEmailAddress(eq("42 Main St"));
    verify(orderImpl).setFulfillmentGroups(isA(List.class));
    verify(orderImpl).setId(eq(1L));
    verify(orderImpl).setLocale(isA(Locale.class));
    verify(orderImpl).setName(eq("0"));
    verify(orderImpl).setOrderAttributes(isA(Map.class));
    verify(orderImpl).setOrderItems(isA(List.class));
    verify(orderImpl).setOrderMessages(isA(List.class));
    verify(orderImpl).setOrderNumber(eq("42"));
    verify(orderImpl).setPayments(isA(List.class));
    verify(orderImpl).setStatus(isA(OrderStatus.class));
    verify(orderImpl).setSubTotal(isA(Money.class));
    verify(orderImpl).setSubmitDate(isA(Date.class));
    verify(orderImpl).setTaxOverride(eq(true));
    verify(orderImpl).setTotal(isA(Money.class));
    verify(orderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(orderImpl).setTotalTax(isA(Money.class));
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getShippingTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTaxTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTransactionTotal());
    assertEquals("1", actualTranslatePaymentTransactionResult.getOrderId());
    assertNull(actualTranslatePaymentTransactionResult.getOrderCurrencyCode());
    assertNull(actualTranslatePaymentTransactionResult.getOrderDescription());
    assertNull(actualTranslatePaymentTransactionResult.getGatewayRequestType());
    assertNull(actualTranslatePaymentTransactionResult.getBillTo());
    assertNull(actualTranslatePaymentTransactionResult.getShipTo());
    assertNull(actualTranslatePaymentTransactionResult.getCreditCard());
    assertNull(actualTranslatePaymentTransactionResult.getCustomer());
    assertNull(actualTranslatePaymentTransactionResult.getSubscription());
    assertTrue(actualTranslatePaymentTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getLineItems().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.isCompleteCheckoutOnCallback());
    assertSame(paymentType, actualTranslatePaymentTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)} with {@code transactionAmount}, {@code paymentTransaction}, {@code autoCalculateFinalPaymentTotals}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction, boolean)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransactionAutoCalculateFinalPaymentTotals5() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    OrderImpl orderImpl = mock(OrderImpl.class);
    when(orderImpl.getSubTotal()).thenReturn(new Money());
    when(orderImpl.getId()).thenReturn(1L);
    when(orderImpl.getEmailAddress()).thenReturn("42 Main St");
    when(orderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(orderImpl.getPayments()).thenReturn(new ArrayList<>());
    when(orderImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(orderImpl.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(orderImpl.getTotalShipping()).thenReturn(new Money());
    when(orderImpl.getTotalTax()).thenReturn(new Money());
    when(orderImpl.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(orderImpl).setAdditionalOfferInformation(Mockito.<Map<Offer, OfferInfo>>any());
    doNothing().when(orderImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(orderImpl).setCandidateOrderOffers(Mockito.<List<CandidateOrderOffer>>any());
    doNothing().when(orderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(orderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(orderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(orderImpl).setFulfillmentGroups(Mockito.<List<FulfillmentGroup>>any());
    doNothing().when(orderImpl).setId(Mockito.<Long>any());
    doNothing().when(orderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(orderImpl).setName(Mockito.<String>any());
    doNothing().when(orderImpl).setOrderAttributes(Mockito.<Map<String, OrderAttribute>>any());
    doNothing().when(orderImpl).setOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(orderImpl).setOrderMessages(Mockito.<List<ActivityMessageDTO>>any());
    doNothing().when(orderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(orderImpl).setPayments(Mockito.<List<OrderPayment>>any());
    doNothing().when(orderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(orderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(orderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(orderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalTax(Mockito.<Money>any());
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl(), true);

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(orderImpl).getCurrency();
    verify(orderImpl).getCustomer();
    verify(orderImpl).getEmailAddress();
    verify(orderImpl).getFulfillmentGroups();
    verify(orderImpl).getId();
    verify(orderImpl).getPayments();
    verify(orderImpl, atLeast(1)).getSubTotal();
    verify(orderImpl, atLeast(1)).getTotalAfterAppliedPayments();
    verify(orderImpl, atLeast(1)).getTotalShipping();
    verify(orderImpl, atLeast(1)).getTotalTax();
    verify(orderImpl).setAdditionalOfferInformation(isA(Map.class));
    verify(orderImpl).setAuditable(isA(Auditable.class));
    verify(orderImpl).setCandidateOrderOffers(isA(List.class));
    verify(orderImpl).setCurrency(isA(BroadleafCurrency.class));
    verify(orderImpl).setCustomer(isA(Customer.class));
    verify(orderImpl).setEmailAddress(eq("42 Main St"));
    verify(orderImpl).setFulfillmentGroups(isA(List.class));
    verify(orderImpl).setId(eq(1L));
    verify(orderImpl).setLocale(isA(Locale.class));
    verify(orderImpl).setName(eq("0"));
    verify(orderImpl).setOrderAttributes(isA(Map.class));
    verify(orderImpl).setOrderItems(isA(List.class));
    verify(orderImpl).setOrderMessages(isA(List.class));
    verify(orderImpl).setOrderNumber(eq("42"));
    verify(orderImpl).setPayments(isA(List.class));
    verify(orderImpl).setStatus(isA(OrderStatus.class));
    verify(orderImpl).setSubTotal(isA(Money.class));
    verify(orderImpl).setSubmitDate(isA(Date.class));
    verify(orderImpl).setTaxOverride(eq(true));
    verify(orderImpl).setTotal(isA(Money.class));
    verify(orderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(orderImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getOrderSubtotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getShippingTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTaxTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTransactionTotal());
    assertEquals("1", actualTranslatePaymentTransactionResult.getOrderId());
    assertNull(actualTranslatePaymentTransactionResult.getOrderCurrencyCode());
    assertNull(actualTranslatePaymentTransactionResult.getOrderDescription());
    assertNull(actualTranslatePaymentTransactionResult.getGatewayRequestType());
    assertNull(actualTranslatePaymentTransactionResult.getBillTo());
    assertNull(actualTranslatePaymentTransactionResult.getShipTo());
    assertNull(actualTranslatePaymentTransactionResult.getCreditCard());
    assertNull(actualTranslatePaymentTransactionResult.getCustomer());
    assertNull(actualTranslatePaymentTransactionResult.getSubscription());
    assertTrue(actualTranslatePaymentTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getLineItems().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.isCompleteCheckoutOnCallback());
    assertSame(paymentType, actualTranslatePaymentTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)} with {@code transactionAmount}, {@code paymentTransaction}, {@code autoCalculateFinalPaymentTotals}.
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translatePaymentTransaction(Money, PaymentTransaction, boolean)"})
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransactionAutoCalculateFinalPaymentTotals6() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any())).thenReturn(null);
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    OrderImpl orderImpl = mock(OrderImpl.class);
    when(orderImpl.getSubTotal()).thenReturn(new Money());
    when(orderImpl.getId()).thenReturn(1L);
    when(orderImpl.getEmailAddress()).thenReturn("42 Main St");
    when(orderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(orderImpl.getPayments()).thenReturn(new ArrayList<>());
    when(orderImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(orderImpl.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(orderImpl.getTotalShipping()).thenReturn(new Money());
    when(orderImpl.getTotalTax()).thenReturn(new Money());
    when(orderImpl.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(orderImpl).setAdditionalOfferInformation(Mockito.<Map<Offer, OfferInfo>>any());
    doNothing().when(orderImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(orderImpl).setCandidateOrderOffers(Mockito.<List<CandidateOrderOffer>>any());
    doNothing().when(orderImpl).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(orderImpl).setCustomer(Mockito.<Customer>any());
    doNothing().when(orderImpl).setEmailAddress(Mockito.<String>any());
    doNothing().when(orderImpl).setFulfillmentGroups(Mockito.<List<FulfillmentGroup>>any());
    doNothing().when(orderImpl).setId(Mockito.<Long>any());
    doNothing().when(orderImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(orderImpl).setName(Mockito.<String>any());
    doNothing().when(orderImpl).setOrderAttributes(Mockito.<Map<String, OrderAttribute>>any());
    doNothing().when(orderImpl).setOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(orderImpl).setOrderMessages(Mockito.<List<ActivityMessageDTO>>any());
    doNothing().when(orderImpl).setOrderNumber(Mockito.<String>any());
    doNothing().when(orderImpl).setPayments(Mockito.<List<OrderPayment>>any());
    doNothing().when(orderImpl).setStatus(Mockito.<OrderStatus>any());
    doNothing().when(orderImpl).setSubTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setSubmitDate(Mockito.<Date>any());
    doNothing().when(orderImpl).setTaxOverride(Mockito.<Boolean>any());
    doNothing().when(orderImpl).setTotal(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    doNothing().when(orderImpl).setTotalTax(Mockito.<Money>any());
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL);
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
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getAdditionalFields()).thenReturn(new HashMap<>());
    when(paymentTransactionImpl.getOrderPayment()).thenReturn(orderPaymentImpl);
    doNothing().when(paymentTransactionImpl).setAdditionalFields(Mockito.<Map<String, String>>any());
    doNothing().when(paymentTransactionImpl).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransactionImpl).setCustomerIpAddress(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setDate(Mockito.<Date>any());
    doNothing().when(paymentTransactionImpl).setId(Mockito.<Long>any());
    doNothing().when(paymentTransactionImpl).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransactionImpl).setParentTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(paymentTransactionImpl).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransactionImpl).setSaveToken(anyBoolean());
    doNothing().when(paymentTransactionImpl).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransactionImpl).setType(Mockito.<PaymentTransactionType>any());
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);
    Money transactionAmount = mock(Money.class);
    when(transactionAmount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    PaymentRequestDTO actualTranslatePaymentTransactionResult = orderToPaymentRequestDTOServiceImpl
        .translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl(), true);

    // Assert
    verify(transactionAmount, atLeast(1)).getAmount();
    verify(postLoaderDao).find(isA(Class.class), isNull());
    verify(orderImpl).getCurrency();
    verify(orderImpl).getCustomer();
    verify(orderImpl).getEmailAddress();
    verify(orderImpl).getFulfillmentGroups();
    verify(orderImpl).getId();
    verify(orderImpl).getPayments();
    verify(orderImpl, atLeast(1)).getSubTotal();
    verify(orderImpl, atLeast(1)).getTotalAfterAppliedPayments();
    verify(orderImpl, atLeast(1)).getTotalShipping();
    verify(orderImpl, atLeast(1)).getTotalTax();
    verify(orderImpl).setAdditionalOfferInformation(isA(Map.class));
    verify(orderImpl).setAuditable(isA(Auditable.class));
    verify(orderImpl).setCandidateOrderOffers(isA(List.class));
    verify(orderImpl).setCurrency(isA(BroadleafCurrency.class));
    verify(orderImpl).setCustomer(isA(Customer.class));
    verify(orderImpl).setEmailAddress(eq("42 Main St"));
    verify(orderImpl).setFulfillmentGroups(isA(List.class));
    verify(orderImpl).setId(eq(1L));
    verify(orderImpl).setLocale(isA(Locale.class));
    verify(orderImpl).setName(eq("0"));
    verify(orderImpl).setOrderAttributes(isA(Map.class));
    verify(orderImpl).setOrderItems(isA(List.class));
    verify(orderImpl).setOrderMessages(isA(List.class));
    verify(orderImpl).setOrderNumber(eq("42"));
    verify(orderImpl).setPayments(isA(List.class));
    verify(orderImpl).setStatus(isA(OrderStatus.class));
    verify(orderImpl).setSubTotal(isA(Money.class));
    verify(orderImpl).setSubmitDate(isA(Date.class));
    verify(orderImpl).setTaxOverride(eq(true));
    verify(orderImpl).setTotal(isA(Money.class));
    verify(orderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(orderImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(orderPaymentImpl).getCurrency();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(paymentTransactionImpl).getAdditionalFields();
    verify(paymentTransactionImpl, atLeast(1)).getOrderPayment();
    verify(paymentTransactionImpl).setAdditionalFields(isA(Map.class));
    verify(paymentTransactionImpl).setAmount(isA(Money.class));
    verify(paymentTransactionImpl).setCustomerIpAddress(eq("42 Main St"));
    verify(paymentTransactionImpl).setDate(isA(Date.class));
    verify(paymentTransactionImpl).setId(eq(1L));
    verify(paymentTransactionImpl).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransactionImpl).setParentTransaction(isA(PaymentTransaction.class));
    verify(paymentTransactionImpl).setRawResponse(eq("Raw Response"));
    verify(paymentTransactionImpl).setSaveToken(eq(true));
    verify(paymentTransactionImpl).setSuccess(eq(true));
    verify(paymentTransactionImpl).setType(isA(PaymentTransactionType.class));
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class),
        eq("42 Main St"));
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getOrderSubtotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getShippingTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTaxTotal());
    assertEquals("0.00", actualTranslatePaymentTransactionResult.getTransactionTotal());
    assertEquals("1", actualTranslatePaymentTransactionResult.getOrderId());
    assertNull(actualTranslatePaymentTransactionResult.getOrderCurrencyCode());
    assertNull(actualTranslatePaymentTransactionResult.getOrderDescription());
    assertNull(actualTranslatePaymentTransactionResult.getGatewayRequestType());
    assertNull(actualTranslatePaymentTransactionResult.getBillTo());
    assertNull(actualTranslatePaymentTransactionResult.getShipTo());
    assertNull(actualTranslatePaymentTransactionResult.getCreditCard());
    assertNull(actualTranslatePaymentTransactionResult.getCustomer());
    assertNull(actualTranslatePaymentTransactionResult.getSubscription());
    assertTrue(actualTranslatePaymentTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getLineItems().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslatePaymentTransactionResult.isCompleteCheckoutOnCallback());
    assertSame(paymentType, actualTranslatePaymentTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#refreshTransaction(PaymentTransaction)}.
   * <ul>
   *   <li>Then return {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#refreshTransaction(PaymentTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentTransaction OrderToPaymentRequestDTOServiceImpl.refreshTransaction(PaymentTransaction)"})
  public void testRefreshTransaction_thenReturnPaymentTransactionImpl() {
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
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);

    // Act
    PaymentTransaction actualRefreshTransactionResult = orderToPaymentRequestDTOServiceImpl
        .refreshTransaction(new PaymentTransactionImpl());

    // Assert
    verify(postLoaderDao).find(isA(Class.class), isNull());
    assertSame(paymentTransactionImpl, actualRefreshTransactionResult);
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link PaymentRequestDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"})
  public void testPopulateTotals_givenPaymentRequestDTO() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(requestDTO).transactionTotal(eq("0.00"));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link PaymentRequestDTO} {@link PaymentRequestDTO#shippingTotal(String)} return {@link PaymentRequestDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"})
  public void testPopulateTotals_givenPaymentRequestDTOShippingTotalReturnPaymentRequestDTO() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.shippingTotal(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO);

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(paymentRequestDTO).shippingTotal(eq("0.00"));
    verify(requestDTO).transactionTotal(eq("0.00"));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link PaymentRequestDTO} {@link PaymentRequestDTO#taxTotal(String)} return {@link PaymentRequestDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"})
  public void testPopulateTotals_givenPaymentRequestDTOTaxTotalReturnPaymentRequestDTO() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.taxTotal(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    PaymentRequestDTO paymentRequestDTO2 = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO2.shippingTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO2);

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(paymentRequestDTO2).shippingTotal(eq("0.00"));
    verify(paymentRequestDTO).taxTotal(eq("0.00"));
    verify(requestDTO).transactionTotal(eq("0.00"));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Then calls {@link PaymentRequestDTO#orderCurrencyCode(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"})
  public void testPopulateTotals_thenCallsOrderCurrencyCode() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.orderCurrencyCode(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    PaymentRequestDTO paymentRequestDTO2 = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO2.taxTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO);
    PaymentRequestDTO paymentRequestDTO3 = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO3.shippingTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO2);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO3);

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(paymentRequestDTO).orderCurrencyCode(isNull());
    verify(paymentRequestDTO3).shippingTotal(eq("0.00"));
    verify(paymentRequestDTO2).taxTotal(eq("0.00"));
    verify(requestDTO).transactionTotal(eq("0.00"));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getTotalAfterAppliedPayments()} return {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"})
  public void testPopulateTotals_whenNullOrderImplGetTotalAfterAppliedPaymentsReturnMoney() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(mock(Money.class));
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getShippingTotal());
    assertEquals("0.00", requestDTO.getTaxTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getTotalShipping()} return {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"})
  public void testPopulateTotals_whenNullOrderImplGetTotalShippingReturnMoney() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(mock(Money.class));
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getTaxTotal());
    assertEquals("0.00", requestDTO.getTransactionTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getTotalTax()} return {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"})
  public void testPopulateTotals_whenNullOrderImplGetTotalTaxReturnMoney() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(mock(Money.class));
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getShippingTotal());
    assertEquals("0.00", requestDTO.getTransactionTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link PaymentRequestDTO} (default constructor).</li>
   *   <li>Then {@link PaymentRequestDTO} (default constructor) ShippingTotal is {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"})
  public void testPopulateTotals_whenPaymentRequestDTO_thenPaymentRequestDTOShippingTotalIs000() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getShippingTotal());
    assertEquals("0.00", requestDTO.getTaxTotal());
    assertEquals("0.00", requestDTO.getTransactionTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateCustomerInfo(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then calls {@link PaymentRequestDTOService#populateCustomerInfo(PaymentRequestDTO, Customer, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateCustomerInfo(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderToPaymentRequestDTOServiceImpl.populateCustomerInfo(Order, PaymentRequestDTO)"})
  public void testPopulateCustomerInfo_whenNullOrderImpl_thenCallsPopulateCustomerInfo() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(),
        Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateCustomerInfo(order, new PaymentRequestDTO());

    // Assert
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isNull(), isNull());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)"})
  public void testPopulateDefaultLineItemsAndSubtotal_givenMoney() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getSubTotal()).thenReturn(mock(Money.class));

    // Act
    orderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(order, new PaymentRequestDTO());

    // Assert
    verify(order, atLeast(1)).getSubTotal();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Then calls {@link PaymentRequestDTO#orderSubtotal(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)"})
  public void testPopulateDefaultLineItemsAndSubtotal_thenCallsOrderSubtotal() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getSubTotal()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.orderSubtotal(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    // Act
    orderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(order, requestDTO);

    // Assert
    verify(requestDTO).orderSubtotal(eq("0.00"));
    verify(order, atLeast(1)).getSubTotal();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Then {@link PaymentRequestDTO} (default constructor) OrderSubtotal is {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)"})
  public void testPopulateDefaultLineItemsAndSubtotal_thenPaymentRequestDTOOrderSubtotalIs000() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getSubTotal()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(order, requestDTO);

    // Assert
    verify(order, atLeast(1)).getSubTotal();
    assertEquals("0.00", requestDTO.getOrderSubtotal());
  }
}
