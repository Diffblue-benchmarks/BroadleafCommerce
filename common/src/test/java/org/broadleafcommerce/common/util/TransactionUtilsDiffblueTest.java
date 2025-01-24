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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServices;
import org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.boot.spi.BootstrapContext;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.jdbc.internal.JdbcCoordinatorImpl;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.hibernate.engine.transaction.jta.platform.internal.AtomikosJtaPlatform;
import org.hibernate.engine.transaction.spi.TransactionObserver;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.internal.SessionImpl;
import org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorBuilderImpl;
import org.hibernate.resource.transaction.backend.jta.internal.JtaTransactionCoordinatorImpl;
import org.junit.Ignore;
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
   * {@link TransactionUtils#createTransaction(String, int, int, PlatformTransactionManager, boolean)}
   * with {@code name}, {@code propagationBehavior}, {@code isolationLevel},
   * {@code transactionManager}, {@code isReadOnly}.
   * <p>
   * Method under test:
   * {@link TransactionUtils#createTransaction(String, int, int, PlatformTransactionManager, boolean)}
   */
  @Test
  public void testCreateTransactionWithNamePropagationBehaviorIsolationLevelTransactionManagerIsReadOnly() {
    // Arrange and Act
    TransactionStatus actualCreateTransactionResult = TransactionUtils.createTransaction("Name", 1, 1,
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
   * {@link TransactionUtils#createTransaction(String, int, PlatformTransactionManager)}
   * with {@code name}, {@code propagationBehavior}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link TransactionUtils#createTransaction(String, int, PlatformTransactionManager)}
   */
  @Test
  public void testCreateTransactionWithNamePropagationBehaviorTransactionManager() {
    // Arrange and Act
    TransactionStatus actualCreateTransactionResult = TransactionUtils.createTransaction("Name", 1,
        new DataSourceTransactionManager(mock(DataSource.class)));

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
    assertFalse(((DefaultTransactionStatus) actualCreateTransactionResult).isReadOnly());
    assertFalse(((DefaultTransactionStatus) actualCreateTransactionResult).isTransactionSavepointManager());
    assertTrue(((DefaultTransactionStatus) actualCreateTransactionResult).isNewSynchronization());
  }

  /**
   * Test
   * {@link TransactionUtils#createTransaction(String, int, PlatformTransactionManager, boolean)}
   * with {@code name}, {@code propagationBehavior}, {@code transactionManager},
   * {@code isReadOnly}.
   * <p>
   * Method under test:
   * {@link TransactionUtils#createTransaction(String, int, PlatformTransactionManager, boolean)}
   */
  @Test
  public void testCreateTransactionWithNamePropagationBehaviorTransactionManagerIsReadOnly() {
    // Arrange and Act
    TransactionStatus actualCreateTransactionResult = TransactionUtils.createTransaction("Name", 1,
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
   * {@link TransactionUtils#createTransaction(int, PlatformTransactionManager, boolean)}
   * with {@code propagationBehavior}, {@code transactionManager},
   * {@code isReadOnly}.
   * <p>
   * Method under test:
   * {@link TransactionUtils#createTransaction(int, PlatformTransactionManager, boolean)}
   */
  @Test
  public void testCreateTransactionWithPropagationBehaviorTransactionManagerIsReadOnly() {
    // Arrange and Act
    TransactionStatus actualCreateTransactionResult = TransactionUtils.createTransaction(1,
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
   * Test {@link TransactionUtils#createTransaction(Session)} with
   * {@code session}.
   * <p>
   * Method under test: {@link TransactionUtils#createTransaction(Session)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateTransactionWithSession() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Unable to create a SessionDelegatorBaseImpl from different Session/SessionImplementor references
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:100)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(mock(SessionImplementor.class));

    // Act
    TransactionUtils.createTransaction(
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(mock(SessionImplementor.class))));
  }

  /**
   * Test {@link TransactionUtils#isTransactionalEntityManager(EntityManager)}.
   * <p>
   * Method under test:
   * {@link TransactionUtils#isTransactionalEntityManager(EntityManager)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTransactionalEntityManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Unable to create a SessionDelegatorBaseImpl from different Session/SessionImplementor references
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:100)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(mock(SessionImplementor.class));

    // Act
    TransactionUtils.isTransactionalEntityManager(
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(mock(SessionImplementor.class))));
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

  /**
   * Test {@link TransactionUtils#finalizeTransaction(Transaction, boolean)} with
   * {@code transaction}, {@code isError}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionUtils#finalizeTransaction(Transaction, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFinalizeTransactionWithTransactionIsError_whenTrue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Unable to create a SessionDelegatorBaseImpl from different Session/SessionImplementor references
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:100)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    JdbcResourceLocalTransactionCoordinatorBuilderImpl transactionCoordinatorBuilder = new JdbcResourceLocalTransactionCoordinatorBuilderImpl();
    Connection userSuppliedConnection = mock(Connection.class);
    SessionDelegatorBaseImpl owner = new SessionDelegatorBaseImpl(mock(SessionImplementor.class), mock(Session.class));

    JdbcCoordinatorImpl owner2 = new JdbcCoordinatorImpl(userSuppliedConnection, owner,
        new LifecycleAwareJDBCServices());

    JtaTransactionCoordinatorImpl transactionCoordinator = new JtaTransactionCoordinatorImpl(
        transactionCoordinatorBuilder, owner2, true, new AtomikosJtaPlatform(), true, true,
        mock(TransactionObserver.class));

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(mock(BootstrapContext.class),
        mock(MetadataBuildingOptions.class));

    SessionFactoryImpl factory = new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(mock(SessionFactoryOptions.class)),
        mock(QueryPlanCache.QueryPlanCreator.class));

    // Act
    TransactionUtils.finalizeTransaction(new TransactionImpl(transactionCoordinator,
        new SessionImpl(factory,
            new SessionFactoryImpl.SessionBuilderImpl<>(new SessionFactoryImpl(mock(MetadataImplementor.class),
                mock(SessionFactoryOptions.class), mock(QueryPlanCache.QueryPlanCreator.class))))),
        true);
  }
}
