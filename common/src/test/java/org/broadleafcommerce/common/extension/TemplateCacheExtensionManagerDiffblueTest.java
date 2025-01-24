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
package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.util.BLCFieldUtils;
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
public class TemplateCacheExtensionManagerDiffblueTest {
  @Autowired
  private TemplateCacheExtensionManager templateCacheExtensionManager;

  /**
   * Test {@link TemplateCacheExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link TemplateCacheExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new TemplateCacheExtensionManager()).isEnabled());
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(new TemplateCacheExtensionManager());
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateCacheKey);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.getTemplateCacheKey(Mockito.<Object>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(true);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    verify(templateCacheExtensionHandler).getTemplateCacheKey(isA(Object.class), eq("Template"),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualTemplateCacheKey);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.getTemplateCacheKey(Mockito.<Object>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(true);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    verify(templateCacheExtensionHandler).getTemplateCacheKey(isA(Object.class), eq("Template"),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualTemplateCacheKey);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTemplateCacheKey4() {
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
    TemplateCacheExtensionManager templateCacheExtensionManager2 = new TemplateCacheExtensionManager();

    ExtensionResultHolder<Object> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    templateCacheExtensionManager2.getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link TemplateCacheExtensionHandler}
   * {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey_givenTemplateCacheExtensionHandlerIsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(false);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateCacheKey);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link TemplateCacheExtensionManager} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey_givenTemplateCacheExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateCacheKey);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey_whenExtensionResultHolderResultIsNull_field() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();

    ExtensionResultHolder<Object> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateCacheExtensionManager.getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder));
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(new TemplateCacheExtensionManager());
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateName);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.getTemplateName(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(true);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    verify(templateCacheExtensionHandler).getTemplateName(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualTemplateName);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.getTemplateName(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(true);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    verify(templateCacheExtensionHandler).getTemplateName(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualTemplateName);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTemplateName4() {
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
    TemplateCacheExtensionManager templateCacheExtensionManager2 = new TemplateCacheExtensionManager();

    ExtensionResultHolder<Object> result = new ExtensionResultHolder<>();
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    templateCacheExtensionManager2.getTemplateName(BLCFieldUtils.NULL_FIELD, result);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link TemplateCacheExtensionHandler}
   * {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName_givenTemplateCacheExtensionHandlerIsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(false);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateName);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link TemplateCacheExtensionManager} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName_givenTemplateCacheExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateName);
  }

  /**
   * Test
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName_whenExtensionResultHolderResultIsNull_field() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();

    ExtensionResultHolder<Object> result = new ExtensionResultHolder<>();
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateCacheExtensionManager.getTemplateName(BLCFieldUtils.NULL_FIELD, result));
  }
}
