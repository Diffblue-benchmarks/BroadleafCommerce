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
package org.broadleafcommerce.common.config.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.cache.CacheManager;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.config.domain.NullSystemProperty;
import org.broadleafcommerce.common.config.domain.SystemProperty;
import org.broadleafcommerce.common.config.domain.SystemPropertyImpl;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class SystemPropertiesDaoImplDiffblueTest {
  @Mock private CacheManager cacheManager;

  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private SystemPropertiesDaoImpl systemPropertiesDaoImpl;

  /**
   * Test {@link SystemPropertiesDaoImpl#removeFromCache(SystemProperty)}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#removeFromCache(SystemProperty)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SystemPropertiesDaoImpl.removeFromCache(SystemProperty)"})
  public void testRemoveFromCache_thenThrowNoResultException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(
        NoResultException.class,
        () -> systemPropertiesDaoImpl.removeFromCache(new NullSystemProperty()));
    verify(cacheManager).getCache("blSystemPropertyNullCheckCache");
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#createNewSystemProperty()}.
   *
   * <ul>
   *   <li>Then return {@link SystemPropertyImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#createNewSystemProperty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemProperty SystemPropertiesDaoImpl.createNewSystemProperty()"})
  public void testCreateNewSystemProperty_thenReturnSystemPropertyImpl() {
    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("Friendly Group");
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl.setValue("42");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(systemPropertyImpl);

    // Act
    SystemProperty actualCreateNewSystemPropertyResult =
        systemPropertiesDaoImpl.createNewSystemProperty();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.config.domain.SystemProperty");
    assertSame(systemPropertyImpl, actualCreateNewSystemPropertyResult);
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#createNewSystemProperty()}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#createNewSystemProperty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemProperty SystemPropertiesDaoImpl.createNewSystemProperty()"})
  public void testCreateNewSystemProperty_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(NoResultException.class, () -> systemPropertiesDaoImpl.createNewSystemProperty());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.config.domain.SystemProperty");
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#getLogger()}.
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#getLogger()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.commons.logging.Log SystemPropertiesDaoImpl.getLogger()"})
  public void testGetLogger() {
    // Arrange, Act and Assert
    assertSame(SystemPropertiesDaoImpl.LOG, new SystemPropertiesDaoImpl().getLogger());
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#getSite()}.
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#getSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesDaoImpl.getSite()"})
  public void testGetSite() {
    // Arrange, Act and Assert
    assertEquals("", systemPropertiesDaoImpl.getSite());
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#getNullObject(Class)}.
   *
   * <p>Method under test: {@link SystemPropertiesDaoImpl#getNullObject(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemProperty SystemPropertiesDaoImpl.getNullObject(Class)"})
  public void testGetNullObject() {
    // Arrange
    Class<SystemProperty> responseClass = SystemProperty.class;

    // Act
    SystemProperty actualNullObject = systemPropertiesDaoImpl.getNullObject(responseClass);

    // Assert
    assertTrue(actualNullObject instanceof NullSystemProperty);
    assertNull(actualNullObject.getOverrideGeneratedPropertyName());
    assertNull(actualNullObject.getId());
    assertNull(actualNullObject.getFriendlyGroup());
    assertNull(actualNullObject.getFriendlyName());
    assertNull(actualNullObject.getFriendlyTab());
    assertNull(actualNullObject.getName());
    assertNull(actualNullObject.getValue());
    assertNull(actualNullObject.getPropertyType());
  }
}
