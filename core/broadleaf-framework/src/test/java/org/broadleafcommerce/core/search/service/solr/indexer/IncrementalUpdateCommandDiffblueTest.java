package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class IncrementalUpdateCommandDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IncrementalUpdateCommand#IncrementalUpdateCommand(List, List)}
   *   <li>{@link IncrementalUpdateCommand#getDeleteQueries()}
   *   <li>{@link IncrementalUpdateCommand#getSolrInputDocuments()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    ArrayList<String> deleteQueries = new ArrayList<>();

    // Act
    IncrementalUpdateCommand actualIncrementalUpdateCommand = new IncrementalUpdateCommand(docs, deleteQueries);
    List<String> actualDeleteQueries = actualIncrementalUpdateCommand.getDeleteQueries();
    List<SolrInputDocument> actualSolrInputDocuments = actualIncrementalUpdateCommand.getSolrInputDocuments();

    // Assert
    assertTrue(actualDeleteQueries.isEmpty());
    assertTrue(actualSolrInputDocuments.isEmpty());
    assertSame(deleteQueries, actualDeleteQueries);
    assertSame(docs, actualSolrInputDocuments);
  }

  /**
   * Test {@link IncrementalUpdateCommand#toString()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add lf.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalUpdateCommand#toString()}
   */
  @Test
  public void testToString_givenArrayListAddLf_thenReturnAString() {
    // Arrange
    ArrayList<String> deleteQueries = new ArrayList<>();
    deleteQueries.add("\n");

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.search.service.solr.indexer.IncrementalUpdateCommand\n" + "  Delete Queries: \n"
            + "    \n" + "\n" + "  SolrInputDocuments: \n" + "    -- No SolrInputDocuments --\n",
        (new IncrementalUpdateCommand(new ArrayList<>(), deleteQueries)).toString());
  }

  /**
   * Test {@link IncrementalUpdateCommand#toString()}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalUpdateCommand#toString()}
   */
  @Test
  public void testToString_thenReturnAString() {
    // Arrange
    ArrayList<SolrInputDocument> docs = new ArrayList<>();

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.search.service.solr.indexer.IncrementalUpdateCommand\n" + "  Delete Queries: \n"
            + "    -- No Delete Queries --\n" + "  SolrInputDocuments: \n" + "    -- No SolrInputDocuments --\n",
        (new IncrementalUpdateCommand(docs, new ArrayList<>())).toString());
  }
}
