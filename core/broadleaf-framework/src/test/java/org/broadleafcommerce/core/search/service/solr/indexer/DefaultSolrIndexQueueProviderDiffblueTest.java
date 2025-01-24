package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext.xml",
    "/bl-framework-applicationContext-entity.xml", "/bl-framework-applicationContext-persistence.xml",
    "/bl-framework-applicationContext-workflow.xml",
    "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultSolrIndexQueueProviderDiffblueTest {
  @Autowired
  private DefaultSolrIndexQueueProvider defaultSolrIndexQueueProvider;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider()}
   *   <li>{@link DefaultSolrIndexQueueProvider#getEnvironment()}
   *   <li>{@link DefaultSolrIndexQueueProvider#getZookeeper()}
   *   <li>{@link DefaultSolrIndexQueueProvider#isDistributed()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider();
    Environment actualEnvironment = actualDefaultSolrIndexQueueProvider.getEnvironment();
    ZooKeeper actualZookeeper = actualDefaultSolrIndexQueueProvider.getZookeeper();

    // Assert
    assertNull(actualZookeeper);
    assertNull(actualEnvironment);
    assertFalse(actualDefaultSolrIndexQueueProvider.isDistributed());
  }

  /**
   * Test
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}.
   * <p>
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewDefaultSolrIndexQueueProvider() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3496 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.DefaultSolrIndexQueueProvider defaultSolrIndexQueueProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafCloudSolrClient solrClient = new BroadleafCloudSolrClient("localhost");

    // Act
    new DefaultSolrIndexQueueProvider(solrClient, new StandardReactiveWebEnvironment());

  }

  /**
   * Test
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}.
   * <p>
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}
   */
  @Test
  public void testNewDefaultSolrIndexQueueProvider2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("42", 10, mock(Watcher.class));

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        null);

    // Assert
    assertNull(actualDefaultSolrIndexQueueProvider.getEnvironment());
    assertTrue(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(zookeeper, actualDefaultSolrIndexQueueProvider.getZookeeper());
  }

  /**
   * Test
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}.
   * <p>
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}
   */
  @Test
  public void testNewDefaultSolrIndexQueueProvider3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("42", 10, null);

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        null);

    // Assert
    assertNull(actualDefaultSolrIndexQueueProvider.getEnvironment());
    assertTrue(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(zookeeper, actualDefaultSolrIndexQueueProvider.getZookeeper());
  }

  /**
   * Test
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}.
   * <p>
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewDefaultSolrIndexQueueProvider4() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3526 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.DefaultSolrIndexQueueProvider defaultSolrIndexQueueProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    // Act
    new DefaultSolrIndexQueueProvider(zookeeper, new StandardReactiveWebEnvironment());

  }

  /**
   * Test
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}.
   * <ul>
   *   <li>Given {@code Scheme}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}
   */
  @Test
  public void testNewDefaultSolrIndexQueueProvider_givenScheme() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("42", 10, null);
    zookeeper.addAuthInfo("Scheme", new byte[]{'A', 1, 'A', Byte.MIN_VALUE, 'A', 1, 'A', 1});

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        null);

    // Assert
    assertNull(actualDefaultSolrIndexQueueProvider.getEnvironment());
    assertTrue(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(zookeeper, actualDefaultSolrIndexQueueProvider.getZookeeper());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createDistributedQueue(String)}.
   * <p>
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#createDistributedQueue(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDistributedQueue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3586 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.DefaultSolrIndexQueueProvider defaultSolrIndexQueueProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    defaultSolrIndexQueueProvider.createDistributedQueue("Queue Name");
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createDistributedLock(String)}.
   * <p>
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#createDistributedLock(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDistributedLock() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3556 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.DefaultSolrIndexQueueProvider defaultSolrIndexQueueProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    defaultSolrIndexQueueProvider.createDistributedLock("Lock Name");
  }
}
