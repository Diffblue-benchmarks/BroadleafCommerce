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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ConversionExceptionDiffblueTest {
  /**
   * Method under test: {@link ConversionException#ConversionException()}
   */
  @Test
  public void testNewConversionException() {
    // Arrange and Act
    ConversionException actualConversionException = new ConversionException();

    // Assert
    assertNull(actualConversionException.getMessage());
    assertNull(actualConversionException.getCause());
    assertEquals(0, actualConversionException.getSuppressed().length);
  }

  /**
   * Method under test: {@link ConversionException#ConversionException(String)}
   */
  @Test
  public void testNewConversionException2() {
    // Arrange and Act
    ConversionException actualConversionException = new ConversionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualConversionException.getMessage());
    assertNull(actualConversionException.getCause());
    assertEquals(0, actualConversionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConversionException#ConversionException(String, Throwable)}
   */
  @Test
  public void testNewConversionException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConversionException actualConversionException = new ConversionException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualConversionException.getMessage());
    assertEquals(0, actualConversionException.getSuppressed().length);
    assertSame(cause, actualConversionException.getCause());
  }

  /**
   * Method under test: {@link ConversionException#ConversionException(Throwable)}
   */
  @Test
  public void testNewConversionException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConversionException actualConversionException = new ConversionException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualConversionException.getMessage());
    assertEquals(0, actualConversionException.getSuppressed().length);
    assertSame(cause, actualConversionException.getCause());
  }
}
