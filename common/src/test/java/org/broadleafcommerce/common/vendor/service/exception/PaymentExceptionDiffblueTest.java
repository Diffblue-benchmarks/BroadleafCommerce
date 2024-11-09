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
package org.broadleafcommerce.common.vendor.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentException.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentExceptionDiffblueTest {
  @Autowired
  private PaymentException paymentException;

  /**
   * Test {@link PaymentException#PaymentException()}.
   * <p>
   * Method under test: {@link PaymentException#PaymentException()}
   */
  @Test
  public void testNewPaymentException() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException();

    // Assert
    assertNull(actualPaymentException.getMessage());
    assertNull(actualPaymentException.getCause());
    assertNull(actualPaymentException.getRootCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
  }

  /**
   * Test {@link PaymentException#PaymentException(String)}.
   * <p>
   * Method under test: {@link PaymentException#PaymentException(String)}
   */
  @Test
  public void testNewPaymentException2() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualPaymentException.getLocalizedMessage());
    assertEquals("An error occurred", actualPaymentException.getMessage());
    assertEquals("An error occurred", actualPaymentException.getRootCauseMessage());
    assertNull(actualPaymentException.getCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(actualPaymentException, actualPaymentException.getRootCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(Throwable)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  public void testNewPaymentException_givenThrowable_thenReturnRootCauseLocalizedMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    PaymentException actualPaymentException = new PaymentException(cause);

    // Assert
    Throwable rootCause = actualPaymentException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualPaymentException.getCause().getCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(Throwable)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  public void testNewPaymentException_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PaymentException actualPaymentException = new PaymentException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualPaymentException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualPaymentException.getMessage());
    assertSame(cause, actualPaymentException.getCause());
    assertSame(cause, actualPaymentException.getRootCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(String, Throwable)}.
   * <ul>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  public void testNewPaymentException_thenReturnRootCauseLocalizedMessageIsNull() {
    // Arrange
    IOException cause = new IOException("foo", new Throwable());

    // Act
    PaymentException actualPaymentException = new PaymentException("An error occurred", cause);

    // Assert
    Throwable rootCause = actualPaymentException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(cause, actualPaymentException.getCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(String, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  public void testNewPaymentException_whenNull_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException("An error occurred", null);

    // Assert
    assertEquals("An error occurred", actualPaymentException.getLocalizedMessage());
    assertEquals("An error occurred", actualPaymentException.getMessage());
    assertEquals("An error occurred", actualPaymentException.getRootCauseMessage());
    assertNull(actualPaymentException.getCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(actualPaymentException, actualPaymentException.getRootCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  public void testNewPaymentException_whenNull_thenReturnLocalizedMessageIsNull() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException((Throwable) null);

    // Assert
    assertNull(actualPaymentException.getLocalizedMessage());
    assertNull(actualPaymentException.getMessage());
    assertNull(actualPaymentException.getCause());
    assertNull(actualPaymentException.getRootCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  public void testNewPaymentException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PaymentException actualPaymentException = new PaymentException("An error occurred", cause);

    // Assert
    Throwable cause2 = actualPaymentException.getCause();
    assertSame(cause, cause2);
    assertSame(cause2, actualPaymentException.getRootCause());
  }
}
