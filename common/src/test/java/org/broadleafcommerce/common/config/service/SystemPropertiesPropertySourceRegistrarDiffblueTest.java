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
package org.broadleafcommerce.common.config.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.config.service.SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
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
    "/context/reader/merge/testbeans2.xml", "/context/reader/merge/testbeans3.xml"}, classes = {String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemPropertiesPropertySourceRegistrarDiffblueTest {
  @MockBean
  private SystemPropertiesService systemPropertiesService;

  @Autowired
  private SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource systemPropertyPropertySource;

  @Autowired
  private SystemPropertiesPropertySourceRegistrar systemPropertiesPropertySourceRegistrar;

  /**
   * Test
   * {@link SystemPropertiesPropertySourceRegistrar#registerSystemPropertySource(ContextRefreshedEvent)}.
   * <p>
   * Method under test:
   * {@link SystemPropertiesPropertySourceRegistrar#registerSystemPropertySource(ContextRefreshedEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRegisterSystemPropertySource() {
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
    SystemPropertiesPropertySourceRegistrar systemPropertiesPropertySourceRegistrar2 = new SystemPropertiesPropertySourceRegistrar();

    // Act
    systemPropertiesPropertySourceRegistrar2
        .registerSystemPropertySource(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext()));
  }

  /**
   * Test SystemPropertyPropertySource
   * {@link SystemPropertyPropertySource#getProperty(String)}.
   * <p>
   * Method under test:
   * {@link SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource#getProperty(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSystemPropertyPropertySourceGetProperty() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.reflect.GenericSignatureFormatError: Signature Parse error: expected '<' or ';' but got .
    //   	Remaining input: .SystemPropertyPropertySource;
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
    //   java.lang.reflect.GenericSignatureFormatError: Signature Parse error: expected '<' or ';' but got .
    //   	Remaining input: .SystemPropertyPropertySource;
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.getOrDeduceTypes(DefinitionsParser.java:121)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.parseMockBeanAnnotation(DefinitionsParser.java:79)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.lambda$parseElement$1(DefinitionsParser.java:72)
    //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at org.springframework.core.annotation.TypeMappedAnnotations$AggregatesSpliterator.tryAdvance(TypeMappedAnnotations.java:602)
    //       at org.springframework.core.annotation.TypeMappedAnnotations$AggregatesSpliterator.tryAdvance(TypeMappedAnnotations.java:569)
    //       at java.base/java.util.Spliterator.forEachRemaining(Spliterator.java:326)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.parseElement(DefinitionsParser.java:72)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.lambda$parse$0(DefinitionsParser.java:65)
    //       at org.springframework.util.ReflectionUtils.doWithFields(ReflectionUtils.java:706)
    //       at org.springframework.util.ReflectionUtils.doWithFields(ReflectionUtils.java:685)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.parse(DefinitionsParser.java:65)
    //       at org.springframework.boot.test.mock.mockito.MockitoContextCustomizerFactory.parseDefinitions(MockitoContextCustomizerFactory.java:44)
    //       at org.springframework.boot.test.mock.mockito.MockitoContextCustomizerFactory.createContextCustomizer(MockitoContextCustomizerFactory.java:39)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.getContextCustomizers(AbstractTestContextBootstrapper.java:402)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildMergedContextConfiguration(AbstractTestContextBootstrapper.java:374)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildDefaultMergedContextConfiguration(AbstractTestContextBootstrapper.java:309)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildMergedContextConfiguration(AbstractTestContextBootstrapper.java:262)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildTestContext(AbstractTestContextBootstrapper.java:107)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:137)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:122)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange and Act
    systemPropertyPropertySource.getProperty("Name");
  }

  /**
   * Test SystemPropertyPropertySource
   * {@link SystemPropertyPropertySource#getProperty(String)}.
   * <ul>
   *   <li>Then return {@code Resolve System Property}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource#getProperty(String)}
   */
  @Test
  public void testSystemPropertyPropertySourceGetProperty_thenReturnResolveSystemProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl source = mock(SystemPropertiesServiceImpl.class);
    when(source.resolveSystemProperty(Mockito.<String>any())).thenReturn("Resolve System Property");

    // Act
    Object actualProperty = (new SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource("Name", source))
        .getProperty("Name");

    // Assert
    verify(source).resolveSystemProperty(eq("Name"));
    assertEquals("Resolve System Property", actualProperty);
  }

  /**
   * Test SystemPropertyPropertySource
   * {@link SystemPropertyPropertySource#SystemPropertyPropertySource(String, SystemPropertiesService)}.
   * <p>
   * Method under test:
   * {@link SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource#SystemPropertyPropertySource(String, SystemPropertiesService)}
   */
  @Test
  public void testSystemPropertyPropertySourceNewSystemPropertyPropertySource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl source = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertSame(source,
        (new SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource("Name", source)).getSource());
  }

  /**
   * Test SystemPropertyPropertySource
   * {@link SystemPropertyPropertySource#SystemPropertyPropertySource(String, SystemPropertiesService)}.
   * <p>
   * Method under test:
   * {@link SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource#SystemPropertyPropertySource(String, SystemPropertiesService)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSystemPropertyPropertySourceNewSystemPropertyPropertySource2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.reflect.GenericSignatureFormatError: Signature Parse error: expected '<' or ';' but got .
    //   	Remaining input: .SystemPropertyPropertySource;
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
    //   java.lang.reflect.GenericSignatureFormatError: Signature Parse error: expected '<' or ';' but got .
    //   	Remaining input: .SystemPropertyPropertySource;
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.getOrDeduceTypes(DefinitionsParser.java:121)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.parseMockBeanAnnotation(DefinitionsParser.java:79)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.lambda$parseElement$1(DefinitionsParser.java:72)
    //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at org.springframework.core.annotation.TypeMappedAnnotations$AggregatesSpliterator.tryAdvance(TypeMappedAnnotations.java:602)
    //       at org.springframework.core.annotation.TypeMappedAnnotations$AggregatesSpliterator.tryAdvance(TypeMappedAnnotations.java:569)
    //       at java.base/java.util.Spliterator.forEachRemaining(Spliterator.java:326)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.parseElement(DefinitionsParser.java:72)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.lambda$parse$0(DefinitionsParser.java:65)
    //       at org.springframework.util.ReflectionUtils.doWithFields(ReflectionUtils.java:706)
    //       at org.springframework.util.ReflectionUtils.doWithFields(ReflectionUtils.java:685)
    //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.parse(DefinitionsParser.java:65)
    //       at org.springframework.boot.test.mock.mockito.MockitoContextCustomizerFactory.parseDefinitions(MockitoContextCustomizerFactory.java:44)
    //       at org.springframework.boot.test.mock.mockito.MockitoContextCustomizerFactory.createContextCustomizer(MockitoContextCustomizerFactory.java:39)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.getContextCustomizers(AbstractTestContextBootstrapper.java:402)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildMergedContextConfiguration(AbstractTestContextBootstrapper.java:374)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildDefaultMergedContextConfiguration(AbstractTestContextBootstrapper.java:309)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildMergedContextConfiguration(AbstractTestContextBootstrapper.java:262)
    //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildTestContext(AbstractTestContextBootstrapper.java:107)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:137)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:122)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange and Act
    new SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource("Name", systemPropertiesService);

  }

  /**
   * Test SystemPropertyPropertySource
   * {@link SystemPropertyPropertySource#SystemPropertyPropertySource(String, SystemPropertiesService)}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource#SystemPropertyPropertySource(String, SystemPropertiesService)}
   */
  @Test
  public void testSystemPropertyPropertySourceNewSystemPropertyPropertySource_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl source = mock(SystemPropertiesServiceImpl.class);

    // Act
    SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource actualSystemPropertyPropertySource = new SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource(
        "Name", source);

    // Assert
    assertEquals("Name", actualSystemPropertyPropertySource.getName());
    assertSame(source, actualSystemPropertyPropertySource.getSource());
  }
}
