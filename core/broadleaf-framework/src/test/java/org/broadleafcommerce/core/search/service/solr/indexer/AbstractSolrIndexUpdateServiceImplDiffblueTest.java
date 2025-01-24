package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.cloud.SolrZooKeeper;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractSolrIndexUpdateServiceImplDiffblueTest {
  @Autowired
  private AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;

  @MockBean
  private SolrIndexQueueProvider solrIndexQueueProvider;

  @MockBean
  private SolrIndexUpdateCommandHandler solrIndexUpdateCommandHandler;

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{Byte.MAX_VALUE, Byte.MIN_VALUE, 3, 1, 'A', 1, 'A', 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

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
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@code `}.</li>
   *   <li>Then calls {@link ZooKeeper#addAuthInfo(String, byte[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenBacktick_thenCallsAddAuthInfo() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{Byte.MAX_VALUE, 1, 3, '`', 'A', 1, 'A', 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@link SolrZooKeeper} addAuthInfo {@code Scheme} and array of
   * {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenSolrZooKeeperAddAuthInfoSchemeAndArrayOfByteWithAAndOne() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@link SolrZooKeeper} addAuthInfo {@code Scheme} and array of
   * {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenSolrZooKeeperAddAuthInfoSchemeAndArrayOfByteWithAAndOne2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{'A', 1, 'A', 1, 'A', Byte.MIN_VALUE, 'A', 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@link SolrZooKeeper} addAuthInfo {@code Scheme} and array of
   * {@code byte} with {@link Byte#MAX_VALUE} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenSolrZooKeeperAddAuthInfoSchemeAndArrayOfByteWithMax_valueAndOne() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{Byte.MAX_VALUE, 1, 'A', 1, 'A', 1, 'A', 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@link SolrZooKeeper} addAuthInfo {@code Scheme} and array of
   * {@code byte} with {@link Byte#MAX_VALUE} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenSolrZooKeeperAddAuthInfoSchemeAndArrayOfByteWithMax_valueAndOne2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{Byte.MAX_VALUE, 1, 3, 1, 'A', 1, 'A', 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@link SolrZooKeeper} addAuthInfo {@code Scheme} and array of
   * {@code byte} with {@link Byte#MAX_VALUE} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenSolrZooKeeperAddAuthInfoSchemeAndArrayOfByteWithMax_valueAndOne3() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{Byte.MAX_VALUE, 1, 'A', -1, 'A', 1, 'A', 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@link SolrZooKeeper} addAuthInfo {@code Scheme} and array of
   * {@code byte} with {@link Byte#MAX_VALUE} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenSolrZooKeeperAddAuthInfoSchemeAndArrayOfByteWithMax_valueAndOne4() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{Byte.MAX_VALUE, 1, 'A', Byte.MAX_VALUE, 'A', 1, 'A', 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@link SolrZooKeeper} addAuthInfo {@code Scheme} and array of
   * {@code byte} with {@link Byte#MAX_VALUE} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenSolrZooKeeperAddAuthInfoSchemeAndArrayOfByteWithMax_valueAndOne5() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{Byte.MAX_VALUE, 1, 'A', 1, 'A', 1, Byte.MAX_VALUE, 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@link SolrZooKeeper} addAuthInfo {@code Scheme} and array of
   * {@code byte} with {@link Byte#MAX_VALUE} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenSolrZooKeeperAddAuthInfoSchemeAndArrayOfByteWithMax_valueAndOne6() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{Byte.MAX_VALUE, 1, 3, 1, Byte.MAX_VALUE, 1, 'A', 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#destroy()}.
   * <ul>
   *   <li>Given {@link SolrZooKeeper} addAuthInfo {@code Scheme} and array of
   * {@code byte} with {@link Byte#MAX_VALUE} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#destroy()}
   */
  @Test
  public void testDestroy_givenSolrZooKeeperAddAuthInfoSchemeAndArrayOfByteWithMax_valueAndOne7() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrZooKeeper zookeeper = mock(SolrZooKeeper.class);
    doNothing().when(zookeeper).addAuthInfo(Mockito.<String>any(), Mockito.<byte[]>any());
    zookeeper.addAuthInfo("Scheme", new byte[]{Byte.MAX_VALUE, 1, 3, 1, 'A', 1, Byte.MAX_VALUE, 1});
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act
    (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl())).destroy();

    // Assert
    verify(zookeeper).addAuthInfo(eq("Scheme"), isA(byte[].class));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#shutdownAll()}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#shutdownAll()}
   */
  @Test
  public void testShutdownAll() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    AbstractSolrIndexUpdateServiceImpl.shutdownAll();
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}
   */
  @Test
  public void testGetCommandGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertEquals("catalog",
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getCommandGroup());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}
   */
  @Test
  public void testGetCommandGroup2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertEquals("catalog",
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getCommandGroup());
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
  public void testScheduleCommand() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .scheduleCommand(FullReindexCommand.DEFAULT_INSTANCE));
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
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#scheduleCommand(SolrUpdateCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#scheduleCommand(SolrUpdateCommand)}
   */
  @Test
  public void testScheduleCommand_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .scheduleCommand(FullReindexCommand.DEFAULT_INSTANCE));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#isRunning(String)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#isRunning(String)}
   */
  @Test
  public void testIsRunning() {
    // Arrange, Act and Assert
    assertFalse(AbstractSolrIndexUpdateServiceImpl.isRunning("42"));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#rebuildIndex()}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#rebuildIndex()}
   */
  @Test
  public void testRebuildIndex() throws ServiceException {
    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .rebuildIndex());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#rebuildIndex()}.
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#rebuildIndex()}
   */
  @Test
  public void testRebuildIndex2() throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = new CatalogSolrIndexUpdateCommandHandlerImpl();
    commandHandler.addDocuments("Collection", new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new CatalogSolrIndexUpdateServiceImpl(new DefaultSolrIndexQueueProvider(), commandHandler))
            .rebuildIndex());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#rebuildIndex()}.
   * <ul>
   *   <li>Given {@link ZooKeeper#ZooKeeper(String, int, Watcher)} with
   * {@code Connect String} and sessionTimeout is ten and {@link Watcher}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexUpdateServiceImpl#rebuildIndex()}
   */
  @Test
  public void testRebuildIndex_givenZooKeeperWithConnectStringAndSessionTimeoutIsTenAndWatcher()
      throws IOException, ServiceException {
    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .rebuildIndex());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)} with
   * {@code documents}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)}
   */
  @Test
  public void testUpdateIndexWithDocuments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> catalogSolrIndexUpdateServiceImpl.updateIndex(new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)} with
   * {@code documents}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)}
   */
  @Test
  public void testUpdateIndexWithDocuments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexQueueProvider queueProvider = mock(SolrIndexQueueProvider.class);
    Mockito
        .<BlockingQueue<? super SolrUpdateCommand>>when(
            queueProvider.createOrRetrieveCommandQueue(Mockito.<String>any()))
        .thenReturn(new LinkedBlockingDeque<>());
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    // Act
    catalogSolrIndexUpdateServiceImpl.updateIndex(new ArrayList<>());

    // Assert
    verify(queueProvider).createOrRetrieveCommandQueue(eq("catalog_commandQueue"));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)} with
   * {@code documents}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List)}
   */
  @Test
  public void testUpdateIndexWithDocuments3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexQueueProvider queueProvider = mock(SolrIndexQueueProvider.class);
    Mockito
        .<BlockingQueue<? super SolrUpdateCommand>>when(
            queueProvider.createOrRetrieveCommandQueue(Mockito.<String>any()))
        .thenReturn(new SynchronousQueue<>());
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> catalogSolrIndexUpdateServiceImpl.updateIndex(new ArrayList<>()));
    verify(queueProvider).createOrRetrieveCommandQueue(eq("catalog_commandQueue"));
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
  public void testUpdateIndexWithDocumentsDeleteQueries() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());
    ArrayList<SolrInputDocument> documents = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogSolrIndexUpdateServiceImpl.updateIndex(documents, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)} with
   * {@code documents}, {@code deleteQueries}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)}
   */
  @Test
  public void testUpdateIndexWithDocumentsDeleteQueries2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexQueueProvider queueProvider = mock(SolrIndexQueueProvider.class);
    Mockito
        .<BlockingQueue<? super SolrUpdateCommand>>when(
            queueProvider.createOrRetrieveCommandQueue(Mockito.<String>any()))
        .thenReturn(new LinkedBlockingDeque<>());
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());
    ArrayList<SolrInputDocument> documents = new ArrayList<>();

    // Act
    catalogSolrIndexUpdateServiceImpl.updateIndex(documents, new ArrayList<>());

    // Assert
    verify(queueProvider).createOrRetrieveCommandQueue(eq("catalog_commandQueue"));
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)} with
   * {@code documents}, {@code deleteQueries}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#updateIndex(List, List)}
   */
  @Test
  public void testUpdateIndexWithDocumentsDeleteQueries3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexQueueProvider queueProvider = mock(SolrIndexQueueProvider.class);
    Mockito
        .<BlockingQueue<? super SolrUpdateCommand>>when(
            queueProvider.createOrRetrieveCommandQueue(Mockito.<String>any()))
        .thenReturn(new SynchronousQueue<>());
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl());
    ArrayList<SolrInputDocument> documents = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogSolrIndexUpdateServiceImpl.updateIndex(documents, new ArrayList<>()));
    verify(queueProvider).createOrRetrieveCommandQueue(eq("catalog_commandQueue"));
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
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_givenIndexFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        new ArrayList<>());

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_givenIndexFieldImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        new ArrayList<>());

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_givenLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        locales);

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_givenLocaleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        locales);

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   * with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocumentWithIndexableFieldsLocales_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl.buildDocument(indexable, fields,
        new ArrayList<>());

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable)} with
   * {@code indexable}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#buildDocument(Indexable)}
   */
  @Test
  public void testBuildDocumentWithIndexable_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl commandHandler = mock(CatalogSolrIndexUpdateCommandHandlerImpl.class);
    when(commandHandler.buildDocument(Mockito.<Indexable>any())).thenReturn(null);
    when(commandHandler.getCommandGroup()).thenReturn("Command Group");
    CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl = new CatalogSolrIndexUpdateServiceImpl(
        new DefaultSolrIndexQueueProvider(), commandHandler);

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateServiceImpl
        .buildDocument(new ProductBundleImpl());

    // Assert
    verify(commandHandler).getCommandGroup();
    verify(commandHandler).buildDocument(isA(Indexable.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}
   */
  @Test
  public void testGetQueuePollTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertEquals(60000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueuePollTime());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getQueuePollTime()}
   */
  @Test
  public void testGetQueuePollTime2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertEquals(60000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueuePollTime());
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
  public void testGetQueueOfferTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider();

    // Act and Assert
    assertEquals(1000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueueOfferTime());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexUpdateServiceImpl#getQueueOfferTime()}
   */
  @Test
  public void testGetQueueOfferTime2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    DefaultSolrIndexQueueProvider queueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertEquals(1000L,
        (new CatalogSolrIndexUpdateServiceImpl(queueProvider, new CatalogSolrIndexUpdateCommandHandlerImpl()))
            .getQueueOfferTime());
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
