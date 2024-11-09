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
package org.broadleafcommerce.common.sandbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.List;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class DefaultSandBoxHelperDiffblueTest {
  /**
   * Test {@link DefaultSandBoxHelper#getSandBoxVersionId(Class, Long)}.
   * <p>
   * Method under test:
   * {@link DefaultSandBoxHelper#getSandBoxVersionId(Class, Long)}
   */
  @Test
  public void testGetSandBoxVersionId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();
    Class<Object> linkedObjectType = Object.class;

    // Act and Assert
    assertEquals(1L, defaultSandBoxHelper.getSandBoxVersionId(linkedObjectType, 1L).longValue());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getCascadedProductionStateId(Class, Long)}.
   * <p>
   * Method under test:
   * {@link DefaultSandBoxHelper#getCascadedProductionStateId(Class, Long)}
   */
  @Test
  public void testGetCascadedProductionStateId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();
    Class<Object> linkedObjectType = Object.class;

    // Act and Assert
    assertEquals(1L, defaultSandBoxHelper.getCascadedProductionStateId(linkedObjectType, 1L).longValue());
  }

  /**
   * Test
   * {@link DefaultSandBoxHelper#isRelatedToParentCatalogIds(Object, Long[])}.
   * <p>
   * Method under test:
   * {@link DefaultSandBoxHelper#isRelatedToParentCatalogIds(Object, Long[])}
   */
  @Test
  public void testIsRelatedToParentCatalogIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DefaultSandBoxHelper()).isRelatedToParentCatalogIds(BLCFieldUtils.NULL_FIELD, 1L));
  }

  /**
   * Test {@link DefaultSandBoxHelper#mergeCloneIds(Class, Long[])}.
   * <p>
   * Method under test: {@link DefaultSandBoxHelper#mergeCloneIds(Class, Long[])}
   */
  @Test
  public void testMergeCloneIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();
    Class<Object> type = Object.class;

    // Act
    List<Long> actualMergeCloneIdsResult = defaultSandBoxHelper.mergeCloneIds(type, 1L);

    // Assert
    assertEquals(1, actualMergeCloneIdsResult.size());
    assertEquals(1L, actualMergeCloneIdsResult.get(0).longValue());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getSandBoxToOriginalMap(Class, Long[])}.
   * <p>
   * Method under test:
   * {@link DefaultSandBoxHelper#getSandBoxToOriginalMap(Class, Long[])}
   */
  @Test
  public void testGetSandBoxToOriginalMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(defaultSandBoxHelper.getSandBoxToOriginalMap(type, 1L).isEmpty());
  }

  /**
   * Test
   * {@link DefaultSandBoxHelper#getTopmostProductionOriginalId(Class, Long)}.
   * <p>
   * Method under test:
   * {@link DefaultSandBoxHelper#getTopmostProductionOriginalId(Class, Long)}
   */
  @Test
  public void testGetTopmostProductionOriginalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(1L, defaultSandBoxHelper.getTopmostProductionOriginalId(type, 1L).longValue());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getOriginalId(Object)} with {@code test}.
   * <p>
   * Method under test: {@link DefaultSandBoxHelper#getOriginalId(Object)}
   */
  @Test
  public void testGetOriginalIdWithTest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DefaultSandBoxHelper()).getOriginalId(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link DefaultSandBoxHelper#getOriginalId(Class, Long)} with
   * {@code type}, {@code id}.
   * <p>
   * Method under test: {@link DefaultSandBoxHelper#getOriginalId(Class, Long)}
   */
  @Test
  public void testGetOriginalIdWithTypeId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();
    Class<Object> type = Object.class;

    // Act
    SandBoxHelper.OriginalIdResponse actualOriginalId = defaultSandBoxHelper.getOriginalId(type, 1L);

    // Assert
    assertEquals(1L, actualOriginalId.getOriginalId().longValue());
    assertFalse(actualOriginalId.isRecordFound());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getProductionOriginalId(Class, Long)}.
   * <p>
   * Method under test:
   * {@link DefaultSandBoxHelper#getProductionOriginalId(Class, Long)}
   */
  @Test
  public void testGetProductionOriginalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(defaultSandBoxHelper.getProductionOriginalId(type, 1L));
  }

  /**
   * Test {@link DefaultSandBoxHelper#isSandBoxable(String)}.
   * <p>
   * Method under test: {@link DefaultSandBoxHelper#isSandBoxable(String)}
   */
  @Test
  public void testIsSandBoxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DefaultSandBoxHelper()).isSandBoxable("Class Name"));
  }

  /**
   * Test
   * {@link DefaultSandBoxHelper#optionallyIncludeDeletedItemsInQueriesAndCollections(Runnable, boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultSandBoxHelper#optionallyIncludeDeletedItemsInQueriesAndCollections(Runnable, boolean)}
   */
  @Test
  public void testOptionallyIncludeDeletedItemsInQueriesAndCollections() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();
    Runnable runnable = mock(Runnable.class);
    doNothing().when(runnable).run();

    // Act
    defaultSandBoxHelper.optionallyIncludeDeletedItemsInQueriesAndCollections(runnable, true);

    // Assert that nothing has changed
    verify(runnable).run();
  }

  /**
   * Test {@link DefaultSandBoxHelper#getTopMostOriginalRecord(Object)}.
   * <p>
   * Method under test:
   * {@link DefaultSandBoxHelper#getTopMostOriginalRecord(Object)}
   */
  @Test
  public void testGetTopMostOriginalRecord() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, (new DefaultSandBoxHelper()).getTopMostOriginalRecord(object));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultSandBoxHelper#ignoreCloneCache(boolean)}
   *   <li>{@link DefaultSandBoxHelper#isPromote()}
   *   <li>{@link DefaultSandBoxHelper#isReject()}
   *   <li>{@link DefaultSandBoxHelper#isReplayOperation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();

    // Act
    defaultSandBoxHelper.ignoreCloneCache(true);
    boolean actualIsPromoteResult = defaultSandBoxHelper.isPromote();
    boolean actualIsRejectResult = defaultSandBoxHelper.isReject();

    // Assert that nothing has changed
    assertFalse(actualIsPromoteResult);
    assertFalse(actualIsRejectResult);
    assertFalse(defaultSandBoxHelper.isReplayOperation());
  }
}
