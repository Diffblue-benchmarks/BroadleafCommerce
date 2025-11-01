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
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BigMemoryHydratedCacheEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractHydratedCacheManagerDiffblueTest {
  @Autowired
  private AbstractHydratedCacheManager abstractHydratedCacheManager;

  /**
   * Method under test:
   * {@link AbstractHydratedCacheManager#getHydrationDescriptor(Object)}
   */
  @Test
  public void testGetHydrationDescriptor() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> abstractHydratedCacheManager.getHydrationDescriptor(BLCFieldUtils.NULL_FIELD));
    assertThrows(RuntimeException.class, () -> abstractHydratedCacheManager.getHydrationDescriptor(46));
  }

  /**
   * Method under test:
   * {@link AbstractHydratedCacheManager#getTopEntityClass(Object)}
   */
  @Test
  public void testGetTopEntityClass() {
    // Arrange and Act
    Class<?> actualTopEntityClass = abstractHydratedCacheManager.getTopEntityClass(BLCFieldUtils.NULL_FIELD);

    // Assert
    Class<Object> expectedTopEntityClass = Object.class;
    assertEquals(expectedTopEntityClass, actualTopEntityClass);
  }

  /**
   * Method under test:
   * {@link AbstractHydratedCacheManager#getTopEntityClass(Object)}
   */
  @Test
  public void testGetTopEntityClass2() {
    // Arrange and Act
    Class<?> actualTopEntityClass = abstractHydratedCacheManager.getTopEntityClass("Entity");

    // Assert
    Class<String> expectedTopEntityClass = String.class;
    assertEquals(expectedTopEntityClass, actualTopEntityClass);
  }

  /**
   * Method under test: {@link AbstractHydratedCacheManager#useCacheRegionInKey()}
   */
  @Test
  public void testUseCacheRegionInKey() {
    // Arrange, Act and Assert
    assertTrue((new BigMemoryHydratedCacheJcacheEventListener()).useCacheRegionInKey());
    assertFalse((new BigMemoryHydratedCacheEventListener()).useCacheRegionInKey());
  }

  /**
   * Method under test: {@link AbstractHydratedCacheManager#clone()}
   */
  @Test
  public void testClone() throws CloneNotSupportedException {
    // Arrange
    BigMemoryHydratedCacheEventListener bigMemoryHydratedCacheEventListener = new BigMemoryHydratedCacheEventListener();

    // Act and Assert
    assertSame(bigMemoryHydratedCacheEventListener, bigMemoryHydratedCacheEventListener.clone());
  }
}
