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
package org.broadleafcommerce.common.config;

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

@ContextConfiguration(classes = {CommonCacheConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonCacheConfigurationDiffblueTest {
  @Autowired
  private CommonCacheConfiguration commonCacheConfiguration;

  /**
   * Test {@link CommonCacheConfiguration#defaultUpdateTimestampsRegion()}.
   * <p>
   * Method under test:
   * {@link CommonCacheConfiguration#defaultUpdateTimestampsRegion()}
   */
  @Test
  public void testDefaultUpdateTimestampsRegion() {
    // Arrange and Act
    JCacheRegionConfiguration actualDefaultUpdateTimestampsRegionResult = commonCacheConfiguration
        .defaultUpdateTimestampsRegion();

    // Assert
    assertEquals("default-update-timestamps-region", actualDefaultUpdateTimestampsRegionResult.getCacheName());
    assertNull(actualDefaultUpdateTimestampsRegionResult.getConfiguration());
    assertEquals(-1, actualDefaultUpdateTimestampsRegionResult.getTtlSeconds());
    assertEquals(5000, actualDefaultUpdateTimestampsRegionResult.getMaxElementsInMemory());
    assertTrue(actualDefaultUpdateTimestampsRegionResult.getEnableManagement());
    assertTrue(actualDefaultUpdateTimestampsRegionResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualDefaultUpdateTimestampsRegionResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualDefaultUpdateTimestampsRegionResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#defaultQueryResultsRegion()}.
   * <p>
   * Method under test:
   * {@link CommonCacheConfiguration#defaultQueryResultsRegion()}
   */
  @Test
  public void testDefaultQueryResultsRegion() {
    // Arrange and Act
    JCacheRegionConfiguration actualDefaultQueryResultsRegionResult = commonCacheConfiguration
        .defaultQueryResultsRegion();

    // Assert
    assertEquals("default-query-results-region", actualDefaultQueryResultsRegionResult.getCacheName());
    assertNull(actualDefaultQueryResultsRegionResult.getConfiguration());
    assertEquals(600, actualDefaultQueryResultsRegionResult.getTtlSeconds());
    assertTrue(actualDefaultQueryResultsRegionResult.getEnableManagement());
    assertTrue(actualDefaultQueryResultsRegionResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualDefaultQueryResultsRegionResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualDefaultQueryResultsRegionResult.getMaxElementsInMemory());
    assertSame(key, actualDefaultQueryResultsRegionResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blStandardElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blStandardElements()}
   */
  @Test
  public void testBlStandardElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlStandardElementsResult = commonCacheConfiguration.blStandardElements();

    // Assert
    assertEquals("blStandardElements", actualBlStandardElementsResult.getCacheName());
    assertNull(actualBlStandardElementsResult.getConfiguration());
    assertEquals(5000, actualBlStandardElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlStandardElementsResult.getTtlSeconds());
    assertTrue(actualBlStandardElementsResult.getEnableManagement());
    assertTrue(actualBlStandardElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlStandardElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlStandardElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blProducts()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blProducts()}
   */
  @Test
  public void testBlProducts() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductsResult = commonCacheConfiguration.blProducts();

    // Assert
    assertEquals("blProducts", actualBlProductsResult.getCacheName());
    assertNull(actualBlProductsResult.getConfiguration());
    assertEquals(100000, actualBlProductsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductsResult.getTtlSeconds());
    assertTrue(actualBlProductsResult.getEnableManagement());
    assertTrue(actualBlProductsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlProductsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlProductsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blProductUrlCache()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blProductUrlCache()}
   */
  @Test
  public void testBlProductUrlCache() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductUrlCacheResult = commonCacheConfiguration.blProductUrlCache();

    // Assert
    assertEquals("blProductUrlCache", actualBlProductUrlCacheResult.getCacheName());
    assertNull(actualBlProductUrlCacheResult.getConfiguration());
    assertEquals(3600, actualBlProductUrlCacheResult.getTtlSeconds());
    assertTrue(actualBlProductUrlCacheResult.getEnableManagement());
    assertTrue(actualBlProductUrlCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlProductUrlCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlProductUrlCacheResult.getMaxElementsInMemory());
    assertSame(key, actualBlProductUrlCacheResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blCategories()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blCategories()}
   */
  @Test
  public void testBlCategories() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCategoriesResult = commonCacheConfiguration.blCategories();

    // Assert
    assertEquals("blCategories", actualBlCategoriesResult.getCacheName());
    assertNull(actualBlCategoriesResult.getConfiguration());
    assertEquals(3000, actualBlCategoriesResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlCategoriesResult.getTtlSeconds());
    assertTrue(actualBlCategoriesResult.getEnableManagement());
    assertTrue(actualBlCategoriesResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlCategoriesResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlCategoriesResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blCategoryUrlCache()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blCategoryUrlCache()}
   */
  @Test
  public void testBlCategoryUrlCache() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCategoryUrlCacheResult = commonCacheConfiguration.blCategoryUrlCache();

    // Assert
    assertEquals("blCategoryUrlCache", actualBlCategoryUrlCacheResult.getCacheName());
    assertNull(actualBlCategoryUrlCacheResult.getConfiguration());
    assertEquals(3600, actualBlCategoryUrlCacheResult.getTtlSeconds());
    assertTrue(actualBlCategoryUrlCacheResult.getEnableManagement());
    assertTrue(actualBlCategoryUrlCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlCategoryUrlCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlCategoryUrlCacheResult.getMaxElementsInMemory());
    assertSame(key, actualBlCategoryUrlCacheResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blOffers()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blOffers()}
   */
  @Test
  public void testBlOffers() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlOffersResult = commonCacheConfiguration.blOffers();

    // Assert
    assertEquals("blOffers", actualBlOffersResult.getCacheName());
    assertNull(actualBlOffersResult.getConfiguration());
    assertEquals(100000, actualBlOffersResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlOffersResult.getTtlSeconds());
    assertTrue(actualBlOffersResult.getEnableManagement());
    assertTrue(actualBlOffersResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlOffersResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlOffersResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blInventoryElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blInventoryElements()}
   */
  @Test
  public void testBlInventoryElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlInventoryElementsResult = commonCacheConfiguration.blInventoryElements();

    // Assert
    assertEquals("blInventoryElements", actualBlInventoryElementsResult.getCacheName());
    assertNull(actualBlInventoryElementsResult.getConfiguration());
    assertEquals(100000, actualBlInventoryElementsResult.getMaxElementsInMemory());
    assertEquals(60, actualBlInventoryElementsResult.getTtlSeconds());
    assertTrue(actualBlInventoryElementsResult.getEnableManagement());
    assertTrue(actualBlInventoryElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlInventoryElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlInventoryElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#queryCatalog()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#queryCatalog()}
   */
  @Test
  public void testQueryCatalog() {
    // Arrange and Act
    JCacheRegionConfiguration actualQueryCatalogResult = commonCacheConfiguration.queryCatalog();

    // Assert
    assertEquals("query.Catalog", actualQueryCatalogResult.getCacheName());
    assertNull(actualQueryCatalogResult.getConfiguration());
    assertEquals(10000, actualQueryCatalogResult.getMaxElementsInMemory());
    assertEquals(600, actualQueryCatalogResult.getTtlSeconds());
    assertTrue(actualQueryCatalogResult.getEnableManagement());
    assertTrue(actualQueryCatalogResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualQueryCatalogResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualQueryCatalogResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#queryPriceList()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#queryPriceList()}
   */
  @Test
  public void testQueryPriceList() {
    // Arrange and Act
    JCacheRegionConfiguration actualQueryPriceListResult = commonCacheConfiguration.queryPriceList();

    // Assert
    assertEquals("query.PriceList", actualQueryPriceListResult.getCacheName());
    assertNull(actualQueryPriceListResult.getConfiguration());
    assertEquals(600, actualQueryPriceListResult.getTtlSeconds());
    assertTrue(actualQueryPriceListResult.getEnableManagement());
    assertTrue(actualQueryPriceListResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualQueryPriceListResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualQueryPriceListResult.getMaxElementsInMemory());
    assertSame(key, actualQueryPriceListResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#queryCms()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#queryCms()}
   */
  @Test
  public void testQueryCms() {
    // Arrange and Act
    JCacheRegionConfiguration actualQueryCmsResult = commonCacheConfiguration.queryCms();

    // Assert
    assertEquals("query.Cms", actualQueryCmsResult.getCacheName());
    assertNull(actualQueryCmsResult.getConfiguration());
    assertEquals(600, actualQueryCmsResult.getTtlSeconds());
    assertTrue(actualQueryCmsResult.getEnableManagement());
    assertTrue(actualQueryCmsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualQueryCmsResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER, actualQueryCmsResult.getMaxElementsInMemory());
    assertSame(key, actualQueryCmsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#queryOffer()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#queryOffer()}
   */
  @Test
  public void testQueryOffer() {
    // Arrange and Act
    JCacheRegionConfiguration actualQueryOfferResult = commonCacheConfiguration.queryOffer();

    // Assert
    assertEquals("query.Offer", actualQueryOfferResult.getCacheName());
    assertNull(actualQueryOfferResult.getConfiguration());
    assertEquals(600, actualQueryOfferResult.getTtlSeconds());
    assertTrue(actualQueryOfferResult.getEnableManagement());
    assertTrue(actualQueryOfferResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualQueryOfferResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER, actualQueryOfferResult.getMaxElementsInMemory());
    assertSame(key, actualQueryOfferResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blOrderElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blOrderElements()}
   */
  @Test
  public void testBlOrderElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlOrderElementsResult = commonCacheConfiguration.blOrderElements();

    // Assert
    assertEquals("blOrderElements", actualBlOrderElementsResult.getCacheName());
    assertNull(actualBlOrderElementsResult.getConfiguration());
    assertEquals(100000, actualBlOrderElementsResult.getMaxElementsInMemory());
    assertEquals(600, actualBlOrderElementsResult.getTtlSeconds());
    assertTrue(actualBlOrderElementsResult.getEnableManagement());
    assertTrue(actualBlOrderElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlOrderElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlOrderElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blCustomerElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blCustomerElements()}
   */
  @Test
  public void testBlCustomerElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCustomerElementsResult = commonCacheConfiguration.blCustomerElements();

    // Assert
    assertEquals("blCustomerElements", actualBlCustomerElementsResult.getCacheName());
    assertNull(actualBlCustomerElementsResult.getConfiguration());
    assertEquals(100000, actualBlCustomerElementsResult.getMaxElementsInMemory());
    assertEquals(600, actualBlCustomerElementsResult.getTtlSeconds());
    assertTrue(actualBlCustomerElementsResult.getEnableManagement());
    assertTrue(actualBlCustomerElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlCustomerElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlCustomerElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blCustomerAddress()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blCustomerAddress()}
   */
  @Test
  public void testBlCustomerAddress() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCustomerAddressResult = commonCacheConfiguration.blCustomerAddress();

    // Assert
    assertEquals("blCustomerAddress", actualBlCustomerAddressResult.getCacheName());
    assertNull(actualBlCustomerAddressResult.getConfiguration());
    assertEquals(600, actualBlCustomerAddressResult.getTtlSeconds());
    assertTrue(actualBlCustomerAddressResult.getEnableManagement());
    assertTrue(actualBlCustomerAddressResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlCustomerAddressResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlCustomerAddressResult.getMaxElementsInMemory());
    assertSame(key, actualBlCustomerAddressResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#queryOrder()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#queryOrder()}
   */
  @Test
  public void testQueryOrder() {
    // Arrange and Act
    JCacheRegionConfiguration actualQueryOrderResult = commonCacheConfiguration.queryOrder();

    // Assert
    assertEquals("query.Order", actualQueryOrderResult.getCacheName());
    assertNull(actualQueryOrderResult.getConfiguration());
    assertEquals(60, actualQueryOrderResult.getTtlSeconds());
    assertTrue(actualQueryOrderResult.getEnableManagement());
    assertTrue(actualQueryOrderResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualQueryOrderResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER, actualQueryOrderResult.getMaxElementsInMemory());
    assertSame(key, actualQueryOrderResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#querySearch()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#querySearch()}
   */
  @Test
  public void testQuerySearch() {
    // Arrange and Act
    JCacheRegionConfiguration actualQuerySearchResult = commonCacheConfiguration.querySearch();

    // Assert
    assertEquals("query.Search", actualQuerySearchResult.getCacheName());
    assertNull(actualQuerySearchResult.getConfiguration());
    assertEquals(600, actualQuerySearchResult.getTtlSeconds());
    assertTrue(actualQuerySearchResult.getEnableManagement());
    assertTrue(actualQuerySearchResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualQuerySearchResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualQuerySearchResult.getMaxElementsInMemory());
    assertSame(key, actualQuerySearchResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#generatedResourceCache()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#generatedResourceCache()}
   */
  @Test
  public void testGeneratedResourceCache() {
    // Arrange and Act
    JCacheRegionConfiguration actualGeneratedResourceCacheResult = commonCacheConfiguration.generatedResourceCache();

    // Assert
    assertEquals("generatedResourceCache", actualGeneratedResourceCacheResult.getCacheName());
    assertNull(actualGeneratedResourceCacheResult.getConfiguration());
    assertEquals(600, actualGeneratedResourceCacheResult.getTtlSeconds());
    assertTrue(actualGeneratedResourceCacheResult.getEnableManagement());
    assertTrue(actualGeneratedResourceCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualGeneratedResourceCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(BroadleafSharedOverrideProfileAwarePropertySource.DEFAULT_ORDER,
        actualGeneratedResourceCacheResult.getMaxElementsInMemory());
    assertSame(key, actualGeneratedResourceCacheResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blTemplateElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blTemplateElements()}
   */
  @Test
  public void testBlTemplateElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlTemplateElementsResult = commonCacheConfiguration.blTemplateElements();

    // Assert
    assertEquals("blTemplateElements", actualBlTemplateElementsResult.getCacheName());
    assertNull(actualBlTemplateElementsResult.getConfiguration());
    assertEquals(3600, actualBlTemplateElementsResult.getTtlSeconds());
    assertEquals(5000, actualBlTemplateElementsResult.getMaxElementsInMemory());
    assertTrue(actualBlTemplateElementsResult.getEnableManagement());
    assertTrue(actualBlTemplateElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlTemplateElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlTemplateElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blTranslationElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blTranslationElements()}
   */
  @Test
  public void testBlTranslationElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlTranslationElementsResult = commonCacheConfiguration.blTranslationElements();

    // Assert
    assertEquals("blTranslationElements", actualBlTranslationElementsResult.getCacheName());
    assertNull(actualBlTranslationElementsResult.getConfiguration());
    assertEquals(10000000, actualBlTranslationElementsResult.getMaxElementsInMemory());
    assertEquals(3600, actualBlTranslationElementsResult.getTtlSeconds());
    assertTrue(actualBlTranslationElementsResult.getEnableManagement());
    assertTrue(actualBlTranslationElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlTranslationElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlTranslationElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blBatchTranslationCache()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blBatchTranslationCache()}
   */
  @Test
  public void testBlBatchTranslationCache() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlBatchTranslationCacheResult = commonCacheConfiguration.blBatchTranslationCache();

    // Assert
    assertEquals("blBatchTranslationCache", actualBlBatchTranslationCacheResult.getCacheName());
    assertNull(actualBlBatchTranslationCacheResult.getConfiguration());
    assertEquals(-1, actualBlBatchTranslationCacheResult.getTtlSeconds());
    assertEquals(10000, actualBlBatchTranslationCacheResult.getMaxElementsInMemory());
    assertTrue(actualBlBatchTranslationCacheResult.getEnableManagement());
    assertTrue(actualBlBatchTranslationCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlBatchTranslationCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlBatchTranslationCacheResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blConfigurationModuleElements()}.
   * <p>
   * Method under test:
   * {@link CommonCacheConfiguration#blConfigurationModuleElements()}
   */
  @Test
  public void testBlConfigurationModuleElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlConfigurationModuleElementsResult = commonCacheConfiguration
        .blConfigurationModuleElements();

    // Assert
    assertEquals("blConfigurationModuleElements", actualBlConfigurationModuleElementsResult.getCacheName());
    assertNull(actualBlConfigurationModuleElementsResult.getConfiguration());
    assertEquals(600, actualBlConfigurationModuleElementsResult.getTtlSeconds());
    assertTrue(actualBlConfigurationModuleElementsResult.getEnableManagement());
    assertTrue(actualBlConfigurationModuleElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlConfigurationModuleElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlConfigurationModuleElementsResult.getMaxElementsInMemory());
    assertSame(key, actualBlConfigurationModuleElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#queryConfigurationModuleElements()}.
   * <p>
   * Method under test:
   * {@link CommonCacheConfiguration#queryConfigurationModuleElements()}
   */
  @Test
  public void testQueryConfigurationModuleElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualQueryConfigurationModuleElementsResult = commonCacheConfiguration
        .queryConfigurationModuleElements();

    // Assert
    assertEquals("query.ConfigurationModuleElements", actualQueryConfigurationModuleElementsResult.getCacheName());
    assertNull(actualQueryConfigurationModuleElementsResult.getConfiguration());
    assertEquals(600, actualQueryConfigurationModuleElementsResult.getTtlSeconds());
    assertTrue(actualQueryConfigurationModuleElementsResult.getEnableManagement());
    assertTrue(actualQueryConfigurationModuleElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualQueryConfigurationModuleElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualQueryConfigurationModuleElementsResult.getMaxElementsInMemory());
    assertSame(key, actualQueryConfigurationModuleElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blSystemPropertyElements()}.
   * <p>
   * Method under test:
   * {@link CommonCacheConfiguration#blSystemPropertyElements()}
   */
  @Test
  public void testBlSystemPropertyElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSystemPropertyElementsResult = commonCacheConfiguration
        .blSystemPropertyElements();

    // Assert
    assertEquals("blSystemPropertyElements", actualBlSystemPropertyElementsResult.getCacheName());
    assertNull(actualBlSystemPropertyElementsResult.getConfiguration());
    assertEquals(600, actualBlSystemPropertyElementsResult.getTtlSeconds());
    assertTrue(actualBlSystemPropertyElementsResult.getEnableManagement());
    assertTrue(actualBlSystemPropertyElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlSystemPropertyElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlSystemPropertyElementsResult.getMaxElementsInMemory());
    assertSame(key, actualBlSystemPropertyElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blSystemPropertyNullCheckCache()}.
   * <p>
   * Method under test:
   * {@link CommonCacheConfiguration#blSystemPropertyNullCheckCache()}
   */
  @Test
  public void testBlSystemPropertyNullCheckCache() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSystemPropertyNullCheckCacheResult = commonCacheConfiguration
        .blSystemPropertyNullCheckCache();

    // Assert
    assertEquals("blSystemPropertyNullCheckCache", actualBlSystemPropertyNullCheckCacheResult.getCacheName());
    assertNull(actualBlSystemPropertyNullCheckCacheResult.getConfiguration());
    assertEquals(600, actualBlSystemPropertyNullCheckCacheResult.getTtlSeconds());
    assertTrue(actualBlSystemPropertyNullCheckCacheResult.getEnableManagement());
    assertTrue(actualBlSystemPropertyNullCheckCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlSystemPropertyNullCheckCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlSystemPropertyNullCheckCacheResult.getMaxElementsInMemory());
    assertSame(key, actualBlSystemPropertyNullCheckCacheResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blBundleElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blBundleElements()}
   */
  @Test
  public void testBlBundleElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlBundleElementsResult = commonCacheConfiguration.blBundleElements();

    // Assert
    assertEquals("blBundleElements", actualBlBundleElementsResult.getCacheName());
    assertNull(actualBlBundleElementsResult.getConfiguration());
    assertEquals(86400, actualBlBundleElementsResult.getTtlSeconds());
    assertTrue(actualBlBundleElementsResult.getEnableManagement());
    assertTrue(actualBlBundleElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlBundleElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlBundleElementsResult.getMaxElementsInMemory());
    assertSame(key, actualBlBundleElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blResourceCacheElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blResourceCacheElements()}
   */
  @Test
  public void testBlResourceCacheElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlResourceCacheElementsResult = commonCacheConfiguration.blResourceCacheElements();

    // Assert
    assertEquals("blResourceCacheElements", actualBlResourceCacheElementsResult.getCacheName());
    assertNull(actualBlResourceCacheElementsResult.getConfiguration());
    assertEquals(86400, actualBlResourceCacheElementsResult.getTtlSeconds());
    assertTrue(actualBlResourceCacheElementsResult.getEnableManagement());
    assertTrue(actualBlResourceCacheElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlResourceCacheElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlResourceCacheElementsResult.getMaxElementsInMemory());
    assertSame(key, actualBlResourceCacheElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blResourceTransformerCacheElements()}.
   * <p>
   * Method under test:
   * {@link CommonCacheConfiguration#blResourceTransformerCacheElements()}
   */
  @Test
  public void testBlResourceTransformerCacheElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlResourceTransformerCacheElementsResult = commonCacheConfiguration
        .blResourceTransformerCacheElements();

    // Assert
    assertEquals("blResourceTransformerCacheElements", actualBlResourceTransformerCacheElementsResult.getCacheName());
    assertNull(actualBlResourceTransformerCacheElementsResult.getConfiguration());
    assertEquals(86400, actualBlResourceTransformerCacheElementsResult.getTtlSeconds());
    assertTrue(actualBlResourceTransformerCacheElementsResult.getEnableManagement());
    assertTrue(actualBlResourceTransformerCacheElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlResourceTransformerCacheElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlResourceTransformerCacheElementsResult.getMaxElementsInMemory());
    assertSame(key, actualBlResourceTransformerCacheElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blSandBoxElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blSandBoxElements()}
   */
  @Test
  public void testBlSandBoxElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSandBoxElementsResult = commonCacheConfiguration.blSandBoxElements();

    // Assert
    assertEquals("blSandBoxElements", actualBlSandBoxElementsResult.getCacheName());
    assertNull(actualBlSandBoxElementsResult.getConfiguration());
    assertEquals(2000, actualBlSandBoxElementsResult.getMaxElementsInMemory());
    assertEquals(3, actualBlSandBoxElementsResult.getTtlSeconds());
    assertTrue(actualBlSandBoxElementsResult.getEnableManagement());
    assertTrue(actualBlSandBoxElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlSandBoxElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlSandBoxElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#queryblSandBoxElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#queryblSandBoxElements()}
   */
  @Test
  public void testQueryblSandBoxElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualQueryblSandBoxElementsResult = commonCacheConfiguration.queryblSandBoxElements();

    // Assert
    assertEquals("query.blSandBoxElements", actualQueryblSandBoxElementsResult.getCacheName());
    assertNull(actualQueryblSandBoxElementsResult.getConfiguration());
    assertEquals(3, actualQueryblSandBoxElementsResult.getTtlSeconds());
    assertEquals(500, actualQueryblSandBoxElementsResult.getMaxElementsInMemory());
    assertTrue(actualQueryblSandBoxElementsResult.getEnableManagement());
    assertTrue(actualQueryblSandBoxElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualQueryblSandBoxElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualQueryblSandBoxElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blSecurityElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blSecurityElements()}
   */
  @Test
  public void testBlSecurityElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSecurityElementsResult = commonCacheConfiguration.blSecurityElements();

    // Assert
    assertEquals("blSecurityElements", actualBlSecurityElementsResult.getCacheName());
    assertNull(actualBlSecurityElementsResult.getConfiguration());
    assertEquals(86400, actualBlSecurityElementsResult.getTtlSeconds());
    assertTrue(actualBlSecurityElementsResult.getEnableManagement());
    assertTrue(actualBlSecurityElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlSecurityElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlSecurityElementsResult.getMaxElementsInMemory());
    assertSame(key, actualBlSecurityElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blSiteElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blSiteElements()}
   */
  @Test
  public void testBlSiteElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSiteElementsResult = commonCacheConfiguration.blSiteElements();

    // Assert
    assertEquals("blSiteElements", actualBlSiteElementsResult.getCacheName());
    assertNull(actualBlSiteElementsResult.getConfiguration());
    assertEquals(3600, actualBlSiteElementsResult.getTtlSeconds());
    assertEquals(5000, actualBlSiteElementsResult.getMaxElementsInMemory());
    assertTrue(actualBlSiteElementsResult.getEnableManagement());
    assertTrue(actualBlSiteElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlSiteElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlSiteElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blSiteElementsQuery()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blSiteElementsQuery()}
   */
  @Test
  public void testBlSiteElementsQuery() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSiteElementsQueryResult = commonCacheConfiguration.blSiteElementsQuery();

    // Assert
    assertEquals("blSiteElementsQuery", actualBlSiteElementsQueryResult.getCacheName());
    assertNull(actualBlSiteElementsQueryResult.getConfiguration());
    assertEquals(3600, actualBlSiteElementsQueryResult.getTtlSeconds());
    assertTrue(actualBlSiteElementsQueryResult.getEnableManagement());
    assertTrue(actualBlSiteElementsQueryResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlSiteElementsQueryResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlSiteElementsQueryResult.getMaxElementsInMemory());
    assertSame(key, actualBlSiteElementsQueryResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blProductOverrideCache()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blProductOverrideCache()}
   */
  @Test
  public void testBlProductOverrideCache() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductOverrideCacheResult = commonCacheConfiguration.blProductOverrideCache();

    // Assert
    assertEquals("blProductOverrideCache", actualBlProductOverrideCacheResult.getCacheName());
    assertNull(actualBlProductOverrideCacheResult.getConfiguration());
    assertEquals(-1, actualBlProductOverrideCacheResult.getTtlSeconds());
    assertTrue(actualBlProductOverrideCacheResult.getEnableManagement());
    assertTrue(actualBlProductOverrideCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlProductOverrideCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(BroadleafSharedOverrideProfileAwarePropertySource.DEFAULT_ORDER,
        actualBlProductOverrideCacheResult.getMaxElementsInMemory());
    assertSame(key, actualBlProductOverrideCacheResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blCountryElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blCountryElements()}
   */
  @Test
  public void testBlCountryElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCountryElementsResult = commonCacheConfiguration.blCountryElements();

    // Assert
    assertEquals("blCountryElements", actualBlCountryElementsResult.getCacheName());
    assertNull(actualBlCountryElementsResult.getConfiguration());
    assertEquals(-1, actualBlCountryElementsResult.getTtlSeconds());
    assertEquals(2000, actualBlCountryElementsResult.getMaxElementsInMemory());
    assertTrue(actualBlCountryElementsResult.getEnableManagement());
    assertTrue(actualBlCountryElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlCountryElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlCountryElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blDataDrivenEnumeration()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blDataDrivenEnumeration()}
   */
  @Test
  public void testBlDataDrivenEnumeration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlDataDrivenEnumerationResult = commonCacheConfiguration.blDataDrivenEnumeration();

    // Assert
    assertEquals("blDataDrivenEnumeration", actualBlDataDrivenEnumerationResult.getCacheName());
    assertNull(actualBlDataDrivenEnumerationResult.getConfiguration());
    assertEquals(86400, actualBlDataDrivenEnumerationResult.getTtlSeconds());
    assertTrue(actualBlDataDrivenEnumerationResult.getEnableManagement());
    assertTrue(actualBlDataDrivenEnumerationResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlDataDrivenEnumerationResult.getKey();
    assertEquals(expectedKey, key);
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        actualBlDataDrivenEnumerationResult.getMaxElementsInMemory());
    assertSame(key, actualBlDataDrivenEnumerationResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blMediaElements()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blMediaElements()}
   */
  @Test
  public void testBlMediaElements() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlMediaElementsResult = commonCacheConfiguration.blMediaElements();

    // Assert
    assertEquals("blMediaElements", actualBlMediaElementsResult.getCacheName());
    assertNull(actualBlMediaElementsResult.getConfiguration());
    assertEquals(20000, actualBlMediaElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlMediaElementsResult.getTtlSeconds());
    assertTrue(actualBlMediaElementsResult.getEnableManagement());
    assertTrue(actualBlMediaElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlMediaElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlMediaElementsResult.getValue());
  }

  /**
   * Test {@link CommonCacheConfiguration#blSystemProperties()}.
   * <p>
   * Method under test: {@link CommonCacheConfiguration#blSystemProperties()}
   */
  @Test
  public void testBlSystemProperties() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSystemPropertiesResult = commonCacheConfiguration.blSystemProperties();

    // Assert
    assertEquals("blSystemProperties", actualBlSystemPropertiesResult.getCacheName());
    assertNull(actualBlSystemPropertiesResult.getConfiguration());
    assertEquals(2000, actualBlSystemPropertiesResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlSystemPropertiesResult.getTtlSeconds());
    assertTrue(actualBlSystemPropertiesResult.getEnableManagement());
    assertTrue(actualBlSystemPropertiesResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlSystemPropertiesResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlSystemPropertiesResult.getValue());
  }
}
