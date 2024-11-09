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
package org.broadleafcommerce.core.payment.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class PaymentExceptionDiffblueTest {
  /**
   * Test {@link PaymentException#PaymentException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException()}
   */
  @Test
  public void testNewPaymentException_thenReturnMessageIsNull() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException();

    // Assert
    assertNull(actualPaymentException.getMessage());
    assertNull(actualPaymentException.getCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
  }

  /**
   * Test {@link PaymentException#PaymentException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(String)}
   */
  @Test
  public void testNewPaymentException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualPaymentException.getMessage());
    assertNull(actualPaymentException.getCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
  }

  /**
   * Test {@link PaymentException#PaymentException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  public void testNewPaymentException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PaymentException actualPaymentException = new PaymentException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualPaymentException.getMessage());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(cause, actualPaymentException.getCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  public void testNewPaymentException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PaymentException actualPaymentException = new PaymentException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualPaymentException.getMessage());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(cause, actualPaymentException.getCause());
  }
}
