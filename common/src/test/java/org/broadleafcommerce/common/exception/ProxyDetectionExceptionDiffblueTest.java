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

public class ProxyDetectionExceptionDiffblueTest {
  /**
   * Test
   * {@link ProxyDetectionException#ProxyDetectionException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProxyDetectionException#ProxyDetectionException(String, Throwable)}
   */
  @Test
  public void testNewProxyDetectionException_thenReturnMessageIsAnErrorOccurred() {
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
   * Test {@link ProxyDetectionException#ProxyDetectionException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProxyDetectionException#ProxyDetectionException(Throwable)}
   */
  @Test
  public void testNewProxyDetectionException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyDetectionException actualProxyDetectionException = new ProxyDetectionException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualProxyDetectionException.getMessage());
    assertEquals(0, actualProxyDetectionException.getSuppressed().length);
    assertSame(cause, actualProxyDetectionException.getCause());
  }

  /**
   * Test {@link ProxyDetectionException#ProxyDetectionException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyDetectionException#ProxyDetectionException()}
   */
  @Test
  public void testNewProxyDetectionException_thenReturnMessageIsNull() {
    // Arrange and Act
    ProxyDetectionException actualProxyDetectionException = new ProxyDetectionException();

    // Assert
    assertNull(actualProxyDetectionException.getMessage());
    assertNull(actualProxyDetectionException.getCause());
    assertEquals(0, actualProxyDetectionException.getSuppressed().length);
  }

  /**
   * Test {@link ProxyDetectionException#ProxyDetectionException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProxyDetectionException#ProxyDetectionException(String)}
   */
  @Test
  public void testNewProxyDetectionException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ProxyDetectionException actualProxyDetectionException = new ProxyDetectionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualProxyDetectionException.getMessage());
    assertNull(actualProxyDetectionException.getCause());
    assertEquals(0, actualProxyDetectionException.getSuppressed().length);
  }

  /**
   * Test
   * {@link ProxyDetectionException#ProxyDetectionException(String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProxyDetectionException#ProxyDetectionException(String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewProxyDetectionException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
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
}
