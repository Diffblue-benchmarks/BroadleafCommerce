package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HibernateUtilsDiffblueTest {
  /**
   * Test {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)} with {@code
   * operation}, {@code em}.
   *
   * <ul>
   *   <li>Given {@link Exception#Exception()}.
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithCache(GenericOperation, EntityManager)"})
  public void testExecuteWithCacheWithOperationEm_givenException_thenThrowException()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception());

    // Act and Assert
    assertThrows(
        Exception.class, () -> HibernateUtils.executeWithCache(operation, (EntityManager) null));
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)} with {@code
   * operation}, {@code em}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithCache(GenericOperation, EntityManager)"})
  public void testExecuteWithCacheWithOperationEm_givenNull_field() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HibernateUtils.executeWithCache(operation, (EntityManager) null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithCache(GenericOperation)} with {@code operation}.
   *
   * <ul>
   *   <li>Given {@link Exception#Exception()}.
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithCache(GenericOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithCache(GenericOperation)"})
  public void testExecuteWithCacheWithOperation_givenException_thenThrowException()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception());

    // Act and Assert
    assertThrows(Exception.class, () -> HibernateUtils.executeWithCache(operation));
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithCache(GenericOperation)} with {@code operation}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithCache(GenericOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithCache(GenericOperation)"})
  public void testExecuteWithCacheWithOperation_givenNull_field() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HibernateUtils.executeWithCache(operation);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithoutCache(GenericOperation, EntityManager)} with {@code
   * operation}, {@code em}.
   *
   * <ul>
   *   <li>Given {@link Exception#Exception()}.
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithoutCache(GenericOperation,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithoutCache(GenericOperation, EntityManager)"})
  public void testExecuteWithoutCacheWithOperationEm_givenException_thenThrowException()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception());

    // Act and Assert
    assertThrows(
        Exception.class, () -> HibernateUtils.executeWithoutCache(operation, (EntityManager) null));
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithoutCache(GenericOperation, EntityManager)} with {@code
   * operation}, {@code em}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithoutCache(GenericOperation,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithoutCache(GenericOperation, EntityManager)"})
  public void testExecuteWithoutCacheWithOperationEm_givenNull_field() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HibernateUtils.executeWithoutCache(operation, (EntityManager) null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithoutCache(GenericOperation)} with {@code operation}.
   *
   * <ul>
   *   <li>Given {@link Exception#Exception()}.
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithoutCache(GenericOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithoutCache(GenericOperation)"})
  public void testExecuteWithoutCacheWithOperation_givenException_thenThrowException()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception());

    // Act and Assert
    assertThrows(Exception.class, () -> HibernateUtils.executeWithoutCache(operation));
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithoutCache(GenericOperation)} with {@code operation}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithoutCache(GenericOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithoutCache(GenericOperation)"})
  public void testExecuteWithoutCacheWithOperation_givenNull_field() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HibernateUtils.executeWithoutCache(operation);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#getCurrentDefaultEntityManager()}.
   *
   * <p>Method under test: {@link HibernateUtils#getCurrentDefaultEntityManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager HibernateUtils.getCurrentDefaultEntityManager()"})
  public void testGetCurrentDefaultEntityManager() {
    // Arrange, Act and Assert
    assertNull(HibernateUtils.getCurrentDefaultEntityManager());
  }
}
