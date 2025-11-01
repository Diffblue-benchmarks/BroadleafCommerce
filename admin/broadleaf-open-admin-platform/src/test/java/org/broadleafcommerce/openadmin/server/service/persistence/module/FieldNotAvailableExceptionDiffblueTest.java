/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class FieldNotAvailableExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link FieldNotAvailableException#FieldNotAvailableException()}
   */
  @Test
  public void testNewFieldNotAvailableException() {
    // Arrange and Act
    FieldNotAvailableException actualFieldNotAvailableException = new FieldNotAvailableException();

    // Assert
    assertNull(actualFieldNotAvailableException.getMessage());
    assertNull(actualFieldNotAvailableException.getCause());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link FieldNotAvailableException#FieldNotAvailableException(String)}
   */
  @Test
  public void testNewFieldNotAvailableException2() {
    // Arrange and Act
    FieldNotAvailableException actualFieldNotAvailableException = new FieldNotAvailableException("foo");

    // Assert
    assertEquals("foo", actualFieldNotAvailableException.getMessage());
    assertNull(actualFieldNotAvailableException.getCause());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link FieldNotAvailableException#FieldNotAvailableException(String, Throwable)}
   */
  @Test
  public void testNewFieldNotAvailableException3() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    FieldNotAvailableException actualFieldNotAvailableException = new FieldNotAvailableException("foo", throwable);

    // Assert
    assertEquals("foo", actualFieldNotAvailableException.getMessage());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
    assertSame(throwable, actualFieldNotAvailableException.getCause());
  }

  /**
   * Method under test:
   * {@link FieldNotAvailableException#FieldNotAvailableException(Throwable)}
   */
  @Test
  public void testNewFieldNotAvailableException4() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    FieldNotAvailableException actualFieldNotAvailableException = new FieldNotAvailableException(throwable);

    // Assert
    assertEquals("java.lang.Throwable", actualFieldNotAvailableException.getMessage());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
    assertSame(throwable, actualFieldNotAvailableException.getCause());
  }
}
