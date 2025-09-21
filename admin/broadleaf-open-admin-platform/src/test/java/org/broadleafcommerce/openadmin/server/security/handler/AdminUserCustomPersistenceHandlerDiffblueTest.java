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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.EntityOperationType;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
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
import org.springframework.core.env.Environment;

@RunWith(MockitoJUnitRunner.class)
public class AdminUserCustomPersistenceHandlerDiffblueTest {
  @Mock private AdminSecurityService adminSecurityService;

  @InjectMocks private AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler;

  @Mock private Environment environment;

  @Mock private SecurityVerifier securityVerifier;

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(false);

    // Act
    boolean actualRequireUniqueEmailAddress =
        adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress();

    // Assert
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertFalse(actualRequireUniqueEmailAddress);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(null);

    // Act
    boolean actualRequireUniqueEmailAddress =
        adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress();

    // Assert
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertFalse(actualRequireUniqueEmailAddress);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    // Act
    boolean actualRequireUniqueEmailAddress =
        adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress();

    // Assert
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertTrue(actualRequireUniqueEmailAddress);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_thenThrowRuntimeException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#willHandleSecurity(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#willHandleSecurity(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.willHandleSecurity(PersistencePackage)"
  })
  public void testWillHandleSecurity() {
    // Arrange, Act and Assert
    assertTrue(adminUserCustomPersistenceHandler.willHandleSecurity(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd() {
    // Arrange
    String[] customCriteria = new String[] {"Custom Criteria"};
    PersistencePackage persistencePackage =
        new PersistencePackage("java.util.List", new Entity(), null, customCriteria, "ABC123");

    // Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_thenThrowRuntimeException() {
    // Arrange
    String[] customCriteria = new String[] {"Custom Criteria"};
    PersistencePackage persistencePackage =
        new PersistencePackage("Dr Jane Doe", new Entity(), null, customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate() {
    // Arrange
    String[] customCriteria = new String[] {"Custom Criteria"};
    PersistencePackage persistencePackage =
        new PersistencePackage("java.util.List", new Entity(), null, customCriteria, "ABC123");

    // Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_thenThrowRuntimeException() {
    // Arrange
    String[] customCriteria = new String[] {"Custom Criteria"};
    PersistencePackage persistencePackage =
        new PersistencePackage("Dr Jane Doe", new Entity(), null, customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove() {
    // Arrange
    String[] customCriteria = new String[] {"Custom Criteria"};
    PersistencePackage persistencePackage =
        new PersistencePackage("java.util.List", new Entity(), null, customCriteria, "ABC123");

    // Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleRemove(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove_thenThrowRuntimeException() {
    // Arrange
    String[] customCriteria = new String[] {"Custom Criteria"};
    PersistencePackage persistencePackage =
        new PersistencePackage("Dr Jane Doe", new Entity(), null, customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.canHandleRemove(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       java.util.List}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithJavaUtilList()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<PersistencePackage>any(), Mockito.<EntityOperationType>any());

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"java.util.List"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminUserCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
    verify(securityVerifier)
        .securityCheck(isA(PersistencePackage.class), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       Type}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<PersistencePackage>any(), Mockito.<EntityOperationType>any());

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminUserCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
    verify(securityVerifier)
        .securityCheck(isA(PersistencePackage.class), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    doThrow(new RuntimeException())
        .when(securityVerifier)
        .securityCheck(Mockito.<PersistencePackage>any(), Mockito.<EntityOperationType>any());
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminUserCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(securityVerifier)
        .securityCheck(isA(PersistencePackage.class), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       Type}.
   *   <li>Then calls {@link Entity#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenEntityGetTypeReturnArrayOfStringWithType_thenCallsGetType()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

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
            adminUserCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.openadmin.server.security.domain.AdminUser"), isNull());
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} (default constructor) Type is array of {@link String} with {@code
   *       Unable to update entity for}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenEntityTypeIsArrayOfStringWithUnableToUpdateEntityFor()
      throws ServiceException {
    // Arrange
    Entity entity = new Entity();
    entity.setType(new String[] {"Unable to update entity for "});

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
            adminUserCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.openadmin.server.security.domain.AdminUser"), isNull());
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link AdminSecurityService} {@link AdminSecurityService#readAdminUserById(Long)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenAdminSecurityServiceReadAdminUserByIdThrowRuntimeException()
      throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn("Login");
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(adminSecurityService.readAdminUserById(Mockito.<Long>any()))
        .thenThrow(new RuntimeException());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

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
            adminUserCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminUser, atLeast(1)).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminSecurityService).readAdminUserById(42L);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link AdminUser} {@link AdminUser#getLogin()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenAdminUserGetLoginReturn42_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn("42");
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, mock(PersistencePerspective.class), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            adminUserCustomPersistenceHandler.remove(
                persistencePackage,
                new DynamicEntityDaoImpl(),
                mock(AdornedTargetListPersistenceModule.class)));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminUser, atLeast(1)).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link AdminUser} {@link AdminUser#getLogin()} return {@code null}.
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenAdminUserGetLoginReturnNull_thenCallsGetOperationTypes()
      throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn(null);
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(adminSecurityService.readAdminUserById(Mockito.<Long>any()))
        .thenReturn(new AdminUserImpl());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    adminUserCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(adminUser).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminSecurityService).readAdminUserById(42L);
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link AdminUser} {@link AdminUser#getLogin()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenAdminUserGetLoginThrowRuntimeException_thenThrowRuntimeException()
      throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenThrow(new RuntimeException());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
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
            adminUserCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(adminUser).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenPropertyGetValueReturnNull_thenCallsGetOperationTypes()
      throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn("Login");
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    adminUserCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(adminUser).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link SecurityVerifier} {@link SecurityVerifier#getPersistentAdminUser()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenSecurityVerifierGetPersistentAdminUserThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
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
            adminUserCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_thenCallsGetOperationTypes() throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn("Login");
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(adminSecurityService.readAdminUserById(Mockito.<Long>any()))
        .thenReturn(new AdminUserImpl());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    adminUserCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(adminUser, atLeast(1)).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminSecurityService).readAdminUserById(42L);
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, new AdminUserImpl(), true);

    // Assert
    verify(entity).addValidationError("login", "admin.nonUniqueUsernameError");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(adminSecurityService).readAdminUserByUserName(null);
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertSame(entity, actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
                entity, new AdminUserImpl(), true));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail3() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, new AdminUserImpl(), true);

    // Assert
    verify(entity).addValidationError("login", "admin.nonUniqueUsernameError");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertSame(entity, actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail4() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, new AdminUserImpl(), true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(adminSecurityService).readAdminUsersByEmail("42");
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail5() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
                entity, new AdminUserImpl(), true));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(adminSecurityService).readAdminUsersByEmail("42");
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail6() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, new AdminUserImpl(), false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(adminSecurityService).readAdminUsersByEmail("42");
    verify(environment, atLeast(1))
        .getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link AdminUser} {@link AdminUser#getEmail()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_given42_whenAdminUserGetEmailReturn42() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getEmail()).thenReturn("42");
    when(adminInstance.getLogin()).thenReturn("Login");

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, adminInstance, false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getEmail();
    verify(adminInstance).getLogin();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(environment, atLeast(1))
        .getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link AdminUser} {@link AdminUser#getLogin()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_given42_whenAdminUserGetLoginReturn42() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getEmail()).thenReturn("jane.doe@example.org");
    when(adminInstance.getLogin()).thenReturn("42");

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, adminInstance, false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getEmail();
    verify(adminInstance).getLogin();
    verify(adminSecurityService).readAdminUsersByEmail("42");
    verify(environment, atLeast(1))
        .getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminUserImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_givenArrayListAddAdminUserImpl() {
    // Arrange
    ArrayList<AdminUser> adminUserList = new ArrayList<>();
    adminUserList.add(new AdminUserImpl());
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any()))
        .thenReturn(adminUserList);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, new AdminUserImpl(), true);

    // Assert
    verify(entity).addValidationError("email", "admin.nonUniqueEmailError");
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(adminSecurityService).readAdminUsersByEmail("42");
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertSame(entity, actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(false);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, new AdminUserImpl(), true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_givenEnvironmentGetPropertyReturnFalse2() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(false);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getLogin()).thenReturn("Login");

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, adminInstance, false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getLogin();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(environment, atLeast(1))
        .getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, new AdminUserImpl(), true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_givenJaneDoeExampleOrg() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getEmail()).thenReturn("jane.doe@example.org");
    when(adminInstance.getLogin()).thenReturn("Login");

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, adminInstance, false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getEmail();
    verify(adminInstance).getLogin();
    verify(adminSecurityService).readAdminUserByUserName("42");
    verify(adminSecurityService).readAdminUsersByEmail("42");
    verify(environment, atLeast(1))
        .getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code login}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_givenPropertyGetValueReturnLogin() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("login");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getEmail()).thenReturn("jane.doe@example.org");
    when(adminInstance.getLogin()).thenReturn("Login");

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, adminInstance, false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getEmail();
    verify(adminInstance).getLogin();
    verify(adminSecurityService).readAdminUserByUserName("login");
    verify(adminSecurityService).readAdminUsersByEmail("login");
    verify(environment, atLeast(1))
        .getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_givenPropertyGetValueReturnNull() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getEmail()).thenReturn("jane.doe@example.org");
    when(adminInstance.getLogin()).thenReturn("Login");

    // Act
    Entity actualValidateLegalUsernameAndEmailResult =
        adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
            entity, adminInstance, false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getEmail();
    verify(adminInstance).getLogin();
    verify(adminSecurityService).readAdminUserByUserName(null);
    verify(adminSecurityService).readAdminUsersByEmail(null);
    verify(environment, atLeast(1))
        .getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"
  })
  public void testValidateLegalUsernameAndEmail_givenRuntimeException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getLogin()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(
                entity, adminInstance, false));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getLogin();
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
  }
}
