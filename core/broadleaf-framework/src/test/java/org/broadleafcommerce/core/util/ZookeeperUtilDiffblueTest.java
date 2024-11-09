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
package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Op;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.mockito.Mockito;

public class ZookeeperUtilDiffblueTest {
  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper)} with
   * {@code path}, {@code data}, {@code zk}.
   * <p>
   * Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper)}
   */
  @Test
  public void testMakePathWithPathDataZk() throws UnsupportedEncodingException, InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(new Stat(1L, 1L, 10L, 10L, 1, 1, 1, 1L, 3, 10, 1L));

    // Act
    ZookeeperUtil.makePath("Path", data, zk);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   * with {@code path}, {@code data}, {@code zk}, {@code createMode}.
   * <p>
   * Method under test:
   * {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  public void testMakePathWithPathDataZkCreateMode()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(new Stat(1L, 1L, 10L, 10L, 1, 1, 1, 1L, 3, 10, 1L));

    // Act
    ZookeeperUtil.makePath("Path", data, zk, CreateMode.PERSISTENT);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   * with {@code path}, {@code data}, {@code zk}, {@code createMode}.
   * <p>
   * Method under test:
   * {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  public void testMakePathWithPathDataZkCreateMode2()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(new Stat(1L, 1L, 10L, 10L, 1, 1, 1, 1L, 3, 10, 1L));

    // Act
    ZookeeperUtil.makePath("Path", data, zk, null);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test
   * {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode, List)}
   * with {@code path}, {@code data}, {@code zk}, {@code createMode},
   * {@code acls}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ZooKeeper#exists(String, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode, List)}
   */
  @Test
  public void testMakePathWithPathDataZkCreateModeAcls_givenArrayList_thenCallsExists()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(new Stat(1L, 1L, 10L, 10L, 1, 1, 1, 1L, 3, 10, 1L));

    // Act
    ZookeeperUtil.makePath("Path", data, zk, CreateMode.PERSISTENT, new ArrayList<>());

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   * with {@code path}, {@code data}, {@code zk}, {@code createMode}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code CONTAINER}.</li>
   *   <li>Then calls {@link ZooKeeper#exists(String, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  public void testMakePathWithPathDataZkCreateMode_givenNull_whenContainer_thenCallsExists()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("Path", data, zk, CreateMode.CONTAINER);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   * with {@code path}, {@code data}, {@code zk}, {@code createMode}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  public void testMakePathWithPathDataZkCreateMode_givenNull_whenEmptyArrayOfByte()
      throws InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("Path", new byte[]{}, zk, CreateMode.PERSISTENT);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   * with {@code path}, {@code data}, {@code zk}, {@code createMode}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link ZooKeeper#exists(String, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  public void testMakePathWithPathDataZkCreateMode_givenNull_whenNull_thenCallsExists()
      throws InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("Path", null, zk, CreateMode.PERSISTENT);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   * with {@code path}, {@code data}, {@code zk}, {@code createMode}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ZooKeeper} {@link ZooKeeper#exists(String, boolean)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper, CreateMode)}
   */
  @Test
  public void testMakePathWithPathDataZkCreateMode_givenNull_whenZooKeeperExistsReturnNull()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("Path", data, zk, CreateMode.PERSISTENT);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper)} with
   * {@code path}, {@code data}, {@code zk}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then calls {@link ZooKeeper#exists(String, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper)}
   */
  @Test
  public void testMakePathWithPathDataZk_givenNull_whenEmptyArrayOfByte_thenCallsExists()
      throws InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("Path", new byte[]{}, zk);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper)} with
   * {@code path}, {@code data}, {@code zk}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link ZooKeeper#exists(String, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper)}
   */
  @Test
  public void testMakePathWithPathDataZk_givenNull_whenNull_thenCallsExists()
      throws InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("Path", null, zk);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper)} with
   * {@code path}, {@code data}, {@code zk}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ZooKeeper} {@link ZooKeeper#exists(String, boolean)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZookeeperUtil#makePath(String, byte[], ZooKeeper)}
   */
  @Test
  public void testMakePathWithPathDataZk_givenNull_whenZooKeeperExistsReturnNull()
      throws UnsupportedEncodingException, InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("Path", data, zk);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, ZooKeeper)} with {@code path},
   * {@code zk}.
   * <p>
   * Method under test: {@link ZookeeperUtil#makePath(String, ZooKeeper)}
   */
  @Test
  public void testMakePathWithPathZk() throws InterruptedException, KeeperException {
    // Arrange
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(new Stat(1L, 1L, 10L, 10L, 1, 1, 1, 1L, 3, 10, 1L));

    // Act
    ZookeeperUtil.makePath("Path", zk);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, ZooKeeper)} with {@code path},
   * {@code zk}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ZooKeeper} {@link ZooKeeper#exists(String, boolean)} return
   * {@code null}.</li>
   *   <li>Then calls {@link ZooKeeper#exists(String, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZookeeperUtil#makePath(String, ZooKeeper)}
   */
  @Test
  public void testMakePathWithPathZk_givenNull_whenZooKeeperExistsReturnNull_thenCallsExists()
      throws InterruptedException, KeeperException {
    // Arrange
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);

    // Act
    ZookeeperUtil.makePath("Path", zk);

    // Assert
    verify(zk).exists(eq("/Path"), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#exists(String, ZooKeeper)}.
   * <ul>
   *   <li>When {@code exists in Zookeeper.}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZookeeperUtil#exists(String, ZooKeeper)}
   */
  @Test
  public void testExists_whenExistsInZookeeper_thenThrowRuntimeException()
      throws IOException, InterruptedException, KeeperException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ZookeeperUtil.exists(" exists in Zookeeper.", new ZooKeeper("Connect String", 10, mock(Watcher.class))));
  }

  /**
   * Test {@link ZookeeperUtil#exists(String, ZooKeeper)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZookeeperUtil#exists(String, ZooKeeper)}
   */
  @Test
  public void testExists_whenPath_thenThrowRuntimeException()
      throws IOException, InterruptedException, KeeperException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ZookeeperUtil.exists("Path", new ZooKeeper("Connect String", 10, mock(Watcher.class))));
  }
}
