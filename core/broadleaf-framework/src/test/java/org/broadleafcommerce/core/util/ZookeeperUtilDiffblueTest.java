package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.NoNodeException;
import org.apache.zookeeper.Op;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class ZookeeperUtilDiffblueTest {
  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)} with {@code path},
   * {@code data}, {@code zk}, {@code createMode}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@code CONTAINER}.
   *   <li>Then calls {@link ZooKeeper#multi(Iterable)}.
   * </ul>
   *
   * <p>Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZookeeperUtil.makePath(String, byte[], ZooKeeper, CreateMode)"})
  public void testMakePathWithPathDataZkCreateMode_givenNull_whenContainer_thenCallsMulti()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("/", data, zk, CreateMode.CONTAINER);

    // Assert
    verify(zk).exists("/", false);
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)} with {@code path},
   * {@code data}, {@code zk}, {@code createMode}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ZooKeeper} {@link ZooKeeper#exists(String, boolean)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZookeeperUtil.makePath(String, byte[], ZooKeeper, CreateMode)"})
  public void testMakePathWithPathDataZkCreateMode_givenNull_whenZooKeeperExistsReturnNull()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("/", data, zk, CreateMode.PERSISTENT);

    // Assert
    verify(zk).exists("/", false);
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)} with {@code path},
   * {@code data}, {@code zk}, {@code createMode}.
   *
   * <ul>
   *   <li>Then throw {@link NoNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZookeeperUtil.makePath(String, byte[], ZooKeeper, CreateMode)"})
  public void testMakePathWithPathDataZkCreateMode_thenThrowNoNodeException()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenThrow(new NoNodeException());

    // Act and Assert
    assertThrows(
        NoNodeException.class, () -> ZookeeperUtil.makePath("/", data, zk, CreateMode.PERSISTENT));
    verify(zk).exists("/", false);
  }
}
