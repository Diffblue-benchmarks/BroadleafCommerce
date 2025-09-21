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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.Type;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class UpdateExecutorDiffblueTest {
  /**
   * Test {@link UpdateExecutor#executeUpdateQuery(EntityManager, String, Object[], Type[], List)}
   * with {@code em}, {@code template}, {@code params}, {@code types}, {@code ids}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UpdateExecutor#executeUpdateQuery(EntityManager, String, Object[],
   * Type[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int UpdateExecutor.executeUpdateQuery(EntityManager, String, Object[], Type[], List)"
  })
  public void testExecuteUpdateQueryWithEmTemplateParamsTypesIds_thenReturnOne()
      throws HibernateException {
    // Arrange
    NativeQueryImpl nativeQueryImpl = mock(NativeQueryImpl.class);
    when(nativeQueryImpl.executeUpdate()).thenReturn(1);
    when(nativeQueryImpl.setParameter(anyInt(), Mockito.<Object>any(), Mockito.<Type>any()))
        .thenReturn(null);

    SessionDelegatorBaseImpl sessionDelegatorBaseImpl = mock(SessionDelegatorBaseImpl.class);
    when(sessionDelegatorBaseImpl.getHibernateFlushMode()).thenReturn(FlushMode.MANUAL);
    doNothing().when(sessionDelegatorBaseImpl).setFlushMode(Mockito.<FlushMode>any());
    when(sessionDelegatorBaseImpl.createSQLQuery(Mockito.<String>any()))
        .thenReturn(nativeQueryImpl);

    SessionDelegatorBaseImpl em = mock(SessionDelegatorBaseImpl.class);
    when(em.unwrap(Mockito.<Class<Session>>any())).thenReturn(sessionDelegatorBaseImpl);

    // Act
    int actualExecuteUpdateQueryResult =
        UpdateExecutor.executeUpdateQuery(
            em,
            "Template",
            new Object[] {BLCFieldUtils.NULL_FIELD},
            new Type[] {new BigDecimalType()},
            new ArrayList<>());

    // Assert
    verify(sessionDelegatorBaseImpl).createSQLQuery("Template");
    verify(sessionDelegatorBaseImpl).getHibernateFlushMode();
    verify(sessionDelegatorBaseImpl, atLeast(1)).setFlushMode(FlushMode.MANUAL);
    verify(em, atLeast(1)).unwrap(isA(Class.class));
    verify(nativeQueryImpl).executeUpdate();
    verify(nativeQueryImpl).setParameter(eq(1), isA(Object.class), isA(Type.class));
    assertEquals(1, actualExecuteUpdateQueryResult);
  }
}
