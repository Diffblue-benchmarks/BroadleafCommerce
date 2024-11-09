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

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
import org.junit.Test;

public class CatalogSolrIndexUpdateServiceImplDiffblueTest {
  /**
   * Test
   * {@link CatalogSolrIndexUpdateServiceImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());
    SolrIndexCachedOperation.CacheOperation cacheOperation = mock(SolrIndexCachedOperation.CacheOperation.class);
    doThrow(new ServiceException("An error occurred")).when(cacheOperation).execute();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateServiceImpl.performCachedOperation(cacheOperation));
    verify(cacheOperation).execute();
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateServiceImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>When {@link CacheOperation} {@link CacheOperation#execute()} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation_whenCacheOperationExecuteDoesNothing() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());
    SolrIndexCachedOperation.CacheOperation cacheOperation = mock(SolrIndexCachedOperation.CacheOperation.class);
    doNothing().when(cacheOperation).execute();

    // Act
    catalogSolrIndexUpdateServiceImpl.performCachedOperation(cacheOperation);

    // Assert
    verify(cacheOperation).execute();
  }
}
