package org.broadleafcommerce.common.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionStatus;

public class TransactionUtilsDiffblueTest {
  /**
   * Test {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager,
   * boolean)} with {@code status}, {@code transactionManager}, {@code isError}.
   *
   * <p>Method under test: {@link TransactionUtils#finalizeTransaction(TransactionStatus,
   * PlatformTransactionManager, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransactionUtils.finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)"
  })
  public void testFinalizeTransactionWithStatusTransactionManagerIsError() {
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
   * Test {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager,
   * boolean)} with {@code status}, {@code transactionManager}, {@code isError}.
   *
   * <p>Method under test: {@link TransactionUtils#finalizeTransaction(TransactionStatus,
   * PlatformTransactionManager, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransactionUtils.finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)"
  })
  public void testFinalizeTransactionWithStatusTransactionManagerIsError2() {
    // Arrange
    DefaultTransactionStatus status = mock(DefaultTransactionStatus.class);
    when(status.isCompleted()).thenThrow(new RuntimeException());
    when(status.isRollbackOnly()).thenThrow(new RuntimeException());

    // Act
    TransactionUtils.finalizeTransaction(status, new LifecycleAwareJpaTransactionManager(), false);

    // Assert
    verify(status).isCompleted();
    verify(status).isRollbackOnly();
  }

  /**
   * Test {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager,
   * boolean)} with {@code status}, {@code transactionManager}, {@code isError}.
   *
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtils#finalizeTransaction(TransactionStatus,
   * PlatformTransactionManager, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransactionUtils.finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)"
  })
  public void testFinalizeTransactionWithStatusTransactionManagerIsError_thenCallsCommit()
      throws TransactionException {
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
   * Test {@link TransactionUtils#finalizeTransaction(TransactionStatus, PlatformTransactionManager,
   * boolean)} with {@code status}, {@code transactionManager}, {@code isError}.
   *
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#rollback(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtils#finalizeTransaction(TransactionStatus,
   * PlatformTransactionManager, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransactionUtils.finalizeTransaction(TransactionStatus, PlatformTransactionManager, boolean)"
  })
  public void testFinalizeTransactionWithStatusTransactionManagerIsError_thenCallsRollback()
      throws TransactionException {
    // Arrange
    DefaultTransactionStatus status = mock(DefaultTransactionStatus.class);
    when(status.isRollbackOnly()).thenThrow(new RuntimeException());

    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act
    TransactionUtils.finalizeTransaction(status, transactionManager, true);

    // Assert
    verify(transactionManager).rollback(isA(TransactionStatus.class));
    verify(status).isRollbackOnly();
  }
}
