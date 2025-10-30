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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.broadleafcommerce.core.util.lock.DistributedLock.DistributedLockException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;

public class ReentrantDistributedZookeeperLockDiffblueTest {
  /**
   * Test {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String)}.
   * <ul>
   *   <li>Then throw {@link DistributedLockException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReentrantDistributedZookeeperLock.<init>(ZooKeeper, String, String)"})
  public void testNewReentrantDistributedZookeeperLock_thenThrowDistributedLockException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(new ZooKeeper("Connect String", 10, mock(Watcher.class)),
            "Lock Path", "Lock Name"));

  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, List)}.
   * <ul>
   *   <li>Then throw {@link DistributedLockException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReentrantDistributedZookeeperLock.<init>(ZooKeeper, String, String, List)"})
  public void testNewReentrantDistributedZookeeperLock_thenThrowDistributedLockException2() throws IOException {
    // Arrange
    ZooKeeper zk = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    // Act and Assert
    assertThrows(DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(zk, "Lock Path", "Lock Name", new ArrayList<>()));

  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, Environment, List)}.
   * <ul>
   *   <li>Then throw {@link DistributedLockException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, Environment, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReentrantDistributedZookeeperLock.<init>(ZooKeeper, String, String, Environment, List)"})
  public void testNewReentrantDistributedZookeeperLock_thenThrowDistributedLockException3() throws IOException {
    // Arrange
    ZooKeeper zk = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act and Assert
    assertThrows(DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(zk, "Lock Path", "Lock Name", env, new ArrayList<>()));

  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, Environment, boolean, List)}.
   * <ul>
   *   <li>Then throw {@link DistributedLockException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, Environment, boolean, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ReentrantDistributedZookeeperLock.<init>(ZooKeeper, String, String, Environment, boolean, List)"})
  public void testNewReentrantDistributedZookeeperLock_thenThrowDistributedLockException4() throws IOException {
    // Arrange
    ZooKeeper zk = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();

    // Act and Assert
    assertThrows(DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(zk, "Lock Path", "Lock Name", env, true, new ArrayList<>()));

  }

  /**
   * Test {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, boolean, List)}.
   * <ul>
   *   <li>Then throw {@link DistributedLockException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReentrantDistributedZookeeperLock#ReentrantDistributedZookeeperLock(ZooKeeper, String, String, boolean, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReentrantDistributedZookeeperLock.<init>(ZooKeeper, String, String, boolean, List)"})
  public void testNewReentrantDistributedZookeeperLock_thenThrowDistributedLockException5() throws IOException {
    // Arrange
    ZooKeeper zk = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    // Act and Assert
    assertThrows(DistributedLockException.class,
        () -> new ReentrantDistributedZookeeperLock(zk, "Lock Path", "Lock Name", true, new ArrayList<>()));

  }
}
