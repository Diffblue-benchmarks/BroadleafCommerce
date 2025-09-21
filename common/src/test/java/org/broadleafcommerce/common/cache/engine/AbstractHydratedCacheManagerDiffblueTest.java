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
package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponents.UriTemplateVariables;

@ContextConfiguration(classes = {BigMemoryHydratedCacheEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractHydratedCacheManagerDiffblueTest {
  @Autowired private AbstractHydratedCacheManager abstractHydratedCacheManager;

  /**
   * Test {@link AbstractHydratedCacheManager#getHydrationDescriptor(Object)}.
   *
   * <ul>
   *   <li>When forty-six.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractHydratedCacheManager#getHydrationDescriptor(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.cache.engine.HydrationDescriptor AbstractHydratedCacheManager.getHydrationDescriptor(Object)"
  })
  public void testGetHydrationDescriptor_whenFortySix_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> abstractHydratedCacheManager.getHydrationDescriptor(46));
  }

  /**
   * Test {@link AbstractHydratedCacheManager#getHydrationDescriptor(Object)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractHydratedCacheManager#getHydrationDescriptor(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.cache.engine.HydrationDescriptor AbstractHydratedCacheManager.getHydrationDescriptor(Object)"
  })
  public void testGetHydrationDescriptor_whenNull_field_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> abstractHydratedCacheManager.getHydrationDescriptor(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link AbstractHydratedCacheManager#getTopEntityClass(Object)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractHydratedCacheManager#getTopEntityClass(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class AbstractHydratedCacheManager.getTopEntityClass(Object)"})
  public void testGetTopEntityClass_whenNull_field_thenReturnObject() {
    // Arrange and Act
    Class<?> actualTopEntityClass =
        abstractHydratedCacheManager.getTopEntityClass(BLCFieldUtils.NULL_FIELD);

    // Assert
    Class<Object> expectedTopEntityClass = Object.class;
    assertEquals(expectedTopEntityClass, actualTopEntityClass);
  }

  /**
   * Test {@link AbstractHydratedCacheManager#getTopEntityClass(Object)}.
   *
   * <ul>
   *   <li>When {@link UriComponents.UriTemplateVariables#SKIP_VALUE}.
   *   <li>Then return {@link Class}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractHydratedCacheManager#getTopEntityClass(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class AbstractHydratedCacheManager.getTopEntityClass(Object)"})
  public void testGetTopEntityClass_whenSkip_value_thenReturnClass() {
    // Arrange and Act
    Class<?> actualTopEntityClass =
        abstractHydratedCacheManager.getTopEntityClass(UriTemplateVariables.SKIP_VALUE);

    // Assert
    Class<Class> expectedTopEntityClass = Class.class;
    assertEquals(expectedTopEntityClass, actualTopEntityClass);
  }

  /**
   * Test {@link AbstractHydratedCacheManager#useCacheRegionInKey()}.
   *
   * <ul>
   *   <li>Given {@link BigMemoryHydratedCacheEventListener} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractHydratedCacheManager#useCacheRegionInKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractHydratedCacheManager.useCacheRegionInKey()"})
  public void testUseCacheRegionInKey_givenBigMemoryHydratedCacheEventListener_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BigMemoryHydratedCacheEventListener().useCacheRegionInKey());
  }

  /**
   * Test {@link AbstractHydratedCacheManager#useCacheRegionInKey()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractHydratedCacheManager#useCacheRegionInKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractHydratedCacheManager.useCacheRegionInKey()"})
  public void testUseCacheRegionInKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BigMemoryHydratedCacheJcacheEventListener().useCacheRegionInKey());
  }

  /**
   * Test {@link AbstractHydratedCacheManager#clone()}.
   *
   * <p>Method under test: {@link AbstractHydratedCacheManager#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractHydratedCacheManager.clone()"})
  public void testClone() throws CloneNotSupportedException {
    // Arrange
    BigMemoryHydratedCacheEventListener bigMemoryHydratedCacheEventListener =
        new BigMemoryHydratedCacheEventListener();

    // Act
    Object actualCloneResult = bigMemoryHydratedCacheEventListener.clone();

    // Assert
    assertSame(bigMemoryHydratedCacheEventListener, actualCloneResult);
  }
}
