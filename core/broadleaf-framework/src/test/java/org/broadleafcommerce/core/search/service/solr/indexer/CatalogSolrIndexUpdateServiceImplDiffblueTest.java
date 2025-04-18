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

import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogSolrIndexUpdateServiceImplDiffblueTest {
  /**
   * Test {@link CatalogSolrIndexUpdateServiceImpl#rebuildIndex()}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateServiceImpl#rebuildIndex()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRebuildIndex() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3429 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
        .rebuildIndex();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateServiceImpl#rebuildIndex(Catalog)} with
   * {@code catalog}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateServiceImpl#rebuildIndex(Catalog)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRebuildIndexWithCatalog() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3444 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl2 = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    // Act
    catalogSolrIndexUpdateServiceImpl2.rebuildIndex(new CatalogImpl());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateServiceImpl#rebuildIndex(Site)} with
   * {@code site}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateServiceImpl#rebuildIndex(Site)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRebuildIndexWithSite() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3468 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl2 = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    // Act
    catalogSolrIndexUpdateServiceImpl2.rebuildIndex(new SiteImpl());
  }

  /**
   * Test
   * {@link CatalogSolrIndexUpdateServiceImpl#performCachedOperation(CacheOperation)}.
   * <p>
   * Method under test:
   * {@link CatalogSolrIndexUpdateServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
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
    //   public class DiffblueFakeClass3414 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
        .performCachedOperation(mock(CacheOperation.class));
  }
}
