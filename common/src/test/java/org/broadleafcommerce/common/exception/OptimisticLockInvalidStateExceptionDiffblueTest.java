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
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class OptimisticLockInvalidStateExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link OptimisticLockInvalidStateException#OptimisticLockInvalidStateException()}
   */
  @Test
  public void testNewOptimisticLockInvalidStateException() {
    // Arrange and Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException = new OptimisticLockInvalidStateException();

    // Assert
    assertNull(actualOptimisticLockInvalidStateException.getMessage());
    assertNull(actualOptimisticLockInvalidStateException.getCause());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(String)}
   */
  @Test
  public void testNewOptimisticLockInvalidStateException2() {
    // Arrange and Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException = new OptimisticLockInvalidStateException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualOptimisticLockInvalidStateException.getMessage());
    assertNull(actualOptimisticLockInvalidStateException.getCause());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(String, Throwable)}
   */
  @Test
  public void testNewOptimisticLockInvalidStateException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException = new OptimisticLockInvalidStateException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOptimisticLockInvalidStateException.getMessage());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockInvalidStateException.getCause());
  }

  /**
   * Method under test:
   * {@link OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewOptimisticLockInvalidStateException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException = new OptimisticLockInvalidStateException(
        "An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualOptimisticLockInvalidStateException.getMessage());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockInvalidStateException.getCause());
  }

  /**
   * Method under test:
   * {@link OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(Throwable)}
   */
  @Test
  public void testNewOptimisticLockInvalidStateException5() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException = new OptimisticLockInvalidStateException(
        cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOptimisticLockInvalidStateException.getMessage());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockInvalidStateException.getCause());
  }
}
