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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class FieldNotAvailableExceptionDiffblueTest {
  /**
   * Test
   * {@link FieldNotAvailableException#FieldNotAvailableException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldNotAvailableException#FieldNotAvailableException(Throwable)}
   */
  @Test
  public void testNewFieldNotAvailableException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    FieldNotAvailableException actualFieldNotAvailableException = new FieldNotAvailableException(throwable);

    // Assert
    assertEquals("java.lang.Throwable", actualFieldNotAvailableException.getMessage());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
    assertSame(throwable, actualFieldNotAvailableException.getCause());
  }

  /**
   * Test {@link FieldNotAvailableException#FieldNotAvailableException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldNotAvailableException#FieldNotAvailableException()}
   */
  @Test
  public void testNewFieldNotAvailableException_thenReturnMessageIsNull() {
    // Arrange and Act
    FieldNotAvailableException actualFieldNotAvailableException = new FieldNotAvailableException();

    // Assert
    assertNull(actualFieldNotAvailableException.getMessage());
    assertNull(actualFieldNotAvailableException.getCause());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
  }

  /**
   * Test {@link FieldNotAvailableException#FieldNotAvailableException(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return Message is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldNotAvailableException#FieldNotAvailableException(String)}
   */
  @Test
  public void testNewFieldNotAvailableException_whenFoo_thenReturnMessageIsFoo() {
    // Arrange and Act
    FieldNotAvailableException actualFieldNotAvailableException = new FieldNotAvailableException("foo");

    // Assert
    assertEquals("foo", actualFieldNotAvailableException.getMessage());
    assertNull(actualFieldNotAvailableException.getCause());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
  }

  /**
   * Test
   * {@link FieldNotAvailableException#FieldNotAvailableException(String, Throwable)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return Message is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldNotAvailableException#FieldNotAvailableException(String, Throwable)}
   */
  @Test
  public void testNewFieldNotAvailableException_whenFoo_thenReturnMessageIsFoo2() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    FieldNotAvailableException actualFieldNotAvailableException = new FieldNotAvailableException("foo", throwable);

    // Assert
    assertEquals("foo", actualFieldNotAvailableException.getMessage());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
    assertSame(throwable, actualFieldNotAvailableException.getCause());
  }
}
