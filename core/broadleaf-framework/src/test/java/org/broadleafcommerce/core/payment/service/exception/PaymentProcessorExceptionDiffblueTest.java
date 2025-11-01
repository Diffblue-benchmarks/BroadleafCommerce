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
package org.broadleafcommerce.core.payment.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.payment.domain.PaymentResponseItem;
import org.junit.Test;

public class PaymentProcessorExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PaymentProcessorException#PaymentProcessorException(String, Throwable, PaymentResponseItem)}
   *   <li>{@link PaymentProcessorException#getPaymentResponseItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();
    PaymentResponseItem paymentResponseItem = mock(PaymentResponseItem.class);

    // Act
    PaymentProcessorException actualPaymentProcessorException = new PaymentProcessorException("An error occurred",
        cause, paymentResponseItem);
    PaymentResponseItem actualPaymentResponseItem = actualPaymentProcessorException.getPaymentResponseItem();

    // Assert
    assertEquals("An error occurred", actualPaymentProcessorException.getMessage());
    assertEquals(0, actualPaymentProcessorException.getSuppressed().length);
    assertSame(cause, actualPaymentProcessorException.getCause());
    assertSame(paymentResponseItem, actualPaymentResponseItem);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PaymentProcessorException#PaymentProcessorException(String, PaymentResponseItem)}
   *   <li>{@link PaymentProcessorException#getPaymentResponseItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    PaymentResponseItem paymentResponseItem = mock(PaymentResponseItem.class);

    // Act
    PaymentProcessorException actualPaymentProcessorException = new PaymentProcessorException("An error occurred",
        paymentResponseItem);
    PaymentResponseItem actualPaymentResponseItem = actualPaymentProcessorException.getPaymentResponseItem();

    // Assert
    assertEquals("An error occurred", actualPaymentProcessorException.getMessage());
    assertNull(actualPaymentProcessorException.getCause());
    assertEquals(0, actualPaymentProcessorException.getSuppressed().length);
    assertSame(paymentResponseItem, actualPaymentResponseItem);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PaymentProcessorException#PaymentProcessorException(Throwable, PaymentResponseItem)}
   *   <li>{@link PaymentProcessorException#getPaymentResponseItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters3() {
    // Arrange
    Throwable cause = new Throwable();
    PaymentResponseItem paymentResponseItem = mock(PaymentResponseItem.class);

    // Act
    PaymentProcessorException actualPaymentProcessorException = new PaymentProcessorException(cause,
        paymentResponseItem);
    PaymentResponseItem actualPaymentResponseItem = actualPaymentProcessorException.getPaymentResponseItem();

    // Assert
    assertEquals("java.lang.Throwable", actualPaymentProcessorException.getMessage());
    assertEquals(0, actualPaymentProcessorException.getSuppressed().length);
    assertSame(cause, actualPaymentProcessorException.getCause());
    assertSame(paymentResponseItem, actualPaymentResponseItem);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PaymentProcessorException#PaymentProcessorException(PaymentResponseItem)}
   *   <li>{@link PaymentProcessorException#getPaymentResponseItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters4() {
    // Arrange
    PaymentResponseItem paymentResponseItem = mock(PaymentResponseItem.class);

    // Act
    PaymentProcessorException actualPaymentProcessorException = new PaymentProcessorException(paymentResponseItem);
    PaymentResponseItem actualPaymentResponseItem = actualPaymentProcessorException.getPaymentResponseItem();

    // Assert
    assertNull(actualPaymentProcessorException.getMessage());
    assertNull(actualPaymentProcessorException.getCause());
    assertEquals(0, actualPaymentProcessorException.getSuppressed().length);
    assertSame(paymentResponseItem, actualPaymentResponseItem);
  }
}
