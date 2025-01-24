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
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class PaymentGatewayConfigurationServiceProviderImplDiffblueTest {
  @Autowired
  private PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl;

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(new ArrayList<>());
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenThrow(new IllegalArgumentException("There is no gateway configured for "));

    // Act
    paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(gatewayType);

    // Assert
    verify(gatewayType).getFriendlyType();
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractPaymentGatewayConfiguration abstractPaymentGatewayConfiguration = mock(
        AbstractPaymentGatewayConfiguration.class);
    when(abstractPaymentGatewayConfiguration.getGatewayType()).thenReturn(PaymentGatewayType.PASSTHROUGH);
    AbstractPaymentGatewayConfigurationService abstractPaymentGatewayConfigurationService = mock(
        AbstractPaymentGatewayConfigurationService.class);
    when(abstractPaymentGatewayConfigurationService.getConfiguration()).thenReturn(abstractPaymentGatewayConfiguration);

    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(abstractPaymentGatewayConfigurationService);

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(gatewayConfigurationServices);
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenReturn("Friendly Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(gatewayType));
    verify(gatewayType).getFriendlyType();
    verify(abstractPaymentGatewayConfiguration).getGatewayType();
    verify(abstractPaymentGatewayConfigurationService).getConfiguration();
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractPaymentGatewayConfiguration abstractPaymentGatewayConfiguration = mock(
        AbstractPaymentGatewayConfiguration.class);
    when(abstractPaymentGatewayConfiguration.getGatewayType()).thenReturn(new PaymentGatewayType());
    AbstractPaymentGatewayConfigurationService abstractPaymentGatewayConfigurationService = mock(
        AbstractPaymentGatewayConfigurationService.class);
    when(abstractPaymentGatewayConfigurationService.getConfiguration()).thenReturn(abstractPaymentGatewayConfiguration);

    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(abstractPaymentGatewayConfigurationService);

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(gatewayConfigurationServices);

    // Act
    paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(mock(PaymentGatewayType.class));

    // Assert
    verify(abstractPaymentGatewayConfiguration).getGatewayType();
    verify(abstractPaymentGatewayConfigurationService).getConfiguration();
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractPaymentGatewayConfiguration abstractPaymentGatewayConfiguration = mock(
        AbstractPaymentGatewayConfiguration.class);
    when(abstractPaymentGatewayConfiguration.getGatewayType()).thenReturn(mock(PaymentGatewayType.class));
    AbstractPaymentGatewayConfigurationService abstractPaymentGatewayConfigurationService = mock(
        AbstractPaymentGatewayConfigurationService.class);
    when(abstractPaymentGatewayConfigurationService.getConfiguration()).thenReturn(abstractPaymentGatewayConfiguration);

    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(abstractPaymentGatewayConfigurationService);

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(gatewayConfigurationServices);
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenReturn("Friendly Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(gatewayType));
    verify(gatewayType).getFriendlyType();
    verify(abstractPaymentGatewayConfiguration).getGatewayType();
    verify(abstractPaymentGatewayConfigurationService).getConfiguration();
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetGatewayConfigurationService5() {
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
    (new PaymentGatewayConfigurationServiceProviderImpl())
        .getGatewayConfigurationService(PaymentGatewayType.PASSTHROUGH);
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <ul>
   *   <li>Given {@code Friendly Type}.</li>
   *   <li>Then calls {@link PaymentGatewayType#getFriendlyType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService_givenFriendlyType_thenCallsGetFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(new ArrayList<>());
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenReturn("Friendly Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(gatewayType));
    verify(gatewayType).getFriendlyType();
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PaymentGatewayConfigurationServiceProviderImpl()).getGatewayConfigurationService(null));
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <ul>
   *   <li>When {@link PaymentGatewayType#PASSTHROUGH}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService_whenPassthrough() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> paymentGatewayConfigurationServiceProviderImpl
        .getGatewayConfigurationService(PaymentGatewayType.PASSTHROUGH));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PaymentGatewayConfigurationServiceProviderImpl#setGatewayConfigurationServices(List)}
   *   <li>
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationServices()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();

    // Act
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(gatewayConfigurationServices);
    List<PaymentGatewayConfigurationService> actualGatewayConfigurationServices = paymentGatewayConfigurationServiceProviderImpl
        .getGatewayConfigurationServices();

    // Assert that nothing has changed
    assertTrue(actualGatewayConfigurationServices.isEmpty());
    assertSame(gatewayConfigurationServices, actualGatewayConfigurationServices);
  }
}
