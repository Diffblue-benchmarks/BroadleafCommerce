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
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ServiceExceptionDiffblueTest {
  /**
   * Test {@link ServiceException#ServiceException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceException#ServiceException()}
   */
  @Test
  public void testNewServiceException_thenReturnMessageIsNull() {
    // Arrange and Act
    ServiceException actualServiceException = new ServiceException();

    // Assert
    assertNull(actualServiceException.getMessage());
    assertNull(actualServiceException.getCause());
    assertEquals(0, actualServiceException.getSuppressed().length);
  }

  /**
   * Test {@link ServiceException#ServiceException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceException#ServiceException(String)}
   */
  @Test
  public void testNewServiceException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ServiceException actualServiceException = new ServiceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualServiceException.getMessage());
    assertNull(actualServiceException.getCause());
    assertEquals(0, actualServiceException.getSuppressed().length);
  }

  /**
   * Test {@link ServiceException#ServiceException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceException#ServiceException(String, Throwable)}
   */
  @Test
  public void testNewServiceException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServiceException actualServiceException = new ServiceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualServiceException.getMessage());
    assertEquals(0, actualServiceException.getSuppressed().length);
    assertSame(cause, actualServiceException.getCause());
  }

  /**
   * Test {@link ServiceException#ServiceException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceException#ServiceException(Throwable)}
   */
  @Test
  public void testNewServiceException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServiceException actualServiceException = new ServiceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualServiceException.getMessage());
    assertEquals(0, actualServiceException.getSuppressed().length);
    assertSame(cause, actualServiceException.getCause());
  }

  /**
   * Test {@link ServiceException#containsCause(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Throwable}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceException#containsCause(Class)}
   */
  @Test
  public void testContainsCause_whenJavaLangThrowable_thenReturnTrue() {
    // Arrange
    ServiceException serviceException = new ServiceException("An error occurred");
    Class<Throwable> clazz = Throwable.class;

    // Act and Assert
    assertTrue(serviceException.containsCause(clazz));
  }
}
