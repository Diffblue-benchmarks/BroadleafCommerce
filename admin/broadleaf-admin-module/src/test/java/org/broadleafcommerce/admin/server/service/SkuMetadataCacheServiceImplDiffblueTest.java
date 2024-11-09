/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;

public class SkuMetadataCacheServiceImplDiffblueTest {
  /**
   * Test {@link SkuMetadataCacheServiceImpl#getEntireCache()}.
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#getEntireCache()}
   */
  @Test
  public void testGetEntireCache() {
    // Arrange, Act and Assert
    assertTrue((new SkuMetadataCacheServiceImpl()).getEntireCache().isEmpty());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#useCache()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#useCache()}
   */
  @Test
  public void testUseCache_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();
    skuMetadataCacheServiceImpl.addToCache("Cache Key", metadata);

    // Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.useCache());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#useCache()}.
   * <ul>
   *   <li>Given {@link SkuMetadataCacheServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#useCache()}
   */
  @Test
  public void testUseCache_givenSkuMetadataCacheServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuMetadataCacheServiceImpl()).useCache());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#getFromCache(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#getFromCache(String)}
   */
  @Test
  public void testGetFromCache_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();
    skuMetadataCacheServiceImpl.addToCache("Cache Key", metadata);

    // Act and Assert
    assertNull(skuMetadataCacheServiceImpl.getFromCache("Cache Key"));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#getFromCache(String)}.
   * <ul>
   *   <li>Given {@link SkuMetadataCacheServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#getFromCache(String)}
   */
  @Test
  public void testGetFromCache_givenSkuMetadataCacheServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuMetadataCacheServiceImpl()).getFromCache("Cache Key"));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}
   */
  @Test
  public void testAddToCache_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.addToCache("Cache Key", metadata));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}
   */
  @Test
  public void testAddToCache_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();

    // Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.addToCache("Cache Key", new HashMap<>()));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  public void testBuildCacheKey_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();
    skuMetadataCacheServiceImpl.addToCache("_", metadata);

    // Act and Assert
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl_42",
        skuMetadataCacheServiceImpl.buildCacheKey("42"));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   * <ul>
   *   <li>Then return
   * {@code org.broadleafcommerce.core.catalog.domain.SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  public void testBuildCacheKey_thenReturnOrgBroadleafcommerceCoreCatalogDomainSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl",
        (new SkuMetadataCacheServiceImpl()).buildCacheKey(null));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   * <ul>
   *   <li>Then return
   * {@code org.broadleafcommerce.core.catalog.domain.SkuImpl_42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  public void testBuildCacheKey_thenReturnOrgBroadleafcommerceCoreCatalogDomainSkuImpl42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl_42",
        (new SkuMetadataCacheServiceImpl()).buildCacheKey("42"));
  }
}
