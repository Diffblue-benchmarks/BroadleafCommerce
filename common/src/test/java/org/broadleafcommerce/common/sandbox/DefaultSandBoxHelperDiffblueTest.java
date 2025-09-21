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
package org.broadleafcommerce.common.sandbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultSandBoxHelper.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultSandBoxHelperDiffblueTest {
  @Autowired private DefaultSandBoxHelper defaultSandBoxHelper;

  /**
   * Test {@link DefaultSandBoxHelper#getSandBoxVersionId(Class, Long)}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getSandBoxVersionId(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DefaultSandBoxHelper.getSandBoxVersionId(Class, Long)"})
  public void testGetSandBoxVersionId() {
    // Arrange
    Class<Object> linkedObjectType = Object.class;

    // Act and Assert
    assertEquals(1L, defaultSandBoxHelper.getSandBoxVersionId(linkedObjectType, 1L).longValue());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getCascadedProductionStateId(Class, Long)}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getCascadedProductionStateId(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DefaultSandBoxHelper.getCascadedProductionStateId(Class, Long)"})
  public void testGetCascadedProductionStateId() {
    // Arrange
    Class<Object> linkedObjectType = Object.class;

    // Act and Assert
    assertEquals(
        1L, defaultSandBoxHelper.getCascadedProductionStateId(linkedObjectType, 1L).longValue());
  }

  /**
   * Test {@link DefaultSandBoxHelper#retrieveCascadedState(Class, Long, EntityManager)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#retrieveCascadedState(Class, Long,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DefaultSandBoxHelper.retrieveCascadedState(Class, Long, EntityManager)"})
  public void testRetrieveCascadedState_whenNull_thenReturnLongValueIsOne() {
    // Arrange
    Class<Object> ceilingImpl = Object.class;

    // Act and Assert
    assertEquals(1L, defaultSandBoxHelper.retrieveCascadedState(ceilingImpl, 1L, null).longValue());
  }

  /**
   * Test {@link DefaultSandBoxHelper#isRelatedToParentCatalogIds(Object, Long[])}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#isRelatedToParentCatalogIds(Object, Long[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultSandBoxHelper.isRelatedToParentCatalogIds(Object, Long[])"})
  public void testIsRelatedToParentCatalogIds() {
    // Arrange, Act and Assert
    assertFalse(defaultSandBoxHelper.isRelatedToParentCatalogIds(BLCFieldUtils.NULL_FIELD, 1L));
  }

  /**
   * Test {@link DefaultSandBoxHelper#mergeCloneIds(Class, Long[])}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#mergeCloneIds(Class, Long[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DefaultSandBoxHelper.mergeCloneIds(Class, Long[])"})
  public void testMergeCloneIds() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    List<Long> actualMergeCloneIdsResult = defaultSandBoxHelper.mergeCloneIds(type, 1L);

    // Assert
    assertEquals(1, actualMergeCloneIdsResult.size());
    assertEquals(1L, actualMergeCloneIdsResult.get(0).longValue());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getSandBoxToOriginalMap(Class, Long[])}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getSandBoxToOriginalMap(Class, Long[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.collect.BiMap DefaultSandBoxHelper.getSandBoxToOriginalMap(Class, Long[])"
  })
  public void testGetSandBoxToOriginalMap() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(defaultSandBoxHelper.getSandBoxToOriginalMap(type, 1L).isEmpty());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getTopmostProductionOriginalId(Class, Long)}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getTopmostProductionOriginalId(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DefaultSandBoxHelper.getTopmostProductionOriginalId(Class, Long)"})
  public void testGetTopmostProductionOriginalId() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(1L, defaultSandBoxHelper.getTopmostProductionOriginalId(type, 1L).longValue());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getOriginalId(Object)} with {@code test}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getOriginalId(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DefaultSandBoxHelper.getOriginalId(Object)"})
  public void testGetOriginalIdWithTest() {
    // Arrange, Act and Assert
    assertNull(defaultSandBoxHelper.getOriginalId(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link DefaultSandBoxHelper#getOriginalId(Class, Long)} with {@code type}, {@code id}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getOriginalId(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OriginalIdResponse DefaultSandBoxHelper.getOriginalId(Class, Long)"})
  public void testGetOriginalIdWithTypeId() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    OriginalIdResponse actualOriginalId = defaultSandBoxHelper.getOriginalId(type, 1L);

    // Assert
    assertEquals(1L, actualOriginalId.getOriginalId().longValue());
    assertFalse(actualOriginalId.isRecordFound());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getProductionOriginalId(Class, Long)}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getProductionOriginalId(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OriginalIdResponse DefaultSandBoxHelper.getProductionOriginalId(Class, Long)"
  })
  public void testGetProductionOriginalId() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(defaultSandBoxHelper.getProductionOriginalId(type, 1L));
  }

  /**
   * Test {@link DefaultSandBoxHelper#isSandBoxable(String)}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#isSandBoxable(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultSandBoxHelper.isSandBoxable(String)"})
  public void testIsSandBoxable() {
    // Arrange, Act and Assert
    assertFalse(defaultSandBoxHelper.isSandBoxable("Class Name"));
  }

  /**
   * Test {@link DefaultSandBoxHelper#optionallyIncludeDeletedItemsInQueriesAndCollections(Runnable,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * DefaultSandBoxHelper#optionallyIncludeDeletedItemsInQueriesAndCollections(Runnable, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultSandBoxHelper.optionallyIncludeDeletedItemsInQueriesAndCollections(Runnable, boolean)"
  })
  public void testOptionallyIncludeDeletedItemsInQueriesAndCollections() {
    // Arrange
    Runnable runnable = mock(Runnable.class);
    doNothing().when(runnable).run();

    // Act
    defaultSandBoxHelper.optionallyIncludeDeletedItemsInQueriesAndCollections(runnable, true);

    // Assert
    verify(runnable).run();
  }

  /**
   * Test {@link DefaultSandBoxHelper#getTopMostOriginalRecord(Object)}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getTopMostOriginalRecord(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultSandBoxHelper.getTopMostOriginalRecord(Object)"})
  public void testGetTopMostOriginalRecord() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualTopMostOriginalRecord = defaultSandBoxHelper.getTopMostOriginalRecord(object);

    // Assert
    assertSame(object, actualTopMostOriginalRecord);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultSandBoxHelper#ignoreCloneCache(boolean)}
   *   <li>{@link DefaultSandBoxHelper#isPromote()}
   *   <li>{@link DefaultSandBoxHelper#isReject()}
   *   <li>{@link DefaultSandBoxHelper#isReplayOperation()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultSandBoxHelper.ignoreCloneCache(boolean)",
    "boolean DefaultSandBoxHelper.isPromote()",
    "boolean DefaultSandBoxHelper.isReject()",
    "boolean DefaultSandBoxHelper.isReplayOperation()"
  })
  public void testGettersAndSetters() {
    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();

    // Act
    defaultSandBoxHelper.ignoreCloneCache(true);
    boolean actualIsPromoteResult = defaultSandBoxHelper.isPromote();
    boolean actualIsRejectResult = defaultSandBoxHelper.isReject();

    // Assert
    assertFalse(actualIsPromoteResult);
    assertFalse(actualIsRejectResult);
    assertFalse(defaultSandBoxHelper.isReplayOperation());
  }
}
