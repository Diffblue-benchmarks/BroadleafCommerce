/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ConverterNotFoundExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ConverterNotFoundException#ConverterNotFoundException()}
   */
  @Test
  public void testNewConverterNotFoundException() {
    // Arrange and Act
    ConverterNotFoundException actualConverterNotFoundException = new ConverterNotFoundException();

    // Assert
    assertNull(actualConverterNotFoundException.getMessage());
    assertNull(actualConverterNotFoundException.getCause());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConverterNotFoundException#ConverterNotFoundException(String)}
   */
  @Test
  public void testNewConverterNotFoundException2() {
    // Arrange and Act
    ConverterNotFoundException actualConverterNotFoundException = new ConverterNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualConverterNotFoundException.getMessage());
    assertNull(actualConverterNotFoundException.getCause());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConverterNotFoundException#ConverterNotFoundException(String, Throwable)}
   */
  @Test
  public void testNewConverterNotFoundException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConverterNotFoundException actualConverterNotFoundException = new ConverterNotFoundException("An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualConverterNotFoundException.getMessage());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
    assertSame(cause, actualConverterNotFoundException.getCause());
  }

  /**
   * Method under test:
   * {@link ConverterNotFoundException#ConverterNotFoundException(Throwable)}
   */
  @Test
  public void testNewConverterNotFoundException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConverterNotFoundException actualConverterNotFoundException = new ConverterNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualConverterNotFoundException.getMessage());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
    assertSame(cause, actualConverterNotFoundException.getCause());
  }
}
