package org.broadleafcommerce.common.extensibility.cache.jcache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.util.Properties;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.broadleafcommerce.common.extensibility.cache.JCacheConfigurationBuilder;
import org.broadleafcommerce.common.extensibility.cache.JCacheRegionConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class MergeJCacheManagerFactoryBeanDiffblueTest {
  @Mock private CacheManager cacheManager;

  @Mock private JCacheConfigurationBuilder jCacheConfigurationBuilder;

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
    assertNull(new MergeJCacheManagerFactoryBean().getObject());
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
    Class<?> actualObjectType = new MergeJCacheManagerFactoryBean().getObjectType();

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
    MergeJCacheManagerFactoryBean mergeJCacheManagerFactoryBean =
        new MergeJCacheManagerFactoryBean();
    mergeJCacheManagerFactoryBean.setBeanClassLoader(new JarClassLoader());

    // Act and Assert
    assertNotNull(mergeJCacheManagerFactoryBean.getDefaultClassLoaderForProvider());
  }

  /**
   * Test {@link MergeJCacheManagerFactoryBean#createCacheIfNotExists(JCacheRegionConfiguration)}.
   *
   * <p>Method under test: {@link
   * MergeJCacheManagerFactoryBean#createCacheIfNotExists(JCacheRegionConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeJCacheManagerFactoryBean.createCacheIfNotExists(JCacheRegionConfiguration)"
  })
  public void testCreateCacheIfNotExists() throws IllegalArgumentException {
    // Arrange
    when(cacheManager.createCache(
            Mockito.<String>any(), Mockito.<Configuration<Object, Object>>any()))
        .thenReturn(null);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);
    doNothing().when(cacheManager).enableManagement(Mockito.<String>any(), anyBoolean());
    doNothing().when(cacheManager).enableStatistics(Mockito.<String>any(), anyBoolean());

    JCacheRegionConfiguration config = mock(JCacheRegionConfiguration.class);
    when(config.getEnableManagement()).thenReturn(true);
    when(config.getEnableStatistics()).thenReturn(true);
    when(config.getCacheName()).thenReturn("Cache Name");
    Mockito.<Configuration<?, ?>>when(config.getConfiguration())
        .thenReturn(new MutableConfiguration<>());

    // Act
    mergeJCacheManagerFactoryBean.createCacheIfNotExists(config);

    // Assert
    verify(cacheManager).createCache(eq("Cache Name"), isA(Configuration.class));
    verify(cacheManager).enableManagement("Cache Name", true);
    verify(cacheManager).enableStatistics("Cache Name", true);
    verify(cacheManager).getCache("Cache Name");
    verify(config, atLeast(1)).getCacheName();
    verify(config, atLeast(1)).getConfiguration();
    verify(config, atLeast(1)).getEnableManagement();
    verify(config, atLeast(1)).getEnableStatistics();
  }

  /**
   * Test {@link MergeJCacheManagerFactoryBean#createCacheIfNotExists(JCacheRegionConfiguration)}.
   *
   * <p>Method under test: {@link
   * MergeJCacheManagerFactoryBean#createCacheIfNotExists(JCacheRegionConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeJCacheManagerFactoryBean.createCacheIfNotExists(JCacheRegionConfiguration)"
  })
  public void testCreateCacheIfNotExists2() throws IllegalArgumentException {
    // Arrange
    when(cacheManager.createCache(
            Mockito.<String>any(), Mockito.<Configuration<Object, Object>>any()))
        .thenReturn(null);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);
    doNothing().when(cacheManager).enableStatistics(Mockito.<String>any(), anyBoolean());

    JCacheRegionConfiguration config = mock(JCacheRegionConfiguration.class);
    when(config.getEnableManagement()).thenReturn(null);
    when(config.getEnableStatistics()).thenReturn(true);
    when(config.getCacheName()).thenReturn("Cache Name");
    Mockito.<Configuration<?, ?>>when(config.getConfiguration())
        .thenReturn(new MutableConfiguration<>());

    // Act
    mergeJCacheManagerFactoryBean.createCacheIfNotExists(config);

    // Assert
    verify(cacheManager).createCache(eq("Cache Name"), isA(Configuration.class));
    verify(cacheManager).enableStatistics("Cache Name", true);
    verify(cacheManager).getCache("Cache Name");
    verify(config, atLeast(1)).getCacheName();
    verify(config, atLeast(1)).getConfiguration();
    verify(config).getEnableManagement();
    verify(config, atLeast(1)).getEnableStatistics();
  }

  /**
   * Test {@link MergeJCacheManagerFactoryBean#createCacheIfNotExists(JCacheRegionConfiguration)}.
   *
   * <p>Method under test: {@link
   * MergeJCacheManagerFactoryBean#createCacheIfNotExists(JCacheRegionConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeJCacheManagerFactoryBean.createCacheIfNotExists(JCacheRegionConfiguration)"
  })
  public void testCreateCacheIfNotExists3() throws IllegalArgumentException {
    // Arrange
    when(cacheManager.createCache(
            Mockito.<String>any(), Mockito.<Configuration<Object, Object>>any()))
        .thenReturn(null);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);
    doNothing().when(cacheManager).enableManagement(Mockito.<String>any(), anyBoolean());

    JCacheRegionConfiguration config = mock(JCacheRegionConfiguration.class);
    when(config.getEnableManagement()).thenReturn(true);
    when(config.getEnableStatistics()).thenReturn(null);
    when(config.getCacheName()).thenReturn("Cache Name");
    Mockito.<Configuration<?, ?>>when(config.getConfiguration())
        .thenReturn(new MutableConfiguration<>());

    // Act
    mergeJCacheManagerFactoryBean.createCacheIfNotExists(config);

    // Assert
    verify(cacheManager).createCache(eq("Cache Name"), isA(Configuration.class));
    verify(cacheManager).enableManagement("Cache Name", true);
    verify(cacheManager).getCache("Cache Name");
    verify(config, atLeast(1)).getCacheName();
    verify(config, atLeast(1)).getConfiguration();
    verify(config, atLeast(1)).getEnableManagement();
    verify(config).getEnableStatistics();
  }

  /**
   * Test {@link MergeJCacheManagerFactoryBean#createCacheIfNotExists(JCacheRegionConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       JCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergeJCacheManagerFactoryBean#createCacheIfNotExists(JCacheRegionConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeJCacheManagerFactoryBean.createCacheIfNotExists(JCacheRegionConfiguration)"
  })
  public void testCreateCacheIfNotExists_thenCallsBuildConfiguration()
      throws IllegalArgumentException {
    // Arrange
    when(jCacheConfigurationBuilder.buildConfiguration(Mockito.<JCacheRegionConfiguration>any()))
        .thenReturn(new MutableConfiguration());
    when(cacheManager.createCache(
            Mockito.<String>any(), Mockito.<Configuration<Object, Object>>any()))
        .thenReturn(null);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);
    doNothing().when(cacheManager).enableManagement(Mockito.<String>any(), anyBoolean());
    doNothing().when(cacheManager).enableStatistics(Mockito.<String>any(), anyBoolean());

    // Act
    mergeJCacheManagerFactoryBean.createCacheIfNotExists(
        new JCacheRegionConfiguration("Cache Name"));

    // Assert
    verify(cacheManager).createCache(eq("Cache Name"), isA(Configuration.class));
    verify(cacheManager).enableManagement("Cache Name", true);
    verify(cacheManager).enableStatistics("Cache Name", true);
    verify(cacheManager).getCache("Cache Name");
    verify(jCacheConfigurationBuilder).buildConfiguration(isA(JCacheRegionConfiguration.class));
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
