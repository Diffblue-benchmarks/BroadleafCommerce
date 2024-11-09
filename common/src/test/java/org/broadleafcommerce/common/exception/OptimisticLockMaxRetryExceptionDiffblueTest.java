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
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class OptimisticLockMaxRetryExceptionDiffblueTest {
  /**
   * Test
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String, Throwable)}
   */
  @Test
  public void testNewOptimisticLockMaxRetryException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException = new OptimisticLockMaxRetryException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOptimisticLockMaxRetryException.getMessage());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockMaxRetryException.getCause());
  }

  /**
   * Test
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(Throwable)}
   */
  @Test
  public void testNewOptimisticLockMaxRetryException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException = new OptimisticLockMaxRetryException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOptimisticLockMaxRetryException.getMessage());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockMaxRetryException.getCause());
  }

  /**
   * Test
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException()}
   */
  @Test
  public void testNewOptimisticLockMaxRetryException_thenReturnMessageIsNull() {
    // Arrange and Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException = new OptimisticLockMaxRetryException();

    // Assert
    assertNull(actualOptimisticLockMaxRetryException.getMessage());
    assertNull(actualOptimisticLockMaxRetryException.getCause());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
  }

  /**
   * Test
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String)}
   */
  @Test
  public void testNewOptimisticLockMaxRetryException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException = new OptimisticLockMaxRetryException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualOptimisticLockMaxRetryException.getMessage());
    assertNull(actualOptimisticLockMaxRetryException.getCause());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
  }

  /**
   * Test
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewOptimisticLockMaxRetryException_whenTrue() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException = new OptimisticLockMaxRetryException(
        "An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualOptimisticLockMaxRetryException.getMessage());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockMaxRetryException.getCause());
  }
}
