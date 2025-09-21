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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.util.Properties;
import javax.cache.CacheManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class MergeJCacheManagerFactoryBeanDiffblueTest {
  @InjectMocks private MergeJCacheManagerFactoryBean mergeJCacheManagerFactoryBean;

  /**
   * Test {@link MergeJCacheManagerFactoryBean#getObject()}.
   *
   * <p>Method under test: {@link MergeJCacheManagerFactoryBean#getObject()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheManager MergeJCacheManagerFactoryBean.getObject()"})
  public void testGetObject() {
    // Arrange, Act and Assert
    assertNull(mergeJCacheManagerFactoryBean.getObject());
  }

  /**
   * Test {@link MergeJCacheManagerFactoryBean#getObjectType()}.
   *
   * <p>Method under test: {@link MergeJCacheManagerFactoryBean#getObjectType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class MergeJCacheManagerFactoryBean.getObjectType()"})
  public void testGetObjectType() {
    // Arrange and Act
    Class<?> actualObjectType = mergeJCacheManagerFactoryBean.getObjectType();

    // Assert
    Class<CacheManager> expectedObjectType = CacheManager.class;
    assertEquals(expectedObjectType, actualObjectType);
  }

  /**
   * Test {@link MergeJCacheManagerFactoryBean#getDefaultClassLoaderForProvider()}.
   *
   * <ul>
   *   <li>Then return not {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MergeJCacheManagerFactoryBean#getDefaultClassLoaderForProvider()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassLoader MergeJCacheManagerFactoryBean.getDefaultClassLoaderForProvider()"
  })
  public void testGetDefaultClassLoaderForProvider_thenReturnNotNull() {
    // Arrange
    mergeJCacheManagerFactoryBean.setBeanClassLoader(new JarClassLoader());

    // Act and Assert
    assertNotNull(mergeJCacheManagerFactoryBean.getDefaultClassLoaderForProvider());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MergeJCacheManagerFactoryBean}
   *   <li>{@link MergeJCacheManagerFactoryBean#setBeanClassLoader(ClassLoader)}
   *   <li>{@link MergeJCacheManagerFactoryBean#setCacheManagerProperties(Properties)}
   *   <li>{@link MergeJCacheManagerFactoryBean#isSingleton()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeJCacheManagerFactoryBean.<init>()",
    "boolean MergeJCacheManagerFactoryBean.isSingleton()",
    "void MergeJCacheManagerFactoryBean.setBeanClassLoader(ClassLoader)",
    "void MergeJCacheManagerFactoryBean.setCacheManagerProperties(Properties)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MergeJCacheManagerFactoryBean actualMergeJCacheManagerFactoryBean =
        new MergeJCacheManagerFactoryBean();
    actualMergeJCacheManagerFactoryBean.setBeanClassLoader(new JarClassLoader());
    actualMergeJCacheManagerFactoryBean.setCacheManagerProperties(new Properties());
    boolean actualIsSingletonResult = actualMergeJCacheManagerFactoryBean.isSingleton();

    // Assert
    assertNull(actualMergeJCacheManagerFactoryBean.getObject());
    assertTrue(actualIsSingletonResult);
  }
}
