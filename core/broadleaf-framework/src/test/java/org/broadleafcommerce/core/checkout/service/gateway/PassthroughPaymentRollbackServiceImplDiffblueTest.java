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
package org.broadleafcommerce.core.checkout.service.gateway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PassthroughPaymentRollbackServiceImplDiffblueTest {
  @Mock
  private OrderPaymentService orderPaymentService;

  @Mock
  private OrderService orderService;

  @InjectMocks
  private PassthroughPaymentRollbackServiceImpl passthroughPaymentRollbackServiceImpl;

  /**
   * Test {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorize(PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return RawResponse is {@code rollback authorize - successful}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorize(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentRollbackServiceImpl.rollbackAuthorize(PaymentRequestDTO)"})
  public void testRollbackAuthorize_given42_thenReturnRawResponseIsRollbackAuthorizeSuccessful()
      throws PaymentException {
    // Arrange
    PaymentRequestDTO transactionToBeRolledBack = new PaymentRequestDTO();
    transactionToBeRolledBack.transactionTotal("42");
    transactionToBeRolledBack.additionalField(PassthroughPaymentConstants.PASSTHROUGH_PAYMENT_TYPE, "Value");

    // Act
    PaymentResponseDTO actualRollbackAuthorizeResult = passthroughPaymentRollbackServiceImpl
        .rollbackAuthorize(transactionToBeRolledBack);

    // Assert
    assertEquals("rollback authorize - successful", actualRollbackAuthorizeResult.getRawResponse());
    assertNull(actualRollbackAuthorizeResult.getOrderId());
    assertNull(actualRollbackAuthorizeResult.getPaymentToken());
    assertNull(actualRollbackAuthorizeResult.getPaymentType());
    assertNull(actualRollbackAuthorizeResult.getBillTo());
    assertNull(actualRollbackAuthorizeResult.getShipTo());
    assertNull(actualRollbackAuthorizeResult.getCreditCard());
    assertNull(actualRollbackAuthorizeResult.getCustomer());
    assertTrue(actualRollbackAuthorizeResult.getCustomerCredits().isEmpty());
    assertTrue(actualRollbackAuthorizeResult.getGiftCards().isEmpty());
    assertTrue(actualRollbackAuthorizeResult.getResponseMap().isEmpty());
    assertTrue(actualRollbackAuthorizeResult.isCompleteCheckoutOnCallback());
    assertTrue(actualRollbackAuthorizeResult.isSuccessful());
    assertTrue(actualRollbackAuthorizeResult.isValid());
  }

  /**
   * Test {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorize(PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link PaymentRequestDTO} (default constructor).</li>
   *   <li>Then throw {@link PaymentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorize(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentRollbackServiceImpl.rollbackAuthorize(PaymentRequestDTO)"})
  public void testRollbackAuthorize_whenPaymentRequestDTO_thenThrowPaymentException() throws PaymentException {
    // Arrange, Act and Assert
    assertThrows(PaymentException.class,
        () -> passthroughPaymentRollbackServiceImpl.rollbackAuthorize(new PaymentRequestDTO()));
  }

  /**
   * Test {@link PassthroughPaymentRollbackServiceImpl#rollbackCapture(PaymentRequestDTO)}.
   * <p>
   * Method under test: {@link PassthroughPaymentRollbackServiceImpl#rollbackCapture(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentRollbackServiceImpl.rollbackCapture(PaymentRequestDTO)"})
  public void testRollbackCapture() throws PaymentException {
    // Arrange, Act and Assert
    assertThrows(PaymentException.class,
        () -> passthroughPaymentRollbackServiceImpl.rollbackCapture(new PaymentRequestDTO()));
  }

  /**
   * Test {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorizeAndCapture(PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link PaymentRequestDTO} (default constructor).</li>
   *   <li>Then throw {@link PaymentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassthroughPaymentRollbackServiceImpl#rollbackAuthorizeAndCapture(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO PassthroughPaymentRollbackServiceImpl.rollbackAuthorizeAndCapture(PaymentRequestDTO)"})
  public void testRollbackAuthorizeAndCapture_whenPaymentRequestDTO_thenThrowPaymentException()
      throws PaymentException {
    // Arrange, Act and Assert
    assertThrows(PaymentException.class,
        () -> passthroughPaymentRollbackServiceImpl.rollbackAuthorizeAndCapture(new PaymentRequestDTO()));
  }

  /**
   * Test {@link PassthroughPaymentRollbackServiceImpl#rollbackRefund(PaymentRequestDTO)}.
   * <p>
   * Method under test: {@link PassthroughPaymentRollbackServiceImpl#rollbackRefund(PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentResponseDTO PassthroughPaymentRollbackServiceImpl.rollbackRefund(PaymentRequestDTO)"})
  public void testRollbackRefund() throws PaymentException {
    // Arrange, Act and Assert
    assertThrows(PaymentException.class,
        () -> passthroughPaymentRollbackServiceImpl.rollbackRefund(new PaymentRequestDTO()));
  }
}
