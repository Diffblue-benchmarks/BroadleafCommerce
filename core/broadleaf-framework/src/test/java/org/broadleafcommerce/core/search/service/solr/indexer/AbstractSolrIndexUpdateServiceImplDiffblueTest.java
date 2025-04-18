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

import java.util.ArrayList;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
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
public class AbstractSolrIndexUpdateServiceImplDiffblueTest {
  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDestroy2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2561 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCommandGroup3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2576 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
        .getCommandGroup();
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#scheduleCommand(SolrUpdateCommand)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#scheduleCommand(SolrUpdateCommand)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testScheduleCommand2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2621 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
        .scheduleCommand(FullReindexCommand.DEFAULT_INSTANCE);
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)} with
   * {@code documents}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateIndexWithDocuments4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2650 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    // Act
    catalogSolrIndexUpdateServiceImpl.updateIndex(new ArrayList<>());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)} with
   * {@code documents}, {@code deleteQueries}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateIndexWithDocumentsDeleteQueries4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2669 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());
    ArrayList<SolrInputDocument> documents = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateServiceImpl.updateIndex(documents, new ArrayList<>());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable)} with
   * {@code indexable}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable)}
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
    //   public class DiffblueFakeClass2501 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    // Act
    catalogSolrIndexUpdateServiceImpl.buildDocument(new ProductBundleImpl());
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
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
    //   public class DiffblueFakeClass2531 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields, new ArrayList<>());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQueuePollTime3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2606 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
        .getQueuePollTime();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQueueOfferTime3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2591 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
        .getQueueOfferTime();
  }
}
