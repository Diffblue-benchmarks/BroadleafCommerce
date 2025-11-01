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
package org.broadleafcommerce.core.util.lock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class DistributedLockDiffblueTest {
  /**
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException()}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException() {
    // Arrange and Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException();

    // Assert
    assertNull(actualDistributedLockException.getMessage());
    assertNull(actualDistributedLockException.getCause());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(String)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException2() {
    // Arrange and Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertNull(actualDistributedLockException.getCause());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(String, Throwable)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException3() {
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
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(String, Throwable, boolean, boolean)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException4() {
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

  /**
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(Throwable)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException5() {
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
}
