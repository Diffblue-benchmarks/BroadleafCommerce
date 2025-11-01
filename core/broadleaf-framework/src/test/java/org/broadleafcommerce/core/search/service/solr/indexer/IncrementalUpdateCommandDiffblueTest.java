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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class IncrementalUpdateCommandDiffblueTest {
  /**
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
}
