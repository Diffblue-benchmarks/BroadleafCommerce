package org.broadleafcommerce.cms.config;

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

@ContextConfiguration(classes = {CmsCacheConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CmsCacheConfigurationDiffblueTest {
  @Autowired
  private CmsCacheConfiguration cmsCacheConfiguration;

  /**
   * Test {@link CmsCacheConfiguration#blCMSElements()}.
   * <p>
   * Method under test: {@link CmsCacheConfiguration#blCMSElements()}
   */
  @Test
  public void testBlCMSElements() {
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
    Class<?> key = actualBlCMSElementsResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlCMSElementsResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsPageCache()}.
   * <p>
   * Method under test: {@link CmsCacheConfiguration#cmsPageCache()}
   */
  @Test
  public void testCmsPageCache() {
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
    Class<?> key = actualCmsPageCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualCmsPageCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsPageMapCache()}.
   * <p>
   * Method under test: {@link CmsCacheConfiguration#cmsPageMapCache()}
   */
  @Test
  public void testCmsPageMapCache() {
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
    Class<?> key = actualCmsPageMapCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualCmsPageMapCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#uriCachedDateCache()}.
   * <p>
   * Method under test: {@link CmsCacheConfiguration#uriCachedDateCache()}
   */
  @Test
  public void testUriCachedDateCache() {
    // Arrange and Act
    JCacheRegionConfiguration actualUriCachedDateCacheResult = cmsCacheConfiguration.uriCachedDateCache();

    // Assert
    assertEquals("uriCachedDateCache", actualUriCachedDateCacheResult.getCacheName());
    assertNull(actualUriCachedDateCacheResult.getConfiguration());
    assertEquals(1000, actualUriCachedDateCacheResult.getMaxElementsInMemory());
    assertEquals(86400, actualUriCachedDateCacheResult.getTtlSeconds());
    assertTrue(actualUriCachedDateCacheResult.getEnableManagement());
    assertTrue(actualUriCachedDateCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualUriCachedDateCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualUriCachedDateCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsStructuredContentCache()}.
   * <p>
   * Method under test: {@link CmsCacheConfiguration#cmsStructuredContentCache()}
   */
  @Test
  public void testCmsStructuredContentCache() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsStructuredContentCacheResult = cmsCacheConfiguration.cmsStructuredContentCache();

    // Assert
    assertEquals("cmsStructuredContentCache", actualCmsStructuredContentCacheResult.getCacheName());
    assertNull(actualCmsStructuredContentCacheResult.getConfiguration());
    assertEquals(3600, actualCmsStructuredContentCacheResult.getTtlSeconds());
    assertEquals(5000, actualCmsStructuredContentCacheResult.getMaxElementsInMemory());
    assertTrue(actualCmsStructuredContentCacheResult.getEnableManagement());
    assertTrue(actualCmsStructuredContentCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualCmsStructuredContentCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualCmsStructuredContentCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#cmsUrlHandlerCache()}.
   * <p>
   * Method under test: {@link CmsCacheConfiguration#cmsUrlHandlerCache()}
   */
  @Test
  public void testCmsUrlHandlerCache() {
    // Arrange and Act
    JCacheRegionConfiguration actualCmsUrlHandlerCacheResult = cmsCacheConfiguration.cmsUrlHandlerCache();

    // Assert
    assertEquals("cmsUrlHandlerCache", actualCmsUrlHandlerCacheResult.getCacheName());
    assertNull(actualCmsUrlHandlerCacheResult.getConfiguration());
    assertEquals(3600, actualCmsUrlHandlerCacheResult.getTtlSeconds());
    assertEquals(5000, actualCmsUrlHandlerCacheResult.getMaxElementsInMemory());
    assertTrue(actualCmsUrlHandlerCacheResult.getEnableManagement());
    assertTrue(actualCmsUrlHandlerCacheResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualCmsUrlHandlerCacheResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualCmsUrlHandlerCacheResult.getValue());
  }

  /**
   * Test {@link CmsCacheConfiguration#blUrlHandler()}.
   * <p>
   * Method under test: {@link CmsCacheConfiguration#blUrlHandler()}
   */
  @Test
  public void testBlUrlHandler() {
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
    Class<?> key = actualBlUrlHandlerResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlUrlHandlerResult.getValue());
  }
}
