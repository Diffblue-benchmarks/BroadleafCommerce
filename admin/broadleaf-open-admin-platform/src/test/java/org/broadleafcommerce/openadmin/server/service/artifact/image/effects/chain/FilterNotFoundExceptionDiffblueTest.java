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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class FilterNotFoundExceptionDiffblueTest {
  /**
   * Test {@link FilterNotFoundException#FilterNotFoundException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterNotFoundException#FilterNotFoundException(String)}
   */
  @Test
  public void testNewFilterNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    FilterNotFoundException actualFilterNotFoundException = new FilterNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualFilterNotFoundException.getMessage());
    assertNull(actualFilterNotFoundException.getCause());
    assertEquals(0, actualFilterNotFoundException.getSuppressed().length);
  }

  /**
   * Test
   * {@link FilterNotFoundException#FilterNotFoundException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterNotFoundException#FilterNotFoundException(String, Throwable)}
   */
  @Test
  public void testNewFilterNotFoundException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FilterNotFoundException actualFilterNotFoundException = new FilterNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualFilterNotFoundException.getMessage());
    assertEquals(0, actualFilterNotFoundException.getSuppressed().length);
    assertSame(cause, actualFilterNotFoundException.getCause());
  }

  /**
   * Test {@link FilterNotFoundException#FilterNotFoundException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterNotFoundException#FilterNotFoundException(Throwable)}
   */
  @Test
  public void testNewFilterNotFoundException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FilterNotFoundException actualFilterNotFoundException = new FilterNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualFilterNotFoundException.getMessage());
    assertEquals(0, actualFilterNotFoundException.getSuppressed().length);
    assertSame(cause, actualFilterNotFoundException.getCause());
  }

  /**
   * Test {@link FilterNotFoundException#FilterNotFoundException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterNotFoundException#FilterNotFoundException()}
   */
  @Test
  public void testNewFilterNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    FilterNotFoundException actualFilterNotFoundException = new FilterNotFoundException();

    // Assert
    assertNull(actualFilterNotFoundException.getMessage());
    assertNull(actualFilterNotFoundException.getCause());
    assertEquals(0, actualFilterNotFoundException.getSuppressed().length);
  }
}
