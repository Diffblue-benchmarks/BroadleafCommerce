package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SolrIndexCachedOperationDiffblueTest {
  /**
   * Test {@link SolrIndexCachedOperation#getCache()}.
   *
   * <p>Method under test: {@link SolrIndexCachedOperation#getCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.dao.CatalogStructure SolrIndexCachedOperation.getCache()"
  })
  public void testGetCache() {
    // Arrange, Act and Assert
    assertNull(SolrIndexCachedOperation.getCache());
  }
}
