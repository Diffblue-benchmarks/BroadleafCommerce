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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager;
import org.hibernate.exception.LockAcquisitionException;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

public class StreamingTransactionCapableUtilDiffblueTest {
  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)}
   * with {@code operation}, {@code exceptionType}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class)}
   */
  @Test
  public void testRunTransactionalOperationWithOperationExceptionType() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure())
        .thenThrow(new LockAcquisitionException("Could not start transaction", new SQLException()));
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code transactionBehavior},
   * {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, int, int)}
   */
  @Test
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionBehaviorIsolationLevel()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure())
        .thenThrow(new LockAcquisitionException("Could not start transaction", new SQLException()));
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, 1, 1));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)}
   * with {@code operation}, {@code exceptionType}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)}
   */
  @Test
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionManager() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    doNothing().when(operation).execute();
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType,
        new DataSourceTransactionManager(dataSource));

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)}
   * with {@code operation}, {@code exceptionType}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)}
   */
  @Test
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionManager2() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    doNothing().when(operation).execute();
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(3);
    Class<Throwable> exceptionType = Throwable.class;
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType,
        new DataSourceTransactionManager(dataSource));

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)}
   * with {@code operation}, {@code exceptionType}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)}
   */
  @Test
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionManager3() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    doNothing().when(operation).execute();
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, transactionManager);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(transactionManager).rollback(isNull());
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)}
   * with {@code operation}, {@code exceptionType}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation, Class, PlatformTransactionManager)}
   */
  @Test
  public void testRunTransactionalOperationWithOperationExceptionTypeTransactionManager4() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    doNothing().when(operation).execute();
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act
    streamingTransactionCapableUtil.runTransactionalOperation(operation, exceptionType, transactionManager);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(transactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure())
        .thenThrow(new LockAcquisitionException("Could not start transaction", new SQLException()));
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction2() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false);

    // Assert that nothing has changed
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction3() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(3);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false);

    // Assert that nothing has changed
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction4() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(-1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false);

    // Assert that nothing has changed
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction5() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction6() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    doNothing().when(transactionManager).commit(Mockito.<TransactionStatus>any());
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setTransactionManager(transactionManager);
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(transactionManager).commit(isA(TransactionStatus.class));
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction7() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction8() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());

    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setTransactionManager(transactionManager);
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(transactionManager).rollback(isNull());
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransaction9() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());

    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setTransactionManager(transactionManager);
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(transactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure())
        .thenThrow(new LockAcquisitionException("Could not start transaction", new SQLException()));
    Class<Throwable> exceptionType = Throwable.class;

    // Act and Assert
    assertThrows(LockAcquisitionException.class,
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel2()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false, 1, 1);

    // Assert that nothing has changed
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel3()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(3);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false, 1, 1);

    // Assert that nothing has changed
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel4()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(-1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false, 1, 1);

    // Assert that nothing has changed
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel5()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel6()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setTransactionManager(new DataSourceTransactionManager(mock(DataSource.class)));
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel7()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        () -> streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1));
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).shouldRetryOnTransactionLockAcquisitionFailure();
    verify(operation).execute();
    verify(transactionManager).commit(isA(TransactionStatus.class));
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel8()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());

    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setTransactionManager(transactionManager);
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(transactionManager).rollback(isNull());
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevel9()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());

    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    streamingTransactionCapableUtil.setTransactionManager(transactionManager);
    streamingTransactionCapableUtil.setRetryMax(1);
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    doNothing().when(operation).execute();
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, true, 1, 1);

    // Assert
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(transactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    doNothing().when(operation).execute();
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(1);
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false, 1, 1, true,
        new LifecycleAwareJpaTransactionManager());

    // Assert that nothing has changed
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager2()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    StreamCapableTransactionalOperation operation = mock(StreamCapableTransactionalOperation.class);
    doNothing().when(operation).execute();
    when(operation.retryMaxCountOverrideForLockAcquisitionFailure()).thenReturn(3);
    Class<Throwable> exceptionType = Throwable.class;

    // Act
    streamingTransactionCapableUtil.runOptionalTransactionalOperation(operation, exceptionType, false, 1, 1, true,
        new LifecycleAwareJpaTransactionManager());

    // Assert that nothing has changed
    verify(operation).retryMaxCountOverrideForLockAcquisitionFailure();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager3()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager4()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   * with {@code operation}, {@code exceptionType}, {@code useTransaction},
   * {@code transactionBehavior}, {@code isolationLevel}, {@code readOnly},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#runOptionalTransactionalOperation(StreamCapableTransactionalOperation, Class, boolean, int, int, boolean, PlatformTransactionManager)}
   */
  @Test
  public void testRunOptionalTransactionalOperationWithOperationExceptionTypeUseTransactionTransactionBehaviorIsolationLevelReadOnlyTransactionManager5()
      throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGettersAndSetters() {
    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();

    // Act
    streamingTransactionCapableUtil.setPageSize(3);
    streamingTransactionCapableUtil.setRetryMax(1);
    int actualPageSize = streamingTransactionCapableUtil.getPageSize();
    int actualRetryMax = streamingTransactionCapableUtil.getRetryMax();
    streamingTransactionCapableUtil.getTransactionManager();

    // Assert that nothing has changed
    assertEquals(1, actualRetryMax);
    assertEquals(3, actualPageSize);
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#setTransactionManager(PlatformTransactionManager)}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#setTransactionManager(PlatformTransactionManager)}
   */
  @Test
  public void testSetTransactionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();
    LifecycleAwareJpaTransactionManager transactionManager = new LifecycleAwareJpaTransactionManager();

    // Act
    streamingTransactionCapableUtil.setTransactionManager(transactionManager);

    // Assert
    assertSame(transactionManager, streamingTransactionCapableUtil.getTransactionManager());
  }

  /**
   * Test
   * {@link StreamingTransactionCapableUtil#setTransactionManager(PlatformTransactionManager)}.
   * <p>
   * Method under test:
   * {@link StreamingTransactionCapableUtil#setTransactionManager(PlatformTransactionManager)}
   */
  @Test
  public void testSetTransactionManager2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamingTransactionCapableUtil streamingTransactionCapableUtil = new StreamingTransactionCapableUtil();

    // Act
    streamingTransactionCapableUtil.setTransactionManager(null);

    // Assert
    assertNull(streamingTransactionCapableUtil.getTransactionManager());
  }
}
