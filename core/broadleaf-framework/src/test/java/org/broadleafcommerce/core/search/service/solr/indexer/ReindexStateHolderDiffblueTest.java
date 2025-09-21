/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReindexStateHolderDiffblueTest {
  /**
   * Test {@link ReindexStateHolder#getInstance(String)} with {@code collectionName}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReindexStateHolder#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReindexStateHolder ReindexStateHolder.getInstance(String)"})
  public void testGetInstanceWithCollectionName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ReindexStateHolder.getInstance("Collection NameCollection Name"));
  }

  /**
   * Test {@link ReindexStateHolder#isFailed()}.
   *
   * <p>Method under test: {@link ReindexStateHolder#isFailed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReindexStateHolder.isFailed()"})
  public void testIsFailed() {
    // Arrange, Act and Assert
    assertTrue(ReindexStateHolder.getInstance("Collection Name", true, true).isFailed());
  }

  /**
   * Test {@link ReindexStateHolder#getFailure()}.
   *
   * <p>Method under test: {@link ReindexStateHolder#getFailure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Exception ReindexStateHolder.getFailure()"})
  public void testGetFailure() {
    // Arrange and Act
    Exception actualFailure =
        ReindexStateHolder.getInstance("Collection Name", true, true).getFailure();

    // Assert
    assertNull(actualFailure.getLocalizedMessage());
    assertNull(actualFailure.getMessage());
    assertNull(actualFailure.getCause());
    assertEquals(0, actualFailure.getSuppressed().length);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReindexStateHolder#getAdditionalState()}
   *   <li>{@link ReindexStateHolder#getCollectionName()}
   *   <li>{@link ReindexStateHolder#isIncrementalCommits()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ReindexStateHolder.getAdditionalState()",
    "String ReindexStateHolder.getCollectionName()",
    "boolean ReindexStateHolder.isIncrementalCommits()"
  })
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
