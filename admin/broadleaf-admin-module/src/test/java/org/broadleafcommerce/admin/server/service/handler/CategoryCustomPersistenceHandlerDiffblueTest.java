/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryXref;
import org.broadleafcommerce.core.catalog.domain.CategoryXrefImpl;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
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
public class CategoryCustomPersistenceHandlerDiffblueTest {
  @InjectMocks private CategoryCustomPersistenceHandler categoryCustomPersistenceHandler;

  @Mock private CategoryDao categoryDao;

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd2() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd3() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Category",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertTrue(categoryCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect2() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect3() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Category",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertTrue(categoryCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate2() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate3() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Category",
            entity,
            new PersistencePerspective(),
            new String[] {"categoryDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertTrue(categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#addValidationError(String, String)} does nothing.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityAddValidationErrorDoesNothing_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#addValidationError(String, String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityAddValidationErrorThrowRuntimeException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doThrow(new RuntimeException())
        .when(entity)
        .addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property(String, String)} with {@code Name} and value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityFindPropertyReturnPropertyWithNameAndValueIsNull()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity, atLeast(1)).getType();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturnNull_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity, atLeast(1)).getType();
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueThrowRuntimeException_thenThrowRuntimeException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            categoryCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#addValidationError(String, String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenEntityAddValidationErrorThrowRuntimeException()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doThrow(new RuntimeException())
        .when(entity)
        .addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", ""));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            categoryCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@code Primary Key}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPrimaryKey_thenThrowServiceException() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            categoryCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity, atLeast(1)).getType();
    verify(property, atLeast(1)).getValue();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.Category"), isNull());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueThrowRuntimeException_thenThrowRuntimeException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            categoryCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_thenThrowValidationException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", ""));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError("defaultParentCategory", "validateCategorySelfLink");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenArrayListAddCategoryImpl_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    ArrayList<org.broadleafcommerce.core.catalog.domain.Category> categoryList = new ArrayList<>();
    categoryList.add(new CategoryImpl());
    when(categoryDao.readAllSubCategories(Mockito.<Long>any())).thenReturn(categoryList);

    Property property = new Property();
    property.setValue("42");

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("id", property);

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(categoryDao).readAllSubCategories(42L);
    verify(entity).getPMap();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default
   *       constructor).
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenArrayListAddCategoryProductXrefImpl_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    when(categoryDao.findXrefByCategoryWithDefaultReference(Mockito.<Long>any()))
        .thenReturn(categoryProductXrefList);
    when(categoryDao.readAllSubCategories(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    Property property = new Property();
    property.setValue("42");

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("id", property);

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            categoryCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(categoryDao).findXrefByCategoryWithDefaultReference(42L);
    verify(categoryDao).readAllSubCategories(42L);
    verify(entity).getPMap();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_thenCallsGetOperationTypes() throws ServiceException {
    // Arrange
    when(categoryDao.findXrefByCategoryWithDefaultReference(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(categoryDao.readAllSubCategories(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    doNothing().when(property).setValue(Mockito.<String>any());
    property.setValue("42");

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("id", property);

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    categoryCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(categoryDao).findXrefByCategoryWithDefaultReference(42L);
    verify(categoryDao).readAllSubCategories(42L);
    verify(entity).getPMap();
    verify(persistencePerspective).getOperationTypes();
    verify(property).getValue();
    verify(property).setValue("42");
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenNull_whenEntityFindPropertyReturnNull_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    categoryCustomPersistenceHandler.validateCategory(entity);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenPropertyGetValueReturnNull() throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    categoryCustomPersistenceHandler.validateCategory(entity);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    categoryCustomPersistenceHandler.validateCategory(entity);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange, Act and Assert
    categoryCustomPersistenceHandler.validateCategory(new Entity());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenNull_whenEntityFindPropertyReturnNull_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    categoryCustomPersistenceHandler.validateSelfLink(entity);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyGetValueReturnNull() throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    categoryCustomPersistenceHandler.validateSelfLink(entity);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    categoryCustomPersistenceHandler.validateSelfLink(entity);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_whenEntity_thenDoesNotThrow() throws ValidationException {
    // Arrange, Act and Assert
    categoryCustomPersistenceHandler.validateSelfLink(new Entity());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_givenNull_whenEntityFindPropertyReturnNull()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_givenPropertyWithNameAndValueIsNull()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_thenCallsGetValue() throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_whenEntity_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    // Act and Assert
    categoryCustomPersistenceHandler.validateRecursiveRelationship(new Entity());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategories(Entity, Category, Long,
   * StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code defaultParentCategory} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategories(Entity,
   * org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.validateCategories(Entity, org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)"
  })
  public void testValidateCategories_givenHashMapDefaultParentCategoryIsNull()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();

    HashMap<String, List<String>> validationErrors = new HashMap<>();
    validationErrors.put("defaultParentCategory", null);

    Entity entity = new Entity();
    entity.setPropertyValidationErrors(validationErrors);

    // Act and Assert
    categoryCustomPersistenceHandler.validateCategories(entity, null, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategories(Entity, Category, Long,
   * StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link CategoryImpl#getParentCategory()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategories(Entity,
   * org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.validateCategories(Entity, org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)"
  })
  public void testValidateCategories_givenNull_thenCallsGetParentCategory()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(null);

    // Act
    categoryCustomPersistenceHandler.validateCategories(
        entity, category, 1L, new StringBuilder("foo"));

    // Assert
    verify(category).getParentCategory();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategories(Entity, Category, Long,
   * StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#validateCategories(Entity,
   * org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.validateCategories(Entity, org.broadleafcommerce.core.catalog.domain.Category, Long, StringBuilder)"
  })
  public void testValidateCategories_whenCategoryImpl_thenDoesNotThrow()
      throws ValidationException {
    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler =
        new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    categoryCustomPersistenceHandler.validateCategories(
        entity, category, 1L, new StringBuilder("foo"));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       fooCategory Name ->}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#addCategoryLink(StringBuilder,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.addCategoryLink(StringBuilder, String)"
  })
  public void testAddCategoryLink_thenStringBuilderWithFooToStringIsFooCategoryName() {
    // Arrange
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    categoryCustomPersistenceHandler.addCategoryLink(productLinks, "Category Name");

    // Assert
    assertEquals("fooCategory Name -> ", productLinks.toString());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#isDefaultCategoryLegacyMode()}.
   *
   * <p>Method under test: {@link CategoryCustomPersistenceHandler#isDefaultCategoryLegacyMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CategoryCustomPersistenceHandler.isDefaultCategoryLegacyMode()"
  })
  public void testIsDefaultCategoryLegacyMode() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.isDefaultCategoryLegacyMode());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(Category)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getExistingDefaultCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category CategoryCustomPersistenceHandler.getExistingDefaultCategory(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetExistingDefaultCategory_whenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryCustomPersistenceHandler.getExistingDefaultCategory(new CategoryImpl()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXref categoryXref = mock(CategoryXref.class);
    when(categoryXref.getDefaultReference()).thenReturn(null);
    when(categoryXref.getCategory()).thenReturn(categoryImpl2);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXref).getCategory();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayListAddCategoryXrefImpl() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default constructor).
   *   <li>When {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayListAddCategoryXrefImpl_whenEntity() {
    // Arrange
    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link CategoryXrefImpl} (default constructor).
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayList_whenCategoryXrefImpl_thenCallsGetValue() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayList_whenEntity() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayList_whenNull_thenCallsGetValue() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, null, entity);

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getCategory()} return {@link
   *       CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefImplGetCategoryReturnCategoryImpl() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefImplGetDefaultReferenceReturnFalse() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(false);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefImplGetDefaultReferenceReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(null);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryXrefImplGetDefaultReferenceReturnTrue() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link CategoryXrefImpl} (default constructor) Category is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenNull_whenCategoryXrefImplCategoryIsNull() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenNull_whenEntityFindPropertyReturnNull() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity).findProperty("defaultParentCategory");
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>When {@link CategoryXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyGetValueReturnNull_whenCategoryXrefImpl() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = mock(CategoryXrefImpl.class);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyWithNameAndValueIs42() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyWithNameAndValueIsEmptyString() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", ""));

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyWithNameAndValueIsNull() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link CategoryXref#getCategory()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_thenCallsGetCategory() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    CategoryXref categoryXref = mock(CategoryXref.class);
    when(categoryXref.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXref).getCategory();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>When {@link CategoryXrefImpl} (default constructor) Category is {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_whenCategoryXrefImplCategoryIsCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(mock(CategoryImpl.class));

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>When {@link CategoryXrefImpl} (default constructor) SubCategory is {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_whenCategoryXrefImplSubCategoryIsCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXref categoryXref = mock(CategoryXref.class);
    when(categoryXref.getDefaultReference()).thenReturn(null);
    when(categoryXref.getCategory()).thenReturn(categoryImpl2);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setSubCategory(mock(CategoryImpl.class));
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXref).getCategory();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   *
   * <ul>
   *   <li>When {@link CategoryXrefImpl} (default constructor) SubCategory is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category,
   * CategoryXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"
  })
  public void testRemoveOldDefault_whenCategoryXrefImplSubCategoryIsNull() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXref categoryXref = mock(CategoryXref.class);
    when(categoryXref.getDefaultReference()).thenReturn(null);
    when(categoryXref.getCategory()).thenReturn(categoryImpl2);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing()
        .when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setSubCategory(null);
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(adminInstance).setParentCategory(isNull());
    verify(categoryXref).getCategory();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty("defaultParentCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenArrayListAddCategoryXrefImpl_thenReturnNull() {
    // Arrange
    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenArrayList_thenReturnNull() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getCategory()} return {@link
   *       CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetCategoryReturnCategoryImpl() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetDefaultReferenceReturnFalse() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(false);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetDefaultReferenceReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(null);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref =
        categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl).getDefaultReference();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetDefaultReferenceReturnTrue() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCurrentDefaultXref_whenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryCustomPersistenceHandler.getCurrentDefaultXref(new CategoryImpl()));
  }
}
