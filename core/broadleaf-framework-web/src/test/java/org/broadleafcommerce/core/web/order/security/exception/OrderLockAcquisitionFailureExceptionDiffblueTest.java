/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order.security.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OrderLockAcquisitionFailureExceptionDiffblueTest {
  /**
   * Test {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String)}
   */
  @Test
  @DisplayName("Test new OrderLockAcquisitionFailureException(String); then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrderLockAcquisitionFailureException.<init>()",
      "void OrderLockAcquisitionFailureException.<init>(String)",
      "void OrderLockAcquisitionFailureException.<init>(String, Throwable)",
      "void OrderLockAcquisitionFailureException.<init>(Throwable)"})
  void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualOrderLockAcquisitionFailureException.getMessage());
    assertNull(actualOrderLockAcquisitionFailureException.getCause());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
  }

  /**
   * Test {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new OrderLockAcquisitionFailureException(String, Throwable); then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrderLockAcquisitionFailureException.<init>()",
      "void OrderLockAcquisitionFailureException.<init>(String)",
      "void OrderLockAcquisitionFailureException.<init>(String, Throwable)",
      "void OrderLockAcquisitionFailureException.<init>(Throwable)"})
  void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOrderLockAcquisitionFailureException.getMessage());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
    assertSame(cause, actualOrderLockAcquisitionFailureException.getCause());
  }

  /**
   * Test {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(Throwable)}
   */
  @Test
  @DisplayName("Test new OrderLockAcquisitionFailureException(Throwable); then return Message is 'java.lang.Throwable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrderLockAcquisitionFailureException.<init>()",
      "void OrderLockAcquisitionFailureException.<init>(String)",
      "void OrderLockAcquisitionFailureException.<init>(String, Throwable)",
      "void OrderLockAcquisitionFailureException.<init>(Throwable)"})
  void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException(
        cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOrderLockAcquisitionFailureException.getMessage());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
    assertSame(cause, actualOrderLockAcquisitionFailureException.getCause());
  }

  /**
   * Test {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException()}
   */
  @Test
  @DisplayName("Test new OrderLockAcquisitionFailureException(); then return Message is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrderLockAcquisitionFailureException.<init>()",
      "void OrderLockAcquisitionFailureException.<init>(String)",
      "void OrderLockAcquisitionFailureException.<init>(String, Throwable)",
      "void OrderLockAcquisitionFailureException.<init>(Throwable)"})
  void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsNull() {
    // Arrange and Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException();

    // Assert
    assertNull(actualOrderLockAcquisitionFailureException.getMessage());
    assertNull(actualOrderLockAcquisitionFailureException.getCause());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
  }
}
