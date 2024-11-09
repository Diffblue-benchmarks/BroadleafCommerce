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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.sql.DataSource;
import org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.AbstractTransactionStatus;
import org.springframework.transaction.support.DefaultTransactionStatus;

public class TransactionUtilsDiffblueTest {
  /**
   * Test
   * {@link TransactionUtils#createTransaction(int, int, PlatformTransactionManager, boolean)}
   * with {@code propagationBehavior}, {@code isolationLevel},
   * {@code transactionManager}, {@code isReadOnly}.
   * <p>
   * Method under test:
   * {@link TransactionUtils#createTransaction(int, int, PlatformTransactionManager, boolean)}
   */
  @Test
  public void testCreateTransactionWithPropagationBehaviorIsolationLevelTransactionManagerIsReadOnly() {
    // Arrange and Act
    TransactionStatus actualCreateTransactionResult = TransactionUtils.createTransaction(1, 1,
        new DataSourceTransactionManager(mock(DataSource.class)), true);

    // Assert
    assertTrue(actualCreateTransactionResult instanceof DefaultTransactionStatus);
    assertNull(((DefaultTransactionStatus) actualCreateTransactionResult).getSuspendedResources());
    assertFalse(actualCreateTransactionResult.isCompleted());
    assertFalse(actualCreateTransactionResult.isNewTransaction());
    assertFalse(actualCreateTransactionResult.isRollbackOnly());
    assertFalse(actualCreateTransactionResult.hasSavepoint());
    assertFalse(((DefaultTransactionStatus) actualCreateTransactionResult).isLocalRollbackOnly());
    assertFalse(((DefaultTransactionStatus) actualCreateTransactionResult).hasTransaction());
    assertFalse(((DefaultTransactionStatus) actualCreateTransactionResult).isDebug());
    assertFalse(((DefaultTransactionStatus) actualCreateTransactionResult).isGlobalRollbackOnly());
    assertFalse(((DefaultTransactionStatus) actualCreateTransactionResult).isTransactionSavepointManager());
    assertTrue(((DefaultTransactionStatus) actualCreateTransactionResult).isNewSynchronization());
    assertTrue(((DefaultTransactionStatus) actualCreateTransactionResult).isReadOnly());
  }

  /**
   * Test
   * {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)}
   * with {@code status}, {@code transactionManager}, {@code isError}.
   * <ul>
   *   <li>Then calls
   * {@link PlatformTransactionManager#commit(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)}
   */
  @Test
  public void testFinalizeTransactionWithStatusTransactionManagerIsError_thenCallsCommit() throws TransactionException {
    // Arrange
    DefaultTransactionStatus status = mock(DefaultTransactionStatus.class);
    when(status.isRollbackOnly()).thenReturn(false);
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    doNothing().when(transactionManager).commit(Mockito.<TransactionStatus>any());

    // Act
    TransactionUtils.finalizeTransaction(status, transactionManager, false);

    // Assert
    verify(transactionManager).commit(isA(TransactionStatus.class));
    verify(status).isRollbackOnly();
  }

  /**
   * Test
   * {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)}
   * with {@code status}, {@code transactionManager}, {@code isError}.
   * <ul>
   *   <li>Then calls {@link AbstractTransactionStatus#isCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)}
   */
  @Test
  public void testFinalizeTransactionWithStatusTransactionManagerIsError_thenCallsIsCompleted() {
    // Arrange
    DefaultTransactionStatus status = mock(DefaultTransactionStatus.class);
    when(status.isCompleted()).thenReturn(true);
    when(status.isRollbackOnly()).thenReturn(true);

    // Act
    TransactionUtils.finalizeTransaction(status, new LifecycleAwareJpaTransactionManager(), true);

    // Assert
    verify(status).isCompleted();
    verify(status).isRollbackOnly();
  }

  /**
   * Test
   * {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)}
   * with {@code status}, {@code transactionManager}, {@code isError}.
   * <ul>
   *   <li>Then calls
   * {@link PlatformTransactionManager#rollback(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)}
   */
  @Test
  public void testFinalizeTransactionWithStatusTransactionManagerIsError_thenCallsRollback()
      throws TransactionException {
    // Arrange
    DefaultTransactionStatus status = mock(DefaultTransactionStatus.class);
    when(status.isRollbackOnly()).thenReturn(true);
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act
    TransactionUtils.finalizeTransaction(status, transactionManager, true);

    // Assert
    verify(transactionManager).rollback(isA(TransactionStatus.class));
    verify(status).isRollbackOnly();
  }

  /**
   * Test
   * {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)}
   * with {@code status}, {@code transactionManager}, {@code isError}.
   * <ul>
   *   <li>Then calls
   * {@link PlatformTransactionManager#rollback(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)}
   */
  @Test
  public void testFinalizeTransactionWithStatusTransactionManagerIsError_thenCallsRollback2()
      throws TransactionException {
    // Arrange
    DefaultTransactionStatus status = mock(DefaultTransactionStatus.class);
    when(status.isRollbackOnly()).thenReturn(true);
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act
    TransactionUtils.finalizeTransaction(status, transactionManager, false);

    // Assert
    verify(transactionManager).rollback(isA(TransactionStatus.class));
    verify(status).isRollbackOnly();
  }
}
