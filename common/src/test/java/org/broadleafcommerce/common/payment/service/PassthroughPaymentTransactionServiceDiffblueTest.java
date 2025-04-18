/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PassthroughPaymentTransactionService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PassthroughPaymentTransactionServiceDiffblueTest {
  @Autowired
  private PassthroughPaymentTransactionService passthroughPaymentTransactionService;

  /**
   * Test {@link PassthroughPaymentTransactionService#authorize(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return OrderId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassthroughPaymentTransactionService#authorize(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentTransactionService.authorize(PaymentRequestDTO)"})
  public void testAuthorize_given42_thenReturnOrderIdIsNull() throws PaymentException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    paymentRequestDTO.transactionTotal("42");

    // Act
    PaymentResponseDTO actualAuthorizeResult = passthroughPaymentTransactionService.authorize(paymentRequestDTO);

    // Assert
    assertNull(actualAuthorizeResult.getOrderId());
    assertNull(actualAuthorizeResult.getPaymentToken());
    assertNull(actualAuthorizeResult.getRawResponse());
    assertNull(actualAuthorizeResult.getPaymentType());
    assertNull(actualAuthorizeResult.getBillTo());
    assertNull(actualAuthorizeResult.getShipTo());
    assertNull(actualAuthorizeResult.getCreditCard());
    assertNull(actualAuthorizeResult.getCustomer());
    assertTrue(actualAuthorizeResult.getCustomerCredits().isEmpty());
    assertTrue(actualAuthorizeResult.getGiftCards().isEmpty());
    assertTrue(actualAuthorizeResult.getResponseMap().isEmpty());
    assertTrue(actualAuthorizeResult.isCompleteCheckoutOnCallback());
    assertTrue(actualAuthorizeResult.isSuccessful());
    assertTrue(actualAuthorizeResult.isValid());
  }

  /**
   * Test {@link PassthroughPaymentTransactionService#capture(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return OrderId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassthroughPaymentTransactionService#capture(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentTransactionService.capture(PaymentRequestDTO)"})
  public void testCapture_given42_thenReturnOrderIdIsNull() throws PaymentException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    paymentRequestDTO.transactionTotal("42");

    // Act
    PaymentResponseDTO actualCaptureResult = passthroughPaymentTransactionService.capture(paymentRequestDTO);

    // Assert
    assertNull(actualCaptureResult.getOrderId());
    assertNull(actualCaptureResult.getPaymentToken());
    assertNull(actualCaptureResult.getRawResponse());
    assertNull(actualCaptureResult.getPaymentType());
    assertNull(actualCaptureResult.getBillTo());
    assertNull(actualCaptureResult.getShipTo());
    assertNull(actualCaptureResult.getCreditCard());
    assertNull(actualCaptureResult.getCustomer());
    assertTrue(actualCaptureResult.getCustomerCredits().isEmpty());
    assertTrue(actualCaptureResult.getGiftCards().isEmpty());
    assertTrue(actualCaptureResult.getResponseMap().isEmpty());
    assertTrue(actualCaptureResult.isCompleteCheckoutOnCallback());
    assertTrue(actualCaptureResult.isSuccessful());
    assertTrue(actualCaptureResult.isValid());
  }

  /**
   * Test {@link PassthroughPaymentTransactionService#authorizeAndCapture(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return OrderId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassthroughPaymentTransactionService#authorizeAndCapture(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentTransactionService.authorizeAndCapture(PaymentRequestDTO)"})
  public void testAuthorizeAndCapture_given42_thenReturnOrderIdIsNull() throws PaymentException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    paymentRequestDTO.transactionTotal("42");

    // Act
    PaymentResponseDTO actualAuthorizeAndCaptureResult = passthroughPaymentTransactionService
        .authorizeAndCapture(paymentRequestDTO);

    // Assert
    assertNull(actualAuthorizeAndCaptureResult.getOrderId());
    assertNull(actualAuthorizeAndCaptureResult.getPaymentToken());
    assertNull(actualAuthorizeAndCaptureResult.getRawResponse());
    assertNull(actualAuthorizeAndCaptureResult.getPaymentType());
    assertNull(actualAuthorizeAndCaptureResult.getBillTo());
    assertNull(actualAuthorizeAndCaptureResult.getShipTo());
    assertNull(actualAuthorizeAndCaptureResult.getCreditCard());
    assertNull(actualAuthorizeAndCaptureResult.getCustomer());
    assertTrue(actualAuthorizeAndCaptureResult.getCustomerCredits().isEmpty());
    assertTrue(actualAuthorizeAndCaptureResult.getGiftCards().isEmpty());
    assertTrue(actualAuthorizeAndCaptureResult.getResponseMap().isEmpty());
    assertTrue(actualAuthorizeAndCaptureResult.isCompleteCheckoutOnCallback());
    assertTrue(actualAuthorizeAndCaptureResult.isSuccessful());
    assertTrue(actualAuthorizeAndCaptureResult.isValid());
  }

  /**
   * Test {@link PassthroughPaymentTransactionService#reverseAuthorize(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return OrderId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassthroughPaymentTransactionService#reverseAuthorize(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentTransactionService.reverseAuthorize(PaymentRequestDTO)"})
  public void testReverseAuthorize_given42_thenReturnOrderIdIsNull() throws PaymentException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    paymentRequestDTO.transactionTotal("42");

    // Act
    PaymentResponseDTO actualReverseAuthorizeResult = passthroughPaymentTransactionService
        .reverseAuthorize(paymentRequestDTO);

    // Assert
    assertNull(actualReverseAuthorizeResult.getOrderId());
    assertNull(actualReverseAuthorizeResult.getPaymentToken());
    assertNull(actualReverseAuthorizeResult.getRawResponse());
    assertNull(actualReverseAuthorizeResult.getPaymentType());
    assertNull(actualReverseAuthorizeResult.getBillTo());
    assertNull(actualReverseAuthorizeResult.getShipTo());
    assertNull(actualReverseAuthorizeResult.getCreditCard());
    assertNull(actualReverseAuthorizeResult.getCustomer());
    assertTrue(actualReverseAuthorizeResult.getCustomerCredits().isEmpty());
    assertTrue(actualReverseAuthorizeResult.getGiftCards().isEmpty());
    assertTrue(actualReverseAuthorizeResult.getResponseMap().isEmpty());
    assertTrue(actualReverseAuthorizeResult.isCompleteCheckoutOnCallback());
    assertTrue(actualReverseAuthorizeResult.isSuccessful());
    assertTrue(actualReverseAuthorizeResult.isValid());
  }

  /**
   * Test {@link PassthroughPaymentTransactionService#refund(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return OrderId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassthroughPaymentTransactionService#refund(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentTransactionService.refund(PaymentRequestDTO)"})
  public void testRefund_given42_thenReturnOrderIdIsNull() throws PaymentException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    paymentRequestDTO.transactionTotal("42");

    // Act
    PaymentResponseDTO actualRefundResult = passthroughPaymentTransactionService.refund(paymentRequestDTO);

    // Assert
    assertNull(actualRefundResult.getOrderId());
    assertNull(actualRefundResult.getPaymentToken());
    assertNull(actualRefundResult.getRawResponse());
    assertNull(actualRefundResult.getPaymentType());
    assertNull(actualRefundResult.getBillTo());
    assertNull(actualRefundResult.getShipTo());
    assertNull(actualRefundResult.getCreditCard());
    assertNull(actualRefundResult.getCustomer());
    assertTrue(actualRefundResult.getCustomerCredits().isEmpty());
    assertTrue(actualRefundResult.getGiftCards().isEmpty());
    assertTrue(actualRefundResult.getResponseMap().isEmpty());
    assertTrue(actualRefundResult.isCompleteCheckoutOnCallback());
    assertTrue(actualRefundResult.isSuccessful());
    assertTrue(actualRefundResult.isValid());
  }

  /**
   * Test {@link PassthroughPaymentTransactionService#voidPayment(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return OrderId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassthroughPaymentTransactionService#voidPayment(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentTransactionService.voidPayment(PaymentRequestDTO)"})
  public void testVoidPayment_given42_thenReturnOrderIdIsNull() throws PaymentException {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    paymentRequestDTO.transactionTotal("42");

    // Act
    PaymentResponseDTO actualVoidPaymentResult = passthroughPaymentTransactionService.voidPayment(paymentRequestDTO);

    // Assert
    assertNull(actualVoidPaymentResult.getOrderId());
    assertNull(actualVoidPaymentResult.getPaymentToken());
    assertNull(actualVoidPaymentResult.getRawResponse());
    assertNull(actualVoidPaymentResult.getPaymentType());
    assertNull(actualVoidPaymentResult.getBillTo());
    assertNull(actualVoidPaymentResult.getShipTo());
    assertNull(actualVoidPaymentResult.getCreditCard());
    assertNull(actualVoidPaymentResult.getCustomer());
    assertTrue(actualVoidPaymentResult.getCustomerCredits().isEmpty());
    assertTrue(actualVoidPaymentResult.getGiftCards().isEmpty());
    assertTrue(actualVoidPaymentResult.getResponseMap().isEmpty());
    assertTrue(actualVoidPaymentResult.isCompleteCheckoutOnCallback());
    assertTrue(actualVoidPaymentResult.isSuccessful());
    assertTrue(actualVoidPaymentResult.isValid());
  }
}
