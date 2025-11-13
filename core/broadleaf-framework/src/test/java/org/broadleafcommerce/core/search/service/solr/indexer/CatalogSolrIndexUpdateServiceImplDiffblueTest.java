package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CatalogSolrIndexUpdateServiceImplDiffblueTest {
  /**
   * Test {@link CatalogSolrIndexUpdateServiceImpl#performCachedOperation(CacheOperation)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateServiceImpl#performCachedOperation(CacheOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateServiceImpl.performCachedOperation(CacheOperation)"
  })
  public void testPerformCachedOperation_thenThrowServiceException() throws ServiceException {
    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl =
        new CatalogSolrIndexUpdateServiceImpl(
            queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    CacheOperation cacheOperation = mock(CacheOperation.class);
    doThrow(new ServiceException("An error occurred")).when(cacheOperation).execute();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> catalogSolrIndexUpdateServiceImpl.performCachedOperation(cacheOperation));
    verify(cacheOperation).execute();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateServiceImpl#performCachedOperation(CacheOperation)}.
   *
   * <ul>
   *   <li>When {@link CacheOperation} {@link CacheOperation#execute()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateServiceImpl#performCachedOperation(CacheOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateServiceImpl.performCachedOperation(CacheOperation)"
  })
  public void testPerformCachedOperation_whenCacheOperationExecuteDoesNothing()
      throws ServiceException {
    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl =
        new CatalogSolrIndexUpdateServiceImpl(
            queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    CacheOperation cacheOperation = mock(CacheOperation.class);
    doNothing().when(cacheOperation).execute();

    // Act
    catalogSolrIndexUpdateServiceImpl.performCachedOperation(cacheOperation);

    // Assert
    verify(cacheOperation).execute();
  }
}
