/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.extensibility.cache.jcache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import bsh.classpath.BshClassLoader;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.util.Properties;
import javax.cache.CacheManager;
import org.junit.Test;

public class MergeJCacheManagerFactoryBeanDiffblueTest {
  /**
   * Method under test: {@link MergeJCacheManagerFactoryBean#getObject()}
   */
  @Test
  public void testGetObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new MergeJCacheManagerFactoryBean()).getObject());
  }

  /**
   * Method under test: {@link MergeJCacheManagerFactoryBean#getObject()}
   */
  @Test
  public void testGetObject2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeJCacheManagerFactoryBean mergeJCacheManagerFactoryBean = new MergeJCacheManagerFactoryBean();
    mergeJCacheManagerFactoryBean.setBeanClassLoader(mock(BshClassLoader.class));

    // Act and Assert
    assertNull(mergeJCacheManagerFactoryBean.getObject());
  }

  /**
   * Method under test: {@link MergeJCacheManagerFactoryBean#getObjectType()}
   */
  @Test
  public void testGetObjectType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualObjectType = (new MergeJCacheManagerFactoryBean()).getObjectType();

    // Assert
    Class<CacheManager> expectedObjectType = CacheManager.class;
    assertEquals(expectedObjectType, actualObjectType);
  }

  /**
   * Method under test: {@link MergeJCacheManagerFactoryBean#getObjectType()}
   */
  @Test
  public void testGetObjectType2() {
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
   * Method under test:
   * {@link MergeJCacheManagerFactoryBean#getDefaultClassLoaderForProvider()}
   */
  @Test
  public void testGetDefaultClassLoaderForProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeJCacheManagerFactoryBean mergeJCacheManagerFactoryBean = new MergeJCacheManagerFactoryBean();
    JarClassLoader classLoader = new JarClassLoader();
    mergeJCacheManagerFactoryBean.setBeanClassLoader(classLoader);

    // Act
    ClassLoader actualDefaultClassLoaderForProvider = mergeJCacheManagerFactoryBean.getDefaultClassLoaderForProvider();

    // Assert
    assertNotNull(actualDefaultClassLoaderForProvider);
    assertSame(classLoader, actualDefaultClassLoaderForProvider);
  }

  /**
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
