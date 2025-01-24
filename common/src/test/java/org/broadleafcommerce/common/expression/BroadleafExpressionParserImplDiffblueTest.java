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
package org.broadleafcommerce.common.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.MapAccessor;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.ConstructorResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.MethodResolver;
import org.springframework.expression.ParserContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypeLocator;
import org.springframework.expression.TypedValue;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.ReflectiveConstructorResolver;
import org.springframework.expression.spel.support.ReflectiveMethodResolver;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.spel.support.StandardOperatorOverloader;
import org.springframework.expression.spel.support.StandardTypeComparator;
import org.springframework.expression.spel.support.StandardTypeConverter;
import org.springframework.expression.spel.support.StandardTypeLocator;
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
public class BroadleafExpressionParserImplDiffblueTest {
  @Autowired
  private BroadleafExpressionParserImpl broadleafExpressionParserImpl;

  /**
   * Test {@link BroadleafExpressionParserImpl#parseExpression(String, Map)} with
   * {@code expressionString}, {@code context}.
   * <p>
   * Method under test:
   * {@link BroadleafExpressionParserImpl#parseExpression(String, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testParseExpressionWithExpressionStringContext() {
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
    BroadleafExpressionParserImpl broadleafExpressionParserImpl2 = new BroadleafExpressionParserImpl();

    // Act
    broadleafExpressionParserImpl2.parseExpression("Expression String", new HashMap<>());
  }

  /**
   * Test
   * {@link BroadleafExpressionParserImpl#parseExpression(String, Map, Class)}
   * with {@code expressionString}, {@code context}, {@code targetType}.
   * <p>
   * Method under test:
   * {@link BroadleafExpressionParserImpl#parseExpression(String, Map, Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testParseExpressionWithExpressionStringContextTargetType() {
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
    BroadleafExpressionParserImpl broadleafExpressionParserImpl2 = new BroadleafExpressionParserImpl();
    HashMap<String, Object> context = new HashMap<>();
    Class<Object> targetType = Object.class;

    // Act
    broadleafExpressionParserImpl2.parseExpression("Expression String", context, targetType);
  }

  /**
   * Test
   * {@link BroadleafExpressionParserImpl#parseExpression(String, Map, Class)}
   * with {@code expressionString}, {@code context}, {@code targetType}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExpressionParserImpl#parseExpression(String, Map, Class)}
   */
  @Test
  public void testParseExpressionWithExpressionStringContextTargetType_givenFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafExpressionParserImpl broadleafExpressionParserImpl = new BroadleafExpressionParserImpl();

    HashMap<String, Object> context = new HashMap<>();
    context.computeIfPresent("foo", mock(BiFunction.class));
    Class<Object> targetType = Object.class;

    // Act
    Object actualParseExpressionResult = broadleafExpressionParserImpl.parseExpression("Expression String", context,
        targetType);

