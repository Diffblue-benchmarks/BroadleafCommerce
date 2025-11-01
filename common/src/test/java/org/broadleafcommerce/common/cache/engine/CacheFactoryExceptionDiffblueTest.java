/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class CacheFactoryExceptionDiffblueTest {
  /**
   * Method under test: {@link CacheFactoryException#CacheFactoryException()}
   */
  @Test
  public void testNewCacheFactoryException() {
    // Arrange and Act
    CacheFactoryException actualCacheFactoryException = new CacheFactoryException();

    // Assert
    assertNull(actualCacheFactoryException.getMessage());
    assertNull(actualCacheFactoryException.getCause());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link CacheFactoryException#CacheFactoryException(String)}
   */
  @Test
  public void testNewCacheFactoryException2() {
    // Arrange and Act
    CacheFactoryException actualCacheFactoryException = new CacheFactoryException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCacheFactoryException.getMessage());
    assertNull(actualCacheFactoryException.getCause());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link CacheFactoryException#CacheFactoryException(String, Throwable)}
   */
  @Test
  public void testNewCacheFactoryException3() {
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
   * Method under test:
   * {@link CacheFactoryException#CacheFactoryException(Throwable)}
   */
  @Test
  public void testNewCacheFactoryException4() {
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
