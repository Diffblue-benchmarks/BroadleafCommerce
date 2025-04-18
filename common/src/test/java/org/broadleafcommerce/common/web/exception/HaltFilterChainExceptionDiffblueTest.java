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
package org.broadleafcommerce.common.web.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HaltFilterChainExceptionDiffblueTest {
  /**
   * Test {@link HaltFilterChainException#HaltFilterChainException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HaltFilterChainException#HaltFilterChainException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HaltFilterChainException.<init>()", "void HaltFilterChainException.<init>(String)",
      "void HaltFilterChainException.<init>(String, Throwable)", "void HaltFilterChainException.<init>(Throwable)"})
  public void testNewHaltFilterChainException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualHaltFilterChainException.getMessage());
    assertNull(actualHaltFilterChainException.getCause());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
  }

  /**
   * Test {@link HaltFilterChainException#HaltFilterChainException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HaltFilterChainException#HaltFilterChainException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HaltFilterChainException.<init>()", "void HaltFilterChainException.<init>(String)",
      "void HaltFilterChainException.<init>(String, Throwable)", "void HaltFilterChainException.<init>(Throwable)"})
  public void testNewHaltFilterChainException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualHaltFilterChainException.getMessage());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
    assertSame(cause, actualHaltFilterChainException.getCause());
  }

  /**
   * Test {@link HaltFilterChainException#HaltFilterChainException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HaltFilterChainException#HaltFilterChainException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HaltFilterChainException.<init>()", "void HaltFilterChainException.<init>(String)",
      "void HaltFilterChainException.<init>(String, Throwable)", "void HaltFilterChainException.<init>(Throwable)"})
  public void testNewHaltFilterChainException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualHaltFilterChainException.getMessage());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
    assertSame(cause, actualHaltFilterChainException.getCause());
  }

  /**
   * Test {@link HaltFilterChainException#HaltFilterChainException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HaltFilterChainException#HaltFilterChainException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HaltFilterChainException.<init>()", "void HaltFilterChainException.<init>(String)",
      "void HaltFilterChainException.<init>(String, Throwable)", "void HaltFilterChainException.<init>(Throwable)"})
  public void testNewHaltFilterChainException_thenReturnMessageIsNull() {
    // Arrange and Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException();

    // Assert
    assertNull(actualHaltFilterChainException.getMessage());
    assertNull(actualHaltFilterChainException.getCause());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
  }
}