    // Assert
    List<PropertyAccessor> propertyAccessors = broadleafExpressionParserImpl.getPropertyAccessors();
    assertEquals(2, propertyAccessors.size());
    PropertyAccessor getResult = propertyAccessors.get(0);
    assertTrue(getResult instanceof MapAccessor);
    assertEquals("Expression String", actualParseExpressionResult);
    Class<Object> expectedPropertyType = Object.class;
    assertEquals(expectedPropertyType, ((MapAccessor) getResult).getPropertyType());
  }

  /**
   * Test
   * {@link BroadleafExpressionParserImpl#parseExpression(String, Map, Class)}
   * with {@code expressionString}, {@code context}, {@code targetType}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExpressionParserImpl#parseExpression(String, Map, Class)}
   */
  @Test
  public void testParseExpressionWithExpressionStringContextTargetType_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafExpressionParserImpl broadleafExpressionParserImpl = new BroadleafExpressionParserImpl();
    HashMap<String, Object> context = new HashMap<>();
    Class<Object> targetType = Object.class;

    // Act
    Object actualParseExpressionResult = broadleafExpressionParserImpl.parseExpression("Expression String", context,
        targetType);

    // Assert
    List<PropertyAccessor> propertyAccessors = broadleafExpressionParserImpl.getPropertyAccessors();
    assertEquals(2, propertyAccessors.size());
    PropertyAccessor getResult = propertyAccessors.get(0);
    assertTrue(getResult instanceof MapAccessor);
    assertEquals("Expression String", actualParseExpressionResult);
    Class<Object> expectedPropertyType = Object.class;
    assertEquals(expectedPropertyType, ((MapAccessor) getResult).getPropertyType());
  }

  /**
   * Test {@link BroadleafExpressionParserImpl#parseExpression(String, Map)} with
   * {@code expressionString}, {@code context}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExpressionParserImpl#parseExpression(String, Map)}
   */
  @Test
  public void testParseExpressionWithExpressionStringContext_givenFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafExpressionParserImpl broadleafExpressionParserImpl = new BroadleafExpressionParserImpl();

    HashMap<String, Object> context = new HashMap<>();
    context.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals("Expression String", broadleafExpressionParserImpl.parseExpression("Expression String", context));
  }

  /**
   * Test {@link BroadleafExpressionParserImpl#parseExpression(String, Map)} with
   * {@code expressionString}, {@code context}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExpressionParserImpl#parseExpression(String, Map)}
   */
  @Test
  public void testParseExpressionWithExpressionStringContext_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafExpressionParserImpl broadleafExpressionParserImpl = new BroadleafExpressionParserImpl();

    // Act and Assert
    assertEquals("Expression String",
        broadleafExpressionParserImpl.parseExpression("Expression String", new HashMap<>()));
  }

  /**
   * Test {@link BroadleafExpressionParserImpl#getParserContext()}.
   * <p>
   * Method under test: {@link BroadleafExpressionParserImpl#getParserContext()}
   */
  @Test
  public void testGetParserContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ParserContext actualParserContext = (new BroadleafExpressionParserImpl()).getParserContext();

    // Assert
    assertTrue(actualParserContext instanceof TemplateParserContext);
    assertEquals("#{", actualParserContext.getExpressionPrefix());
    assertEquals("}", actualParserContext.getExpressionSuffix());
    assertTrue(actualParserContext.isTemplate());
  }

  /**
   * Test {@link BroadleafExpressionParserImpl#getParserContext()}.
   * <p>
   * Method under test: {@link BroadleafExpressionParserImpl#getParserContext()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetParserContext2() {
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
    (new BroadleafExpressionParserImpl()).getParserContext();
  }

  /**
   * Test
   * {@link BroadleafExpressionParserImpl#createStandardEvaluationContext(Map)}.
   * <p>
   * Method under test:
   * {@link BroadleafExpressionParserImpl#createStandardEvaluationContext(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateStandardEvaluationContext() {
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
    BroadleafExpressionParserImpl broadleafExpressionParserImpl2 = new BroadleafExpressionParserImpl();

    // Act
    broadleafExpressionParserImpl2.createStandardEvaluationContext(new HashMap<>());
  }

  /**
   * Test
   * {@link BroadleafExpressionParserImpl#createStandardEvaluationContext(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExpressionParserImpl#createStandardEvaluationContext(Map)}
   */
  @Test
  public void testCreateStandardEvaluationContext_givenFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafExpressionParserImpl broadleafExpressionParserImpl = new BroadleafExpressionParserImpl();

    HashMap<String, Object> context = new HashMap<>();
    context.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    StandardEvaluationContext actualCreateStandardEvaluationContextResult = broadleafExpressionParserImpl
        .createStandardEvaluationContext(context);

    // Assert
    TypedValue rootObject = actualCreateStandardEvaluationContextResult.getRootObject();
    Object value = rootObject.getValue();
    assertTrue(value instanceof Map);
    List<ConstructorResolver> constructorResolvers = actualCreateStandardEvaluationContextResult
        .getConstructorResolvers();
    assertEquals(1, constructorResolvers.size());
    assertTrue(constructorResolvers.get(0) instanceof ReflectiveConstructorResolver);
    List<MethodResolver> methodResolvers = actualCreateStandardEvaluationContextResult.getMethodResolvers();
    assertEquals(1, methodResolvers.size());
    assertTrue(methodResolvers.get(0) instanceof ReflectiveMethodResolver);
    List<PropertyAccessor> propertyAccessors = actualCreateStandardEvaluationContextResult.getPropertyAccessors();
    assertEquals(1, propertyAccessors.size());
    PropertyAccessor getResult = propertyAccessors.get(0);
    assertTrue(getResult instanceof ReflectivePropertyAccessor);
    assertTrue(
        actualCreateStandardEvaluationContextResult.getOperatorOverloader() instanceof StandardOperatorOverloader);
    assertTrue(actualCreateStandardEvaluationContextResult.getTypeComparator() instanceof StandardTypeComparator);
    assertTrue(actualCreateStandardEvaluationContextResult.getTypeConverter() instanceof StandardTypeConverter);
    TypeLocator typeLocator = actualCreateStandardEvaluationContextResult.getTypeLocator();
    assertTrue(typeLocator instanceof StandardTypeLocator);
    List<String> importPrefixes = ((StandardTypeLocator) typeLocator).getImportPrefixes();
    assertEquals(1, importPrefixes.size());
    assertEquals("java.lang", importPrefixes.get(0));
    TypeDescriptor typeDescriptor = rootObject.getTypeDescriptor();
    assertEquals("java.util.HashMap", typeDescriptor.getName());
    assertNull(getResult.getSpecificTargetClasses());
    ResolvableType resolvableType = typeDescriptor.getResolvableType();
    ResolvableType componentType = resolvableType.getComponentType();
    assertNull(componentType.getRawClass());
    ResolvableType[] generics = resolvableType.getGenerics();
    ResolvableType resolvableType2 = generics[0];
    assertNull(resolvableType2.getRawClass());
    ResolvableType resolvableType3 = generics[1];
    assertNull(resolvableType3.getRawClass());
    ResolvableType superType = resolvableType.getSuperType();
    ResolvableType[] interfaces = superType.getInterfaces();
    ResolvableType resolvableType4 = interfaces[0];
    ResolvableType[] generics2 = resolvableType4.getGenerics();
    ResolvableType resolvableType5 = generics2[0];
    assertNull(resolvableType5.getRawClass());
    ResolvableType resolvableType6 = generics2[1];
    assertNull(resolvableType6.getRawClass());
    assertNull(((ReflectivePropertyAccessor) getResult).getLastReadInvokerPair());
    assertNull(typeDescriptor.getElementTypeDescriptor());
    assertNull(typeDescriptor.getMapKeyTypeDescriptor());
    assertNull(typeDescriptor.getMapValueTypeDescriptor());
    assertNull(actualCreateStandardEvaluationContextResult.getBeanResolver());
    ResolvableType[] generics3 = componentType.getGenerics();
    assertEquals(0, generics3.length);
    ResolvableType superType2 = superType.getSuperType();
    assertEquals(0, superType2.getGenerics().length);
    ResolvableType[] interfaces2 = resolvableType.getInterfaces();
    ResolvableType resolvableType7 = interfaces2[1];
    assertEquals(0, resolvableType7.getGenerics().length);
    ResolvableType resolvableType8 = interfaces2[2];
    assertEquals(0, resolvableType8.getGenerics().length);
    assertEquals(0, superType2.getInterfaces().length);
    assertEquals(0, resolvableType4.getInterfaces().length);
    ResolvableType resolvableType9 = interfaces2[0];
    assertEquals(0, resolvableType9.getInterfaces().length);
    assertEquals(0, resolvableType7.getInterfaces().length);
    assertEquals(0, resolvableType8.getInterfaces().length);
    assertEquals(0, typeDescriptor.getAnnotations().length);
    assertEquals(1, interfaces.length);
    assertEquals(2, superType.getGenerics().length);
    assertEquals(2, generics.length);
    assertEquals(2, generics2.length);
    assertEquals(2, resolvableType9.getGenerics().length);
    assertEquals(3, interfaces2.length);
    assertFalse(componentType.hasGenerics());
    assertFalse(superType2.hasGenerics());
    assertFalse(resolvableType2.hasGenerics());
    assertFalse(resolvableType3.hasGenerics());
    assertFalse(resolvableType5.hasGenerics());
    assertFalse(resolvableType6.hasGenerics());
    assertFalse(resolvableType7.hasGenerics());
    assertFalse(resolvableType8.hasGenerics());
    assertFalse(typeDescriptor.isArray());
    assertFalse(typeDescriptor.isCollection());
    assertFalse(typeDescriptor.isPrimitive());
    assertTrue(((Map<Object, Object>) value).isEmpty());
    assertTrue(superType.hasGenerics());
    assertTrue(resolvableType.hasGenerics());
    assertTrue(resolvableType4.hasGenerics());
    assertTrue(resolvableType9.hasGenerics());
    assertTrue(typeDescriptor.isMap());
    assertTrue(actualCreateStandardEvaluationContextResult.isAssignmentEnabled());
    Class<Serializable> expectedRawClass = Serializable.class;
    Class<?> rawClass = resolvableType8.getRawClass();
    assertEquals(expectedRawClass, rawClass);
    Class<Cloneable> expectedRawClass2 = Cloneable.class;
    Class<?> rawClass2 = resolvableType7.getRawClass();
    assertEquals(expectedRawClass2, rawClass2);
    Class<Object> expectedRawClass3 = Object.class;
    assertEquals(expectedRawClass3, superType2.getRawClass());
    Class<AbstractMap> expectedRawClass4 = AbstractMap.class;
    assertEquals(expectedRawClass4, superType.getRawClass());
    Class<HashMap> expectedObjectType = HashMap.class;
    Class<?> objectType = typeDescriptor.getObjectType();
    assertEquals(expectedObjectType, objectType);
    Class<Map> expectedRawClass5 = Map.class;
    Class<?> rawClass3 = resolvableType9.getRawClass();
    assertEquals(expectedRawClass5, rawClass3);
    assertSame(context, value);
    ResolvableType componentType2 = componentType.getComponentType();
    assertSame(componentType2, componentType2);
    assertSame(componentType2, superType2.getComponentType());
    assertSame(componentType2, superType.getComponentType());
    assertSame(componentType2, resolvableType2.getComponentType());
    assertSame(componentType2, resolvableType3.getComponentType());
    assertSame(componentType2, resolvableType5.getComponentType());
    assertSame(componentType2, resolvableType6.getComponentType());
    assertSame(componentType2, resolvableType4.getComponentType());
    assertSame(componentType2, resolvableType9.getComponentType());
    assertSame(componentType2, resolvableType7.getComponentType());
    assertSame(componentType2, resolvableType8.getComponentType());
    assertSame(componentType2, componentType.getSuperType());
    assertSame(componentType2, superType2.getSuperType());
    assertSame(componentType2, resolvableType2.getSuperType());
    assertSame(componentType2, resolvableType3.getSuperType());
    assertSame(componentType2, resolvableType5.getSuperType());
    assertSame(componentType2, resolvableType6.getSuperType());
    assertSame(componentType2, resolvableType4.getSuperType());
    assertSame(componentType2, resolvableType9.getSuperType());
    assertSame(componentType2, resolvableType7.getSuperType());
    assertSame(componentType2, resolvableType8.getSuperType());
    assertSame(generics3, resolvableType2.getGenerics());
    assertSame(generics3, resolvableType3.getGenerics());
    assertSame(generics3, resolvableType5.getGenerics());
    assertSame(generics3, resolvableType6.getGenerics());
    assertSame(generics3, componentType.getInterfaces());
    assertSame(generics3, resolvableType2.getInterfaces());
    assertSame(generics3, resolvableType3.getInterfaces());
    assertSame(generics3, resolvableType5.getInterfaces());
    assertSame(generics3, resolvableType6.getInterfaces());
    assertSame(rawClass3, resolvableType4.getRawClass());
    assertSame(rawClass2, resolvableType7.getSource());
    assertSame(rawClass2, resolvableType7.getType());
    assertSame(rawClass, resolvableType8.getSource());
    assertSame(rawClass, resolvableType8.getType());
    assertSame(objectType, resolvableType.getRawClass());
    assertSame(objectType, resolvableType.getSource());
    assertSame(objectType, resolvableType.getType());
    assertSame(objectType, typeDescriptor.getSource());
    assertSame(objectType, typeDescriptor.getType());
  }

  /**
   * Test
   * {@link BroadleafExpressionParserImpl#createStandardEvaluationContext(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafExpressionParserImpl#createStandardEvaluationContext(Map)}
   */
  @Test
  public void testCreateStandardEvaluationContext_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafExpressionParserImpl broadleafExpressionParserImpl = new BroadleafExpressionParserImpl();
    HashMap<String, Object> context = new HashMap<>();

    // Act
    StandardEvaluationContext actualCreateStandardEvaluationContextResult = broadleafExpressionParserImpl
        .createStandardEvaluationContext(context);

    // Assert
    TypedValue rootObject = actualCreateStandardEvaluationContextResult.getRootObject();
    Object value = rootObject.getValue();
    assertTrue(value instanceof Map);
    List<ConstructorResolver> constructorResolvers = actualCreateStandardEvaluationContextResult
        .getConstructorResolvers();
    assertEquals(1, constructorResolvers.size());
    assertTrue(constructorResolvers.get(0) instanceof ReflectiveConstructorResolver);
    List<MethodResolver> methodResolvers = actualCreateStandardEvaluationContextResult.getMethodResolvers();
    assertEquals(1, methodResolvers.size());
    assertTrue(methodResolvers.get(0) instanceof ReflectiveMethodResolver);
    List<PropertyAccessor> propertyAccessors = actualCreateStandardEvaluationContextResult.getPropertyAccessors();
    assertEquals(1, propertyAccessors.size());
    PropertyAccessor getResult = propertyAccessors.get(0);
    assertTrue(getResult instanceof ReflectivePropertyAccessor);
    assertTrue(
        actualCreateStandardEvaluationContextResult.getOperatorOverloader() instanceof StandardOperatorOverloader);
    assertTrue(actualCreateStandardEvaluationContextResult.getTypeComparator() instanceof StandardTypeComparator);
    assertTrue(actualCreateStandardEvaluationContextResult.getTypeConverter() instanceof StandardTypeConverter);
    TypeLocator typeLocator = actualCreateStandardEvaluationContextResult.getTypeLocator();
    assertTrue(typeLocator instanceof StandardTypeLocator);
    List<String> importPrefixes = ((StandardTypeLocator) typeLocator).getImportPrefixes();
    assertEquals(1, importPrefixes.size());
    assertEquals("java.lang", importPrefixes.get(0));
    TypeDescriptor typeDescriptor = rootObject.getTypeDescriptor();
    assertEquals("java.util.HashMap", typeDescriptor.getName());
    assertNull(getResult.getSpecificTargetClasses());
    ResolvableType resolvableType = typeDescriptor.getResolvableType();
    ResolvableType componentType = resolvableType.getComponentType();
    assertNull(componentType.getRawClass());
    ResolvableType[] generics = resolvableType.getGenerics();
    ResolvableType resolvableType2 = generics[0];
    assertNull(resolvableType2.getRawClass());
    ResolvableType resolvableType3 = generics[1];
    assertNull(resolvableType3.getRawClass());
    ResolvableType superType = resolvableType.getSuperType();
    ResolvableType[] interfaces = superType.getInterfaces();
    ResolvableType resolvableType4 = interfaces[0];
    ResolvableType[] generics2 = resolvableType4.getGenerics();
    ResolvableType resolvableType5 = generics2[0];
    assertNull(resolvableType5.getRawClass());
    ResolvableType resolvableType6 = generics2[1];
    assertNull(resolvableType6.getRawClass());
    assertNull(((ReflectivePropertyAccessor) getResult).getLastReadInvokerPair());
    assertNull(typeDescriptor.getElementTypeDescriptor());
    assertNull(typeDescriptor.getMapKeyTypeDescriptor());
    assertNull(typeDescriptor.getMapValueTypeDescriptor());
    assertNull(actualCreateStandardEvaluationContextResult.getBeanResolver());
    ResolvableType[] generics3 = componentType.getGenerics();
    assertEquals(0, generics3.length);
    ResolvableType superType2 = superType.getSuperType();
    assertEquals(0, superType2.getGenerics().length);
    ResolvableType[] interfaces2 = resolvableType.getInterfaces();
    ResolvableType resolvableType7 = interfaces2[1];
    assertEquals(0, resolvableType7.getGenerics().length);
    ResolvableType resolvableType8 = interfaces2[2];
    assertEquals(0, resolvableType8.getGenerics().length);
    assertEquals(0, superType2.getInterfaces().length);
    assertEquals(0, resolvableType4.getInterfaces().length);
    ResolvableType resolvableType9 = interfaces2[0];
    assertEquals(0, resolvableType9.getInterfaces().length);
    assertEquals(0, resolvableType7.getInterfaces().length);
    assertEquals(0, resolvableType8.getInterfaces().length);
    assertEquals(0, typeDescriptor.getAnnotations().length);
    assertEquals(1, interfaces.length);
    assertEquals(2, superType.getGenerics().length);
    assertEquals(2, generics.length);
    assertEquals(2, generics2.length);
    assertEquals(2, resolvableType9.getGenerics().length);
    assertEquals(3, interfaces2.length);
    assertFalse(componentType.hasGenerics());
    assertFalse(superType2.hasGenerics());
    assertFalse(resolvableType2.hasGenerics());
    assertFalse(resolvableType3.hasGenerics());
    assertFalse(resolvableType5.hasGenerics());
    assertFalse(resolvableType6.hasGenerics());
    assertFalse(resolvableType7.hasGenerics());
    assertFalse(resolvableType8.hasGenerics());
    assertFalse(typeDescriptor.isArray());
    assertFalse(typeDescriptor.isCollection());
    assertFalse(typeDescriptor.isPrimitive());
    assertTrue(((Map<Object, Object>) value).isEmpty());
    assertTrue(superType.hasGenerics());
    assertTrue(resolvableType.hasGenerics());
    assertTrue(resolvableType4.hasGenerics());
    assertTrue(resolvableType9.hasGenerics());
    assertTrue(typeDescriptor.isMap());
    assertTrue(actualCreateStandardEvaluationContextResult.isAssignmentEnabled());
    Class<Serializable> expectedRawClass = Serializable.class;
    Class<?> rawClass = resolvableType8.getRawClass();
    assertEquals(expectedRawClass, rawClass);
    Class<Cloneable> expectedRawClass2 = Cloneable.class;
    Class<?> rawClass2 = resolvableType7.getRawClass();
    assertEquals(expectedRawClass2, rawClass2);
    Class<Object> expectedRawClass3 = Object.class;
    assertEquals(expectedRawClass3, superType2.getRawClass());
    Class<AbstractMap> expectedRawClass4 = AbstractMap.class;
    assertEquals(expectedRawClass4, superType.getRawClass());
    Class<HashMap> expectedObjectType = HashMap.class;
    Class<?> objectType = typeDescriptor.getObjectType();
    assertEquals(expectedObjectType, objectType);
    Class<Map> expectedRawClass5 = Map.class;
    Class<?> rawClass3 = resolvableType9.getRawClass();
    assertEquals(expectedRawClass5, rawClass3);
    assertSame(context, value);
    ResolvableType componentType2 = componentType.getComponentType();
    assertSame(componentType2, componentType2);
    assertSame(componentType2, superType2.getComponentType());
    assertSame(componentType2, superType.getComponentType());
    assertSame(componentType2, resolvableType2.getComponentType());
    assertSame(componentType2, resolvableType3.getComponentType());
    assertSame(componentType2, resolvableType5.getComponentType());
    assertSame(componentType2, resolvableType6.getComponentType());
    assertSame(componentType2, resolvableType4.getComponentType());
    assertSame(componentType2, resolvableType9.getComponentType());
    assertSame(componentType2, resolvableType7.getComponentType());
    assertSame(componentType2, resolvableType8.getComponentType());
    assertSame(componentType2, componentType.getSuperType());
    assertSame(componentType2, superType2.getSuperType());
    assertSame(componentType2, resolvableType2.getSuperType());
    assertSame(componentType2, resolvableType3.getSuperType());
    assertSame(componentType2, resolvableType5.getSuperType());
    assertSame(componentType2, resolvableType6.getSuperType());
    assertSame(componentType2, resolvableType4.getSuperType());
    assertSame(componentType2, resolvableType9.getSuperType());
    assertSame(componentType2, resolvableType7.getSuperType());
    assertSame(componentType2, resolvableType8.getSuperType());
    assertSame(generics3, resolvableType2.getGenerics());
    assertSame(generics3, resolvableType3.getGenerics());
    assertSame(generics3, resolvableType5.getGenerics());
    assertSame(generics3, resolvableType6.getGenerics());
    assertSame(generics3, componentType.getInterfaces());
    assertSame(generics3, resolvableType2.getInterfaces());
    assertSame(generics3, resolvableType3.getInterfaces());
    assertSame(generics3, resolvableType5.getInterfaces());
    assertSame(generics3, resolvableType6.getInterfaces());
    assertSame(rawClass3, resolvableType4.getRawClass());
    assertSame(rawClass2, resolvableType7.getSource());
    assertSame(rawClass2, resolvableType7.getType());
    assertSame(rawClass, resolvableType8.getSource());
    assertSame(rawClass, resolvableType8.getType());
    assertSame(objectType, resolvableType.getRawClass());
    assertSame(objectType, resolvableType.getSource());
    assertSame(objectType, resolvableType.getType());
    assertSame(objectType, typeDescriptor.getSource());
    assertSame(objectType, typeDescriptor.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafExpressionParserImpl#getExpressionParser()}
   *   <li>{@link BroadleafExpressionParserImpl#getPropertyAccessors()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafExpressionParserImpl broadleafExpressionParserImpl = new BroadleafExpressionParserImpl();

    // Act
    ExpressionParser actualExpressionParser = broadleafExpressionParserImpl.getExpressionParser();

    // Assert
    assertTrue(actualExpressionParser instanceof SpelExpressionParser);
    assertSame(broadleafExpressionParserImpl.propertyAccessors, broadleafExpressionParserImpl.getPropertyAccessors());
  }
}
