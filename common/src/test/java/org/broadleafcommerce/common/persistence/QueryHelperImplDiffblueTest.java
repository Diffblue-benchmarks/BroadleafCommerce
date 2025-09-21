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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.hibernate.procedure.internal.ProcedureCallImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {QueryHelperImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryHelperImplDiffblueTest {
  @Autowired private QueryHelperImpl queryHelperImpl;

  /**
   * Test {@link QueryHelperImpl#getSingleton()}.
   *
   * <p>Method under test: {@link QueryHelperImpl#getSingleton()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.persistence.QueryHelper QueryHelperImpl.getSingleton()"
  })
  public void testGetSingleton() {
    // Arrange, Act and Assert
    assertTrue(QueryHelperImpl.getSingleton() instanceof QueryHelperImpl);
  }

  /**
   * Test {@link QueryHelperImpl#getResultListWithHint(Query, String, Object)} with {@code Query},
   * {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link QueryHelperImpl#getResultListWithHint(Query, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List QueryHelperImpl.getResultListWithHint(Query, String, Object)"})
  public void testGetResultListWithHintWithQueryStringObject_givenArrayList_thenReturnEmpty() {
    // Arrange
    ProcedureCallImpl<Object> query = mock(ProcedureCallImpl.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(query.getResultList()).thenReturn(objectList);

    // Act
    List actualResultListWithHint =
        queryHelperImpl.getResultListWithHint(query, "Hint Key", BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(query).getResultList();
    assertTrue(actualResultListWithHint.isEmpty());
    assertSame(objectList, actualResultListWithHint);
  }

  /**
   * Test {@link QueryHelperImpl#getResultListWithHint(TypedQuery, String, Object)} with {@code
   * TypedQuery}, {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link QueryHelperImpl#getResultListWithHint(TypedQuery, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List QueryHelperImpl.getResultListWithHint(TypedQuery, String, Object)"})
  public void testGetResultListWithHintWithTypedQueryStringObject_thenReturnEmpty() {
    // Arrange
    ProcedureCallImpl<Object> query = mock(ProcedureCallImpl.class);
    when(query.getResultList()).thenReturn(new ArrayList<>());

    // Act
    List<Object> actualResultListWithHint =
        queryHelperImpl.getResultListWithHint(query, "Hint Key", BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(query).getResultList();
    assertTrue(actualResultListWithHint.isEmpty());
  }

  /**
   * Test {@link QueryHelperImpl#getSingleResultWithHint(Query, String, Object)} with {@code Query},
   * {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Then return {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link QueryHelperImpl#getSingleResultWithHint(Query, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object QueryHelperImpl.getSingleResultWithHint(Query, String, Object)"})
  public void testGetSingleResultWithHintWithQueryStringObject_thenReturnNull_field() {
    // Arrange
    ProcedureCallImpl<Object> query = mock(ProcedureCallImpl.class);
    when(query.getSingleResult()).thenReturn(BLCFieldUtils.NULL_FIELD);
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualSingleResultWithHint =
        queryHelperImpl.getSingleResultWithHint(query, "Hint Key", object);

    // Assert
    verify(query).getSingleResult();
    assertSame(object, actualSingleResultWithHint);
  }

  /**
   * Test {@link QueryHelperImpl#getSingleResultWithHint(TypedQuery, String, Object)} with {@code
   * TypedQuery}, {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Then return {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link QueryHelperImpl#getSingleResultWithHint(TypedQuery, String,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object QueryHelperImpl.getSingleResultWithHint(TypedQuery, String, Object)"})
  public void testGetSingleResultWithHintWithTypedQueryStringObject_thenReturnNull_field() {
    // Arrange
    ProcedureCallImpl<Object> query = mock(ProcedureCallImpl.class);
    when(query.getSingleResult()).thenReturn(BLCFieldUtils.NULL_FIELD);
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualSingleResultWithHint =
        queryHelperImpl.getSingleResultWithHint(query, "Hint Key", object);

    // Assert
    verify(query).getSingleResult();
    assertSame(object, actualSingleResultWithHint);
  }

  /**
   * Test {@link QueryHelperImpl#getQueryHint(String)}.
   *
   * <ul>
   *   <li>When {@code Hint Key}.
   * </ul>
   *
   * <p>Method under test: {@link QueryHelperImpl#getQueryHint(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object QueryHelperImpl.getQueryHint(String)"})
  public void testGetQueryHint_whenHintKey() {
    // Arrange, Act and Assert
    assertNull(queryHelperImpl.getQueryHint("Hint Key"));
  }

  /**
   * Test {@link QueryHelperImpl#getQueryHint(String)}.
   *
   * <ul>
   *   <li>When {@code ThreadLocalManager.notify.orphans}.
   * </ul>
   *
   * <p>Method under test: {@link QueryHelperImpl#getQueryHint(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object QueryHelperImpl.getQueryHint(String)"})
  public void testGetQueryHint_whenThreadLocalManagerNotifyOrphans() {
    // Arrange, Act and Assert
    assertNull(queryHelperImpl.getQueryHint("ThreadLocalManager.notify.orphans"));
  }
}
