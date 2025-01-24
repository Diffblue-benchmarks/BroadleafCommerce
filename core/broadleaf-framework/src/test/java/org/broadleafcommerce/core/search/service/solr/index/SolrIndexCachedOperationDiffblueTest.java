package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.core.search.dao.CatalogStructure;
import org.junit.Test;
import org.mockito.Mockito;

public class SolrIndexCachedOperationDiffblueTest {
  /**
   * Test {@link SolrIndexCachedOperation#getCache()}.
   * <p>
   * Method under test: {@link SolrIndexCachedOperation#getCache()}
   */
  @Test
  public void testGetCache() {
    // Arrange, Act and Assert
    assertNull(SolrIndexCachedOperation.getCache());
  }

  /**
   * Test {@link SolrIndexCachedOperation#setCache(CatalogStructure)}.
   * <ul>
   *   <li>Then calls
   * {@link CatalogStructure#setDisplayOrdersByCategoryProduct(Map)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexCachedOperation#setCache(CatalogStructure)}
   */
  @Test
  public void testSetCache_thenCallsSetDisplayOrdersByCategoryProduct() {
    // Arrange
    CatalogStructure cache = mock(CatalogStructure.class);
    doNothing().when(cache).setDisplayOrdersByCategoryProduct(Mockito.<Map<String, BigDecimal>>any());
    doNothing().when(cache).setParentCategoriesByCategory(Mockito.<Map<Long, Set<Long>>>any());
    doNothing().when(cache).setParentCategoriesByProduct(Mockito.<Map<Long, Set<Long>>>any());
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act
    SolrIndexCachedOperation.setCache(cache);

    // Assert
    verify(cache).setDisplayOrdersByCategoryProduct(isA(Map.class));
    verify(cache).setParentCategoriesByCategory(isA(Map.class));
    verify(cache).setParentCategoriesByProduct(isA(Map.class));
  }

  /**
   * Test {@link SolrIndexCachedOperation#clearCache()}.
   * <p>
   * Method under test: {@link SolrIndexCachedOperation#clearCache()}
   */
  @Test
  public void testClearCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SolrIndexCachedOperation.clearCache();
  }
}
