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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.experimental.categories.Category;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalUpdateCommand.<init>(List, List)",
      "List IncrementalUpdateCommand.getDeleteQueries()", "List IncrementalUpdateCommand.getSolrInputDocuments()"})
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
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Delete Queries}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalUpdateCommand#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IncrementalUpdateCommand.toString()"})
  public void testToString_givenArrayListAddDeleteQueries_thenReturnAString() {
    // Arrange
    ArrayList<String> deleteQueries = new ArrayList<>();
    deleteQueries.add("Delete Queries");

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.search.service.solr.indexer.IncrementalUpdateCommand\n" + "  Delete Queries: \n"
            + "    Delete Queries\n" + "  SolrInputDocuments: \n" + "    -- No SolrInputDocuments --\n",
        (new IncrementalUpdateCommand(null, deleteQueries)).toString());
  }

  /**
   * Test {@link IncrementalUpdateCommand#toString()}.
   * <ul>
   *   <li>Given {@link IncrementalUpdateCommand#IncrementalUpdateCommand(List, List)} with docs is {@code null} and deleteQueries is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalUpdateCommand#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IncrementalUpdateCommand.toString()"})
  public void testToString_givenIncrementalUpdateCommandWithDocsIsNullAndDeleteQueriesIsNull() {
    // Arrange, Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.search.service.solr.indexer.IncrementalUpdateCommand\n" + "  Delete Queries: \n"
            + "    -- No Delete Queries --\n" + "  SolrInputDocuments: \n" + "    -- No SolrInputDocuments --\n",
        (new IncrementalUpdateCommand(null, null)).toString());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IncrementalUpdateCommand.toString()"})
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
