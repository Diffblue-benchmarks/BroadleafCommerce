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

public class ItemNotFoundExceptionDiffblueTest {
  /**
   * Test {@link ItemNotFoundException#ItemNotFoundException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemNotFoundException#ItemNotFoundException(String)}
   */
  @Test
  public void testNewItemNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ItemNotFoundException actualItemNotFoundException = new ItemNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualItemNotFoundException.getMessage());
    assertNull(actualItemNotFoundException.getCause());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link ItemNotFoundException#ItemNotFoundException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemNotFoundException#ItemNotFoundException(String, Throwable)}
   */
  @Test
  public void testNewItemNotFoundException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ItemNotFoundException actualItemNotFoundException = new ItemNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualItemNotFoundException.getMessage());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
    assertSame(cause, actualItemNotFoundException.getCause());
  }

  /**
   * Test {@link ItemNotFoundException#ItemNotFoundException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemNotFoundException#ItemNotFoundException()}
   */
  @Test
  public void testNewItemNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    ItemNotFoundException actualItemNotFoundException = new ItemNotFoundException();

    // Assert
    assertNull(actualItemNotFoundException.getMessage());
    assertNull(actualItemNotFoundException.getCause());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link ItemNotFoundException#ItemNotFoundException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemNotFoundException#ItemNotFoundException(Throwable)}
   */
  @Test
  public void testNewItemNotFoundException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ItemNotFoundException actualItemNotFoundException = new ItemNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualItemNotFoundException.getMessage());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
    assertSame(cause, actualItemNotFoundException.getCause());
  }
}
