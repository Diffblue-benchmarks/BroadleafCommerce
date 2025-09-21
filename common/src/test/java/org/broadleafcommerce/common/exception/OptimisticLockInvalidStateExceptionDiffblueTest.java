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
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OptimisticLockInvalidStateExceptionDiffblueTest {
  /**
   * Test {@link OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(String)}.
   *
   * <ul>
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockInvalidStateException.<init>()",
    "void OptimisticLockInvalidStateException.<init>(String)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockInvalidStateException.<init>(Throwable)"
  })
  public void testNewOptimisticLockInvalidStateException_thenReturnCauseIsNull() {
    // Arrange and Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException =
        new OptimisticLockInvalidStateException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOptimisticLockInvalidStateException.getMessage());
    assertNull(actualOptimisticLockInvalidStateException.getCause());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
  }

  /**
   * Test {@link OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(String,
   * Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockInvalidStateException.<init>()",
    "void OptimisticLockInvalidStateException.<init>(String)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockInvalidStateException.<init>(Throwable)"
  })
  public void testNewOptimisticLockInvalidStateException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException =
        new OptimisticLockInvalidStateException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOptimisticLockInvalidStateException.getMessage());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockInvalidStateException.getCause());
  }

  /**
   * Test {@link
   * OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockInvalidStateException.<init>()",
    "void OptimisticLockInvalidStateException.<init>(String)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockInvalidStateException.<init>(Throwable)"
  })
  public void testNewOptimisticLockInvalidStateException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException =
        new OptimisticLockInvalidStateException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOptimisticLockInvalidStateException.getMessage());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockInvalidStateException.getCause());
  }

  /**
   * Test {@link OptimisticLockInvalidStateException#OptimisticLockInvalidStateException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OptimisticLockInvalidStateException#OptimisticLockInvalidStateException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockInvalidStateException.<init>()",
    "void OptimisticLockInvalidStateException.<init>(String)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockInvalidStateException.<init>(Throwable)"
  })
  public void testNewOptimisticLockInvalidStateException_thenReturnMessageIsNull() {
    // Arrange and Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException =
        new OptimisticLockInvalidStateException();

    // Assert
    assertNull(actualOptimisticLockInvalidStateException.getMessage());
    assertNull(actualOptimisticLockInvalidStateException.getCause());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
  }

  /**
   * Test {@link OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(String,
   * Throwable, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OptimisticLockInvalidStateException#OptimisticLockInvalidStateException(String, Throwable,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockInvalidStateException.<init>()",
    "void OptimisticLockInvalidStateException.<init>(String)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable)",
    "void OptimisticLockInvalidStateException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockInvalidStateException.<init>(Throwable)"
  })
  public void testNewOptimisticLockInvalidStateException_whenTrue() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockInvalidStateException actualOptimisticLockInvalidStateException =
        new OptimisticLockInvalidStateException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualOptimisticLockInvalidStateException.getMessage());
    assertEquals(0, actualOptimisticLockInvalidStateException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockInvalidStateException.getCause());
  }
}
