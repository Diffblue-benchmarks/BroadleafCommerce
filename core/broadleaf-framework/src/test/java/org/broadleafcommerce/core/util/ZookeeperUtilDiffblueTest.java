package org.broadleafcommerce.core.util;

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
import org.apache.zookeeper.Op;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class ZookeeperUtilDiffblueTest {
  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)} with {@code path},
   * {@code data}, {@code zk}, {@code createMode}.
   *
   * <ul>
   *   <li>Given {@link Stat#Stat()}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link ZooKeeper#multi(Iterable)}.
   * </ul>
   *
   * <p>Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZookeeperUtil.makePath(String, byte[], ZooKeeper, CreateMode)"})
  public void testMakePathWithPathDataZkCreateMode_givenStat_whenNull_thenCallsMulti()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(new Stat());

    // Act
    ZookeeperUtil.makePath("/", data, zk, null);

    // Assert
    verify(zk).exists("/", false);
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)} with {@code path},
   * {@code data}, {@code zk}, {@code createMode}.
   *
   * <ul>
   *   <li>Given {@link Stat#Stat()}.
   *   <li>When {@code Path}.
   *   <li>Then calls {@link ZooKeeper#multi(Iterable)}.
   * </ul>
   *
   * <p>Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZookeeperUtil.makePath(String, byte[], ZooKeeper, CreateMode)"})
  public void testMakePathWithPathDataZkCreateMode_givenStat_whenPath_thenCallsMulti()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(new Stat());

    // Act
    ZookeeperUtil.makePath("Path", data, zk, CreateMode.PERSISTENT);

    // Assert
    verify(zk).exists("/Path", false);
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)} with {@code path},
   * {@code data}, {@code zk}, {@code createMode}.
   *
   * <ul>
   *   <li>Given {@link Stat#Stat()}.
   *   <li>When {@link ZooKeeper} {@link ZooKeeper#exists(String, boolean)} return {@link
   *       Stat#Stat()}.
   * </ul>
   *
   * <p>Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZookeeperUtil.makePath(String, byte[], ZooKeeper, CreateMode)"})
  public void testMakePathWithPathDataZkCreateMode_givenStat_whenZooKeeperExistsReturnStat()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(new Stat());

    // Act
    ZookeeperUtil.makePath("/", data, zk, CreateMode.PERSISTENT);

    // Assert
    verify(zk).exists("/", false);
    verify(zk).multi(isA(Iterable.class));
  }
}
