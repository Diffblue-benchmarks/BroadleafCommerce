package org.broadleafcommerce.openadmin.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extensibility.cache.JCacheRegionConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OpenAdminCacheConfigDiffblueTest {
  /**
   * Test {@link OpenAdminCacheConfig#blAdminSecurityQuery()}.
   *
   * <ul>
   *   <li>Given {@link OpenAdminCacheConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OpenAdminCacheConfig#blAdminSecurityQuery()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration OpenAdminCacheConfig.blAdminSecurityQuery()"})
  public void testBlAdminSecurityQuery_givenOpenAdminCacheConfig() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlAdminSecurityQueryResult =
        new OpenAdminCacheConfig().blAdminSecurityQuery();

    // Assert
    assertEquals("blAdminSecurityQuery", actualBlAdminSecurityQueryResult.getCacheName());
    assertNull(actualBlAdminSecurityQueryResult.getConfiguration());
    assertEquals(1000, actualBlAdminSecurityQueryResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlAdminSecurityQueryResult.getTtlSeconds());
    assertTrue(actualBlAdminSecurityQueryResult.getEnableManagement());
    assertTrue(actualBlAdminSecurityQueryResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlAdminSecurityQueryResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlAdminSecurityQueryResult.getValue());
  }

  /**
   * Test {@link OpenAdminCacheConfig#blAdminSecurityQueryVolatile()}.
   *
   * <ul>
   *   <li>Given {@link OpenAdminCacheConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OpenAdminCacheConfig#blAdminSecurityQueryVolatile()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JCacheRegionConfiguration OpenAdminCacheConfig.blAdminSecurityQueryVolatile()"
  })
  public void testBlAdminSecurityQueryVolatile_givenOpenAdminCacheConfig() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlAdminSecurityQueryVolatileResult =
        new OpenAdminCacheConfig().blAdminSecurityQueryVolatile();

    // Assert
    assertEquals(
        "blAdminSecurityQueryVolatile", actualBlAdminSecurityQueryVolatileResult.getCacheName());
    assertNull(actualBlAdminSecurityQueryVolatileResult.getConfiguration());
    assertEquals(200, actualBlAdminSecurityQueryVolatileResult.getMaxElementsInMemory());
    assertEquals(60, actualBlAdminSecurityQueryVolatileResult.getTtlSeconds());
    assertTrue(actualBlAdminSecurityQueryVolatileResult.getEnableManagement());
    assertTrue(actualBlAdminSecurityQueryVolatileResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlAdminSecurityQueryVolatileResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlAdminSecurityQueryVolatileResult.getValue());
  }

  /**
   * Test {@link OpenAdminCacheConfig#blAdminSecurity()}.
   *
   * <ul>
   *   <li>Given {@link OpenAdminCacheConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OpenAdminCacheConfig#blAdminSecurity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration OpenAdminCacheConfig.blAdminSecurity()"})
  public void testBlAdminSecurity_givenOpenAdminCacheConfig() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlAdminSecurityResult =
        new OpenAdminCacheConfig().blAdminSecurity();

    // Assert
    assertEquals("blAdminSecurity", actualBlAdminSecurityResult.getCacheName());
    assertNull(actualBlAdminSecurityResult.getConfiguration());
    assertEquals(1000, actualBlAdminSecurityResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlAdminSecurityResult.getTtlSeconds());
    assertTrue(actualBlAdminSecurityResult.getEnableManagement());
    assertTrue(actualBlAdminSecurityResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlAdminSecurityResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlAdminSecurityResult.getValue());
  }

  /**
   * Test {@link OpenAdminCacheConfig#blAdminSecurityVolatile()}.
   *
   * <ul>
   *   <li>Given {@link OpenAdminCacheConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OpenAdminCacheConfig#blAdminSecurityVolatile()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JCacheRegionConfiguration OpenAdminCacheConfig.blAdminSecurityVolatile()"})
  public void testBlAdminSecurityVolatile_givenOpenAdminCacheConfig() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlAdminSecurityVolatileResult =
        new OpenAdminCacheConfig().blAdminSecurityVolatile();

    // Assert
    assertEquals("blAdminSecurityVolatile", actualBlAdminSecurityVolatileResult.getCacheName());
    assertNull(actualBlAdminSecurityVolatileResult.getConfiguration());
    assertEquals(200, actualBlAdminSecurityVolatileResult.getMaxElementsInMemory());
    assertEquals(60, actualBlAdminSecurityVolatileResult.getTtlSeconds());
    assertTrue(actualBlAdminSecurityVolatileResult.getEnableManagement());
    assertTrue(actualBlAdminSecurityVolatileResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    assertEquals(expectedKey, actualBlAdminSecurityVolatileResult.getKey());
    Class<Object> expectedValue = Object.class;
    assertEquals(expectedValue, actualBlAdminSecurityVolatileResult.getValue());
  }
}
