package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.exception.ServiceException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractSolrIndexUpdateCommandHandlerImplDiffblueTest {
  @Autowired
  private AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#getCommandGroup()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#getCommandGroup()}
   */
  @Test
  public void testGetCommandGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("catalog", (new CatalogSolrIndexUpdateCommandHandlerImpl()).getCommandGroup());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#getCommandGroup()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#getCommandGroup()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCommandGroup2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2142 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).getCommandGroup();
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   * with {@code command}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteCommandInternalWithCommand() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2088 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<SolrInputDocument> docs = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl
        .executeCommandInternal(new IncrementalUpdateCommand(docs, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)}
   * with {@code command}, {@code collectionName}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternal(IncrementalUpdateCommand, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteCommandInternalWithCommandCollectionName() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2102 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<SolrInputDocument> docs = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl
        .executeCommandInternal(new IncrementalUpdateCommand(docs, new ArrayList<>()), "Collection Name");
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternalNoDefaultCommandType(SolrUpdateCommand)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#executeCommandInternalNoDefaultCommandType(SolrUpdateCommand)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteCommandInternalNoDefaultCommandType() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2120 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl())
        .executeCommandInternalNoDefaultCommandType(FullReindexCommand.DEFAULT_INSTANCE);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#commit(String, boolean, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#commit(String, boolean, boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommit() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2041 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).commit("Collection Name", true, true, true);
  }

  /**
   * Test {@link AbstractSolrIndexUpdateCommandHandlerImpl#rollback(String)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#rollback(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRollback() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2150 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).rollback("Collection Name");
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#addDocument(String, SolrInputDocument)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#addDocument(String, SolrInputDocument)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddDocument() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2020 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).addDocument("Collection", null);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#addDocuments(String, List)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#addDocuments(String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddDocuments() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2029 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.addDocuments("Collection", new ArrayList<>());
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByQuery(String, String)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByQuery(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteByQuery() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2076 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).deleteByQuery("Collection", "Query");
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByQueries(String, List)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByQueries(String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteByQueries() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2064 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.deleteByQueries("Collection", new ArrayList<>());
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByIds(String, List)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#deleteByIds(String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteByIds() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2052 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.deleteByIds("Collection", new ArrayList<>());
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#getForegroundCollectionName()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#getForegroundCollectionName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetForegroundCollectionName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2146 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).getForegroundCollectionName();
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#getBackgroundCollectionName()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateCommandHandlerImpl#getBackgroundCollectionName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetBackgroundCollectionName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2138 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.AbstractSolrIndexUpdateCommandHandlerImpl abstractSolrIndexUpdateCommandHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogSolrIndexUpdateCommandHandlerImpl()).getBackgroundCollectionName();
  }
}
