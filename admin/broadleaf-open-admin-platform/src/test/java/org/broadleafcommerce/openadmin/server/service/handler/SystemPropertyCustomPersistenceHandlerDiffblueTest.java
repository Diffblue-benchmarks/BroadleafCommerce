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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @InjectMocks
  private SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler;

  @Mock
  private SystemPropertiesService systemPropertiesService;

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean SystemPropertyCustomPersistenceHandler.classMatches(PersistencePackage)"})
  public void testClassMatches_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(systemPropertyCustomPersistenceHandler.classMatches(new PersistencePackage()));
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean SystemPropertyCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(systemPropertyCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean SystemPropertyCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(systemPropertyCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity SystemPropertyCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> systemPropertyCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.common.config.domain.SystemProperty"), isNull());
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity SystemPropertyCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithJavaUtilList() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"java.util.List"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> systemPropertyCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity SystemPropertyCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> systemPropertyCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#validateTypeAndValueCombo(SystemProperty)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyCustomPersistenceHandler#validateTypeAndValueCombo(SystemProperty)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity SystemPropertyCustomPersistenceHandler.validateTypeAndValueCombo(SystemProperty)"})
  public void testValidateTypeAndValueCombo_thenReturnNull() {
    // Arrange
    when(systemPropertiesService.isValueValidForType(Mockito.<String>any(), Mockito.<SystemPropertyFieldType>any()))
        .thenReturn(true);

    // Act
    Entity actualValidateTypeAndValueComboResult = systemPropertyCustomPersistenceHandler
        .validateTypeAndValueCombo(new NullSystemProperty());

    // Assert
    verify(systemPropertiesService).isValueValidForType(isNull(), isNull());
    assertNull(actualValidateTypeAndValueComboResult);
  }

  /**
   * Test {@link SystemPropertyCustomPersistenceHandler#validateTypeAndValueCombo(SystemProperty)}.
   * <ul>
   *   <li>Then return Type is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyCustomPersistenceHandler#validateTypeAndValueCombo(SystemProperty)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity SystemPropertyCustomPersistenceHandler.validateTypeAndValueCombo(SystemProperty)"})
  public void testValidateTypeAndValueCombo_thenReturnTypeIsNull() {
    // Arrange
    when(systemPropertiesService.isValueValidForType(Mockito.<String>any(), Mockito.<SystemPropertyFieldType>any()))
        .thenReturn(false);

    // Act
    Entity actualValidateTypeAndValueComboResult = systemPropertyCustomPersistenceHandler
        .validateTypeAndValueCombo(new NullSystemProperty());

    // Assert
    verify(systemPropertiesService).isValueValidForType(isNull(), isNull());
    assertNull(actualValidateTypeAndValueComboResult.getType());
    assertNull(actualValidateTypeAndValueComboResult.getProperties());
    assertNull(actualValidateTypeAndValueComboResult.getDeployDate());
    Map<String, List<String>> propertyValidationErrors = actualValidateTypeAndValueComboResult
        .getPropertyValidationErrors();
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
    assertSame(propertyValidationErrors, actualValidateTypeAndValueComboResult.getValidationErrors());
  }
}
