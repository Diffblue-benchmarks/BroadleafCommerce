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
package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class CacheFactoryExceptionDiffblueTest {
  /**
   * Test {@link CacheFactoryException#CacheFactoryException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CacheFactoryException#CacheFactoryException(String)}
   */
  @Test
  public void testNewCacheFactoryException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    CacheFactoryException actualCacheFactoryException = new CacheFactoryException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCacheFactoryException.getMessage());
    assertNull(actualCacheFactoryException.getCause());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
  }

  /**
   * Test {@link CacheFactoryException#CacheFactoryException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CacheFactoryException#CacheFactoryException(String, Throwable)}
   */
  @Test
  public void testNewCacheFactoryException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CacheFactoryException actualCacheFactoryException = new CacheFactoryException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualCacheFactoryException.getMessage());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
    assertSame(cause, actualCacheFactoryException.getCause());
  }

  /**
   * Test {@link CacheFactoryException#CacheFactoryException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheFactoryException#CacheFactoryException()}
   */
  @Test
  public void testNewCacheFactoryException_thenReturnMessageIsNull() {
    // Arrange and Act
    CacheFactoryException actualCacheFactoryException = new CacheFactoryException();

    // Assert
    assertNull(actualCacheFactoryException.getMessage());
    assertNull(actualCacheFactoryException.getCause());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
  }

  /**
   * Test {@link CacheFactoryException#CacheFactoryException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CacheFactoryException#CacheFactoryException(Throwable)}
   */
  @Test
  public void testNewCacheFactoryException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CacheFactoryException actualCacheFactoryException = new CacheFactoryException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualCacheFactoryException.getMessage());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
    assertSame(cause, actualCacheFactoryException.getCause());
  }
}
