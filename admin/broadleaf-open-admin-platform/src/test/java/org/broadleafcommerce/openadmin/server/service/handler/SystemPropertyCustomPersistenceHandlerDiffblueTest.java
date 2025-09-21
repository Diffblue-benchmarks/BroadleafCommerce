/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.config.domain.NullSystemProperty;
import org.broadleafcommerce.common.config.domain.SystemProperty;
import org.broadleafcommerce.common.config.service.SystemPropertiesService;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SystemPropertyCustomPersistenceHandlerDiffblueTest {
  @Mock private SystemPropertiesService systemPropertiesService;

  @InjectMocks
  private SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler;

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean SystemPropertyCustomPersistenceHandler.classMatches(PersistencePackage)"
  })
  public void testClassMatches_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(systemPropertyCustomPersistenceHandler.classMatches(new PersistencePackage()));
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean SystemPropertyCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(systemPropertyCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean SystemPropertyCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(systemPropertyCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} (default constructor) Type is array of {@link String} with {@code
   *       Unable to perform fetch for entity:}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity SystemPropertyCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenEntityTypeIsArrayOfStringWithUnableToPerformFetchForEntity()
      throws ServiceException {
    // Arrange
    Entity entity = new Entity();
    entity.setType(new String[] {"Unable to perform fetch for entity: "});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            systemPropertyCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, helper));
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.common.config.domain.SystemProperty"), isNull());
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link NullSystemProperty} (default constructor).
   *   <li>Then calls {@link DynamicEntityDao#retrieve(Class, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity SystemPropertyCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenNullSystemProperty_thenCallsRetrieve() throws ServiceException {
    // Arrange
    Entity entity = new Entity();
    entity.setType(new String[] {"java.util.List"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.retrieve(Mockito.<Class<?>>any(), Mockito.<Object>any()))
        .thenReturn(new NullSystemProperty());

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.createPopulatedInstance(
            Mockito.<Serializable>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<Boolean>any()))
        .thenThrow(new RuntimeException());
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            systemPropertyCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, helper));
    verify(dynamicEntityDao).retrieve(isA(Class.class), isA(Object.class));
    verify(helper)
        .createPopulatedInstance(
            isA(Serializable.class), isA(Entity.class), isA(Map.class), eq(false));
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.common.config.domain.SystemProperty"), isNull());
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       List}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity SystemPropertyCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithJavaUtilList()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"java.util.List"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            systemPropertyCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       Type}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity SystemPropertyCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            systemPropertyCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#validateTypeAndValueCombo(SystemProperty)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SystemPropertyCustomPersistenceHandler#validateTypeAndValueCombo(SystemProperty)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity SystemPropertyCustomPersistenceHandler.validateTypeAndValueCombo(SystemProperty)"
  })
  public void testValidateTypeAndValueCombo_thenReturnNull() {
    // Arrange
    when(systemPropertiesService.isValueValidForType(
            Mockito.<String>any(), Mockito.<SystemPropertyFieldType>any()))
        .thenReturn(true);

    // Act
    Entity actualValidateTypeAndValueComboResult =
        systemPropertyCustomPersistenceHandler.validateTypeAndValueCombo(new NullSystemProperty());

    // Assert
    verify(systemPropertiesService).isValueValidForType(isNull(), isNull());
    assertNull(actualValidateTypeAndValueComboResult);
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#validateTypeAndValueCombo(SystemProperty)}.
   *
   * <ul>
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SystemPropertyCustomPersistenceHandler#validateTypeAndValueCombo(SystemProperty)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity SystemPropertyCustomPersistenceHandler.validateTypeAndValueCombo(SystemProperty)"
  })
  public void testValidateTypeAndValueCombo_thenReturnTypeIsNull() {
    // Arrange
    when(systemPropertiesService.isValueValidForType(
            Mockito.<String>any(), Mockito.<SystemPropertyFieldType>any()))
        .thenReturn(false);

    // Act
    Entity actualValidateTypeAndValueComboResult =
        systemPropertyCustomPersistenceHandler.validateTypeAndValueCombo(new NullSystemProperty());

    // Assert
    verify(systemPropertiesService).isValueValidForType(isNull(), isNull());
    assertNull(actualValidateTypeAndValueComboResult.getType());
    assertNull(actualValidateTypeAndValueComboResult.getDeployDate());
    assertNull(actualValidateTypeAndValueComboResult.getProperties());
    Map<String, List<String>> propertyValidationErrors =
        actualValidateTypeAndValueComboResult.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    assertFalse(actualValidateTypeAndValueComboResult.getActive());
    assertFalse(actualValidateTypeAndValueComboResult.getDeleted());
    assertFalse(actualValidateTypeAndValueComboResult.getInactive());
    assertFalse(actualValidateTypeAndValueComboResult.isDirty());
    assertFalse(actualValidateTypeAndValueComboResult.isMultiPartAvailableOnThread());
    assertFalse(actualValidateTypeAndValueComboResult.isPreAdd());
    assertTrue(actualValidateTypeAndValueComboResult.getGlobalValidationErrors().isEmpty());
    assertTrue(propertyValidationErrors.containsKey("value"));
    assertTrue(actualValidateTypeAndValueComboResult.getPMap().isEmpty());
    assertSame(
        propertyValidationErrors, actualValidateTypeAndValueComboResult.getValidationErrors());
  }
}
