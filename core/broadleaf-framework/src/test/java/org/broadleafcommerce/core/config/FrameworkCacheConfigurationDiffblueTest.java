/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.extensibility.cache.JCacheRegionConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FrameworkCacheConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FrameworkCacheConfigurationDiffblueTest {
  @Autowired
  private FrameworkCacheConfiguration frameworkCacheConfiguration;

  /**
   * Test {@link FrameworkCacheConfiguration#blCategoryProduct()}.
   * <p>
   * Method under test: {@link FrameworkCacheConfiguration#blCategoryProduct()}
   */
  @Test
  public void testBlCategoryProduct() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCategoryProductResult = frameworkCacheConfiguration.blCategoryProduct();

    // Assert
    assertEquals("blCategoryProduct", actualBlCategoryProductResult.getCacheName());
    assertNull(actualBlCategoryProductResult.getConfiguration());
    assertEquals(40000, actualBlCategoryProductResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlCategoryProductResult.getTtlSeconds());
    assertTrue(actualBlCategoryProductResult.getEnableManagement());
    assertTrue(actualBlCategoryProductResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlCategoryProductResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlCategoryProductResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blCategoryRelationships()}.
   * <p>
   * Method under test:
   * {@link FrameworkCacheConfiguration#blCategoryRelationships()}
   */
  @Test
  public void testBlCategoryRelationships() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCategoryRelationshipsResult = frameworkCacheConfiguration
        .blCategoryRelationships();

    // Assert
    assertEquals("blCategoryRelationships", actualBlCategoryRelationshipsResult.getCacheName());
    assertNull(actualBlCategoryRelationshipsResult.getConfiguration());
    assertEquals(10000, actualBlCategoryRelationshipsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlCategoryRelationshipsResult.getTtlSeconds());
    assertTrue(actualBlCategoryRelationshipsResult.getEnableManagement());
    assertTrue(actualBlCategoryRelationshipsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlCategoryRelationshipsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlCategoryRelationshipsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blFulfillmentOptionElements()}.
   * <p>
   * Method under test:
   * {@link FrameworkCacheConfiguration#blFulfillmentOptionElements()}
   */
  @Test
  public void testBlFulfillmentOptionElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlFulfillmentOptionElementsResult = frameworkCacheConfiguration
        .blFulfillmentOptionElements();

    // Assert
    assertEquals("blFulfillmentOptionElements", actualBlFulfillmentOptionElementsResult.getCacheName());
    assertNull(actualBlFulfillmentOptionElementsResult.getConfiguration());
    assertEquals(1000, actualBlFulfillmentOptionElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlFulfillmentOptionElementsResult.getTtlSeconds());
    assertTrue(actualBlFulfillmentOptionElementsResult.getEnableManagement());
    assertTrue(actualBlFulfillmentOptionElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlFulfillmentOptionElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlFulfillmentOptionElementsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blProductAttributes()}.
   * <p>
   * Method under test: {@link FrameworkCacheConfiguration#blProductAttributes()}
   */
  @Test
  public void testBlProductAttributes() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductAttributesResult = frameworkCacheConfiguration.blProductAttributes();

    // Assert
    assertEquals("blProductAttributes", actualBlProductAttributesResult.getCacheName());
    assertNull(actualBlProductAttributesResult.getConfiguration());
    assertEquals(10000, actualBlProductAttributesResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductAttributesResult.getTtlSeconds());
    assertTrue(actualBlProductAttributesResult.getEnableManagement());
    assertTrue(actualBlProductAttributesResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlProductAttributesResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlProductAttributesResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blProductOptions()}.
   * <p>
   * Method under test: {@link FrameworkCacheConfiguration#blProductOptions()}
   */
  @Test
  public void testBlProductOptions() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductOptionsResult = frameworkCacheConfiguration.blProductOptions();

    // Assert
    assertEquals("blProductOptions", actualBlProductOptionsResult.getCacheName());
    assertNull(actualBlProductOptionsResult.getConfiguration());
    assertEquals(5000, actualBlProductOptionsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductOptionsResult.getTtlSeconds());
    assertTrue(actualBlProductOptionsResult.getEnableManagement());
    assertTrue(actualBlProductOptionsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlProductOptionsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlProductOptionsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blProductRelationships()}.
   * <p>
   * Method under test:
   * {@link FrameworkCacheConfiguration#blProductRelationships()}
   */
  @Test
  public void testBlProductRelationships() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductRelationshipsResult = frameworkCacheConfiguration.blProductRelationships();

    // Assert
    assertEquals("blProductRelationships", actualBlProductRelationshipsResult.getCacheName());
    assertNull(actualBlProductRelationshipsResult.getConfiguration());
    assertEquals(30000, actualBlProductRelationshipsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductRelationshipsResult.getTtlSeconds());
    assertTrue(actualBlProductRelationshipsResult.getEnableManagement());
    assertTrue(actualBlProductRelationshipsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlProductRelationshipsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlProductRelationshipsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blRelatedProducts()}.
   * <p>
   * Method under test: {@link FrameworkCacheConfiguration#blRelatedProducts()}
   */
  @Test
  public void testBlRelatedProducts() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlRelatedProductsResult = frameworkCacheConfiguration.blRelatedProducts();

    // Assert
    assertEquals("blRelatedProducts", actualBlRelatedProductsResult.getCacheName());
    assertNull(actualBlRelatedProductsResult.getConfiguration());
    assertEquals(1000, actualBlRelatedProductsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlRelatedProductsResult.getTtlSeconds());
    assertTrue(actualBlRelatedProductsResult.getEnableManagement());
    assertTrue(actualBlRelatedProductsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlRelatedProductsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlRelatedProductsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blSearchElements()}.
   * <p>
   * Method under test: {@link FrameworkCacheConfiguration#blSearchElements()}
   */
  @Test
  public void testBlSearchElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSearchElementsResult = frameworkCacheConfiguration.blSearchElements();

    // Assert
    assertEquals("blSearchElements", actualBlSearchElementsResult.getCacheName());
    assertNull(actualBlSearchElementsResult.getConfiguration());
    assertEquals(5000, actualBlSearchElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlSearchElementsResult.getTtlSeconds());
    assertTrue(actualBlSearchElementsResult.getEnableManagement());
    assertTrue(actualBlSearchElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlSearchElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlSearchElementsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blSkuMedia()}.
   * <p>
   * Method under test: {@link FrameworkCacheConfiguration#blSkuMedia()}
   */
  @Test
  public void testBlSkuMedia() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSkuMediaResult = frameworkCacheConfiguration.blSkuMedia();

    // Assert
    assertEquals("blSkuMedia", actualBlSkuMediaResult.getCacheName());
    assertNull(actualBlSkuMediaResult.getConfiguration());
    assertEquals(40000, actualBlSkuMediaResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlSkuMediaResult.getTtlSeconds());
    assertTrue(actualBlSkuMediaResult.getEnableManagement());
    assertTrue(actualBlSkuMediaResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlSkuMediaResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlSkuMediaResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blStoreElements()}.
   * <p>
   * Method under test: {@link FrameworkCacheConfiguration#blStoreElements()}
   */
  @Test
  public void testBlStoreElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlStoreElementsResult = frameworkCacheConfiguration.blStoreElements();

    // Assert
    assertEquals("blStoreElements", actualBlStoreElementsResult.getCacheName());
    assertNull(actualBlStoreElementsResult.getConfiguration());
    assertEquals(1000, actualBlStoreElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlStoreElementsResult.getTtlSeconds());
    assertTrue(actualBlStoreElementsResult.getEnableManagement());
    assertTrue(actualBlStoreElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlStoreElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlStoreElementsResult.getValue());
  }
}
