/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.config;

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

@ContextConfiguration(classes = {OpenAdminCacheConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OpenAdminCacheConfigDiffblueTest {
  @Autowired
  private OpenAdminCacheConfig openAdminCacheConfig;

  /**
   * Test {@link OpenAdminCacheConfig#blAdminSecurityQuery()}.
   * <p>
   * Method under test: {@link OpenAdminCacheConfig#blAdminSecurityQuery()}
   */
  @Test
  public void testBlAdminSecurityQuery() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlAdminSecurityQueryResult = openAdminCacheConfig.blAdminSecurityQuery();

    // Assert
    assertEquals("blAdminSecurityQuery", actualBlAdminSecurityQueryResult.getCacheName());
    assertNull(actualBlAdminSecurityQueryResult.getConfiguration());
    assertEquals(1000, actualBlAdminSecurityQueryResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlAdminSecurityQueryResult.getTtlSeconds());
    assertTrue(actualBlAdminSecurityQueryResult.getEnableManagement());
    assertTrue(actualBlAdminSecurityQueryResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlAdminSecurityQueryResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlAdminSecurityQueryResult.getValue());
  }

  /**
   * Test {@link OpenAdminCacheConfig#blAdminSecurityQueryVolatile()}.
   * <p>
   * Method under test:
   * {@link OpenAdminCacheConfig#blAdminSecurityQueryVolatile()}
   */
  @Test
  public void testBlAdminSecurityQueryVolatile() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlAdminSecurityQueryVolatileResult = openAdminCacheConfig
        .blAdminSecurityQueryVolatile();

    // Assert
    assertEquals("blAdminSecurityQueryVolatile", actualBlAdminSecurityQueryVolatileResult.getCacheName());
    assertNull(actualBlAdminSecurityQueryVolatileResult.getConfiguration());
    assertEquals(200, actualBlAdminSecurityQueryVolatileResult.getMaxElementsInMemory());
    assertEquals(60, actualBlAdminSecurityQueryVolatileResult.getTtlSeconds());
    assertTrue(actualBlAdminSecurityQueryVolatileResult.getEnableManagement());
    assertTrue(actualBlAdminSecurityQueryVolatileResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlAdminSecurityQueryVolatileResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlAdminSecurityQueryVolatileResult.getValue());
  }

  /**
   * Test {@link OpenAdminCacheConfig#blAdminSecurity()}.
   * <p>
   * Method under test: {@link OpenAdminCacheConfig#blAdminSecurity()}
   */
  @Test
  public void testBlAdminSecurity() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlAdminSecurityResult = openAdminCacheConfig.blAdminSecurity();

    // Assert
    assertEquals("blAdminSecurity", actualBlAdminSecurityResult.getCacheName());
    assertNull(actualBlAdminSecurityResult.getConfiguration());
    assertEquals(1000, actualBlAdminSecurityResult.getMaxElementsInMemory());
    assertEquals(86400, actualBlAdminSecurityResult.getTtlSeconds());
    assertTrue(actualBlAdminSecurityResult.getEnableManagement());
    assertTrue(actualBlAdminSecurityResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlAdminSecurityResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlAdminSecurityResult.getValue());
  }

  /**
   * Test {@link OpenAdminCacheConfig#blAdminSecurityVolatile()}.
   * <p>
   * Method under test: {@link OpenAdminCacheConfig#blAdminSecurityVolatile()}
   */
  @Test
  public void testBlAdminSecurityVolatile() {
    // Arrange and Act
    JCacheRegionConfiguration actualBlAdminSecurityVolatileResult = openAdminCacheConfig.blAdminSecurityVolatile();

    // Assert
    assertEquals("blAdminSecurityVolatile", actualBlAdminSecurityVolatileResult.getCacheName());
    assertNull(actualBlAdminSecurityVolatileResult.getConfiguration());
    assertEquals(200, actualBlAdminSecurityVolatileResult.getMaxElementsInMemory());
    assertEquals(60, actualBlAdminSecurityVolatileResult.getTtlSeconds());
    assertTrue(actualBlAdminSecurityVolatileResult.getEnableManagement());
    assertTrue(actualBlAdminSecurityVolatileResult.getEnableStatistics());
    Class<Object> expectedKey = Object.class;
    Class<?> key = actualBlAdminSecurityVolatileResult.getKey();
    assertEquals(expectedKey, key);
    assertSame(key, actualBlAdminSecurityVolatileResult.getValue());
  }
}
