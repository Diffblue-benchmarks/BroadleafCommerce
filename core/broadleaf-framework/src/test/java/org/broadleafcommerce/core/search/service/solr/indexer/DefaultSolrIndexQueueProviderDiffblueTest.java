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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.embedded.SSLConfig;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.Http2SolrClient.Builder;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultSolrIndexQueueProvider.class})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultSolrIndexQueueProvider.<init>()",
      "Environment DefaultSolrIndexQueueProvider.getEnvironment()",
      "ZooKeeper DefaultSolrIndexQueueProvider.getZookeeper()",
      "boolean DefaultSolrIndexQueueProvider.isDistributed()"})
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
   * Test {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}.
   * <p>
   * Method under test: {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultSolrIndexQueueProvider.<init>(SolrClient, Environment)"})
  public void testNewDefaultSolrIndexQueueProvider() {
    // Arrange
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    LBHttp2SolrClient solrClient = new LBHttp2SolrClient(httpClient5, "https://example.org/example");

    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider(solrClient,
        env);

    // Assert
    assertNull(actualDefaultSolrIndexQueueProvider.getZookeeper());
    assertFalse(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(env, actualDefaultSolrIndexQueueProvider.getEnvironment());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}.
   * <ul>
   *   <li>Then return Distributed.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultSolrIndexQueueProvider.<init>(ZooKeeper, Environment)"})
  public void testNewDefaultSolrIndexQueueProvider_thenReturnDistributed() throws IOException {
    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment());

    // Assert
    assertTrue(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(zookeeper, actualDefaultSolrIndexQueueProvider.getZookeeper());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Zookeeper is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultSolrIndexQueueProvider.<init>(SolrClient, Environment)"})
  public void testNewDefaultSolrIndexQueueProvider_whenNull_thenReturnZookeeperIsNull() {
    // Arrange
    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider(
        (SolrClient) null, env);

    // Assert
    assertNull(actualDefaultSolrIndexQueueProvider.getZookeeper());
    assertFalse(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(env, actualDefaultSolrIndexQueueProvider.getEnvironment());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createOrRetrieveCommandQueue(String)}.
   * <ul>
   *   <li>When {@code Queue Name}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSolrIndexQueueProvider#createOrRetrieveCommandQueue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.util.concurrent.BlockingQueue DefaultSolrIndexQueueProvider.createOrRetrieveCommandQueue(String)"})
  public void testCreateOrRetrieveCommandQueue_whenQueueName_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(defaultSolrIndexQueueProvider.createOrRetrieveCommandQueue("Queue Name").isEmpty());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createOrRetrieveCommandLock(String)}.
   * <ul>
   *   <li>When {@code Lock Name}.</li>
   *   <li>Then return {@link ReentrantLock}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSolrIndexQueueProvider#createOrRetrieveCommandLock(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Lock DefaultSolrIndexQueueProvider.createOrRetrieveCommandLock(String)"})
  public void testCreateOrRetrieveCommandLock_whenLockName_thenReturnReentrantLock() {
    // Arrange and Act
    Lock actualCreateOrRetrieveCommandLockResult = defaultSolrIndexQueueProvider
        .createOrRetrieveCommandLock("Lock Name");

    // Assert
    assertTrue(actualCreateOrRetrieveCommandLockResult instanceof ReentrantLock);
    assertEquals(0, ((ReentrantLock) actualCreateOrRetrieveCommandLockResult).getHoldCount());
    assertEquals(0, ((ReentrantLock) actualCreateOrRetrieveCommandLockResult).getQueueLength());
    assertFalse(((ReentrantLock) actualCreateOrRetrieveCommandLockResult).hasQueuedThreads());
    assertFalse(((ReentrantLock) actualCreateOrRetrieveCommandLockResult).isFair());
    assertFalse(((ReentrantLock) actualCreateOrRetrieveCommandLockResult).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) actualCreateOrRetrieveCommandLockResult).isLocked());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createLocalQueue(String)}.
   * <p>
   * Method under test: {@link DefaultSolrIndexQueueProvider#createLocalQueue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.concurrent.BlockingQueue DefaultSolrIndexQueueProvider.createLocalQueue(String)"})
  public void testCreateLocalQueue() {
    // Arrange, Act and Assert
    assertTrue(defaultSolrIndexQueueProvider.createLocalQueue("Queue Name").isEmpty());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createLocalLock(String)}.
   * <p>
   * Method under test: {@link DefaultSolrIndexQueueProvider#createLocalLock(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Lock DefaultSolrIndexQueueProvider.createLocalLock(String)"})
  public void testCreateLocalLock() {
    // Arrange and Act
    Lock actualCreateLocalLockResult = defaultSolrIndexQueueProvider.createLocalLock("Lock Name");

    // Assert
    assertTrue(actualCreateLocalLockResult instanceof ReentrantLock);
    assertEquals(0, ((ReentrantLock) actualCreateLocalLockResult).getHoldCount());
    assertEquals(0, ((ReentrantLock) actualCreateLocalLockResult).getQueueLength());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).hasQueuedThreads());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).isFair());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).isLocked());
  }
}
