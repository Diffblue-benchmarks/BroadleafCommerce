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

public class SecurityServiceExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link SecurityServiceException#SecurityServiceException()}
   */
  @Test
  public void testNewSecurityServiceException() {
    // Arrange and Act
    SecurityServiceException actualSecurityServiceException = new SecurityServiceException();

    // Assert
    assertNull(actualSecurityServiceException.getMessage());
    assertNull(actualSecurityServiceException.getCause());
    assertEquals(0, actualSecurityServiceException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link SecurityServiceException#SecurityServiceException(String)}
   */
  @Test
  public void testNewSecurityServiceException2() {
    // Arrange and Act
    SecurityServiceException actualSecurityServiceException = new SecurityServiceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSecurityServiceException.getMessage());
    assertNull(actualSecurityServiceException.getCause());
    assertEquals(0, actualSecurityServiceException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link SecurityServiceException#SecurityServiceException(String, Throwable)}
   */
  @Test
  public void testNewSecurityServiceException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SecurityServiceException actualSecurityServiceException = new SecurityServiceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualSecurityServiceException.getMessage());
    assertEquals(0, actualSecurityServiceException.getSuppressed().length);
    assertSame(cause, actualSecurityServiceException.getCause());
  }

  /**
   * Method under test:
   * {@link SecurityServiceException#SecurityServiceException(Throwable)}
   */
  @Test
  public void testNewSecurityServiceException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SecurityServiceException actualSecurityServiceException = new SecurityServiceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualSecurityServiceException.getMessage());
    assertEquals(0, actualSecurityServiceException.getSuppressed().length);
    assertSame(cause, actualSecurityServiceException.getCause());
  }
}
