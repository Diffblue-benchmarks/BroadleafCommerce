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
package org.broadleafcommerce.common.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class FileServiceExceptionDiffblueTest {
  /**
   * Method under test: {@link FileServiceException#FileServiceException()}
   */
  @Test
  public void testNewFileServiceException() {
    // Arrange and Act
    FileServiceException actualFileServiceException = new FileServiceException();

    // Assert
    assertNull(actualFileServiceException.getMessage());
    assertNull(actualFileServiceException.getCause());
    assertEquals(0, actualFileServiceException.getSuppressed().length);
  }

  /**
   * Method under test: {@link FileServiceException#FileServiceException(String)}
   */
  @Test
  public void testNewFileServiceException2() {
    // Arrange and Act
    FileServiceException actualFileServiceException = new FileServiceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualFileServiceException.getMessage());
    assertNull(actualFileServiceException.getCause());
    assertEquals(0, actualFileServiceException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link FileServiceException#FileServiceException(String, Throwable)}
   */
  @Test
  public void testNewFileServiceException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FileServiceException actualFileServiceException = new FileServiceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualFileServiceException.getMessage());
    assertEquals(0, actualFileServiceException.getSuppressed().length);
    assertSame(cause, actualFileServiceException.getCause());
  }

  /**
   * Method under test:
   * {@link FileServiceException#FileServiceException(Throwable)}
   */
  @Test
  public void testNewFileServiceException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FileServiceException actualFileServiceException = new FileServiceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualFileServiceException.getMessage());
    assertEquals(0, actualFileServiceException.getSuppressed().length);
    assertSame(cause, actualFileServiceException.getCause());
  }
}
