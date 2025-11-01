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
package org.broadleafcommerce.common.cache;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class CacheStatDiffblueTest {
  /**
   * Method under test: {@link CacheStat#getCacheHitCount()}
   */
  @Test
  public void testGetCacheHitCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new CacheStat()).getCacheHitCount().longValue());
  }

  /**
   * Method under test: {@link CacheStat#getRequestCount()}
   */
  @Test
  public void testGetRequestCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new CacheStat()).getRequestCount().longValue());
  }

  /**
   * Method under test: {@link CacheStat#getHitRate()}
   */
  @Test
  public void testGetHitRate() {
    // Arrange and Act
    BigDecimal actualHitRate = (new CacheStat()).getHitRate();

    // Assert
    assertEquals(new BigDecimal("-1"), actualHitRate);
  }

  /**
   * Method under test: {@link CacheStat#getHitRate()}
   */
  @Test
  public void testGetHitRate2() {
    // Arrange
    CacheStat cacheStat = new CacheStat();
    cacheStat.incrementRequest();

    // Act
    BigDecimal actualHitRate = cacheStat.getHitRate();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualHitRate);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheStat#setLastLogTime(Long)}
   *   <li>{@link CacheStat#getLastLogTime()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CacheStat cacheStat = new CacheStat();

    // Act
    cacheStat.setLastLogTime(1L);

    // Assert that nothing has changed
    assertEquals(1L, cacheStat.getLastLogTime().longValue());
  }
}
