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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.extension.AdminSecurityCheckExtensionHandler;
import org.broadleafcommerce.openadmin.server.security.extension.AdminSecurityCheckExtensionManager;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityProvider;
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
  @InjectMocks
  private AdminSecurityServiceRemote adminSecurityServiceRemote;

  @Mock
  private AdminSecurityCheckExtensionManager adminSecurityCheckExtensionManager;

  @Mock
  private AdminSecurityService adminSecurityService;

  @Mock
  private RowLevelSecurityService rowLevelSecurityService;

  /**
   * Test {@link AdminSecurityServiceRemote#getAdminUser()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#getAdminUser()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.security.remote.AdminUser AdminSecurityServiceRemote.getAdminUser()"})
  public void testGetAdminUser() throws ServiceException {
    // Arrange, Act and Assert
    assertNull(adminSecurityServiceRemote.getAdminUser());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#getPersistentAdminUser()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#getPersistentAdminUser()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminUser AdminSecurityServiceRemote.getPersistentAdminUser()"})
  public void testGetPersistentAdminUser() {
    // Arrange, Act and Assert
    assertNull(adminSecurityServiceRemote.getPersistentAdminUser());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code ceilingEntityFullyQualifiedName}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(adminSecurityService).isUserQualifiedForOperationOnCeilingEntity(isNull(), isA(PermissionType.class),
        eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code ceilingEntityFullyQualifiedName}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType2() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(adminSecurityService).doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Dr Jane Doe"));
    verify(adminSecurityService).isUserQualifiedForOperationOnCeilingEntity(isNull(), isA(PermissionType.class),
        eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code ceilingEntityFullyQualifiedName}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType3() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(adminSecurityService).doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Dr Jane Doe"));
    verify(adminSecurityService).isUserQualifiedForOperationOnCeilingEntity(isNull(), isA(PermissionType.class),
        eq("Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code ceilingEntityFullyQualifiedName}, {@code operationType}.
   * <ul>
   *   <li>When {@code ADD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenAdd() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.ADD);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code ceilingEntityFullyQualifiedName}, {@code operationType}.
   * <ul>
   *   <li>When {@code FETCH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenFetch() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code ceilingEntityFullyQualifiedName}, {@code operationType}.
   * <ul>
   *   <li>When {@code INSPECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenInspect() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.INSPECT);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code ceilingEntityFullyQualifiedName}, {@code operationType}.
   * <ul>
   *   <li>When {@code REMOVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenRemove() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.REMOVE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)} with {@code ceilingEntityFullyQualifiedName}, {@code operationType}.
   * <ul>
   *   <li>When {@code UPDATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String, EntityOperationType)"})
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType_whenUpdate() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck("Dr Jane Doe", EntityOperationType.UPDATE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(new String[]{"Ceiling Names"}, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType2() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    adminSecurityServiceRemote.securityCheck(new String[]{"Ceiling Names"}, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(adminSecurityService).isUserQualifiedForOperationOnCeilingEntity(isNull(), isA(PermissionType.class),
        eq("Ceiling Names"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType3() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck(new String[]{"Ceiling Names"}, EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(adminSecurityService).doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Ceiling Names"));
    verify(adminSecurityService).isUserQualifiedForOperationOnCeilingEntity(isNull(), isA(PermissionType.class),
        eq("Ceiling Names"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType4() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck(new String[]{"Ceiling Names"}, EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(adminSecurityService).doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Ceiling Names"));
    verify(adminSecurityService).isUserQualifiedForOperationOnCeilingEntity(isNull(), isA(PermissionType.class),
        eq("Ceiling Names"));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType5() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.doesOperationExistForCeilingEntity(Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck(new String[]{"Ceiling Names", ")"}, EntityOperationType.FETCH));
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(adminSecurityService).doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Ceiling Names"));
    verify(adminSecurityService, atLeast(1)).isUserQualifiedForOperationOnCeilingEntity(isNull(),
        isA(PermissionType.class), Mockito.<String>any());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <ul>
   *   <li>When {@code ADD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType_whenAdd() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(new String[]{"Ceiling Names"}, EntityOperationType.ADD);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType_whenEmptyArrayOfString() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck(new String[]{}, EntityOperationType.FETCH));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <ul>
   *   <li>When {@code INSPECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType_whenInspect() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(new String[]{"Ceiling Names"}, EntityOperationType.INSPECT);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType_whenNull() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(SecurityServiceException.class,
        () -> adminSecurityServiceRemote.securityCheck((String[]) null, EntityOperationType.FETCH));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <ul>
   *   <li>When {@code REMOVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType_whenRemove() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(new String[]{"Ceiling Names"}, EntityOperationType.REMOVE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)} with {@code ceilingNames}, {@code operationType}.
   * <ul>
   *   <li>When {@code UPDATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(String[], EntityOperationType)"})
  public void testSecurityCheckWithCeilingNamesOperationType_whenUpdate() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(new String[]{"Ceiling Names"}, EntityOperationType.UPDATE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);
    when(adminSecurityService.isUserQualifiedForOperationOnCeilingEntity(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    adminSecurityServiceRemote.securityCheck(new PersistencePackage(), EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(adminSecurityService).isUserQualifiedForOperationOnCeilingEntity(isNull(), isA(PermissionType.class),
        isNull());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType2() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspectiveItems()).thenReturn(new HashMap<>());
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb, sectionCrumb2});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType3() throws ServiceException {
    // Arrange
    when(rowLevelSecurityService.validateAddRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(false));

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspectiveItems()).thenReturn(new HashMap<>());
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});

    // Act and Assert
    assertThrows(ValidationException.class,
        () -> adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.ADD));
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(rowLevelSecurityService).validateAddRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType4() throws ServiceException {
    // Arrange
    when(rowLevelSecurityService.validateAddRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(true));
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[]{new Property()});
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.ADD);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(rowLevelSecurityService).validateAddRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType5() throws ServiceException {
    // Arrange
    when(rowLevelSecurityService.validateAddRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(true));
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.ADD);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(rowLevelSecurityService).validateAddRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType6() throws ServiceException {
    // Arrange
    when(rowLevelSecurityService.validateAddRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(true));
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(null);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.ADD);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(rowLevelSecurityService).validateAddRequest(isNull(), isNull(), isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType7() throws ServiceException {
    // Arrange
    when(rowLevelSecurityService.validateUpdateRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(true));
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getProperties()).thenReturn(new Property[]{new Property()});
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.UPDATE);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage, atLeast(1)).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage).getProperties();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(rowLevelSecurityService).validateUpdateRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@code FETCH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType_givenHashMap_whenFetch() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspectiveItems()).thenReturn(new HashMap<>());
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <ul>
   *   <li>Then calls {@link RowLevelSecurityProvider#validateAddRequest(AdminUser, Entity, PersistencePackage)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType_thenCallsValidateAddRequest()
      throws ServiceException {
    // Arrange
    when(rowLevelSecurityService.validateAddRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(true));
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspectiveItems()).thenReturn(new HashMap<>());
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});

    // Act
    adminSecurityServiceRemote.securityCheck(persistencePackage, EntityOperationType.ADD);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspectiveItems();
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
    verify(rowLevelSecurityService).validateAddRequest(isNull(), isA(Entity.class), isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)} with {@code persistencePackage}, {@code operationType}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceRemote.securityCheck(PersistencePackage, EntityOperationType)"})
  public void testSecurityCheckWithPersistencePackageOperationType_whenPersistencePackage() throws ServiceException {
    // Arrange
    AdminSecurityCheckExtensionHandler adminSecurityCheckExtensionHandler = mock(
        AdminSecurityCheckExtensionHandler.class);
    when(adminSecurityCheckExtensionHandler.handleAdminSecurityCheck(Mockito.<AdminUser>any(),
        Mockito.<PermissionType>any(), Mockito.<List<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminSecurityCheckExtensionManager.getProxy()).thenReturn(adminSecurityCheckExtensionHandler);

    // Act
    adminSecurityServiceRemote.securityCheck(new PersistencePackage(), EntityOperationType.FETCH);

    // Assert
    verify(adminSecurityCheckExtensionManager).getProxy();
    verify(adminSecurityCheckExtensionHandler).handleAdminSecurityCheck(isNull(), isA(PermissionType.class),
        isA(List.class));
  }
}
