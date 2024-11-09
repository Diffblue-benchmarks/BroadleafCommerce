/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.resource.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ResourceMinificationExceptionDiffblueTest {
  /**
   * Test
   * {@link ResourceMinificationException#ResourceMinificationException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationException#ResourceMinificationException(String)}
   */
  @Test
  public void testNewResourceMinificationException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ResourceMinificationException actualResourceMinificationException = new ResourceMinificationException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualResourceMinificationException.getMessage());
    assertNull(actualResourceMinificationException.getCause());
    assertEquals(0, actualResourceMinificationException.getSuppressed().length);
  }

  /**
   * Test
   * {@link ResourceMinificationException#ResourceMinificationException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationException#ResourceMinificationException(String, Throwable)}
   */
  @Test
  public void testNewResourceMinificationException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ResourceMinificationException actualResourceMinificationException = new ResourceMinificationException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualResourceMinificationException.getMessage());
    assertEquals(0, actualResourceMinificationException.getSuppressed().length);
    assertSame(cause, actualResourceMinificationException.getCause());
  }

  /**
   * Test
   * {@link ResourceMinificationException#ResourceMinificationException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationException#ResourceMinificationException(Throwable)}
   */
  @Test
  public void testNewResourceMinificationException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ResourceMinificationException actualResourceMinificationException = new ResourceMinificationException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualResourceMinificationException.getMessage());
    assertEquals(0, actualResourceMinificationException.getSuppressed().length);
    assertSame(cause, actualResourceMinificationException.getCause());
  }

  /**
   * Test {@link ResourceMinificationException#ResourceMinificationException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMinificationException#ResourceMinificationException()}
   */
  @Test
  public void testNewResourceMinificationException_thenReturnMessageIsNull() {
    // Arrange and Act
    ResourceMinificationException actualResourceMinificationException = new ResourceMinificationException();

    // Assert
    assertNull(actualResourceMinificationException.getMessage());
    assertNull(actualResourceMinificationException.getCause());
    assertEquals(0, actualResourceMinificationException.getSuppressed().length);
  }
}
