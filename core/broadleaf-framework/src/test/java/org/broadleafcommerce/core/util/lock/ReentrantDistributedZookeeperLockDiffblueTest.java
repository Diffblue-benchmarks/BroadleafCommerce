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
package org.broadleafcommerce.core.util.lock;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;

public class ReentrantDistributedZookeeperLockDiffblueTest {
  @MockBean
  private ReentrantDistributedZookeeperLock reentrantDistributedZookeeperLock;

  /**
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
}
