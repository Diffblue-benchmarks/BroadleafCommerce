/*-
 * #%L
 * BroadleafCommerce Admin Module
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code categoryDirectEdit}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenArrayOfStringWithCategoryDirectEdit() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenArrayOfStringWithCustomCriteria() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenEmptyArrayOfString() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_thenReturnTrue() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code categoryDirectEdit}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenArrayOfStringWithCategoryDirectEdit() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenArrayOfStringWithCustomCriteria() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenEmptyArrayOfString() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_thenReturnTrue() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code categoryDirectEdit}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithCategoryDirectEdit() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithCustomCriteria() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenEmptyArrayOfString() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_thenReturnTrue() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_givenDrJaneDoe() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_thenReturnTrue() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertFalse(categoryCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property(String, String)} with name is {@code id} and value
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityFindPropertyReturnPropertyWithNameIsIdAndValueIs42() throws ServiceException {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityFindPropertyReturnProperty_thenThrowServiceException() throws ServiceException {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenPropertyGetValueReturn42_thenThrowValidationException() throws ServiceException {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code null}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenPropertyGetValueReturnNull_thenThrowServiceException() throws ServiceException {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property(String, String)} with name is {@code id} and value
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenEntityFindPropertyReturnPropertyWithNameIsIdAndValueIs42() throws ServiceException {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code Primary Key}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenPrimaryKey_thenThrowServiceException() throws ServiceException {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenPropertyGetValueReturn42_thenThrowValidationException() throws ServiceException {
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
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  public void testValidateCategory_givenPropertyGetValueReturn42_thenThrowValidationException()
      throws ValidationException {
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
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code null}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  public void testValidateCategory_givenPropertyGetValueReturnNull_thenCallsGetValue() throws ValidationException {
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
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is {@code id}
   * and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  public void testValidateCategory_givenPropertyWithNameIsIdAndValueIs42() throws ValidationException {
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
   * Test {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateCategory(Entity)}
   */
  @Test
  public void testValidateCategory_givenProperty_whenEntityFindPropertyReturnProperty() throws ValidationException {
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
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  public void testValidateSelfLink_givenPropertyGetValueReturn42_thenCallsGetValue() throws ValidationException {
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
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is {@code id}
   * and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  public void testValidateSelfLink_givenPropertyWithNameIsIdAndValueIs42() throws ValidationException {
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
   * Test {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateSelfLink(Entity)}
   */
  @Test
  public void testValidateSelfLink_givenProperty_whenEntityFindPropertyReturnProperty() throws ValidationException {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then calls {@link Entity#findProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#validateRecursiveRelationship(Entity)}
   */
  @Test
  public void testValidateRecursiveRelationship_givenProperty_thenCallsFindProperty() throws ValidationException {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo}
   * toString is {@code fooCategory Name ->}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#addCategoryLink(StringBuilder, String)}
   */
  @Test
  public void testAddCategoryLink_thenStringBuilderWithFooToStringIsFooCategoryName() {
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
   * Test {@link CategoryCustomPersistenceHandler#isDefaultCategoryLegacyMode()}.
   * <p>
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
   * Test
   * {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(Category)}
   */
  @Test
  public void testGetExistingDefaultCategory_whenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertNull(categoryCustomPersistenceHandler.getExistingDefaultCategory(new CategoryImpl()));
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getExistingDefaultCategory(Category)}
   */
  @Test
  public void testGetExistingDefaultCategory_whenCategoryImpl_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryCustomPersistenceHandler()).getExistingDefaultCategory(mock(CategoryImpl.class)));
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayListAddCategoryXrefImpl() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default
   * constructor).</li>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayListAddCategoryXrefImpl_whenEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

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
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayList_thenCallsGetValue() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link CategoryXref}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayList_whenCategoryXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXref oldDefault = mock(CategoryXref.class);

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayList_whenEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryXrefImpl oldDefault = new CategoryXrefImpl();

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link CategoryImpl#getAllParentCategoryXrefs()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayList_whenNull_thenCallsGetAllParentCategoryXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
    CategoryImpl adminInstance = mock(CategoryImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    categoryCustomPersistenceHandler.removeOldDefault(adminInstance, null, new Entity());

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getCategory()}
   * return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryXrefImplGetCategoryReturnCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl}
   * {@link CategoryXrefImpl#getDefaultReference()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryXrefImplGetDefaultReferenceReturnFalse() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl}
   * {@link CategoryXrefImpl#getDefaultReference()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryXrefImplGetDefaultReferenceReturnNull() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl}
   * {@link CategoryXrefImpl#getDefaultReference()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryXrefImplGetDefaultReferenceReturnTrue() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link CategoryXrefImpl} (default constructor) Category is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenNull_whenCategoryXrefImplCategoryIsNull() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenPropertyGetValueReturnEmptyString() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is
   * {@code defaultParentCategory} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenPropertyWithNameIsDefaultParentCategoryAndValueIs42() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenProperty_whenEntityFindPropertyReturnProperty() {
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}.
   * <ul>
   *   <li>Then calls {@link CategoryXref#getCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#removeOldDefault(Category, CategoryXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_thenCallsGetCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();
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
  }

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default
   * constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref_givenArrayListAddCategoryXrefImpl_thenReturnNull() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref_givenArrayList_thenReturnNull() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} {@link CategoryXrefImpl#getCategory()}
   * return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetCategoryReturnCategoryImpl() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl}
   * {@link CategoryXrefImpl#getDefaultReference()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetDefaultReferenceReturnFalse() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl}
   * {@link CategoryXrefImpl#getDefaultReference()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetDefaultReferenceReturnNull() {
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

  /**
   * Test
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>Given {@link CategoryXrefImpl}
   * {@link CategoryXrefImpl#getDefaultReference()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref_givenCategoryXrefImplGetDefaultReferenceReturnTrue() {
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
   * Test
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryCustomPersistenceHandler#getCurrentDefaultXref(Category)}
   */
  @Test
  public void testGetCurrentDefaultXref_whenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryCustomPersistenceHandler categoryCustomPersistenceHandler = new CategoryCustomPersistenceHandler();

    // Act and Assert
    assertNull(categoryCustomPersistenceHandler.getCurrentDefaultXref(new CategoryImpl()));
  }
}
