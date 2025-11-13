package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IncrementalUpdateCommandDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IncrementalUpdateCommand#IncrementalUpdateCommand(List, List)}
   *   <li>{@link IncrementalUpdateCommand#getDeleteQueries()}
   *   <li>{@link IncrementalUpdateCommand#getSolrInputDocuments()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IncrementalUpdateCommand.<init>(List, List)",
    "List IncrementalUpdateCommand.getDeleteQueries()",
    "List IncrementalUpdateCommand.getSolrInputDocuments()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    ArrayList<String> deleteQueries = new ArrayList<>();

    // Act
    IncrementalUpdateCommand actualIncrementalUpdateCommand =
        new IncrementalUpdateCommand(docs, deleteQueries);
    List<String> actualDeleteQueries = actualIncrementalUpdateCommand.getDeleteQueries();
    List<SolrInputDocument> actualSolrInputDocuments =
        actualIncrementalUpdateCommand.getSolrInputDocuments();

    // Assert
    assertTrue(actualDeleteQueries.isEmpty());
    assertTrue(actualSolrInputDocuments.isEmpty());
    assertSame(deleteQueries, actualDeleteQueries);
    assertSame(docs, actualSolrInputDocuments);
  }

  /**
   * Test {@link IncrementalUpdateCommand#toString()}.
   *
   * <p>Method under test: {@link IncrementalUpdateCommand#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String IncrementalUpdateCommand.toString()"})
  public void testToString() {
    // Arrange
    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    IncrementalUpdateCommand incrementalUpdateCommand =
        new IncrementalUpdateCommand(docs, new ArrayList<>());

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.search.service.solr.indexer.IncrementalUpdateCommand\n"
            + "  Delete Queries: \n"
            + "    -- No Delete Queries --\n"
            + "  SolrInputDocuments: \n"
            + "    -- No SolrInputDocuments --\n",
        incrementalUpdateCommand.toString());
  }

  /**
   * Test {@link IncrementalUpdateCommand#toString()}.
   *
   * <p>Method under test: {@link IncrementalUpdateCommand#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String IncrementalUpdateCommand.toString()"})
  public void testToString2() {
    // Arrange
    ArrayList<String> deleteQueries = new ArrayList<>();
    deleteQueries.add("Delete Queries");
    IncrementalUpdateCommand incrementalUpdateCommand =
        new IncrementalUpdateCommand(null, deleteQueries);

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.search.service.solr.indexer.IncrementalUpdateCommand\n"
            + "  Delete Queries: \n"
            + "    Delete Queries\n"
            + "  SolrInputDocuments: \n"
            + "    -- No SolrInputDocuments --\n",
        incrementalUpdateCommand.toString());
  }

  /**
   * Test {@link IncrementalUpdateCommand#toString()}.
   *
   * <p>Method under test: {@link IncrementalUpdateCommand#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String IncrementalUpdateCommand.toString()"})
  public void testToString3() {
    // Arrange
    IncrementalUpdateCommand incrementalUpdateCommand =
        new IncrementalUpdateCommand(new ArrayList<>(), null);

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.search.service.solr.indexer.IncrementalUpdateCommand\n"
            + "  Delete Queries: \n"
            + "    -- No Delete Queries --\n"
            + "  SolrInputDocuments: \n"
            + "    -- No SolrInputDocuments --\n",
        incrementalUpdateCommand.toString());
  }

  /**
   * Test {@link IncrementalUpdateCommand#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Delete Queries}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalUpdateCommand#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String IncrementalUpdateCommand.toString()"})
  public void testToString_givenArrayListAddDeleteQueries() {
    // Arrange
    ArrayList<String> deleteQueries = new ArrayList<>();
    deleteQueries.add("Delete Queries");
    IncrementalUpdateCommand incrementalUpdateCommand =
        new IncrementalUpdateCommand(new ArrayList<>(), deleteQueries);

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.search.service.solr.indexer.IncrementalUpdateCommand\n"
            + "  Delete Queries: \n"
            + "    Delete Queries\n"
            + "  SolrInputDocuments: \n"
            + "    -- No SolrInputDocuments --\n",
        incrementalUpdateCommand.toString());
  }
}
