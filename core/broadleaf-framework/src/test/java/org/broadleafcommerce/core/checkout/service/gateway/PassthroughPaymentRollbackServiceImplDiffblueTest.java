/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.checkout.service.gateway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;

public class PassthroughPaymentRollbackServiceImplDiffblueTest {
  /**
   * Test
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorize(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return Amount Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorize(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackAuthorize_given42_thenReturnAmountCurrencyDisplayNameIsBritishPound()
      throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentRollbackServiceImpl passthroughPaymentRollbackServiceImpl = new PassthroughPaymentRollbackServiceImpl();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(PassthroughPaymentConstants.PASSTHROUGH_PAYMENT_TYPE, "42");
    PaymentRequestDTO transactionToBeRolledBack = mock(PaymentRequestDTO.class);
    when(transactionToBeRolledBack.getTransactionTotal()).thenReturn("42");
    when(transactionToBeRolledBack.getAdditionalFields()).thenReturn(stringObjectMap);

    // Act
    PaymentResponseDTO actualRollbackAuthorizeResult = passthroughPaymentRollbackServiceImpl
        .rollbackAuthorize(transactionToBeRolledBack);

    // Assert
    verify(transactionToBeRolledBack, atLeast(1)).getAdditionalFields();
    verify(transactionToBeRolledBack).getTransactionTotal();
    Money amount = actualRollbackAuthorizeResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentGatewayType paymentGatewayType = actualRollbackAuthorizeResult.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    PaymentTransactionType paymentTransactionType = actualRollbackAuthorizeResult.getPaymentTransactionType();
    assertEquals("REVERSE_AUTH", paymentTransactionType.getType());
    assertEquals("Reverse Auth", paymentTransactionType.getFriendlyType());
    assertEquals("£", currency.getSymbol());
    assertEquals("rollback authorize - successful", actualRollbackAuthorizeResult.getRawResponse());
    assertNull(actualRollbackAuthorizeResult.getOrderId());
    assertNull(actualRollbackAuthorizeResult.getPaymentToken());
    assertNull(actualRollbackAuthorizeResult.getPaymentType());
    assertNull(actualRollbackAuthorizeResult.getBillTo());
    assertNull(actualRollbackAuthorizeResult.getShipTo());
    assertNull(actualRollbackAuthorizeResult.getCreditCard());
    assertNull(actualRollbackAuthorizeResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualRollbackAuthorizeResult.getCustomerCredits().isEmpty());
    assertTrue(actualRollbackAuthorizeResult.getGiftCards().isEmpty());
    assertTrue(actualRollbackAuthorizeResult.getResponseMap().isEmpty());
    assertTrue(actualRollbackAuthorizeResult.isCompleteCheckoutOnCallback());
    assertTrue(actualRollbackAuthorizeResult.isSuccessful());
    assertTrue(actualRollbackAuthorizeResult.isValid());
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
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorize(PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link PaymentRequestDTO} (default constructor).</li>
   *   <li>Then throw {@link PaymentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorize(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackAuthorize_whenPaymentRequestDTO_thenThrowPaymentException() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentRollbackServiceImpl passthroughPaymentRollbackServiceImpl = new PassthroughPaymentRollbackServiceImpl();

    // Act and Assert
    assertThrows(PaymentException.class,
        () -> passthroughPaymentRollbackServiceImpl.rollbackAuthorize(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackCapture(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackCapture(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackCapture() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentRollbackServiceImpl passthroughPaymentRollbackServiceImpl = new PassthroughPaymentRollbackServiceImpl();

    // Act and Assert
    assertThrows(PaymentException.class,
        () -> passthroughPaymentRollbackServiceImpl.rollbackCapture(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorizeAndCapture(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorizeAndCapture(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackAuthorizeAndCapture() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentRollbackServiceImpl passthroughPaymentRollbackServiceImpl = new PassthroughPaymentRollbackServiceImpl();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(PassthroughPaymentConstants.PASSTHROUGH_PAYMENT_TYPE, "42");
    PaymentRequestDTO transactionToBeRolledBack = mock(PaymentRequestDTO.class);
    when(transactionToBeRolledBack.getTransactionTotal()).thenReturn("42");
    when(transactionToBeRolledBack.getAdditionalFields()).thenReturn(stringObjectMap);

    // Act
    PaymentResponseDTO actualRollbackAuthorizeAndCaptureResult = passthroughPaymentRollbackServiceImpl
        .rollbackAuthorizeAndCapture(transactionToBeRolledBack);

    // Assert
    verify(transactionToBeRolledBack, atLeast(1)).getAdditionalFields();
    verify(transactionToBeRolledBack).getTransactionTotal();
    Money amount = actualRollbackAuthorizeAndCaptureResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentGatewayType paymentGatewayType = actualRollbackAuthorizeAndCaptureResult.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    PaymentTransactionType paymentTransactionType = actualRollbackAuthorizeAndCaptureResult.getPaymentTransactionType();
    assertEquals("VOID", paymentTransactionType.getType());
    assertEquals("Void", paymentTransactionType.getFriendlyType());
    assertEquals("£", currency.getSymbol());
    assertEquals("rollback authorize and capture - successful",
        actualRollbackAuthorizeAndCaptureResult.getRawResponse());
    assertNull(actualRollbackAuthorizeAndCaptureResult.getOrderId());
    assertNull(actualRollbackAuthorizeAndCaptureResult.getPaymentToken());
    assertNull(actualRollbackAuthorizeAndCaptureResult.getPaymentType());
    assertNull(actualRollbackAuthorizeAndCaptureResult.getBillTo());
    assertNull(actualRollbackAuthorizeAndCaptureResult.getShipTo());
    assertNull(actualRollbackAuthorizeAndCaptureResult.getCreditCard());
    assertNull(actualRollbackAuthorizeAndCaptureResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualRollbackAuthorizeAndCaptureResult.getCustomerCredits().isEmpty());
    assertTrue(actualRollbackAuthorizeAndCaptureResult.getGiftCards().isEmpty());
    assertTrue(actualRollbackAuthorizeAndCaptureResult.getResponseMap().isEmpty());
    assertTrue(actualRollbackAuthorizeAndCaptureResult.isCompleteCheckoutOnCallback());
    assertTrue(actualRollbackAuthorizeAndCaptureResult.isSuccessful());
    assertTrue(actualRollbackAuthorizeAndCaptureResult.isValid());
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
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorizeAndCapture(PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link PaymentRequestDTO} (default constructor).</li>
   *   <li>Then throw {@link PaymentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorizeAndCapture(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackAuthorizeAndCapture_whenPaymentRequestDTO_thenThrowPaymentException()
      throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentRollbackServiceImpl passthroughPaymentRollbackServiceImpl = new PassthroughPaymentRollbackServiceImpl();

    // Act and Assert
    assertThrows(PaymentException.class,
        () -> passthroughPaymentRollbackServiceImpl.rollbackAuthorizeAndCapture(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackRefund(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentRollbackServiceImpl#rollbackRefund(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackRefund() throws PaymentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughPaymentRollbackServiceImpl passthroughPaymentRollbackServiceImpl = new PassthroughPaymentRollbackServiceImpl();

    // Act and Assert
    assertThrows(PaymentException.class,
        () -> passthroughPaymentRollbackServiceImpl.rollbackRefund(new PaymentRequestDTO()));
  }
}
