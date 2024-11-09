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
package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.junit.Test;

public class JCacheRegionConfigurationDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Cache Name}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JCacheRegionConfiguration#JCacheRegionConfiguration(String)}
   *   <li>{@link JCacheRegionConfiguration#setCacheName(String)}
   *   <li>{@link JCacheRegionConfiguration#setConfiguration(Configuration)}
   *   <li>{@link JCacheRegionConfiguration#setEnableManagement(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setEnableStatistics(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setKey(Class)}
   *   <li>{@link JCacheRegionConfiguration#setMaxElementsInMemory(int)}
   *   <li>{@link JCacheRegionConfiguration#setTtlSeconds(int)}
   *   <li>{@link JCacheRegionConfiguration#setValue(Class)}
   *   <li>{@link JCacheRegionConfiguration#getCacheName()}
   *   <li>{@link JCacheRegionConfiguration#getConfiguration()}
   *   <li>{@link JCacheRegionConfiguration#getEnableManagement()}
   *   <li>{@link JCacheRegionConfiguration#getEnableStatistics()}
   *   <li>{@link JCacheRegionConfiguration#getKey()}
   *   <li>{@link JCacheRegionConfiguration#getMaxElementsInMemory()}
   *   <li>{@link JCacheRegionConfiguration#getTtlSeconds()}
   *   <li>{@link JCacheRegionConfiguration#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenCacheName() {
    // Arrange and Act
    JCacheRegionConfiguration actualJCacheRegionConfiguration = new JCacheRegionConfiguration("Cache Name");
    actualJCacheRegionConfiguration.setCacheName("Cache Name");
    MutableConfiguration<?, ?> configuration = new MutableConfiguration<>();
    actualJCacheRegionConfiguration.setConfiguration(configuration);
    actualJCacheRegionConfiguration.setEnableManagement(true);
    actualJCacheRegionConfiguration.setEnableStatistics(true);
    Class<Object> key = Object.class;
    actualJCacheRegionConfiguration.setKey(key);
    actualJCacheRegionConfiguration.setMaxElementsInMemory(3);
    actualJCacheRegionConfiguration.setTtlSeconds(1);
    Class<Object> value = Object.class;
    actualJCacheRegionConfiguration.setValue(value);
    String actualCacheName = actualJCacheRegionConfiguration.getCacheName();
    Configuration<?, ?> actualConfiguration = actualJCacheRegionConfiguration.getConfiguration();
    Boolean actualEnableManagement = actualJCacheRegionConfiguration.getEnableManagement();
    Boolean actualEnableStatistics = actualJCacheRegionConfiguration.getEnableStatistics();
    Class<?> actualKey = actualJCacheRegionConfiguration.getKey();
    int actualMaxElementsInMemory = actualJCacheRegionConfiguration.getMaxElementsInMemory();
    int actualTtlSeconds = actualJCacheRegionConfiguration.getTtlSeconds();

    // Assert that nothing has changed
    assertEquals("Cache Name", actualCacheName);
    assertEquals(1, actualTtlSeconds);
    assertEquals(3, actualMaxElementsInMemory);
    assertTrue(actualEnableManagement);
    assertTrue(actualEnableStatistics);
    assertSame(configuration, actualConfiguration);
    assertSame(value, actualKey);
    assertSame(value, actualJCacheRegionConfiguration.getValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JCacheRegionConfiguration#JCacheRegionConfiguration(String, int, int, Class, Class)}
   *   <li>{@link JCacheRegionConfiguration#setCacheName(String)}
   *   <li>{@link JCacheRegionConfiguration#setConfiguration(Configuration)}
   *   <li>{@link JCacheRegionConfiguration#setEnableManagement(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setEnableStatistics(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setKey(Class)}
   *   <li>{@link JCacheRegionConfiguration#setMaxElementsInMemory(int)}
   *   <li>{@link JCacheRegionConfiguration#setTtlSeconds(int)}
   *   <li>{@link JCacheRegionConfiguration#setValue(Class)}
   *   <li>{@link JCacheRegionConfiguration#getCacheName()}
   *   <li>{@link JCacheRegionConfiguration#getConfiguration()}
   *   <li>{@link JCacheRegionConfiguration#getEnableManagement()}
   *   <li>{@link JCacheRegionConfiguration#getEnableStatistics()}
   *   <li>{@link JCacheRegionConfiguration#getKey()}
   *   <li>{@link JCacheRegionConfiguration#getMaxElementsInMemory()}
   *   <li>{@link JCacheRegionConfiguration#getTtlSeconds()}
   *   <li>{@link JCacheRegionConfiguration#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenJavaLangObject() {
    // Arrange
    Class<Object> key = Object.class;
    Class<Object> value = Object.class;

    // Act
    JCacheRegionConfiguration actualJCacheRegionConfiguration = new JCacheRegionConfiguration("Cache Name", 1, 3, key,
        value);
    actualJCacheRegionConfiguration.setCacheName("Cache Name");
    MutableConfiguration<?, ?> configuration = new MutableConfiguration<>();
    actualJCacheRegionConfiguration.setConfiguration(configuration);
    actualJCacheRegionConfiguration.setEnableManagement(true);
    actualJCacheRegionConfiguration.setEnableStatistics(true);
    Class<Object> key2 = Object.class;
    actualJCacheRegionConfiguration.setKey(key2);
    actualJCacheRegionConfiguration.setMaxElementsInMemory(3);
    actualJCacheRegionConfiguration.setTtlSeconds(1);
    Class<Object> value2 = Object.class;
    actualJCacheRegionConfiguration.setValue(value2);
    String actualCacheName = actualJCacheRegionConfiguration.getCacheName();
    Configuration<?, ?> actualConfiguration = actualJCacheRegionConfiguration.getConfiguration();
    Boolean actualEnableManagement = actualJCacheRegionConfiguration.getEnableManagement();
    Boolean actualEnableStatistics = actualJCacheRegionConfiguration.getEnableStatistics();
    Class<?> actualKey = actualJCacheRegionConfiguration.getKey();
    int actualMaxElementsInMemory = actualJCacheRegionConfiguration.getMaxElementsInMemory();
    int actualTtlSeconds = actualJCacheRegionConfiguration.getTtlSeconds();

    // Assert that nothing has changed
    assertEquals("Cache Name", actualCacheName);
    assertEquals(1, actualTtlSeconds);
    assertEquals(3, actualMaxElementsInMemory);
    assertTrue(actualEnableManagement);
    assertTrue(actualEnableStatistics);
    assertSame(configuration, actualConfiguration);
    assertSame(value2, actualKey);
    assertSame(value2, actualJCacheRegionConfiguration.getValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link MutableConfiguration#MutableConfiguration()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JCacheRegionConfiguration#JCacheRegionConfiguration(String, Configuration)}
   *   <li>{@link JCacheRegionConfiguration#setCacheName(String)}
   *   <li>{@link JCacheRegionConfiguration#setConfiguration(Configuration)}
   *   <li>{@link JCacheRegionConfiguration#setEnableManagement(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setEnableStatistics(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setKey(Class)}
   *   <li>{@link JCacheRegionConfiguration#setMaxElementsInMemory(int)}
   *   <li>{@link JCacheRegionConfiguration#setTtlSeconds(int)}
   *   <li>{@link JCacheRegionConfiguration#setValue(Class)}
   *   <li>{@link JCacheRegionConfiguration#getCacheName()}
   *   <li>{@link JCacheRegionConfiguration#getConfiguration()}
   *   <li>{@link JCacheRegionConfiguration#getEnableManagement()}
   *   <li>{@link JCacheRegionConfiguration#getEnableStatistics()}
   *   <li>{@link JCacheRegionConfiguration#getKey()}
   *   <li>{@link JCacheRegionConfiguration#getMaxElementsInMemory()}
   *   <li>{@link JCacheRegionConfiguration#getTtlSeconds()}
   *   <li>{@link JCacheRegionConfiguration#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenMutableConfiguration() {
    // Arrange and Act
    JCacheRegionConfiguration actualJCacheRegionConfiguration = new JCacheRegionConfiguration("Cache Name",
        new MutableConfiguration<>());
    actualJCacheRegionConfiguration.setCacheName("Cache Name");
    MutableConfiguration<?, ?> configuration = new MutableConfiguration<>();
    actualJCacheRegionConfiguration.setConfiguration(configuration);
    actualJCacheRegionConfiguration.setEnableManagement(true);
    actualJCacheRegionConfiguration.setEnableStatistics(true);
    Class<Object> key = Object.class;
    actualJCacheRegionConfiguration.setKey(key);
    actualJCacheRegionConfiguration.setMaxElementsInMemory(3);
    actualJCacheRegionConfiguration.setTtlSeconds(1);
    Class<Object> value = Object.class;
    actualJCacheRegionConfiguration.setValue(value);
    String actualCacheName = actualJCacheRegionConfiguration.getCacheName();
    Configuration<?, ?> actualConfiguration = actualJCacheRegionConfiguration.getConfiguration();
    Boolean actualEnableManagement = actualJCacheRegionConfiguration.getEnableManagement();
    Boolean actualEnableStatistics = actualJCacheRegionConfiguration.getEnableStatistics();
    Class<?> actualKey = actualJCacheRegionConfiguration.getKey();
    int actualMaxElementsInMemory = actualJCacheRegionConfiguration.getMaxElementsInMemory();
    int actualTtlSeconds = actualJCacheRegionConfiguration.getTtlSeconds();

    // Assert that nothing has changed
    assertEquals("Cache Name", actualCacheName);
    assertEquals(1, actualTtlSeconds);
    assertEquals(3, actualMaxElementsInMemory);
    assertTrue(actualEnableManagement);
    assertTrue(actualEnableStatistics);
    assertSame(configuration, actualConfiguration);
    assertSame(value, actualKey);
    assertSame(value, actualJCacheRegionConfiguration.getValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JCacheRegionConfiguration#JCacheRegionConfiguration(String, int, int)}
   *   <li>{@link JCacheRegionConfiguration#setCacheName(String)}
   *   <li>{@link JCacheRegionConfiguration#setConfiguration(Configuration)}
   *   <li>{@link JCacheRegionConfiguration#setEnableManagement(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setEnableStatistics(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setKey(Class)}
   *   <li>{@link JCacheRegionConfiguration#setMaxElementsInMemory(int)}
   *   <li>{@link JCacheRegionConfiguration#setTtlSeconds(int)}
   *   <li>{@link JCacheRegionConfiguration#setValue(Class)}
   *   <li>{@link JCacheRegionConfiguration#getCacheName()}
   *   <li>{@link JCacheRegionConfiguration#getConfiguration()}
   *   <li>{@link JCacheRegionConfiguration#getEnableManagement()}
   *   <li>{@link JCacheRegionConfiguration#getEnableStatistics()}
   *   <li>{@link JCacheRegionConfiguration#getKey()}
   *   <li>{@link JCacheRegionConfiguration#getMaxElementsInMemory()}
   *   <li>{@link JCacheRegionConfiguration#getTtlSeconds()}
   *   <li>{@link JCacheRegionConfiguration#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenOne() {
    // Arrange and Act
    JCacheRegionConfiguration actualJCacheRegionConfiguration = new JCacheRegionConfiguration("Cache Name", 1, 3);
    actualJCacheRegionConfiguration.setCacheName("Cache Name");
    MutableConfiguration<?, ?> configuration = new MutableConfiguration<>();
    actualJCacheRegionConfiguration.setConfiguration(configuration);
    actualJCacheRegionConfiguration.setEnableManagement(true);
    actualJCacheRegionConfiguration.setEnableStatistics(true);
    Class<Object> key = Object.class;
    actualJCacheRegionConfiguration.setKey(key);
    actualJCacheRegionConfiguration.setMaxElementsInMemory(3);
    actualJCacheRegionConfiguration.setTtlSeconds(1);
    Class<Object> value = Object.class;
    actualJCacheRegionConfiguration.setValue(value);
    String actualCacheName = actualJCacheRegionConfiguration.getCacheName();
    Configuration<?, ?> actualConfiguration = actualJCacheRegionConfiguration.getConfiguration();
    Boolean actualEnableManagement = actualJCacheRegionConfiguration.getEnableManagement();
    Boolean actualEnableStatistics = actualJCacheRegionConfiguration.getEnableStatistics();
    Class<?> actualKey = actualJCacheRegionConfiguration.getKey();
    int actualMaxElementsInMemory = actualJCacheRegionConfiguration.getMaxElementsInMemory();
    int actualTtlSeconds = actualJCacheRegionConfiguration.getTtlSeconds();

    // Assert that nothing has changed
    assertEquals("Cache Name", actualCacheName);
    assertEquals(1, actualTtlSeconds);
    assertEquals(3, actualMaxElementsInMemory);
    assertTrue(actualEnableManagement);
    assertTrue(actualEnableStatistics);
    assertSame(configuration, actualConfiguration);
    assertSame(value, actualKey);
    assertSame(value, actualJCacheRegionConfiguration.getValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JCacheRegionConfiguration#JCacheRegionConfiguration(String, int, int, Class, Class, Boolean, Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setCacheName(String)}
   *   <li>{@link JCacheRegionConfiguration#setConfiguration(Configuration)}
   *   <li>{@link JCacheRegionConfiguration#setEnableManagement(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setEnableStatistics(Boolean)}
   *   <li>{@link JCacheRegionConfiguration#setKey(Class)}
   *   <li>{@link JCacheRegionConfiguration#setMaxElementsInMemory(int)}
   *   <li>{@link JCacheRegionConfiguration#setTtlSeconds(int)}
   *   <li>{@link JCacheRegionConfiguration#setValue(Class)}
   *   <li>{@link JCacheRegionConfiguration#getCacheName()}
   *   <li>{@link JCacheRegionConfiguration#getConfiguration()}
   *   <li>{@link JCacheRegionConfiguration#getEnableManagement()}
   *   <li>{@link JCacheRegionConfiguration#getEnableStatistics()}
   *   <li>{@link JCacheRegionConfiguration#getKey()}
   *   <li>{@link JCacheRegionConfiguration#getMaxElementsInMemory()}
   *   <li>{@link JCacheRegionConfiguration#getTtlSeconds()}
   *   <li>{@link JCacheRegionConfiguration#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenTrue() {
    // Arrange
    Class<Object> key = Object.class;
    Class<Object> value = Object.class;

    // Act
    JCacheRegionConfiguration actualJCacheRegionConfiguration = new JCacheRegionConfiguration("Cache Name", 1, 3, key,
        value, true, true);
    actualJCacheRegionConfiguration.setCacheName("Cache Name");
    MutableConfiguration<?, ?> configuration = new MutableConfiguration<>();
    actualJCacheRegionConfiguration.setConfiguration(configuration);
    actualJCacheRegionConfiguration.setEnableManagement(true);
    actualJCacheRegionConfiguration.setEnableStatistics(true);
    Class<Object> key2 = Object.class;
    actualJCacheRegionConfiguration.setKey(key2);
    actualJCacheRegionConfiguration.setMaxElementsInMemory(3);
    actualJCacheRegionConfiguration.setTtlSeconds(1);
    Class<Object> value2 = Object.class;
    actualJCacheRegionConfiguration.setValue(value2);
    String actualCacheName = actualJCacheRegionConfiguration.getCacheName();
    Configuration<?, ?> actualConfiguration = actualJCacheRegionConfiguration.getConfiguration();
    Boolean actualEnableManagement = actualJCacheRegionConfiguration.getEnableManagement();
    Boolean actualEnableStatistics = actualJCacheRegionConfiguration.getEnableStatistics();
    Class<?> actualKey = actualJCacheRegionConfiguration.getKey();
    int actualMaxElementsInMemory = actualJCacheRegionConfiguration.getMaxElementsInMemory();
    int actualTtlSeconds = actualJCacheRegionConfiguration.getTtlSeconds();

    // Assert that nothing has changed
    assertEquals("Cache Name", actualCacheName);
    assertEquals(1, actualTtlSeconds);
    assertEquals(3, actualMaxElementsInMemory);
    assertTrue(actualEnableManagement);
    assertTrue(actualEnableStatistics);
    assertSame(configuration, actualConfiguration);
    assertSame(value2, actualKey);
    assertSame(value2, actualJCacheRegionConfiguration.getValue());
  }
}
