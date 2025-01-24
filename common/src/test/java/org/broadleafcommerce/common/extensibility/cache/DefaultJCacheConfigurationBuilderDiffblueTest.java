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
package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml",
    "/bl-common-applicationContext-mbeans.xml", "/bl-common-applicationContext-persistence.xml",
    "/bl-common-applicationContext-servlet.xml", "/bl-common-applicationContext-wrapper.xml",
    "/bl-common-applicationContext.xml", "/bl-fake-applicationContext-ant.xml",
    "/blc-config/admin/framework/bl-common-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-common-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-common-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-common-applicationContext.xml",
    "/override-contexts/admin-root-autoconfiguration-overrides.xml",
    "/override-contexts/admin-servlet-autoconfiguration-overrides.xml",
    "/override-contexts/autoconfiguration-overrides.xml", "/override-contexts/autoconfiguration-servlet-overrides.xml",
    "/override-contexts/site-root-autoconfiguration-overrides.xml",
    "/override-contexts/site-servlet-autoconfiguration-overrides.xml",
    "/blc-config/admin/bl-admin-test-applicationContext.xml", "/blc-config/bl-test-applicationContext.xml",
    "/blc-config/site/bl-site-test-applicationContext.xml", "/context/config/client-override.xml",
    "/context/config/xml-import-override.xml", "/context/crossmodule/early-applicationContext.xml",
    "/context/crossmodule/early-xml-applicationContext.xml", "/context/crossmodule/late-applicationContext.xml",
    "/context/entityconfig/import-framework.xml", "/context/entityconfig/import-local.xml",
    "/context/importer/applicationContext.xml", "/context/importer/merge/applicationContext-servlet.xml",
    "/context/importer/merge/applicationContext.xml", "/context/merge/bl-framework.xml", "/context/merge/bl-module.xml",
    "/context/merge/local.xml", "/context/reader/bean-override-early-test-applicationContext.xml",
    "/context/reader/bean-override-framework-test-applicationContext.xml",
    "/context/reader/bean-override-local-test-applicationContext.xml", "/context/reader/merge/testbeans.xml",
    "/context/reader/merge/testbeans2.xml", "/context/reader/merge/testbeans3.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultJCacheConfigurationBuilderDiffblueTest {
  @Autowired
  private DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder;

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildConfigurationWithRegionInformation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: messageSource defined in bl-common-applicationContext.xml
    //   java.lang.IllegalStateException: Failed to load ApplicationContext
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:98)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'messageSource' defined in class path resource [bl-common-applicationContext.xml]: Initialization of bean failed; nested exception is org.springframework.beans.TypeMismatchException: Failed to convert property value of type 'java.lang.String' to required type 'boolean' for property 'useCodeAsDefaultMessage'; nested exception is java.lang.IllegalArgumentException: Invalid boolean value [${messages.useCodeAsDefaultMessage}]
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:628)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336)
    //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:214)
    //       at org.springframework.context.support.AbstractApplicationContext.initMessageSource(AbstractApplicationContext.java:784)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:579)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   org.springframework.beans.TypeMismatchException: Failed to convert property value of type 'java.lang.String' to required type 'boolean' for property 'useCodeAsDefaultMessage'; nested exception is java.lang.IllegalArgumentException: Invalid boolean value [${messages.useCodeAsDefaultMessage}]
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertIfNecessary(AbstractNestablePropertyAccessor.java:600)
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertForProperty(AbstractNestablePropertyAccessor.java:609)
    //       at org.springframework.beans.BeanWrapperImpl.convertForProperty(BeanWrapperImpl.java:219)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.convertForProperty(AbstractAutowireCapableBeanFactory.java:1756)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1712)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1452)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:619)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336)
    //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:214)
    //       at org.springframework.context.support.AbstractApplicationContext.initMessageSource(AbstractApplicationContext.java:784)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:579)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   java.lang.IllegalArgumentException: Invalid boolean value [${messages.useCodeAsDefaultMessage}]
    //       at org.springframework.beans.propertyeditors.CustomBooleanEditor.setAsText(CustomBooleanEditor.java:154)
    //       at org.springframework.beans.TypeConverterDelegate.doConvertTextValue(TypeConverterDelegate.java:429)
    //       at org.springframework.beans.TypeConverterDelegate.doConvertValue(TypeConverterDelegate.java:402)
    //       at org.springframework.beans.TypeConverterDelegate.convertIfNecessary(TypeConverterDelegate.java:155)
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertIfNecessary(AbstractNestablePropertyAccessor.java:590)
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertForProperty(AbstractNestablePropertyAccessor.java:609)
    //       at org.springframework.beans.BeanWrapperImpl.convertForProperty(BeanWrapperImpl.java:219)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.convertForProperty(AbstractAutowireCapableBeanFactory.java:1756)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1712)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1452)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:619)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336)
    //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:214)
    //       at org.springframework.context.support.AbstractApplicationContext.initMessageSource(AbstractApplicationContext.java:784)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:579)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder2 = new DefaultJCacheConfigurationBuilder();

    // Act
    defaultJCacheConfigurationBuilder2.buildConfiguration(new JCacheRegionConfiguration("Cache Name"));
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  public void testBuildConfigurationWithRegionInformation_givenZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();

    JCacheRegionConfiguration regionInformation = new JCacheRegionConfiguration("Cache Name");
    regionInformation.setTtlSeconds(0);

    // Act
    Configuration actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(regionInformation);

    // Assert
    Iterable<CacheEntryListenerConfiguration> cacheEntryListenerConfigurations = ((MutableConfiguration) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    Class keyType = actualBuildConfigurationResult.getKeyType();
    assertEquals(expectedKeyType, keyType);
    assertSame(keyType, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   * <ul>
   *   <li>Then return ValueType is KeyType.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  public void testBuildConfigurationWithRegionInformation_thenReturnValueTypeIsKeyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();

    // Act
    Configuration actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(new JCacheRegionConfiguration("Cache Name"));

    // Assert
    Iterable<CacheEntryListenerConfiguration> cacheEntryListenerConfigurations = ((MutableConfiguration) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    Class keyType = actualBuildConfigurationResult.getKeyType();
    assertEquals(expectedKeyType, keyType);
    assertSame(keyType, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   * with {@code regionInformation}.
   * <ul>
   *   <li>Then return ValueType is {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(JCacheRegionConfiguration)}
   */
  @Test
  public void testBuildConfigurationWithRegionInformation_thenReturnValueTypeIsObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();
    JCacheRegionConfiguration regionInformation = mock(JCacheRegionConfiguration.class);
    when(regionInformation.getMaxElementsInMemory()).thenReturn(3);
    when(regionInformation.getTtlSeconds()).thenReturn(1);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(regionInformation.getKey()).thenReturn(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(regionInformation.getValue()).thenReturn(forNameResult2);

    // Act
    Configuration actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(regionInformation);

    // Assert
    verify(regionInformation).getKey();
    verify(regionInformation).getMaxElementsInMemory();
    verify(regionInformation).getTtlSeconds();
    verify(regionInformation).getValue();
    Iterable<CacheEntryListenerConfiguration> cacheEntryListenerConfigurations = ((MutableConfiguration) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    assertEquals(expectedKeyType, actualBuildConfigurationResult.getKeyType());
    assertSame(forNameResult2, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   * with {@code ttlSeconds}, {@code maxElementsInMemory}, {@code keyClass},
   * {@code valueClass}.
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   */
  @Test
  public void testBuildConfigurationWithTtlSecondsMaxElementsInMemoryKeyClassValueClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();
    Class<Object> keyClass = Object.class;
    Class<Object> valueClass = Object.class;

    // Act
    Configuration<Object, Object> actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(1, 3, keyClass, valueClass);

    // Assert
    Iterable<CacheEntryListenerConfiguration<Object, Object>> cacheEntryListenerConfigurations = ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration<Object, Object>>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    assertEquals(expectedKeyType, actualBuildConfigurationResult.getKeyType());
    assertSame(valueClass, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   * with {@code ttlSeconds}, {@code maxElementsInMemory}, {@code keyClass},
   * {@code valueClass}.
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   */
  @Test
  public void testBuildConfigurationWithTtlSecondsMaxElementsInMemoryKeyClassValueClass2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder = new DefaultJCacheConfigurationBuilder();
    Class<Object> keyClass = Object.class;
    Class<Object> valueClass = Object.class;

    // Act
    Configuration<Object, Object> actualBuildConfigurationResult = defaultJCacheConfigurationBuilder
        .buildConfiguration(-1, 3, keyClass, valueClass);

    // Assert
    Iterable<CacheEntryListenerConfiguration<Object, Object>> cacheEntryListenerConfigurations = ((MutableConfiguration<Object, Object>) actualBuildConfigurationResult)
        .getCacheEntryListenerConfigurations();
    assertTrue(cacheEntryListenerConfigurations instanceof Set);
    assertTrue(actualBuildConfigurationResult instanceof MutableConfiguration);
    assertNull(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).getCacheLoaderFactory());
    assertNull(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).getCacheWriterFactory());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isManagementEnabled());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isReadThrough());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isStatisticsEnabled());
    assertFalse(((MutableConfiguration<Object, Object>) actualBuildConfigurationResult).isWriteThrough());
    assertTrue(((Set<CacheEntryListenerConfiguration<Object, Object>>) cacheEntryListenerConfigurations).isEmpty());
    assertTrue(actualBuildConfigurationResult.isStoreByValue());
    Class<Object> expectedKeyType = Object.class;
    assertEquals(expectedKeyType, actualBuildConfigurationResult.getKeyType());
    assertSame(valueClass, actualBuildConfigurationResult.getValueType());
  }

  /**
   * Test
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   * with {@code ttlSeconds}, {@code maxElementsInMemory}, {@code keyClass},
   * {@code valueClass}.
   * <p>
   * Method under test:
   * {@link DefaultJCacheConfigurationBuilder#buildConfiguration(int, int, Class, Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildConfigurationWithTtlSecondsMaxElementsInMemoryKeyClassValueClass3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: messageSource defined in bl-common-applicationContext.xml
    //   java.lang.IllegalStateException: Failed to load ApplicationContext
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:98)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'messageSource' defined in class path resource [bl-common-applicationContext.xml]: Initialization of bean failed; nested exception is org.springframework.beans.TypeMismatchException: Failed to convert property value of type 'java.lang.String' to required type 'boolean' for property 'useCodeAsDefaultMessage'; nested exception is java.lang.IllegalArgumentException: Invalid boolean value [${messages.useCodeAsDefaultMessage}]
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:628)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336)
    //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:214)
    //       at org.springframework.context.support.AbstractApplicationContext.initMessageSource(AbstractApplicationContext.java:784)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:579)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   org.springframework.beans.TypeMismatchException: Failed to convert property value of type 'java.lang.String' to required type 'boolean' for property 'useCodeAsDefaultMessage'; nested exception is java.lang.IllegalArgumentException: Invalid boolean value [${messages.useCodeAsDefaultMessage}]
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertIfNecessary(AbstractNestablePropertyAccessor.java:600)
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertForProperty(AbstractNestablePropertyAccessor.java:609)
    //       at org.springframework.beans.BeanWrapperImpl.convertForProperty(BeanWrapperImpl.java:219)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.convertForProperty(AbstractAutowireCapableBeanFactory.java:1756)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1712)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1452)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:619)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336)
    //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:214)
    //       at org.springframework.context.support.AbstractApplicationContext.initMessageSource(AbstractApplicationContext.java:784)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:579)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   java.lang.IllegalArgumentException: Invalid boolean value [${messages.useCodeAsDefaultMessage}]
    //       at org.springframework.beans.propertyeditors.CustomBooleanEditor.setAsText(CustomBooleanEditor.java:154)
    //       at org.springframework.beans.TypeConverterDelegate.doConvertTextValue(TypeConverterDelegate.java:429)
    //       at org.springframework.beans.TypeConverterDelegate.doConvertValue(TypeConverterDelegate.java:402)
    //       at org.springframework.beans.TypeConverterDelegate.convertIfNecessary(TypeConverterDelegate.java:155)
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertIfNecessary(AbstractNestablePropertyAccessor.java:590)
    //       at org.springframework.beans.AbstractNestablePropertyAccessor.convertForProperty(AbstractNestablePropertyAccessor.java:609)
    //       at org.springframework.beans.BeanWrapperImpl.convertForProperty(BeanWrapperImpl.java:219)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.convertForProperty(AbstractAutowireCapableBeanFactory.java:1756)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1712)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1452)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:619)
    //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336)
    //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334)
    //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:214)
    //       at org.springframework.context.support.AbstractApplicationContext.initMessageSource(AbstractApplicationContext.java:784)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:579)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange
    DefaultJCacheConfigurationBuilder defaultJCacheConfigurationBuilder2 = new DefaultJCacheConfigurationBuilder();
    Class<Object> keyClass = Object.class;
    Class<Object> valueClass = Object.class;

    // Act
    defaultJCacheConfigurationBuilder2.buildConfiguration(1, 3, keyClass, valueClass);
  }
}
