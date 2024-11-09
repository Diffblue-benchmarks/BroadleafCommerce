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
package org.broadleafcommerce.common.extensibility.cache.jcache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import bsh.classpath.BshClassLoader;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.util.Properties;
import javax.cache.CacheManager;
import org.junit.Test;

public class MergeJCacheManagerFactoryBeanDiffblueTest {
  /**
   * Test {@link MergeJCacheManagerFactoryBean#getObject()}.
   * <ul>
   *   <li>Given {@link MergeJCacheManagerFactoryBean} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeJCacheManagerFactoryBean#getObject()}
   */
  @Test
  public void testGetObject_givenMergeJCacheManagerFactoryBean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new MergeJCacheManagerFactoryBean()).getObject());
  }

  /**
   * Test {@link MergeJCacheManagerFactoryBean#getObject()}.
   * <ul>
   *   <li>Given {@link MergeJCacheManagerFactoryBean} (default constructor)
   * BeanClassLoader is {@link BshClassLoader}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeJCacheManagerFactoryBean#getObject()}
   */
  @Test
  public void testGetObject_givenMergeJCacheManagerFactoryBeanBeanClassLoaderIsBshClassLoader() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeJCacheManagerFactoryBean mergeJCacheManagerFactoryBean = new MergeJCacheManagerFactoryBean();
    mergeJCacheManagerFactoryBean.setBeanClassLoader(mock(BshClassLoader.class));

    // Act and Assert
    assertNull(mergeJCacheManagerFactoryBean.getObject());
  }

  /**
   * Test {@link MergeJCacheManagerFactoryBean#getObjectType()}.
   * <p>
   * Method under test: {@link MergeJCacheManagerFactoryBean#getObjectType()}
   */
  @Test
  public void testGetObjectType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeJCacheManagerFactoryBean mergeJCacheManagerFactoryBean = new MergeJCacheManagerFactoryBean();
    mergeJCacheManagerFactoryBean.setBeanClassLoader(mock(BshClassLoader.class));

    // Act
    Class<?> actualObjectType = mergeJCacheManagerFactoryBean.getObjectType();

    // Assert
    Class<CacheManager> expectedObjectType = CacheManager.class;
    assertEquals(expectedObjectType, actualObjectType);
  }

  /**
   * Test {@link MergeJCacheManagerFactoryBean#getObjectType()}.
   * <ul>
   *   <li>Given {@link MergeJCacheManagerFactoryBean} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeJCacheManagerFactoryBean#getObjectType()}
   */
  @Test
  public void testGetObjectType_givenMergeJCacheManagerFactoryBean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualObjectType = (new MergeJCacheManagerFactoryBean()).getObjectType();

    // Assert
    Class<CacheManager> expectedObjectType = CacheManager.class;
    assertEquals(expectedObjectType, actualObjectType);
  }

  /**
   * Test
   * {@link MergeJCacheManagerFactoryBean#getDefaultClassLoaderForProvider()}.
   * <ul>
   *   <li>Then return not {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeJCacheManagerFactoryBean#getDefaultClassLoaderForProvider()}
   */
  @Test
  public void testGetDefaultClassLoaderForProvider_thenReturnNotNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeJCacheManagerFactoryBean mergeJCacheManagerFactoryBean = new MergeJCacheManagerFactoryBean();
    mergeJCacheManagerFactoryBean.setBeanClassLoader(new JarClassLoader());

    // Act and Assert
    assertNotNull(mergeJCacheManagerFactoryBean.getDefaultClassLoaderForProvider());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link MergeJCacheManagerFactoryBean}
   *   <li>{@link MergeJCacheManagerFactoryBean#setBeanClassLoader(ClassLoader)}
   *   <li>
   * {@link MergeJCacheManagerFactoryBean#setCacheManagerProperties(Properties)}
   *   <li>{@link MergeJCacheManagerFactoryBean#isSingleton()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MergeJCacheManagerFactoryBean actualMergeJCacheManagerFactoryBean = new MergeJCacheManagerFactoryBean();
    actualMergeJCacheManagerFactoryBean.setBeanClassLoader(new JarClassLoader());
    actualMergeJCacheManagerFactoryBean.setCacheManagerProperties(new Properties());

    // Assert that nothing has changed
    assertTrue(actualMergeJCacheManagerFactoryBean.isSingleton());
  }
}
