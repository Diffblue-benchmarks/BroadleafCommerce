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
package org.broadleafcommerce.common.extensibility.context.merge.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class MergeManagerSetupExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link MergeManagerSetupException#MergeManagerSetupException()}
   */
  @Test
  public void testNewMergeManagerSetupException() {
    // Arrange and Act
    MergeManagerSetupException actualMergeManagerSetupException = new MergeManagerSetupException();

    // Assert
    assertNull(actualMergeManagerSetupException.getMessage());
    assertNull(actualMergeManagerSetupException.getCause());
    assertEquals(0, actualMergeManagerSetupException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MergeManagerSetupException#MergeManagerSetupException(String)}
   */
  @Test
  public void testNewMergeManagerSetupException2() {
    // Arrange and Act
    MergeManagerSetupException actualMergeManagerSetupException = new MergeManagerSetupException("Arg0");

    // Assert
    assertEquals("Arg0", actualMergeManagerSetupException.getMessage());
    assertNull(actualMergeManagerSetupException.getCause());
    assertEquals(0, actualMergeManagerSetupException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MergeManagerSetupException#MergeManagerSetupException(String, Throwable)}
   */
  @Test
  public void testNewMergeManagerSetupException3() {
    // Arrange
    Throwable arg1 = new Throwable();

    // Act
    MergeManagerSetupException actualMergeManagerSetupException = new MergeManagerSetupException("Arg0", arg1);

    // Assert
    assertEquals("Arg0", actualMergeManagerSetupException.getMessage());
    assertEquals(0, actualMergeManagerSetupException.getSuppressed().length);
    assertSame(arg1, actualMergeManagerSetupException.getCause());
  }

  /**
   * Method under test:
   * {@link MergeManagerSetupException#MergeManagerSetupException(Throwable)}
   */
  @Test
  public void testNewMergeManagerSetupException4() {
    // Arrange
    Throwable arg0 = new Throwable();

    // Act
    MergeManagerSetupException actualMergeManagerSetupException = new MergeManagerSetupException(arg0);

    // Assert
    assertEquals("java.lang.Throwable", actualMergeManagerSetupException.getMessage());
    assertEquals(0, actualMergeManagerSetupException.getSuppressed().length);
    assertSame(arg0, actualMergeManagerSetupException.getCause());
  }
}
