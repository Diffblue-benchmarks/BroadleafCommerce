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
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogSolrIndexUpdateCommandHandlerImplDiffblueTest {
  @Autowired
  private CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;

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
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCommand(SolrUpdateCommand)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCommand(SolrUpdateCommand)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteCommand2() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3127 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).executeCommand(FullReindexCommand.DEFAULT_INSTANCE);
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)}
   * with {@code indexable}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildDocumentWithIndexable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2932 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.buildDocument(new ProductBundleImpl());
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildDocumentWithIndexableFieldsLocales() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2962 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.buildDocument(indexable, fields, new ArrayList<>());
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteFullReindexCommand() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3145 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).executeFullReindexCommand(FullReindexCommand.DEFAULT_INSTANCE);
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
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCatalogReindexCommand(CatalogReindexCommand)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCatalogReindexCommand(CatalogReindexCommand)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteCatalogReindexCommand2() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3107 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.executeCatalogReindexCommand(new CatalogReindexCommand(1L));
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
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeSiteReindexCommand(SiteReindexCommand)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeSiteReindexCommand(SiteReindexCommand)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteSiteReindexCommand2() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3152 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.executeSiteReindexCommand(new SiteReindexCommand(1L));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#getAllLocales()}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getAllLocales()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllLocales() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3232 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).getAllLocales();
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(CacheOperation)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPerformCachedOperation() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3328 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl())
        .performCachedOperation(mock(SolrIndexCachedOperation.CacheOperation.class));
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
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long, Long, SandBox)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long, Long, SandBox)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateIndex() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3332 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.populateIndex(holder, 1L, 1L, new SandBoxImpl());
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getReadIdsOperation(ReindexStateHolder, Long, Long, Integer, Long)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getReadIdsOperation(ReindexStateHolder, Long, Long, Integer, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetReadIdsOperation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3270 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2
        .getReadIdsOperation(ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 1L, 3, 1L);
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAllDocuments() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3086 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).deleteAllDocuments("Collection", true);
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFinalizeChanges() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3172 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).finalizeChanges("Collection", true, true);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSwapCollections() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3410 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).swapCollections();
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
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundOperationExecutor()}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundOperationExecutor()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateBackgroundOperationExecutor2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3052 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).createBackgroundOperationExecutor();
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
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateBackgroundRunnable2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3056 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    ArrayList<Long> ids = new ArrayList<>();
    Semaphore sem = new Semaphore(1);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.createBackgroundRunnable(holder, ids, sem, 1L, 1L, new SandBoxImpl());
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
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIncrementalIndexOperation2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3236 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.getIncrementalIndexOperation(holder, catalog, site, new ArrayList<>());
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
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPage2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3022 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.buildPage(productIds, products, locales, fields,
        ReindexStateHolder.getInstance("Collection Name", true, true));
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductsByIds() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3392 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.readProductsByIds(holder, new ArrayList<>());
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
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIndexFields()}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIndexFields()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIndexFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3266 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).getIndexFields();
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildIncrementalIndex() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2992 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.buildIncrementalIndex(productIds, products, holder, catalog,
        new SiteImpl());
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#readIdBatch(ReindexStateHolder, Long, int, Long)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#readIdBatch(ReindexStateHolder, Long, int, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadIdBatch() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3362 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.readIdBatch(ReindexStateHolder.getInstance("Collection Name", true, true),
        1L, 3, 1L);
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
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#afterPage(List, List, List, List, ReindexStateHolder)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#afterPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAfterPage() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2902 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2.afterPage(productIds, products, locales, fields,
        ReindexStateHolder.getInstance("Collection Name", true, true));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#findCatalog(Long)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#findCatalog(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCatalog() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3194 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).findCatalog(1L);
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
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#findSite(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSite() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3213 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).findSite(1L);
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

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#incrementalCommit(ReindexStateHolder)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#incrementalCommit(ReindexStateHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIncrementalCommit() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3300 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2
        .incrementalCommit(ReindexStateHolder.getInstance("Collection Name", true, true));
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}
   */
  @Test
  public void testIsReindexSuccessful() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act and Assert
    assertFalse(catalogSolrIndexUpdateCommandHandlerImpl
        .isReindexSuccessful(ReindexStateHolder.getInstance("Collection Name", true, true)));
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsReindexSuccessful2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3314 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl2 = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl2
        .isReindexSuccessful(ReindexStateHolder.getInstance("Collection Name", true, true));
  }
}
