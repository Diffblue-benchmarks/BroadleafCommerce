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
package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class PersistenceExceptionDiffblueTest {
  /**
   * Test {@link PersistenceException#PersistenceException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceException#PersistenceException(String)}
   */
  @Test
  public void testNewPersistenceException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    PersistenceException actualPersistenceException = new PersistenceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualPersistenceException.getMessage());
    assertNull(actualPersistenceException.getCause());
    assertEquals(0, actualPersistenceException.getSuppressed().length);
  }

  /**
   * Test {@link PersistenceException#PersistenceException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceException#PersistenceException(String, Throwable)}
   */
  @Test
  public void testNewPersistenceException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PersistenceException actualPersistenceException = new PersistenceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualPersistenceException.getMessage());
    assertEquals(0, actualPersistenceException.getSuppressed().length);
    assertSame(cause, actualPersistenceException.getCause());
  }

  /**
   * Test {@link PersistenceException#PersistenceException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceException#PersistenceException()}
   */
  @Test
  public void testNewPersistenceException_thenReturnMessageIsNull() {
    // Arrange and Act
    PersistenceException actualPersistenceException = new PersistenceException();

    // Assert
    assertNull(actualPersistenceException.getMessage());
    assertNull(actualPersistenceException.getCause());
    assertEquals(0, actualPersistenceException.getSuppressed().length);
  }

  /**
   * Test {@link PersistenceException#PersistenceException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceException#PersistenceException(Throwable)}
   */
  @Test
  public void testNewPersistenceException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PersistenceException actualPersistenceException = new PersistenceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualPersistenceException.getMessage());
    assertEquals(0, actualPersistenceException.getSuppressed().length);
    assertSame(cause, actualPersistenceException.getCause());
  }
}
