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
package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.NoNodeException;
import org.apache.zookeeper.Op;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class ZookeeperUtilDiffblueTest {
  /**
   * Test {@link ZookeeperUtil#makePath(String, ZooKeeper)} with {@code path}, {@code zk}.
   *
   * <ul>
   *   <li>Given {@link NoNodeException#NoNodeException()}.
   *   <li>Then throw {@link NoNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link ZookeeperUtil#makePath(String, ZooKeeper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZookeeperUtil.makePath(String, ZooKeeper)"})
  public void testMakePathWithPathZk_givenNoNodeException_thenThrowNoNodeException()
      throws InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenThrow(new NoNodeException());

    // Act and Assert
    assertThrows(NoNodeException.class, () -> ZookeeperUtil.makePath("/", zk));
    verify(zk).exists("/", false);
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, ZooKeeper)} with {@code path}, {@code zk}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@code foo/bar}.
   *   <li>Then calls {@link ZooKeeper#multi(Iterable)}.
   * </ul>
   *
   * <p>Method under test: {@link ZookeeperUtil#makePath(String, ZooKeeper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZookeeperUtil.makePath(String, ZooKeeper)"})
  public void testMakePathWithPathZk_givenNull_whenFooBar_thenCallsMulti()
      throws InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());

    // Act
    ZookeeperUtil.makePath("foo/bar", zk);

    // Assert
    verify(zk, atLeast(1)).exists(Mockito.<String>any(), eq(false));
    verify(zk).multi(isA(Iterable.class));
  }

  /**
   * Test {@link ZookeeperUtil#makePath(String, ZooKeeper)} with {@code path}, {@code zk}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ZooKeeper} {@link ZooKeeper#exists(String, boolean)} return {@code null}.
   *   <li>Then calls {@link ZooKeeper#multi(Iterable)}.
   * </ul>
   *
   * <p>Method under test: {@link ZookeeperUtil#makePath(String, ZooKeeper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZookeeperUtil.makePath(String, ZooKeeper)"})
  public void testMakePathWithPathZk_givenNull_whenZooKeeperExistsReturnNull_thenCallsMulti()
      throws InterruptedException, KeeperException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ZooKeeper zk = mock(ZooKeeper.class);
    when(zk.exists(Mockito.<String>any(), anyBoolean())).thenReturn(null);
    when(zk.multi(Mockito.<Iterable<Op>>any())).thenReturn(new ArrayList<>());

    // Act
    ZookeeperUtil.makePath("/", zk);

    // Assert
    verify(zk).exists("/", false);
    verify(zk).multi(isA(Iterable.class));
  }
}
