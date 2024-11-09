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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class UnknownUnwrapTypeExceptionDiffblueTest {
  /**
   * Test {@link UnknownUnwrapTypeException#UnknownUnwrapTypeException(Class)}.
   * <p>
   * Method under test:
   * {@link UnknownUnwrapTypeException#UnknownUnwrapTypeException(Class)}
   */
  @Test
  public void testNewUnknownUnwrapTypeException() {
    // Arrange
    Class<Object> unwrapType = Object.class;

    // Act
    UnknownUnwrapTypeException actualUnknownUnwrapTypeException = new UnknownUnwrapTypeException(unwrapType);

    // Assert
    assertEquals("Cannot unwrap to requested type [java.lang.Object]",
        actualUnknownUnwrapTypeException.getLocalizedMessage());
    assertEquals("Cannot unwrap to requested type [java.lang.Object]", actualUnknownUnwrapTypeException.getMessage());
    assertNull(actualUnknownUnwrapTypeException.getCause());
    assertEquals(0, actualUnknownUnwrapTypeException.getSuppressed().length);
  }

  /**
   * Test
   * {@link UnknownUnwrapTypeException#UnknownUnwrapTypeException(Class, Throwable)}.
   * <p>
   * Method under test:
   * {@link UnknownUnwrapTypeException#UnknownUnwrapTypeException(Class, Throwable)}
   */
  @Test
  public void testNewUnknownUnwrapTypeException2() {
    // Arrange
    Class<Object> unwrapType = Object.class;
    Throwable root = new Throwable();

    // Act
    UnknownUnwrapTypeException actualUnknownUnwrapTypeException = new UnknownUnwrapTypeException(unwrapType, root);

    // Assert
    assertEquals("Cannot unwrap to requested type [java.lang.Object]",
        actualUnknownUnwrapTypeException.getLocalizedMessage());
    assertEquals("Cannot unwrap to requested type [java.lang.Object]", actualUnknownUnwrapTypeException.getMessage());
    assertEquals(0, actualUnknownUnwrapTypeException.getSuppressed().length);
    assertSame(root, actualUnknownUnwrapTypeException.getCause());
  }
}
