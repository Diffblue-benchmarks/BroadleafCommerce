/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class AddToCartExceptionDiffblueTest {
  /**
   * Test {@link AddToCartException#AddToCartException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddToCartException#AddToCartException()}
   */
  @Test
  public void testNewAddToCartException_thenReturnMessageIsNull() {
    // Arrange and Act
    AddToCartException actualAddToCartException = new AddToCartException();

    // Assert
    assertNull(actualAddToCartException.getMessage());
    assertNull(actualAddToCartException.getCause());
    assertEquals(0, actualAddToCartException.getSuppressed().length);
  }

  /**
   * Test {@link AddToCartException#AddToCartException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddToCartException#AddToCartException(String)}
   */
  @Test
  public void testNewAddToCartException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    AddToCartException actualAddToCartException = new AddToCartException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAddToCartException.getMessage());
    assertNull(actualAddToCartException.getCause());
    assertEquals(0, actualAddToCartException.getSuppressed().length);
  }

  /**
   * Test {@link AddToCartException#AddToCartException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddToCartException#AddToCartException(String, Throwable)}
   */
  @Test
  public void testNewAddToCartException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AddToCartException actualAddToCartException = new AddToCartException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualAddToCartException.getMessage());
    assertEquals(0, actualAddToCartException.getSuppressed().length);
    assertSame(cause, actualAddToCartException.getCause());
  }

  /**
   * Test {@link AddToCartException#AddToCartException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddToCartException#AddToCartException(Throwable)}
   */
  @Test
  public void testNewAddToCartException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AddToCartException actualAddToCartException = new AddToCartException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualAddToCartException.getMessage());
    assertEquals(0, actualAddToCartException.getSuppressed().length);
    assertSame(cause, actualAddToCartException.getCause());
  }
}
