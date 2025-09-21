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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.validation.Validator;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

@RunWith(MockitoJUnitRunner.class)
public class BeanValidationEntityValidatorServiceImplDiffblueTest {
  @InjectMocks
  private BeanValidationEntityValidatorServiceImpl beanValidationEntityValidatorServiceImpl;

  @Mock private Validator validator;

  /**
   * Test {@link BeanValidationEntityValidatorServiceImpl#validate(Entity, Serializable, Map,
   * RecordHelper, boolean)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code java.util.List}.
   * </ul>
   *
   * <p>Method under test: {@link BeanValidationEntityValidatorServiceImpl#validate(Entity,
   * Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeanValidationEntityValidatorServiceImpl.validate(Entity, Serializable, Map, RecordHelper, boolean)"
  })
  public void testValidate_givenArrayOfStringWithJavaUtilList() {
    // Arrange
    when(validator.validate(Mockito.<Object>any(), (Class[]) Mockito.any()))
        .thenReturn(new HashSet<>());

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"java.util.List"});

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("name", new AdornedTargetCollectionMetadata());

    // Act
    beanValidationEntityValidatorServiceImpl.validate(
        entity, null, mergedProperties, mock(RecordHelper.class), true);

    // Assert
    verify(validator).validate(isNull(), (Class[]) Mockito.any());
    verify(entity).getType();
  }

  /**
   * Test {@link BeanValidationEntityValidatorServiceImpl#validate(Entity, Serializable, Map,
   * RecordHelper, boolean)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Entity}.
   * </ul>
   *
   * <p>Method under test: {@link BeanValidationEntityValidatorServiceImpl#validate(Entity,
   * Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeanValidationEntityValidatorServiceImpl.validate(Entity, Serializable, Map, RecordHelper, boolean)"
  })
  public void testValidate_givenArrayOfStringWithOrgBroadleafcommerceOpenadminDtoEntity() {
    // Arrange
    when(validator.validate(Mockito.<Object>any(), (Class[]) Mockito.any()))
        .thenReturn(new HashSet<>());

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"org.broadleafcommerce.openadmin.dto.Entity"});

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("name", new AdornedTargetCollectionMetadata());

    // Act
    beanValidationEntityValidatorServiceImpl.validate(
        entity, null, mergedProperties, mock(RecordHelper.class), true);

    // Assert
    verify(validator).validate(isNull(), (Class[]) Mockito.any());
    verify(entity).getType();
  }

  /**
   * Test {@link BeanValidationEntityValidatorServiceImpl#validate(Entity, Serializable, Map,
   * RecordHelper, boolean)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link BeanValidationEntityValidatorServiceImpl#validate(Entity,
   * Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeanValidationEntityValidatorServiceImpl.validate(Entity, Serializable, Map, RecordHelper, boolean)"
  })
  public void testValidate_givenArrayOfStringWithType() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("name", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            beanValidationEntityValidatorServiceImpl.validate(
                entity, null, mergedProperties, mock(RecordHelper.class), true));
    verify(entity).getType();
  }

  /**
   * Test {@link BeanValidationEntityValidatorServiceImpl#validate(Entity, Serializable, Map,
   * RecordHelper, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#addProperty(Property)} does nothing.
   *   <li>Then calls {@link Entity#addProperty(Property)}.
   * </ul>
   *
   * <p>Method under test: {@link BeanValidationEntityValidatorServiceImpl#validate(Entity,
   * Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeanValidationEntityValidatorServiceImpl.validate(Entity, Serializable, Map, RecordHelper, boolean)"
  })
  public void testValidate_givenEntityAddPropertyDoesNothing_thenCallsAddProperty()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("name", new AdornedTargetCollectionMetadata());

    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<?>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getPersistenceManager())
        .thenReturn(persistenceManagerImpl);

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Entity entity2 = mock(Entity.class);
    doNothing().when(entity2).addProperty(Mockito.<Property>any());
    when(entity2.findProperty(Mockito.<String>any())).thenReturn(null);
    when(entity2.getType()).thenReturn(new String[] {"Type"});

    RecordHelper recordHelper = mock(RecordHelper.class);
    when(recordHelper.getRecord(
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<String>any()))
        .thenReturn(entity2);
    when(recordHelper.getFieldManager(anyBoolean())).thenReturn(fieldManager);
    when(recordHelper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            beanValidationEntityValidatorServiceImpl.validate(
                entity, instance, mergedProperties, recordHelper, true));
    verify(entity2).addProperty(isA(Property.class));
    verify(entity).findProperty("name");
    verify(entity2).findProperty("name");
    verify(entity2).getType();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(adornedTargetListPersistenceModule).getPersistenceManager();
    verify(fieldManager).getFieldValue(isA(Object.class), isNull());
    verify(recordHelper).getCompatibleModule(OperationType.BASIC);
    verify(recordHelper).getFieldManager(false);
    verify(recordHelper).getRecord(isA(Map.class), isA(Serializable.class), isNull(), isNull());
  }

  /**
   * Test {@link BeanValidationEntityValidatorServiceImpl#validate(Entity, Serializable, Map,
   * RecordHelper, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property()}.
   *   <li>Then calls {@link Entity#findProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BeanValidationEntityValidatorServiceImpl#validate(Entity,
   * Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeanValidationEntityValidatorServiceImpl.validate(Entity, Serializable, Map, RecordHelper, boolean)"
  })
  public void testValidate_givenEntityFindPropertyReturnProperty_thenCallsFindProperty()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("name", new AdornedTargetCollectionMetadata());

    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<?>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getPersistenceManager())
        .thenReturn(persistenceManagerImpl);

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Entity entity2 = mock(Entity.class);
    when(entity2.findProperty(Mockito.<String>any())).thenReturn(new Property());
    when(entity2.getType()).thenReturn(new String[] {"Type"});

    RecordHelper recordHelper = mock(RecordHelper.class);
    when(recordHelper.getRecord(
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<String>any()))
        .thenReturn(entity2);
    when(recordHelper.getFieldManager(anyBoolean())).thenReturn(fieldManager);
    when(recordHelper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            beanValidationEntityValidatorServiceImpl.validate(
                entity, instance, mergedProperties, recordHelper, true));
    verify(entity2).findProperty("name");
    verify(entity2).getType();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(adornedTargetListPersistenceModule).getPersistenceManager();
    verify(fieldManager).getFieldValue(isA(Object.class), isNull());
    verify(recordHelper).getCompatibleModule(OperationType.BASIC);
    verify(recordHelper).getFieldManager(false);
    verify(recordHelper).getRecord(isA(Map.class), isA(Serializable.class), isNull(), isNull());
  }

  /**
   * Test {@link BeanValidationEntityValidatorServiceImpl#validate(Entity, Serializable, Map,
   * RecordHelper, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link BeanValidationEntityValidatorServiceImpl#validate(Entity,
   * Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeanValidationEntityValidatorServiceImpl.validate(Entity, Serializable, Map, RecordHelper, boolean)"
  })
  public void testValidate_givenProperty_whenEntityFindPropertyReturnProperty()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("name", new AdornedTargetCollectionMetadata());

    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<?>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getPersistenceManager())
        .thenReturn(persistenceManagerImpl);

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Entity entity2 = mock(Entity.class);
    when(entity2.findProperty(Mockito.<String>any())).thenReturn(new Property());
    when(entity2.getType()).thenReturn(new String[] {"Type"});

    RecordHelper recordHelper = mock(RecordHelper.class);
    when(recordHelper.getRecord(
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<String>any()))
        .thenReturn(entity2);
    when(recordHelper.getFieldManager(anyBoolean())).thenReturn(fieldManager);
    when(recordHelper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            beanValidationEntityValidatorServiceImpl.validate(
                entity, instance, mergedProperties, recordHelper, true));
    verify(entity, atLeast(1)).findProperty("name");
    verify(entity2, atLeast(1)).findProperty("name");
    verify(entity2).getType();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(adornedTargetListPersistenceModule).getPersistenceManager();
    verify(fieldManager).getFieldValue(isA(Object.class), isNull());
    verify(recordHelper).getCompatibleModule(OperationType.BASIC);
    verify(recordHelper).getFieldManager(false);
    verify(recordHelper).getRecord(isA(Map.class), isA(Serializable.class), isNull(), isNull());
  }

  /**
   * Test {@link BeanValidationEntityValidatorServiceImpl#validate(Entity, Serializable, Map,
   * RecordHelper, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityDaoImpl#getIdMetadata(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link BeanValidationEntityValidatorServiceImpl#validate(Entity,
   * Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeanValidationEntityValidatorServiceImpl.validate(Entity, Serializable, Map, RecordHelper, boolean)"
  })
  public void testValidate_thenCallsGetIdMetadata()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<?>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getPersistenceManager())
        .thenReturn(persistenceManagerImpl);

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Entity entity2 = mock(Entity.class);
    when(entity2.getType()).thenReturn(new String[] {"Type"});

    RecordHelper recordHelper = mock(RecordHelper.class);
    when(recordHelper.getRecord(
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<String>any()))
        .thenReturn(entity2);
    when(recordHelper.getFieldManager(anyBoolean())).thenReturn(fieldManager);
    when(recordHelper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            beanValidationEntityValidatorServiceImpl.validate(
                entity, instance, mergedProperties, recordHelper, true));
    verify(entity2).getType();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(adornedTargetListPersistenceModule).getPersistenceManager();
    verify(fieldManager).getFieldValue(isA(Object.class), isNull());
    verify(recordHelper).getCompatibleModule(OperationType.BASIC);
    verify(recordHelper).getFieldManager(false);
    verify(recordHelper).getRecord(isA(Map.class), isA(Serializable.class), isNull(), isNull());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BeanValidationEntityValidatorServiceImpl}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#setUseDefaultEntityValidations(boolean)}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#setValidator(Validator)}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#getValidator()}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#isUseDefaultEntityValidations()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeanValidationEntityValidatorServiceImpl.<init>()",
    "Validator BeanValidationEntityValidatorServiceImpl.getValidator()",
    "boolean BeanValidationEntityValidatorServiceImpl.isUseDefaultEntityValidations()",
    "void BeanValidationEntityValidatorServiceImpl.setUseDefaultEntityValidations(boolean)",
    "void BeanValidationEntityValidatorServiceImpl.setValidator(Validator)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BeanValidationEntityValidatorServiceImpl actualBeanValidationEntityValidatorServiceImpl =
        new BeanValidationEntityValidatorServiceImpl();
    actualBeanValidationEntityValidatorServiceImpl.setUseDefaultEntityValidations(true);
    CustomValidatorBean validator = new CustomValidatorBean();
    actualBeanValidationEntityValidatorServiceImpl.setValidator(validator);
    Validator actualValidator = actualBeanValidationEntityValidatorServiceImpl.getValidator();
    boolean actualIsUseDefaultEntityValidationsResult =
        actualBeanValidationEntityValidatorServiceImpl.isUseDefaultEntityValidations();

    // Assert
    assertTrue(actualValidator instanceof CustomValidatorBean);
    assertNull(actualBeanValidationEntityValidatorServiceImpl.getGlobalEntityValidators());
    assertTrue(actualIsUseDefaultEntityValidationsResult);
    assertSame(validator, actualValidator);
  }
}
