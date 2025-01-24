package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import org.apache.http.impl.client.AutoRetryHttpClient;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.SSLConfig;
import org.apache.solr.client.solrj.impl.BinaryResponseParser;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.common.web.DeployBehavior;
import org.broadleafcommerce.common.web.DeployState;
import org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState;
import org.broadleafcommerce.common.web.ValidateProductionChangesState;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.dao.CatalogStructure;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient;
import org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SolrIndexServiceImplDiffblueTest {
  @Autowired
  private SolrIndexServiceImpl solrIndexServiceImpl;

  /**
   * Test {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPerformCachedOperation() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1848 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).performCachedOperation(mock(SolrIndexCachedOperation.CacheOperation.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation_thenThrowIllegalStateException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    SolrIndexCachedOperation.CacheOperation cacheOperation = mock(SolrIndexCachedOperation.CacheOperation.class);
    doThrow(new IllegalStateException("ThreadLocalManager.notify.orphans")).when(cacheOperation).execute();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.performCachedOperation(cacheOperation));
    verify(cacheOperation).execute();
  }

  /**
   * Test {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>When {@link CacheOperation} {@link CacheOperation#execute()} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation_whenCacheOperationExecuteDoesNothing() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    SolrIndexCachedOperation.CacheOperation cacheOperation = mock(SolrIndexCachedOperation.CacheOperation.class);
    doNothing().when(cacheOperation).execute();

    // Act
    solrIndexServiceImpl.performCachedOperation(cacheOperation);

    // Assert
    verify(cacheOperation).execute();
  }

  /**
   * Test {@link SolrIndexServiceImpl#rebuildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#rebuildIndex()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRebuildIndex() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1874 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).rebuildIndex();
  }

  /**
   * Test {@link SolrIndexServiceImpl#preBuildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#preBuildIndex()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPreBuildIndex() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1852 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).preBuildIndex();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIndex()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildIndex() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1361 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).buildIndex();
  }

  /**
   * Test {@link SolrIndexServiceImpl#postBuildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#postBuildIndex()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPostBuildIndex() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1850 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).postBuildIndex();
  }

  /**
   * Test {@link SolrIndexServiceImpl#getReindexOperation()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getReindexOperation()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetReindexOperation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1743 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).getReindexOperation();
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteSolrIndexOperation() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1709 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).executeSolrIndexOperation(mock(SolrIndexOperation.class));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}
   */
  @Test
  public void testExecuteSolrIndexOperation_thenThrowRuntimeException() throws IOException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    when(operation.obtainLock()).thenThrow(new RuntimeException("Executing Indexing operation"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> solrIndexServiceImpl.executeSolrIndexOperation(operation));
    verify(operation).obtainLock();
  }

  /**
   * Test {@link SolrIndexServiceImpl#getTotalPageCount(Long)}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getTotalPageCount(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTotalPageCount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1745 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).getTotalPageCount(3L);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildPageNumberMessage(int, Long)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildPageNumberMessage(int, Long)}
   */
  @Test
  public void testBuildPageNumberMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Building page number 1 of 1", (new SolrIndexServiceImpl()).buildPageNumberMessage(1, 1L));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildPageNumberMessage(int, Long)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildPageNumberMessage(int, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPageNumberMessage2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1363 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).buildPageNumberMessage(1, 1L);
  }

  /**
   * Test {@link SolrIndexServiceImpl#countIndexableItems()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#countIndexableItems()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountIndexableItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1553 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).countIndexableItems();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAllDocuments() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1555 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).deleteAllDocuments();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with
   * {@code collection}, {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithCollectionServer() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Http2SolrClient.Builder connectionTimeoutResult = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult2 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult3 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult4 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Http2SolrClient.Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.deleteAllDocuments("Collection",
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with
   * {@code collection}, {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithCollectionServer2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> solrIndexServiceImpl.deleteAllDocuments("Collection", new DelegatingHttpSolrClient(delegate)));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with
   * {@code collection}, {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAllDocumentsWithCollectionServer3() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1557 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.deleteAllDocuments("Collection", new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with
   * {@code collection}, {@code server}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#commit(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithCollectionServer_givenUpdateResponse_thenCallsCommit()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(server.deleteByQuery(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.deleteAllDocuments("Collection", server);

    // Assert
    verify(server).commit(eq("Collection"));
    verify(server).deleteByQuery(eq("Collection"), eq("*:*"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with
   * {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithServer() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Http2SolrClient.Builder connectionTimeoutResult = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult2 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult3 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult4 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Http2SolrClient.Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl
        .deleteAllDocuments(new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with
   * {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithServer2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> solrIndexServiceImpl.deleteAllDocuments(new DelegatingHttpSolrClient(delegate)));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with
   * {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAllDocumentsWithServer3() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1587 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.deleteAllDocuments(new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with
   * {@code server}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#commit(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithServer_givenUpdateResponse_thenCallsCommit()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(server.deleteByQuery(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.deleteAllDocuments(server);

    // Assert
    verify(server).commit(isNull());
    verify(server).deleteByQuery((String) isNull(), eq("*:*"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#useLegacyIndexer()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#useLegacyIndexer()}
   */
  @Test
  public void testUseLegacyIndexer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SolrIndexServiceImpl()).useLegacyIndexer());
  }

  /**
   * Test {@link SolrIndexServiceImpl#useLegacyIndexer()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#useLegacyIndexer()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUseLegacyIndexer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1908 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).useLegacyIndexer();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAllReindexCoreDocuments() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1677 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).deleteAllReindexCoreDocuments();
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(String, SolrClient)}
   * with {@code collection}, {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(String, SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAllNamespaceDocumentsWithCollectionServer() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1617 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.deleteAllNamespaceDocuments("Collection", new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(SolrClient)}
   * with {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAllNamespaceDocumentsWithServer() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1647 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.deleteAllNamespaceDocuments(new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)}
   * with {@code collection}, {@code indexables}, {@code solrServer}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1301 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();
    ArrayList<Indexable> indexables = new ArrayList<>();

    // Act
    solrIndexServiceImpl2.buildIncrementalIndex("Collection", indexables, new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   * with {@code indexables}, {@code solrServer}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildIncrementalIndexWithIndexablesSolrServer() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1331 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();
    ArrayList<Indexable> indexables = new ArrayList<>();

    // Act
    solrIndexServiceImpl2.buildIncrementalIndex(indexables, new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)}
   * with {@code pageSize}, {@code lastId}, {@code operation}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1281 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).buildIncrementalIndex(3, 1L, mock(SolrIndexOperation.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveIndexables() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1854 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).readAllActiveIndexables(3, 1L);
  }

  /**
   * Test {@link SolrIndexServiceImpl#getAllLocales()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getAllLocales()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllLocales() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1711 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).getAllLocales();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildDocument() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1221 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    solrIndexServiceImpl2.buildDocument(indexable, fields, new ArrayList<>());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Indexable indexable = mock(Indexable.class);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Indexable indexable = mock(Indexable.class);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Indexable indexable = mock(Indexable.class);
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildDocument(indexable, fields, locales));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Indexable indexable = mock(Indexable.class);
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildDocument(indexable, fields, locales));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_whenProductBundleImpl_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  public void testAttachIndexableDocumentFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenThrow(new IllegalStateException("Could not get value for property["));
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException("foo"));

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>()));
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachIndexableDocumentFields2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1191 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    solrIndexServiceImpl2.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>());
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <ul>
   *   <li>Then calls {@link FieldImpl#getQualifiedFieldName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  public void testAttachIndexableDocumentFields_thenCallsGetQualifiedFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException("foo"));

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>()));
    verify(fieldImpl).getQualifiedFieldName();
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachAdditionalDocumentFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1131 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.attachAdditionalDocumentFields(new ProductBundleImpl(), null);
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachBasicDocumentFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1161 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.attachBasicDocumentFields(new ProductBundleImpl(), null);
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  public void testAttachBasicDocumentFields_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachBasicDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildFullCategoryHierarchy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1251 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act
    solrIndexServiceImpl2.buildFullCategoryHierarchy(null, cache, 1L, new HashSet<>());
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPropertyValues() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1713 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    solrIndexServiceImpl2.getPropertyValues(indexedItem, field, FieldType.BOOLEAN, new ArrayList<>());
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertToMappedProperty() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1523 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).convertToMappedProperty("Property Name", "List Property Name", "Map Property Name");
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code \.}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenBackslashDot_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("",
        (new SolrIndexServiceImpl()).convertToMappedProperty("\\.", "List Property Name", "Map Property Name"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenEmptyString_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("",
        (new SolrIndexServiceImpl()).convertToMappedProperty("", "List Property Name", "Map Property Name"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code java.lang.Long}.</li>
   *   <li>Then return {@code java.lang.Long}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenJavaLangLong_thenReturnJavaLangLong() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("java.lang.Long", (new SolrIndexServiceImpl()).convertToMappedProperty("java.lang.Long",
        "List Property Name", "Map Property Name"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code java}.</li>
   *   <li>Then return {@code Map Property Name(lang).value.Long}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenJava_thenReturnMapPropertyNameLangValueLong() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Map Property Name(lang).value.Long",
        (new SolrIndexServiceImpl()).convertToMappedProperty("java.lang.Long", "java", "Map Property Name"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code Property Name}.</li>
   *   <li>Then return {@code Property Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenPropertyName_thenReturnPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Property Name", (new SolrIndexServiceImpl()).convertToMappedProperty("Property Name",
        "List Property Name", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#saveState()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#saveState()}
   */
  @Test
  public void testSaveState() throws MissingResourceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Object[] actualSaveStateResult = (new SolrIndexServiceImpl()).saveState();

    // Assert
    Object object = actualSaveStateResult[0];
    assertTrue(object instanceof BroadleafRequestContext);
    java.util.Locale javaLocale = ((BroadleafRequestContext) object).getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = ((BroadleafRequestContext) object).getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(((BroadleafRequestContext) object).getAdminUserId());
    assertNull(((BroadleafRequestContext) object).getSandBoxId());
    assertNull(actualSaveStateResult[1]);
    assertNull(actualSaveStateResult[2]);
    assertNull(actualSaveStateResult[3]);
    assertNull(((BroadleafRequestContext) object).getRequestURIWithoutContext());
    assertNull(((BroadleafRequestContext) object).getTimeZone());
    assertNull(((BroadleafRequestContext) object).getRequest());
    assertNull(((BroadleafRequestContext) object).getResponse());
    assertNull(((BroadleafRequestContext) object).getRequestDTO());
    assertNull(((BroadleafRequestContext) object).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) object).getRequestedBroadleafCurrency());
    assertNull(((BroadleafRequestContext) object).getLocale());
    assertNull(((BroadleafRequestContext) object).getSandBox());
    assertNull(((BroadleafRequestContext) object).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) object).getCurrentProfile());
    assertNull(((BroadleafRequestContext) object).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) object).getSite());
    assertNull(((BroadleafRequestContext) object).getTheme());
    assertNull(((BroadleafRequestContext) object).getMessageSource());
    assertNull(((BroadleafRequestContext) object).getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(4, actualSaveStateResult.length);
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED, ((BroadleafRequestContext) object).getDeployBehavior());
    assertEquals(DeployState.UNDEFINED, ((BroadleafRequestContext) object).getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        ((BroadleafRequestContext) object).getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        ((BroadleafRequestContext) object).getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(((BroadleafRequestContext) object).getAdmin());
    assertFalse(((BroadleafRequestContext) object).getIgnoreSite());
    assertFalse(((BroadleafRequestContext) object).getInternalIgnoreFilters());
    assertFalse(((BroadleafRequestContext) object).getInternalValidateFind());
    assertTrue(((BroadleafRequestContext) object).getExplicitCatalogs().isEmpty());
    assertTrue(((BroadleafRequestContext) object).getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(((BroadleafRequestContext) object).isProductionSandBox());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test {@link SolrIndexServiceImpl#saveState()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#saveState()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveState2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1906 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).saveState();
  }

  /**
   * Test {@link SolrIndexServiceImpl#restoreState(Object[])}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#restoreState(Object[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRestoreState() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1876 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).restoreState(new Object[]{GlobalSolrFullReIndexOperation.LOCK_OBJECT});
  }

  /**
   * Test {@link SolrIndexServiceImpl#optimizeIndex(String, SolrClient)} with
   * {@code collection}, {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#optimizeIndex(String, SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOptimizeIndexWithCollectionServer() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1788 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.optimizeIndex("Collection", new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#optimizeIndex(SolrClient)} with
   * {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#optimizeIndex(SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOptimizeIndexWithServer() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1818 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.optimizeIndex(new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#commit(String, SolrClient)} with
   * {@code collection}, {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#commit(String, SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommitWithCollectionServer() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1373 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.commit("Collection", new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   * with {@code collection}, {@code server}, {@code softCommit},
   * {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush() throws IOException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Http2SolrClient.Builder connectionTimeoutResult = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult2 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult3 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult4 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Http2SolrClient.Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.commit("Collection",
        new LBHttp2SolrClient(httpClient5, "https://example.org/example"), true, true, true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   * with {@code collection}, {@code server}, {@code softCommit},
   * {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush2()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.commit("Collection", server, true, true, true);

    // Assert
    verify(server).commit(eq("Collection"), eq(true), eq(true), eq(true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   * with {@code collection}, {@code server}, {@code softCommit},
   * {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush3()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.commit("Collection", server, true, true, true));
    verify(server).commit(eq("Collection"), eq(true), eq(true), eq(true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   * with {@code collection}, {@code server}, {@code softCommit},
   * {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush4() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1403 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.commit("Collection", new BroadleafCloudSolrClient("localhost"), true, true, true);
  }

  /**
   * Test {@link SolrIndexServiceImpl#commit(SolrClient)} with {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#commit(SolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommitWithServer() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1433 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.commit(new BroadleafCloudSolrClient("localhost"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   * with {@code server}, {@code softCommit}, {@code waitSearcher},
   * {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush() throws IOException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Http2SolrClient.Builder connectionTimeoutResult = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult2 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult3 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult4 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Http2SolrClient.Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl
        .commit(new LBHttp2SolrClient(httpClient5, "https://example.org/example"), true, true, true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   * with {@code server}, {@code softCommit}, {@code waitSearcher},
   * {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush2()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.commit(server, true, true, true));
    verify(server).commit(isNull(), eq(true), eq(true), eq(true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   * with {@code server}, {@code softCommit}, {@code waitSearcher},
   * {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush3() throws IOException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1463 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.commit(new BroadleafCloudSolrClient("localhost"), true, true, true);
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   * with {@code server}, {@code softCommit}, {@code waitSearcher},
   * {@code waitFlush}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush_givenUpdateResponse()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.commit(server, true, true, true);

    // Assert
    verify(server).commit(isNull(), eq(true), eq(true), eq(true));
  }

  /**
   * Test {@link SolrIndexServiceImpl#logDocuments(Collection)}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#logDocuments(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLogDocuments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1782 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.logDocuments(new ArrayList<>());
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  public void testConvertDisplayOrderToLong() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertNull(solrIndexServiceImpl.convertDisplayOrderToLong(cache, "Display Order Key"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertDisplayOrderToLong2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1493 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act
    solrIndexServiceImpl2.convertDisplayOrderToLong(cache, "Display Order Key");
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   * <ul>
   *   <li>Then calls
   * {@link CatalogStructure#getDisplayOrdersByCategoryProduct()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  public void testConvertDisplayOrderToLong_thenCallsGetDisplayOrdersByCategoryProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    CatalogStructure cache = mock(CatalogStructure.class);
    when(cache.getDisplayOrdersByCategoryProduct()).thenReturn(new HashMap<>());
    doNothing().when(cache).setDisplayOrdersByCategoryProduct(Mockito.<Map<String, BigDecimal>>any());
    doNothing().when(cache).setParentCategoriesByCategory(Mockito.<Map<Long, Set<Long>>>any());
    doNothing().when(cache).setParentCategoriesByProduct(Mockito.<Map<Long, Set<Long>>>any());
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act
    Long actualConvertDisplayOrderToLongResult = solrIndexServiceImpl.convertDisplayOrderToLong(cache,
        "Display Order Key");

    // Assert
    verify(cache).getDisplayOrdersByCategoryProduct();
    verify(cache).setDisplayOrdersByCategoryProduct(isA(Map.class));
    verify(cache).setParentCategoriesByCategory(isA(Map.class));
    verify(cache).setParentCategoriesByProduct(isA(Map.class));
    assertNull(actualConvertDisplayOrderToLongResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteByQuery(String)}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteByQuery(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteByQuery() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1679 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).deleteByQuery("Delete Query");
  }

  /**
   * Test {@link SolrIndexServiceImpl#addDocuments(Collection)}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#addDocuments(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddDocuments() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1125 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl2 = new SolrIndexServiceImpl();

    // Act
    solrIndexServiceImpl2.addDocuments(new ArrayList<>());
  }

  /**
   * Test {@link SolrIndexServiceImpl#logDeleteQuery(String)}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#logDeleteQuery(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLogDeleteQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1752 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceImpl solrIndexServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexServiceImpl()).logDeleteQuery("Delete Query");
  }
}
