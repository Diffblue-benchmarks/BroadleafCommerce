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

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.exception.OptimisticLockInvalidStateException;
import org.broadleafcommerce.common.exception.OptimisticLockMaxRetryException;
import org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionExecution;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

public class OptimisticLockUtilsDiffblueTest {
  /**
   * Test
   * {@link OptimisticLockUtils#performOptimisticLockUpdate(String, UpdateOperation, Class, Object, int, PlatformTransactionManager, EntityManager)}.
   * <ul>
   *   <li>Then throw {@link OptimisticLockMaxRetryException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OptimisticLockUtils#performOptimisticLockUpdate(String, OptimisticLockUtils.UpdateOperation, Class, Object, int, PlatformTransactionManager, EntityManager)}
   */
  @Test
  public void testPerformOptimisticLockUpdate_thenThrowOptimisticLockMaxRetryException()
      throws OptimisticLockInvalidStateException, OptimisticLockMaxRetryException {
    // Arrange
    OptimisticLockUtils.UpdateOperation<Object> operation = mock(OptimisticLockUtils.UpdateOperation.class);
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(OptimisticLockMaxRetryException.class, () -> OptimisticLockUtils.performOptimisticLockUpdate("Name",
        operation, entityClass, BLCFieldUtils.NULL_FIELD, -1, new LifecycleAwareJpaTransactionManager(), null));
  }

  /**
   * Test
   * {@link OptimisticLockUtils#doTransactionalOptimisticUpdate(String, UpdateOperation, Class, Object, PlatformTransactionManager, EntityManager)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls
   * {@link PlatformTransactionManager#rollback(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OptimisticLockUtils#doTransactionalOptimisticUpdate(String, OptimisticLockUtils.UpdateOperation, Class, Object, PlatformTransactionManager, EntityManager)}
   */
  @Test
  public void testDoTransactionalOptimisticUpdate_givenNull_thenCallsRollback() throws TransactionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OptimisticLockUtils.UpdateOperation<Object> operation = mock(OptimisticLockUtils.UpdateOperation.class);
    doNothing().when(operation).update(Mockito.<Object>any());
    Class<Object> entityClass = Object.class;
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    when(entityManager.find(Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    doNothing().when(entityManager).flush();

    // Act
    OptimisticLockUtils.doTransactionalOptimisticUpdate("Name", operation, entityClass, BLCFieldUtils.NULL_FIELD,
        transactionManager, entityManager);

    // Assert
    verify(operation).update(isA(Object.class));
    verify(entityManager).find(isA(Class.class), isA(Object.class));
    verify(entityManager).flush();
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(transactionManager).rollback(isNull());
  }

  /**
   * Test
   * {@link OptimisticLockUtils#doTransactionalOptimisticUpdate(String, UpdateOperation, Class, Object, PlatformTransactionManager, EntityManager)}.
   * <ul>
   *   <li>Then calls
   * {@link PlatformTransactionManager#commit(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OptimisticLockUtils#doTransactionalOptimisticUpdate(String, OptimisticLockUtils.UpdateOperation, Class, Object, PlatformTransactionManager, EntityManager)}
   */
  @Test
  public void testDoTransactionalOptimisticUpdate_thenCallsCommit() throws TransactionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OptimisticLockUtils.UpdateOperation<Object> operation = mock(OptimisticLockUtils.UpdateOperation.class);
    doNothing().when(operation).update(Mockito.<Object>any());
    Class<Object> entityClass = Object.class;
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    doNothing().when(transactionManager).commit(Mockito.<TransactionStatus>any());
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    when(entityManager.find(Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    doNothing().when(entityManager).flush();

    // Act
    OptimisticLockUtils.doTransactionalOptimisticUpdate("Name", operation, entityClass, BLCFieldUtils.NULL_FIELD,
        transactionManager, entityManager);

    // Assert
    verify(operation).update(isA(Object.class));
    verify(entityManager).find(isA(Class.class), isA(Object.class));
    verify(entityManager).flush();
    verify(transactionManager).commit(isA(TransactionStatus.class));
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test
   * {@link OptimisticLockUtils#doTransactionalOptimisticUpdate(String, UpdateOperation, Class, Object, PlatformTransactionManager, EntityManager)}.
   * <ul>
   *   <li>Then calls {@link TransactionExecution#isRollbackOnly()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OptimisticLockUtils#doTransactionalOptimisticUpdate(String, OptimisticLockUtils.UpdateOperation, Class, Object, PlatformTransactionManager, EntityManager)}
   */
  @Test
  public void testDoTransactionalOptimisticUpdate_thenCallsIsRollbackOnly() throws TransactionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OptimisticLockUtils.UpdateOperation<Object> operation = mock(OptimisticLockUtils.UpdateOperation.class);
    doNothing().when(operation).update(Mockito.<Object>any());
    Class<Object> entityClass = Object.class;
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    PlatformTransactionManager transactionManager = mock(PlatformTransactionManager.class);
    when(transactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(transactionManager).rollback(Mockito.<TransactionStatus>any());
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    when(entityManager.find(Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    doNothing().when(entityManager).flush();

    // Act
    OptimisticLockUtils.doTransactionalOptimisticUpdate("Name", operation, entityClass, BLCFieldUtils.NULL_FIELD,
        transactionManager, entityManager);

    // Assert
    verify(operation).update(isA(Object.class));
    verify(entityManager).find(isA(Class.class), isA(Object.class));
    verify(entityManager).flush();
    verify(transactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(transactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }
}
