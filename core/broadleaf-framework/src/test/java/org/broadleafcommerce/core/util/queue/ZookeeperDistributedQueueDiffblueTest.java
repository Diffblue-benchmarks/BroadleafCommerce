package org.broadleafcommerce.core.util.queue;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.io.Serializable;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.broadleafcommerce.core.util.queue.DistributedBlockingQueue.DistributedQueueException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ZookeeperDistributedQueueDiffblueTest {
  @MockBean
  private ZookeeperDistributedQueue zookeeperDistributedQueue;

  @Autowired
  private ZookeeperDistributedQueue<Serializable> zookeeperDistributedQueue2;

  /**
   * Test
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper)}.
   * <p>
   * Method under test:
   * {@link ZookeeperDistributedQueue#ZookeeperDistributedQueue(String, ZooKeeper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewZookeeperDistributedQueue() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.broadleafcommerce.core.util.queue.ZookeeperDistributedQueue
    //   when running class:
    //   package org.broadleafcommerce.core.util.queue;
    //   @org.springframework.test.context.ContextConfiguration
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1879 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.queue.ZookeeperDistributedQueue<Ljava.io.Serializable;> zookeeperDistributedQueue;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new ZookeeperDistributedQueue<>("Queue Path", new ZooKeeper("Connect String", 10, mock(Watcher.class)));

  }

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
}
