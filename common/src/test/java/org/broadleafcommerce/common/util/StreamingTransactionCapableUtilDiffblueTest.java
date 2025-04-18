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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager;
import org.hibernate.exception.LockAcquisitionException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionExecution;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StreamingTransactionCapableUtilDiffblueTest {
  @Mock
  private PlatformTransactionManager platformTransactionManager;

  @InjectMocks
  private StreamingTransactionCapableUtil streamingTransactionCapableUtil;

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)} with {@code operation}, {@code exceptionType}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class)"})
  public void testRunTransactionalOperationWithOperationExceptionType() throws Throwable {
    // Arrange
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure())
        .thenThrow(new LockAcquisitionException("String", new SQLException()));
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)} with {@code operation}, {@code exceptionType}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class)"})
  public void testRunTransactionalOperationWithOperationExceptionType2() throws Throwable {
    // Arrange
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)} with {@code operation}, {@code exceptionType}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)"})
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionBehaviorIsolationLevel()
      throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)} with {@code operation}, {@code exceptionType}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)"})
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionBehaviorIsolationLevel2()
      throws Throwable {
    // Arrange
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure())
        .thenThrow(new LockAcquisitionException("String", new SQLException()));
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, 1, 1));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)} with {@code operation}, {@code exceptionType}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)"})
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionBehaviorIsolationLevel3()
      throws Throwable {
    // Arrange
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)} with {@code operation}, {@code exceptionType}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)"})
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionBehaviorIsolationLevel4()
      throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)} with {@code operation}, {@code exceptionType}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)"})
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionBehaviorIsolationLevel5()
      throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(3);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)} with {@code operation}, {@code exceptionType}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)"})
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionBehaviorIsolationLevel6()
      throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(-1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)} with {@code operation}, {@code exceptionType}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)"})
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionBehaviorIsolationLevel7()
      throws Throwable {
    // Arrange
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.shouldRetryOnTransactionLockAcquisitionFailure())
        .thenThrow(new RuntimeException("Could not start transaction"));
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, -1, 1));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).shouldRetryOnTransactionLockAcquisitionFailure();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)} with {@code operation}, {@code exceptionType}, {@code transactionManager}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)"})
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionManager() throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, platformTransactionManager);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)} with {@code operation}, {@code exceptionType}.
   * <ul>
   *   <li>Given minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class)"})
  public void testRunTransactionalOperationWithOperationExceptionType_givenMinusOne() throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(-1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)} with {@code operation}, {@code exceptionType}.
   * <ul>
   *   <li>Given three.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class)"})
  public void testRunTransactionalOperationWithOperationExceptionType_givenThree() throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(3);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)} with {@code operation}, {@code exceptionType}.
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class)"})
  public void testRunTransactionalOperationWithOperationExceptionType_thenCallsCommit() throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)} with {@code operation}, {@code exceptionType}.
   * <ul>
   *   <li>Then calls {@link TransactionExecution#isRollbackOnly()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runTransactionalOperation(StreamCapableTransactionalOperation, Class)"})
  public void testRunTransactionalOperationWithOperationExceptionType_thenCallsIsRollbackOnly() throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)} with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction() throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)} with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction2() throws Throwable {
    // Arrange
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure())
        .thenThrow(new LockAcquisitionException("String", new SQLException()));
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)} with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction3() throws Throwable {
    // Arrange
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)} with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction4() throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)} with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction5() throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(3);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)} with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction6() throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(-1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)} with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction7() throws Throwable {
    // Arrange
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)} with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction8() throws Throwable {
    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.shouldRetryOnTransactionLockAcquisitionFailure())
        .thenThrow(new RuntimeException("Could not start transaction"));
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).shouldRetryOnTransactionLockAcquisitionFailure();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)} with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction9() throws Throwable {
    // Arrange
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    doThrow(new RuntimeException("foo")).when(transactionManager).commit(Mockito.<TransactionStatus>any());
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setTransactionManager(transactionManager);
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.shouldRetryOnTransactionLockAcquisitionFailure())
        .thenThrow(new RuntimeException("Could not start transaction"));
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).shouldRetryOnTransactionLockAcquisitionFailure();
    verify(operation).execute();
    verify(transactionManager).commit(isA(TransactionStatus.class));
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel()
      throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel2()
      throws Throwable {
    // Arrange
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure())
        .thenThrow(new LockAcquisitionException("String", new SQLException()));
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel3()
      throws Throwable {
    // Arrange
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel4()
      throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel5()
      throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(3);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel6()
      throws Throwable {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(-1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel7()
      throws Throwable {
    // Arrange
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel8()
      throws Throwable {
    // Arrange
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.shouldRetryOnTransactionLockAcquisitionFailure())
        .thenThrow(new RuntimeException("Could not start transaction"));
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, -1, 1));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).shouldRetryOnTransactionLockAcquisitionFailure();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel9()
      throws Throwable {
    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.shouldRetryOnTransactionLockAcquisitionFailure())
        .thenThrow(new RuntimeException("Could not start transaction"));
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).shouldRetryOnTransactionLockAcquisitionFailure();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly}, {@code transactionManager}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager()
      throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1, true,
        platformTransactionManager);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly}, {@code transactionManager}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager2()
      throws Throwable {
    // Arrange
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(mock(TransactionStatus.class));
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.shouldRetryOnTransactionLockAcquisitionFailure())
        .thenThrow(new RuntimeException("Could not start transaction"));
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> streamingTransactionCapableUtil
        .runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1, true, platformTransactionManager));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).shouldRetryOnTransactionLockAcquisitionFailure();
    verify(platformTransactionManager, atLeast(1)).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly}, {@code transactionManager}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager3()
      throws Throwable {
    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    doThrow(new Throwable()).when(operation).execute();
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(Throwable.class, () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation,
        exceptionType, false, 1, 1, true, new LifecycleAwareJpaTransactionManager()));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly}, {@code transactionManager}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager4()
      throws Throwable {
    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    doThrow(new LockAcquisitionException("String", new SQLException())).when(operation).execute();
    when(operation.shouldRetryOnTransactionLockAcquisitionFailure()).thenReturn(true);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false, 1, 1,
            true, new LifecycleAwareJpaTransactionManager()));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).shouldRetryOnTransactionLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)} with {@code operation}, {@code exceptionType}, {@code useTransaction}, {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly}, {@code transactionManager}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)"})
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager5()
      throws Throwable {
    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    doThrow(new LockAcquisitionException("String", new SQLException())).when(operation).execute();
    when(operation.shouldRetryOnTransactionLockAcquisitionFailure()).thenReturn(true);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(3);
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false, 1, 1,
            true, new LifecycleAwareJpaTransactionManager()));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation, atLeast(1)).shouldRetryOnTransactionLockAcquisitionFailure();
    verify(operation, atLeast(1)).execute();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StreamingTransactionCapableUtil#setPageSize(int)}
   *   <li>{@link StreamingTransactionCapableUtil#setRetryMax(int)}
   *   <li>{@link StreamingTransactionCapableUtil#getPageSize()}
   *   <li>{@link StreamingTransactionCapableUtil#getRetryMax()}
   *   <li>{@link StreamingTransactionCapableUtil#getTransactionManager()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int StreamingTransactionCapableUtil.getPageSize()",
      "int StreamingTransactionCapableUtil.getRetryMax()",
      "PlatformTransactionManager StreamingTransactionCapableUtil.getTransactionManager()",
      "void StreamingTransactionCapableUtil.setPageSize(int)", "void StreamingTransactionCapableUtil.setRetryMax(int)"})
  public void testGettersAndSetters() {
    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();

    // Act
    streamingTransactionCapableUtil.setPageSize(3);
    streamingTransactionCapableUtil.setRetryMax(1);
    int actualPageSize = streamingTransactionCapableUtil.getPageSize();
    int actualRetryMax = streamingTransactionCapableUtil.getRetryMax();

    // Assert
    assertNull(streamingTransactionCapableUtil.getTransactionManager());
    assertEquals(1, actualRetryMax);
    assertEquals(3, actualPageSize);
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#setTransactionManager(PlatformTransactionManager)}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#setTransactionManager(PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamingTransactionCapableUtil.setTransactionManager(PlatformTransactionManager)"})
  public void testSetTransactionManager() {
    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    LifecycleAwareJpaTransactionManager transactionManager = new LifecycleAwareJpaTransactionManager();

    // Act
    streamingTransactionCapableUtil.setTransactionManager(transactionManager);

    // Assert
    assertSame(transactionManager, streamingTransactionCapableUtil.getTransactionManager());
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#setTransactionManager(PlatformTransactionManager)}.
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#setTransactionManager(PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamingTransactionCapableUtil.setTransactionManager(PlatformTransactionManager)"})
  public void testSetTransactionManager2() {
    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();

    // Act
    streamingTransactionCapableUtil.setTransactionManager(null);

    // Assert that nothing has changed
    assertNull(streamingTransactionCapableUtil.getTransactionManager());
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)"})
  public void testEndTransaction_givenTrue() throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    DefaultTransactionStatus status = mock(DefaultTransactionStatus.class);
    when(status.isRollbackOnly()).thenReturn(true);
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.endTransaction(status, true, exceptionType, platformTransactionManager);

    // Assert
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(status).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)"})
  public void testEndTransaction_givenTrue2() throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    DefaultTransactionStatus status = mock(DefaultTransactionStatus.class);
    when(status.isRollbackOnly()).thenReturn(true);
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.endTransaction(status, false, exceptionType, platformTransactionManager);

    // Assert
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(status).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}.
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)"})
  public void testEndTransaction_thenCallsCommit() throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    DefaultTransactionStatus status = mock(DefaultTransactionStatus.class);
    when(status.isRollbackOnly()).thenReturn(false);
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.endTransaction(status, false, exceptionType, platformTransactionManager);

    // Assert
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(status).isRollbackOnly();
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link PlatformTransactionManager#rollback(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)"})
  public void testEndTransaction_whenNull_thenCallsRollback() throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.endTransaction(null, true, exceptionType, platformTransactionManager);

    // Assert
    verify(platformTransactionManager).rollback(isNull());
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}.
   * <ul>
   *   <li>When {@link SimpleTransactionStatus#SimpleTransactionStatus(boolean)} with newTransaction is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StreamingTransactionCapableUtil.endTransaction(TransactionStatus, boolean, Class, PlatformTransactionManager)"})
  public void testEndTransaction_whenSimpleTransactionStatusWithNewTransactionIsTrue() throws Throwable {
    // Arrange
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    SimpleTransactionStatus status = new SimpleTransactionStatus(true);
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.endTransaction(status, true, exceptionType, platformTransactionManager);

    // Assert
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
  }

  /**
   * Test {@link StreamingTransactionCapableUtil#startTransaction(int, int, boolean, PlatformTransactionManager)}.
   * <ul>
   *   <li>Then return {@link SimpleTransactionStatus#SimpleTransactionStatus(boolean)} with newTransaction is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamingTransactionCapableUtil#startTransaction(int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransactionStatus StreamingTransactionCapableUtil.startTransaction(int, int, boolean, PlatformTransactionManager)"})
  public void testStartTransaction_thenReturnSimpleTransactionStatusWithNewTransactionIsTrue()
      throws TransactionException {
    // Arrange
    SimpleTransactionStatus simpleTransactionStatus = new SimpleTransactionStatus(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(simpleTransactionStatus);

    // Act
    TransactionStatus actualStartTransactionResult = streamingTransactionCapableUtil.startTransaction(1, 1, true,
        platformTransactionManager);

    // Assert
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    assertSame(simpleTransactionStatus, actualStartTransactionResult);
  }
}
