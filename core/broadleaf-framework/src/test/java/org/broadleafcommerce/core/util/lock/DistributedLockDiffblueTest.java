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
package org.broadleafcommerce.core.util.lock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.core.util.lock.DistributedLock.DistributedLockException;
import org.junit.Test;

public class DistributedLockDiffblueTest {
  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException(String, Throwable)}.
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(String, Throwable)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
    assertSame(cause, actualDistributedLockException.getCause());
  }

  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException(Throwable)}.
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(Throwable)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException(
        cause);

    // Assert
    assertEquals("java.lang.Throwable", actualDistributedLockException.getMessage());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
    assertSame(cause, actualDistributedLockException.getCause());
  }

  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException(String)}.
   * <ul>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(String)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException_thenReturnCauseIsNull() {
    // Arrange and Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertNull(actualDistributedLockException.getCause());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
  }

  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException()}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException_thenReturnMessageIsNull() {
    // Arrange and Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException();

    // Assert
    assertNull(actualDistributedLockException.getMessage());
    assertNull(actualDistributedLockException.getCause());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
  }

  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException(String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(String, Throwable, boolean, boolean)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException_whenTrue() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException(
        "An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
    assertSame(cause, actualDistributedLockException.getCause());
  }
}
