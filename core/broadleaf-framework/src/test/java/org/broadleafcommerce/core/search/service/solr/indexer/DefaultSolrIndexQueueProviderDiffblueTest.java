package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.solr.client.solrj.SolrClient;
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
  @Autowired private DefaultSolrIndexQueueProvider defaultSolrIndexQueueProvider;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider()}
   *   <li>{@link DefaultSolrIndexQueueProvider#getEnvironment()}
   *   <li>{@link DefaultSolrIndexQueueProvider#getZookeeper()}
   *   <li>{@link DefaultSolrIndexQueueProvider#isDistributed()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultSolrIndexQueueProvider.<init>()",
    "Environment DefaultSolrIndexQueueProvider.getEnvironment()",
    "ZooKeeper DefaultSolrIndexQueueProvider.getZookeeper()",
    "boolean DefaultSolrIndexQueueProvider.isDistributed()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider =
        new DefaultSolrIndexQueueProvider();
    Environment actualEnvironment = actualDefaultSolrIndexQueueProvider.getEnvironment();
    ZooKeeper actualZookeeper = actualDefaultSolrIndexQueueProvider.getZookeeper();

    // Assert
    assertNull(actualZookeeper);
    assertNull(actualEnvironment);
    assertFalse(actualDefaultSolrIndexQueueProvider.isDistributed());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient,
   * Environment)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Zookeeper is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultSolrIndexQueueProvider#DefaultSolrIndexQueueProvider(SolrClient, Environment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultSolrIndexQueueProvider.<init>(SolrClient, Environment)"})
  public void testNewDefaultSolrIndexQueueProvider_whenNull_thenReturnZookeeperIsNull() {
    // Arrange
    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act
    DefaultSolrIndexQueueProvider actualDefaultSolrIndexQueueProvider =
        new DefaultSolrIndexQueueProvider((SolrClient) null, env);

    // Assert
    assertNull(actualDefaultSolrIndexQueueProvider.getZookeeper());
    assertFalse(actualDefaultSolrIndexQueueProvider.isDistributed());
    assertSame(env, actualDefaultSolrIndexQueueProvider.getEnvironment());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createOrRetrieveCommandQueue(String)}.
   *
   * <ul>
   *   <li>When {@code LockQueue Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultSolrIndexQueueProvider#createOrRetrieveCommandQueue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.concurrent.BlockingQueue DefaultSolrIndexQueueProvider.createOrRetrieveCommandQueue(String)"
  })
  public void testCreateOrRetrieveCommandQueue_whenJavaUtilConcurrentLocksLockQueueName() {
    // Arrange, Act and Assert
    assertTrue(
        new DefaultSolrIndexQueueProvider()
            .createOrRetrieveCommandQueue("java.util.concurrent.locks.LockQueue Name")
            .isEmpty());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createOrRetrieveCommandQueue(String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultSolrIndexQueueProvider#createOrRetrieveCommandQueue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.concurrent.BlockingQueue DefaultSolrIndexQueueProvider.createOrRetrieveCommandQueue(String)"
  })
  public void testCreateOrRetrieveCommandQueue_whenNotBlank_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new DefaultSolrIndexQueueProvider().createOrRetrieveCommandQueue("not blank").isEmpty());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createLocalQueue(String)}.
   *
   * <p>Method under test: {@link DefaultSolrIndexQueueProvider#createLocalQueue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.concurrent.BlockingQueue DefaultSolrIndexQueueProvider.createLocalQueue(String)"
  })
  public void testCreateLocalQueue() {
    // Arrange, Act and Assert
    assertTrue(defaultSolrIndexQueueProvider.createLocalQueue("Queue Name").isEmpty());
  }

  /**
   * Test {@link DefaultSolrIndexQueueProvider#createLocalLock(String)}.
   *
   * <ul>
   *   <li>When {@code /solr-index/command-queue/}.
   *   <li>Then return {@link ReentrantLock}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSolrIndexQueueProvider#createLocalLock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Lock DefaultSolrIndexQueueProvider.createLocalLock(String)"})
  public void testCreateLocalLock_whenSolrIndexCommandQueue_thenReturnReentrantLock() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    Lock actualCreateLocalLockResult =
        new DefaultSolrIndexQueueProvider().createLocalLock("/solr-index/command-queue/");

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
