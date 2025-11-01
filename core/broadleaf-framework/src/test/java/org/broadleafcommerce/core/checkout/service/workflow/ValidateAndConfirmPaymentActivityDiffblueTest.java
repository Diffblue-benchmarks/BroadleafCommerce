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
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.junit.Test;

public class ValidateAndConfirmPaymentActivityDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#ResponseTransactionPair(ValidateAndConfirmPaymentActivity)}
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#getResponseDTO()}
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#getTransactionId()}
   * </ul>
   */
  @Test
  public void testResponseTransactionPairGettersAndSetters() {
    // Arrange and Act
    ValidateAndConfirmPaymentActivity.ResponseTransactionPair actualResponseTransactionPair = (new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler())).new ResponseTransactionPair();
    PaymentResponseDTO actualResponseDTO = actualResponseTransactionPair.getResponseDTO();

    // Assert
    assertNull(actualResponseTransactionPair.getTransactionId());
    assertNull(actualResponseDTO);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#ResponseTransactionPair(ValidateAndConfirmPaymentActivity, PaymentResponseDTO, Long)}
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#getResponseDTO()}
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#getTransactionId()}
   * </ul>
   */
  @Test
  public void testResponseTransactionPairGettersAndSetters2() {
    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    ValidateAndConfirmPaymentActivity.ResponseTransactionPair actualResponseTransactionPair = validateAndConfirmPaymentActivity.new ResponseTransactionPair(
        responseDTO, 1L);
    PaymentResponseDTO actualResponseDTO = actualResponseTransactionPair.getResponseDTO();

    // Assert
    assertEquals(1L, actualResponseTransactionPair.getTransactionId().longValue());
    assertSame(responseDTO, actualResponseDTO);
  }

  /**
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ValidateAndConfirmPaymentActivity.ResponseTransactionPair)}
   */
  @Test
  public void testShouldRollbackFailedTransaction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());

    // Act and Assert
    assertFalse(validateAndConfirmPaymentActivity.shouldRollbackFailedTransaction(
        (new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler())).new ResponseTransactionPair()));
  }

  /**
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ValidateAndConfirmPaymentActivity.ResponseTransactionPair)}
   */
  @Test
  public void testShouldRollbackFailedTransaction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        mock(ConfirmPaymentsRollbackHandler.class));

    // Act and Assert
    assertFalse(validateAndConfirmPaymentActivity.shouldRollbackFailedTransaction(
        (new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler())).new ResponseTransactionPair()));
  }

  /**
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}
   */
  @Test
  public void testCreateCustomerPaymentToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());

    // Act and Assert
    assertNull(validateAndConfirmPaymentActivity.createCustomerPaymentToken(new PaymentTransactionImpl()));
  }

  /**
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}
   */
  @Test
  public void testCreateCustomerPaymentToken2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        mock(ConfirmPaymentsRollbackHandler.class));

    // Act and Assert
    assertNull(validateAndConfirmPaymentActivity.createCustomerPaymentToken(new PaymentTransactionImpl()));
  }
}
