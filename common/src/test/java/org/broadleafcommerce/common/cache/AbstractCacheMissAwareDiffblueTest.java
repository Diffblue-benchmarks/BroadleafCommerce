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

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Mock private CacheManager cacheManager;

  @InjectMocks private SystemPropertiesDaoImpl systemPropertiesDaoImpl;

  /**
   * Test {@link AbstractCacheMissAware#getCache(String)}.
   *
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCacheMissAware#getCache(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache AbstractCacheMissAware.getCache(String)"})
  public void testGetCache_givenCacheManagerGetCacheReturnNull_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<String, SystemProperty> actualCache = systemPropertiesDaoImpl.getCache("Cache Name");

    // Assert
    verify(cacheManager).getCache("Cache Name");
    assertNull(actualCache);
  }
}
