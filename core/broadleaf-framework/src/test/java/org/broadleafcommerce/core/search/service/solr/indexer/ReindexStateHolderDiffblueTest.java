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
