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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
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
  @InjectMocks
  private CategoryCustomPersistenceHandler categoryCustomPersistenceHandler;

  @Mock
  private CategoryDao categoryDao;

  @Mock
  private SandBoxHelper sandBoxHelper;

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd2() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"categoryDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd3() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(categoryCustomPersistenceHandler
        .canHandleAdd(new PersistencePackage("org.broadleafcommerce.core.catalog.domain.Category", entity,
            new PersistencePerspective(), new String[]{"categoryDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect2() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"categoryDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect3() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(categoryCustomPersistenceHandler
        .canHandleInspect(new PersistencePackage("org.broadleafcommerce.core.catalog.domain.Category", entity,
            new PersistencePerspective(), new String[]{"categoryDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate2() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"categoryDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate3() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(categoryCustomPersistenceHandler
        .canHandleUpdate(new PersistencePackage("org.broadleafcommerce.core.catalog.domain.Category", entity,
            new PersistencePerspective(), new String[]{"categoryDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property(String, String)} with name is {@code id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenEntityFindPropertyReturnPropertyWithNameIsIdAndValueIs42() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenEntityFindPropertyReturnProperty_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> categoryCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity, atLeast(1)).getType();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenPropertyGetValueReturn42_thenThrowValidationException() throws ServiceException {
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
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CategoryCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenPropertyGetValueReturnNull_thenThrowServiceException() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> categoryCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity, atLeast(1)).getType();
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property(String, String)} with name is {@code id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenEntityFindPropertyReturnPropertyWithNameIsIdAndValueIs42() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code Primary Key}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenPrimaryKey_thenThrowServiceException() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> categoryCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity, atLeast(1)).getType();
    verify(property, atLeast(1)).getValue();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Category"), isNull());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity CategoryCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenPropertyGetValueReturn42_thenThrowValidationException() throws ServiceException {
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
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testRemove_givenArrayListAddCategoryImpl_thenThrowValidationException() throws ServiceException {
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
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.remove(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(categoryDao).readAllSubCategories(eq(42L));
    verify(entity).getPMap();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default constructor).</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testRemove_givenArrayListAddCategoryProductXrefImpl_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    when(categoryDao.findXrefByCategoryWithDefaultReference(Mockito.<Long>any())).thenReturn(categoryProductXrefList);
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
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.remove(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(categoryDao).findXrefByCategoryWithDefaultReference(eq(42L));
    verify(categoryDao).readAllSubCategories(eq(42L));
    verify(entity).getPMap();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testRemove_thenCallsGetOperationTypes() throws ServiceException {
    // Arrange
    when(categoryDao.findXrefByCategoryWithDefaultReference(Mockito.<Long>any())).thenReturn(new ArrayList<>());
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
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    categoryCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(categoryDao).findXrefByCategoryWithDefaultReference(eq(42L));
    verify(categoryDao).readAllSubCategories(eq(42L));
    verify(entity).getPMap();
    verify(persistencePerspective).getOperationTypes();
    verify(property).getValue();
    verify(property).setValue(eq("42"));
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.validateCategory(entity));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenPropertyGetValueReturnNull_thenCallsGetValue() throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.validateCategory(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is {@code id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenPropertyWithNameIsIdAndValueIs42() throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));

    // Act and Assert
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.validateCategory(entity));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateCategory(Entity)"})
  public void testValidateCategory_givenProperty_whenEntityFindPropertyReturnProperty() throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    categoryCustomPersistenceHandler.validateCategory(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyGetValueReturn42_thenCallsGetValue() throws ValidationException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.validateSelfLink(entity));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is {@code id} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenPropertyWithNameIsIdAndValueIs42() throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));

    // Act and Assert
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.validateSelfLink(entity));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateSelfLink(Entity)"})
  public void testValidateSelfLink_givenProperty_whenEntityFindPropertyReturnProperty() throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    categoryCustomPersistenceHandler.validateSelfLink(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship() throws ValidationException {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship2() throws ValidationException {
    // Arrange
    org.broadleafcommerce.core.catalog.domain.Category category = mock(
        org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getParentCategory()).thenReturn(new CategoryImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(category);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(category, atLeast(1)).getName();
    verify(category).getParentCategory();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getId()} return one.</li>
   *   <li>Then calls {@link CategoryImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_givenCategoryImplGetIdReturnOne_thenCallsGetId()
      throws ValidationException {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.getName()).thenReturn("Name");
    when(categoryImpl.getParentCategory()).thenReturn(new CategoryImpl());
    org.broadleafcommerce.core.catalog.domain.Category category = mock(
        org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getParentCategory()).thenReturn(categoryImpl);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(category);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(sandBoxHelper, atLeast(1)).getOriginalId(Mockito.<Object>any());
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(category, atLeast(1)).getName();
    verify(category).getParentCategory();
    verify(categoryImpl).getId();
    verify(categoryImpl).getName();
    verify(categoryImpl).getParentCategory();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_givenProperty() throws ValidationException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.validateRecursiveRelationship(Entity)"})
  public void testValidateRecursiveRelationship_thenCallsGetValue() throws ValidationException {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.getName()).thenReturn("Name");
    when(categoryImpl.getParentCategory()).thenReturn(new CategoryImpl());
    org.broadleafcommerce.core.catalog.domain.Category category = mock(
        org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getParentCategory()).thenReturn(categoryImpl);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(category);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(sandBoxHelper, atLeast(1)).getOriginalId(Mockito.<Object>any());
    verify(categoryDao, atLeast(1)).readCategoryById(eq(42L));
    verify(category, atLeast(1)).getName();
    verify(category).getParentCategory();
    verify(categoryImpl).getId();
    verify(categoryImpl).getName();
    verify(categoryImpl).getParentCategory();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code fooCategory Name ->}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryCustomPersistenceHandler.addCategoryLink(StringBuilder, String)"})
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
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#isDefaultCategoryLegacyMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CategoryCustomPersistenceHandler.isDefaultCategoryLegacyMode()"})
  public void testIsDefaultCategoryLegacyMode() {
    // Arrange, Act and Assert
    assertFalse(categoryCustomPersistenceHandler.isDefaultCategoryLegacyMode());
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category CategoryCustomPersistenceHandler.getExistingDefaultCategory(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testGetExistingDefaultCategory_whenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryCustomPersistenceHandler.getExistingDefaultCategory(new CategoryImpl()));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default constructor).</li>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link CategoryXref}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
  public void testRemoveOldDefault_givenArrayList_whenCategoryXref() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXref oldDefault = mock(CategoryXref.class);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link CategoryImpl#getAllParentCategoryXrefs()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
  public void testRemoveOldDefault_givenArrayList_whenNull_thenCallsGetAllParentCategoryXrefs() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, null, new Entity());

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getCategory()} return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
  public void testRemoveOldDefault_givenCategoryXrefImplGetCategoryReturnCategoryImpl() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
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
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
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
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl).getDefaultReference();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
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
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
  public void testRemoveOldDefault_givenPropertyGetValueReturn42_thenCallsGetValue() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
  public void testRemoveOldDefault_givenPropertyGetValueReturnEmptyString() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing().when(adminInstance)
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
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is {@code defaultParentCategory} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
  public void testRemoveOldDefault_givenPropertyWithNameIsDefaultParentCategoryAndValueIs42() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("defaultParentCategory", "42"));

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategoryCustomPersistenceHandler.removeOldDefault(org.broadleafcommerce.core.catalog.domain.Category, CategoryXref, Entity)"})
  public void testRemoveOldDefault_givenProperty_whenEntityFindPropertyReturnProperty() {
    // Arrange
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing().when(adminInstance)
        .setParentCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setParentCategory(isNull());
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testGetCurrentDefaultXref_givenArrayListAddCategoryXrefImpl_thenReturnNull() {
    // Arrange
    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref = categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testGetCurrentDefaultXref_givenArrayList_thenReturnNull() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    CategoryXref actualCurrentDefaultXref = categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getCategory()} return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetCategoryReturnCategoryImpl() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    CategoryXref actualCurrentDefaultXref = categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"})
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
    CategoryXref actualCurrentDefaultXref = categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"})
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
    CategoryXref actualCurrentDefaultXref = categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl).getDefaultReference();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getDefaultReference()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"})
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
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CategoryXref CategoryCustomPersistenceHandler.getCurrentDefaultXref(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testGetCurrentDefaultXref_whenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryCustomPersistenceHandler.getCurrentDefaultXref(new CategoryImpl()));
  }
}
