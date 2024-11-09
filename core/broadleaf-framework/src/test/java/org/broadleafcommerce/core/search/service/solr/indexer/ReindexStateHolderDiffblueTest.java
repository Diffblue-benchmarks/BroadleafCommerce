/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.junit.Test;

public class ReindexStateHolderDiffblueTest {
  /**
   * Test {@link ReindexStateHolder#getInstance(String, boolean, boolean)} with
   * {@code collectionName}, {@code incrementalCommits}, {@code createIfAbsent}.
   * <p>
   * Method under test:
   * {@link ReindexStateHolder#getInstance(String, boolean, boolean)}
   */
  @Test
  public void testGetInstanceWithCollectionNameIncrementalCommitsCreateIfAbsent() {
    // Arrange and Act
    ReindexStateHolder actualInstance = ReindexStateHolder.getInstance(null, true, true);

    // Assert
    assertNull(actualInstance.getFailure());
    assertNull(actualInstance.getCollectionName());
    assertEquals(-1L, actualInstance.getLastCommitted());
    assertEquals(0L, actualInstance.getIndexableCount());
    assertEquals(0L, actualInstance.getUnindexedItemCount());
    assertFalse(actualInstance.isFailed());
  }

  /**
   * Test {@link ReindexStateHolder#getInstance(String)} with
   * {@code collectionName}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReindexStateHolder#getInstance(String)}
   */
  @Test
  public void testGetInstanceWithCollectionName_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ReindexStateHolder.getInstance(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReindexStateHolder#getAdditionalState()}
   *   <li>{@link ReindexStateHolder#getCollectionName()}
   *   <li>{@link ReindexStateHolder#isIncrementalCommits()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ReindexStateHolder instance = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Act
    Map<String, Object> actualAdditionalState = instance.getAdditionalState();
    String actualCollectionName = instance.getCollectionName();
    boolean actualIsIncrementalCommitsResult = instance.isIncrementalCommits();

    // Assert
    assertEquals("Collection Name", actualCollectionName);
    assertTrue(actualAdditionalState.isEmpty());
    assertTrue(actualIsIncrementalCommitsResult);
  }
}
