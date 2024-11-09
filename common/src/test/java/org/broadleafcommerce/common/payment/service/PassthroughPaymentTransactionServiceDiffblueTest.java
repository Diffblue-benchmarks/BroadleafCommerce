/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;

public class PassthroughPaymentTransactionServiceDiffblueTest {
  /**
   * Test
   * {@link PassthroughPaymentTransactionService#authorize(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return PaymentType Type is {@code APPLE_PAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PassthroughPaymentTransactionService#authorize(PaymentRequestDTO)}
   */
  @Test
  public void testAuthorize_given42_thenReturnPaymentTypeTypeIsApplePay() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentTransactionService passthroughPaymentTransactionService = new PassthroughPaymentTransactionService();
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(paymentRequestDTO.getPaymentType()).thenReturn(PaymentType.APPLE_PAY);

    // Act
    PaymentResponseDTO actualAuthorizeResult = passthroughPaymentTransactionService.authorize(paymentRequestDTO);

    // Assert
    verify(paymentRequestDTO).getPaymentType();
    verify(paymentRequestDTO).getTransactionTotal();
    PaymentType paymentType = actualAuthorizeResult.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    PaymentTransactionType paymentTransactionType = actualAuthorizeResult.getPaymentTransactionType();
    assertEquals("AUTHORIZE", paymentTransactionType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    assertEquals("Authorize", paymentTransactionType.getFriendlyType());
    Money amount = actualAuthorizeResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentGatewayType paymentGatewayType = actualAuthorizeResult.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    assertEquals("£", currency.getSymbol());
    assertNull(actualAuthorizeResult.getOrderId());
    assertNull(actualAuthorizeResult.getPaymentToken());
    assertNull(actualAuthorizeResult.getRawResponse());
    assertNull(actualAuthorizeResult.getBillTo());
    assertNull(actualAuthorizeResult.getShipTo());
    assertNull(actualAuthorizeResult.getCreditCard());
    assertNull(actualAuthorizeResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualAuthorizeResult.getCustomerCredits().isEmpty());
    assertTrue(actualAuthorizeResult.getGiftCards().isEmpty());
    assertTrue(actualAuthorizeResult.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(actualAuthorizeResult.isCompleteCheckoutOnCallback());
    assertTrue(actualAuthorizeResult.isSuccessful());
    assertTrue(actualAuthorizeResult.isValid());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = amount.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("42.00");
    assertEquals(expectedAmount2, amount.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(amount, amount.abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link PassthroughPaymentTransactionService#capture(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return PaymentType Type is {@code APPLE_PAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PassthroughPaymentTransactionService#capture(PaymentRequestDTO)}
   */
  @Test
  public void testCapture_given42_thenReturnPaymentTypeTypeIsApplePay() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentTransactionService passthroughPaymentTransactionService = new PassthroughPaymentTransactionService();
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(paymentRequestDTO.getPaymentType()).thenReturn(PaymentType.APPLE_PAY);

    // Act
    PaymentResponseDTO actualCaptureResult = passthroughPaymentTransactionService.capture(paymentRequestDTO);

    // Assert
    verify(paymentRequestDTO).getPaymentType();
    verify(paymentRequestDTO).getTransactionTotal();
    PaymentType paymentType = actualCaptureResult.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    Money amount = actualCaptureResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    PaymentTransactionType paymentTransactionType = actualCaptureResult.getPaymentTransactionType();
    assertEquals("CAPTURE", paymentTransactionType.getType());
    assertEquals("Capture", paymentTransactionType.getFriendlyType());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentGatewayType paymentGatewayType = actualCaptureResult.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    assertEquals("£", currency.getSymbol());
    assertNull(actualCaptureResult.getOrderId());
    assertNull(actualCaptureResult.getPaymentToken());
    assertNull(actualCaptureResult.getRawResponse());
    assertNull(actualCaptureResult.getBillTo());
    assertNull(actualCaptureResult.getShipTo());
    assertNull(actualCaptureResult.getCreditCard());
    assertNull(actualCaptureResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualCaptureResult.getCustomerCredits().isEmpty());
    assertTrue(actualCaptureResult.getGiftCards().isEmpty());
    assertTrue(actualCaptureResult.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(actualCaptureResult.isCompleteCheckoutOnCallback());
    assertTrue(actualCaptureResult.isSuccessful());
    assertTrue(actualCaptureResult.isValid());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = amount.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("42.00");
    assertEquals(expectedAmount2, amount.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(amount, amount.abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test
   * {@link PassthroughPaymentTransactionService#authorizeAndCapture(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return PaymentType Type is {@code APPLE_PAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PassthroughPaymentTransactionService#authorizeAndCapture(PaymentRequestDTO)}
   */
  @Test
  public void testAuthorizeAndCapture_given42_thenReturnPaymentTypeTypeIsApplePay() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentTransactionService passthroughPaymentTransactionService = new PassthroughPaymentTransactionService();
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(paymentRequestDTO.getPaymentType()).thenReturn(PaymentType.APPLE_PAY);

    // Act
    PaymentResponseDTO actualAuthorizeAndCaptureResult = passthroughPaymentTransactionService
        .authorizeAndCapture(paymentRequestDTO);

    // Assert
    verify(paymentRequestDTO).getPaymentType();
    verify(paymentRequestDTO).getTransactionTotal();
    PaymentType paymentType = actualAuthorizeAndCaptureResult.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    PaymentTransactionType paymentTransactionType = actualAuthorizeAndCaptureResult.getPaymentTransactionType();
    assertEquals("AUTHORIZE_AND_CAPTURE", paymentTransactionType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    assertEquals("Authorize and Capture", paymentTransactionType.getFriendlyType());
    Money amount = actualAuthorizeAndCaptureResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentGatewayType paymentGatewayType = actualAuthorizeAndCaptureResult.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    assertEquals("£", currency.getSymbol());
    assertNull(actualAuthorizeAndCaptureResult.getOrderId());
    assertNull(actualAuthorizeAndCaptureResult.getPaymentToken());
    assertNull(actualAuthorizeAndCaptureResult.getRawResponse());
    assertNull(actualAuthorizeAndCaptureResult.getBillTo());
    assertNull(actualAuthorizeAndCaptureResult.getShipTo());
    assertNull(actualAuthorizeAndCaptureResult.getCreditCard());
    assertNull(actualAuthorizeAndCaptureResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualAuthorizeAndCaptureResult.getCustomerCredits().isEmpty());
    assertTrue(actualAuthorizeAndCaptureResult.getGiftCards().isEmpty());
    assertTrue(actualAuthorizeAndCaptureResult.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(actualAuthorizeAndCaptureResult.isCompleteCheckoutOnCallback());
    assertTrue(actualAuthorizeAndCaptureResult.isSuccessful());
    assertTrue(actualAuthorizeAndCaptureResult.isValid());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = amount.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("42.00");
    assertEquals(expectedAmount2, amount.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(amount, amount.abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test
   * {@link PassthroughPaymentTransactionService#reverseAuthorize(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return PaymentType Type is {@code APPLE_PAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PassthroughPaymentTransactionService#reverseAuthorize(PaymentRequestDTO)}
   */
  @Test
  public void testReverseAuthorize_given42_thenReturnPaymentTypeTypeIsApplePay() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentTransactionService passthroughPaymentTransactionService = new PassthroughPaymentTransactionService();
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(paymentRequestDTO.getPaymentType()).thenReturn(PaymentType.APPLE_PAY);

    // Act
    PaymentResponseDTO actualReverseAuthorizeResult = passthroughPaymentTransactionService
        .reverseAuthorize(paymentRequestDTO);

    // Assert
    verify(paymentRequestDTO).getPaymentType();
    verify(paymentRequestDTO).getTransactionTotal();
    PaymentType paymentType = actualReverseAuthorizeResult.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    Money amount = actualReverseAuthorizeResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentGatewayType paymentGatewayType = actualReverseAuthorizeResult.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    PaymentTransactionType paymentTransactionType = actualReverseAuthorizeResult.getPaymentTransactionType();
    assertEquals("REVERSE_AUTH", paymentTransactionType.getType());
    assertEquals("Reverse Auth", paymentTransactionType.getFriendlyType());
    assertEquals("£", currency.getSymbol());
    assertNull(actualReverseAuthorizeResult.getOrderId());
    assertNull(actualReverseAuthorizeResult.getPaymentToken());
    assertNull(actualReverseAuthorizeResult.getRawResponse());
    assertNull(actualReverseAuthorizeResult.getBillTo());
    assertNull(actualReverseAuthorizeResult.getShipTo());
    assertNull(actualReverseAuthorizeResult.getCreditCard());
    assertNull(actualReverseAuthorizeResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualReverseAuthorizeResult.getCustomerCredits().isEmpty());
    assertTrue(actualReverseAuthorizeResult.getGiftCards().isEmpty());
    assertTrue(actualReverseAuthorizeResult.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(actualReverseAuthorizeResult.isCompleteCheckoutOnCallback());
    assertTrue(actualReverseAuthorizeResult.isSuccessful());
    assertTrue(actualReverseAuthorizeResult.isValid());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = amount.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("42.00");
    assertEquals(expectedAmount2, amount.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(amount, amount.abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test {@link PassthroughPaymentTransactionService#refund(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return PaymentType Type is {@code APPLE_PAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PassthroughPaymentTransactionService#refund(PaymentRequestDTO)}
   */
  @Test
  public void testRefund_given42_thenReturnPaymentTypeTypeIsApplePay() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentTransactionService passthroughPaymentTransactionService = new PassthroughPaymentTransactionService();
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(paymentRequestDTO.getPaymentType()).thenReturn(PaymentType.APPLE_PAY);

    // Act
    PaymentResponseDTO actualRefundResult = passthroughPaymentTransactionService.refund(paymentRequestDTO);

    // Assert
    verify(paymentRequestDTO).getPaymentType();
    verify(paymentRequestDTO).getTransactionTotal();
    PaymentType paymentType = actualRefundResult.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    Money amount = actualRefundResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentGatewayType paymentGatewayType = actualRefundResult.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    PaymentTransactionType paymentTransactionType = actualRefundResult.getPaymentTransactionType();
    assertEquals("REFUND", paymentTransactionType.getType());
    assertEquals("Refund", paymentTransactionType.getFriendlyType());
    assertEquals("£", currency.getSymbol());
    assertNull(actualRefundResult.getOrderId());
    assertNull(actualRefundResult.getPaymentToken());
    assertNull(actualRefundResult.getRawResponse());
    assertNull(actualRefundResult.getBillTo());
    assertNull(actualRefundResult.getShipTo());
    assertNull(actualRefundResult.getCreditCard());
    assertNull(actualRefundResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualRefundResult.getCustomerCredits().isEmpty());
    assertTrue(actualRefundResult.getGiftCards().isEmpty());
    assertTrue(actualRefundResult.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(actualRefundResult.isCompleteCheckoutOnCallback());
    assertTrue(actualRefundResult.isSuccessful());
    assertTrue(actualRefundResult.isValid());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = amount.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("42.00");
    assertEquals(expectedAmount2, amount.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(amount, amount.abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test
   * {@link PassthroughPaymentTransactionService#voidPayment(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return PaymentType Type is {@code APPLE_PAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PassthroughPaymentTransactionService#voidPayment(PaymentRequestDTO)}
   */
  @Test
  public void testVoidPayment_given42_thenReturnPaymentTypeTypeIsApplePay() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentTransactionService passthroughPaymentTransactionService = new PassthroughPaymentTransactionService();
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.getTransactionTotal()).thenReturn("42");
    when(paymentRequestDTO.getPaymentType()).thenReturn(PaymentType.APPLE_PAY);

    // Act
    PaymentResponseDTO actualVoidPaymentResult = passthroughPaymentTransactionService.voidPayment(paymentRequestDTO);

    // Assert
    verify(paymentRequestDTO).getPaymentType();
    verify(paymentRequestDTO).getTransactionTotal();
    PaymentType paymentType = actualVoidPaymentResult.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    Money amount = actualVoidPaymentResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentGatewayType paymentGatewayType = actualVoidPaymentResult.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    PaymentTransactionType paymentTransactionType = actualVoidPaymentResult.getPaymentTransactionType();
    assertEquals("VOID", paymentTransactionType.getType());
    assertEquals("Void", paymentTransactionType.getFriendlyType());
    assertEquals("£", currency.getSymbol());
    assertNull(actualVoidPaymentResult.getOrderId());
    assertNull(actualVoidPaymentResult.getPaymentToken());
    assertNull(actualVoidPaymentResult.getRawResponse());
    assertNull(actualVoidPaymentResult.getBillTo());
    assertNull(actualVoidPaymentResult.getShipTo());
    assertNull(actualVoidPaymentResult.getCreditCard());
    assertNull(actualVoidPaymentResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualVoidPaymentResult.getCustomerCredits().isEmpty());
    assertTrue(actualVoidPaymentResult.getGiftCards().isEmpty());
    assertTrue(actualVoidPaymentResult.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(actualVoidPaymentResult.isCompleteCheckoutOnCallback());
    assertTrue(actualVoidPaymentResult.isSuccessful());
    assertTrue(actualVoidPaymentResult.isValid());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = amount.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("42.00");
    assertEquals(expectedAmount2, amount.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(amount, amount.abs());
    assertSame(currency, zeroResult.getCurrency());
  }
}
