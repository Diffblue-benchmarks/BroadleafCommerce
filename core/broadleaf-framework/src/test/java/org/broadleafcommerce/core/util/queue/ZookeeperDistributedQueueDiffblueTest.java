/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.core.util.queue;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.broadleafcommerce.core.util.queue.DistributedBlockingQueue.DistributedQueueException;
import org.junit.Test;

public class ZookeeperDistributedQueueDiffblueTest {
  /**
   * Test
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper)}.
   * <ul>
   *   <li>Then throw {@link DistributedQueueException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper)}
   */
  @Test
  public void testNewZookeeperDistributedQueue_thenThrowDistributedQueueException() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(DistributedBlockingQueue.DistributedQueueException.class,
        () -> new ZookeeperDistributedQueue<>("Queue Path", new ZooKeeper("Connect String", 10, mock(Watcher.class))));

  }

  /**
   * Test
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper, int, boolean, List)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link DistributedQueueException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper, int, boolean, List)}
   */
  @Test
  public void testNewZookeeperDistributedQueue_whenOne_thenThrowDistributedQueueException() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(DistributedBlockingQueue.DistributedQueueException.class,
        () -> new ZookeeperDistributedQueue<>("Queue Path", new ZooKeeper("Connect String", 10, mock(Watcher.class)), 1,
            false, null));

  }

  /**
   * Test
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then throw {@link DistributedQueueException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper, int)}
   */
  @Test
  public void testNewZookeeperDistributedQueue_whenThree_thenThrowDistributedQueueException() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(DistributedBlockingQueue.DistributedQueueException.class,
        () -> new ZookeeperDistributedQueue<>("Queue Path", new ZooKeeper("Connect String", 10, mock(Watcher.class)),
            3));

  }

  /**
   * Test
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper, int, boolean, List)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then throw {@link DistributedQueueException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper, int, boolean, List)}
   */
  @Test
  public void testNewZookeeperDistributedQueue_whenThree_thenThrowDistributedQueueException2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zk = new ZooKeeper("Connect String", 10, mock(Watcher.class));

    // Act and Assert
    assertThrows(DistributedBlockingQueue.DistributedQueueException.class,
        () -> new ZookeeperDistributedQueue<>("Queue Path", zk, 3, true, new ArrayList<>()));

  }
}
