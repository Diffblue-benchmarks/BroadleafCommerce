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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.common.cloud.SolrZkClient;
import org.apache.solr.common.cloud.ZkStateReader;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient;
import org.junit.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;

public class DefaultSolrIndexQueueProviderDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#createOrRetrieveCommandQueue(String)}
   */
  @Test
  public void testCreateOrRetrieveCommandQueue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new DefaultSolrIndexQueueProvider()).createOrRetrieveCommandQueue("Queue Name").isEmpty());
  }

  /**
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#createOrRetrieveCommandLock(String)}
   */
  @Test
  public void testCreateOrRetrieveCommandLock() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Lock actualCreateOrRetrieveCommandLockResult = (new DefaultSolrIndexQueueProvider())
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
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#createLocalQueue(String)}
   */
  @Test
  public void testCreateLocalQueue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new DefaultSolrIndexQueueProvider()).createLocalQueue("Queue Name").isEmpty());
  }

  /**
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#createLocalQueue(String)}
   */
  @Test
  public void testCreateLocalQueue2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Creating Local Queue for Solr update commands with the name ", 10,
        mock(Watcher.class));

    // Act and Assert
    assertTrue((new DefaultSolrIndexQueueProvider(zookeeper, new StandardReactiveWebEnvironment()))
        .createLocalQueue("Queue Name")
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#createLocalLock(String)}
   */
  @Test
  public void testCreateLocalLock() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Lock actualCreateLocalLockResult = (new DefaultSolrIndexQueueProvider()).createLocalLock("Lock Name");

    // Assert
    assertTrue(actualCreateLocalLockResult instanceof ReentrantLock);
    assertEquals(0, ((ReentrantLock) actualCreateLocalLockResult).getHoldCount());
    assertEquals(0, ((ReentrantLock) actualCreateLocalLockResult).getQueueLength());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).hasQueuedThreads());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).isFair());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).isLocked());
  }

  /**
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#createLocalLock(String)}
   */
  @Test
  public void testCreateLocalLock2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Creating Local Lock for lock name ", 10, mock(Watcher.class));

    // Act
    Lock actualCreateLocalLockResult = (new DefaultSolrIndexQueueProvider(zookeeper,
        new StandardReactiveWebEnvironment())).createLocalLock("Lock Name");

    // Assert
    assertTrue(actualCreateLocalLockResult instanceof ReentrantLock);
    assertEquals(0, ((ReentrantLock) actualCreateLocalLockResult).getHoldCount());
    assertEquals(0, ((ReentrantLock) actualCreateLocalLockResult).getQueueLength());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).hasQueuedThreads());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).isFair());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) actualCreateLocalLockResult).isLocked());
  }

  /**
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
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}
   */
  @Test
  public void testNewDefaultSolrIndexQueueProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}
   */
  @Test
  public void testNewDefaultSolrIndexQueueProvider2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LBHttp2SolrClient solrClient = new LBHttp2SolrClient(null, "https://example.org/example");

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
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}
   */
  @Test
  public void testNewDefaultSolrIndexQueueProvider3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LBHttp2SolrClient solrClient = mock(LBHttp2SolrClient.class);
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
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}
   */
  @Test
  public void testNewDefaultSolrIndexQueueProvider4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCloudSolrClient solrClient = mock(BroadleafCloudSolrClient.class);
    when(solrClient.getZkStateReader()).thenReturn(new ZkStateReader(new SolrZkClient()));
    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider(solrClient,
        env);

    // Assert
    verify(solrClient).getZkStateReader();
    assertNull(actualDefaultSolrIndexQueueProvider.getZookeeper());
    assertTrue(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(env, actualDefaultSolrIndexQueueProvider.getEnvironment());
  }

  /**
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}
   */
  @Test
  public void testNewDefaultSolrIndexQueueProvider5() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zookeeper = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider(zookeeper,
        env);

    // Assert
    assertTrue(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(zookeeper, actualDefaultSolrIndexQueueProvider.getZookeeper());
    assertSame(env, actualDefaultSolrIndexQueueProvider.getEnvironment());
  }

  /**
   * Method under test:
   * {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(ZooKeeper, Environment)}
   */
  @Test
  public void testNewDefaultSolrIndexQueueProvider6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider = new DefaultSolrIndexQueueProvider(
        (ZooKeeper) null, env);

    // Assert
    assertNull(actualDefaultSolrIndexQueueProvider.getZookeeper());
    assertFalse(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(env, actualDefaultSolrIndexQueueProvider.getEnvironment());
  }
}
