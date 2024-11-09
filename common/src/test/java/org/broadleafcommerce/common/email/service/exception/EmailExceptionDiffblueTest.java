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
package org.broadleafcommerce.common.email.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class EmailExceptionDiffblueTest {
  /**
   * Test {@link EmailException#EmailException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailException#EmailException()}
   */
  @Test
  public void testNewEmailException_thenReturnMessageIsNull() {
    // Arrange and Act
    EmailException actualEmailException = new EmailException();

    // Assert
    assertNull(actualEmailException.getMessage());
    assertNull(actualEmailException.getCause());
    assertEquals(0, actualEmailException.getSuppressed().length);
  }

  /**
   * Test {@link EmailException#EmailException(String)}.
   * <ul>
   *   <li>When {@code Arg0}.</li>
   *   <li>Then return Message is {@code Arg0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailException#EmailException(String)}
   */
  @Test
  public void testNewEmailException_whenArg0_thenReturnMessageIsArg0() {
    // Arrange and Act
    EmailException actualEmailException = new EmailException("Arg0");

    // Assert
    assertEquals("Arg0", actualEmailException.getMessage());
    assertNull(actualEmailException.getCause());
    assertEquals(0, actualEmailException.getSuppressed().length);
  }

  /**
   * Test {@link EmailException#EmailException(String, Throwable)}.
   * <ul>
   *   <li>When {@code Arg0}.</li>
   *   <li>Then return Message is {@code Arg0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailException#EmailException(String, Throwable)}
   */
  @Test
  public void testNewEmailException_whenArg0_thenReturnMessageIsArg02() {
    // Arrange
    Throwable arg1 = new Throwable();

    // Act
    EmailException actualEmailException = new EmailException("Arg0", arg1);

    // Assert
    assertEquals("Arg0", actualEmailException.getMessage());
    assertEquals(0, actualEmailException.getSuppressed().length);
    assertSame(arg1, actualEmailException.getCause());
  }

  /**
   * Test {@link EmailException#EmailException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailException#EmailException(Throwable)}
   */
  @Test
  public void testNewEmailException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable arg0 = new Throwable();

    // Act
    EmailException actualEmailException = new EmailException(arg0);

    // Assert
    assertEquals("java.lang.Throwable", actualEmailException.getMessage());
    assertEquals(0, actualEmailException.getSuppressed().length);
    assertSame(arg0, actualEmailException.getCause());
  }
}
