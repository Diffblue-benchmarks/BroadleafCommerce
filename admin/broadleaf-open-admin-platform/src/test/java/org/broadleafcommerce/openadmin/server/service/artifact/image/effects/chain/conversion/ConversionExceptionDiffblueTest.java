/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ConversionExceptionDiffblueTest {
  /**
   * Test {@link ConversionException#ConversionException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConversionException#ConversionException(String)}
   */
  @Test
  public void testNewConversionException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ConversionException actualConversionException = new ConversionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualConversionException.getMessage());
    assertNull(actualConversionException.getCause());
    assertEquals(0, actualConversionException.getSuppressed().length);
  }

  /**
   * Test {@link ConversionException#ConversionException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConversionException#ConversionException(String, Throwable)}
   */
  @Test
  public void testNewConversionException_thenReturnMessageIsAnErrorOccurred2() {
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
   * Test {@link ConversionException#ConversionException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConversionException#ConversionException()}
   */
  @Test
  public void testNewConversionException_thenReturnMessageIsNull() {
    // Arrange and Act
    ConversionException actualConversionException = new ConversionException();

    // Assert
    assertNull(actualConversionException.getMessage());
    assertNull(actualConversionException.getCause());
    assertEquals(0, actualConversionException.getSuppressed().length);
  }

  /**
   * Test {@link ConversionException#ConversionException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConversionException#ConversionException(Throwable)}
   */
  @Test
  public void testNewConversionException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
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
