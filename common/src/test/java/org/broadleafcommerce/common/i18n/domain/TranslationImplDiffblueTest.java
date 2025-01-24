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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class TranslationImplDiffblueTest {
  @Autowired
  private TranslationImpl translationImpl;

  /**
   * Test {@link TranslationImpl#getEntityType()}.
   * <p>
   * Method under test: {@link TranslationImpl#getEntityType()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetEntityType() {
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
    (new TranslationImpl()).getEntityType();
  }

  /**
   * Test {@link TranslationImpl#getEntityType()}.
   * <ul>
   *   <li>Given {@link TranslationImpl} (default constructor) EntityType is
   * {@link TranslatedEntity#CATALOG}.</li>
   *   <li>Then return {@link TranslatedEntity#CATALOG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType_givenTranslationImplEntityTypeIsCatalog_thenReturnCatalog() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityType(TranslatedEntity.CATALOG);

    // Act
    TranslatedEntity actualEntityType = translationImpl.getEntityType();

    // Assert
    assertSame(actualEntityType.CATALOG, actualEntityType);
  }

  /**
   * Test {@link TranslationImpl#getEntityType()}.
   * <ul>
   *   <li>Given {@link TranslationImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType_givenTranslationImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TranslationImpl()).getEntityType());
  }

  /**
   * Test {@link TranslationImpl#getEntityType()}.
   * <ul>
   *   <li>Then return {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType_thenReturnFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslatedEntity entityType = mock(TranslatedEntity.class);
    when(entityType.getFriendlyType()).thenReturn("Friendly Type");

    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityType(entityType);

    // Act
    TranslatedEntity actualEntityType = translationImpl.getEntityType();

    // Assert
    verify(entityType).getFriendlyType();
    assertEquals("Friendly Type", actualEntityType.getFriendlyType());
    assertEquals("Type", actualEntityType.getType());
  }

  /**
   * Test {@link TranslationImpl#setEntityType(TranslatedEntity)}.
   * <p>
   * Method under test: {@link TranslationImpl#setEntityType(TranslatedEntity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetEntityType() {
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
    (new TranslationImpl()).setEntityType(TranslatedEntity.CATALOG);
  }

  /**
   * Test {@link TranslationImpl#setEntityType(TranslatedEntity)}.
   * <ul>
   *   <li>Then {@link TranslationImpl} (default constructor) EntityType
   * FriendlyType is {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#setEntityType(TranslatedEntity)}
   */
  @Test
  public void testSetEntityType_thenTranslationImplEntityTypeFriendlyTypeIsFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    TranslatedEntity entityType = mock(TranslatedEntity.class);
    when(entityType.getFriendlyType()).thenReturn("Friendly Type");

    // Act
    translationImpl.setEntityType(entityType);

    // Assert
    verify(entityType).getFriendlyType();
    TranslatedEntity entityType2 = translationImpl.getEntityType();
    assertEquals("Friendly Type", entityType2.getFriendlyType());
    assertEquals("Friendly Type", translationImpl.entityType);
    assertEquals("Type", entityType2.getType());
  }

  /**
   * Test {@link TranslationImpl#setEntityType(TranslatedEntity)}.
   * <ul>
   *   <li>When {@link TranslatedEntity#CATALOG}.</li>
   *   <li>Then {@link TranslationImpl} (default constructor)
   * {@link TranslationImpl#entityType} is {@code Catalog}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#setEntityType(TranslatedEntity)}
   */
  @Test
  public void testSetEntityType_whenCatalog_thenTranslationImplEntityTypeIsCatalog() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    TranslatedEntity entityType = TranslatedEntity.CATALOG;

    // Act
    translationImpl.setEntityType(entityType);

    // Assert
    assertEquals("Catalog", translationImpl.entityType);
    TranslatedEntity expectedEntityType = entityType.CATALOG;
    assertSame(expectedEntityType, translationImpl.getEntityType());
  }

  /**
   * Test
   * {@link TranslationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link TranslationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(BLCFieldUtils.NULL_FIELD, true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Translation> actualCreateOrRetrieveCopyInstanceResult = translationImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link TranslationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link TranslationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
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
    TranslationImpl translationImpl2 = new TranslationImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    translationImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TranslationImpl}
   *   <li>{@link TranslationImpl#setEntityId(String)}
   *   <li>{@link TranslationImpl#setFieldName(String)}
   *   <li>{@link TranslationImpl#setId(Long)}
   *   <li>{@link TranslationImpl#setLocaleCode(String)}
   *   <li>{@link TranslationImpl#setTranslatedValue(String)}
   *   <li>{@link TranslationImpl#getEntityId()}
   *   <li>{@link TranslationImpl#getFieldName()}
   *   <li>{@link TranslationImpl#getId()}
   *   <li>{@link TranslationImpl#getLocaleCode()}
   *   <li>{@link TranslationImpl#getTranslatedValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TranslationImpl actualTranslationImpl = new TranslationImpl();
    actualTranslationImpl.setEntityId("42");
    actualTranslationImpl.setFieldName("Field Name");
    actualTranslationImpl.setId(1L);
    actualTranslationImpl.setLocaleCode("en");
    actualTranslationImpl.setTranslatedValue("42");
    String actualEntityId = actualTranslationImpl.getEntityId();
    String actualFieldName = actualTranslationImpl.getFieldName();
    Long actualId = actualTranslationImpl.getId();
    String actualLocaleCode = actualTranslationImpl.getLocaleCode();

    // Assert that nothing has changed
    assertEquals("42", actualEntityId);
    assertEquals("42", actualTranslationImpl.getTranslatedValue());
    assertEquals("Field Name", actualFieldName);
    assertEquals("en", actualLocaleCode);
    assertEquals(1L, actualId.longValue());
  }
}
