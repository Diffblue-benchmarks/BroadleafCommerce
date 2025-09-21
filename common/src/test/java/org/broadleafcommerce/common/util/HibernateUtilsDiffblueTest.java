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
   * Test {@link HibernateUtils#executeWithCache(GenericOperation, String)} with {@code operation},
   * {@code persistenceUnitName}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithCache(GenericOperation, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithCache(GenericOperation, String)"})
  public void testExecuteWithCacheWithOperationPersistenceUnitName_givenNull_field()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HibernateUtils.executeWithCache(operation, (String) null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithCache(GenericOperation, String)} with {@code operation},
   * {@code persistenceUnitName}.
   *
   * <ul>
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithCache(GenericOperation, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithCache(GenericOperation, String)"})
  public void testExecuteWithCacheWithOperationPersistenceUnitName_thenThrowException()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception());

    // Act and Assert
    assertThrows(Exception.class, () -> HibernateUtils.executeWithCache(operation, (String) null));
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
   * Test {@link HibernateUtils#executeWithoutCache(GenericOperation, String)} with {@code
   * operation}, {@code persistenceUnitName}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithoutCache(GenericOperation, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithoutCache(GenericOperation, String)"})
  public void testExecuteWithoutCacheWithOperationPersistenceUnitName_givenNull_field()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    HibernateUtils.executeWithoutCache(operation, (String) null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithoutCache(GenericOperation, String)} with {@code
   * operation}, {@code persistenceUnitName}.
   *
   * <ul>
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#executeWithoutCache(GenericOperation, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HibernateUtils.executeWithoutCache(GenericOperation, String)"})
  public void testExecuteWithoutCacheWithOperationPersistenceUnitName_thenThrowException()
      throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception());

    // Act and Assert
    assertThrows(
        Exception.class, () -> HibernateUtils.executeWithoutCache(operation, (String) null));
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#getCurrentEntityManager(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HibernateUtils#getCurrentEntityManager(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager HibernateUtils.getCurrentEntityManager(String)"})
  public void testGetCurrentEntityManager_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(HibernateUtils.getCurrentEntityManager(null));
  }
}
