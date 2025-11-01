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
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  public void testNewPaymentException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PaymentException actualPaymentException = new PaymentException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualPaymentException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualPaymentException.getMessage());
    assertNull(actualPaymentException.getRootCauseMessage());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(cause, actualPaymentException.getCause());
    assertSame(cause, actualPaymentException.getRootCause());
  }

  /**
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  public void testNewPaymentException3() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException((Throwable) null);

    // Assert
    assertNull(actualPaymentException.getLocalizedMessage());
    assertNull(actualPaymentException.getMessage());
    assertNull(actualPaymentException.getRootCauseMessage());
    assertNull(actualPaymentException.getCause());
    assertNull(actualPaymentException.getRootCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
  }

  /**
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  public void testNewPaymentException4() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    PaymentException actualPaymentException = new PaymentException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualPaymentException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualPaymentException.getMessage());
    assertNull(actualPaymentException.getRootCauseMessage());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(cause, actualPaymentException.getCause());
    assertSame(throwable, actualPaymentException.getRootCause());
  }

  /**
   * Method under test: {@link PaymentException#PaymentException(String)}
   */
  @Test
  public void testNewPaymentException5() {
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
   * Method under test:
   * {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  public void testNewPaymentException6() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PaymentException actualPaymentException = new PaymentException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualPaymentException.getLocalizedMessage());
    assertEquals("An error occurred", actualPaymentException.getMessage());
    assertNull(actualPaymentException.getRootCauseMessage());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(cause, actualPaymentException.getCause());
    assertSame(cause, actualPaymentException.getRootCause());
  }

  /**
   * Method under test:
   * {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  public void testNewPaymentException7() {
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
   * Method under test:
   * {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  public void testNewPaymentException8() {
    // Arrange
    Throwable throwable = new Throwable();
    IOException cause = new IOException("foo", throwable);

    // Act
    PaymentException actualPaymentException = new PaymentException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualPaymentException.getLocalizedMessage());
    assertEquals("An error occurred", actualPaymentException.getMessage());
    assertNull(actualPaymentException.getRootCauseMessage());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(cause, actualPaymentException.getCause());
    assertSame(throwable, actualPaymentException.getRootCause());
  }
}
