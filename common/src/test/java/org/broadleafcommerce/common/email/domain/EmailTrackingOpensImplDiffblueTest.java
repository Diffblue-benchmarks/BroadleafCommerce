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
package org.broadleafcommerce.common.email.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
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
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EmailTrackingOpensImplDiffblueTest {
  @Autowired
  private EmailTrackingOpensImpl emailTrackingOpensImpl;

  /**
   * Test {@link EmailTrackingOpensImpl#setUserAgent(String)}.
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#setUserAgent(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetUserAgent() {
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
    (new EmailTrackingOpensImpl()).setUserAgent("User Agent");
  }

  /**
   * Test {@link EmailTrackingOpensImpl#setUserAgent(String)}.
   * <ul>
   *   <li>Given {@link EmailTrackingOpensImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#setUserAgent(String)}
   */
  @Test
  public void testSetUserAgent_givenEmailTrackingOpensImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();

    // Act
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Assert
    assertEquals("User Agent", emailTrackingOpensImpl.getUserAgent());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#setUserAgent(String)}.
   * <ul>
   *   <li>Given {@link EmailTrackingOpensImpl} (default constructor) DateOpened is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#setUserAgent(String)}
   */
  @Test
  public void testSetUserAgent_givenEmailTrackingOpensImplDateOpenedIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(mock(java.sql.Date.class));

    // Act
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Assert
    assertEquals("User Agent", emailTrackingOpensImpl.getUserAgent());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(null);
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(null);
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(null);
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(null);
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(null);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(null);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(null);
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(null);
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(mock(EmailTrackingImpl.class));
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(2L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(null);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("42");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, null);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, "Different type to EmailTrackingOpensImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailTrackingOpensImpl}
   *   <li>{@link EmailTrackingOpensImpl#setDateOpened(Date)}
   *   <li>{@link EmailTrackingOpensImpl#setEmailTracking(EmailTracking)}
   *   <li>{@link EmailTrackingOpensImpl#setId(Long)}
   *   <li>{@link EmailTrackingOpensImpl#getDateOpened()}
   *   <li>{@link EmailTrackingOpensImpl#getEmailTracking()}
   *   <li>{@link EmailTrackingOpensImpl#getId()}
   *   <li>{@link EmailTrackingOpensImpl#getUserAgent()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailTrackingOpensImpl actualEmailTrackingOpensImpl = new EmailTrackingOpensImpl();
    Date dateOpened = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualEmailTrackingOpensImpl.setDateOpened(dateOpened);
    EmailTrackingImpl emailTracking = new EmailTrackingImpl();
    actualEmailTrackingOpensImpl.setEmailTracking(emailTracking);
    actualEmailTrackingOpensImpl.setId(1L);
    Date actualDateOpened = actualEmailTrackingOpensImpl.getDateOpened();
    EmailTracking actualEmailTracking = actualEmailTrackingOpensImpl.getEmailTracking();
    Long actualId = actualEmailTrackingOpensImpl.getId();
    actualEmailTrackingOpensImpl.getUserAgent();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertSame(emailTracking, actualEmailTracking);
    assertSame(dateOpened, actualDateOpened);
  }
}
