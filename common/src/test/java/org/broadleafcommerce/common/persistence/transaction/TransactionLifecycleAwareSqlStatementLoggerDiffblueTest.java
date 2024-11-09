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
package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.hibernate.engine.jdbc.internal.Formatter;
import org.junit.Test;
import org.mockito.Mockito;

public class TransactionLifecycleAwareSqlStatementLoggerDiffblueTest {
  /**
   * Test
   * {@link TransactionLifecycleAwareSqlStatementLogger#TransactionLifecycleAwareSqlStatementLogger()}.
   * <ul>
   *   <li>Then return not Format.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleAwareSqlStatementLogger#TransactionLifecycleAwareSqlStatementLogger()}
   */
  @Test
  public void testNewTransactionLifecycleAwareSqlStatementLogger_thenReturnNotFormat() {
    // Arrange and Act
    TransactionLifecycleAwareSqlStatementLogger actualTransactionLifecycleAwareSqlStatementLogger = new TransactionLifecycleAwareSqlStatementLogger();

    // Assert
    assertEquals(0L, actualTransactionLifecycleAwareSqlStatementLogger.getLogSlowQuery());
    assertFalse(actualTransactionLifecycleAwareSqlStatementLogger.isFormat());
    assertFalse(actualTransactionLifecycleAwareSqlStatementLogger.isLogToStdout());
  }

  /**
   * Test
   * {@link TransactionLifecycleAwareSqlStatementLogger#TransactionLifecycleAwareSqlStatementLogger(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Format.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleAwareSqlStatementLogger#TransactionLifecycleAwareSqlStatementLogger(boolean, boolean)}
   */
  @Test
  public void testNewTransactionLifecycleAwareSqlStatementLogger_whenTrue_thenReturnFormat() {
    // Arrange and Act
    TransactionLifecycleAwareSqlStatementLogger actualTransactionLifecycleAwareSqlStatementLogger = new TransactionLifecycleAwareSqlStatementLogger(
        true, true);

    // Assert
    assertEquals(0L, actualTransactionLifecycleAwareSqlStatementLogger.getLogSlowQuery());
    assertTrue(actualTransactionLifecycleAwareSqlStatementLogger.isFormat());
    assertTrue(actualTransactionLifecycleAwareSqlStatementLogger.isLogToStdout());
  }

  /**
   * Test
   * {@link TransactionLifecycleAwareSqlStatementLogger#logStatement(String, Formatter)}
   * with {@code statement}, {@code formatter}.
   * <ul>
   *   <li>Then calls {@link Formatter#format(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleAwareSqlStatementLogger#logStatement(String, Formatter)}
   */
  @Test
  public void testLogStatementWithStatementFormatter_thenCallsFormat() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleAwareSqlStatementLogger transactionLifecycleAwareSqlStatementLogger = new TransactionLifecycleAwareSqlStatementLogger(
        true, true);
    Formatter formatter = mock(Formatter.class);
    when(formatter.format(Mockito.<String>any())).thenReturn("Format");

    // Act
    transactionLifecycleAwareSqlStatementLogger.logStatement("MD", formatter);

    // Assert
    verify(formatter).format(eq("MD"));
  }
}
