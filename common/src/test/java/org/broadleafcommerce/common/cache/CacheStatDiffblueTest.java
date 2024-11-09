/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.cache;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class CacheStatDiffblueTest {
  /**
   * Test {@link CacheStat#getCacheHitCount()}.
   * <p>
   * Method under test: {@link CacheStat#getCacheHitCount()}
   */
  @Test
  public void testGetCacheHitCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new CacheStat()).getCacheHitCount().longValue());
  }

  /**
   * Test getters and setters.
   * <p>
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

  /**
   * Test {@link CacheStat#getRequestCount()}.
   * <p>
   * Method under test: {@link CacheStat#getRequestCount()}
   */
  @Test
  public void testGetRequestCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new CacheStat()).getRequestCount().longValue());
  }

  /**
   * Test {@link CacheStat#getHitRate()}.
   * <ul>
   *   <li>Given {@link CacheStat} (default constructor) incrementRequest.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheStat#getHitRate()}
   */
  @Test
  public void testGetHitRate_givenCacheStatIncrementRequest_thenReturnBigDecimalWith000() {
    // Arrange
    CacheStat cacheStat = new CacheStat();
    cacheStat.incrementRequest();

    // Act
    BigDecimal actualHitRate = cacheStat.getHitRate();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualHitRate);
  }

  /**
   * Test {@link CacheStat#getHitRate()}.
   * <ul>
   *   <li>Given {@link CacheStat} (default constructor).</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheStat#getHitRate()}
   */
  @Test
  public void testGetHitRate_givenCacheStat_thenReturnBigDecimalWith1() {
    // Arrange and Act
    BigDecimal actualHitRate = (new CacheStat()).getHitRate();

    // Assert
    assertEquals(new BigDecimal("-1"), actualHitRate);
  }
}
