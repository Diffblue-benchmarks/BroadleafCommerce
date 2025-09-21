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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class EntityValidatorServiceImplDiffblueTest {
  @Mock private ApplicationContext applicationContext;

  @InjectMocks private EntityValidatorServiceImpl entityValidatorServiceImpl;

  /**
   * Test {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}.
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityValidatorServiceImpl.populateBroadleafValidatorMap()"})
  public void testPopulateBroadleafValidatorMap() {
    // Arrange
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> entityValidatorServiceImpl.populateBroadleafValidatorMap());
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}.
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityValidatorServiceImpl.populateBroadleafValidatorMap()"})
  public void testPopulateBroadleafValidatorMap2() throws BeansException {
    // Arrange
    when(applicationContext.getBean(
            Mockito.<String>any(), Mockito.<Class<BroadleafEntityValidator<Object>>>any()))
        .thenThrow(new RuntimeException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> entityValidatorServiceImpl.populateBroadleafValidatorMap());
    verify(applicationContext).getBean(eq("Bean Names For Type"), isA(Class.class));
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper,
   * boolean)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Type}.
   *   <li>Then calls {@link Entity#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map,
   * RecordHelper, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityValidatorServiceImpl.validate(Entity, Serializable, Map, RecordHelper, boolean)"
  })
  public void testValidate_givenArrayOfStringWithType_thenCallsGetType() {
    // Arrange
    Entity submittedEntity = mock(Entity.class);
    when(submittedEntity.getType()).thenReturn(new String[] {"Type"});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            entityValidatorServiceImpl.validate(
                submittedEntity, null, new HashMap<>(), mock(RecordHelper.class), true));
    verify(submittedEntity).getType();
  }

  /**
   * Test {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper,
   * boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityDaoImpl#getIdMetadata(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map,
   * RecordHelper, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityValidatorServiceImpl.validate(Entity, Serializable, Map, RecordHelper, boolean)"
  })
  public void testValidate_thenCallsGetIdMetadata() {
    // Arrange
    Entity submittedEntity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> propertiesMetadata = new HashMap<>();

    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<?>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getPersistenceManager())
        .thenReturn(persistenceManagerImpl);

    RecordHelper recordHelper = mock(RecordHelper.class);
    when(recordHelper.getFieldManager(anyBoolean())).thenThrow(new RuntimeException());
    when(recordHelper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            entityValidatorServiceImpl.validate(
                submittedEntity, instance, propertiesMetadata, recordHelper, true));
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(adornedTargetListPersistenceModule).getPersistenceManager();
    verify(recordHelper).getCompatibleModule(OperationType.BASIC);
    verify(recordHelper).getFieldManager(false);
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Type}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityValidatorServiceImpl.getTypeHierarchy(Entity)"})
  public void testGetTypeHierarchy_givenArrayOfStringWithType_thenThrowRuntimeException() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityValidatorServiceImpl.getTypeHierarchy(entity));
    verify(entity).getType();
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   *
   * <ul>
   *   <li>Then return first is {@code Entity}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityValidatorServiceImpl.getTypeHierarchy(Entity)"})
  public void testGetTypeHierarchy_thenReturnFirstIsOrgBroadleafcommerceOpenadminDtoEntity() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"org.broadleafcommerce.openadmin.dto.Entity"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    verify(entity).getType();
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("org.broadleafcommerce.openadmin.dto.Entity", actualTypeHierarchy.get(0));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       List}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityValidatorServiceImpl.getTypeHierarchy(Entity)"})
  public void testGetTypeHierarchy_whenEntityGetTypeReturnArrayOfStringWithJavaUtilList() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"java.util.List"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    verify(entity).getType();
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("java.util.List", actualTypeHierarchy.get(0));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor) Type is array of {@link String} with {@code
   *       List}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityValidatorServiceImpl.getTypeHierarchy(Entity)"})
  public void testGetTypeHierarchy_whenEntityTypeIsArrayOfStringWithJavaUtilList() {
    // Arrange
    Entity entity = new Entity();
    entity.setType(new String[] {"java.util.List"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("java.util.List", actualTypeHierarchy.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityValidatorServiceImpl#setGlobalEntityValidators(List)}
   *   <li>{@link EntityValidatorServiceImpl#getGlobalEntityValidators()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityValidatorServiceImpl.getGlobalEntityValidators()",
    "void EntityValidatorServiceImpl.setGlobalEntityValidators(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    ArrayList<GlobalPropertyValidator> globalEntityValidators = new ArrayList<>();

    // Act
    entityValidatorServiceImpl.setGlobalEntityValidators(globalEntityValidators);
    List<GlobalPropertyValidator> actualGlobalEntityValidators =
        entityValidatorServiceImpl.getGlobalEntityValidators();

    // Assert
    assertTrue(actualGlobalEntityValidators.isEmpty());
    assertSame(globalEntityValidators, actualGlobalEntityValidators);
  }
}
