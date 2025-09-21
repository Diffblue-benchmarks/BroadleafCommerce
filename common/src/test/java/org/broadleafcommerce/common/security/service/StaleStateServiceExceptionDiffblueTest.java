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
package org.broadleafcommerce.common.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StaleStateServiceExceptionDiffblueTest {
  /**
   * Test {@link StaleStateServiceException#StaleStateServiceException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link StaleStateServiceException#StaleStateServiceException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaleStateServiceException.<init>()",
    "void StaleStateServiceException.<init>(String)",
    "void StaleStateServiceException.<init>(String, Throwable)",
    "void StaleStateServiceException.<init>(Throwable)"
  })
  public void testNewStaleStateServiceException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    StaleStateServiceException actualStaleStateServiceException =
        new StaleStateServiceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualStaleStateServiceException.getMessage());
    assertNull(actualStaleStateServiceException.getCause());
    assertEquals(0, actualStaleStateServiceException.getSuppressed().length);
  }

  /**
   * Test {@link StaleStateServiceException#StaleStateServiceException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link StaleStateServiceException#StaleStateServiceException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaleStateServiceException.<init>()",
    "void StaleStateServiceException.<init>(String)",
    "void StaleStateServiceException.<init>(String, Throwable)",
    "void StaleStateServiceException.<init>(Throwable)"
  })
  public void testNewStaleStateServiceException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    StaleStateServiceException actualStaleStateServiceException =
        new StaleStateServiceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualStaleStateServiceException.getMessage());
    assertEquals(0, actualStaleStateServiceException.getSuppressed().length);
    assertSame(cause, actualStaleStateServiceException.getCause());
  }

  /**
   * Test {@link StaleStateServiceException#StaleStateServiceException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link StaleStateServiceException#StaleStateServiceException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaleStateServiceException.<init>()",
    "void StaleStateServiceException.<init>(String)",
    "void StaleStateServiceException.<init>(String, Throwable)",
    "void StaleStateServiceException.<init>(Throwable)"
  })
  public void testNewStaleStateServiceException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    StaleStateServiceException actualStaleStateServiceException =
        new StaleStateServiceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualStaleStateServiceException.getMessage());
    assertEquals(0, actualStaleStateServiceException.getSuppressed().length);
    assertSame(cause, actualStaleStateServiceException.getCause());
  }

  /**
   * Test {@link StaleStateServiceException#StaleStateServiceException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StaleStateServiceException#StaleStateServiceException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaleStateServiceException.<init>()",
    "void StaleStateServiceException.<init>(String)",
    "void StaleStateServiceException.<init>(String, Throwable)",
    "void StaleStateServiceException.<init>(Throwable)"
  })
  public void testNewStaleStateServiceException_thenReturnMessageIsNull() {
    // Arrange and Act
    StaleStateServiceException actualStaleStateServiceException = new StaleStateServiceException();

    // Assert
    assertNull(actualStaleStateServiceException.getMessage());
    assertNull(actualStaleStateServiceException.getCause());
    assertEquals(0, actualStaleStateServiceException.getSuppressed().length);
  }
}
