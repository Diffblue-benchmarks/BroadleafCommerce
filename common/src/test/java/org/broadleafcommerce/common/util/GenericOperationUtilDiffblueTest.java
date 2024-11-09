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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;

public class GenericOperationUtilDiffblueTest {
  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   * with {@code operation}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationNoRetriesForException() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));
    Class<Exception> forNameResult = Exception.class;

    // Act and Assert
    assertThrows(Exception.class,
        () -> GenericOperationUtil.executeRetryableOperation(operation, new Class[]{forNameResult}));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   * with {@code operation}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationNoRetriesForException2() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));
    Class<InterruptedException> forNameResult = InterruptedException.class;

    // Act and Assert
    assertThrows(Exception.class,
        () -> GenericOperationUtil.executeRetryableOperation(operation, new Class[]{forNameResult}));
    verify(operation, atLeast(1)).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   * with {@code operation}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationNoRetriesForException3() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class, () -> GenericOperationUtil.executeRetryableOperation(operation, new Class[]{}));
    verify(operation, atLeast(1)).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   * with {@code operation}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationNoRetriesForException4() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new InterruptedException("foo"));
    Class<Exception> forNameResult = Exception.class;

    // Act and Assert
    assertThrows(InterruptedException.class,
        () -> GenericOperationUtil.executeRetryableOperation(operation, new Class[]{forNameResult}));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   * with {@code operation}, {@code noRetriesForException}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationNoRetriesForException_givenNull_field() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    Class<Exception> forNameResult = Exception.class;

    // Act
    GenericOperationUtil.executeRetryableOperation(operation, new Class[]{forNameResult});

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   * with {@code operation}, {@code noRetriesForException}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationNoRetriesForException_whenNull() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class, () -> GenericOperationUtil.executeRetryableOperation(operation, null));
    verify(operation, atLeast(1)).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   * with {@code operation}, {@code retries}, {@code waitTime},
   * {@code isWaitTimesAdditive}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationRetriesWaitTimeIsWaitTimesAdditiveNoRetriesForException()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    Class<Exception> forNameResult = Exception.class;

    // Act
    GenericOperationUtil.executeRetryableOperation(operation, 1, 1L, true, new Class[]{forNameResult});

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   * with {@code operation}, {@code retries}, {@code waitTime},
   * {@code isWaitTimesAdditive}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationRetriesWaitTimeIsWaitTimesAdditiveNoRetriesForException2()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));
    Class<Exception> forNameResult = Exception.class;

    // Act and Assert
    assertThrows(Exception.class,
        () -> GenericOperationUtil.executeRetryableOperation(operation, 1, 1L, true, new Class[]{forNameResult}));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   * with {@code operation}, {@code retries}, {@code waitTime},
   * {@code isWaitTimesAdditive}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationRetriesWaitTimeIsWaitTimesAdditiveNoRetriesForException3()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));
    Class<Exception> forNameResult = Exception.class;

    // Act and Assert
    assertThrows(Exception.class,
        () -> GenericOperationUtil.executeRetryableOperation(operation, 0, 1L, true, new Class[]{forNameResult}));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   * with {@code operation}, {@code retries}, {@code waitTime},
   * {@code isWaitTimesAdditive}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationRetriesWaitTimeIsWaitTimesAdditiveNoRetriesForException4()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));
    Class<InterruptedException> forNameResult = InterruptedException.class;

    // Act and Assert
    assertThrows(Exception.class,
        () -> GenericOperationUtil.executeRetryableOperation(operation, 1, 1L, true, new Class[]{forNameResult}));
    verify(operation, atLeast(1)).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   * with {@code operation}, {@code retries}, {@code waitTime},
   * {@code isWaitTimesAdditive}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationRetriesWaitTimeIsWaitTimesAdditiveNoRetriesForException5()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class, () -> GenericOperationUtil.executeRetryableOperation(operation, 1, 1L, true, null));
    verify(operation, atLeast(1)).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   * with {@code operation}, {@code retries}, {@code waitTime},
   * {@code isWaitTimesAdditive}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationRetriesWaitTimeIsWaitTimesAdditiveNoRetriesForException6()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class,
        () -> GenericOperationUtil.executeRetryableOperation(operation, 1, 1L, true, new Class[]{}));
    verify(operation, atLeast(1)).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   * with {@code operation}, {@code retries}, {@code waitTime},
   * {@code isWaitTimesAdditive}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationRetriesWaitTimeIsWaitTimesAdditiveNoRetriesForException7()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new InterruptedException("foo"));
    Class<Exception> forNameResult = Exception.class;

    // Act and Assert
    assertThrows(InterruptedException.class,
        () -> GenericOperationUtil.executeRetryableOperation(operation, 1, 1L, true, new Class[]{forNameResult}));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   * with {@code operation}, {@code retries}, {@code waitTime},
   * {@code isWaitTimesAdditive}, {@code noRetriesForException}.
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation, int, long, boolean, Class[])}
   */
  @Test
  public void testExecuteRetryableOperationWithOperationRetriesWaitTimeIsWaitTimesAdditiveNoRetriesForException8()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class, () -> GenericOperationUtil.executeRetryableOperation(operation, 1, 1L, false, null));
    verify(operation, atLeast(1)).execute();
  }

  /**
   * Test {@link GenericOperationUtil#executeRetryableOperation(GenericOperation)}
   * with {@code operation}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation)}
   */
  @Test
  public void testExecuteRetryableOperationWithOperation_givenNull_field() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    GenericOperationUtil.executeRetryableOperation(operation);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link GenericOperationUtil#executeRetryableOperation(GenericOperation)}
   * with {@code operation}.
   * <ul>
   *   <li>Then throw {@link Exception}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation)}
   */
  @Test
  public void testExecuteRetryableOperationWithOperation_thenThrowException() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class, () -> GenericOperationUtil.executeRetryableOperation(operation));
    verify(operation, atLeast(1)).execute();
  }

  /**
   * Test {@link GenericOperationUtil#executeRetryableOperation(GenericOperation)}
   * with {@code operation}.
   * <ul>
   *   <li>Then throw {@link InterruptedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GenericOperationUtil#executeRetryableOperation(GenericOperation)}
   */
  @Test
  public void testExecuteRetryableOperationWithOperation_thenThrowInterruptedException() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new InterruptedException("foo"));

    // Act and Assert
    assertThrows(InterruptedException.class, () -> GenericOperationUtil.executeRetryableOperation(operation));
    verify(operation).execute();
  }
}
