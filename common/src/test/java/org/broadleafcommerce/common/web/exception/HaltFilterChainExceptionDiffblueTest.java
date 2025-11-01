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
package org.broadleafcommerce.common.web.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class HaltFilterChainExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link HaltFilterChainException#HaltFilterChainException()}
   */
  @Test
  public void testNewHaltFilterChainException() {
    // Arrange and Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException();

    // Assert
    assertNull(actualHaltFilterChainException.getMessage());
    assertNull(actualHaltFilterChainException.getCause());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link HaltFilterChainException#HaltFilterChainException(String)}
   */
  @Test
  public void testNewHaltFilterChainException2() {
    // Arrange and Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualHaltFilterChainException.getMessage());
    assertNull(actualHaltFilterChainException.getCause());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link HaltFilterChainException#HaltFilterChainException(String, Throwable)}
   */
  @Test
  public void testNewHaltFilterChainException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualHaltFilterChainException.getMessage());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
    assertSame(cause, actualHaltFilterChainException.getCause());
  }

  /**
   * Method under test:
   * {@link HaltFilterChainException#HaltFilterChainException(Throwable)}
   */
  @Test
  public void testNewHaltFilterChainException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualHaltFilterChainException.getMessage());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
    assertSame(cause, actualHaltFilterChainException.getCause());
  }
}
