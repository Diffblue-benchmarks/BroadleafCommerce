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
package org.broadleafcommerce.openadmin.server.security.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SortDirection;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminPermissionCustomPersistenceHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminPermissionCustomPersistenceHandlerDiffblueTest {
  @Autowired
  private AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler;

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd2() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd3() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"createNewPermission", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.openadmin.server.security.domain.AdminPermission",
            entity,
            new PersistencePerspective(),
            new String[] {"createNewPermission", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertTrue(adminPermissionCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate2() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate3() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"createNewPermission", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.openadmin.server.security.domain.AdminPermission",
            entity,
            new PersistencePerspective(),
            new String[] {"createNewPermission", "Custom Criteria"},
            "ABC123");

    // Act and Assert
    assertTrue(adminPermissionCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminPermissionCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return empty string.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturnEmptyString_thenCallsGetValue()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminPermissionCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code PERMISSION_}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueReturnPermission_thenCallsGetValue()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("PERMISSION_");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminPermissionCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetValueThrowRuntimeException_thenThrowRuntimeException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminPermissionCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty("id");
    verify(property).getValue();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyWithNameAndValueIs42() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminPermissionCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyWithNameAndValueIsEmptyString() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", ""));
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminPermissionCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.checkPermissionName(PersistencePackage)"
  })
  public void testCheckPermissionName_givenPropertyGetValueReturn42_thenCallsGetValue()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"name"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adminPermissionCustomPersistenceHandler.checkPermissionName(persistencePackage));
    verify(entity).findProperty("name");
    verify(property).getValue();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code PERMISSION_}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.checkPermissionName(PersistencePackage)"
  })
  public void testCheckPermissionName_givenPropertyGetValueReturnPermission_thenCallsGetValue()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("PERMISSION_");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"name"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adminPermissionCustomPersistenceHandler.checkPermissionName(persistencePackage));
    verify(entity).findProperty("name");
    verify(property).getValue();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.checkPermissionName(PersistencePackage)"
  })
  public void testCheckPermissionName_givenPropertyValueIs42() throws ServiceException {
    // Arrange
    Property property = new Property();
    property.setValue("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"name"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adminPermissionCustomPersistenceHandler.checkPermissionName(persistencePackage));
    verify(entity).findProperty("name");
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturn42_thenCallsGetValue() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"name"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminPermissionCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty("name");
    verify(property).getValue();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code PERMISSION_}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturnPermission_thenCallsGetValue()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("PERMISSION_");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"name"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminPermissionCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty("name");
    verify(property).getValue();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Value is {@code 42}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminPermissionCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyValueIs42_whenEntityFindPropertyReturnProperty()
      throws ServiceException {
    // Arrange
    Property property = new Property();
    property.setValue("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"name"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminPermissionCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty("name");
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria} {@link FilterAndSortCriteria#getSortDirection()}
   *       return {@code ASCENDING}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet AdminPermissionCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenFilterAndSortCriteriaGetSortDirectionReturnAscending()
      throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getSortDirection()).thenReturn(SortDirection.ASCENDING);

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("description", filterAndSortCriteria);

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult =
        adminPermissionCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(cto).add(isA(FilterAndSortCriteria.class));
    verify(cto, atLeast(1)).getCriteriaMap();
    verify(filterAndSortCriteria).getSortDirection();
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code description} is {@link
   *       FilterAndSortCriteria#FilterAndSortCriteria(String)} with propertyId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet AdminPermissionCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenHashMapDescriptionIsFilterAndSortCriteriaWithPropertyIdIs42()
      throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("description", new FilterAndSortCriteria("42"));

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult =
        adminPermissionCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(cto).add(isA(FilterAndSortCriteria.class));
    verify(cto, atLeast(1)).getCriteriaMap();
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet AdminPermissionCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenHashMap_thenReturnDynamicResultSet() throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult =
        adminPermissionCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(cto, atLeast(1)).add(Mockito.<FilterAndSortCriteria>any());
    verify(cto, atLeast(1)).getCriteriaMap();
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link FilterAndSortCriteria#setSortAscending(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet AdminPermissionCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_thenCallsSetSortAscending() throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getSortDirection()).thenReturn(null);
    doNothing().when(filterAndSortCriteria).setSortAscending(Mockito.<Boolean>any());

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("description", filterAndSortCriteria);

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult =
        adminPermissionCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(cto).add(isA(FilterAndSortCriteria.class));
    verify(cto, atLeast(1)).getCriteriaMap();
    verify(filterAndSortCriteria).getSortDirection();
    verify(filterAndSortCriteria).setSortAscending(true);
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link
   * AdminPermissionCustomPersistenceHandler#addFriendlyRestriction(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link CriteriaTransferObject#add(FilterAndSortCriteria)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#addFriendlyRestriction(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminPermissionCustomPersistenceHandler.addFriendlyRestriction(CriteriaTransferObject)"
  })
  public void testAddFriendlyRestriction_givenHashMap_thenCallsAdd() {
    // Arrange
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());

    // Act
    adminPermissionCustomPersistenceHandler.addFriendlyRestriction(cto);

    // Assert
    verify(cto).add(isA(FilterAndSortCriteria.class));
    verify(cto).getCriteriaMap();
  }

  /**
   * Test {@link
   * AdminPermissionCustomPersistenceHandler#addFriendlyRestriction(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#addFriendlyRestriction(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminPermissionCustomPersistenceHandler.addFriendlyRestriction(CriteriaTransferObject)"
  })
  public void testAddFriendlyRestriction_thenCriteriaTransferObjectCriteriaMapSizeIsOne() {
    // Arrange
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    adminPermissionCustomPersistenceHandler.addFriendlyRestriction(cto);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("isFriendly");
    assertEquals("isFriendly", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(0, getResult.getOrder().intValue());
    List<String> filterValues = getResult.getFilterValues();
    assertEquals(1, filterValues.size());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertEquals(Boolean.TRUE.toString(), filterValues.get(0));
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminPermissionCustomPersistenceHandler.addDefaultSort(CriteriaTransferObject)"
  })
  public void testAddDefaultSort() {
    // Arrange
    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("description", new FilterAndSortCriteria("42"));

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    cto.add(new FilterAndSortCriteria("42"));

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    verify(cto).add(isA(FilterAndSortCriteria.class));
    verify(cto, atLeast(1)).getCriteriaMap();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria} {@link FilterAndSortCriteria#getSortDirection()}
   *       return {@code ASCENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminPermissionCustomPersistenceHandler.addDefaultSort(CriteriaTransferObject)"
  })
  public void testAddDefaultSort_givenFilterAndSortCriteriaGetSortDirectionReturnAscending() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getSortDirection()).thenReturn(SortDirection.ASCENDING);

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("description", filterAndSortCriteria);

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    cto.add(new FilterAndSortCriteria("42"));

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    verify(cto).add(isA(FilterAndSortCriteria.class));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria).getSortDirection();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link CriteriaTransferObject#add(FilterAndSortCriteria)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminPermissionCustomPersistenceHandler.addDefaultSort(CriteriaTransferObject)"
  })
  public void testAddDefaultSort_givenHashMap_thenCallsAdd() {
    // Arrange
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    cto.add(new FilterAndSortCriteria("42"));

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    verify(cto, atLeast(1)).add(Mockito.<FilterAndSortCriteria>any());
    verify(cto, atLeast(1)).getCriteriaMap();
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then calls {@link FilterAndSortCriteria#setSortAscending(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminPermissionCustomPersistenceHandler.addDefaultSort(CriteriaTransferObject)"
  })
  public void testAddDefaultSort_thenCallsSetSortAscending() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getSortDirection()).thenReturn(null);
    doNothing().when(filterAndSortCriteria).setSortAscending(Mockito.<Boolean>any());

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("description", filterAndSortCriteria);

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    cto.add(new FilterAndSortCriteria("42"));

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    verify(cto).add(isA(FilterAndSortCriteria.class));
    verify(cto, atLeast(1)).getCriteriaMap();
    verify(filterAndSortCriteria).getSortDirection();
    verify(filterAndSortCriteria).setSortAscending(true);
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminPermissionCustomPersistenceHandler.addDefaultSort(CriteriaTransferObject)"
  })
  public void testAddDefaultSort_thenCriteriaTransferObjectCriteriaMapSizeIsOne() {
    // Arrange
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("description");
    assertEquals("description", getResult.getPropertyId());
    assertNull(getResult.getOrder());
    assertNull(getResult.getRestrictionType());
    assertEquals(SortDirection.ASCENDING, getResult.getSortDirection());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.getSortAscending());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminPermissionCustomPersistenceHandler.addDefaultSort(CriteriaTransferObject)"
  })
  public void testAddDefaultSort_thenCriteriaTransferObjectCriteriaMapSizeIsTwo() {
    // Arrange
    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.add(new FilterAndSortCriteria("42"));

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(2, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("description");
    assertEquals("description", getResult.getPropertyId());
    assertNull(getResult.getOrder());
    assertNull(getResult.getRestrictionType());
    assertEquals(SortDirection.ASCENDING, getResult.getSortDirection());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(criteriaMap.containsKey("42"));
    assertTrue(getResult.getSortAscending());
    assertTrue(getResult.isNullsLast());
  }
}
