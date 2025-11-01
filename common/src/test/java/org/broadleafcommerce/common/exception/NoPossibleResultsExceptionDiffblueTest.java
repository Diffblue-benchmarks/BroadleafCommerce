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

public class NoPossibleResultsExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link NoPossibleResultsException#NoPossibleResultsException()}
   */
  @Test
  public void testNewNoPossibleResultsException() {
    // Arrange and Act
    NoPossibleResultsException actualNoPossibleResultsException = new NoPossibleResultsException();

    // Assert
    assertNull(actualNoPossibleResultsException.getMessage());
    assertNull(actualNoPossibleResultsException.getCause());
    assertEquals(0, actualNoPossibleResultsException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link NoPossibleResultsException#NoPossibleResultsException(String)}
   */
  @Test
  public void testNewNoPossibleResultsException2() {
    // Arrange and Act
    NoPossibleResultsException actualNoPossibleResultsException = new NoPossibleResultsException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualNoPossibleResultsException.getMessage());
    assertNull(actualNoPossibleResultsException.getCause());
    assertEquals(0, actualNoPossibleResultsException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link NoPossibleResultsException#NoPossibleResultsException(String, Throwable)}
   */
  @Test
  public void testNewNoPossibleResultsException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NoPossibleResultsException actualNoPossibleResultsException = new NoPossibleResultsException("An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualNoPossibleResultsException.getMessage());
    assertEquals(0, actualNoPossibleResultsException.getSuppressed().length);
    assertSame(cause, actualNoPossibleResultsException.getCause());
  }

  /**
   * Method under test:
   * {@link NoPossibleResultsException#NoPossibleResultsException(Throwable)}
   */
  @Test
  public void testNewNoPossibleResultsException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NoPossibleResultsException actualNoPossibleResultsException = new NoPossibleResultsException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualNoPossibleResultsException.getMessage());
    assertEquals(0, actualNoPossibleResultsException.getSuppressed().length);
    assertSame(cause, actualNoPossibleResultsException.getCause());
  }
}
