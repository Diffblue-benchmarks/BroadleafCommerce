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
}
