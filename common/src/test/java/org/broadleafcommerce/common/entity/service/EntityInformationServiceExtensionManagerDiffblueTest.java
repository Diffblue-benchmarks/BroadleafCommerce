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
package org.broadleafcommerce.common.entity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.entity.dto.EntityInformationDto;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
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
public class EntityInformationServiceExtensionManagerDiffblueTest {
  @Autowired
  private EntityInformationServiceExtensionManager entityInformationServiceExtensionManager;

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateEntityInformationDto() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateEntityInformationDto2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateEntityInformationDto3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .updateEntityInformationDto(Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    verify(abstractEntityInformationServiceExtensionHandler).updateEntityInformationDto(isA(EntityInformationDto.class),
        isA(Object.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateEntityInformationDto4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .updateEntityInformationDto(Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    verify(abstractEntityInformationServiceExtensionHandler).updateEntityInformationDto(isA(EntityInformationDto.class),
        isA(Object.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateEntityInformationDto5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateEntityInformationDto6() {
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
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager2 = new EntityInformationServiceExtensionManager();

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    entityInformationServiceExtensionManager2.updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateEntityInformationDto_givenEntityInformationServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>When {@link EntityInformationDto} (default constructor) CatalogId is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateEntityInformationDto_whenEntityInformationDtoCatalogIdIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateBasicEntityInformationDto() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateBasicEntityInformationDto2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateBasicEntityInformationDto3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateBasicEntityInformationDto4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .updateBasicEntityInformationDto(Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    verify(abstractEntityInformationServiceExtensionHandler)
        .updateBasicEntityInformationDto(isA(EntityInformationDto.class), isA(Object.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateBasicEntityInformationDto5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .updateBasicEntityInformationDto(Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    verify(abstractEntityInformationServiceExtensionHandler)
        .updateBasicEntityInformationDto(isA(EntityInformationDto.class), isA(Object.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateBasicEntityInformationDto6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateBasicEntityInformationDto7() {
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
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager2 = new EntityInformationServiceExtensionManager();

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    entityInformationServiceExtensionManager2.updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>When {@link EntityInformationDto} (default constructor) CatalogId is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateBasicEntityInformationDto_whenEntityInformationDtoCatalogIdIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#isEnabled()}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new EntityInformationServiceExtensionManager()).isEnabled());
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetBaseProfileIdForSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getBaseProfileIdForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetBaseProfileIdForSite2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getBaseProfileIdForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetBaseProfileIdForSite3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getBaseProfileIdForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBaseProfileIdForSite = entityInformationServiceExtensionManager
        .getBaseProfileIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getBaseProfileIdForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualBaseProfileIdForSite);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetBaseProfileIdForSite4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getBaseProfileIdForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBaseProfileIdForSite = entityInformationServiceExtensionManager
        .getBaseProfileIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getBaseProfileIdForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualBaseProfileIdForSite);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetBaseProfileIdForSite5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBaseProfileIdForSite = entityInformationServiceExtensionManager
        .getBaseProfileIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBaseProfileIdForSite);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetBaseProfileIdForSite6() {
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
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager2 = new EntityInformationServiceExtensionManager();
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    entityInformationServiceExtensionManager2.getBaseProfileIdForSite(site, erh);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetBaseProfileIdForSite_givenEntityInformationServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getBaseProfileIdForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetBaseProfileIdForSite_whenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl site = mock(SiteImpl.class);

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getBaseProfileIdForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetParentSiteForProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getParentSiteForProfile(profile, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetParentSiteForProfile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getParentSiteForProfile(profile, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetParentSiteForProfile3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getParentSiteForProfile(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Site>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualParentSiteForProfile = entityInformationServiceExtensionManager
        .getParentSiteForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getParentSiteForProfile(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualParentSiteForProfile);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetParentSiteForProfile4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getParentSiteForProfile(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Site>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualParentSiteForProfile = entityInformationServiceExtensionManager
        .getParentSiteForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getParentSiteForProfile(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualParentSiteForProfile);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetParentSiteForProfile5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualParentSiteForProfile = entityInformationServiceExtensionManager
        .getParentSiteForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualParentSiteForProfile);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetParentSiteForProfile6() {
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
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager2 = new EntityInformationServiceExtensionManager();
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act
    entityInformationServiceExtensionManager2.getParentSiteForProfile(profile, erh);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetParentSiteForProfile_givenEntityInformationServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getParentSiteForProfile(profile, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetParentSiteForProfile_whenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl profile = mock(SiteImpl.class);

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getParentSiteForProfile(profile, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetOkayToUseSiteDiscriminator() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    ExtensionResultHolder<Boolean> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<Boolean>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = entityInformationServiceExtensionManager
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(erh).setResult(eq(true));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetOkayToUseSiteDiscriminator2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    ExtensionResultHolder<Boolean> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<Boolean>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = entityInformationServiceExtensionManager
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(erh).setResult(eq(true));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetOkayToUseSiteDiscriminator3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getOkayToUseSiteDiscriminator(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Boolean>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    ExtensionResultHolder<Boolean> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<Boolean>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = entityInformationServiceExtensionManager
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getOkayToUseSiteDiscriminator(isA(Object.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    verify(erh).setResult(eq(true));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetOkayToUseSiteDiscriminator4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getOkayToUseSiteDiscriminator(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Boolean>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    ExtensionResultHolder<Boolean> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<Boolean>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = entityInformationServiceExtensionManager
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getOkayToUseSiteDiscriminator(isA(Object.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    verify(erh).setResult(eq(true));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetOkayToUseSiteDiscriminator5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    ExtensionResultHolder<Boolean> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<Boolean>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = entityInformationServiceExtensionManager
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    verify(erh).setResult(eq(true));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOkayToUseSiteDiscriminator6() {
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
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager2 = new EntityInformationServiceExtensionManager();

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    entityInformationServiceExtensionManager2.getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetOkayToUseSiteDiscriminator_givenEntityInformationServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    ExtensionResultHolder<Boolean> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<Boolean>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = entityInformationServiceExtensionManager
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(erh).setResult(eq(true));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetOkayToUseSiteDiscriminator_whenExtensionResultHolderResultIsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  public void testFindAllCatalogs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    ExtensionResultHolder<List<Catalog>> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<List<Catalog>>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(erh).setResult(isA(List.class));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  public void testFindAllCatalogs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    ExtensionResultHolder<List<Catalog>> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<List<Catalog>>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(erh).setResult(isA(List.class));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  public void testFindAllCatalogs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .findAllCatalogs(Mockito.<ExtensionResultHolder<List<Catalog>>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    ExtensionResultHolder<List<Catalog>> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<List<Catalog>>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).findAllCatalogs(isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    verify(erh).setResult(isA(List.class));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  public void testFindAllCatalogs4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .findAllCatalogs(Mockito.<ExtensionResultHolder<List<Catalog>>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    ExtensionResultHolder<List<Catalog>> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<List<Catalog>>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).findAllCatalogs(isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    verify(erh).setResult(isA(List.class));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  public void testFindAllCatalogs5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    ExtensionResultHolder<List<Catalog>> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<List<Catalog>>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    verify(erh).setResult(isA(List.class));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAllCatalogs6() {
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
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager2 = new EntityInformationServiceExtensionManager();

    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    entityInformationServiceExtensionManager2.findAllCatalogs(erh);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  public void testFindAllCatalogs_givenEntityInformationServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    ExtensionResultHolder<List<Catalog>> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<List<Catalog>>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(erh).setResult(isA(List.class));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  public void testFindAllCatalogs_whenExtensionResultHolderResultIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();

    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityInformationServiceExtensionManager.findAllCatalogs(erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetDefaultCatalogIdForSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getDefaultCatalogIdForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetDefaultCatalogIdForSite2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getDefaultCatalogIdForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetDefaultCatalogIdForSite3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getDefaultCatalogIdForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualDefaultCatalogIdForSite = entityInformationServiceExtensionManager
        .getDefaultCatalogIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getDefaultCatalogIdForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualDefaultCatalogIdForSite);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetDefaultCatalogIdForSite4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getDefaultCatalogIdForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualDefaultCatalogIdForSite = entityInformationServiceExtensionManager
        .getDefaultCatalogIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getDefaultCatalogIdForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualDefaultCatalogIdForSite);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetDefaultCatalogIdForSite5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualDefaultCatalogIdForSite = entityInformationServiceExtensionManager
        .getDefaultCatalogIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualDefaultCatalogIdForSite);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultCatalogIdForSite6() {
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
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager2 = new EntityInformationServiceExtensionManager();
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    entityInformationServiceExtensionManager2.getDefaultCatalogIdForSite(site, erh);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetDefaultCatalogIdForSite_givenEntityInformationServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getDefaultCatalogIdForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetDefaultCatalogIdForSite_whenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl site = mock(SiteImpl.class);

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getDefaultCatalogIdForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetChildSiteIdsForProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getChildSiteIdsForProfile(profile, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetChildSiteIdsForProfile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getChildSiteIdsForProfile(profile, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetChildSiteIdsForProfile3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getChildSiteIdsForProfile(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Set<Long>>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualChildSiteIdsForProfile = entityInformationServiceExtensionManager
        .getChildSiteIdsForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getChildSiteIdsForProfile(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualChildSiteIdsForProfile);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetChildSiteIdsForProfile4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getChildSiteIdsForProfile(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Set<Long>>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualChildSiteIdsForProfile = entityInformationServiceExtensionManager
        .getChildSiteIdsForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getChildSiteIdsForProfile(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualChildSiteIdsForProfile);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetChildSiteIdsForProfile5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualChildSiteIdsForProfile = entityInformationServiceExtensionManager
        .getChildSiteIdsForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualChildSiteIdsForProfile);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetChildSiteIdsForProfile6() {
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
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager2 = new EntityInformationServiceExtensionManager();
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act
    entityInformationServiceExtensionManager2.getChildSiteIdsForProfile(profile, erh);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetChildSiteIdsForProfile_givenEntityInformationServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getChildSiteIdsForProfile(profile, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetChildSiteIdsForProfile_whenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl profile = mock(SiteImpl.class);

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getChildSiteIdsForProfile(profile, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetTypeForSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetTypeForSite2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetTypeForSite3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getTypeForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTypeForSite = entityInformationServiceExtensionManager.getTypeForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getTypeForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualTypeForSite);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetTypeForSite4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getTypeForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTypeForSite = entityInformationServiceExtensionManager.getTypeForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getTypeForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualTypeForSite);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetTypeForSite5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTypeForSite = entityInformationServiceExtensionManager.getTypeForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTypeForSite);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTypeForSite6() {
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
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager2 = new EntityInformationServiceExtensionManager();
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    entityInformationServiceExtensionManager2.getTypeForSite(site, erh);
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetTypeForSite_givenEntityInformationServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(site, erh));
  }

  /**
   * Test
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager} (default
   * constructor).</li>
   *   <li>When {@link SiteImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  public void testGetTypeForSite_givenEntityInformationServiceExtensionManager_whenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    SiteImpl site = mock(SiteImpl.class);

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(site, erh));
  }
}
