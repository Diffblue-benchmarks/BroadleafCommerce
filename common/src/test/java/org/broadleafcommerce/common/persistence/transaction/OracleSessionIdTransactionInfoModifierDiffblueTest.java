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
package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.jdbc.ReturningWork;
import org.junit.Test;
import org.mockito.Mockito;

public class OracleSessionIdTransactionInfoModifierDiffblueTest {
  /**
   * Test {@link OracleSessionIdTransactionInfoModifier#modify(TransactionInfo)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TransactionInfo} {@link TransactionInfo#getEntityManager()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleSessionIdTransactionInfoModifier#modify(TransactionInfo)}
   */
  @Test
  public void testModify_givenNull_whenTransactionInfoGetEntityManagerReturnNull() {
    // Arrange
    OracleSessionIdTransactionInfoModifier oracleSessionIdTransactionInfoModifier = new OracleSessionIdTransactionInfoModifier();
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getEntityManager()).thenReturn(null);

    // Act
    oracleSessionIdTransactionInfoModifier.modify(info);

    // Assert
    verify(info).getEntityManager();
  }

  /**
   * Test {@link OracleSessionIdTransactionInfoModifier#modify(TransactionInfo)}.
   * <ul>
   *   <li>Given {@link SessionDelegatorBaseImpl}
   * {@link SessionDelegatorBaseImpl#doReturningWork(ReturningWork)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleSessionIdTransactionInfoModifier#modify(TransactionInfo)}
   */
  @Test
  public void testModify_givenSessionDelegatorBaseImplDoReturningWorkReturnNull() throws HibernateException {
    // Arrange
    OracleSessionIdTransactionInfoModifier oracleSessionIdTransactionInfoModifier = new OracleSessionIdTransactionInfoModifier();
    SessionDelegatorBaseImpl sessionDelegatorBaseImpl = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl.doReturningWork(Mockito.<ReturningWork<Integer>>any())).thenReturn(null);
    SessionDelegatorBaseImpl sessionDelegatorBaseImpl2 = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl2.unwrap(Mockito.<Class<Session>>any())).thenReturn(sessionDelegatorBaseImpl);
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getAdditionalParams()).thenReturn(new HashMap<>());
    when(info.getEntityManager()).thenReturn(sessionDelegatorBaseImpl2);

    // Act
    oracleSessionIdTransactionInfoModifier.modify(info);

    // Assert
    verify(info).getAdditionalParams();
    verify(info).getEntityManager();
    verify(sessionDelegatorBaseImpl).doReturningWork(isA(ReturningWork.class));
    verify(sessionDelegatorBaseImpl2).unwrap(isA(Class.class));
  }

  /**
   * Test {@link OracleSessionIdTransactionInfoModifier#modify(TransactionInfo)}.
   * <ul>
   *   <li>Given {@link SessionDelegatorBaseImpl}
   * {@link SessionDelegatorBaseImpl#doReturningWork(ReturningWork)} return
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleSessionIdTransactionInfoModifier#modify(TransactionInfo)}
   */
  @Test
  public void testModify_givenSessionDelegatorBaseImplDoReturningWorkReturnOne() throws HibernateException {
    // Arrange
    OracleSessionIdTransactionInfoModifier oracleSessionIdTransactionInfoModifier = new OracleSessionIdTransactionInfoModifier();
    SessionDelegatorBaseImpl sessionDelegatorBaseImpl = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl.doReturningWork(Mockito.<ReturningWork<Integer>>any())).thenReturn(1);
    SessionDelegatorBaseImpl sessionDelegatorBaseImpl2 = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl2.unwrap(Mockito.<Class<Session>>any())).thenReturn(sessionDelegatorBaseImpl);
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getAdditionalParams()).thenReturn(new HashMap<>());
    when(info.getEntityManager()).thenReturn(sessionDelegatorBaseImpl2);

    // Act
    oracleSessionIdTransactionInfoModifier.modify(info);

    // Assert
    verify(info).getAdditionalParams();
    verify(info).getEntityManager();
    verify(sessionDelegatorBaseImpl).doReturningWork(isA(ReturningWork.class));
    verify(sessionDelegatorBaseImpl2).unwrap(isA(Class.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link OracleSessionIdTransactionInfoModifier}
   *   <li>{@link OracleSessionIdTransactionInfoModifier#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new OracleSessionIdTransactionInfoModifier()).getOrder());
  }
}
