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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.config.dao.ModuleConfigurationDao;
import org.broadleafcommerce.common.config.domain.ModuleConfiguration;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ModuleConfigurationServiceImplDiffblueTest {
  @Mock private ModuleConfigurationDao moduleConfigurationDao;

  @InjectMocks private ModuleConfigurationServiceImpl moduleConfigurationServiceImpl;

  /**
   * Test {@link ModuleConfigurationServiceImpl#findById(Long)}.
   *
   * <p>Method under test: {@link ModuleConfigurationServiceImpl#findById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ModuleConfiguration ModuleConfigurationServiceImpl.findById(Long)"})
  public void testFindById() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    when(moduleConfigurationDao.readById(Mockito.<Long>any())).thenReturn(siteMapConfigurationImpl);

    // Act
    ModuleConfiguration actualFindByIdResult = moduleConfigurationServiceImpl.findById(1L);

    // Assert
    verify(moduleConfigurationDao).readById(1L);
    assertSame(siteMapConfigurationImpl, actualFindByIdResult);
  }

  /**
   * Test {@link ModuleConfigurationServiceImpl#save(ModuleConfiguration)}.
   *
   * <p>Method under test: {@link ModuleConfigurationServiceImpl#save(ModuleConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModuleConfiguration ModuleConfigurationServiceImpl.save(ModuleConfiguration)"
  })
  public void testSave() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    when(moduleConfigurationDao.save(Mockito.<ModuleConfiguration>any()))
        .thenReturn(siteMapConfigurationImpl);

    // Act
    ModuleConfiguration actualSaveResult =
        moduleConfigurationServiceImpl.save(new SiteMapConfigurationImpl());

    // Assert
    verify(moduleConfigurationDao).save(isA(ModuleConfiguration.class));
    assertSame(siteMapConfigurationImpl, actualSaveResult);
  }

  /**
   * Test {@link ModuleConfigurationServiceImpl#delete(ModuleConfiguration)}.
   *
   * <p>Method under test: {@link ModuleConfigurationServiceImpl#delete(ModuleConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ModuleConfigurationServiceImpl.delete(ModuleConfiguration)"})
  public void testDelete() {
    // Arrange
    doNothing().when(moduleConfigurationDao).delete(Mockito.<ModuleConfiguration>any());

    // Act
    moduleConfigurationServiceImpl.delete(new SiteMapConfigurationImpl());

    // Assert
    verify(moduleConfigurationDao).delete(isA(ModuleConfiguration.class));
  }

  /**
   * Test {@link
   * ModuleConfigurationServiceImpl#findActiveConfigurationsByType(ModuleConfigurationType)}.
   *
   * <p>Method under test: {@link
   * ModuleConfigurationServiceImpl#findActiveConfigurationsByType(ModuleConfigurationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ModuleConfigurationServiceImpl.findActiveConfigurationsByType(ModuleConfigurationType)"
  })
  public void testFindActiveConfigurationsByType() {
    // Arrange
    when(moduleConfigurationDao.readActiveByType(Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<ModuleConfiguration> actualFindActiveConfigurationsByTypeResult =
        moduleConfigurationServiceImpl.findActiveConfigurationsByType(
            ModuleConfigurationType.ADDRESS_VERIFICATION);

    // Assert
    verify(moduleConfigurationDao).readActiveByType(isA(ModuleConfigurationType.class));
    assertTrue(actualFindActiveConfigurationsByTypeResult.isEmpty());
  }

  /**
   * Test {@link
   * ModuleConfigurationServiceImpl#findAllConfigurationByType(ModuleConfigurationType)}.
   *
   * <p>Method under test: {@link
   * ModuleConfigurationServiceImpl#findAllConfigurationByType(ModuleConfigurationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ModuleConfigurationServiceImpl.findAllConfigurationByType(ModuleConfigurationType)"
  })
  public void testFindAllConfigurationByType() {
    // Arrange
    when(moduleConfigurationDao.readAllByType(Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<ModuleConfiguration> actualFindAllConfigurationByTypeResult =
        moduleConfigurationServiceImpl.findAllConfigurationByType(
            ModuleConfigurationType.ADDRESS_VERIFICATION);

    // Assert
    verify(moduleConfigurationDao).readAllByType(isA(ModuleConfigurationType.class));
    assertTrue(actualFindAllConfigurationByTypeResult.isEmpty());
  }

  /**
   * Test {@link ModuleConfigurationServiceImpl#findByType(Class)}.
   *
   * <p>Method under test: {@link ModuleConfigurationServiceImpl#findByType(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ModuleConfigurationServiceImpl.findByType(Class)"})
  public void testFindByType() {
    // Arrange
    when(moduleConfigurationDao.readByType(Mockito.<Class<ModuleConfiguration>>any()))
        .thenReturn(new ArrayList<>());
    Class<ModuleConfiguration> type = ModuleConfiguration.class;

    // Act
    List<ModuleConfiguration> actualFindByTypeResult =
        moduleConfigurationServiceImpl.findByType(type);

    // Assert
    verify(moduleConfigurationDao).readByType(isA(Class.class));
    assertTrue(actualFindByTypeResult.isEmpty());
  }
}
