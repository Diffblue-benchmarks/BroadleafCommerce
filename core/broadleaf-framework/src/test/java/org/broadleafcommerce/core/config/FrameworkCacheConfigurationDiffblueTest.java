package org.broadleafcommerce.core.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extensibility.cache.JCacheRegionConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FrameworkCacheConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FrameworkCacheConfigurationDiffblueTest {
  @Autowired private FrameworkCacheConfiguration frameworkCacheConfiguration;

  /**
   * Test {@link FrameworkCacheConfiguration#blCategoryProduct()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blCategoryProduct()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blCategoryProduct()"})
  public void testBlCategoryProduct_givenFrameworkCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCategoryProductResult =
        frameworkCacheConfiguration.blCategoryProduct();

    // Assert
    assertEquals("blCategoryProduct", actualBlCategoryProductResult.getCacheName());
    assertNull(actualBlCategoryProductResult.getConfiguration());
    assertEquals(40000, actualBlCategoryProductResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlCategoryProductResult.getTtlSeconds());
    assertTrue(actualBlCategoryProductResult.getEnableManagement());
    assertTrue(actualBlCategoryProductResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlCategoryProductResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlCategoryProductResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blCategoryProduct()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blCategoryProduct()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blCategoryProduct()"})
  public void testBlCategoryProduct_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCategoryProductResult =
        new FrameworkCacheConfiguration().blCategoryProduct();

    // Assert
    assertEquals("blCategoryProduct", actualBlCategoryProductResult.getCacheName());
    assertNull(actualBlCategoryProductResult.getConfiguration());
    assertEquals(40000, actualBlCategoryProductResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlCategoryProductResult.getTtlSeconds());
    assertTrue(actualBlCategoryProductResult.getEnableManagement());
    assertTrue(actualBlCategoryProductResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlCategoryProductResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlCategoryProductResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blCategoryRelationships()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blCategoryRelationships()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JCacheRegionConfiguration FrameworkCacheConfiguration.blCategoryRelationships()"
  })
  public void testBlCategoryRelationships_givenFrameworkCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCategoryRelationshipsResult =
        frameworkCacheConfiguration.blCategoryRelationships();

    // Assert
    assertEquals("blCategoryRelationships", actualBlCategoryRelationshipsResult.getCacheName());
    assertNull(actualBlCategoryRelationshipsResult.getConfiguration());
    assertEquals(10000, actualBlCategoryRelationshipsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlCategoryRelationshipsResult.getTtlSeconds());
    assertTrue(actualBlCategoryRelationshipsResult.getEnableManagement());
    assertTrue(actualBlCategoryRelationshipsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlCategoryRelationshipsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlCategoryRelationshipsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blCategoryRelationships()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blCategoryRelationships()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JCacheRegionConfiguration FrameworkCacheConfiguration.blCategoryRelationships()"
  })
  public void testBlCategoryRelationships_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCategoryRelationshipsResult =
        new FrameworkCacheConfiguration().blCategoryRelationships();

    // Assert
    assertEquals("blCategoryRelationships", actualBlCategoryRelationshipsResult.getCacheName());
    assertNull(actualBlCategoryRelationshipsResult.getConfiguration());
    assertEquals(10000, actualBlCategoryRelationshipsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlCategoryRelationshipsResult.getTtlSeconds());
    assertTrue(actualBlCategoryRelationshipsResult.getEnableManagement());
    assertTrue(actualBlCategoryRelationshipsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlCategoryRelationshipsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlCategoryRelationshipsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blFulfillmentOptionElements()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blFulfillmentOptionElements()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JCacheRegionConfiguration FrameworkCacheConfiguration.blFulfillmentOptionElements()"
  })
  public void testBlFulfillmentOptionElements_givenFrameworkCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlFulfillmentOptionElementsResult =
        frameworkCacheConfiguration.blFulfillmentOptionElements();

    // Assert
    assertEquals(
        "blFulfillmentOptionElements", actualBlFulfillmentOptionElementsResult.getCacheName());
    assertNull(actualBlFulfillmentOptionElementsResult.getConfiguration());
    assertEquals(1000, actualBlFulfillmentOptionElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlFulfillmentOptionElementsResult.getTtlSeconds());
    assertTrue(actualBlFulfillmentOptionElementsResult.getEnableManagement());
    assertTrue(actualBlFulfillmentOptionElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlFulfillmentOptionElementsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlFulfillmentOptionElementsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blFulfillmentOptionElements()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blFulfillmentOptionElements()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JCacheRegionConfiguration FrameworkCacheConfiguration.blFulfillmentOptionElements()"
  })
  public void testBlFulfillmentOptionElements_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlFulfillmentOptionElementsResult =
        new FrameworkCacheConfiguration().blFulfillmentOptionElements();

    // Assert
    assertEquals(
        "blFulfillmentOptionElements", actualBlFulfillmentOptionElementsResult.getCacheName());
    assertNull(actualBlFulfillmentOptionElementsResult.getConfiguration());
    assertEquals(1000, actualBlFulfillmentOptionElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlFulfillmentOptionElementsResult.getTtlSeconds());
    assertTrue(actualBlFulfillmentOptionElementsResult.getEnableManagement());
    assertTrue(actualBlFulfillmentOptionElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlFulfillmentOptionElementsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlFulfillmentOptionElementsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blProductAttributes()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blProductAttributes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blProductAttributes()"})
  public void testBlProductAttributes_givenFrameworkCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductAttributesResult =
        frameworkCacheConfiguration.blProductAttributes();

    // Assert
    assertEquals("blProductAttributes", actualBlProductAttributesResult.getCacheName());
    assertNull(actualBlProductAttributesResult.getConfiguration());
    assertEquals(10000, actualBlProductAttributesResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductAttributesResult.getTtlSeconds());
    assertTrue(actualBlProductAttributesResult.getEnableManagement());
    assertTrue(actualBlProductAttributesResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlProductAttributesResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlProductAttributesResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blProductAttributes()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blProductAttributes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blProductAttributes()"})
  public void testBlProductAttributes_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductAttributesResult =
        new FrameworkCacheConfiguration().blProductAttributes();

    // Assert
    assertEquals("blProductAttributes", actualBlProductAttributesResult.getCacheName());
    assertNull(actualBlProductAttributesResult.getConfiguration());
    assertEquals(10000, actualBlProductAttributesResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductAttributesResult.getTtlSeconds());
    assertTrue(actualBlProductAttributesResult.getEnableManagement());
    assertTrue(actualBlProductAttributesResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlProductAttributesResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlProductAttributesResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blProductOptions()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blProductOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blProductOptions()"})
  public void testBlProductOptions_givenFrameworkCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductOptionsResult =
        frameworkCacheConfiguration.blProductOptions();

    // Assert
    assertEquals("blProductOptions", actualBlProductOptionsResult.getCacheName());
    assertNull(actualBlProductOptionsResult.getConfiguration());
    assertEquals(5000, actualBlProductOptionsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductOptionsResult.getTtlSeconds());
    assertTrue(actualBlProductOptionsResult.getEnableManagement());
    assertTrue(actualBlProductOptionsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlProductOptionsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlProductOptionsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blProductOptions()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blProductOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blProductOptions()"})
  public void testBlProductOptions_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductOptionsResult =
        new FrameworkCacheConfiguration().blProductOptions();

    // Assert
    assertEquals("blProductOptions", actualBlProductOptionsResult.getCacheName());
    assertNull(actualBlProductOptionsResult.getConfiguration());
    assertEquals(5000, actualBlProductOptionsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductOptionsResult.getTtlSeconds());
    assertTrue(actualBlProductOptionsResult.getEnableManagement());
    assertTrue(actualBlProductOptionsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlProductOptionsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlProductOptionsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blProductRelationships()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blProductRelationships()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JCacheRegionConfiguration FrameworkCacheConfiguration.blProductRelationships()"
  })
  public void testBlProductRelationships_givenFrameworkCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductRelationshipsResult =
        frameworkCacheConfiguration.blProductRelationships();

    // Assert
    assertEquals("blProductRelationships", actualBlProductRelationshipsResult.getCacheName());
    assertNull(actualBlProductRelationshipsResult.getConfiguration());
    assertEquals(30000, actualBlProductRelationshipsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductRelationshipsResult.getTtlSeconds());
    assertTrue(actualBlProductRelationshipsResult.getEnableManagement());
    assertTrue(actualBlProductRelationshipsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlProductRelationshipsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlProductRelationshipsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blProductRelationships()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blProductRelationships()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JCacheRegionConfiguration FrameworkCacheConfiguration.blProductRelationships()"
  })
  public void testBlProductRelationships_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlProductRelationshipsResult =
        new FrameworkCacheConfiguration().blProductRelationships();

    // Assert
    assertEquals("blProductRelationships", actualBlProductRelationshipsResult.getCacheName());
    assertNull(actualBlProductRelationshipsResult.getConfiguration());
    assertEquals(30000, actualBlProductRelationshipsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlProductRelationshipsResult.getTtlSeconds());
    assertTrue(actualBlProductRelationshipsResult.getEnableManagement());
    assertTrue(actualBlProductRelationshipsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlProductRelationshipsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlProductRelationshipsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blRelatedProducts()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blRelatedProducts()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blRelatedProducts()"})
  public void testBlRelatedProducts_givenFrameworkCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlRelatedProductsResult =
        frameworkCacheConfiguration.blRelatedProducts();

    // Assert
    assertEquals("blRelatedProducts", actualBlRelatedProductsResult.getCacheName());
    assertNull(actualBlRelatedProductsResult.getConfiguration());
    assertEquals(1000, actualBlRelatedProductsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlRelatedProductsResult.getTtlSeconds());
    assertTrue(actualBlRelatedProductsResult.getEnableManagement());
    assertTrue(actualBlRelatedProductsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlRelatedProductsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlRelatedProductsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blRelatedProducts()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blRelatedProducts()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blRelatedProducts()"})
  public void testBlRelatedProducts_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlRelatedProductsResult =
        new FrameworkCacheConfiguration().blRelatedProducts();

    // Assert
    assertEquals("blRelatedProducts", actualBlRelatedProductsResult.getCacheName());
    assertNull(actualBlRelatedProductsResult.getConfiguration());
    assertEquals(1000, actualBlRelatedProductsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlRelatedProductsResult.getTtlSeconds());
    assertTrue(actualBlRelatedProductsResult.getEnableManagement());
    assertTrue(actualBlRelatedProductsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlRelatedProductsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlRelatedProductsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blSearchElements()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blSearchElements()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blSearchElements()"})
  public void testBlSearchElements_givenFrameworkCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSearchElementsResult =
        frameworkCacheConfiguration.blSearchElements();

    // Assert
    assertEquals("blSearchElements", actualBlSearchElementsResult.getCacheName());
    assertNull(actualBlSearchElementsResult.getConfiguration());
    assertEquals(5000, actualBlSearchElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlSearchElementsResult.getTtlSeconds());
    assertTrue(actualBlSearchElementsResult.getEnableManagement());
    assertTrue(actualBlSearchElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlSearchElementsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlSearchElementsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blSearchElements()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blSearchElements()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blSearchElements()"})
  public void testBlSearchElements_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSearchElementsResult =
        new FrameworkCacheConfiguration().blSearchElements();

    // Assert
    assertEquals("blSearchElements", actualBlSearchElementsResult.getCacheName());
    assertNull(actualBlSearchElementsResult.getConfiguration());
    assertEquals(5000, actualBlSearchElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlSearchElementsResult.getTtlSeconds());
    assertTrue(actualBlSearchElementsResult.getEnableManagement());
    assertTrue(actualBlSearchElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlSearchElementsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlSearchElementsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blSkuMedia()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blSkuMedia()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blSkuMedia()"})
  public void testBlSkuMedia_givenFrameworkCacheConfiguration() {
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
    assertEquals(expectedKey, actualBlSkuMediaResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlSkuMediaResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blSkuMedia()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blSkuMedia()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blSkuMedia()"})
  public void testBlSkuMedia_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlSkuMediaResult =
        new FrameworkCacheConfiguration().blSkuMedia();

    // Assert
    assertEquals("blSkuMedia", actualBlSkuMediaResult.getCacheName());
    assertNull(actualBlSkuMediaResult.getConfiguration());
    assertEquals(40000, actualBlSkuMediaResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlSkuMediaResult.getTtlSeconds());
    assertTrue(actualBlSkuMediaResult.getEnableManagement());
    assertTrue(actualBlSkuMediaResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlSkuMediaResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlSkuMediaResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blStoreElements()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blStoreElements()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blStoreElements()"})
  public void testBlStoreElements_givenFrameworkCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlStoreElementsResult =
        frameworkCacheConfiguration.blStoreElements();

    // Assert
    assertEquals("blStoreElements", actualBlStoreElementsResult.getCacheName());
    assertNull(actualBlStoreElementsResult.getConfiguration());
    assertEquals(1000, actualBlStoreElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlStoreElementsResult.getTtlSeconds());
    assertTrue(actualBlStoreElementsResult.getEnableManagement());
    assertTrue(actualBlStoreElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlStoreElementsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlStoreElementsResult.getValue());
  }

  /**
   * Test {@link FrameworkCacheConfiguration#blStoreElements()}.
   *
   * <ul>
   *   <li>Given {@link FrameworkCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FrameworkCacheConfiguration#blStoreElements()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration FrameworkCacheConfiguration.blStoreElements()"})
  public void testBlStoreElements_givenFrameworkCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlStoreElementsResult =
        new FrameworkCacheConfiguration().blStoreElements();

    // Assert
    assertEquals("blStoreElements", actualBlStoreElementsResult.getCacheName());
    assertNull(actualBlStoreElementsResult.getConfiguration());
    assertEquals(1000, actualBlStoreElementsResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlStoreElementsResult.getTtlSeconds());
    assertTrue(actualBlStoreElementsResult.getEnableManagement());
    assertTrue(actualBlStoreElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlStoreElementsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlStoreElementsResult.getValue());
  }
}
