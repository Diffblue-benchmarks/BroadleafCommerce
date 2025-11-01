/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order.security.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class OrderLockAcquisitionFailureExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException()}
   */
  @Test
  void testNewOrderLockAcquisitionFailureException() {
    // Arrange and Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException();

    // Assert
    assertNull(actualOrderLockAcquisitionFailureException.getMessage());
    assertNull(actualOrderLockAcquisitionFailureException.getCause());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String)}
   */
  @Test
  void testNewOrderLockAcquisitionFailureException2() {
    // Arrange and Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualOrderLockAcquisitionFailureException.getMessage());
    assertNull(actualOrderLockAcquisitionFailureException.getCause());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String, Throwable)}
   */
  @Test
  void testNewOrderLockAcquisitionFailureException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOrderLockAcquisitionFailureException.getMessage());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
    assertSame(cause, actualOrderLockAcquisitionFailureException.getCause());
  }

  /**
   * Method under test:
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(Throwable)}
   */
  @Test
  void testNewOrderLockAcquisitionFailureException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException(
        cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOrderLockAcquisitionFailureException.getMessage());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
    assertSame(cause, actualOrderLockAcquisitionFailureException.getCause());
  }
}
