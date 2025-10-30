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
package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.core.checkout.service.workflow.ValidateAndConfirmPaymentActivity.ResponseTransactionPair;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidateAndConfirmPaymentActivityDiffblueTest {
  @InjectMocks
  private ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity;

  /**
   * Test ResponseTransactionPair getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResponseTransactionPair#ResponseTransactionPair(ValidateAndConfirmPaymentActivity, PaymentResponseDTO, Long)}
   *   <li>{@link ResponseTransactionPair#getResponseDTO()}
   *   <li>{@link ResponseTransactionPair#getTransactionId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResponseTransactionPair.<init>(ValidateAndConfirmPaymentActivity)",
      "void ResponseTransactionPair.<init>(ValidateAndConfirmPaymentActivity, PaymentResponseDTO, Long)",
      "PaymentResponseDTO ResponseTransactionPair.getResponseDTO()", "Long ResponseTransactionPair.getTransactionId()"})
  public void testResponseTransactionPairGettersAndSetters() {
    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    ResponseTransactionPair actualResponseTransactionPair = validateAndConfirmPaymentActivity.new ResponseTransactionPair(
        responseDTO, 1L);
    PaymentResponseDTO actualResponseDTO = actualResponseTransactionPair.getResponseDTO();

    // Assert
    assertEquals(1L, actualResponseTransactionPair.getTransactionId().longValue());
    assertSame(responseDTO, actualResponseDTO);
  }

  /**
   * Test ResponseTransactionPair getters and setters.
   * <ul>
   *   <li>Then return TransactionId is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResponseTransactionPair#ResponseTransactionPair(ValidateAndConfirmPaymentActivity)}
   *   <li>{@link ResponseTransactionPair#getResponseDTO()}
   *   <li>{@link ResponseTransactionPair#getTransactionId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResponseTransactionPair.<init>(ValidateAndConfirmPaymentActivity)",
      "void ResponseTransactionPair.<init>(ValidateAndConfirmPaymentActivity, PaymentResponseDTO, Long)",
      "PaymentResponseDTO ResponseTransactionPair.getResponseDTO()", "Long ResponseTransactionPair.getTransactionId()"})
  public void testResponseTransactionPairGettersAndSetters_thenReturnTransactionIdIsNull() {
    // Arrange and Act
    ResponseTransactionPair actualResponseTransactionPair = (new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler())).new ResponseTransactionPair();
    PaymentResponseDTO actualResponseDTO = actualResponseTransactionPair.getResponseDTO();

    // Assert
    assertNull(actualResponseTransactionPair.getTransactionId());
    assertNull(actualResponseDTO);
  }

  /**
   * Test {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ResponseTransactionPair)}.
   * <p>
   * Method under test: {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ResponseTransactionPair)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAndConfirmPaymentActivity.shouldRollbackFailedTransaction(ResponseTransactionPair)"})
  public void testShouldRollbackFailedTransaction() {
    // Arrange, Act and Assert
    assertFalse(validateAndConfirmPaymentActivity
        .shouldRollbackFailedTransaction(validateAndConfirmPaymentActivity.new ResponseTransactionPair()));
  }

  /**
   * Test {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}.
   * <ul>
   *   <li>When {@link PaymentTransactionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.profile.core.domain.CustomerPayment ValidateAndConfirmPaymentActivity.createCustomerPaymentToken(PaymentTransaction)"})
  public void testCreateCustomerPaymentToken_whenPaymentTransactionImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(validateAndConfirmPaymentActivity.createCustomerPaymentToken(new PaymentTransactionImpl()));
  }
}
