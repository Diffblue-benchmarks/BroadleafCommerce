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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;

public class SkuMetadataCacheServiceImplDiffblueTest {
  /**
   * Method under test: {@link SkuMetadataCacheServiceImpl#getEntireCache()}
   */
  @Test
  public void testGetEntireCache() {
    // Arrange, Act and Assert
    assertTrue((new SkuMetadataCacheServiceImpl()).getEntireCache().isEmpty());
  }

  /**
   * Method under test: {@link SkuMetadataCacheServiceImpl#useCache()}
   */
  @Test
  public void testUseCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuMetadataCacheServiceImpl()).useCache());
  }

  /**
   * Method under test: {@link SkuMetadataCacheServiceImpl#useCache()}
   */
  @Test
  public void testUseCache2() {
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
   * Method under test: {@link SkuMetadataCacheServiceImpl#getFromCache(String)}
   */
  @Test
  public void testGetFromCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuMetadataCacheServiceImpl()).getFromCache("Cache Key"));
  }

  /**
   * Method under test: {@link SkuMetadataCacheServiceImpl#getFromCache(String)}
   */
  @Test
  public void testGetFromCache2() {
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
   * Method under test:
   * {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}
   */
  @Test
  public void testAddToCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();

    // Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.addToCache("Cache Key", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}
   */
  @Test
  public void testAddToCache2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.addToCache("Cache Key", metadata));
  }

  /**
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  public void testBuildCacheKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl_42",
        (new SkuMetadataCacheServiceImpl()).buildCacheKey("42"));
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl",
        (new SkuMetadataCacheServiceImpl()).buildCacheKey(null));
  }

  /**
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  public void testBuildCacheKey2() {
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
}
