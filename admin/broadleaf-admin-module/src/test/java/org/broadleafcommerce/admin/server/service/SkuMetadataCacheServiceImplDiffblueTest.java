/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SkuMetadataCacheServiceImplDiffblueTest {
  @InjectMocks
  private SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl;

  /**
   * Test {@link SkuMetadataCacheServiceImpl#getEntireCache()}.
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#getEntireCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuMetadataCacheServiceImpl.getEntireCache()"})
  public void testGetEntireCache() {
    // Arrange, Act and Assert
    assertTrue((new SkuMetadataCacheServiceImpl()).getEntireCache().isEmpty());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#useCache()}.
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#useCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuMetadataCacheServiceImpl.useCache()"})
  public void testUseCache() {
    // Arrange, Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.useCache());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#getFromCache(String)}.
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#getFromCache(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuMetadataCacheServiceImpl.getFromCache(String)"})
  public void testGetFromCache() {
    // Arrange, Act and Assert
    assertNull(skuMetadataCacheServiceImpl.getFromCache("Cache Key"));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}.
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuMetadataCacheServiceImpl.addToCache(String, Map)"})
  public void testAddToCache() {
    // Arrange, Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.addToCache("Cache Key", new HashMap<>()));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   * <ul>
   *   <li>Then return {@code org.broadleafcommerce.core.catalog.domain.SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuMetadataCacheServiceImpl.buildCacheKey(String)"})
  public void testBuildCacheKey_thenReturnOrgBroadleafcommerceCoreCatalogDomainSkuImpl() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", skuMetadataCacheServiceImpl.buildCacheKey(null));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   * <ul>
   *   <li>Then return {@code org.broadleafcommerce.core.catalog.domain.SkuImpl_42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuMetadataCacheServiceImpl.buildCacheKey(String)"})
  public void testBuildCacheKey_thenReturnOrgBroadleafcommerceCoreCatalogDomainSkuImpl42() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl_42",
        skuMetadataCacheServiceImpl.buildCacheKey("42"));
  }
}
