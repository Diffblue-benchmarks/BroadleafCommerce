package org.broadleafcommerce.cms.config;

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

@ContextConfiguration(classes = {CmsCacheConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CmsCacheConfigurationDiffblueTest {
  @Autowired private CmsCacheConfiguration cmsCacheConfiguration;

  /**
   * Test {@link CmsCacheConfiguration#blCMSElements()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#blCMSElements()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.blCMSElements()"})
  public void testBlCMSElements_givenCmsCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCMSElementsResult = cmsCacheConfiguration.blCMSElements();

    // Assert
    assertEquals("blCMSElements", actualBlCMSElementsResult.getCacheName());
    assertNull(actualBlCMSElementsResult.getConfiguration());
    assertEquals(10000, actualBlCMSElementsResult.getMaxElementsInMemory());
    assertEquals(3600, actualBlCMSElementsResult.getTtlSeconds());
    assertTrue(actualBlCMSElementsResult.getEnableManagement());
    assertTrue(actualBlCMSElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlCMSElementsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlCMSElementsResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#blCMSElements()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#blCMSElements()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.blCMSElements()"})
  public void testBlCMSElements_givenCmsCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlCMSElementsResult =
        new CmsCacheConfiguration().blCMSElements();

    // Assert
    assertEquals("blCMSElements", actualBlCMSElementsResult.getCacheName());
    assertNull(actualBlCMSElementsResult.getConfiguration());
    assertEquals(10000, actualBlCMSElementsResult.getMaxElementsInMemory());
    assertEquals(3600, actualBlCMSElementsResult.getTtlSeconds());
    assertTrue(actualBlCMSElementsResult.getEnableManagement());
    assertTrue(actualBlCMSElementsResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlCMSElementsResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlCMSElementsResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsPageCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#cmsPageCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.cmsPageCache()"})
  public void testCmsPageCache_givenCmsCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsPageCacheResult = cmsCacheConfiguration.cmsPageCache();

    // Assert
    assertEquals("cmsPageCache", actualCmsPageCacheResult.getCacheName());
    assertNull(actualCmsPageCacheResult.getConfiguration());
    assertEquals(1000, actualCmsPageCacheResult.getMaxElementsInMemory());
    assertEquals(3600, actualCmsPageCacheResult.getTtlSeconds());
    assertTrue(actualCmsPageCacheResult.getEnableManagement());
    assertTrue(actualCmsPageCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualCmsPageCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualCmsPageCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsPageCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#cmsPageCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.cmsPageCache()"})
  public void testCmsPageCache_givenCmsCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsPageCacheResult = new CmsCacheConfiguration().cmsPageCache();

    // Assert
    assertEquals("cmsPageCache", actualCmsPageCacheResult.getCacheName());
    assertNull(actualCmsPageCacheResult.getConfiguration());
    assertEquals(1000, actualCmsPageCacheResult.getMaxElementsInMemory());
    assertEquals(3600, actualCmsPageCacheResult.getTtlSeconds());
    assertTrue(actualCmsPageCacheResult.getEnableManagement());
    assertTrue(actualCmsPageCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualCmsPageCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualCmsPageCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsPageMapCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#cmsPageMapCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.cmsPageMapCache()"})
  public void testCmsPageMapCache_givenCmsCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsPageMapCacheResult = cmsCacheConfiguration.cmsPageMapCache();

    // Assert
    assertEquals("cmsPageMapCache", actualCmsPageMapCacheResult.getCacheName());
    assertNull(actualCmsPageMapCacheResult.getConfiguration());
    assertEquals(1000, actualCmsPageMapCacheResult.getMaxElementsInMemory());
    assertEquals(3600, actualCmsPageMapCacheResult.getTtlSeconds());
    assertTrue(actualCmsPageMapCacheResult.getEnableManagement());
    assertTrue(actualCmsPageMapCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualCmsPageMapCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualCmsPageMapCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsPageMapCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#cmsPageMapCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.cmsPageMapCache()"})
  public void testCmsPageMapCache_givenCmsCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsPageMapCacheResult =
        new CmsCacheConfiguration().cmsPageMapCache();

    // Assert
    assertEquals("cmsPageMapCache", actualCmsPageMapCacheResult.getCacheName());
    assertNull(actualCmsPageMapCacheResult.getConfiguration());
    assertEquals(1000, actualCmsPageMapCacheResult.getMaxElementsInMemory());
    assertEquals(3600, actualCmsPageMapCacheResult.getTtlSeconds());
    assertTrue(actualCmsPageMapCacheResult.getEnableManagement());
    assertTrue(actualCmsPageMapCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualCmsPageMapCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualCmsPageMapCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#uriCachedDateCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#uriCachedDateCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.uriCachedDateCache()"})
  public void testUriCachedDateCache_givenCmsCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualUriCachedDateCacheResult =
        cmsCacheConfiguration.uriCachedDateCache();

    // Assert
    assertEquals("uriCachedDateCache", actualUriCachedDateCacheResult.getCacheName());
    assertNull(actualUriCachedDateCacheResult.getConfiguration());
    assertEquals(1000, actualUriCachedDateCacheResult.getMaxElementsInMemory());
    assertEquals(86400, actualUriCachedDateCacheResult.getTtlSeconds());
    assertTrue(actualUriCachedDateCacheResult.getEnableManagement());
    assertTrue(actualUriCachedDateCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualUriCachedDateCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualUriCachedDateCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#uriCachedDateCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#uriCachedDateCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.uriCachedDateCache()"})
  public void testUriCachedDateCache_givenCmsCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualUriCachedDateCacheResult =
        new CmsCacheConfiguration().uriCachedDateCache();

    // Assert
    assertEquals("uriCachedDateCache", actualUriCachedDateCacheResult.getCacheName());
    assertNull(actualUriCachedDateCacheResult.getConfiguration());
    assertEquals(1000, actualUriCachedDateCacheResult.getMaxElementsInMemory());
    assertEquals(86400, actualUriCachedDateCacheResult.getTtlSeconds());
    assertTrue(actualUriCachedDateCacheResult.getEnableManagement());
    assertTrue(actualUriCachedDateCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualUriCachedDateCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualUriCachedDateCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsStructuredContentCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#cmsStructuredContentCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.cmsStructuredContentCache()"})
  public void testCmsStructuredContentCache_givenCmsCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsStructuredContentCacheResult =
        cmsCacheConfiguration.cmsStructuredContentCache();

    // Assert
    assertEquals("cmsStructuredContentCache", actualCmsStructuredContentCacheResult.getCacheName());
    assertNull(actualCmsStructuredContentCacheResult.getConfiguration());
    assertEquals(3600, actualCmsStructuredContentCacheResult.getTtlSeconds());
    assertEquals(5000, actualCmsStructuredContentCacheResult.getMaxElementsInMemory());
    assertTrue(actualCmsStructuredContentCacheResult.getEnableManagement());
    assertTrue(actualCmsStructuredContentCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualCmsStructuredContentCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualCmsStructuredContentCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsStructuredContentCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#cmsStructuredContentCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.cmsStructuredContentCache()"})
  public void testCmsStructuredContentCache_givenCmsCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsStructuredContentCacheResult =
        new CmsCacheConfiguration().cmsStructuredContentCache();

    // Assert
    assertEquals("cmsStructuredContentCache", actualCmsStructuredContentCacheResult.getCacheName());
    assertNull(actualCmsStructuredContentCacheResult.getConfiguration());
    assertEquals(3600, actualCmsStructuredContentCacheResult.getTtlSeconds());
    assertEquals(5000, actualCmsStructuredContentCacheResult.getMaxElementsInMemory());
    assertTrue(actualCmsStructuredContentCacheResult.getEnableManagement());
    assertTrue(actualCmsStructuredContentCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualCmsStructuredContentCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualCmsStructuredContentCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsUrlHandlerCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#cmsUrlHandlerCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.cmsUrlHandlerCache()"})
  public void testCmsUrlHandlerCache_givenCmsCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsUrlHandlerCacheResult =
        cmsCacheConfiguration.cmsUrlHandlerCache();

    // Assert
    assertEquals("cmsUrlHandlerCache", actualCmsUrlHandlerCacheResult.getCacheName());
    assertNull(actualCmsUrlHandlerCacheResult.getConfiguration());
    assertEquals(3600, actualCmsUrlHandlerCacheResult.getTtlSeconds());
    assertEquals(5000, actualCmsUrlHandlerCacheResult.getMaxElementsInMemory());
    assertTrue(actualCmsUrlHandlerCacheResult.getEnableManagement());
    assertTrue(actualCmsUrlHandlerCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualCmsUrlHandlerCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualCmsUrlHandlerCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsUrlHandlerCache()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#cmsUrlHandlerCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.cmsUrlHandlerCache()"})
  public void testCmsUrlHandlerCache_givenCmsCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsUrlHandlerCacheResult =
        new CmsCacheConfiguration().cmsUrlHandlerCache();

    // Assert
    assertEquals("cmsUrlHandlerCache", actualCmsUrlHandlerCacheResult.getCacheName());
    assertNull(actualCmsUrlHandlerCacheResult.getConfiguration());
    assertEquals(3600, actualCmsUrlHandlerCacheResult.getTtlSeconds());
    assertEquals(5000, actualCmsUrlHandlerCacheResult.getMaxElementsInMemory());
    assertTrue(actualCmsUrlHandlerCacheResult.getEnableManagement());
    assertTrue(actualCmsUrlHandlerCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualCmsUrlHandlerCacheResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualCmsUrlHandlerCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#blUrlHandler()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#blUrlHandler()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.blUrlHandler()"})
  public void testBlUrlHandler_givenCmsCacheConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlUrlHandlerResult = cmsCacheConfiguration.blUrlHandler();

    // Assert
    assertEquals("blUrlHandler", actualBlUrlHandlerResult.getCacheName());
    assertNull(actualBlUrlHandlerResult.getConfiguration());
    assertEquals(1000, actualBlUrlHandlerResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlUrlHandlerResult.getTtlSeconds());
    assertTrue(actualBlUrlHandlerResult.getEnableManagement());
    assertTrue(actualBlUrlHandlerResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlUrlHandlerResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlUrlHandlerResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#blUrlHandler()}.
   *
   * <ul>
   *   <li>Given {@link CmsCacheConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CmsCacheConfiguration#blUrlHandler()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration CmsCacheConfiguration.blUrlHandler()"})
  public void testBlUrlHandler_givenCmsCacheConfiguration2() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlUrlHandlerResult = new CmsCacheConfiguration().blUrlHandler();

    // Assert
    assertEquals("blUrlHandler", actualBlUrlHandlerResult.getCacheName());
    assertNull(actualBlUrlHandlerResult.getConfiguration());
    assertEquals(1000, actualBlUrlHandlerResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlUrlHandlerResult.getTtlSeconds());
    assertTrue(actualBlUrlHandlerResult.getEnableManagement());
    assertTrue(actualBlUrlHandlerResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlUrlHandlerResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlUrlHandlerResult.getValue());
  }
}
