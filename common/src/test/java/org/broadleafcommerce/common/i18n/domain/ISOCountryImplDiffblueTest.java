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
package org.broadleafcommerce.common.i18n.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType;
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
public class ISOCountryImplDiffblueTest {
  @Autowired
  private ISOCountryImpl iSOCountryImpl;

  /**
   * Test {@link ISOCountryImpl#getStatus()}.
   * <p>
   * Method under test: {@link ISOCountryImpl#getStatus()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStatus() {
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
    (new ISOCountryImpl()).getStatus();
  }

  /**
   * Test {@link ISOCountryImpl#getStatus()}.
   * <ul>
   *   <li>Given {@link ISOCodeStatusType} {@link ISOCodeStatusType#getType()}
   * return {@code Type}.</li>
   *   <li>Then return {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#getStatus()}
   */
  @Test
  public void testGetStatus_givenISOCodeStatusTypeGetTypeReturnType_thenReturnFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCodeStatusType status = mock(ISOCodeStatusType.class);
    when(status.getType()).thenReturn("Type");

    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setStatus(status);

    // Act
    ISOCodeStatusType actualStatus = isoCountryImpl.getStatus();

    // Assert
    verify(status).getType();
    assertEquals("Friendly Type", actualStatus.getFriendlyType());
    assertEquals("Type", actualStatus.getType());
  }

  /**
   * Test {@link ISOCountryImpl#getStatus()}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#getStatus()}
   */
  @Test
  public void testGetStatus_givenISOCountryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ISOCountryImpl()).getStatus());
  }

  /**
   * Test {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}.
   * <p>
   * Method under test: {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetStatus() {
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
    (new ISOCountryImpl()).setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);
  }

  /**
   * Test {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor) Alpha2 is
   * {@code Alpha2}.</li>
   *   <li>Then {@link ISOCountryImpl} (default constructor)
   * {@link ISOCountryImpl#status} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}
   */
  @Test
  public void testSetStatus_givenISOCountryImplAlpha2IsAlpha2_thenISOCountryImplStatusIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act
    isoCountryImpl.setStatus(null);

    // Assert
    assertNull(isoCountryImpl.status);
    assertNull(isoCountryImpl.getStatus());
  }

  /**
   * Test {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link ISOCountryImpl} (default constructor) Status FriendlyType is
   * {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}
   */
  @Test
  public void testSetStatus_givenType_thenISOCountryImplStatusFriendlyTypeIsFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    ISOCodeStatusType status = mock(ISOCodeStatusType.class);
    when(status.getType()).thenReturn("Type");

    // Act
    isoCountryImpl.setStatus(status);

    // Assert
    verify(status).getType();
    ISOCodeStatusType status2 = isoCountryImpl.getStatus();
    assertEquals("Friendly Type", status2.getFriendlyType());
    assertEquals("Type", status2.getType());
    assertEquals("Type", isoCountryImpl.status);
  }

  /**
   * Test {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}.
   * <ul>
   *   <li>Then {@link ISOCountryImpl} (default constructor)
   * {@link ISOCountryImpl#status} is {@code EXCEPTIONALLY_RESERVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}
   */
  @Test
  public void testSetStatus_thenISOCountryImplStatusIsExceptionallyReserved() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    ISOCodeStatusType status = ISOCodeStatusType.EXCEPTIONALLY_RESERVED;

    // Act
    isoCountryImpl.setStatus(status);

    // Assert
    assertEquals("EXCEPTIONALLY_RESERVED", isoCountryImpl.status);
    ISOCodeStatusType expectedStatus = status.EXCEPTIONALLY_RESERVED;
    assertSame(expectedStatus, isoCountryImpl.getStatus());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and
   * {@link ISOCountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl2);
    int expectedHashCodeResult = isoCountryImpl.hashCode();
    assertEquals(expectedHashCodeResult, isoCountryImpl2.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and
   * {@link ISOCountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl);
    int expectedHashCodeResult = isoCountryImpl.hashCode();
    assertEquals(expectedHashCodeResult, isoCountryImpl.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Name");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2(null);
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha2");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3(null);
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Alpha2");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName(null);
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(1);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(null);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.INDETERMINATELY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(new ISOCodeStatusType());

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ISOCodeStatusType status = mock(ISOCodeStatusType.class);
    when(status.getType()).thenReturn("Type");

    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(status);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, null);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, "Different type to ISOCountryImpl");
  }

  /**
   * Test {@link ISOCountryImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link ISOCountryImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName() {
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
    (new ISOCountryImpl()).getMainEntityName();
  }

  /**
   * Test {@link ISOCountryImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link ISOCodeStatusType} {@link ISOCodeStatusType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link ISOCodeStatusType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenISOCodeStatusTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCodeStatusType status = mock(ISOCodeStatusType.class);
    when(status.getType()).thenReturn("Type");

    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setStatus(status);

    // Act
    String actualMainEntityName = isoCountryImpl.getMainEntityName();

    // Assert
    verify(status).getType();
    assertNull(actualMainEntityName);
  }

  /**
   * Test {@link ISOCountryImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenISOCountryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ISOCountryImpl()).getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ISOCountryImpl}
   *   <li>{@link ISOCountryImpl#setAlpha2(String)}
   *   <li>{@link ISOCountryImpl#setAlpha3(String)}
   *   <li>{@link ISOCountryImpl#setName(String)}
   *   <li>{@link ISOCountryImpl#setNumericCode(Integer)}
   *   <li>{@link ISOCountryImpl#getAlpha2()}
   *   <li>{@link ISOCountryImpl#getAlpha3()}
   *   <li>{@link ISOCountryImpl#getName()}
   *   <li>{@link ISOCountryImpl#getNumericCode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ISOCountryImpl actualIsoCountryImpl = new ISOCountryImpl();
    actualIsoCountryImpl.setAlpha2("Alpha2");
    actualIsoCountryImpl.setAlpha3("Alpha3");
    actualIsoCountryImpl.setName("Name");
    actualIsoCountryImpl.setNumericCode(10);
    String actualAlpha2 = actualIsoCountryImpl.getAlpha2();
    String actualAlpha3 = actualIsoCountryImpl.getAlpha3();
    String actualName = actualIsoCountryImpl.getName();

    // Assert that nothing has changed
    assertEquals("Alpha2", actualAlpha2);
    assertEquals("Alpha3", actualAlpha3);
    assertEquals("Name", actualName);
    assertEquals(10, actualIsoCountryImpl.getNumericCode().intValue());
  }
}
