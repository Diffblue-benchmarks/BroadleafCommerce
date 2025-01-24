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
package org.broadleafcommerce.common.sitemap.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
public class SiteMapUrlEntryImplDiffblueTest {
  @Autowired
  private SiteMapUrlEntryImpl siteMapUrlEntryImpl;

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}
   */
  @Test
  public void testGetSiteMapChangeFreq() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);

    // Act
    SiteMapChangeFreqType actualSiteMapChangeFreq = siteMapUrlEntryImpl.getSiteMapChangeFreq();

    // Assert
    assertSame(actualSiteMapChangeFreq.ALWAYS, actualSiteMapChangeFreq);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}
   */
  @Test
  public void testGetSiteMapChangeFreq2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(mock(CustomUrlSiteMapGeneratorConfiguration.class));
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);

    // Act
    SiteMapChangeFreqType actualSiteMapChangeFreq = siteMapUrlEntryImpl.getSiteMapChangeFreq();

    // Assert
    assertSame(actualSiteMapChangeFreq.ALWAYS, actualSiteMapChangeFreq);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSiteMapChangeFreq3() {
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

    // Arrange and Act
    (new SiteMapUrlEntryImpl()).getSiteMapChangeFreq();
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}.
   * <ul>
   *   <li>Given {@link SiteMapUrlEntryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}
   */
  @Test
  public void testGetSiteMapChangeFreq_givenSiteMapUrlEntryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapUrlEntryImpl()).getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetSiteMapChangeFreq() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    SiteMapChangeFreqType siteMapChangeFreq = mock(SiteMapChangeFreqType.class);
    when(siteMapChangeFreq.getType()).thenReturn("Type");

    // Act
    siteMapUrlEntryImpl.setSiteMapChangeFreq(siteMapChangeFreq);

    // Assert
    verify(siteMapChangeFreq).getType();
    SiteMapChangeFreqType siteMapChangeFreq2 = siteMapUrlEntryImpl.getSiteMapChangeFreq();
    assertEquals("Friendly Type", siteMapChangeFreq2.getFriendlyType());
    assertEquals("Type", siteMapChangeFreq2.getType());
    assertEquals("Type", siteMapUrlEntryImpl.changeFreq);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetSiteMapChangeFreq2() {
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

    // Arrange and Act
    (new SiteMapUrlEntryImpl()).setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor)
   * {@link SiteMapUrlEntryImpl#changeFreq} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetSiteMapChangeFreq_thenSiteMapUrlEntryImplChangeFreqIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    siteMapUrlEntryImpl.setSiteMapChangeFreq(null);

    // Assert
    assertNull(siteMapUrlEntryImpl.changeFreq);
    assertNull(siteMapUrlEntryImpl.getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>When {@link SiteMapChangeFreqType#ALWAYS}.</li>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor)
   * {@link SiteMapUrlEntryImpl#changeFreq} is {@code ALWAYS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetSiteMapChangeFreq_whenAlways_thenSiteMapUrlEntryImplChangeFreqIsAlways() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    SiteMapChangeFreqType siteMapChangeFreq = SiteMapChangeFreqType.ALWAYS;

    // Act
    siteMapUrlEntryImpl.setSiteMapChangeFreq(siteMapChangeFreq);

    // Assert
    assertEquals("ALWAYS", siteMapUrlEntryImpl.changeFreq);
    SiteMapChangeFreqType expectedSiteMapChangeFreq = siteMapChangeFreq.ALWAYS;
    assertSame(expectedSiteMapChangeFreq, siteMapUrlEntryImpl.getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapPriority()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapPriority()}
   */
  @Test
  public void testGetSiteMapPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    SiteMapPriorityType actualSiteMapPriority = siteMapUrlEntryImpl.getSiteMapPriority();

    // Assert
    assertSame(actualSiteMapPriority.ONE, actualSiteMapPriority);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapPriority()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapPriority()}
   */
  @Test
  public void testGetSiteMapPriority2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(mock(CustomUrlSiteMapGeneratorConfiguration.class));
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    SiteMapPriorityType actualSiteMapPriority = siteMapUrlEntryImpl.getSiteMapPriority();

    // Assert
    assertSame(actualSiteMapPriority.ONE, actualSiteMapPriority);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapPriority()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapPriority()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSiteMapPriority3() {
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

    // Arrange and Act
    (new SiteMapUrlEntryImpl()).getSiteMapPriority();
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapPriority()}.
   * <ul>
   *   <li>Given {@link SiteMapUrlEntryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapPriority()}
   */
  @Test
  public void testGetSiteMapPriority_givenSiteMapUrlEntryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapUrlEntryImpl()).getSiteMapPriority());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  public void testSetSiteMapPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    SiteMapPriorityType siteMapPriority = mock(SiteMapPriorityType.class);
    when(siteMapPriority.getType()).thenReturn("Type");

    // Act
    siteMapUrlEntryImpl.setSiteMapPriority(siteMapPriority);

    // Assert
    verify(siteMapPriority).getType();
    SiteMapPriorityType siteMapPriority2 = siteMapUrlEntryImpl.getSiteMapPriority();
    assertEquals("Friendly Type", siteMapPriority2.getFriendlyType());
    assertEquals("Type", siteMapPriority2.getType());
    assertEquals("Type", siteMapUrlEntryImpl.priority);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetSiteMapPriority2() {
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

    // Arrange and Act
    (new SiteMapUrlEntryImpl()).setSiteMapPriority(SiteMapPriorityType.ONE);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <ul>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor)
   * {@link SiteMapUrlEntryImpl#priority} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  public void testSetSiteMapPriority_thenSiteMapUrlEntryImplPriorityIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    siteMapUrlEntryImpl.setSiteMapPriority(null);

    // Assert
    assertNull(siteMapUrlEntryImpl.priority);
    assertNull(siteMapUrlEntryImpl.getSiteMapPriority());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <ul>
   *   <li>When {@link SiteMapPriorityType#ONE}.</li>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor)
   * {@link SiteMapUrlEntryImpl#priority} is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  public void testSetSiteMapPriority_whenOne_thenSiteMapUrlEntryImplPriorityIs10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    SiteMapPriorityType siteMapPriority = SiteMapPriorityType.ONE;

    // Act
    siteMapUrlEntryImpl.setSiteMapPriority(siteMapPriority);

    // Assert
    assertEquals("1.0", siteMapUrlEntryImpl.priority);
    SiteMapPriorityType expectedSiteMapPriority = siteMapPriority.ONE;
    assertSame(expectedSiteMapPriority, siteMapUrlEntryImpl.getSiteMapPriority());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapUrlEntryImpl}
   *   <li>
   * {@link SiteMapUrlEntryImpl#setCustomUrlSiteMapGeneratorConfiguration(CustomUrlSiteMapGeneratorConfiguration)}
   *   <li>{@link SiteMapUrlEntryImpl#setId(Long)}
   *   <li>{@link SiteMapUrlEntryImpl#setLastMod(Date)}
   *   <li>{@link SiteMapUrlEntryImpl#setLocation(String)}
   *   <li>{@link SiteMapUrlEntryImpl#getCustomUrlSiteMapGeneratorConfiguration()}
   *   <li>{@link SiteMapUrlEntryImpl#getId()}
   *   <li>{@link SiteMapUrlEntryImpl#getLastMod()}
   *   <li>{@link SiteMapUrlEntryImpl#getLocation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapUrlEntryImpl actualSiteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    CustomUrlSiteMapGeneratorConfigurationImpl customUrlSiteMapGeneratorConfiguration = new CustomUrlSiteMapGeneratorConfigurationImpl();
    actualSiteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(customUrlSiteMapGeneratorConfiguration);
    actualSiteMapUrlEntryImpl.setId(1L);
    Date lastModified = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualSiteMapUrlEntryImpl.setLastMod(lastModified);
    actualSiteMapUrlEntryImpl.setLocation("https://example.org/example");
    CustomUrlSiteMapGeneratorConfiguration actualCustomUrlSiteMapGeneratorConfiguration = actualSiteMapUrlEntryImpl
        .getCustomUrlSiteMapGeneratorConfiguration();
    Long actualId = actualSiteMapUrlEntryImpl.getId();
    Date actualLastMod = actualSiteMapUrlEntryImpl.getLastMod();

    // Assert that nothing has changed
    assertEquals("https://example.org/example", actualSiteMapUrlEntryImpl.getLocation());
    assertEquals(1L, actualId.longValue());
    assertSame(customUrlSiteMapGeneratorConfiguration, actualCustomUrlSiteMapGeneratorConfiguration);
    assertSame(lastModified, actualLastMod);
  }
}
