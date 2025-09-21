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
package org.broadleafcommerce.openadmin.server.security.remote;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.extension.AdminSecurityCheckExtensionHandler;
import org.broadleafcommerce.openadmin.server.security.extension.AdminSecurityCheckExtensionManager;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.GlobalValidationResult;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminSecurityServiceRemoteDiffblueTest {
  @Mock private AdminSecurityCheckExtensionManager adminSecurityCheckExtensionManager;

  @Mock private AdminSecurityService adminSecurityService;

  @InjectMocks private AdminSecurityServiceRemote adminSecurityServiceRemote;

  @Mock private RowLevelSecurityService rowLevelSecurityService;

  /**
   * Test {@link AdminSecurityServiceRemote#getAdminUser()}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#getAdminUser()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.security.remote.AdminUser AdminSecurityServiceRemote.getAdminUser()"
  })
  public void testGetAdminUser() throws ServiceException {
    // Arrange, Act and Assert
    assertNull(adminSecurityServiceRemote.getAdminUser());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#getPersistentAdminUser()}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#getPersistentAdminUser()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminUser AdminSecurityServiceRemote.getPersistentAdminUser()"})
  public void testGetPersistentAdminUser() {
    // Arrange, Act and Assert
    assertNull(adminSecurityServiceRemote.getPersistentAdminUser());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code
   * ceilingEntityFullyQualifiedName}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code
   * ceilingEntityFullyQualifiedName}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType2()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(
            Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Dr Jane Doe"));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code
   * ceilingEntityFullyQualifiedName}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType3()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(
            Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Dr Jane Doe"));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code
   * ceilingEntityFullyQualifiedName}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenAdd()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.ADD);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code
   * ceilingEntityFullyQualifiedName}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code FETCH}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenFetch()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code
   * ceilingEntityFullyQualifiedName}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code INSPECT}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenInspect()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.INSPECT);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code
   * ceilingEntityFullyQualifiedName}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code REMOVE}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenRemove()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.REMOVE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code
   * ceilingEntityFullyQualifiedName}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code UPDATE}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenUpdate()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.UPDATE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(
        new String[] {"Ceiling Names"}, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType2() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    adminSecurityServiceRemote.securityCheck(
        new String[] {"Ceiling Names"}, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Ceiling Names"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType3() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(
            Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () ->
            adminSecurityServiceRemote.securityCheck(
                new String[] {"Ceiling Names"}, EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Ceiling Names"));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Ceiling Names"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType4() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(
            Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () ->
            adminSecurityServiceRemote.securityCheck(
                new String[] {"Ceiling Names", ")"}, EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Ceiling Names"));
    verify(adminSecurityService, atLeast(1))
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), Mockito.<String>any());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType5() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(
            Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () ->
            adminSecurityServiceRemote.securityCheck(
                new String[] {"Ceiling Names"}, EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Ceiling Names"));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Ceiling Names"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType_whenAdd() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(
        new String[] {"Ceiling Names"}, EntityOperationType.ADD);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType_whenEmptyArrayOfString()
      throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck(new String[] {}, EntityOperationType.FETCH));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code INSPECT}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType_whenInspect() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(
        new String[] {"Ceiling Names"}, EntityOperationType.INSPECT);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType_whenNull() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck((String[]) null, EntityOperationType.FETCH));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code REMOVE}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType_whenRemove() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(
        new String[] {"Ceiling Names"}, EntityOperationType.REMOVE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with
   * {@code ceilingNames}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code UPDATE}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[],
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"
  })
  public void testSecurityCheckWithCeilingNamesOperationType_whenUpdate() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(
        new String[] {"Ceiling Names"}, EntityOperationType.UPDATE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", null, persistencePerspective, customCriteria, "ABC123");

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType2() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSecurityCeilingEntityFullyQualifiedClassname("Dr Jane Doe");

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType3() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSectionCrumbs(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType4() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(
            Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(null);
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () ->
            adminSecurityServiceRemote.securityCheck(
                persistencePackage, EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Dr Jane Doe"));
    verify(adminSecurityService, atLeast(1))
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), Mockito.<String>any());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType5() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {new Property()});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType6() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties())
        .thenReturn(new Property[] {new Property("Name", "42")});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType7() throws ServiceException {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            adminSecurityServiceRemote.securityCheck(
                persistencePackage, EntityOperationType.FETCH));
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType8() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType9() throws ServiceException {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier(".id");
    sectionCrumb2.setSectionId(".id");
    sectionCrumb2.setSectionIdentifier(".id");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs())
        .thenReturn(new SectionCrumb[] {sectionCrumb, sectionCrumb2});

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            adminSecurityServiceRemote.securityCheck(
                persistencePackage, EntityOperationType.FETCH));
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType10() throws ServiceException {
    // Arrange
    when(rowLevelSecurityService.validateAddRequest(
            Mockito.<AdminUser>any(), Mockito.<Entity>any(), Mockito.<PersistencePackage>any()))
        .thenReturn(new GlobalValidationResult(true));

    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.ADD);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
    verify(rowLevelSecurityService)
        .validateAddRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType11() throws ServiceException {
    // Arrange
    GlobalValidationResult globalValidationResult = mock(GlobalValidationResult.class);
    when(globalValidationResult.isValid()).thenReturn(false);
    when(globalValidationResult.getErrorMessage()).thenReturn(null);
    when(rowLevelSecurityService.validateAddRequest(
            Mockito.<AdminUser>any(), Mockito.<Entity>any(), Mockito.<PersistencePackage>any()))
        .thenReturn(globalValidationResult);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.ADD));
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
    verify(rowLevelSecurityService)
        .validateAddRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
    verify(globalValidationResult).getErrorMessage();
    verify(globalValidationResult).isValid();
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType12() throws ServiceException {
    // Arrange
    GlobalValidationResult globalValidationResult = mock(GlobalValidationResult.class);
    when(globalValidationResult.isValid()).thenReturn(false);
    when(globalValidationResult.getErrorMessage()).thenReturn("");
    when(rowLevelSecurityService.validateAddRequest(
            Mockito.<AdminUser>any(), Mockito.<Entity>any(), Mockito.<PersistencePackage>any()))
        .thenReturn(globalValidationResult);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.ADD));
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
    verify(rowLevelSecurityService)
        .validateAddRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
    verify(globalValidationResult).getErrorMessage();
    verify(globalValidationResult).isValid();
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType13() throws ServiceException {
    // Arrange
    when(rowLevelSecurityService.validateUpdateRequest(
            Mockito.<AdminUser>any(), Mockito.<Entity>any(), Mockito.<PersistencePackage>any()))
        .thenReturn(new GlobalValidationResult(true));

    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.UPDATE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
    verify(rowLevelSecurityService)
        .validateUpdateRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType14() throws ServiceException {
    // Arrange
    when(rowLevelSecurityService.validateRemoveRequest(
            Mockito.<AdminUser>any(), Mockito.<Entity>any(), Mockito.<PersistencePackage>any()))
        .thenReturn(new GlobalValidationResult(true));

    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.REMOVE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
    verify(rowLevelSecurityService)
        .validateRemoveRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType_givenNull()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(null);
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType_givenNull2()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(null);
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <ul>
   *   <li>Then calls {@link GlobalValidationResult#getErrorMessages()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType_thenCallsGetErrorMessages()
      throws ServiceException {
    // Arrange
    GlobalValidationResult globalValidationResult = mock(GlobalValidationResult.class);
    when(globalValidationResult.getErrorMessages()).thenReturn(new ArrayList<>());
    when(globalValidationResult.isValid()).thenReturn(false);
    when(globalValidationResult.getErrorMessage()).thenReturn("An error occurred");
    when(rowLevelSecurityService.validateAddRequest(
            Mockito.<AdminUser>any(), Mockito.<Entity>any(), Mockito.<PersistencePackage>any()))
        .thenReturn(globalValidationResult);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.ADD));
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
    verify(rowLevelSecurityService)
        .validateAddRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
    verify(globalValidationResult).getErrorMessage();
    verify(globalValidationResult).getErrorMessages();
    verify(globalValidationResult).isValid();
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@code INSPECT}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType_whenInspect()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    when(property.getName()).thenReturn(".id");

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[] {property});
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname())
        .thenReturn("Dr Jane Doe");
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.INSPECT);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(property, atLeast(1)).getName();
    verify(property).getValue();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
    verify(adminSecurityService)
        .isUserQualifiedForOperationOnCeilingEntity(
            isNull(), isA(PermissionType.class), eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage,
   * EntityOperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"
  })
  public void testSecurityCheckWithPersistencePackageOperationType_whenPersistencePackage()
      throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler =
        mock(AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(
            Mockito.<AdminUser>any(), Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy())
        .thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(new PersistencePackage(), EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler)
        .handleAdminSecurityCheck(isNull(), isA(PermissionType.class), isA(List.class));
  }
}
