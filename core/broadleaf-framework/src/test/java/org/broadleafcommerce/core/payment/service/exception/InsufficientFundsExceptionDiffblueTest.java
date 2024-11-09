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

public class InsufficientFundsExceptionDiffblueTest {
  /**
   * Test {@link InsufficientFundsException#InsufficientFundsException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InsufficientFundsException#InsufficientFundsException(String)}
   */
  @Test
  public void testNewInsufficientFundsException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    InsufficientFundsException actualInsufficientFundsException = new InsufficientFundsException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInsufficientFundsException.getMessage());
    assertNull(actualInsufficientFundsException.getCause());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
  }

  /**
   * Test
   * {@link InsufficientFundsException#InsufficientFundsException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InsufficientFundsException#InsufficientFundsException(String, Throwable)}
   */
  @Test
  public void testNewInsufficientFundsException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InsufficientFundsException actualInsufficientFundsException = new InsufficientFundsException("An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualInsufficientFundsException.getMessage());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
    assertSame(cause, actualInsufficientFundsException.getCause());
  }

  /**
   * Test
   * {@link InsufficientFundsException#InsufficientFundsException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InsufficientFundsException#InsufficientFundsException(Throwable)}
   */
  @Test
  public void testNewInsufficientFundsException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InsufficientFundsException actualInsufficientFundsException = new InsufficientFundsException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualInsufficientFundsException.getMessage());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
    assertSame(cause, actualInsufficientFundsException.getCause());
  }

  /**
   * Test {@link InsufficientFundsException#InsufficientFundsException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InsufficientFundsException#InsufficientFundsException()}
   */
  @Test
  public void testNewInsufficientFundsException_thenReturnMessageIsNull() {
    // Arrange and Act
    InsufficientFundsException actualInsufficientFundsException = new InsufficientFundsException();

    // Assert
    assertNull(actualInsufficientFundsException.getMessage());
    assertNull(actualInsufficientFundsException.getCause());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
  }
}
