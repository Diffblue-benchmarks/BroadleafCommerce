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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class CatalogSolrIndexUpdateCommandHandlerImplDiffblueTest {
  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCommand(SolrUpdateCommand)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCommand(SolrUpdateCommand)}
   */
  @Test
  public void testExecuteCommand() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new CatalogSolrIndexUpdateCommandHandlerImpl()).executeCommand(FullReindexCommand.DEFAULT_INSTANCE));
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCatalogReindexCommand(CatalogReindexCommand)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCatalogReindexCommand(CatalogReindexCommand)}
   */
  @Test
  public void testExecuteCatalogReindexCommand() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.executeCatalogReindexCommand(new CatalogReindexCommand(1L)));
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeSiteReindexCommand(SiteReindexCommand)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeSiteReindexCommand(SiteReindexCommand)}
   */
  @Test
  public void testExecuteSiteReindexCommand() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.executeSiteReindexCommand(new SiteReindexCommand(1L)));
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation_thenThrowIllegalStateException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    SolrIndexCachedOperation.CacheOperation cacheOperation = mock(SolrIndexCachedOperation.CacheOperation.class);
    doThrow(new IllegalStateException("ThreadLocalManager.notify.orphans")).when(cacheOperation).execute();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.performCachedOperation(cacheOperation));
    verify(cacheOperation).execute();
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>When {@link CacheOperation} {@link CacheOperation#execute()} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation_whenCacheOperationExecuteDoesNothing() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    SolrIndexCachedOperation.CacheOperation cacheOperation = mock(SolrIndexCachedOperation.CacheOperation.class);
    doNothing().when(cacheOperation).execute();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.performCachedOperation(cacheOperation);

    // Assert
    verify(cacheOperation).execute();
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundOperationExecutor()}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundOperationExecutor()}
   */
  @Test
  public void testCreateBackgroundOperationExecutor() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ThreadPoolTaskExecutor actualCreateBackgroundOperationExecutorResult = (new CatalogSolrIndexUpdateCommandHandlerImpl())
        .createBackgroundOperationExecutor();

    // Assert
    assertEquals("catalog-solr-reindex-worker-", actualCreateBackgroundOperationExecutorResult.getThreadNamePrefix());
    ThreadPoolExecutor threadPoolExecutor = actualCreateBackgroundOperationExecutorResult.getThreadPoolExecutor();
    assertEquals(0, threadPoolExecutor.getActiveCount());
    assertEquals(0, threadPoolExecutor.getLargestPoolSize());
    assertEquals(0, threadPoolExecutor.getPoolSize());
    assertEquals(0, actualCreateBackgroundOperationExecutorResult.getActiveCount());
    assertEquals(0, actualCreateBackgroundOperationExecutorResult.getPoolSize());
    assertEquals(0, actualCreateBackgroundOperationExecutorResult.getQueueSize());
    assertEquals(0L, threadPoolExecutor.getCompletedTaskCount());
    assertEquals(0L, threadPoolExecutor.getTaskCount());
    assertEquals(10, threadPoolExecutor.getCorePoolSize());
    assertEquals(10, threadPoolExecutor.getMaximumPoolSize());
    assertEquals(10, actualCreateBackgroundOperationExecutorResult.getCorePoolSize());
    assertEquals(10, actualCreateBackgroundOperationExecutorResult.getMaxPoolSize());
    assertEquals(5, actualCreateBackgroundOperationExecutorResult.getThreadPriority());
    assertEquals(60, actualCreateBackgroundOperationExecutorResult.getKeepAliveSeconds());
    assertFalse(actualCreateBackgroundOperationExecutorResult.isDaemon());
    assertTrue(threadPoolExecutor.getQueue().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualCreateBackgroundOperationExecutorResult.getQueueCapacity());
    assertSame(actualCreateBackgroundOperationExecutorResult, threadPoolExecutor.getThreadFactory());
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}
   */
  @Test
  public void testCreateBackgroundRunnable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    ArrayList<Long> ids = new ArrayList<>();
    Semaphore sem = new Semaphore(1);

    // Act and Assert
    assertEquals("blPU",
        catalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(holder, ids, sem, 1L, 1L, new SandBoxImpl())
            .getEntityManagerName());
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)}
   */
  @Test
  public void testGetIncrementalIndexOperation() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertNull(
        catalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(holder, catalog, site, new ArrayList<>())
            .execute());
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  public void testBuildPage() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertTrue(catalogSolrIndexUpdateCommandHandlerImpl
        .buildPage(productIds, products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true))
        .isEmpty());
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}
   */
  @Test
  public void testReadProductsByIds_whenArrayList() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Act and Assert
    assertNull(catalogSolrIndexUpdateCommandHandlerImpl.readProductsByIds(holder, new ArrayList<>()));
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}
   */
  @Test
  public void testReadProductsByIds_whenNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act and Assert
    assertNull(catalogSolrIndexUpdateCommandHandlerImpl
        .readProductsByIds(ReindexStateHolder.getInstance("Collection Name", true, true), null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#afterBackgroundThread(ReindexStateHolder, Catalog, Site, SandBox)}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#afterProcess(ReindexStateHolder)}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#afterReadIdBatch(ReindexStateHolder, Long, int, Long)}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#afterReadProducts(ReindexStateHolder, List)}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeBackgroundThread(ReindexStateHolder, Catalog, Site, SandBox)}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#beforePage(List, List, List, List, ReindexStateHolder)}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeProcess(ReindexStateHolder)}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeReadIdBatch(ReindexStateHolder, Long, int, Long)}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeReadProducts(ReindexStateHolder, List)}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getBackgroundOperationExecutor()}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalCommitInterval()}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#getSolrConfiguration()}
   *   <li>
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getThreadsForBackgroundExecution()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws IllegalStateException, ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.afterBackgroundThread(holder, catalog, site, new SandBoxImpl());
    catalogSolrIndexUpdateCommandHandlerImpl
        .afterProcess(ReindexStateHolder.getInstance("Collection Name", true, true));
    catalogSolrIndexUpdateCommandHandlerImpl
        .afterReadIdBatch(ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 3, 1L);
    ReindexStateHolder holder2 = ReindexStateHolder.getInstance("Collection Name", true, true);
    catalogSolrIndexUpdateCommandHandlerImpl.afterReadProducts(holder2, new ArrayList<>());
    ReindexStateHolder holder3 = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog2 = new CatalogImpl();
    SiteImpl site2 = new SiteImpl();
    catalogSolrIndexUpdateCommandHandlerImpl.beforeBackgroundThread(holder3, catalog2, site2, new SandBoxImpl());
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();
    catalogSolrIndexUpdateCommandHandlerImpl.beforePage(productIds, products, locales, fields,
        ReindexStateHolder.getInstance("Collection Name", true, true));
    catalogSolrIndexUpdateCommandHandlerImpl
        .beforeProcess(ReindexStateHolder.getInstance("Collection Name", true, true));
    catalogSolrIndexUpdateCommandHandlerImpl
        .beforeReadIdBatch(ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 3, 1L);
    ReindexStateHolder holder4 = ReindexStateHolder.getInstance("Collection Name", true, true);
    catalogSolrIndexUpdateCommandHandlerImpl.beforeReadProducts(holder4, new ArrayList<>());
    ThreadPoolTaskExecutor actualBackgroundOperationExecutor = catalogSolrIndexUpdateCommandHandlerImpl
        .getBackgroundOperationExecutor();
    long actualIncrementalCommitInterval = catalogSolrIndexUpdateCommandHandlerImpl.getIncrementalCommitInterval();
    catalogSolrIndexUpdateCommandHandlerImpl.getSolrConfiguration();
    int actualThreadsForBackgroundExecution = catalogSolrIndexUpdateCommandHandlerImpl
        .getThreadsForBackgroundExecution();

    // Assert that nothing has changed
    assertEquals("catalog-solr-reindex-worker-", actualBackgroundOperationExecutor.getThreadNamePrefix());
    ThreadPoolExecutor threadPoolExecutor = actualBackgroundOperationExecutor.getThreadPoolExecutor();
    assertEquals(0, threadPoolExecutor.getActiveCount());
    assertEquals(0, threadPoolExecutor.getLargestPoolSize());
    assertEquals(0, threadPoolExecutor.getPoolSize());
    assertEquals(0, actualBackgroundOperationExecutor.getActiveCount());
    assertEquals(0, actualBackgroundOperationExecutor.getPoolSize());
    assertEquals(0, actualBackgroundOperationExecutor.getQueueSize());
    assertEquals(0L, threadPoolExecutor.getCompletedTaskCount());
    assertEquals(0L, threadPoolExecutor.getTaskCount());
    assertEquals(10, threadPoolExecutor.getCorePoolSize());
    assertEquals(10, threadPoolExecutor.getMaximumPoolSize());
    assertEquals(10, actualThreadsForBackgroundExecution);
    assertEquals(10, actualBackgroundOperationExecutor.getCorePoolSize());
    assertEquals(10, actualBackgroundOperationExecutor.getMaxPoolSize());
    assertEquals(30000L, actualIncrementalCommitInterval);
    assertEquals(5, actualBackgroundOperationExecutor.getThreadPriority());
    assertEquals(60, actualBackgroundOperationExecutor.getKeepAliveSeconds());
    assertFalse(actualBackgroundOperationExecutor.isDaemon());
    assertEquals(Integer.MAX_VALUE, actualBackgroundOperationExecutor.getQueueCapacity());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#findCatalog(Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#findCatalog(Long)}
   */
  @Test
  public void testFindCatalog_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CatalogSolrIndexUpdateCommandHandlerImpl()).findCatalog(null));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#findSite(Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#findSite(Long)}
   */
  @Test
  public void testFindSite_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CatalogSolrIndexUpdateCommandHandlerImpl()).findSite(null));
  }
}
