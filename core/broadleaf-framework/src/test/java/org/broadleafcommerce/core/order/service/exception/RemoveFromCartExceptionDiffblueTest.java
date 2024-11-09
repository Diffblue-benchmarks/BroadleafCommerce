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

public class RemoveFromCartExceptionDiffblueTest {
  /**
   * Test {@link RemoveFromCartException#RemoveFromCartException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoveFromCartException#RemoveFromCartException(String)}
   */
  @Test
  public void testNewRemoveFromCartException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    RemoveFromCartException actualRemoveFromCartException = new RemoveFromCartException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualRemoveFromCartException.getMessage());
    assertNull(actualRemoveFromCartException.getCause());
    assertEquals(0, actualRemoveFromCartException.getSuppressed().length);
  }

  /**
   * Test
   * {@link RemoveFromCartException#RemoveFromCartException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoveFromCartException#RemoveFromCartException(String, Throwable)}
   */
  @Test
  public void testNewRemoveFromCartException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RemoveFromCartException actualRemoveFromCartException = new RemoveFromCartException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualRemoveFromCartException.getMessage());
    assertEquals(0, actualRemoveFromCartException.getSuppressed().length);
    assertSame(cause, actualRemoveFromCartException.getCause());
  }

  /**
   * Test {@link RemoveFromCartException#RemoveFromCartException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoveFromCartException#RemoveFromCartException(Throwable)}
   */
  @Test
  public void testNewRemoveFromCartException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RemoveFromCartException actualRemoveFromCartException = new RemoveFromCartException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualRemoveFromCartException.getMessage());
    assertEquals(0, actualRemoveFromCartException.getSuppressed().length);
    assertSame(cause, actualRemoveFromCartException.getCause());
  }

  /**
   * Test {@link RemoveFromCartException#RemoveFromCartException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveFromCartException#RemoveFromCartException()}
   */
  @Test
  public void testNewRemoveFromCartException_thenReturnMessageIsNull() {
    // Arrange and Act
    RemoveFromCartException actualRemoveFromCartException = new RemoveFromCartException();

    // Assert
    assertNull(actualRemoveFromCartException.getMessage());
    assertNull(actualRemoveFromCartException.getCause());
    assertEquals(0, actualRemoveFromCartException.getSuppressed().length);
  }
}
