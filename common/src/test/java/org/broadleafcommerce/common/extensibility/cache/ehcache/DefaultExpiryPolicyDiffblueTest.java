/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Duration;
import java.util.function.Supplier;
import org.broadleafcommerce.common.extensibility.cache.TimedValueHolder;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultExpiryPolicy.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultExpiryPolicyDiffblueTest {
  @Autowired private DefaultExpiryPolicy defaultExpiryPolicy;

  /**
   * Test {@link DefaultExpiryPolicy#DefaultExpiryPolicy()}.
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#DefaultExpiryPolicy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultExpiryPolicy.<init>()"})
  public void testNewDefaultExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE, new DefaultExpiryPolicy().getDefaultDuration().toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#DefaultExpiryPolicy(int)}.
   *
   * <ul>
   *   <li>Then return DefaultDuration toNanos is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#DefaultExpiryPolicy(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultExpiryPolicy.<init>(int)"})
  public void testNewDefaultExpiryPolicy_thenReturnDefaultDurationToNanosIsMax_value() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE, new DefaultExpiryPolicy(-1).getDefaultDuration().toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#DefaultExpiryPolicy(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return DefaultDuration toNanos is {@code 1000000000}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#DefaultExpiryPolicy(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultExpiryPolicy.<init>(int)"})
  public void testNewDefaultExpiryPolicy_whenOne_thenReturnDefaultDurationToNanosIs1000000000() {
    // Arrange, Act and Assert
    assertEquals(1000000000L, new DefaultExpiryPolicy(1).getDefaultDuration().toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}.
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration DefaultExpiryPolicy.getExpiryForCreation(Object, Object)"})
  public void testGetExpiryForCreation() {
    // Arrange
    TimedValueHolder timedValueHolder = new TimedValueHolder(BLCFieldUtils.NULL_FIELD, null);

    // Act and Assert
    assertEquals(
        Long.MAX_VALUE,
        defaultExpiryPolicy
            .getExpiryForCreation(BLCFieldUtils.NULL_FIELD, timedValueHolder)
            .toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}.
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration DefaultExpiryPolicy.getExpiryForCreation(Object, Object)"})
  public void testGetExpiryForCreation2() {
    // Arrange, Act and Assert
    assertEquals(
        Long.MAX_VALUE,
        defaultExpiryPolicy
            .getExpiryForCreation(
                BLCFieldUtils.NULL_FIELD, new TimedValueHolder(BLCFieldUtils.NULL_FIELD, -1))
            .toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}.
   *
   * <ul>
   *   <li>Then return toNanos is zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration DefaultExpiryPolicy.getExpiryForCreation(Object, Object)"})
  public void testGetExpiryForCreation_thenReturnToNanosIsZero() {
    // Arrange and Act
    Duration actualExpiryForCreation =
        defaultExpiryPolicy.getExpiryForCreation(
            BLCFieldUtils.NULL_FIELD, new TimedValueHolder(BLCFieldUtils.NULL_FIELD, 0));

    // Assert
    assertEquals(0L, actualExpiryForCreation.toNanos());
    assertSame(Duration.ZERO, actualExpiryForCreation);
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then return toNanos is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration DefaultExpiryPolicy.getExpiryForCreation(Object, Object)"})
  public void testGetExpiryForCreation_whenNull_field_thenReturnToNanosIsMax_value() {
    // Arrange, Act and Assert
    assertEquals(
        Long.MAX_VALUE,
        defaultExpiryPolicy
            .getExpiryForCreation(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD)
            .toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForAccess(Object, Supplier)}.
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#getExpiryForAccess(Object, Supplier)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration DefaultExpiryPolicy.getExpiryForAccess(Object, Supplier)"})
  public void testGetExpiryForAccess() {
    // Arrange, Act and Assert
    assertNull(
        defaultExpiryPolicy.getExpiryForAccess(BLCFieldUtils.NULL_FIELD, mock(Supplier.class)));
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForUpdate(Object, Supplier, Object)}.
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#getExpiryForUpdate(Object, Supplier, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration DefaultExpiryPolicy.getExpiryForUpdate(Object, Supplier, Object)"})
  public void testGetExpiryForUpdate() {
    // Arrange, Act and Assert
    assertNull(
        defaultExpiryPolicy.getExpiryForUpdate(
            BLCFieldUtils.NULL_FIELD, mock(Supplier.class), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link DefaultExpiryPolicy#getDefaultDuration()}.
   *
   * <p>Method under test: {@link DefaultExpiryPolicy#getDefaultDuration()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration DefaultExpiryPolicy.getDefaultDuration()"})
  public void testGetDefaultDuration() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE, new DefaultExpiryPolicy().getDefaultDuration().toNanos());
  }
}
