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

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.persistence.EntityManager;
import org.junit.Ignore;
import org.junit.Test;

public class HibernateUtilsDiffblueTest {
  /**
   * Test {@link HibernateUtils#deproxy(Object)}.
   * <p>
   * Method under test: {@link HibernateUtils#deproxy(Object)}
   */
  @Test
  public void testDeproxy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    HibernateUtils.deproxy(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link HibernateUtils#executeWithCache(GenericOperation)} with
   * {@code operation}.
   * <p>
   * Method under test: {@link HibernateUtils#executeWithCache(GenericOperation)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteWithCacheWithOperation() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@6a77dc94 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentEntityManager(HibernateUtils.java:166)
    //       at org.broadleafcommerce.common.util.HibernateUtils.executeWithCache(HibernateUtils.java:93)
    //       at org.broadleafcommerce.common.util.HibernateUtils.executeWithCache(HibernateUtils.java:105)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    HibernateUtils.<Object>executeWithCache(mock(GenericOperation.class));
  }

  /**
   * Test {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)}
   * with {@code operation}, {@code em}.
   * <ul>
   *   <li>Given {@link Exception#Exception(String)} with {@code foo}.</li>
   *   <li>Then throw {@link Exception}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)}
   */
  @Test
  public void testExecuteWithCacheWithOperationEm_givenExceptionWithFoo_thenThrowException() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class, () -> HibernateUtils.executeWithCache(operation, (EntityManager) null));
    verify(operation).execute();
  }

  /**
   * Test {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)}
   * with {@code operation}, {@code em}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HibernateUtils#executeWithCache(GenericOperation, EntityManager)}
   */
  @Test
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
   * Test {@link HibernateUtils#executeWithCache(GenericOperation, String)} with
   * {@code operation}, {@code persistenceUnitName}.
   * <p>
   * Method under test:
   * {@link HibernateUtils#executeWithCache(GenericOperation, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteWithCacheWithOperationPersistenceUnitName() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@6a77dc94 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentEntityManager(HibernateUtils.java:166)
    //       at org.broadleafcommerce.common.util.HibernateUtils.executeWithCache(HibernateUtils.java:93)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    HibernateUtils.<Object>executeWithCache(mock(GenericOperation.class), "Persistence Unit Name");
  }

  /**
   * Test {@link HibernateUtils#executeWithoutCache(GenericOperation)} with
   * {@code operation}.
   * <p>
   * Method under test:
   * {@link HibernateUtils#executeWithoutCache(GenericOperation)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteWithoutCacheWithOperation() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@6a77dc94 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentEntityManager(HibernateUtils.java:166)
    //       at org.broadleafcommerce.common.util.HibernateUtils.executeWithoutCache(HibernateUtils.java:142)
    //       at org.broadleafcommerce.common.util.HibernateUtils.executeWithoutCache(HibernateUtils.java:154)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    HibernateUtils.<Object>executeWithoutCache(mock(GenericOperation.class));
  }

  /**
   * Test
   * {@link HibernateUtils#executeWithoutCache(GenericOperation, EntityManager)}
   * with {@code operation}, {@code em}.
   * <ul>
   *   <li>Given {@link Exception#Exception(String)} with {@code foo}.</li>
   *   <li>Then throw {@link Exception}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HibernateUtils#executeWithoutCache(GenericOperation, EntityManager)}
   */
  @Test
  public void testExecuteWithoutCacheWithOperationEm_givenExceptionWithFoo_thenThrowException() throws Exception {
    // Arrange
    GenericOperation<Object> operation = mock(GenericOperation.class);
    when(operation.execute()).thenThrow(new Exception("foo"));

    // Act and Assert
    assertThrows(Exception.class, () -> HibernateUtils.executeWithoutCache(operation, (EntityManager) null));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link HibernateUtils#executeWithoutCache(GenericOperation, EntityManager)}
   * with {@code operation}, {@code em}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HibernateUtils#executeWithoutCache(GenericOperation, EntityManager)}
   */
  @Test
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
   * Test {@link HibernateUtils#executeWithoutCache(GenericOperation, String)}
   * with {@code operation}, {@code persistenceUnitName}.
   * <p>
   * Method under test:
   * {@link HibernateUtils#executeWithoutCache(GenericOperation, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteWithoutCacheWithOperationPersistenceUnitName() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@6a77dc94 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentEntityManager(HibernateUtils.java:166)
    //       at org.broadleafcommerce.common.util.HibernateUtils.executeWithoutCache(HibernateUtils.java:142)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    HibernateUtils.<Object>executeWithoutCache(mock(GenericOperation.class), "Persistence Unit Name");
  }

  /**
   * Test {@link HibernateUtils#getCurrentEntityManager(String)}.
   * <p>
   * Method under test: {@link HibernateUtils#getCurrentEntityManager(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrentEntityManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@6a77dc94 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentEntityManager(HibernateUtils.java:166)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    HibernateUtils.getCurrentEntityManager("Persistence Unit Name");
  }

  /**
   * Test {@link HibernateUtils#getCurrentDefaultEntityManager()}.
   * <p>
   * Method under test: {@link HibernateUtils#getCurrentDefaultEntityManager()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrentDefaultEntityManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@6a77dc94 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentEntityManager(HibernateUtils.java:166)
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentDefaultEntityManager(HibernateUtils.java:181)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    HibernateUtils.getCurrentDefaultEntityManager();
  }

  /**
   * Test {@link HibernateUtils#clearDefaultEntityManager()}.
   * <p>
   * Method under test: {@link HibernateUtils#clearDefaultEntityManager()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearDefaultEntityManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@6a77dc94 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentEntityManager(HibernateUtils.java:166)
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentDefaultEntityManager(HibernateUtils.java:181)
    //       at org.broadleafcommerce.common.util.HibernateUtils.clearDefaultEntityManager(HibernateUtils.java:189)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    HibernateUtils.clearDefaultEntityManager();
  }

  /**
   * Test {@link HibernateUtils#clearEntityManager(String)}.
   * <p>
   * Method under test: {@link HibernateUtils#clearEntityManager(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearEntityManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@6a77dc94 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.HibernateUtils.getCurrentEntityManager(HibernateUtils.java:166)
    //       at org.broadleafcommerce.common.util.HibernateUtils.clearEntityManager(HibernateUtils.java:201)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    HibernateUtils.clearEntityManager("Persistence Unit Name");
  }
}
