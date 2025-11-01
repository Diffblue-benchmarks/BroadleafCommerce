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

public class ProxyDetectionExceptionDiffblueTest {
  /**
   * Method under test: {@link ProxyDetectionException#ProxyDetectionException()}
   */
  @Test
  public void testNewProxyDetectionException() {
    // Arrange and Act
    ProxyDetectionException actualProxyDetectionException = new ProxyDetectionException();

    // Assert
    assertNull(actualProxyDetectionException.getMessage());
    assertNull(actualProxyDetectionException.getCause());
    assertEquals(0, actualProxyDetectionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ProxyDetectionException#ProxyDetectionException(String)}
   */
  @Test
  public void testNewProxyDetectionException2() {
    // Arrange and Act
    ProxyDetectionException actualProxyDetectionException = new ProxyDetectionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualProxyDetectionException.getMessage());
    assertNull(actualProxyDetectionException.getCause());
    assertEquals(0, actualProxyDetectionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ProxyDetectionException#ProxyDetectionException(String, Throwable)}
   */
  @Test
  public void testNewProxyDetectionException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyDetectionException actualProxyDetectionException = new ProxyDetectionException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualProxyDetectionException.getMessage());
    assertEquals(0, actualProxyDetectionException.getSuppressed().length);
    assertSame(cause, actualProxyDetectionException.getCause());
  }

  /**
   * Method under test:
   * {@link ProxyDetectionException#ProxyDetectionException(String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewProxyDetectionException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyDetectionException actualProxyDetectionException = new ProxyDetectionException("An error occurred", cause,
        true, true);

    // Assert
    assertEquals("An error occurred", actualProxyDetectionException.getMessage());
    assertEquals(0, actualProxyDetectionException.getSuppressed().length);
    assertSame(cause, actualProxyDetectionException.getCause());
  }

  /**
   * Method under test:
   * {@link ProxyDetectionException#ProxyDetectionException(Throwable)}
   */
  @Test
  public void testNewProxyDetectionException5() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyDetectionException actualProxyDetectionException = new ProxyDetectionException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualProxyDetectionException.getMessage());
    assertEquals(0, actualProxyDetectionException.getSuppressed().length);
    assertSame(cause, actualProxyDetectionException.getCause());
  }
}
