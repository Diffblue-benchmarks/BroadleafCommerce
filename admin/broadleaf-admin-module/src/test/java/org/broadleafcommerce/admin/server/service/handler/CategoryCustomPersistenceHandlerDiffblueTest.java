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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryXref;
import org.broadleafcommerce.core.catalog.domain.CategoryXrefImpl;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class CategoryCustomPersistenceHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleAddResult = categoryCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"categoryDirectEdit"});

    // Act
    Boolean actualCanHandleAddResult = categoryCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleAddResult = categoryCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.Category");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"categoryDirectEdit"});

    // Act
    Boolean actualCanHandleAddResult = categoryCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleInspectResult = categoryCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"categoryDirectEdit"});

    // Act
    Boolean actualCanHandleInspectResult = categoryCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleInspectResult = categoryCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.Category");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"categoryDirectEdit"});

    // Act
    Boolean actualCanHandleInspectResult = categoryCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleInspectResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleUpdateResult = categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"categoryDirectEdit"});

    // Act
    Boolean actualCanHandleUpdateResult = categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleUpdateResult = categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.Category");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"categoryDirectEdit"});

    // Act
    Boolean actualCanHandleUpdateResult = categoryCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleRemoveResult = categoryCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.Category");

    // Act
    Boolean actualCanHandleRemoveResult = categoryCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleRemoveResult);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd4() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  public void testValidateCategory() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    categoryCustomPersistenceHandler.validateCategory(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  public void testValidateCategory2() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));

    // Act and Assert
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.validateCategory(entity));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  public void testValidateCategory3() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  public void testValidateCategory4() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  public void testValidateSelfLink() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    categoryCustomPersistenceHandler.validateSelfLink(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  public void testValidateSelfLink2() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));

    // Act and Assert
    assertThrows(ValidationException.class, () -> categoryCustomPersistenceHandler.validateSelfLink(entity));
    verify(entity).addValidationError(eq("defaultParentCategory"), eq("validateCategorySelfLink"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  public void testValidateSelfLink3() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  public void testValidateRecursiveRelationship() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    categoryCustomPersistenceHandler.validateRecursiveRelationship(entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}
   */
  @Test
  public void testAddCategoryLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    StringBuilder productLinks = new StringBuilder("foo");

    // Act
    categoryCustomPersistenceHandler.addCategoryLink(productLinks, "Category Name");

    // Assert
    assertEquals("fooCategory Name -> ", productLinks.toString());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#isDefaultCategoryLegacyMode()}
   */
  @Test
  public void testIsDefaultCategoryLegacyMode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CategoryCustomPersistenceHandler()).isDefaultCategoryLegacyMode());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(Category)}
   */
  @Test
  public void testGetExistingDefaultCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertNull(categoryCustomPersistenceHandler.getExistingDefaultCategory(new CategoryImpl()));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(Category)}
   */
  @Test
  public void testGetExistingDefaultCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryCustomPersistenceHandler()).getExistingDefaultCategory(mock(CategoryImpl.class)));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl adminInstance = new CategoryImpl();
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Entity entity = new Entity();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertEquals(adminInstance, category);
    assertEquals(adminInstance, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Entity entity = new Entity();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertEquals(category, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    Entity entity = new Entity();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertEquals(categoryXrefImpl, oldDefault);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    Entity entity = new Entity();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, null, entity);

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXref oldDefault = mock(CategoryXref.class);
    Entity entity = new Entity();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing().when(adminInstance).setParentCategory(Mockito.<Category>any());
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
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertEquals(category, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertEquals(category, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertEquals(category, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    doNothing().when(adminInstance).setParentCategory(Mockito.<Category>any());
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
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertEquals(category, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    CategoryImpl categoryImpl = new CategoryImpl();
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
    verify(categoryXrefImpl).getCategory();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertEquals(categoryImpl, category);
    assertEquals(categoryImpl, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertEquals(category, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertEquals(category, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
    Category category = oldDefault.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertEquals(category, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
    oldDefault.setCategory(null);
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
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertNull(oldDefault.getCategory());
    assertTrue(subCategory.getActiveProductXrefs().isEmpty());
    assertTrue(subCategory.getActiveProducts().isEmpty());
    assertTrue(subCategory.getAllChildCategories().isEmpty());
    assertTrue(subCategory.getAllChildCategoryXrefs().isEmpty());
    assertTrue(subCategory.getAllParentCategories().isEmpty());
    assertTrue(subCategory.getAllParentCategoryXrefs().isEmpty());
    assertTrue(subCategory.getAllProductXrefs().isEmpty());
    assertTrue(subCategory.getAllProducts().isEmpty());
    assertTrue(subCategory.getCategoryAttributes().isEmpty());
    assertTrue(subCategory.getChildCategories().isEmpty());
    assertTrue(subCategory.getChildCategoryXrefs().isEmpty());
    assertTrue(subCategory.getCrossSaleProducts().isEmpty());
    assertTrue(subCategory.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(subCategory.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(subCategory.getCumulativeSearchFacets().isEmpty());
    assertTrue(subCategory.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(subCategory.getExcludedSearchFacets().isEmpty());
    assertTrue(subCategory.getFeaturedProducts().isEmpty());
    assertTrue(subCategory.getSearchFacets().isEmpty());
    assertTrue(subCategory.getUpSaleProducts().isEmpty());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);
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
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertNull(oldDefault.getCategory());
    assertTrue(subCategory.getActiveProductXrefs().isEmpty());
    assertTrue(subCategory.getActiveProducts().isEmpty());
    assertTrue(subCategory.getAllChildCategories().isEmpty());
    assertTrue(subCategory.getAllChildCategoryXrefs().isEmpty());
    assertTrue(subCategory.getAllParentCategories().isEmpty());
    assertTrue(subCategory.getAllParentCategoryXrefs().isEmpty());
    assertTrue(subCategory.getAllProductXrefs().isEmpty());
    assertTrue(subCategory.getAllProducts().isEmpty());
    assertTrue(subCategory.getCategoryAttributes().isEmpty());
    assertTrue(subCategory.getChildCategories().isEmpty());
    assertTrue(subCategory.getChildCategoryXrefs().isEmpty());
    assertTrue(subCategory.getCrossSaleProducts().isEmpty());
    assertTrue(subCategory.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(subCategory.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(subCategory.getCumulativeSearchFacets().isEmpty());
    assertTrue(subCategory.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(subCategory.getExcludedSearchFacets().isEmpty());
    assertTrue(subCategory.getFeaturedProducts().isEmpty());
    assertTrue(subCategory.getSearchFacets().isEmpty());
    assertTrue(subCategory.getUpSaleProducts().isEmpty());
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);
    CategoryXref categoryXref = mock(CategoryXref.class);
    CategoryImpl categoryImpl2 = new CategoryImpl();
    when(categoryXref.getCategory()).thenReturn(categoryImpl2);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXref).getCategory();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertNull(oldDefault.getCategory());
    assertEquals(categoryImpl2, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);
    CategoryXref categoryXref = mock(CategoryXref.class);
    CategoryImpl categoryImpl2 = new CategoryImpl();
    when(categoryXref.getCategory()).thenReturn(categoryImpl2);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(mock(CategoryImpl.class));
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXref).getCategory();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertEquals(categoryImpl2, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault18() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXref categoryXref = mock(CategoryXref.class);
    when(categoryXref.getCategory()).thenReturn(categoryImpl2);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXref);
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    CategoryXrefImpl oldDefault = new CategoryXrefImpl();
    oldDefault.setCategory(null);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(categoryImpl).isActive();
    verify(categoryXref).getCategory();
    verify(categoryXrefImpl).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    verify(entity, atLeast(1)).findProperty(eq("defaultParentCategory"));
    verify(property).getValue();
    Category subCategory = oldDefault.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertNull(oldDefault.getCategory());
    assertEquals(categoryImpl2, subCategory);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertNull(categoryCustomPersistenceHandler.getCurrentDefaultXref(new CategoryImpl()));
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    CategoryXref actualCurrentDefaultXref = categoryCustomPersistenceHandler.getCurrentDefaultXref(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
}
