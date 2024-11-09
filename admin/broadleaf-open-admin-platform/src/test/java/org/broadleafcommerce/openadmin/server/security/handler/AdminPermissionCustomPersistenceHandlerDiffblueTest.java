/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.security.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;

public class AdminPermissionCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleAdd(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code createNewPermission}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenArrayOfStringWithCreateNewPermission() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"createNewPermission"});

    // Act
    Boolean actualCanHandleAddResult = adminPermissionCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleAddResult = adminPermissionCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleAddResult = adminPermissionCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.openadmin.server.security.domain.AdminPermission");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"createNewPermission"});

    // Act
    Boolean actualCanHandleAddResult = adminPermissionCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleUpdate(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code createNewPermission}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithCreateNewPermission() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"createNewPermission"});

    // Act
    Boolean actualCanHandleUpdateResult = adminPermissionCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleUpdateResult = adminPermissionCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleUpdateResult = adminPermissionCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.openadmin.server.security.domain.AdminPermission");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"createNewPermission"});

    // Act
    Boolean actualCanHandleUpdateResult = adminPermissionCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = adminPermissionCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionImpl");

    // Act
    Boolean actualCanHandleFetchResult = adminPermissionCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();

    // Act and Assert
    assertFalse(adminPermissionCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenPropertyGetValueReturn42_thenCallsGetValue() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminPermissionCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return empty
   * string.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenPropertyGetValueReturnEmptyString_thenCallsGetValue() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminPermissionCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code PERMISSION_}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenPropertyGetValueReturnPermission_thenCallsGetValue() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("PERMISSION_");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminPermissionCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(property, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property#Property()} Value is {@code 42}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenPropertyValueIs42_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();

    Property property = new Property();
    property.setValue("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminPermissionCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getEntity();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}
   */
  @Test
  public void testCheckPermissionName_givenPropertyGetValueReturn42_thenCallsGetValue() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adminPermissionCustomPersistenceHandler.checkPermissionName(persistencePackage));
    verify(entity).findProperty(eq("name"));
    verify(persistencePackage).getEntity();
    verify(property).getValue();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code PERMISSION_}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}
   */
  @Test
  public void testCheckPermissionName_givenPropertyGetValueReturnPermission_thenCallsGetValue()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("PERMISSION_");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adminPermissionCustomPersistenceHandler.checkPermissionName(persistencePackage));
    verify(entity).findProperty(eq("name"));
    verify(persistencePackage).getEntity();
    verify(property).getValue();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link Property#Property()} Value is {@code 42}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#checkPermissionName(PersistencePackage)}
   */
  @Test
  public void testCheckPermissionName_givenPropertyValueIs42_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();

    Property property = new Property();
    property.setValue("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adminPermissionCustomPersistenceHandler.checkPermissionName(persistencePackage));
    verify(entity).findProperty(eq("name"));
    verify(persistencePackage).getEntity();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenPropertyGetValueReturn42_thenCallsGetValue() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminPermissionCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty(eq("name"));
    verify(persistencePackage).getEntity();
    verify(property).getValue();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code PERMISSION_}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenPropertyGetValueReturnPermission_thenCallsGetValue() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("PERMISSION_");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminPermissionCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty(eq("name"));
    verify(persistencePackage).getEntity();
    verify(property).getValue();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property#Property()} Value is {@code 42}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenPropertyValueIs42_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();

    Property property = new Property();
    property.setValue("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminPermissionCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty(eq("name"));
    verify(persistencePackage).getEntity();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenReturnDynamicResultSet() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = adminPermissionCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(cto, atLeast(1)).add(Mockito.<FilterAndSortCriteria>any());
    verify(cto, atLeast(1)).getCriteriaMap();
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#addFriendlyRestriction(CriteriaTransferObject)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls
   * {@link CriteriaTransferObject#add(FilterAndSortCriteria)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#addFriendlyRestriction(CriteriaTransferObject)}
   */
  @Test
  public void testAddFriendlyRestriction_givenHashMap_thenCallsAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
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
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#addFriendlyRestriction(CriteriaTransferObject)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#addFriendlyRestriction(CriteriaTransferObject)}
   */
  @Test
  public void testAddFriendlyRestriction_thenCriteriaTransferObjectCriteriaMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
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
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria}
   * {@link FilterAndSortCriteria#getSortDirection()} return
   * {@code ASCENDING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort_givenFilterAndSortCriteriaGetSortDirectionReturnAscending() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getSortDirection()).thenReturn(SortDirection.ASCENDING);

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("description", filterAndSortCriteria);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria).getSortDirection();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls
   * {@link CriteriaTransferObject#add(FilterAndSortCriteria)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort_givenHashMap_thenCallsAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    doNothing().when(cto).add(Mockito.<FilterAndSortCriteria>any());

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    verify(cto).add(isA(FilterAndSortCriteria.class));
    verify(cto, atLeast(1)).getCriteriaMap();
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   * <ul>
   *   <li>Then calls {@link FilterAndSortCriteria#setSortAscending(Boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort_thenCallsSetSortAscending() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getSortDirection()).thenReturn(null);
    doNothing().when(filterAndSortCriteria).setSortAscending(Mockito.<Boolean>any());

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("description", filterAndSortCriteria);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    verify(cto, atLeast(1)).getCriteriaMap();
    verify(filterAndSortCriteria).getSortDirection();
    verify(filterAndSortCriteria).setSortAscending(eq(true));
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap is
   * {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort_thenCriteriaTransferObjectCriteriaMapIsHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();

    HashMap<String, FilterAndSortCriteria> criteriaMap = new HashMap<>();
    criteriaMap.put("description", new FilterAndSortCriteria("42"));

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.setCriteriaMap(criteriaMap);

    // Act
    adminPermissionCustomPersistenceHandler.addDefaultSort(cto);

    // Assert
    assertSame(criteriaMap, cto.getCriteriaMap());
  }

  /**
   * Test
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionCustomPersistenceHandler#addDefaultSort(CriteriaTransferObject)}
   */
  @Test
  public void testAddDefaultSort_thenCriteriaTransferObjectCriteriaMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
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
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }
}
