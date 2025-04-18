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
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl;
import org.broadleafcommerce.common.config.domain.SystemProperty;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AbstractCacheMissAwareDiffblueTest {
  @Mock
  private CacheManager cacheManager;

  @Mock
  private StatisticsService statisticsService;

  @InjectMocks
  private SystemPropertiesDaoImpl systemPropertiesDaoImpl;

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractCacheMissAware.buildKey(String[])"})
  public void testBuildKey_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new SystemPropertiesDaoImpl()).buildKey());
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>Then return {@code ThreadLocalManager.notify.orphans_true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractCacheMissAware.buildKey(String[])"})
  public void testBuildKey_thenReturnThreadLocalManagerNotifyOrphansTrue() {
    // Arrange
    SystemPropertiesDaoImpl systemPropertiesDaoImpl = new SystemPropertiesDaoImpl();

    // Act and Assert
    assertEquals("ThreadLocalManager.notify.orphans_true",
        systemPropertiesDaoImpl.buildKey("ThreadLocalManager.notify.orphans", Boolean.TRUE.toString()));
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@link Boolean#TRUE} toString.</li>
   *   <li>Then return {@code 42_true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractCacheMissAware.buildKey(String[])"})
  public void testBuildKey_when42AndTrueToString_thenReturn42True() {
    // Arrange
    SystemPropertiesDaoImpl systemPropertiesDaoImpl = new SystemPropertiesDaoImpl();

    // Act and Assert
    assertEquals("42_true", systemPropertiesDaoImpl.buildKey("42", Boolean.TRUE.toString()));
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractCacheMissAware.buildKey(String[])"})
  public void testBuildKey_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new SystemPropertiesDaoImpl()).buildKey(""));
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractCacheMissAware.buildKey(String[])"})
  public void testBuildKey_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SystemPropertiesDaoImpl()).buildKey(null));
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>When {@code Params}.</li>
   *   <li>Then return {@code Params}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractCacheMissAware.buildKey(String[])"})
  public void testBuildKey_whenParams_thenReturnParams() {
    // Arrange, Act and Assert
    assertEquals("Params", (new SystemPropertiesDaoImpl()).buildKey("Params"));
  }

  /**
   * Test {@link AbstractCacheMissAware#getCache(String)}.
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#getCache(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache AbstractCacheMissAware.getCache(String)"})
  public void testGetCache_givenCacheManagerGetCacheReturnNull_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<String, SystemProperty> actualCache = systemPropertiesDaoImpl.getCache("Cache Name");

    // Assert
    verify(cacheManager).getCache(eq("Cache Name"));
    assertNull(actualCache);
  }
}
