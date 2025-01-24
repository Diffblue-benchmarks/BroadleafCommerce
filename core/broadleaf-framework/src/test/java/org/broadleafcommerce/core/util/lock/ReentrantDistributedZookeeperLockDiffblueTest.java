package org.broadleafcommerce.core.util.lock;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;

public class ReentrantDistributedZookeeperLockDiffblueTest {
  @MockBean
  private ReentrantDistributedZookeeperLock reentrantDistributedZookeeperLock;

  /**
   * Test
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String)}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String)}
   */
  @Test
  public void testNewReentrantDistributedZookeeperLock() throws IOException {
    // Arrange, Act and Assert
    assertThrows(DistributedLock.DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)),
            "Lock Path", "Lock Name"));

  }

  /**
   * Test
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, List)}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, List)}
   */
  @Test
  public void testNewReentrantDistributedZookeeperLock2() throws IOException {
    // Arrange
    ZooKeeper zk = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    // Act and Assert
    assertThrows(DistributedLock.DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(zk, "Lock Path", "Lock Name", new ArrayList<>()));

  }

  /**
   * Test
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, Environment, List)}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, Environment, List)}
   */
  @Test
  public void testNewReentrantDistributedZookeeperLock3() throws IOException {
    // Arrange
    ZooKeeper zk = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act and Assert
    assertThrows(DistributedLock.DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(zk, "Lock Path", "Lock Name", env, new ArrayList<>()));

  }

  /**
   * Test
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, Environment, boolean, List)}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, Environment, boolean, List)}
   */
  @Test
  public void testNewReentrantDistributedZookeeperLock4() throws IOException {
    // Arrange
    ZooKeeper zk = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act and Assert
    assertThrows(DistributedLock.DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(zk, "Lock Path", "Lock Name", env, true, new ArrayList<>()));

  }

  /**
   * Test
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, boolean, List)}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, boolean, List)}
   */
  @Test
  public void testNewReentrantDistributedZookeeperLock5() throws IOException {
    // Arrange
    ZooKeeper zk = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    // Act and Assert
    assertThrows(DistributedLock.DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(zk, "Lock Path", "Lock Name", true, new ArrayList<>()));

  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#lock()}.
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#lock()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLock() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).lock();
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#unlock()}.
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#unlock()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUnlock() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).unlock();
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#lockInterruptibly()}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#lockInterruptibly()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLockInterruptibly() throws IOException, InterruptedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).lockInterruptibly();
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#tryLock()}.
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#tryLock()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTryLock() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).tryLock();
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#tryLock(long, TimeUnit)} with
   * {@code long}, {@code TimeUnit}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#tryLock(long, TimeUnit)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTryLockWithLongTimeUnit() throws IOException, InterruptedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).tryLock(10L, TimeUnit.NANOSECONDS);
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#newCondition()}.
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#newCondition()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewCondition() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).newCondition();
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#lockInternally(long)}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#lockInternally(long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLockInternally() throws IOException, InterruptedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).lockInternally(1L);
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#initialize()}.
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#initialize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInitialize() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).initialize();
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#canParticipate()}.
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#canParticipate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanParticipate() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).canParticipate();
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#currentThreadHoldsLock()}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#currentThreadHoldsLock()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCurrentThreadHoldsLock() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).currentThreadHoldsLock();
  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#getCurrentThreadLockPermits()}.
   * <p>
   * Method under test:
   * {@link ReentrantDistributedZookeeperLock#getCurrentThreadLockPermits()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrentThreadLockPermits() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.broadleafcommerce.core.util.lock.DistributedLock$DistributedLockException: Zookeeper encountered an error trying to create the persistent path, /broadleaf/app/distributed-locks/Lock Path in Zookeeper.
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:556)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /broadleaf
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:102)
    //       at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2256)
    //       at org.apache.zookeeper.ZooKeeper.exists(ZooKeeper.java:2281)
    //       at org.broadleafcommerce.core.util.ZookeeperUtil.makePath(ZookeeperUtil.java:120)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:545)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock$6.execute(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.common.util.GenericOperationUtil.executeRetryableOperation(GenericOperationUtil.java:84)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.initialize(ReentrantDistributedZookeeperLock.java:541)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:275)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:181)
    //       at org.broadleafcommerce.core.util.lock.ReentrantDistributedZookeeperLock.<init>(ReentrantDistributedZookeeperLock.java:163)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)), "Lock Path",
        "Lock Name")).getCurrentThreadLockPermits();
  }
}
